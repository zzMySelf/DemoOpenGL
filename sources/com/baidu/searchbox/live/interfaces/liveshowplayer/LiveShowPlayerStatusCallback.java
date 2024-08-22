package com.baidu.searchbox.live.interfaces.liveshowplayer;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerStatusCallback;", "", "onBufferEnd", "", "onBufferStart", "onEnded", "onError", "var1", "", "var2", "onInfo", "onInfoExtent", "onPause", "onPrepared", "onResume", "onStart", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LiveShowPlayerStatusCallback.kt */
public interface LiveShowPlayerStatusCallback {
    void onBufferEnd();

    void onBufferStart();

    void onEnded();

    void onError(int i2, int i3);

    void onInfo(int i2, int i3);

    void onInfoExtent(int i2, Object obj);

    void onPause();

    void onPrepared();

    void onResume();

    void onStart();
}
