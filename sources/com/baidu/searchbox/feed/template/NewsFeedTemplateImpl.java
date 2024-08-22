package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ad.util.AdQuickPersistConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.IFeedTplContainer;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.flow.util.FontAdjustment;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataStar;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.template.FeedTemplateImpl;
import com.baidu.searchbox.feed.template.statistic.FeedChannelConstants;
import com.baidu.searchbox.feed.template.util.FontSizeExpUtil;
import com.baidu.searchbox.feed.template.view.divinecomment.FeedDivineCommentView;
import com.baidu.searchbox.feed.template.view.outcomment.FeedHotTemplateOutComment;
import com.baidu.searchbox.feed.template.view.poi.FeedHotPoiView;
import com.baidu.searchbox.skin.NightModeHelper;
import java.util.Map;

public class NewsFeedTemplateImpl implements FeedTemplate {
    public FeedHotTemplateOutComment feedHotOutComment;
    public FeedHotPoiView feedHotPoiView;
    public FeedTemplateImpl mBaseTemplateImpl;
    public FeedBarView mFeedBarView;
    public FeedDivineCommentView mFeedDivineComment;
    public FeedRelatedLabelView mFeedRelatedView;
    protected FeedItemStarTitleBar mFeedTitlebar;
    protected TextView mTitleFoldView;

    public NewsFeedTemplateImpl(FeedTemplateImpl baseTemplateImpl) {
        this.mBaseTemplateImpl = baseTemplateImpl;
    }

    public void onClick(View v) {
    }

    public void setOnChildViewClickListener(FeedTemplate.OnChildViewClickListener listener) {
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> map) {
    }

    public void afterCreateViewHolder() {
    }

    public void beforeBindViewHolder(FeedBaseModel feedModel) {
    }

    public void afterBindViewHolder(FeedBaseModel feedModel) {
    }

    public FeedBaseModel getFeedModel() {
        return this.mBaseTemplateImpl.getFeedModel();
    }

    public void hideBottomDivider(boolean needHide) {
        if (this.mBaseTemplateImpl.mBottomDivider != null) {
            int i2 = 0;
            if (isNeedShowThickDivider()) {
                FeedTemplateImpl feedTemplateImpl = this.mBaseTemplateImpl;
                if (!feedTemplateImpl.isShowFeedDescRichText(feedTemplateImpl.mFeedModel)) {
                    this.mBaseTemplateImpl.mBottomDivider.setVisibility(0);
                    return;
                }
            }
            if (isNeedShowThickDivider()) {
                FeedTemplateImpl feedTemplateImpl2 = this.mBaseTemplateImpl;
                if (feedTemplateImpl2.isShowFeedDescRichText(feedTemplateImpl2.mFeedModel)) {
                    this.mBaseTemplateImpl.mBottomDivider.setVisibility(8);
                    return;
                }
            }
            if (isNeedShowThickDivider() || !FeedTemplateImpl.isNeedShowFeedDesc(this.mBaseTemplateImpl.mFeedModel)) {
                View view2 = this.mBaseTemplateImpl.mBottomDivider;
                if (needHide) {
                    i2 = 4;
                }
                view2.setVisibility(i2);
                return;
            }
            this.mBaseTemplateImpl.mBottomDivider.setVisibility(4);
        }
    }

    public void updateRefreshTime() {
    }

    public void applyFontSize() {
    }

    public void applyFeedNightMode() {
        FeedDivineCommentView feedDivineCommentView = this.mFeedDivineComment;
        if (feedDivineCommentView != null) {
            feedDivineCommentView.onNightModeChanged();
        }
    }

    public void applyRoundUiPolicy() {
    }

    public void initialize(Context context) {
    }

    public void onFontSizeChanged(int fontSizeInPx) {
        FeedBarView feedBarView = this.mFeedBarView;
        if (feedBarView != null) {
            feedBarView.onFontSizeChanged();
        }
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
    }

    public void setChannelId(String channelId) {
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return null;
    }

    public void bindFeedTplContainer(IFeedTplContainer feedTplContainer) {
    }

    public FeedBarView getFeedBarView() {
        return this.mFeedBarView;
    }

    public FeedItemStarTitleBar getFeedTitlebar() {
        return this.mFeedTitlebar;
    }

    public String getChannelId() {
        return this.mBaseTemplateImpl.mChannelId;
    }

    public void checkFeedBarView() {
        FeedBarView barView = this.mFeedBarView;
        View dividerInXml = this.mBaseTemplateImpl.mBottomDivider;
        if (barView != null && dividerInXml == null) {
            barView.setShowTopDivider(true);
        }
    }

    private boolean isNeedShowThickDivider() {
        FeedBarView feedBarView = this.mFeedBarView;
        return feedBarView != null && feedBarView.getVisibility() == 0 && FeedTemplateImpl.isNeedShowFeedBar(this.mBaseTemplateImpl.mFeedModel);
    }

    private void initFeedHotPoiView(FeedBaseModel model, FeedTemplate host) {
        View view2;
        if (this.feedHotPoiView == null && (view2 = host.getRootView().findViewById(R.id.feed_tpl_hot_poi_view_id)) != null) {
            if (view2 instanceof ViewStub) {
                this.feedHotPoiView = (FeedHotPoiView) ((ViewStub) view2).inflate();
            } else if (view2 instanceof FeedHotPoiView) {
                this.feedHotPoiView = (FeedHotPoiView) view2;
            }
        }
    }

    private void initFeedBarView(FeedBaseModel model, FeedTemplate host) {
        View view2;
        if (this.mFeedBarView == null && (view2 = host.getRootView().findViewById(R.id.feed_bar_view)) != null) {
            if (view2 instanceof ViewStub) {
                this.mFeedBarView = (FeedBarView) ((ViewStub) view2).inflate();
            } else if (view2 instanceof FeedBarView) {
                this.mFeedBarView = (FeedBarView) view2;
            }
        }
    }

    private void initFeedProfileTitleBar(FeedBaseModel model, FeedTemplate host) {
        View view2;
        if (this.mFeedTitlebar == null && (view2 = host.getRootView().findViewById(R.id.feed_profile_title_bar)) != null) {
            if (view2 instanceof ViewStub) {
                this.mFeedTitlebar = (FeedItemStarTitleBar) ((ViewStub) view2).inflate();
                FontAdjustment.clearFontSizeLevelTag(host);
            } else if (view2 instanceof FeedItemStarTitleBar) {
                this.mFeedTitlebar = (FeedItemStarTitleBar) view2;
            }
        }
    }

    private void initTitleFoldView(FeedBaseModel model, FeedTemplate host) {
        TextView textView = this.mTitleFoldView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (model != null && model.data != null && model.data.isNeedFold && FeedTemplateImpl.isNeedShowFold(model)) {
            if (this.mTitleFoldView == null) {
                View view2 = host.getRootView().findViewById(R.id.feed_title_fold_stub);
                if (view2 != null && (view2 instanceof ViewStub)) {
                    TextView textView2 = (TextView) ((ViewStub) view2).inflate();
                    this.mTitleFoldView = textView2;
                    textView2.setTextColor(FeedRuntime.getAppContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC90));
                    this.mTitleFoldView.setTextSize((float) DeviceUtil.ScreenInfo.px2dp(FeedRuntime.getAppContext(), (float) FontSizeExpUtil.getStarTitleFontSize(model)));
                }
            } else if (!model.data.isFolded) {
                this.mTitleFoldView.setVisibility(8);
            } else {
                this.mTitleFoldView.setVisibility(0);
            }
        }
    }

    private boolean needShowPoiView(FeedBaseModel feedModel, FeedTemplateImpl.Config<?> config) {
        FeedRuntimeStatus status = feedModel.runtimeStatus;
        FeedItemData itemData = feedModel.data;
        return (itemData instanceof FeedItemDataStar) && !((FeedItemDataStar) itemData).isTop && ((FeedItemDataStar) itemData).poiData != null && ((FeedItemDataStar) itemData).poiData.check() && !FeedChannelConstants.isFeedChannel(status.channelId) && itemData.hitDynamicLayoutStyle();
    }

    private void updateFeedHotPoiView(FeedBaseModel feedModel, FeedTemplate host, FeedTemplateImpl.Config<?> config) {
        FeedHotPoiView feedHotPoiView2 = this.feedHotPoiView;
        if (feedHotPoiView2 != null) {
            feedHotPoiView2.setVisibility(8);
        }
        if (needShowPoiView(feedModel, config)) {
            initFeedHotPoiView(feedModel, host);
            FeedHotPoiView feedHotPoiView3 = this.feedHotPoiView;
            if (feedHotPoiView3 != null) {
                feedHotPoiView3.setVisibility(0);
                this.feedHotPoiView.update(feedModel, ((FeedItemDataStar) feedModel.data).poiData, false);
            }
        }
    }

    private void updateFeedRelatedView(FeedBaseModel feedModel, FeedTemplate host, FeedTemplateImpl.Config<?> config) {
        FeedRelatedLabelView feedRelatedLabelView = this.mFeedRelatedView;
        if (feedRelatedLabelView != null) {
            feedRelatedLabelView.setVisibility(8);
        }
        if (needShowRelatedView(feedModel)) {
            initRelatedContentView(feedModel, host);
            FeedRelatedLabelView feedRelatedLabelView2 = this.mFeedRelatedView;
            if (feedRelatedLabelView2 != null) {
                feedRelatedLabelView2.setVisibility(0);
                this.mFeedRelatedView.update(feedModel, ((FeedItemDataStar) feedModel.data).relatedData);
            }
        }
    }

    private boolean needShowRelatedView(FeedBaseModel feedModel) {
        return (feedModel.data instanceof FeedItemDataStar) && ((FeedItemDataStar) feedModel.data).relatedData != null && !TextUtils.isEmpty(((FeedItemDataStar) feedModel.data).relatedData.relatedTitle) && !TextUtils.isEmpty(((FeedItemDataStar) feedModel.data).relatedData.cmd);
    }

    private void initRelatedContentView(FeedBaseModel model, FeedTemplate host) {
        View view2;
        if (this.mFeedRelatedView == null && (view2 = host.getRootView().findViewById(R.id.feed_related_content)) != null) {
            if (view2 instanceof ViewStub) {
                this.mFeedRelatedView = (FeedRelatedLabelView) ((ViewStub) view2).inflate();
            } else if (view2 instanceof FeedRelatedLabelView) {
                this.mFeedRelatedView = (FeedRelatedLabelView) view2;
            }
        }
    }

    private boolean needShowFeedBar(FeedBaseModel feedModel, FeedTemplateImpl.Config<?> config) {
        return config.needShowFeedBar && FeedTemplateImpl.isNeedShowFeedBar(feedModel) && feedModel.data != null && !feedModel.data.hitDynamicLayoutStyle();
    }

    private void updateFeedBarView(FeedBaseModel feedModel, FeedTemplate host, FeedTemplateImpl.Config<?> config) {
        FeedBarView feedBarView = this.mFeedBarView;
        if (feedBarView != null) {
            feedBarView.setVisibility(8);
        }
        if (needShowFeedBar(feedModel, config)) {
            initFeedBarView(feedModel, host);
            FeedBarView feedBarView2 = this.mFeedBarView;
            if (feedBarView2 != null) {
                feedBarView2.setVisibility(0);
                updateFeedBarCommentCount(feedModel);
                checkFeedBarView();
                this.mFeedBarView.update(feedModel);
            }
        }
    }

    public void initCommonViewsIfNeed(FeedBaseModel feedModel, FeedTemplate host, FeedTemplateImpl.Config config) {
        updateFeedHotPoiView(feedModel, host, config);
        updateFeedBarView(feedModel, host, config);
        initTitleFoldView(feedModel, host);
        updateFeedRelatedView(feedModel, host, config);
        if (config.needShowTitleBar && FeedTemplateImpl.isNeedShowTitleBar(feedModel)) {
            initFeedProfileTitleBar(feedModel, host);
        }
        if (FeedTemplateImpl.isNeedShowOutCommentView(feedModel)) {
            initFeedHotOutComment(feedModel, host);
        }
        if (FeedTemplateImpl.isNeedShowDivineCommentView(feedModel)) {
            initFeedDivineComment(host);
        }
        FeedItemStarTitleBar feedItemStarTitleBar = this.mFeedTitlebar;
        if (feedItemStarTitleBar != null) {
            feedItemStarTitleBar.update(feedModel);
        }
        FeedHotTemplateOutComment feedHotTemplateOutComment = this.feedHotOutComment;
        if (feedHotTemplateOutComment != null) {
            feedHotTemplateOutComment.update(feedModel);
        }
        FeedDivineCommentView feedDivineCommentView = this.mFeedDivineComment;
        if (feedDivineCommentView != null) {
            feedDivineCommentView.update(feedModel);
        }
    }

    private void initFeedHotOutComment(FeedBaseModel feedModel, FeedTemplate host) {
        View view2;
        if (this.feedHotOutComment == null && (view2 = host.getRootView().findViewById(R.id.feed_hot_out_comment_stub)) != null) {
            if (view2 instanceof ViewStub) {
                this.feedHotOutComment = (FeedHotTemplateOutComment) ((ViewStub) view2).inflate();
            } else if (view2 instanceof FeedHotTemplateOutComment) {
                this.feedHotOutComment = (FeedHotTemplateOutComment) view2;
            }
            FeedHotTemplateOutComment feedHotTemplateOutComment = this.feedHotOutComment;
            if (feedHotTemplateOutComment != null) {
                feedHotTemplateOutComment.setBusiness(feedModel.runtimeStatus.channelId);
                this.feedHotOutComment.setAnchorView(this.mBaseTemplateImpl.mFeedLabelView);
                this.feedHotOutComment.onNightModeChanged(NightModeHelper.isNightMode());
            }
        }
    }

    private void initFeedDivineComment(FeedTemplate host) {
        View view2;
        if (this.mFeedDivineComment == null && host.getRootView() != null && (view2 = host.getRootView().findViewById(R.id.feed_tpl_divine_comment_view_stub_id)) != null) {
            if (view2 instanceof ViewStub) {
                this.mFeedDivineComment = (FeedDivineCommentView) ((ViewStub) view2).inflate();
            } else if (view2 instanceof FeedDivineCommentView) {
                this.mFeedDivineComment = (FeedDivineCommentView) view2;
            }
        }
    }

    private void updateFeedBarCommentCount(FeedBaseModel feedModel) {
        FeedBar feedBar;
        int commentCount;
        if (FeedFilter.checkAdFeed(feedModel) && this.mFeedBarView.getFeedBar() != null && (feedBar = this.mFeedBarView.getFeedBar()) != null && feedBar.comment != null && (commentCount = AdQuickPersistConfig.Companion.getInstance().getInt(feedModel.id, -1)) >= 0) {
            feedBar.comment.count = commentCount;
        }
    }

    public View getRootView() {
        return null;
    }

    public void onViewResume() {
        FeedHotTemplateOutComment feedHotTemplateOutComment = this.feedHotOutComment;
        if (feedHotTemplateOutComment != null) {
            feedHotTemplateOutComment.onViewResume();
        }
        FeedTemplateImpl feedTemplateImpl = this.mBaseTemplateImpl;
        if (feedTemplateImpl != null && feedTemplateImpl.mFeedLabelView != null && this.mBaseTemplateImpl.mFeedLabelView.getFeedBarView() != null) {
            this.mBaseTemplateImpl.mFeedLabelView.getFeedBarView().onViewResume();
        }
    }

    public void updateLabelBarVisibility(FeedBaseModel model) {
        if (model != null && model.data != null && model.runtimeStatus != null && FeedChannelConstants.isSearchHotChannel(model.runtimeStatus.channelId) && (model.data instanceof FeedItemDataStar)) {
            FeedItemDataStar itemDataStar = (FeedItemDataStar) model.data;
            FeedTemplateImpl feedTemplateImpl = this.mBaseTemplateImpl;
            if (feedTemplateImpl != null && feedTemplateImpl.mFeedLabelView != null) {
                if (itemDataStar.isTop) {
                    this.mBaseTemplateImpl.mFeedLabelView.setVisibility(0);
                    this.mBaseTemplateImpl.mFeedLabelView.getUnlikeButton().setVisibility(8);
                    adjustFeedBarHeight(R.dimen.feed_hot_footer_height_with_divider);
                    FeedBarView feedBarView = this.mFeedBarView;
                    if (feedBarView != null) {
                        feedBarView.setShowTopDivider(true);
                        return;
                    }
                    return;
                }
                this.mBaseTemplateImpl.mFeedLabelView.setVisibility(8);
                adjustFeedBarHeight(R.dimen.feed_hot_footer_height_without_divider);
                FeedBarView feedBarView2 = this.mFeedBarView;
                if (feedBarView2 != null) {
                    feedBarView2.setShowTopDivider(false);
                }
            }
        }
    }

    private void adjustFeedBarHeight(int heightResId) {
        if (this.mFeedBarView != null) {
            int height = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(heightResId);
            ViewGroup.LayoutParams layoutParams = this.mFeedBarView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, height);
            } else {
                layoutParams.height = height;
            }
            this.mFeedBarView.setFeedBarHeight(height);
            this.mFeedBarView.setLayoutParams(layoutParams);
        }
    }
}
