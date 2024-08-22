package com.tera.scan.pdfedit.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.baidu.aiscan.R;
import com.github.barteksc.pdfviewer.PDFThumb;
import com.google.common.net.MediaType;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.j.th;
import fe.mmm.qw.qqq.o.fe;
import i.qw.Cif;
import i.qw.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0001<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010%\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0016\u0010(\u001a\u00020\u00162\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\b\u0010)\u001a\u00020'H\u0014J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010\u0016H\u0002JL\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0016H\u0002J\u0016\u00106\u001a\u00020'2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160\u001eH\u0002J.\u00107\u001a\u00020'2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0016H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b#\u0010\u0010¨\u0006="}, d2 = {"Lcom/tera/scan/pdfedit/viewmodel/PdfMergingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_mergePdfResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tera/scan/pdfedit/viewmodel/MergePdfEvent;", "_mergeProgressLiveData", "", "completePdfCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "completePdfPageCount", "createPdfDir", "Ljava/io/File;", "getCreatePdfDir", "()Ljava/io/File;", "createPdfDir$delegate", "Lkotlin/Lazy;", "mergeJob", "Lkotlinx/coroutines/Job;", "mergePdfFileName", "", "mergePdfResultLiveData", "Landroidx/lifecycle/LiveData;", "getMergePdfResultLiveData", "()Landroidx/lifecycle/LiveData;", "mergeProgressLiveData", "getMergeProgressLiveData", "pdfList", "Ljava/util/ArrayList;", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "replaceOldDocFile", "", "tempDir", "getTempDir", "tempDir$delegate", "calculateTotalPages", "cleanTempFile", "", "getEstimatedFileSizeDesc", "onCleared", "onCreatePdfFinish", "path", "onLoadPdfSucceed", "pdfThumb", "Lcom/tera/scan/pdfedit/util/PdfHdImageProxy;", "pdfFile", "filesLocalPath", "currentPdfBitmapRenderedCompleteCount", "allPdfPageCount", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "pdfMergeSuccess", "startCreateLocalPdf", "startMergePdfList", "fileName", "activity", "Landroid/app/Activity;", "writePdfToDb", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergingViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<Integer> f7095ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final LiveData<Integer> f7096de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final AtomicInteger f7097fe = new AtomicInteger(0);
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Lazy f7098i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public String f292if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final Lazy f7099o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public Job f7100pf;
    @NotNull
    public final Application qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final MutableLiveData<fe> f7101rg;
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final AtomicInteger f293switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final LiveData<fe> f7102th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public ArrayList<ScanRecordExportFile> f7103uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f7104yj;

    public static final class ad implements PDFThumb.IThumbCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f7105ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ ScanRecordExportFile f7106de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ ArrayList<String> f7107fe;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ArrayList<ScanRecordExportFile> f7108i;
        public final /* synthetic */ PdfMergingViewModel qw;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f7109rg;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f7110th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f7111uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ fe.mmm.qw.qqq.i.de f7112yj;

        public ad(PdfMergingViewModel pdfMergingViewModel, CountDownLatch countDownLatch, ScanRecordExportFile scanRecordExportFile, ArrayList<String> arrayList, AtomicInteger atomicInteger, int i2, fe.mmm.qw.qqq.i.de deVar, int i3, ArrayList<ScanRecordExportFile> arrayList2) {
            this.qw = pdfMergingViewModel;
            this.f7105ad = countDownLatch;
            this.f7106de = scanRecordExportFile;
            this.f7107fe = arrayList;
            this.f7109rg = atomicInteger;
            this.f7110th = i2;
            this.f7112yj = deVar;
            this.f7111uk = i3;
            this.f7108i = arrayList2;
        }

        public void ad(int i2) {
            fe.mmm.qw.i.qw.ad("merge_pdf", this.f7106de.getFileName() + " page=" + i2 + " 加载失败");
            de();
        }

        public final void de() {
            this.f7109rg.getAndIncrement();
            if (this.f7109rg.get() == this.f7110th) {
                this.qw.f7097fe.getAndIncrement();
                this.f7112yj.m996if();
            }
            int size = (this.f7107fe.size() * 80) / this.f7111uk;
            Integer num = (Integer) this.qw.f7095ad.getValue();
            if (num == null || size != num.intValue()) {
                fe.mmm.qw.i.qw.ad("merge_pdf", "更新保存image进度 savePdfImageProgress=" + size);
                this.qw.f7095ad.postValue(Integer.valueOf(size));
            }
            if (this.qw.f7097fe.get() == this.f7108i.size()) {
                this.qw.uk(this.f7107fe);
            }
            if (this.f7109rg.get() == this.f7110th) {
                this.f7105ad.countDown();
            }
        }

        public void qw(int i2, @Nullable Bitmap bitmap) {
            Job access$getMergeJob$p = this.qw.f7100pf;
            if (access$getMergeJob$p != null && access$getMergeJob$p.isCancelled()) {
                this.f7105ad.countDown();
                return;
            }
            fe.mmm.qw.i.qw.ad("merge_pdf", "onBitmapRendered userPage=" + i2 + " file=" + this.f7106de.getFileName() + "  " + Thread.currentThread().getName());
            StringBuilder sb = new StringBuilder();
            sb.append(this.qw.fe().getAbsolutePath());
            sb.append(File.separator);
            String format = String.format("page_%s%s.jpg", Arrays.copyOf(new Object[]{this.f7106de.getFileName(), Integer.valueOf(i2)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            sb.append(format);
            String sb2 = sb.toString();
            fe.mmm.qw.j.ddd.ad.uk(bitmap, sb2);
            this.f7107fe.add(sb2);
            if (bitmap != null) {
                bitmap.recycle();
            }
            de();
        }
    }

    public static final class de implements IPdfEditCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ArrayList<String> f7113ad;
        public final /* synthetic */ PdfMergingViewModel qw;

        public de(PdfMergingViewModel pdfMergingViewModel, ArrayList<String> arrayList) {
            this.qw = pdfMergingViewModel;
            this.f7113ad = arrayList;
        }

        public void ad(@Nullable String str) {
            this.qw.f293switch.addAndGet(this.f7113ad.size());
            this.qw.rg(str);
        }

        public void qw(int i2) {
            int i3 = ((i2 / 100) * 20) + 80;
            boolean z = false;
            if (i3 >= 0 && i3 < 101) {
                z = true;
            }
            int i4 = z ? i3 : 100;
            Integer num = (Integer) this.qw.f7095ad.getValue();
            if (num == null || i4 != num.intValue()) {
                fe.mmm.qw.i.qw.ad("merge_pdf", "更新create pdf进度  result=" + i3 + "  progress=" + i2);
                this.qw.f7095ad.postValue(Integer.valueOf(i4));
            }
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
    public PdfMergingViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.qw = application;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.f7095ad = mutableLiveData;
        this.f7096de = mutableLiveData;
        MutableLiveData<fe> mutableLiveData2 = new MutableLiveData<>();
        this.f7101rg = mutableLiveData2;
        this.f7102th = mutableLiveData2;
        this.f7098i = LazyKt__LazyJVMKt.lazy(new PdfMergingViewModel$createPdfDir$2(this));
        this.f7099o = LazyKt__LazyJVMKt.lazy(new PdfMergingViewModel$tempDir$2(this));
        this.f292if = "";
        this.f293switch = new AtomicInteger(0);
    }

    public final void ad() {
        fe.mmm.qw.j.xxx.ad.rg(fe());
    }

    public final File de() {
        return (File) this.f7098i.getValue();
    }

    public final File fe() {
        return (File) this.f7099o.getValue();
    }

    @NotNull
    public final String getEstimatedFileSizeDesc(@Nullable ArrayList<ScanRecordExportFile> arrayList) {
        long j = 0;
        if (arrayList != null) {
            for (ScanRecordExportFile size : arrayList) {
                j += (long) size.getSize();
            }
        }
        String string = this.qw.getString(R.string.pdf_merge_estimated_file_size, new Object[]{th.qw(j)});
        Intrinsics.checkNotNullExpressionValue(string, "application.getString(R.…matFileSize(allFileSize))");
        return string;
    }

    @NotNull
    public final LiveData<fe> getMergePdfResultLiveData() {
        return this.f7102th;
    }

    @NotNull
    public final LiveData<Integer> getMergeProgressLiveData() {
        return this.f7096de;
    }

    public final void i(String str) {
        ScanRecordExportFile qw2 = ScanRecordExportFile.Companion.qw(this.qw, str);
        if (fe.mmm.qw.rrr.qw.ad.qw.qw().pf(this.qw, CollectionsKt__CollectionsJVMKt.listOf(qw2))) {
            this.f7101rg.postValue(new fe.ad(qw2, this.f293switch.get()));
        } else {
            this.f7101rg.postValue(new fe.qw(R.string.pdf_fail_write_pdf_fail));
        }
    }

    public void onCleared() {
        super.onCleared();
        Job job = this.f7100pf;
        if (job != null) {
            Job.qw.qw(job, (CancellationException) null, 1, (Object) null);
        }
        ad();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bc A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e1 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f4 A[Catch:{ all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fa A[Catch:{ all -> 0x0100 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int qw(java.util.ArrayList<com.tera.scan.record.model.ScanRecordExportFile> r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r2 = "merge_pdf"
            com.shockwave.pdfium.PdfiumCore r13 = new com.shockwave.pdfium.PdfiumCore
            android.app.Application r0 = r1.qw
            r13.<init>(r0)
            java.util.Iterator r14 = r21.iterator()
            r15 = 0
            r16 = 0
        L_0x0012:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x010b
            java.lang.Object r0 = r14.next()
            com.tera.scan.record.model.ScanRecordExportFile r0 = (com.tera.scan.record.model.ScanRecordExportFile) r0
            java.lang.String r3 = r0.getLocalPath()
            r4 = 1
            if (r3 == 0) goto L_0x002e
            int r3 = r3.length()
            if (r3 != 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r3 = 0
            goto L_0x002f
        L_0x002e:
            r3 = 1
        L_0x002f:
            if (r3 == 0) goto L_0x0032
            goto L_0x0012
        L_0x0032:
            r12 = 0
            java.io.File r3 = new java.io.File     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            java.lang.String r5 = r0.getLocalPath()     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            r3.<init>(r5)     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            fe.if.ad.qw.if.de r5 = new fe.if.ad.qw.if.de     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            r5.<init>(r3)     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            android.app.Application r3 = r1.qw     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            com.shockwave.pdfium.PdfDocument r5 = r5.qw(r3, r13, r12)     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            fe.if.ad.qw.th r17 = new fe.if.ad.qw.th     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            com.github.barteksc.pdfviewer.util.FitPolicy r6 = com.github.barteksc.pdfviewer.util.FitPolicy.WIDTH     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            com.shockwave.pdfium.util.Size r7 = new com.shockwave.pdfium.util.Size     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            r7.<init>(r4, r4)     // Catch:{ PdfPasswordException -> 0x00c3, Exception -> 0x0098, all -> 0x0093 }
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 0
            r18 = 1
            r3 = r17
            r4 = r13
            r19 = r12
            r12 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ PdfPasswordException -> 0x0090, Exception -> 0x008d, all -> 0x0088 }
            int r0 = r17.ggg()     // Catch:{ PdfPasswordException -> 0x0085, Exception -> 0x0082, all -> 0x007c }
            int r16 = r16 + r0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0071 }
            r17.ad()     // Catch:{ all -> 0x0071 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0071 }
            kotlin.Result.m1155constructorimpl(r0)     // Catch:{ all -> 0x0071 }
            goto L_0x0012
        L_0x0071:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
            goto L_0x0012
        L_0x007c:
            r0 = move-exception
            r2 = r0
            r12 = r17
            goto L_0x00f0
        L_0x0082:
            r12 = r17
            goto L_0x009a
        L_0x0085:
            r12 = r17
            goto L_0x00c5
        L_0x0088:
            r0 = move-exception
            r2 = r0
            r12 = r19
            goto L_0x00f0
        L_0x008d:
            r12 = r19
            goto L_0x009a
        L_0x0090:
            r12 = r19
            goto L_0x00c5
        L_0x0093:
            r0 = move-exception
            r19 = r12
        L_0x0096:
            r2 = r0
            goto L_0x00f0
        L_0x0098:
            r19 = r12
        L_0x009a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r3.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r0.getFileName()     // Catch:{ all -> 0x00ee }
            r3.append(r0)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = " pdf 损坏"
            r3.append(r0)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ee }
            fe.mmm.qw.i.qw.ad(r2, r0)     // Catch:{ all -> 0x00ee }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0071 }
            if (r12 == 0) goto L_0x00bc
            r12.ad()     // Catch:{ all -> 0x0071 }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0071 }
            goto L_0x00be
        L_0x00bc:
            r12 = r19
        L_0x00be:
            kotlin.Result.m1155constructorimpl(r12)     // Catch:{ all -> 0x0071 }
            goto L_0x0012
        L_0x00c3:
            r19 = r12
        L_0x00c5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r3.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r0.getFileName()     // Catch:{ all -> 0x00ee }
            r3.append(r0)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = " pdf 需要密码"
            r3.append(r0)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ee }
            fe.mmm.qw.i.qw.ad(r2, r0)     // Catch:{ all -> 0x00ee }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0071 }
            if (r12 == 0) goto L_0x00e7
            r12.ad()     // Catch:{ all -> 0x0071 }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0071 }
            goto L_0x00e9
        L_0x00e7:
            r12 = r19
        L_0x00e9:
            kotlin.Result.m1155constructorimpl(r12)     // Catch:{ all -> 0x0071 }
            goto L_0x0012
        L_0x00ee:
            r0 = move-exception
            goto L_0x0096
        L_0x00f0:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0100 }
            if (r12 == 0) goto L_0x00fa
            r12.ad()     // Catch:{ all -> 0x0100 }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0100 }
            goto L_0x00fc
        L_0x00fa:
            r12 = r19
        L_0x00fc:
            kotlin.Result.m1155constructorimpl(r12)     // Catch:{ all -> 0x0100 }
            goto L_0x010a
        L_0x0100:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x010a:
            throw r2
        L_0x010b:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.pdfedit.viewmodel.PdfMergingViewModel.qw(java.util.ArrayList):int");
    }

    public final void rg(String str) {
        Job job = this.f7100pf;
        boolean z = true;
        if (!(job != null && job.isCancelled())) {
            fe.mmm.qw.i.qw.ad("merge_pdf", "合并结束 path=" + str);
            if (!(str == null || str.length() == 0)) {
                z = false;
            }
            if (z) {
                this.f7101rg.postValue(new fe.qw(R.string.pdf_fail_write_pdf_fail));
            } else {
                yj(str);
            }
            ad();
        }
    }

    public final void startMergePdfList(@Nullable ArrayList<ScanRecordExportFile> arrayList, boolean z, @NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.f7104yj = z;
        this.f7103uk = arrayList;
        this.f292if = str;
        boolean z2 = false;
        this.f7097fe.set(0);
        if (arrayList == null || arrayList.isEmpty()) {
            z2 = true;
        }
        if (z2) {
            this.f7101rg.postValue(new fe.qw(R.string.pdf_fail_read_pdf_fail));
        } else {
            this.f7100pf = Cif.fe(ViewModelKt.getViewModelScope(this), u.ad(), (CoroutineStart) null, new PdfMergingViewModel$startMergePdfList$1(this, arrayList, activity, (Continuation<? super PdfMergingViewModel$startMergePdfList$1>) null), 2, (Object) null);
        }
    }

    public final void th(fe.mmm.qw.qqq.i.de deVar, ScanRecordExportFile scanRecordExportFile, ArrayList<String> arrayList, AtomicInteger atomicInteger, int i2, ArrayList<ScanRecordExportFile> arrayList2, CountDownLatch countDownLatch) {
        fe.mmm.qw.qqq.i.de deVar2 = deVar;
        int ad2 = deVar.ad();
        deVar.ddd(new ad(this, countDownLatch, scanRecordExportFile, arrayList, atomicInteger, ad2, deVar, i2, arrayList2));
        for (int i3 = 0; i3 < ad2; i3++) {
            deVar.vvv(i3);
        }
    }

    public final void uk(ArrayList<String> arrayList) {
        Job job = this.f7100pf;
        boolean z = true;
        if (job == null || !job.isCancelled()) {
            z = false;
        }
        if (!z) {
            fe.mmm.qw.i.qw.ad("merge_pdf", "开始合并 " + Thread.currentThread().getName());
            Application application = this.qw;
            fe.mmm.qw.qqq.ad.qw.qw.qw(application, de().getAbsolutePath() + File.separator + this.f292if + ".pdf", new ArrayList(arrayList), false, false, new de(this, arrayList));
        }
    }

    public final void yj(String str) {
        ArrayList<ScanRecordExportFile> arrayList;
        i(str);
        if (this.f7104yj && (arrayList = this.f7103uk) != null && fe.mmm.qw.rrr.qw.ad.qw.qw().th(this.qw, arrayList) > 0) {
            for (ScanRecordExportFile localPath : arrayList) {
                fe.mmm.qw.j.xxx.ad.fe(localPath.getLocalPath());
            }
        }
    }
}
