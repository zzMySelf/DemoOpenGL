package com.baidu.apollon.restnet;

import java.net.URI;

public class b {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    /* renamed from: i  reason: collision with root package name */
    public final int f702i;
    public String j;
    public String k;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public long d;
        public boolean e;
        public int f;
        public boolean g;
        public String h;

        /* renamed from: i  reason: collision with root package name */
        public String f703i;
        public boolean j;
        public boolean k;
        public int l = -1;

        public a a(URI uri) {
            if (uri != null) {
                this.a = uri.getHost();
                this.b = uri.getPath();
                this.c = uri.getScheme();
            }
            return this;
        }

        public a b(boolean z) {
            this.j = z;
            return this;
        }

        public a c(boolean z) {
            this.g = z;
            return this;
        }

        public a d(boolean z) {
            this.k = z;
            return this;
        }

        public a b(String str) {
            this.f703i = str;
            return this;
        }

        public a a(long j2) {
            this.d = j2;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public a a(String str) {
            this.h = str;
            return this;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.g;
        this.j = aVar.h;
        this.k = aVar.f703i;
        this.g = aVar.j;
        this.h = aVar.k;
        this.f702i = aVar.l;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.k;
    }

    public boolean j() {
        return this.h;
    }

    public int k() {
        return this.f702i;
    }
}
