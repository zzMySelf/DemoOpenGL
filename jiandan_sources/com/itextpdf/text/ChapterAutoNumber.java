package com.itextpdf.text;

import fe.when.ad.c.qw;

public class ChapterAutoNumber extends Chapter {
    public static final long serialVersionUID = -9217457637987854167L;
    public boolean numberSet = false;

    public ChapterAutoNumber(Paragraph paragraph) {
        super(paragraph, 0);
    }

    public Section addSection(String str) {
        if (!isAddedCompletely()) {
            return addSection(str, 2);
        }
        throw new IllegalStateException(qw.ad("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }

    public int setAutomaticNumber(int i2) {
        if (this.numberSet) {
            return i2;
        }
        int i3 = i2 + 1;
        super.setChapterNumber(i3);
        this.numberSet = true;
        return i3;
    }

    public ChapterAutoNumber(String str) {
        super(str, 0);
    }

    public Section addSection(Paragraph paragraph) {
        if (!isAddedCompletely()) {
            return addSection(paragraph, 2);
        }
        throw new IllegalStateException(qw.ad("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }
}
