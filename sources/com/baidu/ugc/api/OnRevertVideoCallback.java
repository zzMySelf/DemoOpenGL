package com.baidu.ugc.api;

import android.os.RemoteException;

public interface OnRevertVideoCallback {
    void onConvertAborted() throws RemoteException;

    void onConvertFailed() throws RemoteException;

    void onConvertProgress(int i2) throws RemoteException;

    void onConvertSuccess() throws RemoteException;

    void onResult(boolean z, String str);
}
