package com.cmic.sso.sdk.a;

import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class a implements Cloneable {
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3773i;
    public boolean j;
    public int k;
    public int l;

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    public static class C0177a {
        public final a a = new a();

        public C0177a a(String str) {
            String unused = this.a.a = str;
            return this;
        }

        public C0177a b(String str) {
            String unused = this.a.b = str;
            return this;
        }

        public C0177a c(String str) {
            String unused = this.a.c = str;
            return this;
        }

        public C0177a d(String str) {
            String unused = this.a.d = str;
            return this;
        }

        public C0177a e(boolean z) {
            boolean unused = this.a.f3773i = z;
            return this;
        }

        public C0177a f(boolean z) {
            boolean unused = this.a.j = z;
            return this;
        }

        public C0177a a(boolean z) {
            boolean unused = this.a.e = z;
            return this;
        }

        public C0177a b(boolean z) {
            boolean unused = this.a.f = z;
            return this;
        }

        public C0177a c(boolean z) {
            boolean unused = this.a.g = z;
            return this;
        }

        public C0177a d(boolean z) {
            boolean unused = this.a.h = z;
            return this;
        }

        public C0177a a(int i2) {
            int unused = this.a.k = i2;
            return this;
        }

        public C0177a b(int i2) {
            int unused = this.a.l = i2;
            return this;
        }

        public a a() {
            return this.a;
        }
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.f3773i;
    }

    public boolean j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    /* renamed from: m */
    public a clone() {
        return (a) super.clone();
    }

    public String toString() {
        return "UmcConfigBean{mHttpsGetTokenHost='" + this.a + ExtendedMessageFormat.QUOTE + ", mHttpsGetPhoneScripHost='" + this.b + ExtendedMessageFormat.QUOTE + ", mConfigHost='" + this.c + ExtendedMessageFormat.QUOTE + ", mLogHost='" + this.d + ExtendedMessageFormat.QUOTE + ", mCloseCtccWork=" + this.e + ", mCloseCuccWort=" + this.f + ", mCloseM008Business=" + this.g + ", mCloseGetPhoneIpv4=" + this.h + ", mCloseGetPhoneIpv6=" + this.f3773i + ", mCloseLog=" + this.j + ", mMaxFailedLogTimes=" + this.k + ", mLogSuspendTime=" + this.l + ExtendedMessageFormat.END_FE;
    }

    public a() {
        this.a = "rcs.cmpassport.com";
        this.b = "rcs.cmpassport.com";
        this.c = "config2.cmpassport.com";
        this.d = "log2.cmpassport.com:9443";
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.f3773i = false;
        this.j = false;
        this.k = 3;
        this.l = 1;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
