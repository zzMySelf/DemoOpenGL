package com.baidu.searchbox.videoplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.PosterLayer;
import com.baidu.searchbox.player.strategy.IVideoUpdateStrategy;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020\u0014J\b\u0010%\u001a\u00020 H\u0016J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020 H\u0016J\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0014J\u0012\u0010+\u001a\u00020 2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010,\u001a\u00020 H\u0014J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020 H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u00060"}, d2 = {"Lcom/baidu/searchbox/videoplayer/TTSVideoPlayer;", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ACTION_HIDE_POSTER", "", "getACTION_HIDE_POSTER", "()Ljava/lang/String;", "ACTION_SHOW_POSTER", "getACTION_SHOW_POSTER", "KEY_FORCE_SHOW_POSTER", "", "getKEY_FORCE_SHOW_POSTER", "()I", "PAUSE_TYPE_INTERNAL", "getPAUSE_TYPE_INTERNAL", "PAUSE_TYPE_NORMAL", "getPAUSE_TYPE_NORMAL", "isLocalPlaying", "", "()Z", "setLocalPlaying", "(Z)V", "mPauseType", "getMPauseType", "setMPauseType", "(I)V", "started", "getStarted", "setStarted", "abandonAudioFocus", "", "getPlayerStageType", "getStrategy", "Lcom/baidu/searchbox/player/strategy/IVideoUpdateStrategy;", "isPauseInner", "pause", "pauseInner", "requestAudioFocus", "resume", "setPosterVisiable", "visible", "setupLayers", "showNetTipToast", "start", "stop", "TTSVideoPosterLayer", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TTSVideoPlayer.kt */
public final class TTSVideoPlayer extends BaseVideoPlayer {
    private final String ACTION_HIDE_POSTER = "layer_event_hide_poster";
    private final String ACTION_SHOW_POSTER = "layer_event_show_poster";
    private final int KEY_FORCE_SHOW_POSTER = 37;
    private final int PAUSE_TYPE_INTERNAL = 100;
    private final int PAUSE_TYPE_NORMAL = -1;
    private boolean isLocalPlaying;
    private int mPauseType = -1;
    private boolean started;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TTSVideoPlayer(Context context) {
        super(context, "", "");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final String getACTION_SHOW_POSTER() {
        return this.ACTION_SHOW_POSTER;
    }

    public final String getACTION_HIDE_POSTER() {
        return this.ACTION_HIDE_POSTER;
    }

    public final int getKEY_FORCE_SHOW_POSTER() {
        return this.KEY_FORCE_SHOW_POSTER;
    }

    public final int getPAUSE_TYPE_INTERNAL() {
        return this.PAUSE_TYPE_INTERNAL;
    }

    public final int getPAUSE_TYPE_NORMAL() {
        return this.PAUSE_TYPE_NORMAL;
    }

    public final boolean isLocalPlaying() {
        return this.isLocalPlaying;
    }

    public final void setLocalPlaying(boolean z) {
        this.isLocalPlaying = z;
    }

    public final boolean getStarted() {
        return this.started;
    }

    public final void setStarted(boolean z) {
        this.started = z;
    }

    public final int getMPauseType() {
        return this.mPauseType;
    }

    public final void setMPauseType(int i2) {
        this.mPauseType = i2;
    }

    public int getPlayerStageType() {
        return 16;
    }

    /* access modifiers changed from: protected */
    public void showNetTipToast() {
    }

    public IVideoUpdateStrategy getStrategy() {
        if (this.mStrategy == null) {
            this.mStrategy = new TTSVideoPlayerStrategy();
        }
        IVideoUpdateStrategy iVideoUpdateStrategy = this.mStrategy;
        Intrinsics.checkNotNullExpressionValue(iVideoUpdateStrategy, "mStrategy");
        return iVideoUpdateStrategy;
    }

    /* access modifiers changed from: protected */
    public void setupLayers(Context context) {
        super.setupLayers(context);
        addLayer(new TtsActionLayer());
    }

    public void requestAudioFocus() {
    }

    public void abandonAudioFocus() {
    }

    public void start() {
        super.start();
        this.isLocalPlaying = true;
        this.started = true;
        this.mPauseType = this.PAUSE_TYPE_NORMAL;
    }

    public void pause() {
        super.pause();
        this.isLocalPlaying = false;
        this.mPauseType = this.PAUSE_TYPE_NORMAL;
    }

    public final void pauseInner() {
        super.pause();
        this.isLocalPlaying = false;
        this.mPauseType = this.PAUSE_TYPE_INTERNAL;
    }

    public void resume() {
        super.resume();
        this.isLocalPlaying = true;
        this.started = true;
        this.mPauseType = this.PAUSE_TYPE_NORMAL;
    }

    public void stop() {
        super.stop();
        this.isLocalPlaying = false;
    }

    public final void setPosterVisiable(boolean visible) {
        String action;
        if (visible) {
            action = this.ACTION_SHOW_POSTER;
        } else {
            action = this.ACTION_HIDE_POSTER;
        }
        VideoEvent event = LayerEvent.obtainEvent(action);
        Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(action)");
        if (visible) {
            event.putExtra(this.KEY_FORCE_SHOW_POSTER, true);
        }
        sendEvent(event);
    }

    public final boolean isPauseInner() {
        return this.mPauseType == this.PAUSE_TYPE_INTERNAL;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/videoplayer/TTSVideoPlayer$TTSVideoPosterLayer;", "Lcom/baidu/searchbox/player/layer/PosterLayer;", "()V", "initLayer", "", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSVideoPlayer.kt */
    public static final class TTSVideoPosterLayer extends PosterLayer {
        public void initLayer() {
            super.initLayer();
            ((GenericDraweeHierarchy) this.mPoster.getHierarchy()).setPlaceholderImage((Drawable) null);
        }
    }
}
