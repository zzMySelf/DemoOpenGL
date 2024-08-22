package com.baidu.bdtask.service.cache;

import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0016\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/bdtask/service/cache/TaskCacheManager;", "", "()V", "cacheKey", "", "fingerprint", "storageRequestStack", "Lcom/baidu/bdtask/utils/stack/ISafeStack;", "Lkotlin/Function0;", "", "cacheTasks", "state", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "taskInfo", "Lcom/baidu/bdtask/model/info/TaskInfo;", "force", "", "duplicateIdIsValid", "actionId", "id", "getTaskStateCacheSync", "isCacheAble", "removeCache", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10968a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final b f10969e = new b();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f10970b = TaskState.key;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.baidu.bdtask.utils.a.a<Function0<Unit>> f10971c = new com.baidu.bdtask.utils.a.b();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f10972d = "";

    private b() {
    }

    public final boolean a(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return false;
        }
        if (taskInfo.getTaskRule().isNeedPersist() || taskInfo.isPassiveTask()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "actionId"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)     // Catch:{ all -> 0x0040 }
            com.baidu.bdtask.BDPTask$INSTANCE r0 = com.baidu.bdtask.BDPTask.INSTANCE     // Catch:{ all -> 0x0040 }
            com.baidu.bdtask.TaskState r3 = r0.findTaskStateByActionId(r3)     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x003d
            com.baidu.bdtask.model.info.TaskInfo r0 = r3.getTaskInfo()     // Catch:{ all -> 0x0040 }
            com.baidu.bdtask.model.rule.TaskRuleData r0 = r0.getTaskRule()     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.isNeedUnique()     // Catch:{ all -> 0x0040 }
            r1 = 1
            if (r0 == 0) goto L_0x003b
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0040 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x002c
            goto L_0x003b
        L_0x002c:
            com.baidu.bdtask.ctrl.model.TaskStatus r3 = r3.getTaskStatus()     // Catch:{ all -> 0x0040 }
            com.baidu.bdtask.ctrl.model.TaskProcess r3 = r3.getProcess()     // Catch:{ all -> 0x0040 }
            boolean r3 = r3.isContainsInDuplicateIds(r4)     // Catch:{ all -> 0x0040 }
            r3 = r3 ^ r1
            monitor-exit(r2)
            return r3
        L_0x003b:
            monitor-exit(r2)
            return r1
        L_0x003d:
            r3 = 0
            monitor-exit(r2)
            return r3
        L_0x0040:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.bdtask.service.cache.b.a(java.lang.String, java.lang.String):boolean");
    }

    public final void a(com.baidu.bdtask.ctrl.b bVar, TaskInfo taskInfo, boolean z) {
        Intrinsics.checkParameterIsNotNull(bVar, "state");
        DebugTrace.INSTANCE.debug((Function0<String>) new TaskCacheManager$cacheTasks$1(z, bVar));
        if (!z) {
            if (taskInfo == null) {
                return;
            }
            if (!a(taskInfo)) {
                DebugTrace.INSTANCE.debug((Function0<String>) TaskCacheManager$cacheTasks$2.INSTANCE);
                return;
            }
        }
        this.f10971c.b();
        this.f10971c.a(new TaskCacheManager$cacheTasks$3(this, bVar));
        ExecutorUtilsExt.postOnSerial(new C0200b(this), "storageSync");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
    /* renamed from: com.baidu.bdtask.service.cache.b$b  reason: collision with other inner class name */
    static final class C0200b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f10973a;

        C0200b(b bVar) {
            this.f10973a = bVar;
        }

        public final void run() {
            Function0 function0;
            if (!this.f10973a.f10971c.c() && (function0 = (Function0) this.f10973a.f10971c.a()) != null) {
                function0.invoke();
            }
        }
    }

    public final String a() {
        String a2 = com.baidu.bdtask.framework.service.a.f10840a.getCacheService().a(this.f10970b);
        return a2 != null ? a2 : "";
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/bdtask/service/cache/TaskCacheManager$Companion;", "", "()V", "instance", "Lcom/baidu/bdtask/service/cache/TaskCacheManager;", "getInstance", "()Lcom/baidu/bdtask/service/cache/TaskCacheManager;", "maxIdLen", "", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return b.f10969e;
        }
    }
}
