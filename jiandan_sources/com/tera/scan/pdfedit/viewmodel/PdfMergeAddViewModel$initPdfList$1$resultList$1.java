package com.tera.scan.pdfedit.viewmodel;

import android.app.Application;
import com.tera.scan.pdfedit.data.AddPdfItemData;
import com.tera.scan.record.database.DocScanProviderHelper;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.rrr.qw.ad;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfMergeAddViewModel$initPdfList$1$resultList$1", f = "PdfMergeAddViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfMergeAddViewModel$initPdfList$1$resultList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AddPdfItemData>>, Object> {
    public int label;
    public final /* synthetic */ PdfMergeAddViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAddViewModel$initPdfList$1$resultList$1(PdfMergeAddViewModel pdfMergeAddViewModel, Continuation<? super PdfMergeAddViewModel$initPdfList$1$resultList$1> continuation) {
        super(2, continuation);
        this.this$0 = pdfMergeAddViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfMergeAddViewModel$initPdfList$1$resultList$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<AddPdfItemData>> continuation) {
        return ((PdfMergeAddViewModel$initPdfList$1$resultList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DocScanProviderHelper qw = ad.qw.qw();
            Application application = this.this$0.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            List second = qw.when(application).getSecond();
            qw.ad("pdf_merge_import", "allExportList=" + second.size());
            ArrayList<ScanRecordExportFile> arrayList = new ArrayList<>();
            for (Object next : second) {
                if (fe.mmm.qw.o.qw.qw.ad.ad.rg(((ScanRecordExportFile) next).getLocalPath())) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (ScanRecordExportFile addPdfItemData : arrayList) {
                arrayList2.add(new AddPdfItemData(addPdfItemData, false, 2, (DefaultConstructorMarker) null));
            }
            return arrayList2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
