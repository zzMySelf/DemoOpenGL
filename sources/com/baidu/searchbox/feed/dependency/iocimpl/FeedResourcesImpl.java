package com.baidu.searchbox.feed.dependency.iocimpl;

import com.baidu.searchbox.feed.fluency.IFeedResourcesConfig;
import com.baidu.searchbox.feed.template.R;

public class FeedResourcesImpl implements IFeedResourcesConfig {
    public int getMuteVideoID() {
        return R.layout.feed_tpl_mute_video_view_fluency;
    }

    public int getThreeImgID() {
        return R.layout.feed_tpl_triple_image_fluency;
    }

    public int getOneImgID() {
        return R.layout.feed_tpl_single_image_ab_test_fluency;
    }

    public int getStarThreeImgID() {
        return R.layout.feed_tpl_star_triple_image_fluency;
    }

    public int getStarOneImgID() {
        return R.layout.feed_tpl_star_big_image_fluency;
    }

    public int getAdBigImgID() {
        return R.layout.feed_ad_tpl_big_image_fluency;
    }

    public int getAdVerticalVideoID() {
        return R.layout.feed_ad_tpl_ad_vertical_video_fluency;
    }

    public int getAdThreeImgID() {
        return R.layout.feed_ad_tpl_triple_image_fluency;
    }

    public int getAdVideoID() {
        return R.layout.feed_ad_tpl_ad_video_fluency;
    }

    public int getAdSingleImgID() {
        return R.layout.feed_ad_tpl_single_image_for_img_right_fluency;
    }

    public int getStarOneImgThreeLinesID() {
        return R.layout.feed_tpl_single_image_three_lines_ab_test_fluency;
    }

    public int getBigImageID() {
        return R.layout.feed_tpl_big_image_fluency;
    }
}
