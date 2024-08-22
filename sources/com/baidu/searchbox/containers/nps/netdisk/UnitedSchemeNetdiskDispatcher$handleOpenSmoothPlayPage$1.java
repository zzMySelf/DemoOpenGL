package com.baidu.searchbox.containers.nps.netdisk;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "isSuccess", "", "errorCode", "", "errorMsg", "", "invoke", "(ZLjava/lang/Integer;Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnitedSchemeNetdiskDispatcher.kt */
final class UnitedSchemeNetdiskDispatcher$handleOpenSmoothPlayPage$1 extends Lambda implements Function3<Boolean, Integer, String, Unit> {
    final /* synthetic */ CallbackHandler $callback;
    final /* synthetic */ String $callbackTag;
    final /* synthetic */ UnitedSchemeNetdiskDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnitedSchemeNetdiskDispatcher$handleOpenSmoothPlayPage$1(String str, UnitedSchemeNetdiskDispatcher unitedSchemeNetdiskDispatcher, CallbackHandler callbackHandler) {
        super(3);
        this.$callbackTag = str;
        this.this$0 = unitedSchemeNetdiskDispatcher;
        this.$callback = callbackHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke(((Boolean) p1).booleanValue(), (Integer) p2, (String) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess, Integer errorCode, String errorMsg) {
        CharSequence charSequence = this.$callbackTag;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            String invokeResult = this.this$0.buildInvokeResult(isSuccess, errorCode, errorMsg);
            CallbackHandler callbackHandler = this.$callback;
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.$callbackTag, invokeResult);
            }
        }
    }
}
