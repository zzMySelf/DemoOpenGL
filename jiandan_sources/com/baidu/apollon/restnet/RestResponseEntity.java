package com.baidu.apollon.restnet;

import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.http.a;
import com.google.common.base.Ascii;
import java.util.List;
import kotlin.text.Typography;

public class RestResponseEntity<T> {
    public final HttpStatus a;
    public a b;
    public T c;
    public String d;

    public RestResponseEntity(HttpStatus httpStatus) {
        this.a = httpStatus;
    }

    public HttpStatus a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public T getBody() {
        return this.c;
    }

    public List<String> getHeaderValue(String str) {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.get((Object) str);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.a.toString());
        sb.append(Ascii.CASE_MASK);
        sb.append(this.a.getReasonPhrase());
        sb.append(',');
        Object body = getBody();
        a aVar = this.b;
        if (body != null) {
            sb.append(body);
            if (aVar != null) {
                sb.append(',');
            }
        }
        if (aVar != null) {
            sb.append(aVar);
        }
        sb.append(Typography.greater);
        return sb.toString();
    }

    public String a(String str) {
        a aVar = this.b;
        return aVar != null ? aVar.c(str) : "";
    }

    public void b(String str) {
        this.d = str;
    }

    public RestResponseEntity(T t, HttpStatus httpStatus) {
        this.a = httpStatus;
        this.c = t;
    }

    public RestResponseEntity(a aVar, HttpStatus httpStatus) {
        this.b = aVar;
        this.a = httpStatus;
    }

    public RestResponseEntity(T t, a aVar, HttpStatus httpStatus) {
        this.b = aVar;
        this.c = t;
        this.a = httpStatus;
    }
}
