package com.a.a.b;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final f f1523a = new a();

    /* renamed from: b  reason: collision with root package name */
    private float f1524b;

    private static class a extends f {
        private a() {
        }
    }

    public f() {
        a();
    }

    public static f c() {
        return f1523a;
    }

    public void a() {
        this.f1524b = Float.MAX_VALUE;
    }

    public boolean a(f fVar) {
        return this.f1524b <= fVar.f1524b;
    }

    public boolean b() {
        return this.f1524b == Float.MAX_VALUE;
    }
}
