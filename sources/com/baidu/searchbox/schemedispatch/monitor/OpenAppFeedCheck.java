package com.baidu.searchbox.schemedispatch.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import com.baidu.searchbox.utils.SchemeSpUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class OpenAppFeedCheck extends OpenAppBaseCheck implements IFeedCheck {
    private static final String DATA_TAG_LIGHT_BROWSE_LIST = "feed_wlist";
    private static final String DATA_TAG_LIGHT_BROWSE_TYPE = "feed_opt";
    private static final String SCHEME_FEED_WHITE_LIST_FILENAME = "scheme_feed_white_list_invoke";
    public static final String SCHEME_FORBID_FEED_TYPE_SPKEY = "scheme_forbid_feed_opt_key";
    private static final String TAG = "OpenAppFeedCheck";
    private static List<SchemeCheckInfo> sFeedWhiteList = new ArrayList();

    public boolean saveWhiteListDispatch(JSONObject data) {
        String feedOpt = data.optString(DATA_TAG_LIGHT_BROWSE_TYPE);
        JSONArray feedWhiteList = data.optJSONArray(DATA_TAG_LIGHT_BROWSE_LIST);
        if (TextUtils.isEmpty(feedOpt) || feedWhiteList == null) {
            if (DEBUG) {
                Log.d(TAG, "Type or feed whitelist is empty");
            }
            return false;
        }
        List<String> dataList = new ArrayList<>();
        for (int index = 0; index < feedWhiteList.length(); index++) {
            dataList.add(feedWhiteList.optString(index));
        }
        if (!writeCache(dataList, SCHEME_FEED_WHITE_LIST_FILENAME)) {
            return false;
        }
        SchemeSpUtil.getInstance().putString(SCHEME_FORBID_FEED_TYPE_SPKEY, feedOpt);
        synchronized (OpenAppFeedCheck.class) {
            sFeedWhiteList.clear();
            sFeedWhiteList.addAll(SchemeCheckInfoKt.toSchemeCheckInfoList(dataList));
        }
        return true;
    }

    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                OpenAppFeedCheck.loadFeedWhiteList();
                FileUtils.deleteCache(AppRuntime.getAppContext(), "scheme_feed_white_list");
            }
        }, "SchemeFeedWhiteListLoad", 2);
    }

    /* access modifiers changed from: private */
    public static synchronized void loadFeedWhiteList() {
        synchronized (OpenAppFeedCheck.class) {
            sFeedWhiteList.clear();
            sFeedWhiteList.addAll(SchemeCheckInfoKt.toSchemeCheckInfoList(readCache(SCHEME_FEED_WHITE_LIST_FILENAME)));
        }
    }

    public SchemeCheckInfo checkSchemeInFeedWhiteList(String originScheme, String pageUrl, String refer) {
        SchemeCheckInfo match;
        if (TextUtils.isEmpty(originScheme)) {
            return null;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString(SCHEME_FORBID_FEED_TYPE_SPKEY, "0"), "0")) {
            SchemeForbidStatisticUtils.onEvent(pageUrl, originScheme, false, true, "feed", refer);
            return null;
        }
        synchronized (OpenAppFeedCheck.class) {
            match = getInfoInList(originScheme, sFeedWhiteList);
            SchemeForbidStatisticUtils.onEvent(pageUrl, originScheme, true, canInvoke(match), "feed", refer);
        }
        return match;
    }

    /* Debug info: failed to restart local var, previous not found, register: 6 */
    public synchronized SchemeCheckInfo adCheckSchemeInFeedWhiteList(String originScheme, String invokeFlag, SchemeStatisticField fields) {
        if (TextUtils.isEmpty(originScheme)) {
            return null;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString(SCHEME_FORBID_FEED_TYPE_SPKEY, "0"), "0")) {
            SchemeForbidStatisticUtils.onEvent(fields.addField("scheme", originScheme).addField("enable", "0").addField("type", "clk_feed").addField("invokable", "1"));
            return null;
        }
        SchemeCheckInfo match = null;
        synchronized (OpenAppFeedCheck.class) {
            try {
                if (!TextUtils.equals(invokeFlag, "0")) {
                    try {
                        match = getInfoInList(originScheme, sFeedWhiteList);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                SchemeForbidStatisticUtils.onEvent(fields.addField("scheme", originScheme).addField("enable", "1").addField("type", "clk_feed").addField("invokable", canInvoke(match) ? "1" : "0"));
                return match;
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }
}
