package com.baidu.bdtask.model.response;

import com.baidu.bdtask.model.b;
import com.baidu.bdtask.model.ui.TaskUIBtn;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.bdtask.model.ui.TaskUIProgress;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/bdtask/model/response/TaskResponseModelCreator;", "Lcom/baidu/bdtask/model/ITaskModelCreator;", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "creatorFactory", "Lcom/baidu/bdtask/model/TaskModelCreatorFactory;", "(Lcom/baidu/bdtask/model/TaskModelCreatorFactory;)V", "getKey", "", "getModel", "rawData", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class a extends com.baidu.bdtask.model.a<TaskResponseData> {

    /* renamed from: a  reason: collision with root package name */
    private final b f10954a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(bVar);
        Intrinsics.checkParameterIsNotNull(bVar, "creatorFactory");
        this.f10954a = bVar;
    }

    /* renamed from: b */
    public TaskResponseData a(String str) {
        TaskUIData taskUIData;
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(str2, "rawData");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt(TaskResponseData.keyUiType);
            com.baidu.bdtask.model.a a2 = this.f10954a.a(TaskUIData.key);
            String optString = jSONObject.optString(TaskUIData.key);
            Intrinsics.checkExpressionValueIsNotNull(optString, "responseObj.optString(TaskUIData.key)");
            TaskUIData taskUIData2 = (TaskUIData) a2.a(optString);
            if (taskUIData2 != null) {
                taskUIData = taskUIData2;
            } else {
                taskUIData = new TaskUIData((String) null, (String) null, 0, (String) null, (String) null, (String) null, (TaskUIProgress) null, (TaskUIBtn) null, (TaskUIBtn) null, 0, (String) null, (String) null, FileWatcher.ALL_EVENTS, (DefaultConstructorMarker) null);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("progress");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            int optInt2 = optJSONObject.optInt("total");
            int optInt3 = optJSONObject.optInt("complete");
            boolean optBoolean = optJSONObject.optBoolean("done");
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TaskResponseData.keyNextActive);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            long optLong = optJSONObject2.optLong(NextActive.keyUtil, 0);
            String optString2 = optJSONObject2.optString("taskInfo", "");
            NextSDKConf nextSDKConf = null;
            NextSDKConf nextSDKConf2 = null;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(TaskResponseData.keyNextSDKConf);
            JSONObject optJSONObject4 = optJSONObject3 != null ? optJSONObject3.optJSONObject("rule") : null;
            if (optJSONObject4 != null) {
                nextSDKConf = new NextSDKConf(new NextTaskRule(optJSONObject4.optInt("stay", 0), optJSONObject4.optInt("repeat", 0)));
            }
            TaskProcessData taskProcessData = new TaskProcessData(optInt2, optInt3, optBoolean);
            Intrinsics.checkExpressionValueIsNotNull(optString2, "taskInfo");
            return new TaskResponseData(optInt, taskProcessData, taskUIData, new NextActive(optLong, optString2), nextSDKConf);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new TaskResponseData(0, (TaskProcessData) null, (TaskUIData) null, (NextActive) null, (NextSDKConf) null, 31, (DefaultConstructorMarker) null);
        }
    }

    public String a() {
        return "response";
    }
}
