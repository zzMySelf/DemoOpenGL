package com.baidu.searchbox.video.feedflow.flow.collection;

import androidx.lifecycle.Observer;
import kotlin.Unit;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectionPanelPlugin$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ CollectionPanelPlugin f$0;
    public final /* synthetic */ CollectionPanelState f$1;

    public /* synthetic */ CollectionPanelPlugin$$ExternalSyntheticLambda3(CollectionPanelPlugin collectionPanelPlugin, CollectionPanelState collectionPanelState) {
        this.f$0 = collectionPanelPlugin;
        this.f$1 = collectionPanelState;
    }

    public final void onChanged(Object obj) {
        CollectionPanelPlugin.m6144onAttachToManager$lambda23$lambda6(this.f$0, this.f$1, (Unit) obj);
    }
}
