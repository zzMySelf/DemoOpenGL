package fe.when.ad;

import com.itextpdf.text.ChapterAutoNumber;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.LargeElement;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.c.qw;
import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class th implements DocListener, IAccessibleElement {
    public static float aaa = 0.86f;
    public static boolean mmm = false;
    public static boolean nn = true;

    /* renamed from: ad  reason: collision with root package name */
    public ArrayList<DocListener> f9891ad;
    public qw ddd;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public float f9892i;

    /* renamed from: if  reason: not valid java name */
    public float f475if;

    /* renamed from: o  reason: collision with root package name */
    public float f9893o;

    /* renamed from: pf  reason: collision with root package name */
    public float f9894pf;
    public int ppp;

    /* renamed from: switch  reason: not valid java name */
    public boolean f476switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9895th;

    /* renamed from: uk  reason: collision with root package name */
    public aaa f9896uk;
    public s0 vvv;
    public boolean when;
    public HashMap<s0, y0> xxx;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9897yj;

    public th() {
        this(mmm.qw);
    }

    public boolean ad(Element element) throws DocumentException {
        boolean z = false;
        if (this.f9897yj) {
            throw new DocumentException(qw.ad("the.document.has.been.closed.you.can.t.add.any.elements", new Object[0]));
        } else if (this.f9895th || !element.isContent()) {
            if (element instanceof ChapterAutoNumber) {
                this.ggg = ((ChapterAutoNumber) element).setAutomaticNumber(this.ggg);
            }
            Iterator<DocListener> it = this.f9891ad.iterator();
            while (it.hasNext()) {
                z |= it.next().ad(element);
            }
            if (element instanceof LargeElement) {
                LargeElement largeElement = (LargeElement) element;
                if (!largeElement.isComplete()) {
                    largeElement.flushContent();
                }
            }
            return z;
        } else {
            throw new DocumentException(qw.ad("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        }
    }

    public void close() {
        if (!this.f9897yj) {
            this.f9895th = false;
            this.f9897yj = true;
        }
        Iterator<DocListener> it = this.f9891ad.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    public float ddd() {
        return this.f9894pf;
    }

    public boolean de(aaa aaa2) {
        this.f9896uk = aaa2;
        Iterator<DocListener> it = this.f9891ad.iterator();
        while (it.hasNext()) {
            it.next().de(aaa2);
        }
        return true;
    }

    public boolean fe(float f, float f2, float f3, float f4) {
        this.f9892i = f;
        this.f9893o = f2;
        this.f9894pf = f3;
        this.f475if = f4;
        Iterator<DocListener> it = this.f9891ad.iterator();
        while (it.hasNext()) {
            it.next().fe(f, f2, f3, f4);
        }
        return true;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.xxx;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.xxx;
    }

    public qw getId() {
        return this.ddd;
    }

    public s0 getRole() {
        return this.vvv;
    }

    public float ggg() {
        return this.f9893o;
    }

    public float i() {
        return this.f475if;
    }

    /* renamed from: if  reason: not valid java name */
    public float m1132if() {
        return this.f9896uk.xxx(this.f9892i);
    }

    public boolean isInline() {
        return false;
    }

    public int o() {
        return this.ppp;
    }

    public void open() {
        if (!this.f9897yj) {
            this.f9895th = true;
        }
        Iterator<DocListener> it = this.f9891ad.iterator();
        while (it.hasNext()) {
            DocListener next = it.next();
            next.de(this.f9896uk);
            next.fe(this.f9892i, this.f9893o, this.f9894pf, this.f475if);
            next.open();
        }
    }

    public aaa pf() {
        return this.f9896uk;
    }

    public float ppp(float f) {
        return this.f9896uk.nn(this.f9893o + f);
    }

    public boolean qw() {
        if (!this.f9895th || this.f9897yj) {
            return false;
        }
        Iterator<DocListener> it = this.f9891ad.iterator();
        while (it.hasNext()) {
            it.next().qw();
        }
        return true;
    }

    public boolean rg() {
        try {
            return ad(new nn(6, new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date())));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.xxx == null) {
            this.xxx = new HashMap<>();
        }
        this.xxx.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.ddd = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.vvv = s0Var;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1133switch(float f) {
        return this.f9896uk.xxx(this.f9892i + f);
    }

    public void th(DocListener docListener) {
        this.f9891ad.add(docListener);
        if (docListener instanceof IAccessibleElement) {
            IAccessibleElement iAccessibleElement = (IAccessibleElement) docListener;
            iAccessibleElement.setRole(this.vvv);
            iAccessibleElement.setId(this.ddd);
            HashMap<s0, y0> hashMap = this.xxx;
            if (hashMap != null) {
                for (s0 next : hashMap.keySet()) {
                    iAccessibleElement.setAccessibleAttribute(next, this.xxx.get(next));
                }
            }
        }
    }

    public float uk(float f) {
        return this.f9896uk.ppp(this.f475if + f);
    }

    public float vvv() {
        return this.f9896uk.qqq(this.f9894pf);
    }

    public float when() {
        return this.f9892i;
    }

    public float xxx(float f) {
        return this.f9896uk.qqq(this.f9894pf + f);
    }

    public boolean yj() {
        try {
            return ad(new nn(5, b.qw().fe()));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public th(aaa aaa2) {
        this(aaa2, 36.0f, 36.0f, 36.0f, 36.0f);
    }

    public th(aaa aaa2, float f, float f2, float f3, float f4) {
        this.f9891ad = new ArrayList<>();
        this.f9892i = 0.0f;
        this.f9893o = 0.0f;
        this.f9894pf = 0.0f;
        this.f475if = 0.0f;
        this.f476switch = false;
        this.when = false;
        this.ppp = 0;
        this.ggg = 0;
        this.vvv = s0.C0;
        this.xxx = null;
        this.ddd = new qw();
        this.f9896uk = aaa2;
        this.f9892i = f;
        this.f9893o = f2;
        this.f9894pf = f3;
        this.f475if = f4;
    }
}
