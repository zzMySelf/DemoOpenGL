package com.baidu.searchbox.hotdiscussion.linkage.compare;

import android.text.TextUtils;
import com.baidu.searchbox.dynamic.template.model.DynamicVideoData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.generalcommunity.ui.GCommunityViewModel;

public class MiniVideoTemplateCompare implements GCommunityViewModel.ITemplateCompare {
    private final boolean isFuzzyCompare;

    public MiniVideoTemplateCompare() {
        this(false);
    }

    public MiniVideoTemplateCompare(boolean isFuzzyCompare2) {
        this.isFuzzyCompare = isFuzzyCompare2;
    }

    public boolean isTemplateKey(String key, FeedBaseModel baseModel) {
        if (this.isFuzzyCompare) {
            key = NormalTemplateCompare.getFuzzyId(key);
        }
        if (!TextUtils.isEmpty(key) && baseModel != null && (baseModel.data instanceof DynamicVideoData)) {
            DynamicVideoData data = (DynamicVideoData) baseModel.data;
            if (data.videoInfo != null) {
                return TextUtils.equals(data.videoInfo.vid, key);
            }
        }
        return false;
    }
}
