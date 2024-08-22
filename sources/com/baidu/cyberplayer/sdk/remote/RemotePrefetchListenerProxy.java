package com.baidu.cyberplayer.sdk.remote;

import com.baidu.cyberplayer.sdk.DuMediaPrefetchBase;
import com.baidu.cyberplayer.sdk.remote.IPrefetchListener;

public class RemotePrefetchListenerProxy extends IPrefetchListener.Stub {
    private DuMediaPrefetchBase.OnPrefetchListener mPrefetchListener = null;

    public RemotePrefetchListenerProxy(DuMediaPrefetchBase.OnPrefetchListener listener) {
        this.mPrefetchListener = listener;
    }

    public boolean updatePrefetchListener(DuMediaPrefetchBase.OnPrefetchListener listener) {
        if (listener == this.mPrefetchListener) {
            return false;
        }
        this.mPrefetchListener = listener;
        return true;
    }

    public void onPrefetchStatusChanged(String url, boolean succeed, int errCode, String errInfo) {
        DuMediaPrefetchBase.OnPrefetchListener listener = this.mPrefetchListener;
        if (listener != null) {
            listener.onPrefetchStatusChanged(url, succeed, errCode, errInfo);
        }
    }
}
