package com.tera.scan.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.tera.scan.model.callback.IImageCropResult;
import com.terascan.algo.Point;
import fe.mmm.qw.ddd.de;
import fe.mmm.qw.ddd.p023if.ad;
import fe.mmm.qw.ddd.uk;
import i.qw.Cif;
import i.qw.i0;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J*\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tera/scan/model/ImageCropPredictor;", "Lcom/tera/scan/model/BaseImagePredictor;", "()V", "lock", "", "predictorIngList", "", "", "kotlin.jvm.PlatformType", "", "callbackResult", "", "saveBitmapBackPath", "cropInfoBean", "Lcom/tera/scan/model/CropInfo;", "callback", "Lcom/tera/scan/model/callback/IImageCropResult;", "changeRealPoints", "Ljava/util/ArrayList;", "Lcom/terascan/algo/Point;", "Lkotlin/collections/ArrayList;", "changeRealRate", "", "imageCrop", "context", "Landroid/content/Context;", "imageCropPerform", "outPutImgByte", "source", "", "duration", "", "Companion", "scan-model_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageCropPredictor extends uk {
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public static final qw f7026o = new qw((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public static volatile ImageCropPredictor f7027pf;

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f7028i;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Object f7029uk;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageCropPredictor qw() {
            ImageCropPredictor i2 = ImageCropPredictor.f7027pf;
            if (i2 == null) {
                synchronized (this) {
                    i2 = ImageCropPredictor.f7027pf;
                    if (i2 == null) {
                        i2 = new ImageCropPredictor((DefaultConstructorMarker) null);
                        qw qwVar = ImageCropPredictor.f7026o;
                        ImageCropPredictor.f7027pf = i2;
                    }
                }
            }
            return i2;
        }
    }

    public ImageCropPredictor() {
        this.f7029uk = new Object();
        this.f7028i = Collections.synchronizedList(new ArrayList());
    }

    public /* synthetic */ ImageCropPredictor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[Catch:{ all -> 0x003b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ddd(com.tera.scan.model.ImageCropPredictor r2, com.tera.scan.model.CropInfo r3, com.tera.scan.model.callback.IImageCropResult r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "$cropInfoBean"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "$callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x003b }
            java.util.List<java.lang.String> r0 = r2.f7028i     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r0 = 0
            goto L_0x001f
        L_0x001e:
            r0 = 1
        L_0x001f:
            if (r0 == 0) goto L_0x0025
            r2.uk()     // Catch:{ all -> 0x003b }
            goto L_0x0035
        L_0x0025:
            java.util.List<java.lang.String> r0 = r2.f7028i     // Catch:{ all -> 0x003b }
            java.lang.String r1 = r3.getSrc()     // Catch:{ all -> 0x003b }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0035
            r0 = 0
            r2.m843switch(r0, r3, r4)     // Catch:{ all -> 0x003b }
        L_0x0035:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003b }
            kotlin.Result.m1155constructorimpl(r2)     // Catch:{ all -> 0x003b }
            goto L_0x0045
        L_0x003b:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            kotlin.Result.m1155constructorimpl(r2)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.model.ImageCropPredictor.ddd(com.tera.scan.model.ImageCropPredictor, com.tera.scan.model.CropInfo, com.tera.scan.model.callback.IImageCropResult):void");
    }

    public static final void when(IImageCropResult iImageCropResult, String str) {
        Intrinsics.checkNotNullParameter(iImageCropResult, "$callback");
        iImageCropResult.onResult(str);
    }

    public final int ggg(CropInfo cropInfo) {
        int rotate = cropInfo.getRotate();
        if (rotate == 1) {
            return 6;
        }
        if (rotate != 2) {
            return rotate != 3 ? 0 : 8;
        }
        return 3;
    }

    @WorkerThread
    public final void nn(byte[] bArr, CropInfo cropInfo, IImageCropResult iImageCropResult, long j) {
        if (bArr == null) {
            m843switch(cropInfo.getSrc(), cropInfo, iImageCropResult);
            return;
        }
        File file = new File(new ad().qw(cropInfo.getDest()));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(cropInfo.getDest());
        if (file2.exists()) {
            file2.delete();
        }
        new ad().ad(file2, new ByteArrayInputStream(bArr));
        if (file2.exists()) {
            m843switch(cropInfo.getDest(), cropInfo, iImageCropResult);
        } else {
            m843switch(cropInfo.getSrc(), cropInfo, iImageCropResult);
        }
    }

    public final ArrayList<Point> ppp(CropInfo cropInfo) {
        ArrayList<Point> arrayList = new ArrayList<>();
        arrayList.add(new Point(cropInfo.getPoints().get(0).getDx(), cropInfo.getPoints().get(0).getDy()));
        arrayList.add(new Point(cropInfo.getPoints().get(3).getDx(), cropInfo.getPoints().get(3).getDy()));
        arrayList.add(new Point(cropInfo.getPoints().get(2).getDx(), cropInfo.getPoints().get(2).getDy()));
        arrayList.add(new Point(cropInfo.getPoints().get(1).getDx(), cropInfo.getPoints().get(1).getDy()));
        return arrayList;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m843switch(String str, CropInfo cropInfo, IImageCropResult iImageCropResult) {
        if (this.f7028i.contains(cropInfo.getSrc())) {
            this.f7028i.remove(cropInfo.getSrc());
            new Handler(Looper.getMainLooper()).post(new de(iImageCropResult, str));
        }
    }

    public final void vvv(@NotNull Context context, @NotNull CropInfo cropInfo, @NotNull IImageCropResult iImageCropResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cropInfo, "cropInfoBean");
        Intrinsics.checkNotNullParameter(iImageCropResult, "callback");
        this.f7028i.add(cropInfo.getSrc());
        Job unused = Cif.fe(i0.f6136ad, (CoroutineContext) null, (CoroutineStart) null, new ImageCropPredictor$imageCrop$1(this, cropInfo, iImageCropResult, context, (Continuation<? super ImageCropPredictor$imageCrop$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void xxx(com.tera.scan.model.CropInfo r17, com.tera.scan.model.callback.IImageCropResult r18, android.content.Context r19) {
        /*
            r16 = this;
            r7 = r16
            r3 = r17
            r4 = r18
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            fe.mmm.qw.ddd.fe r1 = new fe.mmm.qw.ddd.fe
            r1.<init>(r7, r3, r4)
            r5 = 5000(0x1388, double:2.4703E-320)
            r0.postDelayed(r1, r5)
            r0 = r19
            boolean r0 = r7.yj(r0)
            if (r0 != 0) goto L_0x0029
            java.lang.String r0 = r17.getSrc()
            r7.m843switch(r0, r3, r4)
            return
        L_0x0029:
            com.terascan.algo.DocumentScanAPI r8 = r16.th()
            if (r8 == 0) goto L_0x00a5
            java.util.ArrayList r10 = r16.ppp(r17)
            long r1 = java.lang.System.currentTimeMillis()
            java.io.File r0 = new java.io.File
            java.lang.String r5 = r17.getSrc()
            r0.<init>(r5)
            int r12 = fe.mmm.qw.ddd.p023if.de.qw(r0)
            r5 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x006b }
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x006b }
            r0.<init>()     // Catch:{ all -> 0x006b }
            r6 = 1
            r0.inJustDecodeBounds = r6     // Catch:{ all -> 0x006b }
            java.lang.String r6 = r17.getSrc()     // Catch:{ all -> 0x006b }
            android.graphics.BitmapFactory.decodeFile(r6, r0)     // Catch:{ all -> 0x006b }
            int r6 = r0.outWidth     // Catch:{ all -> 0x006b }
            int r5 = r0.outHeight     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0062 }
            kotlin.Result.m1155constructorimpl(r0)     // Catch:{ all -> 0x0062 }
            r14 = r5
            r13 = r6
            goto L_0x0079
        L_0x0062:
            r0 = move-exception
            r15 = r6
            r6 = r0
            r0 = r5
            r5 = r15
            goto L_0x006e
        L_0x0068:
            r0 = move-exception
            r5 = r6
            goto L_0x006c
        L_0x006b:
            r0 = move-exception
        L_0x006c:
            r6 = r0
            r0 = 0
        L_0x006e:
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            kotlin.Result.m1155constructorimpl(r6)
            r14 = r0
            r13 = r5
        L_0x0079:
            if (r13 <= 0) goto L_0x009e
            if (r14 > 0) goto L_0x007e
            goto L_0x009e
        L_0x007e:
            java.lang.String r0 = r17.getSrc()
            byte[] r9 = r8.loadLocalFile(r0)
            int r11 = r16.ggg(r17)
            byte[] r0 = r8.rectify(r9, r10, r11, r12, r13, r14)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            r1 = r16
            r2 = r0
            r3 = r17
            r4 = r18
            r1.nn(r2, r3, r4, r5)
            goto L_0x00a5
        L_0x009e:
            java.lang.String r0 = r17.getSrc()
            r7.m843switch(r0, r3, r4)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.model.ImageCropPredictor.xxx(com.tera.scan.model.CropInfo, com.tera.scan.model.callback.IImageCropResult, android.content.Context):void");
    }
}
