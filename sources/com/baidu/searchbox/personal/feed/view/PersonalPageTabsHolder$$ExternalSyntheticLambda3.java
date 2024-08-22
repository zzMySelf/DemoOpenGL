package com.baidu.searchbox.personal.feed.view;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersonalPageTabsHolder$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ PersonalPageTabsHolder f$1;

    public /* synthetic */ PersonalPageTabsHolder$$ExternalSyntheticLambda3(Function1 function1, PersonalPageTabsHolder personalPageTabsHolder) {
        this.f$0 = function1;
        this.f$1 = personalPageTabsHolder;
    }

    public final void onClick(View view2) {
        PersonalPageTabsHolder.m2070setAddedTabListener$lambda1(this.f$0, this.f$1, view2);
    }
}
