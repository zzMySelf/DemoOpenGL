package com.baidu.searchbox.video.component.base;

import com.baidu.searchbox.feed.detail.arch.ext.NestedViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedViewHolder;", "M", "S", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsItemComponent.kt */
final class AbsItemComponent$itemView$2 extends Lambda implements Function0<NestedViewHolder<M>> {
    final /* synthetic */ AbsItemComponent<M, S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbsItemComponent$itemView$2(AbsItemComponent<M, S> absItemComponent) {
        super(0);
        this.this$0 = absItemComponent;
    }

    public final NestedViewHolder<M> invoke() {
        return this.this$0.createViewInternal();
    }
}
