package com.baidu.searchbox.liveshow.scheme.task;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.plugin.network.LiveRequesterKt;
import com.baidu.live.plugin.network.PreloadNetWorkManager;
import com.baidu.searchbox.live.imp.net.BdNetworkImpl;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0013H\u0002J<\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0013J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction;", "", "()V", "takManager", "Lcom/baidu/searchbox/liveshow/scheme/task/LiveTaskManager;", "appointmentRoomTask", "", "context", "Landroid/content/Context;", "params", "", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "canHandle", "action", "getParams", "map", "", "handle", "handleUnknownAction", "requestAppointmentRoom", "", "roomIds", "Companion", "TaskType", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveSchemeTaskAction.kt */
public final class LiveSchemeTaskAction {
    public static final String ACTION_APPOINT_ROOM_TASK = "appointmentRoomTask";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final boolean DEBUG = UnitedSchemeConstants.DEBUG;
    public static final String TAG = "LiveSchemeTaskAction";
    /* access modifiers changed from: private */
    public final LiveTaskManager takManager = new LiveTaskManager();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction$Companion;", "", "()V", "ACTION_APPOINT_ROOM_TASK", "", "DEBUG", "", "TAG", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveSchemeTaskAction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction$TaskType;", "", "()V", "Subscribe", "Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction$TaskType$Subscribe;", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveSchemeTaskAction.kt */
    public static abstract class TaskType {
        public /* synthetic */ TaskType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TaskType() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction$TaskType$Subscribe;", "Lcom/baidu/searchbox/liveshow/scheme/task/LiveSchemeTaskAction$TaskType;", "()V", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LiveSchemeTaskAction.kt */
        public static final class Subscribe extends TaskType {
            public static final Subscribe INSTANCE = new Subscribe();

            private Subscribe() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    public final boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, String action, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!Intrinsics.areEqual((Object) action, (Object) ACTION_APPOINT_ROOM_TASK)) {
            return handleUnknownAction(entity);
        }
        String params2 = getParams(params);
        if (params2 == null) {
            params2 = "";
        }
        return appointmentRoomTask(context, params2, entity, handler);
    }

    private final boolean appointmentRoomTask(Context context, String params, UnitedSchemeEntity entity, CallbackHandler handler) {
        String roomIds = "";
        String actionId = "";
        try {
            JSONObject paramsObject = new JSONObject(params);
            String optString = paramsObject.optString("roomIds");
            String str = "";
            if (optString == null) {
                optString = str;
            }
            roomIds = optString;
            JSONObject taskInfo = paramsObject.optJSONObject("taskInfo");
            String optString2 = taskInfo != null ? taskInfo.optString("actionId") : null;
            if (optString2 != null) {
                str = optString2;
            }
            actionId = str;
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        LiveTask task = this.takManager.createTask(TaskType.Subscribe.INSTANCE, actionId, new LiveSchemeTaskAction$appointmentRoomTask$task$1(entity, handler));
        if (!task.valid() || TextUtils.isEmpty(roomIds)) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 202, "解析失败，请检查参数是否正确");
            return true;
        } else if (Intrinsics.areEqual((Object) this.takManager.startTask(task), (Object) actionId)) {
            requestAppointmentRoom(roomIds, entity, handler);
            return true;
        } else {
            entity.result = UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 1003, "任务未激活");
            return true;
        }
    }

    public final boolean canHandle(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return TextUtils.equals(ACTION_APPOINT_ROOM_TASK, action);
    }

    private final boolean handleUnknownAction(UnitedSchemeEntity entity) {
        if (!entity.isOnlyVerify()) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "unknown action");
        }
        entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }

    private final String getParams(Map<String, String> map) {
        return map.get("params");
    }

    private final void requestAppointmentRoom(String roomIds, UnitedSchemeEntity entity, CallbackHandler handler) {
        if (PreloadNetWorkManager.getNetWorkImpl() == null) {
            PreloadNetWorkManager.setNetWorkImpl(new BdNetworkImpl());
        }
        Map requestParams = new LinkedHashMap();
        requestParams.put("room_ids", roomIds);
        LiveRequesterKt.fetchDataWithSign2$default(LiveTaskManager.TASK_BATCH_SUBSCRIPTION, requestParams, new LiveSchemeTaskAction$requestAppointmentRoom$1(entity, handler, this), 17, 285, (Map) null, 32, (Object) null);
    }
}
