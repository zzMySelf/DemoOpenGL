package com.baidu.apollon.restnet.rest;

import android.util.Log;
import com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.baidu.apollon.restnet.http.HttpStatus;

public class f<T> {
    public static final String a = "f";
    public final Class<T> b;
    public final AbstractHttpMessageConverter<?> c;

    public f(Class<T> cls, AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        if (cls == null) {
            throw new IllegalArgumentException("'responseType' must not be null");
        } else if (abstractHttpMessageConverter != null) {
            this.b = cls;
            this.c = abstractHttpMessageConverter;
        } else {
            throw new IllegalArgumentException("'messageConverters' must not be empty");
        }
    }

    private boolean b(e eVar) throws Exception {
        HttpStatus e = eVar.e();
        if (e == HttpStatus.NO_CONTENT || e == HttpStatus.NOT_MODIFIED || eVar.d().h() == 0) {
            return false;
        }
        return true;
    }

    public T a(e eVar) throws Exception {
        if (!b(eVar)) {
            return null;
        }
        if (eVar.d().i() == null) {
            boolean isLoggable = Log.isLoggable(a, 3);
        }
        return this.c.a(this.b, eVar);
    }

    public String a() {
        return this.c.a();
    }
}
