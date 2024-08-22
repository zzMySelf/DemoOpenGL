package com.tera.scan.flutter.plugin.documenttool;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import fe.mmm.qw.h.de.qw;
import fe.mmm.qw.h.fe.de;
import fe.mmm.qw.p024if.pf.th.yj;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy$onMethodCall$3", f = "DocumentToolPluginProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocumentToolPluginProxy$onMethodCall$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<String> $pathList;
    public final /* synthetic */ MethodChannel.Result $result;
    public int label;
    public final /* synthetic */ DocumentToolPluginProxy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentToolPluginProxy$onMethodCall$3(DocumentToolPluginProxy documentToolPluginProxy, MethodChannel.Result result, List<String> list, Continuation<? super DocumentToolPluginProxy$onMethodCall$3> continuation) {
        super(2, continuation);
        this.this$0 = documentToolPluginProxy;
        this.$result = result;
        this.$pathList = list;
    }

    /* renamed from: invokeSuspend$lambda-3$lambda-2  reason: not valid java name */
    public static final void m761invokeSuspend$lambda3$lambda2(MethodChannel.Result result, String str) {
        result.success(str);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DocumentToolPluginProxy$onMethodCall$3(this.this$0, this.$result, this.$pathList, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DocumentToolPluginProxy$onMethodCall$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Context rg2 = this.this$0.rg();
            String str = null;
            String ad2 = rg2 != null ? new qw().ad(rg2, "JPG") : null;
            if (ad2 == null) {
                this.$result.success((Object) null);
                return Unit.INSTANCE;
            }
            if (this.this$0.rg() != null) {
                List<String> list = this.$pathList;
                MethodChannel.Result result = this.$result;
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.m1155constructorimpl(new de().de(list, ad2));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m1155constructorimpl(ResultKt.createFailure(th2));
                }
                if (!Result.m1161isFailureimpl(obj2)) {
                    str = obj2;
                }
                String str2 = str;
                if (str2 == null) {
                    str2 = "";
                }
                new Handler(Looper.getMainLooper()).post(new yj(result, str2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
