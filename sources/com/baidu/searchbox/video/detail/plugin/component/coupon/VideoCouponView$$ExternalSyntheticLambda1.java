package com.baidu.searchbox.video.detail.plugin.component.coupon;

import com.baidu.searchbox.account.ILoginResultListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoCouponView$$ExternalSyntheticLambda1 implements ILoginResultListener {
    public final /* synthetic */ VideoCouponView f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ VideoCouponView$$ExternalSyntheticLambda1(VideoCouponView videoCouponView, Function1 function1) {
        this.f$0 = videoCouponView;
        this.f$1 = function1;
    }

    public final void onResult(int i2) {
        VideoCouponView.m5362login$lambda3(this.f$0, this.f$1, i2);
    }
}
