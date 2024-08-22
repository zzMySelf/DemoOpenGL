package com.tera.scan.main.home;

import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.widget.swiperefresh.NetdiskSwipeRefreshLayout;
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
@DebugMetadata(c = "com.tera.scan.main.home.HomeFragment$refresh$2", f = "HomeFragment.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
public final class HomeFragment$refresh$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$refresh$2(HomeFragment homeFragment, Continuation<? super HomeFragment$refresh$2> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeFragment$refresh$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HomeFragment$refresh$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MainActivityViewModel access$getMainActivityViewModel = this.this$0.getMainActivityViewModel();
            this.label = 1;
            if (access$getMainActivityViewModel.reloadScanRecordList(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetdiskSwipeRefreshLayout access$getRefreshLayout$p = this.this$0.refreshLayout;
        if (access$getRefreshLayout$p != null) {
            access$getRefreshLayout$p.setRefreshing(false);
        }
        return Unit.INSTANCE;
    }
}
