package com.baidu.swan.apps.pay.autosign;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.swan.apps.account.SwanAppAccount;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitorExternInfo;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Response;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/swan/apps/pay/autosign/RequestAutoSignApi$requestAutoSign$1$handle$1", "Lcom/baidu/swan/apps/util/typedbox/TypedCallback;", "Lcom/baidu/swan/apps/setting/oauth/TaskResult;", "Lcom/baidu/swan/apps/setting/oauth/request/Authorize$Result;", "onCallback", "", "result", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RequestAutoSignApi.kt */
public final class RequestAutoSignApi$requestAutoSign$1$handle$1 implements TypedCallback<TaskResult<Authorize.Result>> {
    final /* synthetic */ String $cb;
    final /* synthetic */ JSONObject $paramsJo;
    final /* synthetic */ Activity $swanActivity;
    final /* synthetic */ SwanApp $swanApp;
    final /* synthetic */ RequestAutoSignApi this$0;

    RequestAutoSignApi$requestAutoSign$1$handle$1(RequestAutoSignApi $receiver, String $cb2, JSONObject $paramsJo2, SwanApp $swanApp2, Activity $swanActivity2) {
        this.this$0 = $receiver;
        this.$cb = $cb2;
        this.$paramsJo = $paramsJo2;
        this.$swanApp = $swanApp2;
        this.$swanActivity = $swanActivity2;
    }

    public void onCallback(TaskResult<Authorize.Result> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!OAuthUtils.isAuthorizeOk(result)) {
            int errCode = result.getErrorCode();
            String errMsg = OAuthUtils.getErrorMessage(errCode);
            SwanAppLog.logToFile(this.this$0.getLogTag(), this.this$0.getLogTag() + " failed:auth fail(" + errCode + AbstractJsonLexerKt.COMMA + errMsg + ')');
            this.this$0.invokeCallback(this.$cb, new SwanApiResult(errCode, errMsg));
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AUTO_SIGN, 1005, "please call this api after apply for permission", String.valueOf(errCode), errMsg, (Response) null, (SwanAppStabilityMonitorExternInfo) null, (Map<String, JSONObject>) null, "requestAutoSign");
            return;
        }
        String token = this.$paramsJo.optString("token");
        String chosenChannel = this.$paramsJo.optString("chosenChannel");
        CharSequence charSequence = token;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = chosenChannel;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                if (this.$swanApp.getAccount().isLogin(this.$swanActivity)) {
                    RequestAutoSignApi requestAutoSignApi = this.this$0;
                    Activity activity = this.$swanActivity;
                    Intrinsics.checkNotNullExpressionValue(token, "token");
                    Intrinsics.checkNotNullExpressionValue(chosenChannel, "chosenChannel");
                    requestAutoSignApi.doRequestAutoSign(activity, token, chosenChannel, this.$cb);
                    return;
                }
                SwanAppAccount account = this.$swanApp.getAccount();
                Activity activity2 = this.$swanActivity;
                account.login(activity2, (Bundle) null, new RequestAutoSignApi$requestAutoSign$1$handle$1$$ExternalSyntheticLambda0(this.this$0, activity2, token, chosenChannel, this.$cb));
                return;
            }
        }
        this.this$0.invokeCallback(this.$cb, new SwanApiResult(202, "params check fail, token or chosenChannel is empty"));
        SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AUTO_SIGN, 1001, "params check fail, token or chosenChannel is empty", "201", "params check fail, token or chosenChannel is empty", (Response) null, (SwanAppStabilityMonitorExternInfo) null, (Map<String, JSONObject>) null, "requestAutoSign");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCallback$lambda-0  reason: not valid java name */
    public static final void m8049onCallback$lambda0(RequestAutoSignApi this$02, Activity $swanActivity2, String $token, String $chosenChannel, String $cb2, int resultCode) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($swanActivity2, "$swanActivity");
        Intrinsics.checkNotNullParameter($cb2, "$cb");
        if (resultCode == 0) {
            Intrinsics.checkNotNullExpressionValue($token, "token");
            Intrinsics.checkNotNullExpressionValue($chosenChannel, "chosenChannel");
            this$02.doRequestAutoSign($swanActivity2, $token, $chosenChannel, $cb2);
            return;
        }
        this$02.invokeCallback($cb2, new SwanApiResult(10004, "login fail"));
        Intrinsics.checkNotNullExpressionValue($chosenChannel, "chosenChannel");
        this$02.doRequestAutoSignUBC("loginCancel", $chosenChannel, "login fail");
    }
}
