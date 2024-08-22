package com.baidu.searchbox.music.player;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.DuMediaInstall;
import com.baidu.cyberplayer.sdk.DuMediaNet;
import com.baidu.cyberplayer.sdk.DuMediaPlayStatus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.imagesearch.host.entry.constants.ImageSearchInvokeSource;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.net.client.freeproxy.FreeSimCardProxyManager;
import com.baidu.searchbox.player.utils.BdCyberUtils;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import com.baidu.searchbox.plugin.api.InvokeListener;
import com.baidu.searchbox.video.videoplayer.httpdns.VideoHttpDns;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010D\u001a\u00020EH\u0002J\u001b\u0010F\u001a\u00020E2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020100H\u0016¢\u0006\u0002\u00105J%\u0010H\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010J2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020100H\u0016¢\u0006\u0002\u0010KJ%\u0010L\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010J2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020100H\u0016¢\u0006\u0002\u0010KJ\u001b\u0010M\u001a\u00020E2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020100H\u0016¢\u0006\u0002\u00105J\u001a\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020\u000f2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0018\u0010P\u001a\u00020E2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u00020E2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020EH\u0002J\n\u0010X\u001a\u0004\u0018\u00010SH\u0016J\b\u0010Y\u001a\u00020\tH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010S2\u0006\u0010[\u001a\u00020\rH\u0016J\b\u0010\\\u001a\u00020\tH\u0016J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020%H\u0002J\b\u0010b\u001a\u00020\tH\u0016J\u0010\u0010c\u001a\u00020E2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010d\u001a\u00020EH\u0016J\u0010\u0010e\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020`H\u0016J\b\u0010f\u001a\u00020EH\u0016J\"\u0010g\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020\t2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\"\u0010l\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020\t2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\b\u0010m\u001a\u00020EH\u0016J\b\u0010n\u001a\u00020EH\u0016J\u0012\u0010o\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0012\u0010p\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0012\u0010q\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010r\u001a\u00020EH\u0002J\u001a\u0010s\u001a\u00020E2\u0006\u0010t\u001a\u00020\t2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010u\u001a\u00020E2\u0006\u0010v\u001a\u00020\u000fH\u0016J\u001a\u0010w\u001a\u00020E2\u0006\u0010x\u001a\u00020\t2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J>\u0010y\u001a\u00020E2\u0006\u0010t\u001a\u00020\t2\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020S\u0018\u00010{j\n\u0012\u0004\u0012\u00020S\u0018\u0001`|2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010}\u001a\u00020\tH\u0016J\u001a\u0010~\u001a\u00020E2\u0006\u0010\u001a\u00020\u001c2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001b\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020\u001cH\u0016J\u0013\u0010\u0001\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001a\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\b\u0012\u0004\u0012\u00020100X\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\"\u0010:\u001a\b\u0012\u0004\u0012\u00020100X\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b;\u00103\"\u0004\b<\u00105R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020100X\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\u001a\u0010@\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u0010C¨\u0006\u0001"}, d2 = {"Lcom/baidu/searchbox/music/player/DuMediaPlayer;", "Lcom/baidu/searchbox/music/player/MusicCore;", "Lcom/baidu/cyberplayer/sdk/DuMediaPlayStatus$OnPreparedListener;", "Lcom/baidu/cyberplayer/sdk/DuMediaPlayStatus$OnCompletionListener;", "Lcom/baidu/cyberplayer/sdk/DuMediaPlayStatus$OnInfoListener;", "Lcom/baidu/cyberplayer/sdk/DuMediaPlayStatus$OnErrorListener;", "Lcom/baidu/cyberplayer/sdk/DuMediaPlayStatus$OnSeekCompleteListener;", "()V", "AUDIO_FOCUSED", "", "AUDIO_NO_FOCUS_CAN_DUCK", "AUDIO_NO_FOCUS_NO_DUCK", "COOKIE", "", "DEBUG", "", "getDEBUG", "()Z", "FROM_VALUE_MUSIC_PLAYER", "MUSIC_CORE_BIZ", "getMUSIC_CORE_BIZ", "()Ljava/lang/String;", "OPT_TYPE", "REFER", "TAG", "getTAG", "USER_AGENT", "VOLUME_DUCK", "", "VOLUME_NORMAL", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "cyberPlayer", "Lcom/baidu/cyberplayer/sdk/DuMediaPlayer;", "getCyberPlayer", "()Lcom/baidu/cyberplayer/sdk/DuMediaPlayer;", "setCyberPlayer", "(Lcom/baidu/cyberplayer/sdk/DuMediaPlayer;)V", "handleAudioFocus", "mCurrentAudioFocusState", "mOnAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mPlayOnFocusGain", "playErrorListeners", "", "Lcom/baidu/searchbox/plugin/api/InvokeListener;", "getPlayErrorListeners", "()[Lcom/baidu/searchbox/plugin/api/InvokeListener;", "setPlayErrorListeners", "([Lcom/baidu/searchbox/plugin/api/InvokeListener;)V", "[Lcom/baidu/searchbox/plugin/api/InvokeListener;", "playInfoListeners", "getPlayInfoListeners", "setPlayInfoListeners", "playSeekListeners", "getPlaySeekListeners", "setPlaySeekListeners", "playstateListeners", "getPlaystateListeners", "setPlaystateListeners", "useProxy", "getUseProxy", "setUseProxy", "(Z)V", "abandonAudioFocus", "", "addMusicErrorListner", "listeners", "addPlayInfoListener", "callback", "Lcom/baidu/searchbox/plugin/api/InvokeCallback;", "(Lcom/baidu/searchbox/plugin/api/InvokeCallback;[Lcom/baidu/searchbox/plugin/api/InvokeListener;)V", "addPlayStateListener", "addSeekCompleteListener", "changeToFreeCard", "isFree", "configPlayerCoreStatistic", "playUrl", "song", "Lcom/baidu/searchbox/music/bean/Song;", "configProxy", "uri", "Landroid/net/Uri;", "configurePlayerState", "getCurrentSong", "getDownloadProgress", "getDownloadSong", "songId", "getDuration", "getMusicPluginVersion", "", "context", "Landroid/content/Context;", "getPlayer", "getPosition", "initMusic", "installMusicPlugin", "isAvailable", "onCompletion", "onError", "what", "extra", "obj", "", "onInfo", "onPrepared", "onSeekComplete", "pause", "play", "release", "requestAudioFocus", "seek", "position", "setHandleAudioFocus", "isHandled", "setPlayMode", "mode", "setSongList", "songs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "currProcess", "setSpeed", "speed", "setVolume", "leftVolume", "rightVolume", "stop", "lib-music-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DuMediaPlayer.kt */
public final class DuMediaPlayer implements MusicCore, DuMediaPlayStatus.OnPreparedListener, DuMediaPlayStatus.OnCompletionListener, DuMediaPlayStatus.OnInfoListener, DuMediaPlayStatus.OnErrorListener, DuMediaPlayStatus.OnSeekCompleteListener {
    private final int AUDIO_FOCUSED = 2;
    private final int AUDIO_NO_FOCUS_CAN_DUCK = 1;
    private final int AUDIO_NO_FOCUS_NO_DUCK;
    private final String COOKIE = "Cookie";
    private final boolean DEBUG = AppConfig.isDebug();
    private final String FROM_VALUE_MUSIC_PLAYER = "mp3_media_player";
    private final String MUSIC_CORE_BIZ = ImageSearchInvokeSource.HISSUG_HIS;
    private final int OPT_TYPE = 5;
    private final String REFER = "refer";
    private final String TAG = "DuMediaPlayer";
    private final String USER_AGENT = "user-agent";
    private final float VOLUME_DUCK = 0.2f;
    private final float VOLUME_NORMAL = 1.0f;
    private AudioManager audioManager;
    private volatile com.baidu.cyberplayer.sdk.DuMediaPlayer cyberPlayer;
    private boolean handleAudioFocus = true;
    private int mCurrentAudioFocusState = this.AUDIO_NO_FOCUS_NO_DUCK;
    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private boolean mPlayOnFocusGain;
    private InvokeListener[] playErrorListeners = new InvokeListener[0];
    private InvokeListener[] playInfoListeners = new InvokeListener[0];
    private InvokeListener[] playSeekListeners = new InvokeListener[0];
    private InvokeListener[] playstateListeners = new InvokeListener[0];
    private boolean useProxy;

    public DuMediaPlayer() {
        Object systemService = AppRuntime.getAppContext().getSystemService("audio");
        if (systemService != null) {
            this.audioManager = (AudioManager) systemService;
            this.mOnAudioFocusChangeListener = new DuMediaPlayer$$ExternalSyntheticLambda0(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }

    public final boolean getDEBUG() {
        return this.DEBUG;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final String getMUSIC_CORE_BIZ() {
        return this.MUSIC_CORE_BIZ;
    }

    public final com.baidu.cyberplayer.sdk.DuMediaPlayer getCyberPlayer() {
        return this.cyberPlayer;
    }

    public final void setCyberPlayer(com.baidu.cyberplayer.sdk.DuMediaPlayer duMediaPlayer) {
        this.cyberPlayer = duMediaPlayer;
    }

    public final AudioManager getAudioManager() {
        return this.audioManager;
    }

    public final void setAudioManager(AudioManager audioManager2) {
        this.audioManager = audioManager2;
    }

    public final InvokeListener[] getPlayInfoListeners() {
        return this.playInfoListeners;
    }

    public final void setPlayInfoListeners(InvokeListener[] invokeListenerArr) {
        Intrinsics.checkNotNullParameter(invokeListenerArr, "<set-?>");
        this.playInfoListeners = invokeListenerArr;
    }

    public final InvokeListener[] getPlaystateListeners() {
        return this.playstateListeners;
    }

    public final void setPlaystateListeners(InvokeListener[] invokeListenerArr) {
        Intrinsics.checkNotNullParameter(invokeListenerArr, "<set-?>");
        this.playstateListeners = invokeListenerArr;
    }

    public final InvokeListener[] getPlayErrorListeners() {
        return this.playErrorListeners;
    }

    public final void setPlayErrorListeners(InvokeListener[] invokeListenerArr) {
        Intrinsics.checkNotNullParameter(invokeListenerArr, "<set-?>");
        this.playErrorListeners = invokeListenerArr;
    }

    public final InvokeListener[] getPlaySeekListeners() {
        return this.playSeekListeners;
    }

    public final void setPlaySeekListeners(InvokeListener[] invokeListenerArr) {
        Intrinsics.checkNotNullParameter(invokeListenerArr, "<set-?>");
        this.playSeekListeners = invokeListenerArr;
    }

    public final boolean getUseProxy() {
        return this.useProxy;
    }

    public final void setUseProxy(boolean z) {
        this.useProxy = z;
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    private final synchronized com.baidu.cyberplayer.sdk.DuMediaPlayer getPlayer() {
        com.baidu.cyberplayer.sdk.DuMediaPlayer player;
        if (this.cyberPlayer == null) {
            com.baidu.cyberplayer.sdk.DuMediaPlayer player2 = new com.baidu.cyberplayer.sdk.DuMediaPlayer(1, (DuMediaNet.HttpDNS) new VideoHttpDns(), false);
            player2.setOnPreparedListener(this);
            player2.setOnInfoListener(this);
            player2.setOnCompletionListener(this);
            player2.setOnErrorListener(this);
            player2.setOnSeekCompleteListener(this);
            this.cyberPlayer = player2;
        }
        player = this.cyberPlayer;
        if (player == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.cyberplayer.sdk.DuMediaPlayer");
        }
        return player;
    }

    public void initMusic(InvokeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.DEBUG) {
            Log.d(this.TAG, "initMusic");
        }
        BdCyberUtils.initCyber(new DuMediaPlayer$initMusic$1(callback), this.OPT_TYPE);
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setSongList(int r12, java.util.ArrayList<com.baidu.searchbox.music.bean.Song> r13, com.baidu.searchbox.plugin.api.InvokeCallback r14, int r15) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.DEBUG     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r11.TAG     // Catch:{ all -> 0x00f5 }
            java.lang.String r1 = "setSongList"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00f5 }
        L_0x000d:
            if (r13 != 0) goto L_0x0011
            monitor-exit(r11)
            return
        L_0x0011:
            int r0 = r13.size()     // Catch:{ all -> 0x00f5 }
            if (r12 < 0) goto L_0x00f3
            if (r12 < r0) goto L_0x001b
            goto L_0x00f3
        L_0x001b:
            java.lang.Object r1 = r13.get(r12)     // Catch:{ all -> 0x00f5 }
            java.lang.String r2 = "songs.get(position)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x00f5 }
            com.baidu.searchbox.music.bean.Song r1 = (com.baidu.searchbox.music.bean.Song) r1     // Catch:{ all -> 0x00f5 }
            int r2 = r1.mAudioType     // Catch:{ all -> 0x00f5 }
            if (r2 != 0) goto L_0x002e
            java.lang.String r2 = r1.mFilePath     // Catch:{ all -> 0x00f5 }
            goto L_0x0030
        L_0x002e:
            java.lang.String r2 = r1.mOnlineUrl     // Catch:{ all -> 0x00f5 }
        L_0x0030:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00f5 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00f5 }
            if (r3 == 0) goto L_0x0042
            r3 = -10000(0xffffffffffffd8f0, float:NaN)
            r4 = -2
            r5 = 0
            r11.onError(r3, r4, r5)     // Catch:{ all -> 0x00f5 }
            monitor-exit(r11)
            return
        L_0x0042:
            com.baidu.cyberplayer.sdk.DuMediaPlayer r3 = r11.getPlayer()     // Catch:{ all -> 0x00f5 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x00f5 }
            r4.<init>()     // Catch:{ all -> 0x00f5 }
            java.lang.String r5 = "playstate"
            r6 = 0
            r4.put(r5, r6)     // Catch:{ all -> 0x00f5 }
            com.baidu.searchbox.plugin.api.InvokeListener[] r5 = r11.playstateListeners     // Catch:{ all -> 0x00f5 }
            int r7 = r5.length     // Catch:{ all -> 0x00f5 }
        L_0x0055:
            if (r6 >= r7) goto L_0x0063
            r8 = r5[r6]     // Catch:{ all -> 0x00f5 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x00f5 }
            r8.onExecute(r9)     // Catch:{ all -> 0x00f5 }
            int r6 = r6 + 1
            goto L_0x0055
        L_0x0063:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00f5 }
            r5.<init>()     // Catch:{ all -> 0x00f5 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x00f5 }
            java.util.Map<java.lang.String, java.lang.String> r6 = r1.mCustomHTTPHeaders     // Catch:{ all -> 0x00f5 }
            if (r6 == 0) goto L_0x00cd
            r7 = 0
            java.util.Map<java.lang.String, java.lang.String> r8 = r1.mCustomHTTPHeaders     // Catch:{ all -> 0x00f5 }
            java.lang.String r9 = r11.USER_AGENT     // Catch:{ all -> 0x00f5 }
            boolean r8 = r8.containsKey(r9)     // Catch:{ all -> 0x00f5 }
            if (r8 == 0) goto L_0x008e
            java.util.Map<java.lang.String, java.lang.String> r8 = r1.mCustomHTTPHeaders     // Catch:{ all -> 0x00f5 }
            java.lang.String r9 = r11.USER_AGENT     // Catch:{ all -> 0x00f5 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x00f5 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00f5 }
            if (r8 == 0) goto L_0x008e
            r9 = 0
            java.lang.String r10 = "User-Agent"
            java.lang.Object r10 = r5.put(r10, r8)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00f5 }
        L_0x008e:
            java.util.Map<java.lang.String, java.lang.String> r8 = r1.mCustomHTTPHeaders     // Catch:{ all -> 0x00f5 }
            java.lang.String r9 = r11.REFER     // Catch:{ all -> 0x00f5 }
            boolean r8 = r8.containsKey(r9)     // Catch:{ all -> 0x00f5 }
            if (r8 == 0) goto L_0x00ad
            java.util.Map<java.lang.String, java.lang.String> r8 = r1.mCustomHTTPHeaders     // Catch:{ all -> 0x00f5 }
            java.lang.String r9 = r11.REFER     // Catch:{ all -> 0x00f5 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x00f5 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00f5 }
            if (r8 == 0) goto L_0x00ad
            r9 = 0
            java.lang.String r10 = "Referer"
            java.lang.Object r10 = r5.put(r10, r8)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00f5 }
        L_0x00ad:
            java.util.Map<java.lang.String, java.lang.String> r8 = r1.mCustomHTTPHeaders     // Catch:{ all -> 0x00f5 }
            java.lang.String r9 = r11.COOKIE     // Catch:{ all -> 0x00f5 }
            boolean r8 = r8.containsKey(r9)     // Catch:{ all -> 0x00f5 }
            if (r8 == 0) goto L_0x00cc
            java.util.Map<java.lang.String, java.lang.String> r8 = r1.mCustomHTTPHeaders     // Catch:{ all -> 0x00f5 }
            java.lang.String r9 = r11.COOKIE     // Catch:{ all -> 0x00f5 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x00f5 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00f5 }
            if (r8 == 0) goto L_0x00cc
            r9 = 0
            java.lang.String r10 = "Cookie"
            java.lang.Object r10 = r5.put(r10, r8)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00f5 }
        L_0x00cc:
        L_0x00cd:
            r3.reset()     // Catch:{ all -> 0x00f5 }
            android.net.Uri r6 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x00f5 }
            android.content.Context r7 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x00f5 }
            r3.setDataSource(r7, r6, r5)     // Catch:{ all -> 0x00f5 }
            java.lang.String r7 = "playUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ all -> 0x00f5 }
            r11.configProxy(r6)     // Catch:{ all -> 0x00f5 }
            java.lang.String r7 = "playUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)     // Catch:{ all -> 0x00f5 }
            r11.configPlayerCoreStatistic(r2, r1)     // Catch:{ all -> 0x00f5 }
            r3.prepareAsync()     // Catch:{ all -> 0x00f5 }
            monitor-exit(r11)
            return
        L_0x00f3:
            monitor-exit(r11)
            return
        L_0x00f5:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.music.player.DuMediaPlayer.setSongList(int, java.util.ArrayList, com.baidu.searchbox.plugin.api.InvokeCallback, int):void");
    }

    public void setHandleAudioFocus(boolean isHandled) {
        this.handleAudioFocus = isHandled;
    }

    private final void configProxy(Uri uri) {
        if (this.useProxy && FreeSimCardProxyManager.getInstance().isNeedProxy(uri.getHost())) {
            List proxies = FreeSimCardProxyManager.getInstance().getProxies(uri.getScheme());
            Intrinsics.checkNotNullExpressionValue(proxies, "getInstance().getProxies(uri.scheme)");
            List proxies2 = proxies;
            if (this.DEBUG && proxies2.size() > 0) {
                String proxyUrl = proxies2.get(0).address().toString();
                getPlayer().setOption("http_proxy", proxyUrl);
                getPlayer().setOption("need-t5-auth", String.valueOf(!TextUtils.isEmpty(proxyUrl)));
                Log.d(this.TAG, "use proxy --> " + proxyUrl);
            }
        }
    }

    private final void configPlayerCoreStatistic(String playUrl, Song song) {
        HashMap stageInfo = new HashMap();
        stageInfo.put("stage_type", this.MUSIC_CORE_BIZ);
        stageInfo.put("stage_source", playUrl);
        stageInfo.put("stage_title", song.mSongName);
        stageInfo.put("from", this.FROM_VALUE_MUSIC_PLAYER);
        stageInfo.put("page", song.page);
        getPlayer().setExternalInfo("stage_info", stageInfo);
    }

    public void changeToFreeCard(boolean isFree, InvokeCallback callback) {
        this.useProxy = isFree;
    }

    public void play(InvokeCallback callback) {
        if (this.DEBUG) {
            Log.d(this.TAG, "play");
        }
        requestAudioFocus();
        getPlayer().start();
        JSONObject json = new JSONObject();
        json.put("playstate", 1);
        for (InvokeListener lis : this.playstateListeners) {
            lis.onExecute(json.toString());
        }
    }

    public void pause(InvokeCallback callback) {
        if (this.DEBUG) {
            Log.d(this.TAG, "pause");
        }
        getPlayer().pause();
        JSONObject json = new JSONObject();
        json.put("playstate", 2);
        for (InvokeListener lis : this.playstateListeners) {
            lis.onExecute(json.toString());
        }
    }

    public void stop(InvokeCallback callback) {
        if (this.DEBUG) {
            Log.d(this.TAG, "stope");
        }
        getPlayer().stop();
        abandonAudioFocus();
    }

    public void seek(int position, InvokeCallback callback) {
        if (this.DEBUG) {
            Log.d(this.TAG, "seek");
        }
        getPlayer().seekTo((long) position);
    }

    public void setSpeed(float speed, InvokeCallback callback) {
        if (this.DEBUG) {
            Log.d(this.TAG, "setSpeed");
        }
        getPlayer().setSpeed(speed);
    }

    public void addSeekCompleteListener(InvokeListener[] listeners) {
        Intrinsics.checkNotNullParameter(listeners, PluginInvokerConstants.LISTENERS);
        this.playSeekListeners = listeners;
    }

    public void addMusicErrorListner(InvokeListener[] listeners) {
        Intrinsics.checkNotNullParameter(listeners, PluginInvokerConstants.LISTENERS);
        if (this.DEBUG) {
            Log.d(this.TAG, "addMusicErrorListner");
        }
        this.playErrorListeners = listeners;
    }

    public int getDuration() {
        return getPlayer().getDuration();
    }

    public int getPosition() {
        return getPlayer().getCurrentPosition();
    }

    public int getDownloadProgress() {
        return -1;
    }

    public Song getCurrentSong() {
        return MusicPlayer.getInstance().getSong();
    }

    public void release(InvokeCallback callback) {
        synchronized (this) {
            getPlayer().release();
            abandonAudioFocus();
            this.cyberPlayer = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void addPlayInfoListener(InvokeCallback callback, InvokeListener[] listeners) {
        Intrinsics.checkNotNullParameter(listeners, PluginInvokerConstants.LISTENERS);
        this.playInfoListeners = listeners;
    }

    public void addPlayStateListener(InvokeCallback callback, InvokeListener[] listeners) {
        Intrinsics.checkNotNullParameter(listeners, PluginInvokerConstants.LISTENERS);
        this.playstateListeners = listeners;
    }

    public void setPlayMode(int mode, InvokeCallback callback) {
    }

    public Song getDownloadSong(String songId) {
        Intrinsics.checkNotNullParameter(songId, "songId");
        return MusicPlayer.getInstance().getSong();
    }

    public long getMusicPluginVersion(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Long.MAX_VALUE;
    }

    public boolean isAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DuMediaInstall.isCoreLoaded(this.OPT_TYPE);
    }

    public void installMusicPlugin() {
    }

    public void setVolume(float leftVolume, float rightVolume) {
        getPlayer().setVolume(leftVolume, rightVolume);
    }

    public void onPrepared() {
        play((InvokeCallback) null);
        for (InvokeListener lis : this.playInfoListeners) {
            lis.onExecute((String) null);
        }
    }

    public void onCompletion() {
        JSONObject json = new JSONObject();
        json.put("playstate", 3);
        for (InvokeListener lis : this.playstateListeners) {
            lis.onExecute(json.toString());
        }
        JSONObject json2 = new JSONObject();
        json2.put("playstate", 4);
        for (InvokeListener lis2 : this.playstateListeners) {
            lis2.onExecute(json2.toString());
        }
    }

    public boolean onInfo(int what, int extra, Object obj) {
        if (this.DEBUG) {
            Log.d(this.TAG, CollectionsKt.joinToString$default(CollectionsKt.listOf(Integer.valueOf(what), Integer.valueOf(extra), obj), "@@", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return true;
    }

    public void onSeekComplete() {
        for (InvokeListener lis : this.playSeekListeners) {
            lis.onExecute((String) null);
        }
    }

    public boolean onError(int what, int extra, Object obj) {
        if (this.DEBUG) {
            Log.d(this.TAG, "onError: > " + what + " - " + extra);
        }
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("errorCode", extra);
        jsonobject.put("errorDetail", obj);
        String result = jsonobject.toString();
        Intrinsics.checkNotNullExpressionValue(result, "jsonobject.toString()");
        for (InvokeListener lis : this.playErrorListeners) {
            lis.onExecute(result);
        }
        synchronized (this) {
            getPlayer().release();
            this.cyberPlayer = null;
            Unit unit = Unit.INSTANCE;
        }
        return true;
    }

    private final void requestAudioFocus() {
        AudioManager it;
        if (!this.handleAudioFocus || (it = this.audioManager) == null) {
            return;
        }
        if (it.requestAudioFocus(this.mOnAudioFocusChangeListener, 3, 1) == 1) {
            this.mCurrentAudioFocusState = this.AUDIO_FOCUSED;
        } else {
            this.mCurrentAudioFocusState = this.AUDIO_NO_FOCUS_NO_DUCK;
        }
    }

    private final void abandonAudioFocus() {
        AudioManager it;
        if (this.handleAudioFocus && (it = this.audioManager) != null && it.abandonAudioFocus(this.mOnAudioFocusChangeListener) == 1) {
            this.mCurrentAudioFocusState = this.AUDIO_NO_FOCUS_NO_DUCK;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mOnAudioFocusChangeListener$lambda-8  reason: not valid java name */
    public static final void m1276mOnAudioFocusChangeListener$lambda8(DuMediaPlayer this$0, int focusChange) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.DEBUG) {
            Log.d(this$0.TAG, "onAudioFocusChange: " + focusChange);
        }
        switch (focusChange) {
            case -3:
                this$0.mCurrentAudioFocusState = this$0.AUDIO_NO_FOCUS_CAN_DUCK;
                break;
            case -2:
                this$0.mCurrentAudioFocusState = this$0.AUDIO_NO_FOCUS_NO_DUCK;
                this$0.mPlayOnFocusGain = this$0.getPlayer().isPlaying();
                break;
            case -1:
                this$0.mCurrentAudioFocusState = this$0.AUDIO_NO_FOCUS_NO_DUCK;
                break;
            case 1:
                this$0.mCurrentAudioFocusState = this$0.AUDIO_FOCUSED;
                break;
        }
        this$0.configurePlayerState();
    }

    private final void configurePlayerState() {
        int i2 = this.mCurrentAudioFocusState;
        if (i2 == this.AUDIO_NO_FOCUS_NO_DUCK) {
            pause((InvokeCallback) null);
            return;
        }
        if (i2 == this.AUDIO_NO_FOCUS_CAN_DUCK) {
            com.baidu.cyberplayer.sdk.DuMediaPlayer player = getPlayer();
            float f2 = this.VOLUME_DUCK;
            player.setVolume(f2, f2);
        } else {
            com.baidu.cyberplayer.sdk.DuMediaPlayer player2 = getPlayer();
            float f3 = this.VOLUME_NORMAL;
            player2.setVolume(f3, f3);
        }
        if (this.mPlayOnFocusGain) {
            play((InvokeCallback) null);
            this.mPlayOnFocusGain = false;
        }
    }
}
