package fe.vvv.qw;

import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.BitmapCallback;
import com.otaliastudios.cameraview.FileCallback;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.PictureFormat;
import fe.vvv.qw.xxx.ad;
import java.io.File;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final int f8957ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f8958de;

    /* renamed from: fe  reason: collision with root package name */
    public final byte[] f8959fe;
    public final Location qw;

    /* renamed from: rg  reason: collision with root package name */
    public final PictureFormat f8960rg;

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public Location f8961ad;

        /* renamed from: de  reason: collision with root package name */
        public int f8962de;

        /* renamed from: fe  reason: collision with root package name */
        public ad f8963fe;
        public boolean qw;

        /* renamed from: rg  reason: collision with root package name */
        public Facing f8964rg;

        /* renamed from: th  reason: collision with root package name */
        public byte[] f8965th;

        /* renamed from: yj  reason: collision with root package name */
        public PictureFormat f8966yj;
    }

    public fe(@NonNull qw qwVar) {
        boolean z = qwVar.qw;
        this.qw = qwVar.f8961ad;
        this.f8957ad = qwVar.f8962de;
        this.f8958de = qwVar.f8963fe;
        Facing facing = qwVar.f8964rg;
        this.f8959fe = qwVar.f8965th;
        this.f8960rg = qwVar.f8966yj;
    }

    @NonNull
    public ad ad() {
        return this.f8958de;
    }

    public void de(int i2, int i3, @NonNull BitmapCallback bitmapCallback) {
        PictureFormat pictureFormat = this.f8960rg;
        if (pictureFormat == PictureFormat.JPEG) {
            de.fe(qw(), i2, i3, new BitmapFactory.Options(), this.f8957ad, bitmapCallback);
        } else if (pictureFormat != PictureFormat.DNG || Build.VERSION.SDK_INT < 24) {
            throw new UnsupportedOperationException("PictureResult.toBitmap() does not support this picture format: " + this.f8960rg);
        } else {
            de.fe(qw(), i2, i3, new BitmapFactory.Options(), this.f8957ad, bitmapCallback);
        }
    }

    public void fe(@NonNull BitmapCallback bitmapCallback) {
        de(-1, -1, bitmapCallback);
    }

    @NonNull
    public byte[] qw() {
        return this.f8959fe;
    }

    public void rg(@NonNull File file, @NonNull FileCallback fileCallback) {
        de.yj(qw(), file, fileCallback);
    }
}
