package com.baidu.searchbox.video.feedflow.detail.payment.player.plugin;

import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.video.detail.export.IVideoSender;
import com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentFlowPlayer;
import com.baidu.searchbox.video.payment.videodetail.VideoPaymentVideoProgressPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/player/plugin/PaymentVideoProgressPlugin;", "Lcom/baidu/searchbox/video/payment/videodetail/VideoPaymentVideoProgressPlugin;", "()V", "getProgressData", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentVideoProgressPlugin.kt */
public final class PaymentVideoProgressPlugin extends VideoPaymentVideoProgressPlugin {
    /* access modifiers changed from: protected */
    public String getProgressData() {
        BDVideoPlayer bindPlayer = getBindPlayer();
        IVideoSender.VideoProgressBean videoProgressBean = null;
        PaymentFlowPlayer player = bindPlayer instanceof PaymentFlowPlayer ? (PaymentFlowPlayer) bindPlayer : null;
        if (player != null) {
            PaymentFlowPlayer paymentFlowPlayer = player;
            try {
                videoProgressBean = IVideoSender.VideoProgressBean.obtainVideoProcess(player.getAlbumPaid(), player.getId(), getMPosition(), getMDuration(), player.isFree() ? 0 : 1, player.isPaid() ? 1 : 0);
            } catch (JSONException e2) {
                return "";
            }
        }
        if (videoProgressBean == null) {
            return "";
        }
        String jsonStr = videoProgressBean.toJsonStr();
        Intrinsics.checkNotNullExpressionValue(jsonStr, "videoProgressBean.toJsonStr()");
        return jsonStr;
    }
}
