package com.tera.scan.main;

import fe.mmm.qw.xxx.ggg.rg;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.MainActivity$initListener$1", f = "MainActivity.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class MainActivity$initListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ MainActivity this$0;

    public static final class qw implements FlowCollector<rg> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MainActivity f6951ad;

        public qw(MainActivity mainActivity) {
            this.f6951ad = mainActivity;
        }

        @Nullable
        public Object emit(rg rgVar, @NotNull Continuation<? super Unit> continuation) {
            rg rgVar2 = rgVar;
            this.f6951ad.getViewModel().switchToFragment(this.f6951ad, rgVar2.ad(), rgVar2.qw());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivity$initListener$1(MainActivity mainActivity, Continuation<? super MainActivity$initListener$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MainActivity$initListener$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MainActivity$initListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<rg> bottomTabSelected$app_main_aiscanConfigRelease = this.this$0.getViewModel().getBottomTabSelected$app_main_aiscanConfigRelease();
            qw qwVar = new qw(this.this$0);
            this.label = 1;
            if (bottomTabSelected$app_main_aiscanConfigRelease.fe(qwVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
