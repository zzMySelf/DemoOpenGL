package com.baidu.searchbox.feed.biserial.processors;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdmediacore.MediaRuntime;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.feed.biserial.ui.ScrollGuideAbility;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FlowProcessor;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.annotations.OnDestroyViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnLeavePageAction;
import com.baidu.searchbox.feed.flow.annotations.OnRefreshOperatorAction;
import com.baidu.searchbox.feed.tab.interaction.tts.TTSPlayerEvent;
import com.baidu.searchbox.feed.widget.scrolllguide.ArrowAnimGuideViewManager;
import com.baidu.searchbox.feed.widget.scrolllguide.ArrowGuidePolicy;
import com.baidu.searchbox.feed.widget.scrolllguide.GuidePolicyDickCacheImpl;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.TypedAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0003J\b\u0010\f\u001a\u00020\bH\u0003J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0003J\u0017\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/processors/DiscoveryScrollGuideProcessor;", "Lcom/baidu/searchbox/feed/flow/FlowProcessor;", "()V", "currentRefreshSource", "", "guideManager", "Lcom/baidu/searchbox/feed/widget/scrolllguide/ArrowAnimGuideViewManager;", "dismissGuide", "", "getScrollGuideAbility", "Lcom/baidu/searchbox/feed/biserial/ui/ScrollGuideAbility;", "onDestroy", "onLeavePage", "onListScroll", "action", "Lcom/baidu/searchbox/feed/flow/Actions$ScrollDraggingStateAction;", "onRefreshOperation", "operator", "", "(Ljava/lang/Integer;)V", "registerFontChangeEvent", "showGuideIfNeed", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DiscoveryScrollGuideProcesor.kt */
public final class DiscoveryScrollGuideProcessor extends FlowProcessor {
    private String currentRefreshSource = "";
    private ArrowAnimGuideViewManager guideManager;

    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (z) {
            TypedAction typedAction = (TypedAction) action;
            if (Actions.ACTION_ON_REFRESH_OPERATOR.equals(typedAction.type)) {
                onRefreshOperation((Integer) typedAction.payload);
                return onProcess;
            }
        }
        if (z && Actions.ACTION_ON_LEAVE_PAGE.equals(((TypedAction) action).type)) {
            onLeavePage();
            return onProcess;
        } else if (action instanceof Actions.ScrollDraggingStateAction) {
            onListScroll((Actions.ScrollDraggingStateAction) action);
            return onProcess;
        } else {
            if (z && Actions.ACTION_ON_DESTROY.equals(((TypedAction) action).type)) {
                onDestroy();
            }
            return onProcess;
        }
    }

    @OnRefreshOperatorAction
    private final void onRefreshOperation(Integer operator) {
        if (operator != null) {
            operator.intValue();
            Object refreshSource = getPage().getRefreshSource();
            String refreshSource2 = refreshSource instanceof String ? (String) refreshSource : null;
            if (refreshSource2 == null) {
                refreshSource2 = "";
            }
            if (!(refreshSource2.length() == 0)) {
                this.currentRefreshSource = refreshSource2;
            }
            boolean isAutoRefresh = Intrinsics.areEqual((Object) this.currentRefreshSource, (Object) "4");
            if (operator.intValue() == 4 && isAutoRefresh) {
                showGuideIfNeed();
            }
        }
    }

    @OnLeavePageAction
    private final void onLeavePage() {
        dismissGuide();
    }

    private final void onListScroll(Actions.ScrollDraggingStateAction action) {
        dismissGuide();
    }

    private final void showGuideIfNeed() {
        ArrowGuidePolicy policy = new ArrowGuidePolicy(new GuidePolicyDickCacheImpl("178"));
        boolean isTtsPlaying = false;
        if (MediaRuntime.getContext().calcMiniBarOuter()[0] > 0) {
            isTtsPlaying = true;
        }
        if (!isTtsPlaying && policy.isValid() && policy.canShow()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ArrowAnimGuideViewManager build = new ArrowAnimGuideViewManager.Builder(context).layoutRes(R.layout.feed_discovery_up_guide_view_layout).text(policy.getGuideTitle()).textColorRes(com.baidu.searchbox.feed.biserial.R.color.feed_bi_find_tab_guid_text).bgColorRes(com.baidu.searchbox.feed.biserial.R.color.feed_discovery_guide_bg_color).arrowDrawableRes(R.drawable.feed_discovery_guide_arrow_icon).showPolicy(policy).showDelayTime((long) (policy.getGuideDelayMillis() * 1000)).autoDismissMillis((long) (policy.getGuideDuration() * 1000)).isFadeOut(true).onAttachToParent(new DiscoveryScrollGuideProcessor$showGuideIfNeed$1(this)).onShowFun(DiscoveryScrollGuideProcessor$showGuideIfNeed$2.INSTANCE).onClickListener(new DiscoveryScrollGuideProcessor$$ExternalSyntheticLambda0(this)).build();
            this.guideManager = build;
            if (build != null) {
                build.showGuideIfNeed();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showGuideIfNeed$lambda-0  reason: not valid java name */
    public static final void m18447showGuideIfNeed$lambda0(DiscoveryScrollGuideProcessor this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissGuide();
    }

    /* access modifiers changed from: private */
    public final void registerFontChangeEvent() {
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, new DiscoveryScrollGuideProcessor$$ExternalSyntheticLambda1(this));
        BdEventBus.Companion.getDefault().register(this, TTSPlayerEvent.class, new DiscoveryScrollGuideProcessor$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerFontChangeEvent$lambda-1  reason: not valid java name */
    public static final void m18445registerFontChangeEvent$lambda1(DiscoveryScrollGuideProcessor this$0, FontSizeChangeMessage event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        ArrowAnimGuideViewManager arrowAnimGuideViewManager = this$0.guideManager;
        if (arrowAnimGuideViewManager != null) {
            arrowAnimGuideViewManager.onFontSizeChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerFontChangeEvent$lambda-2  reason: not valid java name */
    public static final void m18446registerFontChangeEvent$lambda2(DiscoveryScrollGuideProcessor this$0, TTSPlayerEvent ttsEvent) {
        ArrowAnimGuideViewManager arrowAnimGuideViewManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsEvent, "ttsEvent");
        if (ttsEvent.ttsPlayerState == 2 && (arrowAnimGuideViewManager = this$0.guideManager) != null) {
            arrowAnimGuideViewManager.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final ScrollGuideAbility getScrollGuideAbility() {
        ScrollGuideAbility scrollGuideAbility = (ScrollGuideAbility) getPage().queryAbility(ScrollGuideAbility.class);
        return scrollGuideAbility == null ? ScrollGuideAbility.Companion.getEMPTY() : scrollGuideAbility;
    }

    private final void dismissGuide() {
        ArrowAnimGuideViewManager arrowAnimGuideViewManager = this.guideManager;
        if (arrowAnimGuideViewManager != null) {
            if (arrowAnimGuideViewManager != null) {
                arrowAnimGuideViewManager.dismiss();
            }
            this.guideManager = null;
        }
    }

    @OnDestroyViewAction
    private final void onDestroy() {
        BdEventBus.Companion.getDefault().unregister(this);
    }
}
