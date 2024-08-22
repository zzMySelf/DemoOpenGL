package com.baidu.pass.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKActionConfig;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import java.util.concurrent.atomic.AtomicInteger;

public class FaceActionLive {
    private static final String TAG = FaceActionLive.class.getSimpleName();
    /* access modifiers changed from: private */
    public BDFaceInstance bdFaceInstance;
    private int[] isExist = new int[1];

    public FaceActionLive() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public FaceActionLive(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance != null) {
            this.bdFaceInstance = bDFaceInstance;
        }
    }

    private native int nativeActionLive(long j2, int i2, BDFaceImageInstance bDFaceImageInstance, float[] fArr, int[] iArr);

    /* access modifiers changed from: private */
    public native int nativeActionLiveModelInit(long j2, byte[] bArr, byte[] bArr2);

    private native void nativeActionLoadConfig(long j2, BDFaceSDKActionConfig bDFaceSDKActionConfig);

    private native int nativeClearHistory(long j2);

    private native int nativeUninitActionLiveModel(long j2);

    public int actionLive(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceActionLiveType == null || atomicInteger == null) {
            Log.v(TAG, "Parameter is null");
            return -1;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        int nativeActionLive = nativeActionLive(index, bDFaceActionLiveType.ordinal(), bDFaceImageInstance, fArr, this.isExist);
        atomicInteger.set(this.isExist[0]);
        return nativeActionLive;
    }

    public int clearHistory() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeClearHistory(index);
    }

    public void initActionLiveModel(Context context, String str, String str2, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str3 = str;
        final String str4 = str2;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceActionLive.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str3);
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str4);
                    if (modelContent.length != 0 && modelContent2.length != 0) {
                        int access$100 = FaceActionLive.this.nativeActionLiveModelInit(index, modelContent, modelContent2);
                        Callback callback = callback2;
                        if (access$100 == 0) {
                            callback.onResponse(access$100, "动作活体模型加载成功");
                        } else {
                            callback.onResponse(access$100, "动作活体模型加载失败");
                        }
                    }
                }
            }
        });
    }

    public void loadActionConfig(BDFaceSDKActionConfig bDFaceSDKActionConfig) {
        BDFaceInstance bDFaceInstance = this.bdFaceInstance;
        if (bDFaceInstance != null) {
            long index = bDFaceInstance.getIndex();
            if (index != 0) {
                nativeActionLoadConfig(index, bDFaceSDKActionConfig);
            }
        }
    }

    public int uninitActionLiveModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitActionLiveModel(index);
    }
}
