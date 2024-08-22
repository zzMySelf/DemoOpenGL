package fe.p013if.ad.qw;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import com.github.barteksc.pdfviewer.PDFThumb;
import com.shockwave.pdfium.util.SizeF;

/* renamed from: fe.if.ad.qw.yj  reason: invalid package */
public class yj extends PDFThumb {
    public yj(Looper looper, th thVar) {
        super(looper, thVar);
    }

    public void ad(Runnable runnable) {
        runnable.run();
    }

    public Bitmap rg(int i2, SizeF sizeF) {
        try {
            this.qw.nn(i2);
            if (this.qw.mmm(i2)) {
                return null;
            }
            int width = (int) sizeF.getWidth();
            int height = (int) sizeF.getHeight();
            if (height > 14400) {
                width = (width * 14400) / height;
                height = 14400;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            this.qw.tt(createBitmap, i2, new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), false);
            return createBitmap;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public SizeF uk(SizeF sizeF) {
        return sizeF;
    }
}
