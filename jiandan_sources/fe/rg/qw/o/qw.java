package fe.rg.qw.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidubce.services.bos.BosClientConfiguration;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class qw {
    /* JADX INFO: finally extract failed */
    @NonNull
    public static ImageHeaderParser.ImageType ad(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
        int i2 = 0;
        int size = list.size();
        while (i2 < size) {
            try {
                ImageHeaderParser.ImageType ad2 = list.get(i2).ad(inputStream);
                if (ad2 != ImageHeaderParser.ImageType.UNKNOWN) {
                    inputStream.reset();
                    return ad2;
                }
                inputStream.reset();
                i2++;
            } catch (Throwable th2) {
                inputStream.reset();
                throw th2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageHeaderParser.ImageType de(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType qw = list.get(i2).qw(byteBuffer);
            if (qw != ImageHeaderParser.ImageType.UNKNOWN) {
                return qw;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    public static int qw(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
        int i2 = 0;
        int size = list.size();
        while (i2 < size) {
            try {
                int de2 = list.get(i2).de(inputStream, arrayPool);
                if (de2 != -1) {
                    inputStream.reset();
                    return de2;
                }
                inputStream.reset();
                i2++;
            } catch (Throwable th2) {
                inputStream.reset();
                throw th2;
            }
        }
        return -1;
    }
}
