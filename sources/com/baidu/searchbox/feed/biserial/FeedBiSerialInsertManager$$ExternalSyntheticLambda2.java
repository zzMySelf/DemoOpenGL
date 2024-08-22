package com.baidu.searchbox.feed.biserial;

import com.baidu.searchbox.feed.flow.RefreshablePage;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.util.FeedInsertUtils;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedBiSerialInsertManager$$ExternalSyntheticLambda2 implements FeedInsertUtils.InsertModelsCallback {
    public final /* synthetic */ RefreshablePage f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ ArrayList f$2;
    public final /* synthetic */ IBiSerialDeleteTplListener f$3;
    public final /* synthetic */ FeedBaseModel f$4;

    public /* synthetic */ FeedBiSerialInsertManager$$ExternalSyntheticLambda2(RefreshablePage refreshablePage, int i2, ArrayList arrayList, IBiSerialDeleteTplListener iBiSerialDeleteTplListener, FeedBaseModel feedBaseModel) {
        this.f$0 = refreshablePage;
        this.f$1 = i2;
        this.f$2 = arrayList;
        this.f$3 = iBiSerialDeleteTplListener;
        this.f$4 = feedBaseModel;
    }

    public final void onInserted(boolean z) {
        FeedBiSerialInsertManager.m18429handleDeleteAndInsertTpl$lambda5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, z);
    }
}
