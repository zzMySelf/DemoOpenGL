package com.baidu.searchbox.video.payment.videodetail;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.model.PaymentSpecialColumnModel;
import com.baidu.searchbox.video.detail.service.IPaymentSpecialColumnService;
import com.baidu.searchbox.video.payment.ui.VideoPaymentFloatingOperateView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPaymentFloatingOperateComponent.kt */
final class VideoPaymentFloatingOperateComponent$videoPaymentOperateView$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VideoPaymentFloatingOperateView $this_apply;
    final /* synthetic */ VideoPaymentFloatingOperateComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoPaymentFloatingOperateComponent$videoPaymentOperateView$2$1$1(VideoPaymentFloatingOperateComponent videoPaymentFloatingOperateComponent, VideoPaymentFloatingOperateView videoPaymentFloatingOperateView) {
        super(0);
        this.this$0 = videoPaymentFloatingOperateComponent;
        this.$this_apply = videoPaymentFloatingOperateView;
    }

    public final void invoke() {
        PaymentSpecialColumnModel access$getPaymentData$p = this.this$0.paymentData;
        boolean z = true;
        if (access$getPaymentData$p == null || !access$getPaymentData$p.isAntiSpam()) {
            z = false;
        }
        if (z) {
            UniversalToast.makeText(this.$this_apply.getContext(), R.string.video_payment_antispam_toast_text).show();
            return;
        }
        IPaymentSpecialColumnService iPaymentSpecialColumnService = (IPaymentSpecialColumnService) this.this$0.mComponentManager.getService(IPaymentSpecialColumnService.class);
        if (iPaymentSpecialColumnService != null) {
            iPaymentSpecialColumnService.pay("banner");
        }
    }
}
