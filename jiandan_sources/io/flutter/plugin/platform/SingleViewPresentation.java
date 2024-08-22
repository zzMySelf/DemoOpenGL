package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@TargetApi(17)
@Keep
public class SingleViewPresentation extends Presentation {
    public final AccessibilityEventsDelegate accessibilityEventsDelegate;
    public FrameLayout container;
    public Object createParams;
    public final View.OnFocusChangeListener focusChangeListener;
    public final Context outerContext;
    public AccessibilityDelegatingFrameLayout rootView;
    public boolean startFocused = false;
    public PresentationState state;
    public final PlatformViewFactory viewFactory;
    public int viewId;

    public static class AccessibilityDelegatingFrameLayout extends FrameLayout {
        public final AccessibilityEventsDelegate accessibilityEventsDelegate;
        public final View embeddedView;

        public AccessibilityDelegatingFrameLayout(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate2, View view) {
            super(context);
            this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
            this.embeddedView = view;
        }

        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, view, accessibilityEvent);
        }
    }

    public static class FakeWindowViewGroup extends ViewGroup {
        public final Rect childRect = new Rect();
        public final Rect viewBounds = new Rect();

        public FakeWindowViewGroup(Context context) {
            super(context);
        }

        public static int atMost(int i2) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE);
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.viewBounds.set(i2, i3, i4, i5);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.viewBounds, layoutParams.x, layoutParams.y, this.childRect);
                Rect rect = this.childRect;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        public void onMeasure(int i2, int i3) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                getChildAt(i4).measure(atMost(i2), atMost(i3));
            }
            super.onMeasure(i2, i3);
        }
    }

    public static class ImmContext extends ContextWrapper {
        @NonNull
        public final InputMethodManager inputMethodManager;

        public ImmContext(Context context) {
            this(context, (InputMethodManager) null);
        }

        public Context createDisplayContext(Display display) {
            return new ImmContext(super.createDisplayContext(display), this.inputMethodManager);
        }

        public Object getSystemService(String str) {
            if ("input_method".equals(str)) {
                return this.inputMethodManager;
            }
            return super.getSystemService(str);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.view.inputmethod.InputMethodManager} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ImmContext(android.content.Context r1, @androidx.annotation.Nullable android.view.inputmethod.InputMethodManager r2) {
            /*
                r0 = this;
                r0.<init>(r1)
                if (r2 == 0) goto L_0x0006
                goto L_0x000f
            L_0x0006:
                java.lang.String r2 = "input_method"
                java.lang.Object r1 = r1.getSystemService(r2)
                r2 = r1
                android.view.inputmethod.InputMethodManager r2 = (android.view.inputmethod.InputMethodManager) r2
            L_0x000f:
                r0.inputMethodManager = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.SingleViewPresentation.ImmContext.<init>(android.content.Context, android.view.inputmethod.InputMethodManager):void");
        }
    }

    public static class PresentationContext extends ContextWrapper {
        public final Context flutterAppWindowContext;
        @Nullable
        public WindowManager windowManager;
        @NonNull
        public final WindowManagerHandler windowManagerHandler;

        public PresentationContext(Context context, @NonNull WindowManagerHandler windowManagerHandler2, Context context2) {
            super(context);
            this.windowManagerHandler = windowManagerHandler2;
            this.flutterAppWindowContext = context2;
        }

        private WindowManager getWindowManager() {
            if (this.windowManager == null) {
                this.windowManager = this.windowManagerHandler.getWindowManager();
            }
            return this.windowManager;
        }

        private boolean isCalledFromAlertDialog() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i2 = 0;
            while (i2 < stackTrace.length && i2 < 11) {
                if (stackTrace[i2].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i2].getMethodName().equals("<init>")) {
                    return true;
                }
                i2++;
            }
            return false;
        }

        public Object getSystemService(String str) {
            if (!"window".equals(str)) {
                return super.getSystemService(str);
            }
            if (isCalledFromAlertDialog()) {
                return this.flutterAppWindowContext.getSystemService(str);
            }
            return getWindowManager();
        }
    }

    public static class PresentationState {
        public FakeWindowViewGroup fakeWindowViewGroup;
        public PlatformView platformView;
        public WindowManagerHandler windowManagerHandler;
    }

    public static class WindowManagerHandler implements InvocationHandler {
        public static final String TAG = "PlatformViewsController";
        public final WindowManager delegate;
        public FakeWindowViewGroup fakeWindowRootView;

        public WindowManagerHandler(WindowManager windowManager, FakeWindowViewGroup fakeWindowViewGroup) {
            this.delegate = windowManager;
            this.fakeWindowRootView = fakeWindowViewGroup;
        }

        private void addView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
            } else {
                fakeWindowViewGroup.addView(objArr[0], objArr[1]);
            }
        }

        private void removeView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
            } else {
                fakeWindowViewGroup.removeView(objArr[0]);
            }
        }

        private void removeViewImmediate(Object[] objArr) {
            if (this.fakeWindowRootView == null) {
                Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = objArr[0];
            view.clearAnimation();
            this.fakeWindowRootView.removeView(view);
        }

        private void updateViewLayout(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
            } else {
                fakeWindowViewGroup.updateViewLayout(objArr[0], objArr[1]);
            }
        }

        public WindowManager getWindowManager() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(java.lang.Object r5, java.lang.reflect.Method r6, java.lang.Object[] r7) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.String r5 = r6.getName()
                int r0 = r5.hashCode()
                r1 = 3
                r2 = 2
                r3 = 1
                switch(r0) {
                    case -1148522778: goto L_0x002d;
                    case 542766184: goto L_0x0023;
                    case 931413976: goto L_0x0019;
                    case 1098630473: goto L_0x000f;
                    default: goto L_0x000e;
                }
            L_0x000e:
                goto L_0x0037
            L_0x000f:
                java.lang.String r0 = "removeView"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0037
                r5 = 1
                goto L_0x0038
            L_0x0019:
                java.lang.String r0 = "updateViewLayout"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0037
                r5 = 3
                goto L_0x0038
            L_0x0023:
                java.lang.String r0 = "removeViewImmediate"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0037
                r5 = 2
                goto L_0x0038
            L_0x002d:
                java.lang.String r0 = "addView"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0037
                r5 = 0
                goto L_0x0038
            L_0x0037:
                r5 = -1
            L_0x0038:
                r0 = 0
                if (r5 == 0) goto L_0x005a
                if (r5 == r3) goto L_0x0056
                if (r5 == r2) goto L_0x0052
                if (r5 == r1) goto L_0x004e
                android.view.WindowManager r5 = r4.delegate     // Catch:{ InvocationTargetException -> 0x0048 }
                java.lang.Object r5 = r6.invoke(r5, r7)     // Catch:{ InvocationTargetException -> 0x0048 }
                return r5
            L_0x0048:
                r5 = move-exception
                java.lang.Throwable r5 = r5.getCause()
                throw r5
            L_0x004e:
                r4.updateViewLayout(r7)
                return r0
            L_0x0052:
                r4.removeViewImmediate(r7)
                return r0
            L_0x0056:
                r4.removeView(r7)
                return r0
            L_0x005a:
                r4.addView(r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.SingleViewPresentation.WindowManagerHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }

    public SingleViewPresentation(Context context, Display display, PlatformViewFactory platformViewFactory, AccessibilityEventsDelegate accessibilityEventsDelegate2, int i2, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        super(new ImmContext(context), display);
        this.viewFactory = platformViewFactory;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.viewId = i2;
        this.createParams = obj;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        this.state = new PresentationState();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public PresentationState detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public PlatformView getView() {
        if (this.state.platformView == null) {
            return null;
        }
        return this.state.platformView;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.fakeWindowViewGroup == null) {
            FakeWindowViewGroup unused = this.state.fakeWindowViewGroup = new FakeWindowViewGroup(getContext());
        }
        if (this.state.windowManagerHandler == null) {
            PresentationState presentationState = this.state;
            WindowManagerHandler unused2 = presentationState.windowManagerHandler = new WindowManagerHandler((WindowManager) getContext().getSystemService("window"), presentationState.fakeWindowViewGroup);
        }
        this.container = new FrameLayout(getContext());
        PresentationContext presentationContext = new PresentationContext(getContext(), this.state.windowManagerHandler, this.outerContext);
        if (this.state.platformView == null) {
            PlatformView unused3 = this.state.platformView = this.viewFactory.create(presentationContext, this.viewId, this.createParams);
        }
        View view = this.state.platformView.getView();
        this.container.addView(view);
        AccessibilityDelegatingFrameLayout accessibilityDelegatingFrameLayout = new AccessibilityDelegatingFrameLayout(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView = accessibilityDelegatingFrameLayout;
        accessibilityDelegatingFrameLayout.addView(this.container);
        this.rootView.addView(this.state.fakeWindowViewGroup);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public SingleViewPresentation(Context context, Display display, AccessibilityEventsDelegate accessibilityEventsDelegate2, PresentationState presentationState, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new ImmContext(context), display);
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.viewFactory = null;
        this.state = presentationState;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }
}
