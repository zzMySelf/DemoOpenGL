package com.baidu.assistant.res.update.cloudcontrol.commands;

import com.baidu.assistant.res.update.cloudcontrol.configs.OperateResCloudConfig;
import com.baidu.assistant.res.update.models.OperateResData;
import com.baidu.assistant.res.update.models.OperateResItem;
import com.baidu.assistant.res.update.utils.DownloadLog;
import com.baidu.searchbox.config.AppConfig;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/assistant/res/update/cloudcontrol/commands/OperateResCommandImp;", "Lcom/baidu/assistant/res/update/cloudcontrol/commands/AbsBaseCommandImp;", "()V", "getActionName", "", "getLogTag", "handleCloudData", "", "actionData", "Lorg/json/JSONObject;", "syncLocalOperateResData", "operateResData", "Lcom/baidu/assistant/res/update/models/OperateResData;", "lib-assistant-update_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OperateResCommandImp.kt */
public final class OperateResCommandImp extends AbsBaseCommandImp {
    public String getLogTag() {
        String simpleName = OperateResCommandImp.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "OperateResCommandImp::class.java.simpleName");
        return simpleName;
    }

    public String getActionName() {
        return OperateResCloudConfig.ACTION_OPERATE_RES;
    }

    public void handleCloudData(JSONObject actionData) {
        try {
            DownloadLog.INSTANCE.i(getLogTag(), "handleCloudData " + actionData);
            if (actionData == null) {
                OperateResCloudConfig.INSTANCE.saveOperateResData((OperateResData) null);
                return;
            }
            OperateResData operateResData = (OperateResData) new Gson().fromJson(actionData.toString(), OperateResData.class);
            if (operateResData != null) {
                syncLocalOperateResData(operateResData);
            }
            DownloadLog.INSTANCE.i(getLogTag(), "handleCloudData saveOperateResData " + operateResData);
            OperateResCloudConfig.INSTANCE.saveOperateResData(operateResData);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    private final void syncLocalOperateResData(OperateResData operateResData) {
        Map destination$iv$iv;
        String str;
        OperateResItem operateResItem;
        List<OperateResItem> resList;
        List $this$syncLocalOperateResData_u24lambda_u2d3 = operateResData.getResList();
        if ($this$syncLocalOperateResData_u24lambda_u2d3 != null) {
            OperateResData localOperateResData = OperateResCloudConfig.INSTANCE.getOperateResData();
            DownloadLog.INSTANCE.i(getLogTag(), "syncLocalOperateResData localOperateResData " + localOperateResData);
            if (localOperateResData == null || (resList = localOperateResData.getResList()) == null) {
                destination$iv$iv = null;
            } else {
                Iterable $this$associateBy$iv = resList;
                destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16));
                for (Object element$iv$iv : $this$associateBy$iv) {
                    destination$iv$iv.put(((OperateResItem) element$iv$iv).getId(), (OperateResItem) element$iv$iv);
                }
            }
            Map localOperateResMap = destination$iv$iv;
            for (OperateResItem it : $this$syncLocalOperateResData_u24lambda_u2d3) {
                if (localOperateResMap == null || (operateResItem = (OperateResItem) localOperateResMap.get(it.getId())) == null || (str = operateResItem.getLocalVersion()) == null) {
                    str = "0";
                }
                it.setLocalVersion(str);
            }
        }
    }
}
