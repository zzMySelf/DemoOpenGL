package com.baidu.growthsystem.wealth.scheme;

import android.content.Context;
import com.baidu.growthsystem.wealth.common.task.WealthTaskActionManager;
import com.baidu.growthsystem.wealth.common.task.core.IWealthTaskActionListener;
import com.baidu.growthsystem.wealth.common.util.WealthVideoYalogUtilKt;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemePriorityDispatcher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004JD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u0017"}, d2 = {"Lcom/baidu/growthsystem/wealth/scheme/NotifyWealthPacketTaskRegisteredAction;", "Lcom/baidu/growthsystem/wealth/scheme/BaseWealthSchemeAction;", "Lcom/baidu/growthsystem/wealth/scheme/UnitedSchemeWealthDispatcher;", "dispatcher", "(Lcom/baidu/growthsystem/wealth/scheme/UnitedSchemeWealthDispatcher;)V", "doCustomSchemeCallback", "", "context", "Landroid/content/Context;", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "code", "", "message", "", "data", "Lorg/json/JSONObject;", "getActionName", "handleAction", "", "handleCascadeScheme", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotifyWealthCustomTaskRegisteredAction.kt */
public final class NotifyWealthPacketTaskRegisteredAction extends BaseWealthSchemeAction<UnitedSchemeWealthDispatcher> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotifyWealthPacketTaskRegisteredAction(UnitedSchemeWealthDispatcher dispatcher) {
        super(dispatcher);
        Intrinsics.checkNotNullParameter(dispatcher, UnitedSchemePriorityDispatcher.SCHEME_PATH_DISPATCHER);
    }

    public String getActionName() {
        return WealthVideoSchemeContantsKt.ACTION_NOTIFY_WEALTH_CUSTOM_TASK_REGISTERED;
    }

    public boolean handleAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        Object obj;
        boolean z;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(unitedSchemeEntity, "entity");
        String params = unitedSchemeEntity.getParam("params");
        if (params == null) {
            doCustomSchemeCallback$default(this, context, handler, entity, 202, (String) null, (JSONObject) null, 48, (Object) null);
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            NotifyWealthPacketTaskRegisteredAction notifyWealthPacketTaskRegisteredAction = this;
            obj = Result.m8971constructorimpl(new JSONObject(params));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        JSONObject paramsJson = (JSONObject) obj;
        if (paramsJson == null) {
            doCustomSchemeCallback$default(this, context, handler, entity, 202, (String) null, (JSONObject) null, 48, (Object) null);
            return false;
        }
        String type = paramsJson.optString("type");
        WealthTaskActionManager wealthTaskActionManager = WealthTaskActionManager.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(type, "type");
        IWealthTaskActionListener actionListener = wealthTaskActionManager.findActionByName(type);
        if (actionListener == null) {
            doCustomSchemeCallback(context, handler, entity, 10002, "任务类型无效", (JSONObject) null);
            return false;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            actionListener.onTaskRegistered();
            doCustomSchemeCallback$default(this, context, handler, entity, 0, (String) null, (JSONObject) null, 48, (Object) null);
            z = Result.m8971constructorimpl(true);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            z = Result.m8971constructorimpl(ResultKt.createFailure(th3));
        }
        Throwable r1 = Result.m8974exceptionOrNullimpl(z);
        if (r1 != null) {
            Throwable th4 = r1;
            doCustomSchemeCallback$default(this, context, handler, entity, 1001, (String) null, (JSONObject) null, 48, (Object) null);
            z = false;
        }
        return ((Boolean) z).booleanValue();
    }

    static /* synthetic */ void doCustomSchemeCallback$default(NotifyWealthPacketTaskRegisteredAction notifyWealthPacketTaskRegisteredAction, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, int i2, String str, JSONObject jSONObject, int i3, Object obj) {
        String str2;
        JSONObject jSONObject2;
        if ((i3 & 16) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i3 & 32) != 0) {
            jSONObject2 = null;
        } else {
            jSONObject2 = jSONObject;
        }
        notifyWealthPacketTaskRegisteredAction.doCustomSchemeCallback(context, callbackHandler, unitedSchemeEntity, i2, str2, jSONObject2);
    }

    private final void doCustomSchemeCallback(Context context, CallbackHandler handler, UnitedSchemeEntity entity, int code, String message, JSONObject data) {
        handleCascadeScheme(context, entity);
        doCallback(handler, entity, code, message, data);
    }

    private final void handleCascadeScheme(Context context, UnitedSchemeEntity entity) {
        String nextScheme = entity != null ? entity.getParam("schema") : null;
        CharSequence charSequence = nextScheme;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Router.invoke(context, nextScheme);
            WealthVideoYalogUtilKt.doWealthVideoYalog("Invoke cascade scheme from 'scheme/notifyWealthCustomTaskRegistered': " + nextScheme);
        }
    }
}
