package fe.fe.vvv.qw.qw;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.pyramid.annotation.component.ListHolder;
import java.util.List;

public class ad<T> implements ListHolder<T> {

    /* renamed from: ad  reason: collision with root package name */
    public Provider<List<T>> f3169ad;

    /* renamed from: de  reason: collision with root package name */
    public Provider<List<T>> f3170de;
    public List<T> qw;

    public static ad de() {
        return new ad();
    }

    public void ad(Provider<List<T>> provider) {
        this.f3169ad = provider;
        this.qw = null;
    }

    public List<T> qw() {
        List<T> list = this.qw;
        if (list != null) {
            return list;
        }
        Provider<List<T>> provider = this.f3169ad;
        if (provider != null) {
            List<T> list2 = provider.get();
            this.qw = list2;
            return list2;
        }
        Provider<List<T>> provider2 = this.f3170de;
        if (provider2 != null) {
            return provider2.get();
        }
        return null;
    }
}
