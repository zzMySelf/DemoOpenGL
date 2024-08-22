package fe.p013if.ad.qw;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import fe.p013if.ad.qw.p015switch.de;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* renamed from: fe.if.ad.qw.th  reason: invalid package */
public class th {
    public static final Object mmm = new Object();

    /* renamed from: ad  reason: collision with root package name */
    public PdfiumCore f4569ad;
    public final boolean ddd;

    /* renamed from: de  reason: collision with root package name */
    public int f4570de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public List<Size> f4571fe = new ArrayList();
    public List<Float> ggg = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public Size f4572i = new Size(0, 0);

    /* renamed from: if  reason: not valid java name */
    public boolean f168if;
    public int[] nn;

    /* renamed from: o  reason: collision with root package name */
    public SizeF f4573o = new SizeF(0.0f, 0.0f);

    /* renamed from: pf  reason: collision with root package name */
    public SizeF f4574pf = new SizeF(0.0f, 0.0f);
    public List<Float> ppp = new ArrayList();
    public PdfDocument qw;

    /* renamed from: rg  reason: collision with root package name */
    public List<SizeF> f4575rg = new ArrayList();

    /* renamed from: switch  reason: not valid java name */
    public int f169switch;

    /* renamed from: th  reason: collision with root package name */
    public SparseBooleanArray f4576th = new SparseBooleanArray();

    /* renamed from: uk  reason: collision with root package name */
    public Size f4577uk = new Size(0, 0);
    public float vvv = 0.0f;
    public boolean when;
    public final FitPolicy xxx;

    /* renamed from: yj  reason: collision with root package name */
    public Queue<Integer> f4578yj = new LinkedList();

    public th(PdfiumCore pdfiumCore, PdfDocument pdfDocument, FitPolicy fitPolicy, Size size, int[] iArr, boolean z, int i2, boolean z2, boolean z3) {
        this.f4569ad = pdfiumCore;
        this.qw = pdfDocument;
        this.xxx = fitPolicy;
        this.nn = iArr;
        this.f168if = z;
        this.f169switch = i2;
        this.when = z2;
        this.ddd = z3;
        a(size);
    }

    public final void a(Size size) {
        int[] iArr = this.nn;
        if (iArr != null) {
            this.f4570de = iArr.length;
        } else {
            this.f4570de = this.f4569ad.getPageCount(this.qw);
        }
        for (int i2 = 0; i2 < this.f4570de; i2++) {
            Size pageSize = this.f4569ad.getPageSize(this.qw, de(i2));
            if (pageSize.getWidth() > this.f4577uk.getWidth()) {
                this.f4577uk = pageSize;
            }
            if (pageSize.getHeight() > this.f4572i.getHeight()) {
                this.f4572i = pageSize;
            }
            this.f4571fe.add(pageSize);
        }
        rrr(size);
    }

    public final void aaa(Size size) {
        float f;
        float f2;
        this.ggg.clear();
        for (int i2 = 0; i2 < ggg(); i2++) {
            SizeF sizeF = this.f4575rg.get(i2);
            if (this.f168if) {
                f = (float) size.getHeight();
                f2 = sizeF.getHeight();
            } else {
                f = (float) size.getWidth();
                f2 = sizeF.getWidth();
            }
            float max = Math.max(0.0f, f - f2);
            if (i2 < ggg() - 1) {
                max += (float) this.f169switch;
            }
            this.ggg.add(Float.valueOf(max));
        }
    }

    public void ad() {
        PdfDocument pdfDocument;
        PdfiumCore pdfiumCore = this.f4569ad;
        if (!(pdfiumCore == null || (pdfDocument = this.qw) == null)) {
            pdfiumCore.closeDocument(pdfDocument);
        }
        this.qw = null;
        this.nn = null;
    }

    public RectF ddd(int i2, int i3, int i4, int i5, int i6, RectF rectF) {
        return this.f4569ad.mapRectToDevice(this.qw, de(i2), i3, i4, i5, i6, 0, rectF);
    }

    public int de(int i2) {
        int i3;
        int[] iArr = this.nn;
        if (iArr == null) {
            i3 = i2;
        } else if (i2 < 0 || i2 >= iArr.length) {
            return -1;
        } else {
            i3 = iArr[i2];
        }
        if (i3 < 0 || i2 >= ggg()) {
            return -1;
        }
        return i3;
    }

    public final void eee() {
        float f;
        float f2;
        this.ppp.clear();
        float f3 = 0.0f;
        for (int i2 = 0; i2 < ggg(); i2++) {
            SizeF sizeF = this.f4575rg.get(i2);
            float height = this.f168if ? sizeF.getHeight() : sizeF.getWidth();
            if (this.when) {
                f += this.ggg.get(i2).floatValue() / 2.0f;
                if (i2 == 0) {
                    f -= ((float) this.f169switch) / 2.0f;
                } else if (i2 == ggg() - 1) {
                    f += ((float) this.f169switch) / 2.0f;
                }
                this.ppp.add(Float.valueOf(f));
                f2 = this.ggg.get(i2).floatValue() / 2.0f;
            } else {
                this.ppp.add(Float.valueOf(f));
                f2 = (float) this.f169switch;
            }
            f3 = f + height + f2;
        }
    }

    public List<PdfDocument.Bookmark> fe() {
        PdfDocument pdfDocument = this.qw;
        if (pdfDocument == null) {
            return new ArrayList();
        }
        return this.f4569ad.getTableOfContents(pdfDocument);
    }

    public int ggg() {
        return this.f4570de;
    }

    public PdfDocument.Meta i() {
        PdfDocument pdfDocument = this.qw;
        if (pdfDocument == null) {
            return null;
        }
        return this.f4569ad.getDocumentMeta(pdfDocument);
    }

    /* renamed from: if  reason: not valid java name */
    public List<PdfDocument.Link> m291if(int i2) {
        return this.f4569ad.getPageLinks(this.qw, de(i2));
    }

    public boolean mmm(int i2) {
        return !this.f4576th.get(de(i2), false);
    }

    public boolean nn(int i2) throws PageRenderingException {
        Integer poll;
        int de2 = de(i2);
        if (de2 < 0) {
            return false;
        }
        synchronized (mmm) {
            if (this.f4576th.indexOfKey(de2) >= 0) {
                return false;
            }
            try {
                this.f4569ad.openPage(this.qw, de2);
                this.f4576th.put(de2, true);
                this.f4578yj.add(Integer.valueOf(i2));
                if (this.f4578yj.size() > 10 && (poll = this.f4578yj.poll()) != null) {
                    this.f4569ad.closePage(this.qw, poll.intValue());
                    this.f4576th.delete(poll.intValue());
                }
                return true;
            } catch (Exception e) {
                this.f4576th.put(de2, false);
                throw new PageRenderingException(i2, e);
            }
        }
    }

    public int o(float f, float f2) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < ggg() && (this.ppp.get(i2).floatValue() * f2) - (ppp(i2, f2) / 2.0f) < f) {
            i3++;
            i2++;
        }
        int i4 = i3 - 1;
        if (i4 >= 0) {
            return i4;
        }
        return 0;
    }

    public float pf(int i2, float f) {
        SizeF when2 = when(i2);
        return (this.f168if ? when2.getHeight() : when2.getWidth()) * f;
    }

    public float ppp(int i2, float f) {
        return (this.when ? this.ggg.get(i2).floatValue() : (float) this.f169switch) * f;
    }

    public final void qqq() {
        float f;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < ggg(); i2++) {
            SizeF sizeF = this.f4575rg.get(i2);
            f2 += this.f168if ? sizeF.getHeight() : sizeF.getWidth();
            if (this.when) {
                f = this.ggg.get(i2).floatValue();
            } else if (i2 < ggg() - 1) {
                f = (float) this.f169switch;
            }
            f2 += f;
        }
        this.vvv = f2;
    }

    public int qw(int i2) {
        int ggg2;
        if (i2 <= 0) {
            return 0;
        }
        int[] iArr = this.nn;
        if (iArr != null) {
            if (i2 >= iArr.length) {
                ggg2 = iArr.length;
            }
            return i2;
        }
        if (i2 >= ggg()) {
            ggg2 = ggg();
        }
        return i2;
        return ggg2 - 1;
    }

    public float rg(float f) {
        return this.vvv * f;
    }

    public void rrr(Size size) {
        this.f4575rg.clear();
        de deVar = new de(this.xxx, this.f4577uk, this.f4572i, size, this.ddd);
        this.f4574pf = deVar.yj();
        this.f4573o = deVar.th();
        for (Size qw2 : this.f4571fe) {
            this.f4575rg.add(deVar.qw(qw2));
        }
        if (this.when) {
            aaa(size);
        }
        qqq();
        eee();
    }

    /* renamed from: switch  reason: not valid java name */
    public float m292switch(int i2, float f) {
        if (de(i2) < 0) {
            return 0.0f;
        }
        return this.ppp.get(i2).floatValue() * f;
    }

    public float th() {
        return yj().getHeight();
    }

    public void tt(Bitmap bitmap, int i2, Rect rect, boolean z) {
        Bitmap bitmap2 = bitmap;
        this.f4569ad.renderPageBitmap(this.qw, bitmap2, de(i2), rect.left, rect.top, rect.width(), rect.height(), z);
    }

    public float uk() {
        return yj().getWidth();
    }

    public SizeF vvv(int i2, float f) {
        SizeF when2 = when(i2);
        return new SizeF(when2.getWidth() * f, when2.getHeight() * f);
    }

    public SizeF when(int i2) {
        if (de(i2) < 0) {
            return new SizeF(0.0f, 0.0f);
        }
        return this.f4575rg.get(i2);
    }

    public float xxx(int i2, float f) {
        float th2;
        float height;
        SizeF when2 = when(i2);
        if (this.f168if) {
            th2 = uk();
            height = when2.getWidth();
        } else {
            th2 = th();
            height = when2.getHeight();
        }
        return (f * (th2 - height)) / 2.0f;
    }

    public SizeF yj() {
        return this.f168if ? this.f4574pf : this.f4573o;
    }
}
