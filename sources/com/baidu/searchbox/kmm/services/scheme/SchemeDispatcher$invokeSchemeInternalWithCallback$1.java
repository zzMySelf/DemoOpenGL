package com.baidu.searchbox.kmm.services.scheme;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/kmm/services/scheme/SchemeDispatcher$invokeSchemeInternalWithCallback$1", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "getCurrentPageUrl", "", "handleSchemeDispatchCallback", "", "callbackStr", "params", "com.baidu.searchbox.kmm.services.scheme"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchemeDispatcher.kt */
public final class SchemeDispatcher$invokeSchemeInternalWithCallback$1 implements CallbackHandler {
    final /* synthetic */ Function1<Boolean, Unit> $callback;

    SchemeDispatcher$invokeSchemeInternalWithCallback$1(Function1<? super Boolean, Unit> $callback2) {
        this.$callback = $callback2;
    }

    public void handleSchemeDispatchCallback(String callbackStr, String params) {
        Object obj;
        CharSequence charSequence = params;
        boolean z = true;
        boolean z2 = false;
        if (charSequence == null || charSequence.length() == 0) {
            this.$callback.invoke(false);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            SchemeDispatcher$invokeSchemeInternalWithCallback$1 schemeDispatcher$invokeSchemeInternalWithCallback$1 = this;
            if (new JSONObject(params).optInt("status") != 0) {
                z = false;
            }
            obj = Result.m8971constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m8977isFailureimpl(obj)) {
            z2 = obj;
        }
        this.$callback.invoke(Boolean.valueOf(((Boolean) z2).booleanValue()));
    }

    public String getCurrentPageUrl() {
        return null;
    }
}
