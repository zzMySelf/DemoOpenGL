package fe.th.de;

import androidx.browser.trusted.sharing.ShareTarget;
import fe.th.de.pf;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.uk.rg;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class ddd {

    /* renamed from: ad  reason: collision with root package name */
    public final String f5125ad;

    /* renamed from: de  reason: collision with root package name */
    public final pf f5126de;

    /* renamed from: fe  reason: collision with root package name */
    public final nn f5127fe;
    public final Cif qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Map<Class<?>, Object> f5128rg;

    /* renamed from: th  reason: collision with root package name */
    public volatile de f5129th;

    public ddd(qw qwVar) {
        this.qw = qwVar.qw;
        this.f5125ad = qwVar.f5130ad;
        this.f5126de = qwVar.f5131de.rg();
        this.f5127fe = qwVar.f5132fe;
        this.f5128rg = fe.aaa(qwVar.f5133rg);
    }

    public de ad() {
        de deVar = this.f5129th;
        if (deVar != null) {
            return deVar;
        }
        de pf2 = de.pf(this.f5126de);
        this.f5129th = pf2;
        return pf2;
    }

    public String de(String str) {
        return this.f5126de.de(str);
    }

    public pf fe() {
        return this.f5126de;
    }

    public nn qw() {
        return this.f5127fe;
    }

    public boolean rg() {
        return this.qw.m339switch();
    }

    public String th() {
        return this.f5125ad;
    }

    public String toString() {
        return "Request{method=" + this.f5125ad + ", url=" + this.qw + ", tags=" + this.f5128rg + ExtendedMessageFormat.END_FE;
    }

    public Cif uk() {
        return this.qw;
    }

    public qw yj() {
        return new qw(this);
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f5130ad;

        /* renamed from: de  reason: collision with root package name */
        public pf.qw f5131de;

        /* renamed from: fe  reason: collision with root package name */
        public nn f5132fe;
        public Cif qw;

        /* renamed from: rg  reason: collision with root package name */
        public Map<Class<?>, Object> f5133rg;

        public qw() {
            this.f5133rg = Collections.emptyMap();
            this.f5130ad = ShareTarget.METHOD_GET;
            this.f5131de = new pf.qw();
        }

        public ddd ad() {
            if (this.qw != null) {
                return new ddd(this);
            }
            throw new IllegalStateException("url == null");
        }

        public qw de(String str, String str2) {
            this.f5131de.uk(str, str2);
            return this;
        }

        public qw fe(pf pfVar) {
            this.f5131de = pfVar.th();
            return this;
        }

        public qw qw(String str, String str2) {
            this.f5131de.qw(str, str2);
            return this;
        }

        public qw rg(String str, nn nnVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (nnVar != null && !rg.ad(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (nnVar != null || !rg.rg(str)) {
                this.f5130ad = str;
                this.f5132fe = nnVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public qw th(String str) {
            this.f5131de.yj(str);
            return this;
        }

        public qw uk(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                yj(Cif.pf(str));
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public qw yj(Cif ifVar) {
            if (ifVar != null) {
                this.qw = ifVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public qw(ddd ddd) {
            Map<Class<?>, Object> map;
            this.f5133rg = Collections.emptyMap();
            this.qw = ddd.qw;
            this.f5130ad = ddd.f5125ad;
            this.f5132fe = ddd.f5127fe;
            if (ddd.f5128rg.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(ddd.f5128rg);
            }
            this.f5133rg = map;
            this.f5131de = ddd.f5126de.th();
        }
    }
}
