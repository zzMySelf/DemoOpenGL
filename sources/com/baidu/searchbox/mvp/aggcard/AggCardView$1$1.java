package com.baidu.searchbox.mvp.aggcard;

import com.baidu.searchbox.mvp.entity.CardList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "card", "Lcom/baidu/searchbox/mvp/entity/CardList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AggCardView.kt */
final class AggCardView$1$1 extends Lambda implements Function2<Integer, CardList, Unit> {
    final /* synthetic */ AggCardView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AggCardView$1$1(AggCardView aggCardView) {
        super(2);
        this.this$0 = aggCardView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Number) p1).intValue(), (CardList) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(int index, CardList card) {
        Function2<Integer, CardList, Unit> itemClkListener = this.this$0.getItemClkListener();
        if (itemClkListener != null) {
            itemClkListener.invoke(Integer.valueOf(index), card);
        }
    }
}
