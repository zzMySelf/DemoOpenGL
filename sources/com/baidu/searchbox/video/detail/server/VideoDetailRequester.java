package com.baidu.searchbox.video.detail.server;

import android.text.TextUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.net.FeedRequester;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.video.detail.core.model.VideoDetailModel;
import com.baidu.searchbox.video.detail.export.ISearchVideoPrivacyManager;
import com.baidu.searchbox.video.detail.export.IVideoBaiduIdentityManager;
import com.baidu.searchbox.video.detail.export.IVideoReqStats;
import com.baidu.searchbox.video.detail.export.IVideoUrlUtils;
import com.baidu.searchbox.video.detail.plugin.component.right.model.TrainingGroupModel;
import com.baidu.searchbox.video.detail.utils.VideoDetailPathFactory;
import com.baidu.searchbox.video.detail.utils.VideoUrlConfig;
import com.baidu.searchbox.video.payment.player.VideoPaymentUrlModel;
import java.util.Map;
import org.json.JSONObject;

public class VideoDetailRequester {
    private static final String BUSINESS = "search";
    private static final String KEY_ACTION = "action";
    private static final String KEY_CMD = "cmd";
    private static final String VALUE_ACTION = "feed";

    public static void getVideoDetailData(String url, String tpl, Map<String, String> getParams, Map<String, String> postParams, StatResponseCallback<VideoDetailModel> listener) {
        String url2 = IVideoUrlUtils.Impl.get().appendParams(addCommonParameters(url + VideoDetailPathFactory.create(tpl).getLandPath(), "search".equals(tpl)), getParams);
        PostFormRequest.PostFormRequestBuilder builder = FeedRequester.getHttpManager().postFormRequest();
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) builder.url(url2)).params(postParams)).enableStat(true);
        if (TextUtils.equals("feed", tpl)) {
            ((PostFormRequest.PostFormRequestBuilder) builder.requestFrom(IVideoReqStats.Impl.get().getFrom())).requestSubFrom(IVideoReqStats.Impl.get().getVideoDetailSubFrom());
        } else if (TextUtils.equals("search", tpl)) {
            ((PostFormRequest.PostFormRequestBuilder) builder.requestFrom(IVideoReqStats.Impl.get().getSearchFrom())).requestSubFrom(IVideoReqStats.Impl.get().getSearchVideoDetailSubFrom());
        }
        if (url2.startsWith("https://") || TextUtils.equals(tpl, "feedpayment")) {
            builder.cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false));
        }
        ((PostFormRequest.PostFormRequestBuilder) builder.connectionTimeout(3000)).build().executeStatUIBack(listener);
    }

    public static void getVideoRelateFlow(String url, String tpl, Map<String, String> getParams, Map<String, String> postParams, ResponseCallback<JSONObject> listener) {
        String url2 = IVideoUrlUtils.Impl.get().appendParams(addCommonParameters(url + VideoDetailPathFactory.create(tpl).getRelatePath(), "search".equals(tpl)), getParams);
        if (url2.startsWith("https://")) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(FeedRuntime.getAppContext()).postFormRequest().url(url2)).params(postParams)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).build().executeAsyncOnUIBack(listener);
            return;
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(FeedRuntime.getAppContext()).postFormRequest().url(url2)).params(postParams)).build().executeAsyncOnUIBack(listener);
    }

    public static void fetchVideoPaymentUrl(Map<String, String> getParams, ResponseCallback<VideoPaymentUrlModel> listener) {
        String url = IVideoUrlUtils.Impl.get().appendParams(getBaseUrl("259"), getParams);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(FeedRuntime.getAppContext()).postFormRequest().url(url)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).enableStat(true)).requestFrom(IVideoReqStats.Impl.get().getFrom())).requestSubFrom(IVideoReqStats.Impl.get().getPaymentUrlSubFrom())).build().executeAsync(listener);
    }

    private static String getBaseUrl(String cmd) {
        return IVideoBaiduIdentityManager.Impl.get().processUrl(IVideoUrlUtils.Impl.get().appendParam(IVideoUrlUtils.Impl.get().appendParam(VideoUrlConfig.getFeedBaseUrl(), "action", "feed"), "cmd", cmd));
    }

    private static String addCommonParameters(String url, boolean isComponent) {
        if (isComponent) {
            return ISearchVideoPrivacyManager.Impl.get().componentProcessUrl(url);
        }
        return IVideoBaiduIdentityManager.Impl.get().processUrl(url);
    }

    public static void fetchVideoDetailTrainingGroup(Map<String, String> postParams, ResponseCallback<TrainingGroupModel> listener) {
        String url = getBaseUrl("284");
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(FeedRuntime.getAppContext()).postFormRequest().url(url)).params(postParams)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).enableStat(true)).build().executeAsync(listener);
    }
}
