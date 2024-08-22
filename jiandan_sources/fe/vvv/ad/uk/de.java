package fe.vvv.ad.uk;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import fe.vvv.ad.ad.fe;
import fe.vvv.ad.ad.qw;
import fe.vvv.ad.th.rg;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class de extends qw {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public de(@NotNull qw qwVar, @NotNull rg rgVar) {
        super(qwVar, rgVar);
        Intrinsics.checkNotNullParameter(qwVar, "eglCore");
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] i(@org.jetbrains.annotations.NotNull android.graphics.Bitmap.CompressFormat r3) {
        /*
            r2 = this;
            java.lang.String r0 = "format"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r2.o(r0, r3)     // Catch:{ all -> 0x001b }
            byte[] r3 = r0.toByteArray()     // Catch:{ all -> 0x001b }
            java.lang.String r1 = "it.toByteArray()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x001b }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r3
        L_0x001b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001d }
        L_0x001d:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.vvv.ad.uk.de.i(android.graphics.Bitmap$CompressFormat):byte[]");
    }

    public final void o(@NotNull OutputStream outputStream, @NotNull Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(outputStream, "stream");
        Intrinsics.checkNotNullParameter(compressFormat, "format");
        if (rg()) {
            int fe2 = fe();
            int de2 = de();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fe2 * de2 * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, fe2, de2, 6408, 5121, allocateDirect);
            fe.ad("glReadPixels");
            allocateDirect.rewind();
            Bitmap createBitmap = Bitmap.createBitmap(fe2, de2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            createBitmap.compress(compressFormat, 90, outputStream);
            createBitmap.recycle();
            return;
        }
        throw new RuntimeException("Expected EGL context/surface is not current");
    }
}
