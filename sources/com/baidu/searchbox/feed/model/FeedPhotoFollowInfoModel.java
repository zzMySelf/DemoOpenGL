package com.baidu.searchbox.feed.model;

import org.json.JSONObject;

public class FeedPhotoFollowInfoModel {
    public String mFollowUrl;
    public String mStatus;
    public String mThirdId;
    public String mType;
    public String mUnFollowUrl;

    public static FeedPhotoFollowInfoModel parse(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        FeedPhotoFollowInfoModel data = new FeedPhotoFollowInfoModel();
        data.mFollowUrl = jsonObject.optString("add_url");
        data.mUnFollowUrl = jsonObject.optString("cancel_url");
        data.mType = jsonObject.optString("type");
        data.mThirdId = jsonObject.optString("third_id");
        data.mStatus = jsonObject.optString("status");
        return data;
    }
}
