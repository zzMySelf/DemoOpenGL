package com.dxmbumptech.glide.load;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        public final boolean hasAlpha;

        /* access modifiers changed from: public */
        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    @NonNull
    ImageType ad(@NonNull InputStream inputStream) throws IOException;

    int de(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException;

    @NonNull
    ImageType qw(@NonNull ByteBuffer byteBuffer) throws IOException;
}
