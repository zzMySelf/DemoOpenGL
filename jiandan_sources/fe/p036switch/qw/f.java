package fe.p036switch.qw;

import java.util.Map;

/* renamed from: fe.switch.qw.f  reason: invalid package */
public class f {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<String, Object> f8805ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f8806de;
    public final String qw;

    /* renamed from: fe.switch.qw.f$ad */
    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public Map<String, Object> f8807ad;

        /* renamed from: de  reason: collision with root package name */
        public int f8808de;

        /* renamed from: fe  reason: collision with root package name */
        public String f8809fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f8810rg = true;

        public ad i(String str) {
            this.qw = str;
            return this;
        }

        public ad o(int i2) {
            this.f8808de = i2;
            return this;
        }

        public ad pf(String str) {
            this.f8809fe = str;
            return this;
        }

        public ad th(Map<String, Object> map) {
            this.f8807ad = map;
            return this;
        }

        public ad uk(boolean z) {
            this.f8810rg = z;
            return this;
        }

        public f yj() {
            return new f(this);
        }
    }

    public String ad() {
        return this.qw;
    }

    public int de() {
        return this.f8806de;
    }

    public Map<String, Object> qw() {
        return this.f8805ad;
    }

    public f(ad adVar) {
        this.qw = adVar.qw;
        this.f8805ad = adVar.f8807ad;
        this.f8806de = adVar.f8808de;
        String unused = adVar.f8809fe;
        boolean unused2 = adVar.f8810rg;
    }
}
