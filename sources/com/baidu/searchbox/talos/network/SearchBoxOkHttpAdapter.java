package com.baidu.searchbox.talos.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.adapter.IOkHttpAdapter;
import com.baidu.talos.network.DefaultContainerImpl;
import com.baidu.talos.network.TLSForwardUtils;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class SearchBoxOkHttpAdapter implements IOkHttpAdapter {
    private volatile OkHttpClient mOkHttpClient;

    public OkHttpClient getOkHttpClient() {
        if (this.mOkHttpClient == null) {
            synchronized (this) {
                if (this.mOkHttpClient == null) {
                    this.mOkHttpClient = HttpManager.newHttpManager(TalosAppRuntimeInit.getAppContext()).getOkHttpClient().newBuilder().connectTimeout(0, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).cookieJar(new DefaultContainerImpl()).build();
                    OkHttpClient newClient = TLSForwardUtils.addInterceptor(this.mOkHttpClient);
                    if (newClient != null) {
                        this.mOkHttpClient = newClient;
                    }
                }
            }
        }
        return this.mOkHttpClient;
    }
}
