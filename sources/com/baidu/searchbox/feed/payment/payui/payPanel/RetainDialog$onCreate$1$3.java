package com.baidu.searchbox.feed.payment.payui.payPanel;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.feed.payment.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isContinueBuy", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RetainDialog.kt */
final class RetainDialog$onCreate$1$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RetainView $this_run;
    final /* synthetic */ RetainDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RetainDialog$onCreate$1$3(RetainDialog retainDialog, RetainView retainView) {
        super(1);
        this.this$0 = retainDialog;
        this.$this_run = retainView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isContinueBuy) {
        if (isContinueBuy) {
            this.this$0.dismissWithReason(2);
            return;
        }
        UniversalToast.makeText(this.$this_run.getContext(), R.string.feed_pay_retain_discount_end_tips).show();
        this.this$0.dismissWithReason(3);
    }
}
