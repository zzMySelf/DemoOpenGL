package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"FLOWVIDEO_PLAYER_DATACHANNEL_SWITCH_ANDROID", "", "<set-?>", "", "playerDataChannelAsyncMessageEnable", "getPlayerDataChannelAsyncMessageEnable", "()Z", "setPlayerDataChannelAsyncMessageEnable", "(Z)V", "playerDataChannelAsyncMessageEnable$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerDataChannelSwitch.kt */
public final class PlayerDataChannelSwitchKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(PlayerDataChannelSwitchKt.class, "playerDataChannelAsyncMessageEnable", "getPlayerDataChannelAsyncMessageEnable()Z", 1))};
    private static final String FLOWVIDEO_PLAYER_DATACHANNEL_SWITCH_ANDROID = "flowvideo_player_datacchannel_switch_android";
    private static final VideoSPData playerDataChannelAsyncMessageEnable$delegate = new VideoSPData(FLOWVIDEO_PLAYER_DATACHANNEL_SWITCH_ANDROID, true, false, (String) null, 12, (DefaultConstructorMarker) null);

    public static final boolean getPlayerDataChannelAsyncMessageEnable() {
        return ((Boolean) playerDataChannelAsyncMessageEnable$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    public static final void setPlayerDataChannelAsyncMessageEnable(boolean z) {
        playerDataChannelAsyncMessageEnable$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }
}
