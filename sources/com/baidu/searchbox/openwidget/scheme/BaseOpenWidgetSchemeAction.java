package com.baidu.searchbox.openwidget.scheme;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.openwidget.utils.AnyProcess;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseAction;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemePriorityDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@AnyProcess
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J<\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0004J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J&\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J6\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001aH&J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0004¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/openwidget/scheme/BaseOpenWidgetSchemeAction;", "T", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeAbsDispatcher;", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeBaseAction;", "dispatcher", "(Lcom/baidu/searchbox/unitedscheme/UnitedSchemeAbsDispatcher;)V", "doCallback", "", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "code", "", "message", "", "data", "Lorg/json/JSONObject;", "extractActivity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "handle", "", "handleAction", "params", "", "tryGetActiveActivity", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseOpenWidgetSchemeAction.kt */
public abstract class BaseOpenWidgetSchemeAction<T extends UnitedSchemeAbsDispatcher> extends UnitedSchemeBaseAction<T> {
    public abstract boolean handleAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Map<String, String> map);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseOpenWidgetSchemeAction(T dispatcher) {
        super(dispatcher);
        Intrinsics.checkNotNullParameter(dispatcher, UnitedSchemePriorityDispatcher.SCHEME_PATH_DISPATCHER);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        if (BaseOpenWidgetSchemeActionKt.DEBUG) {
            Log.v("BaseOpenWidgetAction", "entity(" + (unitedSchemeEntity != null ? entity.getUri() : null) + ')');
        }
        if (context == null) {
            CallbackHandler callbackHandler = handler;
        } else if (unitedSchemeEntity == null) {
            CallbackHandler callbackHandler2 = handler;
        } else {
            HashMap params = entity.getParams();
            if (params == null) {
                CallbackHandler callbackHandler3 = handler;
            } else if (params.size() <= 0) {
                CallbackHandler callbackHandler4 = handler;
            } else {
                Activity extractActivity = extractActivity(context);
                return handleAction(extractActivity != null ? extractActivity : context, entity, handler, params);
            }
            if (BaseOpenWidgetSchemeActionKt.DEBUG) {
                Log.w("BaseOpenWidgetAction", "Params is null");
            }
            if (!entity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "no params");
            }
            doCallback$default(this, handler, entity, 202, "params为空", (JSONObject) null, 16, (Object) null);
            return false;
        }
        doCallback$default(this, handler, entity, 1001, (String) null, (JSONObject) null, 24, (Object) null);
        return false;
    }

    private final Activity extractActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return extractActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static /* synthetic */ void doCallback$default(BaseOpenWidgetSchemeAction baseOpenWidgetSchemeAction, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, int i2, String str, JSONObject jSONObject, int i3, Object obj) {
        String str2;
        JSONObject jSONObject2;
        if (obj == null) {
            if ((i3 & 8) != 0) {
                str2 = null;
            } else {
                str2 = str;
            }
            if ((i3 & 16) != 0) {
                jSONObject2 = null;
            } else {
                jSONObject2 = jSONObject;
            }
            baseOpenWidgetSchemeAction.doCallback(callbackHandler, unitedSchemeEntity, i2, str2, jSONObject2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doCallback");
    }

    /* access modifiers changed from: protected */
    public final void doCallback(CallbackHandler handler, UnitedSchemeEntity entity, int code, String message, JSONObject data) {
        if (handler != null) {
            if (message == null) {
                UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(data == null ? new JSONObject() : data, code));
            } else {
                UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(data == null ? new JSONObject() : data, code, message));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Activity tryGetActiveActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return tryGetActiveActivity(((ContextWrapper) context).getBaseContext());
        }
        if (BdBoxActivityManager.isForeground()) {
            return BdBoxActivityManager.getRealTopActivity();
        }
        return null;
    }
}
