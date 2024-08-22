package fe.when.ad;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ad implements Element {

    /* renamed from: ad  reason: collision with root package name */
    public int f9305ad;

    /* renamed from: i  reason: collision with root package name */
    public float f9306i = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f9307o = Float.NaN;

    /* renamed from: th  reason: collision with root package name */
    public HashMap<String, Object> f9308th = new HashMap<>();

    /* renamed from: uk  reason: collision with root package name */
    public float f9309uk = Float.NaN;

    /* renamed from: yj  reason: collision with root package name */
    public float f9310yj = Float.NaN;

    public ad(ad adVar) {
        this.f9305ad = adVar.f9305ad;
        this.f9308th = adVar.f9308th;
        this.f9310yj = adVar.f9310yj;
        this.f9309uk = adVar.f9309uk;
        this.f9306i = adVar.f9306i;
        this.f9307o = adVar.f9307o;
    }

    public HashMap<String, Object> ad() {
        return this.f9308th;
    }

    public String de() {
        String str = (String) this.f9308th.get("content");
        return str == null ? "" : str;
    }

    public float fe() {
        return this.f9310yj;
    }

    public List<fe> getChunks() {
        return new ArrayList();
    }

    public String i() {
        String str = (String) this.f9308th.get("title");
        return str == null ? "" : str;
    }

    /* renamed from: if  reason: not valid java name */
    public float m1063if() {
        return this.f9307o;
    }

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public float o() {
        return this.f9306i;
    }

    public float pf(float f) {
        if (Float.isNaN(this.f9306i)) {
            return f;
        }
        return this.f9306i;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.ad(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int qw() {
        return this.f9305ad;
    }

    public float rg(float f) {
        if (Float.isNaN(this.f9310yj)) {
            return f;
        }
        return this.f9310yj;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1064switch(float f) {
        if (Float.isNaN(this.f9307o)) {
            return f;
        }
        return this.f9307o;
    }

    public float th() {
        return this.f9309uk;
    }

    public int type() {
        return 29;
    }

    public void uk(float f, float f2, float f3, float f4) {
        this.f9310yj = f;
        this.f9309uk = f2;
        this.f9306i = f3;
        this.f9307o = f4;
    }

    public float yj(float f) {
        if (Float.isNaN(this.f9309uk)) {
            return f;
        }
        return this.f9309uk;
    }
}
