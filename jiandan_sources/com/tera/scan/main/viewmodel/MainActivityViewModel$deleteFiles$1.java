package com.tera.scan.main.viewmodel;

import androidx.fragment.app.FragmentActivity;
import fe.mmm.qw.xxx.yj.g.qw.qw;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.viewmodel.MainActivityViewModel$deleteFiles$1", f = "MainActivityViewModel.kt", i = {}, l = {464}, m = "invokeSuspend", n = {}, s = {})
public final class MainActivityViewModel$deleteFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ qw<?> $listHolder;
    public final /* synthetic */ Function1<Boolean, Unit> $onResultCallback;
    public final /* synthetic */ List<Integer> $positionList;
    public int label;
    public final /* synthetic */ MainActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivityViewModel$deleteFiles$1(qw<?> qwVar, FragmentActivity fragmentActivity, List<Integer> list, MainActivityViewModel mainActivityViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super MainActivityViewModel$deleteFiles$1> continuation) {
        super(2, continuation);
        this.$listHolder = qwVar;
        this.$activity = fragmentActivity;
        this.$positionList = list;
        this.this$0 = mainActivityViewModel;
        this.$onResultCallback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MainActivityViewModel$deleteFiles$1(this.$listHolder, this.$activity, this.$positionList, this.this$0, this.$onResultCallback, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MainActivityViewModel$deleteFiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            qw<?> qwVar = this.$listHolder;
            FragmentActivity fragmentActivity = this.$activity;
            List<Integer> list = this.$positionList;
            this.label = 1;
            obj = qwVar.m1010if(fragmentActivity, list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        this.this$0.getSelectItemList().clear();
        this.this$0.updateSelectItemCount(this.$listHolder.uk().size());
        this.$onResultCallback.invoke(Boxing.boxBoolean(booleanValue));
        return Unit.INSTANCE;
    }
}
