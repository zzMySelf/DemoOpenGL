package com.baidu.searchbox.video.feedflow.detail.relatedsearch.panellist;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedSearchListView.kt */
final class RelatedSearchListView$recyclerView$2 extends Lambda implements Function0<RecyclerView> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RelatedSearchListView$recyclerView$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final RecyclerView invoke() {
        RecyclerView recyclerView = new RecyclerView(this.$context);
        RecyclerView $this$invoke_u24lambda_u2d0 = recyclerView;
        $this$invoke_u24lambda_u2d0.setFocusable(false);
        $this$invoke_u24lambda_u2d0.setFocusableInTouchMode(false);
        return recyclerView;
    }
}
