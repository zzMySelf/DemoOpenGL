package com.baidu.searchbox.video.detail.service;

import com.baidu.searchbox.video.detail.model.PaymentSpecialColumnModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/detail/service/IPaymentTitleInfoService;", "Lcom/baidu/searchbox/video/detail/service/IService;", "setColumnInfo", "", "info", "Lcom/baidu/searchbox/video/detail/model/PaymentSpecialColumnModel;", "video-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPaymentTitleInfoService.kt */
public interface IPaymentTitleInfoService extends IService {
    void setColumnInfo(PaymentSpecialColumnModel paymentSpecialColumnModel);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IPaymentTitleInfoService.kt */
    public static final class DefaultImpls {
        public static void setColumnInfo(IPaymentTitleInfoService iPaymentTitleInfoService, PaymentSpecialColumnModel info) {
        }
    }
}
