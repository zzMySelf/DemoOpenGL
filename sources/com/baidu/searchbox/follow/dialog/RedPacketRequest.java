package com.baidu.searchbox.follow.dialog;

import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.follow.net.FollowUrlConfig;
import com.baidu.searchbox.follow.redpacket.data.RedPacket;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionIdentityManager;
import java.util.Map;

public class RedPacketRequest {
    private static boolean DEBUG = FollowRuntime.isDebug();
    private static final String KEY_ACTION = "action";
    protected static final String KEY_CMD = "cmd";
    private static final String KEY_CMD_220 = "220";
    private static final String KEY_CMD_221 = "221";
    private static String TAG = "RedPacketRequest";
    private static final String VALUE_ACTION = "tengen";

    public static void getRedPacket(Map<String, String> postParams, ResponseCallback<RedPacket> listener) {
        String url = getBaseUrl("221");
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) FollowUrlConfig.getPostFormRequestBuilder().url(url)).params(postParams)).cookieManager(HttpManager.getDefault(FollowRuntime.getAppContext()).getCookieManager(true, false))).build().executeAsyncOnUIBack(listener);
    }

    public static void closeRedPacket(Map<String, String> postParams, ResponseCallback<RedPacket> listener) {
        String url = getBaseUrl("220");
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) FollowUrlConfig.getPostFormRequestBuilder().url(url)).params(postParams)).cookieManager(HttpManager.getDefault(FollowRuntime.getAppContext()).getCookieManager(true, false))).build().executeAsyncOnUIBack(listener);
    }

    public static String getBaseUrl(String cmd) {
        return InteractionIdentityManager.processUrl(UrlUtil.addParam(UrlUtil.addParam(FollowUrlConfig.getFeedBaseUrl(), "action", VALUE_ACTION), "cmd", cmd));
    }
}
