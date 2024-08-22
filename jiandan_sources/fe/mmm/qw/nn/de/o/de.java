package fe.mmm.qw.nn.de.o;

import fe.mmm.qw.nn.ad.qw.qw;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public String f8101ad;

    /* renamed from: de  reason: collision with root package name */
    public ad f8102de;

    /* renamed from: fe  reason: collision with root package name */
    public String f8103fe;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8104i = false;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f8105rg;

    /* renamed from: th  reason: collision with root package name */
    public String f8106th;

    /* renamed from: uk  reason: collision with root package name */
    public String f8107uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f8108yj = false;

    public de(String str) {
        this.f8101ad = str;
        this.f8107uk = qw.qw.rg();
    }

    public String ad() {
        return this.f8106th;
    }

    public String de() {
        return this.f8103fe;
    }

    public String fe() {
        return this.qw;
    }

    public void ggg(ad adVar) {
        this.f8102de = adVar;
    }

    public String i() {
        return this.f8101ad;
    }

    /* renamed from: if  reason: not valid java name */
    public void m989if(boolean z) {
        this.f8108yj = z;
    }

    public boolean o() {
        return this.f8104i;
    }

    public boolean pf() {
        return "POST".equals(this.qw);
    }

    public void ppp(String str) {
        this.qw = str;
    }

    public boolean qw() {
        return this.f8108yj;
    }

    public ad rg() {
        return this.f8102de;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m990switch(String str, String str2) {
        this.f8106th = str;
        this.f8105rg = str2;
    }

    public String th() {
        ad adVar = this.f8102de;
        if (adVar == null) {
            return "";
        }
        return adVar.toString();
    }

    public String toString() {
        return "HttpRequest{mHttpMethod='" + this.qw + "', mUrl='" + this.f8101ad + "', mParams='" + this.f8102de + "', mCookie='" + this.f8103fe + "', mUid='" + this.f8105rg + "', mBduss='" + this.f8106th + "'}";
    }

    public String uk() {
        return this.f8105rg;
    }

    public void vvv(String str) {
        this.f8101ad = str;
    }

    public void when(String str) {
        this.f8103fe = str;
    }

    public String yj() {
        return this.f8107uk;
    }
}
