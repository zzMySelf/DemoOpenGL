package com.baidu.searchbox.hotdiscussion.textseletecd;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ITextSelected.kt */
final class ITextSelectedKt$bindSelectedTextClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $holderView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ITextSelectedKt$bindSelectedTextClick$1(View view2) {
        super(0);
        this.$holderView = view2;
    }

    public final void invoke() {
        View view2 = this.$holderView;
        if (view2 != null) {
            view2.performClick();
        }
    }
}
