package com.baidu.apollon.restnet.converter;

import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.rest.e;
import java.io.IOException;

public abstract class AbstractHttpMessageConverter<T> {
    public String a = "";

    public String a() {
        return this.a;
    }

    public abstract T b(Class<?> cls, e eVar) throws IOException, RestRuntimeException;

    public void a(String str) {
        this.a = str;
    }

    public final T a(Class<?> cls, e eVar) throws IOException {
        return b(cls, eVar);
    }
}
