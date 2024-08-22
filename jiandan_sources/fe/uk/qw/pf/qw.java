package fe.uk.qw.pf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidubce.services.bos.BosClientConfiguration;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import fe.uk.qw.pf.de.pf;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class qw {

    public class ad implements yj {
        public final /* synthetic */ ByteBuffer qw;

        public ad(ByteBuffer byteBuffer) {
            this.qw = byteBuffer;
        }

        public ImageHeaderParser.ImageType qw(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.qw(this.qw);
        }
    }

    public class de implements yj {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ArrayPool f5893ad;
        public final /* synthetic */ pf qw;

        public de(pf pfVar, ArrayPool arrayPool) {
            this.qw = pfVar;
            this.f5893ad = arrayPool;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.dxmbumptech.glide.load.ImageHeaderParser.ImageType qw(com.dxmbumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                com.dxmbumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.dxmbumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0027 }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0027 }
                fe.uk.qw.pf.de.pf r3 = r4.qw     // Catch:{ all -> 0x0027 }
                android.os.ParcelFileDescriptor r3 = r3.qw()     // Catch:{ all -> 0x0027 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0027 }
                r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r4.f5893ad     // Catch:{ all -> 0x0027 }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x0027 }
                com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.ad(r1)     // Catch:{ all -> 0x0024 }
                r1.close()     // Catch:{ IOException -> 0x001e }
            L_0x001e:
                fe.uk.qw.pf.de.pf r0 = r4.qw
                r0.qw()
                return r5
            L_0x0024:
                r5 = move-exception
                r0 = r1
                goto L_0x0028
            L_0x0027:
                r5 = move-exception
            L_0x0028:
                if (r0 == 0) goto L_0x002d
                r0.close()     // Catch:{ IOException -> 0x002d }
            L_0x002d:
                fe.uk.qw.pf.de.pf r0 = r4.qw
                r0.qw()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.pf.qw.de.qw(com.dxmbumptech.glide.load.ImageHeaderParser):com.dxmbumptech.glide.load.ImageHeaderParser$ImageType");
        }
    }

    public class fe implements th {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ArrayPool f5894ad;
        public final /* synthetic */ InputStream qw;

        public fe(InputStream inputStream, ArrayPool arrayPool) {
            this.qw = inputStream;
            this.f5894ad = arrayPool;
        }

        public int qw(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.de(this.qw, this.f5894ad);
            } finally {
                this.qw.reset();
            }
        }
    }

    /* renamed from: fe.uk.qw.pf.qw$qw  reason: collision with other inner class name */
    public class C0237qw implements yj {
        public final /* synthetic */ InputStream qw;

        public C0237qw(InputStream inputStream) {
            this.qw = inputStream;
        }

        public ImageHeaderParser.ImageType qw(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.ad(this.qw);
            } finally {
                this.qw.reset();
            }
        }
    }

    public class rg implements th {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ArrayPool f5895ad;
        public final /* synthetic */ pf qw;

        public rg(pf pfVar, ArrayPool arrayPool) {
            this.qw = pfVar;
            this.f5895ad = arrayPool;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int qw(com.dxmbumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                com.dxmbumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.dxmbumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0029 }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0029 }
                fe.uk.qw.pf.de.pf r3 = r4.qw     // Catch:{ all -> 0x0029 }
                android.os.ParcelFileDescriptor r3 = r3.qw()     // Catch:{ all -> 0x0029 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0029 }
                r2.<init>(r3)     // Catch:{ all -> 0x0029 }
                com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r4.f5895ad     // Catch:{ all -> 0x0029 }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x0029 }
                com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool r0 = r4.f5895ad     // Catch:{ all -> 0x0026 }
                int r5 = r5.de(r1, r0)     // Catch:{ all -> 0x0026 }
                r1.close()     // Catch:{ IOException -> 0x0020 }
            L_0x0020:
                fe.uk.qw.pf.de.pf r0 = r4.qw
                r0.qw()
                return r5
            L_0x0026:
                r5 = move-exception
                r0 = r1
                goto L_0x002a
            L_0x0029:
                r5 = move-exception
            L_0x002a:
                if (r0 == 0) goto L_0x002f
                r0.close()     // Catch:{ IOException -> 0x002f }
            L_0x002f:
                fe.uk.qw.pf.de.pf r0 = r4.qw
                r0.qw()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.pf.qw.rg.qw(com.dxmbumptech.glide.load.ImageHeaderParser):int");
        }
    }

    public interface th {
        int qw(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public interface yj {
        ImageHeaderParser.ImageType qw(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public static int ad(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
        return de(list, new fe(inputStream, arrayPool));
    }

    public static int de(@NonNull List<ImageHeaderParser> list, th thVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int qw = thVar.qw(list.get(i2));
            if (qw != -1) {
                return qw;
            }
        }
        return -1;
    }

    @RequiresApi(21)
    @NonNull
    public static ImageHeaderParser.ImageType fe(@NonNull List<ImageHeaderParser> list, @NonNull pf pfVar, @NonNull ArrayPool arrayPool) throws IOException {
        return yj(list, new de(pfVar, arrayPool));
    }

    @RequiresApi(21)
    public static int qw(@NonNull List<ImageHeaderParser> list, @NonNull pf pfVar, @NonNull ArrayPool arrayPool) throws IOException {
        return de(list, new rg(pfVar, arrayPool));
    }

    @NonNull
    public static ImageHeaderParser.ImageType rg(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
        return yj(list, new C0237qw(inputStream));
    }

    @NonNull
    public static ImageHeaderParser.ImageType th(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return yj(list, new ad(byteBuffer));
    }

    @NonNull
    public static ImageHeaderParser.ImageType yj(@NonNull List<ImageHeaderParser> list, yj yjVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType qw = yjVar.qw(list.get(i2));
            if (qw != ImageHeaderParser.ImageType.UNKNOWN) {
                return qw;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
