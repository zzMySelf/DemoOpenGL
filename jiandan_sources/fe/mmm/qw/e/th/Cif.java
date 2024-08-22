package fe.mmm.qw.e.th;

/* renamed from: fe.mmm.qw.e.th.if  reason: invalid class name */
public class Cif {
    public static volatile pf qw;

    public static synchronized pf qw() {
        pf pfVar;
        synchronized (Cif.class) {
            if (qw == null) {
                qw = new pf();
            }
            pfVar = qw;
        }
        return pfVar;
    }
}
