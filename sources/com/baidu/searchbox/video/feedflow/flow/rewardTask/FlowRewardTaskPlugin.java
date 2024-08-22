package com.baidu.searchbox.video.feedflow.flow.rewardTask;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.taskapi.ITaskComponent;
import com.baidu.searchbox.taskapi.TaskComponent;
import com.baidu.searchbox.taskapi.core.config.TaskConfig;
import com.baidu.searchbox.taskapi.core.config.TaskType;
import com.baidu.searchbox.taskapi.core.strategy.ITaskAnimatorCallback;
import com.baidu.searchbox.taskapi.core.strategy.TaskAnimatorMutexStrategy;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.rewardTask.FlowRewardTaskPlugin$playerComponentListener$2;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.tab.ITabComponentService;
import com.baidu.searchbox.video.feedflow.tab.TabItemCreatorServiceKt;
import com.baidu.searchbox.video.feedflow.ubc.UBC4815;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n*\u0001\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/rewardTask/FlowRewardTaskPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "animCallback", "Lcom/baidu/searchbox/taskapi/core/strategy/ITaskAnimatorCallback;", "curPlayerComponentService", "Lcom/baidu/searchbox/video/feedflow/detail/player/service/IPlayerComponentService;", "handler", "Landroid/os/Handler;", "isPlaying", "", "playerComponentListener", "com/baidu/searchbox/video/feedflow/flow/rewardTask/FlowRewardTaskPlugin$playerComponentListener$2$1", "getPlayerComponentListener", "()Lcom/baidu/searchbox/video/feedflow/flow/rewardTask/FlowRewardTaskPlugin$playerComponentListener$2$1;", "playerComponentListener$delegate", "Lkotlin/Lazy;", "taskComponent", "Lcom/baidu/searchbox/taskapi/ITaskComponent;", "addPlayerComponentListener", "", "getVid", "", "initTaskComponent", "isTaskAvailable", "onAttachToManager", "onCreate", "onDestroy", "onPause", "queryTaskAndStart", "removePlayerComponentListener", "startTask", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowRewardTaskPlugin.kt */
public final class FlowRewardTaskPlugin extends LiveDataPlugin {
    /* access modifiers changed from: private */
    public ITaskAnimatorCallback animCallback;
    private IPlayerComponentService curPlayerComponentService;
    private final Handler handler = new FlowRewardTaskPlugin$handler$1(this, Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean isPlaying;
    private final Lazy playerComponentListener$delegate = LazyKt.lazy(new FlowRewardTaskPlugin$playerComponentListener$2(this));
    /* access modifiers changed from: private */
    public ITaskComponent taskComponent;

    private final FlowRewardTaskPlugin$playerComponentListener$2.AnonymousClass1 getPlayerComponentListener() {
        return (FlowRewardTaskPlugin$playerComponentListener$2.AnonymousClass1) this.playerComponentListener$delegate.getValue();
    }

    public void onCreate() {
        super.onCreate();
        Store<AbsState> store = getStore();
        AbsState absState = null;
        if (!UBCManifestKt.isPageSourceFromFeed(store != null ? store.getState() : null)) {
            Store<AbsState> store2 = getStore();
            if (UBCManifestKt.isPageSourceFromCollection(store2 != null ? store2.getState() : null)) {
                Store<AbsState> store3 = getStore();
                if (store3 != null) {
                    absState = store3.getState();
                }
                if (!UBCManifestKt.isPdSourceFromFeed(absState)) {
                    return;
                }
            } else {
                return;
            }
        }
        initTaskComponent();
    }

    public void onPause() {
        super.onPause();
        ITaskComponent iTaskComponent = this.taskComponent;
        if (iTaskComponent != null) {
            iTaskComponent.pause();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        removePlayerComponentListener();
        ITaskAnimatorCallback it = this.animCallback;
        if (it != null) {
            TaskAnimatorMutexStrategy.INSTANCE.removeAnimator(it);
        }
        ITaskComponent iTaskComponent = this.taskComponent;
        if (iTaskComponent != null) {
            iTaskComponent.destroy();
        }
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    public void onAttachToManager() {
        FlowRewardTaskState $this$onAttachToManager_u24lambda_u2d3;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d3 = (FlowRewardTaskState) store.subscribe((Class<T>) FlowRewardTaskState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d3.getOnItemSelected().observe(this, new FlowRewardTaskPlugin$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d3.getEndShow().observe(this, new FlowRewardTaskPlugin$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-1  reason: not valid java name */
    public static final void m6597onAttachToManager$lambda3$lambda1(FlowRewardTaskPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queryTaskAndStart();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-2  reason: not valid java name */
    public static final void m6598onAttachToManager$lambda3$lambda2(FlowRewardTaskPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TaskAnimatorMutexStrategy.INSTANCE.endAnimator(this$0.animCallback);
    }

    private final void queryTaskAndStart() {
        Message message = Message.obtain();
        message.obj = getVid();
        ITaskComponent iTaskComponent = this.taskComponent;
        if (iTaskComponent != null) {
            iTaskComponent.initCheckTaskIsExistAsync(new FlowRewardTaskPlugin$$ExternalSyntheticLambda4(this, message));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: queryTaskAndStart$lambda-5  reason: not valid java name */
    public static final void m6599queryTaskAndStart$lambda5(FlowRewardTaskPlugin this$0, Message $message, TaskType taskType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (taskType != TaskType.TASK_UNKNOWN) {
            this$0.handler.sendMessage($message);
        }
    }

    /* access modifiers changed from: private */
    public final void startTask() {
        Activity activity = VideoFlowUtilsKt.getActivity(getContext());
        boolean z = false;
        if (!(activity != null && activity.isFinishing())) {
            removePlayerComponentListener();
            this.isPlaying = false;
            ITaskComponent iTaskComponent = this.taskComponent;
            if (iTaskComponent != null) {
                iTaskComponent.pause();
            }
            if (isTaskAvailable()) {
                addPlayerComponentListener();
                IPlayerComponentService iPlayerComponentService = this.curPlayerComponentService;
                if (iPlayerComponentService != null && iPlayerComponentService.isPlayerPlaying()) {
                    z = true;
                }
                if (z) {
                    this.isPlaying = true;
                    ITaskComponent iTaskComponent2 = this.taskComponent;
                    if (iTaskComponent2 != null) {
                        iTaskComponent2.start(getVid());
                    }
                }
            }
        }
    }

    private final void initTaskComponent() {
        TaskConfig config = new TaskConfig.Builder().setGetVideoIsPlay(new FlowRewardTaskPlugin$$ExternalSyntheticLambda0(this)).setTimeoutPause(false).setSource("feed_video_ronghe").setLoginToastText("登录成功！看资讯赚钱").setPageTag(UBC4815.From.FROM_MERGE_VIDEO).setTaskStatusCallback(new FlowRewardTaskPlugin$initTaskComponent$taskStatusListener$1(this)).builder();
        Activity activity = VideoFlowUtilsKt.getActivity(getContext());
        if (activity != null) {
            ITaskComponent createNoMutexComponent = TaskComponent.createNoMutexComponent(activity, config, "724");
            this.taskComponent = createNoMutexComponent;
            if (createNoMutexComponent != null) {
                createNoMutexComponent.init(new FlowRewardTaskPlugin$$ExternalSyntheticLambda1());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initTaskComponent$lambda-6  reason: not valid java name */
    public static final boolean m6595initTaskComponent$lambda6(FlowRewardTaskPlugin this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.isPlaying;
    }

    /* access modifiers changed from: private */
    /* renamed from: initTaskComponent$lambda-7  reason: not valid java name */
    public static final void m6596initTaskComponent$lambda7(TaskType it) {
    }

    private final boolean isTaskAvailable() {
        ITabComponentService iTabComponentService = (ITabComponentService) getManager().getService(ITabComponentService.class);
        String str = null;
        if (!TabItemCreatorServiceKt.isSupportRewardTaskTab(iTabComponentService != null ? iTabComponentService.getCurrentTabId() : null)) {
            return false;
        }
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        ItemModel curItemModel = iFlowComponentService != null ? iFlowComponentService.getCurItemModel() : null;
        if (curItemModel != null) {
            str = curItemModel.getLayout();
        }
        return ItemTypeManifestKt.isSupportRewardTaskItem(str);
    }

    private final void addPlayerComponentListener() {
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        this.curPlayerComponentService = iPlayerComponentService;
        if (iPlayerComponentService != null) {
            iPlayerComponentService.addPlayerComponentListener(getPlayerComponentListener());
        }
    }

    private final void removePlayerComponentListener() {
        IPlayerComponentService iPlayerComponentService = this.curPlayerComponentService;
        if (iPlayerComponentService != null) {
            iPlayerComponentService.removePlayerComponentListener(getPlayerComponentListener());
        }
    }

    /* access modifiers changed from: private */
    public final String getVid() {
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        String videoVid = VideoFlowUBCHelper.INSTANCE.getVideoVid(iFlowComponentService != null ? iFlowComponentService.getCurItemModel() : null);
        return videoVid == null ? "-1" : videoVid;
    }
}
