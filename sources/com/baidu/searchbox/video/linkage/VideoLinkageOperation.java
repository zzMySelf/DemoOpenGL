package com.baidu.searchbox.video.linkage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.feed.controller.FeedLinkageOperation;
import com.baidu.searchbox.feed.controller.ILinkageOperation;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataStarScroll;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.tab.model.VideoTabTracker;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.video.controller.VideoBaseDataManager;
import com.baidu.searchbox.video.controller.VideoDataManagerFactory;
import com.baidu.searchbox.video.runtime.VideoRuntime;

public class VideoLinkageOperation extends FeedLinkageOperation {
    private static final boolean DEBUG = VideoRuntime.DEBUG;
    private static final String TAG = "VideoLinkageOperation";
    private static volatile ILinkageOperation sInstance;

    private VideoLinkageOperation() {
    }

    public static ILinkageOperation getInstance() {
        if (sInstance == null) {
            synchronized (VideoLinkageOperation.class) {
                if (sInstance == null) {
                    sInstance = new VideoLinkageOperation();
                }
            }
        }
        return sInstance;
    }

    /* access modifiers changed from: protected */
    public void saveLinkageData(LinkageData linkageData) {
        FeedBaseModel model;
        if (linkageData != null) {
            VideoBaseDataManager dataManager = VideoDataManagerFactory.getDataManager(VideoTabTracker.INSTANCE.getCurrentChannelId());
            if (TextUtils.equals(linkageData.type, "pro")) {
                FeedBaseModel model2 = dataManager.getFeedBaseMode(linkageData.nid);
                if (isFeedBarLikeValid(model2)) {
                    updateLinkLike(model2, linkageData, dataManager);
                    if (DEBUG) {
                        Log.d(TAG, "Update List Item in VideoPageView/like");
                    }
                }
            } else if (TextUtils.equals(linkageData.type, "favor")) {
                FeedBaseModel model3 = dataManager.getFeedBaseModeByUkey(linkageData.nid);
                if (isFeedBarFavorValid(model3)) {
                    updateLinkFavor(model3, linkageData, dataManager);
                    if (DEBUG) {
                        Log.d(TAG, "Update List Item in VideoPageView/favor");
                    }
                }
            } else if (TextUtils.equals(linkageData.type, "comment")) {
                FeedBaseModel model4 = dataManager.getFeedBaseMode(linkageData.nid);
                if (isFeedBarCommentValid(model4)) {
                    updateLinkComment(model4, linkageData, dataManager);
                }
            } else if (TextUtils.equals(linkageData.type, "follow")) {
                processFollowStatus(dataManager, linkageData);
            } else if (TextUtils.equals(linkageData.type, "dislike")) {
                FeedBaseModel model5 = dataManager.getFeedBaseMode(linkageData.nid);
                if (isFeedBarDislikeValid(model5)) {
                    updateLinkDisLike(model5, linkageData, dataManager);
                    if (DEBUG) {
                        Log.d(TAG, "Update List Item in VideoPageView/Dislike");
                    }
                }
            } else if (TextUtils.equals(linkageData.type, ILinkageOperation.TYPE_PLAY_COUNT) && (model = dataManager.getFeedBaseMode(linkageData.nid)) != null && model.data != null && model.data.feedBar != null && model.data.feedBar.playCount != null) {
                FeedBar feedBar = model.data.feedBar;
                int count = FeedUtil.convertStringToIntSafe(linkageData.count);
                if (feedBar.playCount.count != count) {
                    feedBar.playCount.count = count;
                    dataManager.updateFeed(model);
                } else {
                    linkageData.isUsed = true;
                }
                linkageData.handled = true;
            }
        }
    }

    private void updateLinkLike(FeedBaseModel model, LinkageData linkageData, VideoBaseDataManager dataManager) {
        FeedBar feedBar = model.data.feedBar;
        boolean status = TextUtils.equals(linkageData.status, "1");
        int count = FeedUtil.convertStringToIntSafe(linkageData.count);
        if (feedBar.like.status == status && feedBar.like.count == count) {
            linkageData.isUsed = true;
        } else {
            feedBar.like.status = status;
            feedBar.like.count = count;
            dataManager.updateFeed(model);
        }
        linkageData.handled = true;
    }

    private void updateLinkFavor(FeedBaseModel model, LinkageData linkageData, VideoBaseDataManager dataManager) {
        FeedBar feedBar = model.data.feedBar;
        boolean isFavored = TextUtils.equals(linkageData.status, "1");
        if (isFavored != feedBar.favor.isFavored) {
            feedBar.favor.isFavored = isFavored;
            dataManager.updateFeed(model);
        } else {
            linkageData.isUsed = true;
        }
        linkageData.handled = true;
    }

    private void updateLinkComment(FeedBaseModel model, LinkageData linkageData, VideoBaseDataManager dataManager) {
        FeedBar feedBar = model.data.feedBar;
        int countFromLinkage = FeedUtil.convertStringToIntSafe(linkageData.count);
        if (feedBar.comment.count != countFromLinkage) {
            feedBar.comment.count = countFromLinkage;
            dataManager.updateFeed(model);
        } else {
            linkageData.isUsed = true;
        }
        linkageData.handled = true;
    }

    private void updateLinkDisLike(FeedBaseModel model, LinkageData linkageData, VideoBaseDataManager dataManager) {
        FeedBar feedBar = model.data.feedBar;
        boolean status = TextUtils.equals(linkageData.status, "1");
        int count = FeedUtil.convertStringToIntSafe(linkageData.count);
        if (feedBar.degrade.status == status && feedBar.degrade.count == count) {
            linkageData.isUsed = true;
        } else {
            feedBar.degrade.status = status;
            feedBar.degrade.count = count;
            dataManager.updateFeed(model);
        }
        linkageData.handled = true;
    }

    private boolean isFeedBarLikeValid(FeedBaseModel model) {
        return isFeedBarValid(model) && model.data.feedBar.like != null;
    }

    private boolean isFeedBarFavorValid(FeedBaseModel model) {
        return isFeedBarValid(model) && model.data.feedBar.favor != null;
    }

    private boolean isFeedBarCommentValid(FeedBaseModel model) {
        return isFeedBarValid(model) && model.data.feedBar.comment != null;
    }

    private boolean isFeedBarDislikeValid(FeedBaseModel model) {
        return isFeedBarValid(model) && model.data.feedBar.degrade != null;
    }

    private boolean isFeedBarFollowValid(FeedBaseModel model) {
        return isFeedBarValid(model) && model.data.feedBar.follow != null;
    }

    private boolean isFeedBarValid(FeedBaseModel model) {
        return (model == null || model.data == null || model.data.feedBar == null) ? false : true;
    }

    private void processFollowStatus(VideoBaseDataManager videoDataManager, LinkageData linkageData) {
        if (TextUtils.isEmpty(linkageData.nid)) {
            for (FeedBaseModel model : videoDataManager.getCachedFeeds()) {
                doSaveFollowStatus(videoDataManager, model, linkageData);
            }
            return;
        }
        doSaveFollowStatus(videoDataManager, videoDataManager.getFeedBaseMode(linkageData.nid), linkageData);
    }

    private void doSaveFollowStatus(VideoBaseDataManager feedDataManager, FeedBaseModel model, LinkageData linkageData) {
        FeedItemData.AdditionalInfo.FollowButton button;
        if (model != null && model.data != null) {
            boolean isNeedUpdateDB = false;
            if (checkFeedItemData(model.data.mAdditionalInfo, linkageData)) {
                FeedItemData.AdditionalInfo.FollowButton button2 = model.data.mAdditionalInfo.button;
                if (button2 != null && !TextUtils.equals(button2.state, linkageData.status)) {
                    button2.state = linkageData.status;
                    isNeedUpdateDB = true;
                }
            } else if (model.data.topAuthorInfo != null && checkFeedItemData(model.data.topAuthorInfo.followInfo, linkageData)) {
                FeedItemData.AdditionalInfo.FollowButton button3 = model.data.topAuthorInfo.followInfo.button;
                if (button3 != null && !TextUtils.equals(button3.state, linkageData.status)) {
                    FeedItemData.AdditionalInfo followInfo = model.data.topAuthorInfo.followInfo;
                    if (followInfo.isCompleteForRedBonusInfo()) {
                        followInfo.activityType = "";
                        if (followInfo.button.buttonDatas.size() > 0) {
                            followInfo.button.buttonDatas.get(0).color = followInfo.followRedBonusActivityInfo.normalColor;
                            followInfo.button.buttonDatas.get(0).bgcolor = followInfo.followRedBonusActivityInfo.normalBgColor;
                            followInfo.button.buttonDatas.get(0).bgcolorTaped = followInfo.followRedBonusActivityInfo.normalBgColorTaped;
                        }
                    }
                    button3.state = linkageData.status;
                    isNeedUpdateDB = true;
                }
            } else if ((model.data instanceof FeedItemDataStarScroll) && ((FeedItemDataStarScroll) model.data).itemDataList != null && ((FeedItemDataStarScroll) model.data).itemDataList.size() > 0) {
                for (FeedItemDataStarScroll.StarScrollItemData item : ((FeedItemDataStarScroll) model.data).itemDataList) {
                    if (checkFeedItemData(item.followInfo, linkageData) && (button = item.followInfo.button) != null && !TextUtils.equals(button.state, linkageData.status)) {
                        button.state = linkageData.status;
                        isNeedUpdateDB = true;
                    }
                }
            } else if (model.data instanceof FeedItemDataTabVideo) {
                isNeedUpdateDB = processTabLabelFollow(model, linkageData);
            }
            if (isNeedUpdateDB) {
                linkageData.handled = true;
                feedDataManager.updateFeed(model);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean processTabLabelFollow(FeedBaseModel model, LinkageData linkageData) {
        if (!isFeedBarFollowValid(model)) {
            return false;
        }
        FeedItemDataTabVideo feedItemData = (FeedItemDataTabVideo) model.data;
        if (!checkFeedItemData(feedItemData.feedBar.follow.info, linkageData)) {
            return false;
        }
        FeedBar.Follow follow = feedItemData.feedBar.follow;
        if (TextUtils.equals(follow.isFollow, linkageData.status)) {
            return false;
        }
        follow.isFollow = linkageData.status;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean checkFeedItemData(FeedItemData.AdditionalInfo followInfo, LinkageData linkageData) {
        return followInfo != null && linkageData.ext != null && !TextUtils.isEmpty(followInfo.type) && !TextUtils.isEmpty(followInfo.thirdId) && TextUtils.equals(linkageData.ext.get(ILinkageOperation.FOLLOW_INFO_TYPE), followInfo.type) && TextUtils.equals(linkageData.ext.get("third_id"), followInfo.thirdId);
    }
}
