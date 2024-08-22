package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.api.TagContentBean;
import com.baidu.searchbox.flowvideo.detail.repos.TagContentModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/FlowTagContentMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/detail/api/TagContentBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/TagContentModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowTagContentMapper.kt */
public final class FlowTagContentMapper implements Mapper<TagContentBean, TagContentModel> {
    public static final FlowTagContentMapper INSTANCE = new FlowTagContentMapper();

    private FlowTagContentMapper() {
    }

    public TagContentModel map(TagContentBean input) {
        if (input == null) {
            return null;
        }
        return new TagContentModel(input.getTitle(), input.getType(), input.getSubType());
    }
}
