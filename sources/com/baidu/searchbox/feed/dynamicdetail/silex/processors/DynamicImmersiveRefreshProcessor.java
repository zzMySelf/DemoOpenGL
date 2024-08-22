package com.baidu.searchbox.feed.dynamicdetail.silex.processors;

import android.text.TextUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.dynamicdetail.silex.DynamicImmersivePreFetcher;
import com.baidu.searchbox.feed.dynamicdetail.silex.event.DynamicPullRequestCompleteEvent;
import com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FeedFlowContext;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.annotations.OnPauseAction;
import com.baidu.searchbox.feed.flow.annotations.OnRefreshOperatorAction;
import com.baidu.searchbox.feed.flow.assistants.PrefetchAssistant;
import com.baidu.searchbox.feed.flow.util.FlowContextHeldTask;
import com.baidu.searchbox.feed.listpage.domain.DisplayList;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.silex.infrastructure.SilexListRepository;
import com.baidu.searchbox.feed.silex.infrastructure.localdata.policy.DataFeedbackGRManager;
import com.baidu.searchbox.feed.silex.refresh.action.AutoRefreshAction;
import com.baidu.searchbox.feed.silex.refresh.action.FeedItemsSuccessAction;
import com.baidu.searchbox.feed.silex.refresh.action.ListEmptyAction;
import com.baidu.searchbox.feed.silex.refresh.action.ServerFeedsResultAction;
import com.baidu.searchbox.feed.silex.refresh.domain.RefreshState;
import com.baidu.searchbox.feed.silex.refresh.usecase.PullToRefresh;
import com.baidu.searchbox.feed.silex.refresh.usecase.command.CPullFromServer;
import com.baidu.searchbox.feed.silex.refresh.usecase.command.CPullFromServerSuccess;
import com.baidu.searchbox.feed.util.FeedSessionManager;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.Assistant;
import com.baidu.texas.context.Id;
import com.baidu.texas.context.TypedAction;
import com.baidu.texas.context.support.StringId;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0003J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0003J\u0017\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0003¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\r2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0002J\b\u0010 \u001a\u00020\nH\u0003J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\nH\u0003J\u0010\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveRefreshProcessor;", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveFlowProcessor;", "()V", "getAssistant", "Lcom/baidu/texas/context/Assistant;", "getId", "Lcom/baidu/texas/context/Id;", "getNid", "", "handleAutoRefresh", "", "refreshSource", "anim", "", "handleAutoRefreshAction", "autoRefreshAction", "Lcom/baidu/searchbox/feed/silex/refresh/action/AutoRefreshAction;", "handleEmptyFeeds", "handleFeedsFromServer", "action", "Lcom/baidu/searchbox/feed/silex/refresh/action/ServerFeedsResultAction;", "handlePullSuccess", "Lcom/baidu/searchbox/feed/silex/refresh/action/FeedItemsSuccessAction;", "handleRefreshOperator", "operator", "", "(Ljava/lang/Integer;)V", "notifyRefreshFinish", "isFromDB", "newFeeds", "", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "onCreateView", "onPreFetchData", "state", "onViewPause", "pullToRefresh", "Companion", "PreFetchTask", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersiveRefreshProcessor.kt */
public final class DynamicImmersiveRefreshProcessor extends DynamicImmersiveFlowProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Id ID = new StringId(DynamicImmersiveRefreshProcessor.class.getName());

    public static final Id getID() {
        return Companion.getID();
    }

    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (z && Actions.ACTION_ON_CREATE_VIEW.equals(((TypedAction) action).type)) {
            onCreateView();
            return onProcess;
        } else if (z && Actions.ACTION_ON_PAUSE.equals(((TypedAction) action).type)) {
            onViewPause();
            return onProcess;
        } else if (action instanceof FeedItemsSuccessAction) {
            handlePullSuccess((FeedItemsSuccessAction) action);
            return onProcess;
        } else if (action instanceof ServerFeedsResultAction) {
            handleFeedsFromServer((ServerFeedsResultAction) action);
            return onProcess;
        } else {
            if (z) {
                TypedAction typedAction = (TypedAction) action;
                if (Actions.ACTION_ON_REFRESH_OPERATOR.equals(typedAction.type)) {
                    handleRefreshOperator((Integer) typedAction.payload);
                    return onProcess;
                }
            }
            if (action instanceof AutoRefreshAction) {
                handleAutoRefreshAction((AutoRefreshAction) action);
            }
            return onProcess;
        }
    }

    private final String getNid() {
        Map<String, Object> userData = getUserData();
        Object obj = null;
        if (!((userData != null ? userData.get("nid") : null) instanceof String)) {
            return "";
        }
        Map<String, Object> userData2 = getUserData();
        if (userData2 != null) {
            obj = userData2.get("nid");
        }
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getCachedFeeds();
     */
    @com.baidu.searchbox.feed.flow.annotations.OnCreateViewAction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onCreateView() {
        /*
            r8 = this;
            com.baidu.searchbox.feed.listpage.domain.DisplayList r0 = r8.getDisplayList()
            if (r0 == 0) goto L_0x0011
            java.util.List r0 = r0.getCachedFeeds()
            if (r0 == 0) goto L_0x0011
            int r0 = r0.size()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 2
            if (r0 > r1) goto L_0x001d
            com.baidu.searchbox.feed.flow.RefreshablePage r0 = r8.getPage()
            r1 = 1
            r0.setFooterGoneForce(r1)
        L_0x001d:
            com.baidu.searchbox.feed.dynamicdetail.silex.DynamicImmersivePreFetcher r0 = com.baidu.searchbox.feed.dynamicdetail.silex.DynamicImmersivePreFetcher.INSTANCE
            java.lang.String r1 = r8.getNid()
            com.baidu.searchbox.feed.flow.FeedFlowContext r2 = r8.getProcessContext()
            boolean r0 = r0.obtain(r1, r2)
            if (r0 == 0) goto L_0x002e
            return
        L_0x002e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "未执行提前请求逻辑"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r8.getNid()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DynamicImmersiveRefreshProcessor"
            com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt.dynamicOnLineLog(r1, r0)
            com.baidu.searchbox.feed.silex.refresh.usecase.PullToRefresh r0 = new com.baidu.searchbox.feed.silex.refresh.usecase.PullToRefresh
            java.lang.String r3 = r8.getChannelId()
            com.baidu.searchbox.feed.flow.FeedFlowContext r1 = r8.getProcessContext()
            com.baidu.texas.context.PartialActionDispatcher r4 = r1.asWeakPartialActionDispatcher()
            com.baidu.searchbox.feed.flow.FeedFlowContext r1 = r8.getProcessContext()
            com.baidu.searchbox.feed.list.domain.ListRepository r5 = r1.getListRepo()
            com.baidu.searchbox.feed.silex.refresh.domain.RefreshState r6 = r8.getRefreshState()
            com.baidu.searchbox.feed.silex.refresh.domain.PolicyState r7 = r8.getPolicyState()
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            com.baidu.searchbox.feed.silex.refresh.usecase.command.CPullFirstPage r1 = new com.baidu.searchbox.feed.silex.refresh.usecase.command.CPullFirstPage
            r1.<init>()
            r0.execute((com.baidu.searchbox.feed.silex.refresh.usecase.command.CPullFirstPage) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveRefreshProcessor.onCreateView():void");
    }

    @OnPauseAction
    private final void onViewPause() {
        SilexListRepository silexListRepository;
        DataFeedbackGRManager feedbackGRManager;
        if ((getProcessContext().getListRepo() instanceof SilexListRepository) && (silexListRepository = (SilexListRepository) getProcessContext().getListRepo()) != null && (feedbackGRManager = silexListRepository.getFeedbackGRManager()) != null) {
            feedbackGRManager.storage();
        }
    }

    public Assistant getAssistant() {
        return new DynamicImmersiveRefreshProcessor$getAssistant$1(this);
    }

    private final void handlePullSuccess(FeedItemsSuccessAction action) {
        if (action != null && TextUtils.equals(action.getType(), "pull")) {
            if (action.getFeeds() == null || action.getFeeds().size() <= 0) {
                handleEmptyFeeds();
            } else {
                getPage().setFooterGoneForce(false);
                notifyRefreshFinish(action.isFromDB(), action.getFeeds());
                getPage().notifyDataSetChanged();
                getPage().postDelayed(new PreFetchTask(this, getProcessContext()), 100);
            }
            DynamicImmersivePreFetcher.INSTANCE.clearRecord();
        }
    }

    private final void handleFeedsFromServer(ServerFeedsResultAction action) {
        List<FeedBaseModel> cachedFeeds;
        if (action != null && TextUtils.equals(action.getType(), "pull")) {
            BdEventBus.Companion.getDefault().post(new DynamicPullRequestCompleteEvent(action.getFeedFlowModel()));
            FeedFlowModel feedFlowModel = action.getFeedFlowModel();
            if (Intrinsics.areEqual((Object) feedFlowModel != null ? feedFlowModel.error : null, (Object) DynamicUtilsKt.REQUEST_DELETE_ERROR_CODE)) {
                DisplayList displayList = getDisplayList();
                if (!(displayList == null || (cachedFeeds = displayList.getCachedFeeds()) == null)) {
                    cachedFeeds.clear();
                }
                getPage().notifyDataSetChanged();
                DynamicUtilsKt.dynamicOnLineLog("DynamicImmersiveRefreshProcessor", "资源被删除" + getNid());
            } else if (!action.isSuccess() || action.getFeedFlowModel() == null) {
                DynamicUtilsKt.dynamicOnLineLog("DynamicImmersiveRefreshProcessor", "请求失败：" + action.isSuccess());
                handleEmptyFeeds();
            } else {
                List newFeeds = action.getFeedFlowModel().feedBaseModelList;
                if (newFeeds == null || newFeeds.isEmpty()) {
                    handleEmptyFeeds();
                    return;
                }
                DynamicUtilsKt.dynamicOnLineLog("DynamicImmersiveRefreshProcessor", "请求到了数据: " + newFeeds.size());
                new PullToRefresh(getChannelId(), getProcessContext().asWeakPartialActionDispatcher(), getProcessContext().getListRepo(), getRefreshState(), getPolicyState()).execute(new CPullFromServerSuccess(action.getFeedFlowModel()));
            }
        }
    }

    private final void handleEmptyFeeds() {
        notifyRefreshFinish(false, (List<? extends FeedBaseModel>) null);
    }

    @OnRefreshOperatorAction
    private final void handleRefreshOperator(Integer operator) {
        String str;
        if (operator != null && operator.intValue() == 1) {
            Object refreshSource = getPage().getRefreshSource();
            if (refreshSource != null) {
                String refreshSource2 = (String) refreshSource;
                if (TextUtils.isEmpty(refreshSource2)) {
                    RefreshState refreshState = getRefreshState();
                    Intrinsics.checkNotNull(refreshState);
                    if (refreshState.isHomeState()) {
                        str = "5";
                    } else {
                        str = "4";
                    }
                    refreshSource2 = str;
                }
                pullToRefresh(refreshSource2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    private final void pullToRefresh(String refreshSource) {
        RefreshState refreshState = getRefreshState();
        if (refreshState != null) {
            refreshState.setCurRefreshSource(refreshSource);
        }
        new PullToRefresh(getChannelId(), getProcessContext().asWeakPartialActionDispatcher(), getProcessContext().getListRepo(), getRefreshState(), getPolicyState()).execute(new CPullFromServer(refreshSource));
    }

    private final void notifyRefreshFinish(boolean isFromDB, List<? extends FeedBaseModel> newFeeds) {
        List<FeedBaseModel> cachedFeeds;
        boolean isNeedShowTip = false;
        if (NetWorkUtils.isNetworkConnected() || isFromDB) {
            isNeedShowTip = true;
            if (!isFromDB) {
                getPage().setRefreshSource("");
            }
        } else {
            getPage().toastNetErrorIfNoEmptyView();
        }
        getPage().postDelayed(new DynamicImmersiveRefreshProcessor$$ExternalSyntheticLambda0(this, newFeeds, isNeedShowTip), 0);
        DisplayList displayList = getDisplayList();
        Integer num = null;
        if ((displayList != null ? displayList.getCachedFeeds() : null) != null) {
            DisplayList displayList2 = getDisplayList();
            if (!(displayList2 == null || (cachedFeeds = displayList2.getCachedFeeds()) == null)) {
                num = Integer.valueOf(cachedFeeds.size());
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() > 0) {
                getPage().hideEmptyView();
                return;
            }
        }
        getProcessContext().dispatchOnProcess(new ListEmptyAction());
    }

    /* access modifiers changed from: private */
    /* renamed from: notifyRefreshFinish$lambda-0  reason: not valid java name */
    public static final void m18651notifyRefreshFinish$lambda0(DynamicImmersiveRefreshProcessor this$0, List $newFeeds, boolean $showFlag) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPage().onPullDownRefreshComplete($newFeeds != null ? $newFeeds.size() : 0, $showFlag);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveRefreshProcessor$PreFetchTask;", "Lcom/baidu/searchbox/feed/flow/util/FlowContextHeldTask;", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveRefreshProcessor;", "pullToRefreshProcessor", "flowContext", "Lcom/baidu/searchbox/feed/flow/FeedFlowContext;", "(Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveRefreshProcessor;Lcom/baidu/searchbox/feed/flow/FeedFlowContext;)V", "run", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicImmersiveRefreshProcessor.kt */
    public static final class PreFetchTask extends FlowContextHeldTask<DynamicImmersiveRefreshProcessor> {
        public PreFetchTask(DynamicImmersiveRefreshProcessor pullToRefreshProcessor, FeedFlowContext flowContext) {
            super(pullToRefreshProcessor, flowContext);
        }

        /* access modifiers changed from: protected */
        public void run(DynamicImmersiveRefreshProcessor pullToRefreshProcessor, FeedFlowContext flowContext) {
            Intrinsics.checkNotNullParameter(pullToRefreshProcessor, "pullToRefreshProcessor");
            Intrinsics.checkNotNullParameter(flowContext, "flowContext");
            pullToRefreshProcessor.onPreFetchData(0);
        }
    }

    private final void handleAutoRefreshAction(AutoRefreshAction autoRefreshAction) {
        String refreshSource = autoRefreshAction.getRefreshSource();
        Intrinsics.checkNotNullExpressionValue(refreshSource, "autoRefreshAction.refreshSource");
        handleAutoRefresh(refreshSource, false);
    }

    private final void handleAutoRefresh(String refreshSource, boolean anim) {
        if (Intrinsics.areEqual((Object) refreshSource, (Object) "6")) {
            FeedSessionManager.getInstance().clearSessionRefreshCountByTabId(getChannelId());
        }
        getPage().postDelayed(new DynamicImmersiveRefreshProcessor$$ExternalSyntheticLambda1(anim, this, refreshSource), 150);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleAutoRefresh$lambda-1  reason: not valid java name */
    public static final void m18650handleAutoRefresh$lambda1(boolean $anim, DynamicImmersiveRefreshProcessor this$0, String $refreshSource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($refreshSource, "$refreshSource");
        if (!$anim) {
            this$0.pullToRefresh($refreshSource);
        } else if (!this$0.getPage().autoRefresh($refreshSource, true, true) && this$0.getPage().isRefreshing()) {
            this$0.pullToRefresh($refreshSource);
        }
    }

    /* access modifiers changed from: private */
    public final void onPreFetchData(int state) {
        ((PrefetchAssistant) query(PrefetchAssistant.class)).onPrefetchData(false, state, getPage().findFirstVisibleItemPosition(), getPage().findLastVisibleItemPosition() + 1);
    }

    public Id getId() {
        return ID;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveRefreshProcessor$Companion;", "", "()V", "ID", "Lcom/baidu/texas/context/Id;", "getID$annotations", "getID", "()Lcom/baidu/texas/context/Id;", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicImmersiveRefreshProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getID$annotations() {
        }

        private Companion() {
        }

        public final Id getID() {
            return DynamicImmersiveRefreshProcessor.ID;
        }
    }
}
