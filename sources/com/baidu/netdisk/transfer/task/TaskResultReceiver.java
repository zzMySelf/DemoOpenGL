package com.baidu.netdisk.transfer.task;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.netdisk.base.service.constant.BaseExtras;
import com.baidu.netdisk.util.WeakRefResultReceiver;

public abstract class TaskResultReceiver<T> extends WeakRefResultReceiver<T> {
    private static final int STATUS_FAILED = 2;
    private static final int STATUS_SUCCESS = 1;
    private static final String TAG = "TaskResultReceiver";

    public TaskResultReceiver(T reference, Handler handler) {
        super(reference, handler);
    }

    /* access modifiers changed from: protected */
    public boolean onInterceptResult(T t, int resultCode, Bundle resultData) {
        switch (resultCode) {
            case 1:
                onSuccess();
                return true;
            case 2:
                if (resultData == null) {
                    return true;
                }
                onFailed(resultData.getInt(BaseExtras.ERROR, 0));
                return true;
            default:
                return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onSuccess() {
    }

    /* access modifiers changed from: protected */
    public void handleSuccess(T t) {
    }

    /* access modifiers changed from: protected */
    public void onFailed(int errorCode) {
    }

    /* access modifiers changed from: protected */
    public void handleFailed(T t) {
    }

    public void sendSuccess() {
        send(1, (Bundle) null);
    }

    public void sendFailed(int errorCode) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseExtras.ERROR, errorCode);
        send(2, bundle);
    }
}
