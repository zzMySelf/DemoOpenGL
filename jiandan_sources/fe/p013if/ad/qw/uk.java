package fe.p013if.ad.qw;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;

/* renamed from: fe.if.ad.qw.uk  reason: invalid package */
public class uk extends Handler {

    /* renamed from: th  reason: collision with root package name */
    public static final String f4579th = uk.class.getName();

    /* renamed from: ad  reason: collision with root package name */
    public RectF f4580ad = new RectF();

    /* renamed from: de  reason: collision with root package name */
    public Rect f4581de = new Rect();

    /* renamed from: fe  reason: collision with root package name */
    public Matrix f4582fe = new Matrix();
    public PDFView qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f4583rg = false;

    /* renamed from: fe.if.ad.qw.uk$ad */
    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PageRenderingException f4584ad;

        public ad(PageRenderingException pageRenderingException) {
            this.f4584ad = pageRenderingException;
        }

        public void run() {
            uk.this.qw.onPageError(this.f4584ad);
        }
    }

    /* renamed from: fe.if.ad.qw.uk$de */
    public class de {

        /* renamed from: ad  reason: collision with root package name */
        public float f4586ad;

        /* renamed from: de  reason: collision with root package name */
        public RectF f4587de;

        /* renamed from: fe  reason: collision with root package name */
        public int f4588fe;
        public float qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f4589rg;

        /* renamed from: th  reason: collision with root package name */
        public int f4590th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f4591uk;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f4592yj;

        public de(uk ukVar, float f, float f2, RectF rectF, int i2, boolean z, int i3, boolean z2, boolean z3) {
            this.f4588fe = i2;
            this.qw = f;
            this.f4586ad = f2;
            this.f4587de = rectF;
            this.f4589rg = z;
            this.f4590th = i3;
            this.f4592yj = z2;
            this.f4591uk = z3;
        }
    }

    /* renamed from: fe.if.ad.qw.uk$qw */
    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.p013if.ad.qw.pf.ad f4593ad;

        public qw(fe.p013if.ad.qw.pf.ad adVar) {
            this.f4593ad = adVar;
        }

        public void run() {
            uk.this.qw.onBitmapRendered(this.f4593ad);
        }
    }

    public uk(Looper looper, PDFView pDFView) {
        super(looper);
        this.qw = pDFView;
    }

    public void ad(int i2, float f, float f2, RectF rectF, boolean z, int i3, boolean z2, boolean z3) {
        sendMessage(obtainMessage(1, new de(this, f, f2, rectF, i2, z, i3, z2, z3)));
    }

    public final void de(int i2, int i3, RectF rectF) {
        this.f4582fe.reset();
        float f = (float) i2;
        float f2 = (float) i3;
        this.f4582fe.postTranslate((-rectF.left) * f, (-rectF.top) * f2);
        this.f4582fe.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.f4580ad.set(0.0f, 0.0f, f, f2);
        this.f4582fe.mapRect(this.f4580ad);
        this.f4580ad.round(this.f4581de);
    }

    public final fe.p013if.ad.qw.pf.ad fe(de deVar) throws PageRenderingException {
        Bitmap.Config config;
        th thVar = this.qw.pdfFile;
        if (thVar == null) {
            return null;
        }
        thVar.nn(deVar.f4588fe);
        int round = Math.round(deVar.qw);
        int round2 = Math.round(deVar.f4586ad);
        if (!(round == 0 || round2 == 0 || thVar.mmm(deVar.f4588fe))) {
            try {
                if (deVar.f4592yj) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                Bitmap createBitmap = Bitmap.createBitmap(round, round2, config);
                de(round, round2, deVar.f4587de);
                thVar.tt(createBitmap, deVar.f4588fe, this.f4581de, deVar.f4591uk);
                return new fe.p013if.ad.qw.pf.ad(deVar.f4588fe, createBitmap, deVar.f4587de, deVar.f4589rg, deVar.f4590th);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void handleMessage(Message message) {
        try {
            fe.p013if.ad.qw.pf.ad fe2 = fe((de) message.obj);
            if (fe2 == null) {
                return;
            }
            if (this.f4583rg) {
                this.qw.post(new qw(fe2));
            } else {
                fe2.fe().recycle();
            }
        } catch (PageRenderingException e) {
            this.qw.post(new ad(e));
        }
    }

    public void rg() {
        this.f4583rg = true;
    }

    public void th() {
        this.f4583rg = false;
    }
}
