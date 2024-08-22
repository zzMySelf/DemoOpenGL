package com.baidu.searchbox.nadcore.player;

import com.baidu.nadcore.player.IPlayerStatusCallback;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0016¨\u0006!"}, d2 = {"com/baidu/searchbox/nadcore/player/PlayerProxy$setPlayerListener$1", "Lcom/baidu/searchbox/player/callback/IVideoPlayerCallback;", "goBackOrForeground", "", "isForeground", "", "onBufferEnd", "onBufferStart", "onEnd", "what", "", "onError", "extra", "info", "", "onGlobalOrientationLock", "var1", "onInfo", "onNetworkSpeedUpdate", "speed", "onPause", "onPlayerKernelPreEmpted", "onPrepared", "onResume", "onSeekEnd", "onStart", "onUpdateProgress", "progress", "buffer", "max", "onVideoSizeChanged", "width", "height", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerProxy.kt */
public final class PlayerProxy$setPlayerListener$1 implements IVideoPlayerCallback {
    final /* synthetic */ IPlayerStatusCallback $callback;

    PlayerProxy$setPlayerListener$1(IPlayerStatusCallback $callback2) {
        this.$callback = $callback2;
    }

    public void onStart() {
        this.$callback.onStart();
    }

    public void onPause() {
        this.$callback.onPause();
    }

    public void onResume() {
        this.$callback.onResume();
    }

    public void onEnd(int what) {
        this.$callback.onEnd(what);
    }

    public void onBufferStart() {
        this.$callback.onBufferStart();
    }

    public void onBufferEnd() {
        this.$callback.onBufferEnd();
    }

    public void onNetworkSpeedUpdate(int speed) {
        this.$callback.onNetworkSpeedUpdate(speed);
    }

    public void onSeekEnd() {
        this.$callback.onSeekEnd();
    }

    public void onError(int what, int extra, String info) {
        this.$callback.onError(what, extra, info == null ? "" : info);
    }

    public void onInfo(int what, int extra) {
        this.$callback.onInfo(what, extra);
    }

    public void onPrepared() {
        this.$callback.onPrepared();
    }

    public void onVideoSizeChanged(int width, int height) {
        this.$callback.onVideoSizeChanged(width, height);
    }

    public void goBackOrForeground(boolean isForeground) {
        this.$callback.goBackOrForeground(isForeground);
    }

    public void onUpdateProgress(int progress, int buffer, int max) {
        this.$callback.onUpdateProgress(progress, buffer, max);
    }

    public void onGlobalOrientationLock(boolean var1) {
    }

    public void onPlayerKernelPreEmpted() {
    }
}
