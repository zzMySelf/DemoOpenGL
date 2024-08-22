package com.baidu.searchbox.video.feedflow.flow.topexpand.expandable;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopExpandableComponent.kt */
final class TopExpandableComponent$globalLayoutListener$2 extends Lambda implements Function0<ViewTreeObserver.OnGlobalLayoutListener> {
    final /* synthetic */ TopExpandableComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopExpandableComponent$globalLayoutListener$2(TopExpandableComponent topExpandableComponent) {
        super(0);
        this.this$0 = topExpandableComponent;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener invoke() {
        return this.this$0.createGlobalLayoutListener();
    }
}
