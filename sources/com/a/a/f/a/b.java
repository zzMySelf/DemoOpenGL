package com.a.a.f.a;

import com.a.a.a.d;
import com.a.a.b.a;
import com.baidu.vr.a;

public class b extends com.a.a.f.b<a> implements d {

    /* renamed from: a  reason: collision with root package name */
    public static int[] f1666a = {101, 102};

    /* renamed from: b  reason: collision with root package name */
    private boolean f1667b;

    /* renamed from: c  reason: collision with root package name */
    private a f1668c;

    /* renamed from: d  reason: collision with root package name */
    private a.C0062a f1669d;

    public b(int i2, d dVar) {
        super(i2, dVar);
    }

    public void a(float f2, float f3, float f4) {
        a.C0062a aVar = this.f1669d;
        if (aVar != null) {
            aVar.a(f2, f3, f4);
        }
    }

    public void a(com.a.a.b.a aVar) {
        this.f1668c = aVar;
    }

    public void a(a.C0062a aVar) {
        this.f1669d = aVar;
    }

    public void a(boolean z) {
        this.f1667b = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public a a(int i2) {
        switch (i2) {
            case 102:
                return new c();
            default:
                return new e();
        }
    }

    public int d() {
        return ((a) b_()).d();
    }

    public boolean e() {
        return this.f1667b;
    }

    public com.a.a.b.a f() {
        return this.f1668c;
    }
}
