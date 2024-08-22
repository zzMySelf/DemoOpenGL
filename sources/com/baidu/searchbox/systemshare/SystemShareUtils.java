package com.baidu.searchbox.systemshare;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.boxshare.constants.ShareConstants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.socialshare.runtime.SocialShareRuntime;
import com.baidu.searchbox.socialshare.statistics.SocialShareStatisticHelper;
import com.baidu.searchbox.socialshare.utils.Utils;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.ubc.UBCManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemShareUtils {
    private static final String TAG = "SystemShareUtils";

    public static String getUrl(String data) {
        String value = "";
        if (TextUtils.isEmpty(data)) {
            return value;
        }
        Matcher matcher = Pattern.compile(SystemShareConstants.REGULAR).matcher(data);
        if (matcher != null && matcher.find()) {
            value = matcher.group();
        }
        if (!UrlUtil.isUrl(value)) {
            return "";
        }
        return value;
    }

    public static String delTextUrls(String value) {
        if (TextUtils.isEmpty(value)) {
            return value;
        }
        Matcher matcher = Pattern.compile(SystemShareConstants.REGULAR).matcher(value);
        while (matcher != null && matcher.find()) {
            value = value.replace(matcher.group(), "");
            matcher = Pattern.compile(SystemShareConstants.REGULAR).matcher(value);
        }
        return value.replaceAll("\n", "");
    }

    public static void doSystemShareUBCEvent(String shareValue) {
        UBCManager ubcManager = Utils.getUBCManager();
        if (ubcManager != null) {
            String ubcEvent = SocialShareStatisticHelper.generateUBCEvent(ShareConstants.UBC_SYSTEM_SHARE_TYPE, ShareConstants.UBC_SYSTEM_SHARE_FROM, BaiduIdentityManager.getInstance(SocialShareRuntime.getAppContext()).getModel(), shareValue, ShareConstants.UBC_SYSTEM_SHARE_TYPE);
            ubcManager.onEvent("430", ubcEvent);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doSystemShareUBCEvent ubcEvent: " + ubcEvent);
            }
        }
    }
}
