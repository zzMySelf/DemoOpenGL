package com.dxmbumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

public interface GifDecoder {

    public interface BitmapProvider {
        @NonNull
        byte[] ad(int i2);

        @NonNull
        Bitmap de(int i2, int i3, @NonNull Bitmap.Config config);

        @NonNull
        int[] fe(int i2);

        void qw(@NonNull Bitmap bitmap);

        void rg(@NonNull byte[] bArr);

        void th(@NonNull int[] iArr);
    }

    void ad();

    void clear();

    int de();

    void fe(@NonNull Bitmap.Config config);

    @NonNull
    ByteBuffer getData();

    int i();

    @Nullable
    Bitmap qw();

    int rg();

    void th();

    int uk();

    int yj();
}
