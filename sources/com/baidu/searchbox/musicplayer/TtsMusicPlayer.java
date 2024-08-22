package com.baidu.searchbox.musicplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.feed.tts.data.structure.TTSArticlePosition;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.playback.FeedTtsProgressListener;
import com.baidu.searchbox.music.MusicManager;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.music.player.MusicCore;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import com.baidu.searchbox.plugin.api.InvokeListener;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004./01B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\r\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\u0006\u0010 \u001a\u00020\u0015J\r\u0010!\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001dJ\u0015\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\u0012¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010&\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0010J\b\u0010+\u001a\u00020\u0015H\u0002J\r\u0010,\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001dJ\b\u0010-\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00060\nR\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer;", "", "()V", "musicCore", "Lcom/baidu/searchbox/music/player/MusicCore;", "playSongModel", "Lcom/baidu/searchbox/feed/tts/model/IFeedTTSModel;", "playState", "Lcom/baidu/searchbox/music/MusicPlayState;", "progressHandler", "Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$ProgressHandler;", "getProgressHandler", "()Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$ProgressHandler;", "progressHandler$delegate", "Lkotlin/Lazy;", "progressListener", "Lcom/baidu/searchbox/feed/tts/playback/FeedTtsProgressListener;", "getDuration", "", "getPosition", "initMusic", "", "callback", "Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$InitCallback;", "isPause", "", "isPlayStateActive", "isPlaying", "pause", "()Lkotlin/Unit;", "play", "model", "release", "resume", "seekTo", "position", "(I)Lkotlin/Unit;", "setPlayErrorListener", "listener", "Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$PlayErrorListener;", "setPlayStateChangeListener", "Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$PlayStateChangeListener;", "setProgressChangeListener", "startProgressUpdate", "stop", "stopProgressUpdate", "InitCallback", "PlayErrorListener", "PlayStateChangeListener", "ProgressHandler", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TtsMusicPlayer.kt */
public final class TtsMusicPlayer {
    /* access modifiers changed from: private */
    public final MusicCore musicCore;
    /* access modifiers changed from: private */
    public IFeedTTSModel playSongModel;
    private MusicPlayState playState = MusicPlayState.STOP;
    private final Lazy progressHandler$delegate = LazyKt.lazy(new TtsMusicPlayer$progressHandler$2(this));
    /* access modifiers changed from: private */
    public FeedTtsProgressListener progressListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$InitCallback;", "", "onFailed", "", "onSuccess", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TtsMusicPlayer.kt */
    public interface InitCallback {
        void onFailed();

        void onSuccess();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$PlayErrorListener;", "", "onPlayError", "", "errorInfo", "", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TtsMusicPlayer.kt */
    public interface PlayErrorListener {
        void onPlayError(String str);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$PlayStateChangeListener;", "", "onPlayStateChange", "", "playState", "Lcom/baidu/searchbox/music/MusicPlayState;", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TtsMusicPlayer.kt */
    public interface PlayStateChangeListener {
        void onPlayStateChange(MusicPlayState musicPlayState);
    }

    public TtsMusicPlayer() {
        MusicCore createDuMediaPlayer = MusicManager.Companion.get().createDuMediaPlayer();
        this.musicCore = createDuMediaPlayer;
        if (createDuMediaPlayer != null) {
            createDuMediaPlayer.setHandleAudioFocus(false);
        }
    }

    private final ProgressHandler getProgressHandler() {
        return (ProgressHandler) this.progressHandler$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$ProgressHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TtsMusicPlayer.kt */
    private final class ProgressHandler extends Handler {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProgressHandler(Looper looper) {
            super(looper);
            Intrinsics.checkNotNull(looper);
        }

        public void handleMessage(Message msg) {
            IFeedTTSModel $this$handleMessage_u24lambda_u2d0;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 308 && ($this$handleMessage_u24lambda_u2d0 = TtsMusicPlayer.this.playSongModel) != null) {
                TtsMusicPlayer ttsMusicPlayer = TtsMusicPlayer.this;
                if (ttsMusicPlayer.musicCore != null && $this$handleMessage_u24lambda_u2d0.isFeedSong()) {
                    String utteranceId = TTSArticlePosition.buildInitialPosition($this$handleMessage_u24lambda_u2d0.getId()).composeUniversalTtsId();
                    FeedTtsProgressListener access$getProgressListener$p = ttsMusicPlayer.progressListener;
                    if (access$getProgressListener$p != null) {
                        access$getProgressListener$p.onSpeechProgressChanged(utteranceId, ttsMusicPlayer.musicCore.getPosition());
                    }
                }
                sendEmptyMessageDelayed(308, 400);
            }
        }
    }

    public final void initMusic(InitCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 != null) {
            musicCore2.initMusic(new TtsMusicPlayer$$ExternalSyntheticLambda1(callback));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initMusic$lambda-0  reason: not valid java name */
    public static final void m1348initMusic$lambda0(InitCallback $callback, int statusCode, String str) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        switch (statusCode) {
            case 0:
                $callback.onSuccess();
                return;
            case 14:
                $callback.onFailed();
                return;
            default:
                return;
        }
    }

    public final void setProgressChangeListener(FeedTtsProgressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.progressListener = listener;
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 != null) {
            musicCore2.addPlayInfoListener((InvokeCallback) null, new InvokeListener[]{new TtsMusicPlayer$$ExternalSyntheticLambda3(this, listener)});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setProgressChangeListener$lambda-1  reason: not valid java name */
    public static final String m1351setProgressChangeListener$lambda1(TtsMusicPlayer this$0, FeedTtsProgressListener $listener, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($listener, "$listener");
        int duration = this$0.musicCore.getDuration();
        $listener.onWordCountUpdated(duration, duration);
        return null;
    }

    public final void setPlayStateChangeListener(PlayStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 != null) {
            musicCore2.addPlayStateListener((InvokeCallback) null, new InvokeListener[]{new TtsMusicPlayer$$ExternalSyntheticLambda2(this, listener)});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setPlayStateChangeListener$lambda-2  reason: not valid java name */
    public static final String m1350setPlayStateChangeListener$lambda2(TtsMusicPlayer this$0, PlayStateChangeListener $listener, String s) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($listener, "$listener");
        try {
            switch (new JSONObject(s).optInt("playstate")) {
                case 0:
                    this$0.playState = MusicPlayState.READY;
                    this$0.stopProgressUpdate();
                    break;
                case 1:
                    this$0.playState = MusicPlayState.PLAY;
                    this$0.startProgressUpdate();
                    break;
                case 2:
                    this$0.playState = MusicPlayState.PAUSE;
                    this$0.stopProgressUpdate();
                    break;
                case 3:
                    this$0.playState = MusicPlayState.END;
                    this$0.stopProgressUpdate();
                    break;
                case 4:
                    this$0.playState = MusicPlayState.STOP;
                    this$0.stopProgressUpdate();
                    break;
            }
            $listener.onPlayStateChange(this$0.playState);
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void setPlayErrorListener(PlayErrorListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 != null) {
            musicCore2.addMusicErrorListner(new InvokeListener[]{new TtsMusicPlayer$$ExternalSyntheticLambda0(listener)});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setPlayErrorListener$lambda-3  reason: not valid java name */
    public static final String m1349setPlayErrorListener$lambda3(PlayErrorListener $listener, String errorInfo) {
        Intrinsics.checkNotNullParameter($listener, "$listener");
        $listener.onPlayError(errorInfo);
        return null;
    }

    public final Unit seekTo(int position) {
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 == null) {
            return null;
        }
        musicCore2.seek(position, (InvokeCallback) null);
        return Unit.INSTANCE;
    }

    public final void play(IFeedTTSModel model) {
        Song it;
        if (model != null && (it = model.extractCommonSong()) != null) {
            ArrayList songList = new ArrayList(1);
            songList.add(it);
            MusicCore musicCore2 = this.musicCore;
            if (musicCore2 != null) {
                musicCore2.setSongList(0, songList, (InvokeCallback) null, 0);
            }
            this.playSongModel = model;
        }
    }

    public final Unit pause() {
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 == null) {
            return null;
        }
        musicCore2.pause((InvokeCallback) null);
        return Unit.INSTANCE;
    }

    public final Unit resume() {
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 == null) {
            return null;
        }
        musicCore2.play((InvokeCallback) null);
        return Unit.INSTANCE;
    }

    public final Unit stop() {
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 == null) {
            return null;
        }
        musicCore2.stop((InvokeCallback) null);
        return Unit.INSTANCE;
    }

    public final void release() {
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 != null) {
            musicCore2.release((InvokeCallback) null);
        }
        this.playState = MusicPlayState.STOP;
        this.progressListener = null;
        this.playSongModel = null;
    }

    public final int getDuration() {
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 != null) {
            return musicCore2.getDuration();
        }
        return 0;
    }

    public final int getPosition() {
        MusicCore musicCore2 = this.musicCore;
        if (musicCore2 != null) {
            return musicCore2.getPosition();
        }
        return 0;
    }

    public final boolean isPlaying() {
        return this.playState == MusicPlayState.PLAY;
    }

    public final boolean isPause() {
        return this.playState == MusicPlayState.PAUSE;
    }

    public final boolean isPlayStateActive() {
        return this.playState == MusicPlayState.PLAY || this.playState == MusicPlayState.PAUSE;
    }

    private final void startProgressUpdate() {
        getProgressHandler().removeCallbacksAndMessages((Object) null);
        getProgressHandler().sendEmptyMessageDelayed(308, 400);
    }

    private final void stopProgressUpdate() {
        getProgressHandler().removeMessages(308);
    }
}
