package com.baidu.swan.apps.camera;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager;
import com.baidu.swan.apps.camera.listener.CameraTimeOutListener;
import com.baidu.swan.apps.camera.manager.ICameraManager;
import com.baidu.swan.apps.camera.model.CameraAttrModel;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.event.message.SwanAppCommonMessage;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.lifecycle.SwanAppWebViewCallback;
import com.baidu.swan.apps.lifecycle.WebViewLifecycleDispatcher;
import com.baidu.swan.apps.util.SwanAppSwanCoreUtils;
import com.baidu.swan.apps.view.container.util.SwanAppEventHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppCameraManager implements ICameraManager {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String KEY_CAMERA = "camera";
    private static final String KEY_CAMERA_ID = "cameraId";
    private static final String KEY_EXCEPTION_TYPE = "eType";
    private static final String KEY_SLAVE_ID = "wvID";
    public static final String TAG = "SwanAppCameraManager";
    private static final String TARGET_SWAN_VERSION = "1.13.0";
    private static final String VALUE_EXCEPTION_ERROR = "error";
    private static final String VALUE_EXCEPTION_STOP = "stop";
    private CameraTimeOutListener mCameraTimeOutListener;
    private CameraWebViewLifeCycleCallback mCameraWebViewCallback;
    private Timer mTimer;

    private SwanAppCameraManager() {
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final SwanAppCameraManager sInstance = new SwanAppCameraManager();

        private SingletonHolder() {
        }
    }

    public static SwanAppCameraManager getIns() {
        return SingletonHolder.sInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveImage(byte[] r16, java.lang.String r17, int r18, int r19, boolean r20) {
        /*
            r15 = this;
            r1 = r16
            r2 = r19
            r0 = 0
            if (r1 == 0) goto L_0x00e6
            int r3 = r1.length
            if (r3 == 0) goto L_0x00e6
            boolean r3 = android.text.TextUtils.isEmpty(r17)
            if (r3 == 0) goto L_0x0016
            r5 = r17
            r9 = r18
            goto L_0x00ea
        L_0x0016:
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ Exception | OutOfMemoryError -> 0x00d9 }
            r5 = r17
            r4.<init>(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            boolean r6 = r4.exists()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.String r7 = "SwanAppCameraManager"
            if (r6 == 0) goto L_0x0044
            boolean r6 = r4.delete()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            boolean r8 = DEBUG     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            if (r8 == 0) goto L_0x0044
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r8.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.String r9 = "delete = "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.StringBuilder r8 = r8.append(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            android.util.Log.d(r7, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
        L_0x0044:
            java.io.File r6 = r4.getParentFile()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            if (r6 == 0) goto L_0x006d
            java.io.File r6 = r4.getParentFile()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            boolean r6 = r6.mkdirs()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            boolean r8 = DEBUG     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            if (r8 == 0) goto L_0x006d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r8.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.String r9 = "mkdirs = "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.StringBuilder r8 = r8.append(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            android.util.Log.d(r7, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
        L_0x006d:
            boolean r6 = r4.createNewFile()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            boolean r8 = DEBUG     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            if (r8 == 0) goto L_0x008b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r8.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.String r9 = "createNewFile = "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.StringBuilder r8 = r8.append(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            android.util.Log.d(r7, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
        L_0x008b:
            int r7 = r1.length     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r1, r0, r7)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            if (r2 != 0) goto L_0x0094
            if (r20 == 0) goto L_0x00bc
        L_0x0094:
            android.graphics.Matrix r0 = new android.graphics.Matrix     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r0.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r0.reset()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            if (r2 == 0) goto L_0x00a2
            float r7 = (float) r2     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r0.postRotate(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
        L_0x00a2:
            if (r20 == 0) goto L_0x00ab
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r7, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
        L_0x00ab:
            r9 = 0
            r10 = 0
            int r11 = r8.getWidth()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            int r12 = r8.getHeight()     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r14 = 1
            r13 = r0
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r8 = r7
        L_0x00bc:
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r7.<init>(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r0.<init>(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception | OutOfMemoryError -> 0x00d7 }
            r9 = r18
            r8.compress(r7, r9, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00d5 }
            r0.flush()     // Catch:{ Exception | OutOfMemoryError -> 0x00d5 }
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00d5 }
            r3 = 1
            goto L_0x00e5
        L_0x00d5:
            r0 = move-exception
            goto L_0x00de
        L_0x00d7:
            r0 = move-exception
            goto L_0x00dc
        L_0x00d9:
            r0 = move-exception
            r5 = r17
        L_0x00dc:
            r9 = r18
        L_0x00de:
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x00e5
            r0.printStackTrace()
        L_0x00e5:
            return r3
        L_0x00e6:
            r5 = r17
            r9 = r18
        L_0x00ea:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.camera.SwanAppCameraManager.saveImage(byte[], java.lang.String, int, int, boolean):boolean");
    }

    public void startTimer(int delayTime, final CameraTimeOutListener listener) {
        this.mCameraTimeOutListener = listener;
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                CameraTimeOutListener cameraTimeOutListener = listener;
                if (cameraTimeOutListener != null) {
                    cameraTimeOutListener.timeOut();
                }
                SwanAppCameraManager.this.stopTimer();
            }
        }, (long) delayTime);
    }

    public void stopTimer() {
        this.mCameraTimeOutListener = null;
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void cancelTimer() {
        CameraTimeOutListener cameraTimeOutListener = this.mCameraTimeOutListener;
        if (cameraTimeOutListener != null) {
            cameraTimeOutListener.cancel();
        }
        stopTimer();
    }

    public void onSwanAppForegroundChange(boolean isBackground) {
        if (isBackground) {
            cancelTimer();
        }
    }

    public void onExceptionError(String slaveId, String cameraId, boolean errorType) {
        String str = "error";
        if (SwanAppSwanCoreUtils.isSwanCoreLowerThan(TARGET_SWAN_VERSION)) {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("wvID", slaveId);
            paramMap.put(KEY_CAMERA_ID, cameraId);
            if (!errorType) {
                str = "stop";
            }
            paramMap.put(KEY_EXCEPTION_TYPE, str);
            SwanAppController.getInstance().sendJSMessage(new SwanAppCommonMessage("camera", paramMap));
            return;
        }
        JSONObject paramMap2 = new JSONObject();
        try {
            paramMap2.put("wvID", slaveId);
            paramMap2.put(KEY_CAMERA_ID, cameraId);
            if (!errorType) {
                str = "stop";
            }
            paramMap2.put(KEY_EXCEPTION_TYPE, str);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        SwanAppEventHelper.sendEventToSlave(slaveId, cameraId, "camera", paramMap2.optString(KEY_EXCEPTION_TYPE), paramMap2);
    }

    public boolean hasCameraPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(context, "android.permission.CAMERA") != 0) {
            return false;
        }
        return true;
    }

    public boolean hasRecordPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") != 0) {
            return false;
        }
        return true;
    }

    public synchronized void registerWebViewLifeCycleCallback(CameraPreview cameraPreview, CameraAttrModel cameraModel) {
        if (DEBUG) {
            Log.d(TAG, "registerWebViewLifeCycleCallback");
        }
        if (this.mCameraWebViewCallback == null) {
            this.mCameraWebViewCallback = new CameraWebViewLifeCycleCallback(cameraPreview, cameraModel);
        }
        WebViewLifecycleDispatcher.register(this.mCameraWebViewCallback);
    }

    public synchronized void unRegisterWebViewLifeCycleCallback() {
        if (DEBUG) {
            Log.d(TAG, "unRegisterWebViewLifeCycleCallback");
        }
        CameraWebViewLifeCycleCallback cameraWebViewLifeCycleCallback = this.mCameraWebViewCallback;
        if (cameraWebViewLifeCycleCallback != null) {
            WebViewLifecycleDispatcher.unRegister(cameraWebViewLifeCycleCallback);
            this.mCameraWebViewCallback = null;
        }
    }

    public synchronized void updateCallbackParams(CameraPreview cameraPreview, CameraAttrModel cameraModel) {
        if (DEBUG) {
            Log.d(TAG, "updateWebViewLifeCycleCallbackParams");
        }
        CameraWebViewLifeCycleCallback cameraWebViewLifeCycleCallback = this.mCameraWebViewCallback;
        if (cameraWebViewLifeCycleCallback != null) {
            cameraWebViewLifeCycleCallback.updateParams(cameraPreview, cameraModel);
        }
    }

    public void onRelease() {
        try {
            CameraPreview.releaseCamera();
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        unRegisterWebViewLifeCycleCallback();
    }

    public static class CameraWebViewLifeCycleCallback implements SwanAppWebViewCallback {
        private CameraPreview mCameraView;
        private boolean mIsTorchMode;
        private String mWebViewId;

        public CameraWebViewLifeCycleCallback(CameraPreview cameraPreview, CameraAttrModel cameraModel) {
            updateParams(cameraPreview, cameraModel);
        }

        public void onCreate(ISwanAppWebViewManager viewManager) {
        }

        public void onResume(ISwanAppWebViewManager viewManager) {
            if (SwanAppCameraManager.DEBUG) {
                Log.d(SwanAppCameraManager.TAG, "onResume: CameraWebView");
            }
            if (isCameraTorchMode(viewManager)) {
                this.mCameraView.setFlashModeOutside("torch");
            }
        }

        public void onPause(ISwanAppWebViewManager viewManager) {
            if (SwanAppCameraManager.DEBUG) {
                Log.d(SwanAppCameraManager.TAG, "onPause: CameraWebView");
            }
            if (isCameraTorchMode(viewManager)) {
                this.mCameraView.setFlashModeOutside("off");
            }
        }

        public void onDestroy(ISwanAppWebViewManager viewManager) {
        }

        private boolean isCameraTorchMode(ISwanAppWebViewManager viewManager) {
            if (viewManager != null && TextUtils.equals(viewManager.getWebViewId(), this.mWebViewId) && this.mIsTorchMode) {
                return true;
            }
            return false;
        }

        public void updateParams(CameraPreview cameraPreview, CameraAttrModel cameraModel) {
            this.mCameraView = cameraPreview;
            this.mWebViewId = cameraModel.slaveId;
            this.mIsTorchMode = TextUtils.equals(cameraModel.getFlash(), "torch");
        }
    }
}
