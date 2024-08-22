package fe.qw.qw.vvv;

import com.dlife.ctaccountapi.x;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public float f3524ad;
    public float qw;

    public fe(float f, float f2) {
        this.qw = f;
        this.f3524ad = f2;
    }

    public float ad() {
        return this.qw;
    }

    public float de() {
        return this.f3524ad;
    }

    public void fe(float f, float f2) {
        this.qw = f;
        this.f3524ad = f2;
    }

    public boolean qw(float f, float f2) {
        return this.qw == f && this.f3524ad == f2;
    }

    public String toString() {
        return ad() + x.a + de();
    }

    public fe() {
        this(1.0f, 1.0f);
    }
}
