package com.dxmpay.apollon.restnet.converter;

import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import java.io.IOException;

public abstract class AbstractHttpMessageConverter<T> {

    /* renamed from: ad  reason: collision with root package name */
    public SMManagerDelegate f4026ad;
    public String qw = "";

    public String ad() {
        return this.qw;
    }

    public void de(SMManagerDelegate sMManagerDelegate) {
        this.f4026ad = sMManagerDelegate;
    }

    public void fe(String str) {
        this.qw = str;
    }

    public final T qw(Class<?> cls, e eVar) throws IOException {
        return rg(cls, eVar);
    }

    public abstract T rg(Class<?> cls, e eVar) throws IOException, RestRuntimeException;

    public String th(String str) {
        SMManagerDelegate sMManagerDelegate = this.f4026ad;
        return sMManagerDelegate != null ? sMManagerDelegate.responseBodyConvert(str) : str;
    }
}
