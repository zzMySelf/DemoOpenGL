package com.baidu.searchbox.feed.flow.impl;

import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.controller.FeedDataManager;
import com.baidu.searchbox.feed.controller.FeedFontSettingManagerKt;
import com.baidu.searchbox.feed.controller.FontSettingInsertScene;
import com.baidu.searchbox.feed.controller.PageViewHelper;
import com.baidu.searchbox.feed.controller.datamanager.FeedPolicyStorage;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.event.FeedMainTabEvent;
import com.baidu.searchbox.feed.event.LoadMoreFeedRequest;
import com.baidu.searchbox.feed.event.RefreshCompletedEvent;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FlowProcessor;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.RefreshablePage;
import com.baidu.searchbox.feed.flow.annotations.OnCreateViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnDestroyViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnHomeStateAction;
import com.baidu.searchbox.feed.flow.annotations.OnPauseAction;
import com.baidu.searchbox.feed.flow.annotations.OnTabStateAction;
import com.baidu.searchbox.feed.flow.annotations.OnUserVisibleHintAction;
import com.baidu.searchbox.feed.flow.assistants.FeedSearchCPageSupernatantAssistant;
import com.baidu.searchbox.feed.flow.assistants.ITemplateAssistant;
import com.baidu.searchbox.feed.flow.assistants.LoadMoreAssistant;
import com.baidu.searchbox.feed.flow.assistants.MuteVideoPlayAssistant;
import com.baidu.searchbox.feed.flow.assistants.PageStateAssistant;
import com.baidu.searchbox.feed.flow.assistants.RefreshAssistant;
import com.baidu.searchbox.feed.flow.assistants.RefreshInfo;
import com.baidu.searchbox.feed.flow.assistants.ShakeEffectAssistant;
import com.baidu.searchbox.feed.flow.assistants.TemplateAssistant;
import com.baidu.searchbox.feed.flow.extension.IHotSearchUnfoldMoreProcessExtension;
import com.baidu.searchbox.feed.flow.extension.LoadMoreConsumer;
import com.baidu.searchbox.feed.flow.ui.ScrollDeciderAbility;
import com.baidu.searchbox.feed.flow.util.ScrollAttachment;
import com.baidu.searchbox.feed.insert.FeedInsertRepository;
import com.baidu.searchbox.feed.listpage.application.command.LoadMorePostProcess;
import com.baidu.searchbox.feed.listpage.application.command.LoadMoreRequest;
import com.baidu.searchbox.feed.listpage.application.command.LoadMoreResultProcess;
import com.baidu.searchbox.feed.listpage.application.usecase.LoadMore;
import com.baidu.searchbox.feed.listpage.domain.Channel;
import com.baidu.searchbox.feed.listpage.domain.LoadMoreResult;
import com.baidu.searchbox.feed.listpage.domain.LoadMoreState;
import com.baidu.searchbox.feed.listpage.domain.LoadingState;
import com.baidu.searchbox.feed.listpage.domain.NormalLoadingState;
import com.baidu.searchbox.feed.listpage.domain.transform.CheckReloadTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.ComposePostTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.DuplicateTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.FeedNewRefreshHisRemindTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.FillDataTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.FontSettingTransFormer;
import com.baidu.searchbox.feed.listpage.domain.transform.RemoveExpiredTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.SearchInsertTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.TimeLineTransformer;
import com.baidu.searchbox.feed.listpage.domain.transform.UpdateRelativePosTransformer;
import com.baidu.searchbox.feed.listpage.infrastructure.LoadMoreMessageProducer;
import com.baidu.searchbox.feed.listpage.infrastructure.OuterServiceImpl;
import com.baidu.searchbox.feed.listpage.infrastructure.ProgressMessages;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.refreshex.ClickRecommendRefreshHelper;
import com.baidu.searchbox.feed.refreshex.LoadMoreClickRecommend;
import com.baidu.searchbox.feed.refreshex.LoadMoreEx;
import com.baidu.searchbox.feed.refreshex.NewRefresh;
import com.baidu.searchbox.feed.refreshex.RefreshRevolutionary;
import com.baidu.searchbox.feed.refreshex.RevolutionaryRefreshStateAction;
import com.baidu.searchbox.feed.template.tplinterface.IFooterView;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.Assistant;
import com.baidu.texas.context.ProcessContext;
import com.baidu.texas.context.TypedAction;
import com.baidu.texas.context.support.ClassId;
import com.baidu.texas.context.support.StringId;
import com.baidu.texas.ddd.DomainEventPublisher;
import com.baidu.texas.ddd.support.jms.MessageListener;
import com.baidu.texas.ddd.support.jms.TopicSubscriber;
import com.baidu.texas.ddd.support.jms.adapter.DomainMessages;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00000\u00000\u0018H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\bH\u0016J\u001a\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\bH\u0016J\"\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0012H\u0003J\b\u00103\u001a\u00020\u0012H\u0003J\u0010\u00104\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u0012H\u0003J\u0010\u00109\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010;\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0003J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010=\u001a\u00020@H\u0003J\b\u0010A\u001a\u00020\u0012H\u0003J\u0010\u0010B\u001a\u00020\u00122\u0006\u0010=\u001a\u00020CH\u0003J\b\u0010D\u001a\u00020\u0012H\u0003J\u0017\u0010E\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u00020\u00122\u0006\u0010=\u001a\u00020IH\u0003J\u0018\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0006H\u0002J\u0010\u0010M\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u0006H\u0002J\u0010\u0010O\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u0006H\u0016J\u0010\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\bH\u0002J\u0010\u0010R\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\bH\u0002J\u0010\u0010S\u001a\u00020\u00122\u0006\u0010=\u001a\u00020@H\u0002J\u001a\u0010T\u001a\u00020\u00122\b\b\u0001\u0010N\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/baidu/searchbox/feed/flow/impl/LoadMoreProcessor;", "Lcom/baidu/searchbox/feed/flow/FlowProcessor;", "Lcom/baidu/searchbox/feed/flow/assistants/LoadMoreAssistant;", "Lcom/baidu/searchbox/feed/listpage/infrastructure/LoadMoreMessageProducer$Callback;", "()V", "footViewState", "", "hasTouched", "", "loadMoreClickRecommend", "Lcom/baidu/searchbox/feed/refreshex/LoadMoreClickRecommend;", "loadingState", "Lcom/baidu/searchbox/feed/listpage/domain/NormalLoadingState;", "subscriber", "Lcom/baidu/texas/ddd/support/jms/TopicSubscriber;", "unSubscriber", "Lcom/baidu/texas/ddd/DomainEventPublisher$Unsubscriber;", "executeClickRecommendLoad", "", "refreshInfo", "Lcom/baidu/searchbox/feed/flow/assistants/RefreshInfo;", "getAssistant", "getFooterViewState", "getId", "Lcom/baidu/texas/context/support/ClassId;", "kotlin.jvm.PlatformType", "getLoadingState", "handleLoadMoreFeedEvent", "event", "Lcom/baidu/searchbox/feed/event/LoadMoreFeedRequest;", "handleLoadingFail", "needToast", "infiniteLoadMoreIfNeed", "result", "Lcom/baidu/searchbox/feed/listpage/domain/LoadMoreResult;", "isClickRecommendLoading", "loadMoreFeeds", "lastFeed", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "isPrefetch", "refreshState", "", "loadMoreIfNeed", "moveY", "", "notifyLoadMoreResult", "statusCode", "onBindContext", "context", "Lcom/baidu/texas/context/ProcessContext;", "onCreateView", "onDestroyView", "onExecuteLoadMoreProcess", "Lcom/baidu/searchbox/feed/listpage/application/command/LoadMorePostProcess;", "onExecuteLoadMoreResult", "Lcom/baidu/searchbox/feed/listpage/application/command/LoadMoreResultProcess;", "onHomeState", "onLoadMoreFailed", "onLoadMoreLoading", "onLoadMoreSuccess", "onPageDispatchTouch", "action", "Lcom/baidu/searchbox/feed/flow/Actions$PageDispatchTouchAction;", "onPageTouch", "Lcom/baidu/searchbox/feed/flow/Actions$PageTouchAction;", "onPause", "onScrolled", "Lcom/baidu/searchbox/feed/flow/Actions$ScrolledAction;", "onTabState", "onUserVisibleHint", "isShowToUser", "(Ljava/lang/Boolean;)V", "onWindowStatusChanged", "Lcom/baidu/searchbox/feed/flow/Actions$ItemViewWindowRelationAction;", "preloadMoreIfNeed", "feedListSize", "lastVisiblePos", "setFooterState", "state", "setFooterViewState", "setOverScrollEnable", "enable", "setPullRefreshEnable", "showFooterIfNeed", "showFooterWhenFailed", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadMoreProcessor.kt */
public final class LoadMoreProcessor extends FlowProcessor implements LoadMoreAssistant, LoadMoreMessageProducer.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ClassId<LoadMoreProcessor> ID = new ClassId<>(LoadMoreProcessor.class);
    private int footViewState;
    private boolean hasTouched;
    private LoadMoreClickRecommend loadMoreClickRecommend;
    private NormalLoadingState loadingState;
    private TopicSubscriber subscriber;
    private DomainEventPublisher.Unsubscriber unSubscriber;

    public static final ClassId<LoadMoreProcessor> getID() {
        return Companion.getID();
    }

    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (z && Actions.ACTION_ON_CREATE_VIEW.equals(((TypedAction) action).type)) {
            onCreateView();
            return onProcess;
        } else if (!z || !Actions.ACTION_ON_PAUSE.equals(((TypedAction) action).type)) {
            if (z) {
                TypedAction typedAction = (TypedAction) action;
                if (Actions.ACTION_ON_USER_VISIBLE_HINT.equals(typedAction.type)) {
                    onUserVisibleHint((Boolean) typedAction.payload);
                    return onProcess;
                }
            }
            if (z && Actions.ACTION_ON_HOME_STATE.equals(((TypedAction) action).type)) {
                onHomeState();
                return onProcess;
            } else if (z && Actions.ACTION_ON_TAB_STATE.equals(((TypedAction) action).type)) {
                onTabState();
                return onProcess;
            } else if (action instanceof Actions.ItemViewWindowRelationAction) {
                onWindowStatusChanged((Actions.ItemViewWindowRelationAction) action);
                return onProcess;
            } else if (z && Actions.ACTION_ON_DESTROY.equals(((TypedAction) action).type)) {
                onDestroyView();
                return onProcess;
            } else if (action instanceof Actions.PageDispatchTouchAction) {
                onPageDispatchTouch((Actions.PageDispatchTouchAction) action);
                return onProcess;
            } else if (action instanceof Actions.PageTouchAction) {
                onPageTouch((Actions.PageTouchAction) action);
                return onProcess;
            } else {
                if (action instanceof Actions.ScrolledAction) {
                    onScrolled((Actions.ScrolledAction) action);
                }
                return onProcess;
            }
        } else {
            onPause();
            return onProcess;
        }
    }

    public void onBindContext(ProcessContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onBindContext(context);
        this.loadingState = new NormalLoadingState(getChannelId(), FeedPolicyStorage.getPersistentPolicy());
    }

    @OnCreateViewAction
    private final void onCreateView() {
        BdEventBus.Companion.getDefault().lazyRegister(this, LoadMoreFeedRequest.class, 1, new LoadMoreProcessor$$ExternalSyntheticLambda1(this));
        LoadMoreMessageProducer.Adapter adapter = new LoadMoreMessageProducer.Adapter(this, getChannelId());
        this.unSubscriber = DomainMessages.livePublisher(LoadMoreMessageProducer.DOMAIN_TOPIC).subscribe(adapter);
        TopicSubscriber $this$onCreateView_u24lambda_u2d1 = ProgressMessages.liveSubscriber(LoadMoreMessageProducer.DOMAIN_TOPIC);
        $this$onCreateView_u24lambda_u2d1.setMessageListener(adapter);
        this.subscriber = $this$onCreateView_u24lambda_u2d1;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m18686onCreateView$lambda0(LoadMoreProcessor this$0, LoadMoreFeedRequest event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.handleLoadMoreFeedEvent(event);
    }

    private final void handleLoadMoreFeedEvent(LoadMoreFeedRequest event) {
        if (Intrinsics.areEqual((Object) getChannelId(), (Object) event.channelId)) {
            List feedList = getDataManager().getCachedFeeds();
            FeedBaseModel lastFeed = null;
            if (feedList != null && feedList.size() > 0) {
                lastFeed = feedList.get(feedList.size() - 1);
            }
            if (TextUtils.isEmpty(event.refreshState)) {
                loadMoreFeeds(lastFeed, event.isPrefech);
                return;
            }
            boolean z = event.isPrefech;
            String str = event.refreshState;
            Intrinsics.checkNotNullExpressionValue(str, "event.refreshState");
            loadMoreFeeds(lastFeed, z, str);
        }
    }

    @OnPauseAction
    private final void onPause() {
        this.hasTouched = false;
    }

    @OnUserVisibleHintAction
    private final void onUserVisibleHint(Boolean isShowToUser) {
        if (Intrinsics.areEqual((Object) isShowToUser, (Object) Boolean.FALSE)) {
            this.hasTouched = false;
        }
    }

    @OnHomeStateAction
    private final void onHomeState() {
        getPage().modifyFooterDisplayStyle(2, true);
    }

    @OnTabStateAction
    private final void onTabState() {
        getPage().modifyFooterDisplayStyle(2, false);
    }

    private final void onWindowStatusChanged(Actions.ItemViewWindowRelationAction action) {
        LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
        if (loadMoreClickRecommend2 != null) {
            loadMoreClickRecommend2.onWindowStatusChanged(action);
        }
    }

    @OnDestroyViewAction
    private final void onDestroyView() {
        BdEventBus.Companion.getDefault().unregister(this);
        DomainEventPublisher.Unsubscriber unsubscriber = this.unSubscriber;
        if (unsubscriber != null) {
            unsubscriber.unsubscribe();
        }
        TopicSubscriber topicSubscriber = this.subscriber;
        if (topicSubscriber != null) {
            topicSubscriber.setMessageListener((MessageListener) null);
        }
    }

    private final void onPageDispatchTouch(Actions.PageDispatchTouchAction action) {
        LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
        if (loadMoreClickRecommend2 != null) {
            loadMoreClickRecommend2.onDispatchPageTouch(action);
        }
        if (!this.hasTouched) {
            this.hasTouched = true;
        }
    }

    private final void onPageTouch(Actions.PageTouchAction action) {
        showFooterIfNeed(action);
        loadMoreIfNeed(action.diffY);
    }

    private final void showFooterIfNeed(Actions.PageTouchAction action) {
        ScrollDeciderAbility scrollDeciderAbility;
        List feedList;
        Channel channel = getDataManager().getChannel();
        if (channel != null && Intrinsics.areEqual((Object) "1", (Object) channel.getChannelId()) && action.diffY < 0.0f) {
            if ((action.offsetY == 0.0f) && (scrollDeciderAbility = (ScrollDeciderAbility) getPage().queryAbility(ScrollDeciderAbility.class)) != null) {
                if ((scrollDeciderAbility.canScrollDown() || scrollDeciderAbility.canScrollUp()) && (feedList = getDataManager().getCachedFeeds()) != null && feedList.size() > 0 && getPage().findLastVisibleItemPosition() == feedList.size() && !getPage().isFooterShowing()) {
                    getPage().setFooterVisibility(0);
                }
            }
        }
    }

    private final void loadMoreIfNeed(float moveY) {
        List it;
        int feedListSize;
        NormalLoadingState normalLoadingState = this.loadingState;
        if (normalLoadingState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingState");
            normalLoadingState = null;
        }
        if (normalLoadingState.isNeedLoading() && ((int) moveY) < 0) {
            int i2 = this.footViewState;
            if ((i2 == 803 || i2 == 0) && getPage().isFooterShowing() && (it = getDataManager().getCachedFeeds()) != null && (feedListSize = it.size()) > 0) {
                loadMoreFeeds(it.get(feedListSize - 1), false);
            }
        }
    }

    private final void onScrolled(Actions.ScrolledAction action) {
        List feedList = getDataManager().getCachedFeeds();
        if (feedList != null && feedList.size() > 0) {
            int feedListSize = feedList.size();
            ScrollAttachment attachment = action.attachment;
            Intrinsics.checkNotNullExpressionValue(attachment, "action.attachment");
            if (!this.hasTouched) {
                return;
            }
            if (attachment.positionChanged || attachment.lastVisiblePosition == feedListSize - 1) {
                preloadMoreIfNeed(feedListSize, attachment.lastVisiblePosition);
                int dy = action.dy;
                boolean isLoadMoreViewVisible = false;
                if (dy > 0) {
                    getPage().setFooterVisibility(0);
                }
                if (getPage().isFooterShowing() && dy > 0) {
                    isLoadMoreViewVisible = true;
                }
                if (isLoadMoreViewVisible) {
                    NormalLoadingState normalLoadingState = this.loadingState;
                    if (normalLoadingState == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingState");
                        normalLoadingState = null;
                    }
                    if (normalLoadingState.isNeedLoading()) {
                        loadMoreFeeds(feedList.get(feedListSize - 1), true);
                    }
                }
            }
        }
    }

    private final void preloadMoreIfNeed(int feedListSize, int lastVisiblePos) {
        if (getDataManager().getFeedListPreLoadPosition() > 0 && lastVisiblePos == feedListSize - getDataManager().getFeedListPreLoadPosition()) {
            NormalLoadingState normalLoadingState = this.loadingState;
            if (normalLoadingState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingState");
                normalLoadingState = null;
            }
            if (normalLoadingState.isNeedLoading()) {
                loadMoreFeeds(getDataManager().getCachedFeeds().get(feedListSize - 1), true);
            }
        }
    }

    public void onLoadMoreLoading(LoadMoreResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        boolean z = false;
        if (RefreshRevolutionary.isNewRefresh(result.refreshState)) {
            setFooterState(806);
            setOverScrollEnable(true);
            setPullRefreshEnable(false);
            capsulesAbility().changeCapsulesState(1);
            getPage().setFooterVisibility(0);
        } else if (ClickRecommendRefreshHelper.isClickRecommendRefresh(result.refreshState)) {
            Assistant query = query(RefreshAssistant.class);
            Intrinsics.checkNotNullExpressionValue(query, "query(RefreshAssistant::class.java)");
            RefreshAssistant refreshAssistant = (RefreshAssistant) query;
            refreshAssistant.setCurrentRefreshSource(result.refreshState);
            refreshAssistant.setUploadRefreshState(result.refreshState);
            getPage().setFooterVisibility(0);
            setFooterState(807);
            setOverScrollEnable(true);
            setPullRefreshEnable(false);
            LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
            if (loadMoreClickRecommend2 != null && loadMoreClickRecommend2.isFromScheme()) {
                z = true;
            }
            if (z) {
                capsulesAbility().changeCapsulesState(1, FeedRuntime.getAppContext().getString(R.string.feed_up_refresh_loading_tips));
            }
        } else {
            setFooterState(801);
            getPage().setFooterVisibility(0);
            if (TextUtils.equals(getChannelId(), "1")) {
                BdEventBus.Companion.getDefault().post(new FeedMainTabEvent(FeedMainTabEvent.CMD_RESTART));
            }
        }
    }

    public void onLoadMoreFailed(LoadMoreResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        boolean needToast = false;
        if (result.state == LoadMoreState.FAIL_EXCEED_SLIDE_LIMIT) {
            setFooterState(804);
            getPage().setFooterVisibility(0);
            TTSRuntime.getInstance().onLoadMoreData(0, (List<IFeedTTSModel>) null);
            String str = result.refreshState;
            Intrinsics.checkNotNullExpressionValue(str, "result.refreshState");
            notifyLoadMoreResult(0, str);
            handleLoadingFail(false);
        } else if (result.state == LoadMoreState.FAIL_NO_NET || result.state == LoadMoreState.FAIL_NET_ERROR || result.state == LoadMoreState.FAIL_OTHER_LOADING) {
            if (RefreshRevolutionary.isNewRefresh(result.refreshState)) {
                FeedUtil.refreshLog("new refresh", "new refresh called failed ui");
                capsulesAbility().changeCapsulesState(2);
                overScrollAbility().cancelWhenOverScroll();
                setOverScrollEnable(false);
                setPullRefreshEnable(true);
                showFooterWhenFailed(803, result);
                getDataManager().clearInsertData();
            } else if (ClickRecommendRefreshHelper.isClickRecommendRefresh(result.refreshState)) {
                FeedUtil.refreshLog("recommend refresh", "recommend refresh called failed ui");
                LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
                if (loadMoreClickRecommend2 != null && loadMoreClickRecommend2.isFromScheme()) {
                    capsulesAbility().hideCapsulesUI();
                    capsulesAbility().changeCapsulesState(2);
                    capsulesAbility().dismissFailCapsules();
                    UniversalToast.makeText(getContext(), R.string.feed_up_refresh_fail_toast).showToast();
                }
                overScrollAbility().cancelWhenOverScroll();
                setOverScrollEnable(false);
                setPullRefreshEnable(true);
                showFooterWhenFailed(803, result);
            } else {
                if (!result.isPrefetch) {
                    UniversalToast.makeText(getContext(), R.string.feed_update_toast_bad_net).showToast();
                }
                showFooterWhenFailed(803, result);
                if (!result.isPrefetch || result.state == LoadMoreState.FAIL_NET_ERROR) {
                    needToast = true;
                }
                handleLoadingFail(needToast);
            }
        } else if (result.state != LoadMoreState.FAIL_NO_CACHE && result.state != LoadMoreState.FAIL_NO_DB) {
        } else {
            if (getDataManager().isReformMode()) {
                showFooterWhenFailed(802, result);
            } else if (result.state == LoadMoreState.FAIL_NO_CACHE) {
                FeedUtil.refreshLog("onLoadMoreFailed", "缓存已全部加载完");
                if (getDataManager().isLoadHistorySwitchOpen() || !getDataManager().isNeverRefreshed()) {
                    showFooterWhenFailed(802, result);
                } else {
                    infiniteLoadMoreIfNeed(result);
                }
            } else if (result.state == LoadMoreState.FAIL_NO_DB) {
                FeedUtil.refreshLog("onLoadMoreFailed", "DB已全部加载完");
                getDataManager().setLoadedLocalDataOnce();
                infiniteLoadMoreIfNeed(result);
            }
        }
    }

    public void onLoadMoreSuccess(LoadMoreResult result) {
        FeedBaseModel firstModel;
        FeedBaseModel firstNormalFeed;
        LoadMoreResult loadMoreResult = result;
        if (loadMoreResult != null) {
            boolean noMore = false;
            for (LoadMoreConsumer extension : getExtensions(LoadMoreConsumer.EP)) {
                if (extension.isNoMoreData(loadMoreResult)) {
                    showFooterWhenFailed(802, loadMoreResult);
                    NormalLoadingState normalLoadingState = this.loadingState;
                    if (normalLoadingState == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingState");
                        normalLoadingState = null;
                    }
                    normalLoadingState.setHasMoreData(false);
                    noMore = true;
                }
            }
            if (!noMore) {
                if (loadMoreResult.state == LoadMoreState.NEW_SUCCESS_ANIMATION_SHOW) {
                    overScrollAbility().cancelWhenOverScroll();
                    setOverScrollEnable(false);
                    getPage().setFooterVisibility(0);
                    ((MuteVideoPlayAssistant) query(MuteVideoPlayAssistant.class)).stop();
                    return;
                }
                setFooterState(0);
                if (ClickRecommendRefreshHelper.isClickRecommendRefresh(loadMoreResult.refreshState)) {
                    LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
                    if (loadMoreClickRecommend2 != null && loadMoreClickRecommend2.isFromScheme()) {
                        getPage().notifyDataSetChanged();
                    } else {
                        getPage().notifyItemRangeChanged(0, getDataManager().getCachedFeeds().size());
                    }
                } else {
                    getPage().notifyDataSetChanged();
                }
                if (loadMoreResult.state == LoadMoreState.SUCCESS_NET) {
                    if (RefreshRevolutionary.isNewRefresh(loadMoreResult.refreshState)) {
                        setPullRefreshEnable(true);
                        PageViewHelper.hideCapsule(getDataManager().getTplStateManager(), capsulesAbility());
                        capsulesAbility().changeCapsulesState(3);
                        if (Intrinsics.areEqual((Object) "1", (Object) getChannelId())) {
                            BdEventBus.Companion.getDefault().post(new FeedMainTabEvent(FeedMainTabEvent.CMD_RESTART));
                        }
                        Assistant query = query(RefreshAssistant.class);
                        Intrinsics.checkNotNullExpressionValue(query, "query(RefreshAssistant::class.java)");
                        RefreshAssistant refreshAssistant = (RefreshAssistant) query;
                        if (loadMoreResult.list != null && loadMoreResult.list.size() > 0) {
                            FeedBaseModel firstModel2 = loadMoreResult.list.get(0);
                            firstModel2.runtimeStatus.isFirstInReform = true;
                            String nid = firstModel2.id;
                            FeedUtil.refreshLog("onLoadMoreSuccess", "原地刷新首条，nid：" + nid);
                            if (FeedFilter.checkNewRemindTemplate(firstModel2) && loadMoreResult.list.size() > 1 && (firstNormalFeed = loadMoreResult.list.get(1)) != null) {
                                firstNormalFeed.runtimeStatus.isFirstInReform = true;
                                FeedUtil.refreshLog("onLoadMoreSuccess", "原地刷新首条为历史条，再取一条，nid：" + firstNormalFeed.id);
                            }
                            new NewRefresh(getPage(), getDataManager()).autoScroll(getAnchor().getTopId(), nid, 0, false, loadMoreResult.refreshState, refreshAssistant.getPullUpScrollValue());
                            getProcessContext().dispatchOnProcess(new RevolutionaryRefreshStateAction(getChannelId(), loadMoreResult.refreshState, 0));
                        }
                        refreshAssistant.setUploadRefreshState("7");
                        refreshAssistant.resetPullUpScrollValue();
                    } else if (ClickRecommendRefreshHelper.isClickRecommendRefresh(loadMoreResult.refreshState)) {
                        setPullRefreshEnable(true);
                        LoadMoreClickRecommend loadMoreClickRecommend3 = this.loadMoreClickRecommend;
                        if (loadMoreClickRecommend3 != null && loadMoreClickRecommend3.isFromScheme()) {
                            PageViewHelper.hideCapsule(getDataManager().getTplStateManager(), capsulesAbility());
                            capsulesAbility().changeCapsulesState(3);
                            if (!(loadMoreResult.list == null || loadMoreResult.list.size() <= 0 || (firstModel = loadMoreResult.list.get(0)) == null)) {
                                getPage().postDelayed(new LoadMoreProcessor$$ExternalSyntheticLambda0(this, firstModel), 0);
                            }
                        }
                        if (Intrinsics.areEqual((Object) "1", (Object) getChannelId())) {
                            BdEventBus.Companion.getDefault().post(new FeedMainTabEvent(FeedMainTabEvent.CMD_RESTART));
                        }
                        RefreshAssistant refreshAssistant2 = (RefreshAssistant) queryOrNull(RefreshAssistant.class);
                        if (refreshAssistant2 != null) {
                            refreshAssistant2.setUploadRefreshState("7");
                        }
                    } else {
                        BdEventBus.Companion.getDefault().post(new RefreshCompletedEvent(1));
                    }
                }
                IFeedTTSModel[] newArray = FeedUtil.toTTSModelArray(loadMoreResult.list);
                IFeedTTSModel[] newArray2 = newArray == null ? new IFeedTTSModel[0] : newArray;
                TTSRuntime.getInstance().onLoadMoreData(1, CollectionsKt.listOf(Arrays.copyOf(newArray2, newArray2.length)));
                String str = loadMoreResult.refreshState;
                Intrinsics.checkNotNullExpressionValue(str, "result.refreshState");
                notifyLoadMoreResult(1, str);
                FeedInsertRepository.INSTANCE.clearPendingData();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadMoreSuccess$lambda-3  reason: not valid java name */
    public static final void m18687onLoadMoreSuccess$lambda3(LoadMoreProcessor this$0, FeedBaseModel $firstModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int pos = this$0.getDataManager().getFeedIndex($firstModel.id);
        if (pos > 0) {
            LoadMoreClickRecommend loadMoreClickRecommend2 = this$0.loadMoreClickRecommend;
            if (loadMoreClickRecommend2 != null && loadMoreClickRecommend2.isFromSchemeAndInsert()) {
                this$0.getPage().scrollToPositionWithOffset(pos, 0);
            } else {
                this$0.getPage().scrollToPosition(pos, true);
            }
        }
    }

    public void onExecuteLoadMoreProcess(LoadMorePostProcess event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ComposePostTransformer composePostTransformer = new ComposePostTransformer();
        NormalLoadingState normalLoadingState = null;
        if (event instanceof LoadMorePostProcess.LoadMoreNetPostProcess) {
            composePostTransformer.addTransformer(new SearchInsertTransformer(getDataManager()));
            composePostTransformer.addTransformer(new DuplicateTransformer(getDataManager().getDataDuplicateProcessor())).addTransformer(new FillDataTransformer());
            if (RefreshRevolutionary.isNewRefresh(event.refreshState)) {
                ComposePostTransformer addTransformer = composePostTransformer.addTransformer(new UpdateRelativePosTransformer());
                String str = event.refreshState;
                Intrinsics.checkNotNullExpressionValue(str, "event.refreshState");
                addTransformer.addTransformer(new FeedNewRefreshHisRemindTransformer(str, getDataManager().getTplStateManager()));
            } else if (ClickRecommendRefreshHelper.isClickRecommendRefresh(event.refreshState)) {
                composePostTransformer.addTransformer(new UpdateRelativePosTransformer());
            }
        } else {
            if (!getDataManager().isReformMode()) {
                composePostTransformer.addTransformer(new RemoveExpiredTransformer());
            }
            composePostTransformer.addTransformer(new CheckReloadTransformer(getDataManager().getDataDuplicateProcessor())).addTransformer(new FontSettingTransFormer(getDataManager().getTplStateManager(), FontSettingInsertScene.LOAD_MORE_FROM_LOCAL, getProcessContext().getUserData(new StringId(FeedFontSettingManagerKt.USER_DATA_FONT_SETTING), null)));
        }
        if (RefreshRevolutionary.isNewRefresh(event.refreshState)) {
            LoadMoreEx loadMoreEx = new LoadMoreEx(getDataManager().getChannel(), getDataManager().getRepo(), ((RefreshAssistant) query(RefreshAssistant.class)).getRefreshPolicy(), new OuterServiceImpl(), new LoadMoreMessageProducer(getChannelId()));
            NormalLoadingState normalLoadingState2 = this.loadingState;
            if (normalLoadingState2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingState");
            } else {
                normalLoadingState = normalLoadingState2;
            }
            loadMoreEx.execute(event, normalLoadingState, composePostTransformer);
        } else if (ClickRecommendRefreshHelper.isClickRecommendRefresh(event.refreshState)) {
            LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
            if (loadMoreClickRecommend2 != null) {
                loadMoreClickRecommend2.execute(event, composePostTransformer);
            }
        } else {
            LoadMore loadMore = new LoadMore(getDataManager().getChannel(), getDataManager().getRepo(), ((RefreshAssistant) query(RefreshAssistant.class)).getRefreshPolicy(), new OuterServiceImpl(), new LoadMoreMessageProducer(getChannelId()));
            NormalLoadingState normalLoadingState3 = this.loadingState;
            if (normalLoadingState3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingState");
            } else {
                normalLoadingState = normalLoadingState3;
            }
            loadMore.execute(event, (LoadingState) normalLoadingState, composePostTransformer);
        }
    }

    public void onExecuteLoadMoreResult(LoadMoreResultProcess event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ComposePostTransformer composePostTransformer = new ComposePostTransformer();
        NormalLoadingState normalLoadingState = null;
        composePostTransformer.addTransformer(new DuplicateTransformer(getDataManager().getDataDuplicateProcessor())).addTransformer(new UpdateRelativePosTransformer()).addTransformer(new FontSettingTransFormer(getDataManager().getTplStateManager(), FontSettingInsertScene.LOAD_MORE_FROM_NET, getProcessContext().getUserData(new StringId(FeedFontSettingManagerKt.USER_DATA_FONT_SETTING), null))).addTransformer(new TimeLineTransformer(getDataManager().getTplStateManager()));
        for (IHotSearchUnfoldMoreProcessExtension extension : getExtensions(IHotSearchUnfoldMoreProcessExtension.EP)) {
            extension.beforeShowFlow(event.list);
        }
        LoadMore loadMore = new LoadMore(getDataManager().getChannel(), getDataManager().getRepo(), ((RefreshAssistant) query(RefreshAssistant.class)).getRefreshPolicy(), new OuterServiceImpl(), new LoadMoreMessageProducer(getChannelId()));
        NormalLoadingState normalLoadingState2 = this.loadingState;
        if (normalLoadingState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingState");
        } else {
            normalLoadingState = normalLoadingState2;
        }
        loadMore.execute(event, (LoadingState) normalLoadingState, composePostTransformer);
        FeedRouter.resolveModelIntent(getContext(), event.list);
    }

    private final void infiniteLoadMoreIfNeed(LoadMoreResult result) {
        List feedList = getDataManager().getCachedFeeds();
        FeedBaseModel lastFeed = null;
        if (feedList != null && feedList.size() > 0) {
            lastFeed = feedList.get(feedList.size() - 1);
        }
        if (!getDataManager().isMainChannel() || !getDataManager().getPolicyWrapper().enableLaunchUp() || lastFeed == null) {
            showFooterWhenFailed(802, result);
            return;
        }
        FeedUtil.refreshLog("infiniteLoadMoreIfNeed", "到底继续加载");
        NormalLoadingState normalLoadingState = this.loadingState;
        if (normalLoadingState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingState");
            normalLoadingState = null;
        }
        normalLoadingState.setHasMoreData(true);
        getDataManager().setRefreshStateAfterBoot(2);
        getDataManager().saveLoadHistorySwitch("0");
        getDataManager().refreshAllIndex();
        loadMoreFeeds(lastFeed, true);
    }

    private final void showFooterWhenFailed(@IFooterView.FooterState int state, LoadMoreResult result) {
        FeedUtil.refreshLog("showFooterWhenFailed", "显示到底Footer");
        setFooterState(state);
        getPage().setFooterVisibility(0);
        getPage().notifyDataSetChanged();
        TTSRuntime.getInstance().onLoadMoreData(0, (List<IFeedTTSModel>) null);
        String str = result.refreshState;
        Intrinsics.checkNotNullExpressionValue(str, "result.refreshState");
        notifyLoadMoreResult(0, str);
    }

    private final void setFooterState(int state) {
        getPage().setFooterState(state);
        this.footViewState = state;
    }

    private final void notifyLoadMoreResult(int statusCode, String refreshState) {
        ShakeEffectAssistant shakeEffectAssistant = (ShakeEffectAssistant) queryOrNull(ShakeEffectAssistant.class);
        if (shakeEffectAssistant != null) {
            shakeEffectAssistant.notifyLoadMoreResult(statusCode, refreshState);
        }
        FeedSearchCPageSupernatantAssistant feedSearchCPageSupernatantAssistant = (FeedSearchCPageSupernatantAssistant) queryOrNull(FeedSearchCPageSupernatantAssistant.class);
        if (feedSearchCPageSupernatantAssistant != null) {
            feedSearchCPageSupernatantAssistant.notifyLoadMoreResult(statusCode, refreshState);
        }
    }

    private final void setOverScrollEnable(boolean enable) {
        overScrollAbility().setEndOverEnable(enable);
        if (enable) {
            getPage().setInsertOffset(FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.feed_load_more_container_height_new));
        } else {
            getPage().setInsertOffset(0);
        }
    }

    private final void setPullRefreshEnable(boolean enable) {
        getPage().setPullRefreshEnable(enable);
    }

    private final void handleLoadingFail(boolean needToast) {
        if (needToast) {
            UniversalToast.makeText(getContext(), R.string.feed_update_toast_bad_net).showToast();
        }
    }

    public NormalLoadingState getLoadingState() {
        NormalLoadingState normalLoadingState = this.loadingState;
        if (normalLoadingState != null) {
            return normalLoadingState;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingState");
        return null;
    }

    public void setFooterViewState(int state) {
        this.footViewState = state;
    }

    public int getFooterViewState() {
        return this.footViewState;
    }

    public void loadMoreFeeds(FeedBaseModel lastFeed, boolean isPrefetch) {
        loadMoreFeeds(lastFeed, isPrefetch, "7");
    }

    public boolean isClickRecommendLoading() {
        LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
        return loadMoreClickRecommend2 != null && loadMoreClickRecommend2.isLoading();
    }

    public void executeClickRecommendLoad(RefreshInfo refreshInfo) {
        Intrinsics.checkNotNullParameter(refreshInfo, "refreshInfo");
        if (refreshInfo.isFromScheme) {
            ((PageStateAssistant) query(PageStateAssistant.class)).resetFlagOfBackFromDetailPage();
            if (isClickRecommendLoading() || ((RefreshAssistant) query(RefreshAssistant.class)).isFloatRefreshing() || getPage().isRefreshing() || ((LoadMoreAssistant) query(LoadMoreAssistant.class)).getLoadingState().isLoadingMore()) {
                return;
            }
        } else if (isClickRecommendLoading()) {
            LoadMoreClickRecommend loadMoreClickRecommend2 = this.loadMoreClickRecommend;
            boolean z = true;
            if (loadMoreClickRecommend2 == null || !loadMoreClickRecommend2.isFromScheme()) {
                z = false;
            }
            if (z) {
                FeedUtil.refreshLog("click recommend refresh", "scheme loading 正在上滑刷新中!");
                LoadMoreClickRecommend loadMoreClickRecommend3 = this.loadMoreClickRecommend;
                if (loadMoreClickRecommend3 != null) {
                    loadMoreClickRecommend3.notifyTemplateResult(0, refreshInfo.getRefreshState(), refreshInfo.clickId);
                    return;
                }
                return;
            }
        }
        if (this.loadMoreClickRecommend == null) {
            RefreshablePage page = getPage();
            Channel channel = getDataManager().getChannel();
            FeedDataManager dataManager = getDataManager();
            NormalLoadingState normalLoadingState = this.loadingState;
            if (normalLoadingState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingState");
                normalLoadingState = null;
            }
            this.loadMoreClickRecommend = new LoadMoreClickRecommend(page, channel, dataManager, normalLoadingState, fakeLoadingAbility(), ((RefreshAssistant) query(RefreshAssistant.class)).getRefreshPolicy(), new OuterServiceImpl(), new LoadMoreMessageProducer(getChannelId()), (ITemplateAssistant) query(TemplateAssistant.class));
        }
        LoadMoreClickRecommend loadMoreClickRecommend4 = this.loadMoreClickRecommend;
        if (loadMoreClickRecommend4 != null) {
            loadMoreClickRecommend4.setFromScheme(refreshInfo.isFromScheme);
        }
        LoadMoreClickRecommend loadMoreClickRecommend5 = this.loadMoreClickRecommend;
        if (loadMoreClickRecommend5 != null) {
            loadMoreClickRecommend5.setDeleteTiming(refreshInfo.deleteTiming);
        }
        LoadMoreClickRecommend loadMoreClickRecommend6 = this.loadMoreClickRecommend;
        if (loadMoreClickRecommend6 != null) {
            loadMoreClickRecommend6.setRefreshType(refreshInfo.refreshType);
        }
        LoadMoreClickRecommend loadMoreClickRecommend7 = this.loadMoreClickRecommend;
        if (loadMoreClickRecommend7 != null) {
            loadMoreClickRecommend7.setRefreshTips(refreshInfo.getReformRefreshTip());
        }
        LoadMoreClickRecommend loadMoreClickRecommend8 = this.loadMoreClickRecommend;
        if (loadMoreClickRecommend8 != null) {
            loadMoreClickRecommend8.execute(refreshInfo);
        }
    }

    private final void loadMoreFeeds(FeedBaseModel lastFeed, boolean isPrefetch, String refreshState) {
        Assistant query = query(RefreshAssistant.class);
        Intrinsics.checkNotNullExpressionValue(query, "query(RefreshAssistant::class.java)");
        RefreshAssistant refreshAssistant = (RefreshAssistant) query;
        if (!refreshAssistant.isFloatRefreshing() && !isClickRecommendLoading()) {
            FeedUtil.refreshLog("loadMoreFeeds", "refresh state:" + refreshState);
            capsulesAbility().dismissFailCapsules();
            refreshAssistant.resetPullUpScrollValue();
            refreshAssistant.setUploadRefreshState(refreshState);
            refreshAssistant.setCurrentRefreshSource(refreshState);
            ((PageStateAssistant) query(PageStateAssistant.class)).resetFlagOfBackFromDetailPage();
            LoadMoreRequest request = new LoadMoreRequest(lastFeed, isPrefetch, refreshState);
            LoadMore loadMore = new LoadMore(getDataManager().getChannel(), getDataManager().getRepo(), refreshAssistant.getRefreshPolicy(), new OuterServiceImpl(), new LoadMoreMessageProducer(getChannelId()));
            NormalLoadingState normalLoadingState = this.loadingState;
            if (normalLoadingState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingState");
                normalLoadingState = null;
            }
            loadMore.execute(request, normalLoadingState);
        }
    }

    public LoadMoreProcessor getAssistant() {
        return this;
    }

    public ClassId<LoadMoreProcessor> getId() {
        return ID;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/flow/impl/LoadMoreProcessor$Companion;", "", "()V", "ID", "Lcom/baidu/texas/context/support/ClassId;", "Lcom/baidu/searchbox/feed/flow/impl/LoadMoreProcessor;", "kotlin.jvm.PlatformType", "getID$annotations", "getID", "()Lcom/baidu/texas/context/support/ClassId;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LoadMoreProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getID$annotations() {
        }

        private Companion() {
        }

        public final ClassId<LoadMoreProcessor> getID() {
            return LoadMoreProcessor.ID;
        }
    }
}
