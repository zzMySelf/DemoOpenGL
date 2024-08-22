package com.baidu.netdisk.transfer.base;

import android.os.Looper;
import android.os.Message;
import com.baidu.netdisk.kernel.android.ext.WeakReferenceHandler;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.transfer.io.model.UploadResponseModel;

public class NetdiskUploadCallback implements IUploadCallback {
    private static final String TAG = "NetdiskUploadCallback";
    private IUploadCallback mCallback;

    public NetdiskUploadCallback(IUploadCallback callback) {
        this.mCallback = callback;
    }

    public void onResult(UploadResponseModel model) {
        if (this.mCallback != null) {
            UploadPerformHandler uploadPerformHandler = new UploadPerformHandler(Looper.getMainLooper(), this.mCallback, model);
            Message msg = uploadPerformHandler.obtainMessage();
            msg.what = 6000;
            uploadPerformHandler.sendMessage(msg);
        }
    }

    private static class UploadPerformHandler extends WeakReferenceHandler<NetdiskUploadCallback> {
        private IUploadCallback mCallback;
        private UploadResponseModel mData;

        private UploadPerformHandler(NetdiskUploadCallback reference, Looper looper, IUploadCallback callback, UploadResponseModel data) {
            super(reference, looper);
            this.mCallback = callback;
            this.mData = data;
        }

        /* access modifiers changed from: protected */
        public void handleMessage(NetdiskUploadCallback reference, Message msg) {
            NetDiskLog.w(NetdiskUploadCallback.TAG, "【Upload-Interface】 handleMessage reference:" + reference);
            if (reference != null) {
                switch (msg.what) {
                    case 6000:
                        IUploadCallback iUploadCallback = this.mCallback;
                        if (iUploadCallback != null) {
                            iUploadCallback.onResult(this.mData);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
