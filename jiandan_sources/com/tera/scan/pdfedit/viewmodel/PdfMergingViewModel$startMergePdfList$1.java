package com.tera.scan.pdfedit.viewmodel;

import android.app.Activity;
import com.baidu.aiscan.R;
import com.tera.scan.doc.preview.document.ui.view.ILoadCallback;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.qqq.i.de;
import fe.mmm.qw.qqq.o.fe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfMergingViewModel$startMergePdfList$1", f = "PdfMergingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfMergingViewModel$startMergePdfList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ ArrayList<ScanRecordExportFile> $pdfList;
    public int label;
    public final /* synthetic */ PdfMergingViewModel this$0;

    public static final class qw implements ILoadCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PdfMergingViewModel f7114ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f7115i;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ CountDownLatch f294if;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ int f7116o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ ArrayList<ScanRecordExportFile> f7117pf;

        /* renamed from: switch  reason: not valid java name */
        public final /* synthetic */ Ref.BooleanRef f295switch;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ de f7118th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ ArrayList<String> f7119uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ ScanRecordExportFile f7120yj;

        public qw(PdfMergingViewModel pdfMergingViewModel, de deVar, ScanRecordExportFile scanRecordExportFile, ArrayList<String> arrayList, AtomicInteger atomicInteger, int i2, ArrayList<ScanRecordExportFile> arrayList2, CountDownLatch countDownLatch, Ref.BooleanRef booleanRef) {
            this.f7114ad = pdfMergingViewModel;
            this.f7118th = deVar;
            this.f7120yj = scanRecordExportFile;
            this.f7119uk = arrayList;
            this.f7115i = atomicInteger;
            this.f7116o = i2;
            this.f7117pf = arrayList2;
            this.f294if = countDownLatch;
            this.f295switch = booleanRef;
        }

        public void onLoadFailed(int i2, long j) {
            fe.mmm.qw.i.qw.ad("merge_pdf", this.f7120yj.getFileName() + " pdf加载失败");
            this.f295switch.element = false;
            this.f294if.countDown();
        }

        public void onLoadSucceed() {
            PdfMergingViewModel pdfMergingViewModel = this.f7114ad;
            de deVar = this.f7118th;
            ScanRecordExportFile scanRecordExportFile = this.f7120yj;
            Intrinsics.checkNotNullExpressionValue(scanRecordExportFile, "pdfFile");
            pdfMergingViewModel.th(deVar, scanRecordExportFile, this.f7119uk, this.f7115i, this.f7116o, this.f7117pf, this.f294if);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergingViewModel$startMergePdfList$1(PdfMergingViewModel pdfMergingViewModel, ArrayList<ScanRecordExportFile> arrayList, Activity activity, Continuation<? super PdfMergingViewModel$startMergePdfList$1> continuation) {
        super(2, continuation);
        this.this$0 = pdfMergingViewModel;
        this.$pdfList = arrayList;
        this.$activity = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfMergingViewModel$startMergePdfList$1(this.this$0, this.$pdfList, this.$activity, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfMergingViewModel$startMergePdfList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            int access$calculateTotalPages = this.this$0.qw(this.$pdfList);
            Iterator<ScanRecordExportFile> it = this.$pdfList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ScanRecordExportFile next = it.next();
                String localPath = next.getLocalPath();
                if (localPath == null || localPath.length() == 0) {
                    this.this$0.f7101rg.postValue(new fe.qw(R.string.pdf_fail_read_pdf_fail));
                    this.this$0.ad();
                    break;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                String localPath2 = next.getLocalPath();
                if (localPath2 == null) {
                    localPath2 = "";
                }
                de deVar = new de(localPath2, this.$activity, (String) null);
                AtomicInteger atomicInteger = new AtomicInteger(0);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                qw qwVar = r2;
                Ref.BooleanRef booleanRef2 = booleanRef;
                de deVar2 = deVar;
                ArrayList arrayList2 = arrayList;
                qw qwVar2 = new qw(this.this$0, deVar, next, arrayList, atomicInteger, access$calculateTotalPages, this.$pdfList, countDownLatch, booleanRef2);
                deVar2.xxx(qwVar);
                deVar2.i();
                countDownLatch.await();
                if (!booleanRef2.element) {
                    this.this$0.f7101rg.postValue(new fe.qw(R.string.pdf_fail_read_pdf_fail));
                    this.this$0.ad();
                    break;
                }
                Job access$getMergeJob$p = this.this$0.f7100pf;
                if (access$getMergeJob$p != null && access$getMergeJob$p.isCancelled()) {
                    break;
                }
                arrayList = arrayList2;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
