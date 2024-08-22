package com.baidu.searchbox.feed.template.view.starimage3;

import android.view.View;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataStar;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedHotNineGridView$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ FeedHotNineGridView f$0;
    public final /* synthetic */ FeedItemDataStar f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ FeedBaseModel f$4;
    public final /* synthetic */ FeedHotStarImage3BaseImg f$5;

    public /* synthetic */ FeedHotNineGridView$$ExternalSyntheticLambda0(FeedHotNineGridView feedHotNineGridView, FeedItemDataStar feedItemDataStar, boolean z, int i2, FeedBaseModel feedBaseModel, FeedHotStarImage3BaseImg feedHotStarImage3BaseImg) {
        this.f$0 = feedHotNineGridView;
        this.f$1 = feedItemDataStar;
        this.f$2 = z;
        this.f$3 = i2;
        this.f$4 = feedBaseModel;
        this.f$5 = feedHotStarImage3BaseImg;
    }

    public final void onClick(View view2) {
        FeedHotNineGridView.m19605setImgBrowserClickListener$lambda4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view2);
    }
}
