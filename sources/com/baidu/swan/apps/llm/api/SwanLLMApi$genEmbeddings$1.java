package com.baidu.swan.apps.llm.api;

import android.app.Activity;
import com.baidu.swan.apps.api.base.SwanBaseApi;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.runtime.SwanApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/swan/apps/llm/api/SwanLLMApi$genEmbeddings$1", "Lcom/baidu/swan/apps/api/base/SwanBaseApi$CommonApiHandler;", "handle", "Lcom/baidu/swan/apps/api/result/SwanApiResult;", "swanApp", "Lcom/baidu/swan/apps/runtime/SwanApp;", "swanActivity", "Landroid/app/Activity;", "paramsJo", "Lorg/json/JSONObject;", "cb", "", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanLLMApi.kt */
public final class SwanLLMApi$genEmbeddings$1 implements SwanBaseApi.CommonApiHandler {
    final /* synthetic */ SwanLLMApi this$0;

    SwanLLMApi$genEmbeddings$1(SwanLLMApi $receiver) {
        this.this$0 = $receiver;
    }

    public SwanApiResult handle(SwanApp swanApp, Activity swanActivity, JSONObject paramsJo, String cb) {
        Intrinsics.checkNotNullParameter(swanApp, "swanApp");
        Intrinsics.checkNotNullParameter(swanActivity, "swanActivity");
        Intrinsics.checkNotNullParameter(paramsJo, "paramsJo");
        Intrinsics.checkNotNullParameter(cb, "cb");
        paramsJo.remove("cb");
        LLMRequest $this$handle_u24lambda_u2d0 = new LLMRequest();
        SwanLLMApi swanLLMApi = this.this$0;
        $this$handle_u24lambda_u2d0.setData(paramsJo);
        $this$handle_u24lambda_u2d0.executeRequest(LLMRequest.Companion.getEMBEDDING_URL(), new SwanLLMApi$genEmbeddings$1$handle$1$1(swanLLMApi, cb));
        SwanApiResult ok = SwanApiResult.ok();
        Intrinsics.checkNotNullExpressionValue(ok, "ok()");
        return ok;
    }
}
