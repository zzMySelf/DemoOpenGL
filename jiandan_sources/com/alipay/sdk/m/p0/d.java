package com.alipay.sdk.m.p0;

import android.database.ContentObserver;
import android.os.Handler;

public class d extends ContentObserver {
    public static final String d = "VMS_IDLG_SDK_Observer";
    public String a;
    public int b;
    public c c;

    public d(c cVar, int i2, String str) {
        super((Handler) null);
        this.c = cVar;
        this.b = i2;
        this.a = str;
    }

    public void onChange(boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this.b, this.a);
        }
    }
}
