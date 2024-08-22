package com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter;

import android.widget.CompoundButton;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MoreBottomAdapter$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ MoreMenuBottomItemModel f$0;
    public final /* synthetic */ MoreBottomAdapter f$1;

    public /* synthetic */ MoreBottomAdapter$$ExternalSyntheticLambda1(MoreMenuBottomItemModel moreMenuBottomItemModel, MoreBottomAdapter moreBottomAdapter) {
        this.f$0 = moreMenuBottomItemModel;
        this.f$1 = moreBottomAdapter;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MoreBottomAdapter.m11731onBindViewHolder$lambda2(this.f$0, this.f$1, compoundButton, z);
    }
}
