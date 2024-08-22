package com.baidu.searchbox.feed.payment.payui.payPanel.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.model.DiscountDialogInfo;
import com.baidu.searchbox.feed.payment.payui.guide.ShortVideoPreferentialView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0016J\u0012\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0012H\u0016J\u000e\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R0\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/payPanel/dialog/ShortVideoDiscountDialog;", "Landroid/app/Dialog;", "ctx", "Landroid/content/Context;", "discountInfo", "Lcom/baidu/searchbox/feed/payment/model/DiscountDialogInfo;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/payment/model/DiscountDialogInfo;)V", "dialogCloseable", "Ljava/lang/Runnable;", "dialogOpenable", "disCountView", "Lcom/baidu/searchbox/feed/payment/payui/guide/ShortVideoPreferentialView;", "getDisCountView", "()Lcom/baidu/searchbox/feed/payment/payui/guide/ShortVideoPreferentialView;", "disCountView$delegate", "Lkotlin/Lazy;", "onDiscountDialogShowListener", "Lkotlin/Function0;", "", "getOnDiscountDialogShowListener", "()Lkotlin/jvm/functions/Function0;", "setOnDiscountDialogShowListener", "(Lkotlin/jvm/functions/Function0;)V", "onItemAnimListener", "Lkotlin/Function2;", "", "", "getOnItemAnimListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemAnimListener", "(Lkotlin/jvm/functions/Function2;)V", "startTime", "closeDelayed", "dismiss", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setWindowAttr", "show", "showDelayed", "duration", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortVideoDiscountDialog.kt */
public final class ShortVideoDiscountDialog extends Dialog {
    /* access modifiers changed from: private */
    public final Context ctx;
    private final Runnable dialogCloseable = new ShortVideoDiscountDialog$$ExternalSyntheticLambda0(this);
    private final Runnable dialogOpenable = new ShortVideoDiscountDialog$$ExternalSyntheticLambda1(this);
    private final Lazy disCountView$delegate = LazyKt.lazy(new ShortVideoDiscountDialog$disCountView$2(this));
    private final DiscountDialogInfo discountInfo;
    private Function0<Unit> onDiscountDialogShowListener;
    private Function2<? super Long, ? super String, Unit> onItemAnimListener;
    /* access modifiers changed from: private */
    public final long startTime = (System.currentTimeMillis() / ((long) 1000));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortVideoDiscountDialog(Context ctx2, DiscountDialogInfo discountInfo2) {
        super(ctx2);
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        Intrinsics.checkNotNullParameter(discountInfo2, "discountInfo");
        this.ctx = ctx2;
        this.discountInfo = discountInfo2;
    }

    private final ShortVideoPreferentialView getDisCountView() {
        return (ShortVideoPreferentialView) this.disCountView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: dialogCloseable$lambda-0  reason: not valid java name */
    public static final void m19282dialogCloseable$lambda0(ShortVideoDiscountDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: dialogOpenable$lambda-1  reason: not valid java name */
    public static final void m19283dialogOpenable$lambda1(ShortVideoDiscountDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.show();
        this$0.closeDelayed();
    }

    public final Function2<Long, String, Unit> getOnItemAnimListener() {
        return this.onItemAnimListener;
    }

    public final void setOnItemAnimListener(Function2<? super Long, ? super String, Unit> function2) {
        this.onItemAnimListener = function2;
    }

    public final Function0<Unit> getOnDiscountDialogShowListener() {
        return this.onDiscountDialogShowListener;
    }

    public final void setOnDiscountDialogShowListener(Function0<Unit> function0) {
        this.onDiscountDialogShowListener = function0;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setWindowAttr();
        setContentView(getDisCountView());
        getDisCountView().onBindView(this.discountInfo);
    }

    private final void setWindowAttr() {
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(this.ctx, R.color.feed_transparent));
        }
        requestWindowFeature(1);
    }

    public final void showDelayed(long duration) {
        UiThreadUtils.getMainHandler().postDelayed(this.dialogOpenable, duration <= 0 ? 500 : duration);
    }

    private final void closeDelayed() {
        if (this.discountInfo.closingTime > 0) {
            UiThreadUtils.getMainHandler().postDelayed(this.dialogCloseable, ((long) this.discountInfo.closingTime) * 1000);
        }
    }

    public void show() {
        Context context = this.ctx;
        if ((context instanceof Activity) && !ActivityUtils.isDestroyed((Activity) context)) {
            if (isShowing()) {
                dismiss();
                return;
            }
            super.show();
            Function0<Unit> function0 = this.onDiscountDialogShowListener;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        UiThreadUtils.getMainHandler().removeCallbacks(this.dialogOpenable);
        UiThreadUtils.getMainHandler().removeCallbacks(this.dialogCloseable);
        getDisCountView().onDestory();
        Function2<? super Long, ? super String, Unit> function2 = this.onItemAnimListener;
        if (function2 != null) {
            function2.invoke(Long.valueOf(this.startTime), null);
        }
        this.onItemAnimListener = null;
        this.onDiscountDialogShowListener = null;
    }
}
