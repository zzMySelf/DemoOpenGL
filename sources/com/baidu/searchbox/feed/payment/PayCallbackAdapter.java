package com.baidu.searchbox.feed.payment;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/payment/PayCallbackAdapter;", "Lcom/baidu/searchbox/feed/payment/PayCallback;", "resId", "", "(Ljava/lang/String;)V", "extra", "getExtra", "()Ljava/lang/String;", "setExtra", "getResId", "onPayStateCallback", "", "payState", "", "payStateCallback", "lib-feedpay-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: feedpay.kt */
public abstract class PayCallbackAdapter implements PayCallback {
    private String extra;
    private final String resId;

    public abstract void payStateCallback(int i2, String str);

    public PayCallbackAdapter(String resId2) {
        this.resId = resId2;
    }

    public final String getResId() {
        return this.resId;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        this.extra = str;
    }

    public final void payStateCallback(int payState) {
        onPayStateCallback(payState, this.resId, this.extra);
    }

    public void onPayStateCallback(int payState, String resId2, String extra2) {
        payStateCallback(payState, resId2);
    }
}
