package com.tera.scan.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.baidu.sapi2.views.SmsLoginView;
import com.terascan.algo.Point;
import fe.mmm.qw.ddd.ad;
import fe.mmm.qw.ddd.uk;
import fe.mmm.qw.ddd.yj;
import i.qw.Cif;
import i.qw.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002JP\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0002JH\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0002J8\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001bj\b\u0012\u0004\u0012\u00020\u0007`\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J,\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tera/scan/model/ImagePredictor;", "Lcom/tera/scan/model/BaseImagePredictor;", "()V", "lock", "", "predictorIngList", "", "", "kotlin.jvm.PlatformType", "", "callbackErrorResult", "", "handler", "Landroid/os/Handler;", "callback", "Lcom/tera/scan/model/ImagePredictorCallback;", "imagePath", "checkImagePoint", "orinPoint", "", "imageMaxSize", "generateResultMap", "Ljava/util/concurrent/ConcurrentHashMap;", "imageSizeWidth", "imageSizeHeight", "degree", "response", "Ljava/util/ArrayList;", "Lcom/terascan/algo/Point;", "Lkotlin/collections/ArrayList;", "imagePredictorPerform", "context", "Landroid/content/Context;", "unPredictorList", "predictor", "pathList", "priority", "Companion", "scan-model_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImagePredictor extends uk {
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public static final qw f7037o = new qw((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public static volatile ImagePredictor f7038pf;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Object f7039i;

    /* renamed from: uk  reason: collision with root package name */
    public final List<String> f7040uk;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImagePredictor qw() {
            ImagePredictor i2 = ImagePredictor.f7038pf;
            if (i2 == null) {
                synchronized (this) {
                    i2 = ImagePredictor.f7038pf;
                    if (i2 == null) {
                        i2 = new ImagePredictor((DefaultConstructorMarker) null);
                        qw qwVar = ImagePredictor.f7037o;
                        ImagePredictor.f7038pf = i2;
                    }
                }
            }
            return i2;
        }
    }

    public ImagePredictor() {
        this.f7040uk = Collections.synchronizedList(new ArrayList());
        this.f7039i = new Object();
    }

    public /* synthetic */ ImagePredictor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void aaa(ImagePredictor imagePredictor, String str, int i2, int i3, int i4, ArrayList arrayList, ImagePredictorCallback imagePredictorCallback) {
        Intrinsics.checkNotNullParameter(imagePredictor, "this$0");
        Intrinsics.checkNotNullParameter(str, "$imagePath");
        Intrinsics.checkNotNullParameter(imagePredictorCallback, "$callback");
        ConcurrentHashMap<String, String> ggg = imagePredictor.ggg(str, i2, i3, i4, arrayList);
        imagePredictor.f7040uk.remove(str);
        imagePredictorCallback.predictorResult(ggg);
    }

    public static final void ddd(ImagePredictor imagePredictor) {
        Intrinsics.checkNotNullParameter(imagePredictor, "this$0");
        "predictorIngList.isNullOrEmpty() " + imagePredictor.f7040uk + ".isNullOrEmpty()";
        List<String> list = imagePredictor.f7040uk;
        if (list == null || list.isEmpty()) {
            imagePredictor.uk();
        }
    }

    public static final void when(ImagePredictorCallback imagePredictorCallback, ImagePredictor imagePredictor, String str) {
        Intrinsics.checkNotNullParameter(imagePredictorCallback, "$callback");
        Intrinsics.checkNotNullParameter(imagePredictor, "this$0");
        Intrinsics.checkNotNullParameter(str, "$imagePath");
        imagePredictorCallback.predictorResult(imagePredictor.vvv(str, 0, 0, (ArrayList<Point>) null));
    }

    public final ConcurrentHashMap<String, String> ggg(String str, int i2, int i3, int i4, ArrayList<Point> arrayList) {
        int i5;
        int i6;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("path", str);
        if (arrayList != null) {
            if (i4 % 180 == 0) {
                i6 = i2;
                i5 = i3;
            } else {
                i5 = i2;
                i6 = i3;
            }
            concurrentHashMap.put(SmsLoginView.f.k, "1");
            concurrentHashMap.put("imageSizeWidth", String.valueOf(i6));
            concurrentHashMap.put("imageSizeHeight", String.valueOf(i5));
            concurrentHashMap.put("x1", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(0).getX()), i2));
            concurrentHashMap.put("y1", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(0).getY()), i3));
            concurrentHashMap.put("x2", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(1).getX()), i2));
            concurrentHashMap.put("y2", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(1).getY()), i3));
            concurrentHashMap.put("x3", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(2).getX()), i2));
            concurrentHashMap.put("y3", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(2).getY()), i3));
            concurrentHashMap.put("x4", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(3).getX()), i2));
            concurrentHashMap.put("y4", ppp(MathKt__MathJVMKt.roundToInt(arrayList.get(3).getY()), i3));
        }
        return concurrentHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.terascan.algo.DocumentResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mmm(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull com.tera.scan.model.ImagePredictorCallback r12) {
        /*
            r10 = this;
            java.lang.String r0 = "imagePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r11)
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0022
            r10.m847switch(r1, r12, r11)
            return
        L_0x0022:
            fe.mmm.qw.ddd.if.qw r0 = new fe.mmm.qw.ddd.if.qw
            r0.<init>()
            int r7 = r0.qw(r11)
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r2 = 1
            r0.inJustDecodeBounds = r2
            android.graphics.BitmapFactory.decodeFile(r11, r0)
            int r5 = r0.outWidth
            int r6 = r0.outHeight
            if (r5 <= 0) goto L_0x0099
            if (r6 > 0) goto L_0x003f
            goto L_0x0099
        L_0x003f:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0084 }
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0084 }
            com.terascan.algo.DocumentScanAPI r0 = r10.th()     // Catch:{ all -> 0x0084 }
            r2 = 0
            if (r0 == 0) goto L_0x005a
            com.terascan.algo.DocumentScanAPI r3 = r10.th()     // Catch:{ all -> 0x0084 }
            if (r3 == 0) goto L_0x0055
            byte[] r2 = r3.loadLocalFile(r11)     // Catch:{ all -> 0x0084 }
        L_0x0055:
            r3 = 0
            com.terascan.algo.DocumentResult r2 = r0.detect(r2, r5, r6, r3)     // Catch:{ all -> 0x0084 }
        L_0x005a:
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x0080
            int r0 = r2.getCode()     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0066
            goto L_0x0080
        L_0x0066:
            java.util.ArrayList r8 = r2.getPoints()     // Catch:{ all -> 0x0084 }
            fe.mmm.qw.ddd.rg r0 = new fe.mmm.qw.ddd.rg     // Catch:{ all -> 0x0084 }
            r2 = r0
            r3 = r10
            r4 = r11
            r9 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0084 }
            boolean r0 = r1.post(r0)     // Catch:{ all -> 0x0084 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0084 }
            java.lang.Object r0 = kotlin.Result.m1155constructorimpl(r0)     // Catch:{ all -> 0x0084 }
            goto L_0x008f
        L_0x0080:
            r10.m847switch(r1, r12, r11)     // Catch:{ all -> 0x0084 }
            return
        L_0x0084:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m1155constructorimpl(r0)
        L_0x008f:
            java.lang.Throwable r0 = kotlin.Result.m1158exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x0098
            r10.m847switch(r1, r12, r11)
        L_0x0098:
            return
        L_0x0099:
            r10.m847switch(r1, r12, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.model.ImagePredictor.mmm(java.lang.String, com.tera.scan.model.ImagePredictorCallback):void");
    }

    public final void nn(@NotNull Context context, @NotNull List<String> list, int i2, @NotNull ImagePredictorCallback imagePredictorCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "pathList");
        Intrinsics.checkNotNullParameter(imagePredictorCallback, "callback");
        System.currentTimeMillis();
        Handler handler = new Handler(Looper.getMainLooper());
        ArrayList arrayList = new ArrayList(list);
        this.f7040uk.addAll(list);
        Job unused = Cif.fe(i0.f6136ad, (CoroutineContext) null, (CoroutineStart) null, new ImagePredictor$predictor$3(this, context, arrayList, handler, imagePredictorCallback, (Continuation<? super ImagePredictor$predictor$3>) null), 3, (Object) null);
    }

    public final String ppp(int i2, int i3) {
        return String.valueOf(Math.min(i3, Math.max(0, i2)));
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m847switch(Handler handler, ImagePredictorCallback imagePredictorCallback, String str) {
        this.f7040uk.remove(str);
        handler.post(new yj(imagePredictorCallback, this, str));
    }

    public final ConcurrentHashMap<String, String> vvv(String str, int i2, int i3, ArrayList<Point> arrayList) {
        return ggg(str, i2, i3, 0, arrayList);
    }

    public final void xxx(Context context, ArrayList<String> arrayList, Handler handler, ImagePredictorCallback imagePredictorCallback) {
        if (!yj(context)) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (String str : arrayList) {
                m847switch(handler, imagePredictorCallback, str);
                arrayList2.add(Unit.INSTANCE);
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (String mmm : arrayList) {
            mmm(mmm, imagePredictorCallback);
            arrayList3.add(Unit.INSTANCE);
        }
        handler.postDelayed(new ad(this), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }
}
