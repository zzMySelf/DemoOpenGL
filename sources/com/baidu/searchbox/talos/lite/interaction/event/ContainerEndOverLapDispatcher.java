package com.baidu.searchbox.talos.lite.interaction.event;

import com.baidu.searchbox.talos.lite.IAction;
import com.baidu.searchbox.talos.lite.interaction.action.ActionUtilsKt;
import com.baidu.searchbox.talos.lite.utils.TalosLiteConstantsKt;
import com.baidu.swan.apps.textarea.info.TextAreaCallbackInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0002R6\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bj\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R:\u0010\u0010\u001a.\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\bj\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u0001`\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/talos/lite/interaction/event/ContainerEndOverLapDispatcher;", "Lcom/baidu/searchbox/talos/lite/interaction/event/ITalosLiteEventDispatcher;", "rootViewTag", "", "eventName", "", "(JLjava/lang/String;)V", "actionMap", "Ljava/util/LinkedHashMap;", "", "", "Lcom/baidu/searchbox/talos/lite/IAction;", "Lkotlin/collections/LinkedHashMap;", "isActionsNeedSort", "", "scopeId", "sortedActionMap", "addAction", "", "status", "action", "addActions", "eventActionJson", "Lorg/json/JSONObject;", "dispatch", "viewTag", "paramsJson", "getEventName", "getRootViewTag", "removeAction", "sortActionsIfNeed", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContainerEndOverLapDispatcher.kt */
public final class ContainerEndOverLapDispatcher implements ITalosLiteEventDispatcher {
    private final LinkedHashMap<Double, List<IAction>> actionMap = new LinkedHashMap<>();
    private final String eventName;
    private boolean isActionsNeedSort;
    private final long rootViewTag;
    private long scopeId = -1;
    private LinkedHashMap<Double, List<IAction>> sortedActionMap;

    public ContainerEndOverLapDispatcher(long rootViewTag2, String eventName2) {
        Intrinsics.checkNotNullParameter(eventName2, TextAreaCallbackInfo.EVENT_NAME_KEY);
        this.rootViewTag = rootViewTag2;
        this.eventName = eventName2;
    }

    public String getEventName() {
        return this.eventName;
    }

    public long getRootViewTag() {
        return this.rootViewTag;
    }

    public void addActions(JSONObject eventActionJson) {
        if (eventActionJson != null) {
            double status = eventActionJson.optDouble("status");
            this.scopeId = eventActionJson.optLong(TalosLiteConstantsKt.KEY_SCOPE_ID, -1);
            JSONArray actions = eventActionJson.optJSONArray(TalosLiteConstantsKt.KEY_ACTIONS);
            if (actions != null) {
                int length = actions.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject actionItem = actions.optJSONObject(i2);
                    if (actionItem != null) {
                        Intrinsics.checkNotNullExpressionValue(actionItem, "optJSONObject(i)");
                        long j2 = this.rootViewTag;
                        IAction action = ActionUtilsKt.parseActionItem(j2, j2, this.scopeId, actionItem);
                        if (action != null) {
                            addAction(status, action);
                        }
                    }
                }
            }
        }
    }

    private final void sortActionsIfNeed() {
        LinkedHashMap<Double, List<IAction>> linkedHashMap;
        if (this.isActionsNeedSort) {
            if (this.actionMap.size() > 1) {
                Map map = MapsKt.toMap(CollectionsKt.sortedWith(MapsKt.toList(this.actionMap), new ContainerEndOverLapDispatcher$sortActionsIfNeed$$inlined$sortedByDescending$1()));
                linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
            } else {
                linkedHashMap = this.actionMap;
            }
            this.sortedActionMap = linkedHashMap;
            this.isActionsNeedSort = false;
        }
    }

    private final void addAction(double status, IAction action) {
        if (this.actionMap.get(Double.valueOf(status)) == null) {
            this.actionMap.put(Double.valueOf(status), new ArrayList());
        }
        List list = this.actionMap.get(Double.valueOf(status));
        if (list != null) {
            list.add(action);
        }
        this.isActionsNeedSort = true;
    }

    public void removeAction(long viewTag) {
        this.actionMap.clear();
    }

    public void dispatch(long viewTag, JSONObject paramsJson) {
        JSONObject jSONObject = paramsJson;
        sortActionsIfNeed();
        LinkedHashMap $this$dispatch_u24lambda_u2d5 = this.sortedActionMap;
        if ($this$dispatch_u24lambda_u2d5 != null) {
            Double currentStatus = jSONObject != null ? Double.valueOf(jSONObject.optDouble("status")) : null;
            if (currentStatus != null) {
                double doubleValue = currentStatus.doubleValue();
                for (Map.Entry entry : $this$dispatch_u24lambda_u2d5.entrySet()) {
                    double status = ((Number) entry.getKey()).doubleValue();
                    List actionList = (List) entry.getValue();
                    if (currentStatus.doubleValue() >= status) {
                        ActionUtilsKt.dispatchActionsChain(this.rootViewTag, actionList, (JSONObject) null);
                        return;
                    }
                }
            }
        }
    }
}
