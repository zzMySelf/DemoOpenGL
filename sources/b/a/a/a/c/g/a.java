package b.a.a.a.c.g;

/* compiled from: OperateElementInfo */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1299a;

    /* renamed from: b  reason: collision with root package name */
    private String f1300b;

    /* renamed from: c  reason: collision with root package name */
    private String f1301c;

    private a() {
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f1299a == null) {
                f1299a = new a();
            }
            aVar = f1299a;
        }
        return aVar;
    }

    public String a() {
        return this.f1301c;
    }

    public String c() {
        return this.f1300b;
    }
}
