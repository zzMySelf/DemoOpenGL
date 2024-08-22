package com.baidu.searchbox.feed.factory;

import com.baidu.searchbox.feed.base.FeedTemplateManager;
import com.baidu.searchbox.feed.base.IFeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemDataLandMiniVideo;
import com.baidu.searchbox.feed.model.FeedItemDataMiniVideo;
import com.baidu.searchbox.feed.model.FeedItemDataMiniVideoAuthor;
import com.baidu.searchbox.feed.model.FeedItemDataTabTalent;
import com.baidu.searchbox.feed.template.FeedMiniVideoAuthorView;
import com.baidu.searchbox.feed.template.FeedMiniVideoLandSlideView;
import com.baidu.searchbox.feed.template.FeedMiniVideoSlideView;
import com.baidu.searchbox.feed.template.FeedTabMiniVideoView;
import com.baidu.searchbox.feed.template.FeedTabTopicMiniVideoView;
import com.baidu.searchbox.feed.template.FeedTabUserMiniVideoView;
import java.util.ArrayList;
import java.util.List;

public class MiniVideoFeedTemplates implements FeedTemplateManager.Collector {
    public List<IFeedTemplate> collect() {
        List<IFeedTemplate> templates = new ArrayList<>();
        templates.add(new SimpleFeedTemplate("mini_video", FeedTabMiniVideoView.class, FeedItemDataTabTalent.class, SimpleFeedTemplate.Policy.NO_ORIGINAL_POLICY));
        templates.add(new SimpleFeedTemplate("mini_topic_video", FeedTabTopicMiniVideoView.class, FeedItemDataTabTalent.class, SimpleFeedTemplate.Policy.NO_ORIGINAL_POLICY));
        templates.add(new SimpleFeedTemplate("video_land_minivideo", FeedMiniVideoLandSlideView.class, FeedItemDataLandMiniVideo.class, new SimpleFeedTemplate.Policy().showOriginalEnter(false).scrollable(true)));
        templates.add(new SimpleFeedTemplate("feed_author_mini_video", FeedMiniVideoAuthorView.class, FeedItemDataMiniVideoAuthor.class, SimpleFeedTemplate.Policy.NO_ORIGINAL_POLICY));
        templates.add(new SimpleFeedTemplate("user_mini_video", FeedTabUserMiniVideoView.class, FeedItemDataTabTalent.class, SimpleFeedTemplate.Policy.NO_ORIGINAL_POLICY));
        templates.add(new SimpleFeedTemplate("feed_mini_video", FeedMiniVideoSlideView.class, FeedItemDataMiniVideo.class, new SimpleFeedTemplate.Policy().showOriginalEnter(false).scrollable(true)));
        templates.add(new SimpleFeedTemplate("mini_video_activity", FeedTabTopicMiniVideoView.class, FeedItemDataTabTalent.class, SimpleFeedTemplate.Policy.NO_ORIGINAL_POLICY));
        return templates;
    }
}
