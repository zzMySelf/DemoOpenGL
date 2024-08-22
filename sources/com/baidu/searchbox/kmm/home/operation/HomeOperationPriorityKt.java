package com.baidu.searchbox.kmm.home.operation;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.updateprocessor.HomeOperationPriorityUpdateListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"homeOperationDefaultPriority", "Lcom/baidu/searchbox/kmm/home/operation/HomeOperationPriority;", "getHomeOperationDefaultPriority", "()Lcom/baidu/searchbox/kmm/home/operation/HomeOperationPriority;", "getPriorityByNode", "node", "", "com.baidu.searchbox.kmm.business.home"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeOperationPriority.kt */
public final class HomeOperationPriorityKt {
    private static final HomeOperationPriority homeOperationDefaultPriority = new HomeOperationPriority();

    public static final HomeOperationPriority getHomeOperationDefaultPriority() {
        return homeOperationDefaultPriority;
    }

    public static final HomeOperationPriority getPriorityByNode(String node) {
        Object obj;
        Intrinsics.checkNotNullParameter(node, "node");
        String nodeDataJson = HomeOperationPriorityUpdateListener.Companion.getKv().getString(node, "");
        CharSequence charSequence = nodeDataJson;
        int i2 = 1;
        if (charSequence == null || charSequence.length() == 0) {
            return homeOperationDefaultPriority;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(JsonUtilKt.toJsonObject(nodeDataJson));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        JsonObject priorityObj = (JsonObject) obj;
        if (priorityObj == null) {
            return homeOperationDefaultPriority;
        }
        HomeOperationPriority homeOperationPriority = new HomeOperationPriority();
        HomeOperationPriority $this$getPriorityByNode_u24lambda_u2d1 = homeOperationPriority;
        $this$getPriorityByNode_u24lambda_u2d1.setPriority(JsonUtilKt.getPrimitiveArray(priorityObj, "priority", HomeOperationPriorityKt$getPriorityByNode$1$1.INSTANCE));
        int count = JsonUtilKt.getInt(priorityObj, "showCount", -1);
        if (count >= 0) {
            i2 = count;
        }
        $this$getPriorityByNode_u24lambda_u2d1.setShowCount(i2);
        return homeOperationPriority;
    }
}
