package com.baidu.searchbox.follow.followaddrlist.fragment;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.follow.util.Event;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FollowCategoryFragment$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ FollowCategoryFragment f$0;

    public /* synthetic */ FollowCategoryFragment$$ExternalSyntheticLambda2(FollowCategoryFragment followCategoryFragment) {
        this.f$0 = followCategoryFragment;
    }

    public final void onChanged(Object obj) {
        FollowCategoryFragment.m18880registerViewModel$lambda6(this.f$0, (Event) obj);
    }
}
