package com.baidu.wallet.base.iddetect.view;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.wallet.base.iddetect.CameraSizeInfo;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import com.baidu.wallet.base.iddetect.utils.Utils;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SurfaceViewForScan extends SurfaceView implements SurfaceHolder.Callback {
    public static final int BUFFER_NUM = 4;
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 0;
    public static int FRAME_HEIGHT = CameraUtilsForScan.MAX_SIZE_HEIGHT;
    public static int FRAME_WIDTH = 960;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TRACKER = 1;
    public static final String TAG = SurfaceViewForScan.class.getSimpleName();
    public byte[][] buffer;
    public Callback callback;
    public Camera camera;
    public int cameraID;
    public Camera.Parameters cameraParameters;
    public int displayRotation;
    public int focusAreaSize;
    public int frameFormat;
    public int frameHeight;
    public int frameWidth;
    public LooperThread looperThread;
    public IdCardActivity mAttachedActivity;
    public Context mContext;
    public int mCurrentCameraPosition;
    public int mCurrentMode;
    public Camera.AutoFocusCallback mFocusCallback;
    public CameraSizeInfo mInfo;
    public Camera.PictureCallback mPictureCallback;
    public byte[] rotatedFrame;
    public SurfaceHolder surfaceHolder;

    public interface Callback {
        void onFrame(byte[] bArr, int i2, int i3, int i4);
    }

    public class LooperThread extends Thread {
        public Handler handler;

        public LooperThread() {
        }

        public void run() {
            Looper.prepare();
            this.handler = new MyHandler(SurfaceViewForScan.this);
            Looper.loop();
        }
    }

    public static class MyHandler extends Handler {
        public static final int FRAME_INTERVAL = 200;
        public long lastFrame = System.currentTimeMillis();
        public final WeakReference<SurfaceViewForScan> surfaceViewForScanWR;

        public MyHandler(SurfaceViewForScan surfaceViewForScan) {
            this.surfaceViewForScanWR = new WeakReference<>(surfaceViewForScan);
        }

        public void handleMessage(Message message) {
            int i2;
            int i3;
            SurfaceViewForScan surfaceViewForScan = (SurfaceViewForScan) this.surfaceViewForScanWR.get();
            if (surfaceViewForScan != null) {
                byte[] bArr = (byte[]) message.obj;
                if (System.currentTimeMillis() - this.lastFrame > 200) {
                    this.lastFrame = System.currentTimeMillis();
                    int access$000 = surfaceViewForScan.displayRotation;
                    if (surfaceViewForScan.mCurrentCameraPosition == 1) {
                        access$000 += 180;
                    }
                    int i4 = 360 - access$000;
                    if (i4 == 0) {
                        System.arraycopy(bArr, 0, surfaceViewForScan.rotatedFrame, 0, bArr.length);
                        i3 = surfaceViewForScan.frameWidth;
                        i2 = surfaceViewForScan.frameHeight;
                    } else if (i4 == 90) {
                        boolean unused = surfaceViewForScan.rotateYUV420Degree90(bArr, surfaceViewForScan.rotatedFrame, surfaceViewForScan.frameWidth, surfaceViewForScan.frameHeight);
                        i3 = surfaceViewForScan.frameHeight;
                        i2 = surfaceViewForScan.frameWidth;
                    } else if (i4 == 180) {
                        boolean unused2 = surfaceViewForScan.rotateYUV420Degree180(bArr, surfaceViewForScan.rotatedFrame, surfaceViewForScan.frameWidth, surfaceViewForScan.frameHeight);
                        i3 = surfaceViewForScan.frameWidth;
                        i2 = surfaceViewForScan.frameHeight;
                    } else if (i4 != 270) {
                        System.arraycopy(bArr, 0, surfaceViewForScan.rotatedFrame, 0, bArr.length);
                        i3 = surfaceViewForScan.frameWidth;
                        i2 = surfaceViewForScan.frameHeight;
                    } else {
                        boolean unused3 = surfaceViewForScan.rotateYUV420Degree270(bArr, surfaceViewForScan.rotatedFrame, surfaceViewForScan.frameWidth, surfaceViewForScan.frameHeight);
                        i3 = surfaceViewForScan.frameHeight;
                        i2 = surfaceViewForScan.frameWidth;
                    }
                    if (surfaceViewForScan.callback != null) {
                        surfaceViewForScan.callback.onFrame(surfaceViewForScan.rotatedFrame, i3, i2, surfaceViewForScan.frameFormat);
                    }
                }
                if (Build.VERSION.SDK_INT >= 8 && surfaceViewForScan.camera != null && bArr != null) {
                    surfaceViewForScan.camera.addCallbackBuffer(bArr);
                }
            }
        }
    }

    public SurfaceViewForScan(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private int clamp(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        this.mContext = context;
        this.mCurrentCameraPosition = 1;
        this.mCurrentMode = 1;
        try {
            CameraSizeInfo sortSizeInstance = CameraUtilsForScan.getSortSizeInstance(context, 1, false);
            this.mInfo = sortSizeInstance;
            if (sortSizeInstance != null) {
                FRAME_WIDTH = sortSizeInstance.mWidth;
                FRAME_HEIGHT = sortSizeInstance.mHeight;
            } else {
                IdCardActivity idCardActivity = this.mAttachedActivity;
                if (idCardActivity != null) {
                    idCardActivity.dialogPermission();
                    return;
                }
            }
            SurfaceHolder holder = getHolder();
            this.surfaceHolder = holder;
            holder.addCallback(this);
            this.surfaceHolder.setType(3);
        } catch (Exception e) {
            String simpleName = SurfaceViewForScan.class.getSimpleName();
            LogUtil.errord(simpleName, "init fail exception = " + e.getMessage());
            throw e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        r5.camera = null;
        r5.cameraID = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r5.camera = android.hardware.Camera.open();
        r5.cameraID = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initCamera() {
        /*
            r5 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = -1
            r2 = 0
            r3 = 9
            if (r0 < r3) goto L_0x002e
            r0 = 0
            int r3 = r5.mCurrentCameraPosition     // Catch:{ Exception -> 0x0020 }
            r4 = 1
            if (r3 != r4) goto L_0x0017
            android.hardware.Camera r3 = android.hardware.Camera.open(r0)     // Catch:{ Exception -> 0x0020 }
            r5.camera = r3     // Catch:{ Exception -> 0x0020 }
            r5.cameraID = r0     // Catch:{ Exception -> 0x0020 }
            goto L_0x0039
        L_0x0017:
            android.hardware.Camera r3 = android.hardware.Camera.open(r4)     // Catch:{ Exception -> 0x0020 }
            r5.camera = r3     // Catch:{ Exception -> 0x0020 }
            r5.cameraID = r4     // Catch:{ Exception -> 0x0020 }
            goto L_0x0039
        L_0x0020:
            android.hardware.Camera r3 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0029 }
            r5.camera = r3     // Catch:{ Exception -> 0x0029 }
            r5.cameraID = r0     // Catch:{ Exception -> 0x0029 }
            goto L_0x0039
        L_0x0029:
            r5.camera = r2
            r5.cameraID = r1
            goto L_0x0039
        L_0x002e:
            android.hardware.Camera r0 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0035 }
            r5.camera = r0     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r5.camera = r2
            r5.cameraID = r1
        L_0x0039:
            android.hardware.Camera r0 = r5.camera
            if (r0 != 0) goto L_0x0044
            com.baidu.wallet.base.iddetect.IdCardActivity r0 = r5.mAttachedActivity
            if (r0 == 0) goto L_0x0044
            r0.dialogPermission()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.initCamera():void");
    }

    private void initSize() {
        int i2;
        Camera camera2 = this.camera;
        if (camera2 != null && camera2.getParameters() != null) {
            int screenWidth = Utils.getScreenWidth(this.mContext);
            int screenHeight = Utils.getScreenHeight(this.mContext);
            LogUtil.i("ScreenSize", "width:" + screenHeight + ",height:" + screenWidth);
            List<Camera.Size> supportedPreviewSizes = this.camera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 1) {
                for (int i3 = 0; i3 < supportedPreviewSizes.size(); i3++) {
                    Camera.Size size = supportedPreviewSizes.get(i3);
                    int i4 = size.width;
                    if (i4 >= FRAME_WIDTH && (i2 = size.height) >= FRAME_HEIGHT && i4 <= screenHeight && i2 <= screenWidth) {
                        FRAME_WIDTH = i4;
                        FRAME_HEIGHT = i2;
                    }
                }
            }
            LogUtil.i("FRAME Size", "FRAME_WIDTH:" + FRAME_WIDTH + ",FRAME_HEIGHT:" + FRAME_HEIGHT);
        }
    }

    /* access modifiers changed from: private */
    public boolean rotateYUV420Degree180(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = 0;
        for (int i6 = i4 - 1; i6 >= 0; i6--) {
            bArr2[i5] = bArr[i6];
            i5++;
        }
        for (int i7 = ((i4 * 3) / 2) - 1; i7 >= i4; i7 -= 2) {
            int i8 = i5 + 1;
            bArr2[i5] = bArr[i7 - 1];
            i5 = i8 + 1;
            bArr2[i8] = bArr[i7];
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean rotateYUV420Degree270(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = 0;
        for (int i6 = i4; i6 >= 0; i6--) {
            for (int i7 = 0; i7 < i3; i7++) {
                bArr2[i5] = bArr[(i7 * i2) + i6];
                i5++;
            }
        }
        int i8 = i2 * i3;
        int i9 = i8;
        while (i4 > 0) {
            for (int i10 = 0; i10 < i3 / 2; i10++) {
                int i11 = (i10 * i2) + i8;
                bArr2[i9] = bArr[(i4 - 1) + i11];
                int i12 = i9 + 1;
                bArr2[i12] = bArr[i11 + i4];
                i9 = i12 + 1;
            }
            i4 -= 2;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean rotateYUV420Degree90(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = i3 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i2) + i5];
                i4++;
            }
        }
        int i7 = i2 * i3;
        int i8 = ((i7 * 3) / 2) - 1;
        for (int i9 = i2 - 1; i9 > 0; i9 -= 2) {
            for (int i10 = 0; i10 < i3 / 2; i10++) {
                int i11 = (i10 * i2) + i7;
                bArr2[i8] = bArr[i11 + i9];
                int i12 = i8 - 1;
                bArr2[i12] = bArr[i11 + (i9 - 1)];
                i8 = i12 - 1;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x014d, code lost:
        if (r0 != 3) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01f9, code lost:
        if (r0 != 3) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0083, code lost:
        if (r1 != 3) goto L_0x0085;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ef A[LOOP:0: B:17:0x00ed->B:18:0x00ef, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x019f A[LOOP:1: B:34:0x019d->B:35:0x019f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x021d A[Catch:{ Exception -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupCamera() {
        /*
            r14 = this;
            android.hardware.Camera r0 = r14.camera
            if (r0 == 0) goto L_0x0273
            com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$LooperThread r0 = new com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$LooperThread
            r0.<init>()
            r14.looperThread = r0
            r0.start()
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "FRAME_WIDTH = "
            r1.append(r2)
            int r2 = FRAME_WIDTH
            r1.append(r2)
            java.lang.String r2 = ";FRAME_HEIGHT="
            r1.append(r2)
            int r2 = FRAME_HEIGHT
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.wallet.core.utils.LogUtil.i(r0, r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 9
            r2 = 4
            r3 = 0
            r4 = 8
            r6 = 270(0x10e, float:3.78E-43)
            r7 = 180(0xb4, float:2.52E-43)
            r8 = 3
            r9 = 2
            r10 = 17
            r11 = 90
            r12 = 0
            r13 = 1
            if (r0 < r1) goto L_0x0116
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            r14.cameraParameters = r0
            r0.setPreviewFormat(r10)
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            int r1 = FRAME_WIDTH
            int r10 = FRAME_HEIGHT
            r0.setPreviewSize(r1, r10)
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r1 = r14.cameraParameters
            r0.setParameters(r1)
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
            int r1 = r14.cameraID
            android.hardware.Camera.getCameraInfo(r1, r0)
            android.content.Context r1 = r14.getContext()
            android.app.Activity r1 = (android.app.Activity) r1
            android.view.WindowManager r1 = r1.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            int r1 = r1.getRotation()
            if (r1 == 0) goto L_0x0085
            if (r1 == r13) goto L_0x008a
            if (r1 == r9) goto L_0x0087
            if (r1 == r8) goto L_0x008c
        L_0x0085:
            r6 = 0
            goto L_0x008c
        L_0x0087:
            r6 = 180(0xb4, float:2.52E-43)
            goto L_0x008c
        L_0x008a:
            r6 = 90
        L_0x008c:
            int r1 = r0.facing
            if (r1 != r13) goto L_0x009e
            int r0 = r0.orientation
            int r0 = r0 + r6
            int r0 = r0 % 360
            r14.displayRotation = r0
            int r0 = 360 - r0
            int r0 = r0 % 360
            r14.displayRotation = r0
            goto L_0x00a7
        L_0x009e:
            int r0 = r0.orientation
            int r0 = r0 - r6
            int r0 = r0 + 360
            int r0 = r0 % 360
            r14.displayRotation = r0
        L_0x00a7:
            android.hardware.Camera r0 = r14.camera
            int r1 = r14.displayRotation
            r0.setDisplayOrientation(r1)
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            android.hardware.Camera$Size r0 = r0.getPreviewSize()
            int r0 = r0.height
            r14.frameHeight = r0
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            android.hardware.Camera$Size r0 = r0.getPreviewSize()
            int r0 = r0.width
            r14.frameWidth = r0
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            int r0 = r0.getPreviewFormat()
            r14.frameFormat = r0
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            int r0 = r0.getPreviewFormat()
            int r0 = android.graphics.ImageFormat.getBitsPerPixel(r0)
            r6 = 1
            int r1 = r14.frameHeight
            long r8 = (long) r1
            long r8 = r8 * r6
            int r1 = r14.frameWidth
            long r6 = (long) r1
            long r8 = r8 * r6
            long r0 = (long) r0
            long r8 = r8 * r0
            long r8 = r8 / r4
            int r0 = (int) r8
            byte[] r1 = new byte[r0]
            r14.rotatedFrame = r1
        L_0x00ed:
            if (r12 >= r2) goto L_0x00ff
            byte[][] r1 = r14.buffer
            byte[] r4 = new byte[r0]
            r1[r12] = r4
            android.hardware.Camera r4 = r14.camera
            r1 = r1[r12]
            r4.addCallbackBuffer(r1)
            int r12 = r12 + 1
            goto L_0x00ed
        L_0x00ff:
            int r0 = r14.mCurrentMode
            if (r0 != r13) goto L_0x010f
            android.hardware.Camera r0 = r14.camera
            com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$1 r1 = new com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$1
            r1.<init>()
            r0.setPreviewCallbackWithBuffer(r1)
            goto L_0x0273
        L_0x010f:
            android.hardware.Camera r0 = r14.camera
            r0.setPreviewCallbackWithBuffer(r3)
            goto L_0x0273
        L_0x0116:
            r1 = 8
            if (r0 != r1) goto L_0x01c6
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            r14.cameraParameters = r0
            r0.setPreviewFormat(r10)
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            int r1 = FRAME_WIDTH
            int r10 = FRAME_HEIGHT
            r0.setPreviewSize(r1, r10)
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r1 = r14.cameraParameters
            r0.setParameters(r1)
            android.content.Context r0 = r14.getContext()
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.WindowManager r0 = r0.getWindowManager()
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getOrientation()
            if (r0 == 0) goto L_0x014f
            if (r0 == r13) goto L_0x0154
            if (r0 == r9) goto L_0x0151
            if (r0 == r8) goto L_0x0156
        L_0x014f:
            r6 = 0
            goto L_0x0156
        L_0x0151:
            r6 = 180(0xb4, float:2.52E-43)
            goto L_0x0156
        L_0x0154:
            r6 = 90
        L_0x0156:
            int r11 = r11 - r6
            int r11 = r11 + 360
            int r11 = r11 % 360
            r14.displayRotation = r11
            android.hardware.Camera r0 = r14.camera
            r0.setDisplayOrientation(r11)
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            android.hardware.Camera$Size r0 = r0.getPreviewSize()
            int r0 = r0.height
            r14.frameHeight = r0
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            android.hardware.Camera$Size r0 = r0.getPreviewSize()
            int r0 = r0.width
            r14.frameWidth = r0
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            int r0 = r0.getPreviewFormat()
            r14.frameFormat = r0
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            int r0 = r0.getPreviewFormat()
            int r0 = android.graphics.ImageFormat.getBitsPerPixel(r0)
            int r1 = r14.frameHeight
            long r6 = (long) r1
            int r1 = r14.frameWidth
            long r8 = (long) r1
            long r6 = r6 * r8
            long r0 = (long) r0
            long r6 = r6 * r0
            long r6 = r6 / r4
            int r0 = (int) r6
            byte[] r1 = new byte[r0]
            r14.rotatedFrame = r1
        L_0x019d:
            if (r12 >= r2) goto L_0x01af
            byte[][] r1 = r14.buffer
            byte[] r4 = new byte[r0]
            r1[r12] = r4
            android.hardware.Camera r4 = r14.camera
            r1 = r1[r12]
            r4.addCallbackBuffer(r1)
            int r12 = r12 + 1
            goto L_0x019d
        L_0x01af:
            int r0 = r14.mCurrentMode
            if (r0 != r13) goto L_0x01bf
            android.hardware.Camera r0 = r14.camera
            com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$2 r1 = new com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$2
            r1.<init>()
            r0.setPreviewCallbackWithBuffer(r1)
            goto L_0x0273
        L_0x01bf:
            android.hardware.Camera r0 = r14.camera
            r0.setPreviewCallbackWithBuffer(r3)
            goto L_0x0273
        L_0x01c6:
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            r14.cameraParameters = r0
            r0.setPreviewFormat(r10)
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            int r1 = FRAME_WIDTH
            int r2 = FRAME_HEIGHT
            r0.setPreviewSize(r1, r2)
            android.hardware.Camera r0 = r14.camera
            android.hardware.Camera$Parameters r1 = r14.cameraParameters
            r0.setParameters(r1)
            android.content.Context r0 = r14.getContext()
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.WindowManager r0 = r0.getWindowManager()
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getOrientation()
            if (r0 == 0) goto L_0x01fb
            if (r0 == r13) goto L_0x0200
            if (r0 == r9) goto L_0x01fd
            if (r0 == r8) goto L_0x0202
        L_0x01fb:
            r6 = 0
            goto L_0x0202
        L_0x01fd:
            r6 = 180(0xb4, float:2.52E-43)
            goto L_0x0202
        L_0x0200:
            r6 = 90
        L_0x0202:
            int r11 = r11 - r6
            int r11 = r11 + 360
            int r11 = r11 % 360
            r14.displayRotation = r11
            android.hardware.Camera r0 = r14.camera     // Catch:{ Exception -> 0x022d }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x022d }
            java.lang.String r1 = "setDisplayOrientation"
            java.lang.Class[] r2 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x022d }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x022d }
            r2[r12] = r6     // Catch:{ Exception -> 0x022d }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ Exception -> 0x022d }
            if (r0 == 0) goto L_0x0231
            android.hardware.Camera r1 = r14.camera     // Catch:{ Exception -> 0x022d }
            java.lang.Object[] r2 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x022d }
            int r6 = r14.displayRotation     // Catch:{ Exception -> 0x022d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x022d }
            r2[r12] = r6     // Catch:{ Exception -> 0x022d }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x022d }
            goto L_0x0231
        L_0x022d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0231:
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            android.hardware.Camera$Size r0 = r0.getPreviewSize()
            int r0 = r0.height
            r14.frameHeight = r0
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            android.hardware.Camera$Size r0 = r0.getPreviewSize()
            int r0 = r0.width
            r14.frameWidth = r0
            android.hardware.Camera$Parameters r0 = r14.cameraParameters
            int r0 = r0.getPreviewFormat()
            r14.frameFormat = r0
            int r0 = r14.frameHeight
            long r0 = (long) r0
            int r2 = r14.frameWidth
            long r6 = (long) r2
            long r0 = r0 * r6
            r6 = 12
            long r0 = r0 * r6
            long r0 = r0 / r4
            int r1 = (int) r0
            byte[] r0 = new byte[r1]
            r14.rotatedFrame = r0
            int r0 = r14.mCurrentMode
            if (r0 != r13) goto L_0x026e
            android.hardware.Camera r0 = r14.camera
            com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$3 r1 = new com.baidu.wallet.base.iddetect.view.SurfaceViewForScan$3
            r1.<init>()
            r0.setPreviewCallback(r1)
            goto L_0x0273
        L_0x026e:
            android.hardware.Camera r0 = r14.camera
            r0.setPreviewCallback(r3)
        L_0x0273:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.setupCamera():void");
    }

    public void autoFocus() {
        Camera.Parameters parameters;
        try {
            if (this.camera != null && (parameters = this.camera.getParameters()) != null && parameters.getSupportedFocusModes() != null) {
                if (parameters.getFocusMode() != null) {
                    if (!parameters.getSupportedFocusModes().contains("auto")) {
                        return;
                    }
                    if (parameters.getFocusMode().equals("auto")) {
                        this.camera.autoFocus((Camera.AutoFocusCallback) null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IdCardActivity getAttachedActivity() {
        return this.mAttachedActivity;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public int getCameraID() {
        return this.cameraID;
    }

    public Camera.PictureCallback getPictureCallback() {
        return this.mPictureCallback;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        pointFocus(motionEvent.getX(), motionEvent.getY());
        return super.onTouchEvent(motionEvent);
    }

    public void pointFocus(float f, float f2) {
        Camera.Parameters parameters;
        try {
            if (this.camera != null && (parameters = this.camera.getParameters()) != null && parameters.getSupportedFocusModes() != null) {
                if (parameters.getFocusMode() != null) {
                    if (!parameters.getSupportedFocusModes().contains("auto")) {
                        return;
                    }
                    if (parameters.getFocusMode().equals("auto")) {
                        ArrayList arrayList = new ArrayList();
                        int clamp = clamp((int) (((f / ((float) getWidth())) * 2000.0f) - 1000.0f), -1000, getWidth() - this.focusAreaSize);
                        int clamp2 = clamp((int) (((f2 / ((float) getHeight())) * 2000.0f) - 1000.0f), -1000, getHeight() - this.focusAreaSize);
                        String str = TAG;
                        LogUtil.d(str, "getWidth()" + getWidth() + "getHeight()" + getHeight());
                        String str2 = TAG;
                        LogUtil.d(str2, "left" + clamp + "top" + clamp2);
                        arrayList.add(new Camera.Area(new Rect(clamp, clamp2, this.focusAreaSize + clamp, this.focusAreaSize + clamp2), 1000));
                        this.camera.cancelAutoFocus();
                        parameters.setFocusMode("auto");
                        parameters.setFocusAreas(arrayList);
                        this.camera.setParameters(parameters);
                        this.camera.autoFocus(this.mFocusCallback);
                    }
                }
            }
        } catch (Exception unused) {
            autoFocus();
        }
    }

    public void releaseSource() {
        try {
            if (this.camera != null) {
                this.camera.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                this.camera.setPreviewCallback((Camera.PreviewCallback) null);
                this.camera.stopPreview();
                this.camera.release();
                this.camera = null;
            }
            if (this.looperThread != null && this.looperThread.handler != null) {
                this.looperThread.handler.getLooper().quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.mAttachedActivity = idCardActivity;
    }

    public void setAutoFocusCallback(Camera.AutoFocusCallback autoFocusCallback) {
        this.mFocusCallback = autoFocusCallback;
    }

    public void setPictureCallback(Camera.PictureCallback pictureCallback) {
        this.mPictureCallback = pictureCallback;
    }

    public void setPreviewCallback(Callback callback2) {
        this.callback = callback2;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder2, int i2, int i3, int i4) {
        if (surfaceHolder2.getSurface() != null) {
            try {
                if (this.camera != null) {
                    this.camera.stopPreview();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                setupCamera();
                if (this.camera != null) {
                    this.camera.setPreviewDisplay(surfaceHolder2);
                    this.camera.startPreview();
                    autoFocus();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder2) {
        initCamera();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder2) {
        Handler handler;
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.release();
        }
        LooperThread looperThread2 = this.looperThread;
        if (looperThread2 != null && (handler = looperThread2.handler) != null) {
            handler.getLooper().quit();
        }
    }

    public void switchCamera() {
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 != null && surfaceHolder2.getSurface() != null) {
            if (this.mCurrentCameraPosition == 1) {
                this.mCurrentCameraPosition = 0;
            } else {
                this.mCurrentCameraPosition = 1;
            }
            try {
                releaseSource();
                initCamera();
                setupCamera();
                this.camera.setPreviewDisplay(this.surfaceHolder);
                this.camera.startPreview();
                autoFocus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void takePicture() {
        Camera camera2;
        Camera.PictureCallback pictureCallback;
        if (this.mCurrentMode == 0 && (camera2 = this.camera) != null && (pictureCallback = this.mPictureCallback) != null) {
            camera2.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, pictureCallback);
        }
    }

    public SurfaceViewForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SurfaceViewForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.buffer = new byte[4][];
        this.mCurrentCameraPosition = 0;
        this.mCurrentMode = 1;
        this.mPictureCallback = null;
        this.mContext = null;
        this.focusAreaSize = 100;
        init(context, attributeSet, i2);
    }
}
