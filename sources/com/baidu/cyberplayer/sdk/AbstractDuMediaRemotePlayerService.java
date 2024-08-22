package com.baidu.cyberplayer.sdk;

import android.app.Service;

public abstract class AbstractDuMediaRemotePlayerService extends Service {
    private boolean mAsyncInitTurbonet = false;

    public abstract long getKernelNetHandle();

    public abstract long getPCDNNetHandle();

    public abstract boolean installSuccess();

    public abstract void notifyTurbonetInited();

    public abstract void remoteInstallNewType(int i2);

    public boolean isAsyncInitTurbonet() {
        return this.mAsyncInitTurbonet;
    }

    public void setAsyncInitTurbonet(boolean asyncInit) {
        this.mAsyncInitTurbonet = asyncInit;
    }
}
