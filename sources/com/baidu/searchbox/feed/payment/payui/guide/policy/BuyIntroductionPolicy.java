package com.baidu.searchbox.feed.payment.payui.guide.policy;

import android.content.Context;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.feed.flow.TimeServer;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData;
import com.baidu.searchbox.feed.payment.payui.guide.policy.IIntroductionPolicy;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.widget.guide.WidgetGuideDataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/guide/policy/BuyIntroductionPolicy;", "Lcom/baidu/searchbox/feed/payment/payui/guide/policy/IIntroductionPolicy;", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getDialogData", "Lcom/baidu/searchbox/feed/payment/payui/guide/model/PayGuideData$DialogGuideData;", "guideData", "Lcom/baidu/searchbox/feed/payment/payui/guide/model/PayGuideData;", "columnType", "", "getTabBubble", "context", "Landroid/content/Context;", "needShow", "", "recordDialogShow", "", "showToast", "Companion", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BuyIntroductionPolicy.kt */
public class BuyIntroductionPolicy implements IIntroductionPolicy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int hasDialogShown;
    private final String type;

    public BuyIntroductionPolicy(String type2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
    }

    public String buildToastText(Context context, int prefixHintId, String toastMsg) {
        return IIntroductionPolicy.DefaultImpls.buildToastText(this, context, prefixHintId, toastMsg);
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if ((r1 == null || r1.isEmpty()) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r2 == false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData.DialogGuideData getDialogData(com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "guideData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData$DialogGuideData r0 = r5.dialogGuideData
            java.lang.String r1 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.baidu.searchbox.feed.payment.payui.guide.policy.BuyIntroductionPolicyKt.customizeData(r0, r6)
            java.lang.String r1 = r0.title
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006a
            java.lang.String r1 = r0.btnTitle
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006a
            java.lang.String r1 = r0.subTitle
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0041
            java.util.List<java.lang.String> r1 = r0.subTitles
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x003e
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r1 = r2
            goto L_0x003f
        L_0x003e:
            r1 = r3
        L_0x003f:
            if (r1 != 0) goto L_0x006a
        L_0x0041:
            java.lang.String r1 = r0.imgUrl
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x005a
            java.util.List<java.lang.String> r1 = r0.imgUrls
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0057
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0058
        L_0x0057:
            r2 = r3
        L_0x0058:
            if (r2 != 0) goto L_0x006a
        L_0x005a:
            int r1 = r0.buyDialogCount
            if (r1 >= r3) goto L_0x0063
            int r1 = com.baidu.searchbox.feed.payment.payui.guide.policy.BuyIntroductionPolicyKt.getBuyDialogMaxCount()
            goto L_0x0065
        L_0x0063:
            int r1 = r0.buyDialogCount
        L_0x0065:
            com.baidu.searchbox.feed.payment.payui.guide.policy.BuyIntroductionPolicyKt.setBuyDialogMaxCount(r1)
            r1 = r0
            goto L_0x007a
        L_0x006a:
            java.lang.String r1 = "FeedPay"
            com.baidu.searchbox.feed.log.IFeedLogger r1 = com.baidu.searchbox.feed.log.OnLineLog.get(r1)
            java.lang.String r2 = "购买物料数据检查不通过"
            r1.e(r2)
            r1 = 0
            r2 = r1
            com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData$DialogGuideData r2 = (com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData.DialogGuideData) r2
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.payui.guide.policy.BuyIntroductionPolicy.getDialogData(com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData, int):com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData$DialogGuideData");
    }

    public boolean needShow() {
        if (hasDialogShown < 3) {
            return BuyIntroductionPolicyKt.dailyNeedShow();
        }
        OnLineLog.get("FeedPay").w("购买弹框时间:" + FeedUtil.stampToDate(Long.valueOf(TimeServer.Proxy.getDefault().currentTimeMillis())) + " 弹框次数:" + hasDialogShown);
        return false;
    }

    public void recordDialogShow() {
        hasDialogShown++;
        BuyIntroductionPolicyKt.commonRecordShow();
    }

    public String getTabBubble(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getString(R.string.pay_bubble_text);
    }

    public void showToast(Context context, PayGuideData guideData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guideData, WidgetGuideDataManager.KEY_GUIDE_DATA);
        UniversalToast.makeText(context, (CharSequence) buildToastText(context, R.string.pay_success_tip_no_dialog, guideData.toastMsg)).showToast(true);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/guide/policy/BuyIntroductionPolicy$Companion;", "", "()V", "hasDialogShown", "", "getHasDialogShown", "()I", "setHasDialogShown", "(I)V", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BuyIntroductionPolicy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getHasDialogShown() {
            return BuyIntroductionPolicy.hasDialogShown;
        }

        public final void setHasDialogShown(int i2) {
            BuyIntroductionPolicy.hasDialogShown = i2;
        }
    }
}
