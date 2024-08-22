package fe.ad.qw.qw.de;

import java.util.concurrent.CountDownLatch;

public class qw extends CountDownLatch {
    public qw(int i2) {
        super(i2);
    }

    public void qw() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
