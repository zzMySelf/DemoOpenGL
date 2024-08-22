package com.baidu.searchbox.feed.video.parser;

import android.text.TextUtils;
import com.baidu.android.util.io.StreamUtils;
import com.baidu.searchbox.ad.exp.AdPolicyMiniVideo;
import com.baidu.searchbox.ccs.AdPolicyUpdateListener;
import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataTabTalent;
import com.baidu.searchbox.feed.model.IFeedItemModel;
import com.baidu.searchbox.feed.model.IFeedProtocol;
import com.baidu.searchbox.feed.net.ADRequester;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.parser.IFeedDataParser;
import com.baidu.searchbox.feed.parser.ValidationResult;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.video.MiniVideoAdShowsCountCallback;
import com.baidu.searchbox.feed.video.model.MiniVideoAdModel;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniVideoAdModelParser {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    public String business = "mini_video";
    public String channelId;
    private MiniVideoAdShowsCountCallback mAdShowsCountCallback;
    private IFeedProtocol mFeedProtocol;

    public MiniVideoAdModel parseResponse(InputStream result, IFeedProtocol feedProtocol) {
        this.mFeedProtocol = feedProtocol;
        return parse(result);
    }

    private MiniVideoAdModel parse(InputStream result) {
        JSONObject codeObj;
        JSONArray itemsArray;
        String strResult = StreamUtils.streamToString(result);
        if (strResult == null) {
            return null;
        }
        MiniVideoAdModel miniVideoAdModel = new MiniVideoAdModel();
        try {
            JSONObject jsonObject = new JSONObject(strResult);
            miniVideoAdModel.error = jsonObject.optString("errno");
            miniVideoAdModel.timestamp = jsonObject.optString("timestamp");
            JSONObject dataJsonObj = jsonObject.optJSONObject("data");
            if (dataJsonObj == null || (codeObj = dataJsonObj.optJSONObject(this.mFeedProtocol.obtainCmdFlow())) == null || (itemsArray = codeObj.optJSONArray("items")) == null) {
                return miniVideoAdModel;
            }
            ArrayList<FeedBaseModel> feedBaseModelList = new ArrayList<>();
            int arraySize = itemsArray.length();
            IFeedDataParser<IFeedItemModel, JSONObject> parser = FeedApi.DataParsers.defaultBaseModelConfig().channelId(this.channelId).business(this.business).build();
            for (int i2 = 0; i2 < arraySize; i2++) {
                JSONObject itemObj = itemsArray.getJSONObject(i2);
                extendAdIdInDeferCharge(itemObj);
                FeedBaseModel feedBaseModel = (FeedBaseModel) parser.parse(itemObj);
                ValidationResult validationResult = FeedBaseModel.checkValidate(feedBaseModel);
                if (validationResult.isOk()) {
                    if (i2 < 3) {
                        prefetchImage(feedBaseModel);
                    }
                    feedBaseModelList.add(feedBaseModel);
                    MiniVideoAdShowsCountCallback miniVideoAdShowsCountCallback = this.mAdShowsCountCallback;
                    if (miniVideoAdShowsCountCallback != null) {
                        miniVideoAdShowsCountCallback.adShowsCount();
                    }
                } else if (FeedFilter.checkAdFeed(feedBaseModel)) {
                    ADRequester.postADDropLog(feedBaseModel, validationResult.code);
                }
            }
            miniVideoAdModel.feedBaseModelList = feedBaseModelList;
            JSONObject objAdPolicy = codeObj.optJSONObject(AdPolicyUpdateListener.KEY_AD_POLICY_ACTION);
            if (objAdPolicy != null) {
                miniVideoAdModel.adPolicy = new AdPolicyMiniVideo(objAdPolicy);
            }
            return miniVideoAdModel;
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void prefetchImage(FeedBaseModel feedBaseModel) {
        if (feedBaseModel != null && (feedBaseModel.data instanceof FeedItemDataTabTalent)) {
            FeedUtil.prefetchImage(((FeedItemDataTabTalent) feedBaseModel.data).mMiniLandBackground);
            FeedUtil.prefetchImage(((FeedItemDataTabTalent) feedBaseModel.data).mMiniLandPoster);
        }
    }

    public void setAdShowsCountCallback(MiniVideoAdShowsCountCallback adShowsCountCallback) {
        this.mAdShowsCountCallback = adShowsCountCallback;
    }

    private void extendAdIdInDeferCharge(JSONObject modelObj) {
        if (modelObj != null && modelObj.has("defer_charge_urls")) {
            try {
                String id = modelObj.getString("id");
                if (!TextUtils.isEmpty(id)) {
                    JSONObject dataObj = new JSONObject(modelObj.getString("data"));
                    JSONObject deferObj = new JSONObject(dataObj.getString("defer_charge_urls"));
                    deferObj.put("id", id);
                    dataObj.put("defer_charge_urls", deferObj.toString());
                    modelObj.put("data", dataObj);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
