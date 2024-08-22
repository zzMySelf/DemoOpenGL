package com.baidu.searchbox.video.component.base;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.detail.frame.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AbsItemComponent$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ AbsItemComponent f$0;

    public /* synthetic */ AbsItemComponent$$ExternalSyntheticLambda1(AbsItemComponent absItemComponent) {
        this.f$0 = absItemComponent;
    }

    public final void onChanged(Object obj) {
        AbsItemComponent.m5216toParentObserver$lambda0(this.f$0, (Action) obj);
    }
}
