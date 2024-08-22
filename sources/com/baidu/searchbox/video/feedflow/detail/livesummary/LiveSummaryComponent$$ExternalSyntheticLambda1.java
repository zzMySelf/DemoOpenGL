package com.baidu.searchbox.video.feedflow.detail.livesummary;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.video.feedflow.detail.author.AuthorState;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LiveSummaryComponent$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ AuthorState f$0;
    public final /* synthetic */ LiveSummaryComponent f$1;

    public /* synthetic */ LiveSummaryComponent$$ExternalSyntheticLambda1(AuthorState authorState, LiveSummaryComponent liveSummaryComponent) {
        this.f$0 = authorState;
        this.f$1 = liveSummaryComponent;
    }

    public final void onChanged(Object obj) {
        LiveSummaryComponent.m11694onAttachToManager$lambda6$lambda4(this.f$0, this.f$1, (Boolean) obj);
    }
}
