package com.baidu.searchbox.search.tab.bottom.interactbar;

import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.config.FeedUrlConfig;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class CoolPraiseVM {
    CoolPraiseVM() {
    }

    public void processLike(Context context, FeedBaseModel baseModel, CoolPraiseView praiseView, FeedBar.Like like) {
        processLikeData(praiseView, like, baseModel);
        String url = BaiduIdentityManager.getInstance().appendParam(FeedUrlConfig.getLikeUrl(), 1, true, true);
        JSONObject json = new JSONObject();
        try {
            json.put("nid", baseModel.id);
            json.put("type", like.status ? "1" : "0");
            json.put("ext", like.ext);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        Map<String, String> params = new HashMap<>();
        params.put("data", json.toString());
        StringResponseCallback callback = new StringResponseCallback() {
            public void onSuccess(String response, int statusCode) {
            }

            public void onFail(Exception exception) {
            }
        };
        if (url.startsWith("https://")) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postFormRequest().url(url)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(false, false))).params(params)).build().executeAsyncOnUIBack(callback);
        } else {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postFormRequest().url(url)).params(params)).build().executeAsyncOnUIBack(callback);
        }
    }

    private void processLikeData(CoolPraiseView praiseView, FeedBar.Like like, FeedBaseModel baseModel) {
        boolean isPraised = praiseView.getIsPraisedState();
        if (!isPraised) {
            like.count--;
        } else {
            like.count++;
        }
        praiseView.setPraiseCount(String.valueOf(like.count));
        praiseView.setPraiseCntsVisibility(like.count > 0);
        like.status = isPraised;
        LinkageData linkageData = new LinkageData();
        linkageData.nid = baseModel.id;
        linkageData.status = isPraised ? "1" : "0";
        linkageData.count = String.valueOf(like.count);
        linkageData.type = "pro";
        linkageData.isUsed = true;
        FeedLinkageManager.getInstance(baseModel.runtimeStatus.business).addLinkage(linkageData);
    }
}
