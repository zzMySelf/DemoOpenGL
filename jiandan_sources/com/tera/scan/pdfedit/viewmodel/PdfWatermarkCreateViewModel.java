package com.tera.scan.pdfedit.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.common.net.MediaType;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.qqq.o.de;
import i.qw.Cif;
import i.qw.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JG\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010&\u001a\u00020\u0019H\u0014J\u0012\u0010'\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J(\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0002J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/tera/scan/pdfedit/viewmodel/PdfWatermarkCreateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_createWatermarkPdfResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tera/scan/pdfedit/viewmodel/CreateWatermarkPdfEvent;", "_loadingLiveData", "", "createWatermarkPdfResultLiveData", "Landroidx/lifecycle/LiveData;", "getCreateWatermarkPdfResultLiveData", "()Landroidx/lifecycle/LiveData;", "loadingLiveData", "getLoadingLiveData", "tempDir", "Ljava/io/File;", "getTempDir", "()Ljava/io/File;", "tempDir$delegate", "Lkotlin/Lazy;", "watermarkCreateJob", "Lkotlinx/coroutines/Job;", "createWatermarkPdf", "", "path", "", "watermarkText", "watermarkTextSize", "", "watermarkTextSizeScale", "watermarkTextTransparency", "watermarkTextColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getAvailableNewPath", "oldPath", "fileOldName", "onCleared", "onCreatePdfFinish", "startCreateLocalPdf", "originLocalPath", "filesLocalPath", "", "writePdfToDb", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfWatermarkCreateViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String DEFAULT_WATERMARK_PATH_NAME = "watermark";
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Lazy f7137ad = LazyKt__LazyJVMKt.lazy(new PdfWatermarkCreateViewModel$tempDir$2(this));
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public Job f7138de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final MutableLiveData<Boolean> f7139fe = new MutableLiveData<>();
    @NotNull
    public final Application qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final MutableLiveData<de> f7140rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final LiveData<de> f7141th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final LiveData<Boolean> f7142yj;

    public static final class ad implements IPdfEditCallback {
        public final /* synthetic */ PdfWatermarkCreateViewModel qw;

        public ad(PdfWatermarkCreateViewModel pdfWatermarkCreateViewModel) {
            this.qw = pdfWatermarkCreateViewModel;
        }

        public void ad(@Nullable String str) {
            this.qw.de(str);
        }

        public void qw(int i2) {
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfWatermarkCreateViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.qw = application;
        MutableLiveData<de> mutableLiveData = new MutableLiveData<>();
        this.f7140rg = mutableLiveData;
        this.f7141th = mutableLiveData;
        this.f7142yj = this.f7139fe;
    }

    public final File ad() {
        return (File) this.f7137ad.getValue();
    }

    public final void createWatermarkPdf(@Nullable String str, @Nullable String str2, @Nullable Double d, @Nullable Double d2, @Nullable Double d3, @Nullable String str3) {
        if (str == null || str.length() == 0) {
            this.f7140rg.postValue(new de.qw((Integer) null));
            return;
        }
        this.f7139fe.setValue(Boolean.TRUE);
        this.f7138de = Cif.fe(ViewModelKt.getViewModelScope(this), u.ad(), (CoroutineStart) null, new PdfWatermarkCreateViewModel$createWatermarkPdf$1(str, this, str2, d, d2, d3, str3, (Continuation<? super PdfWatermarkCreateViewModel$createWatermarkPdf$1>) null), 2, (Object) null);
    }

    public final void de(String str) {
        this.f7139fe.postValue(Boolean.FALSE);
        Job job = this.f7138de;
        boolean z = true;
        if (job != null && job.isCancelled()) {
            this.f7140rg.postValue(new de.qw((Integer) null));
            return;
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            this.f7140rg.postValue(new de.qw((Integer) null));
        } else {
            rg(str);
        }
    }

    public final void fe(String str, String str2, List<String> list) {
        Job job = this.f7138de;
        boolean z = true;
        if (job == null || !job.isCancelled()) {
            z = false;
        }
        if (z) {
            this.f7140rg.postValue(new de.qw((Integer) null));
            return;
        }
        fe.mmm.qw.qqq.ad.qw.qw.qw(this.qw, qw(str, str2), new ArrayList(list), false, false, new ad(this));
    }

    @NotNull
    public final LiveData<de> getCreateWatermarkPdfResultLiveData() {
        return this.f7141th;
    }

    @NotNull
    public final LiveData<Boolean> getLoadingLiveData() {
        return this.f7142yj;
    }

    public void onCleared() {
        super.onCleared();
        Job job = this.f7138de;
        if (job != null) {
            Job.qw.qw(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final String qw(String str, String str2) {
        String str3;
        String sb;
        int i2 = 0;
        do {
            if (i2 == 0) {
                str3 = str2 + " watermark";
            } else {
                str3 = str2 + " watermark(" + i2 + ')';
            }
            StringBuilder sb2 = new StringBuilder();
            String substring = str.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb2.append(substring);
            sb2.append('/');
            sb2.append(str3);
            sb2.append(".pdf");
            sb = sb2.toString();
            i2++;
        } while (new File(sb).exists());
        return sb;
    }

    public final void rg(String str) {
        ScanRecordExportFile qw2 = ScanRecordExportFile.Companion.qw(this.qw, str);
        if (fe.mmm.qw.rrr.qw.ad.qw.qw().pf(this.qw, CollectionsKt__CollectionsJVMKt.listOf(qw2))) {
            this.f7140rg.postValue(new de.ad(qw2));
        } else {
            this.f7140rg.postValue(new de.qw((Integer) null));
        }
    }
}
