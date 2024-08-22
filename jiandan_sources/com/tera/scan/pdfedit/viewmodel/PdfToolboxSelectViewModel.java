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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\tJ\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/pdfedit/viewmodel/PdfToolboxSelectViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_loadingLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_pdfListLiveData", "Ljava/util/ArrayList;", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "loadingLiveData", "Landroidx/lifecycle/LiveData;", "getLoadingLiveData", "()Landroidx/lifecycle/LiveData;", "pdfListLiveData", "getPdfListLiveData", "addPdfItems", "", "scanRecordExportFiles", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "getSelectPdfItem", "position", "", "getSelectPdfItems", "initPdfList", "toggleSelectPdfItem", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfToolboxSelectViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LiveData<Boolean> f7134ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<ArrayList<AddPdfItemData>> f7135de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final LiveData<ArrayList<AddPdfItemData>> f7136fe;
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
    public PdfToolboxSelectViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.qw = mutableLiveData;
        this.f7134ad = mutableLiveData;
        MutableLiveData<ArrayList<AddPdfItemData>> mutableLiveData2 = new MutableLiveData<>();
        this.f7135de = mutableLiveData2;
        this.f7136fe = mutableLiveData2;
    }

    public final void addPdfItems(@Nullable ArrayList<ScanRecordExportFile> arrayList) {
        if (!(arrayList == null || arrayList.isEmpty())) {
            ArrayList value = this.f7135de.getValue();
            if (value == null) {
                value = new ArrayList();
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (ScanRecordExportFile addPdfItemData : arrayList) {
                arrayList2.add(new AddPdfItemData(addPdfItemData, false, 2, (DefaultConstructorMarker) null));
            }
            value.addAll(0, arrayList2);
            this.f7135de.setValue(value);
        }
    }

    @NotNull
    public final LiveData<Boolean> getLoadingLiveData() {
        return this.f7134ad;
    }

    @NotNull
    public final LiveData<ArrayList<AddPdfItemData>> getPdfListLiveData() {
        return this.f7136fe;
    }

    @Nullable
    public final ScanRecordExportFile getSelectPdfItem(int i2) {
        ArrayList value = this.f7135de.getValue();
        if (value == null) {
            return null;
        }
        boolean z = false;
        if (i2 >= 0 && i2 < value.size()) {
            z = true;
        }
        if (z) {
            return ((AddPdfItemData) value.get(i2)).getScanRecordExportFile();
        }
        return null;
    }

    @NotNull
    public final ArrayList<ScanRecordExportFile> getSelectPdfItems() {
        ArrayList value = this.f7135de.getValue();
        if (value == null) {
            return new ArrayList<>();
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
        ArrayList<ScanRecordExportFile> arrayList3 = new ArrayList<>();
        if (!arrayList2.isEmpty()) {
            arrayList3.addAll(arrayList2);
        }
        return arrayList3;
    }

    public final void initPdfList() {
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PdfToolboxSelectViewModel$initPdfList$1(this, (Continuation<? super PdfToolboxSelectViewModel$initPdfList$1>) null), 3, (Object) null);
    }

    public final void toggleSelectPdfItem(int i2) {
        ArrayList value = this.f7135de.getValue();
        if (value != null) {
            boolean z = false;
            if (i2 >= 0 && i2 < value.size()) {
                z = true;
            }
            if (z) {
                Object obj = value.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                AddPdfItemData addPdfItemData = (AddPdfItemData) obj;
                addPdfItemData.setSelected(true ^ addPdfItemData.isSelected());
            }
            this.f7135de.setValue(value);
        }
    }
}
