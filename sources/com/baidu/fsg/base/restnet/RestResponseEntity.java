package com.baidu.fsg.base.restnet;

import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.restnet.http.a;
import com.baidu.searchbox.favor.sync.util.FavorUtil;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RestResponseEntity<T> {
    private T mBody;
    private a mHeaders;
    private final HttpStatus mStatusCode;

    public RestResponseEntity(HttpStatus httpStatus) {
        this.mStatusCode = httpStatus;
    }

    public RestResponseEntity(a aVar, HttpStatus httpStatus) {
        this.mHeaders = aVar;
        this.mStatusCode = httpStatus;
    }

    public RestResponseEntity(T t, HttpStatus httpStatus) {
        this.mStatusCode = httpStatus;
        this.mBody = t;
    }

    public RestResponseEntity(T t, a aVar, HttpStatus httpStatus) {
        this.mHeaders = aVar;
        this.mBody = t;
        this.mStatusCode = httpStatus;
    }

    public T getBody() {
        return this.mBody;
    }

    public String getFirstHeaderValue(String str) {
        a aVar = this.mHeaders;
        return aVar != null ? aVar.c(str) : "";
    }

    public List<String> getHeaderValue(String str) {
        a aVar = this.mHeaders;
        if (aVar != null) {
            return aVar.get((Object) str);
        }
        return null;
    }

    public HttpStatus getStatusCode() {
        return this.mStatusCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(FavorUtil.FAVOR_SCOPE_LESS_THAN);
        sb.append(this.mStatusCode.toString());
        sb.append(' ');
        sb.append(this.mStatusCode.getReasonPhrase());
        sb.append(AbstractJsonLexerKt.COMMA);
        Object body = getBody();
        a aVar = this.mHeaders;
        if (body != null) {
            sb.append(body);
            if (aVar != null) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
        }
        if (aVar != null) {
            sb.append(aVar);
        }
        sb.append(Typography.greater);
        return sb.toString();
    }
}
