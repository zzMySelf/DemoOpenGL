package fe.p013if.ad.qw.p015switch;

import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;

/* renamed from: fe.if.ad.qw.switch.de  reason: invalid package */
public class de {

    /* renamed from: ad  reason: collision with root package name */
    public final Size f4561ad;

    /* renamed from: de  reason: collision with root package name */
    public final Size f4562de;

    /* renamed from: fe  reason: collision with root package name */
    public final Size f4563fe;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4564i;
    public FitPolicy qw;

    /* renamed from: rg  reason: collision with root package name */
    public SizeF f4565rg;

    /* renamed from: th  reason: collision with root package name */
    public SizeF f4566th;

    /* renamed from: uk  reason: collision with root package name */
    public float f4567uk;

    /* renamed from: yj  reason: collision with root package name */
    public float f4568yj;

    /* renamed from: fe.if.ad.qw.switch.de$qw */
    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.barteksc.pdfviewer.util.FitPolicy[] r0 = com.github.barteksc.pdfviewer.util.FitPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.github.barteksc.pdfviewer.util.FitPolicy r1 = com.github.barteksc.pdfviewer.util.FitPolicy.HEIGHT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.barteksc.pdfviewer.util.FitPolicy r1 = com.github.barteksc.pdfviewer.util.FitPolicy.BOTH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.p013if.ad.qw.p015switch.de.qw.<clinit>():void");
        }
    }

    public de(FitPolicy fitPolicy, Size size, Size size2, Size size3, boolean z) {
        this.qw = fitPolicy;
        this.f4561ad = size;
        this.f4562de = size2;
        this.f4563fe = size3;
        this.f4564i = z;
        ad();
    }

    public final void ad() {
        int i2 = qw.qw[this.qw.ordinal()];
        if (i2 == 1) {
            SizeF fe2 = fe(this.f4562de, (float) this.f4563fe.getHeight());
            this.f4566th = fe2;
            this.f4567uk = fe2.getHeight() / ((float) this.f4562de.getHeight());
            Size size = this.f4561ad;
            this.f4565rg = fe(size, ((float) size.getHeight()) * this.f4567uk);
        } else if (i2 != 2) {
            SizeF rg2 = rg(this.f4561ad, (float) this.f4563fe.getWidth());
            this.f4565rg = rg2;
            this.f4568yj = rg2.getWidth() / ((float) this.f4561ad.getWidth());
            Size size2 = this.f4562de;
            this.f4566th = rg(size2, ((float) size2.getWidth()) * this.f4568yj);
        } else {
            float width = de(this.f4561ad, (float) this.f4563fe.getWidth(), (float) this.f4563fe.getHeight()).getWidth() / ((float) this.f4561ad.getWidth());
            Size size3 = this.f4562de;
            SizeF de2 = de(size3, ((float) size3.getWidth()) * width, (float) this.f4563fe.getHeight());
            this.f4566th = de2;
            this.f4567uk = de2.getHeight() / ((float) this.f4562de.getHeight());
            SizeF de3 = de(this.f4561ad, (float) this.f4563fe.getWidth(), ((float) this.f4561ad.getHeight()) * this.f4567uk);
            this.f4565rg = de3;
            this.f4568yj = de3.getWidth() / ((float) this.f4561ad.getWidth());
        }
    }

    public final SizeF de(Size size, float f, float f2) {
        float width = ((float) size.getWidth()) / ((float) size.getHeight());
        float floor = (float) Math.floor((double) (f / width));
        if (floor > f2) {
            f = (float) Math.floor((double) (width * f2));
        } else {
            f2 = floor;
        }
        return new SizeF(f, f2);
    }

    public final SizeF fe(Size size, float f) {
        return new SizeF((float) Math.floor((double) (f / (((float) size.getHeight()) / ((float) size.getWidth())))), f);
    }

    public SizeF qw(Size size) {
        if (size.getWidth() <= 0 || size.getHeight() <= 0) {
            return new SizeF(0.0f, 0.0f);
        }
        float width = this.f4564i ? (float) this.f4563fe.getWidth() : ((float) size.getWidth()) * this.f4568yj;
        float height = this.f4564i ? (float) this.f4563fe.getHeight() : ((float) size.getHeight()) * this.f4567uk;
        int i2 = qw.qw[this.qw.ordinal()];
        if (i2 == 1) {
            return fe(size, height);
        }
        if (i2 != 2) {
            return rg(size, width);
        }
        return de(size, width, height);
    }

    public final SizeF rg(Size size, float f) {
        return new SizeF(f, (float) Math.floor((double) (f / (((float) size.getWidth()) / ((float) size.getHeight())))));
    }

    public SizeF th() {
        return this.f4566th;
    }

    public SizeF yj() {
        return this.f4565rg;
    }
}
