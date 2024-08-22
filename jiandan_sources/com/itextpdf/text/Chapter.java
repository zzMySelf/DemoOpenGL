package com.itextpdf.text;

import java.util.ArrayList;

public class Chapter extends Section {
    public static final long serialVersionUID = 1791000695779357361L;

    public Chapter(int i2) {
        super((Paragraph) null, 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.numbers = arrayList;
        arrayList.add(Integer.valueOf(i2));
        this.triggerNewPage = true;
    }

    public boolean isNestable() {
        return false;
    }

    public int type() {
        return 16;
    }

    public Chapter(Paragraph paragraph, int i2) {
        super(paragraph, 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.numbers = arrayList;
        arrayList.add(Integer.valueOf(i2));
        this.triggerNewPage = true;
    }

    public Chapter(String str, int i2) {
        this(new Paragraph(str), i2);
    }
}
