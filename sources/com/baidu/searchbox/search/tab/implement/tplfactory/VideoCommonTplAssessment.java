package com.baidu.searchbox.search.tab.implement.tplfactory;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.search.tab.implement.VideoTplNamaCenterKt;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAssessmentModel;
import com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAssessmentView;
import org.json.JSONObject;

public class VideoCommonTplAssessment extends SimpleFeedTemplate {
    public VideoCommonTplAssessment() {
        super(VideoTplNamaCenterKt.SEARCH_VIDEO_ASSESSMENT, VideoCommonAssessmentView.class, VideoCommonAssessmentModel.class, SimpleFeedTemplate.Policy.POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        return new VideoCommonAssessmentView(ctx);
    }

    /* access modifiers changed from: protected */
    public FeedItemData newItemModel(JSONObject dataObj) {
        return new VideoCommonAssessmentModel();
    }
}
