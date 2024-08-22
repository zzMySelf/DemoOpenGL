package fe.mmm.qw.o.qw.rg;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import fe.mmm.qw.j.ddd.ad;
import java.io.File;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull
    public static final qw qw = new qw();

    public final String ad(Context context, Bitmap bitmap) {
        Object obj;
        String str = null;
        if (bitmap == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            File file = new File(context.getCacheDir().getAbsolutePath() + "/convert_pdf");
            if (!file.exists()) {
                file.mkdir();
            }
            obj = Result.m1155constructorimpl(ad.uk(bitmap, file.getPath() + "/image_" + System.currentTimeMillis() + '_' + UUID.randomUUID() + BrowserServiceFileProvider.FILE_EXTENSION));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m1161isFailureimpl(obj)) {
            str = obj;
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc A[Catch:{ all -> 0x00e5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void qw(@org.jetbrains.annotations.NotNull android.content.Context r16, @org.jetbrains.annotations.NotNull java.lang.String r17, boolean r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<java.lang.String>, kotlin.Unit> r19) {
        /*
            r15 = this;
            r0 = r16
            r1 = r17
            r2 = r19
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            android.graphics.pdf.PdfRenderer r5 = new android.graphics.pdf.PdfRenderer     // Catch:{ Exception -> 0x00b5, all -> 0x00b0 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00b5, all -> 0x00b0 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b0 }
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            android.os.ParcelFileDescriptor r1 = android.os.ParcelFileDescriptor.open(r6, r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b0 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b0 }
            int r1 = r5.getPageCount()     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r6 = 0
            r7 = 0
        L_0x0031:
            if (r7 >= r1) goto L_0x009c
            android.graphics.pdf.PdfRenderer$Page r8 = r5.openPage(r7)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            int r9 = r8.getWidth()     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            float r9 = (float) r9     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r10 = 1149698048(0x44870000, float:1080.0)
            float r9 = r10 / r9
            int r11 = r8.getHeight()     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            float r11 = (float) r11     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            float r11 = r11 * r9
            int r9 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r11)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            if (r18 == 0) goto L_0x0056
            int r9 = r8.getWidth()     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            float r10 = (float) r9     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            int r9 = r8.getHeight()     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
        L_0x0056:
            int r10 = (int) r10     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r10, r9, r11)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            java.lang.String r12 = "createBitmap(width.toInt… Bitmap.Config.ARGB_8888)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            android.graphics.Canvas r12 = new android.graphics.Canvas     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r13 = -1
            r12.drawColor(r13)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            android.graphics.Paint r13 = new android.graphics.Paint     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r13.<init>()     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r14 = 0
            r12.drawBitmap(r11, r14, r14, r13)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            android.graphics.Rect r12 = new android.graphics.Rect     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r12.<init>(r6, r6, r10, r9)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r9 = 1
            r8.render(r11, r12, r4, r9)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r10 = r15
            java.lang.String r12 = r15.ad(r0, r11)     // Catch:{ Exception -> 0x009a }
            if (r12 == 0) goto L_0x008c
            int r13 = r12.length()     // Catch:{ Exception -> 0x009a }
            if (r13 != 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r9 = 0
        L_0x008c:
            if (r9 != 0) goto L_0x0091
            r3.add(r12)     // Catch:{ Exception -> 0x009a }
        L_0x0091:
            fe.mmm.qw.j.ddd.ad.yj(r11)     // Catch:{ Exception -> 0x009a }
            r8.close()     // Catch:{ Exception -> 0x009a }
            int r7 = r7 + 1
            goto L_0x0031
        L_0x009a:
            r0 = move-exception
            goto L_0x00b8
        L_0x009c:
            r10 = r15
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00a8 }
            r5.close()     // Catch:{ all -> 0x00a8 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a8 }
            kotlin.Result.m1155constructorimpl(r0)     // Catch:{ all -> 0x00a8 }
            goto L_0x00d2
        L_0x00a8:
            r0 = move-exception
            goto L_0x00c9
        L_0x00aa:
            r0 = move-exception
            r10 = r15
            goto L_0x00d7
        L_0x00ad:
            r0 = move-exception
            r10 = r15
            goto L_0x00b8
        L_0x00b0:
            r0 = move-exception
            r10 = r15
            r1 = r0
            r5 = r4
            goto L_0x00d8
        L_0x00b5:
            r0 = move-exception
            r10 = r15
            r5 = r4
        L_0x00b8:
            r0.printStackTrace()     // Catch:{ all -> 0x00d6 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00c8 }
            if (r5 == 0) goto L_0x00c4
            r5.close()     // Catch:{ all -> 0x00c8 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c8 }
        L_0x00c4:
            kotlin.Result.m1155constructorimpl(r4)     // Catch:{ all -> 0x00c8 }
            goto L_0x00d2
        L_0x00c8:
            r0 = move-exception
        L_0x00c9:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x00d2:
            r2.invoke(r3)
            return
        L_0x00d6:
            r0 = move-exception
        L_0x00d7:
            r1 = r0
        L_0x00d8:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00e5 }
            if (r5 == 0) goto L_0x00e1
            r5.close()     // Catch:{ all -> 0x00e5 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e5 }
        L_0x00e1:
            kotlin.Result.m1155constructorimpl(r4)     // Catch:{ all -> 0x00e5 }
            goto L_0x00ef
        L_0x00e5:
            r0 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m1155constructorimpl(r0)
        L_0x00ef:
            r2.invoke(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.o.qw.rg.qw.qw(android.content.Context, java.lang.String, boolean, kotlin.jvm.functions.Function1):void");
    }
}
