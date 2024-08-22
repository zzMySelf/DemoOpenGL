package com.tera.scan.pdfedit.util;

import android.content.Context;
import fe.mmm.qw.th.qw.th.i;
import java.io.File;
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
@DebugMetadata(c = "com.tera.scan.pdfedit.util.PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2", f = "PdfCreateWatermarkPageHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ i $loadingDialogHelper;
    public final /* synthetic */ String $localFilePath;
    public final /* synthetic */ File $tempDir;
    public final /* synthetic */ String $watermarkText;
    public final /* synthetic */ String $watermarkTextColor;
    public final /* synthetic */ Double $watermarkTextSize;
    public final /* synthetic */ Double $watermarkTextSizeScale;
    public final /* synthetic */ Double $watermarkTextTransparency;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2(String str, i iVar, String str2, Double d, Double d2, Double d3, String str3, File file, Context context, Continuation<? super PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2> continuation) {
        super(2, continuation);
        this.$localFilePath = str;
        this.$loadingDialogHelper = iVar;
        this.$watermarkText = str2;
        this.$watermarkTextSize = d;
        this.$watermarkTextSizeScale = d2;
        this.$watermarkTextTransparency = d3;
        this.$watermarkTextColor = str3;
        this.$tempDir = file;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2(this.$localFilePath, this.$loadingDialogHelper, this.$watermarkText, this.$watermarkTextSize, this.$watermarkTextSizeScale, this.$watermarkTextTransparency, this.$watermarkTextColor, this.$tempDir, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: fe.mmm.qw.qqq.i.ad} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: fe.mmm.qw.qqq.i.ad} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: android.graphics.Matrix} */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r9v22, types: [kotlin.Unit] */
    /* JADX WARNING: type inference failed for: r9v25, types: [kotlin.Unit] */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01d2, code lost:
        r0.close();
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d8, code lost:
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r2 = r0;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ae, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01af, code lost:
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01bb, code lost:
        r0.close();
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01c1, code lost:
        r9 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01d2 A[Catch:{ all -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d8 A[Catch:{ all -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ae A[ExcHandler: Exception (e java.lang.Exception), PHI: r9 
      PHI: (r9v7 android.graphics.Matrix) = (r9v0 android.graphics.Matrix), (r9v0 android.graphics.Matrix), (r9v0 android.graphics.Matrix), (r9v0 android.graphics.Matrix), (r9v0 android.graphics.Matrix), (r9v0 android.graphics.Matrix), (r9v0 android.graphics.Matrix), (r9v26 android.graphics.Matrix), (r9v28 android.graphics.Matrix), (r9v30 android.graphics.Matrix), (r9v32 android.graphics.Matrix), (r9v34 android.graphics.Matrix), (r9v36 android.graphics.Matrix), (r9v38 android.graphics.Matrix), (r9v40 android.graphics.Matrix), (r9v42 android.graphics.Matrix), (r9v44 android.graphics.Matrix), (r9v46 android.graphics.Matrix) binds: [B:3:0x0017, B:18:0x004c, B:31:0x0077, B:21:0x0054, B:22:?, B:6:0x0024, B:7:?, B:38:0x00c7, B:39:?, B:44:0x00d2, B:45:?, B:50:0x00dd, B:51:?, B:56:0x00eb, B:57:?, B:53:0x00e1, B:47:0x00d6, B:41:0x00cb] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01bb A[Catch:{ all -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01c1 A[Catch:{ all -> 0x019d }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            if (r0 != 0) goto L_0x01e8
            kotlin.ResultKt.throwOnFailure(r26)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r9 = 0
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            java.lang.String r2 = r1.$localFilePath     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r0.<init>(r2)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            boolean r2 = r0.exists()     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            if (r2 != 0) goto L_0x004c
            fe.mmm.qw.th.qw.th.i r0 = r1.$loadingDialogHelper     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            r0.fe()     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x003c }
            T r0 = r8.element     // Catch:{ all -> 0x003c }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ all -> 0x003c }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003c }
        L_0x0038:
            kotlin.Result.m1155constructorimpl(r9)     // Catch:{ all -> 0x003c }
            goto L_0x0046
        L_0x003c:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x0046:
            return r2
        L_0x0047:
            r0 = move-exception
            r2 = r0
            r10 = r9
            goto L_0x01ca
        L_0x004c:
            java.lang.String r2 = r1.$localFilePath     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            boolean r2 = fe.mmm.qw.o.qw.qw.ad.ad.rg(r2)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            if (r2 != 0) goto L_0x0077
            fe.mmm.qw.th.qw.th.i r0 = r1.$loadingDialogHelper     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            r0.fe()     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x006c }
            T r0 = r8.element     // Catch:{ all -> 0x006c }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x0068
            r0.close()     // Catch:{ all -> 0x006c }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006c }
        L_0x0068:
            kotlin.Result.m1155constructorimpl(r9)     // Catch:{ all -> 0x006c }
            goto L_0x0076
        L_0x006c:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x0076:
            return r2
        L_0x0077:
            android.graphics.pdf.PdfRenderer r2 = new android.graphics.pdf.PdfRenderer     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            android.os.ParcelFileDescriptor r3 = android.os.ParcelFileDescriptor.open(r0, r3)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r2.<init>(r3)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r8.element = r2     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.pdf.PdfRenderer r2 = (android.graphics.pdf.PdfRenderer) r2     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            int r2 = r2.getPageCount()     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r3 = 0
            r4 = 0
        L_0x008c:
            r5 = 1
            if (r4 >= r2) goto L_0x016c
            T r6 = r8.element     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.pdf.PdfRenderer r6 = (android.graphics.pdf.PdfRenderer) r6     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.pdf.PdfRenderer$Page r6 = r6.openPage(r4)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            int r14 = r6.getWidth()     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            int r15 = r6.getHeight()     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.Bitmap r12 = android.graphics.Bitmap.createBitmap(r14, r15, r10)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.Canvas r13 = new android.graphics.Canvas     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r13.<init>(r12)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r10 = -1
            r13.drawColor(r10)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.Paint r10 = new android.graphics.Paint     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r10.<init>()     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r11 = 0
            r13.drawBitmap(r12, r11, r11, r10)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r11.<init>(r3, r3, r14, r15)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            r6.render(r12, r11, r9, r5)     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            fe.mmm.qw.qqq.i.ad r10 = fe.mmm.qw.qqq.i.ad.qw     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            java.lang.String r5 = r1.$watermarkText     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            if (r5 != 0) goto L_0x00c7
            java.lang.String r5 = ""
        L_0x00c7:
            java.lang.Double r3 = r1.$watermarkTextSize     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            if (r3 == 0) goto L_0x00d0
            double r16 = r3.doubleValue()     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            goto L_0x00d2
        L_0x00d0:
            r16 = 4625196817309499392(0x4030000000000000, double:16.0)
        L_0x00d2:
            java.lang.Double r3 = r1.$watermarkTextSizeScale     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            if (r3 == 0) goto L_0x00db
            double r18 = r3.doubleValue()     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            goto L_0x00dd
        L_0x00db:
            r18 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x00dd:
            java.lang.Double r3 = r1.$watermarkTextTransparency     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            if (r3 == 0) goto L_0x00e6
            double r21 = r3.doubleValue()     // Catch:{ Exception -> 0x01ae, all -> 0x0047 }
            goto L_0x00eb
        L_0x00e6:
            r21 = 4596373779694328218(0x3fc999999999999a, double:0.2)
        L_0x00eb:
            java.lang.String r3 = r1.$watermarkTextColor     // Catch:{ Exception -> 0x01ae, all -> 0x01aa }
            if (r3 != 0) goto L_0x00f1
            java.lang.String r3 = "000000"
        L_0x00f1:
            r9 = r11
            r11 = r5
            r23 = r2
            r5 = r12
            r2 = r13
            r12 = r16
            r20 = r14
            r24 = r15
            r14 = r18
            r16 = r21
            r18 = r3
            r19 = r20
            r20 = r24
            android.graphics.Bitmap r3 = r10.ad(r11, r12, r14, r16, r18, r19, r20)     // Catch:{ Exception -> 0x0169, all -> 0x0166 }
            if (r3 == 0) goto L_0x0112
            r10 = 0
            r2.drawBitmap(r3, r9, r9, r10)     // Catch:{ Exception -> 0x01a8 }
            goto L_0x0113
        L_0x0112:
            r10 = 0
        L_0x0113:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a8 }
            r2.<init>()     // Catch:{ Exception -> 0x01a8 }
            java.io.File r9 = r1.$tempDir     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ Exception -> 0x01a8 }
            r2.append(r9)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ Exception -> 0x01a8 }
            r2.append(r9)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r9 = "page_%s%s.jpg"
            r11 = 2
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r13 = r0.getName()     // Catch:{ Exception -> 0x01a8 }
            r14 = 0
            r12[r14] = r13     // Catch:{ Exception -> 0x01a8 }
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)     // Catch:{ Exception -> 0x01a8 }
            r15 = 1
            r12[r15] = r13     // Catch:{ Exception -> 0x01a8 }
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r12, r11)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r9 = java.lang.String.format(r9, r11)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r11 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)     // Catch:{ Exception -> 0x01a8 }
            r2.append(r9)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01a8 }
            fe.mmm.qw.qqq.i.ad r9 = fe.mmm.qw.qqq.i.ad.qw     // Catch:{ Exception -> 0x01a8 }
            r9.rg(r5, r2)     // Catch:{ Exception -> 0x01a8 }
            r7.add(r2)     // Catch:{ Exception -> 0x01a8 }
            fe.mmm.qw.j.ddd.ad.yj(r5)     // Catch:{ Exception -> 0x01a8 }
            fe.mmm.qw.j.ddd.ad.yj(r3)     // Catch:{ Exception -> 0x01a8 }
            r6.close()     // Catch:{ Exception -> 0x01a8 }
            int r4 = r4 + 1
            r9 = r10
            r2 = r23
            r3 = 0
            goto L_0x008c
        L_0x0166:
            r0 = move-exception
            r10 = 0
            goto L_0x01ac
        L_0x0169:
            r0 = move-exception
            r10 = 0
            goto L_0x01b0
        L_0x016c:
            r10 = r9
            boolean r2 = r7.isEmpty()     // Catch:{ Exception -> 0x01a8 }
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x018a
            com.tera.scan.pdfedit.util.PdfCreateWatermarkPageHandler r2 = com.tera.scan.pdfedit.util.PdfCreateWatermarkPageHandler.qw     // Catch:{ Exception -> 0x01a8 }
            android.content.Context r3 = r1.$context     // Catch:{ Exception -> 0x01a8 }
            fe.mmm.qw.th.qw.th.i r4 = r1.$loadingDialogHelper     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r5 = r1.$localFilePath     // Catch:{ Exception -> 0x01a8 }
            fe.mmm.qw.qqq.i.ad r6 = fe.mmm.qw.qqq.i.ad.qw     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r6 = r6.de(r0)     // Catch:{ Exception -> 0x01a8 }
            r2.uk(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01a8 }
        L_0x018a:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x019d }
            T r0 = r8.element     // Catch:{ all -> 0x019d }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x019d }
            if (r0 == 0) goto L_0x0198
            r0.close()     // Catch:{ all -> 0x019d }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x019d }
            goto L_0x0199
        L_0x0198:
            r9 = r10
        L_0x0199:
            kotlin.Result.m1155constructorimpl(r9)     // Catch:{ all -> 0x019d }
            goto L_0x01c5
        L_0x019d:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
            goto L_0x01c5
        L_0x01a8:
            r0 = move-exception
            goto L_0x01b0
        L_0x01aa:
            r0 = move-exception
            r10 = r9
        L_0x01ac:
            r2 = r0
            goto L_0x01ca
        L_0x01ae:
            r0 = move-exception
            r10 = r9
        L_0x01b0:
            r0.printStackTrace()     // Catch:{ all -> 0x01c8 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x019d }
            T r0 = r8.element     // Catch:{ all -> 0x019d }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x019d }
            if (r0 == 0) goto L_0x01c1
            r0.close()     // Catch:{ all -> 0x019d }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x019d }
            goto L_0x01c2
        L_0x01c1:
            r9 = r10
        L_0x01c2:
            kotlin.Result.m1155constructorimpl(r9)     // Catch:{ all -> 0x019d }
        L_0x01c5:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01c8:
            r0 = move-exception
            goto L_0x01ac
        L_0x01ca:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x01dd }
            T r0 = r8.element     // Catch:{ all -> 0x01dd }
            android.graphics.pdf.PdfRenderer r0 = (android.graphics.pdf.PdfRenderer) r0     // Catch:{ all -> 0x01dd }
            if (r0 == 0) goto L_0x01d8
            r0.close()     // Catch:{ all -> 0x01dd }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01dd }
            goto L_0x01d9
        L_0x01d8:
            r9 = r10
        L_0x01d9:
            kotlin.Result.m1155constructorimpl(r9)     // Catch:{ all -> 0x01dd }
            goto L_0x01e7
        L_0x01dd:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x01e7:
            throw r2
        L_0x01e8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.pdfedit.util.PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
