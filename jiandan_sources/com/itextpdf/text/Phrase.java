package com.itextpdf.text;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.HyphenationEvent;
import fe.when.ad.c.qw;
import fe.when.ad.eee;
import fe.when.ad.fe;
import fe.when.ad.rrr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Phrase extends ArrayList<Element> implements TextElementArray {
    public static final long serialVersionUID = 2643594602455068231L;
    public Font font;
    public HyphenationEvent hyphenation;
    public float leading;
    public float multipliedLeading;
    public rrr tabSettings;

    public Phrase() {
        this(16.0f);
    }

    public static final Phrase getInstance(String str) {
        return getInstance(16, str, new Font());
    }

    public boolean addAll(Collection<? extends Element> collection) {
        for (Element add : collection) {
            add(add);
        }
        return true;
    }

    public boolean addChunk(fe feVar) {
        Font fe2 = feVar.fe();
        String de2 = feVar.de();
        Font font2 = this.font;
        if (font2 != null && !font2.when()) {
            fe2 = this.font.ad(feVar.fe());
        }
        if (size() > 0 && !feVar.i()) {
            try {
                fe feVar2 = (fe) get(size() - 1);
                if (!feVar2.i() && ((fe2 == null || fe2.compareTo(feVar2.fe()) == 0) && !"".equals(feVar2.de().trim()) && !"".equals(de2.trim()))) {
                    feVar2.qw(de2);
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        fe feVar3 = new fe(de2, fe2);
        feVar3.when(feVar.ad());
        feVar3.f9860uk = feVar.getRole();
        feVar3.f9856i = feVar.getAccessibleAttributes();
        if (this.hyphenation != null && feVar3.th() == null && !feVar3.o()) {
            feVar3.ggg(this.hyphenation);
        }
        return super.add(feVar3);
    }

    public void addSpecial(Element element) {
        super.add(element);
    }

    public List<fe> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.addAll(((Element) it.next()).getChunks());
        }
        return arrayList;
    }

    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();
        for (fe feVar : getChunks()) {
            stringBuffer.append(feVar.toString());
        }
        return stringBuffer.toString();
    }

    public Font getFont() {
        return this.font;
    }

    public HyphenationEvent getHyphenation() {
        return this.hyphenation;
    }

    public float getLeading() {
        Font font2;
        if (!Float.isNaN(this.leading) || (font2 = this.font) == null) {
            return this.leading;
        }
        return font2.th(1.5f);
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public rrr getTabSettings() {
        return this.tabSettings;
    }

    public float getTotalLeading() {
        Font font2 = this.font;
        float th2 = font2 == null ? this.multipliedLeading * 12.0f : font2.th(this.multipliedLeading);
        if (th2 <= 0.0f || hasLeading()) {
            return getLeading() + th2;
        }
        return th2;
    }

    public boolean hasLeading() {
        return !Float.isNaN(this.leading);
    }

    public boolean isContent() {
        return true;
    }

    public boolean isEmpty() {
        int size = size();
        if (size == 0) {
            return true;
        }
        if (size != 1) {
            return false;
        }
        Element element = (Element) get(0);
        return element.type() == 10 && ((fe) element).o();
    }

    public boolean isNestable() {
        return true;
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator it = iterator();
            while (it.hasNext()) {
                elementListener.ad((Element) it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void setFont(Font font2) {
        this.font = font2;
    }

    public void setHyphenation(HyphenationEvent hyphenationEvent) {
        this.hyphenation = hyphenationEvent;
    }

    public void setLeading(float f, float f2) {
        this.leading = f;
        this.multipliedLeading = f2;
    }

    public void setMultipliedLeading(float f) {
        this.leading = 0.0f;
        this.multipliedLeading = f;
    }

    public void setTabSettings(rrr rrr) {
        this.tabSettings = rrr;
    }

    public boolean trim() {
        while (size() > 0) {
            Element element = (Element) get(0);
            if (!(element instanceof fe) || !((fe) element).pf()) {
                break;
            }
            remove(element);
        }
        while (size() > 0) {
            Element element2 = (Element) get(size() - 1);
            if (!(element2 instanceof fe) || !((fe) element2).pf()) {
                break;
            }
            remove(element2);
        }
        if (size() > 0) {
            return true;
        }
        return false;
    }

    public int type() {
        return 11;
    }

    public Phrase(Phrase phrase) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        addAll(phrase);
        setLeading(phrase.getLeading(), phrase.getMultipliedLeading());
        this.font = phrase.getFont();
        this.tabSettings = phrase.getTabSettings();
        setHyphenation(phrase.getHyphenation());
    }

    public static final Phrase getInstance(int i2, String str) {
        return getInstance(i2, str, new Font());
    }

    public static final Phrase getInstance(int i2, String str, Font font2) {
        Phrase phrase = new Phrase(true);
        phrase.setLeading((float) i2);
        phrase.font = font2;
        if (font2.o() != Font.FontFamily.SYMBOL && font2.o() != Font.FontFamily.ZAPFDINGBATS && font2.fe() == null) {
            while (true) {
                int ad2 = eee.ad(str);
                if (ad2 <= -1) {
                    break;
                }
                if (ad2 > 0) {
                    phrase.add((Element) new fe(str.substring(0, ad2), font2));
                    str = str.substring(ad2);
                }
                Font font3 = new Font(Font.FontFamily.SYMBOL, font2.m676if(), font2.m677switch(), font2.i());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(eee.qw(str.charAt(0)));
                str = str.substring(1);
                while (eee.ad(str) == 0) {
                    stringBuffer.append(eee.qw(str.charAt(0)));
                    str = str.substring(1);
                }
                phrase.add((Element) new fe(stringBuffer.toString(), font3));
            }
        }
        if (!(str == null || str.length() == 0)) {
            phrase.add((Element) new fe(str, font2));
        }
        return phrase;
    }

    public void add(int i2, Element element) {
        if (element != null) {
            int type = element.type();
            if (!(type == 14 || type == 17 || type == 23 || type == 29 || type == 37 || type == 50 || type == 55 || type == 666)) {
                switch (type) {
                    case 10:
                        fe feVar = (fe) element;
                        if (!this.font.when()) {
                            feVar.ppp(this.font.ad(feVar.fe()));
                        }
                        if (this.hyphenation != null && feVar.th() == null && !feVar.o()) {
                            feVar.ggg(this.hyphenation);
                        }
                        super.add(i2, feVar);
                        return;
                    case 11:
                    case 12:
                        break;
                    default:
                        throw new ClassCastException(qw.ad("insertion.of.illegal.element.1", element.getClass().getName()));
                }
            }
            super.add(i2, element);
        }
    }

    public void setLeading(float f) {
        this.leading = f;
        this.multipliedLeading = 0.0f;
    }

    public Phrase(float f) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        this.leading = f;
        this.font = new Font();
    }

    public boolean add(String str) {
        if (str == null) {
            return false;
        }
        return super.add(new fe(str, this.font));
    }

    public boolean add(Element element) {
        boolean z;
        if (element == null) {
            return false;
        }
        try {
            int type = element.type();
            if (type == 14 || type == 17 || type == 23 || type == 29 || type == 37 || type == 50 || type == 55 || type == 666) {
                return super.add(element);
            }
            switch (type) {
                case 10:
                    return addChunk((fe) element);
                case 11:
                case 12:
                    Iterator it = ((Phrase) element).iterator();
                    boolean z2 = true;
                    while (it.hasNext()) {
                        Element element2 = (Element) it.next();
                        if (element2 instanceof fe) {
                            z = addChunk((fe) element2);
                        } else {
                            z = add(element2);
                        }
                        z2 &= z;
                    }
                    return z2;
                default:
                    throw new ClassCastException(String.valueOf(element.type()));
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(qw.ad("insertion.of.illegal.element.1", e.getMessage()));
        }
    }

    public Phrase(fe feVar) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        super.add(feVar);
        this.font = feVar.fe();
        setHyphenation(feVar.th());
    }

    public Phrase(float f, fe feVar) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        this.leading = f;
        super.add(feVar);
        this.font = feVar.fe();
        setHyphenation(feVar.th());
    }

    public Phrase(String str) {
        this(Float.NaN, str, new Font());
    }

    public Phrase(String str, Font font2) {
        this(Float.NaN, str, font2);
    }

    public Phrase(float f, String str) {
        this(f, str, new Font());
    }

    public Phrase(float f, String str, Font font2) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        this.leading = f;
        this.font = font2;
        if (str != null && str.length() != 0) {
            super.add(new fe(str, font2));
        }
    }

    public Phrase(boolean z) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
    }
}
