package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/LiveExtendTagsMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "", "", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveExtendTagsMapper.kt */
public final class LiveExtendTagsMapper implements Mapper<List<? extends String>, List<? extends String>> {
    public static final LiveExtendTagsMapper INSTANCE = new LiveExtendTagsMapper();

    private LiveExtendTagsMapper() {
    }

    public List<String> map(List<String> input) {
        if (input == null) {
            return null;
        }
        List<String> bean = input.isEmpty() ^ true ? input : null;
        if (bean == null) {
            return null;
        }
        List result = new ArrayList();
        for (String tag : bean) {
            if (!StringsKt.isBlank(tag)) {
                result.add(tag);
            }
        }
        return result;
    }
}
