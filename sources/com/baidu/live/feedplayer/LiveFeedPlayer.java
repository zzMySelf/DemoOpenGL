package com.baidu.live.feedplayer;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.baidu.live.feedplayer.base.LivePlayerProvider;
import com.baidu.live.feedplayer.base.MediaSource;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J+\u0010*\u001a\u0004\u0018\u0001H+\"\n\b\u0000\u0010+*\u0004\u0018\u00010,2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u0002H+\u0018\u00010.H\u0016¢\u0006\u0002\u0010/J\n\u00100\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0014H\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0014H\u0016J\b\u00108\u001a\u00020\u0014H\u0016J\b\u00109\u001a\u00020\u0014H\u0016J\b\u0010:\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u00020\u0014H\u0016J\b\u0010<\u001a\u00020\u0014H\u0016J\b\u0010=\u001a\u00020\u0014H\u0016J\b\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u00020\u0014H\u0016J\b\u0010@\u001a\u00020\u0014H\u0016J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0014H\u0016J\b\u0010B\u001a\u00020\u0007H\u0016J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0014H\u0016J\u0012\u0010E\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010G\u001a\u00020\u0007H\u0016J\b\u0010H\u001a\u00020\u0007H\u0016J$\u0010I\u001a\u00020\u00072\u0012\u0010 \u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010,\u0018\u00010.2\u0006\u0010J\u001a\u00020,H\u0016J\b\u0010K\u001a\u00020\u0007H\u0016J\u0010\u0010L\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010M\u001a\u00020\u00072\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010P\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J\b\u0010R\u001a\u00020\u0007H\u0016J\b\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0014H\u0016J\b\u0010U\u001a\u00020\u0007H\u0016J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0014H\u0016J\b\u0010X\u001a\u00020\u0007H\u0016J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u001dH\u0016J\u0018\u0010Y\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u001dH\u0016J\u0010\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0014H\u0016J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010c\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010dH\u0016J\u0010\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0014H\u0016J\u0012\u0010g\u001a\u00020\u00072\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010h\u001a\u00020\u00072\u0006\u0010i\u001a\u00020'H\u0016J\u0010\u0010j\u001a\u00020\u00072\u0006\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0014H\u0016J\u0012\u0010o\u001a\u00020\u00072\b\u0010p\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010q\u001a\u00020\u00072\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J0\u0010t\u001a\u00020\u00072&\u0010u\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0016\u0018\u00010vj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0016\u0018\u0001`wH\u0016J\u0010\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u001dH\u0016J\u0010\u0010z\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u001dH\u0016J\u0012\u0010{\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010|\u001a\u00020\u0007H\u0016J\b\u0010}\u001a\u00020\u0007H\u0016J\b\u0010~\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u00020\u0007H\u0016J1\u0010\u0001\u001a\u00020\u00072&\u0010u\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0016\u0018\u00010vj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0016\u0018\u0001`wH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/baidu/live/feedplayer/LiveFeedPlayer;", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "mediaSource", "Lcom/baidu/live/feedplayer/base/MediaSource;", "(Lcom/baidu/live/feedplayer/base/MediaSource;)V", "player", "addOnInfoListener", "", "onInfoListener", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnInfoListener;", "addProgressListener", "listener", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnProgressChangeListener;", "attachKernelLayer", "kernelLayer", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "attachToContainer", "holder", "Landroid/view/ViewGroup;", "checkMode", "", "mode", "", "detachFromContainer", "detachKernelLayer", "disableOrientationEventHelper", "enableOrientationEventHelper", "getCurrentMode", "getDuration", "", "getInfo", "", "key", "data", "cb", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$InfoCallback;", "getKernalScreenshot", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$KernalScreenshotListener;", "scale", "", "getPlayerCallbackManager", "Lcom/baidu/searchbox/player/callback/UniversalPlayerCallbackManager;", "getPlayerContext", "T", "Lcom/baidu/searchbox/player/context/IPlayerContext;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/baidu/searchbox/player/context/IPlayerContext;", "getPlayerKernelLayer", "getPosition", "getServerIpInfo", "getVideoUrl", "goBackOrForeground", "isForeground", "imCloseTimeStatistics", "isComplete", "isError", "isFloatingMode", "isIdle", "isPause", "isPlaying", "isReverseLandscape", "isStop", "isUseCache", "isUseLivePreStartPlayer", "mute", "pause", "pauseInternal", "isUserClick", "play", "url", "prePlay", "prepare", "registerContext", "context", "release", "removeOnInfoListener", "removePlayerListener", "callback", "Lcom/baidu/searchbox/player/callback/IVideoPlayerCallback;", "removeProgressListener", "requestPlayerAudioFocus", "resetDefaultSwitchHelper", "resume", "isForce", "resumeFromError", "resumePlayer", "isClearPos", "saveProgressToDb", "seekTo", "p0", "msec", "seekmode", "sendEvent", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "setAcceptVolumeChange", "accept", "setMode", "setOnAudioFocusChangedListener", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnAudioFocusChangedListener;", "setOrientationLock", "lock", "setPlayerListener", "setSpeed", "i", "setStyleSwitchHelper", "helper", "Lcom/baidu/searchbox/player/helper/IPlayerStyleSwitchHelper;", "setUseLivePreStartPlayerState", "isUse", "setUserAgent", "ua", "setVideoBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setVideoInfo", "videoInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setVideoRotation", "rotation", "setVideoScalingMode", "setVideoUrl", "start", "stop", "stopTimeStatistics", "switchToHalf", "updateVideoInfo", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFeedPlayer.kt */
public final class LiveFeedPlayer implements LivePlayer {
    private LivePlayer player;

    public LiveFeedPlayer(MediaSource mediaSource) {
        Intrinsics.checkNotNullParameter(mediaSource, "mediaSource");
        String roomId = mediaSource.getRoomId();
        this.player = LivePlayerProvider.INSTANCE.createPlayer(roomId == null ? "0000" : roomId);
    }

    public void setExtInfoStatistics(HashMap<String, String> extInfo) {
        LivePlayer.DefaultImpls.setExtInfoStatistics(this, extInfo);
    }

    public void resume(boolean isForce) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.resume(isForce);
        }
    }

    public void resume() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.resume();
        }
    }

    public void addProgressListener(LivePlayer.OnProgressChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.addProgressListener(listener);
        }
    }

    public void removeProgressListener(LivePlayer.OnProgressChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.removeProgressListener(listener);
        }
    }

    public void goBackOrForeground(boolean isForeground) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.goBackOrForeground(isForeground);
        }
    }

    public boolean isComplete() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isComplete();
        }
        return false;
    }

    public boolean isError() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isError();
        }
        return false;
    }

    public String getServerIpInfo() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getServerIpInfo();
        }
        return null;
    }

    public void setPlayerListener(IVideoPlayerCallback callback) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setPlayerListener(callback);
        }
    }

    public void removePlayerListener(IVideoPlayerCallback callback) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.removePlayerListener(callback);
        }
    }

    public void sendEvent(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.sendEvent(event);
        }
    }

    public boolean isFloatingMode() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isFloatingMode();
        }
        return false;
    }

    public void resumeFromError() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.resumeFromError();
        }
    }

    public void resumePlayer(boolean isClearPos) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.resumePlayer(isClearPos);
        }
    }

    public boolean isPause() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isPause();
        }
        return false;
    }

    public boolean isStop() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isStop();
        }
        return false;
    }

    public boolean isIdle() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isStop();
        }
        return true;
    }

    public void setSpeed(float i2) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setSpeed(i2);
        }
    }

    public void attachToContainer(ViewGroup holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.attachToContainer(holder);
        }
    }

    public void detachFromContainer() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.detachFromContainer();
        }
    }

    public void attachKernelLayer(BaseKernelLayer kernelLayer) {
        Intrinsics.checkNotNullParameter(kernelLayer, "kernelLayer");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.attachKernelLayer(kernelLayer);
        }
    }

    public BaseKernelLayer getPlayerKernelLayer() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getPlayerKernelLayer();
        }
        return null;
    }

    public BaseKernelLayer detachKernelLayer() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.detachKernelLayer();
        }
        return null;
    }

    public String getVideoUrl() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getVideoUrl();
        }
        return null;
    }

    public void setVideoInfo(HashMap<Integer, String> videoInfo) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setVideoInfo(videoInfo);
        }
    }

    public void updateVideoInfo(HashMap<Integer, String> videoInfo) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.updateVideoInfo(videoInfo);
        }
    }

    public void switchToHalf() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.switchToHalf();
        }
    }

    public boolean checkMode(String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.checkMode(mode);
        }
        return false;
    }

    public String getCurrentMode() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getCurrentMode();
        }
        return null;
    }

    public void setMode(String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setMode(mode);
        }
    }

    public void enableOrientationEventHelper() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.enableOrientationEventHelper();
        }
    }

    public void disableOrientationEventHelper() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.disableOrientationEventHelper();
        }
    }

    public void resetDefaultSwitchHelper() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.resetDefaultSwitchHelper();
        }
    }

    public int getPosition() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getPosition();
        }
        return -1;
    }

    public void pauseInternal(boolean isUserClick) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.pauseInternal(isUserClick);
        }
    }

    public int getDuration() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getDuration();
        }
        return -1;
    }

    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        LivePlayer livePlayer = this.player;
        Intrinsics.checkNotNull(livePlayer);
        return livePlayer.getPlayerCallbackManager();
    }

    public void setOrientationLock(boolean lock) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setOrientationLock(lock);
        }
    }

    public boolean isReverseLandscape() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isReverseLandscape();
        }
        return false;
    }

    public void setStyleSwitchHelper(IPlayerStyleSwitchHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setStyleSwitchHelper(helper);
        }
    }

    public void saveProgressToDb() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.saveProgressToDb();
        }
    }

    public void registerContext(Class<? extends IPlayerContext> key, IPlayerContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.registerContext(key, context);
        }
    }

    public <T extends IPlayerContext> T getPlayerContext(Class<T> clazz) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getPlayerContext(clazz);
        }
        return null;
    }

    public void release() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.release();
        }
    }

    public void stopTimeStatistics() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.stopTimeStatistics();
        }
    }

    public void imCloseTimeStatistics() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.imCloseTimeStatistics();
        }
    }

    public Object getInfo(Object key, Object data, LivePlayer.InfoCallback cb) {
        Intrinsics.checkNotNullParameter(key, "key");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.getInfo(key, data, cb);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if ((r0 != null ? r0.getPlayerKernelLayer() : null) == null) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getKernalScreenshot(com.baidu.searchbox.live.interfaces.player.LivePlayer.KernalScreenshotListener r8, float r9) {
        /*
            r7 = this;
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.baidu.searchbox.live.interfaces.player.LivePlayer r0 = r7.player
            if (r0 == 0) goto L_0x0013
            if (r0 == 0) goto L_0x0010
            com.baidu.searchbox.player.layer.BaseKernelLayer r0 = r0.getPlayerKernelLayer()
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 != 0) goto L_0x001c
        L_0x0013:
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r8
            com.baidu.searchbox.live.interfaces.player.LivePlayer.KernalScreenshotListener.DefaultImpls.onResult$default(r1, r2, r3, r4, r5, r6)
        L_0x001c:
            com.baidu.searchbox.live.interfaces.player.LivePlayer r0 = r7.player
            if (r0 == 0) goto L_0x0023
            r0.getKernalScreenshot(r8, r9)
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.feedplayer.LiveFeedPlayer.getKernalScreenshot(com.baidu.searchbox.live.interfaces.player.LivePlayer$KernalScreenshotListener, float):void");
    }

    public void setOnAudioFocusChangedListener(LivePlayer.OnAudioFocusChangedListener listener) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setOnAudioFocusChangedListener(listener);
        }
    }

    public void requestPlayerAudioFocus() {
    }

    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Intrinsics.checkNotNullParameter(onInfoListener, "onInfoListener");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.addOnInfoListener(onInfoListener);
        }
    }

    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Intrinsics.checkNotNullParameter(onInfoListener, "onInfoListener");
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.removeOnInfoListener(onInfoListener);
        }
    }

    public void seekTo(int msec, int seekmode) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.seekTo(msec, seekmode);
        }
    }

    public void seekTo(int p0) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.seekTo(p0);
        }
    }

    public void prePlay() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.prePlay();
        }
    }

    public void setAcceptVolumeChange(boolean accept) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setAcceptVolumeChange(accept);
        }
    }

    public void start() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.start();
        }
    }

    public void pause() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.pause();
        }
    }

    public void setVideoUrl(String url) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setVideoUrl(url);
        }
    }

    public void stop() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.stop();
        }
    }

    public boolean isUseCache() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isUseCache();
        }
        return false;
    }

    public void setUseLivePreStartPlayerState(boolean isUse) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setUseLivePreStartPlayerState(isUse);
        }
    }

    public boolean isUseLivePreStartPlayer() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isUseLivePreStartPlayer();
        }
        return false;
    }

    public void play(String url) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.play(url);
        }
    }

    public boolean isPlaying() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            return livePlayer.isPlaying();
        }
        return false;
    }

    public void prepare() {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.prepare();
        }
    }

    public void setVideoScalingMode(int scale) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setVideoScalingMode(scale);
        }
    }

    public void setVideoBackground(Drawable drawable) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setVideoBackground(drawable);
        }
    }

    public void setVideoRotation(int rotation) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setVideoRotation(rotation);
        }
    }

    public void setUserAgent(String ua) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.setUserAgent(ua);
        }
    }

    public void mute(boolean mute) {
        LivePlayer livePlayer = this.player;
        if (livePlayer != null) {
            livePlayer.mute(mute);
        }
    }
}
