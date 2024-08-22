package fe.when.ad.f;

import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.qw;
import java.util.ArrayList;
import java.util.HashMap;

public class e1 implements IAccessibleElement {

    /* renamed from: ad  reason: collision with root package name */
    public qw f9434ad = new qw();

    /* renamed from: th  reason: collision with root package name */
    public ArrayList<c1> f9435th = null;

    /* renamed from: uk  reason: collision with root package name */
    public HashMap<s0, y0> f9436uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public s0 f9437yj = s0.h5;

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.f9436uk;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.f9436uk;
    }

    public qw getId() {
        return this.f9434ad;
    }

    public s0 getRole() {
        return this.f9437yj;
    }

    public boolean isInline() {
        return false;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.f9436uk == null) {
            this.f9436uk = new HashMap<>();
        }
        this.f9436uk.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.f9434ad = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.f9437yj = s0Var;
    }
}
