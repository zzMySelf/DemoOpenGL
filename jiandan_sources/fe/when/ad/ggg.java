package fe.when.ad;

import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import java.util.HashMap;

public class ggg implements IAccessibleElement {

    /* renamed from: ad  reason: collision with root package name */
    public s0 f9872ad = s0.E2;

    /* renamed from: th  reason: collision with root package name */
    public qw f9873th = null;

    /* renamed from: yj  reason: collision with root package name */
    public HashMap<s0, y0> f9874yj = null;

    public ggg(ListItem listItem) {
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.f9874yj;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.f9874yj;
    }

    public qw getId() {
        if (this.f9873th == null) {
            this.f9873th = new qw();
        }
        return this.f9873th;
    }

    public s0 getRole() {
        return this.f9872ad;
    }

    public boolean isInline() {
        return false;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.f9874yj == null) {
            this.f9874yj = new HashMap<>();
        }
        this.f9874yj.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.f9873th = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.f9872ad = s0Var;
    }
}
