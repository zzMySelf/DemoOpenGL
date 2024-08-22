package fe.fe.vvv.qw.qw;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.pyramid.annotation.component.Holder;

public class qw<T> implements Holder<T> {

    /* renamed from: ad  reason: collision with root package name */
    public Provider<T> f3171ad;

    /* renamed from: de  reason: collision with root package name */
    public Provider<T> f3172de;
    public T qw;

    public static qw ad() {
        return new qw();
    }

    public T get() {
        T t = this.qw;
        if (t != null) {
            return t;
        }
        Provider<T> provider = this.f3171ad;
        if (provider != null) {
            T t2 = provider.get();
            this.qw = t2;
            return t2;
        }
        Provider<T> provider2 = this.f3172de;
        if (provider2 != null) {
            return provider2.get();
        }
        return null;
    }

    public void qw(Provider<T> provider) {
        this.f3171ad = provider;
        this.qw = null;
    }
}
