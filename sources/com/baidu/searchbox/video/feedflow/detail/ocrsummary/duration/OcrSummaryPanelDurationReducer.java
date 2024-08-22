package com.baidu.searchbox.video.feedflow.detail.ocrsummary.duration;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrSummaryAction;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrSummaryState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/duration/OcrSummaryPanelDurationReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrSummaryPanelDurationReducer.kt */
public final class OcrSummaryPanelDurationReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData<Boolean> mutableLiveData = null;
        if (action instanceof OcrSummaryAction.OcrSummaryPanelShowAction) {
            OcrSummaryState ocrSummaryState = (OcrSummaryState) state.select(OcrSummaryState.class);
            if (ocrSummaryState != null) {
                mutableLiveData = ocrSummaryState.getStartOrStopDuration();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(true);
            }
        } else if (action instanceof OcrSummaryAction.OcrSummaryPanelHideAction) {
            OcrSummaryState ocrSummaryState2 = (OcrSummaryState) state.select(OcrSummaryState.class);
            if (ocrSummaryState2 != null) {
                mutableLiveData = ocrSummaryState2.getStartOrStopDuration();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        }
        return state;
    }
}
