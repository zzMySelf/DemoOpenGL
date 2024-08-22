package com.baidu.searchbox.dynamic.template.view.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.DynamicItemPostData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.template.statistic.FeedChannelConstants;
import java.util.Map;

public abstract class DynamicPostLayout extends GeneralPostLayout {
    private static final String SEARCH_REYI_PREFIX = "search";
    protected FeedBaseModel mBaseModel;

    public abstract View getPostContent(Context context);

    public DynamicPostLayout(Context context) {
        super(context);
    }

    public DynamicPostLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicPostLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPostPaddingLeft = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X001);
        this.mPostPaddingRight = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X001);
        this.mPostPaddingTop = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.generalcommunity.R.dimen.dp_0);
        this.mPostPaddingBottom = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.generalcommunity.R.dimen.dp_0);
        this.mPostView.setPadding(this.mPostPaddingLeft, this.mPostPaddingTop, this.mPostPaddingRight, this.mPostPaddingBottom);
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        super.update(feedModel, options);
        if (feedModel != null) {
            this.mBaseModel = feedModel;
            DynamicItemPostData itemPostData = (DynamicItemPostData) feedModel.data;
            if (itemPostData.isFakeToppingType || TextUtils.equals(feedModel.layout, "bigimage")) {
                this.mRecommendView.showDislike(8);
            } else {
                this.mRecommendView.showDislike(0);
            }
            if (TextUtils.isEmpty(feedModel.runtimeStatus.channelId) || !feedModel.runtimeStatus.channelId.startsWith("search")) {
                updateRecommendViewStyle(0, com.baidu.searchbox.dynamic.template.R.dimen.dynamic_footer_height_with_divider);
            } else {
                if (itemPostData.isTop.booleanValue()) {
                    updateRecommendViewStyle(0, com.baidu.searchbox.dynamic.template.R.dimen.dynamic_footer_height_with_divider);
                } else {
                    updateRecommendViewStyle(8, com.baidu.searchbox.dynamic.template.R.dimen.dynamic_footer_height_without_divider);
                }
                this.mRecommendView.showDislike(8);
            }
            if (itemPostData.isFirstCard) {
                this.mRecommendView.showDislike(8);
            }
            adjustOutCommentLayout();
        }
    }

    private void adjustOutCommentLayout() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(com.baidu.searchbox.dynamic.template.R.dimen.dynamic_out_comment_content_height));
        params.bottomMargin = getResources().getDimensionPixelOffset(com.baidu.searchbox.dynamic.template.R.dimen.dynamic_out_comment_content_padding);
        params.addRule(3, this.mContentSpace.getId());
        this.mOutCommentView.setLayoutParams(params);
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        super.onFeedNightModeChanged(isNightMode);
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null || !FeedChannelConstants.isDynamicImmersiveChannel(feedBaseModel.runtimeStatus.channelId)) {
            this.mPressLayout.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), com.baidu.searchbox.dynamic.template.R.drawable.dynamic_post_layout_bg, (Resources.Theme) null));
        } else {
            this.mPressLayout.setBackground((Drawable) null);
        }
    }
}
