package com.baidu.searchbox.video.feedflow.flow.collection.autonextguide;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.flow.collection.backguide.CollectionBackGuideState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionBackGuideReducer.kt */
final class CollectionBackGuideReducer$reduce$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CommonState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionBackGuideReducer$reduce$2(CommonState commonState) {
        super(0);
        this.$state = commonState;
    }

    public final void invoke() {
        CollectionBackGuideState collectionBackGuideState = (CollectionBackGuideState) this.$state.select(CollectionBackGuideState.class);
        MutableLiveData<Unit> showView = collectionBackGuideState != null ? collectionBackGuideState.getShowView() : null;
        if (showView != null) {
            showView.setValue(Unit.INSTANCE);
        }
    }
}
