package com.baidu.apollon.restnet.http;

import com.baidu.apollon.NoProguard;
import fe.th.de.Cswitch;
import fe.th.de.ggg;
import fe.th.de.vvv;
import java.net.URLStreamHandler;

public class OkHttpFactory implements NoProguard {
    public final vvv a;
    public URLStreamHandler b;

    public static class a {
        public static final OkHttpFactory a = new OkHttpFactory();
    }

    public static OkHttpFactory getInstance() {
        return a.a;
    }

    public ggg client() {
        return this.a.ad();
    }

    public URLStreamHandler getURLStreamHandler(String str) {
        if (!"http".equals(str) && !"https".equals(str)) {
            return null;
        }
        if (this.b == null) {
            this.b = this.a.createURLStreamHandler(str);
        }
        return this.b;
    }

    public void setClient(ggg ggg) {
        if (ggg != null) {
            this.a.th(ggg);
        }
    }

    public OkHttpFactory() {
        ggg.ad nn = new ggg().nn();
        nn.th(new Cswitch(d.a()));
        nn.o(b.e);
        this.a = new vvv(nn.ad());
    }
}
