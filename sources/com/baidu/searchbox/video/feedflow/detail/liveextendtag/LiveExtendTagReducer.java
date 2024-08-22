package com.baidu.searchbox.video.feedflow.detail.liveextendtag;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/liveextendtag/LiveExtendTagReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveExtendTagReducer.kt */
public final class LiveExtendTagReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        LiveExtendTagState $this$reduce_u24lambda_u2d2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = false;
        if (action instanceof LiveExtendTagsNetSuccess) {
            LiveExtendTagState $this$reduce_u24lambda_u2d0 = (LiveExtendTagState) state.select(LiveExtendTagState.class);
            if ($this$reduce_u24lambda_u2d0 != null) {
                $this$reduce_u24lambda_u2d0.getTags().setValue(((LiveExtendTagsNetSuccess) action).getTags());
                List value = $this$reduce_u24lambda_u2d0.getTags().getValue();
                if (value != null) {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    if (!value.isEmpty()) {
                        z = true;
                    }
                }
                if (z) {
                    $this$reduce_u24lambda_u2d0.isVisible().setValue(true);
                }
            }
        } else if (action instanceof LiveExtendTagIsVisible) {
            LiveExtendTagState liveExtendTagState = (LiveExtendTagState) state.select(LiveExtendTagState.class);
            MutableLiveData<Boolean> isVisible = liveExtendTagState != null ? liveExtendTagState.isVisible() : null;
            if (isVisible != null) {
                isVisible.setValue(Boolean.valueOf(((LiveExtendTagIsVisible) action).isVisible()));
            }
        } else if (action instanceof LiveExtendTagShowOrHideAnim) {
            LiveExtendTagState $this$reduce_u24lambda_u2d1 = (LiveExtendTagState) state.select(LiveExtendTagState.class);
            if ($this$reduce_u24lambda_u2d1 != null) {
                $this$reduce_u24lambda_u2d1.isShowOrHideAnim().setValue(Boolean.valueOf(((LiveExtendTagShowOrHideAnim) action).isShowOrHideAnim()));
            }
        } else if ((action instanceof ResetExtendTagsData) && ($this$reduce_u24lambda_u2d2 = (LiveExtendTagState) state.select(LiveExtendTagState.class)) != null) {
            $this$reduce_u24lambda_u2d2.getTags().setValue(CollectionsKt.emptyList());
            $this$reduce_u24lambda_u2d2.isVisible().setValue(false);
        }
        return state;
    }
}
