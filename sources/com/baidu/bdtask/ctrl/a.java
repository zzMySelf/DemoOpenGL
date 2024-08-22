package com.baidu.bdtask.ctrl;

import android.text.TextUtils;
import com.baidu.bdtask.callbacks.TaskCallback;
import com.baidu.bdtask.ctrl.actions.register.c;
import com.baidu.bdtask.ctrl.model.TaskEnvTag;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextSDKConf;
import com.baidu.bdtask.utils.TaskErrorNoUtils;
import com.baidu.bdtask.utils.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\f"}, d2 = {"Lcom/baidu/bdtask/ctrl/BDPTaskReducer;", "", "()V", "commonValidCheck", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "state", "key", "", "getNotNullState", "action", "Lcom/baidu/bdtask/framework/redux/Action;", "handleAction", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class a {
    public final b a(com.baidu.bdtask.framework.redux.a aVar, b bVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "action");
        com.baidu.bdtask.ctrl.actions.duplicate.a.a aVar2 = null;
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.register.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.register.a) ? null : aVar))) {
            b a2 = a(bVar, aVar);
            com.baidu.bdtask.ctrl.actions.register.a aVar3 = (com.baidu.bdtask.ctrl.actions.register.a) aVar;
            a2.a(aVar3.f());
            a2.a(aVar3.f(), aVar3.g());
            SubTaskState b2 = a2.b(aVar3.c());
            if (b2 != null) {
                b2.setInterceptor(aVar3.h());
                b2.updateStatus(aVar3.d(), Integer.valueOf(aVar3.a()), aVar3.b());
            }
            Unit unit = Unit.INSTANCE;
            return a(a2, aVar3.c());
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (c) (!(aVar instanceof c) ? null : aVar))) {
            b a3 = a(bVar, aVar);
            c cVar = (c) aVar;
            a3.a(cVar.f());
            a3.a(cVar.f(), cVar.g());
            SubTaskState b3 = a3.b(cVar.c());
            if (b3 != null) {
                b3.updateStatus(cVar.d(), Integer.valueOf(cVar.a()), cVar.b());
            }
            Unit unit2 = Unit.INSTANCE;
            return a(a3, cVar.c());
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.b.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.b.a) ? null : aVar))) {
            b a4 = a(bVar, aVar);
            com.baidu.bdtask.ctrl.actions.b.a aVar4 = (com.baidu.bdtask.ctrl.actions.b.a) aVar;
            SubTaskState b4 = a4.b(aVar4.c());
            if (b4 != null) {
                b4.updateStatus(aVar4.d(), Integer.valueOf(aVar4.a()), aVar4.b());
                b4.updateExtraUnRegisterMsg(aVar4.g());
                Unit unit3 = Unit.INSTANCE;
            }
            Unit unit4 = Unit.INSTANCE;
            return a4;
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.interrupt.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.interrupt.a) ? null : aVar))) {
            b a5 = a(bVar, aVar);
            com.baidu.bdtask.ctrl.actions.interrupt.a aVar5 = (com.baidu.bdtask.ctrl.actions.interrupt.a) aVar;
            SubTaskState b5 = a5.b(aVar5.c());
            if (b5 != null) {
                b5.updateStatus(aVar5.d(), Integer.valueOf(aVar5.a()), aVar5.b()).getTaskStatus().setInterruptErrorNo(aVar5.f());
                Unit unit5 = Unit.INSTANCE;
                b5.clearProcess();
                b5.cleanDuplicateId();
                Unit unit6 = Unit.INSTANCE;
            }
            Unit unit7 = Unit.INSTANCE;
            return a5;
        }
        boolean z = false;
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.a.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.a.a) ? null : aVar))) {
            b a6 = a(bVar, aVar);
            com.baidu.bdtask.ctrl.actions.a.a aVar6 = (com.baidu.bdtask.ctrl.actions.a.a) aVar;
            SubTaskState b6 = a6.b(aVar6.c());
            if (b6 != null) {
                b6.updateStatus(aVar6.d(), Integer.valueOf(aVar6.a()), aVar6.b());
                if (b6.getTaskInfo().isPassiveTask() || b6.getTaskInfo().isDaemonTask()) {
                    z = true;
                }
                b6.reset2Running(z);
                Unit unit8 = Unit.INSTANCE;
            }
            Unit unit9 = Unit.INSTANCE;
            return a6;
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.dotask.click.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.dotask.click.a) ? null : aVar))) {
            b a7 = a(bVar, aVar);
            com.baidu.bdtask.ctrl.actions.dotask.click.a aVar7 = (com.baidu.bdtask.ctrl.actions.dotask.click.a) aVar;
            SubTaskState b7 = a7.b(aVar7.c());
            if (b7 != null) {
                b7.updateStatus(aVar7.d(), Integer.valueOf(aVar7.a()), aVar7.b());
                TaskProcess process = b7.getTaskStatus().getProcess();
                TaskStatusRuntime curStatusRuntime = b7.getCurStatusRuntime();
                String b8 = com.baidu.bdtask.utils.c.f11138a.b(aVar7.g());
                curStatusRuntime.setCurTag(b8);
                if (!TextUtils.isEmpty(aVar7.g())) {
                    process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, b8, 1, 0, 4, (Object) null));
                }
                process.addClickNumber();
                if (b7.getTaskInfo().getTaskRule().isNeedUnique()) {
                    process.cacheDuplicateId(aVar7.f());
                }
                Unit unit10 = Unit.INSTANCE;
            }
            Unit unit11 = Unit.INSTANCE;
            return a(a7, aVar7.c());
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.dotask.visit.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.dotask.visit.a) ? null : aVar))) {
            b a8 = a(bVar, aVar);
            com.baidu.bdtask.ctrl.actions.dotask.visit.a aVar8 = (com.baidu.bdtask.ctrl.actions.dotask.visit.a) aVar;
            SubTaskState b9 = a8.b(aVar8.c());
            if (b9 != null) {
                b9.updateStatus(aVar8.d(), Integer.valueOf(aVar8.a()), aVar8.b());
                TaskStatus taskStatus = b9.getTaskStatus();
                TaskProcess process2 = taskStatus.getProcess();
                TaskStatusRuntime curStatusRuntime2 = b9.getCurStatusRuntime();
                if (aVar8.i()) {
                    process2.clearTags();
                    process2.setStayTime(aVar8.f());
                } else {
                    process2.addStayTime(aVar8.f());
                }
                String b10 = com.baidu.bdtask.utils.c.f11138a.b(aVar8.h());
                curStatusRuntime2.setCurTag(b10);
                if (!TextUtils.isEmpty(aVar8.h())) {
                    process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, b10, aVar8.f(), 0, 4, (Object) null));
                }
                taskStatus.getTaskStatusRuntime().setCurDuplicateId(aVar8.g());
                Unit unit12 = Unit.INSTANCE;
            }
            Unit unit13 = Unit.INSTANCE;
            return a(a8, aVar8.c());
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.finishreq.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.finishreq.a) ? null : aVar))) {
            com.baidu.bdtask.ctrl.actions.finishreq.a aVar9 = (com.baidu.bdtask.ctrl.actions.finishreq.a) aVar;
            TaskInfo g2 = aVar9.g();
            NextSDKConf h2 = aVar9.h();
            b a9 = a(bVar, aVar);
            SubTaskState b11 = a9.b(aVar9.c());
            if (b11 != null) {
                if (!TaskErrorNoUtils.INSTANCE.isTaskRequestFailErrorNo(aVar9.a()) || !b11.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                    b11.updateStatus(aVar9.d(), Integer.valueOf(aVar9.a()), aVar9.b());
                    b11.updateTaskInfoByMerge(g2);
                    b11.updateNextSDKConfig(h2);
                    b11.updateTaskInfoWithResponse(aVar9.f());
                    b11.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                    if (b11.getTaskInfo().getTaskRule().isNeedUnique() && b11.getTaskInfo().isVisitAction()) {
                        b11.getTaskStatus().getProcess().cacheDuplicateId(aVar9.i());
                    }
                    b11.clearProcessTags();
                    b11.addExitOnce();
                } else {
                    b11.updateStatus(aVar9.d(), 0, "");
                    b11.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                }
                Unit unit14 = Unit.INSTANCE;
            }
            Unit unit15 = Unit.INSTANCE;
            return a(a9, aVar9.c());
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.duplicate.duplicate.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.duplicate.duplicate.a) ? null : aVar))) {
            b a10 = a(bVar, aVar);
            com.baidu.bdtask.ctrl.actions.duplicate.duplicate.a aVar10 = (com.baidu.bdtask.ctrl.actions.duplicate.duplicate.a) aVar;
            SubTaskState b12 = a10.b(aVar10.c());
            if (b12 != null) {
                b12.updateStatus(aVar10.d(), Integer.valueOf(aVar10.a()), aVar10.b()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                Unit unit16 = Unit.INSTANCE;
                Unit unit17 = Unit.INSTANCE;
            }
            Unit unit18 = Unit.INSTANCE;
            return a10;
        }
        if (Intrinsics.areEqual((Object) aVar, (Object) (com.baidu.bdtask.ctrl.actions.exitstrategy.a) (!(aVar instanceof com.baidu.bdtask.ctrl.actions.exitstrategy.a) ? null : aVar))) {
            b a11 = a(bVar, aVar);
            SubTaskState b13 = a11.b(((com.baidu.bdtask.ctrl.actions.exitstrategy.a) aVar).c());
            if (b13 != null) {
                b13.resetExit();
                Unit unit19 = Unit.INSTANCE;
            }
            Unit unit20 = Unit.INSTANCE;
            return a11;
        }
        if (aVar instanceof com.baidu.bdtask.ctrl.actions.duplicate.a.a) {
            aVar2 = aVar;
        }
        if (!Intrinsics.areEqual((Object) aVar, (Object) aVar2)) {
            return a(bVar, aVar);
        }
        b a12 = a(bVar, aVar);
        com.baidu.bdtask.ctrl.actions.duplicate.a.a aVar11 = (com.baidu.bdtask.ctrl.actions.duplicate.a.a) aVar;
        SubTaskState b14 = a12.b(aVar11.c());
        if (b14 != null) {
            if (b14.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(aVar11.d())) {
                b14.getTaskStatus().getProcess().cacheDuplicateId(aVar11.d());
            }
            Unit unit21 = Unit.INSTANCE;
        }
        Unit unit22 = Unit.INSTANCE;
        return a12;
    }

    private final b a(b bVar, com.baidu.bdtask.framework.redux.a aVar) {
        b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        if (bVar == null || (bVar2 = bVar.a()) == null) {
            bVar2 = new b();
        }
        if (((d) (!(aVar instanceof d) ? null : aVar)) != null) {
            SubTaskState b2 = bVar2.b(((d) aVar).c());
            if (b2 != null) {
                b2.processRuleDataMaxValueFix();
            }
            if (!(b2 == null || (taskStatus = b2.getTaskStatus()) == null || (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) == null)) {
                taskStatusRuntime.setCurAction(aVar);
            }
        }
        return bVar2;
    }

    private final b a(b bVar, String str) {
        SubTaskState b2;
        TaskInfo a2 = bVar.a(str);
        if (a2 == null) {
            return bVar;
        }
        if (com.baidu.bdtask.framework.service.a.f10840a.getTaskCheckInterceptorService().expireTimeCheckEnable(a2.getActionId())) {
            DebugTrace.INSTANCE.debug((Function0<String>) new BDPTaskReducer$commonValidCheck$1(a2));
            if (!d.f11139a.a(a2.getTaskRule().getExpireTime()) && (b2 = bVar.b(str)) != null) {
                b2.updateStatus(22, 103, TaskCallback.ERROR_NO_TASK_EXPIRED_MSG);
                b2.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        DebugTrace.INSTANCE.debug((Function0<String>) new BDPTaskReducer$commonValidCheck$3(a2));
        return bVar;
    }
}
