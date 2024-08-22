package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

public class vvv implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: ad  reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f4897ad;

    /* renamed from: i  reason: collision with root package name */
    public Key f4898i;

    /* renamed from: if  reason: not valid java name */
    public volatile ModelLoader.qw<?> f186if;

    /* renamed from: o  reason: collision with root package name */
    public List<ModelLoader<File, ?>> f4899o;

    /* renamed from: pf  reason: collision with root package name */
    public int f4900pf;

    /* renamed from: switch  reason: not valid java name */
    public File f187switch;

    /* renamed from: th  reason: collision with root package name */
    public final rg<?> f4901th;

    /* renamed from: uk  reason: collision with root package name */
    public int f4902uk = -1;
    public xxx when;

    /* renamed from: yj  reason: collision with root package name */
    public int f4903yj;

    public vvv(rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f4901th = rgVar;
        this.f4897ad = fetcherReadyCallback;
    }

    public final boolean ad() {
        return this.f4900pf < this.f4899o.size();
    }

    public void cancel() {
        ModelLoader.qw<?> qwVar = this.f186if;
        if (qwVar != null) {
            qwVar.f3709de.cancel();
        }
    }

    public void de(@NonNull Exception exc) {
        this.f4897ad.th(this.when, exc, this.f186if.f3709de, DataSource.RESOURCE_DISK_CACHE);
    }

    public boolean qw() {
        List<Key> de2 = this.f4901th.de();
        boolean z = false;
        if (de2.isEmpty()) {
            return false;
        }
        List<Class<?>> list = this.f4901th.m311if();
        if (list.isEmpty() && File.class.equals(this.f4901th.ggg())) {
            return false;
        }
        while (true) {
            if (this.f4899o == null || !ad()) {
                int i2 = this.f4902uk + 1;
                this.f4902uk = i2;
                if (i2 >= list.size()) {
                    int i3 = this.f4903yj + 1;
                    this.f4903yj = i3;
                    if (i3 >= de2.size()) {
                        return false;
                    }
                    this.f4902uk = 0;
                }
                Key key = de2.get(this.f4903yj);
                Class cls = list.get(this.f4902uk);
                Key key2 = key;
                this.when = new xxx(this.f4901th.ad(), key2, this.f4901th.when(), this.f4901th.xxx(), this.f4901th.th(), this.f4901th.vvv(cls), cls, this.f4901th.o());
                File ad2 = this.f4901th.fe().ad(this.when);
                this.f187switch = ad2;
                if (ad2 != null) {
                    this.f4898i = key;
                    this.f4899o = this.f4901th.i(ad2);
                    this.f4900pf = 0;
                }
            } else {
                this.f186if = null;
                while (!z && ad()) {
                    List<ModelLoader<File, ?>> list2 = this.f4899o;
                    int i4 = this.f4900pf;
                    this.f4900pf = i4 + 1;
                    this.f186if = list2.get(i4).ad(this.f187switch, this.f4901th.xxx(), this.f4901th.th(), this.f4901th.o());
                    if (this.f186if != null && this.f4901th.ddd(this.f186if.f3709de.qw())) {
                        this.f186if.f3709de.th(this.f4901th.pf(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void rg(Object obj) {
        this.f4897ad.uk(this.f4898i, obj, this.f186if.f3709de, DataSource.RESOURCE_DISK_CACHE, this.when);
    }
}
