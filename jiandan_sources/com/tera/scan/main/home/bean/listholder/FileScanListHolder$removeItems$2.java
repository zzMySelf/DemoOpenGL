package com.tera.scan.main.home.bean.listholder;

import android.content.Context;
import fe.mmm.qw.rrr.qw.ad;
import fe.mmm.qw.xxx.yj.g.qw.de;
import java.util.ArrayList;
import java.util.List;
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
@DebugMetadata(c = "com.tera.scan.main.home.bean.listholder.FileScanListHolder$removeItems$2", f = "FileScanListHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileScanListHolder$removeItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ List<Integer> $list;
    public int label;
    public final /* synthetic */ de this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileScanListHolder$removeItems$2(List<Integer> list, Context context, de deVar, Continuation<? super FileScanListHolder$removeItems$2> continuation) {
        super(2, continuation);
        this.$list = list;
        this.$context = context;
        this.this$0 = deVar;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileScanListHolder$removeItems$2(this.$list, this.$context, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((FileScanListHolder$removeItems$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            List<Integer> list = this.$list;
            de deVar = this.this$0;
            for (Number intValue : list) {
                arrayList.add(((fe.mmm.qw.xxx.yj.g.ad.de) deVar.de().get(intValue.intValue())).getData().getRecordId());
            }
            return Boxing.boxBoolean(ad.qw.qw().rg(this.$context, arrayList) > 0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
