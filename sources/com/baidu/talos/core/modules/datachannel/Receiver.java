package com.baidu.talos.core.modules.datachannel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.util.LogUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0019\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/talos/core/modules/datachannel/Receiver;", "Landroid/content/BroadcastReceiver;", "runtimeContext", "Lcom/baidu/talos/core/context/IRuntimeContext;", "(Lcom/baidu/talos/core/context/IRuntimeContext;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "bundleToJson", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "jsonArrayFrom", "Lorg/json/JSONArray;", "array", "", "([Ljava/lang/Object;)Lorg/json/JSONArray;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "lib-talos-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Receiver.kt */
public final class Receiver extends BroadcastReceiver {
    private int count = 1;
    private final IRuntimeContext runtimeContext;

    public Receiver(IRuntimeContext runtimeContext2) {
        Intrinsics.checkNotNullParameter(runtimeContext2, "runtimeContext");
        this.runtimeContext = runtimeContext2;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i2) {
        this.count = i2;
    }

    public void onReceive(Context context, Intent intent) {
        IRuntimeContext iRuntimeContext;
        LogUtils.d(ReceiverKt.TAG, "onReceived " + intent);
        if (intent != null) {
            Intent intent2 = intent;
            String it = intent.getAction();
            if (it != null && (iRuntimeContext = this.runtimeContext) != null) {
                iRuntimeContext.sendEvent(it, bundleToJson(intent.getExtras()).toString());
            }
        }
    }

    private final JSONObject bundleToJson(Bundle bundle) {
        JSONObject jsonObject = new JSONObject();
        if (bundle != null) {
            try {
                Set<String> keys = bundle.keySet();
                if (keys != null) {
                    for (String key : keys) {
                        Object value = bundle.get(key);
                        if (value != null) {
                            if (value instanceof Bundle) {
                                jsonObject.put(key, bundleToJson((Bundle) value));
                            } else if (value instanceof Object[]) {
                                Intrinsics.checkNotNullExpressionValue(value, "value");
                                jsonObject.put(key, jsonArrayFrom((Object[]) value));
                            } else {
                                boolean z = true;
                                if (!(value instanceof Boolean ? true : value instanceof Integer ? true : value instanceof Long ? true : value instanceof Double)) {
                                    z = value instanceof String;
                                }
                                if (z) {
                                    jsonObject.put(key, value);
                                } else {
                                    jsonObject.put(key, value.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e(ReceiverKt.TAG, "bundleToJson exception: " + e2);
            }
        }
        return jsonObject;
    }

    private final JSONArray jsonArrayFrom(Object[] array) {
        JSONArray jsonArray = new JSONArray();
        for (Bundle bundle : array) {
            if (bundle != null) {
                Object[] objArr = bundle;
                if (bundle instanceof Bundle) {
                    jsonArray.put(bundleToJson(bundle));
                } else if (bundle instanceof Object[]) {
                    jsonArray.put(jsonArrayFrom(bundle));
                } else {
                    boolean z = true;
                    if (!(bundle instanceof Boolean ? true : bundle instanceof Integer ? true : bundle instanceof Long ? true : bundle instanceof Double)) {
                        z = bundle instanceof String;
                    }
                    if (z) {
                        jsonArray.put(bundle);
                    } else {
                        jsonArray.put(bundle.toString());
                    }
                }
            }
        }
        return jsonArray;
    }
}
