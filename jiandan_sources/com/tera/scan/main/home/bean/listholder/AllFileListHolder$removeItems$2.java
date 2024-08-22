package com.tera.scan.main.home.bean.listholder;

import android.content.Context;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.j.xxx.ad;
import fe.mmm.qw.xxx.yj.g.ad.qw;
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
@DebugMetadata(c = "com.tera.scan.main.home.bean.listholder.AllFileListHolder$removeItems$2", f = "AllFileListHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AllFileListHolder$removeItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ List<Integer> $list;
    public int label;
    public final /* synthetic */ AllFileListHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllFileListHolder$removeItems$2(AllFileListHolder allFileListHolder, List<Integer> list, Context context, Continuation<? super AllFileListHolder$removeItems$2> continuation) {
        super(2, continuation);
        this.this$0 = allFileListHolder;
        this.$list = list;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AllFileListHolder$removeItems$2(this.this$0, this.$list, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((AllFileListHolder$removeItems$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z;
        boolean z2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<qw> de2 = this.this$0.de();
            boolean z3 = true;
            if (!de2.isEmpty()) {
                for (Number intValue : this.$list) {
                    int intValue2 = intValue.intValue();
                    if (de2.size() > intValue2) {
                        Object data = de2.get(intValue2).getData();
                        if (data instanceof ScanRecordExportFile) {
                            arrayList.add(data);
                            ad.fe(((ScanRecordExportFile) data).getLocalPath());
                        } else if (data instanceof ScanRecord) {
                            arrayList2.add(((ScanRecord) data).getRecordId());
                        }
                    }
                }
            }
            if (!arrayList.isEmpty() && fe.mmm.qw.rrr.qw.ad.qw.qw().th(this.$context, arrayList) <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (!arrayList2.isEmpty() && fe.mmm.qw.rrr.qw.ad.qw.qw().rg(this.$context, arrayList2) <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z || !z2) {
                z3 = false;
            }
            return Boxing.boxBoolean(z3);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
