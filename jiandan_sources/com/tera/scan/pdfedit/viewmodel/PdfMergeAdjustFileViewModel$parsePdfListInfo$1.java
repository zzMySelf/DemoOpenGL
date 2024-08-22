package com.tera.scan.pdfedit.viewmodel;

import com.baidu.aiscan.R;
import com.tera.scan.record.model.ScanRecordExportFile;
import i.qw.o;
import i.qw.u;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfMergeAdjustFileViewModel$parsePdfListInfo$1", f = "PdfMergeAdjustFileViewModel.kt", i = {0}, l = {65}, m = "invokeSuspend", n = {"needToastPdfDamage"}, s = {"L$0"})
public final class PdfMergeAdjustFileViewModel$parsePdfListInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $isInit;
    public final /* synthetic */ ArrayList<ScanRecordExportFile> $pdfList;
    public Object L$0;
    public int label;
    public final /* synthetic */ PdfMergeAdjustFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAdjustFileViewModel$parsePdfListInfo$1(boolean z, PdfMergeAdjustFileViewModel pdfMergeAdjustFileViewModel, ArrayList<ScanRecordExportFile> arrayList, Continuation<? super PdfMergeAdjustFileViewModel$parsePdfListInfo$1> continuation) {
        super(2, continuation);
        this.$isInit = z;
        this.this$0 = pdfMergeAdjustFileViewModel;
        this.$pdfList = arrayList;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfMergeAdjustFileViewModel$parsePdfListInfo$1(this.$isInit, this.this$0, this.$pdfList, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfMergeAdjustFileViewModel$parsePdfListInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            CoroutineDispatcher ad2 = u.ad();
            PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1 pdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1 = new PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1(this.$pdfList, this.this$0, booleanRef2, (Continuation<? super PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1>) null);
            this.L$0 = booleanRef2;
            this.label = 1;
            Object yj2 = o.yj(ad2, pdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1, this);
            if (yj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            obj = yj2;
        } else if (i2 == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ArrayList arrayList = (ArrayList) obj;
        if (this.$isInit) {
            this.this$0.f7092fe.setValue(arrayList);
        } else {
            ArrayList arrayList2 = (ArrayList) this.this$0.f7092fe.getValue();
            if ((true ^ arrayList.isEmpty()) && arrayList2 != null) {
                Boxing.boxBoolean(arrayList2.addAll(arrayList));
            }
            this.this$0.f7092fe.setValue(arrayList2);
        }
        this.this$0.f7090ad.setValue(Boxing.boxBoolean(false));
        if (booleanRef.element) {
            fe.mmm.qw.th.qw.th.o.rg(R.string.corrupt_file_found_while_selecting);
        }
        return Unit.INSTANCE;
    }
}
