package com.baidu.searchbox.feed.payment.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/CouponPayInfoItem;", "Lcom/baidu/searchbox/NoProGuard;", "()V", "data", "Lcom/baidu/searchbox/feed/payment/model/CouponPayInfoItemData;", "layout", "", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayPanelData.kt */
public final class CouponPayInfoItem implements NoProGuard {
    @SerializedName("data")
    public final CouponPayInfoItemData data = new CouponPayInfoItemData();
    @SerializedName("layout")
    public String layout = "";
}
