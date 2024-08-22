package com.itextpdf.text;

import com.baidu.wallet.paysdk.datamodel.Bank;
import fe.when.ad.fe;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Anchor extends Phrase {
    public static final long serialVersionUID = -852278536049236911L;
    public String name = null;
    public String reference = null;

    public Anchor() {
        super(16.0f);
    }

    public boolean applyAnchor(fe feVar, boolean z, boolean z2) {
        if (this.name != null && z && !feVar.o()) {
            feVar.vvv(this.name);
            z = false;
        }
        if (z2) {
            feVar.xxx(this.reference.substring(1));
        } else {
            String str = this.reference;
            if (str != null) {
                feVar.m1127if(str);
            }
        }
        return z;
    }

    public List<fe> getChunks() {
        String str = this.reference;
        boolean z = true;
        boolean z2 = str != null && str.startsWith(Bank.HOT_BANK_LETTER);
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element instanceof fe) {
                fe feVar = (fe) element;
                z = applyAnchor(feVar, z, z2);
                arrayList.add(feVar);
            } else {
                for (fe next : element.getChunks()) {
                    z = applyAnchor(next, z, z2);
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public String getName() {
        return this.name;
    }

    public String getReference() {
        return this.reference;
    }

    public URL getUrl() {
        try {
            return new URL(this.reference);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public boolean process(ElementListener elementListener) {
        try {
            boolean z = this.reference != null && this.reference.startsWith(Bank.HOT_BANK_LETTER);
            boolean z2 = true;
            for (fe next : getChunks()) {
                if (this.name != null && z2 && !next.o()) {
                    next.vvv(this.name);
                    z2 = false;
                }
                if (z) {
                    next.xxx(this.reference.substring(1));
                }
                elementListener.ad(next);
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public int type() {
        return 17;
    }

    public Anchor(float f) {
        super(f);
    }

    public Anchor(fe feVar) {
        super(feVar);
    }

    public Anchor(String str) {
        super(str);
    }

    public Anchor(String str, Font font) {
        super(str, font);
    }

    public Anchor(float f, fe feVar) {
        super(f, feVar);
    }

    public Anchor(float f, String str) {
        super(f, str);
    }

    public Anchor(float f, String str, Font font) {
        super(f, str, font);
    }

    public Anchor(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Anchor) {
            Anchor anchor = (Anchor) phrase;
            setName(anchor.name);
            setReference(anchor.reference);
        }
    }
}
