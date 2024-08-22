package com.baidu.swan.apps.api.module.topping;

import com.baidu.swan.apps.api.module.topping.message.SwanToppingMessageManager;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.database.topping.ToppingDbDataManager;
import com.baidu.swan.apps.runtime.Swan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lorg/json/JSONObject;", "<anonymous parameter 1>", "", "cb", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanToppingApi.kt */
final class SwanToppingApi$getTopStatus$1 extends Lambda implements Function3<JSONObject, Boolean, String, Unit> {
    final /* synthetic */ SwanToppingApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwanToppingApi$getTopStatus$1(SwanToppingApi swanToppingApi) {
        super(3);
        this.this$0 = swanToppingApi;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((JSONObject) p1, ((Boolean) p2).booleanValue(), (String) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject jSONObject, boolean z, String cb) {
        Intrinsics.checkNotNullParameter(jSONObject, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(cb, "cb");
        boolean isTop = ToppingDbDataManager.INSTANCE.checkIsToppingFromDatabase(Swan.get().getApp().getAppKey());
        SwanApiResult result = new SwanApiResult(0);
        result.putData(SwanToppingMessageManager.PARAM_IS_TOP, Boolean.valueOf(isTop));
        this.this$0.invokeCallback(cb, result);
    }
}
