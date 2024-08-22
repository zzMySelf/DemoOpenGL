package fe.rg.qw.o.th.yj;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class ad implements GifDecoder.BitmapProvider {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayPool f4992ad;
    public final BitmapPool qw;

    public ad(BitmapPool bitmapPool, @Nullable ArrayPool arrayPool) {
        this.qw = bitmapPool;
        this.f4992ad = arrayPool;
    }

    @NonNull
    public byte[] ad(int i2) {
        ArrayPool arrayPool = this.f4992ad;
        if (arrayPool == null) {
            return new byte[i2];
        }
        return (byte[]) arrayPool.de(i2, byte[].class);
    }

    @NonNull
    public Bitmap de(int i2, int i3, @NonNull Bitmap.Config config) {
        return this.qw.rg(i2, i3, config);
    }

    @NonNull
    public int[] fe(int i2) {
        ArrayPool arrayPool = this.f4992ad;
        if (arrayPool == null) {
            return new int[i2];
        }
        return (int[]) arrayPool.de(i2, int[].class);
    }

    public void qw(@NonNull Bitmap bitmap) {
        this.qw.de(bitmap);
    }

    public void rg(@NonNull byte[] bArr) {
        ArrayPool arrayPool = this.f4992ad;
        if (arrayPool != null) {
            arrayPool.put(bArr);
        }
    }

    public void th(@NonNull int[] iArr) {
        ArrayPool arrayPool = this.f4992ad;
        if (arrayPool != null) {
            arrayPool.put(iArr);
        }
    }
}
