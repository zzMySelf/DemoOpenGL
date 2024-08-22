package com.baidu.cyberplayer.sdk;

import android.os.RemoteException;

public class DuMediaInstallBase {

    public interface InstallListener {
        void onInstallError(int i2, int i3, String str);

        @Deprecated
        void onInstallProgress(int i2, int i3);

        void onInstallSuccess(int i2, String str) throws RemoteException;
    }

    public interface InstallListener2 extends InstallListener {
        void onInstallInfo(int i2, int i3, Object obj);
    }
}
