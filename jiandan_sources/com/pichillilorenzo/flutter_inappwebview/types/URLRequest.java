package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.Nullable;
import androidx.core.net.MailTo;
import com.alipay.sdk.m.p.e;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class URLRequest {
    @Nullable
    public byte[] body;
    @Nullable
    public Map<String, String> headers;
    @Nullable
    public String method;
    @Nullable
    public String url;

    public URLRequest(@Nullable String str, @Nullable String str2, @Nullable byte[] bArr, @Nullable Map<String, String> map) {
        this.url = str;
        this.method = str2;
        this.body = bArr;
        this.headers = map;
    }

    @Nullable
    public static URLRequest fromMap(@Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        String str = (String) map.get("url");
        if (str == null) {
            str = "about:blank";
        }
        return new URLRequest(str, (String) map.get(e.s), (byte[]) map.get(MailTo.BODY), (Map) map.get("headers"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || URLRequest.class != obj.getClass()) {
            return false;
        }
        URLRequest uRLRequest = (URLRequest) obj;
        String str = this.url;
        if (str == null ? uRLRequest.url != null : !str.equals(uRLRequest.url)) {
            return false;
        }
        String str2 = this.method;
        if (str2 == null ? uRLRequest.method != null : !str2.equals(uRLRequest.method)) {
            return false;
        }
        if (!Arrays.equals(this.body, uRLRequest.body)) {
            return false;
        }
        Map<String, String> map = this.headers;
        Map<String, String> map2 = uRLRequest.headers;
        return map != null ? map.equals(map2) : map2 == null;
    }

    @Nullable
    public byte[] getBody() {
        return this.body;
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public String getMethod() {
        return this.method;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.method;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.body)) * 31;
        Map<String, String> map = this.headers;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode2 + i2;
    }

    public void setBody(@Nullable byte[] bArr) {
        this.body = bArr;
    }

    public void setHeaders(@Nullable Map<String, String> map) {
        this.headers = map;
    }

    public void setMethod(@Nullable String str) {
        this.method = str;
    }

    public void setUrl(@Nullable String str) {
        this.url = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.url);
        hashMap.put(e.s, this.method);
        hashMap.put(MailTo.BODY, this.body);
        return hashMap;
    }

    public String toString() {
        return "URLRequest{url='" + this.url + ExtendedMessageFormat.QUOTE + ", method='" + this.method + ExtendedMessageFormat.QUOTE + ", body=" + Arrays.toString(this.body) + ", headers=" + this.headers + ExtendedMessageFormat.END_FE;
    }
}
