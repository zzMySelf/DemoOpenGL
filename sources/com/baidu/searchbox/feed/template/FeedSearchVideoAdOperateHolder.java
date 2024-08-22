package com.baidu.searchbox.feed.template;

import android.view.View;
import com.baidu.searchbox.feed.ad.util.FeedAdLogUtil;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;

public class FeedSearchVideoAdOperateHolder extends FeedTabVideoAdOperateViewHolder {
    public /* bridge */ /* synthetic */ void adaptOptimizeMode(int i2, int i3, int i4, int i5) {
        super.adaptOptimizeMode(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ void onClick(View view2) {
        super.onClick(view2);
    }

    FeedSearchVideoAdOperateHolder(int operateType, View view2) {
        super(operateType, view2);
        setColor();
    }

    /* access modifiers changed from: protected */
    public void handleClick(FeedBaseModel model, String area) {
        super.handleClick(model, area);
        uploadClickTcLog(model, "pys_check");
    }

    private void uploadClickTcLog(FeedBaseModel feedBaseModel, String action) {
        if (feedBaseModel != null && (feedBaseModel.data instanceof FeedItemDataTabVideo)) {
            FeedItemDataTabVideo itemData = (FeedItemDataTabVideo) feedBaseModel.data;
            if (itemData.mVideoInfo != null) {
                FeedAdLogUtil.uploadClickTcLog(itemData.mVideoInfo, action, 0, feedBaseModel.runtimeStatus.viewPosition, false);
            }
        }
    }

    public void setMoreImageBg(FeedBaseModel feedBaseModel) {
        super.setMoreImageBg(feedBaseModel);
        this.mMoreImage.setImageDrawable(getResources().getDrawable(R.drawable.feed_search_tab_video_more_icon_selector));
    }

    /* access modifiers changed from: protected */
    public void update(FeedBaseModel model, FeedAdBaseView view2) {
        super.update(model, view2);
        setColor();
        adaptOptimizeMode(R.dimen.dimens_19dp, R.dimen.dimens_11dp, R.dimen.dimens_10dp, R.dimen.dimens_15dp);
    }

    private void setColor() {
        boolean needAdaptDark = FeedAdUtil.needAdaptSearchVideoDarkBg();
        setElementColor(getResources().getColor(needAdaptDark ? com.baidu.searchbox.search.style.res.R.color.SVC4 : com.baidu.android.common.ui.style.R.color.GC1), getResources().getColor(needAdaptDark ? com.baidu.searchbox.search.style.res.R.color.SVC3 : com.baidu.android.common.ui.style.R.color.GC1));
    }

    /* access modifiers changed from: protected */
    public void setTagViewColor() {
        this.mTagView.setTextColor(getResources().getColor(R.color.SVC65));
    }
}
