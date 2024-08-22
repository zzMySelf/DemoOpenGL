package com.tera.scan.pdfedit.viewmodel;

import android.app.Application;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tera/scan/pdfedit/viewmodel/PdfMergeAddViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_loadingLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_pdfListLiveData", "", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "loadingLiveData", "Landroidx/lifecycle/LiveData;", "getLoadingLiveData", "()Landroidx/lifecycle/LiveData;", "pdfListLiveData", "getPdfListLiveData", "getSelectPdfItems", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "initPdfList", "", "toggleSelectPdfItem", "position", "", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAddViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LiveData<Boolean> f7087ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<List<AddPdfItemData>> f7088de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final LiveData<List<AddPdfItemData>> f7089fe;
    @NotNull
    public final MutableLiveData<Boolean> qw;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAddViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.qw = mutableLiveData;
        this.f7087ad = mutableLiveData;
        MutableLiveData<List<AddPdfItemData>> mutableLiveData2 = new MutableLiveData<>();
        this.f7088de = mutableLiveData2;
        this.f7089fe = mutableLiveData2;
    }

    @NotNull
    public final LiveData<Boolean> getLoadingLiveData() {
        return this.f7087ad;
    }

    @NotNull
    public final LiveData<List<AddPdfItemData>> getPdfListLiveData() {
        return this.f7089fe;
    }

    @NotNull
    public final List<ScanRecordExportFile> getSelectPdfItems() {
        List value = this.f7088de.getValue();
        if (value == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<AddPdfItemData> arrayList = new ArrayList<>();
        for (Object next : value) {
            if (((AddPdfItemData) next).isSelected()) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (AddPdfItemData scanRecordExportFile : arrayList) {
            arrayList2.add(scanRecordExportFile.getScanRecordExportFile());
        }
        return arrayList2;
    }

    public final void initPdfList() {
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PdfMergeAddViewModel$initPdfList$1(this, (Continuation<? super PdfMergeAddViewModel$initPdfList$1>) null), 3, (Object) null);
    }

    public final void toggleSelectPdfItem(int i2) {
        List value = this.f7088de.getValue();
        if (value != null) {
            boolean z = false;
            if (i2 >= 0 && i2 < value.size()) {
                z = true;
            }
            if (z) {
                AddPdfItemData addPdfItemData = (AddPdfItemData) value.get(i2);
                addPdfItemData.setSelected(true ^ addPdfItemData.isSelected());
            }
            this.f7088de.setValue(value);
        }
    }
}
