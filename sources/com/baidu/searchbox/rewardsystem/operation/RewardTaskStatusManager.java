package com.baidu.searchbox.rewardsystem.operation;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.rewardsystem.components.IRewardOPStatusComponent;
import com.baidu.searchbox.rewardsystem.components.data.OPRewardStatusDataManager;
import com.baidu.searchbox.rewardsystem.components.home.HomePreviewStatus;
import com.baidu.searchbox.rewardsystem.components.status.running.TaskRunningOPComponent;
import com.baidu.searchbox.rewardsystem.config.RewardConfig;
import com.baidu.searchbox.rewardsystem.newtimer.data.TimerDataModel;
import com.baidu.searchbox.rewardsystem.newtimer.view.NormalTimerView;
import com.baidu.searchbox.rewardsystem.operation.base.IRewardTaskStatusManager;
import com.baidu.searchbox.rewardsystem.operation.base.RewardTaskStatusListener;
import com.baidu.searchbox.rewardsystem.repo.RewardTaskRepo;
import com.baidu.searchbox.rewardsystem.status.StatusChangeStrategyManager;
import com.baidu.searchbox.rewardsystem.tips.TipsViewBean;
import com.baidu.searchbox.rewardsystem.utils.RewardDebugUtils;
import com.baidu.searchbox.taskapi.HomeComponentManager;
import com.baidu.searchbox.taskapi.core.strategy.TaskMutexStrategy;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014*\u0002\u001f\"\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\bH\u0017J\u0006\u0010(\u001a\u00020\u001dJ\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002J\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020%J\u0006\u0010-\u001a\u00020%J\b\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\u000e\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0017J\u0010\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u000104J\u0012\u00105\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00106\u001a\u00020\u0014H\u0016J\b\u00107\u001a\u00020\u0014H\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010;\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0018\u0010<\u001a\u00020%2\u0006\u0010*\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0002J&\u0010>\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u00010:2\b\u0010@\u001a\u0004\u0018\u00010:2\b\u0010A\u001a\u0004\u0018\u00010:H\u0007J\u0010\u0010B\u001a\u00020%2\u0006\u00101\u001a\u00020\u0017H\u0016J\u0006\u0010C\u001a\u00020%J\u0010\u0010D\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0010\u0010E\u001a\u00020%2\u0006\u00101\u001a\u00020\u0017H\u0016J\u0006\u0010F\u001a\u00020%J\b\u0010G\u001a\u00020%H\u0002J\u0010\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\bH\u0016J\u0010\u0010J\u001a\u00020%2\u0006\u0010*\u001a\u00020\bH\u0016J\u000e\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020:R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006N"}, d2 = {"Lcom/baidu/searchbox/rewardsystem/operation/RewardTaskStatusManager;", "Lcom/baidu/searchbox/rewardsystem/operation/base/IRewardTaskStatusManager;", "()V", "accountListener", "Lcom/baidu/searchbox/account/IAccountStatusChangedListener;", "accountService", "Lcom/baidu/searchbox/account/BoxAccountManager;", "cacheRunningStatus", "", "getCacheRunningStatus", "()I", "setCacheRunningStatus", "(I)V", "components", "", "Lcom/baidu/searchbox/rewardsystem/components/IRewardOPStatusComponent;", "curStatus", "fairLock", "Ljava/util/concurrent/locks/ReentrantLock;", "isInited", "", "listeners", "", "Lcom/baidu/searchbox/rewardsystem/operation/base/RewardTaskStatusListener;", "requestDataTimes", "statusChangeStrategy", "Lkotlin/Lazy;", "Lcom/baidu/searchbox/rewardsystem/status/StatusChangeStrategyManager;", "statusDataManager", "Lcom/baidu/searchbox/rewardsystem/components/data/OPRewardStatusDataManager;", "taskPassiveTaskCallback", "com/baidu/searchbox/rewardsystem/operation/RewardTaskStatusManager$taskPassiveTaskCallback$1", "Lcom/baidu/searchbox/rewardsystem/operation/RewardTaskStatusManager$taskPassiveTaskCallback$1;", "taskStateCallback", "com/baidu/searchbox/rewardsystem/operation/RewardTaskStatusManager$taskStateCallback$1", "Lcom/baidu/searchbox/rewardsystem/operation/RewardTaskStatusManager$taskStateCallback$1;", "addOPComponent", "", "component", "getCurStatus", "getDataManager", "getRealStatus", "newStatus", "handleUpdateData", "init", "initAccount", "isActive", "isFinished", "isLastTaskStatusListener", "listener", "isOPTask", "taskState", "Lcom/baidu/bdtask/TaskState;", "isOPTaskNull", "isOffline", "isRunning", "offline", "taskActId", "", "onNewTaskRegistered", "onStatusChanged", "oldStatus", "playRewardAndBottomAnim", "type", "assetTotal", "assetTotalPre", "registerTaskStatusListener", "release", "removeOPComponent", "removeTaskStatusListener", "reset", "resetStatus", "setMultiStatus", "times", "setNewStatusChanged", "showNotLoginTipsView", "viewType", "Companion", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardTaskStatusManager.kt */
public final class RewardTaskStatusManager implements IRewardTaskStatusManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<RewardTaskStatusManager> instance = LazyKt.lazy(RewardTaskStatusManager$Companion$instance$1.INSTANCE);
    private static final int maxRequestTimes = 5;
    private static final int taskExpireCode = 301;
    private final IAccountStatusChangedListener accountListener;
    private BoxAccountManager accountService;
    private int cacheRunningStatus;
    private final Set<IRewardOPStatusComponent> components;
    /* access modifiers changed from: private */
    public int curStatus;
    private final ReentrantLock fairLock;
    private volatile boolean isInited;
    private final List<RewardTaskStatusListener> listeners;
    /* access modifiers changed from: private */
    public int requestDataTimes;
    private final Lazy<StatusChangeStrategyManager> statusChangeStrategy;
    private final OPRewardStatusDataManager statusDataManager;
    private final RewardTaskStatusManager$taskPassiveTaskCallback$1 taskPassiveTaskCallback;
    private final RewardTaskStatusManager$taskStateCallback$1 taskStateCallback;

    public /* synthetic */ RewardTaskStatusManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @StableApi
    @JvmStatic
    public static final RewardTaskStatusManager getInstance() {
        return Companion.getInstance();
    }

    private RewardTaskStatusManager() {
        this.curStatus = HomePreviewStatus.INSTANCE.getCacheStatus();
        this.cacheRunningStatus = 5;
        this.listeners = new LinkedList();
        this.components = new HashSet();
        this.fairLock = new ReentrantLock(true);
        this.statusDataManager = new OPRewardStatusDataManager();
        this.statusChangeStrategy = LazyKt.lazy(RewardTaskStatusManager$statusChangeStrategy$1.INSTANCE);
        this.accountListener = new RewardTaskStatusManager$$ExternalSyntheticLambda2(this);
        this.taskPassiveTaskCallback = new RewardTaskStatusManager$taskPassiveTaskCallback$1(this);
        this.taskStateCallback = new RewardTaskStatusManager$taskStateCallback$1(this);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/rewardsystem/operation/RewardTaskStatusManager$Companion;", "", "()V", "instance", "Lkotlin/Lazy;", "Lcom/baidu/searchbox/rewardsystem/operation/RewardTaskStatusManager;", "maxRequestTimes", "", "taskExpireCode", "getInstance", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RewardTaskStatusManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @StableApi
        @JvmStatic
        public final RewardTaskStatusManager getInstance() {
            return (RewardTaskStatusManager) RewardTaskStatusManager.instance.getValue();
        }
    }

    public final int getCacheRunningStatus() {
        return this.cacheRunningStatus;
    }

    public final void setCacheRunningStatus(int i2) {
        this.cacheRunningStatus = i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: accountListener$lambda-0  reason: not valid java name */
    public static final void m2682accountListener$lambda0(RewardTaskStatusManager this$0, boolean oldStatus, boolean newStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TaskDebugUtil.debugLog("【RewardTaskStatusManager】 loginStatusChangedListener callback");
        if (!newStatus) {
            TaskDebugUtil.debugLog("【RewardTaskStatusManager】[退出账号] 开始清除数据");
            this$0.setNewStatusChanged(0);
            TaskMutexStrategy.clearLocalMutexData();
            this$0.resetStatus();
        } else {
            TaskDebugUtil.debugLog("【RewardTaskStatusManager】[登陆账号] start request 【3011】");
            RewardTaskRepo.INSTANCE.request("1");
        }
        if (newStatus && oldStatus) {
            TaskDebugUtil.debugLog("【RewardTaskStatusManager】[切换账号] 开始清除数据");
            TaskMutexStrategy.clearLocalMutexData();
            this$0.resetStatus();
        }
    }

    public final void init() {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            if (!this.isInited) {
                this.isInited = true;
                TaskDebugUtil.debugLog("【RewardTaskStatusManager】【init】");
                BDPTask.INSTANCE.findTaskStateByActionIdAsync("638", this.taskStateCallback);
                Unit unit = Unit.INSTANCE;
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    public final void initAccount() {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            TaskDebugUtil.debugLog("【RewardTaskStatusManager】【initAccount】");
            BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            this.accountService = boxAccountManager;
            if (boxAccountManager != null) {
                boxAccountManager.removeLoginStatusChangedListener(this.accountListener);
            }
            BoxAccountManager boxAccountManager2 = this.accountService;
            if (boxAccountManager2 != null) {
                boxAccountManager2.addLoginStatusChangedListener(this.accountListener);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            lock.unlock();
        }
    }

    public final void release() {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            if (this.isInited) {
                TaskDebugUtil.debugLog("【RewardTaskStatusManager】【release】 ");
                this.isInited = false;
                this.statusDataManager.cleanMultipleToastStatus();
                BoxAccountManager boxAccountManager = this.accountService;
                if (boxAccountManager != null) {
                    boxAccountManager.removeLoginStatusChangedListener(this.accountListener);
                }
                this.listeners.clear();
                this.components.clear();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public final boolean isOPTask(TaskState taskState) {
        if (taskState == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) taskState.getTaskInfo().getActionId(), (Object) "638");
    }

    private final boolean isOPTaskNull(TaskState taskState) {
        TaskInfo taskInfo;
        if (taskState == null || (taskInfo = taskState.getTaskInfo()) == null || taskInfo.getActionId() == null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r4 = r0.getTaskInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNewTaskRegistered(com.baidu.bdtask.TaskState r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "638"
            if (r0 != 0) goto L_0x000b
            com.baidu.bdtask.BDPTask$INSTANCE r2 = com.baidu.bdtask.BDPTask.INSTANCE
            com.baidu.bdtask.TaskState r0 = r2.findTaskStateByActionId(r1)
        L_0x000b:
            boolean r2 = r6.isOPTaskNull(r0)
            r3 = 0
            if (r2 == 0) goto L_0x003a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "【RewardTaskStatusManager】op task is null，so return actionId: "
            java.lang.StringBuilder r2 = r2.append(r4)
            if (r0 == 0) goto L_0x002b
            com.baidu.bdtask.model.info.TaskInfo r4 = r0.getTaskInfo()
            if (r4 == 0) goto L_0x002b
            java.lang.String r4 = r4.getActionId()
            goto L_0x002c
        L_0x002b:
            r4 = r3
        L_0x002c:
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.baidu.searchbox.taskapi.core.util.TaskDebugUtil.debugLog(r2)
            if (r0 != 0) goto L_0x003a
            return
        L_0x003a:
            boolean r2 = r6.isOPTask(r0)
            if (r2 != 0) goto L_0x0085
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "【RewardTaskStatusManager】not current task，update [STATUS_INTERRUPTED] actionId: "
            java.lang.StringBuilder r1 = r1.append(r2)
            if (r0 == 0) goto L_0x0058
            com.baidu.bdtask.model.info.TaskInfo r2 = r0.getTaskInfo()
            if (r2 == 0) goto L_0x0058
            java.lang.String r3 = r2.getActionId()
        L_0x0058:
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.baidu.searchbox.taskapi.core.util.TaskDebugUtil.debugLog(r1)
            int r1 = r6.curStatus
            r6.cacheRunningStatus = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "【RewardTaskStatusManager】【onNewTaskRegistered】 当前任务被打断 curStatus: "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r6.curStatus
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.searchbox.taskapi.core.util.TaskDebugUtil.debugLog(r1)
            r1 = 5
            r6.setNewStatusChanged(r1)
            return
        L_0x0085:
            com.baidu.bdtask.BDPTask$INSTANCE r2 = com.baidu.bdtask.BDPTask.INSTANCE
            com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager$taskPassiveTaskCallback$1 r4 = r6.taskPassiveTaskCallback
            com.baidu.bdtask.callbacks.PassiveTaskCallback r4 = (com.baidu.bdtask.callbacks.PassiveTaskCallback) r4
            r2.registerPassiveTaskListenerWithActionId(r1, r4)
            com.baidu.searchbox.rewardsystem.bdptask.BDPTaskOPBridge r1 = com.baidu.searchbox.rewardsystem.bdptask.BDPTaskOPBridge.INSTANCE
            com.baidu.searchbox.rewardsystem.bdptask.IBDPTask r1 = r1.getBdpTaskCtrl()
            com.baidu.bdtask.TaskState r1 = r1.getCurActiveTaskState()
            if (r1 == 0) goto L_0x009f
            com.baidu.bdtask.model.info.TaskInfo r1 = r1.getTaskInfo()
            goto L_0x00a0
        L_0x009f:
            r1 = r3
        L_0x00a0:
            if (r1 == 0) goto L_0x00b2
            com.baidu.bdtask.model.response.TaskResponseData r2 = r1.getResponse()
            if (r2 == 0) goto L_0x00b2
            com.baidu.bdtask.model.ui.TaskUIData r2 = r2.getUi()
            if (r2 == 0) goto L_0x00b2
            java.lang.String r3 = r2.getExtra()
        L_0x00b2:
            r2 = r3
            com.baidu.searchbox.rewardsystem.components.data.OPRewardStatusDataManager r3 = r6.statusDataManager
            com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager$onNewTaskRegistered$1 r4 = new com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager$onNewTaskRegistered$1
            r4.<init>(r6)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager$onNewTaskRegistered$2 r5 = new com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager$onNewTaskRegistered$2
            r5.<init>(r6)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r3.updateData(r2, r4, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "【RewardTaskStatusManager】init status:"
            java.lang.StringBuilder r3 = r3.append(r4)
            int r4 = r6.getCurStatus()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.baidu.searchbox.taskapi.core.util.TaskDebugUtil.debugLog(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager.onNewTaskRegistered(com.baidu.bdtask.TaskState):void");
    }

    public void registerTaskStatusListener(RewardTaskStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Lock lock = this.fairLock;
        lock.lock();
        try {
            if (!this.listeners.contains(listener)) {
                int i2 = this.curStatus;
                listener.onStatusChanged(i2, i2);
                this.listeners.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public final boolean isLastTaskStatusListener(RewardTaskStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Lock lock = this.fairLock;
        lock.lock();
        try {
            if (this.listeners.size() > 0) {
                List<RewardTaskStatusListener> list = this.listeners;
                return Intrinsics.areEqual((Object) list.get(list.size() - 1), (Object) listener);
            }
            lock.unlock();
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void removeTaskStatusListener(RewardTaskStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Lock lock = this.fairLock;
        lock.lock();
        try {
            Iterator iterator = this.listeners.iterator();
            while (true) {
                if (iterator.hasNext()) {
                    if (Intrinsics.areEqual((Object) iterator.next(), (Object) listener)) {
                        iterator.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public void setNewStatusChanged(int newStatus) {
        Lock lock = this.fairLock;
        lock.lock();
        if (newStatus == 2) {
            lock.unlock();
            return;
        }
        try {
            int temp = getRealStatus(this.curStatus, newStatus);
            TaskDebugUtil.debugLog("【RewardTaskStatusManager】update task status from: " + this.curStatus + " => to: " + newStatus + " get: " + temp);
            int oldStatus = this.curStatus;
            if (temp == oldStatus) {
                TaskDebugUtil.debugLog("【RewardTaskStatusManager】update task status, but no change, so return ");
                return;
            }
            this.curStatus = temp;
            TaskDebugUtil.debugLog("【RewardTaskStatusManager】update task status new status " + this.curStatus);
            onStatusChanged(temp, oldStatus);
            Unit unit = Unit.INSTANCE;
            lock.unlock();
        } finally {
            lock.unlock();
        }
    }

    private final void onStatusChanged(int newStatus, int oldStatus) {
        TaskDebugUtil.debugLog("【RewardTaskStatusManager】onStatusChanged " + newStatus + " listener size:" + this.listeners.size() + " components size:" + this.components.size());
        for (IRewardOPStatusComponent curStatus2 : this.components) {
            curStatus2.setCurStatus(newStatus);
        }
        for (RewardTaskStatusListener onStatusChanged : this.listeners) {
            onStatusChanged.onStatusChanged(newStatus, oldStatus);
        }
        HomePreviewStatus.INSTANCE.syncStatus(newStatus);
        if (newStatus != 0 && HomeComponentManager.INSTANCE.getNotLoginReceive()) {
            TaskDebugUtil.debugLog("【RewardTaskStatusManager】onStatusChanged " + newStatus + "，【红包未领取态】置为false ");
            HomeComponentManager.INSTANCE.setNotLoginReceive(false);
        }
    }

    public final void handleUpdateData() {
        UiThreadUtils.runOnUiThread(new RewardTaskStatusManager$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleUpdateData$lambda-8  reason: not valid java name */
    public static final void m2683handleUpdateData$lambda8(RewardTaskStatusManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TaskDebugUtil.debugLog("【handleUpdateData components size:" + this$0.components.size());
        for (IRewardOPStatusComponent handleUpdateData : this$0.components) {
            handleUpdateData.handleUpdateData();
        }
    }

    @StableApi
    public final void playRewardAndBottomAnim(String type, String assetTotal, String assetTotalPre) {
        TipsViewBean bean = new TipsViewBean();
        TipsViewBean $this$playRewardAndBottomAnim_u24lambda_u2d9 = bean;
        $this$playRewardAndBottomAnim_u24lambda_u2d9.mAssetTotalPre = assetTotalPre;
        $this$playRewardAndBottomAnim_u24lambda_u2d9.mAssetTotal = assetTotal;
        $this$playRewardAndBottomAnim_u24lambda_u2d9.mToastType = type;
        TimerDataModel timerData = new TimerDataModel();
        timerData.setTipsViewBean(bean);
        UiThreadUtils.runOnUiThread(new RewardTaskStatusManager$$ExternalSyntheticLambda0(this, timerData));
    }

    /* access modifiers changed from: private */
    /* renamed from: playRewardAndBottomAnim$lambda-11  reason: not valid java name */
    public static final void m2684playRewardAndBottomAnim$lambda11(RewardTaskStatusManager this$0, TimerDataModel $timerData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($timerData, "$timerData");
        TaskDebugUtil.debugLog("【playRewardAndBottomAnim components size:" + this$0.components.size());
        for (IRewardOPStatusComponent playRewardAndBottomAnim : this$0.components) {
            playRewardAndBottomAnim.playRewardAndBottomAnim($timerData);
        }
    }

    public void addOPComponent(IRewardOPStatusComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        Lock lock = this.fairLock;
        lock.lock();
        try {
            if (!this.components.contains(component)) {
                this.components.add(component);
                if (AppConfig.isDebug()) {
                    RewardDebugUtils.INSTANCE.debug("addOPComponent:" + component + " left:" + this.components.size());
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public void removeOPComponent(IRewardOPStatusComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        Lock lock = this.fairLock;
        lock.lock();
        try {
            Iterator iterator = this.components.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual((Object) iterator.next(), (Object) component)) {
                    iterator.remove();
                    if (AppConfig.isDebug()) {
                        RewardDebugUtils.INSTANCE.debug("removeOPComponent:" + component + ": left:" + this.components.size());
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public void offline(String taskActId) {
        Intrinsics.checkNotNullParameter(taskActId, "taskActId");
        BDPTask.INSTANCE.clearPassiveTaskByActTaskId(taskActId);
        setNewStatusChanged(3);
    }

    public void setMultiStatus(int times) {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            this.statusDataManager.setMultipleTimes(times);
            for (IRewardOPStatusComponent updateMultiReward : this.components) {
                updateMultiReward.updateMultiReward(times);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public boolean isFinished() {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            return getCurStatus() == 4;
        } finally {
            lock.unlock();
        }
    }

    public boolean isOffline() {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            return getCurStatus() == 3;
        } finally {
            lock.unlock();
        }
    }

    public boolean isActive() {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            int curStatus2 = getCurStatus();
            return (curStatus2 == 3 || curStatus2 == 5) ? false : true;
        } finally {
            lock.unlock();
        }
    }

    public boolean isRunning() {
        Lock lock = this.fairLock;
        lock.lock();
        try {
            return RewardConfig.isStatusRunning(getCurStatus());
        } finally {
            lock.unlock();
        }
    }

    private final int getRealStatus(int curStatus2, int newStatus) {
        return this.statusChangeStrategy.getValue().transition(curStatus2, newStatus);
    }

    @StableApi
    public int getCurStatus() {
        int i2 = this.curStatus;
        return getRealStatus(i2, i2);
    }

    public final OPRewardStatusDataManager getDataManager() {
        return this.statusDataManager;
    }

    public final void reset() {
        this.statusDataManager.cleanMultipleToastStatus();
    }

    public final void showNotLoginTipsView(String viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Lock lock = this.fairLock;
        lock.lock();
        try {
            for (IRewardOPStatusComponent showNotLoginTipsView : this.components) {
                showNotLoginTipsView.showNotLoginTipsView(viewType);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    private final void resetStatus() {
        NormalTimerView.Companion.reset();
        TaskRunningOPComponent.Companion.reset();
        TaskFloatShowManager.Companion.getInstance().reset();
    }
}
