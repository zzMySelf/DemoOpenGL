package com.baidu.searchbox.feed.util;

import com.baidu.searchbox.feed.controller.FeedDataManager;
import com.baidu.searchbox.feed.flow.RefreshablePage;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.texas.context.Assistant;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedInsertUtils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ FeedDataManager f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ FeedFlowModel f$2;
    public final /* synthetic */ RefreshablePage f$3;
    public final /* synthetic */ Boolean f$4;
    public final /* synthetic */ Assistant f$5;

    public /* synthetic */ FeedInsertUtils$$ExternalSyntheticLambda0(FeedDataManager feedDataManager, String str, FeedFlowModel feedFlowModel, RefreshablePage refreshablePage, Boolean bool, Assistant assistant) {
        this.f$0 = feedDataManager;
        this.f$1 = str;
        this.f$2 = feedFlowModel;
        this.f$3 = refreshablePage;
        this.f$4 = bool;
        this.f$5 = assistant;
    }

    public final void run() {
        FeedInsertUtils.lambda$tryToInsertSearchWhenColdBoot$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
