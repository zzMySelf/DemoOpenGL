package com.baidu.ar.face;

import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.face.d.a;

public class b {
    private static final String n = "b";

    /* renamed from: a  reason: collision with root package name */
    private boolean f9403a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9404b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9405c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9406d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9407e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9408f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9409g = true;

    /* renamed from: h  reason: collision with root package name */
    private int f9410h = 180;

    /* renamed from: i  reason: collision with root package name */
    private int f9411i = 320;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9412j = true;
    private boolean k = false;
    private int l = 4;
    private int m = 4;

    public int a() {
        return this.f9411i;
    }

    public a.C0155a a(a.b bVar) {
        a.C0155a aVar;
        int i2 = bVar.l;
        if (i2 == 0) {
            this.l = 1;
            aVar = bVar.f9430i;
        } else if (i2 == 1) {
            this.l = 1;
            aVar = bVar.f9431j;
        } else if (i2 != 2) {
            com.baidu.ar.p.b.b(n, "createFaceParams() device not support!!!");
            aVar = null;
        } else {
            this.l = 4;
            aVar = bVar.k;
        }
        this.m = this.l;
        return aVar;
    }

    public void a(int i2) {
        this.f9411i = i2;
    }

    public void a(String str, int i2) {
        boolean z = false;
        this.f9403a = c.d(str, false);
        this.f9404b = c.e(str, false);
        this.f9405c = c.f(str, false);
        this.f9406d = c.b(str, false);
        this.f9407e = c.a(str, false);
        if (i2 != 0) {
            z = true;
        }
        this.f9408f = c.c(str, z);
        int a2 = c.a(str, 1);
        this.m = a2;
        if (a2 > 1 && !ARAuth.checkFeatureAuth(FeatureCodes.FACE_MULTI)) {
            this.m = 1;
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    public int b() {
        return this.f9410h;
    }

    public void b(int i2) {
        this.f9410h = i2;
    }

    public void b(boolean z) {
        this.f9412j = z;
    }

    public int c() {
        return this.l;
    }

    public void c(int i2) {
        boolean z = false;
        this.f9403a = false;
        this.f9404b = false;
        this.f9405c = false;
        this.f9406d = false;
        this.f9407e = false;
        this.m = this.l;
        if (i2 != 0) {
            z = true;
        }
        this.f9408f = z;
        this.f9409g = true;
    }

    public int d() {
        return this.m;
    }

    public void d(int i2) {
        this.f9403a = this.f9403a;
        this.f9404b = this.f9404b;
        this.f9405c = this.f9405c;
        this.f9406d = this.f9406d;
        this.f9407e = this.f9407e;
        this.f9408f = this.f9408f || i2 != 0;
        this.f9409g = true;
    }

    public void e(int i2) {
        this.f9408f = i2 != 0;
    }

    public boolean e() {
        return this.k;
    }

    public boolean f() {
        return this.f9407e;
    }

    public boolean g() {
        return this.f9412j;
    }

    public boolean h() {
        return this.f9406d;
    }

    public boolean i() {
        return this.f9408f;
    }

    public boolean j() {
        return this.f9403a;
    }

    public boolean k() {
        return this.f9409g;
    }

    public boolean l() {
        return this.f9404b;
    }

    public boolean m() {
        return this.f9405c;
    }

    public void n() {
        this.f9410h = 180;
        this.f9411i = 320;
    }

    public void o() {
        this.m = 1;
    }
}
