package com.baidu.searchbox.flowvideo.paymentpanel.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.paymentpanel.api.TagDataBean;
import com.baidu.searchbox.flowvideo.paymentpanel.repos.TagDataModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/paymentpanel/mapper/PaidVideoTagItemMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/paymentpanel/api/TagDataBean;", "Lcom/baidu/searchbox/flowvideo/paymentpanel/repos/TagDataModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentDetailPanelMapper.kt */
public final class PaidVideoTagItemMapper implements Mapper<TagDataBean, TagDataModel> {
    public static final PaidVideoTagItemMapper INSTANCE = new PaidVideoTagItemMapper();

    private PaidVideoTagItemMapper() {
    }

    public TagDataModel map(TagDataBean input) {
        if (input == null) {
            return null;
        }
        TagDataBean tagDataBean = input;
        return new TagDataModel(input.getType(), input.getContent(), input.getCmd(), PaidVideoTagItemUrlMapper.INSTANCE.map(input.getUrl()));
    }
}
