package com.baidu.searchbox.hissug.searchable.bean;

import android.text.TextUtils;
import com.baidu.searchbox.hissug.his.HisParams;

public class SSPlaceHolderSuggestion extends Suggestion {
    private String flag;

    public SSPlaceHolderSuggestion(String flag2) {
        this.flag = flag2;
    }

    public String getFlag() {
        return this.flag;
    }

    public void updateHisParams(HisParams params) {
        if (params != null) {
            if (TextUtils.equals(this.flag, "website")) {
                params.hasShowWebSite = true;
            } else if (TextUtils.equals(this.flag, SugConstants.DIRECT_SUG_VIDEO)) {
                params.hasShowVideo = true;
            } else if (TextUtils.equals(this.flag, "pic")) {
                params.hasShowPicture = true;
            } else if (TextUtils.equals(this.flag, "constellation")) {
                params.hasShowConstellation = true;
            } else if (TextUtils.equals(this.flag, "postcode")) {
                params.hasShowZipCode = true;
            } else if (TextUtils.equals(this.flag, SugConstants.DIRECT_SUG_ZONECODE)) {
                params.hasShowDistrictCode = true;
            } else if (TextUtils.equals(this.flag, "custom")) {
                params.hasShowCustom = true;
            } else if (TextUtils.equals(this.flag, "novel")) {
                params.hasShowNovel = true;
            } else if (TextUtils.equals(this.flag, "weather")) {
                params.hasShowWeather = true;
            } else if (TextUtils.equals(this.flag, "translate")) {
                params.hasShowTranslate = true;
            } else if (TextUtils.equals(this.flag, "movie")) {
                params.hasShowMovie = true;
            } else if (TextUtils.equals(this.flag, "music")) {
                params.hasShowMusic = true;
            } else if (TextUtils.equals(this.flag, "hot")) {
                params.hasShowHot = true;
            } else if (TextUtils.equals(this.flag, "entity")) {
                params.hasShowEntity = true;
            } else if (TextUtils.equals(this.flag, "answer")) {
                params.hasShowAnswer = true;
            }
        }
    }
}
