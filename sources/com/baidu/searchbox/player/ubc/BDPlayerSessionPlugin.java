package com.baidu.searchbox.player.ubc;

import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.preboot.env.PrebootRuntimeKt;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/ubc/BDPlayerSessionPlugin;", "Lcom/baidu/searchbox/player/ubc/PlayerSessionPlugin;", "()V", "getNetQuality", "", "getPlayerMode", "", "getPreBootInfo", "Lorg/json/JSONObject;", "getStartPosition", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BDPlayerSessionPlugin.kt */
public class BDPlayerSessionPlugin extends PlayerSessionPlugin {
    public JSONObject getPreBootInfo() {
        JSONObject extLog = new JSONObject();
        PlayerPrebootStatUtils.appendPrebootStat(extLog, getUbcContent());
        return extLog.optJSONObject(PrebootRuntimeKt.LOG_TAG);
    }

    public int getStartPosition() {
        BDVideoPlayer bindPlayer = getBindPlayer();
        Integer num = null;
        BasicVideoSeries videoSeries = bindPlayer != null ? bindPlayer.getVideoSeries() : null;
        BdVideoSeries bdVideoSeries = videoSeries instanceof BdVideoSeries ? (BdVideoSeries) videoSeries : null;
        if (bdVideoSeries != null) {
            num = Integer.valueOf(bdVideoSeries.getStartPosition());
        }
        return BdPlayerUtils.orZero(num);
    }

    public String getPlayerMode() {
        BDVideoPlayer bindPlayer = getBindPlayer();
        String str = null;
        UniversalPlayer universalPlayer = bindPlayer instanceof UniversalPlayer ? (UniversalPlayer) bindPlayer : null;
        if (universalPlayer != null) {
            str = universalPlayer.getCurrentMode();
        }
        return str == null ? "" : str;
    }

    public int getNetQuality() {
        return NetworkQuality.getNetworkQuality();
    }
}
