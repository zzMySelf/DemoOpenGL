package com.tera.scan.main.importfile.viewmodel;

import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.rrr.qw.ad;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1", f = "ImportDocFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<ScanRecordExportFile>>, Object> {
    public final /* synthetic */ Ref.ObjectRef<Pair<Integer, Integer>> $copyFileResultPair;
    public final /* synthetic */ Ref.BooleanRef $insertResultIsSuccess;
    public final /* synthetic */ List<ScanRecordExportFile> $recordExportFiles;
    public int label;
    public final /* synthetic */ ImportDocFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1(Ref.ObjectRef<Pair<Integer, Integer>> objectRef, ImportDocFileViewModel importDocFileViewModel, List<ScanRecordExportFile> list, Ref.BooleanRef booleanRef, Continuation<? super ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1> continuation) {
        super(2, continuation);
        this.$copyFileResultPair = objectRef;
        this.this$0 = importDocFileViewModel;
        this.$recordExportFiles = list;
        this.$insertResultIsSuccess = booleanRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1(this.$copyFileResultPair, this.this$0, this.$recordExportFiles, this.$insertResultIsSuccess, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<ScanRecordExportFile>> continuation) {
        return ((ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$copyFileResultPair.element = this.this$0.ad(this.$recordExportFiles);
            this.$insertResultIsSuccess.element = ad.qw.qw().pf(this.this$0.qw, this.$recordExportFiles);
            return this.$recordExportFiles;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
