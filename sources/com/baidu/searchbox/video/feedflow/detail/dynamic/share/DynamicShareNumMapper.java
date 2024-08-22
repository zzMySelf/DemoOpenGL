package com.baidu.searchbox.video.feedflow.detail.dynamic.share;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailShareModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.video.component.share.ShareNumModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/share/DynamicShareNumMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicDetailModel;", "Lcom/baidu/searchbox/video/component/share/ShareNumModel;", "()V", "map", "input", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicShareNumMapper.kt */
public final class DynamicShareNumMapper implements Mapper<DynamicDetailModel, ShareNumModel> {
    public static final DynamicShareNumMapper INSTANCE = new DynamicShareNumMapper();

    private DynamicShareNumMapper() {
    }

    public ShareNumModel map(DynamicDetailModel input) {
        Intrinsics.checkNotNullParameter(input, "input");
        FlowDetailShareModel shareInfo = input.getShareInfo();
        if (shareInfo == null) {
            return null;
        }
        try {
            return new ShareNumModel(Long.parseLong(shareInfo.getShareNum()), Long.parseLong(shareInfo.getShareTrigger()), input.getNid());
        } catch (NumberFormatException e2) {
            return new ShareNumModel(0, 0, input.getNid());
        }
    }
}
