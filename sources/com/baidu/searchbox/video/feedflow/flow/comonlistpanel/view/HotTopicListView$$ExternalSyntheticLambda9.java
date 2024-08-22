package com.baidu.searchbox.video.feedflow.flow.comonlistpanel.view;

import androidx.lifecycle.Observer;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HotTopicListView$$ExternalSyntheticLambda9 implements Observer {
    public final /* synthetic */ HotTopicListView f$0;

    public /* synthetic */ HotTopicListView$$ExternalSyntheticLambda9(HotTopicListView hotTopicListView) {
        this.f$0 = hotTopicListView;
    }

    public final void onChanged(Object obj) {
        HotTopicListView.m6307insertPositionObserver$lambda3(this.f$0, (Pair) obj);
    }
}
