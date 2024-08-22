package com.baidu.searchbox.feed.payment.utils;

import android.view.View;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B&\u0012\u001f\u0010\u0002\u001a\u001b\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0005J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R'\u0010\u0002\u001a\u001b\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/payment/utils/SerialClickListener;", "Landroid/view/View$OnClickListener;", "realOnClick", "Lkotlin/Function2;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "mDoing", "", "markDone", "onClick", "view", "postDelayedMarkDone", "delayedMillis", "", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleUiHelper.kt */
public final class SerialClickListener implements View.OnClickListener {
    private boolean mDoing;
    private final Function2<SerialClickListener, View, Unit> realOnClick;

    public SerialClickListener(Function2<? super SerialClickListener, ? super View, Unit> realOnClick2) {
        Intrinsics.checkNotNullParameter(realOnClick2, "realOnClick");
        this.realOnClick = realOnClick2;
    }

    public void onClick(View view2) {
        if (!this.mDoing) {
            this.mDoing = true;
            this.realOnClick.invoke(this, view2);
        }
    }

    public final void markDone() {
        this.mDoing = false;
    }

    public final void postDelayedMarkDone(long delayedMillis) {
        FeedpayKt.mainHandler().postDelayed(new SerialClickListener$$ExternalSyntheticLambda0(this), delayedMillis);
    }

    /* access modifiers changed from: private */
    /* renamed from: postDelayedMarkDone$lambda-0  reason: not valid java name */
    public static final void m19304postDelayedMarkDone$lambda0(SerialClickListener this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.markDone();
    }
}
