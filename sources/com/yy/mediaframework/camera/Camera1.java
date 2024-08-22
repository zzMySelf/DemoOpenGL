package com.yy.mediaframework.camera;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.yy.mediaframework.UploadStreamStateParams;
import com.yy.mediaframework.camera.CameraConstants;
import com.yy.mediaframework.camera.util.Camera1Utils;
import com.yy.mediaframework.camera.util.CameraFrameUtils;
import com.yy.mediaframework.camera.util.Size;
import com.yy.mediaframework.capture.IYMFPreviewFrameCallback;
import com.yy.mediaframework.capture.Mp4CaptureSource;
import com.yy.mediaframework.extra.YYSeiData;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
import com.yy.mediaframework.stat.YMFLiveExceptionStat;
import com.yy.mediaframework.stat.YMFLiveExceptionType;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.TimeUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Camera1 implements ICamera {
    private static final int FOCUS_AREA_SIZE = 300;
    private static final int FOCUS_AREA_SIZE_VIVO = 300;
    private static final String TAG = "Camera1";
    private CountDownLatch barrierRef = null;
    public Camera.ErrorCallback errorCallback = new Camera.ErrorCallback() {
        public void onError(int error, Camera camera) {
            if (Camera1.this.mCameraCallback != null) {
                CameraCallback cameraCallback = (CameraCallback) Camera1.this.mCameraCallback.get();
                CameraCallback callback = cameraCallback;
                if (cameraCallback != null) {
                    callback.onError(false, error);
                }
            }
            if (error == 2) {
                YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_CAPTURE_USED_BY_HIGHER_PRIORITY);
            }
            YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_CAPTURE_ERROR);
        }
    };
    private boolean isFlashOn = false;
    private boolean mAutoFocus = false;
    private AutoFocusCallBack mAutoFocusCallback = new AutoFocusCallBack();
    private final AutoFocusListener mAutoFocusListener = new AutoFocusListener();
    /* access modifiers changed from: private */
    public WeakReference<CameraCallback> mCameraCallback = new WeakReference<>((Object) null);
    private int[] mCameraFpsRange = new int[2];
    private Camera mCameraInstance;
    private Camera.CameraInfo mCameraInstanceInfo;
    /* access modifiers changed from: private */
    public final Object mCameraLock = new Object();
    private Camera1PreviewCallbackHost mCameraPreviewCallbackHost = new Camera1PreviewCallbackHost(this);
    private WeakReference<SurfaceTexture[]> mCameraPreviewSurfaceTextures;
    private CameraConstants.CameraResolutionMode mCameraResMode;
    private Timer mCameraTimer;
    private Context mContext = null;
    /* access modifiers changed from: private */
    public RectF mCurrentFocusArea = null;
    /* access modifiers changed from: private */
    public String mDefaultMasterFocusMode;
    private int mDesiredFps = 0;
    private String mDeviceBrand;
    /* access modifiers changed from: private */
    public String mDeviceName;
    private int mDisplayOrientation = 0;
    /* access modifiers changed from: private */
    public boolean mEnableCaptureFpsControl = true;
    private boolean mEnablePCCameraToolMode = false;
    private float mExposureCompensation = 0.5f;
    public Camera.FaceDetectionListener mFaceDetectListener = new Camera.FaceDetectionListener() {
        public void onFaceDetection(Camera.Face[] faces, Camera camera) {
            for (Camera.Face face : faces) {
                RectF viewRect = new RectF(face.rect);
                YMFLog.debug((Object) this, "[CCapture]", "face1:" + viewRect.left + " " + viewRect.top + " " + viewRect.right + " " + viewRect.bottom);
                Camera1.this.mMatrixDriveToView.mapRect(viewRect);
                YMFLog.debug((Object) this, "[CCapture]", "face2:" + viewRect.left + " " + viewRect.top + " " + viewRect.right + " " + viewRect.bottom);
                if (Camera1.this.mFaceFocusEnable) {
                    RectF rect = new RectF(viewRect.left, viewRect.top, viewRect.right, viewRect.bottom);
                    if (Camera1.this.mCameraCallback != null) {
                        CameraCallback cameraCallback = (CameraCallback) Camera1.this.mCameraCallback.get();
                        CameraCallback callback = cameraCallback;
                        if (cameraCallback != null) {
                            RectF unused = Camera1.this.mCurrentFocusArea = rect;
                            callback.onCameraFocusAreaChanged(rect);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    };
    private boolean mFaceDetectSupported = false;
    /* access modifiers changed from: private */
    public boolean mFaceFocusEnable = false;
    private boolean mFaceFocusRestart = false;
    private int mFacing = 0;
    private int mFlash = 0;
    /* access modifiers changed from: private */
    public AtomicBoolean mFocusAndExposureModeLocked = new AtomicBoolean(false);
    private List<Camera.Area> mFocusArea;
    private boolean mFocusAreaSupported = false;
    private TimerTask mFocusTimerTask;
    /* access modifiers changed from: private */
    public WeakReference<Handler> mHandler = new WeakReference<>((Object) null);
    private boolean mIsAutoExposureLockSupported = false;
    private boolean mIsAutoFocusSupported = false;
    private boolean mIsAutoWhiteBalanceLockSupported = false;
    private AtomicBoolean mIsMasterCameraOpened = new AtomicBoolean(false);
    private boolean mIsTorchSupported = false;
    private boolean mIsZoomSupported = false;
    private Matrix mMatrix;
    /* access modifiers changed from: private */
    public Matrix mMatrixDriveToView;
    private float mMaxZoom = 1.0f;
    private List<Camera.Area> mMeteringArea;
    private boolean mMeteringAreaSupported = false;
    private TimerTask mMeteringTimerTask;
    private boolean mMirror = false;
    private WeakReference<SurfaceTexture.OnFrameAvailableListener> mPreviewFrameAvailableListenerRef;
    private int mPreviewHeight;
    private List<Camera.Size> mPreviewSizes = null;
    private int mPreviewWidth;
    private float mResumeZoomValue = 1.0f;
    private int mRotation = 90;
    private boolean mSurfaceTextureAttached = false;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private int maxExposureCompensation = 0;
    private int minExposureCompensation = 0;
    private WeakReference<byte[]> previewCallbackBuffer;

    Camera1(Context context, Handler handler) {
        this.mContext = context.getApplicationContext();
        this.mCameraInstanceInfo = new Camera.CameraInfo();
        this.mMatrix = new Matrix();
        this.mMatrixDriveToView = new Matrix();
        this.mDeviceName = Build.MODEL.toLowerCase();
        this.mDeviceBrand = Build.BRAND.toLowerCase();
        this.mHandler = new WeakReference<>(handler);
    }

    public int openCamera() {
        WeakReference<CameraCallback> weakReference;
        WeakReference<CameraCallback> weakReference2;
        if (this.mCameraInstance != null) {
            stopCamera();
        }
        YMFLog.info(this, "[CCapture]", "openCamera...");
        this.mFocusAndExposureModeLocked.set(false);
        this.mExposureCompensation = 0.5f;
        Camera doOpenCamera = doOpenCamera();
        this.mCameraInstance = doOpenCamera;
        if (doOpenCamera == null || !isHasPermission(doOpenCamera)) {
            if (this.mCameraInstance != null) {
                stopCamera();
            }
            this.mIsMasterCameraOpened.set(false);
            if (!(this.mCameraInstance == null || (weakReference = this.mCameraCallback) == null)) {
                CameraCallback cameraCallback = (CameraCallback) weakReference.get();
                CameraCallback callback = cameraCallback;
                if (cameraCallback != null) {
                    callback.onError(false, 4);
                }
            }
            return 4;
        }
        this.mIsMasterCameraOpened.set(true);
        setPreviewCallbackWithBuffer(this.mCameraPreviewCallbackHost);
        this.mDefaultMasterFocusMode = this.mCameraInstance.getParameters().getFocusMode();
        setCameraZoom(this.mCameraInstance, (float) ((int) this.mResumeZoomValue));
        YMFLog.info(this, "[CCapture]", "openCamera:" + this.mDefaultMasterFocusMode + " mResumeZoomValue " + this.mResumeZoomValue);
        if (!(this.mCameraInstance == null || (weakReference2 = this.mCameraCallback) == null)) {
            CameraCallback cameraCallback2 = (CameraCallback) weakReference2.get();
            CameraCallback callback2 = cameraCallback2;
            if (cameraCallback2 != null) {
                callback2.onCameraOpened(this.mPreviewWidth, this.mPreviewHeight, this.mFacing, this.mCameraResMode, this.mDisplayOrientation, false);
            }
        }
        return 0;
    }

    public void stopCamera() {
        Timer timer = this.mCameraTimer;
        if (timer != null) {
            timer.cancel();
            this.mCameraTimer = null;
        }
        TimerTask timerTask = this.mMeteringTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mMeteringTimerTask = null;
        }
        TimerTask timerTask2 = this.mFocusTimerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
            this.mFocusTimerTask = null;
        }
        this.isFlashOn = false;
        Camera camera = this.mCameraInstance;
        if (camera != null) {
            try {
                camera.stopPreview();
                this.mCameraInstance.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                Camera1Utils.setCameraBufferHashCode(0);
                this.mCameraInstance.release();
                this.mCameraInstance = null;
                this.mSurfaceTextureAttached = false;
                WeakReference<CameraCallback> weakReference = this.mCameraCallback;
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((CameraCallback) this.mCameraCallback.get()).onCameraClosed();
                }
                YMFLog.info(this, "[CCapture]", "releaseCamera done " + this.mSurfaceTextureAttached);
            } catch (Throwable throwable) {
                YMFLog.error((Object) this, "[CCapture]", "closeCameraInner exception:" + throwable);
            }
            this.mCameraInstance = null;
        }
    }

    public void reset() {
        YMFLog.info(this, "[CCapture]", "reset.");
        this.mResumeZoomValue = 1.0f;
        this.mCameraPreviewCallbackHost.reset();
    }

    public int restartCamera() {
        this.mFaceFocusEnable = false;
        stopCamera();
        openCamera();
        return 0;
    }

    public void changeCameraCaptureParameter(int width, int height, int fps, int cameraFacing, int displayOrientation, CameraConstants.CameraResolutionMode resMode) {
        if (getCameraFacing() != cameraFacing || getPreviewSize().getWidth() != width || getPreviewSize().getHeight() != height || getCaptureFps() != fps || getDisplayOrientation() != displayOrientation || getCameraResMode() != resMode) {
            stopCamera();
            setPreviewSize(new Size(width, height));
            setCameraFacing(cameraFacing);
            setCameraResMode(resMode);
            setDisplayOrientation(displayOrientation);
            if (!this.mEnablePCCameraToolMode) {
                setCaptureFps(fps + 2);
            } else {
                setCaptureFps(fps);
            }
            openCamera();
        }
    }

    public boolean isCameraOpened() {
        return this.mCameraInstance != null;
    }

    public void setCameraFacing(int facing) {
        YMFLog.info(TAG, "[CCapture]", "setCameraFacing:" + facing);
        this.mFacing = facing;
    }

    public void switchCamera() {
        if (isCameraOpened()) {
            stopCamera();
            int i2 = this.mFacing;
            if (i2 == 1) {
                this.mFacing = 0;
            } else if (i2 == 0) {
                this.mFacing = 1;
            }
            this.mFaceFocusEnable = false;
            YMFLog.info(TAG, "[CCapture]", "switchCamera to CameraFacing:" + (this.mFacing == 0 ? "Front" : "Back"));
            openCamera();
        }
    }

    public int getCameraFacing() {
        return this.mFacing;
    }

    public void setAutoFocus(boolean autoFocusOn) {
        if (this.mFocusAreaSupported && this.mCameraInstance != null && isCameraOpened()) {
            if (autoFocusOn) {
                try {
                    this.mCameraInstance.autoFocus(this.mAutoFocusCallback);
                    this.mAutoFocus = true;
                } catch (Exception e2) {
                    YMFLog.error((Object) this, "[CCapture]", "auto focus error!");
                }
            } else {
                this.mCameraInstance.autoFocus((Camera.AutoFocusCallback) null);
                this.mAutoFocus = false;
            }
        }
    }

    public boolean isAutoFocusOn() {
        return this.mAutoFocus;
    }

    public void setFlash(int flash) {
    }

    public int getFlash() {
        return this.isFlashOn ? 1 : 0;
    }

    public void setSurfaceTextureToCamera(CameraSurfaceTexture cameraSurfaceTexture) {
        if (this.mCameraInstance == null || this.mSurfaceTextureAttached) {
            YMFLog.error((Object) this, "[CCapture]", "camera not available, should openCamera first or is preview:" + this.mSurfaceTextureAttached + " cameraSurfaceTexture " + cameraSurfaceTexture);
        } else if (cameraSurfaceTexture != null) {
            SurfaceTexture[] surfaces = cameraSurfaceTexture.surfaces;
            SurfaceTexture.OnFrameAvailableListener listener = cameraSurfaceTexture.listener;
            if (surfaces != null) {
                YMFLog.info(this, "[CCapture]", "setSurfaceTextureToCamera surfaces[0]:" + surfaces[0]);
                setCameraPreviewTexture(this.mCameraInstance, surfaces[0], cameraSurfaceTexture.listener);
                this.mCameraPreviewSurfaceTextures = new WeakReference<>(surfaces);
            }
            if (listener != null) {
                this.mPreviewFrameAvailableListenerRef = new WeakReference<>(listener);
            }
            this.mSurfaceTextureAttached = true;
        } else {
            this.mCameraPreviewSurfaceTextures = null;
            this.mPreviewFrameAvailableListenerRef = null;
        }
    }

    private void setCameraPreviewTexture(Camera camera, SurfaceTexture surfaces, SurfaceTexture.OnFrameAvailableListener listener) {
        if (camera == null) {
            try {
                YMFLog.error((Object) this, "[CCapture]", "camera not available, should openCamera first!");
            } catch (Throwable throwable) {
                YMFLog.error((Object) this, "[CCapture]", "setCameraPreviewTexture exception:" + throwable.toString());
            }
        } else {
            surfaces.setOnFrameAvailableListener(listener);
            camera.setPreviewTexture(surfaces);
            camera.startPreview();
            if (this.mFaceFocusEnable) {
                setCameraAutoFocusFaceMode(true);
            }
        }
    }

    public void addCallbackBuffer(byte[] callbackBuffer) {
        if (callbackBuffer == null) {
            YMFLog.error((Object) this, "[CCapture]", "invalid callbackBuffer");
            return;
        }
        this.previewCallbackBuffer = new WeakReference<>(callbackBuffer);
        if (callbackBuffer.length == 0 || callbackBuffer.length != getCurrentPreviewBufferSize()) {
            YMFLog.error((Object) this, "[CCapture]", "invalid callbackBuffer");
            return;
        }
        Camera1Utils.setCameraBufferHashCode((long) callbackBuffer.hashCode());
        this.mCameraInstance.addCallbackBuffer(callbackBuffer);
    }

    public int getCurrentPreviewBufferSize() {
        synchronized (this.mCameraLock) {
            if (this.mCameraInstance == null) {
                return 0;
            }
            int bitsPerPixel = ((this.mPreviewWidth * this.mPreviewHeight) * ImageFormat.getBitsPerPixel(17)) / 8;
            return bitsPerPixel;
        }
    }

    private void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        if (this.mCameraInstance == null) {
            YMFLog.error((Object) this, "[CCapture]", "invalid camera.");
            return;
        }
        int buffSize = ((this.mPreviewWidth * this.mPreviewHeight) * ImageFormat.getBitsPerPixel(17)) / 8;
        for (int i2 = 0; i2 < 3; i2++) {
            byte[] buffer = new byte[buffSize];
            this.mCameraInstance.addCallbackBuffer(buffer);
            Camera1Utils.setCameraBufferHashCode((long) buffer.hashCode());
        }
        this.mCameraInstance.setPreviewCallbackWithBuffer(previewCallback);
    }

    public void setCameraResMode(CameraConstants.CameraResolutionMode cameraResMode) {
        if (cameraResMode != null) {
            YMFLog.info(this, "[CCapture]", "setCameraResMode " + cameraResMode.ordinal());
            this.mCameraResMode = cameraResMode;
        }
    }

    public CameraConstants.CameraResolutionMode getCameraResMode() {
        return this.mCameraResMode;
    }

    public void setDisplayOrientation(int displayDisplayOrientation) {
        YMFLog.info(this, "[CCapture]", "setDisplayOrientation " + displayDisplayOrientation);
        this.mDisplayOrientation = displayDisplayOrientation;
    }

    public int getDisplayOrientation() {
        return this.mDisplayOrientation;
    }

    public Size getPreviewSize() {
        return new Size(this.mPreviewWidth, this.mPreviewHeight);
    }

    public void setPreviewSize(Size size) {
        this.mPreviewWidth = size.getWidth();
        this.mPreviewHeight = size.getHeight();
    }

    public void setCaptureFps(int captureTargetFps) {
        YMFLog.info(this, "[CCapture]", "setCaptureTargetFps:" + captureTargetFps);
        this.mDesiredFps = captureTargetFps;
        this.mEnableCaptureFpsControl = true;
        this.mCameraPreviewCallbackHost.setTargetFps(captureTargetFps);
    }

    public int getCaptureFps() {
        return this.mDesiredFps;
    }

    public void setCameraStateCallback(CameraCallback callback) {
        YMFLog.info(this, "[CCapture]", " setCameraStateCallbackAsync:" + callback);
        this.mCameraCallback = new WeakReference<>(callback);
    }

    public void setSurfaceViewSize(int viewWidth, int viewHeight) {
        YMFLog.info(this, "[CCapture]", "setSurfaceViewSize width:" + viewWidth + " height:" + viewHeight);
        if (this.mSurfaceViewWidth != viewWidth || this.mSurfaceViewHeight != viewHeight) {
            this.mSurfaceViewWidth = viewWidth;
            this.mSurfaceViewHeight = viewHeight;
            setMatrix();
        }
    }

    public float getCurrentZoom() {
        if (this.mCameraInstance != null) {
            return this.mResumeZoomValue;
        }
        return -1.0f;
    }

    private float getMaxZoomInternal(Camera camera) {
        if (camera == null) {
            YMFLog.error((Object) this, "[CCapture]", "camera is null");
            return -1.0f;
        }
        try {
            Camera.Parameters param = camera.getParameters();
            if (param != null) {
                int maxZoom = param.getMaxZoom();
                List<Integer> zoomRatios = param.getZoomRatios();
                if (zoomRatios != null && !zoomRatios.isEmpty() && maxZoom == zoomRatios.size() - 1) {
                    YMFLog.info(this, "[CCapture]", "getMaxZoom:" + maxZoom + "， maxZoomRatio:" + zoomRatios.get(zoomRatios.size() - 1));
                    float ret = ((float) zoomRatios.get(maxZoom).intValue()) / 100.0f;
                    if ((this.mDeviceBrand.contains("oppo") || this.mDeviceBrand.contains("vivo")) && ret > 5.0f) {
                        return 5.0f;
                    }
                    return ret;
                }
            }
        } catch (Throwable throwable) {
            YMFLog.error((Object) this, "[CCapture]", "getMaxZoom exceptiion:" + throwable);
        }
        return -1.0f;
    }

    public float getMaxZoom() {
        if (this.mCameraInstance != null) {
            return this.mMaxZoom;
        }
        return -1.0f;
    }

    private boolean isZoomSupport(Camera camera) {
        if (camera == null) {
            YMFLog.error((Object) this, "[CCapture]", "camera is null");
            return false;
        }
        try {
            Camera.Parameters param = camera.getParameters();
            if (param != null && param.isZoomSupported()) {
                List<Integer> ratios = param.getZoomRatios();
                boolean isZoomSupport = true;
                if (ratios == null || ratios.isEmpty() || ratios.size() != param.getMaxZoom() + 1) {
                    isZoomSupport = false;
                }
                YMFLog.info(this, "[CCapture]", "isZoomSupport:" + isZoomSupport + ", getZoomRatios:" + ratios);
                return isZoomSupport;
            }
        } catch (Throwable throwable) {
            YMFLog.error((Object) this, "[CCapture]", "isZoomSupport exception:" + throwable);
        }
        return false;
    }

    public float setZoom(float zoom) {
        float cameraZoom;
        synchronized (this.mCameraLock) {
            cameraZoom = setCameraZoom(this.mCameraInstance, zoom);
            this.mResumeZoomValue = cameraZoom;
        }
        return cameraZoom;
    }

    public int setCameraConfigParam(String key, String value) {
        return 0;
    }

    private Camera.CameraInfo getCameraInfo() {
        return this.mCameraInstanceInfo;
    }

    private void checkCameraSupportFeature(Camera.Parameters parms) {
        this.mFocusAreaSupported = Camera1Utils.isFocusAreaSupported(parms);
        this.mMeteringAreaSupported = Camera1Utils.isMeteringAreaSupported(parms);
        this.mFaceDetectSupported = Camera1Utils.isFaceDetectionSupported(parms);
        YMFLog.info(this, "[CCapture]", "mFocusAreaSupported" + this.mFocusAreaSupported + " mMeteringAreaSupported " + this.mMeteringAreaSupported + "mFaceDetectSupported" + this.mFaceDetectSupported);
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x020b A[Catch:{ all -> 0x013e, all -> 0x0222 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x020c A[Catch:{ all -> 0x013e, all -> 0x0222 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera doOpenCamera() {
        /*
            r15 = this;
            java.lang.String r0 = "auto"
            java.lang.String r1 = "continuous-video"
            java.lang.String r2 = ", height:"
            java.lang.String r3 = "[CCapture]"
            r4 = 0
            java.util.Timer r5 = r15.mCameraTimer
            if (r5 != 0) goto L_0x0014
            java.util.Timer r5 = new java.util.Timer
            r5.<init>()
            r15.mCameraTimer = r5
        L_0x0014:
            int r5 = r15.mFacing     // Catch:{ all -> 0x0222 }
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L_0x001c
            r5 = r6
            goto L_0x001d
        L_0x001c:
            r5 = r7
        L_0x001d:
            boolean r5 = com.yy.mediaframework.camera.util.Camera1Utils.isCameraAvailable(r5)     // Catch:{ all -> 0x0222 }
            if (r5 != 0) goto L_0x0031
            java.lang.String r5 = "current facing camera not available, change facing camera."
            com.yy.mediaframework.utils.YMFLog.info(r15, r3, r5)     // Catch:{ all -> 0x0222 }
            int r5 = r15.mFacing     // Catch:{ all -> 0x0222 }
            if (r5 != 0) goto L_0x002e
            r5 = r6
            goto L_0x002f
        L_0x002e:
            r5 = r7
        L_0x002f:
            r15.mFacing = r5     // Catch:{ all -> 0x0222 }
        L_0x0031:
            int r5 = r15.mFacing     // Catch:{ all -> 0x0222 }
            android.hardware.Camera$CameraInfo r8 = r15.mCameraInstanceInfo     // Catch:{ all -> 0x0222 }
            android.hardware.Camera r5 = r15.openCamera(r5, r8)     // Catch:{ all -> 0x0222 }
            r4 = r5
            if (r4 != 0) goto L_0x0043
            java.lang.String r0 = "Unable to open camera"
            com.yy.mediaframework.utils.YMFLog.error((java.lang.Object) r15, (java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0222 }
            r0 = 0
            return r0
        L_0x0043:
            android.hardware.Camera$Parameters r5 = r4.getParameters()     // Catch:{ all -> 0x0222 }
            int r8 = r15.mDisplayOrientation     // Catch:{ all -> 0x0222 }
            int r9 = r15.mPreviewWidth     // Catch:{ all -> 0x0222 }
            int r10 = r15.mPreviewHeight     // Catch:{ all -> 0x0222 }
            r12 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            com.yy.mediaframework.camera.CameraConstants$CameraResolutionMode r14 = r15.mCameraResMode     // Catch:{ all -> 0x0222 }
            r11 = r5
            com.yy.mediaframework.camera.util.Camera1Utils.chooseBestAspectPreviewSize(r8, r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0222 }
            android.hardware.Camera$Size r8 = r5.getPreviewSize()     // Catch:{ all -> 0x0222 }
            int r8 = r8.width     // Catch:{ all -> 0x0222 }
            r15.mPreviewWidth = r8     // Catch:{ all -> 0x0222 }
            android.hardware.Camera$Size r8 = r5.getPreviewSize()     // Catch:{ all -> 0x0222 }
            int r8 = r8.height     // Catch:{ all -> 0x0222 }
            r15.mPreviewHeight = r8     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
            r8.<init>()     // Catch:{ all -> 0x0222 }
            java.lang.String r9 = "chooseBestAspectPreviewSize width:"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x0222 }
            int r9 = r15.mPreviewWidth     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x0222 }
            int r9 = r15.mPreviewHeight     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x0222 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0222 }
            com.yy.mediaframework.utils.YMFLog.info(r15, r3, r8)     // Catch:{ all -> 0x0222 }
            java.util.List r8 = r5.getSupportedPreviewSizes()     // Catch:{ all -> 0x0222 }
            r15.mPreviewSizes = r8     // Catch:{ all -> 0x0222 }
            java.util.List r8 = r5.getSupportedFocusModes()     // Catch:{ all -> 0x0222 }
            boolean r9 = r8.contains(r1)     // Catch:{ all -> 0x0222 }
            if (r9 == 0) goto L_0x00a0
            r5.setFocusMode(r1)     // Catch:{ all -> 0x0222 }
            r15.mIsAutoFocusSupported = r6     // Catch:{ all -> 0x0222 }
            goto L_0x00ae
        L_0x00a0:
            boolean r1 = r8.contains(r0)     // Catch:{ all -> 0x0222 }
            if (r1 == 0) goto L_0x00ac
            r5.setFocusMode(r0)     // Catch:{ all -> 0x0222 }
            r15.mIsAutoFocusSupported = r6     // Catch:{ all -> 0x0222 }
            goto L_0x00ae
        L_0x00ac:
            r15.mIsAutoFocusSupported = r7     // Catch:{ all -> 0x0222 }
        L_0x00ae:
            boolean r0 = r5.isAutoWhiteBalanceLockSupported()     // Catch:{ all -> 0x0222 }
            if (r0 == 0) goto L_0x00ba
            r5.setAutoWhiteBalanceLock(r7)     // Catch:{ all -> 0x0222 }
            r15.mIsAutoWhiteBalanceLockSupported = r6     // Catch:{ all -> 0x0222 }
            goto L_0x00bc
        L_0x00ba:
            r15.mIsAutoWhiteBalanceLockSupported = r7     // Catch:{ all -> 0x0222 }
        L_0x00bc:
            boolean r0 = r5.isAutoExposureLockSupported()     // Catch:{ all -> 0x0222 }
            if (r0 == 0) goto L_0x00c8
            r5.setAutoExposureLock(r7)     // Catch:{ all -> 0x0222 }
            r15.mIsAutoExposureLockSupported = r6     // Catch:{ all -> 0x0222 }
            goto L_0x00ca
        L_0x00c8:
            r15.mIsAutoExposureLockSupported = r7     // Catch:{ all -> 0x0222 }
        L_0x00ca:
            boolean r0 = com.yy.mediaframework.camera.util.Camera1Utils.isTorchSupported(r5)     // Catch:{ all -> 0x0222 }
            r15.mIsTorchSupported = r0     // Catch:{ all -> 0x0222 }
            boolean r0 = r15.isZoomSupport(r4)     // Catch:{ all -> 0x0222 }
            r15.mIsZoomSupported = r0     // Catch:{ all -> 0x0222 }
            if (r0 == 0) goto L_0x00de
            float r0 = r15.getMaxZoomInternal(r4)     // Catch:{ all -> 0x0222 }
            r15.mMaxZoom = r0     // Catch:{ all -> 0x0222 }
        L_0x00de:
            int r0 = r5.getMaxExposureCompensation()     // Catch:{ all -> 0x0222 }
            r15.maxExposureCompensation = r0     // Catch:{ all -> 0x0222 }
            int r0 = r5.getMinExposureCompensation()     // Catch:{ all -> 0x0222 }
            r15.minExposureCompensation = r0     // Catch:{ all -> 0x0222 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0222 }
            r1 = 15
            if (r0 < r1) goto L_0x00f9
            boolean r0 = r5.isVideoStabilizationSupported()     // Catch:{ all -> 0x0222 }
            if (r0 == 0) goto L_0x00f9
            r5.setVideoStabilization(r6)     // Catch:{ all -> 0x0222 }
        L_0x00f9:
            r15.checkCameraSupportFeature(r5)     // Catch:{ all -> 0x0222 }
            boolean r0 = r15.mEnablePCCameraToolMode     // Catch:{ all -> 0x0222 }
            if (r0 == 0) goto L_0x015e
            com.yy.mediaframework.Constant$CaptureFpsMode r0 = com.yy.mediaframework.UploadStreamStateParams.mCaptureFpsMode     // Catch:{ all -> 0x0222 }
            com.yy.mediaframework.Constant$CaptureFpsMode r1 = com.yy.mediaframework.Constant.CaptureFpsMode.StrictMode     // Catch:{ all -> 0x0222 }
            if (r0 != r1) goto L_0x015e
            boolean r0 = r15.isFoundPrefectMatchFPSRange(r5)     // Catch:{ all -> 0x0222 }
            if (r0 == 0) goto L_0x015e
            int r0 = r15.mDesiredFps     // Catch:{ all -> 0x013e }
            int r1 = r0 * 1000
            int r0 = r0 * 1000
            r5.setPreviewFpsRange(r1, r0)     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            r0.<init>()     // Catch:{ all -> 0x013e }
            java.lang.String r1 = "set PreviewFpsRange:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x013e }
            int r1 = r15.mDesiredFps     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x013e }
            java.lang.String r1 = "-"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x013e }
            int r1 = r15.mDesiredFps     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x013e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x013e }
            com.yy.mediaframework.utils.YMFLog.info(r15, r3, r0)     // Catch:{ all -> 0x013e }
            r4.setParameters(r5)     // Catch:{ all -> 0x013e }
            goto L_0x015d
        L_0x013e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
            r1.<init>()     // Catch:{ all -> 0x0222 }
            java.lang.String r9 = "set fps range exception:"
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch:{ all -> 0x0222 }
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch:{ all -> 0x0222 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0222 }
            com.yy.mediaframework.utils.YMFLog.info(r15, r3, r1)     // Catch:{ all -> 0x0222 }
            r15.setPreviewFpsRangeFps(r4, r5)     // Catch:{ all -> 0x0222 }
        L_0x015d:
            goto L_0x0161
        L_0x015e:
            r15.setPreviewFpsRangeFps(r4, r5)     // Catch:{ all -> 0x0222 }
        L_0x0161:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
            r0.<init>()     // Catch:{ all -> 0x0222 }
            java.lang.String r1 = "getPreviewSize width:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            int r1 = r15.mPreviewWidth     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0222 }
            int r1 = r15.mPreviewHeight     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0222 }
            com.yy.mediaframework.utils.YMFLog.info(r15, r3, r0)     // Catch:{ all -> 0x0222 }
            int r0 = r15.mDisplayOrientation     // Catch:{ all -> 0x0222 }
            if (r0 == 0) goto L_0x01a5
            r1 = 180(0xb4, float:2.52E-43)
            if (r0 != r1) goto L_0x018c
            goto L_0x01a5
        L_0x018c:
            r1 = 90
            if (r0 == r1) goto L_0x0194
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L_0x01b5
        L_0x0194:
            int r0 = r15.mPreviewWidth     // Catch:{ all -> 0x0222 }
            int r1 = r15.mPreviewHeight     // Catch:{ all -> 0x0222 }
            if (r0 >= r1) goto L_0x01b5
            int r1 = r1 + r0
            r15.mPreviewHeight = r1     // Catch:{ all -> 0x0222 }
            int r0 = r1 - r0
            r15.mPreviewWidth = r0     // Catch:{ all -> 0x0222 }
            int r1 = r1 - r0
            r15.mPreviewHeight = r1     // Catch:{ all -> 0x0222 }
            goto L_0x01b5
        L_0x01a5:
            int r0 = r15.mPreviewWidth     // Catch:{ all -> 0x0222 }
            int r1 = r15.mPreviewHeight     // Catch:{ all -> 0x0222 }
            if (r0 <= r1) goto L_0x01b5
            int r1 = r1 + r0
            r15.mPreviewHeight = r1     // Catch:{ all -> 0x0222 }
            int r0 = r1 - r0
            r15.mPreviewWidth = r0     // Catch:{ all -> 0x0222 }
            int r1 = r1 - r0
            r15.mPreviewHeight = r1     // Catch:{ all -> 0x0222 }
        L_0x01b5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
            r0.<init>()     // Catch:{ all -> 0x0222 }
            java.lang.String r1 = "openCamera width:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            int r1 = r15.mPreviewWidth     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0222 }
            int r1 = r15.mPreviewHeight     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            java.lang.String r1 = ", displayRotation:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            int r1 = r15.mDisplayOrientation     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0222 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0222 }
            com.yy.mediaframework.utils.YMFLog.info(r15, r3, r0)     // Catch:{ all -> 0x0222 }
            java.util.List r0 = r5.getSupportedPreviewFormats()     // Catch:{ all -> 0x0222 }
            r1 = 17
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0222 }
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0222 }
            if (r2 == 0) goto L_0x01fd
            int r2 = r5.getPreviewFormat()     // Catch:{ all -> 0x0222 }
            if (r2 == r1) goto L_0x01fd
            r5.setPreviewFormat(r1)     // Catch:{ all -> 0x0222 }
        L_0x01fd:
            r4.setParameters(r5)     // Catch:{ all -> 0x0222 }
            int r1 = r15.mDisplayOrientation     // Catch:{ all -> 0x0222 }
            android.hardware.Camera$CameraInfo r2 = r15.mCameraInstanceInfo     // Catch:{ all -> 0x0222 }
            r15.setCameraDisplayOrientation(r1, r4, r2)     // Catch:{ all -> 0x0222 }
            int r1 = r15.mFacing     // Catch:{ all -> 0x0222 }
            if (r1 != 0) goto L_0x020c
            goto L_0x020d
        L_0x020c:
            r6 = r7
        L_0x020d:
            r15.mMirror = r6     // Catch:{ all -> 0x0222 }
            r15.setMirror(r6)     // Catch:{ all -> 0x0222 }
            android.hardware.Camera$ErrorCallback r1 = r15.errorCallback     // Catch:{ all -> 0x0222 }
            r4.setErrorCallback(r1)     // Catch:{ all -> 0x0222 }
            android.hardware.Camera$Parameters r1 = r4.getParameters()     // Catch:{ all -> 0x0222 }
            java.lang.String r2 = r1.getFocusMode()     // Catch:{ all -> 0x0222 }
            r15.mDefaultMasterFocusMode = r2     // Catch:{ all -> 0x0222 }
            goto L_0x023b
        L_0x0222:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "openCamera exception:"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.yy.mediaframework.utils.YMFLog.error((java.lang.Object) r15, (java.lang.String) r3, (java.lang.String) r1)
            r4 = 0
        L_0x023b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.mediaframework.camera.Camera1.doOpenCamera():android.hardware.Camera");
    }

    private boolean isFoundPrefectMatchFPSRange(Camera.Parameters parms) {
        if (this.mDesiredFps <= 0) {
            return false;
        }
        boolean isFoundMatchFps = false;
        List<int[]> supportedPreviewFpsRange = parms.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            int i2 = 0;
            while (true) {
                if (i2 >= supportedPreviewFpsRange.size()) {
                    break;
                }
                int[] range = supportedPreviewFpsRange.get(i2);
                if (range != null && range.length > 0 && 1 < range.length) {
                    YMFLog.info(this, "[CCapture]", "getSupportedPreviewFpsRange: index=" + i2 + ", support min fps=" + range[0] + ", support max fps=" + range[1]);
                    int i3 = range[0];
                    int i4 = this.mDesiredFps;
                    if (i3 == i4 * 1000 && range[1] == i4 * 1000) {
                        isFoundMatchFps = true;
                        YMFLog.info(this, "[CCapture]", "Found perfect matched FPS range, desired FPS: " + this.mDesiredFps);
                        break;
                    }
                }
                i2++;
            }
            if (!isFoundMatchFps) {
                YMFLog.error((Object) this, "[CCapture]", "Can NOT found perfect matched FPS range, desired FPS: " + this.mDesiredFps);
            }
        }
        return isFoundMatchFps;
    }

    private void setPreviewFpsRangeFps(Camera camera, Camera.Parameters parms) {
        int i2;
        parms.getPreviewFpsRange(this.mCameraFpsRange);
        YMFLog.info(this, "[CCapture]", "get PreviewFpsRange:" + (this.mCameraFpsRange[0] / 1000) + "-" + (this.mCameraFpsRange[1] / 1000));
        int[] iArr = this.mCameraFpsRange;
        int i3 = iArr[0];
        int i4 = this.mDesiredFps;
        if (i3 <= i4 * 1000 && (i2 = iArr[1]) >= i4 * 1000) {
            try {
                parms.setPreviewFpsRange(i3, i2);
                YMFLog.info(this, "[CCapture]", "set PreviewFpsRange:" + (this.mCameraFpsRange[0] / 1000) + "-" + (this.mCameraFpsRange[1] / 1000));
                camera.setParameters(parms);
            } catch (Throwable throwable) {
                YMFLog.info(this, "[CCapture]", "set fps range exception:" + throwable.toString());
                int[] iArr2 = this.mCameraFpsRange;
                parms.setPreviewFpsRange(iArr2[0], iArr2[1]);
                YMFLog.info(this, "[CCapture]", "set PreviewFpsRange:" + (this.mCameraFpsRange[0] / 1000) + "-" + (this.mCameraFpsRange[1] / 1000));
            }
        }
    }

    private void setMirror(boolean mirror) {
        this.mMirror = mirror;
        setMatrix();
    }

    private Camera openCamera(int cameraFacing, Camera.CameraInfo info) {
        if (info == null) {
            info = new Camera.CameraInfo();
        }
        Camera camera = null;
        try {
            int numCameras = Camera.getNumberOfCameras();
            int i2 = 0;
            while (true) {
                if (i2 >= numCameras) {
                    break;
                }
                Camera.getCameraInfo(i2, info);
                if (cameraFacing == 0) {
                    if (info.facing == 1) {
                        camera = Camera.open(i2);
                        break;
                    }
                } else if (info.facing == 0) {
                    camera = Camera.open(i2);
                    break;
                }
                i2++;
            }
            if (camera != null) {
                return camera;
            }
            Log.d(TAG, "No front-facing camera found; opening default");
            return Camera.open();
        } catch (Throwable throwable) {
            YMFLog.error((Object) null, "[CCapture]", "openCamera exception:" + throwable);
            return null;
        }
    }

    private void setCameraDisplayOrientation(int displayRotation, Camera camera, Camera.CameraInfo cameraInfo) {
        if (camera != null) {
            int result = 90;
            if (cameraInfo != null) {
                if (cameraInfo.facing == 1) {
                    result = (360 - ((cameraInfo.orientation + displayRotation) % 360)) % 360;
                } else {
                    result = ((cameraInfo.orientation - displayRotation) + 360) % 360;
                }
                YMFLog.info((Object) null, "[CCapture]", "setDisplayOrientation:" + displayRotation + " Rotation:" + result + " sensorOrientation:" + cameraInfo.orientation);
            } else {
                YMFLog.error((Object) null, "[CCapture]", "setCameraDisplayOrientation cameraInfo null");
            }
            camera.setDisplayOrientation(result);
            setRotation(result);
        }
    }

    public void setRotation(int result) {
        YMFLog.info(this, "[Render  ]", "setRotation:" + result);
        this.mRotation = result;
    }

    public int getRotation() {
        return this.mRotation;
    }

    private void setMatrix() {
        if (this.mSurfaceViewWidth != 0 && this.mSurfaceViewHeight != 0) {
            Matrix matrix = new Matrix();
            Camera1Utils.prepareMatrix(matrix, this.mMirror, this.mRotation, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            this.mMatrixDriveToView = matrix;
            matrix.invert(this.mMatrix);
        }
    }

    public boolean isCameraManualFocusPositionSupported() {
        return this.mFocusAreaSupported;
    }

    public boolean isCameraManualExposurePositionSupported() {
        return this.mMeteringAreaSupported;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.mFaceDetectSupported;
    }

    public int setCameraAutoFocusFaceMode(boolean enable) {
        this.mFocusAndExposureModeLocked.set(false);
        Camera camera = this.mCameraInstance;
        if (camera == null) {
            return -1;
        }
        try {
            if (isCameraAutoFocusFaceModeSupported()) {
                if (!enable) {
                    camera.setFaceDetectionListener((Camera.FaceDetectionListener) null);
                    camera.stopFaceDetection();
                    this.mFaceFocusEnable = false;
                } else {
                    this.mCurrentFocusArea = null;
                    camera.setFaceDetectionListener(this.mFaceDetectListener);
                    camera.startFaceDetection();
                    this.mFaceFocusEnable = true;
                }
            }
            return 0;
        } catch (Exception e2) {
            YMFLog.error((Object) TAG, "[CCapture]", "setCameraAutoFocusFaceMode," + e2.toString());
            this.mFaceFocusEnable = false;
            return -1;
        }
    }

    public boolean isZoomSupport() {
        return this.mIsZoomSupported;
    }

    private float setCameraZoom(Camera camera, float _zoom) {
        List<Integer> zoomRatios;
        if (camera == null) {
            YMFLog.error((Object) this, "[CCapture]", "camera is null");
            return -1.0f;
        }
        float zoom = 100.0f * _zoom;
        try {
            Camera.Parameters param = camera.getParameters();
            if (!(param == null || (zoomRatios = param.getZoomRatios()) == null || zoom < 0.0f)) {
                int zoomIdx = 0;
                Iterator<Integer> it = zoomRatios.iterator();
                while (true) {
                    if (!it.hasNext() || ((float) it.next().intValue()) >= zoom) {
                        break;
                    } else if (zoomIdx == zoomRatios.size() - 1) {
                        break;
                    } else {
                        zoomIdx++;
                    }
                }
                if (zoomIdx != param.getZoom()) {
                    param.setZoom(zoomIdx);
                    camera.setParameters(param);
                }
                YMFLog.info(this, "[CCapture]", "setZoom:" + zoom + ", zoomidx: " + zoomIdx + ", zoomRatio:" + ((float) zoomRatios.get(zoomIdx).intValue()));
                return _zoom;
            }
        } catch (Throwable throwable) {
            YMFLog.error((Object) this, "[CCapture]", "setZoom exception:" + throwable.toString());
        }
        return -1.0f;
    }

    public boolean isTorchSupported() {
        return this.mIsTorchSupported;
    }

    public boolean setCameraTorchOn(boolean enable) {
        boolean cameraFlashMode;
        synchronized (this.mCameraLock) {
            YMFLog.info(this, "[CCapture]", "setCameraFlashMode.");
            cameraFlashMode = setCameraFlashMode(this.mCameraInstance, enable);
        }
        return cameraFlashMode;
    }

    private boolean setCameraFlashMode(Camera camera, boolean enable) {
        if (camera == null) {
            return true;
        }
        boolean savedFlash = this.isFlashOn;
        try {
            Camera.Parameters params = camera.getParameters();
            if (Camera1Utils.isTorchSupported(params)) {
                params.setFlashMode(enable ? "torch" : "off");
                camera.setParameters(params);
                this.isFlashOn = enable;
                return true;
            }
            this.isFlashOn = false;
            return true;
        } catch (Throwable throwable) {
            this.isFlashOn = savedFlash;
            YMFLog.error((Object) this, "[CCapture]", "setCameraFlashMode exception:" + throwable);
            return true;
        }
    }

    private boolean isHasPermission(Camera camera) {
        try {
            Field fieldPassword = camera.getClass().getDeclaredField("mHasPermission");
            fieldPassword.setAccessible(true);
            return ((Boolean) fieldPassword.get(camera)).booleanValue();
        } catch (Exception e2) {
            return true;
        }
    }

    public int setFocusMetering(float fx, float fy) {
        int x = Math.round(fx);
        int y = Math.round(fy);
        int ret = 0;
        this.mMirror = this.mFacing == 0;
        this.mCurrentFocusArea = null;
        TimerTask timerTask = this.mMeteringTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mMeteringTimerTask = null;
        }
        TimerTask timerTask2 = this.mFocusTimerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
            this.mFocusTimerTask = null;
        }
        final Camera meteringCamera = this.mCameraInstance;
        setCameraAutoFocusFaceMode(false);
        if (meteringCamera == null) {
            return -1;
        }
        try {
            final Camera.Parameters params = meteringCamera.getParameters();
            this.mFocusAreaSupported = Camera1Utils.isFocusAreaSupported(params);
            this.mMeteringAreaSupported = Camera1Utils.isMeteringAreaSupported(params);
            setMatrix();
            if (!(this.mFocusArea == null && this.mMeteringArea == null)) {
                resetFocusMeteringArea(meteringCamera);
            }
            meteringCamera.cancelAutoFocus();
            if (this.mFocusAreaSupported) {
                ArrayList arrayList = new ArrayList();
                this.mFocusArea = arrayList;
                arrayList.add(new Camera.Area(new Rect(), 1000));
                calculateTapArea(x, y, 1.0f, this.mFocusArea.get(0).rect);
                params.setFocusAreas(this.mFocusArea);
            } else {
                YMFLog.warn(this, "[CCapture]", "focus areas not supported");
            }
            if (!this.mMeteringAreaSupported) {
                YMFLog.warn(this, "[CCapture]", "metering areas not supported");
            } else if (this.mMeteringArea == null) {
                ArrayList arrayList2 = new ArrayList();
                this.mMeteringArea = arrayList2;
                arrayList2.add(new Camera.Area(new Rect(), 800));
                calculateTapArea(x, y, 1.0f, this.mMeteringArea.get(0).rect);
                params.setMeteringAreas(this.mMeteringArea);
            }
            if (params.getSupportedFocusModes().contains("auto")) {
                params.setFocusMode("auto");
                YMFLog.info(this, "[CCapture]", "set FOCUS_MODE_AUTO, " + this.mDeviceName);
            }
            meteringCamera.setParameters(params);
            if (this.mFocusAreaSupported && meteringCamera != null) {
                try {
                    meteringCamera.autoFocus(this.mAutoFocusCallback);
                    ret = 0;
                } catch (Exception e2) {
                    ret = -1;
                    YMFLog.error((Object) this, "[CCapture]", "auto focus error!");
                }
            }
            if ((!this.mDeviceName.toLowerCase().contains("oppo") && !this.mDeviceName.toLowerCase().contains("vivo")) || this.mCameraTimer == null) {
                return ret;
            }
            AnonymousClass1 r0 = new TimerTask() {
                public void run() {
                    YMFLog.info(this, "[CCapture]", "reset metering area to null...");
                    try {
                        params.setMeteringAreas((List) null);
                        meteringCamera.setParameters(params);
                    } catch (RuntimeException e2) {
                        YMFLog.error((Object) this, "[CCapture]", "meteringCamera setParameters not supported:" + params.flatten());
                        YMFLog.error((Object) this, "[CCapture]", "meteringCamera setParameters exception:" + e2.getMessage());
                    }
                }
            };
            this.mMeteringTimerTask = r0;
            this.mCameraTimer.schedule(r0, 20000);
            return ret;
        } catch (Exception e3) {
            YMFLog.warn(this, "[CCapture]", "handleFocusMetering exception: " + e3.getMessage());
            return -1;
        }
    }

    public int setCameraFocusPosition(float posX, float posY) {
        WeakReference<CameraCallback> weakReference;
        this.mFocusAndExposureModeLocked.set(false);
        int ret = setFocusMetering((float) Math.round(posX), (float) Math.round(posY));
        if (ret == 0 && (weakReference = this.mCameraCallback) != null) {
            CameraCallback cameraCallback = (CameraCallback) weakReference.get();
            CameraCallback listener = cameraCallback;
            if (cameraCallback != null) {
                try {
                    Iterator<Camera.Area> it = this.mFocusArea.iterator();
                    if (it.hasNext()) {
                        RectF viewRect = new RectF(it.next().rect);
                        YMFLog.info(this, "[CCapture]", "Focus:" + viewRect.left + " " + viewRect.top + " " + viewRect.right + " " + viewRect.bottom);
                        this.mMatrixDriveToView.mapRect(viewRect);
                        listener.onCameraFocusAreaChanged(new RectF(viewRect.left, viewRect.top, viewRect.right, viewRect.bottom));
                    }
                } catch (Exception ex) {
                    YMFLog.error((Object) this, "[CCapture]", "setCameraFocusPosition exception:" + ex.toString());
                }
            }
        }
        return ret;
    }

    public int setCameraExposurePosition(float posX, float posY) {
        WeakReference<CameraCallback> weakReference;
        this.mFocusAndExposureModeLocked.set(false);
        int ret = setFocusMetering((float) Math.round(posX), (float) Math.round(posY));
        if (ret == 0 && (weakReference = this.mCameraCallback) != null) {
            CameraCallback cameraCallback = (CameraCallback) weakReference.get();
            CameraCallback listener = cameraCallback;
            if (cameraCallback != null) {
                try {
                    Iterator<Camera.Area> it = this.mMeteringArea.iterator();
                    if (it.hasNext()) {
                        RectF viewRect = new RectF(it.next().rect);
                        this.mMatrixDriveToView.mapRect(viewRect);
                        listener.onCameraExposureAreaChanged(new RectF(viewRect.left, viewRect.top, viewRect.right, viewRect.bottom));
                    }
                } catch (Exception ex) {
                    YMFLog.error((Object) this, "[CCapture]", "setCameraExposurePosition exception:" + ex.toString());
                }
            }
        }
        return ret;
    }

    public void registerFrameCallback(IYMFPreviewFrameCallback callback) {
        Camera1PreviewCallbackHost camera1PreviewCallbackHost = this.mCameraPreviewCallbackHost;
        if (camera1PreviewCallbackHost != null) {
            camera1PreviewCallbackHost.registerCallback(callback);
        }
    }

    public void unregisterFrameCallback(IYMFPreviewFrameCallback callback) {
        Camera1PreviewCallbackHost camera1PreviewCallbackHost = this.mCameraPreviewCallbackHost;
        if (camera1PreviewCallbackHost != null) {
            camera1PreviewCallbackHost.unregisterCallback(callback);
        }
    }

    private void resetFocusMeteringArea(Camera camera) {
        this.mFocusArea = null;
        this.mMeteringArea = null;
        if (camera != null) {
            YMFLog.info(this, "[CCapture]", "resetFocusMeteringArea");
            Camera.Parameters params = camera.getParameters();
            if (this.mFocusAreaSupported) {
                params.setFocusAreas(this.mFocusArea);
            }
            if (this.mMeteringAreaSupported) {
                params.setMeteringAreas(this.mMeteringArea);
            }
            camera.setParameters(params);
        }
    }

    /* access modifiers changed from: private */
    public void resetCameraFocus(final Camera camera, long delayMs) {
        if (this.mCameraTimer != null) {
            AnonymousClass2 r0 = new TimerTask() {
                public void run() {
                    if (Camera1.this.mHandler != null && Camera1.this.mHandler.get() != null) {
                        ((Handler) Camera1.this.mHandler.get()).post(new Runnable() {
                            /* Debug info: failed to restart local var, previous not found, register: 6 */
                            public void run() {
                                try {
                                    synchronized (Camera1.this.mCameraLock) {
                                        if (!Camera1.this.mFocusAndExposureModeLocked.get()) {
                                            YMFLog.info(this, "[CCapture]", "reset camera focus mode:" + Camera1.this.mDefaultMasterFocusMode);
                                            Camera.Parameters params = camera.getParameters();
                                            params.setFocusMode(Camera1.this.mDefaultMasterFocusMode);
                                            if (params.isAutoWhiteBalanceLockSupported()) {
                                                params.setAutoWhiteBalanceLock(false);
                                            }
                                            if (params.isAutoExposureLockSupported()) {
                                                params.setAutoExposureLock(false);
                                            }
                                            camera.setParameters(params);
                                        } else {
                                            YMFLog.info(this, "[CCapture]", "camera focus mode locked");
                                            Camera.Parameters params2 = camera.getParameters();
                                            if (params2.getSupportedFocusModes().contains("auto")) {
                                                params2.setFocusMode("auto");
                                                YMFLog.info(this, "[CCapture]", "set FOCUS_MODE_AUTO, " + Camera1.this.mDeviceName);
                                            }
                                            if (params2.isAutoWhiteBalanceLockSupported()) {
                                                params2.setAutoWhiteBalanceLock(true);
                                            }
                                            if (params2.isAutoExposureLockSupported()) {
                                                params2.setAutoExposureLock(true);
                                            }
                                            camera.setParameters(params2);
                                        }
                                    }
                                } catch (Exception ex) {
                                    YMFLog.error((Object) this, "[CCapture]", "onAutoFocus exception:" + ex.toString());
                                }
                            }
                        });
                    }
                }
            };
            this.mFocusTimerTask = r0;
            this.mCameraTimer.schedule(r0, delayMs);
        }
    }

    private void calculateTapArea(int x, int y, float areaMultiple, Rect rect) {
        int areaWidth = (int) (areaMultiple * 300.0f);
        int areaHeight = (int) (300.0f * areaMultiple);
        int left = Camera1Utils.clamp(x - (areaWidth / 2), 0, this.mSurfaceViewWidth - areaWidth);
        int top = Camera1Utils.clamp(y - (areaHeight / 2), 0, this.mSurfaceViewHeight - areaHeight);
        RectF rectF = new RectF((float) left, (float) top, (float) (left + areaWidth), (float) (top + areaHeight));
        this.mMatrix.mapRect(rectF);
        Camera1Utils.rectFToRect(rectF, rect);
    }

    public void resumeZoomValue(float zoom) {
        this.mResumeZoomValue = zoom;
    }

    private class AutoFocusCallBack implements Camera.AutoFocusCallback {
        private AutoFocusCallBack() {
        }

        public void onAutoFocus(boolean focused, Camera camera) {
            YMFLog.info(this, "[CCapture]", "onAutoFocus...focused:" + focused);
            Camera1.this.resetCameraFocus(camera, 3000);
        }
    }

    public boolean isCameraFocusAndExposureModeLocked() {
        return this.mFocusAndExposureModeLocked.get();
    }

    public float getCameraExposureCompensation() {
        if (this.mCameraInstance == null) {
            return -1.0f;
        }
        return this.mExposureCompensation;
    }

    public float[] getCameraExposureCompensationRange() {
        float[] ret = new float[2];
        if (this.mCameraInstance == null) {
            ret[0] = 0.0f;
            ret[1] = 0.0f;
        } else {
            ret[0] = (float) this.minExposureCompensation;
            ret[1] = (float) this.maxExposureCompensation;
        }
        return ret;
    }

    public int isValidExposureCompensation(float c2) {
        if (this.mCameraInstance == null) {
            YMFLog.error((Object) this, "[CCapture]", "isValidExposureCompensation: mCameraInstance is null");
            return -1;
        } else if (c2 <= 1.0f && c2 >= 0.0f) {
            return 0;
        } else {
            YMFLog.error((Object) this, "[CCapture]", "isValidExposureCompensation: desired compensation NOT support");
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setCameraExposureCompensation(float r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.mCameraLock
            monitor-enter(r0)
            float r1 = r9.getCameraExposureCompensation()     // Catch:{ all -> 0x0030 }
            int r2 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r3
        L_0x000e:
            android.hardware.Camera r2 = r9.mCameraInstance     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x002e
            android.hardware.Camera$Parameters r4 = r2.getParameters()     // Catch:{ all -> 0x0030 }
            int r5 = r4.getMaxExposureCompensation()     // Catch:{ all -> 0x0030 }
            int r6 = r4.getMinExposureCompensation()     // Catch:{ all -> 0x0030 }
            int r7 = r5 - r6
            float r7 = (float) r7     // Catch:{ all -> 0x0030 }
            float r7 = r7 * r10
            float r8 = (float) r6     // Catch:{ all -> 0x0030 }
            float r7 = r7 + r8
            int r7 = (int) r7     // Catch:{ all -> 0x0030 }
            r4.setExposureCompensation(r7)     // Catch:{ all -> 0x0030 }
            r2.setParameters(r4)     // Catch:{ all -> 0x0030 }
            r9.mExposureCompensation = r10     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r3
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.mediaframework.camera.Camera1.setCameraExposureCompensation(float):int");
    }

    public int isValidExposureDuration(float d2) {
        return -2;
    }

    public int setCameraExposureDuration(float d2) {
        return -2;
    }

    public float getCameraExposureDuration() {
        return -2.0f;
    }

    public float[] getCameraExposureDurationRange() {
        return new float[]{0.0f, 0.0f};
    }

    public int isValidExposureISO(float iso) {
        return -2;
    }

    public int setCameraExposureISO(float iso) {
        return -2;
    }

    public float getCameraExposureISO() {
        return -2.0f;
    }

    public float[] getCameraExposureISORange() {
        return new float[]{0.0f, 0.0f};
    }

    public int isValidLensPosition(float lensPosition) {
        return -2;
    }

    public int setCameraLensPosition(float lensPosition) {
        return -2;
    }

    public float getCameraLensPosition() {
        return -2.0f;
    }

    public int setCameraFocusAndExposureModeLocked(boolean enable) {
        YMFLog.info(this, "[CCapture]", "setCameraFocusAndExposureModeLocked: " + enable);
        if (isSupportFocusLock() == 0) {
            setCameraFocusLocked(enable);
        } else {
            YMFLog.error((Object) this, "[CCapture]", "setCameraFocusAndExposureModeLocked: NOT support FOCUS Lock");
        }
        if (isSupportExposureLock() == 0) {
            setCameraExposureLocked(enable);
        } else {
            YMFLog.error((Object) this, "[CCapture]", "setCameraFocusAndExposureModeLocked: NOT support Exposure Lock");
        }
        if (isSupportAWBLock() == 0) {
            setCameraAWBLocked(enable);
        } else {
            YMFLog.error((Object) this, "[CCapture]", "setCameraFocusAndExposureModeLocked: NOT support AWB Lock");
        }
        this.mFocusAndExposureModeLocked.set(enable);
        return 0;
    }

    private final class AutoFocusListener implements Camera.AutoFocusCallback {
        private AutoFocusListener() {
        }

        public void onAutoFocus(boolean focused, Camera camera) {
            YMFLog.info(this, "[CCapture]", "[AutoFocusListener] onAutoFocus...focused:" + focused);
        }
    }

    public int isSupportFocusLock() {
        if (this.mCameraInstance == null) {
            YMFLog.error((Object) this, "[CCapture]", "isSupportFocusLock: camera is null");
            return -1;
        } else if (this.mIsAutoFocusSupported) {
            return 0;
        } else {
            YMFLog.error((Object) this, "[CCapture]", "isSupportFocusLock: NOT support FOCUS_MODE_CONTINUOUS_VIDEO or FOCUS_MODE_AUTO, deviceBrand: " + this.mDeviceBrand + ", deviceName: " + this.mDeviceName);
            return -2;
        }
    }

    public int setCameraFocusLocked(boolean enable) {
        YMFLog.info(this, "[CCapture]", "setCameraFocusLocked: " + enable);
        synchronized (this.mCameraLock) {
            Camera camera = this.mCameraInstance;
            if (camera != null) {
                Camera.Parameters params = camera.getParameters();
                if (enable) {
                    params.setFocusMode("auto");
                    camera.setParameters(params);
                    YMFLog.info(this, "[CCapture]", "setCameraFocusLocked: set FOCUS_MODE_AUTO, deviceBrand: " + this.mDeviceBrand + ", deviceName: " + this.mDeviceName);
                } else {
                    params.setFocusMode("continuous-video");
                    camera.setParameters(params);
                    YMFLog.info(this, "[CCapture]", "setCameraFocusLocked: set FOCUS_MODE_CONTINUOUS_VIDEO");
                }
            }
        }
        return 0;
    }

    public int isSupportExposureLock() {
        if (this.mCameraInstance == null) {
            YMFLog.error((Object) this, "[CCapture]", "isSupportExposureLock: camera is null");
            return -1;
        } else if (this.mIsAutoExposureLockSupported) {
            return 0;
        } else {
            YMFLog.error((Object) this, "[CCapture]", "isSupportExposureLock: NOT support AutoExposureLock");
            return -2;
        }
    }

    public int setCameraExposureLocked(boolean enable) {
        YMFLog.info(this, "[CCapture]", "setCameraExposureLocked: " + enable);
        synchronized (this.mCameraLock) {
            Camera camera = this.mCameraInstance;
            if (camera != null) {
                Camera.Parameters params = camera.getParameters();
                if (enable) {
                    params.setAutoExposureLock(true);
                } else {
                    params.setAutoExposureLock(false);
                }
                camera.setParameters(params);
            }
        }
        return 0;
    }

    public int isSupportAWBLock() {
        if (this.mCameraInstance == null) {
            YMFLog.error((Object) this, "[CCapture]", "isSupportAWBLock: camera is null");
            return -1;
        } else if (this.mCameraInstance.getParameters().isAutoWhiteBalanceLockSupported()) {
            return 0;
        } else {
            YMFLog.error((Object) this, "[CCapture]", "isSupportAWBLock: NOT support AutoExposureLock");
            return -2;
        }
    }

    public int setCameraAWBLocked(boolean enable) {
        YMFLog.info(this, "[CCapture]", "setCameraAWBLocked: " + enable);
        synchronized (this.mCameraLock) {
            Camera camera = this.mCameraInstance;
            if (camera != null) {
                Camera.Parameters params = camera.getParameters();
                if (enable) {
                    params.setAutoWhiteBalanceLock(true);
                } else {
                    params.setAutoWhiteBalanceLock(false);
                }
                camera.setParameters(params);
            }
        }
        return 0;
    }

    public class Camera1PreviewCallbackHost implements Camera.PreviewCallback {
        private static final String TAG = "Camera1PreviewCallbackHost";
        private CameraFrameUtils mCameraFrameUtil = new CameraFrameUtils();
        private AtomicBoolean mCameraNV21DataUsed = new AtomicBoolean(true);
        private List<IYMFPreviewFrameCallback> mCameraPreviewClientList = new CopyOnWriteArrayList();
        private WeakReference<ICamera> mCameraRef = new WeakReference<>((Object) null);
        private long mIndex = 0;
        private boolean mIsCameraFirstFrame = false;
        private ConcurrentHashMap<Long, YYSeiData> mPtsSeiMap = new ConcurrentHashMap<>();
        private IYMFPreviewFrameCallback mYMFPreviewFrameCallback = null;
        private YMFVideoFrame mYMFVideoFrame = new YMFVideoFrame();
        private Queue<YYSeiData> mYYSeiDataQueue = new LinkedBlockingQueue();
        private final Object syncLock = new Object();

        public Camera1PreviewCallbackHost(ICamera camera) {
            this.mCameraRef = new WeakReference<>(camera);
        }

        public void reset() {
            this.mCameraPreviewClientList.clear();
            this.mYMFPreviewFrameCallback = null;
            this.mCameraFrameUtil.clear();
            this.mCameraNV21DataUsed.set(true);
        }

        public void setTargetFps(int fps) {
            this.mCameraFrameUtil.setTargetFps(fps);
        }

        public void setYMFPreviewFrameCallback(IYMFPreviewFrameCallback callback) {
            YMFLog.info(this, "[CCapture]", "setYMFPreviewFrameCallback " + callback);
            synchronized (this.syncLock) {
                this.mCameraNV21DataUsed.set(true);
                this.mYMFPreviewFrameCallback = callback;
            }
            this.mIsCameraFirstFrame = true;
            Mp4CaptureSource.getInstance().setInnderPreviewCallback(callback);
        }

        public void registerCallback(IYMFPreviewFrameCallback callback) {
            synchronized (this.syncLock) {
                this.mCameraNV21DataUsed.set(true);
                if (!this.mCameraPreviewClientList.contains(callback)) {
                    this.mCameraPreviewClientList.add(callback);
                }
            }
            Mp4CaptureSource.getInstance().setExternalPreviewCallbackClient(this.mCameraPreviewClientList);
        }

        public void unregisterCallback(IYMFPreviewFrameCallback callback) {
            synchronized (this.syncLock) {
                if (this.mCameraPreviewClientList.contains(callback)) {
                    this.mCameraPreviewClientList.remove(callback);
                }
            }
            Mp4CaptureSource.getInstance().setExternalPreviewCallbackClient(this.mCameraPreviewClientList);
        }

        public void onPreviewFrame(byte[] data, Camera camera) {
            if (data == null || !Camera1Utils.queryCameraBufferHashCode((long) data.hashCode())) {
                YMFLog.warn(this, "[CCapture]", " cameraDataBuffer is old");
                return;
            }
            this.mCameraFrameUtil.calculateCameraCaptureFrameRateIn();
            if (Mp4CaptureSource.getInstance().isMp4Capture() || (Camera1.this.mEnableCaptureFpsControl && this.mCameraFrameUtil.skipCurrentFrame())) {
                Camera1.this.addCallbackBuffer(data);
                return;
            }
            if (this.mIsCameraFirstFrame) {
                YMFLog.info(this, "[CCapture]", " camera first onPreviewFrame data");
                this.mIsCameraFirstFrame = false;
            }
            try {
                processCameraData(data, camera);
            } catch (Exception e2) {
                YMFLog.error((Object) this, "[Preview ]", "onPreviewFrame error " + Log.getStackTraceString(e2));
            } catch (Throwable th2) {
                Camera1.this.addCallbackBuffer(data);
                throw th2;
            }
            Camera1.this.addCallbackBuffer(data);
        }

        public Queue<YYSeiData> getYYSeiQueue() {
            return this.mYYSeiDataQueue;
        }

        public ConcurrentHashMap<Long, YYSeiData> getPtsSeiMap() {
            return this.mPtsSeiMap;
        }

        private void processCameraData(byte[] data, Camera camera) {
            long startTime = System.currentTimeMillis();
            YYSeiData seiData = new YYSeiData();
            seiData.cameraRotation = Camera1.this.getRotation();
            this.mIndex++;
            this.mYMFVideoFrame.mImageFormat = 17;
            this.mYMFVideoFrame.mYUVCaptureBuffer = data;
            if (((this.mYMFVideoFrame.mYuvWidth * this.mYMFVideoFrame.mYuvHeight) * 3) / 2 != data.length) {
                this.mYMFVideoFrame.mYuvWidth = camera.getParameters().getPreviewSize().width;
                this.mYMFVideoFrame.mYuvHeight = camera.getParameters().getPreviewSize().height;
            }
            YMFVideoFrame yMFVideoFrame = this.mYMFVideoFrame;
            WeakReference<ICamera> weakReference = this.mCameraRef;
            yMFVideoFrame.mCameraInstance = weakReference != null ? (ICamera) weakReference.get() : null;
            this.mYMFVideoFrame.mIndex = this.mIndex;
            this.mYMFVideoFrame.mWillBeRendered = this.mCameraNV21DataUsed;
            this.mYMFVideoFrame.mSei = seiData;
            this.mYMFVideoFrame.mYuvCaptureYYPtsMillions = TimeUtil.getTickCountLong();
            this.mCameraFrameUtil.calculateCameraCaptureFrameRateOut();
            synchronized (this.syncLock) {
                List<IYMFPreviewFrameCallback> list = this.mCameraPreviewClientList;
                if (list != null && !list.isEmpty()) {
                    try {
                        for (IYMFPreviewFrameCallback cameraPreviewFrame : this.mCameraPreviewClientList) {
                            if (cameraPreviewFrame != null) {
                                if (seiData.data != null) {
                                    this.mCameraFrameUtil.attachSei(seiData, getYYSeiQueue());
                                }
                                cameraPreviewFrame.onPreviewFrameAvailable(this.mYMFVideoFrame);
                            }
                        }
                    } catch (Exception e2) {
                        YMFLog.error((Object) this, "[Preview ]", " ui code error " + e2.toString());
                    }
                }
                IYMFPreviewFrameCallback iYMFPreviewFrameCallback = this.mYMFPreviewFrameCallback;
                if (iYMFPreviewFrameCallback != null) {
                    iYMFPreviewFrameCallback.onPreviewFrameAvailable(this.mYMFVideoFrame);
                }
            }
            YMFLiveStatisticManager.getInstance().calcPureYuvCallbackLatency(startTime);
            if (UploadStreamStateParams.mYuvTextureMode) {
                YMFLiveStatisticManager.getInstance().setCameraCaptureFrameRate();
            }
        }
    }

    public Queue<YYSeiData> getYYSeiQueue() {
        Camera1PreviewCallbackHost camera1PreviewCallbackHost = this.mCameraPreviewCallbackHost;
        if (camera1PreviewCallbackHost != null) {
            return camera1PreviewCallbackHost.getYYSeiQueue();
        }
        return null;
    }

    public ConcurrentHashMap<Long, YYSeiData> getPtsSeiMap() {
        Camera1PreviewCallbackHost camera1PreviewCallbackHost = this.mCameraPreviewCallbackHost;
        if (camera1PreviewCallbackHost != null) {
            return camera1PreviewCallbackHost.getPtsSeiMap();
        }
        return null;
    }

    public void setYMFPreviewFrameCallback(IYMFPreviewFrameCallback callback) {
        Camera1PreviewCallbackHost camera1PreviewCallbackHost = this.mCameraPreviewCallbackHost;
        if (camera1PreviewCallbackHost != null) {
            camera1PreviewCallbackHost.setYMFPreviewFrameCallback(callback);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f3, code lost:
        if (r0 == 270) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fa, code lost:
        if (r10.width < r1) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fc, code lost:
        if (r0 == 0) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0100, code lost:
        if (r0 != 180) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0104, code lost:
        if (r10.height < r1) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0106, code lost:
        if (r9 >= r8) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0108, code lost:
        r5 = r10;
        r6 = java.lang.Math.abs(r14 - r3);
        r8 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera.Size getBestPreviewSize(int r22, int r23, int r24, double r25) {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            double r3 = (double) r2
            double r5 = (double) r1
            double r3 = r3 / r5
            r5 = 0
            r6 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r8 = 2147483647(0x7fffffff, float:NaN)
            r9 = 2147483646(0x7ffffffe, float:NaN)
            r10 = 270(0x10e, float:3.78E-43)
            r11 = 90
            if (r0 == r11) goto L_0x001d
            if (r0 != r10) goto L_0x0023
        L_0x001d:
            if (r1 <= r2) goto L_0x0023
            double r12 = (double) r1
            double r14 = (double) r2
            double r3 = r12 / r14
        L_0x0023:
            r12 = r21
            java.util.List<android.hardware.Camera$Size> r13 = r12.mPreviewSizes
            r14 = 0
            if (r13 != 0) goto L_0x002b
            return r14
        L_0x002b:
            com.yy.mediaframework.camera.util.Camera1Utils$SizeComparator r15 = new com.yy.mediaframework.camera.util.Camera1Utils$SizeComparator
            r15.<init>()
            java.util.Comparator r15 = java.util.Collections.reverseOrder(r15)
            java.util.Collections.sort(r13, r15)
            java.util.Iterator r15 = r13.iterator()
        L_0x003b:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x0119
            java.lang.Object r16 = r15.next()
            r10 = r16
            android.hardware.Camera$Size r10 = (android.hardware.Camera.Size) r10
            int r11 = r10.width
            r17 = r15
            double r14 = (double) r11
            int r11 = r10.height
            r18 = r8
            r19 = r9
            double r8 = (double) r11
            double r14 = r14 / r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "getSupportedPreviewSizes:"
            java.lang.StringBuilder r8 = r8.append(r9)
            int r9 = r10.width
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = "x"
            java.lang.StringBuilder r8 = r8.append(r9)
            int r9 = r10.height
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = ", ratio:"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r14)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "[CCapture]"
            r11 = 0
            com.yy.mediaframework.utils.YMFLog.info(r11, r9, r8)
            r8 = 90
            if (r0 == r8) goto L_0x00a2
            r8 = 270(0x10e, float:3.78E-43)
            if (r0 != r8) goto L_0x0091
            goto L_0x00a2
        L_0x0091:
            int r8 = r10.width
            int r8 = r8 - r2
            int r8 = java.lang.Math.abs(r8)
            int r9 = r10.height
            int r9 = r9 - r1
            int r9 = java.lang.Math.abs(r9)
            int r8 = r8 + r9
            r9 = r8
            goto L_0x00b2
        L_0x00a2:
            int r8 = r10.width
            int r8 = r8 - r1
            int r8 = java.lang.Math.abs(r8)
            int r9 = r10.height
            int r9 = r9 - r2
            int r9 = java.lang.Math.abs(r9)
            int r8 = r8 + r9
            r9 = r8
        L_0x00b2:
            double r19 = r14 - r3
            double r19 = java.lang.Math.abs(r19)
            int r8 = (r19 > r6 ? 1 : (r19 == r6 ? 0 : -1))
            r11 = 180(0xb4, float:2.52E-43)
            if (r8 >= 0) goto L_0x00db
            r8 = 90
            if (r0 == r8) goto L_0x00c6
            r8 = 270(0x10e, float:3.78E-43)
            if (r0 != r8) goto L_0x00ca
        L_0x00c6:
            int r8 = r10.width
            if (r8 >= r1) goto L_0x00d2
        L_0x00ca:
            if (r0 == 0) goto L_0x00ce
            if (r0 != r11) goto L_0x00db
        L_0x00ce:
            int r8 = r10.height
            if (r8 < r1) goto L_0x00db
        L_0x00d2:
            r5 = r10
            double r19 = r14 - r3
            double r6 = java.lang.Math.abs(r19)
            r8 = r9
            goto L_0x00dd
        L_0x00db:
            r8 = r18
        L_0x00dd:
            double r18 = r14 - r3
            double r18 = java.lang.Math.abs(r18)
            double r18 = r18 - r6
            double r18 = java.lang.Math.abs(r18)
            int r18 = (r18 > r25 ? 1 : (r18 == r25 ? 0 : -1))
            if (r18 > 0) goto L_0x0110
            r11 = 90
            if (r0 == r11) goto L_0x00f6
            r11 = 270(0x10e, float:3.78E-43)
            if (r0 != r11) goto L_0x00fc
            goto L_0x00f8
        L_0x00f6:
            r11 = 270(0x10e, float:3.78E-43)
        L_0x00f8:
            int r11 = r10.width
            if (r11 >= r1) goto L_0x0106
        L_0x00fc:
            if (r0 == 0) goto L_0x0102
            r11 = 180(0xb4, float:2.52E-43)
            if (r0 != r11) goto L_0x0110
        L_0x0102:
            int r11 = r10.height
            if (r11 < r1) goto L_0x0110
        L_0x0106:
            if (r9 >= r8) goto L_0x0110
            r5 = r10
            double r18 = r14 - r3
            double r6 = java.lang.Math.abs(r18)
            r8 = r9
        L_0x0110:
            r15 = r17
            r10 = 270(0x10e, float:3.78E-43)
            r11 = 90
            r14 = 0
            goto L_0x003b
        L_0x0119:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.mediaframework.camera.Camera1.getBestPreviewSize(int, int, int, double):android.hardware.Camera$Size");
    }

    public boolean isResSupported(int displayOrientation, int width, int height, double threshold) {
        Camera.Size[] bestSize = {getBestPreviewSize(displayOrientation, width, height, threshold)};
        if (bestSize[0] == null) {
            return false;
        }
        if ((bestSize[0].width != width || bestSize[0].height != height) && (bestSize[0].width != height || bestSize[0].height != width)) {
            return false;
        }
        YMFLog.info(this, "[CCapture]", "found supported resolution: " + bestSize[0].width + "x" + bestSize[0].height);
        return true;
    }

    public void setEnablePCCameraToolMode(boolean enable) {
        this.mEnablePCCameraToolMode = enable;
    }

    public void setCountDownLatchLock(CountDownLatch barrier) {
        synchronized (this.mCameraLock) {
            this.barrierRef = barrier;
        }
    }
}
