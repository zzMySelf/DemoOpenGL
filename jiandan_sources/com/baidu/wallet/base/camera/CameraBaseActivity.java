package com.baidu.wallet.base.camera;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.d;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.permission.CommonPermissionCallback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CameraBaseActivity extends BaseActivity implements SurfaceHolder.Callback, com.baidu.wallet.base.camera.internal.c {
    public static final int MSG_PROBE_OPEN_STATE = 1;
    public static int REQUEST_PERMISSION_CAMERA = 1;
    public static final int RequestCode = 132;
    public static final int ResultCodeExit = 1243;
    public static final int ResultCodeStay = 1244;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_RAW = 0;
    public static final String Tag = CameraBaseActivity.class.getSimpleName();
    public Camera.AutoFocusCallback autoFocusCallback = new Camera.AutoFocusCallback() {
        public int b;

        public void onAutoFocus(boolean z, Camera camera) {
            if (CameraBaseActivity.this.mPreviewCb != null && CameraBaseActivity.this.mPreviewCb.d() != null) {
                CameraBaseActivity cameraBaseActivity = CameraBaseActivity.this;
                if (!cameraBaseActivity.mInCaptureProgresses) {
                    com.baidu.wallet.base.camera.internal.b d = cameraBaseActivity.mPreviewCb.d();
                    if (z) {
                        this.b = 0;
                        CameraBaseActivity.this.takePictureWithoutAutoFocus(d);
                        return;
                    }
                    int i2 = this.b + 1;
                    this.b = i2;
                    if (i2 > 1) {
                        CameraBaseActivity.this.takePictureWithoutAutoFocus(d);
                    } else {
                        d.a(CameraBaseActivity.this.autoFocusCallback, "continuous-picture");
                    }
                }
            }
        }
    };
    public int cameraId = 0;
    public boolean fromLangbridge = false;
    public com.baidu.wallet.base.camera.internal.a mAutoFocusCb;
    public final Handler mAutoFocusHandler = new Handler(Looper.myLooper()) {
        public void handleMessage(Message message) {
            int id = ResUtils.id(CameraBaseActivity.this.getActivity(), "wallet_auto_focus");
            if (id != message.what) {
                super.handleMessage(message);
            } else if (CameraBaseActivity.this.mPreviewCb != null) {
                CameraBaseActivity.this.mAutoFocusCb.a(this, id);
                com.baidu.wallet.base.camera.internal.b d = CameraBaseActivity.this.mPreviewCb.d();
                if (d != null) {
                    try {
                        d.a((Camera.AutoFocusCallback) CameraBaseActivity.this.mAutoFocusCb);
                    } catch (Exception unused) {
                        LogUtil.w(CameraBaseActivity.Tag, "mAutoFocusHandler.handleMessage()");
                    }
                }
            } else {
                CameraBaseActivity.this.mAutoFocusCb.a((Handler) null, id);
            }
        }
    };
    public Rect mBmpDataRect = new Rect();
    public boolean mCanRequestCameraPermission = true;
    public ViewGroup mContentView;
    public final AtomicInteger mDetectorState = new AtomicInteger(0);
    public a[] mDetectors = null;
    public final AtomicBoolean mDone = new AtomicBoolean(false);
    public b mFlashController = new b();
    public float mFocusDataYXRatial = 1.0f;
    public Rect mFocusViewRect = new Rect();
    public IImageProcess mImageProcessor;
    public int[] mImageSize = new int[2];
    public boolean mInCaptureProgresses = false;
    public AtomicBoolean mInCaptureTimeOut = new AtomicBoolean(false);
    public AtomicBoolean mIsCameraMalfunctioned = new AtomicBoolean(false);
    public Handler mMiscEvtHandler = null;
    public OnCameraChangeListener mOnCameraChange;
    public CommonPermissionCallback mPermissionCallBack;
    public d mPreviewCb;
    public SurfaceView mPreviewView;
    public int mRotation;
    public float mScaleCoefficient = 1.0f;
    public int[] mScreeSize = new int[2];
    public SurfaceHolder mSurfaceHolder = null;
    public com.baidu.wallet.base.camera.util.c mThreadPool;
    public CountDownTimer mTimer;
    public View mTitleBarMargin;
    public RelativeLayout mTitle_bar;

    public class b implements Runnable {
        public boolean b;

        public b() {
        }

        public void a(boolean z) {
            this.b = z;
        }

        public void run() {
            CameraBaseActivity.this.updateFlashLightUi(this.b);
        }
    }

    public static class c extends Thread {
        public WeakReference<CameraBaseActivity> a;

        public c(CameraBaseActivity cameraBaseActivity) {
            this.a = new WeakReference<>(cameraBaseActivity);
        }

        private boolean a() {
            CameraBaseActivity cameraBaseActivity = (CameraBaseActivity) this.a.get();
            if (cameraBaseActivity == null) {
                return false;
            }
            if (!(cameraBaseActivity.mDetectors == null || cameraBaseActivity.mDetectors.length == 0)) {
                for (a aVar : cameraBaseActivity.mDetectors) {
                    if (aVar != null && aVar.a()) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void run() {
            CameraBaseActivity cameraBaseActivity = (CameraBaseActivity) this.a.get();
            if (cameraBaseActivity != null) {
                while (!a()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                cameraBaseActivity.mImageProcessor.destroyProcessor();
                a[] unused = cameraBaseActivity.mDetectors = null;
            }
        }
    }

    private synchronized a getAvailableDetector() {
        int i2 = 0;
        if (this.mDetectors == null) {
            a[] aVarArr = new a[com.baidu.wallet.base.camera.util.a.a()];
            this.mDetectors = aVarArr;
            aVarArr[0] = new a();
            return this.mDetectors[0];
        }
        while (i2 < this.mDetectors.length) {
            if (this.mDetectors[i2] == null) {
                this.mDetectors[i2] = new a();
                return this.mDetectors[i2];
            } else if (!this.mDetectors[i2].a()) {
                return this.mDetectors[i2];
            } else {
                i2++;
            }
        }
        return null;
    }

    public static String getToken() {
        return SafePay.getInstance().getToken();
    }

    /* access modifiers changed from: private */
    public void handleNoCamaraPermission() {
        onPermissionDenied();
        showBaseDialog(3, ResUtils.getString(getActivity(), "wallet_camera_error"));
    }

    private boolean isFlashOn() {
        if (this.mPreviewCb != null) {
            return CameraCtrl.getInstance().isFlashOn();
        }
        return false;
    }

    private void setFlashLightOn(boolean z) {
        if (this.mPreviewCb != null) {
            CameraCtrl instance = CameraCtrl.getInstance();
            if (instance.isFlashOn() != z) {
                instance.setFlashOn(z);
            }
            switchFlashOnMainThread(instance.isFlashOn());
        }
    }

    private void startCountDown() {
        stopCountDown();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        AnonymousClass8 r1 = new CountDownTimer((long) SdkInitResponse.getInstance().getTakePicWaitTime(), (long) SdkInitResponse.getInstance().getTakePicWaitTime()) {
            public void onFinish() {
                if (CameraBaseActivity.this.mTimer != null) {
                    CameraBaseActivity.this.mTimer.cancel();
                    CameraBaseActivity.this.mInCaptureTimeOut.set(true);
                    CameraBaseActivity.this.mInCaptureProgresses = false;
                    LogUtil.d(CameraBaseActivity.Tag, com.alipay.sdk.m.m.a.Z);
                }
            }

            public void onTick(long j) {
            }
        };
        this.mTimer = r1;
        r1.start();
    }

    private boolean startScan() {
        d dVar;
        if (this.mPreviewCb == null) {
            int a2 = d.a(getActivity(), this.cameraId);
            this.mRotation = a2;
            int i2 = this.cameraId;
            int[] iArr = this.mScreeSize;
            d a3 = d.a(i2, iArr[0], iArr[1], a2, 17, 10, this);
            this.mPreviewCb = a3;
            if (a3 == null) {
                handleNoCamaraPermission();
                return false;
            }
        }
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (!(surfaceHolder == null || (dVar = this.mPreviewCb) == null)) {
            dVar.a(surfaceHolder);
            com.baidu.wallet.base.camera.internal.a aVar = new com.baidu.wallet.base.camera.internal.a();
            this.mAutoFocusCb = aVar;
            aVar.a(getAutoFocusDelay());
            this.mAutoFocusCb.b(getFirstFocusDelay());
            this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "wallet_auto_focus")).sendToTarget();
            try {
                Camera.Size previewSize = this.mPreviewCb.d().d().getPreviewSize();
                this.mImageSize[0] = previewSize.width;
                this.mImageSize[1] = previewSize.height;
                int[] iArr2 = this.mScreeSize;
                int[] iArr3 = this.mImageSize;
                this.mScaleCoefficient = ((((float) iArr2[1]) * ((float) iArr3[1])) / ((float) iArr2[0])) / ((float) iArr3[0]);
                String str = Tag;
                LogUtil.i(str, "ratio:" + this.mScaleCoefficient);
                relayoutUi();
                setFocusRectValue(this.mFocusViewRect);
                mapViewDataBoundary(this.mBmpDataRect);
            } catch (Throwable th2) {
                showBaseDialog(3, ResUtils.getString(getActivity(), "wallet_camera_error"));
                DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SDK_SELF_DEFINE_GET_PREVIEW_SIZE_FAILED, Arrays.asList(new String[]{th2.getMessage()}));
                return false;
            }
        }
        this.mDone.set(false);
        this.mIsCameraMalfunctioned.set(true);
        Handler handler = this.mMiscEvtHandler;
        if (handler == null) {
            this.mMiscEvtHandler = new Handler() {
                public void handleMessage(Message message) {
                    if (1 == message.what && CameraBaseActivity.this.mIsCameraMalfunctioned.get()) {
                        CameraBaseActivity.this.showBaseDialog(3, ResUtils.getString(CameraBaseActivity.this.getActivity(), "wallet_camera_error"));
                    }
                }
            };
        } else {
            handler.removeMessages(1);
        }
        this.mMiscEvtHandler.sendEmptyMessageDelayed(1, 1500);
        return true;
    }

    private void switchFlashOnMainThread(boolean z) {
        this.mFlashController.a(z);
        getActivity().runOnUiThread(this.mFlashController);
    }

    public void autoFoucus() {
        com.baidu.wallet.base.camera.internal.b d;
        d dVar = this.mPreviewCb;
        if (dVar != null && (d = dVar.d()) != null) {
            try {
                d.a((Camera.AutoFocusCallback) this.mAutoFocusCb);
            } catch (Throwable unused) {
                LogUtil.w(Tag, "autoFocus exception");
            }
        }
    }

    public void destroyCamera() {
        LogUtil.i(Tag, "destroyCamera()");
        OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
        if (onCameraChangeListener != null) {
            onCameraChangeListener.onCameraClose();
        }
        if (this.mDetectors != null) {
            int i2 = 0;
            while (true) {
                a[] aVarArr = this.mDetectors;
                if (i2 < aVarArr.length) {
                    aVarArr[i2] = null;
                    i2++;
                } else {
                    this.mDetectors = null;
                    return;
                }
            }
        }
    }

    public String getApplicationName() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = DxmApplicationContextImpl.getApplicationContext(this).getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public long getAutoFocusDelay() {
        return 500;
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public abstract View getCustomizedView();

    public long getFirstFocusDelay() {
        return 500;
    }

    public abstract float getFocusDataYXRatioal();

    public abstract IImageProcess getImageProcessor();

    public boolean initCamera(int i2, int i3, int i4, int i5) {
        String str = Tag;
        LogUtil.i(str, "initCamera(" + i2 + "|" + i3 + "|" + i4 + "|" + i5 + ")");
        OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
        if (onCameraChangeListener == null) {
            return true;
        }
        onCameraChangeListener.onCameraOpen();
        return true;
    }

    public boolean isStatusbarTextColorBlack() {
        return false;
    }

    public void mapViewDataBoundary(Rect rect) {
        float focusDataYXRatioal = getFocusDataYXRatioal();
        this.mFocusDataYXRatial = focusDataYXRatioal;
        if (0.0f >= focusDataYXRatioal) {
            this.mFocusDataYXRatial = 1.0f;
        }
        int round = Math.round(((float) this.mImageSize[1]) * (((float) this.mFocusViewRect.left) / ((float) this.mScreeSize[0])));
        rect.top = round;
        int[] iArr = this.mImageSize;
        rect.bottom = iArr[1] - round;
        rect.left = Math.round(((float) iArr[0]) * (((float) this.mFocusViewRect.top) / ((float) this.mScreeSize[1])));
        rect.right = Math.round((((float) rect.height()) * this.mFocusDataYXRatial) + ((float) rect.left));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (132 != i2 || i3 == 1244) {
            restartScan();
        } else if (i3 == 1243) {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_camera_detection"), (ViewGroup) null);
        this.mContentView = viewGroup;
        setContentView((View) viewGroup);
        IImageProcess imageProcessor = getImageProcessor();
        this.mImageProcessor = imageProcessor;
        if (imageProcessor == null) {
            LogUtil.e(Tag, "onCreate() failed to get ImageProcessor", (Throwable) null);
            finish();
        }
        this.mContentView.addView(getCustomizedView(), 1);
        View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
        this.mTitleBarMargin = findViewById;
        setTop(findViewById);
        setIsShowMultiWindowTips(true);
        setIsMultiWindowAvailable(false);
        setMultiWindowTipsId("wallet_base_multi_window_close");
        SurfaceView surfaceView = (SurfaceView) findViewById(ResUtils.id(getActivity(), "surfaceview"));
        this.mPreviewView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setKeepScreenOn(true);
        holder.setType(3);
        holder.addCallback(this);
        com.baidu.wallet.base.camera.util.c a2 = com.baidu.wallet.base.camera.util.c.a(com.baidu.wallet.base.camera.util.a.a(), ImageProcessor.a);
        this.mThreadPool = a2;
        a2.a((Runnable) new Runnable() {
            public void run() {
                CameraBaseActivity.this.mDetectorState.set(CameraBaseActivity.this.mImageProcessor.initProcessor() ? 1 : 0);
            }
        });
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("fromLangbridge")) {
            this.fromLangbridge = extras.getBoolean("fromLangbridge", false);
        }
    }

    public void onDestroy() {
        LogUtil.i(Tag, "onDestroy()");
        this.mDone.set(true);
        Handler handler = this.mMiscEvtHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mMiscEvtHandler = null;
        }
        stopCamera();
        if (this.mImageProcessor != null) {
            new c(this).start();
        }
        com.baidu.wallet.base.camera.util.c cVar = this.mThreadPool;
        if (cVar != null) {
            cVar.a();
            this.mThreadPool = null;
        }
        updateFlashLightUi(false);
        super.onDestroy();
    }

    public void onPause() {
        LogUtil.i(Tag, "onPause()");
        super.onPause();
    }

    public abstract void onPermissionDenied();

    public void onPrepareDialog(int i2, Dialog dialog) {
        super.onPrepareDialog(i2, dialog);
        if (i2 == 3) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    WalletGlobalUtils.showStr = "";
                    CameraCtrl instance = CameraCtrl.getInstance();
                    if (instance != null) {
                        instance.reset();
                    }
                    CameraBaseActivity.this.finish();
                }
            });
        }
    }

    public abstract void onProcessImageOk(Object[] objArr);

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == REQUEST_PERMISSION_CAMERA) {
            CommonPermissionCallback commonPermissionCallback = this.mPermissionCallBack;
            if (commonPermissionCallback != null) {
                commonPermissionCallback.onRequestPermissionsResult(i2, strArr, iArr);
                this.mPermissionCallBack = null;
            }
            this.mCanRequestCameraPermission = true;
            if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
                handleNoCamaraPermission();
                return;
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if ("android.permission.CAMERA".equalsIgnoreCase(strArr[i3]) && iArr != null && iArr.length > i3) {
                    if (iArr[i3] == 0) {
                        relayoutUi();
                        setFocusRectValue(this.mFocusViewRect);
                        startScan();
                    } else if (-1 == iArr[i3]) {
                        handleNoCamaraPermission();
                    }
                }
            }
        }
    }

    public void onResume() {
        LogUtil.i(Tag, "onResume()");
        super.onResume();
    }

    public void pauseCamera() {
        if (this.mAutoFocusCb != null) {
            this.mAutoFocusCb.a((Handler) null, ResUtils.id(getActivity(), "wallet_auto_focus"));
        }
        d dVar = this.mPreviewCb;
        if (dVar != null) {
            dVar.c();
            setFlashLightOn(false);
        }
    }

    public void processImage(byte[] bArr) {
        a availableDetector;
        if (!this.mDone.get() && 1 == this.mDetectorState.get() && (availableDetector = getAvailableDetector()) != null && this.mPreviewCb != null && !this.mDone.get()) {
            int[] iArr = this.mImageSize;
            availableDetector.a(bArr, iArr[0], iArr[1], this.mBmpDataRect);
            this.mThreadPool.a((Runnable) availableDetector);
            if (this.mIsCameraMalfunctioned.get()) {
                for (byte b2 : bArr) {
                    if (b2 != 0) {
                        this.mIsCameraMalfunctioned.compareAndSet(true, false);
                        Handler handler = this.mMiscEvtHandler;
                        if (handler != null) {
                            handler.removeCallbacksAndMessages((Object) null);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public abstract void relayoutUi();

    public void restartScan() {
        this.mDone.set(false);
        d dVar = this.mPreviewCb;
        if (dVar != null) {
            dVar.a(this.mPreviewView.getHolder());
            this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "wallet_auto_focus")).sendToTarget();
            return;
        }
        startScan();
    }

    public abstract void setFocusRectValue(Rect rect);

    public void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        this.mOnCameraChange = onCameraChangeListener;
    }

    public void setTop(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(getActivity())));
            ImmersiveStatusBarManager.setTopBar(getActivity(), view, isStatusbarTextColorBlack());
        }
    }

    public void stopCamera() {
        d dVar = this.mPreviewCb;
        if (dVar != null) {
            dVar.a(false);
            this.mPreviewCb = null;
        }
    }

    public void stopCountDown() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
            this.mInCaptureTimeOut.set(false);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        LogUtil.i(Tag, "surfaceChanged");
        int[] iArr = this.mScreeSize;
        iArr[0] = i3;
        iArr[1] = i4;
        this.mSurfaceHolder = surfaceHolder;
        if (PermissionManager.checkCallingPermission(getActivity(), "android.permission.CAMERA")) {
            startScan();
        } else if (this.mCanRequestCameraPermission) {
            this.mPermissionCallBack = BaiduWalletUtils.requestPermissionsDialog(this.fromLangbridge ? "wallet_langbridge" : "", getActivity(), new String[]{"android.permission.CAMERA"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        boolean unused = CameraBaseActivity.this.mCanRequestCameraPermission = false;
                        if (!PermissionManager.checkCallingOrSelfPermission(CameraBaseActivity.this.getActivity(), new String[]{"android.permission.CAMERA"}, CameraBaseActivity.REQUEST_PERMISSION_CAMERA)) {
                            CameraBaseActivity.this.handleNoCamaraPermission();
                        }
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        CameraBaseActivity.this.onRequestPermissionsResult(1, new String[]{"android.permission.CAMERA"}, new int[]{-1});
                    }
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        String str = Tag;
        LogUtil.i(str, "surfaceCreated()" + surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtil.i(Tag, "surfaceDestroyed");
        switchFlashOnMainThread(false);
        this.mSurfaceHolder = null;
        stopCamera();
    }

    public void switchCamera() {
        if (CameraCtrl.getInstance().isSupportMultiCamera()) {
            int i2 = this.cameraId;
            if (i2 == 0) {
                this.cameraId = 1;
            } else if (i2 == 1) {
                this.cameraId = 0;
            }
            restartScan();
        }
    }

    public void takePicture() {
        com.baidu.wallet.base.camera.internal.b d;
        try {
            LogUtil.d(Tag, "takePic");
            startCountDown();
            if (this.mPreviewCb != null && (d = this.mPreviewCb.d()) != null) {
                d.a(this.autoFocusCallback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takePictureWithoutAutoFocus(com.baidu.wallet.base.camera.internal.b bVar) {
        if (bVar != null) {
            this.mInCaptureProgresses = true;
            System.currentTimeMillis();
            try {
                bVar.a((Camera.ShutterCallback) null, (Camera.PictureCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0027, code lost:
                        r6 = r4.a;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onPictureTaken(byte[] r5, android.hardware.Camera r6) {
                        /*
                            r4 = this;
                            java.lang.String r6 = com.baidu.wallet.base.camera.CameraBaseActivity.Tag
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            r0.<init>()
                            java.lang.String r1 = "takepic callback Timeout = "
                            r0.append(r1)
                            com.baidu.wallet.base.camera.CameraBaseActivity r1 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            java.util.concurrent.atomic.AtomicBoolean r1 = r1.mInCaptureTimeOut
                            r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            com.baidu.wallet.core.utils.LogUtil.d(r6, r0)
                            com.baidu.wallet.base.camera.CameraBaseActivity r6 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            java.util.concurrent.atomic.AtomicBoolean r6 = r6.mInCaptureTimeOut
                            boolean r6 = r6.get()
                            r0 = 0
                            if (r6 != 0) goto L_0x0051
                            com.baidu.wallet.base.camera.CameraBaseActivity r6 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            com.baidu.wallet.base.camera.IImageProcess r1 = r6.mImageProcessor
                            if (r1 == 0) goto L_0x0051
                            int[] r6 = r6.mImageSize
                            r2 = r6[r0]
                            r3 = 1
                            r6 = r6[r3]
                            java.lang.Object[] r5 = r1.processImageJpegData(r5, r2, r6)
                            if (r5 == 0) goto L_0x005b
                            com.baidu.wallet.base.camera.CameraBaseActivity r6 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            java.util.concurrent.atomic.AtomicBoolean r6 = r6.mDone
                            boolean r6 = r6.compareAndSet(r0, r3)
                            if (r6 == 0) goto L_0x005b
                            com.baidu.wallet.base.camera.CameraBaseActivity r6 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            r6.pauseCamera()
                            com.baidu.wallet.base.camera.CameraBaseActivity r6 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            r6.onProcessImageOk(r5)
                            goto L_0x005b
                        L_0x0051:
                            com.baidu.wallet.base.camera.CameraBaseActivity r5 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            r5.pauseCamera()
                            com.baidu.wallet.base.camera.CameraBaseActivity r5 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            r5.restartScan()
                        L_0x005b:
                            com.baidu.wallet.base.camera.CameraBaseActivity r5 = com.baidu.wallet.base.camera.CameraBaseActivity.this
                            r5.mInCaptureProgresses = r0
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.camera.CameraBaseActivity.AnonymousClass6.onPictureTaken(byte[], android.hardware.Camera):void");
                    }
                });
            } catch (Throwable th2) {
                this.mInCaptureTimeOut.set(true);
                this.mInCaptureProgresses = false;
                DXMSdkSAUtils.onEventWithValues("sdk_self_define_take_picture_failed", Arrays.asList(new String[]{th2.getMessage()}));
            }
        }
    }

    public void triggerFlash() {
        setFlashLightOn(!isFlashOn());
    }

    public abstract void updateFlashLightUi(boolean z);

    public class a implements Runnable {
        public final String b = a.class.getSimpleName();
        public byte[] c;
        public byte[] d = null;
        public int e;
        public int f;
        public Rect g;
        public final AtomicBoolean h = new AtomicBoolean(false);

        public a() {
        }

        public void a(byte[] bArr, int i2, int i3, Rect rect) {
            this.c = bArr;
            this.e = i2;
            this.f = i3;
            this.g = rect;
            int recycledBufSize = CameraBaseActivity.this.mImageProcessor.getRecycledBufSize(rect.width(), rect.height());
            byte[] bArr2 = this.d;
            if (bArr2 == null || bArr2.length != recycledBufSize) {
                this.d = new byte[recycledBufSize];
            }
        }

        public void run() {
            if (CameraBaseActivity.this.mDone.get()) {
                this.h.set(false);
            } else if (!this.h.compareAndSet(false, true)) {
                LogUtil.e(this.b, "internal error", (Throwable) null);
            } else {
                Object[] processImage = CameraBaseActivity.this.mImageProcessor.processImage(this.c, this.e, this.f, this.g, this.d);
                if (processImage != null && CameraBaseActivity.this.mDone.compareAndSet(false, true)) {
                    CameraBaseActivity.this.pauseCamera();
                    CameraBaseActivity.this.onProcessImageOk(processImage);
                }
                this.h.set(false);
            }
        }

        public boolean a() {
            return this.h.get();
        }
    }
}
