package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.f.d1;
import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import fe.when.ad.fe;
import fe.when.ad.i;
import fe.when.ad.ppp;
import fe.when.ad.qw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Paragraph extends Phrase implements Indentable, Spaceable, IAccessibleElement {
    public static final long serialVersionUID = 7852314969733375514L;
    public HashMap<s0, y0> accessibleAttributes = null;
    public int alignment = -1;
    public float extraParagraphSpace = 0.0f;
    public float firstLineIndent = 0.0f;
    public qw id = null;
    public float indentationLeft;
    public float indentationRight;
    public boolean keeptogether = false;
    public s0 role = s0.F3;
    public float spacingAfter;
    public float spacingBefore;

    public Paragraph() {
    }

    public List<Element> breakUp() {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        Paragraph paragraph = null;
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Element element = (Element) it.next();
            if (element.type() == 14 || element.type() == 23 || element.type() == 12) {
                if (paragraph != null && paragraph.size() > 0) {
                    paragraph.setSpacingAfter(0.0f);
                    arrayList.add(paragraph);
                    paragraph = cloneShallow(false);
                }
                if (arrayList.size() == 0) {
                    int type = element.type();
                    if (type == 12) {
                        ((Paragraph) element).setSpacingBefore(getSpacingBefore());
                    } else if (type == 14) {
                        ListItem qw = ((ppp) element).qw();
                        if (qw != null) {
                            qw.setSpacingBefore(getSpacingBefore());
                        }
                    } else if (type == 23) {
                        ((d1) element).F(getSpacingBefore());
                    }
                }
                arrayList.add(element);
            } else {
                if (paragraph == null) {
                    if (arrayList.size() != 0) {
                        z = false;
                    }
                    paragraph = cloneShallow(z);
                }
                paragraph.add(element);
            }
        }
        if (paragraph != null && paragraph.size() > 0) {
            arrayList.add(paragraph);
        }
        if (arrayList.size() != 0) {
            Element element2 = (Element) arrayList.get(arrayList.size() - 1);
            int type2 = element2.type();
            if (type2 == 12) {
                ((Paragraph) element2).setSpacingAfter(getSpacingAfter());
            } else if (type2 == 14) {
                ListItem rg2 = ((ppp) element2).rg();
                if (rg2 != null) {
                    rg2.setSpacingAfter(getSpacingAfter());
                }
            } else if (type2 == 23) {
                ((d1) element2).E(getSpacingAfter());
            }
        }
        return arrayList;
    }

    public Paragraph cloneShallow(boolean z) {
        Paragraph paragraph = new Paragraph();
        paragraph.setFont(getFont());
        paragraph.setAlignment(getAlignment());
        paragraph.setLeading(getLeading(), this.multipliedLeading);
        paragraph.setIndentationLeft(getIndentationLeft());
        paragraph.setIndentationRight(getIndentationRight());
        paragraph.setFirstLineIndent(getFirstLineIndent());
        paragraph.setSpacingAfter(getSpacingAfter());
        if (z) {
            paragraph.setSpacingBefore(getSpacingBefore());
        }
        paragraph.setExtraParagraphSpace(getExtraParagraphSpace());
        paragraph.setRole(this.role);
        paragraph.id = getId();
        if (this.accessibleAttributes != null) {
            paragraph.accessibleAttributes = new HashMap<>(this.accessibleAttributes);
        }
        paragraph.setTabSettings(getTabSettings());
        paragraph.setKeepTogether(getKeepTogether());
        return paragraph;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.accessibleAttributes;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.accessibleAttributes;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public float getFirstLineIndent() {
        return this.firstLineIndent;
    }

    public qw getId() {
        if (this.id == null) {
            this.id = new qw();
        }
        return this.id;
    }

    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    public float getIndentationRight() {
        return this.indentationRight;
    }

    public boolean getKeepTogether() {
        return this.keeptogether;
    }

    public s0 getRole() {
        return this.role;
    }

    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    public boolean isInline() {
        return false;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(s0Var, y0Var);
    }

    public void setAlignment(int i2) {
        this.alignment = i2;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void setFirstLineIndent(float f) {
        this.firstLineIndent = f;
    }

    public void setId(qw qwVar) {
        this.id = qwVar;
    }

    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setKeepTogether(boolean z) {
        this.keeptogether = z;
    }

    public void setRole(s0 s0Var) {
        this.role = s0Var;
    }

    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Deprecated
    public float spacingAfter() {
        return this.spacingAfter;
    }

    @Deprecated
    public float spacingBefore() {
        return getSpacingBefore();
    }

    public int type() {
        return 12;
    }

    public boolean add(Element element) {
        if (element instanceof ppp) {
            ppp ppp = (ppp) element;
            ppp.m1130if(ppp.ad() + this.indentationLeft);
            ppp.m1131switch(this.indentationRight);
            return super.add((Element) ppp);
        } else if (element instanceof i) {
            super.addSpecial(element);
            return true;
        } else if (!(element instanceof Paragraph)) {
            return super.add(element);
        } else {
            super.addSpecial(element);
            return true;
        }
    }

    public Paragraph(float f) {
        super(f);
    }

    public Paragraph(fe feVar) {
        super(feVar);
    }

    public Paragraph(float f, fe feVar) {
        super(f, feVar);
    }

    public Paragraph(String str) {
        super(str);
    }

    public Paragraph(String str, Font font) {
        super(str, font);
    }

    public Paragraph(float f, String str) {
        super(f, str);
    }

    public Paragraph(float f, String str, Font font) {
        super(f, str, font);
    }

    public Paragraph(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            setAlignment(paragraph.alignment);
            setIndentationLeft(paragraph.getIndentationLeft());
            setIndentationRight(paragraph.getIndentationRight());
            setFirstLineIndent(paragraph.getFirstLineIndent());
            setSpacingAfter(paragraph.getSpacingAfter());
            setSpacingBefore(paragraph.getSpacingBefore());
            setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
            setRole(paragraph.role);
            this.id = paragraph.getId();
            if (paragraph.accessibleAttributes != null) {
                this.accessibleAttributes = new HashMap<>(paragraph.accessibleAttributes);
            }
        }
    }
}
