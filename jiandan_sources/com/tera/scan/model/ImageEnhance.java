package com.tera.scan.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.model.callback.IImageEnhanceResult;
import com.terascan.algo.DocumentEnhanceAPI;
import i.qw.Cif;
import i.qw.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J*\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 J6\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ.\u0010%\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010&\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0007J \u0010'\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012H\u0007J\u0006\u0010)\u001a\u00020\u0014J>\u0010*\u001a\u00020\u0014*\u00020+2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u00120\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/tera/scan/model/ImageEnhance;", "", "()V", "documentEnhanceAPI", "Lcom/terascan/algo/DocumentEnhanceAPI;", "getDocumentEnhanceAPI", "()Lcom/terascan/algo/DocumentEnhanceAPI;", "setDocumentEnhanceAPI", "(Lcom/terascan/algo/DocumentEnhanceAPI;)V", "isInit", "", "isInitDewarpCoarseSuccess", "isInitDewarpFineSuccess", "lock", "predictorIngList", "", "", "kotlin.jvm.PlatformType", "", "callbackResult", "", "outputData", "", "resultPath", "filePath", "callback", "Lcom/tera/scan/model/callback/IImageEnhanceResult;", "enhance", "imageBuffer", "enableSharpen", "enalbeDewarp", "quality", "", "imageEnhanceFilter", "context", "Landroid/content/Context;", "postProcess", "imageShadowFilter", "initLicenseAndModel", "initLicenseAndModelByLocalFile", "modelPathList", "releaseApi", "imageShadowPerform", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "scan-model_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageEnhance {
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public static volatile ImageEnhance f7030uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public static final qw f7031yj = new qw((DefaultConstructorMarker) null);

    /* renamed from: ad  reason: collision with root package name */
    public boolean f7032ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f7033de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public DocumentEnhanceAPI f7034fe;
    public volatile boolean qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final Object f7035rg;

    /* renamed from: th  reason: collision with root package name */
    public final List<String> f7036th;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageEnhance qw() {
            ImageEnhance ad2 = ImageEnhance.f7030uk;
            if (ad2 == null) {
                synchronized (this) {
                    ad2 = ImageEnhance.f7030uk;
                    if (ad2 == null) {
                        ad2 = new ImageEnhance((DefaultConstructorMarker) null);
                        qw qwVar = ImageEnhance.f7031yj;
                        ImageEnhance.f7030uk = ad2;
                    }
                }
            }
            return ad2;
        }
    }

    public ImageEnhance() {
        this.f7035rg = new Object();
        this.f7036th = Collections.synchronizedList(new ArrayList());
    }

    public /* synthetic */ ImageEnhance(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[Catch:{ all -> 0x003b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void pf(com.tera.scan.model.ImageEnhance r3, java.lang.String r4, java.lang.String r5, com.tera.scan.model.callback.IImageEnhanceResult r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "$filePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "$callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x003b }
            java.util.List<java.lang.String> r0 = r3.f7036th     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x001f
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            r2 = 0
            if (r0 == 0) goto L_0x002a
            java.lang.String r3 = "zsj 释放滤镜"
            java.lang.Object r3 = com.mars.kotlin.extension.LoggerKt.e$default(r3, r2, r1, r2)     // Catch:{ all -> 0x003b }
            goto L_0x0037
        L_0x002a:
            java.util.List<java.lang.String> r0 = r3.f7036th     // Catch:{ all -> 0x003b }
            boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0035
            r3.th(r2, r5, r4, r6)     // Catch:{ all -> 0x003b }
        L_0x0035:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003b }
        L_0x0037:
            kotlin.Result.m1155constructorimpl(r3)     // Catch:{ all -> 0x003b }
            goto L_0x0045
        L_0x003b:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            kotlin.Result.m1155constructorimpl(r3)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.model.ImageEnhance.pf(com.tera.scan.model.ImageEnhance, java.lang.String, java.lang.String, com.tera.scan.model.callback.IImageEnhanceResult):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015 A[Catch:{ all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[Catch:{ all -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void yj(java.lang.String r1, com.tera.scan.model.callback.IImageEnhanceResult r2, byte[] r3) {
        /*
            java.lang.String r0 = "$callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0012
            int r0 = r1.length()     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x0013
        L_0x0012:
            r0 = 1
        L_0x0013:
            if (r0 != 0) goto L_0x0022
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x002b }
            r3.<init>(r1)     // Catch:{ all -> 0x002b }
            boolean r1 = r3.exists()     // Catch:{ all -> 0x002b }
            r2.ad(r1)     // Catch:{ all -> 0x002b }
            goto L_0x0025
        L_0x0022:
            r2.qw(r3)     // Catch:{ all -> 0x002b }
        L_0x0025:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002b }
            kotlin.Result.m1155constructorimpl(r1)     // Catch:{ all -> 0x002b }
            goto L_0x0035
        L_0x002b:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            kotlin.Result.m1155constructorimpl(r1)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.model.ImageEnhance.yj(java.lang.String, com.tera.scan.model.callback.IImageEnhanceResult, byte[]):void");
    }

    public final void i(@NotNull Context context, @NotNull String str, boolean z, boolean z2, @NotNull IImageEnhanceResult iImageEnhanceResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(iImageEnhanceResult, "callback");
        this.f7036th.add(str);
        Job unused = Cif.fe(i0.f6136ad, (CoroutineContext) null, (CoroutineStart) null, new ImageEnhance$imageShadowFilter$1(this, str, iImageEnhanceResult, context, z, z2, (Continuation<? super ImageEnhance$imageShadowFilter$1>) null), 3, (Object) null);
    }

    @WorkerThread
    /* renamed from: if  reason: not valid java name */
    public final boolean m844if(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.qw) {
            return true;
        }
        this.qw = m845switch(context, (List<String>) null);
        return this.qw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(kotlinx.coroutines.CoroutineScope r8, java.lang.String r9, com.tera.scan.model.callback.IImageEnhanceResult r10, android.content.Context r11, boolean r12, boolean r13, java.lang.String r14) {
        /*
            r7 = this;
            android.os.Handler r8 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r8.<init>(r0)
            fe.mmm.qw.ddd.th r0 = new fe.mmm.qw.ddd.th
            r0.<init>(r7, r9, r14, r10)
            r1 = 5000(0x1388, double:2.4703E-320)
            r8.postDelayed(r0, r1)
            boolean r8 = r7.m844if(r11)
            r7.qw = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = "zsj 模型初始化 done result initLicenseAndModel "
            r8.append(r11)
            boolean r11 = r7.qw
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            r11 = 0
            r0 = 1
            com.mars.kotlin.extension.LoggerKt.e$default(r8, r11, r0, r11)
            boolean r8 = r7.qw
            if (r8 != 0) goto L_0x0039
            r7.th(r11, r14, r9, r10)
            return
        L_0x0039:
            com.terascan.algo.DocumentEnhanceAPI r8 = r7.f7034fe
            if (r8 == 0) goto L_0x00c4
            r1 = 0
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0057 }
            byte[] r2 = r8.loadLocalFile(r9)     // Catch:{ all -> 0x0057 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0055 }
            r3.<init>(r9)     // Catch:{ all -> 0x0055 }
            int r3 = fe.mmm.qw.ddd.p023if.de.qw(r3)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0053 }
            kotlin.Result.m1155constructorimpl(r4)     // Catch:{ all -> 0x0053 }
            goto L_0x0063
        L_0x0053:
            r4 = move-exception
            goto L_0x005a
        L_0x0055:
            r4 = move-exception
            goto L_0x0059
        L_0x0057:
            r4 = move-exception
            r2 = r11
        L_0x0059:
            r3 = 0
        L_0x005a:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            kotlin.Result.m1155constructorimpl(r4)
        L_0x0063:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "zsj enhance 开始时间 "
            r4.append(r5)
            long r5 = java.lang.System.currentTimeMillis()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.mars.kotlin.extension.LoggerKt.e$default(r4, r11, r0, r11)
            java.lang.System.currentTimeMillis()
            if (r2 == 0) goto L_0x00a6
            boolean r4 = r7.f7032ad
            if (r4 == 0) goto L_0x008c
            boolean r4 = r7.f7033de
            if (r4 == 0) goto L_0x008c
            if (r13 == 0) goto L_0x008c
            r13 = 1
            goto L_0x008d
        L_0x008c:
            r13 = 0
        L_0x008d:
            byte[] r12 = r8.enhance(r2, r12, r13, r3)
            java.lang.System.currentTimeMillis()
            if (r14 == 0) goto L_0x009c
            int r13 = r14.length()
            if (r13 != 0) goto L_0x009d
        L_0x009c:
            r1 = 1
        L_0x009d:
            if (r1 != 0) goto L_0x00a2
            r8.writeLocalFile(r14, r12)
        L_0x00a2:
            r7.th(r12, r14, r9, r10)
            goto L_0x00a9
        L_0x00a6:
            r7.th(r11, r14, r9, r10)
        L_0x00a9:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "zsj enhance 结束时间 "
            r8.append(r9)
            long r9 = java.lang.System.currentTimeMillis()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object r8 = com.mars.kotlin.extension.LoggerKt.e$default(r8, r11, r0, r11)
            java.lang.String r8 = (java.lang.String) r8
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.model.ImageEnhance.o(kotlinx.coroutines.CoroutineScope, java.lang.String, com.tera.scan.model.callback.IImageEnhanceResult, android.content.Context, boolean, boolean, java.lang.String):void");
    }

    @WorkerThread
    /* renamed from: switch  reason: not valid java name */
    public final boolean m845switch(@NotNull Context context, @Nullable List<String> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        LoggerKt.e$default("zsj 模型初始化 initLicenseAndModel " + this.qw, (Object) null, 1, (Object) null);
        if (this.qw) {
            return true;
        }
        LoggerKt.e$default("zsj 模型开始初始化 " + System.currentTimeMillis(), (Object) null, 1, (Object) null);
        if (this.f7034fe == null) {
            this.f7034fe = new DocumentEnhanceAPI(context.getAssets());
        }
        boolean z2 = false;
        try {
            Result.Companion companion = Result.Companion;
            DocumentEnhanceAPI documentEnhanceAPI = this.f7034fe;
            if (!(documentEnhanceAPI != null ? documentEnhanceAPI.initAlgoApi() : false)) {
                return false;
            }
            DocumentEnhanceAPI documentEnhanceAPI2 = this.f7034fe;
            z = documentEnhanceAPI2 != null ? documentEnhanceAPI2.init("model/ocrwangpanenhance_v3_models/enc_enhance_no_clip_mobilenet_v1_gpu_model_opencl.nb", "model/LICENSE", "enhance", false, false) : false;
            try {
                DocumentEnhanceAPI documentEnhanceAPI3 = this.f7034fe;
                this.f7032ad = documentEnhanceAPI3 != null ? documentEnhanceAPI3.init("model/ocrwangpanenhance_v3_models/dewarp_coarse.nb", "model/LICENSE", "dewarp_coarse", false, false) : false;
                DocumentEnhanceAPI documentEnhanceAPI4 = this.f7034fe;
                if (documentEnhanceAPI4 != null) {
                    z2 = documentEnhanceAPI4.init("model/ocrwangpanenhance_v3_models/dewarp_fine.nb", "model/LICENSE", "dewarp_fine", false, false);
                }
                this.f7033de = z2;
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                boolean z3 = z;
                th = th2;
                z2 = z3;
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th));
                z = z2;
                LoggerKt.e$default("zsj 模型初始化完成 " + System.currentTimeMillis(), (Object) null, 1, (Object) null);
                this.qw = z;
                return z;
            }
            LoggerKt.e$default("zsj 模型初始化完成 " + System.currentTimeMillis(), (Object) null, 1, (Object) null);
            this.qw = z;
            return z;
        } catch (Throwable th3) {
            th = th3;
            Result.Companion companion22 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th));
            z = z2;
            LoggerKt.e$default("zsj 模型初始化完成 " + System.currentTimeMillis(), (Object) null, 1, (Object) null);
            this.qw = z;
            return z;
        }
    }

    public final void th(byte[] bArr, String str, String str2, IImageEnhanceResult iImageEnhanceResult) {
        if (this.f7036th.contains(str2)) {
            this.f7036th.remove(str2);
        }
        new Handler(Looper.getMainLooper()).post(new fe.mmm.qw.ddd.qw(str, iImageEnhanceResult, bArr));
    }

    public final void uk(@NotNull Context context, @NotNull String str, @NotNull String str2, boolean z, boolean z2, @NotNull IImageEnhanceResult iImageEnhanceResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(str2, "resultPath");
        IImageEnhanceResult iImageEnhanceResult2 = iImageEnhanceResult;
        Intrinsics.checkNotNullParameter(iImageEnhanceResult2, "callback");
        this.f7036th.add(str);
        Job unused = Cif.fe(i0.f6136ad, (CoroutineContext) null, (CoroutineStart) null, new ImageEnhance$imageEnhanceFilter$job$1(this, str, iImageEnhanceResult2, context, z, z2, str2, (Continuation<? super ImageEnhance$imageEnhanceFilter$job$1>) null), 3, (Object) null);
    }
}
