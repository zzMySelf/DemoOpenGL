package com.tera.scan.pdfedit.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.baidu.aiscan.R;
import com.github.barteksc.pdfviewer.PDFThumb;
import com.google.common.net.MediaType;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.o.qw.de.qw.uk;
import fe.mmm.qw.qqq.o.rg;
import fe.mmm.qw.yj.th;
import i.qw.Cif;
import i.qw.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0001GB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\bJ\b\u00106\u001a\u000203H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000203H\u0014J\u0012\u0010:\u001a\u0002032\b\u0010;\u001a\u0004\u0018\u000108H\u0002J\u0011\u0010<\u001a\u000203H@ø\u0001\u0000¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u0002032\u0006\u0010;\u001a\u000208H\u0002J\u0016\u0010?\u001a\u0002032\f\u0010@\u001a\b\u0012\u0004\u0012\u0002080AH\u0002J\u0018\u0010B\u001a\u0002032\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u000203J\u0010\u0010F\u001a\u0002032\u0006\u0010;\u001a\u000208H\u0002R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0010\u0010#\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R)\u0010'\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0015R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0015R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0015R\u001b\u0010/\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b0\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lcom/tera/scan/pdfedit/viewmodel/PdfSplitViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_changingItemLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "Lcom/tera/scan/pdfedit/data/SplitPdfItemData;", "_loadingLiveData", "", "_pdfPageDataLiveData", "Ljava/util/ArrayList;", "_splitPdfResultLiveData", "Lcom/tera/scan/pdfedit/viewmodel/SplitPdfEvent;", "allParseCompleteCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "changingItemLiveData", "Landroidx/lifecycle/LiveData;", "getChangingItemLiveData", "()Landroidx/lifecycle/LiveData;", "completePdfPageCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "createPdfDir", "Ljava/io/File;", "getCreatePdfDir", "()Ljava/io/File;", "createPdfDir$delegate", "Lkotlin/Lazy;", "createPdfJob", "Lkotlinx/coroutines/Job;", "isAllSelectLiveData", "loadingLiveData", "getLoadingLiveData", "parseJob", "pdfFile", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "pdfPageCount", "pdfPageDataLiveData", "getPdfPageDataLiveData", "pdfThumb", "Lcom/tera/scan/doc/preview/pdf/ui/PdfThumbProxy;", "selectedCountLiveData", "getSelectedCountLiveData", "splitPdfResultLiveData", "getSplitPdfResultLiveData", "tempDir", "getTempDir", "tempDir$delegate", "changeAllSelectState", "", "changeItemSelectState", "position", "cleanTempFile", "getSplitPdfFileName", "", "onCleared", "onCreatePdfFinish", "path", "onParsePdfSucceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pdfSplitSuccess", "startCreateLocalPdf", "filesLocalPath", "", "startParsePdf", "activity", "Landroid/app/Activity;", "startSplitPdf", "writePdfToDb", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfSplitViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<Pair<Boolean, Boolean>> f7121ad;
    @Nullable
    public Job ddd;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final LiveData<Pair<Boolean, Boolean>> f7122de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final MutableLiveData<rg> f7123fe;
    @NotNull
    public final AtomicInteger ggg;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public uk f7124i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final LiveData<Pair<Boolean, ArrayList<fe.mmm.qw.qqq.rg.ad>>> f296if;
    @NotNull
    public final CountDownLatch nn;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public ScanRecordExportFile f7125o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final MutableLiveData<Pair<Boolean, ArrayList<fe.mmm.qw.qqq.rg.ad>>> f7126pf;
    public int ppp;
    @NotNull
    public final Application qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final LiveData<rg> f7127rg;
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final MutableLiveData<Pair<Integer, fe.mmm.qw.qqq.rg.ad>> f297switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lazy f7128th = LazyKt__LazyJVMKt.lazy(new PdfSplitViewModel$createPdfDir$2(this));
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public Job f7129uk;
    @NotNull
    public final LiveData<Integer> vvv;
    @NotNull
    public final LiveData<Pair<Integer, fe.mmm.qw.qqq.rg.ad>> when;
    @NotNull
    public final LiveData<Boolean> xxx;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Lazy f7130yj = LazyKt__LazyJVMKt.lazy(new PdfSplitViewModel$tempDir$2(this));

    public static final class ad implements PDFThumb.IThumbCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f7131ad;
        public final /* synthetic */ PdfSplitViewModel qw;

        public ad(PdfSplitViewModel pdfSplitViewModel, AtomicInteger atomicInteger) {
            this.qw = pdfSplitViewModel;
            this.f7131ad = atomicInteger;
        }

        public void ad(int i2) {
            StringBuilder sb = new StringBuilder();
            ScanRecordExportFile access$getPdfFile$p = this.qw.f7125o;
            sb.append(access$getPdfFile$p != null ? access$getPdfFile$p.getFileName() : null);
            sb.append(" page=");
            sb.append(i2);
            sb.append(" 加载失败");
            fe.mmm.qw.i.qw.ad("pdf_split", sb.toString());
            de();
        }

        public final void de() {
            this.f7131ad.getAndIncrement();
            if (this.f7131ad.get() == this.qw.ppp && this.qw.nn.getCount() > 0) {
                this.qw.nn.countDown();
            }
        }

        public void qw(int i2, @Nullable Bitmap bitmap) {
            Job access$getParseJob$p = this.qw.f7129uk;
            boolean z = true;
            if (!(access$getParseJob$p != null && access$getParseJob$p.isCancelled())) {
                StringBuilder sb = new StringBuilder();
                sb.append("onBitmapRendered userPage=");
                sb.append(i2);
                sb.append(" file=");
                ScanRecordExportFile access$getPdfFile$p = this.qw.f7125o;
                String str = null;
                sb.append(access$getPdfFile$p != null ? access$getPdfFile$p.getFileName() : null);
                sb.append("  ");
                sb.append(Thread.currentThread().getName());
                fe.mmm.qw.i.qw.ad("pdf_split", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.qw.fe().getAbsolutePath());
                sb2.append(File.separator);
                Object[] objArr = new Object[2];
                ScanRecordExportFile access$getPdfFile$p2 = this.qw.f7125o;
                if (access$getPdfFile$p2 != null) {
                    str = access$getPdfFile$p2.getFileName();
                }
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i2);
                String format = String.format("page_%s%s.jpg", Arrays.copyOf(objArr, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                sb2.append(format);
                String sb3 = sb2.toString();
                fe.mmm.qw.j.ddd.ad.uk(bitmap, sb3);
                if (bitmap != null) {
                    bitmap.recycle();
                }
                Pair pair = (Pair) this.qw.f7126pf.getValue();
                if (pair != null) {
                    PdfSplitViewModel pdfSplitViewModel = this.qw;
                    ArrayList arrayList = (ArrayList) pair.getSecond();
                    if (i2 < 0 || i2 >= arrayList.size()) {
                        z = false;
                    }
                    if (z) {
                        ((fe.mmm.qw.qqq.rg.ad) arrayList.get(i2)).fe(sb3);
                        pdfSplitViewModel.f7126pf.postValue(new Pair(Boolean.FALSE, arrayList));
                        pdfSplitViewModel.f297switch.postValue(new Pair(Integer.valueOf(i2), arrayList.get(i2)));
                    }
                }
                de();
            }
        }
    }

    public static final class de implements IPdfEditCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ List<String> f7132ad;
        public final /* synthetic */ PdfSplitViewModel qw;

        public de(PdfSplitViewModel pdfSplitViewModel, List<String> list) {
            this.qw = pdfSplitViewModel;
            this.f7132ad = list;
        }

        public void ad(@Nullable String str) {
            this.qw.ggg.getAndSet(this.f7132ad.size());
            this.qw.th(str);
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
    public PdfSplitViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.qw = application;
        MutableLiveData<Pair<Boolean, Boolean>> mutableLiveData = new MutableLiveData<>();
        this.f7121ad = mutableLiveData;
        this.f7122de = mutableLiveData;
        MutableLiveData<rg> mutableLiveData2 = new MutableLiveData<>();
        this.f7123fe = mutableLiveData2;
        this.f7127rg = mutableLiveData2;
        MutableLiveData<Pair<Boolean, ArrayList<fe.mmm.qw.qqq.rg.ad>>> mutableLiveData3 = new MutableLiveData<>();
        this.f7126pf = mutableLiveData3;
        this.f296if = mutableLiveData3;
        MutableLiveData<Pair<Integer, fe.mmm.qw.qqq.rg.ad>> mutableLiveData4 = new MutableLiveData<>();
        this.f297switch = mutableLiveData4;
        this.when = mutableLiveData4;
        this.ggg = new AtomicInteger(0);
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(this.f7126pf, new fe.mmm.qw.qqq.o.qw(mediatorLiveData, this));
        this.vvv = mediatorLiveData;
        MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        mediatorLiveData2.addSource(this.f7126pf, new fe.mmm.qw.qqq.o.ad(mediatorLiveData2, this));
        this.xxx = mediatorLiveData2;
        this.nn = new CountDownLatch(1);
    }

    public static final void i(MediatorLiveData mediatorLiveData, PdfSplitViewModel pdfSplitViewModel, Pair pair) {
        ArrayList<fe.mmm.qw.qqq.rg.ad> arrayList;
        Intrinsics.checkNotNullParameter(mediatorLiveData, "$this_apply");
        Intrinsics.checkNotNullParameter(pdfSplitViewModel, "this$0");
        Pair value = pdfSplitViewModel.f7126pf.getValue();
        int i2 = 0;
        if (!(value == null || (arrayList = (ArrayList) value.getSecond()) == null || ((arrayList instanceof Collection) && arrayList.isEmpty()))) {
            for (fe.mmm.qw.qqq.rg.ad de2 : arrayList) {
                if (de2.de() && (i2 = i2 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        mediatorLiveData.setValue(Integer.valueOf(i2));
    }

    public static final void rg(MediatorLiveData mediatorLiveData, PdfSplitViewModel pdfSplitViewModel, Pair pair) {
        Boolean bool;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(mediatorLiveData, "$this_apply");
        Intrinsics.checkNotNullParameter(pdfSplitViewModel, "this$0");
        Pair value = pdfSplitViewModel.f7126pf.getValue();
        if (value == null || (arrayList = (ArrayList) value.getSecond()) == null) {
            bool = Boolean.FALSE;
        } else {
            boolean z = true;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((fe.mmm.qw.qqq.rg.ad) it.next()).de()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            bool = Boolean.valueOf(z);
        }
        mediatorLiveData.setValue(bool);
    }

    public final File ad() {
        return (File) this.f7128th.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        r2 = (java.util.ArrayList) r2.getSecond();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void changeAllSelectState() {
        /*
            r5 = this;
            androidx.lifecycle.LiveData<java.lang.Integer> r0 = r5.vvv
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            r1 = 0
            if (r0 != 0) goto L_0x000f
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
        L_0x000f:
            int r0 = r0.intValue()
            androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.util.ArrayList<fe.mmm.qw.qqq.rg.ad>>> r2 = r5.f7126pf
            java.lang.Object r2 = r2.getValue()
            kotlin.Pair r2 = (kotlin.Pair) r2
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r2.getSecond()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            if (r2 == 0) goto L_0x002a
            int r2 = r2.size()
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            r3 = 1
            if (r3 > r0) goto L_0x0032
            if (r0 >= r2) goto L_0x0032
            r2 = 1
            goto L_0x0033
        L_0x0032:
            r2 = 0
        L_0x0033:
            if (r2 == 0) goto L_0x0037
        L_0x0035:
            r1 = 1
            goto L_0x003a
        L_0x0037:
            if (r0 != 0) goto L_0x003a
            goto L_0x0035
        L_0x003a:
            androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.util.ArrayList<fe.mmm.qw.qqq.rg.ad>>> r0 = r5.f7126pf
            java.lang.Object r2 = r0.getValue()
            kotlin.Pair r2 = (kotlin.Pair) r2
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r2.getSecond()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.Iterator r3 = r2.iterator()
        L_0x004e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r3.next()
            fe.mmm.qw.qqq.rg.ad r4 = (fe.mmm.qw.qqq.rg.ad) r4
            r4.rg(r1)
            goto L_0x004e
        L_0x005e:
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r1.<init>(r3, r2)
            goto L_0x0067
        L_0x0066:
            r1 = 0
        L_0x0067:
            r0.setValue(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel.changeAllSelectState():void");
    }

    public final void changeItemSelectState(int i2) {
        Pair value = this.f7126pf.getValue();
        if (value != null) {
            ArrayList arrayList = (ArrayList) value.getSecond();
            boolean z = false;
            if (i2 >= 0 && i2 < arrayList.size()) {
                z = true;
            }
            if (z) {
                Object obj = arrayList.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj, "dataList[position]");
                fe.mmm.qw.qqq.rg.ad adVar = (fe.mmm.qw.qqq.rg.ad) obj;
                adVar.rg(true ^ adVar.de());
                this.f7126pf.setValue(new Pair(Boolean.FALSE, arrayList));
                MutableLiveData<Pair<Integer, fe.mmm.qw.qqq.rg.ad>> mutableLiveData = this.f297switch;
                Integer valueOf = Integer.valueOf(i2);
                Object obj2 = arrayList.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj2, "dataList[position]");
                mutableLiveData.setValue(new Pair(valueOf, obj2));
            }
        }
    }

    public final String de() {
        ScanRecordExportFile scanRecordExportFile = this.f7125o;
        if (scanRecordExportFile == null) {
            return "";
        }
        int rg2 = th.ppp().rg(scanRecordExportFile.getFileName(), 0);
        return StringsKt__StringsJVMKt.replace$default(scanRecordExportFile.getFileName(), ".pdf", "", false, 4, (Object) null) + this.qw.getString(R.string.pdf_default_name_suffix, new Object[]{String.valueOf(rg2 + 1)}) + ".pdf";
    }

    public final File fe() {
        return (File) this.f7130yj.getValue();
    }

    @NotNull
    public final LiveData<Pair<Integer, fe.mmm.qw.qqq.rg.ad>> getChangingItemLiveData() {
        return this.when;
    }

    @NotNull
    public final LiveData<Pair<Boolean, Boolean>> getLoadingLiveData() {
        return this.f7122de;
    }

    @NotNull
    public final LiveData<Pair<Boolean, ArrayList<fe.mmm.qw.qqq.rg.ad>>> getPdfPageDataLiveData() {
        return this.f296if;
    }

    @NotNull
    public final LiveData<Integer> getSelectedCountLiveData() {
        return this.vvv;
    }

    @NotNull
    public final LiveData<rg> getSplitPdfResultLiveData() {
        return this.f7127rg;
    }

    @NotNull
    public final LiveData<Boolean> isAllSelectLiveData() {
        return this.xxx;
    }

    public final void o(List<String> list) {
        Job job = this.ddd;
        boolean z = true;
        if (job == null || !job.isCancelled()) {
            z = false;
        }
        if (!z) {
            String de2 = de();
            fe.mmm.qw.i.qw.ad("pdf_split", "开始合并 " + Thread.currentThread().getName());
            Application application = this.qw;
            fe.mmm.qw.qqq.ad.qw.qw.qw(application, ad().getAbsolutePath() + File.separator + de2, new ArrayList(list), false, false, new de(this, list));
        }
    }

    public void onCleared() {
        super.onCleared();
        uk ukVar = this.f7124i;
        if (ukVar != null) {
            ukVar.m996if();
        }
        Job job = this.f7129uk;
        if (job != null) {
            Job.qw.qw(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.ddd;
        if (job2 != null) {
            Job.qw.qw(job2, (CancellationException) null, 1, (Object) null);
        }
        qw();
    }

    public final void pf(String str) {
        ScanRecordExportFile qw2 = ScanRecordExportFile.Companion.qw(this.qw, str);
        boolean pf2 = fe.mmm.qw.rrr.qw.ad.qw.qw().pf(this.qw, CollectionsKt__CollectionsJVMKt.listOf(qw2));
        this.f7121ad.postValue(new Pair(Boolean.FALSE, Boolean.TRUE));
        if (pf2) {
            this.f7123fe.postValue(new rg.ad(qw2, this.ggg.get()));
        } else {
            this.f7123fe.postValue(new rg.qw(R.string.pdf_fail_write_pdf_fail));
        }
    }

    public final void qw() {
        fe.mmm.qw.j.xxx.ad.rg(fe());
    }

    public final void startParsePdf(@Nullable ScanRecordExportFile scanRecordExportFile, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.f7125o = scanRecordExportFile;
        if (scanRecordExportFile != null) {
            String localPath = scanRecordExportFile.getLocalPath();
            if (!(localPath == null || localPath.length() == 0)) {
                this.f7129uk = Cif.fe(ViewModelKt.getViewModelScope(this), u.ad(), (CoroutineStart) null, new PdfSplitViewModel$startParsePdf$1(this, scanRecordExportFile, activity, (Continuation<? super PdfSplitViewModel$startParsePdf$1>) null), 2, (Object) null);
                return;
            }
        }
        this.f7123fe.postValue(new rg.qw(R.string.pdf_fail_read_pdf_fail));
    }

    public final void startSplitPdf() {
        this.f7121ad.setValue(new Pair(Boolean.TRUE, Boolean.FALSE));
        this.ddd = Cif.fe(ViewModelKt.getViewModelScope(this), u.ad(), (CoroutineStart) null, new PdfSplitViewModel$startSplitPdf$1(this, (Continuation<? super PdfSplitViewModel$startSplitPdf$1>) null), 2, (Object) null);
    }

    public final void th(String str) {
        Job job = this.ddd;
        boolean z = true;
        if (!(job != null && job.isCancelled())) {
            fe.mmm.qw.i.qw.ad("pdf_split", "合并结束 path=" + str);
            if (!(str == null || str.length() == 0)) {
                z = false;
            }
            if (z) {
                this.f7123fe.postValue(new rg.qw(R.string.pdf_fail_write_pdf_fail));
            } else {
                uk(str);
            }
            qw();
        }
    }

    public final void uk(String str) {
        pf(str);
        th ppp2 = th.ppp();
        ScanRecordExportFile scanRecordExportFile = this.f7125o;
        String str2 = null;
        int rg2 = ppp2.rg(scanRecordExportFile != null ? scanRecordExportFile.getFileName() : null, 0);
        th ppp3 = th.ppp();
        ScanRecordExportFile scanRecordExportFile2 = this.f7125o;
        if (scanRecordExportFile2 != null) {
            str2 = scanRecordExportFile2.getFileName();
        }
        ppp3.pf(str2, rg2 + 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object yj(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$onParsePdfSucceed$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$onParsePdfSucceed$1 r0 = (com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$onParsePdfSucceed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$onParsePdfSucceed$1 r0 = new com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$onParsePdfSucceed$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r5 = r0.L$0
            com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel r5 = (com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel) r5
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00d1
        L_0x0033:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r14)
            fe.mmm.qw.o.qw.de.qw.uk r14 = r13.f7124i
            if (r14 == 0) goto L_0x0047
            int r14 = r14.ad()
            goto L_0x0048
        L_0x0047:
            r14 = 0
        L_0x0048:
            r13.ppp = r14
            boolean r14 = com.tera.scan.pdfedit.ui.PDFMergeKt.m850switch(r13)
            if (r14 != 0) goto L_0x0065
            int r14 = r13.ppp
            if (r14 != r4) goto L_0x0065
            com.tera.scan.record.model.ScanRecordExportFile r14 = r13.f7125o
            if (r14 == 0) goto L_0x0062
            androidx.lifecycle.MutableLiveData<fe.mmm.qw.qqq.o.rg> r0 = r13.f7123fe
            fe.mmm.qw.qqq.o.rg$ad r1 = new fe.mmm.qw.qqq.o.rg$ad
            r1.<init>(r14, r4)
            r0.postValue(r1)
        L_0x0062:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0065:
            androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.util.ArrayList<fe.mmm.qw.qqq.rg.ad>>> r14 = r13.f7126pf
            java.lang.Object r14 = r14.getValue()
            if (r14 != 0) goto L_0x0097
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            int r2 = r13.ppp
            r11 = 0
        L_0x0075:
            if (r11 >= r2) goto L_0x0089
            fe.mmm.qw.qqq.rg.ad r12 = new fe.mmm.qw.qqq.rg.ad
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r7 = ""
            r5 = r12
            r6 = r11
            r5.<init>(r6, r7, r8, r9, r10)
            r14.add(r12)
            int r11 = r11 + 1
            goto L_0x0075
        L_0x0089:
            androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.util.ArrayList<fe.mmm.qw.qqq.rg.ad>>> r2 = r13.f7126pf
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r5.<init>(r6, r14)
            r2.postValue(r5)
        L_0x0097:
            androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> r14 = r13.f7121ad
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r2.<init>(r5, r6)
            r14.postValue(r2)
            java.util.concurrent.atomic.AtomicInteger r14 = new java.util.concurrent.atomic.AtomicInteger
            r14.<init>(r3)
            fe.mmm.qw.o.qw.de.qw.uk r2 = r13.f7124i
            if (r2 == 0) goto L_0x00ba
            com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$ad r5 = new com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$ad
            r5.<init>(r13, r14)
            r2.ddd(r5)
        L_0x00ba:
            int r14 = r13.ppp
            r5 = r13
            r2 = r14
        L_0x00be:
            if (r3 >= r2) goto L_0x00db
            r6 = 100
            r0.L$0 = r5
            r0.I$0 = r3
            r0.I$1 = r2
            r0.label = r4
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.ad(r6, r0)
            if (r14 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            fe.mmm.qw.o.qw.de.qw.uk r14 = r5.f7124i
            if (r14 == 0) goto L_0x00d8
            r14.vvv(r3)
        L_0x00d8:
            int r3 = r3 + 1
            goto L_0x00be
        L_0x00db:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel.yj(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
