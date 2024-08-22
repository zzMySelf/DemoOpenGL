package com.baidu.searchbox.video.payment.videodetail;

import com.baidu.searchbox.feed.payment.widget.couponfloat.ICouponFloatController;
import com.baidu.searchbox.feed.payment.widget.couponfloat.ReceiveCouponCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPaymentBottomOperateComponent.kt */
final class VideoPaymentBottomOperateComponent$startTimer$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ICouponFloatController $this_run;
    final /* synthetic */ VideoPaymentBottomOperateComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoPaymentBottomOperateComponent$startTimer$1$1(VideoPaymentBottomOperateComponent videoPaymentBottomOperateComponent, ICouponFloatController iCouponFloatController) {
        super(0);
        this.this$0 = videoPaymentBottomOperateComponent;
        this.$this_run = iCouponFloatController;
    }

    public final void invoke() {
        this.this$0.getVideoPaymentOperateView().setVisibility(0);
        ICouponFloatController iCouponFloatController = this.$this_run;
        final VideoPaymentBottomOperateComponent videoPaymentBottomOperateComponent = this.this$0;
        iCouponFloatController.triggerReceiveCoupon(false, new ReceiveCouponCallback() {
            public void onResult(String refreshData) {
                videoPaymentBottomOperateComponent.onRefreshData(refreshData);
            }
        });
    }
}
