package com.baidu.growthsystem.wealth.payment.component;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.growthsystem.wealth.payment.service.WealthPaymentStatus;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@StableApi
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH&J\u001a\u0010\u0016\u001a\u00020\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0012\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001dH&¨\u0006\u001e"}, d2 = {"Lcom/baidu/growthsystem/wealth/payment/component/IWealthPaymentComponent;", "", "attach", "", "rootView", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getContentView", "Landroid/view/View;", "getCurStatus", "Lcom/baidu/growthsystem/wealth/payment/service/WealthPaymentStatus;", "getRootViewViewPreMeasureHeight", "", "isAttached", "", "isVisible", "onOrientationChanged", "isRight", "release", "setClickAble", "clickAble", "setOnPaymentClickListener", "listener", "Lkotlin/Function0;", "setVisibility", "isVisibility", "triggerOncePaymentTask", "itemID", "", "wealth-task-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWealthPaymentComponent.kt */
public interface IWealthPaymentComponent {
    void attach(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams);

    View getContentView();

    WealthPaymentStatus getCurStatus();

    int getRootViewViewPreMeasureHeight();

    boolean isAttached();

    boolean isVisible();

    void onOrientationChanged(boolean z);

    void release();

    void setClickAble(boolean z);

    void setOnPaymentClickListener(Function0<Unit> function0);

    void setVisibility(boolean z);

    void triggerOncePaymentTask(String str);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWealthPaymentComponent.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void triggerOncePaymentTask$default(IWealthPaymentComponent iWealthPaymentComponent, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                iWealthPaymentComponent.triggerOncePaymentTask(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: triggerOncePaymentTask");
        }

        public static /* synthetic */ void setOnPaymentClickListener$default(IWealthPaymentComponent iWealthPaymentComponent, Function0 function0, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    function0 = null;
                }
                iWealthPaymentComponent.setOnPaymentClickListener(function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnPaymentClickListener");
        }
    }
}
