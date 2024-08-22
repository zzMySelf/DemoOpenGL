package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.common.config.AirPlayOptSwitchConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"KEY_NODE_CONTINUE", "", "KEY_NODE_GUIDE", "KEY_NODE_GUIDE_DURATION", "KEY_NODE_MENU_BUILD", "KEY_NODE_PROJECTION", "SP_KEY_AIR_PLAY_OPT_CONFIG", "parseAirPlayOptConfig", "Lcom/baidu/searchbox/video/feedflow/common/config/AirPlayOptSwitchConfig;", "airPlayOptConfig", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowAirPlayOptSwitcher.kt */
public final class FlowAirPlayOptSwitcherKt {
    private static final String KEY_NODE_CONTINUE = "continue";
    private static final String KEY_NODE_GUIDE = "guide";
    private static final String KEY_NODE_GUIDE_DURATION = "guide_duration";
    private static final String KEY_NODE_MENU_BUILD = "menu_build";
    private static final String KEY_NODE_PROJECTION = "projection";
    private static final String SP_KEY_AIR_PLAY_OPT_CONFIG = "key_air_play_opt_config";

    public static final AirPlayOptSwitchConfig parseAirPlayOptConfig(String airPlayOptConfig) {
        Intrinsics.checkNotNullParameter(airPlayOptConfig, "airPlayOptConfig");
        try {
            if (!(!StringsKt.isBlank(airPlayOptConfig))) {
                return null;
            }
            JSONObject airPlayConfigJson = new JSONObject(airPlayOptConfig);
            return new AirPlayOptSwitchConfig(Intrinsics.areEqual((Object) airPlayConfigJson.optString("continue"), (Object) "1"), Intrinsics.areEqual((Object) airPlayConfigJson.optString("guide"), (Object) "1"), BdPlayerUtils.orZero(Integer.valueOf(airPlayConfigJson.optInt(KEY_NODE_GUIDE_DURATION))), Intrinsics.areEqual((Object) airPlayConfigJson.optString(KEY_NODE_MENU_BUILD), (Object) "1"));
        } catch (Exception e2) {
            return null;
        }
    }
}
