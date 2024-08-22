package com.baidu.browser.explore.container;

import com.baidu.browser.components.landingpagetts.model.LandingPageTTSResultManager;
import com.baidu.searchbox.pinchsummary.interfaces.OnPinchSummaryDataSourceCallback;
import com.baidu.searchbox.pinchsummary.model.PinchSummaryDataSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchBoxContainer$$ExternalSyntheticLambda0 implements LandingPageTTSResultManager.TTSDataCallback {
    public final /* synthetic */ SearchBoxContainer f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ PinchSummaryDataSource f$2;
    public final /* synthetic */ OnPinchSummaryDataSourceCallback f$3;

    public /* synthetic */ SearchBoxContainer$$ExternalSyntheticLambda0(SearchBoxContainer searchBoxContainer, String str, PinchSummaryDataSource pinchSummaryDataSource, OnPinchSummaryDataSourceCallback onPinchSummaryDataSourceCallback) {
        this.f$0 = searchBoxContainer;
        this.f$1 = str;
        this.f$2 = pinchSummaryDataSource;
        this.f$3 = onPinchSummaryDataSourceCallback;
    }

    public final void responseTtsData(String str, int i2) {
        this.f$0.m12795lambda$getPinchSummaryData$4$combaidubrowserexplorecontainerSearchBoxContainer(this.f$1, this.f$2, this.f$3, str, i2);
    }
}
