package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.shockwave.pdfium.util.SizeF;
import com.tera.scan.ui.widget.RotateProgress;
import fe.p013if.ad.qw.th;
import java.lang.ref.WeakReference;

public class PDFThumb {

    /* renamed from: ad  reason: collision with root package name */
    public qw f4395ad;

    /* renamed from: de  reason: collision with root package name */
    public Handler f4396de = new Handler(Looper.getMainLooper());

    /* renamed from: fe  reason: collision with root package name */
    public IThumbCallback f4397fe;
    public th qw;

    public interface ILongPicCallback {
    }

    public interface IThumbCallback {
        void ad(int i2);

        void qw(int i2, Bitmap bitmap);
    }

    public static class qw extends Handler {
        public WeakReference<PDFThumb> qw;

        /* renamed from: com.github.barteksc.pdfviewer.PDFThumb$qw$qw  reason: collision with other inner class name */
        public class C0185qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ PDFThumb f4398ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ Bitmap f4399th;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ int f4400yj;

            public C0185qw(qw qwVar, PDFThumb pDFThumb, Bitmap bitmap, int i2) {
                this.f4398ad = pDFThumb;
                this.f4399th = bitmap;
                this.f4400yj = i2;
            }

            public void run() {
                if (this.f4398ad.f4397fe == null) {
                    return;
                }
                if (this.f4399th != null) {
                    this.f4398ad.f4397fe.qw(this.f4400yj, this.f4399th);
                } else {
                    this.f4398ad.f4397fe.ad(this.f4400yj);
                }
            }
        }

        public qw(PDFThumb pDFThumb, Looper looper) {
            super(looper);
            this.qw = new WeakReference<>(pDFThumb);
        }

        public void handleMessage(Message message) {
            PDFThumb pDFThumb = (PDFThumb) this.qw.get();
            if (pDFThumb != null) {
                int i2 = message.what;
                pDFThumb.ad(new C0185qw(this, pDFThumb, pDFThumb.rg(i2, pDFThumb.uk(pDFThumb.qw.when(i2))), i2));
            }
        }
    }

    public PDFThumb(Looper looper, th thVar) {
        this.qw = thVar;
        this.f4395ad = new qw(this, looper);
    }

    public void ad(Runnable runnable) {
        this.f4396de.post(runnable);
    }

    public void de() {
        this.f4395ad.removeCallbacksAndMessages((Object) null);
    }

    public int fe() {
        return this.qw.ggg();
    }

    public Bitmap rg(int i2, SizeF sizeF) {
        try {
            this.qw.nn(i2);
            if (this.qw.mmm(i2)) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap((int) sizeF.getWidth(), (int) sizeF.getHeight(), Bitmap.Config.RGB_565);
            this.qw.tt(createBitmap, i2, new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), false);
            return createBitmap;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public void th(int i2) {
        this.f4395ad.sendEmptyMessage(i2);
    }

    public SizeF uk(SizeF sizeF) {
        double min = Math.min(Math.min(360.0d / ((double) sizeF.getWidth()), 520.0d / ((double) sizeF.getHeight())), 1.0d);
        return new SizeF((float) Math.min(RotateProgress.FULL_DEGREE, (int) (((double) sizeF.getWidth()) * min)), (float) Math.min(520, (int) (((double) sizeF.getHeight()) * min)));
    }

    public void yj(IThumbCallback iThumbCallback) {
        this.f4397fe = iThumbCallback;
    }
}
