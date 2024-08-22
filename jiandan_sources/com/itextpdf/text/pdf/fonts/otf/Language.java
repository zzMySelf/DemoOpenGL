package com.itextpdf.text.pdf.fonts.otf;

import java.util.Arrays;
import java.util.List;

public enum Language {
    BENGALI("beng", "bng2");
    
    public final List<String> codes;

    /* access modifiers changed from: public */
    Language(String... strArr) {
        this.codes = Arrays.asList(strArr);
    }

    public boolean isSupported(String str) {
        return this.codes.contains(str);
    }
}
