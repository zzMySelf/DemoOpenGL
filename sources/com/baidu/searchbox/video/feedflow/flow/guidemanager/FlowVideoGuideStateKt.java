package com.baidu.searchbox.video.feedflow.flow.guidemanager;

import com.baidu.searchbox.video.service.guidepriority.GuidePriorityModel;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"isGuideShowing", "", "service", "Lcom/baidu/searchbox/video/service/guidepriority/GuidePriorityService;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoGuideState.kt */
public final class FlowVideoGuideStateKt {
    public static final boolean isGuideShowing(GuidePriorityService service) {
        Map guideMap = service != null ? service.getGuideMap() : null;
        if (guideMap == null) {
            return false;
        }
        for (Map.Entry<Integer, GuidePriorityModel> element$iv : guideMap.entrySet()) {
            if (((GuidePriorityModel) element$iv.getValue()).isShowing().invoke().booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
