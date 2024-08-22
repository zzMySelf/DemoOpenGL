package com.baidu.searchbox.openwidget.scheme;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.openwidget.OpenWidgetProvider;
import com.baidu.searchbox.openwidget.pages.OpenWidgetCenterActivity;
import com.baidu.searchbox.openwidget.utils.AnyProcess;
import com.baidu.searchbox.openwidget.utils.ValidationsKt;
import com.baidu.searchbox.openwidget.utils.WidgetsKt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemePriorityDispatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@AnyProcess
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/openwidget/scheme/StartOpenWidgetCenterAction;", "Lcom/baidu/searchbox/openwidget/scheme/BaseOpenWidgetSchemeAction;", "Lcom/baidu/searchbox/openwidget/scheme/UnitedSchemeOpenWidgetDispatcher;", "dispatcher", "(Lcom/baidu/searchbox/openwidget/scheme/UnitedSchemeOpenWidgetDispatcher;)V", "getActionName", "", "handleAction", "", "context", "Landroid/content/Context;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "params", "", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StartOpenWidgetCenterAction.kt */
public final class StartOpenWidgetCenterAction extends BaseOpenWidgetSchemeAction<UnitedSchemeOpenWidgetDispatcher> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartOpenWidgetCenterAction(UnitedSchemeOpenWidgetDispatcher dispatcher) {
        super(dispatcher);
        Intrinsics.checkNotNullParameter(dispatcher, UnitedSchemePriorityDispatcher.SCHEME_PATH_DISPATCHER);
    }

    public String getActionName() {
        return StartOpenWidgetCenterActionKt.ACTION_START_WIDGET_CENTER;
    }

    public boolean handleAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler, Map<String, String> params) {
        Object obj;
        boolean z;
        int widgetId;
        Map<String, String> map = params;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(map, "params");
        try {
            Result.Companion companion = Result.Companion;
            StartOpenWidgetCenterAction startOpenWidgetCenterAction = this;
            String str = map.get("params");
            if (str == null) {
                str = "";
            }
            obj = Result.m8971constructorimpl(new JSONObject(str));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Long l = null;
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        JSONObject json = (JSONObject) obj;
        if (json == null) {
            if (StartOpenWidgetCenterActionKt.DEBUG) {
                Log.d("StartOpenWidgetCenter", "params为空");
            }
            BaseOpenWidgetSchemeAction.doCallback$default(this, handler, entity, 202, (String) null, (JSONObject) null, 24, (Object) null);
            return false;
        }
        int widgetId2 = json.optInt("id", 0);
        int width = json.optInt("width", 0);
        int height = json.optInt("height", 0);
        long $this$handleAction_u24lambda_u2d1 = json.optLong(OpenWidgetProvider.EXTRA_OPEN_WIDGET_ID, -1);
        if ($this$handleAction_u24lambda_u2d1 != -1) {
            l = Long.valueOf($this$handleAction_u24lambda_u2d1);
        }
        Long openWidgetId = l;
        if (widgetId2 == 0) {
            widgetId = widgetId2;
            z = false;
            int i2 = height;
            int i3 = width;
        } else if (!WidgetsKt.isOpenWidgetProvider(widgetId2)) {
            widgetId = widgetId2;
            z = false;
            int i4 = height;
            int i5 = width;
        } else if (!ValidationsKt.isValidAsWidgetSize(new Pair(Integer.valueOf(width), Integer.valueOf(height)))) {
            if (StartOpenWidgetCenterActionKt.DEBUG) {
                Log.d("StartOpenWidgetCenter", "宽、高无效, width=" + width + ", height=" + height);
            }
            int i6 = height;
            int i7 = width;
            BaseOpenWidgetSchemeAction.doCallback$default(this, handler, entity, 202, (String) null, (JSONObject) null, 24, (Object) null);
            return false;
        } else {
            int width2 = width;
            int widgetId3 = widgetId2;
            if (OpenWidgetCenterActivity.Companion.startSafely(context, widgetId2, width2, height, openWidgetId)) {
                int i8 = widgetId3;
                BaseOpenWidgetSchemeAction.doCallback$default(this, handler, entity, 0, (String) null, (JSONObject) null, 24, (Object) null);
                return true;
            }
            BaseOpenWidgetSchemeAction.doCallback$default(this, handler, entity, 1001, (String) null, (JSONObject) null, 24, (Object) null);
            return false;
        }
        if (StartOpenWidgetCenterActionKt.DEBUG != 0) {
            Log.d("StartOpenWidgetCenter", "找不到widget, id=" + widgetId);
        }
        BaseOpenWidgetSchemeAction.doCallback$default(this, handler, entity, 2001, (String) null, (JSONObject) null, 24, (Object) null);
        return z;
    }
}
