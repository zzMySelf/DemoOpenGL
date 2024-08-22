package fe.mmm.qw.e.th;

public class o {
    public static volatile i qw;

    public static synchronized i qw() {
        i iVar;
        synchronized (o.class) {
            if (qw == null) {
                qw = new i();
            }
            iVar = qw;
        }
        return iVar;
    }
}
