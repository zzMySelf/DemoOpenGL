package com.baidu.wallet.lightapp.business.offlinecache;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LangbridgeCacheManager implements NoProguard, IOfflineCache {
    public final String OFFLINE_FAIL_OVER_OCCUR = "OfflineFailOverOccur";
    public final int a = 5000;
    public IOfflineCache b;
    public String c;
    public boolean d = true;
    public String e = "";
    public long f = 0;
    public int g = 5000;

    public static class a {
        public static LangbridgeCacheManager a = new LangbridgeCacheManager();
    }

    private void a(String str) {
        try {
            this.g = new JSONObject(str).optInt("refreshInterval", 5000);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static LangbridgeCacheManager getInstance() {
        return a.a;
    }

    public void forceLangbridgeCacheOnly(Context context, Boolean bool) {
        LangbridgePreloadCellCenter.getInstance(context).setAllCellsEnable(!bool.booleanValue());
    }

    public String getLangbridgeUA(Context context) {
        String str = this.c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
        }
        String userAgentString = new LightappBrowserWebView(DxmApplicationContextImpl.getApplicationContext(context)).getSettings().getUserAgentString();
        if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
            userAgentString = userAgentString + " " + BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
        }
        this.c = userAgentString;
        return userAgentString;
    }

    public String getOfflineCacheConfig(Context context) {
        return SdkInitResponse.getInstance().getOfflineCacheConfig(context);
    }

    public JSONObject getOfflineCacheInfo(String str) {
        if (a()) {
            return this.b.getOfflineCacheInfo(str);
        }
        return null;
    }

    public JSONObject getSummaryOfflineCacheInfo(String str) {
        JSONObject offlineCacheInfo;
        JSONObject jSONObject = new JSONObject();
        if (!(this.b == null || TextUtils.isEmpty(str) || (offlineCacheInfo = this.b.getOfflineCacheInfo(str)) == null)) {
            try {
                jSONObject.put("package_name", offlineCacheInfo.optString("name"));
                jSONObject.put("package_version", offlineCacheInfo.optString("decryVersion"));
            } catch (JSONException e2) {
                LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "JSONException on getSummaryOfflineCacheInfo", e2);
            }
        }
        return jSONObject;
    }

    public void handleCreateLangbirdge(String str, WebView webView) {
        if (a()) {
            this.b.handleCreateLangbirdge(str, webView);
        }
    }

    public void handleFinishLangbirdge(long j) {
        if (a()) {
            this.b.handleFinishLangbirdge(j);
        }
    }

    public void handleFinishPage(String str) {
        if (a()) {
            this.b.handleFinishPage(str);
        }
    }

    public void handleLoadUrl(long j, String str) {
        if (a()) {
            this.b.handleLoadUrl(j, str);
        }
    }

    public void handleStartLangbirdge(long j, String str) {
        if (a()) {
            this.b.handleStartLangbirdge(j, str);
        }
    }

    public void handleStartPage(String str) {
        if (a()) {
            this.b.handleStartPage(str);
        }
    }

    public WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        if (a()) {
            return this.b.interceptRequest(str, map);
        }
        return null;
    }

    public boolean isOfflineCacheReady(String str) {
        if (a()) {
            return this.b.isOfflineCacheReady(str);
        }
        return false;
    }

    public void offlineConfigUpdate(String str) {
        IOfflineCache iOfflineCache = this.b;
        if (iOfflineCache != null) {
            iOfflineCache.offlineConfigUpdate(str);
            a(str);
        }
    }

    public void onLangbridgeRefresh(Context context, String str) {
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.e.equals(str) && currentTimeMillis - this.f < ((long) this.g)) {
                this.d = false;
                HashMap hashMap = new HashMap();
                hashMap.put("code", "2");
                hashMap.put(LightAppStatEvent.PAGE_URL, str);
                Tracker.send("OfflineFailOverOccur", (Map<String, String>) hashMap, context);
            }
            this.e = str;
            this.f = currentTimeMillis;
        }
    }

    public void setLangbridgeUA(String str) {
        if (TextUtils.isEmpty(this.c)) {
            this.c = str;
        }
    }

    public void setOfflineCacheImpl(IOfflineCache iOfflineCache) {
        this.b = iOfflineCache;
    }

    public boolean showProgressLine(String str) {
        if (a()) {
            return this.b.showProgressLine(str);
        }
        return true;
    }

    private boolean a() {
        return this.b != null && this.d;
    }
}
