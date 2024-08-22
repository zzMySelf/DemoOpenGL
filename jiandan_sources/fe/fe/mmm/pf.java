package fe.fe.mmm;

public class pf {
    public static volatile o qw;

    public static synchronized o qw() {
        o oVar;
        synchronized (pf.class) {
            if (qw == null) {
                qw = new o();
            }
            oVar = qw;
        }
        return oVar;
    }
}
