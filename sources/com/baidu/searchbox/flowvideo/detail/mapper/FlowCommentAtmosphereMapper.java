package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.api.FlowCommentAtmosphereBean;
import com.baidu.searchbox.flowvideo.detail.repos.FlowCommentAtmosphereModel;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/FlowCommentAtmosphereMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/detail/api/FlowCommentAtmosphereBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowCommentAtmosphereModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowCommentAtmosphereMapper.kt */
public final class FlowCommentAtmosphereMapper implements Mapper<FlowCommentAtmosphereBean, FlowCommentAtmosphereModel> {
    public static final FlowCommentAtmosphereMapper INSTANCE = new FlowCommentAtmosphereMapper();

    private FlowCommentAtmosphereMapper() {
    }

    public FlowCommentAtmosphereModel map(FlowCommentAtmosphereBean input) {
        if (input == null) {
            return null;
        }
        FlowCommentAtmosphereBean flowCommentAtmosphereBean = input;
        String hotIcon = input.getHotIcon();
        Integer intOrNull = StringsKt.toIntOrNull(input.getHotSwitch());
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        Integer intOrNull2 = StringsKt.toIntOrNull(input.getHotThresholdNum());
        int intValue2 = intOrNull2 != null ? intOrNull2.intValue() : 3000;
        String sofaIcon = input.getSofaIcon();
        Integer intOrNull3 = StringsKt.toIntOrNull(input.getSofaSwitch());
        int intValue3 = intOrNull3 != null ? intOrNull3.intValue() : 0;
        String voteIcon = input.getVoteIcon();
        Integer intOrNull4 = StringsKt.toIntOrNull(input.getVoteSwitch());
        int intValue4 = intOrNull4 != null ? intOrNull4.intValue() : 0;
        Integer intOrNull5 = StringsKt.toIntOrNull(input.getIconDelayTime());
        int intValue5 = intOrNull5 != null ? intOrNull5.intValue() : 1;
        Integer intOrNull6 = StringsKt.toIntOrNull(input.getHotRotateSwitch());
        int intValue6 = intOrNull6 != null ? intOrNull6.intValue() : 0;
        Integer intOrNull7 = StringsKt.toIntOrNull(input.getHotStype());
        int intValue7 = intOrNull7 != null ? intOrNull7.intValue() : 0;
        Integer intOrNull8 = StringsKt.toIntOrNull(input.getZeroCommentSwitch());
        return new FlowCommentAtmosphereModel(hotIcon, intValue, intValue2, intValue5, sofaIcon, intValue3, voteIcon, intOrNull8 != null ? intOrNull8.intValue() : 0, input.getZeroCommentIcon(), input.getZeroCommentNewIcon(), intValue4, intValue6, intValue7);
    }
}
