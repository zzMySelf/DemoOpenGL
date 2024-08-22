package com.baidu.searchbox.music.player;

import com.baidu.searchbox.player.utils.SimpleCyberInstallListener;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/music/player/DuMediaPlayer$initMusic$1", "Lcom/baidu/searchbox/player/utils/SimpleCyberInstallListener;", "onInstallError", "", "p0", "", "p1", "p2", "", "onInstallInfo", "", "onInstallProgress", "onInstallSuccess", "lib-music-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DuMediaPlayer.kt */
public final class DuMediaPlayer$initMusic$1 extends SimpleCyberInstallListener {
    final /* synthetic */ InvokeCallback $callback;

    DuMediaPlayer$initMusic$1(InvokeCallback $callback2) {
        this.$callback = $callback2;
    }

    public void onInstallError(int p0, int p1, String p2) {
        this.$callback.onResult(14, (String) null);
    }

    public void onInstallSuccess(int p0, String p1) {
        this.$callback.onResult(0, (String) null);
    }

    public void onInstallProgress(int p0, int p1) {
    }

    public void onInstallInfo(int p0, int p1, Object p2) {
    }
}
