package com.tera.scan.network.network.api;

public enum NetdiskApi$Scheme {
    HTTPS("https://"),
    HTTP("http://");
    
    public String mSchemeValue;

    /* access modifiers changed from: public */
    NetdiskApi$Scheme(String str) {
        this.mSchemeValue = str;
    }

    public String getValue() {
        return this.mSchemeValue;
    }
}
