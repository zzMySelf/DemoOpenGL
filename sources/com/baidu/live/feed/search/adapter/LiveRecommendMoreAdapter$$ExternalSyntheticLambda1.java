package com.baidu.live.feed.search.adapter;

import android.view.View;
import com.baidu.live.business.model.data.LiveRoomEntity;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LiveRecommendMoreAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ LiveRecommendMoreAdapter f$0;
    public final /* synthetic */ LiveRoomEntity f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Ref.IntRef f$3;

    public /* synthetic */ LiveRecommendMoreAdapter$$ExternalSyntheticLambda1(LiveRecommendMoreAdapter liveRecommendMoreAdapter, LiveRoomEntity liveRoomEntity, int i2, Ref.IntRef intRef) {
        this.f$0 = liveRecommendMoreAdapter;
        this.f$1 = liveRoomEntity;
        this.f$2 = i2;
        this.f$3 = intRef;
    }

    public final void onClick(View view2) {
        LiveRecommendMoreAdapter.m13910onBindViewHolder$lambda9(this.f$0, this.f$1, this.f$2, this.f$3, view2);
    }
}
