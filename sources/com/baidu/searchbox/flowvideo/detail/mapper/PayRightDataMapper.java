package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.api.PayRightBean;
import com.baidu.searchbox.flowvideo.detail.api.PayRightElementBean;
import com.baidu.searchbox.flowvideo.detail.repos.PayRightElementModel;
import com.baidu.searchbox.flowvideo.detail.repos.PayRightModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/PayRightDataMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/detail/api/PayRightBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/PayRightModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayRightDataMapper.kt */
public final class PayRightDataMapper implements Mapper<PayRightBean, PayRightModel> {
    public static final PayRightDataMapper INSTANCE = new PayRightDataMapper();

    private PayRightDataMapper() {
    }

    public PayRightModel map(PayRightBean input) {
        List items = null;
        if (input == null) {
            return null;
        }
        PayRightBean bean = input;
        String title = bean.getTitle();
        List<PayRightElementBean> items2 = bean.getItems();
        if (items2 != null) {
            List list = new ArrayList();
            for (PayRightElementBean item : items2) {
                PayRightElementModel itemModel = PayRightElementDataMapper.INSTANCE.map(item);
                if (itemModel != null) {
                    list.add(itemModel);
                }
            }
            items = list;
        }
        return new PayRightModel(title, items);
    }
}
