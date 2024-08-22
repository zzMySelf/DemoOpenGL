package com.baidu.searchbox.video.feedflow.detail.longpressspeed;

import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.di.IFlowVideoConfig;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/LongPressSpeedComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/AbsLongPressSpeedComponent;", "()V", "guideHide", "", "guideShow", "isCanShow", "", "isShownGuide", "setGuideHasShown", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressSpeedComponent.kt */
public class LongPressSpeedComponent extends AbsLongPressSpeedComponent {
    public boolean isCanShow() {
        boolean isNeedGuideAnim = !isShownGuide();
        AbsState absState = null;
        if (isNeedGuideAnim) {
            GuidePriorityService guidePriorityService = (GuidePriorityService) getManager().getService(GuidePriorityService.class);
            isNeedGuideAnim = guidePriorityService != null ? GuidePriorityService.DefaultImpls.isCanShow$default(guidePriorityService, 19, (Function1) null, 2, (Object) null) : false;
        }
        if (isNeedGuideAnim) {
            Store<AbsState> store = getStore();
            if (store != null) {
                absState = store.getState();
            }
            if (!UBCManifestKt.isPageSourceFromCollection(absState)) {
                return true;
            }
        }
        return false;
    }

    public boolean isShownGuide() {
        return true;
    }

    public void setGuideHasShown() {
        IFlowVideoConfig config = DIFactory.INSTANCE.getConfig();
        Store<AbsState> store = getStore();
        config.setLongPressSpeedGuideHasShown(LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null));
    }

    public void guideShow() {
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(ShowLongPressGuide.INSTANCE);
        }
    }

    public void guideHide() {
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(HideLongPressGuide.INSTANCE);
        }
    }
}
