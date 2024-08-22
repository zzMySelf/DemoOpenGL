package com.tera.scan.main.importfile.viewmodel;

import fe.mmm.qw.xxx.uk.ggg.fe;
import fe.mmm.qw.xxx.uk.when.qw;
import i.qw.o;
import i.qw.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel$importSelectFiles$1$1", f = "ImportDocFileViewModel.kt", i = {0, 0, 0}, l = {300}, m = "invokeSuspend", n = {"copyFileResultPair", "insertResultIsSuccess", "allCount"}, s = {"L$0", "L$1", "I$0"})
public final class ImportDocFileViewModel$importSelectFiles$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<qw> $list;
    public final /* synthetic */ String $reqFileType;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public int label;
    public final /* synthetic */ ImportDocFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocFileViewModel$importSelectFiles$1$1(List<qw> list, ImportDocFileViewModel importDocFileViewModel, String str, Continuation<? super ImportDocFileViewModel$importSelectFiles$1$1> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = importDocFileViewModel;
        this.$reqFileType = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImportDocFileViewModel$importSelectFiles$1$1(this.$list, this.this$0, this.$reqFileType, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImportDocFileViewModel$importSelectFiles$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i2;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            List<qw> list = this.$list;
            Intrinsics.checkNotNullExpressionValue(list, "list");
            List<R> mutableList = SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), ImportDocFileViewModel$importSelectFiles$1$1$recordExportFiles$1.INSTANCE), new ImportDocFileViewModel$importSelectFiles$1$1$recordExportFiles$2(this.this$0)));
            this.this$0.f6975ad.setValue(Boxing.boxBoolean(true));
            int size = mutableList.size();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            CoroutineDispatcher ad2 = u.ad();
            ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1 importDocFileViewModel$importSelectFiles$1$1$importFinalList$1 = new ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1(objectRef2, this.this$0, mutableList, booleanRef2, (Continuation<? super ImportDocFileViewModel$importSelectFiles$1$1$importFinalList$1>) null);
            this.L$0 = objectRef2;
            this.L$1 = booleanRef2;
            this.I$0 = size;
            this.label = 1;
            Object yj2 = o.yj(ad2, importDocFileViewModel$importSelectFiles$1$1$importFinalList$1, this);
            if (yj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            booleanRef = booleanRef2;
            Object obj2 = yj2;
            i2 = size;
            obj = obj2;
        } else if (i3 == 1) {
            int i4 = this.I$0;
            booleanRef = (Ref.BooleanRef) this.L$1;
            ResultKt.throwOnFailure(obj);
            i2 = i4;
            objectRef = (Ref.ObjectRef) this.L$0;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ImportDocFileViewModel importDocFileViewModel = this.this$0;
        boolean z = booleanRef.element;
        Pair pair = (Pair) objectRef.element;
        fe access$assembleImportResult = importDocFileViewModel.qw(z, i2, pair, (List) obj, this.$reqFileType);
        this.this$0.f6975ad.setValue(Boxing.boxBoolean(false));
        this.this$0.f6979o.setValue(access$assembleImportResult);
        return Unit.INSTANCE;
    }
}
