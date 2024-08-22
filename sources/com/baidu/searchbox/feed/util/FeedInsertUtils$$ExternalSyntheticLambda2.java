package com.baidu.searchbox.feed.util;

import com.baidu.searchbox.feed.controller.FeedDataManager;
import com.baidu.searchbox.feed.flow.RefreshablePage;
import com.baidu.searchbox.feed.insert.FeedInsertData;
import com.baidu.searchbox.feed.model.FeedInsertPolicy;
import com.baidu.searchbox.feed.util.FeedInsertUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedInsertUtils$$ExternalSyntheticLambda2 implements FeedInsertUtils.InsertModelsCallback {
    public final /* synthetic */ RefreshablePage f$0;
    public final /* synthetic */ FeedDataManager f$1;
    public final /* synthetic */ FeedInsertPolicy f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ FeedInsertData f$4;

    public /* synthetic */ FeedInsertUtils$$ExternalSyntheticLambda2(RefreshablePage refreshablePage, FeedDataManager feedDataManager, FeedInsertPolicy feedInsertPolicy, String str, FeedInsertData feedInsertData) {
        this.f$0 = refreshablePage;
        this.f$1 = feedDataManager;
        this.f$2 = feedInsertPolicy;
        this.f$3 = str;
        this.f$4 = feedInsertData;
    }

    public final void onInserted(boolean z) {
        FeedInsertUtils.lambda$doInsertDataWithoutRefresh$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, z);
    }
}
