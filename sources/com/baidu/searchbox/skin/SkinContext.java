package com.baidu.searchbox.skin;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.skin.ioc.ISkinContext;
import com.baidu.searchbox.skin.model.Skin;
import com.baidu.searchbox.skin.statistic.NightDurationStatistic;
import com.baidu.searchbox.skin.util.SkinBroadcastSender;
import com.baidu.swan.api.SwanAppApi;
import com.facebook.drawee.generic.RootDrawable;
import org.json.JSONException;
import org.json.JSONObject;

public class SkinContext implements ISkinContext {
    private static final String NIGHT_MODE_ACTION = "com.baidu.channel.foundation.nightmodechanged";
    public static final String SKIN_NIGHT_PACKAGE_NAME = "com.baidu.searchbox.skin.night";
    private static final int UI_COVER_LAYER_COLOR = 2130706432;

    public void notifyNightModeState(Context context, boolean enable, boolean forceSync) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("isNightMode", enable ? 1 : 0);
            SkinBroadcastSender.sendBroadcast(context, NIGHT_MODE_ACTION, jo.toString());
            if (enable) {
                NightDurationStatistic.startTiming();
            } else {
                NightDurationStatistic.stopTiming();
            }
            if (!forceSync && ProcessUtils.isMainProcess()) {
                SwanAppApi.getMessageSender().sendNightModeState();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void notifyUpdateSkin(Skin skin) {
        RootDrawable.setGlobalColorFilter(getUiCoverColorFilter());
    }

    public void notifyResetSkin(boolean forceChange) {
        RootDrawable.setGlobalColorFilter((ColorFilter) null);
    }

    public String getSkinVersion() {
        return String.format("%s_%s", new Object[]{BuildConfigManager.getString("SkinVersion", "SKIN_VERSION"), BuildConfigManager.getString("BuildConfig", "VERSION_NAME")});
    }

    public String getNightPackageName() {
        return SKIN_NIGHT_PACKAGE_NAME;
    }

    public boolean uesSystemNightMode() {
        return false;
    }

    private ColorFilter getUiCoverColorFilter() {
        return new PorterDuffColorFilter(2130706432, PorterDuff.Mode.SRC_ATOP);
    }
}
