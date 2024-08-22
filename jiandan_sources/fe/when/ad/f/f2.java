package fe.when.ad.f;

public class f2 extends ppp {

    /* renamed from: rg  reason: collision with root package name */
    public s1 f9448rg;

    public f2(s1 s1Var) {
        super(5, 0.5f, 0.5f, 0.5f);
        this.f9448rg = s1Var;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f2) && ((f2) obj).f9448rg.equals(this.f9448rg);
    }

    public int hashCode() {
        return this.f9448rg.hashCode();
    }

    public s1 o() {
        return this.f9448rg;
    }
}
