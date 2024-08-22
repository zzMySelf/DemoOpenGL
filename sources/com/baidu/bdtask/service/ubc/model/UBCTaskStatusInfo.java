package com.baidu.bdtask.service.ubc.model;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.swan.apps.impl.inlinewidget.video.widget.SwanInlineBaseVideoWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/bdtask/service/ubc/model/UBCTaskStatusInfo;", "Lcom/baidu/bdtask/model/ITaskModelData;", "taskInfo", "Lcom/baidu/bdtask/model/info/TaskInfo;", "taskInfoStatus", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "errorNo", "", "errorMsg", "", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;ILjava/lang/String;)V", "interruptErrorNo", "statusCode", "toJson", "Lorg/json/JSONObject;", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public class UBCTaskStatusInfo implements ITaskModelData {
    private final String errorMsg;
    private final int errorNo;
    private final int interruptErrorNo;
    private final int statusCode;
    private final TaskInfo taskInfo;
    private final TaskStatus taskInfoStatus;

    public UBCTaskStatusInfo(TaskInfo taskInfo2, TaskStatus taskInfoStatus2, int errorNo2, String errorMsg2) {
        Intrinsics.checkParameterIsNotNull(taskInfo2, "taskInfo");
        Intrinsics.checkParameterIsNotNull(taskInfoStatus2, "taskInfoStatus");
        Intrinsics.checkParameterIsNotNull(errorMsg2, "errorMsg");
        this.taskInfo = taskInfo2;
        this.taskInfoStatus = taskInfoStatus2;
        this.errorNo = errorNo2;
        this.errorMsg = errorMsg2;
        this.statusCode = taskInfoStatus2.getCurStatus();
        this.interruptErrorNo = taskInfoStatus2.getInterruptErrorNo();
    }

    public ITaskModelData deepCopy() {
        return ITaskModelData.DefaultImpls.deepCopy(this);
    }

    public boolean isEmpty() {
        return ITaskModelData.DefaultImpls.isEmpty(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UBCTaskStatusInfo(TaskInfo taskInfo2, TaskStatus taskStatus, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(taskInfo2, taskStatus, (i3 & 4) != 0 ? taskStatus.getCurStatusCode() : i2, (i3 & 8) != 0 ? taskStatus.getCurStatusCodeMsg() : str);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("statusCode", this.statusCode);
        jSONObject.put(SwanInlineBaseVideoWidget.UbcConstants.EXT_KEY_ERROR_NO, this.errorNo);
        jSONObject.put("msg", this.errorMsg);
        jSONObject.put("taskInfo", new UBCTaskInfo(this.taskInfo, this.taskInfoStatus).toJson());
        int i2 = this.interruptErrorNo;
        if (i2 != 0) {
            jSONObject.put(TaskStatus.keyInterruptErrorNo, i2);
        }
        if (this.taskInfoStatus.isFinished()) {
            jSONObject.put("progress", this.taskInfo.getResponse().getProcessData().toJson());
        }
        return jSONObject;
    }
}
