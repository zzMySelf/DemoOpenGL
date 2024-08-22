package com.baidu.swan.apps.setting.oauth.record;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/swan/apps/setting/oauth/record/SwanAppAuthRecordManager$queryRecords$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lorg/json/JSONObject;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "json", "code", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanAppAuthRecordManager.kt */
public final class SwanAppAuthRecordManager$queryRecords$responseCallback$1 extends ResponseCallback<JSONObject> {
    final /* synthetic */ Function1<AuthRecordListModel, Unit> $callback;

    SwanAppAuthRecordManager$queryRecords$responseCallback$1(Function1<? super AuthRecordListModel, Unit> $callback2) {
        this.$callback = $callback2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.body();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject parseResponse(okhttp3.Response r3, int r4) throws java.lang.Exception {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x000d
            okhttp3.ResponseBody r0 = r3.body()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.string()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            org.json.JSONObject r0 = com.baidu.swan.apps.util.SwanAppJSONUtils.parseString(r0)
            java.lang.String r1 = "parseString(response?.body()?.string())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.setting.oauth.record.SwanAppAuthRecordManager$queryRecords$responseCallback$1.parseResponse(okhttp3.Response, int):org.json.JSONObject");
    }

    public void onSuccess(JSONObject json, int code) {
        this.$callback.invoke(AuthRecordListModel.Companion.parseFromResponseJson(json));
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        if (SwanAppAuthRecordManager.DEBUG) {
            Log.d("SwanAppAuthRecordManager", "queryRecords-onFail:" + e2);
        }
        this.$callback.invoke(null);
    }
}
