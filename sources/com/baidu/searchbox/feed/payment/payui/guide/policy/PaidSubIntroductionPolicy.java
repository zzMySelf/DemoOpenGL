package com.baidu.searchbox.feed.payment.payui.guide.policy;

import android.content.Context;
import com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData;
import com.baidu.searchbox.feed.payment.payui.guide.policy.IIntroductionPolicy;
import com.baidu.searchbox.widget.guide.WidgetGuideDataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/guide/policy/PaidSubIntroductionPolicy;", "Lcom/baidu/searchbox/feed/payment/payui/guide/policy/IIntroductionPolicy;", "paidSubBizType", "", "(Ljava/lang/String;)V", "getDialogData", "Lcom/baidu/searchbox/feed/payment/payui/guide/model/PayGuideData$DialogGuideData;", "guideData", "Lcom/baidu/searchbox/feed/payment/payui/guide/model/PayGuideData;", "columnType", "", "getTabBubble", "context", "Landroid/content/Context;", "needShow", "", "recordDialogShow", "", "showToast", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaidSubIntroductionPolicy.kt */
public final class PaidSubIntroductionPolicy implements IIntroductionPolicy {
    private final String paidSubBizType;

    public PaidSubIntroductionPolicy(String paidSubBizType2) {
        Intrinsics.checkNotNullParameter(paidSubBizType2, "paidSubBizType");
        this.paidSubBizType = paidSubBizType2;
    }

    public String buildToastText(Context context, int prefixHintId, String toastMsg) {
        return IIntroductionPolicy.DefaultImpls.buildToastText(this, context, prefixHintId, toastMsg);
    }

    public PayGuideData.DialogGuideData getDialogData(PayGuideData guideData, int columnType) {
        Intrinsics.checkNotNullParameter(guideData, WidgetGuideDataManager.KEY_GUIDE_DATA);
        return guideData.paidSubPaySuccessData;
    }

    public boolean needShow() {
        return true;
    }

    public void recordDialogShow() {
    }

    public String getTabBubble(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "";
    }

    public void showToast(Context context, PayGuideData guideData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guideData, WidgetGuideDataManager.KEY_GUIDE_DATA);
    }
}
