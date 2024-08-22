package com.baidu.searchbox.player.plugin;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.BdVolumeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0003J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/player/plugin/HeadsetPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isPauseByHeadsetDisconnect", "", "isPlayerMute", "changeVolume", "", "headsetConnect", "getBindPlayer", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "getSubscribeEvent", "", "isHeadsetConnect", "onPlayerEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onSystemEventNotify", "Companion", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeadsetPlugin.kt */
public final class HeadsetPlugin extends AbsPlugin {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double DEFAULT_VOLUME_PERCENT = 0.35d;
    private static final String TAG = "HeadsetPlugin";
    private static boolean isBluetoothHeadsetConnect;
    private static boolean isGlobalMute;
    private static boolean isHeadsetConnect;
    private static boolean isLastHeadsetConnect;
    private static int preAudioVolume = -1;
    private boolean isPauseByHeadsetDisconnect;
    private boolean isPlayerMute;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/player/plugin/HeadsetPlugin$Companion;", "", "()V", "DEFAULT_VOLUME_PERCENT", "", "TAG", "", "isBluetoothHeadsetConnect", "", "isGlobalMute", "isHeadsetConnect", "isLastHeadsetConnect", "preAudioVolume", "", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HeadsetPlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeadsetPlugin(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int[] getSubscribeEvent() {
        return new int[]{1, 4};
    }

    public void onSystemEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual((Object) event.getAction(), (Object) "system_event_headset_plug")) {
            boolean booleanExtra = event.getBooleanExtra(2);
            isHeadsetConnect = booleanExtra;
            if (!isBluetoothHeadsetConnect) {
                changeVolume(booleanExtra);
            }
        } else if (Intrinsics.areEqual((Object) event.getAction(), (Object) "system_event_bluetooth_headset")) {
            boolean booleanExtra2 = event.getBooleanExtra(5);
            isBluetoothHeadsetConnect = booleanExtra2;
            if (!isHeadsetConnect) {
                changeVolume(booleanExtra2);
            }
        }
    }

    public void onPlayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual((Object) event.getAction(), (Object) "player_event_set_data")) {
            boolean z = false;
            this.isPauseByHeadsetDisconnect = false;
            boolean currentHeadsetConnect = isHeadsetConnect();
            if (!currentHeadsetConnect) {
                preAudioVolume = BdVolumeUtils.getVolume(getContext());
            }
            if (currentHeadsetConnect != isLastHeadsetConnect) {
                isLastHeadsetConnect = currentHeadsetConnect;
                if (!currentHeadsetConnect && BDVideoPlayer.isGlobalMute() && BdVolumeUtils.getVolume(getContext()) > 0) {
                    BdVideoLog.d(TAG, "恢复操作,静音->非静音");
                    isGlobalMute = false;
                    BaseVideoPlayer bindPlayer = getBindPlayer();
                    if (bindPlayer != null) {
                        bindPlayer.setGlobalMuteMode(false);
                    }
                }
            }
            BaseVideoPlayer bindPlayer2 = getBindPlayer();
            if (bindPlayer2 != null) {
                z = bindPlayer2.isMute();
            }
            this.isPlayerMute = z;
        }
    }

    /* JADX WARNING: type inference failed for: r2v14, types: [com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void changeVolume(boolean r11) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "播放器是否静音isMute= "
            java.lang.StringBuilder r0 = r0.append(r1)
            com.baidu.searchbox.player.BaseVideoPlayer r1 = r10.getBindPlayer()
            r2 = 0
            if (r1 == 0) goto L_0x001c
            boolean r1 = r1.isMute()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", 播放器是否全局静音sGlobalMute= "
            java.lang.StringBuilder r0 = r0.append(r1)
            boolean r1 = com.baidu.searchbox.player.BDVideoPlayer.isGlobalMute()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", 播放器静音状态(业务复写的方法)isPlayerMute= "
            java.lang.StringBuilder r0 = r0.append(r1)
            com.baidu.searchbox.player.BaseVideoPlayer r1 = r10.getBindPlayer()
            if (r1 == 0) goto L_0x0045
            boolean r1 = r1.isPlayerMute()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0046
        L_0x0045:
            r1 = r2
        L_0x0046:
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", 播放器耳机连接前的音量大小-> "
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = preAudioVolume
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", 播放器音量音量焦点-> "
            java.lang.StringBuilder r0 = r0.append(r1)
            com.baidu.searchbox.player.BaseVideoPlayer r1 = r10.getBindPlayer()
            if (r1 == 0) goto L_0x006d
            boolean r1 = r1.isHasAudioFocus()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x006e
        L_0x006d:
            r1 = r2
        L_0x006e:
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HeadsetPlugin"
            com.baidu.searchbox.player.utils.BdVideoLog.d((java.lang.String) r1, (java.lang.String) r0)
            java.lang.String r0 = ", 播放器="
            r3 = 1
            r4 = 0
            if (r11 == 0) goto L_0x015a
            isLastHeadsetConnect = r3
            boolean r5 = com.baidu.searchbox.player.BDVideoPlayer.isGlobalMute()
            isGlobalMute = r5
            com.baidu.searchbox.player.BaseVideoPlayer r5 = r10.getBindPlayer()
            if (r5 == 0) goto L_0x0094
            boolean r5 = r5.isMute()
            goto L_0x0095
        L_0x0094:
            r5 = r4
        L_0x0095:
            r10.isPlayerMute = r5
            com.baidu.searchbox.player.BaseVideoPlayer r5 = r10.getBindPlayer()
            if (r5 == 0) goto L_0x00a8
            com.baidu.searchbox.player.callback.BaseVideoPlayerCallbackManager r5 = r5.getPlayerCallbackManager()
            if (r5 == 0) goto L_0x00a8
            boolean r6 = r10.isPlayerMute
            r5.onHeadsetConnectChanged(r3, r6)
        L_0x00a8:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "耳机连接>>> 静音状态,全局="
            java.lang.StringBuilder r5 = r5.append(r6)
            boolean r6 = isGlobalMute
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r0 = r5.append(r0)
            boolean r5 = r10.isPlayerMute
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.baidu.searchbox.player.utils.BdVideoLog.d((java.lang.String) r1, (java.lang.String) r0)
            boolean r0 = r10.isPlayerMute
            if (r0 == 0) goto L_0x00d0
            goto L_0x00df
        L_0x00d0:
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r10.getBindPlayer()
            if (r0 == 0) goto L_0x00de
            boolean r0 = r0.isMute()
            if (r0 != r3) goto L_0x00de
            r0 = r3
            goto L_0x00df
        L_0x00de:
            r0 = r4
        L_0x00df:
            if (r0 == 0) goto L_0x00ea
            com.baidu.searchbox.player.BaseVideoPlayer r1 = r10.getBindPlayer()
            if (r1 == 0) goto L_0x00ea
            r1.setGlobalMuteMode(r4)
        L_0x00ea:
            android.content.Context r1 = r10.getContext()
            int r1 = com.baidu.searchbox.player.utils.BdVolumeUtils.getVolume(r1)
            if (r1 != 0) goto L_0x0104
            android.content.Context r5 = r10.getContext()
            int r5 = com.baidu.searchbox.player.utils.BdVolumeUtils.getMaxVolume(r5)
            double r6 = (double) r5
            r8 = 4599976659396224614(0x3fd6666666666666, double:0.35)
            double r6 = r6 * r8
            int r1 = (int) r6
        L_0x0104:
            android.content.Context r5 = r10.getContext()
            com.baidu.searchbox.player.utils.BdVolumeUtils.setVolume(r5, r1)
            boolean r5 = com.baidu.searchbox.player.utils.VideoPlayerSpUtil.getHeadsetSwitchEnable()
            if (r5 == 0) goto L_0x0204
            com.baidu.searchbox.player.BaseVideoPlayer r5 = r10.getBindPlayer()
            if (r5 == 0) goto L_0x011e
            boolean r5 = r5.isPause()
            if (r5 != r3) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r3 = r4
        L_0x011f:
            if (r3 == 0) goto L_0x0204
            boolean r3 = r10.isPauseByHeadsetDisconnect
            if (r3 == 0) goto L_0x0204
            com.baidu.searchbox.player.BaseVideoPlayer r3 = r10.getBindPlayer()
            if (r3 == 0) goto L_0x0134
            int r3 = r3.getDuration()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0135
        L_0x0134:
            r3 = r2
        L_0x0135:
            int r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r3)
            com.baidu.searchbox.player.BaseVideoPlayer r5 = r10.getBindPlayer()
            if (r5 == 0) goto L_0x0147
            int r2 = r5.getPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0147:
            int r2 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r2)
            if (r3 <= r2) goto L_0x0204
            r10.isPauseByHeadsetDisconnect = r4
            com.baidu.searchbox.player.BaseVideoPlayer r2 = r10.getBindPlayer()
            if (r2 == 0) goto L_0x0204
            r2.resume()
            goto L_0x0204
        L_0x015a:
            com.baidu.searchbox.player.BaseVideoPlayer r5 = r10.getBindPlayer()
            if (r5 == 0) goto L_0x016b
            com.baidu.searchbox.player.callback.BaseVideoPlayerCallbackManager r5 = r5.getPlayerCallbackManager()
            if (r5 == 0) goto L_0x016b
            boolean r6 = r10.isPlayerMute
            r5.onHeadsetConnectChanged(r4, r6)
        L_0x016b:
            boolean r5 = isLastHeadsetConnect
            if (r5 == 0) goto L_0x01f7
            isLastHeadsetConnect = r4
            com.baidu.searchbox.player.BaseVideoPlayer r5 = r10.getBindPlayer()
            if (r5 == 0) goto L_0x017b
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r2 = r5.getVideoSeries()
        L_0x017b:
            com.baidu.searchbox.player.model.BasicVideoSeries r2 = (com.baidu.searchbox.player.model.BasicVideoSeries) r2
            boolean r2 = com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeriesEx.isHeadsetDisconnectDoPause(r2)
            if (r2 == 0) goto L_0x01a4
            boolean r2 = com.baidu.searchbox.player.utils.VideoPlayerSpUtil.getHeadsetSwitchEnable()
            if (r2 == 0) goto L_0x01a4
            com.baidu.searchbox.player.BaseVideoPlayer r2 = r10.getBindPlayer()
            if (r2 == 0) goto L_0x0196
            boolean r2 = r2.isPlaying()
            if (r2 != r3) goto L_0x0196
            r4 = r3
        L_0x0196:
            if (r4 == 0) goto L_0x01a4
            r10.isPauseByHeadsetDisconnect = r3
            com.baidu.searchbox.player.BaseVideoPlayer r2 = r10.getBindPlayer()
            if (r2 == 0) goto L_0x01a4
            r3 = 4
            r2.pause(r3)
        L_0x01a4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "耳机断开>>> 恢复之前静音状态,全局="
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = isGlobalMute
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            boolean r2 = r10.isPlayerMute
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = ", 声音="
            java.lang.StringBuilder r0 = r0.append(r2)
            int r2 = preAudioVolume
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.baidu.searchbox.player.utils.BdVideoLog.d((java.lang.String) r1, (java.lang.String) r0)
            int r0 = preAudioVolume
            if (r0 != 0) goto L_0x01e0
            android.content.Context r0 = r10.getContext()
            int r1 = preAudioVolume
            com.baidu.searchbox.player.utils.BdVolumeUtils.setVolume(r0, r1)
        L_0x01e0:
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r10.getBindPlayer()
            if (r0 == 0) goto L_0x01eb
            boolean r1 = isGlobalMute
            r0.setGlobalMuteMode(r1)
        L_0x01eb:
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r10.getBindPlayer()
            if (r0 == 0) goto L_0x0204
            boolean r1 = r10.isPlayerMute
            r0.setMuteMode(r1)
            goto L_0x0204
        L_0x01f7:
            com.baidu.searchbox.player.session.VideoSessionManager r0 = com.baidu.searchbox.player.session.VideoSessionManager.getInstance()
            java.lang.String r1 = "action_mute_sync_to_all_player"
            com.baidu.searchbox.player.event.VideoEvent r1 = com.baidu.searchbox.player.event.LayerEvent.obtainEvent(r1)
            r0.sendEventToAll(r1)
        L_0x0204:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.plugin.HeadsetPlugin.changeVolume(boolean):void");
    }

    private final boolean isHeadsetConnect() {
        boolean curBluetoothHeadsetConnect;
        AudioManager audioManager = BdVolumeUtils.getAudioManager(getContext());
        boolean curHeadsetConnect = audioManager != null ? audioManager.isWiredHeadsetOn() : false;
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter != null) {
            curBluetoothHeadsetConnect = adapter.getProfileConnectionState(1) == 2;
        } else {
            curBluetoothHeadsetConnect = false;
        }
        BdVideoLog.d(TAG, "当前耳机连接状态>>> 有线耳机=" + curHeadsetConnect + ", 蓝牙=" + curBluetoothHeadsetConnect);
        if (curHeadsetConnect || curBluetoothHeadsetConnect) {
            return true;
        }
        return false;
    }

    public BaseVideoPlayer getBindPlayer() {
        BDVideoPlayer bindPlayer = super.getBindPlayer();
        if (bindPlayer instanceof BaseVideoPlayer) {
            return (BaseVideoPlayer) bindPlayer;
        }
        return null;
    }
}
