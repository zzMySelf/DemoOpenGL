package com.baidu.bdtask.model.guide;

import com.baidu.bdtask.model.b;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/bdtask/model/guide/TaskGuideModelCreator;", "Lcom/baidu/bdtask/model/ITaskModelCreator;", "Lcom/baidu/bdtask/model/guide/TaskGuideData;", "creatorFactory", "Lcom/baidu/bdtask/model/TaskModelCreatorFactory;", "(Lcom/baidu/bdtask/model/TaskModelCreatorFactory;)V", "getKey", "", "getModel", "rawData", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class a extends com.baidu.bdtask.model.a<TaskGuideData> {

    /* renamed from: a  reason: collision with root package name */
    private final b f10951a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(bVar);
        Intrinsics.checkParameterIsNotNull(bVar, "creatorFactory");
        this.f10951a = bVar;
    }

    /* renamed from: b */
    public TaskGuideData a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "rawData");
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(TaskResponseData.keyUiType);
            com.baidu.bdtask.model.a a2 = this.f10951a.a(TaskUIData.key);
            String optString = jSONObject.optString(TaskUIData.key);
            Intrinsics.checkExpressionValueIsNotNull(optString, "guide.optString(TaskUIData.key)");
            TaskUIData taskUIData = (TaskUIData) a2.a(optString);
            if (taskUIData != null) {
                return new TaskGuideData(optInt, taskUIData);
            }
            return new TaskGuideData(0, (TaskUIData) null, 3, (DefaultConstructorMarker) null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new TaskGuideData(0, (TaskUIData) null, 3, (DefaultConstructorMarker) null);
        }
    }

    public String a() {
        return "guide";
    }
}
