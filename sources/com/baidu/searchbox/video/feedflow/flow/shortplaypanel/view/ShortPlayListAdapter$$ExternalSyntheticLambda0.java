package com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view;

import android.view.View;
import com.baidu.searchbox.video.feedflow.loading.VideoFlowLoadingView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShortPlayListAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ ShortPlayListAdapter f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ VideoFlowLoadingView.State f$2;

    public /* synthetic */ ShortPlayListAdapter$$ExternalSyntheticLambda0(ShortPlayListAdapter shortPlayListAdapter, int i2, VideoFlowLoadingView.State state) {
        this.f$0 = shortPlayListAdapter;
        this.f$1 = i2;
        this.f$2 = state;
    }

    public final void onClick(View view2) {
        ShortPlayListAdapter.m6640onBindLoadingMoreViewHolder$lambda9(this.f$0, this.f$1, this.f$2, view2);
    }
}
