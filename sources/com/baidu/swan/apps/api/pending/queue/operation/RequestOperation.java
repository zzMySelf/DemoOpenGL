package com.baidu.swan.apps.api.pending.queue.operation;

import android.text.TextUtils;
import com.baidu.swan.apps.api.module.network.RequestApi;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.swan.apps.runtime.SwanApp;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestOperation extends BasePendingOperation {
    private static final CopyOnWriteArrayList<String> PENDING_REQUEST_URLS;
    private RequestApi mRequestApi;
    private final RequestApi.Requesting mRequesting;
    private SwanApp mSwanApp;

    static {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        PENDING_REQUEST_URLS = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        copyOnWriteArrayList.add("https://dxp.baidu.com/mini");
        copyOnWriteArrayList.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
        copyOnWriteArrayList.add("https://eclick.baidu.com/se.jpg");
        copyOnWriteArrayList.add("https://miniapp-ad.cdn.bcebos.com/miniapp_ad/config/cg.json");
    }

    public RequestOperation(RequestApi requestApi, SwanApp swanApp, RequestApi.Requesting requesting) {
        this.mRequestApi = requestApi;
        this.mSwanApp = swanApp;
        this.mRequesting = requesting;
    }

    public boolean allowsPending() {
        return isPendingUrlInWhiteList(this.mRequesting.params.optString("url"));
    }

    public String getModule() {
        return "request";
    }

    public String getParams() {
        return String.format("%s : %s", new Object[]{this.mSwanApp.getAppId(), this.mRequesting.params.optString("url")});
    }

    public BasePendingOperation.OperationType getType() {
        return BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST;
    }

    public void run() {
        this.mRequestApi.doRequest(this.mSwanApp, this.mRequesting);
    }

    private boolean isPendingUrlInWhiteList(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        int size = PENDING_REQUEST_URLS.size();
        for (int i2 = 0; i2 < size; i2++) {
            String pendingUrl = PENDING_REQUEST_URLS.get(i2);
            if (!TextUtils.isEmpty(pendingUrl) && url.startsWith(pendingUrl)) {
                return true;
            }
        }
        return false;
    }

    public static Collection<String> getPendingRequestUrls() {
        return PENDING_REQUEST_URLS;
    }
}
