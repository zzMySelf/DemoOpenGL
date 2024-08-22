package fe.mmm.qw.e.th;

public class th {
    public static volatile rg qw;

    public static synchronized rg qw() {
        rg rgVar;
        synchronized (th.class) {
            if (qw == null) {
                qw = new rg();
            }
            rgVar = qw;
        }
        return rgVar;
    }
}
