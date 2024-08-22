package com.baidu.searchbox.dynamicpublisher.quanzi;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuanziComponent.kt */
final class QuanziComponent$quanziTv$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ QuanziComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuanziComponent$quanziTv$2(QuanziComponent quanziComponent) {
        super(0);
        this.this$0 = quanziComponent;
    }

    public final TextView invoke() {
        TextView textView = new TextView(this.this$0.getContext());
        TextView $this$invoke_u24lambda_u2d1 = textView;
        $this$invoke_u24lambda_u2d1.setOnClickListener(new QuanziComponent$quanziTv$2$$ExternalSyntheticLambda0(this.this$0));
        $this$invoke_u24lambda_u2d1.setVisibility(8);
        return textView;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m18181invoke$lambda1$lambda0(QuanziComponent this$02, View it) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.onQuanziTvClick();
    }
}
