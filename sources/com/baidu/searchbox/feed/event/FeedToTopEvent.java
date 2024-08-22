package com.baidu.searchbox.feed.event;

import com.baidu.searchbox.home.feed.CeilingScene;

public class FeedToTopEvent {
    public CeilingScene mCeilingScene;
    public boolean mIsDelayFeedToTop = true;
    public boolean mIsDuringFragmentAnim = false;
    public boolean mIsNeedPreWebview = true;
    public boolean mIsSmoothScroll = false;

    public FeedToTopEvent(CeilingScene scene) {
        this.mCeilingScene = scene;
    }

    public FeedToTopEvent(boolean isDelayFeedToTop, boolean isDuringFragmentAnim, CeilingScene scene) {
        this.mIsDelayFeedToTop = isDelayFeedToTop;
        this.mIsDuringFragmentAnim = isDuringFragmentAnim;
        this.mCeilingScene = scene;
    }

    public FeedToTopEvent(boolean isDelayFeedToTop, boolean isDuringFragmentAnim, boolean isNeedPreWebview, CeilingScene scene) {
        this.mIsDelayFeedToTop = isDelayFeedToTop;
        this.mIsDuringFragmentAnim = isDuringFragmentAnim;
        this.mIsNeedPreWebview = isNeedPreWebview;
        this.mCeilingScene = scene;
    }

    public FeedToTopEvent(boolean isDelayFeedToTop, boolean isDuringFragmentAnim, boolean isNeedPreWebview, boolean isSmoothScroll, CeilingScene scene) {
        this.mIsDelayFeedToTop = isDelayFeedToTop;
        this.mIsDuringFragmentAnim = isDuringFragmentAnim;
        this.mIsNeedPreWebview = isNeedPreWebview;
        this.mIsSmoothScroll = isSmoothScroll;
        this.mCeilingScene = scene;
    }
}
