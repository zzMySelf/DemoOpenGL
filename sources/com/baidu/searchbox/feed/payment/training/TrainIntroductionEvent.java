package com.baidu.searchbox.feed.payment.training;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/payment/training/TrainIntroductionEvent;", "", "showImmediately", "", "resId", "", "(ZLjava/lang/String;)V", "getResId", "()Ljava/lang/String;", "setResId", "(Ljava/lang/String;)V", "getShowImmediately", "()Z", "setShowImmediately", "(Z)V", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrainEnterManager.kt */
public final class TrainIntroductionEvent {
    private String resId;
    private boolean showImmediately;

    public TrainIntroductionEvent(boolean showImmediately2, String resId2) {
        this.showImmediately = showImmediately2;
        this.resId = resId2;
    }

    public final String getResId() {
        return this.resId;
    }

    public final boolean getShowImmediately() {
        return this.showImmediately;
    }

    public final void setResId(String str) {
        this.resId = str;
    }

    public final void setShowImmediately(boolean z) {
        this.showImmediately = z;
    }
}
