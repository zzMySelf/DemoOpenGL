package com.baidu.searchbox.feed.dynamicdetail.silex.processors;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.ad.ioc.INadDynamicImmersiveInsertManager;
import com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.annotations.OnCreateViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnDestroyViewAction;
import com.baidu.searchbox.feed.silex.actions.TemplateShowAction;
import com.baidu.searchbox.feed.silex.refresh.action.FeedItemsSuccessAction;
import com.baidu.searchbox.feed.template.FeedAdBaseView;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.TypedAction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0003J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000bH\u0003J\b\u0010\f\u001a\u00020\u0006H\u0003J\b\u0010\r\u001a\u00020\u0006H\u0003J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0012H\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveAdInsertProcessor;", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveFlowProcessor;", "()V", "adInsertManager", "Lcom/baidu/searchbox/feed/ad/ioc/INadDynamicImmersiveInsertManager;", "handlePullSuccess", "", "action", "Lcom/baidu/searchbox/feed/silex/refresh/action/FeedItemsSuccessAction;", "initAdInsertModule", "onBindViewHolder", "Lcom/baidu/searchbox/feed/flow/Actions$BindItemViewAction;", "onCreateView", "onDestroy", "onScrolled", "scrolledAction", "Lcom/baidu/searchbox/feed/flow/Actions$ScrolledAction;", "onTemplateShow", "Lcom/baidu/searchbox/feed/silex/actions/TemplateShowAction;", "IRequestPostParamsListener", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersiveAdInsertProcessor.kt */
public final class DynamicImmersiveAdInsertProcessor extends DynamicImmersiveFlowProcessor {
    private INadDynamicImmersiveInsertManager adInsertManager;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveAdInsertProcessor$IRequestPostParamsListener;", "", "getPostParamsMap", "", "requestMap", "", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicImmersiveAdInsertProcessor.kt */
    public interface IRequestPostParamsListener {
        void getPostParamsMap(Map<String, String> map);
    }

    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (z && Actions.ACTION_ON_CREATE_VIEW.equals(((TypedAction) action).type)) {
            onCreateView();
            return onProcess;
        } else if (action instanceof FeedItemsSuccessAction) {
            handlePullSuccess((FeedItemsSuccessAction) action);
            return onProcess;
        } else if (action instanceof Actions.BindItemViewAction) {
            onBindViewHolder((Actions.BindItemViewAction) action);
            return onProcess;
        } else if (action instanceof TemplateShowAction) {
            onTemplateShow((TemplateShowAction) action);
            return onProcess;
        } else if (action instanceof Actions.ScrolledAction) {
            onScrolled((Actions.ScrolledAction) action);
            return onProcess;
        } else {
            if (z && Actions.ACTION_ON_DESTROY.equals(((TypedAction) action).type)) {
                onDestroy();
            }
            return onProcess;
        }
    }

    @OnCreateViewAction
    private final void onCreateView() {
        initAdInsertModule();
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [java.util.Map] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initAdInsertModule() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.ad.ioc.INadDynamicImmersiveInsertManager r0 = com.baidu.searchbox.feed.FeedRuntime.getNadDynamicImmersiveInsertManager()
            r7.adInsertManager = r0
            com.baidu.searchbox.feed.flow.FeedFlowContext r0 = r7.getProcessContext()
            com.baidu.searchbox.feed.dynamicdetail.silex.action.OnAdInsertManagerInitAction r1 = new com.baidu.searchbox.feed.dynamicdetail.silex.action.OnAdInsertManagerInitAction
            com.baidu.searchbox.feed.ad.ioc.INadDynamicImmersiveInsertManager r2 = r7.adInsertManager
            r1.<init>(r2)
            com.baidu.texas.context.Action r1 = (com.baidu.texas.context.Action) r1
            r0.dispatchOnProcess(r1)
            com.baidu.searchbox.feed.ad.ioc.INadDynamicImmersiveInsertManager r0 = r7.adInsertManager
            if (r0 == 0) goto L_0x0055
            r1 = 0
            com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$callback$1 r2 = new com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$callback$1
            r2.<init>(r7)
            com.baidu.searchbox.feed.listpage.domain.DisplayList r3 = r7.getDisplayList()
            r4 = 0
            if (r3 == 0) goto L_0x002c
            java.util.List r3 = r3.getCachedFeeds()
            goto L_0x002d
        L_0x002c:
            r3 = r4
        L_0x002d:
            java.lang.String r5 = r7.getChannelId()
            r6 = r2
            com.baidu.searchbox.feed.ad.NotifyListChangeCallback r6 = (com.baidu.searchbox.feed.ad.NotifyListChangeCallback) r6
            r0.init(r3, r5, r6)
            com.baidu.searchbox.feed.dynamicdetail.silex.DynamicImmersivePreFetcher r3 = com.baidu.searchbox.feed.dynamicdetail.silex.DynamicImmersivePreFetcher.INSTANCE
            java.util.Map r3 = r3.getRequestParamsMap()
            boolean r5 = r3 instanceof java.util.HashMap
            if (r5 == 0) goto L_0x0044
            r4 = r3
            java.util.HashMap r4 = (java.util.HashMap) r4
        L_0x0044:
            r0.initPostParams(r4)
            com.baidu.searchbox.feed.dynamicdetail.silex.DynamicImmersivePreFetcher r3 = com.baidu.searchbox.feed.dynamicdetail.silex.DynamicImmersivePreFetcher.INSTANCE
            com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$1 r4 = new com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$1
            r4.<init>(r0)
            com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor$IRequestPostParamsListener r4 = (com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor.IRequestPostParamsListener) r4
            r3.setRequestParamsListener(r4)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor.initAdInsertModule():void");
    }

    private final void handlePullSuccess(FeedItemsSuccessAction action) {
        INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager;
        if (action != null && TextUtils.equals(action.getType(), "pull") && (iNadDynamicImmersiveInsertManager = this.adInsertManager) != null) {
            iNadDynamicImmersiveInsertManager.resetState();
        }
    }

    private final void onBindViewHolder(Actions.BindItemViewAction action) {
        INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager;
        if (action != null && (iNadDynamicImmersiveInsertManager = this.adInsertManager) != null) {
            iNadDynamicImmersiveInsertManager.onPositionSelected(action.position);
        }
    }

    private final void onTemplateShow(TemplateShowAction action) {
        INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager;
        if (action != null && !DynamicUtilsKt.isSpecialTpl(action.itemData) && (iNadDynamicImmersiveInsertManager = this.adInsertManager) != null) {
            int i2 = action.itemPosition;
            View view2 = action.itemView;
            iNadDynamicImmersiveInsertManager.saveViewHeight(i2, view2 != null ? view2.getHeight() : 0);
        }
    }

    private final void onScrolled(Actions.ScrolledAction scrolledAction) {
        List<View> $this$forEach$iv = getPage().getCurrentVisibleViewList();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "page.getCurrentVisibleViewList()");
        for (View view2 : $this$forEach$iv) {
            if ((view2 instanceof FeedAdBaseView) && (getPage().getAnchorView() instanceof RecyclerView)) {
                FeedAdBaseView feedAdBaseView = (FeedAdBaseView) view2;
                View anchorView = getPage().getAnchorView();
                if (anchorView != null) {
                    feedAdBaseView.onScroll((RecyclerView) anchorView, scrolledAction.dx, scrolledAction.dy);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                }
            }
        }
    }

    @OnDestroyViewAction
    private final void onDestroy() {
        INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager = this.adInsertManager;
        if (iNadDynamicImmersiveInsertManager != null) {
            iNadDynamicImmersiveInsertManager.destroy();
        }
        this.adInsertManager = null;
    }
}
