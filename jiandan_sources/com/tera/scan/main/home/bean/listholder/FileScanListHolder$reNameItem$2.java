package com.tera.scan.main.home.bean.listholder;

import android.content.Context;
import fe.mmm.qw.rrr.qw.ad;
import fe.mmm.qw.xxx.yj.g.qw.de;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.home.bean.listholder.FileScanListHolder$reNameItem$2", f = "FileScanListHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileScanListHolder$reNameItem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $position;
    public int label;
    public final /* synthetic */ de this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileScanListHolder$reNameItem$2(de deVar, int i2, Context context, String str, Continuation<? super FileScanListHolder$reNameItem$2> continuation) {
        super(2, continuation);
        this.this$0 = deVar;
        this.$position = i2;
        this.$context = context;
        this.$name = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileScanListHolder$reNameItem$2(this.this$0, this.$position, this.$context, this.$name, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((FileScanListHolder$reNameItem$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(ad.qw.qw().aaa(this.$context, ((fe.mmm.qw.xxx.yj.g.ad.de) this.this$0.de().get(this.$position)).de().getRecordId(), this.$name) > 0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
