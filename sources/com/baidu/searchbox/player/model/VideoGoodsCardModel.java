package com.baidu.searchbox.player.model;

import org.json.JSONObject;

public class VideoGoodsCardModel implements Comparable<VideoGoodsCardModel> {
    public String mCmd;
    public String mDesc;
    public int mEndShowTime;
    public JSONObject mExtLog;
    public JSONObject mExtLogRdc;
    public String mGid;
    public String mGuideText;
    public String mMoneyText;
    public String mOriginMoney;
    public double mPosterRatio;
    public String mPosterUrl;
    public int mShowTimeInPlayer;
    public int mStartShowTime;
    public String mTagText;
    public String mTitleText;

    public int compareTo(VideoGoodsCardModel model) {
        return this.mShowTimeInPlayer - model.mShowTimeInPlayer;
    }
}
