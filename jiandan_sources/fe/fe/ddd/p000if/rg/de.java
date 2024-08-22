package fe.fe.ddd.p000if.rg;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: fe.fe.ddd.if.rg.de  reason: invalid package */
public class de extends ad {
    public de(int i2) {
        super(i2);
        this.f1028de = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 100, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    public String th() {
        return "ElasticDredgeDisasterCell";
    }
}
