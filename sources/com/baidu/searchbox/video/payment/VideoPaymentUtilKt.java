package com.baidu.searchbox.video.payment;

import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.video.detail.core.ComponentManager;
import com.baidu.searchbox.video.detail.core.model.VideoDetailCommonModel;
import com.baidu.searchbox.video.detail.core.model.VideoDetailModel;
import com.baidu.searchbox.video.detail.model.PaymentSpecialColumnModel;
import com.baidu.searchbox.video.detail.service.IPaymentColumnInfoService;
import com.baidu.searchbox.video.detail.utils.VideoDetailUbcExtUtils;
import com.baidu.searchbox.video.payment.player.VideoPaymentPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\b\u001a\f\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\n\u001a&\u0010\u000b\u001a\u00020\f*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, d2 = {"shouldShowEndLayer", "", "player", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "getPaymentInfoService", "Lcom/baidu/searchbox/video/detail/service/IPaymentColumnInfoService;", "Lcom/baidu/searchbox/video/detail/core/ComponentManager;", "isMiddleLineEnable", "Lcom/baidu/searchbox/video/detail/model/PaymentSpecialColumnModel$FloatingOperate$OperateButton;", "isPaymentNewStyle", "Lcom/baidu/searchbox/video/detail/core/model/VideoDetailModel;", "reportPaymentUbcEvent", "", "type", "", "value", "extLog", "Lorg/json/JSONObject;", "lib-detail-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPaymentUtil.kt */
public final class VideoPaymentUtilKt {
    public static final boolean shouldShowEndLayer(BaseVideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        VideoPaymentPlayer $this$shouldShowEndLayer_u24lambda_u2d0 = player instanceof VideoPaymentPlayer ? (VideoPaymentPlayer) player : null;
        if ($this$shouldShowEndLayer_u24lambda_u2d0 == null) {
            return false;
        }
        if ($this$shouldShowEndLayer_u24lambda_u2d0.isAlbumPaid() || $this$shouldShowEndLayer_u24lambda_u2d0.isFree()) {
            return true;
        }
        return false;
    }

    public static final boolean isPaymentNewStyle(VideoDetailModel $this$isPaymentNewStyle) {
        VideoDetailCommonModel videoDetailCommonModel;
        if ($this$isPaymentNewStyle == null || (videoDetailCommonModel = $this$isPaymentNewStyle.commonModel) == null) {
            return false;
        }
        return videoDetailCommonModel.isNewPaymentStyle;
    }

    public static final boolean isMiddleLineEnable(PaymentSpecialColumnModel.FloatingOperate.OperateButton $this$isMiddleLineEnable) {
        Intrinsics.checkNotNullParameter($this$isMiddleLineEnable, "<this>");
        return Intrinsics.areEqual((Object) $this$isMiddleLineEnable.style, (Object) "midLine");
    }

    public static /* synthetic */ void reportPaymentUbcEvent$default(VideoDetailModel videoDetailModel, String str, String str2, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            jSONObject = null;
        }
        reportPaymentUbcEvent(videoDetailModel, str, str2, jSONObject);
    }

    public static final void reportPaymentUbcEvent(VideoDetailModel $this$reportPaymentUbcEvent, String type, String value, JSONObject extLog) {
        Intrinsics.checkNotNullParameter($this$reportPaymentUbcEvent, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        if ($this$reportPaymentUbcEvent.intentData != null && $this$reportPaymentUbcEvent.commonModel != null) {
            String page = $this$reportPaymentUbcEvent.intentData.page;
            String nid = $this$reportPaymentUbcEvent.commonModel.mAlumId;
            VideoDetailUbcExtUtils.paymentUbc(page, type, value, $this$reportPaymentUbcEvent.intentData.pd + $this$reportPaymentUbcEvent.intentData.recSrc, nid, $this$reportPaymentUbcEvent.intentData.payOrderInfo, (String) null, extLog);
        }
    }

    public static final IPaymentColumnInfoService getPaymentInfoService(ComponentManager $this$getPaymentInfoService) {
        Intrinsics.checkNotNullParameter($this$getPaymentInfoService, "<this>");
        if (isPaymentNewStyle($this$getPaymentInfoService.currentModel)) {
            return (IPaymentColumnInfoService) $this$getPaymentInfoService.getService(IPaymentColumnInfoService.class);
        }
        IPaymentColumnInfoService iPaymentColumnInfoService = null;
        return null;
    }
}
