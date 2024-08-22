package fe.when.ad;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.c.qw;
import fe.when.ad.f.h;
import fe.when.ad.f.s0;
import fe.when.ad.f.w1;
import fe.when.ad.f.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class fe implements Element, IAccessibleElement {

    /* renamed from: if  reason: not valid java name */
    public static final fe f469if;

    /* renamed from: switch  reason: not valid java name */
    public static final fe f470switch;

    /* renamed from: ad  reason: collision with root package name */
    public StringBuffer f9855ad;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<s0, y0> f9856i;

    /* renamed from: o  reason: collision with root package name */
    public qw f9857o;

    /* renamed from: pf  reason: collision with root package name */
    public String f9858pf;

    /* renamed from: th  reason: collision with root package name */
    public Font f9859th;

    /* renamed from: uk  reason: collision with root package name */
    public s0 f9860uk;

    /* renamed from: yj  reason: collision with root package name */
    public HashMap<String, Object> f9861yj;

    static {
        fe feVar = new fe(StringUtils.LF);
        f469if = feVar;
        feVar.setRole(s0.F3);
        fe feVar2 = new fe("");
        f470switch = feVar2;
        feVar2.ddd();
        Float valueOf = Float.valueOf(Float.NaN);
        new fe(valueOf, false);
        new fe(valueOf, true);
    }

    public fe() {
        this.f9855ad = null;
        this.f9859th = null;
        this.f9861yj = null;
        this.f9860uk = null;
        this.f9856i = null;
        this.f9857o = null;
        this.f9858pf = null;
        this.f9855ad = new StringBuffer();
        this.f9859th = new Font();
        this.f9860uk = s0.Q4;
    }

    public HashMap<String, Object> ad() {
        return this.f9861yj;
    }

    public fe ddd() {
        m1128switch("NEWPAGE", (Object) null);
        return this;
    }

    public String de() {
        if (this.f9858pf == null) {
            this.f9858pf = this.f9855ad.toString().replaceAll("\t", "");
        }
        return this.f9858pf;
    }

    public Font fe() {
        return this.f9859th;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        if (yj() != null) {
            return yj().getAccessibleAttribute(s0Var);
        }
        HashMap<s0, y0> hashMap = this.f9856i;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        if (yj() != null) {
            return yj().getAccessibleAttributes();
        }
        return this.f9856i;
    }

    public List<fe> getChunks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    public qw getId() {
        if (this.f9857o == null) {
            this.f9857o = new qw();
        }
        return this.f9857o;
    }

    public s0 getRole() {
        if (yj() != null) {
            return yj().getRole();
        }
        return this.f9860uk;
    }

    public fe ggg(HyphenationEvent hyphenationEvent) {
        m1128switch("HYPHENATION", hyphenationEvent);
        return this;
    }

    public boolean i() {
        return this.f9861yj != null;
    }

    /* renamed from: if  reason: not valid java name */
    public fe m1127if(String str) {
        setRole(s0.J2);
        setAccessibleAttribute(s0.vvv, new w1(str));
        m1128switch("ACTION", new h(str));
        return this;
    }

    public boolean isContent() {
        return true;
    }

    public boolean isInline() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public boolean o() {
        return this.f9855ad.toString().trim().length() == 0 && this.f9855ad.toString().indexOf(StringUtils.LF) == -1 && this.f9861yj == null;
    }

    public boolean pf() {
        HashMap<String, Object> hashMap = this.f9861yj;
        return hashMap != null && hashMap.containsKey("WHITESPACE");
    }

    public void ppp(Font font) {
        this.f9859th = font;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.ad(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public StringBuffer qw(String str) {
        this.f9858pf = null;
        StringBuffer stringBuffer = this.f9855ad;
        stringBuffer.append(str);
        return stringBuffer;
    }

    public float rg() {
        Float f;
        HashMap<String, Object> hashMap = this.f9861yj;
        if (hashMap == null || (f = (Float) hashMap.get("HSCALE")) == null) {
            return 1.0f;
        }
        return f.floatValue();
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (yj() != null) {
            yj().setAccessibleAttribute(s0Var, y0Var);
            return;
        }
        if (this.f9856i == null) {
            this.f9856i = new HashMap<>();
        }
        this.f9856i.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.f9857o = qwVar;
    }

    public void setRole(s0 s0Var) {
        if (yj() != null) {
            yj().setRole(s0Var);
        } else {
            this.f9860uk = s0Var;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final fe m1128switch(String str, Object obj) {
        if (this.f9861yj == null) {
            this.f9861yj = new HashMap<>();
        }
        this.f9861yj.put(str, obj);
        return this;
    }

    public HyphenationEvent th() {
        HashMap<String, Object> hashMap = this.f9861yj;
        if (hashMap == null) {
            return null;
        }
        return (HyphenationEvent) hashMap.get("HYPHENATION");
    }

    public String toString() {
        return de();
    }

    public int type() {
        return 10;
    }

    public float uk() {
        if (yj() != null) {
            return yj().T();
        }
        return this.f9859th.rg(true).eee(de(), this.f9859th.uk()) * rg();
    }

    public fe vvv(String str) {
        m1128switch("LOCALDESTINATION", str);
        return this;
    }

    public void when(HashMap<String, Object> hashMap) {
        this.f9861yj = hashMap;
    }

    public fe xxx(String str) {
        m1128switch("LOCALGOTO", str);
        return this;
    }

    public i yj() {
        Object[] objArr;
        HashMap<String, Object> hashMap = this.f9861yj;
        if (hashMap == null || (objArr = (Object[]) hashMap.get("IMAGE")) == null) {
            return null;
        }
        return (i) objArr[0];
    }

    public fe(fe feVar) {
        this.f9855ad = null;
        this.f9859th = null;
        this.f9861yj = null;
        this.f9860uk = null;
        this.f9856i = null;
        this.f9857o = null;
        this.f9858pf = null;
        StringBuffer stringBuffer = feVar.f9855ad;
        if (stringBuffer != null) {
            this.f9855ad = new StringBuffer(stringBuffer.toString());
        }
        Font font = feVar.f9859th;
        if (font != null) {
            this.f9859th = new Font(font);
        }
        if (feVar.f9861yj != null) {
            this.f9861yj = new HashMap<>(feVar.f9861yj);
        }
        this.f9860uk = feVar.f9860uk;
        if (feVar.f9856i != null) {
            this.f9856i = new HashMap<>(feVar.f9856i);
        }
        this.f9857o = feVar.getId();
    }

    public fe(String str, Font font) {
        this.f9855ad = null;
        this.f9859th = null;
        this.f9861yj = null;
        this.f9860uk = null;
        this.f9856i = null;
        this.f9857o = null;
        this.f9858pf = null;
        this.f9855ad = new StringBuffer(str);
        this.f9859th = font;
        this.f9860uk = s0.Q4;
    }

    public fe(String str) {
        this(str, new Font());
    }

    public fe(DrawInterface drawInterface, boolean z) {
        this("￼", new Font());
        m1128switch("SEPARATOR", new Object[]{drawInterface, Boolean.valueOf(z)});
        this.f9860uk = null;
    }

    public fe(Float f, boolean z) {
        this("￼", new Font());
        if (f.floatValue() >= 0.0f) {
            m1128switch("TAB", new Object[]{f, Boolean.valueOf(z)});
            m1128switch("SPLITCHARACTER", tt.qw);
            m1128switch("TABSETTINGS", (Object) null);
            this.f9860uk = s0.rrr;
            return;
        }
        throw new IllegalArgumentException(qw.ad("a.tab.position.may.not.be.lower.than.0.yours.is.1", String.valueOf(f)));
    }

    public fe(i iVar, float f, float f2, boolean z) {
        this("￼", new Font());
        m1128switch("IMAGE", new Object[]{iVar, new Float(f), new Float(f2), Boolean.valueOf(z)});
        this.f9860uk = s0.rrr;
    }
}
