package com.baidu.searchbox.follow.recommend;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.follow.net.Callback;
import com.baidu.searchbox.follow.net.FollowUrlConfig;
import com.baidu.searchbox.follow.recommend.data.IFollowRecommendItem;
import com.baidu.searchbox.follow.recommend.data.RelatedRecommendAccountItem;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestParasBuilder;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionIdentityManager;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RelatedRecommendRequest {
    private static final String KEY_CMD = "cmd";
    private static final String KEY_CONTENT_UPDATE_MARK = "content_update_mark";
    private static final String KEY_ID = "id";
    private static final String KEY_INTRO = "intro";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_LOGO = "logo";
    private static final String KEY_SCHEMA = "schema";
    private static final String KEY_TAGS = "tags";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TYPE_ID = "type_id";
    private static final String KEY_VIP_TYPE = "vip_type";
    private static final String REQUEST_KEY_CURRENT_TYPE = "current_type";
    private static final String REQUEST_KEY_NID = "nid";
    private static final String REQUEST_KEY_NUM = "num";
    public static final int REQUEST_MAX_NUM = 20;

    public void requestRelatedRecommendList(Context context, String type, String thirdId, String nid, Callback<List<IFollowRecommendItem>> callback) {
        requestRelatedRecommendList(context, type, thirdId, nid, 0, callback);
    }

    public void requestRelatedRecommendList(Context context, String type, String thirdId, String nid, int timeout, final Callback<List<IFollowRecommendItem>> callback) {
        ResponseCallback<List<IFollowRecommendItem>> responseCallback = new ResponseCallback<List<IFollowRecommendItem>>() {
            public List<IFollowRecommendItem> parseResponse(Response response, int i2) throws Exception {
                if (response.body() != null) {
                    return RelatedRecommendRequest.this.parseResponse(response.body().string());
                }
                return null;
            }

            public void onSuccess(List<IFollowRecommendItem> recommendItems, int statusCode) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(recommendItems);
                }
            }

            public void onFail(Exception e2) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure();
                }
            }
        };
        if (NetWorkUtils.isNetworkConnected(context)) {
            HttpRequestParasBuilder builder = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) FollowUrlConfig.getPostFormRequestBuilder().url(InteractionIdentityManager.processUrl(FollowUrlConfig.getFollowRelatedRecommendListUrl()))).addParam("num", "20")).addParam("sfrom", "sbox")).addParam(REQUEST_KEY_CURRENT_TYPE, type)).addParam("third_id", thirdId);
            if (!TextUtils.isEmpty(nid)) {
                builder.addParam("nid", nid);
            }
            if (timeout > 0) {
                builder.connectionTimeout(timeout);
            }
            builder.cookieManager(HttpManager.getDefault(FollowRuntime.getAppContext()).getCookieManager(true, false)).build().executeAsyncOnUIBack(responseCallback);
        } else if (callback != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    callback.onNetworkException();
                }
            });
        }
    }

    public List<IFollowRecommendItem> parseResponse(String result) {
        JSONObject dataJson;
        BaseJsonData baseJsonData = BaseJsonData.fromJson(result);
        if (baseJsonData == null || baseJsonData.getErrorCode() != 0 || (dataJson = baseJsonData.getData()) == null) {
            return null;
        }
        List<IFollowRecommendItem> recommendItems = null;
        try {
            JSONArray items = dataJson.getJSONArray("items");
            if (items != null && items.length() > 0) {
                recommendItems = new ArrayList<>();
                for (int i2 = 0; i2 < items.length(); i2++) {
                    JSONObject itemJson = items.getJSONObject(i2);
                    RelatedRecommendAccountItem item = new RelatedRecommendAccountItem();
                    item.id = itemJson.getString("id");
                    item.typeId = itemJson.getString("type_id");
                    item.logo = itemJson.getString("logo");
                    item.title = itemJson.getString("title");
                    item.intro = itemJson.getString("intro");
                    item.vipType = itemJson.getString("vip_type");
                    item.cmd = itemJson.getString("cmd");
                    item.scheme = itemJson.getString("schema");
                    JSONArray tagsJa = itemJson.getJSONArray("tags");
                    for (int k = 0; k < tagsJa.length(); k++) {
                        String tag = (String) tagsJa.get(k);
                        if (!TextUtils.isEmpty(tag)) {
                            item.tags.add(tag);
                        }
                    }
                    JSONArray markJa = itemJson.getJSONArray(KEY_CONTENT_UPDATE_MARK);
                    for (int k2 = 0; k2 < markJa.length(); k2++) {
                        String mark = (String) markJa.get(k2);
                        if (!TextUtils.isEmpty(mark)) {
                            item.contentUpdateMark.add(mark);
                        }
                    }
                    if (!item.tags.isEmpty()) {
                        if (!item.contentUpdateMark.isEmpty()) {
                            recommendItems.add(item);
                        }
                    }
                }
            }
            return recommendItems;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
