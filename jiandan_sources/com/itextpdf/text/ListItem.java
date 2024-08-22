package com.itextpdf.text;

import fe.when.ad.f.s0;
import fe.when.ad.fe;
import fe.when.ad.ggg;
import fe.when.ad.vvv;
import java.util.List;

public class ListItem extends Paragraph {
    public static final long serialVersionUID = 1970670787169329006L;
    public ggg listBody = null;
    public vvv listLabel = null;
    public fe symbol;

    public ListItem() {
        setRole(s0.G2);
    }

    public void adjustListSymbolFont() {
        fe feVar;
        List<fe> chunks = getChunks();
        if (!chunks.isEmpty() && (feVar = this.symbol) != null) {
            feVar.ppp(chunks.get(0).fe());
        }
    }

    public ggg getListBody() {
        if (this.listBody == null) {
            this.listBody = new ggg(this);
        }
        return this.listBody;
    }

    public vvv getListLabel() {
        if (this.listLabel == null) {
            this.listLabel = new vvv(this);
        }
        return this.listLabel;
    }

    public fe getListSymbol() {
        return this.symbol;
    }

    public void setIndentationLeft(float f, boolean z) {
        if (z) {
            setIndentationLeft(getListSymbol().uk());
        } else {
            setIndentationLeft(f);
        }
    }

    public void setListSymbol(fe feVar) {
        if (this.symbol == null) {
            this.symbol = feVar;
            if (feVar.fe().when()) {
                this.symbol.ppp(this.font);
            }
        }
    }

    public int type() {
        return 15;
    }

    public ListItem(float f) {
        super(f);
        setRole(s0.G2);
    }

    public ListItem(fe feVar) {
        super(feVar);
        setRole(s0.G2);
    }

    public ListItem(String str) {
        super(str);
        setRole(s0.G2);
    }

    public ListItem(String str, Font font) {
        super(str, font);
        setRole(s0.G2);
    }

    public ListItem(float f, fe feVar) {
        super(f, feVar);
        setRole(s0.G2);
    }

    public ListItem(float f, String str) {
        super(f, str);
        setRole(s0.G2);
    }

    public ListItem(float f, String str, Font font) {
        super(f, str, font);
        setRole(s0.G2);
    }

    public ListItem(Phrase phrase) {
        super(phrase);
        setRole(s0.G2);
    }
}
