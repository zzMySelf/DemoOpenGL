package com.baidu.searchbox.video.collectionflow.clearscreen.component.playduration;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.player.FirstJumpPlayerFirstFrame;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerPause;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerResume;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/clearscreen/component/playduration/CollectionClearPlayDurationReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionClearPlayDurationReducer.kt */
public final class CollectionClearPlayDurationReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof FirstJumpPlayerFirstFrame) {
            CollectionClearPlayDurationState collectionClearPlayDurationState = (CollectionClearPlayDurationState) state.select(CollectionClearPlayDurationState.class);
            if (collectionClearPlayDurationState != null) {
                mutableLiveData = collectionClearPlayDurationState.getStartPlaySlot();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        } else if (action instanceof ClearRecordNextSlot) {
            CollectionClearPlayDurationState collectionClearPlayDurationState2 = (CollectionClearPlayDurationState) state.select(CollectionClearPlayDurationState.class);
            if (collectionClearPlayDurationState2 != null) {
                mutableLiveData = collectionClearPlayDurationState2.getEndLastSlot();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        } else if (action instanceof ClearStartLoadingPartAction) {
            CollectionClearPlayDurationState collectionClearPlayDurationState3 = (CollectionClearPlayDurationState) state.select(CollectionClearPlayDurationState.class);
            if (collectionClearPlayDurationState3 != null) {
                mutableLiveData = collectionClearPlayDurationState3.getStartLoadingPart();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        } else if (action instanceof PlayerResume) {
            CollectionClearPlayDurationState collectionClearPlayDurationState4 = (CollectionClearPlayDurationState) state.select(CollectionClearPlayDurationState.class);
            if (collectionClearPlayDurationState4 != null) {
                mutableLiveData = collectionClearPlayDurationState4.getStartOrEndPausePart();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        } else if (action instanceof PlayerPause) {
            CollectionClearPlayDurationState collectionClearPlayDurationState5 = (CollectionClearPlayDurationState) state.select(CollectionClearPlayDurationState.class);
            if (collectionClearPlayDurationState5 != null) {
                mutableLiveData = collectionClearPlayDurationState5.getStartOrEndPausePart();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(true);
            }
        }
        return state;
    }
}
