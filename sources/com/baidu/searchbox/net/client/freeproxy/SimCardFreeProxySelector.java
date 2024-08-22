package com.baidu.searchbox.net.client.freeproxy;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.network.NetworkRuntime;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

public class SimCardFreeProxySelector extends ProxySelector {
    private static final boolean DEBUG = NetworkRuntime.GLOBAL_DEBUG;
    private static final String TAG = "SimCardFreeProxy";
    private Context mContext;
    private ProxySelector mDefaultSystemProxySelector = ProxySelector.getDefault();

    public SimCardFreeProxySelector(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public List<Proxy> select(URI uri) {
        List<Proxy> proxies = null;
        if (uri != null && FreeSimCardProxyManager.getInstance().isNeedProxy(uri.getHost())) {
            proxies = getFreeProxy(uri);
            if (DEBUG && proxies != null && proxies.size() > 0) {
                Log.d(TAG, "need proxy url is --> " + uri.toString());
                Log.d(TAG, "free proxy is --> " + proxies.toString());
            }
        }
        if (proxies == null || proxies.size() <= 0) {
            return this.mDefaultSystemProxySelector.select(uri);
        }
        return proxies;
    }

    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        this.mDefaultSystemProxySelector.connectFailed(uri, sa, ioe);
    }

    private List<Proxy> getFreeProxy(URI uri) {
        return FreeSimCardProxyManager.getInstance().getProxies(uri.getScheme());
    }
}
