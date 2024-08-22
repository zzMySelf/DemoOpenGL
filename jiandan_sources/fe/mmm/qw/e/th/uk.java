package fe.mmm.qw.e.th;

public class uk {
    public static volatile yj qw;

    public static synchronized yj qw() {
        yj yjVar;
        synchronized (uk.class) {
            if (qw == null) {
                qw = new yj();
            }
            yjVar = qw;
        }
        return yjVar;
    }
}
