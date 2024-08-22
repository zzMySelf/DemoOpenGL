package com.baidu.searchbox.search.video.plugin;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.statistic.FeedDisplayReport;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.video.plugin.FeedAdAlsLogPlugin;
import com.baidu.searchbox.video.detail.utils.BusinessUtils;
import java.util.ArrayList;
import java.util.List;

public class SearchAdLogPlugin extends FeedAdAlsLogPlugin {
    /* access modifiers changed from: protected */
    public void handleFenRunClick(FeedBaseModel feedBaseModel, int viewType) {
    }

    /* access modifiers changed from: protected */
    public void handleFenRunShow(FeedBaseModel model, int viewType) {
        if (FeedFilter.checkAdFeed(model) && !"2".equals(model.data.feedFloorType) && !FeedTplNameCenter.HIDDEN.equals(model.layout)) {
            List<FeedBaseModel> feedList = new ArrayList<>();
            feedList.add(model);
            FeedDisplayReport.getCommendUtil(BusinessUtils.getBusiness(this.mComponentManager.currentModel)).reportFeedDisplay(feedList, 1, true);
        }
    }
}
