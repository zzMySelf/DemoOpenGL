package com.baidu.searchbox.video.feedflow.detail.recognition;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.CollectionContinueDataUpdate;
import com.baidu.searchbox.video.feedflow.detail.collectonselectset.CollectionSelectSetsAction;
import com.baidu.searchbox.video.feedflow.detail.hotcomment.HotCommentAction;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim;
import com.baidu.searchbox.video.feedflow.detail.recognition.CelebrityRecognitionAction;
import com.baidu.searchbox.video.feedflow.detail.recognition.utils.CelebrityLottiePreloader;
import com.baidu.searchbox.video.feedflow.detail.videopk.VideoPkAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/recognition/CelebrityRecognitionReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CelebrityRecognitionReducer.kt */
public final class CelebrityRecognitionReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = false;
        MutableLiveData<Boolean> mutableLiveData = null;
        if (action instanceof NetAction.Success) {
            Object data = ((NetAction.Success) action).getData();
            FlowDetailModel model = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
            if (model != null) {
                CelebrityRecognitionState celebrityRecognitionState = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
                if (celebrityRecognitionState != null) {
                    mutableLiveData = celebrityRecognitionState.getEnabled();
                }
                if (mutableLiveData != null) {
                    if (model.isCelebrityRecognitionEnabled() && CelebrityLottiePreloader.INSTANCE.isEnabled()) {
                        z = true;
                    }
                    mutableLiveData.setValue(Boolean.valueOf(z));
                }
            }
        } else if (action instanceof CelebrityRecognitionAction.OnCelebrityRecognitionSuccess) {
            CelebrityRecognitionState $this$reduce_u24lambda_u2d1 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if ($this$reduce_u24lambda_u2d1 != null) {
                $this$reduce_u24lambda_u2d1.getData().setValue(((CelebrityRecognitionAction.OnCelebrityRecognitionSuccess) action).getData());
            }
        } else if (action instanceof LongPressSpeedAnim) {
            CelebrityRecognitionState celebrityRecognitionState2 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if (celebrityRecognitionState2 != null) {
                celebrityRecognitionState2.setVisible(!((LongPressSpeedAnim) action).isStart());
            }
        } else if (action instanceof VideoPkAction.OnVideoPkShownAction) {
            CelebrityRecognitionState celebrityRecognitionState3 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if (celebrityRecognitionState3 != null) {
                celebrityRecognitionState3.setRecognitionEnabled(false);
            }
        } else if (action instanceof VideoPkAction.OnVideoPkHiddenAction) {
            CelebrityRecognitionState celebrityRecognitionState4 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if (celebrityRecognitionState4 != null) {
                celebrityRecognitionState4.setRecognitionEnabled(true);
            }
        } else if (action instanceof CollectionSelectSetsAction.OnCollectionNextButtonClick) {
            CelebrityRecognitionState celebrityRecognitionState5 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if (celebrityRecognitionState5 != null) {
                celebrityRecognitionState5.reset();
            }
        } else if (action instanceof CollectionContinueDataUpdate) {
            CelebrityRecognitionState celebrityRecognitionState6 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if (celebrityRecognitionState6 != null) {
                celebrityRecognitionState6.reset();
            }
        } else if (action instanceof HotCommentAction.HotCommentShownAction) {
            CelebrityRecognitionState celebrityRecognitionState7 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if (celebrityRecognitionState7 != null) {
                mutableLiveData = celebrityRecognitionState7.getSetBottomMargin();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(true);
            }
        } else if (action instanceof HotCommentAction.HotCommentCloseBtnClickAction) {
            CelebrityRecognitionState celebrityRecognitionState8 = (CelebrityRecognitionState) state.select(CelebrityRecognitionState.class);
            if (celebrityRecognitionState8 != null) {
                mutableLiveData = celebrityRecognitionState8.getSetBottomMargin();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        }
        return state;
    }
}
