package com.itextpdf.text.pdf;

import fe.when.ad.f.v0;

public enum PdfSigLockDictionary$LockPermissions {
    NO_CHANGES_ALLOWED(1),
    FORM_FILLING(2),
    FORM_FILLING_AND_ANNOTATION(3);
    
    public v0 number;

    /* access modifiers changed from: public */
    PdfSigLockDictionary$LockPermissions(int i2) {
        this.number = new v0(i2);
    }

    public v0 getValue() {
        return this.number;
    }
}
