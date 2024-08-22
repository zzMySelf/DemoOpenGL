package com.otaliastudios.cameraview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.dlife.ctaccountapi.x;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import com.otaliastudios.cameraview.frame.FrameProcessor;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;
import com.otaliastudios.cameraview.gesture.GestureFinder;
import com.otaliastudios.cameraview.internal.GridLinesLayout;
import com.otaliastudios.cameraview.internal.OrientationHelper;
import com.otaliastudios.cameraview.markers.AutoFocusMarker;
import com.otaliastudios.cameraview.markers.AutoFocusTrigger;
import com.otaliastudios.cameraview.markers.MarkerLayout;
import com.otaliastudios.cameraview.overlay.OverlayLayout;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.FilterCameraPreview;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.widget.RotateProgress;
import fe.vvv.qw.fe;
import fe.vvv.qw.rg;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CameraView extends FrameLayout implements LifecycleObserver {
    public static final long DEFAULT_AUTOFOCUS_RESET_DELAY_MILLIS = 3000;
    public static final int DEFAULT_FRAME_PROCESSING_EXECUTORS = 1;
    public static final int DEFAULT_FRAME_PROCESSING_POOL_SIZE = 2;
    public static final boolean DEFAULT_PICTURE_METERING = true;
    public static final boolean DEFAULT_PICTURE_SNAPSHOT_METERING = false;
    public static final boolean DEFAULT_PLAY_SOUNDS = true;
    public static final boolean DEFAULT_REQUEST_PERMISSIONS = true;
    public static final boolean DEFAULT_USE_DEVICE_ORIENTATION = true;
    public static final CameraLogger LOG;
    public static final int PERMISSION_REQUEST_CODE = 16;
    public static final String TAG;
    public AutoFocusMarker mAutoFocusMarker;
    @VisibleForTesting
    public uk mCameraCallbacks;
    public CameraEngine mCameraEngine;
    public CameraPreview mCameraPreview;
    public Engine mEngine;
    public boolean mExperimental;
    public Executor mFrameProcessingExecutor;
    public int mFrameProcessingExecutors;
    @VisibleForTesting
    public List<FrameProcessor> mFrameProcessors = new CopyOnWriteArrayList();
    public HashMap<Gesture, GestureAction> mGestureMap = new HashMap<>(4);
    @VisibleForTesting
    public GridLinesLayout mGridLinesLayout;
    public boolean mInEditor;
    public boolean mKeepScreenOn;
    public fe.vvv.qw.xxx.ad mLastPreviewStreamSize;
    public Lifecycle mLifecycle;
    @VisibleForTesting
    public List<fe.vvv.qw.qw> mListeners = new CopyOnWriteArrayList();
    @VisibleForTesting
    public MarkerLayout mMarkerLayout;
    public OrientationHelper mOrientationHelper;
    @VisibleForTesting
    public OverlayLayout mOverlayLayout;
    public Filter mPendingFilter;
    @VisibleForTesting
    public fe.vvv.qw.pf.ad mPinchGestureFinder;
    public boolean mPlaySounds;
    public Preview mPreview;
    public boolean mRequestPermissions;
    @VisibleForTesting
    public fe.vvv.qw.pf.de mScrollGestureFinder;
    public MediaActionSound mSound;
    @VisibleForTesting
    public fe.vvv.qw.pf.fe mTapGestureFinder;
    public Handler mUiHandler;
    public boolean mUseDeviceOrientation;

    public class ad extends fe.vvv.qw.qw {
        public final /* synthetic */ int qw;

        public ad(int i2) {
            this.qw = i2;
        }

        public void fe(@NonNull CameraException cameraException) {
            super.fe(cameraException);
            if (cameraException.getReason() == 5) {
                CameraView.this.setVideoMaxDuration(this.qw);
                CameraView.this.removeCameraListener(this);
            }
        }

        public void pf(@NonNull fe.vvv.qw.rg rgVar) {
            CameraView.this.setVideoMaxDuration(this.qw);
            CameraView.this.removeCameraListener(this);
        }
    }

    public class de implements Runnable {
        public de() {
        }

        public void run() {
            CameraView cameraView = CameraView.this;
            boolean unused = cameraView.mKeepScreenOn = cameraView.getKeepScreenOn();
            if (!CameraView.this.mKeepScreenOn) {
                CameraView.this.setKeepScreenOn(true);
            }
        }
    }

    public class fe extends fe.vvv.qw.qw {
        public final /* synthetic */ int qw;

        public fe(int i2) {
            this.qw = i2;
        }

        public void fe(@NonNull CameraException cameraException) {
            super.fe(cameraException);
            if (cameraException.getReason() == 5) {
                CameraView.this.setVideoMaxDuration(this.qw);
                CameraView.this.removeCameraListener(this);
            }
        }

        public void pf(@NonNull fe.vvv.qw.rg rgVar) {
            CameraView.this.setVideoMaxDuration(this.qw);
            CameraView.this.removeCameraListener(this);
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            CameraView cameraView = CameraView.this;
            boolean unused = cameraView.mKeepScreenOn = cameraView.getKeepScreenOn();
            if (!CameraView.this.mKeepScreenOn) {
                CameraView.this.setKeepScreenOn(true);
            }
        }
    }

    public class rg implements Runnable {
        public rg() {
        }

        public void run() {
            if (CameraView.this.getKeepScreenOn() != CameraView.this.mKeepScreenOn) {
                CameraView cameraView = CameraView.this;
                cameraView.setKeepScreenOn(cameraView.mKeepScreenOn);
            }
        }
    }

    public class th implements ThreadFactory {

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicInteger f6678ad = new AtomicInteger(1);

        public th() {
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "FrameExecutor #" + this.f6678ad.getAndIncrement());
        }
    }

    @VisibleForTesting
    public class uk implements CameraEngine.Callback, OrientationHelper.Callback, GestureFinder.Controller {

        /* renamed from: ad  reason: collision with root package name */
        public final CameraLogger f6680ad;
        public final String qw;

        public class ad implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ fe.vvv.qw.o.qw f6682ad;

            public ad(fe.vvv.qw.o.qw qwVar) {
                this.f6682ad = qwVar;
            }

            public void run() {
                uk.this.f6680ad.uk("dispatchFrame: executing. Passing", Long.valueOf(this.f6682ad.yj()), "to processors.");
                for (FrameProcessor process : CameraView.this.mFrameProcessors) {
                    try {
                        process.process(this.f6682ad);
                    } catch (Exception e) {
                        uk.this.f6680ad.i("Frame processor crashed:", e);
                    }
                }
                this.f6682ad.i();
            }
        }

        public class de implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ CameraException f6684ad;

            public de(CameraException cameraException) {
                this.f6684ad = cameraException;
            }

            public void run() {
                for (fe.vvv.qw.qw fe2 : CameraView.this.mListeners) {
                    fe2.fe(this.f6684ad);
                }
            }
        }

        public class fe implements Runnable {
            public fe() {
            }

            public void run() {
                for (fe.vvv.qw.qw o2 : CameraView.this.mListeners) {
                    o2.o();
                }
            }
        }

        public class i implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ fe.qw f6687ad;

            public i(fe.qw qwVar) {
                this.f6687ad = qwVar;
            }

            public void run() {
                fe.vvv.qw.fe feVar = new fe.vvv.qw.fe(this.f6687ad);
                for (fe.vvv.qw.qw uk2 : CameraView.this.mListeners) {
                    uk2.uk(feVar);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$uk$if  reason: invalid class name */
        public class Cif implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ boolean f6689ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ Gesture f6690th;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ PointF f6692yj;

            public Cif(boolean z, Gesture gesture, PointF pointF) {
                this.f6689ad = z;
                this.f6690th = gesture;
                this.f6692yj = pointF;
            }

            public void run() {
                if (this.f6689ad && CameraView.this.mPlaySounds) {
                    CameraView.this.playSound(1);
                }
                if (CameraView.this.mAutoFocusMarker != null) {
                    CameraView.this.mAutoFocusMarker.de(this.f6690th != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.f6689ad, this.f6692yj);
                }
                for (fe.vvv.qw.qw qw : CameraView.this.mListeners) {
                    qw.qw(this.f6689ad, this.f6692yj);
                }
            }
        }

        public class o implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ rg.qw f6693ad;

            public o(rg.qw qwVar) {
                this.f6693ad = qwVar;
            }

            public void run() {
                fe.vvv.qw.rg rgVar = new fe.vvv.qw.rg(this.f6693ad);
                for (fe.vvv.qw.qw pf2 : CameraView.this.mListeners) {
                    pf2.pf(rgVar);
                }
            }
        }

        public class pf implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ PointF f6695ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ Gesture f6696th;

            public pf(PointF pointF, Gesture gesture) {
                this.f6695ad = pointF;
                this.f6696th = gesture;
            }

            public void run() {
                CameraView.this.mMarkerLayout.onEvent(1, new PointF[]{this.f6695ad});
                if (CameraView.this.mAutoFocusMarker != null) {
                    CameraView.this.mAutoFocusMarker.qw(this.f6696th != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.f6695ad);
                }
                for (fe.vvv.qw.qw ad2 : CameraView.this.mListeners) {
                    ad2.ad(this.f6695ad);
                }
            }
        }

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ float f6698ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ float[] f6699th;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ PointF[] f6701yj;

            public qw(float f, float[] fArr, PointF[] pointFArr) {
                this.f6698ad = f;
                this.f6699th = fArr;
                this.f6701yj = pointFArr;
            }

            public void run() {
                for (fe.vvv.qw.qw th2 : CameraView.this.mListeners) {
                    th2.th(this.f6698ad, this.f6699th, this.f6701yj);
                }
            }
        }

        public class rg implements Runnable {
            public rg() {
            }

            public void run() {
                for (fe.vvv.qw.qw i2 : CameraView.this.mListeners) {
                    i2.i();
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$uk$switch  reason: invalid class name */
        public class Cswitch implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ int f6703ad;

            public Cswitch(int i2) {
                this.f6703ad = i2;
            }

            public void run() {
                for (fe.vvv.qw.qw yj2 : CameraView.this.mListeners) {
                    yj2.yj(this.f6703ad);
                }
            }
        }

        public class th implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ fe.vvv.qw.ad f6705ad;

            public th(fe.vvv.qw.ad adVar) {
                this.f6705ad = adVar;
            }

            public void run() {
                for (fe.vvv.qw.qw rg2 : CameraView.this.mListeners) {
                    rg2.rg(this.f6705ad);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$uk$uk  reason: collision with other inner class name */
        public class C0259uk implements Runnable {
            public C0259uk() {
            }

            public void run() {
                CameraView.this.requestLayout();
            }
        }

        public class when implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ float f6708ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ PointF[] f6709th;

            public when(float f, PointF[] pointFArr) {
                this.f6708ad = f;
                this.f6709th = pointFArr;
            }

            public void run() {
                for (fe.vvv.qw.qw qwVar : CameraView.this.mListeners) {
                    qwVar.m1039if(this.f6708ad, new float[]{0.0f, 1.0f}, this.f6709th);
                }
            }
        }

        public class yj implements Runnable {
            public yj() {
            }

            public void run() {
                for (fe.vvv.qw.qw de2 : CameraView.this.mListeners) {
                    de2.de();
                }
            }
        }

        public uk() {
            String simpleName = uk.class.getSimpleName();
            this.qw = simpleName;
            this.f6680ad = CameraLogger.qw(simpleName);
        }

        public void ad(@NonNull fe.vvv.qw.o.qw qwVar) {
            this.f6680ad.uk("dispatchFrame:", Long.valueOf(qwVar.yj()), "processors:", Integer.valueOf(CameraView.this.mFrameProcessors.size()));
            if (CameraView.this.mFrameProcessors.isEmpty()) {
                qwVar.i();
            } else {
                CameraView.this.mFrameProcessingExecutor.execute(new ad(qwVar));
            }
        }

        public void de(int i2, boolean z) {
            this.f6680ad.de("onDisplayOffsetChanged", Integer.valueOf(i2), "recreate:", Boolean.valueOf(z));
            if (CameraView.this.isOpened() && !z) {
                this.f6680ad.i("onDisplayOffsetChanged", "restarting the camera.");
                CameraView.this.close();
                CameraView.this.open();
            }
        }

        public void fe(boolean z) {
            if (z && CameraView.this.mPlaySounds) {
                CameraView.this.playSound(0);
            }
        }

        @NonNull
        public Context getContext() {
            return CameraView.this.getContext();
        }

        public int getHeight() {
            return CameraView.this.getHeight();
        }

        public int getWidth() {
            return CameraView.this.getWidth();
        }

        public void ggg(float f, @Nullable PointF[] pointFArr) {
            this.f6680ad.de("dispatchOnZoomChanged", Float.valueOf(f));
            CameraView.this.mUiHandler.post(new when(f, pointFArr));
        }

        public void i() {
            this.f6680ad.de("dispatchOnVideoRecordingStart");
            CameraView.this.mUiHandler.post(new fe());
        }

        /* renamed from: if  reason: not valid java name */
        public void m710if(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
            this.f6680ad.de("dispatchOnExposureCorrectionChanged", Float.valueOf(f));
            CameraView.this.mUiHandler.post(new qw(f, fArr, pointFArr));
        }

        public void o(@NonNull fe.qw qwVar) {
            this.f6680ad.de("dispatchOnPictureTaken", qwVar);
            CameraView.this.mUiHandler.post(new i(qwVar));
        }

        public void pf(@Nullable Gesture gesture, @NonNull PointF pointF) {
            this.f6680ad.de("dispatchOnFocusStart", gesture, pointF);
            CameraView.this.mUiHandler.post(new pf(pointF, gesture));
        }

        public void ppp() {
            fe.vvv.qw.xxx.ad y = CameraView.this.mCameraEngine.y(Reference.VIEW);
            if (y == null) {
                throw new RuntimeException("Preview stream size should not be null here.");
            } else if (y.equals(CameraView.this.mLastPreviewStreamSize)) {
                this.f6680ad.de("onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", y);
            } else {
                this.f6680ad.de("onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", y);
                CameraView.this.mUiHandler.post(new C0259uk());
            }
        }

        public void qw(@NonNull rg.qw qwVar) {
            this.f6680ad.de("dispatchOnVideoTaken", qwVar);
            CameraView.this.mUiHandler.post(new o(qwVar));
        }

        public void rg(@NonNull fe.vvv.qw.ad adVar) {
            this.f6680ad.de("dispatchOnCameraOpened", adVar);
            CameraView.this.mUiHandler.post(new th(adVar));
        }

        /* renamed from: switch  reason: not valid java name */
        public void m711switch(CameraException cameraException) {
            this.f6680ad.de("dispatchError", cameraException);
            CameraView.this.mUiHandler.post(new de(cameraException));
        }

        public void th() {
            this.f6680ad.de("dispatchOnVideoRecordingEnd");
            CameraView.this.mUiHandler.post(new rg());
        }

        public void uk(@Nullable Gesture gesture, boolean z, @NonNull PointF pointF) {
            this.f6680ad.de("dispatchOnFocusEnd", gesture, Boolean.valueOf(z), pointF);
            CameraView.this.mUiHandler.post(new Cif(z, gesture, pointF));
        }

        public void when(int i2) {
            this.f6680ad.de("onDeviceOrientationChanged", Integer.valueOf(i2));
            int o2 = CameraView.this.mOrientationHelper.o();
            if (!CameraView.this.mUseDeviceOrientation) {
                CameraView.this.mCameraEngine.qqq().yj((360 - o2) % RotateProgress.FULL_DEGREE);
            } else {
                CameraView.this.mCameraEngine.qqq().yj(i2);
            }
            CameraView.this.mUiHandler.post(new Cswitch((i2 + o2) % RotateProgress.FULL_DEGREE));
        }

        public void yj() {
            this.f6680ad.de("dispatchOnCameraClosed");
            CameraView.this.mUiHandler.post(new yj());
        }
    }

    public static /* synthetic */ class yj {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ int[] f6712ad;

        /* renamed from: de  reason: collision with root package name */
        public static final /* synthetic */ int[] f6713de;

        /* renamed from: fe  reason: collision with root package name */
        public static final /* synthetic */ int[] f6714fe;
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|(2:19|20)|21|23|24|(2:25|26)|27|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|(2:19|20)|21|23|24|(2:25|26)|27|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|(2:19|20)|21|23|24|25|26|27|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|48) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ae */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b8 */
        static {
            /*
                com.otaliastudios.cameraview.controls.Facing[] r0 = com.otaliastudios.cameraview.controls.Facing.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6714fe = r0
                r1 = 1
                com.otaliastudios.cameraview.controls.Facing r2 = com.otaliastudios.cameraview.controls.Facing.BACK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f6714fe     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.controls.Facing r3 = com.otaliastudios.cameraview.controls.Facing.FRONT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.otaliastudios.cameraview.gesture.GestureAction[] r2 = com.otaliastudios.cameraview.gesture.GestureAction.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f6713de = r2
                com.otaliastudios.cameraview.gesture.GestureAction r3 = com.otaliastudios.cameraview.gesture.GestureAction.TAKE_PICTURE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f6713de     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.otaliastudios.cameraview.gesture.GestureAction r3 = com.otaliastudios.cameraview.gesture.GestureAction.AUTO_FOCUS     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f6713de     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.otaliastudios.cameraview.gesture.GestureAction r4 = com.otaliastudios.cameraview.gesture.GestureAction.ZOOM     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r3 = 4
                int[] r4 = f6713de     // Catch:{ NoSuchFieldError -> 0x004e }
                com.otaliastudios.cameraview.gesture.GestureAction r5 = com.otaliastudios.cameraview.gesture.GestureAction.EXPOSURE_CORRECTION     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                r4 = 5
                int[] r5 = f6713de     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.otaliastudios.cameraview.gesture.GestureAction r6 = com.otaliastudios.cameraview.gesture.GestureAction.FILTER_CONTROL_1     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r5 = f6713de     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.otaliastudios.cameraview.gesture.GestureAction r6 = com.otaliastudios.cameraview.gesture.GestureAction.FILTER_CONTROL_2     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.otaliastudios.cameraview.gesture.Gesture[] r5 = com.otaliastudios.cameraview.gesture.Gesture.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f6712ad = r5
                com.otaliastudios.cameraview.gesture.Gesture r6 = com.otaliastudios.cameraview.gesture.Gesture.PINCH     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r5 = f6712ad     // Catch:{ NoSuchFieldError -> 0x007f }
                com.otaliastudios.cameraview.gesture.Gesture r6 = com.otaliastudios.cameraview.gesture.Gesture.TAP     // Catch:{ NoSuchFieldError -> 0x007f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r5 = f6712ad     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.otaliastudios.cameraview.gesture.Gesture r6 = com.otaliastudios.cameraview.gesture.Gesture.LONG_TAP     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r5 = f6712ad     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.otaliastudios.cameraview.gesture.Gesture r6 = com.otaliastudios.cameraview.gesture.Gesture.SCROLL_HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r3 = f6712ad     // Catch:{ NoSuchFieldError -> 0x009d }
                com.otaliastudios.cameraview.gesture.Gesture r5 = com.otaliastudios.cameraview.gesture.Gesture.SCROLL_VERTICAL     // Catch:{ NoSuchFieldError -> 0x009d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r3[r5] = r4     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                com.otaliastudios.cameraview.controls.Preview[] r3 = com.otaliastudios.cameraview.controls.Preview.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                qw = r3
                com.otaliastudios.cameraview.controls.Preview r4 = com.otaliastudios.cameraview.controls.Preview.SURFACE     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                int[] r1 = qw     // Catch:{ NoSuchFieldError -> 0x00b8 }
                com.otaliastudios.cameraview.controls.Preview r3 = com.otaliastudios.cameraview.controls.Preview.TEXTURE     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.otaliastudios.cameraview.controls.Preview r1 = com.otaliastudios.cameraview.controls.Preview.GL_SURFACE     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.CameraView.yj.<clinit>():void");
        }
    }

    static {
        String simpleName = CameraView.class.getSimpleName();
        TAG = simpleName;
        LOG = CameraLogger.qw(simpleName);
    }

    public CameraView(@NonNull Context context) {
        super(context, (AttributeSet) null);
        initialize(context, (AttributeSet) null);
    }

    private void checkPermissionsManifestOrThrow(@NonNull Audio audio) {
        if (audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO) {
            try {
                String[] strArr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions;
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    if (!strArr[i2].equals("android.permission.RECORD_AUDIO")) {
                        i2++;
                    } else {
                        return;
                    }
                }
                throw new IllegalStateException(LOG.ad("Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    private void clearLifecycleObserver() {
        Lifecycle lifecycle = this.mLifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
            this.mLifecycle = null;
        }
    }

    private void doInstantiateEngine() {
        LOG.i("doInstantiateEngine:", "instantiating. engine:", this.mEngine);
        CameraEngine instantiateCameraEngine = instantiateCameraEngine(this.mEngine, this.mCameraCallbacks);
        this.mCameraEngine = instantiateCameraEngine;
        LOG.i("doInstantiateEngine:", "instantiated. engine:", instantiateCameraEngine.getClass().getSimpleName());
        this.mCameraEngine.p0(this.mOverlayLayout);
    }

    private void initialize(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        Context context2 = context;
        boolean isInEditMode = isInEditMode();
        this.mInEditor = isInEditMode;
        if (!isInEditMode) {
            setWillNotDraw(false);
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CameraView, 0, 0);
            fe.vvv.qw.th.qw qwVar = new fe.vvv.qw.th.qw(context2, obtainStyledAttributes);
            boolean z = obtainStyledAttributes.getBoolean(36, true);
            boolean z2 = obtainStyledAttributes.getBoolean(43, true);
            this.mExperimental = obtainStyledAttributes.getBoolean(6, false);
            this.mRequestPermissions = obtainStyledAttributes.getBoolean(40, true);
            this.mPreview = qwVar.o();
            this.mEngine = qwVar.de();
            int color = obtainStyledAttributes.getColor(21, GridLinesLayout.DEFAULT_COLOR);
            long j = (long) obtainStyledAttributes.getFloat(47, 0.0f);
            int integer = obtainStyledAttributes.getInteger(46, 0);
            int integer2 = obtainStyledAttributes.getInteger(44, 0);
            int integer3 = obtainStyledAttributes.getInteger(1, 0);
            float f = obtainStyledAttributes.getFloat(38, 0.0f);
            boolean z3 = obtainStyledAttributes.getBoolean(39, false);
            int i2 = integer;
            float f2 = f;
            long integer4 = (long) obtainStyledAttributes.getInteger(4, 3000);
            boolean z4 = z3;
            boolean z5 = obtainStyledAttributes.getBoolean(25, true);
            long j2 = integer4;
            boolean z6 = obtainStyledAttributes.getBoolean(35, false);
            int integer5 = obtainStyledAttributes.getInteger(42, 0);
            int integer6 = obtainStyledAttributes.getInteger(41, 0);
            int integer7 = obtainStyledAttributes.getInteger(13, 0);
            int integer8 = obtainStyledAttributes.getInteger(12, 0);
            int integer9 = obtainStyledAttributes.getInteger(11, 0);
            int integer10 = obtainStyledAttributes.getInteger(14, 2);
            int integer11 = obtainStyledAttributes.getInteger(10, 1);
            fe.vvv.qw.xxx.de deVar = new fe.vvv.qw.xxx.de(obtainStyledAttributes);
            int i3 = integer11;
            fe.vvv.qw.pf.qw qwVar2 = new fe.vvv.qw.pf.qw(obtainStyledAttributes);
            fe.vvv.qw.p038switch.qw qwVar3 = new fe.vvv.qw.p038switch.qw(obtainStyledAttributes);
            fe.vvv.qw.uk.ad adVar = new fe.vvv.qw.uk.ad(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            this.mCameraCallbacks = new uk();
            this.mUiHandler = new Handler(Looper.getMainLooper());
            this.mPinchGestureFinder = new fe.vvv.qw.pf.ad(this.mCameraCallbacks);
            this.mTapGestureFinder = new fe.vvv.qw.pf.fe(this.mCameraCallbacks);
            this.mScrollGestureFinder = new fe.vvv.qw.pf.de(this.mCameraCallbacks);
            this.mGridLinesLayout = new GridLinesLayout(context2);
            this.mOverlayLayout = new OverlayLayout(context2);
            this.mMarkerLayout = new MarkerLayout(context2);
            addView(this.mGridLinesLayout);
            addView(this.mMarkerLayout);
            addView(this.mOverlayLayout);
            doInstantiateEngine();
            setPlaySounds(z);
            setUseDeviceOrientation(z2);
            setGrid(qwVar.th());
            setGridColor(color);
            setFacing(qwVar.fe());
            setFlash(qwVar.rg());
            setMode(qwVar.uk());
            setWhiteBalance(qwVar.m1040if());
            setHdr(qwVar.yj());
            setAudio(qwVar.qw());
            setAudioBitRate(integer3);
            setAudioCodec(qwVar.ad());
            setPictureSize(deVar.qw());
            setPictureMetering(z5);
            setPictureSnapshotMetering(z6);
            setPictureFormat(qwVar.i());
            setVideoSize(deVar.ad());
            setVideoCodec(qwVar.pf());
            setVideoMaxSize(j);
            setVideoMaxDuration(i2);
            setVideoBitRate(integer2);
            setAutoFocusResetDelay(j2);
            setPreviewFrameRateExact(z4);
            setPreviewFrameRate(f2);
            setSnapshotMaxWidth(integer5);
            setSnapshotMaxHeight(integer6);
            setFrameProcessingMaxWidth(integer7);
            setFrameProcessingMaxHeight(integer8);
            setFrameProcessingFormat(integer9);
            setFrameProcessingPoolSize(integer10);
            setFrameProcessingExecutors(i3);
            mapGesture(Gesture.TAP, qwVar2.rg());
            mapGesture(Gesture.LONG_TAP, qwVar2.de());
            mapGesture(Gesture.PINCH, qwVar2.fe());
            mapGesture(Gesture.SCROLL_HORIZONTAL, qwVar2.ad());
            mapGesture(Gesture.SCROLL_VERTICAL, qwVar2.th());
            setAutoFocusMarker(qwVar3.qw());
            setFilter(adVar.qw());
            this.mOrientationHelper = new OrientationHelper(context2, this.mCameraCallbacks);
        }
    }

    private boolean isClosed() {
        return this.mCameraEngine.B() == CameraState.OFF && !this.mCameraEngine.N();
    }

    private String ms(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i2 == 0) {
            return "UNSPECIFIED";
        }
        if (i2 != 1073741824) {
            return null;
        }
        return "EXACTLY";
    }

    private void onGesture(@NonNull GestureFinder gestureFinder, @NonNull fe.vvv.qw.ad adVar) {
        Gesture de2 = gestureFinder.de();
        PointF[] rg2 = gestureFinder.rg();
        switch (yj.f6713de[this.mGestureMap.get(de2).ordinal()]) {
            case 1:
                takePicture();
                return;
            case 2:
                this.mCameraEngine.J0(de2, fe.vvv.qw.when.ad.rg(new fe.vvv.qw.xxx.ad(getWidth(), getHeight()), rg2[0]), rg2[0]);
                return;
            case 3:
                float L = this.mCameraEngine.L();
                float ad2 = gestureFinder.ad(L, 0.0f, 1.0f);
                if (ad2 != L) {
                    this.mCameraEngine.H0(ad2, rg2, true);
                    return;
                }
                return;
            case 4:
                float d = this.mCameraEngine.d();
                float ad3 = adVar.ad();
                float qw2 = adVar.qw();
                float ad4 = gestureFinder.ad(d, ad3, qw2);
                if (ad4 != d) {
                    this.mCameraEngine.e0(ad4, new float[]{ad3, qw2}, rg2, true);
                    return;
                }
                return;
            case 5:
                if (getFilter() instanceof OneParameterFilter) {
                    OneParameterFilter oneParameterFilter = (OneParameterFilter) getFilter();
                    float rg3 = oneParameterFilter.rg();
                    float ad5 = gestureFinder.ad(rg3, 0.0f, 1.0f);
                    if (ad5 != rg3) {
                        oneParameterFilter.i(ad5);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                if (getFilter() instanceof TwoParameterFilter) {
                    TwoParameterFilter twoParameterFilter = (TwoParameterFilter) getFilter();
                    float de3 = twoParameterFilter.de();
                    float ad6 = gestureFinder.ad(de3, 0.0f, 1.0f);
                    if (ad6 != de3) {
                        twoParameterFilter.uk(ad6);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void playSound(int i2) {
        if (this.mPlaySounds) {
            if (this.mSound == null) {
                this.mSound = new MediaActionSound();
            }
            this.mSound.play(i2);
        }
    }

    @TargetApi(23)
    private void requestPermissions(boolean z, boolean z2) {
        Activity activity = null;
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add("android.permission.CAMERA");
        }
        if (z2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (activity != null) {
            activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 16);
        }
    }

    public void addCameraListener(@NonNull fe.vvv.qw.qw qwVar) {
        this.mListeners.add(qwVar);
    }

    public void addFrameProcessor(@Nullable FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.mFrameProcessors.add(frameProcessor);
            if (this.mFrameProcessors.size() == 1) {
                this.mCameraEngine.l0(true);
            }
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.mInEditor || !this.mOverlayLayout.isOverlay(layoutParams)) {
            super.addView(view, i2, layoutParams);
        } else {
            this.mOverlayLayout.addView(view, layoutParams);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean checkPermissions(@NonNull Audio audio) {
        checkPermissionsManifestOrThrow(audio);
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z = audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO;
        boolean z2 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z3 = z && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z2 && !z3) {
            return true;
        }
        if (this.mRequestPermissions) {
            requestPermissions(z2, z3);
        }
        return false;
    }

    public void clearCameraListeners() {
        this.mListeners.clear();
    }

    public void clearFrameProcessors() {
        boolean z = this.mFrameProcessors.size() > 0;
        this.mFrameProcessors.clear();
        if (z) {
            this.mCameraEngine.l0(false);
        }
    }

    public void clearGesture(@NonNull Gesture gesture) {
        mapGesture(gesture, GestureAction.NONE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (!this.mInEditor) {
            this.mOrientationHelper.yj();
            this.mCameraEngine.N0(false);
            CameraPreview cameraPreview = this.mCameraPreview;
            if (cameraPreview != null) {
                cameraPreview.ddd();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (!this.mInEditor) {
            clearCameraListeners();
            clearFrameProcessors();
            this.mCameraEngine.mmm(true);
            CameraPreview cameraPreview = this.mCameraPreview;
            if (cameraPreview != null) {
                cameraPreview.vvv();
            }
        }
    }

    @VisibleForTesting
    public void doInstantiatePreview() {
        LOG.i("doInstantiateEngine:", "instantiating. preview:", this.mPreview);
        CameraPreview instantiatePreview = instantiatePreview(this.mPreview, getContext(), this);
        this.mCameraPreview = instantiatePreview;
        LOG.i("doInstantiateEngine:", "instantiated. preview:", instantiatePreview.getClass().getSimpleName());
        this.mCameraEngine.v0(this.mCameraPreview);
        Filter filter = this.mPendingFilter;
        if (filter != null) {
            setFilter(filter);
            this.mPendingFilter = null;
        }
    }

    @NonNull
    public <T extends Control> T get(@NonNull Class<T> cls) {
        if (cls == Audio.class) {
            return getAudio();
        }
        if (cls == Facing.class) {
            return getFacing();
        }
        if (cls == Flash.class) {
            return getFlash();
        }
        if (cls == Grid.class) {
            return getGrid();
        }
        if (cls == Hdr.class) {
            return getHdr();
        }
        if (cls == Mode.class) {
            return getMode();
        }
        if (cls == WhiteBalance.class) {
            return getWhiteBalance();
        }
        if (cls == VideoCodec.class) {
            return getVideoCodec();
        }
        if (cls == AudioCodec.class) {
            return getAudioCodec();
        }
        if (cls == Preview.class) {
            return getPreview();
        }
        if (cls == Engine.class) {
            return getEngine();
        }
        if (cls == PictureFormat.class) {
            return getPictureFormat();
        }
        throw new IllegalArgumentException("Unknown control class: " + cls);
    }

    @NonNull
    public Audio getAudio() {
        return this.mCameraEngine.eee();
    }

    public int getAudioBitRate() {
        return this.mCameraEngine.rrr();
    }

    @NonNull
    public AudioCodec getAudioCodec() {
        return this.mCameraEngine.tt();
    }

    public long getAutoFocusResetDelay() {
        return this.mCameraEngine.a();
    }

    @Nullable
    public fe.vvv.qw.ad getCameraOptions() {
        return this.mCameraEngine.c();
    }

    @NonNull
    public Engine getEngine() {
        return this.mEngine;
    }

    public float getExposureCorrection() {
        return this.mCameraEngine.d();
    }

    @NonNull
    public Facing getFacing() {
        return this.mCameraEngine.e();
    }

    @NonNull
    public Filter getFilter() {
        CameraPreview cameraPreview = this.mCameraPreview;
        if (cameraPreview == null) {
            return this.mPendingFilter;
        }
        if (cameraPreview instanceof FilterCameraPreview) {
            return ((FilterCameraPreview) cameraPreview).de();
        }
        throw new RuntimeException("Filters are only supported by the GL_SURFACE preview. Current:" + this.mPreview);
    }

    @NonNull
    public Flash getFlash() {
        return this.mCameraEngine.f();
    }

    public int getFrameProcessingExecutors() {
        return this.mFrameProcessingExecutors;
    }

    public int getFrameProcessingFormat() {
        return this.mCameraEngine.g();
    }

    public int getFrameProcessingMaxHeight() {
        return this.mCameraEngine.h();
    }

    public int getFrameProcessingMaxWidth() {
        return this.mCameraEngine.j();
    }

    public int getFrameProcessingPoolSize() {
        return this.mCameraEngine.k();
    }

    @NonNull
    public GestureAction getGestureAction(@NonNull Gesture gesture) {
        return this.mGestureMap.get(gesture);
    }

    @NonNull
    public Grid getGrid() {
        return this.mGridLinesLayout.getGridMode();
    }

    public int getGridColor() {
        return this.mGridLinesLayout.getGridColor();
    }

    @NonNull
    public Hdr getHdr() {
        return this.mCameraEngine.l();
    }

    @Nullable
    public Location getLocation() {
        return this.mCameraEngine.m();
    }

    @NonNull
    public Mode getMode() {
        return this.mCameraEngine.n();
    }

    @NonNull
    public PictureFormat getPictureFormat() {
        return this.mCameraEngine.q();
    }

    public boolean getPictureMetering() {
        return this.mCameraEngine.r();
    }

    @Nullable
    public fe.vvv.qw.xxx.ad getPictureSize() {
        return this.mCameraEngine.s(Reference.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.mCameraEngine.u();
    }

    public boolean getPlaySounds() {
        return this.mPlaySounds;
    }

    @NonNull
    public Preview getPreview() {
        return this.mPreview;
    }

    public float getPreviewFrameRate() {
        return this.mCameraEngine.w();
    }

    public boolean getPreviewFrameRateExact() {
        return this.mCameraEngine.x();
    }

    public int getSnapshotMaxHeight() {
        return this.mCameraEngine.z();
    }

    public int getSnapshotMaxWidth() {
        return this.mCameraEngine.A();
    }

    @Nullable
    public fe.vvv.qw.xxx.ad getSnapshotSize() {
        fe.vvv.qw.xxx.ad adVar = null;
        if (!(getWidth() == 0 || getHeight() == 0)) {
            fe.vvv.qw.xxx.ad D = this.mCameraEngine.D(Reference.VIEW);
            if (D == null) {
                return null;
            }
            Rect qw2 = fe.vvv.qw.p037if.ad.qw(D, fe.vvv.qw.xxx.qw.th(getWidth(), getHeight()));
            adVar = new fe.vvv.qw.xxx.ad(qw2.width(), qw2.height());
            if (this.mCameraEngine.qqq().ad(Reference.VIEW, Reference.OUTPUT)) {
                return adVar.ad();
            }
        }
        return adVar;
    }

    public boolean getUseDeviceOrientation() {
        return this.mUseDeviceOrientation;
    }

    public int getVideoBitRate() {
        return this.mCameraEngine.E();
    }

    @NonNull
    public VideoCodec getVideoCodec() {
        return this.mCameraEngine.F();
    }

    public int getVideoMaxDuration() {
        return this.mCameraEngine.G();
    }

    public long getVideoMaxSize() {
        return this.mCameraEngine.H();
    }

    @Nullable
    public fe.vvv.qw.xxx.ad getVideoSize() {
        return this.mCameraEngine.I(Reference.OUTPUT);
    }

    @NonNull
    public WhiteBalance getWhiteBalance() {
        return this.mCameraEngine.K();
    }

    public float getZoom() {
        return this.mCameraEngine.L();
    }

    @NonNull
    public CameraEngine instantiateCameraEngine(@NonNull Engine engine, @NonNull CameraEngine.Callback callback) {
        if (this.mExperimental && engine == Engine.CAMERA2 && Build.VERSION.SDK_INT >= 21) {
            return new fe.vvv.qw.yj.ad(callback);
        }
        this.mEngine = Engine.CAMERA1;
        return new fe.vvv.qw.yj.qw(callback);
    }

    @NonNull
    public CameraPreview instantiatePreview(@NonNull Preview preview, @NonNull Context context, @NonNull ViewGroup viewGroup) {
        int i2 = yj.qw[preview.ordinal()];
        if (i2 == 1) {
            return new fe.vvv.qw.vvv.ad(context, viewGroup);
        }
        if (i2 != 2) {
            this.mPreview = Preview.GL_SURFACE;
            return new fe.vvv.qw.vvv.qw(context, viewGroup);
        } else if (isHardwareAccelerated()) {
            return new fe.vvv.qw.vvv.de(context, viewGroup);
        } else {
            this.mPreview = Preview.GL_SURFACE;
            return new fe.vvv.qw.vvv.qw(context, viewGroup);
        }
    }

    public boolean isOpened() {
        return this.mCameraEngine.B().isAtLeast(CameraState.ENGINE) && this.mCameraEngine.C().isAtLeast(CameraState.ENGINE);
    }

    public boolean isTakingPicture() {
        return this.mCameraEngine.O();
    }

    public boolean isTakingVideo() {
        return this.mCameraEngine.P();
    }

    public boolean mapGesture(@NonNull Gesture gesture, @NonNull GestureAction gestureAction) {
        GestureAction gestureAction2 = GestureAction.NONE;
        boolean z = false;
        if (gesture.isAssignableTo(gestureAction)) {
            this.mGestureMap.put(gesture, gestureAction);
            int i2 = yj.f6712ad[gesture.ordinal()];
            if (i2 == 1) {
                fe.vvv.qw.pf.ad adVar = this.mPinchGestureFinder;
                if (this.mGestureMap.get(Gesture.PINCH) != gestureAction2) {
                    z = true;
                }
                adVar.i(z);
            } else if (i2 == 2 || i2 == 3) {
                fe.vvv.qw.pf.fe feVar = this.mTapGestureFinder;
                if (!(this.mGestureMap.get(Gesture.TAP) == gestureAction2 && this.mGestureMap.get(Gesture.LONG_TAP) == gestureAction2)) {
                    z = true;
                }
                feVar.i(z);
            } else if (i2 == 4 || i2 == 5) {
                fe.vvv.qw.pf.de deVar = this.mScrollGestureFinder;
                if (!(this.mGestureMap.get(Gesture.SCROLL_HORIZONTAL) == gestureAction2 && this.mGestureMap.get(Gesture.SCROLL_VERTICAL) == gestureAction2)) {
                    z = true;
                }
                deVar.i(z);
            }
            return true;
        }
        mapGesture(gesture, gestureAction2);
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mInEditor && this.mCameraPreview == null) {
            doInstantiatePreview();
        }
    }

    public void onDetachedFromWindow() {
        this.mLastPreviewStreamSize = null;
        super.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void onMeasure(int i2, int i3) {
        if (this.mInEditor) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824));
            return;
        }
        fe.vvv.qw.xxx.ad y = this.mCameraEngine.y(Reference.VIEW);
        this.mLastPreviewStreamSize = y;
        if (y == null) {
            LOG.i("onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        float rg2 = (float) this.mLastPreviewStreamSize.rg();
        float fe2 = (float) this.mLastPreviewStreamSize.fe();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.mCameraPreview.eee()) {
            if (mode == 1073741824) {
                mode = Integer.MIN_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = Integer.MIN_VALUE;
            }
        } else {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = 1073741824;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = 1073741824;
            }
        }
        CameraLogger cameraLogger = LOG;
        cameraLogger.de("onMeasure:", "requested dimensions are (" + size + "[" + ms(mode) + "]x" + size2 + "[" + ms(mode2) + "])");
        CameraLogger cameraLogger2 = LOG;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(rg2);
        sb.append(x.a);
        sb.append(fe2);
        sb.append(")");
        cameraLogger2.de("onMeasure:", "previewSize is", sb.toString());
        if (mode == 1073741824 && mode2 == 1073741824) {
            CameraLogger cameraLogger3 = LOG;
            cameraLogger3.de("onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", "(" + size + x.a + size2 + ")");
            super.onMeasure(i2, i3);
        } else if (mode == 0 && mode2 == 0) {
            CameraLogger cameraLogger4 = LOG;
            cameraLogger4.de("onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + rg2 + x.a + fe2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) rg2, 1073741824), View.MeasureSpec.makeMeasureSpec((int) fe2, 1073741824));
        } else {
            float f = fe2 / rg2;
            if (mode == 0 || mode2 == 0) {
                if (mode == 0) {
                    size = Math.round(((float) size2) / f);
                } else {
                    size2 = Math.round(((float) size) * f);
                }
                CameraLogger cameraLogger5 = LOG;
                cameraLogger5.de("onMeasure:", "one dimension was free, we adapted it to fit the ratio.", "(" + size + x.a + size2 + ")");
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else if (mode == 1073741824 || mode2 == 1073741824) {
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(Math.round(((float) size2) / f), size);
                } else {
                    size2 = Math.min(Math.round(((float) size) * f), size2);
                }
                CameraLogger cameraLogger6 = LOG;
                cameraLogger6.de("onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", "(" + size + x.a + size2 + ")");
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else {
                float f2 = (float) size2;
                float f3 = (float) size;
                if (f2 / f3 >= f) {
                    size2 = Math.round(f3 * f);
                } else {
                    size = Math.round(f2 / f);
                }
                CameraLogger cameraLogger7 = LOG;
                cameraLogger7.de("onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", "(" + size + x.a + size2 + ")");
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isOpened()) {
            return true;
        }
        fe.vvv.qw.ad c = this.mCameraEngine.c();
        if (c != null) {
            if (this.mPinchGestureFinder.uk(motionEvent)) {
                LOG.de("onTouchEvent", "pinch!");
                onGesture(this.mPinchGestureFinder, c);
            } else if (this.mScrollGestureFinder.uk(motionEvent)) {
                LOG.de("onTouchEvent", "scroll!");
                onGesture(this.mScrollGestureFinder, c);
            } else if (this.mTapGestureFinder.uk(motionEvent)) {
                LOG.de("onTouchEvent", "tap!");
                onGesture(this.mTapGestureFinder, c);
            }
            return true;
        }
        throw new IllegalStateException("Options should not be null here.");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void open() {
        if (!this.mInEditor) {
            CameraPreview cameraPreview = this.mCameraPreview;
            if (cameraPreview != null) {
                cameraPreview.nn();
            }
            if (checkPermissions(getAudio())) {
                this.mOrientationHelper.uk();
                this.mCameraEngine.qqq().uk(this.mOrientationHelper.o());
                this.mCameraEngine.I0();
            }
        }
    }

    public void removeCameraListener(@NonNull fe.vvv.qw.qw qwVar) {
        this.mListeners.remove(qwVar);
    }

    public void removeFrameProcessor(@Nullable FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.mFrameProcessors.remove(frameProcessor);
            if (this.mFrameProcessors.size() == 0) {
                this.mCameraEngine.l0(false);
            }
        }
    }

    public void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.mInEditor || layoutParams == null || !this.mOverlayLayout.isOverlay(layoutParams)) {
            super.removeView(view);
        } else {
            this.mOverlayLayout.removeView(view);
        }
    }

    public void set(@NonNull Control control) {
        if (control instanceof Audio) {
            setAudio((Audio) control);
        } else if (control instanceof Facing) {
            setFacing((Facing) control);
        } else if (control instanceof Flash) {
            setFlash((Flash) control);
        } else if (control instanceof Grid) {
            setGrid((Grid) control);
        } else if (control instanceof Hdr) {
            setHdr((Hdr) control);
        } else if (control instanceof Mode) {
            setMode((Mode) control);
        } else if (control instanceof WhiteBalance) {
            setWhiteBalance((WhiteBalance) control);
        } else if (control instanceof VideoCodec) {
            setVideoCodec((VideoCodec) control);
        } else if (control instanceof AudioCodec) {
            setAudioCodec((AudioCodec) control);
        } else if (control instanceof Preview) {
            setPreview((Preview) control);
        } else if (control instanceof Engine) {
            setEngine((Engine) control);
        } else if (control instanceof PictureFormat) {
            setPictureFormat((PictureFormat) control);
        }
    }

    public void setAudio(@NonNull Audio audio) {
        if (audio == getAudio() || isClosed()) {
            this.mCameraEngine.a0(audio);
        } else if (checkPermissions(audio)) {
            this.mCameraEngine.a0(audio);
        } else {
            close();
        }
    }

    public void setAudioBitRate(int i2) {
        this.mCameraEngine.b0(i2);
    }

    public void setAudioCodec(@NonNull AudioCodec audioCodec) {
        this.mCameraEngine.c0(audioCodec);
    }

    public void setAutoFocusMarker(@Nullable AutoFocusMarker autoFocusMarker) {
        this.mAutoFocusMarker = autoFocusMarker;
        this.mMarkerLayout.onMarker(1, autoFocusMarker);
    }

    public void setAutoFocusResetDelay(long j) {
        this.mCameraEngine.d0(j);
    }

    public void setEngine(@NonNull Engine engine) {
        if (isClosed()) {
            this.mEngine = engine;
            CameraEngine cameraEngine = this.mCameraEngine;
            doInstantiateEngine();
            CameraPreview cameraPreview = this.mCameraPreview;
            if (cameraPreview != null) {
                this.mCameraEngine.v0(cameraPreview);
            }
            setFacing(cameraEngine.e());
            setFlash(cameraEngine.f());
            setMode(cameraEngine.n());
            setWhiteBalance(cameraEngine.K());
            setHdr(cameraEngine.l());
            setAudio(cameraEngine.eee());
            setAudioBitRate(cameraEngine.rrr());
            setAudioCodec(cameraEngine.tt());
            setPictureSize(cameraEngine.t());
            setPictureFormat(cameraEngine.q());
            setVideoSize(cameraEngine.J());
            setVideoCodec(cameraEngine.F());
            setVideoMaxSize(cameraEngine.H());
            setVideoMaxDuration(cameraEngine.G());
            setVideoBitRate(cameraEngine.E());
            setAutoFocusResetDelay(cameraEngine.a());
            setPreviewFrameRate(cameraEngine.w());
            setPreviewFrameRateExact(cameraEngine.x());
            setSnapshotMaxWidth(cameraEngine.A());
            setSnapshotMaxHeight(cameraEngine.z());
            setFrameProcessingMaxWidth(cameraEngine.j());
            setFrameProcessingMaxHeight(cameraEngine.h());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(cameraEngine.k());
            this.mCameraEngine.l0(!this.mFrameProcessors.isEmpty());
        }
    }

    public void setExperimental(boolean z) {
        this.mExperimental = z;
    }

    public void setExposureCorrection(float f) {
        fe.vvv.qw.ad cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float ad2 = cameraOptions.ad();
            float qw2 = cameraOptions.qw();
            if (f < ad2) {
                f = ad2;
            }
            if (f > qw2) {
                f = qw2;
            }
            this.mCameraEngine.e0(f, new float[]{ad2, qw2}, (PointF[]) null, false);
        }
    }

    public void setFacing(@NonNull Facing facing) {
        this.mCameraEngine.f0(facing);
    }

    public void setFilter(@NonNull Filter filter) {
        CameraPreview cameraPreview = this.mCameraPreview;
        if (cameraPreview == null) {
            this.mPendingFilter = filter;
            return;
        }
        boolean z = cameraPreview instanceof FilterCameraPreview;
        if (!(filter instanceof fe.vvv.qw.uk.de) && !z) {
            throw new RuntimeException("Filters are only supported by the GL_SURFACE preview. Current preview:" + this.mPreview);
        } else if (z) {
            ((FilterCameraPreview) this.mCameraPreview).ad(filter);
        }
    }

    public void setFlash(@NonNull Flash flash) {
        this.mCameraEngine.g0(flash);
    }

    public void setFrameProcessingExecutors(int i2) {
        if (i2 >= 1) {
            this.mFrameProcessingExecutors = i2;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 4, TimeUnit.SECONDS, new LinkedBlockingQueue(), new th());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.mFrameProcessingExecutor = threadPoolExecutor;
            return;
        }
        throw new IllegalArgumentException("Need at least 1 executor, got " + i2);
    }

    public void setFrameProcessingFormat(int i2) {
        this.mCameraEngine.h0(i2);
    }

    public void setFrameProcessingMaxHeight(int i2) {
        this.mCameraEngine.i0(i2);
    }

    public void setFrameProcessingMaxWidth(int i2) {
        this.mCameraEngine.j0(i2);
    }

    public void setFrameProcessingPoolSize(int i2) {
        this.mCameraEngine.k0(i2);
    }

    public void setGrid(@NonNull Grid grid) {
        this.mGridLinesLayout.setGridMode(grid);
    }

    public void setGridColor(@ColorInt int i2) {
        this.mGridLinesLayout.setGridColor(i2);
    }

    public void setHdr(@NonNull Hdr hdr) {
        this.mCameraEngine.m0(hdr);
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            clearLifecycleObserver();
            return;
        }
        clearLifecycleObserver();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        this.mLifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    public void setLocation(double d, double d2) {
        Location location = new Location("Unknown");
        location.setTime(System.currentTimeMillis());
        location.setAltitude(0.0d);
        location.setLatitude(d);
        location.setLongitude(d2);
        this.mCameraEngine.n0(location);
    }

    public void setMode(@NonNull Mode mode) {
        this.mCameraEngine.o0(mode);
    }

    public void setPictureFormat(@NonNull PictureFormat pictureFormat) {
        this.mCameraEngine.q0(pictureFormat);
    }

    public void setPictureMetering(boolean z) {
        this.mCameraEngine.r0(z);
    }

    public void setPictureSize(@NonNull SizeSelector sizeSelector) {
        this.mCameraEngine.s0(sizeSelector);
    }

    public void setPictureSnapshotMetering(boolean z) {
        this.mCameraEngine.t0(z);
    }

    public void setPlaySounds(boolean z) {
        this.mPlaySounds = z && Build.VERSION.SDK_INT >= 16;
        this.mCameraEngine.u0(z);
    }

    public void setPreview(@NonNull Preview preview) {
        CameraPreview cameraPreview;
        boolean z = true;
        if (preview != this.mPreview) {
            this.mPreview = preview;
            if (getWindowToken() == null) {
                z = false;
            }
            if (!z && (cameraPreview = this.mCameraPreview) != null) {
                cameraPreview.vvv();
                this.mCameraPreview = null;
            }
        }
    }

    public void setPreviewFrameRate(float f) {
        this.mCameraEngine.w0(f);
    }

    public void setPreviewFrameRateExact(boolean z) {
        this.mCameraEngine.x0(z);
    }

    public void setPreviewStreamSize(@NonNull SizeSelector sizeSelector) {
        this.mCameraEngine.y0(sizeSelector);
    }

    public void setRequestPermissions(boolean z) {
        this.mRequestPermissions = z;
    }

    public void setSnapshotMaxHeight(int i2) {
        this.mCameraEngine.z0(i2);
    }

    public void setSnapshotMaxWidth(int i2) {
        this.mCameraEngine.A0(i2);
    }

    public void setUseDeviceOrientation(boolean z) {
        this.mUseDeviceOrientation = z;
    }

    public void setVideoBitRate(int i2) {
        this.mCameraEngine.B0(i2);
    }

    public void setVideoCodec(@NonNull VideoCodec videoCodec) {
        this.mCameraEngine.C0(videoCodec);
    }

    public void setVideoMaxDuration(int i2) {
        this.mCameraEngine.D0(i2);
    }

    public void setVideoMaxSize(long j) {
        this.mCameraEngine.E0(j);
    }

    public void setVideoSize(@NonNull SizeSelector sizeSelector) {
        this.mCameraEngine.F0(sizeSelector);
    }

    public void setWhiteBalance(@NonNull WhiteBalance whiteBalance) {
        this.mCameraEngine.G0(whiteBalance);
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.mCameraEngine.H0(f, (PointF[]) null, false);
    }

    public void startAutoFocus(float f, float f2) {
        if (f < 0.0f || f > ((float) getWidth())) {
            throw new IllegalArgumentException("x should be >= 0 and <= getWidth()");
        } else if (f2 < 0.0f || f2 > ((float) getHeight())) {
            throw new IllegalArgumentException("y should be >= 0 and <= getHeight()");
        } else {
            fe.vvv.qw.xxx.ad adVar = new fe.vvv.qw.xxx.ad(getWidth(), getHeight());
            PointF pointF = new PointF(f, f2);
            this.mCameraEngine.J0((Gesture) null, fe.vvv.qw.when.ad.rg(adVar, pointF), pointF);
        }
    }

    public void stopVideo() {
        this.mCameraEngine.R0();
        this.mUiHandler.post(new rg());
    }

    public void takePicture() {
        this.mCameraEngine.S0(new fe.qw());
    }

    public void takePictureSnapshot() {
        this.mCameraEngine.T0(new fe.qw());
    }

    public void takeVideo(@NonNull File file) {
        takeVideo(file, (FileDescriptor) null);
    }

    public void takeVideoSnapshot(@NonNull File file) {
        this.mCameraEngine.V0(new rg.qw(), file);
        this.mUiHandler.post(new qw());
    }

    public Facing toggleFacing() {
        int i2 = yj.f6714fe[this.mCameraEngine.e().ordinal()];
        if (i2 == 1) {
            setFacing(Facing.FRONT);
        } else if (i2 == 2) {
            setFacing(Facing.BACK);
        }
        return this.mCameraEngine.e();
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mInEditor || !this.mOverlayLayout.isOverlay(attributeSet)) {
            return super.generateLayoutParams(attributeSet);
        }
        return this.mOverlayLayout.generateLayoutParams(attributeSet);
    }

    public void takeVideo(@NonNull FileDescriptor fileDescriptor) {
        takeVideo((File) null, fileDescriptor);
    }

    private void takeVideo(@Nullable File file, @Nullable FileDescriptor fileDescriptor) {
        rg.qw qwVar = new rg.qw();
        if (file != null) {
            this.mCameraEngine.U0(qwVar, file, (FileDescriptor) null);
        } else if (fileDescriptor != null) {
            this.mCameraEngine.U0(qwVar, (File) null, fileDescriptor);
        } else {
            throw new IllegalStateException("file and fileDescriptor are both null.");
        }
        this.mUiHandler.post(new de());
    }

    public void takeVideoSnapshot(@NonNull File file, int i2) {
        addCameraListener(new ad(getVideoMaxDuration()));
        setVideoMaxDuration(i2);
        takeVideoSnapshot(file);
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet);
    }

    public void setLocation(@Nullable Location location) {
        this.mCameraEngine.n0(location);
    }

    public void takeVideo(@NonNull File file, int i2) {
        takeVideo(file, (FileDescriptor) null, i2);
    }

    public void startAutoFocus(@NonNull RectF rectF) {
        if (new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()).contains(rectF)) {
            this.mCameraEngine.J0((Gesture) null, fe.vvv.qw.when.ad.ad(new fe.vvv.qw.xxx.ad(getWidth(), getHeight()), rectF), new PointF(rectF.centerX(), rectF.centerY()));
            return;
        }
        throw new IllegalArgumentException("Region is out of view bounds! " + rectF);
    }

    public void takeVideo(@NonNull FileDescriptor fileDescriptor, int i2) {
        takeVideo((File) null, fileDescriptor, i2);
    }

    private void takeVideo(@Nullable File file, @Nullable FileDescriptor fileDescriptor, int i2) {
        addCameraListener(new fe(getVideoMaxDuration()));
        setVideoMaxDuration(i2);
        takeVideo(file, fileDescriptor);
    }
}
