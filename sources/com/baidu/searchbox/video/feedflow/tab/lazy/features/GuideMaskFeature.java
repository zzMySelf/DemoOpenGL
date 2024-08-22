package com.baidu.searchbox.video.feedflow.tab.lazy.features;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.component.guide.GuideAction;
import com.baidu.searchbox.video.feedflow.common.downgrade.DowngradeFeatureWrap;
import com.baidu.searchbox.video.feedflow.flow.guide.SevenDayUnScrollUpStartGuideAction;
import com.baidu.searchbox.video.feedflow.tab.lazy.TabLazyInflateState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/lazy/features/GuideMaskFeature;", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/DowngradeFeatureWrap;", "()V", "apply", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "canApply", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuideMaskFeature.kt */
public final class GuideMaskFeature extends DowngradeFeatureWrap {
    public boolean canApply(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof GuideAction.OnGuideScrollUpStartAction ? true : Intrinsics.areEqual((Object) action, (Object) SevenDayUnScrollUpStartGuideAction.INSTANCE)) {
            return true;
        }
        return false;
    }

    public void apply(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        TabLazyInflateState tabLazyInflateState = (TabLazyInflateState) state.select(TabLazyInflateState.class);
        if (tabLazyInflateState != null) {
            tabLazyInflateState.triggerInflateGuideMask$lib_flow_component_release();
        }
    }
}
