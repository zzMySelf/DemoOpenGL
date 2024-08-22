package com.tera.scan.pdfedit.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfWatermarkCreateViewModel$createWatermarkPdf$1", f = "PdfWatermarkCreateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfWatermarkCreateViewModel$createWatermarkPdf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $path;
    public final /* synthetic */ String $watermarkText;
    public final /* synthetic */ String $watermarkTextColor;
    public final /* synthetic */ Double $watermarkTextSize;
    public final /* synthetic */ Double $watermarkTextSizeScale;
    public final /* synthetic */ Double $watermarkTextTransparency;
    public int label;
    public final /* synthetic */ PdfWatermarkCreateViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfWatermarkCreateViewModel$createWatermarkPdf$1(String str, PdfWatermarkCreateViewModel pdfWatermarkCreateViewModel, String str2, Double d, Double d2, Double d3, String str3, Continuation<? super PdfWatermarkCreateViewModel$createWatermarkPdf$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = pdfWatermarkCreateViewModel;
        this.$watermarkText = str2;
        this.$watermarkTextSize = d;
        this.$watermarkTextSizeScale = d2;
        this.$watermarkTextTransparency = d3;
        this.$watermarkTextColor = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfWatermarkCreateViewModel$createWatermarkPdf$1(this.$path, this.this$0, this.$watermarkText, this.$watermarkTextSize, this.$watermarkTextSizeScale, this.$watermarkTextTransparency, this.$watermarkTextColor, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfWatermarkCreateViewModel$createWatermarkPdf$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: type inference failed for: r3v21, types: [kotlin.Unit] */
    /* JADX WARNING: type inference failed for: r3v23, types: [kotlin.Unit] */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0111, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0112, code lost:
        r3 = r0;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0199, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x019a, code lost:
        r2 = kotlin.Result.Companion;
        kotlin.Result.m1155constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01a5, code lost:
        r3 = r0;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ac, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b8, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r1.this$0.f7140rg.postValue(new fe.mmm.qw.qqq.o.de.qw((java.lang.Integer) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r0 = kotlin.Result.Companion;
        r0 = r2.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c5, code lost:
        if (r0 != null) goto L_0x01c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c7, code lost:
        r0.close();
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01cd, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01ce, code lost:
        kotlin.Result.m1155constructorimpl(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d7, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e1, code lost:
        r0.close();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e7, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ac A[ExcHandler: Exception (r0v12 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:3:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01e1 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e7 A[Catch:{ all -> 0x01ec }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            if (r0 != 0) goto L_0x01f7
            kotlin.ResultKt.throwOnFailure(r26)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            java.lang.String r5 = r1.$path     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            if (r5 != 0) goto L_0x0042
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0037 }
            T r0 = r2.element     // Catch:{ all -> 0x0037 }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0033
            r0.close()     // Catch:{ all -> 0x0037 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
        L_0x0033:
            kotlin.Result.m1155constructorimpl(r3)     // Catch:{ all -> 0x0037 }
            goto L_0x0041
        L_0x0037:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x0041:
            return r4
        L_0x0042:
            java.lang.String r5 = r1.$path     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            boolean r5 = fe.mmm.qw.o.qw.qw.ad.ad.rg(r5)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            if (r5 != 0) goto L_0x0076
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkCreateViewModel r0 = r1.this$0     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            androidx.lifecycle.MutableLiveData r0 = r0.f7140rg     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            fe.mmm.qw.qqq.o.de$qw r4 = new fe.mmm.qw.qqq.o.de$qw     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r0.postValue(r4)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x006b }
            T r0 = r2.element     // Catch:{ all -> 0x006b }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ all -> 0x006b }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006b }
        L_0x0067:
            kotlin.Result.m1155constructorimpl(r3)     // Catch:{ all -> 0x006b }
            goto L_0x0075
        L_0x006b:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x0075:
            return r4
        L_0x0076:
            android.graphics.pdf.PdfRenderer r5 = new android.graphics.pdf.PdfRenderer     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            android.os.ParcelFileDescriptor r6 = android.os.ParcelFileDescriptor.open(r4, r6)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r2.element = r5     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.pdf.PdfRenderer r5 = (android.graphics.pdf.PdfRenderer) r5     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            int r5 = r5.getPageCount()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r6 = 0
            r7 = 0
        L_0x008b:
            r8 = 1
            if (r7 >= r5) goto L_0x016d
            T r9 = r2.element     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.pdf.PdfRenderer r9 = (android.graphics.pdf.PdfRenderer) r9     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.pdf.PdfRenderer$Page r9 = r9.openPage(r7)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            int r14 = r9.getWidth()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            int r15 = r9.getHeight()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.Bitmap r12 = android.graphics.Bitmap.createBitmap(r14, r15, r10)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.Canvas r13 = new android.graphics.Canvas     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r13.<init>(r12)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r10 = -1
            r13.drawColor(r10)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.Paint r10 = new android.graphics.Paint     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r10.<init>()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r11 = 0
            r13.drawBitmap(r12, r11, r11, r10)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r11.<init>(r6, r6, r14, r15)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            r9.render(r12, r11, r3, r8)     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            fe.mmm.qw.qqq.i.ad r10 = fe.mmm.qw.qqq.i.ad.qw     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            java.lang.String r8 = r1.$watermarkText     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            if (r8 != 0) goto L_0x00c6
            java.lang.String r8 = ""
        L_0x00c6:
            java.lang.Double r6 = r1.$watermarkTextSize     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            if (r6 == 0) goto L_0x00cf
            double r16 = r6.doubleValue()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            goto L_0x00d1
        L_0x00cf:
            r16 = 4625196817309499392(0x4030000000000000, double:16.0)
        L_0x00d1:
            java.lang.Double r6 = r1.$watermarkTextSizeScale     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            if (r6 == 0) goto L_0x00da
            double r18 = r6.doubleValue()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            goto L_0x00dc
        L_0x00da:
            r18 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x00dc:
            java.lang.Double r6 = r1.$watermarkTextTransparency     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            if (r6 == 0) goto L_0x00e5
            double r21 = r6.doubleValue()     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            goto L_0x00ea
        L_0x00e5:
            r21 = 4596373779694328218(0x3fc999999999999a, double:0.2)
        L_0x00ea:
            java.lang.String r6 = r1.$watermarkTextColor     // Catch:{ Exception -> 0x01ac, all -> 0x01a8 }
            if (r6 != 0) goto L_0x00f0
            java.lang.String r6 = "000000"
        L_0x00f0:
            r3 = r11
            r11 = r8
            r23 = r5
            r8 = r12
            r5 = r13
            r12 = r16
            r20 = r14
            r24 = r15
            r14 = r18
            r16 = r21
            r18 = r6
            r19 = r20
            r20 = r24
            android.graphics.Bitmap r6 = r10.ad(r11, r12, r14, r16, r18, r19, r20)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            if (r6 == 0) goto L_0x0116
            r10 = 0
            r5.drawBitmap(r6, r3, r3, r10)     // Catch:{ Exception -> 0x01ac, all -> 0x0111 }
            goto L_0x0116
        L_0x0111:
            r0 = move-exception
            r3 = r0
            r4 = r10
            goto L_0x01d9
        L_0x0116:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r3.<init>()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkCreateViewModel r5 = r1.this$0     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.io.File r5 = r5.ad()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r3.append(r5)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r3.append(r5)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r5 = "page_%s%s.jpg"
            r10 = 2
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r12 = r4.getName()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r13 = 0
            r11[r13] = r12     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r14 = 1
            r11[r14] = r12     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r11, r10)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r5 = java.lang.String.format(r5, r10)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r10 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r3.append(r5)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            fe.mmm.qw.qqq.i.ad r5 = fe.mmm.qw.qqq.i.ad.qw     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r5.rg(r8, r3)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r0.add(r3)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            fe.mmm.qw.j.ddd.ad.yj(r8)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            fe.mmm.qw.j.ddd.ad.yj(r6)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r9.close()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            int r7 = r7 + 1
            r5 = r23
            r3 = 0
            r6 = 0
            goto L_0x008b
        L_0x016d:
            boolean r3 = r0.isEmpty()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r5 = 1
            r3 = r3 ^ r5
            if (r3 == 0) goto L_0x0186
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkCreateViewModel r3 = r1.this$0     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r5 = r1.$path     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            fe.mmm.qw.qqq.i.ad r6 = fe.mmm.qw.qqq.i.ad.qw     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            java.lang.String r4 = r6.de(r4)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
            r3.fe(r5, r4, r0)     // Catch:{ Exception -> 0x01ac, all -> 0x01a4 }
        L_0x0186:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0199 }
            T r0 = r2.element     // Catch:{ all -> 0x0199 }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x0199 }
            if (r0 == 0) goto L_0x0194
            r0.close()     // Catch:{ all -> 0x0199 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0199 }
            goto L_0x0195
        L_0x0194:
            r3 = 0
        L_0x0195:
            kotlin.Result.m1155constructorimpl(r3)     // Catch:{ all -> 0x0199 }
            goto L_0x01d1
        L_0x0199:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
            goto L_0x01d1
        L_0x01a4:
            r0 = move-exception
            r3 = r0
            r4 = 0
            goto L_0x01d9
        L_0x01a8:
            r0 = move-exception
            r4 = r3
        L_0x01aa:
            r3 = r0
            goto L_0x01d9
        L_0x01ac:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x01d6 }
            com.tera.scan.pdfedit.viewmodel.PdfWatermarkCreateViewModel r0 = r1.this$0     // Catch:{ all -> 0x01d6 }
            androidx.lifecycle.MutableLiveData r0 = r0.f7140rg     // Catch:{ all -> 0x01d6 }
            fe.mmm.qw.qqq.o.de$qw r3 = new fe.mmm.qw.qqq.o.de$qw     // Catch:{ all -> 0x01d6 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x01d4 }
            r0.postValue(r3)     // Catch:{ all -> 0x01d4 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0199 }
            T r0 = r2.element     // Catch:{ all -> 0x0199 }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x0199 }
            if (r0 == 0) goto L_0x01cd
            r0.close()     // Catch:{ all -> 0x0199 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0199 }
            goto L_0x01ce
        L_0x01cd:
            r3 = r4
        L_0x01ce:
            kotlin.Result.m1155constructorimpl(r3)     // Catch:{ all -> 0x0199 }
        L_0x01d1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01d4:
            r0 = move-exception
            goto L_0x01aa
        L_0x01d6:
            r0 = move-exception
            r4 = 0
            goto L_0x01aa
        L_0x01d9:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x01ec }
            T r0 = r2.element     // Catch:{ all -> 0x01ec }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x01ec }
            if (r0 == 0) goto L_0x01e7
            r0.close()     // Catch:{ all -> 0x01ec }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01ec }
            goto L_0x01e8
        L_0x01e7:
            r0 = r4
        L_0x01e8:
            kotlin.Result.m1155constructorimpl(r0)     // Catch:{ all -> 0x01ec }
            goto L_0x01f6
        L_0x01ec:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x01f6:
            throw r3
        L_0x01f7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.pdfedit.viewmodel.PdfWatermarkCreateViewModel$createWatermarkPdf$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
