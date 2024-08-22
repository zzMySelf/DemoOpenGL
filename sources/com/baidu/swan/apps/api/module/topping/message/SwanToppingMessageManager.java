package com.baidu.swan.apps.api.module.topping.message;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.event.message.SwanAppCommonMessage;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.process.delegate.observe.observer.SwanAppMessengerObserver;
import com.baidu.swan.apps.process.messaging.channel.SwanAppMessageChannel;
import com.baidu.swan.apps.runtime.Swan;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/swan/apps/api/module/topping/message/SwanToppingMessageManager;", "", "()V", "EVENT_TOP_STATUS_CHANGE", "", "FLAG_HAS_TOPPING", "FLAG_NOT_TOPPING", "PARAM_APP_KEYS", "PARAM_IS_TOP", "TAG", "sendMessageToAllClient", "", "appKeys", "", "isTopping", "", "sendMessageToSwanJs", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanToppingMessageManager.kt */
public final class SwanToppingMessageManager {
    private static final String EVENT_TOP_STATUS_CHANGE = "topStatusChange";
    private static final String FLAG_HAS_TOPPING = "1";
    private static final String FLAG_NOT_TOPPING = "0";
    public static final SwanToppingMessageManager INSTANCE = new SwanToppingMessageManager();
    public static final String PARAM_APP_KEYS = "appKeys";
    public static final String PARAM_IS_TOP = "isTop";
    private static final String TAG = "SwanToppingMessageManager";

    private SwanToppingMessageManager() {
    }

    public final void sendMessageToAllClient(List<String> appKeys, boolean isTopping) {
        Intrinsics.checkNotNullParameter(appKeys, PARAM_APP_KEYS);
        JSONArray json = new JSONArray();
        for (String it : appKeys) {
            json.put(it);
        }
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_APP_KEYS, json.toString());
        bundle.putBoolean(PARAM_IS_TOP, isTopping);
        SwanAppMessageChannel.sendMessageToServer(bundle, ToppingMessageServerDelegation.class, (SwanAppMessengerObserver) null);
    }

    public final void sendMessageToSwanJs(boolean isTopping) {
        HashMap map = new HashMap();
        map.put(PARAM_IS_TOP, isTopping ? "1" : "0");
        SwanAppController.getInstance().sendJSMessage(new SwanAppCommonMessage(EVENT_TOP_STATUS_CHANGE, map));
        if (SwanAppLibConfig.DEBUG) {
            Log.d(TAG, "sendMessageToSwanJs:" + map + AbstractJsonLexerKt.COMMA + Swan.get().getApp().getName());
        }
    }
}
