package com.baidu.searchbox.feed.template.utils;

import android.text.TextUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/template/utils/FeedTabParamsUtils;", "", "()V", "tabBusiness", "", "tabId", "tabSource", "getTabBusiness", "getTabId", "getTabSource", "isValid", "", "parseTabParams", "Lcom/baidu/searchbox/feed/template/utils/FeedTabParamsUtils$TabParamsData;", "params", "TabParamsData", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTabParamsUtils.kt */
public final class FeedTabParamsUtils {
    public static final FeedTabParamsUtils INSTANCE = new FeedTabParamsUtils();
    private static String tabBusiness;
    private static String tabId;
    private static String tabSource;

    private FeedTabParamsUtils() {
    }

    public final TabParamsData parseTabParams(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        TabParamsData tabData = new TabParamsData();
        try {
            JSONObject paramsJson = new JSONObject(params);
            tabData.setTabId(paramsJson.optString("tab_id"));
            tabData.setTabBusiness(paramsJson.optString("tab"));
            tabData.setTabSource(paramsJson.optString("source"));
            tabSource = tabData.getTabSource();
            tabId = tabData.getTabId();
            tabBusiness = tabData.getTabBusiness();
        } catch (JSONException e2) {
            if (FeedRuntime.GLOBAL_DEBUG) {
                e2.printStackTrace();
            }
        }
        return tabData;
    }

    public final String getTabSource() {
        return tabSource;
    }

    public final String getTabBusiness() {
        return tabBusiness;
    }

    public final String getTabId() {
        return tabId;
    }

    public final boolean isValid() {
        return !TextUtils.isEmpty(tabBusiness) && !TextUtils.isEmpty(tabSource) && !TextUtils.isEmpty(tabId);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/template/utils/FeedTabParamsUtils$TabParamsData;", "", "()V", "tabBusiness", "", "getTabBusiness", "()Ljava/lang/String;", "setTabBusiness", "(Ljava/lang/String;)V", "tabId", "getTabId", "setTabId", "tabSource", "getTabSource", "setTabSource", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTabParamsUtils.kt */
    public static final class TabParamsData {
        private String tabBusiness;
        private String tabId;
        private String tabSource;

        public final String getTabId() {
            return this.tabId;
        }

        public final void setTabId(String str) {
            this.tabId = str;
        }

        public final String getTabBusiness() {
            return this.tabBusiness;
        }

        public final void setTabBusiness(String str) {
            this.tabBusiness = str;
        }

        public final String getTabSource() {
            return this.tabSource;
        }

        public final void setTabSource(String str) {
            this.tabSource = str;
        }
    }
}
