package com.baidu.swan.apps.process.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.swan.apps.IAsyncProcessCallback;
import com.baidu.swan.apps.IProcessBridge;

public class SwanProcessCallStub extends IProcessBridge.Stub {
    private final Handler mHandler;

    public SwanProcessCallStub(Handler handler) {
        this.mHandler = handler;
    }

    public void send(Message msg) throws RemoteException {
        if (msg != null && this.mHandler != null) {
            msg.sendingUid = Binder.getCallingUid();
            this.mHandler.sendMessage(msg);
        }
    }

    public Bundle callMainProcessSync(String identify, Bundle bundle) throws RemoteException {
        if (TextUtils.isEmpty(identify)) {
            return null;
        }
        return SwanProcessCallManager.callOnMainProcess(identify, bundle);
    }

    public void callMainProcessAsync(String identify, int id, IAsyncProcessCallback callback) throws RemoteException {
    }
}
