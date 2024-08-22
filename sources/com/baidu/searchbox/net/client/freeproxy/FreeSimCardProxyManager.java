package com.baidu.searchbox.net.client.freeproxy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.caches.SimpleKVFilePersister;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.interfere.NetworkInterfereHelper;
import com.baidu.searchbox.libsimcard.helper.SimBindHelper;
import com.baidu.searchbox.libsimcard.helper.SimCardHelper;
import com.baidu.searchbox.net.client.freeproxy.FreeProxyInfo;
import com.baidu.searchbox.network.NetworkRuntime;
import com.baidu.searchbox.network.NetworkSwitcherManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FreeSimCardProxyManager {
    private static final String APP_ID = "0001";
    private static final String APP_ID_KEY = "appid";
    private static final String CACHE_FILE = "free_proxy.json";
    private static final String CUID_KEY = "cuid";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = NetworkRuntime.GLOBAL_DEBUG;
    private static final String FREE_PROXY_URL = "https://userident.baidu.com/devbind/status";
    private static final String SCHEME_HTTP = "http://";
    private static final String SCHEME_HTTPS = "https://";
    private static final String TAG = "FreeSimCardProxyManager";
    private static final String VERSION_KEY = "version";
    private static volatile FreeSimCardProxyManager sInstance;
    private FreeProxyInfo mFreeProxyInfo = new FreeProxyInfo();
    /* access modifiers changed from: private */
    public boolean mIsUpdating = false;

    private FreeSimCardProxyManager() {
        recoverFromFile();
    }

    public static FreeSimCardProxyManager getInstance() {
        if (sInstance == null) {
            synchronized (FreeSimCardProxyManager.class) {
                if (sInstance == null) {
                    sInstance = new FreeSimCardProxyManager();
                }
            }
        }
        return sInstance;
    }

    public void update() {
        if (!NetworkInterfereHelper.isPeakTime() && !this.mIsUpdating && isFreeCardSwitchOn()) {
            this.mIsUpdating = true;
            ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(NetworkRuntime.getAppContext()).getRequest().url(FREE_PROXY_URL)).addUrlParam("appid", "0001")).addUrlParam("cuid", BaiduIdentityManager.getInstance(NetworkRuntime.getAppContext()).getUid())).addUrlParam("version", getLocalVersion())).build().executeAsync(new StringResponseCallback() {
                public void onSuccess(String s, int i2) {
                    FreeSimCardProxyManager.this.parse(s);
                    boolean unused = FreeSimCardProxyManager.this.mIsUpdating = false;
                    if (FreeSimCardProxyManager.DEBUG) {
                        Log.d(FreeSimCardProxyManager.TAG, "get white list from server --> " + s);
                    }
                }

                public void onFail(Exception e2) {
                    boolean unused = FreeSimCardProxyManager.this.mIsUpdating = false;
                    if (FreeSimCardProxyManager.DEBUG && e2 != null) {
                        String msg = e2.getLocalizedMessage();
                        Log.e(FreeSimCardProxyManager.TAG, msg == null ? "" : msg);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public synchronized void parse(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject json = new JSONObject(str);
                int optInt = json.optInt("status");
                String optString = json.optString("message");
                JSONObject data = json.optJSONObject("data");
                if (this.mFreeProxyInfo.parseJson(data)) {
                    saveToFile(data);
                    if (DEBUG) {
                        Log.d(TAG, "get new proxy info from server --> " + this.mFreeProxyInfo.toString());
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }

    public boolean isBind() {
        return this.mFreeProxyInfo.isBind();
    }

    public synchronized boolean isInWhiteList(String host) {
        return this.mFreeProxyInfo.getWhiteList().contains(host);
    }

    private void saveToFile(final JSONObject data) {
        if (data != null) {
            ExecutorUtilsExt.getSerialExecutor("save_data_to_file").execute(new Runnable() {
                public void run() {
                    ProxySimpleKVFilePersister.getPersister().putStringToFileSync(FreeSimCardProxyManager.CACHE_FILE, data.toString());
                }
            });
        }
    }

    private void recoverFromFile() {
        long start = System.currentTimeMillis();
        String json = ProxySimpleKVFilePersister.getPersister().getStringFromFileSync(CACHE_FILE);
        if (!TextUtils.isEmpty(json)) {
            try {
                this.mFreeProxyInfo.parseJson(new JSONObject(json));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (DEBUG) {
                Log.d(TAG, "sim card white list from file cost time --> " + (System.currentTimeMillis() - start) + " ms");
                Log.d(TAG, "proxy info --> " + this.mFreeProxyInfo.toString());
            }
        }
    }

    private String getLocalVersion() {
        return this.mFreeProxyInfo.getVersion();
    }

    public synchronized List<Proxy> getProxies(String scheme) {
        List<Proxy> proxies;
        proxies = new ArrayList<>();
        List<FreeProxyInfo.ProxyHost> proxyHosts = this.mFreeProxyInfo.getProxies(scheme);
        if (proxyHosts != null) {
            for (FreeProxyInfo.ProxyHost proxyHost : proxyHosts) {
                if (proxyHost.port != -1) {
                    proxies.add(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxyHost.host, proxyHost.port)));
                }
            }
        }
        return proxies;
    }

    private static class ProxySimpleKVFilePersister {
        private static final String PROXY_DIR = "free_proxy";

        private ProxySimpleKVFilePersister() {
        }

        /* access modifiers changed from: private */
        public static SimpleKVFilePersister getPersister() {
            return Holder.PERSISTER;
        }

        private static final class Holder {
            /* access modifiers changed from: private */
            public static final SimpleKVFilePersister PERSISTER = new SimpleKVFilePersister(ProxySimpleKVFilePersister.PROXY_DIR);

            private Holder() {
            }
        }
    }

    public boolean isNeedProxy(String host) {
        if (DEBUG) {
            Log.d(TAG, "isModelNetwork --> " + NetWorkUtils.isMobileNetworkConnected((Context) null));
            Log.d(TAG, "isHttpManagerFreeProxySwitchOn --> " + isHttpManagerFreeProxySwitchOn());
            Log.d(TAG, "isFreeCardSwitchOn --> " + isFreeCardSwitchOn());
            Log.d(TAG, "isSearchFreeSwitchOn --> " + isSearchFreeSwitchOn());
            Log.d(TAG, "isFreeCard --> " + isFreeCard());
            Log.d(TAG, "isInWhiteList --> " + isInWhiteList(host));
        }
        return NetWorkUtils.isMobileNetworkConnected((Context) null) && isHttpManagerFreeProxySwitchOn() && isFreeCardSwitchOn() && isSearchFreeSwitchOn() && isFreeCard() && !isInWhiteList(host);
    }

    private boolean isFreeCardSwitchOn() {
        return SimCardHelper.getInstance().isEnable();
    }

    private boolean isSearchFreeSwitchOn() {
        return PreferenceUtils.getBoolean(SimCardHelper.PREF_FREE_FLOW_SEARCH, true);
    }

    public boolean isFreeCard() {
        return SimCardHelper.getInstance().isFreeFlowCard() || SimBindHelper.getInstance().getSimBindStatusFromDisk();
    }

    private boolean isHttpManagerFreeProxySwitchOn() {
        return PreferenceUtils.getBoolean(NetworkSwitcherManager.KEY_SIMCARD_FREE_PROXY_PREF, true);
    }
}
