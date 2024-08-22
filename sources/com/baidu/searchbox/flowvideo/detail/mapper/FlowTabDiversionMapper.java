package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.repos.TabDiversionModel;
import com.baidu.searchbox.flowvideo.flow.api.TabDiversionBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/FlowTabDiversionMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/flow/api/TabDiversionBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/TabDiversionModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowTabDiversionMapper.kt */
public final class FlowTabDiversionMapper implements Mapper<TabDiversionBean, TabDiversionModel> {
    public static final FlowTabDiversionMapper INSTANCE = new FlowTabDiversionMapper();

    private FlowTabDiversionMapper() {
    }

    public TabDiversionModel map(TabDiversionBean input) {
        String str;
        String str2 = null;
        String id = input != null ? input.getId() : null;
        if (id == null) {
            id = "";
        }
        String topTip = input != null ? input.getTopTip() : null;
        if (topTip == null) {
            topTip = "";
        }
        String btnText = input != null ? input.getBtnText() : null;
        if (btnText == null) {
            btnText = "";
        }
        String btnIcon = input != null ? input.getBtnIcon() : null;
        if (btnIcon == null) {
            btnIcon = "";
        }
        String btnJumpTabId = input != null ? input.getBtnJumpTabId() : null;
        if (btnJumpTabId == null) {
            btnJumpTabId = "";
        }
        String btnJumpScheme = input != null ? input.getBtnJumpScheme() : null;
        if (btnJumpScheme == null) {
            btnJumpScheme = "";
        }
        String triggerType = input != null ? input.getTriggerType() : null;
        if (triggerType == null) {
            triggerType = "";
        }
        String triggerConfig = input != null ? input.getTriggerConfig() : null;
        if (triggerConfig == null) {
            triggerConfig = "";
        }
        if (input != null) {
            str2 = input.getNeedLatestEpisode();
        }
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        TabDiversionModel model = new TabDiversionModel(id, topTip, btnText, btnIcon, btnJumpTabId, btnJumpScheme, triggerType, triggerConfig, str);
        boolean z = true;
        if (!model.checkValid()) {
            z = false;
        }
        if (!z) {
            return null;
        }
        return model;
    }
}
