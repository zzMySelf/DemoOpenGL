package com.baidu.searchbox.paywall.novel;

import android.app.Activity;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.kmm.paywall.recommend.PaywallPopModel;
import com.baidu.searchbox.paywall.PaywallTabActivity;
import com.baidu.searchbox.paywall.manager.RecommendDialogManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "popModel", "Lcom/baidu/searchbox/kmm/paywall/recommend/PaywallPopModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallNovelPresenter.kt */
final class PaywallNovelPresenter$start$1$3 extends Lambda implements Function1<PaywallPopModel, Unit> {
    public static final PaywallNovelPresenter$start$1$3 INSTANCE = new PaywallNovelPresenter$start$1$3();

    PaywallNovelPresenter$start$1$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((PaywallPopModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(PaywallPopModel popModel) {
        Intrinsics.checkNotNullParameter(popModel, "popModel");
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        WeakReference weakActivity = new WeakReference(activity);
        if (activity instanceof PaywallTabActivity) {
            UiThreadUtils.runOnUiThread(new PaywallNovelPresenter$start$1$3$$ExternalSyntheticLambda0(weakActivity, popModel));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m1942invoke$lambda0(WeakReference $weakActivity, PaywallPopModel $popModel) {
        Intrinsics.checkNotNullParameter($weakActivity, "$weakActivity");
        Intrinsics.checkNotNullParameter($popModel, "$popModel");
        RecommendDialogManager.INSTANCE.showRecommendDialog($weakActivity, $popModel);
    }
}
