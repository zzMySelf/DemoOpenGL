package fe.fe.ddd.de.ad;

public class fe {
    public static volatile de qw;

    public static synchronized de qw() {
        de deVar;
        synchronized (fe.class) {
            if (qw == null) {
                qw = new de();
            }
            deVar = qw;
        }
        return deVar;
    }
}
