package com.tera.scan.pdfedit.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.baidu.aiscan.R;
import com.google.common.net.MediaType;
import com.shockwave.pdfium.PdfiumCore;
import com.tera.scan.record.model.ScanRecordExportFile;
import i.qw.Cif;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 ,2\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0018\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\tj\b\u0012\u0004\u0012\u00020\u001b`\u000bJ\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007J\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\tj\b\u0012\u0004\u0012\u00020\u001b`\u000bJ\u0006\u0010$\u001a\u00020\u0007J\"\u0010%\u001a\u00020\u00192\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u000bJ,\u0010'\u001a\u00020\u00192\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u000b2\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0016\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lcom/tera/scan/pdfedit/viewmodel/PdfMergeAdjustFileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_loading", "Landroidx/lifecycle/MutableLiveData;", "", "_pdfListLiveData", "Ljava/util/ArrayList;", "Lcom/tera/scan/pdfedit/data/MergePdfItemData;", "Lkotlin/collections/ArrayList;", "loading", "Landroidx/lifecycle/LiveData;", "getLoading", "()Landroidx/lifecycle/LiveData;", "pdfListLiveData", "getPdfListLiveData", "pdfiumCore", "Lcom/shockwave/pdfium/PdfiumCore;", "getPdfiumCore", "()Lcom/shockwave/pdfium/PdfiumCore;", "pdfiumCore$delegate", "Lkotlin/Lazy;", "addPdfItem", "", "addList", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "deletePdfItem", "position", "", "mergePdfItemData", "getCreatePdfDefaultName", "", "replaceOldDocFile", "getPdfList", "hasEncryptPdf", "initPdfData", "pdfList", "parsePdfListInfo", "isInit", "swapPdfItem", "longClickPosition", "actionUpPosition", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAdjustFileViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<Boolean> f7090ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final LiveData<Boolean> f7091de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final MutableLiveData<ArrayList<fe.mmm.qw.qqq.rg.qw>> f7092fe;
    @NotNull
    public final Application qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final LiveData<ArrayList<fe.mmm.qw.qqq.rg.qw>> f7093rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lazy f7094th = LazyKt__LazyJVMKt.lazy(new PdfMergeAdjustFileViewModel$pdfiumCore$2(this));

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAdjustFileViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.qw = application;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.f7090ad = mutableLiveData;
        this.f7091de = mutableLiveData;
        MutableLiveData<ArrayList<fe.mmm.qw.qqq.rg.qw>> mutableLiveData2 = new MutableLiveData<>();
        this.f7092fe = mutableLiveData2;
        this.f7093rg = mutableLiveData2;
    }

    public final void ad(ArrayList<ScanRecordExportFile> arrayList, boolean z) {
        this.f7090ad.setValue(Boolean.TRUE);
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PdfMergeAdjustFileViewModel$parsePdfListInfo$1(z, this, arrayList, (Continuation<? super PdfMergeAdjustFileViewModel$parsePdfListInfo$1>) null), 3, (Object) null);
    }

    public final void addPdfItem(@NotNull ArrayList<ScanRecordExportFile> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "addList");
        ad(arrayList, false);
    }

    public final void deletePdfItem(int i2, @NotNull fe.mmm.qw.qqq.rg.qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "mergePdfItemData");
        ArrayList value = this.f7092fe.getValue();
        if (value != null) {
            boolean z = false;
            if (i2 >= 0 && i2 < value.size()) {
                z = true;
            }
            if (z) {
                value.remove(i2);
            }
            this.f7092fe.setValue(value);
        }
    }

    @NotNull
    public final String getCreatePdfDefaultName(boolean z) {
        StringBuilder sb = new StringBuilder("");
        if (z) {
            ArrayList value = this.f7092fe.getValue();
            if (value != null) {
                Iterator it = value.iterator();
                while (it.hasNext()) {
                    sb.append(StringsKt__StringsJVMKt.replace$default(((fe.mmm.qw.qqq.rg.qw) it.next()).ad().getFileName(), ".pdf", "", false, 4, (Object) null));
                }
            }
            sb.append(this.qw.getString(R.string.pdf_default_name_suffix, new Object[]{"1"}));
        } else {
            sb.append(this.qw.getString(R.string.app_name_scan));
            sb.append(new SimpleDateFormat(" MM-dd-yyyy HH:mm", Locale.getDefault()).format(new Date()));
        }
        if (sb.length() > 50) {
            sb.setLength(50);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    @NotNull
    public final LiveData<Boolean> getLoading() {
        return this.f7091de;
    }

    @NotNull
    public final ArrayList<ScanRecordExportFile> getPdfList() {
        ArrayList<ScanRecordExportFile> arrayList = new ArrayList<>();
        ArrayList<fe.mmm.qw.qqq.rg.qw> value = this.f7092fe.getValue();
        if (value != null) {
            for (fe.mmm.qw.qqq.rg.qw ad2 : value) {
                arrayList.add(ad2.ad());
            }
        }
        return arrayList;
    }

    @NotNull
    public final LiveData<ArrayList<fe.mmm.qw.qqq.rg.qw>> getPdfListLiveData() {
        return this.f7093rg;
    }

    public final boolean hasEncryptPdf() {
        ArrayList<fe.mmm.qw.qqq.rg.qw> value = this.f7092fe.getValue();
        if (value == null) {
            return false;
        }
        if ((value instanceof Collection) && value.isEmpty()) {
            return false;
        }
        for (fe.mmm.qw.qqq.rg.qw de2 : value) {
            if (de2.de()) {
                return true;
            }
        }
        return false;
    }

    public final void initPdfData(@Nullable ArrayList<ScanRecordExportFile> arrayList) {
        ad(arrayList, true);
    }

    public final PdfiumCore qw() {
        return (PdfiumCore) this.f7094th.getValue();
    }

    public final void swapPdfItem(int i2, int i3) {
        ArrayList value;
        if (i2 >= 0 && (value = this.f7092fe.getValue()) != null) {
            boolean z = true;
            if (i2 >= 0 && i2 < value.size()) {
                if (i3 < 0 || i3 >= value.size()) {
                    z = false;
                }
                if (z) {
                    Collections.swap(value, i2, i3);
                    this.f7092fe.setValue(value);
                }
            }
        }
    }
}
