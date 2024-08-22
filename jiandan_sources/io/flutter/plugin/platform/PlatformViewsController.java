package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.common.others.lang.StringUtil;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import th.qw.ad.ad.ad;
import th.qw.ad.ad.de;
import th.qw.ad.ad.qw;

public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    public static final String TAG = "PlatformViewsController";
    public final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    public AndroidTouchProcessor androidTouchProcessor;
    public final PlatformViewsChannel.PlatformViewsHandler channelHandler = new PlatformViewsChannel.PlatformViewsHandler() {
        private void ensureValidAndroidVersion(int i2) {
            if (Build.VERSION.SDK_INT < i2) {
                throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + i2);
            }
        }

        public void clearFocus(int i2) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i2);
            if (platformView != null) {
                platformView.getView().clearFocus();
                return;
            }
            ensureValidAndroidVersion(20);
            PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2)).getView().clearFocus();
        }

        public void createAndroidViewForPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(19);
            if (PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                PlatformViewFactory factory = PlatformViewsController.this.registry.getFactory(platformViewCreationRequest.viewType);
                if (factory != null) {
                    Object obj = null;
                    if (platformViewCreationRequest.params != null) {
                        obj = factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
                    }
                    PlatformViewsController.this.platformViews.put(platformViewCreationRequest.viewId, factory.create(PlatformViewsController.this.context, platformViewCreationRequest.viewId, obj));
                    return;
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            }
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
        }

        @TargetApi(17)
        public long createVirtualDisplayForPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(20);
            if (!PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
            } else if (!PlatformViewsController.this.vdControllers.containsKey(Integer.valueOf(platformViewCreationRequest.viewId))) {
                PlatformViewFactory factory = PlatformViewsController.this.registry.getFactory(platformViewCreationRequest.viewType);
                if (factory != null) {
                    Object obj = null;
                    if (platformViewCreationRequest.params != null) {
                        obj = factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
                    }
                    Object obj2 = obj;
                    int access$500 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalWidth);
                    int access$5002 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalHeight);
                    PlatformViewsController.this.validateVirtualDisplayDimensions(access$500, access$5002);
                    TextureRegistry.SurfaceTextureEntry createSurfaceTexture = PlatformViewsController.this.textureRegistry.createSurfaceTexture();
                    VirtualDisplayController create = VirtualDisplayController.create(PlatformViewsController.this.context, PlatformViewsController.this.accessibilityEventsDelegate, factory, createSurfaceTexture, access$500, access$5002, platformViewCreationRequest.viewId, obj2, new qw(this, platformViewCreationRequest));
                    if (create != null) {
                        if (PlatformViewsController.this.flutterView != null) {
                            create.onFlutterViewAttached(PlatformViewsController.this.flutterView);
                        }
                        PlatformViewsController.this.vdControllers.put(Integer.valueOf(platformViewCreationRequest.viewId), create);
                        View view = create.getView();
                        view.setLayoutDirection(platformViewCreationRequest.direction);
                        PlatformViewsController.this.contextToPlatformView.put(view.getContext(), view);
                        return createSurfaceTexture.id();
                    }
                    throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            } else {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + platformViewCreationRequest.viewId);
            }
        }

        public void disposeAndroidViewForPlatformView(int i2) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i2);
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(i2);
            if (platformView != null) {
                if (flutterMutatorView != null) {
                    flutterMutatorView.removeView(platformView.getView());
                }
                PlatformViewsController.this.platformViews.remove(i2);
                platformView.dispose();
            }
            if (flutterMutatorView != null) {
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ((ViewGroup) flutterMutatorView.getParent()).removeView(flutterMutatorView);
                PlatformViewsController.this.platformViewParent.remove(i2);
            }
        }

        public void disposeVirtualDisplayForPlatformView(int i2) {
            ensureValidAndroidVersion(20);
            VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2));
            if (virtualDisplayController != null) {
                if (PlatformViewsController.this.textInputPlugin != null) {
                    PlatformViewsController.this.textInputPlugin.clearPlatformViewClient(i2);
                }
                PlatformViewsController.this.contextToPlatformView.remove(virtualDisplayController.getView().getContext());
                virtualDisplayController.dispose();
                PlatformViewsController.this.vdControllers.remove(Integer.valueOf(i2));
                return;
            }
            throw new IllegalStateException("Trying to dispose a platform view with unknown id: " + i2);
        }

        public void onTouch(@NonNull PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            int i2 = platformViewTouch.viewId;
            float f = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            ensureValidAndroidVersion(20);
            if (PlatformViewsController.this.vdControllers.containsKey(Integer.valueOf(i2))) {
                PlatformViewsController.this.vdControllers.get(Integer.valueOf(platformViewTouch.viewId)).dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f, platformViewTouch, true));
            } else if (PlatformViewsController.this.platformViews.get(i2) != null) {
                MotionEvent motionEvent = PlatformViewsController.this.toMotionEvent(f, platformViewTouch, false);
                View view = ((PlatformView) PlatformViewsController.this.platformViews.get(platformViewTouch.viewId)).getView();
                if (view != null) {
                    view.dispatchTouchEvent(motionEvent);
                }
            } else {
                throw new IllegalStateException("Sending touch to an unknown view with id: " + i2);
            }
        }

        public /* synthetic */ void qw(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
            if (z) {
                PlatformViewsController.this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            }
        }

        public void resizePlatformView(@NonNull PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, @NonNull final Runnable runnable) {
            ensureValidAndroidVersion(20);
            final VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(platformViewResizeRequest.viewId));
            if (virtualDisplayController != null) {
                int access$500 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
                int access$5002 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
                PlatformViewsController.this.validateVirtualDisplayDimensions(access$500, access$5002);
                PlatformViewsController.this.lockInputConnection(virtualDisplayController);
                virtualDisplayController.resize(access$500, access$5002, new Runnable() {
                    public void run() {
                        PlatformViewsController.this.unlockInputConnection(virtualDisplayController);
                        runnable.run();
                    }
                });
                return;
            }
            throw new IllegalStateException("Trying to resize a platform view with unknown id: " + platformViewResizeRequest.viewId);
        }

        @TargetApi(17)
        public void setDirection(int i2, int i3) {
            if (PlatformViewsController.validateDirection(i3)) {
                ensureValidAndroidVersion(20);
                View view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2)).getView();
                if (view != null) {
                    view.setLayoutDirection(i3);
                    return;
                }
                throw new IllegalStateException("Sending touch to an unknown view with id: " + i3);
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + i3 + "(view id: " + i2 + ")");
        }

        public void synchronizeToNativeViewHierarchy(boolean z) {
            boolean unused = PlatformViewsController.this.synchronizeToNativeViewHierarchy = z;
        }
    };
    public Context context;
    @VisibleForTesting
    public final HashMap<Context, View> contextToPlatformView = new HashMap<>();
    public HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    public HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    public View flutterView;
    public boolean flutterViewConvertedToImageView = false;
    public final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();
    public int nextOverlayLayerId = 0;
    public final SparseArray<FlutterImageView> overlayLayerViews = new SparseArray<>();
    public final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    public final SparseArray<PlatformView> platformViews = new SparseArray<>();
    public PlatformViewsChannel platformViewsChannel;
    public final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
    public boolean synchronizeToNativeViewHierarchy = true;
    @Nullable
    public TextInputPlugin textInputPlugin;
    @Nullable
    public TextureRegistry textureRegistry;
    @VisibleForTesting
    public final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap<>();

    private void finishFrame(boolean z) {
        for (int i2 = 0; i2 < this.overlayLayerViews.size(); i2++) {
            int keyAt = this.overlayLayerViews.keyAt(i2);
            FlutterImageView valueAt = this.overlayLayerViews.valueAt(i2);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(keyAt))) {
                ((FlutterView) this.flutterView).attachOverlaySurfaceToRender(valueAt);
                z &= valueAt.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i3 = 0; i3 < this.platformViewParent.size(); i3++) {
            int keyAt2 = this.platformViewParent.keyAt(i3);
            View view = this.platformViewParent.get(keyAt2);
            if (!this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(keyAt2)) || (!z && this.synchronizeToNativeViewHierarchy)) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    private void flushAllViews() {
        for (VirtualDisplayController dispose : this.vdControllers.values()) {
            dispose.dispose();
        }
        this.vdControllers.clear();
        while (this.platformViews.size() > 0) {
            this.channelHandler.disposeAndroidViewForPlatformView(this.platformViews.keyAt(0));
        }
        if (this.contextToPlatformView.size() > 0) {
            this.contextToPlatformView.clear();
        }
    }

    private float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    private void initializeRootImageViewIfNeeded() {
        if (this.synchronizeToNativeViewHierarchy && !this.flutterViewConvertedToImageView) {
            ((FlutterView) this.flutterView).convertToImageView();
            this.flutterViewConvertedToImageView = true;
        }
    }

    /* access modifiers changed from: private */
    public void lockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.lockPlatformViewInputConnection();
            virtualDisplayController.onInputConnectionLocked();
        }
    }

    public static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    public static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        for (Object parsePointerCoords : (List) obj) {
            arrayList.add(parsePointerCoords(parsePointerCoords, f));
        }
        return arrayList;
    }

    public static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    public static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object parsePointerProperties : (List) obj) {
            arrayList.add(parsePointerProperties(parsePointerProperties));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public int toPhysicalPixels(double d) {
        return (int) Math.round(d * ((double) getDisplayDensity()));
    }

    /* access modifiers changed from: private */
    public void unlockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.unlockPlatformViewInputConnection();
            virtualDisplayController.onInputConnectionUnlocked();
        }
    }

    public static boolean validateDirection(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* access modifiers changed from: private */
    public void validateVirtualDisplayDimensions(int i2, int i3) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        if (i3 > displayMetrics.heightPixels || i2 > displayMetrics.widthPixels) {
            Log.w("PlatformViewsController", "Creating a virtual display of size: [" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + displayMetrics.widthPixels + StringUtil.ARRAY_ELEMENT_SEPARATOR + displayMetrics.heightPixels + "].");
        }
    }

    public /* synthetic */ void ad() {
        finishFrame(false);
    }

    public void attach(Context context2, TextureRegistry textureRegistry2, @NonNull DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context2;
            this.textureRegistry = textureRegistry2;
            PlatformViewsChannel platformViewsChannel2 = new PlatformViewsChannel(dartExecutor);
            this.platformViewsChannel = platformViewsChannel2;
            platformViewsChannel2.setPlatformViewsHandler(this.channelHandler);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin2) {
        this.textInputPlugin = textInputPlugin2;
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void attachToView(@NonNull View view) {
        this.flutterView = view;
        for (VirtualDisplayController onFlutterViewAttached : this.vdControllers.values()) {
            onFlutterViewAttached.onFlutterViewAttached(view);
        }
    }

    public boolean checkInputConnectionProxy(@Nullable View view) {
        if (view == null || !this.contextToPlatformView.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.contextToPlatformView.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    @VisibleForTesting
    @TargetApi(19)
    public FlutterOverlaySurface createOverlaySurface(@NonNull FlutterImageView flutterImageView) {
        int i2 = this.nextOverlayLayerId;
        this.nextOverlayLayerId = i2 + 1;
        this.overlayLayerViews.put(i2, flutterImageView);
        return new FlutterOverlaySurface(i2, flutterImageView.getSurface());
    }

    public void destroyOverlaySurfaces() {
        for (int i2 = 0; i2 < this.overlayLayerViews.size(); i2++) {
            this.overlayLayerViews.keyAt(i2);
            FlutterImageView valueAt = this.overlayLayerViews.valueAt(i2);
            valueAt.detachFromRenderer();
            View view = this.flutterView;
            if (view != null) {
                ((FlutterView) view).removeView(valueAt);
            }
        }
        this.overlayLayerViews.clear();
    }

    @UiThread
    public void detach() {
        PlatformViewsChannel platformViewsChannel2 = this.platformViewsChannel;
        if (platformViewsChannel2 != null) {
            platformViewsChannel2.setPlatformViewsHandler((PlatformViewsChannel.PlatformViewsHandler) null);
        }
        destroyOverlaySurfaces();
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    public void detachAccessibiltyBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge((AccessibilityBridge) null);
    }

    public void detachFromView() {
        destroyOverlaySurfaces();
        this.flutterView = null;
        this.flutterViewConvertedToImageView = false;
        for (VirtualDisplayController onFlutterViewDetached : this.vdControllers.values()) {
            onFlutterViewDetached.onFlutterViewDetached();
        }
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    public View getPlatformViewById(Integer num) {
        if (this.platformViews.get(num.intValue()) != null) {
            return this.platformViews.get(num.intValue()).getView();
        }
        VirtualDisplayController virtualDisplayController = this.vdControllers.get(num);
        if (virtualDisplayController == null) {
            return null;
        }
        return virtualDisplayController.getView();
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    @VisibleForTesting
    public void initializePlatformViewIfNeeded(int i2) {
        PlatformView platformView = this.platformViews.get(i2);
        if (platformView == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        } else if (this.platformViewParent.get(i2) == null) {
            if (platformView.getView() == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            } else if (platformView.getView().getParent() == null) {
                Context context2 = this.context;
                FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context2, context2.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                flutterMutatorView.setOnDescendantFocusChangeListener(new de(this, i2));
                this.platformViewParent.put(i2, flutterMutatorView);
                flutterMutatorView.addView(platformView.getView());
                ((FlutterView) this.flutterView).addView(flutterMutatorView);
            } else {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    public void onAttachedToJNI() {
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
    }

    public void onDetachedFromJNI() {
        flushAllViews();
    }

    public void onDisplayOverlaySurface(int i2, int i3, int i4, int i5, int i6) {
        if (this.overlayLayerViews.get(i2) != null) {
            initializeRootImageViewIfNeeded();
            FlutterImageView flutterImageView = this.overlayLayerViews.get(i2);
            if (flutterImageView.getParent() == null) {
                ((FlutterView) this.flutterView).addView(flutterImageView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
            layoutParams.leftMargin = i3;
            layoutParams.topMargin = i4;
            flutterImageView.setLayoutParams(layoutParams);
            flutterImageView.setVisibility(0);
            flutterImageView.bringToFront();
            this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i2));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i2 + ") doesn't exist");
    }

    public void onDisplayPlatformView(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        initializeRootImageViewIfNeeded();
        initializePlatformViewIfNeeded(i2);
        FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i2);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i3, i4, i5, i6);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
        View view = this.platformViews.get(i2).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i2));
    }

    public void onEndFrame() {
        FlutterView flutterView2 = (FlutterView) this.flutterView;
        boolean z = false;
        if (!this.flutterViewConvertedToImageView || !this.currentFrameUsedPlatformViewIds.isEmpty()) {
            if (this.flutterViewConvertedToImageView && flutterView2.acquireLatestImageViewFrame()) {
                z = true;
            }
            finishFrame(z);
            return;
        }
        this.flutterViewConvertedToImageView = false;
        flutterView2.revertImageView(new ad(this));
    }

    public void onPreEngineRestart() {
        flushAllViews();
    }

    public /* synthetic */ void qw(int i2, View view, boolean z) {
        if (z) {
            this.platformViewsChannel.invokeViewFocused(i2);
            return;
        }
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.clearPlatformViewClient(i2);
        }
    }

    @VisibleForTesting
    public MotionEvent toMotionEvent(float f, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z) {
        PlatformViewsChannel.PlatformViewTouch platformViewTouch2 = platformViewTouch;
        MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch2.motionEventId));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch2.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch2.pointerCount]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch2.rawPointerCoords, f).toArray(new MotionEvent.PointerCoords[platformViewTouch2.pointerCount]);
        if (!z && pop != null) {
            return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), pop.getAction(), platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
        }
        return MotionEvent.obtain(platformViewTouch2.downTime.longValue(), platformViewTouch2.eventTime.longValue(), platformViewTouch2.action, platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch2.metaState, platformViewTouch2.buttonState, platformViewTouch2.xPrecision, platformViewTouch2.yPrecision, platformViewTouch2.deviceId, platformViewTouch2.edgeFlags, platformViewTouch2.source, platformViewTouch2.flags);
    }

    public boolean usesVirtualDisplay(Integer num) {
        return this.vdControllers.containsKey(num);
    }

    @TargetApi(19)
    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new FlutterImageView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), FlutterImageView.SurfaceKind.overlay));
    }
}
