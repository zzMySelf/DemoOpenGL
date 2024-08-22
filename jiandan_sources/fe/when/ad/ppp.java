package fe.when.ad;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.TextElementArray;
import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ppp implements TextElementArray, Indentable, IAccessibleElement {

    /* renamed from: ad  reason: collision with root package name */
    public ArrayList<Element> f9877ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9878i;

    /* renamed from: if  reason: not valid java name */
    public float f473if;

    /* renamed from: o  reason: collision with root package name */
    public boolean f9879o;

    /* renamed from: pf  reason: collision with root package name */
    public float f9880pf;
    public qw ppp;

    /* renamed from: switch  reason: not valid java name */
    public s0 f474switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9881th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f9882uk;
    public HashMap<s0, y0> when;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9883yj;

    public ppp() {
        this(false, false);
    }

    public float ad() {
        return this.f9880pf;
    }

    public float de() {
        return this.f473if;
    }

    public ArrayList<Element> fe() {
        return this.f9877ad;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.when;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.when;
    }

    public List<fe> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = this.f9877ad.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getChunks());
        }
        return arrayList;
    }

    public qw getId() {
        if (this.ppp == null) {
            this.ppp = new qw();
        }
        return this.ppp;
    }

    public s0 getRole() {
        return this.f474switch;
    }

    public boolean i() {
        return this.f9882uk;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1130if(float f) {
        this.f9880pf = f;
    }

    public boolean isContent() {
        return true;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isNestable() {
        return true;
    }

    public boolean o() {
        return this.f9881th;
    }

    public void pf() {
        Iterator<Element> it = this.f9877ad.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            Element next = it.next();
            if (next instanceof ListItem) {
                f = Math.max(f, ((ListItem) next).getIndentationLeft());
            }
        }
        Iterator<Element> it2 = this.f9877ad.iterator();
        while (it2.hasNext()) {
            Element next2 = it2.next();
            if (next2 instanceof ListItem) {
                ((ListItem) next2).setIndentationLeft(f);
            }
        }
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator<Element> it = this.f9877ad.iterator();
            while (it.hasNext()) {
                elementListener.ad(it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ListItem qw() {
        Element element = this.f9877ad.size() > 0 ? this.f9877ad.get(0) : null;
        if (element != null) {
            if (element instanceof ListItem) {
                return (ListItem) element;
            }
            if (element instanceof ppp) {
                return ((ppp) element).qw();
            }
        }
        return null;
    }

    public ListItem rg() {
        Element element;
        if (this.f9877ad.size() > 0) {
            ArrayList<Element> arrayList = this.f9877ad;
            element = arrayList.get(arrayList.size() - 1);
        } else {
            element = null;
        }
        if (element != null) {
            if (element instanceof ListItem) {
                return (ListItem) element;
            }
            if (element instanceof ppp) {
                return ((ppp) element).rg();
            }
        }
        return null;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.when == null) {
            this.when = new HashMap<>();
        }
        this.when.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.ppp = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.f474switch = s0Var;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1131switch(float f) {
        this.f473if = f;
    }

    public boolean th() {
        return this.f9879o;
    }

    public int type() {
        return 14;
    }

    public boolean uk() {
        return this.f9883yj;
    }

    public boolean yj() {
        return this.f9878i;
    }

    public ppp(boolean z, boolean z2) {
        this.f9877ad = new ArrayList<>();
        this.f9881th = false;
        this.f9883yj = false;
        this.f9882uk = false;
        this.f9878i = false;
        this.f9879o = false;
        new fe("- ");
        this.f9880pf = 0.0f;
        this.f473if = 0.0f;
        this.f474switch = s0.v2;
        this.when = null;
        this.ppp = null;
        this.f9881th = z;
        this.f9883yj = z2;
        this.f9878i = true;
        this.f9879o = true;
    }
}
