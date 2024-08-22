package com.tera.scan.pdfedit.viewmodel;

import android.app.Activity;
import com.baidu.aiscan.R;
import com.tera.scan.doc.preview.document.ui.view.ILoadCallback;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.o.qw.de.qw.uk;
import fe.mmm.qw.qqq.i.de;
import fe.mmm.qw.qqq.o.rg;
import i.qw.ggg;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$startParsePdf$1", f = "PdfSplitViewModel.kt", i = {}, l = {399, 153}, m = "invokeSuspend", n = {}, s = {})
public final class PdfSplitViewModel$startParsePdf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ ScanRecordExportFile $pdfFile;
    public Object L$0;
    public int label;
    public final /* synthetic */ PdfSplitViewModel this$0;

    public static final class qw implements ILoadCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation<Boolean> f7133ad;

        public qw(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f7133ad = cancellableContinuation;
        }

        public void onLoadFailed(int i2, long j) {
            CancellableContinuation<Boolean> cancellableContinuation = this.f7133ad;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m1155constructorimpl(Boolean.FALSE));
        }

        public void onLoadSucceed() {
            CancellableContinuation<Boolean> cancellableContinuation = this.f7133ad;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m1155constructorimpl(Boolean.TRUE));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfSplitViewModel$startParsePdf$1(PdfSplitViewModel pdfSplitViewModel, ScanRecordExportFile scanRecordExportFile, Activity activity, Continuation<? super PdfSplitViewModel$startParsePdf$1> continuation) {
        super(2, continuation);
        this.this$0 = pdfSplitViewModel;
        this.$pdfFile = scanRecordExportFile;
        this.$activity = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfSplitViewModel$startParsePdf$1(this.this$0, this.$pdfFile, this.$activity, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfSplitViewModel$startParsePdf$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.f7121ad.postValue(new Pair(Boxing.boxBoolean(true), Boxing.boxBoolean(true)));
            PdfSplitViewModel pdfSplitViewModel = this.this$0;
            String localPath = this.$pdfFile.getLocalPath();
            if (localPath == null) {
                localPath = "";
            }
            pdfSplitViewModel.f7124i = new de(localPath, this.$activity, (String) null);
            PdfSplitViewModel pdfSplitViewModel2 = this.this$0;
            this.L$0 = pdfSplitViewModel2;
            this.label = 1;
            ggg ggg = new ggg(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
            ggg.eee();
            uk access$getPdfThumb$p = pdfSplitViewModel2.f7124i;
            if (access$getPdfThumb$p != null) {
                access$getPdfThumb$p.xxx(new qw(ggg));
            }
            uk access$getPdfThumb$p2 = pdfSplitViewModel2.f7124i;
            if (access$getPdfThumb$p2 != null) {
                access$getPdfThumb$p2.i();
            }
            obj = ggg.mmm();
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            PdfSplitViewModel pdfSplitViewModel3 = (PdfSplitViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            PdfSplitViewModel pdfSplitViewModel4 = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (pdfSplitViewModel4.yj(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            fe.mmm.qw.i.qw.ad("pdf_split", this.$pdfFile.getFileName() + " pdf加载失败");
            this.this$0.f7121ad.postValue(new Pair(Boxing.boxBoolean(false), Boxing.boxBoolean(true)));
            this.this$0.f7123fe.postValue(new rg.qw(R.string.pdf_fail_read_pdf_fail));
        }
        return Unit.INSTANCE;
    }
}
