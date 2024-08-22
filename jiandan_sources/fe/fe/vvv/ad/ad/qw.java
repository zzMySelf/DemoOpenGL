package fe.fe.vvv.ad.ad;

import com.baidu.pyramid.runtime.service.ServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.config.AppConfig;

public abstract class qw<T> implements ServiceFetcher<T> {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f3160ad = AppConfig.rg();
    public T qw;

    public final T getService() {
        synchronized (this) {
            if (this.qw == null) {
                try {
                    this.qw = qw();
                } catch (ServiceNotFoundException e) {
                    if (f3160ad) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
        }
        return this.qw;
    }

    public abstract T qw() throws ServiceNotFoundException;
}
