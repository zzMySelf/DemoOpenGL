package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.api.PaymentDetailPanelTagBean;
import com.baidu.searchbox.flowvideo.detail.repos.PaymentDetailPanelTagModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/PaymentDetailPanelTagMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/detail/api/PaymentDetailPanelTagBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/PaymentDetailPanelTagModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentDetailPanelTagMapper.kt */
public final class PaymentDetailPanelTagMapper implements Mapper<PaymentDetailPanelTagBean, PaymentDetailPanelTagModel> {
    public static final PaymentDetailPanelTagMapper INSTANCE = new PaymentDetailPanelTagMapper();

    private PaymentDetailPanelTagMapper() {
    }

    public PaymentDetailPanelTagModel map(PaymentDetailPanelTagBean input) {
        if (input == null) {
            return null;
        }
        PaymentDetailPanelTagBean bean = input;
        return new PaymentDetailPanelTagModel(bean.getType(), bean.getPosition());
    }
}
