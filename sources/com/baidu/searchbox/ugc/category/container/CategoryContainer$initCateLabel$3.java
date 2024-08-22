package com.baidu.searchbox.ugc.category.container;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "groupPos", "", "itemPos", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CategoryContainer.kt */
final class CategoryContainer$initCateLabel$3 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ CategoryContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CategoryContainer$initCateLabel$3(CategoryContainer categoryContainer) {
        super(2);
        this.this$0 = categoryContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Number) p1).intValue(), ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int groupPos, int itemPos) {
        Function2<Integer, Integer, Unit> onLabelListener = this.this$0.getOnLabelListener();
        if (onLabelListener != null) {
            onLabelListener.invoke(Integer.valueOf(groupPos), Integer.valueOf(itemPos));
        }
    }
}
