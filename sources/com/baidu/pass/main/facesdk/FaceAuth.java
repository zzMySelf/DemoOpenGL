package com.baidu.pass.main.facesdk;

import android.util.Log;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;

public class FaceAuth {
    private static final String TAG = "FaceSDK";
    private boolean isLoadSucess = false;

    public FaceAuth() {
        try {
            System.loadLibrary("bd_pass_face_sdk");
            this.isLoadSucess = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public native int nativeCreatInstance();

    private native void nativeSetActiveLog(int i2, int i3);

    private native void nativeSetCoreConfigure(int i2, int i3);

    public void initLicense(final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i2 = -1;
                try {
                    i2 = FaceAuth.this.nativeCreatInstance();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Log.e(FaceAuth.TAG, "bdface_create_instance status " + -1);
                }
                callback.onResponse(i2, "OK");
            }
        });
    }

    public boolean isLoadSucess() {
        return this.isLoadSucess;
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i2) {
        try {
            nativeSetActiveLog(bDFaceLogInfo.ordinal(), i2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i2) {
        try {
            nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
