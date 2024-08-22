package com.baidu.searchbox.net;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.net.client.apache.DataFlowHttpClient;
import com.baidu.searchbox.net.client.apache.DefaultHttpClient;
import com.baidu.searchbox.net.client.apache.ProxyHttpClient;
import com.baidu.searchbox.network.NetworkRuntime;

public final class ProxyHttpClientFactory {
    private static final boolean DEBUG = NetworkRuntime.GLOBAL_DEBUG;
    private static final String KEY_HTTP_CLIENT_SWITCH = "KEY_HTTP_CLIENT_SWITCH";
    public static final boolean NETWORK_OKHTTP_DEFAULT = true;
    public static final String NETWORK_OKHTTP_SWITCH = "net_okhttp";
    private static final String TAG = "ProxyHttpClientFactory";

    public enum HttpClientTypeEnum {
        DATAFLOW_TYPE,
        PROXY_TYPE,
        DEFAULT_TYPE
    }

    public static boolean getUseOriginHttpclient() {
        return !AbTestManager.getInstance().getSwitch("net_okhttp", true);
    }

    public static IProxyHttpClient getHttpClinet(Context context, HttpClientTypeEnum httpClientTypeEnum, boolean isUseOriginHttpclient) {
        if (DEBUG) {
            Log.d(TAG, "baidu_network  use origin apache http client: " + isUseOriginHttpclient);
        }
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$net$ProxyHttpClientFactory$HttpClientTypeEnum[httpClientTypeEnum.ordinal()]) {
            case 1:
                if (isUseOriginHttpclient) {
                    return new DataFlowHttpClient(context);
                }
                return new com.baidu.searchbox.net.client.okhttp.DataFlowHttpClient(context);
            case 2:
                if (isUseOriginHttpclient) {
                    return new ProxyHttpClient(context);
                }
                return new com.baidu.searchbox.net.client.okhttp.ProxyHttpClient(context);
            case 3:
                if (isUseOriginHttpclient) {
                    return new DefaultHttpClient();
                }
                return new com.baidu.searchbox.net.client.okhttp.DefaultHttpClient();
            default:
                return null;
        }
    }

    /* renamed from: com.baidu.searchbox.net.ProxyHttpClientFactory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$net$ProxyHttpClientFactory$HttpClientTypeEnum;

        static {
            int[] iArr = new int[HttpClientTypeEnum.values().length];
            $SwitchMap$com$baidu$searchbox$net$ProxyHttpClientFactory$HttpClientTypeEnum = iArr;
            try {
                iArr[HttpClientTypeEnum.DATAFLOW_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$net$ProxyHttpClientFactory$HttpClientTypeEnum[HttpClientTypeEnum.PROXY_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$net$ProxyHttpClientFactory$HttpClientTypeEnum[HttpClientTypeEnum.DEFAULT_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static IProxyHttpClient getHttpClinet(Context context, HttpClientTypeEnum httpClientTypeEnum) {
        boolean useOriginHttpClient = getUseOriginHttpclient();
        if (DEBUG) {
            useOriginHttpClient = !isDebugUseOkHttpClient() && useOriginHttpClient;
        }
        return getHttpClinet(context, httpClientTypeEnum, useOriginHttpClient);
    }

    private static boolean isDebugUseOkHttpClient() {
        return PreferenceManager.getDefaultSharedPreferences(NetworkRuntime.getAppContext()).getBoolean(KEY_HTTP_CLIENT_SWITCH, false);
    }
}
