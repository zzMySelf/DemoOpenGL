package com.itextpdf.text.pdf.interfaces;

import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import fe.when.ad.qw;
import java.util.HashMap;

public interface IAccessibleElement {
    y0 getAccessibleAttribute(s0 s0Var);

    HashMap<s0, y0> getAccessibleAttributes();

    qw getId();

    s0 getRole();

    boolean isInline();

    void setAccessibleAttribute(s0 s0Var, y0 y0Var);

    void setId(qw qwVar);

    void setRole(s0 s0Var);
}
