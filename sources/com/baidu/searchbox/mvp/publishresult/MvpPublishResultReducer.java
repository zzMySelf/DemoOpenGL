package com.baidu.searchbox.mvp.publishresult;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.mvp.publishresult.MvpPublishResultAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/mvp/publishresult/MvpPublishResultReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MvpPublishResultReducer.kt */
public final class MvpPublishResultReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof MvpPublishResultAction.NotifyPublishResultModel) {
            MvpPublishResultState mvpPublishResultState = (MvpPublishResultState) state.select(MvpPublishResultState.class);
            if (mvpPublishResultState != null) {
                mutableLiveData = mvpPublishResultState.getMvpResultModel();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((MvpPublishResultAction.NotifyPublishResultModel) action).getData());
            }
        } else if (action instanceof MvpPublishResultAction.ShowPublishResult) {
            MvpPublishResultState mvpPublishResultState2 = (MvpPublishResultState) state.select(MvpPublishResultState.class);
            MutableLiveData<String> title = mvpPublishResultState2 != null ? mvpPublishResultState2.getTitle() : null;
            if (title != null) {
                title.setValue(((MvpPublishResultAction.ShowPublishResult) action).getTitleStr());
            }
            MvpPublishResultState mvpPublishResultState3 = (MvpPublishResultState) state.select(MvpPublishResultState.class);
            if (mvpPublishResultState3 != null) {
                mutableLiveData = mvpPublishResultState3.getShow();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(true);
            }
        } else if (action instanceof MvpPublishResultAction.NotifyPublishResult) {
            MvpPublishResultState mvpPublishResultState4 = (MvpPublishResultState) state.select(MvpPublishResultState.class);
            if (mvpPublishResultState4 != null) {
                mutableLiveData = mvpPublishResultState4.isPublishSuc();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(((MvpPublishResultAction.NotifyPublishResult) action).isPublishSuc()));
            }
        } else if (action instanceof MvpPublishResultAction.NotifyPublishId) {
            MvpPublishResultState mvpPublishResultState5 = (MvpPublishResultState) state.select(MvpPublishResultState.class);
            if (mvpPublishResultState5 != null) {
                mutableLiveData = mvpPublishResultState5.getNid();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((MvpPublishResultAction.NotifyPublishId) action).getNid());
            }
        } else if (action instanceof MvpPublishResultAction.ResumeShowPublishResult) {
            MvpPublishResultState mvpPublishResultState6 = (MvpPublishResultState) state.select(MvpPublishResultState.class);
            if (mvpPublishResultState6 != null) {
                mutableLiveData = mvpPublishResultState6.getShow();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(true);
            }
        } else if (action instanceof MvpPublishResultAction.PublishResultGone) {
            MvpPublishResultState mvpPublishResultState7 = (MvpPublishResultState) state.select(MvpPublishResultState.class);
            if (mvpPublishResultState7 != null) {
                mutableLiveData = mvpPublishResultState7.getShow();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        }
        return state;
    }
}
