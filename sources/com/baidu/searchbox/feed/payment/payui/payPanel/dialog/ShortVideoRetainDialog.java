package com.baidu.searchbox.feed.payment.payui.payPanel.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.model.RetainDialogData;
import com.baidu.searchbox.feed.payment.payui.guide.ShortVideoRetainView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012*\b\u0002\u0010\t\u001a$\u0012\u0018\u0012\u00160\u000b¢\u0006\u0002\b\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0015\u0010\u0018\u001a\u00020\b2\u000b\u0010\u000f\u001a\u00070\u000b¢\u0006\u0002\b\fH\u0002J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R0\u0010\t\u001a$\u0012\u0018\u0012\u00160\u000b¢\u0006\u0002\b\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/payPanel/dialog/ShortVideoRetainDialog;", "Landroid/app/Dialog;", "ctx", "Landroid/content/Context;", "dialogData", "Lcom/baidu/searchbox/feed/payment/model/RetainDialogData;", "onShowListener", "Lkotlin/Function0;", "", "onDismissListener", "Lkotlin/Function1;", "", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/DismissReason;", "Lkotlin/ParameterName;", "name", "reason", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/payment/model/RetainDialogData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "retainView", "Lcom/baidu/searchbox/feed/payment/payui/guide/ShortVideoRetainView;", "getRetainView", "()Lcom/baidu/searchbox/feed/payment/payui/guide/ShortVideoRetainView;", "retainView$delegate", "Lkotlin/Lazy;", "dismiss", "dismissWithReason", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setWindowAttr", "show", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortVideoRetainDialog.kt */
public final class ShortVideoRetainDialog extends Dialog {
    /* access modifiers changed from: private */
    public final Context ctx;
    private final RetainDialogData dialogData;
    private final Function1<Integer, Unit> onDismissListener;
    private final Function0<Unit> onShowListener;
    private final Lazy retainView$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShortVideoRetainDialog(Context context, RetainDialogData retainDialogData, Function0 function0, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, retainDialogData, (i2 & 4) != 0 ? null : function0, (i2 & 8) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortVideoRetainDialog(Context ctx2, RetainDialogData dialogData2, Function0<Unit> onShowListener2, Function1<? super Integer, Unit> onDismissListener2) {
        super(ctx2);
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        Intrinsics.checkNotNullParameter(dialogData2, "dialogData");
        this.ctx = ctx2;
        this.dialogData = dialogData2;
        this.onShowListener = onShowListener2;
        this.onDismissListener = onDismissListener2;
        this.retainView$delegate = LazyKt.lazy(new ShortVideoRetainDialog$retainView$2(this));
    }

    private final ShortVideoRetainView getRetainView() {
        return (ShortVideoRetainView) this.retainView$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setWindowAttr();
        ShortVideoRetainView $this$onCreate_u24lambda_u2d0 = getRetainView();
        $this$onCreate_u24lambda_u2d0.updateUI(this.dialogData);
        $this$onCreate_u24lambda_u2d0.setOnClickCancelListener(new ShortVideoRetainDialog$onCreate$1$1(this));
        $this$onCreate_u24lambda_u2d0.setOnClickCloseListener(new ShortVideoRetainDialog$onCreate$1$2(this));
        $this$onCreate_u24lambda_u2d0.setOnClickConfirmListener(new ShortVideoRetainDialog$onCreate$1$3(this));
        setContentView(getRetainView());
    }

    private final void setWindowAttr() {
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(this.ctx, R.color.feed_transparent));
        }
        requestWindowFeature(1);
    }

    public void show() {
        Context context = this.ctx;
        if ((context instanceof Activity) && !ActivityUtils.isDestroyed((Activity) context)) {
            if (isShowing()) {
                dismiss();
                return;
            }
            super.show();
            Function0<Unit> function0 = this.onShowListener;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void dismissWithReason(int reason) {
        dismiss();
        Function1<Integer, Unit> function1 = this.onDismissListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(reason));
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }
}
