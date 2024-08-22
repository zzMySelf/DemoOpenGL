package com.baidu.ar.track2d.f;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private int f10517a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f10518b = -1;

    public void a() {
        this.f10517a = -1;
        this.f10518b = -1;
    }

    public boolean a(boolean z) {
        int i2 = this.f10518b;
        if (i2 != -1) {
            this.f10517a = i2;
            this.f10518b = z ^ true ? 1 : 0;
        } else if (z) {
            this.f10517a = i2;
            this.f10518b = 0;
        }
        return this.f10518b != -1;
    }

    public boolean b() {
        int i2 = this.f10517a;
        return (i2 == 1 || i2 == -1) && this.f10518b == 0;
    }

    public boolean c() {
        return this.f10517a == 0 && this.f10518b == 1;
    }
}
