package com.baidu.searchbox.video.channel.flow.flow.ubc;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.UbcBean;
import com.baidu.searchbox.minivideo.util.MiniVideoStaisticUtils;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdAutoEnterType;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState;
import com.baidu.searchbox.video.feedflow.flow.ubc.FlowUbcReducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/flow/ubc/ChannelFlowUbcReducer;", "Lcom/baidu/searchbox/video/feedflow/flow/ubc/FlowUbcReducer;", "()V", "getVideoInfoExtLog", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "intentData", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "ubcBean", "Lcom/baidu/searchbox/feed/detail/ext/common/UbcBean;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowUbcReducer.kt */
public final class ChannelFlowUbcReducer extends FlowUbcReducer {
    public String getVideoInfoExtLog(CommonState state, IntentData intentData, UbcBean ubcBean) {
        ColdAutoEnterType type;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(intentData, "intentData");
        Intrinsics.checkNotNullParameter(ubcBean, "ubcBean");
        try {
            String from = ubcBean.getFrom();
            boolean z = true;
            if (from.length() == 0) {
                from = "feed";
            }
            String page = ubcBean.getPage();
            if (page.length() == 0) {
                page = "channel_video_landing";
            }
            JSONObject vExtLogObj = new JSONObject();
            String pd = intentData.pd;
            Intrinsics.checkNotNullExpressionValue(pd, "pd");
            if (pd.length() != 0) {
                z = false;
            }
            if (z) {
                pd = "unknown";
            }
            vExtLogObj.put(MiniVideoStaisticUtils.UBC_VIDEO_FROM_KEY, from);
            vExtLogObj.put(MiniVideoStaisticUtils.UBC_VIDEO_PAGE_KEY, page);
            vExtLogObj.put(MiniVideoStaisticUtils.UBC_VIDEO_SOURCE_KEY, pd);
            ColdLaunchEnterVideoTabState coldLaunchEnterVideoTabState = (ColdLaunchEnterVideoTabState) state.select(ColdLaunchEnterVideoTabState.class);
            if (!(coldLaunchEnterVideoTabState == null || (type = coldLaunchEnterVideoTabState.getColdAutoEnterType()) == null)) {
                vExtLogObj.put("coldLaunchEnterType", type.getKey());
            }
            String jSONObject = vExtLogObj.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "vExtLogObj.toString()");
            return jSONObject;
        } catch (JSONException e2) {
            return "";
        }
    }
}
