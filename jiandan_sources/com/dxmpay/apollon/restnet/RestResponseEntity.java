package com.dxmpay.apollon.restnet;

import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.google.common.base.Ascii;
import fe.i.qw.th.ad.qw;
import java.io.Serializable;
import java.util.List;
import kotlin.text.Typography;

public class RestResponseEntity<T> implements Serializable {
    public T mBody;
    public qw mHeaders;
    public String mResponseString;
    public final HttpStatus mStatusCode;

    public RestResponseEntity(HttpStatus httpStatus) {
        this.mStatusCode = httpStatus;
    }

    public T getBody() {
        return this.mBody;
    }

    public String getFirstHeaderValue(String str) {
        qw qwVar = this.mHeaders;
        return qwVar != null ? qwVar.yj(str) : "";
    }

    public List<String> getHeaderValue(String str) {
        qw qwVar = this.mHeaders;
        if (qwVar != null) {
            return qwVar.get(str);
        }
        return null;
    }

    public String getResponseString() {
        return this.mResponseString;
    }

    public HttpStatus getStatusCode() {
        return this.mStatusCode;
    }

    public void setBody(T t) {
        this.mBody = t;
    }

    public void setResponseString(String str) {
        this.mResponseString = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.mStatusCode.toString());
        sb.append(Ascii.CASE_MASK);
        sb.append(this.mStatusCode.getReasonPhrase());
        sb.append(',');
        Object body = getBody();
        qw qwVar = this.mHeaders;
        if (body != null) {
            sb.append(body);
            if (qwVar != null) {
                sb.append(',');
            }
        }
        if (qwVar != null) {
            sb.append(qwVar);
        }
        sb.append(Typography.greater);
        return sb.toString();
    }

    public RestResponseEntity(T t, HttpStatus httpStatus) {
        this.mStatusCode = httpStatus;
        this.mBody = t;
    }

    public RestResponseEntity(qw qwVar, HttpStatus httpStatus) {
        this.mHeaders = qwVar;
        this.mStatusCode = httpStatus;
    }

    public RestResponseEntity(T t, qw qwVar, HttpStatus httpStatus) {
        this.mHeaders = qwVar;
        this.mBody = t;
        this.mStatusCode = httpStatus;
    }
}
