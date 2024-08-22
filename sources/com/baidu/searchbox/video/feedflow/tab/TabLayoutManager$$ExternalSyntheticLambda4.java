package com.baidu.searchbox.video.feedflow.tab;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.detail.frame.Store;
import kotlin.Unit;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TabLayoutManager$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ TabLayoutManager f$0;
    public final /* synthetic */ TabLayoutState f$1;
    public final /* synthetic */ Store f$2;

    public /* synthetic */ TabLayoutManager$$ExternalSyntheticLambda4(TabLayoutManager tabLayoutManager, TabLayoutState tabLayoutState, Store store) {
        this.f$0 = tabLayoutManager;
        this.f$1 = tabLayoutState;
        this.f$2 = store;
    }

    public final void onChanged(Object obj) {
        TabLayoutManager.m6815initManager$lambda17$lambda11(this.f$0, this.f$1, this.f$2, (Unit) obj);
    }
}
