package com.baidu.searchbox.video.feedflow.flow.globalmuteguide;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.audiofocus.RequestAudioFocusAction;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalCancelMuteBtn;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/globalmuteguide/GlobalMuteGuideComponent$setViewListener$1", "Lcom/baidu/searchbox/video/feedflow/flow/globalmuteguide/GlobalCancelMuteBtn$IOnCancelMuteViewListener;", "onHideCancelKeepMute", "", "isClick", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlobalMuteGuideComponent.kt */
public final class GlobalMuteGuideComponent$setViewListener$1 implements GlobalCancelMuteBtn.IOnCancelMuteViewListener {
    final /* synthetic */ GlobalMuteGuideComponent this$0;

    GlobalMuteGuideComponent$setViewListener$1(GlobalMuteGuideComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onHideCancelKeepMute(boolean isClick) {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new OnHideCancelKeepMuteAction(isClick));
        }
        GlobalMuteGuideView access$getGuideView$p = this.this$0.guideView;
        if (access$getGuideView$p != null) {
            access$getGuideView$p.hideView(false);
        }
        Store $this$select$iv = this.this$0.getStore();
        Boolean bool = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            GlobalMuteGuideState globalMuteGuideState = (GlobalMuteGuideState) (commonState != null ? commonState.select(GlobalMuteGuideState.class) : null);
            if (globalMuteGuideState != null) {
                bool = Boolean.valueOf(globalMuteGuideState.getForceCancelMuteFromDestroy());
            }
        }
        boolean forceCancelMuteFromDestroy = BdPlayerUtils.orFalse(bool);
        if (this.this$0.isShowCancelMuteButtonDynamic() && !forceCancelMuteFromDestroy) {
            GlobalMuteGuideHelper.INSTANCE.setCancelMuteFromDynamic(true);
            GlobalMuteGuideHelper.INSTANCE.registerActivityLifecycle();
            Store access$getStore2 = this.this$0.getStore();
            if (access$getStore2 != null) {
                StoreExtKt.post(access$getStore2, RequestAudioFocusAction.INSTANCE);
            }
        }
    }
}
