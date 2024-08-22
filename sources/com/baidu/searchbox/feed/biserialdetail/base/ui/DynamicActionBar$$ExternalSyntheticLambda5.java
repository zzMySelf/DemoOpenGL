package com.baidu.searchbox.feed.biserialdetail.base.ui;

import android.view.View;
import com.baidu.searchbox.feed.biserialdetail.ubc.DynamicDetailStatisticsHelper;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.template.FeedStarFollowButtonView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DynamicActionBar$$ExternalSyntheticLambda5 implements FeedStarFollowButtonView.OnViewClickListener {
    public final /* synthetic */ DynamicActionBar f$0;
    public final /* synthetic */ DynamicDetailStatisticsHelper f$1;
    public final /* synthetic */ FeedItemData.AdditionalInfo f$2;

    public /* synthetic */ DynamicActionBar$$ExternalSyntheticLambda5(DynamicActionBar dynamicActionBar, DynamicDetailStatisticsHelper dynamicDetailStatisticsHelper, FeedItemData.AdditionalInfo additionalInfo) {
        this.f$0 = dynamicActionBar;
        this.f$1 = dynamicDetailStatisticsHelper;
        this.f$2 = additionalInfo;
    }

    public final void onViewClick(View.OnClickListener onClickListener, boolean z) {
        DynamicActionBar.m18500setButtonClickEvent$lambda16(this.f$0, this.f$1, this.f$2, onClickListener, z);
    }
}
