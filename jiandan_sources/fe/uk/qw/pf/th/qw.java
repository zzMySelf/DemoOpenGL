package fe.uk.qw.pf.th;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.dlife.ctaccountapi.x;
import com.dxmbumptech.glide.load.DecodeFormat;
import com.dxmbumptech.glide.load.PreferredColorSpace;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.dxmbumptech.glide.load.resource.bitmap.Downsampler;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.th.fe.ppp;
import java.io.IOException;

@RequiresApi(api = 28)
public abstract class qw<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    public final ppp qw = ppp.ad();

    /* renamed from: fe.uk.qw.pf.th.qw$qw  reason: collision with other inner class name */
    public class C0242qw implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f5987ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ boolean f5988de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ DecodeFormat f5989fe;
        public final /* synthetic */ int qw;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ DownsampleStrategy f5990rg;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ PreferredColorSpace f5991th;

        /* renamed from: fe.uk.qw.pf.th.qw$qw$qw  reason: collision with other inner class name */
        public class C0243qw implements ImageDecoder.OnPartialImageListener {
            public C0243qw(C0242qw qwVar) {
            }

            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public C0242qw(int i2, int i3, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.qw = i2;
            this.f5987ad = i3;
            this.f5988de = z;
            this.f5989fe = decodeFormat;
            this.f5990rg = downsampleStrategy;
            this.f5991th = preferredColorSpace;
        }

        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = false;
            if (qw.this.qw.rg(this.qw, this.f5987ad, this.f5988de, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f5989fe == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0243qw(this));
            Size size = imageInfo.getSize();
            int i2 = this.qw;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getWidth();
            }
            int i3 = this.f5987ad;
            if (i3 == Integer.MIN_VALUE) {
                i3 = size.getHeight();
            }
            float ad2 = this.f5990rg.ad(size.getWidth(), size.getHeight(), i2, i3);
            int round = Math.round(((float) size.getWidth()) * ad2);
            int round2 = Math.round(((float) size.getHeight()) * ad2);
            if (Log.isLoggable("ImageDecoder", 2)) {
                "Resizing from [" + size.getWidth() + x.a + size.getHeight() + "] to [" + round + x.a + round2 + "] scaleFactor: " + ad2;
            }
            imageDecoder.setTargetSize(round, round2);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28) {
                if (this.f5991th == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i4 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    public abstract Resource<T> de(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Nullable
    /* renamed from: fe */
    public final Resource<T> ad(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull ad adVar) throws IOException {
        return de(source, i2, i3, new C0242qw(i2, i3, adVar.de(Downsampler.f3888i) != null && ((Boolean) adVar.de(Downsampler.f3888i)).booleanValue(), (DecodeFormat) adVar.de(Downsampler.f3891th), (DownsampleStrategy) adVar.de(DownsampleStrategy.f3886th), (PreferredColorSpace) adVar.de(Downsampler.f3893yj)));
    }

    /* renamed from: rg */
    public final boolean qw(@NonNull ImageDecoder.Source source, @NonNull ad adVar) {
        return true;
    }
}
