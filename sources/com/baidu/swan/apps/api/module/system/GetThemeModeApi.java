package com.baidu.swan.apps.api.module.system;

import android.app.Activity;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.event.message.SwanAppCustomMessage;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.util.SwanAppActivityUtils;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/swan/apps/api/module/system/GetThemeModeApi;", "Lcom/baidu/swan/apps/api/module/system/AbsSystemApi;", "context", "Lcom/baidu/swan/apps/api/base/ISwanApiContext;", "(Lcom/baidu/swan/apps/api/base/ISwanApiContext;)V", "getLogTag", "", "getThemeMode", "Lcom/baidu/swan/apps/api/result/SwanApiResult;", "Companion", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetThemeModeApi.kt */
public final class GetThemeModeApi extends AbsSystemApi {
    private static final String API_GET_THEME_MODE = "getThemeMode";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EVENT_THEME_CHANGE = "themeModeChange";
    private static final String KEY_MODE = "mode";
    private static final String TAG = "GetThemeModeApi";
    private static final String VALUE_DARK_MODE = "dark";
    private static final String VALUE_LIGHT_MODE = "light";
    private static final String WHITELIST_GET_THEME_MODE = "swanAPI/getThemeMode";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetThemeModeApi(ISwanApiContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return TAG;
    }

    public final SwanApiResult getThemeMode() {
        logInfo("#getThemeMode", false);
        Activity activity = Swan.get().getActivity();
        if (activity == null) {
            return new SwanApiResult(1001);
        }
        if (!SwanAppActivityUtils.isActivityActive(activity)) {
            return new SwanApiResult(1001);
        }
        return new SwanApiResult(0, SwanAppJSONUtils.setValue((JSONObject) null, "mode", SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState() ? "dark" : "light"));
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/swan/apps/api/module/system/GetThemeModeApi$Companion;", "", "()V", "API_GET_THEME_MODE", "", "EVENT_THEME_CHANGE", "KEY_MODE", "TAG", "VALUE_DARK_MODE", "VALUE_LIGHT_MODE", "WHITELIST_GET_THEME_MODE", "sendThemeChangeMsgToJS", "", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GetThemeModeApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void sendThemeChangeMsgToJS() {
            SwanAppCustomMessage msg = new SwanAppCustomMessage(GetThemeModeApi.EVENT_THEME_CHANGE);
            msg.putValueToData("mode", SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState() ? "dark" : "light");
            SwanAppController.getInstance().sendJSMessage(msg);
        }
    }
}
