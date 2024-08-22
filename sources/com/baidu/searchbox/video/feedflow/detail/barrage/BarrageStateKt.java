package com.baidu.searchbox.video.feedflow.detail.barrage;

import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailCommentModel;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"BARRAGE_DISABLE", "", "getBarrageSwitch", "", "commentConf", "", "isBarrageEnabled", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailCommentModel;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageState.kt */
public final class BarrageStateKt {
    public static final int BARRAGE_DISABLE = 0;

    public static final boolean isBarrageEnabled(FlowDetailCommentModel $this$isBarrageEnabled) {
        if ($this$isBarrageEnabled == null) {
            return false;
        }
        FlowDetailCommentModel comment = $this$isBarrageEnabled;
        if (!comment.isCommentSwitch()) {
            return false;
        }
        if (!(comment.getTopicId().length() > 0) || !getBarrageSwitch(comment.getCommentConf())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean getBarrageSwitch(String commentConf) {
        Object obj;
        Object obj2;
        if (commentConf != null) {
            try {
                obj2 = Integer.valueOf(new JSONObject(commentConf).optInt("barrage_switch"));
            } catch (Exception e2) {
                obj = "";
            }
        } else {
            obj2 = null;
        }
        obj = obj2;
        return !(obj instanceof Integer) || ((Number) obj).intValue() != 0;
    }
}
