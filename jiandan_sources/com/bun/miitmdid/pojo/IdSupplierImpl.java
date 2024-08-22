package com.bun.miitmdid.pojo;

import androidx.annotation.Keep;
import com.bun.miitmdid.interfaces.IdSupplier;

@Keep
public class IdSupplierImpl implements IdSupplier {
    @Keep
    public final String AAID;
    @Keep
    public final String OAID;
    @Keep
    public final String VAID;
    @Keep
    public final boolean isLimited;
    @Keep
    public final boolean isSupported;

    public IdSupplierImpl() {
        this.OAID = "";
        this.VAID = "";
        this.AAID = "";
        this.isSupported = false;
        this.isLimited = false;
    }

    public IdSupplierImpl(String str, String str2, String str3, boolean z, boolean z2) {
        this.OAID = str;
        this.VAID = str2;
        this.AAID = str3;
        this.isSupported = z;
        this.isLimited = z2;
    }

    @Keep
    public native String getAAID();

    @Keep
    public native String getOAID();

    @Keep
    public native String getVAID();

    @Keep
    public native boolean isLimited();

    @Keep
    public native boolean isSupported();
}
