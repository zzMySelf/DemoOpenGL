package com.tera.scan.flutter.plugin.documenttool;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy$onMethodCall$2", f = "DocumentToolPluginProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocumentToolPluginProxy$onMethodCall$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ MethodChannel.Result $result;
    public int label;
    public final /* synthetic */ DocumentToolPluginProxy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentToolPluginProxy$onMethodCall$2(DocumentToolPluginProxy documentToolPluginProxy, MethodCall methodCall, MethodChannel.Result result, Continuation<? super DocumentToolPluginProxy$onMethodCall$2> continuation) {
        super(2, continuation);
        this.this$0 = documentToolPluginProxy;
        this.$call = methodCall;
        this.$result = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DocumentToolPluginProxy$onMethodCall$2(this.this$0, this.$call, this.$result, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DocumentToolPluginProxy$onMethodCall$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.C(this.$call, this.$result);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
