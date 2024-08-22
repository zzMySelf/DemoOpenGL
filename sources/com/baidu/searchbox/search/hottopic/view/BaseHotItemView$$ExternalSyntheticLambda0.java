package com.baidu.searchbox.search.hottopic.view;

import android.view.View;
import com.baidu.searchbox.search.hottopic.model.HotItemBean;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseHotItemView$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ HotItemBean f$1;
    public final /* synthetic */ BaseHotItemView f$2;
    public final /* synthetic */ Function1 f$3;

    public /* synthetic */ BaseHotItemView$$ExternalSyntheticLambda0(View view2, HotItemBean hotItemBean, BaseHotItemView baseHotItemView, Function1 function1) {
        this.f$0 = view2;
        this.f$1 = hotItemBean;
        this.f$2 = baseHotItemView;
        this.f$3 = function1;
    }

    public final void onClick(View view2) {
        BaseHotItemView.m2752setData$lambda10$lambda9(this.f$0, this.f$1, this.f$2, this.f$3, view2);
    }
}
