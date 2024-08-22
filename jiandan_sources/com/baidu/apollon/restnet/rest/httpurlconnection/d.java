package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.http.a;
import com.baidu.apollon.restnet.rest.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class d implements e {
    public InputStream a;
    public int b;
    public String c;
    public Map<String, List<String>> d;
    public a e;
    public InputStream f;

    public d(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
        this.a = inputStream;
        this.b = i2;
        this.c = str;
        this.d = map;
    }

    private boolean g() {
        String g = d().g();
        return !TextUtils.isEmpty(g) && g.contains("gzip");
    }

    public int a() throws IOException {
        return this.b;
    }

    public String b() throws IOException {
        return this.c;
    }

    public InputStream c() throws IOException {
        if (g()) {
            return a(this.a);
        }
        return this.a;
    }

    public a d() {
        if (this.e == null) {
            this.e = new a(this.d, false);
        }
        return this.e;
    }

    public HttpStatus e() throws Exception {
        return HttpStatus.valueOf(a());
    }

    public void f() {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        InputStream inputStream2 = this.a;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private InputStream a(InputStream inputStream) throws IOException {
        if (this.f == null) {
            this.f = new GZIPInputStream(inputStream);
        }
        return this.f;
    }
}
