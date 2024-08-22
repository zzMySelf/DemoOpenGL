package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import fe.when.ad.qw;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PdfArtifact implements IAccessibleElement {

    /* renamed from: ad  reason: collision with root package name */
    public s0 f6542ad = s0.rrr;

    /* renamed from: th  reason: collision with root package name */
    public HashMap<s0, y0> f6543th = null;

    /* renamed from: yj  reason: collision with root package name */
    public qw f6544yj = new qw();

    public enum ArtifactType {
        PAGINATION,
        LAYOUT,
        PAGE,
        BACKGROUND
    }

    static {
        new HashSet(Arrays.asList(new String[]{"Pagination", "Layout", "Page", "Background"}));
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.f6543th;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.f6543th;
    }

    public qw getId() {
        return this.f6544yj;
    }

    public s0 getRole() {
        return this.f6542ad;
    }

    public boolean isInline() {
        return true;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.f6543th == null) {
            this.f6543th = new HashMap<>();
        }
        this.f6543th.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.f6544yj = qwVar;
    }

    public void setRole(s0 s0Var) {
    }
}
