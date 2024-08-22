package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.uk.qw.pf.de.pf;
import fe.uk.qw.vvv.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ggg {

    @RequiresApi(21)
    public static final class ad implements ggg {

        /* renamed from: ad  reason: collision with root package name */
        public final List<ImageHeaderParser> f5954ad;

        /* renamed from: de  reason: collision with root package name */
        public final pf f5955de;
        public final ArrayPool qw;

        public ad(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            i.fe(arrayPool);
            this.qw = arrayPool;
            i.fe(list);
            this.f5954ad = list;
            this.f5955de = new pf(parcelFileDescriptor);
        }

        public void ad() {
        }

        public int de() throws IOException {
            return fe.uk.qw.pf.qw.qw(this.f5954ad, this.f5955de, this.qw);
        }

        public ImageHeaderParser.ImageType fe() throws IOException {
            return fe.uk.qw.pf.qw.fe(this.f5954ad, this.f5955de, this.qw);
        }

        @Nullable
        public Bitmap qw(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f5955de.qw().getFileDescriptor(), (Rect) null, options);
        }
    }

    public static final class qw implements ggg {

        /* renamed from: ad  reason: collision with root package name */
        public final ArrayPool f5956ad;

        /* renamed from: de  reason: collision with root package name */
        public final List<ImageHeaderParser> f5957de;
        public final fe.uk.qw.pf.de.i qw;

        public qw(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            i.fe(arrayPool);
            this.f5956ad = arrayPool;
            i.fe(list);
            this.f5957de = list;
            this.qw = new fe.uk.qw.pf.de.i(inputStream, arrayPool);
        }

        public void ad() {
            this.qw.de();
        }

        public int de() throws IOException {
            return fe.uk.qw.pf.qw.ad(this.f5957de, this.qw.qw(), this.f5956ad);
        }

        public ImageHeaderParser.ImageType fe() throws IOException {
            return fe.uk.qw.pf.qw.rg(this.f5957de, this.qw.qw(), this.f5956ad);
        }

        @Nullable
        public Bitmap qw(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.qw.qw(), (Rect) null, options);
        }
    }

    void ad();

    int de() throws IOException;

    ImageHeaderParser.ImageType fe() throws IOException;

    @Nullable
    Bitmap qw(BitmapFactory.Options options) throws IOException;
}
