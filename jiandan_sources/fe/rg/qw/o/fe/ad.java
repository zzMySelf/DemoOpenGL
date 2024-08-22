package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

public class ad implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: ad  reason: collision with root package name */
    public final List<Key> f4774ad;

    /* renamed from: i  reason: collision with root package name */
    public Key f4775i;

    /* renamed from: if  reason: not valid java name */
    public volatile ModelLoader.qw<?> f180if;

    /* renamed from: o  reason: collision with root package name */
    public List<ModelLoader<File, ?>> f4776o;

    /* renamed from: pf  reason: collision with root package name */
    public int f4777pf;

    /* renamed from: switch  reason: not valid java name */
    public File f181switch;

    /* renamed from: th  reason: collision with root package name */
    public final rg<?> f4778th;

    /* renamed from: uk  reason: collision with root package name */
    public int f4779uk;

    /* renamed from: yj  reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f4780yj;

    public ad(rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(rgVar.de(), rgVar, fetcherReadyCallback);
    }

    public final boolean ad() {
        return this.f4777pf < this.f4776o.size();
    }

    public void cancel() {
        ModelLoader.qw<?> qwVar = this.f180if;
        if (qwVar != null) {
            qwVar.f3709de.cancel();
        }
    }

    public void de(@NonNull Exception exc) {
        this.f4780yj.th(this.f4775i, exc, this.f180if.f3709de, DataSource.DATA_DISK_CACHE);
    }

    public boolean qw() {
        while (true) {
            boolean z = false;
            if (this.f4776o == null || !ad()) {
                int i2 = this.f4779uk + 1;
                this.f4779uk = i2;
                if (i2 >= this.f4774ad.size()) {
                    return false;
                }
                Key key = this.f4774ad.get(this.f4779uk);
                File ad2 = this.f4778th.fe().ad(new de(key, this.f4778th.when()));
                this.f181switch = ad2;
                if (ad2 != null) {
                    this.f4775i = key;
                    this.f4776o = this.f4778th.i(ad2);
                    this.f4777pf = 0;
                }
            } else {
                this.f180if = null;
                while (!z && ad()) {
                    List<ModelLoader<File, ?>> list = this.f4776o;
                    int i3 = this.f4777pf;
                    this.f4777pf = i3 + 1;
                    this.f180if = list.get(i3).ad(this.f181switch, this.f4778th.xxx(), this.f4778th.th(), this.f4778th.o());
                    if (this.f180if != null && this.f4778th.ddd(this.f180if.f3709de.qw())) {
                        this.f180if.f3709de.th(this.f4778th.pf(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void rg(Object obj) {
        this.f4780yj.uk(this.f4775i, obj, this.f180if.f3709de, DataSource.DATA_DISK_CACHE, this.f4775i);
    }

    public ad(List<Key> list, rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f4779uk = -1;
        this.f4774ad = list;
        this.f4778th = rgVar;
        this.f4780yj = fetcherReadyCallback;
    }
}
