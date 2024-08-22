package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.engine.DataFetcherGenerator;
import com.dxmbumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

public class ad implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: ad  reason: collision with root package name */
    public final List<Key> f5741ad;

    /* renamed from: i  reason: collision with root package name */
    public Key f5742i;

    /* renamed from: if  reason: not valid java name */
    public volatile ModelLoader.qw<?> f234if;

    /* renamed from: o  reason: collision with root package name */
    public List<ModelLoader<File, ?>> f5743o;

    /* renamed from: pf  reason: collision with root package name */
    public int f5744pf;

    /* renamed from: switch  reason: not valid java name */
    public File f235switch;

    /* renamed from: th  reason: collision with root package name */
    public final rg<?> f5745th;

    /* renamed from: uk  reason: collision with root package name */
    public int f5746uk;

    /* renamed from: yj  reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f5747yj;

    public ad(rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(rgVar.de(), rgVar, fetcherReadyCallback);
    }

    public final boolean ad() {
        return this.f5744pf < this.f5743o.size();
    }

    public void cancel() {
        ModelLoader.qw<?> qwVar = this.f234if;
        if (qwVar != null) {
            qwVar.f3879de.cancel();
        }
    }

    public void de(@NonNull Exception exc) {
        this.f5747yj.th(this.f5742i, exc, this.f234if.f3879de, DataSource.DATA_DISK_CACHE);
    }

    public boolean qw() {
        while (true) {
            boolean z = false;
            if (this.f5743o == null || !ad()) {
                int i2 = this.f5746uk + 1;
                this.f5746uk = i2;
                if (i2 >= this.f5741ad.size()) {
                    return false;
                }
                Key key = this.f5741ad.get(this.f5746uk);
                File ad2 = this.f5745th.fe().ad(new de(key, this.f5745th.ppp()));
                this.f235switch = ad2;
                if (ad2 != null) {
                    this.f5742i = key;
                    this.f5743o = this.f5745th.o(ad2);
                    this.f5744pf = 0;
                }
            } else {
                this.f234if = null;
                while (!z && ad()) {
                    List<ModelLoader<File, ?>> list = this.f5743o;
                    int i3 = this.f5744pf;
                    this.f5744pf = i3 + 1;
                    this.f234if = list.get(i3).ad(this.f235switch, this.f5745th.ddd(), this.f5745th.th(), this.f5745th.pf());
                    if (this.f234if != null && this.f5745th.nn(this.f234if.f3879de.qw())) {
                        this.f234if.f3879de.th(this.f5745th.m379if(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void rg(Object obj) {
        this.f5747yj.rg(this.f5742i, obj, this.f234if.f3879de, DataSource.DATA_DISK_CACHE, this.f5742i);
    }

    public ad(List<Key> list, rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f5746uk = -1;
        this.f5741ad = list;
        this.f5745th = rgVar;
        this.f5747yj = fetcherReadyCallback;
    }
}
