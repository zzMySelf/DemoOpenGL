package com.tera.scan.pdfedit.viewmodel;

import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.qqq.rg.qw;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tera/scan/pdfedit/data/MergePdfItemData;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1", f = "PdfMergeAdjustFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<qw>>, Object> {
    public final /* synthetic */ Ref.BooleanRef $needToastPdfDamage;
    public final /* synthetic */ ArrayList<ScanRecordExportFile> $pdfList;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ PdfMergeAdjustFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1(ArrayList<ScanRecordExportFile> arrayList, PdfMergeAdjustFileViewModel pdfMergeAdjustFileViewModel, Ref.BooleanRef booleanRef, Continuation<? super PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1> continuation) {
        super(2, continuation);
        this.$pdfList = arrayList;
        this.this$0 = pdfMergeAdjustFileViewModel;
        this.$needToastPdfDamage = booleanRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1 pdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1 = new PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1(this.$pdfList, this.this$0, this.$needToastPdfDamage, continuation);
        pdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1.L$0 = obj;
        return pdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ArrayList<qw>> continuation) {
        return ((PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:37|38|39|40|(1:42)(1:43)|44|73) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d0, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r5.element = true;
        fe.mmm.qw.i.qw.ad("pdf_merge", r0.getFileName() + " pdf 损坏");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r0 = kotlin.Result.Companion;
        r0 = (fe.p013if.ad.qw.th) r15.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f2, code lost:
        if (r0 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f4, code lost:
        r0.ad();
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fa, code lost:
        r12 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fc, code lost:
        kotlin.Result.m1155constructorimpl(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0103, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        fe.mmm.qw.i.qw.ad("pdf_merge", r0.getFileName() + " pdf 需要密码");
        r3.add(new fe.mmm.qw.qqq.rg.qw(r0, 0, true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r0 = kotlin.Result.Companion;
        r0 = (fe.p013if.ad.qw.th) r15.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012c, code lost:
        if (r0 != null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012e, code lost:
        r0.ad();
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0134, code lost:
        r12 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0136, code lost:
        kotlin.Result.m1155constructorimpl(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0143, code lost:
        r0.ad();
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0149, code lost:
        r12 = r16;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0105 */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:15:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: PdfPasswordException (unused com.shockwave.pdfium.PdfPasswordException), SYNTHETIC, Splitter:B:15:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0143 A[Catch:{ all -> 0x014f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0149 A[Catch:{ all -> 0x014f }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r27) {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r2 = "pdf_merge"
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            if (r0 != 0) goto L_0x015b
            kotlin.ResultKt.throwOnFailure(r27)
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList<com.tera.scan.record.model.ScanRecordExportFile> r0 = r1.$pdfList
            if (r0 == 0) goto L_0x015a
            com.tera.scan.pdfedit.viewmodel.PdfMergeAdjustFileViewModel r4 = r1.this$0
            kotlin.jvm.internal.Ref$BooleanRef r5 = r1.$needToastPdfDamage
            java.util.Iterator r6 = r0.iterator()
        L_0x0023:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x015a
            java.lang.Object r0 = r6.next()
            com.tera.scan.record.model.ScanRecordExportFile r0 = (com.tera.scan.record.model.ScanRecordExportFile) r0
            java.lang.String r7 = r0.getLocalPath()
            r14 = 1
            if (r7 == 0) goto L_0x003f
            int r7 = r7.length()
            if (r7 != 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r7 = 0
            goto L_0x0040
        L_0x003f:
            r7 = 1
        L_0x0040:
            if (r7 == 0) goto L_0x0043
            goto L_0x0023
        L_0x0043:
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            r12 = 0
            java.io.File r7 = new java.io.File     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            java.lang.String r8 = r0.getLocalPath()     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            if (r8 != 0) goto L_0x005a
            java.lang.String r8 = ""
            goto L_0x005a
        L_0x0054:
            r0 = move-exception
            r2 = r0
            r16 = r12
            goto L_0x013b
        L_0x005a:
            r7.<init>(r8)     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            fe.if.ad.qw.if.de r8 = new fe.if.ad.qw.if.de     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            r8.<init>(r7)     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            android.app.Application r7 = r4.qw     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            com.shockwave.pdfium.PdfiumCore r9 = r4.qw()     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            com.shockwave.pdfium.PdfDocument r18 = r8.qw(r7, r9, r12)     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            fe.if.ad.qw.th r7 = new fe.if.ad.qw.th     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            com.shockwave.pdfium.PdfiumCore r17 = r4.qw()     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            com.github.barteksc.pdfviewer.util.FitPolicy r19 = com.github.barteksc.pdfviewer.util.FitPolicy.WIDTH     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            com.shockwave.pdfium.util.Size r8 = new com.shockwave.pdfium.util.Size     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            r8.<init>(r14, r14)     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            r21 = 0
            r22 = 1
            r23 = 0
            r24 = 0
            r25 = 1
            r16 = r7
            r20 = r8
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            r15.element = r7     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            fe.mmm.qw.qqq.rg.qw r11 = new fe.mmm.qw.qqq.rg.qw     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            fe.if.ad.qw.th r7 = (fe.p013if.ad.qw.th) r7     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            int r9 = r7.ggg()     // Catch:{ PdfPasswordException -> 0x0103, Exception -> 0x00d0, all -> 0x00cb }
            r10 = 0
            r16 = 4
            r17 = 0
            r7 = r11
            r8 = r0
            r13 = r11
            r11 = r16
            r16 = r12
            r12 = r17
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ PdfPasswordException -> 0x0105, Exception -> 0x00d2 }
            r3.add(r13)     // Catch:{ PdfPasswordException -> 0x0105, Exception -> 0x00d2 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00bf }
            T r0 = r15.element     // Catch:{ all -> 0x00bf }
            fe.if.ad.qw.th r0 = (fe.p013if.ad.qw.th) r0     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00b8
            r0.ad()     // Catch:{ all -> 0x00bf }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bf }
            goto L_0x00ba
        L_0x00b8:
            r12 = r16
        L_0x00ba:
            kotlin.Result.m1155constructorimpl(r12)     // Catch:{ all -> 0x00bf }
            goto L_0x0023
        L_0x00bf:
            r0 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
            goto L_0x0023
        L_0x00cb:
            r0 = move-exception
            r16 = r12
        L_0x00ce:
            r2 = r0
            goto L_0x013b
        L_0x00d0:
            r16 = r12
        L_0x00d2:
            r5.element = r14     // Catch:{ all -> 0x0101 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
            r7.<init>()     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = r0.getFileName()     // Catch:{ all -> 0x0101 }
            r7.append(r0)     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = " pdf 损坏"
            r7.append(r0)     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0101 }
            fe.mmm.qw.i.qw.ad(r2, r0)     // Catch:{ all -> 0x0101 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00bf }
            T r0 = r15.element     // Catch:{ all -> 0x00bf }
            fe.if.ad.qw.th r0 = (fe.p013if.ad.qw.th) r0     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00fa
            r0.ad()     // Catch:{ all -> 0x00bf }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bf }
            goto L_0x00fc
        L_0x00fa:
            r12 = r16
        L_0x00fc:
            kotlin.Result.m1155constructorimpl(r12)     // Catch:{ all -> 0x00bf }
            goto L_0x0023
        L_0x0101:
            r0 = move-exception
            goto L_0x00ce
        L_0x0103:
            r16 = r12
        L_0x0105:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
            r7.<init>()     // Catch:{ all -> 0x0101 }
            java.lang.String r8 = r0.getFileName()     // Catch:{ all -> 0x0101 }
            r7.append(r8)     // Catch:{ all -> 0x0101 }
            java.lang.String r8 = " pdf 需要密码"
            r7.append(r8)     // Catch:{ all -> 0x0101 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0101 }
            fe.mmm.qw.i.qw.ad(r2, r7)     // Catch:{ all -> 0x0101 }
            fe.mmm.qw.qqq.rg.qw r7 = new fe.mmm.qw.qqq.rg.qw     // Catch:{ all -> 0x0101 }
            r8 = 0
            r7.<init>(r0, r8, r14)     // Catch:{ all -> 0x0101 }
            r3.add(r7)     // Catch:{ all -> 0x0101 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00bf }
            T r0 = r15.element     // Catch:{ all -> 0x00bf }
            fe.if.ad.qw.th r0 = (fe.p013if.ad.qw.th) r0     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x0134
            r0.ad()     // Catch:{ all -> 0x00bf }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bf }
            goto L_0x0136
        L_0x0134:
            r12 = r16
        L_0x0136:
            kotlin.Result.m1155constructorimpl(r12)     // Catch:{ all -> 0x00bf }
            goto L_0x0023
        L_0x013b:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x014f }
            T r0 = r15.element     // Catch:{ all -> 0x014f }
            fe.if.ad.qw.th r0 = (fe.p013if.ad.qw.th) r0     // Catch:{ all -> 0x014f }
            if (r0 == 0) goto L_0x0149
            r0.ad()     // Catch:{ all -> 0x014f }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014f }
            goto L_0x014b
        L_0x0149:
            r12 = r16
        L_0x014b:
            kotlin.Result.m1155constructorimpl(r12)     // Catch:{ all -> 0x014f }
            goto L_0x0159
        L_0x014f:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x0159:
            throw r2
        L_0x015a:
            return r3
        L_0x015b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.pdfedit.viewmodel.PdfMergeAdjustFileViewModel$parsePdfListInfo$1$mergePdfList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
