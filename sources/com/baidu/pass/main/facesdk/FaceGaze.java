package com.baidu.pass.main.facesdk;

import android.content.Context;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceGazeInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.utils.FileUitls;

public class FaceGaze {
    private static final String TAG = FaceGaze.class.getSimpleName();
    /* access modifiers changed from: private */
    public BDFaceInstance bdFaceInstance;

    public FaceGaze() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public FaceGaze(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance != null) {
            this.bdFaceInstance = bDFaceInstance;
        }
    }

    private native BDFaceGazeInfo nativeGaze(long j2, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* access modifiers changed from: private */
    public native int nativeGazeModelInit(long j2, byte[] bArr);

    private native int nativeUninitGazeModel(long j2);

    public BDFaceGazeInfo gaze(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance == null || fArr == null || fArr.length < 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeGaze(index, bDFaceImageInstance, fArr);
    }

    public void initModel(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceGaze.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    int i2 = -1;
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    if (modelContent.length != 0 && (i2 = FaceGaze.this.nativeGazeModelInit(index, modelContent)) != 0) {
                        callback.onResponse(i2, "注意力检测模型加载失败");
                    } else if (i2 == 0) {
                        callback.onResponse(0, "注意力检测模型加载成功");
                    } else {
                        callback.onResponse(1, "注意力检测模型加载失败");
                    }
                }
            }
        });
    }

    public int uninitGazeModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitGazeModel(index);
    }
}
