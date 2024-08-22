package com.baidu.bdtask.service.ubc.model;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/bdtask/service/ubc/model/UBCRegisterTaskInfo;", "Lcom/baidu/bdtask/service/ubc/model/UBCTaskStatusInfo;", "type", "", "taskInfo", "Lcom/baidu/bdtask/model/info/TaskInfo;", "taskInfoStatus", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "errorNo", "", "errorMsg", "(Ljava/lang/String;Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;ILjava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class UBCRegisterTaskInfo extends UBCTaskStatusInfo {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String TASK_REGISTER_COMMON_TYPE = "from_common";
    private static final String TASK_REGISTER_PASSIVE_TYPE = "from_passive";
    private static final String TASK_REGISTER_RECOVERY_TYPE = "from_recovery";
    private static final String TASK_REGISTER_SILENCE_TYPE = "from_silence";
    private final TaskStatus taskInfoStatus;
    private final String type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UBCRegisterTaskInfo(String type2, TaskInfo taskInfo, TaskStatus taskInfoStatus2, int errorNo, String errorMsg) {
        super(taskInfo, taskInfoStatus2, errorNo, errorMsg);
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        Intrinsics.checkParameterIsNotNull(taskInfoStatus2, "taskInfoStatus");
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        this.type = type2;
        this.taskInfoStatus = taskInfoStatus2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UBCRegisterTaskInfo(java.lang.String r7, com.baidu.bdtask.model.info.TaskInfo r8, com.baidu.bdtask.ctrl.model.TaskStatus r9, int r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 8
            if (r13 == 0) goto L_0x000a
            int r10 = r9.getCurStatusCode()
            r4 = r10
            goto L_0x000b
        L_0x000a:
            r4 = r10
        L_0x000b:
            r10 = r12 & 16
            if (r10 == 0) goto L_0x0015
            java.lang.String r11 = r9.getCurStatusCodeMsg()
            r5 = r11
            goto L_0x0016
        L_0x0015:
            r5 = r11
        L_0x0016:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.bdtask.service.ubc.model.UBCRegisterTaskInfo.<init>(java.lang.String, com.baidu.bdtask.model.info.TaskInfo, com.baidu.bdtask.ctrl.model.TaskStatus, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ(\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011J*\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/bdtask/service/ubc/model/UBCRegisterTaskInfo$Companion;", "", "()V", "TASK_REGISTER_COMMON_TYPE", "", "TASK_REGISTER_PASSIVE_TYPE", "TASK_REGISTER_RECOVERY_TYPE", "TASK_REGISTER_SILENCE_TYPE", "withCommonRegisterTaskInfo", "Lcom/baidu/bdtask/service/ubc/model/UBCRegisterTaskInfo;", "taskInfo", "Lcom/baidu/bdtask/model/info/TaskInfo;", "taskInfoStatus", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "withPassiveRegisterTaskInfo", "errorMsg", "errorNo", "", "withRecoveryRegisterTaskInfo", "withSilenceRegisterTaskInfo", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* bridge */ /* synthetic */ UBCRegisterTaskInfo a(a aVar, TaskInfo taskInfo, TaskStatus taskStatus, String str, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = "";
            }
            if ((i3 & 8) != 0) {
                i2 = 0;
            }
            return aVar.a(taskInfo, taskStatus, str, i2);
        }

        public final UBCRegisterTaskInfo a(TaskInfo taskInfo, TaskStatus taskStatus, String str, int i2) {
            Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
            Intrinsics.checkParameterIsNotNull(taskStatus, "taskInfoStatus");
            Intrinsics.checkParameterIsNotNull(str, "errorMsg");
            return new UBCRegisterTaskInfo(UBCRegisterTaskInfo.TASK_REGISTER_RECOVERY_TYPE, taskInfo, taskStatus, i2, str);
        }

        public static /* bridge */ /* synthetic */ UBCRegisterTaskInfo b(a aVar, TaskInfo taskInfo, TaskStatus taskStatus, String str, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = 0;
            }
            return aVar.b(taskInfo, taskStatus, str, i2);
        }

        public final UBCRegisterTaskInfo b(TaskInfo taskInfo, TaskStatus taskStatus, String str, int i2) {
            Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
            Intrinsics.checkParameterIsNotNull(taskStatus, "taskInfoStatus");
            Intrinsics.checkParameterIsNotNull(str, "errorMsg");
            return new UBCRegisterTaskInfo(UBCRegisterTaskInfo.TASK_REGISTER_PASSIVE_TYPE, taskInfo, taskStatus, i2, str);
        }

        public final UBCRegisterTaskInfo a(TaskInfo taskInfo, TaskStatus taskStatus) {
            Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
            Intrinsics.checkParameterIsNotNull(taskStatus, "taskInfoStatus");
            return new UBCRegisterTaskInfo(UBCRegisterTaskInfo.TASK_REGISTER_COMMON_TYPE, taskInfo, taskStatus, 0, (String) null, 24, (DefaultConstructorMarker) null);
        }

        public final UBCRegisterTaskInfo b(TaskInfo taskInfo, TaskStatus taskStatus) {
            Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
            Intrinsics.checkParameterIsNotNull(taskStatus, "taskInfoStatus");
            return new UBCRegisterTaskInfo(UBCRegisterTaskInfo.TASK_REGISTER_SILENCE_TYPE, taskInfo, taskStatus, 0, (String) null, 24, (DefaultConstructorMarker) null);
        }
    }

    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("type", this.type);
        json.put("timestamp", c.f11138a.a());
        return json;
    }
}
