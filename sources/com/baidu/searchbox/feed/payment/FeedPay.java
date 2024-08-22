package com.baidu.searchbox.feed.payment;

import android.content.Context;
import com.baidu.searchbox.feed.payment.core.model.FeedPaymentConfig;
import com.baidu.searchbox.feed.payment.core.model.PayInfo;
import com.baidu.searchbox.feed.payment.model.SimpleResponse;
import com.baidu.searchbox.feed.payment.widget.RemoteDrawableFacade;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J8\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J<\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\r2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J8\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J:\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020$H&JP\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u001c2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0 2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u001c0*H&JP\u0010+\u001a\u00020&\"\u0004\b\u0000\u0010\u001c2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0 2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u001c0*H&J(\u0010-\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H&J\u0012\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000102H&JF\u00103\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u00104\u001a\u0004\u0018\u00010\u00072\b\u00105\u001a\u0004\u0018\u00010\u00072\b\u00106\u001a\u0004\u0018\u00010\u00072\b\u00107\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J.\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u00122\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010)\u001a\u0004\u0018\u00010>H&J2\u0010?\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u00122\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010>H&¨\u0006@"}, d2 = {"Lcom/baidu/searchbox/feed/payment/FeedPay;", "", "cancelPayment", "", "dropPayCallback", "extractUnitedSchemeDispatchers", "", "", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeBaseDispatcher;", "needShowIntroductionDialog", "", "type", "biz", "", "obtainRemoteDrawable", "Lcom/baidu/searchbox/feed/payment/widget/RemoteDrawableFacade;", "openIntroductionDialog", "context", "Landroid/content/Context;", "columnType", "callback", "Lcom/baidu/searchbox/feed/payment/DismissCallback;", "openPaidSubDialog", "psBizType", "ext", "openPaySuccessDialog", "parseFromOutline", "Lcom/baidu/searchbox/feed/payment/model/SimpleResponse;", "T", "json", "path", "modelClass", "Ljava/lang/Class;", "params", "popupRulesWith", "Lcom/baidu/searchbox/feed/payment/PopupRule;", "Lcom/baidu/searchbox/feed/payment/PopupParams;", "sendRequestAsync", "Lcom/baidu/searchbox/feed/payment/Cancelable;", "originUrl", "postParams", "cb", "Lcom/baidu/searchbox/feed/payment/PayResponseCallback;", "sendRequestAsyncOnUIBack", "cmd", "sendToDataChannel", "feedId", "status", "setRequestAspect", "aspect", "Lcom/baidu/searchbox/feed/payment/PayRequestAspect;", "showCouponReceiveDialog", "sourceId", "source", "from", "serverExt", "startPayment", "ctx", "payInfo", "Lcom/baidu/searchbox/feed/payment/core/model/PayInfo;", "payConfig", "Lcom/baidu/searchbox/feed/payment/core/model/FeedPaymentConfig;", "Lcom/baidu/searchbox/feed/payment/PayCallback;", "startSubscription", "lib-feedpay-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: feedpay.kt */
public interface FeedPay {
    void cancelPayment();

    void dropPayCallback();

    Map<String, UnitedSchemeBaseDispatcher> extractUnitedSchemeDispatchers();

    boolean needShowIntroductionDialog(String str, int i2);

    RemoteDrawableFacade obtainRemoteDrawable();

    void openIntroductionDialog(Context context, String str, int i2, int i3, DismissCallback dismissCallback);

    void openPaidSubDialog(Context context, int i2, Map<String, ? extends Object> map, DismissCallback dismissCallback);

    void openPaySuccessDialog(Context context, String str, int i2, int i3, DismissCallback dismissCallback);

    <T> SimpleResponse parseFromOutline(String str, String str2, Class<T> cls, Object obj);

    PopupRule popupRulesWith(PopupParams popupParams);

    <T> Cancelable sendRequestAsync(String str, String str2, Class<T> cls, Map<String, String> map, PayResponseCallback<T> payResponseCallback);

    <T> Cancelable sendRequestAsyncOnUIBack(String str, String str2, Class<T> cls, Map<String, String> map, PayResponseCallback<T> payResponseCallback);

    void sendToDataChannel(Context context, String str, String str2, String str3);

    void setRequestAspect(PayRequestAspect payRequestAspect);

    void showCouponReceiveDialog(Context context, String str, String str2, String str3, String str4, DismissCallback dismissCallback);

    void startPayment(Context context, PayInfo payInfo, FeedPaymentConfig feedPaymentConfig, PayCallback payCallback);

    void startSubscription(Context context, PayInfo payInfo, FeedPaymentConfig feedPaymentConfig, PayCallback payCallback);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: feedpay.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void openIntroductionDialog$default(FeedPay feedPay, Context context, String str, int i2, int i3, DismissCallback dismissCallback, int i4, Object obj) {
            int i5;
            DismissCallback dismissCallback2;
            if (obj == null) {
                if ((i4 & 8) != 0) {
                    i5 = -1;
                } else {
                    i5 = i3;
                }
                if ((i4 & 16) != 0) {
                    dismissCallback2 = null;
                } else {
                    dismissCallback2 = dismissCallback;
                }
                feedPay.openIntroductionDialog(context, str, i2, i5, dismissCallback2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openIntroductionDialog");
        }

        public static /* synthetic */ void openPaidSubDialog$default(FeedPay feedPay, Context context, int i2, Map map, DismissCallback dismissCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    map = null;
                }
                if ((i3 & 8) != 0) {
                    dismissCallback = null;
                }
                feedPay.openPaidSubDialog(context, i2, map, dismissCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPaidSubDialog");
        }

        public static /* synthetic */ void startSubscription$default(FeedPay feedPay, Context context, PayInfo payInfo, FeedPaymentConfig feedPaymentConfig, PayCallback payCallback, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    feedPaymentConfig = null;
                }
                if ((i2 & 8) != 0) {
                    payCallback = null;
                }
                feedPay.startSubscription(context, payInfo, feedPaymentConfig, payCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSubscription");
        }

        public static /* synthetic */ void showCouponReceiveDialog$default(FeedPay feedPay, Context context, String str, String str2, String str3, String str4, DismissCallback dismissCallback, int i2, Object obj) {
            DismissCallback dismissCallback2;
            if (obj == null) {
                if ((i2 & 32) != 0) {
                    dismissCallback2 = null;
                } else {
                    dismissCallback2 = dismissCallback;
                }
                feedPay.showCouponReceiveDialog(context, str, str2, str3, str4, dismissCallback2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCouponReceiveDialog");
        }

        public static /* synthetic */ Cancelable sendRequestAsync$default(FeedPay feedPay, String str, String str2, Class cls, Map map, PayResponseCallback payResponseCallback, int i2, Object obj) {
            Map map2;
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    Map emptyMap = Collections.emptyMap();
                    Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
                    map2 = emptyMap;
                } else {
                    map2 = map;
                }
                return feedPay.sendRequestAsync(str, str2, cls, map2, payResponseCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendRequestAsync");
        }

        public static /* synthetic */ Cancelable sendRequestAsyncOnUIBack$default(FeedPay feedPay, String str, String str2, Class cls, Map map, PayResponseCallback payResponseCallback, int i2, Object obj) {
            Map map2;
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    Map emptyMap = Collections.emptyMap();
                    Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
                    map2 = emptyMap;
                } else {
                    map2 = map;
                }
                return feedPay.sendRequestAsyncOnUIBack(str, str2, cls, map2, payResponseCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendRequestAsyncOnUIBack");
        }

        public static /* synthetic */ SimpleResponse parseFromOutline$default(FeedPay feedPay, String str, String str2, Class cls, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 8) != 0) {
                    obj = null;
                }
                return feedPay.parseFromOutline(str, str2, cls, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseFromOutline");
        }

        public static /* synthetic */ void openPaySuccessDialog$default(FeedPay feedPay, Context context, String str, int i2, int i3, DismissCallback dismissCallback, int i4, Object obj) {
            int i5;
            DismissCallback dismissCallback2;
            if (obj == null) {
                if ((i4 & 8) != 0) {
                    i5 = -1;
                } else {
                    i5 = i3;
                }
                if ((i4 & 16) != 0) {
                    dismissCallback2 = null;
                } else {
                    dismissCallback2 = dismissCallback;
                }
                feedPay.openPaySuccessDialog(context, str, i2, i5, dismissCallback2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPaySuccessDialog");
        }
    }
}
