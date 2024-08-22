package com.baidu.searchbox.feed.payment.statistics;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.feed.payment.core.model.PayInfo;
import com.baidu.searchbox.feed.payment.statistics.PaymentStatistics;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0007"}, d2 = {"statColumnBuyFail", "", "process", "", "payInfo", "Lcom/baidu/searchbox/feed/payment/core/model/PayInfo;", "statSubscriptionBuyFail", "lib-feed-payment_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BuyFailStats.kt */
public final class BuyFailStats {
    public static final void statColumnBuyFail(String process, PayInfo payInfo) {
        BoxAccount boxAccount;
        JSONObject extJO = new JSONObject();
        JSONObject $this$statColumnBuyFail_u24lambda_u2d1 = extJO;
        String str = null;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject $this$statColumnBuyFail_u24lambda_u2d1_u24lambda_u2d0 = $this$statColumnBuyFail_u24lambda_u2d1;
            if (Intrinsics.areEqual((Object) payInfo != null ? payInfo.splitPayType : null, (Object) PayInfo.SPLIT_PAY_TYPE_ITEM)) {
                $this$statColumnBuyFail_u24lambda_u2d1_u24lambda_u2d0.put("nid", payInfo.itemId);
            }
            BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            $this$statColumnBuyFail_u24lambda_u2d1_u24lambda_u2d0.put("uk", (accountManager == null || (boxAccount = accountManager.getBoxAccount()) == null) ? null : boxAccount.getUk());
            $this$statColumnBuyFail_u24lambda_u2d1_u24lambda_u2d0.put("amount", payInfo != null ? Integer.valueOf(payInfo.currentPrice) : null);
            Result.m8971constructorimpl($this$statColumnBuyFail_u24lambda_u2d1_u24lambda_u2d0.put("process", process));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        JSONObject ubcJO = new JSONObject();
        JSONObject $this$statColumnBuyFail_u24lambda_u2d3 = ubcJO;
        try {
            Result.Companion companion3 = Result.Companion;
            JSONObject $this$statColumnBuyFail_u24lambda_u2d3_u24lambda_u2d2 = $this$statColumnBuyFail_u24lambda_u2d3;
            String str2 = payInfo != null ? payInfo.from : null;
            if (str2 == null) {
                str2 = "feed";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "payInfo?.from ?: BuyFail.FROM_FAIL");
            }
            $this$statColumnBuyFail_u24lambda_u2d3_u24lambda_u2d2.put("from", str2);
            $this$statColumnBuyFail_u24lambda_u2d3_u24lambda_u2d2.put("page", PaymentStatistics.BuyFail.PAGE_FAIL_COLUMN);
            $this$statColumnBuyFail_u24lambda_u2d3_u24lambda_u2d2.put("type", "buy_fail");
            $this$statColumnBuyFail_u24lambda_u2d3_u24lambda_u2d2.put("value", payInfo != null ? payInfo.columnId : null);
            if (payInfo != null) {
                str = payInfo.source;
            }
            $this$statColumnBuyFail_u24lambda_u2d3_u24lambda_u2d2.put("source", str);
            Result.m8971constructorimpl($this$statColumnBuyFail_u24lambda_u2d3_u24lambda_u2d2.put("ext", extJO));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th3));
        }
        PaymentStatistics.Event.onEvent(PaymentStatistics.Id.PAY_PANEL_ID, ubcJO);
    }

    public static final void statSubscriptionBuyFail(String process, PayInfo payInfo) {
        BoxAccount boxAccount;
        JSONObject extJO = new JSONObject();
        JSONObject $this$statSubscriptionBuyFail_u24lambda_u2d5 = extJO;
        String str = null;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject $this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4 = $this$statSubscriptionBuyFail_u24lambda_u2d5;
            $this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4.put("pd", payInfo != null ? payInfo.pd : null);
            $this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4.put("pdRec", payInfo != null ? payInfo.pdRec : null);
            $this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4.put("amount", payInfo != null ? Integer.valueOf(payInfo.payPrice) : null);
            $this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4.put("nid", payInfo != null ? payInfo.psExtNid : null);
            $this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4.put("option", payInfo != null ? payInfo.psProductId : null);
            BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            $this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4.put("uk", (accountManager == null || (boxAccount = accountManager.getBoxAccount()) == null) ? null : boxAccount.getUk());
            Result.m8971constructorimpl($this$statSubscriptionBuyFail_u24lambda_u2d5_u24lambda_u2d4.put("process", process));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        JSONObject ubcJO = new JSONObject();
        JSONObject $this$statSubscriptionBuyFail_u24lambda_u2d7 = ubcJO;
        try {
            Result.Companion companion3 = Result.Companion;
            JSONObject $this$statSubscriptionBuyFail_u24lambda_u2d7_u24lambda_u2d6 = $this$statSubscriptionBuyFail_u24lambda_u2d7;
            $this$statSubscriptionBuyFail_u24lambda_u2d7_u24lambda_u2d6.put("from", "feed");
            $this$statSubscriptionBuyFail_u24lambda_u2d7_u24lambda_u2d6.put("page", PaymentStatistics.BuyFail.PAGE_FAIL_SUB);
            $this$statSubscriptionBuyFail_u24lambda_u2d7_u24lambda_u2d6.put("type", "buy_fail");
            $this$statSubscriptionBuyFail_u24lambda_u2d7_u24lambda_u2d6.put("value", payInfo != null ? payInfo.columnId : null);
            if (payInfo != null) {
                str = payInfo.source;
            }
            $this$statSubscriptionBuyFail_u24lambda_u2d7_u24lambda_u2d6.put("source", str);
            Result.m8971constructorimpl($this$statSubscriptionBuyFail_u24lambda_u2d7_u24lambda_u2d6.put("ext", extJO));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th3));
        }
        PaymentStatistics.Event.onEvent(PaymentStatistics.Id.SUB_PANEL_ID, ubcJO);
    }
}
