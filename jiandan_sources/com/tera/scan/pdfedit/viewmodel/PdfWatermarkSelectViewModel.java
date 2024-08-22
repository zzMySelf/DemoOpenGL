package com.tera.scan.pdfedit.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.common.net.MediaType;
import com.tera.scan.pdfedit.data.AddPdfItemData;
import com.tera.scan.record.model.ScanRecordExportFile;
import i.qw.Cif;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\rJ\u0011\u0010\u001e\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\bJ\u0006\u0010$\u001a\u00020\u001bJ\b\u0010%\u001a\u00020\u001bH\u0014R&\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R'\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/tera/scan/pdfedit/viewmodel/PdfWatermarkSelectViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_convertPdfToLocalImageResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "_loadingLiveData", "", "_pdfListLiveData", "Ljava/util/ArrayList;", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "Lkotlin/collections/ArrayList;", "convertPdfToLocalImageJob", "Lkotlinx/coroutines/Job;", "convertPdfToLocalImageResultLiveData", "Landroidx/lifecycle/LiveData;", "getConvertPdfToLocalImageResultLiveData", "()Landroidx/lifecycle/LiveData;", "loadingLiveData", "getLoadingLiveData", "pdfListLiveData", "getPdfListLiveData", "addPdfItems", "", "scanRecordExportFiles", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "doInitPdfData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConvertPdfToLocalImages", "context", "Landroid/content/Context;", "mLocalPath", "initPdfList", "onCleared", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfWatermarkSelectViewModel extends AndroidViewModel {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<ArrayList<AddPdfItemData>> f7143ad = new MutableLiveData<>();
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<Pair<String, List<String>>> f7144de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public Job f7145fe;
    @NotNull
    public final MutableLiveData<Boolean> qw = new MutableLiveData<>();
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final LiveData<Boolean> f7146rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final LiveData<ArrayList<AddPdfItemData>> f7147th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final LiveData<Pair<String, List<String>>> f7148yj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfWatermarkSelectViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        MutableLiveData<Pair<String, List<String>>> mutableLiveData = new MutableLiveData<>();
        this.f7144de = mutableLiveData;
        this.f7146rg = this.qw;
        this.f7147th = this.f7143ad;
        this.f7148yj = mutableLiveData;
    }

    public final void addPdfItems(@Nullable ArrayList<ScanRecordExportFile> arrayList) {
        if (!(arrayList == null || arrayList.isEmpty())) {
            ArrayList value = this.f7143ad.getValue();
            if (value == null) {
                value = new ArrayList();
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (ScanRecordExportFile addPdfItemData : arrayList) {
                arrayList2.add(new AddPdfItemData(addPdfItemData, false, 2, (DefaultConstructorMarker) null));
            }
            value.addAll(0, arrayList2);
            this.f7143ad.setValue(value);
        }
    }

    @NotNull
    public final LiveData<Pair<String, List<String>>> getConvertPdfToLocalImageResultLiveData() {
        return this.f7148yj;
    }

    public final void getConvertPdfToLocalImages(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str != null) {
            this.qw.setValue(Boolean.TRUE);
            Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1(this, str, context, (Continuation<? super PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1>) null), 3, (Object) null);
        }
    }

    @NotNull
    public final LiveData<Boolean> getLoadingLiveData() {
        return this.f7146rg;
    }

    @NotNull
    public final LiveData<ArrayList<AddPdfItemData>> getPdfListLiveData() {
        return this.f7147th;
    }

    public final void initPdfList() {
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PdfWatermarkSelectViewModel$initPdfList$1(this, (Continuation<? super PdfWatermarkSelectViewModel$initPdfList$1>) null), 3, (Object) null);
    }

    public void onCleared() {
        super.onCleared();
        Job job = this.f7145fe;
        if (job != null) {
            Job.qw.qw(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0090 A[LOOP:1: B:23:0x0089->B:25:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object qw(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$doInitPdfData$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$doInitPdfData$1 r0 = (com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$doInitPdfData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$doInitPdfData$1 r0 = new com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$doInitPdfData$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel r0 = (com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004e
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.CoroutineDispatcher r9 = i.qw.u.ad()
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$doInitPdfData$records$1 r2 = new com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$doInitPdfData$records$1
            r2.<init>(r8, r3)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = i.qw.o.yj(r9, r2, r0)
            if (r9 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r8
        L_0x004e:
            kotlin.Pair r9 = (kotlin.Pair) r9
            java.lang.Object r9 = r9.getSecond()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x005f:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x007a
            java.lang.Object r2 = r9.next()
            r5 = r2
            com.tera.scan.record.model.ScanRecordExportFile r5 = (com.tera.scan.record.model.ScanRecordExportFile) r5
            java.lang.String r5 = r5.getLocalPath()
            boolean r5 = fe.mmm.qw.o.qw.qw.ad.ad.rg(r5)
            if (r5 == 0) goto L_0x005f
            r1.add(r2)
            goto L_0x005f
        L_0x007a:
            java.util.ArrayList r9 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r2)
            r9.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0089:
            boolean r2 = r1.hasNext()
            r5 = 0
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r1.next()
            com.tera.scan.record.model.ScanRecordExportFile r2 = (com.tera.scan.record.model.ScanRecordExportFile) r2
            com.tera.scan.pdfedit.data.AddPdfItemData r6 = new com.tera.scan.pdfedit.data.AddPdfItemData
            r7 = 2
            r6.<init>(r2, r5, r7, r3)
            r9.add(r6)
            goto L_0x0089
        L_0x00a0:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = r9.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x00af
            r1.addAll(r9)
        L_0x00af:
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.tera.scan.pdfedit.data.AddPdfItemData>> r9 = r0.f7143ad
            r9.postValue(r1)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r9 = r0.qw
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r9.postValue(r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel.qw(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
