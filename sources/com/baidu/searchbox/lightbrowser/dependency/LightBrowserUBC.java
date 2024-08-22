package com.baidu.searchbox.lightbrowser.dependency;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.feed.config.NewsHelper;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.lightbrowser.LightBrowserRuntime;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserUBC;
import com.baidu.searchbox.lightbrowser.statistic.LightBrowserStatisticConstants;
import com.baidu.searchbox.lightbrowser.utils.LightBrowserUtil;
import com.baidu.ubc.bussiness.UBCDurationSearchSession;
import org.json.JSONException;
import org.json.JSONObject;

public class LightBrowserUBC implements ILightBrowserUBC {
    public JSONObject extendExt(JSONObject extJson, Intent intent) {
        if (extJson == null) {
            return null;
        }
        try {
            if (UBCDurationSearchSession.isInSearchSession()) {
                extJson.put("s_session", UBCDurationSearchSession.getSSession());
            }
            if (FeedConfig.isTeenagerMode()) {
                extJson.put("child_mode", "1");
            }
            if (NewsHelper.isColdRestore(intent)) {
                extJson.put("coldstart", "1");
            }
            if (LightBrowserUtil.isSearchRevisit(intent)) {
                extJson.put(LightBrowserStatisticConstants.UBC_REVISIT_TYPE, "search");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return extJson;
    }

    public String getPerformanceExtra(Context context, String url, String slog) {
        if (context == null) {
            return "";
        }
        String bk = LightBrowserRuntime.getLightBrowserContext().getZeusVersion(context.getApplicationContext());
        String netTypeId = NetWorkUtils.getNetworkTypeString(context);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cc", "");
            jsonObject.put("net", netTypeId);
            jsonObject.put("url", url);
            jsonObject.put("bker", bk);
            jsonObject.put("slog", slog);
            jsonObject.put(FeedStatisticConstants.UBC_EXT_KEY_DEVICE, LightBrowserUtil.getSystemDeviceGrade());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject.toString();
    }
}
