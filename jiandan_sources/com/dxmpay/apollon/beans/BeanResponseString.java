package com.dxmpay.apollon.beans;

public class BeanResponseString extends BeanResponseBase {
    public String content = null;

    public String getRealResponseContent() {
        String str = this.content;
        return str != null ? str.toString() : "";
    }

    public String getToken() {
        return this.token;
    }
}
