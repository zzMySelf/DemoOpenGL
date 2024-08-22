package fe.fe.ddd.p000if.rg;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: fe.fe.ddd.if.rg.fe  reason: invalid package */
public class fe extends ad {
    public fe(int i2) {
        super(i2);
        this.f1027ad = i2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f1028de = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public String th() {
        return "ElasticDredgeNormalCell";
    }
}
