package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.util.FeedUtil;

public class FeedTitleTopView extends NewsFeedBaseView {
    private boolean mIsSupplementaryHide;

    public FeedTitleTopView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public View initInflate(LayoutInflater inflater) {
        return inflater.inflate(R.layout.feed_tpl_text_top, this);
    }

    /* access modifiers changed from: protected */
    public void initLayout(Context context) {
        setPadding(getResources().getDimensionPixelSize(R.dimen.F_M_W_X001), getResources().getDimensionPixelSize(R.dimen.F_M_H_X00200002), getResources().getDimensionPixelSize(R.dimen.F_M_W_X001), 0);
    }

    /* access modifiers changed from: protected */
    public void updateSubViewData(FeedBaseModel model) {
        if (model != null && (model.data instanceof FeedItemDataNews)) {
            this.mIsSupplementaryHide = TextUtils.equals("1", ((FeedItemDataNews) model.data).hideSupplementary);
        }
    }

    /* access modifiers changed from: protected */
    public void updateFeedOrderSense() {
        updateHorizontalPadding(this);
    }

    /* access modifiers changed from: protected */
    public void updateSubViewUi(FeedBaseModel model) {
        if (model != null) {
            hideFeedLabelView();
            adjustItemTopLayout(model);
            adjustSpaceBetweenLayout(model);
            adjustItemBottomLayout(model);
        }
    }

    private void hideFeedLabelView() {
        View feedLabelView = this.mFeedTemplateImplBase.mFeedLabelView;
        if (feedLabelView != null) {
            feedLabelView.setVisibility(this.mIsSupplementaryHide ? 8 : 0);
        }
    }

    private void adjustItemTopLayout(FeedBaseModel model) {
        int reduceSpace = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_1_5dp);
        int space = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_9dp);
        if (hitMarginStyle1(model)) {
            space = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_8dp);
        } else if (hitMarginStyle2(model)) {
            space = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_6dp);
        }
        if (FeedUtil.isTabletBasic() && model.runtimeStatus.viewPosition == 0) {
            space += getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_13dp);
        }
        setPadding(getEdgeBlankWidth(), model.runtimeStatus.reduceTop ? reduceSpace : space, getEdgeBlankWidth(), 0);
    }

    private void adjustSpaceBetweenLayout(FeedBaseModel model) {
        View titleView = this.mTitle;
        View feedLabelView = this.mFeedTemplateImplBase.mFeedLabelView;
        boolean needHideFeedLabelView = feedLabelView == null && this.mIsSupplementaryHide;
        if (titleView != null && !needHideFeedLabelView) {
            adjustLayoutParams(feedLabelView, 0, Integer.MIN_VALUE);
        }
    }

    private void adjustItemBottomLayout(FeedBaseModel model) {
        View titleView = this.mTitle;
        View feedLabelView = this.mFeedTemplateImplBase.mFeedLabelView;
        boolean needHideFeedLabelView = false;
        adjustLayoutParams(titleView, Integer.MIN_VALUE, 0);
        adjustLayoutParams(feedLabelView, Integer.MIN_VALUE, 0);
        if (feedLabelView == null || this.mIsSupplementaryHide) {
            needHideFeedLabelView = true;
        }
        View view2 = needHideFeedLabelView ? titleView : feedLabelView;
        int reduceSpace = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_1_5dp);
        int space = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_9dp);
        if (hitMarginStyle1(model)) {
            space = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_8dp);
        } else if (hitMarginStyle2(model)) {
            space = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_6dp);
        }
        adjustLayoutParams(view2, Integer.MIN_VALUE, model.runtimeStatus.reduceBottom ? reduceSpace : space);
    }

    private void adjustLayoutParams(View view2, int topMargin, int bottomMargin) {
        if (view2 != null) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            if (topMargin != Integer.MIN_VALUE) {
                lp.topMargin = Math.max(0, topMargin);
            }
            if (bottomMargin != Integer.MIN_VALUE) {
                lp.bottomMargin = Math.max(0, bottomMargin);
            }
            view2.setLayoutParams(lp);
        }
    }

    private boolean hitMarginStyle1(FeedBaseModel model) {
        return TextUtils.equals(FeedTplNameCenter.TITLE_ONLY_TOP, model.layout) && (model.data instanceof FeedItemDataNews) && TextUtils.equals(model.data.topMarginStyle, "1");
    }

    private boolean hitMarginStyle2(FeedBaseModel model) {
        return TextUtils.equals(FeedTplNameCenter.TITLE_ONLY_TOP, model.layout) && (model.data instanceof FeedItemDataNews) && TextUtils.equals(model.data.topMarginStyle, "2");
    }

    public void onClick(View v) {
        super.onClick(v);
    }
}
