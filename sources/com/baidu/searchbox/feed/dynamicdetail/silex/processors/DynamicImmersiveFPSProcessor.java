package com.baidu.searchbox.feed.dynamicdetail.silex.processors;

import com.baidu.searchbox.feed.apm.fluency.FluencyInfoTracer;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.annotations.OnCreateViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnPauseAction;
import com.baidu.searchbox.feed.flow.annotations.OnResumeAction;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.TypedAction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0003J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000bH\u0003J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\rH\u0003J\b\u0010\u000e\u001a\u00020\u0006H\u0003J\b\u0010\u000f\u001a\u00020\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveFPSProcessor;", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveFlowProcessor;", "()V", "fluencyInfoTracer", "Lcom/baidu/searchbox/feed/apm/fluency/FluencyInfoTracer;", "onCreateView", "", "onScrollDraggingState", "action", "Lcom/baidu/searchbox/feed/flow/Actions$ScrollDraggingStateAction;", "onScrollIdleState", "Lcom/baidu/searchbox/feed/flow/Actions$ScrollIdleStateAction;", "onScrollSettlingState", "Lcom/baidu/searchbox/feed/flow/Actions$ScrollSettlingStateAction;", "onViewPause", "onViewResume", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersiveFPSProcessor.kt */
public final class DynamicImmersiveFPSProcessor extends DynamicImmersiveFlowProcessor {
    private final FluencyInfoTracer fluencyInfoTracer = new FluencyInfoTracer();

    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (z && Actions.ACTION_ON_CREATE_VIEW.equals(((TypedAction) action).type)) {
            onCreateView();
            return onProcess;
        } else if (z && Actions.ACTION_ON_RESUME.equals(((TypedAction) action).type)) {
            onViewResume();
            return onProcess;
        } else if (z && Actions.ACTION_ON_PAUSE.equals(((TypedAction) action).type)) {
            onViewPause();
            return onProcess;
        } else if (action instanceof Actions.ScrollIdleStateAction) {
            onScrollIdleState((Actions.ScrollIdleStateAction) action);
            return onProcess;
        } else if (action instanceof Actions.ScrollDraggingStateAction) {
            onScrollDraggingState((Actions.ScrollDraggingStateAction) action);
            return onProcess;
        } else {
            if (action instanceof Actions.ScrollSettlingStateAction) {
                onScrollSettlingState((Actions.ScrollSettlingStateAction) action);
            }
            return onProcess;
        }
    }

    @OnCreateViewAction
    private final void onCreateView() {
        this.fluencyInfoTracer.init("10030");
    }

    @OnResumeAction
    private final void onViewResume() {
        this.fluencyInfoTracer.onEnterPage();
    }

    @OnPauseAction
    private final void onViewPause() {
        this.fluencyInfoTracer.onLeavePage();
    }

    private final void onScrollIdleState(Actions.ScrollIdleStateAction action) {
        this.fluencyInfoTracer.onListScrollStateChanged(0);
    }

    private final void onScrollDraggingState(Actions.ScrollDraggingStateAction action) {
        this.fluencyInfoTracer.onListScrollStateChanged(1);
    }

    private final void onScrollSettlingState(Actions.ScrollSettlingStateAction action) {
        this.fluencyInfoTracer.onListScrollStateChanged(2);
    }
}
