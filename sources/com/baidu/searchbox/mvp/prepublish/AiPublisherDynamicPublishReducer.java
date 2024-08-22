package com.baidu.searchbox.mvp.prepublish;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.mvp.prepublish.AiPublisherDynamicPublishAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/mvp/prepublish/AiPublisherDynamicPublishReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPublisherDynamicPublishReducer.kt */
public final class AiPublisherDynamicPublishReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof AiPublisherDynamicPublishAction.ShowEnable) {
            AiPublisherDynamicPublishState aiPublisherDynamicPublishState = (AiPublisherDynamicPublishState) state.select(AiPublisherDynamicPublishState.class);
            if (aiPublisherDynamicPublishState != null) {
                mutableLiveData = aiPublisherDynamicPublishState.getShowEnable();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(((AiPublisherDynamicPublishAction.ShowEnable) action).getEnable()));
            }
        } else if (action instanceof AiPublisherDynamicPublishAction.UpdateRenderModel) {
            Object pageData = ((AiPublisherDynamicPublishAction.UpdateRenderModel) action).getPageModel().getPageData();
            AiPublisherDynamicPublishModel it = pageData instanceof AiPublisherDynamicPublishModel ? (AiPublisherDynamicPublishModel) pageData : null;
            if (it != null) {
                AiPublisherDynamicPublishState aiPublisherDynamicPublishState2 = (AiPublisherDynamicPublishState) state.select(AiPublisherDynamicPublishState.class);
                if (aiPublisherDynamicPublishState2 != null) {
                    mutableLiveData = aiPublisherDynamicPublishState2.getPageModel();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(it);
                }
            }
        } else if (action instanceof AiPublisherDynamicPublishAction.RenderView) {
            Object pageData2 = ((AiPublisherDynamicPublishAction.RenderView) action).getPageModel().getPageData();
            AiPublisherDynamicPublishModel it2 = pageData2 instanceof AiPublisherDynamicPublishModel ? (AiPublisherDynamicPublishModel) pageData2 : null;
            if (it2 != null) {
                AiPublisherDynamicPublishState aiPublisherDynamicPublishState3 = (AiPublisherDynamicPublishState) state.select(AiPublisherDynamicPublishState.class);
                if (aiPublisherDynamicPublishState3 != null) {
                    mutableLiveData = aiPublisherDynamicPublishState3.getPageModel();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(it2);
                }
            }
        } else if (action instanceof AiPublisherDynamicPublishAction.AddImages) {
            AiPublisherDynamicPublishState aiPublisherDynamicPublishState4 = (AiPublisherDynamicPublishState) state.select(AiPublisherDynamicPublishState.class);
            if (aiPublisherDynamicPublishState4 != null) {
                mutableLiveData = aiPublisherDynamicPublishState4.getAddImages();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((AiPublisherDynamicPublishAction.AddImages) action).getImages());
            }
        } else if (action instanceof AiPublisherDynamicPublishAction.UpdateTitle) {
            AiPublisherDynamicPublishState aiPublisherDynamicPublishState5 = (AiPublisherDynamicPublishState) state.select(AiPublisherDynamicPublishState.class);
            if (aiPublisherDynamicPublishState5 != null) {
                mutableLiveData = aiPublisherDynamicPublishState5.getUpdateTitle();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((AiPublisherDynamicPublishAction.UpdateTitle) action).getTitle());
            }
        } else if (action instanceof AiPublisherDynamicPublishAction.UpdateText) {
            AiPublisherDynamicPublishState aiPublisherDynamicPublishState6 = (AiPublisherDynamicPublishState) state.select(AiPublisherDynamicPublishState.class);
            if (aiPublisherDynamicPublishState6 != null) {
                mutableLiveData = aiPublisherDynamicPublishState6.getUpdateText();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((AiPublisherDynamicPublishAction.UpdateText) action).getContent());
            }
        }
        return state;
    }
}
