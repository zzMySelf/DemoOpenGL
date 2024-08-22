package com.baidu.cyberplayer.sdk.remote;

import com.baidu.cyberplayer.sdk.downloadcore.DuMediaDownloaderInfoBase;
import com.baidu.cyberplayer.sdk.remote.IDownloaderInfoListener;

public class RemoteDownloaderInfoListenerProxy extends IDownloaderInfoListener.Stub {
    private DuMediaDownloaderInfoBase.OnDownloaderInfoListener mListener = null;

    public RemoteDownloaderInfoListenerProxy(DuMediaDownloaderInfoBase.OnDownloaderInfoListener listener) {
        this.mListener = listener;
    }

    public boolean updateDownloaderInfoListener(DuMediaDownloaderInfoBase.OnDownloaderInfoListener listener) {
        if (listener == this.mListener) {
            return false;
        }
        this.mListener = listener;
        return true;
    }

    public void onMessageCallback(int aInt, String aString) {
        DuMediaDownloaderInfoBase.OnDownloaderInfoListener listener = this.mListener;
        if (listener != null) {
            listener.onDownloadTaskMessageCallback(aInt, aString);
        }
    }
}
