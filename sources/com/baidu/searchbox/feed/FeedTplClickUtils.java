package com.baidu.searchbox.feed;

import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.template.FeedLabelView;

public final class FeedTplClickUtils {
    private FeedTplClickUtils() {
    }

    public static void setNeedShowUnlikeIcon(FeedTemplate feedTemplate, boolean showUnlikeIcon) {
        FeedLabelView labelView;
        if (feedTemplate != null && (labelView = (FeedLabelView) feedTemplate.getRootView().findViewById(R.id.feed_label_view)) != null) {
            labelView.setNeedShowUnlikeIcon(showUnlikeIcon);
        }
    }
}
