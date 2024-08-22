package com.baidu.searchbox.mall.comp.box;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.mall.comp.sug.event.InputSugEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchBoxComp$$ExternalSyntheticLambda8 implements Action {
    public final /* synthetic */ SearchBoxComp f$0;

    public /* synthetic */ SearchBoxComp$$ExternalSyntheticLambda8(SearchBoxComp searchBoxComp) {
        this.f$0 = searchBoxComp;
    }

    public final void call(Object obj) {
        SearchBoxComp.m288registerInputSugEvent$lambda6(this.f$0, (InputSugEvent) obj);
    }
}
