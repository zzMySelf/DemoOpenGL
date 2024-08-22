package com.baidu.searchbox.kmm.services.scheme;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/kmm/services/scheme/SchemeDispatcher$invokeSchemeInternalWithCallbackParams$1", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "getCurrentPageUrl", "", "handleSchemeDispatchCallback", "", "callbackStr", "params", "com.baidu.searchbox.kmm.services.scheme"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchemeDispatcher.kt */
public final class SchemeDispatcher$invokeSchemeInternalWithCallbackParams$1 implements CallbackHandler {
    final /* synthetic */ Function3<Boolean, String, JsonObject, Unit> $callback;

    SchemeDispatcher$invokeSchemeInternalWithCallbackParams$1(Function3<? super Boolean, ? super String, ? super JsonObject, Unit> $callback2) {
        this.$callback = $callback2;
    }

    public void handleSchemeDispatchCallback(String callbackStr, String params) {
        CharSequence charSequence = params;
        boolean success = true;
        if (charSequence == null || charSequence.length() == 0) {
            this.$callback.invoke(false, callbackStr, null);
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(params);
            if (jsonObject.optInt("status") != 0) {
                success = false;
            }
            this.$callback.invoke(Boolean.valueOf(success), callbackStr, new JsonObject(jsonObject));
        } catch (JSONException e2) {
            this.$callback.invoke(false, callbackStr, null);
        }
    }

    public String getCurrentPageUrl() {
        return null;
    }
}
