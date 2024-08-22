package com.baidu.searchbox.video.feedflow.flow.collection.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabCollectionPanelAdapter.kt */
final class TabCollectionPanelAdapter$pagerViewCreateListener$1 extends Lambda implements Function2<Integer, View, Unit> {
    final /* synthetic */ TabCollectionPanelAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabCollectionPanelAdapter$pagerViewCreateListener$1(TabCollectionPanelAdapter tabCollectionPanelAdapter) {
        super(2);
        this.this$0 = tabCollectionPanelAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Number) p1).intValue(), (View) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i2, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v instanceof CollectionCommonListView) {
            ((CollectionCommonListView) v).subscribeData(this.this$0.getStore(), this.this$0.getLifecycleOwner(), this.this$0.getManager(), this.this$0.isLandscapeHomeMiddleState(), this.this$0.isLandscapeRelatedRecommendState());
        }
    }
}
