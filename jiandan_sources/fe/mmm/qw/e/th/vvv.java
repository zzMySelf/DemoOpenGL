package fe.mmm.qw.e.th;

public class vvv {
    public static volatile ggg qw;

    public static synchronized ggg qw() {
        ggg ggg;
        synchronized (vvv.class) {
            if (qw == null) {
                qw = new ggg();
            }
            ggg = qw;
        }
        return ggg;
    }
}
