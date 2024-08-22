package com.tera.scan.main.viewmodel;

import android.content.Context;
import android.database.Cursor;
import com.tera.scan.record.database.DocScanProviderHelper;
import com.tera.scan.record.database.ScanRecordSortRule;
import com.tera.scan.record.model.ScanRecord;
import fe.ggg.ad.qw.de.th.rg;
import fe.mmm.qw.p030switch.rg.qw;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.viewmodel.ScanHomeFragmentViewModel$loadScanRecords$1", f = "ScanHomeFragmentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ScanHomeFragmentViewModel$loadScanRecords$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public int label;
    public final /* synthetic */ ScanHomeFragmentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanHomeFragmentViewModel$loadScanRecords$1(Context context, ScanHomeFragmentViewModel scanHomeFragmentViewModel, Continuation<? super ScanHomeFragmentViewModel$loadScanRecords$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = scanHomeFragmentViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ScanHomeFragmentViewModel$loadScanRecords$1(this.$context, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ScanHomeFragmentViewModel$loadScanRecords$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            new ArrayList();
            Pair<Cursor, List<ScanRecord>> vvv = new DocScanProviderHelper(qw.qw().getBduss()).vvv(this.$context, 0, 50, CollectionsKt__CollectionsJVMKt.listOf(ScanRecordSortRule.OPEN_TIME_DESC));
            List unused = this.this$0.f7022th;
            rg.yj(this.this$0.f7019de, vvv.getSecond());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
