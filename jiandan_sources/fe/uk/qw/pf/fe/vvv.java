package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.engine.DataFetcherGenerator;
import com.dxmbumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

public class vvv implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: ad  reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f5873ad;

    /* renamed from: i  reason: collision with root package name */
    public Key f5874i;

    /* renamed from: if  reason: not valid java name */
    public volatile ModelLoader.qw<?> f240if;

    /* renamed from: o  reason: collision with root package name */
    public List<ModelLoader<File, ?>> f5875o;

    /* renamed from: pf  reason: collision with root package name */
    public int f5876pf;

    /* renamed from: switch  reason: not valid java name */
    public File f241switch;

    /* renamed from: th  reason: collision with root package name */
    public final rg<?> f5877th;

    /* renamed from: uk  reason: collision with root package name */
    public int f5878uk = -1;
    public xxx when;

    /* renamed from: yj  reason: collision with root package name */
    public int f5879yj;

    public vvv(rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f5877th = rgVar;
        this.f5873ad = fetcherReadyCallback;
    }

    public final boolean ad() {
        return this.f5876pf < this.f5875o.size();
    }

    public void cancel() {
        ModelLoader.qw<?> qwVar = this.f240if;
        if (qwVar != null) {
            qwVar.f3879de.cancel();
        }
    }

    public void de(@NonNull Exception exc) {
        this.f5873ad.th(this.when, exc, this.f240if.f3879de, DataSource.RESOURCE_DISK_CACHE);
    }

    public boolean qw() {
        List<Key> de2 = this.f5877th.de();
        boolean z = false;
        if (de2.isEmpty()) {
            return false;
        }
        List<Class<?>> list = this.f5877th.m380switch();
        if (!list.isEmpty()) {
            while (true) {
                if (this.f5875o == null || !ad()) {
                    int i2 = this.f5878uk + 1;
                    this.f5878uk = i2;
                    if (i2 >= list.size()) {
                        int i3 = this.f5879yj + 1;
                        this.f5879yj = i3;
                        if (i3 >= de2.size()) {
                            return false;
                        }
                        this.f5878uk = 0;
                    }
                    Key key = de2.get(this.f5879yj);
                    Class cls = list.get(this.f5878uk);
                    Key key2 = key;
                    this.when = new xxx(this.f5877th.ad(), key2, this.f5877th.ppp(), this.f5877th.ddd(), this.f5877th.th(), this.f5877th.xxx(cls), cls, this.f5877th.pf());
                    File ad2 = this.f5877th.fe().ad(this.when);
                    this.f241switch = ad2;
                    if (ad2 != null) {
                        this.f5874i = key;
                        this.f5875o = this.f5877th.o(ad2);
                        this.f5876pf = 0;
                    }
                } else {
                    this.f240if = null;
                    while (!z && ad()) {
                        List<ModelLoader<File, ?>> list2 = this.f5875o;
                        int i4 = this.f5876pf;
                        this.f5876pf = i4 + 1;
                        this.f240if = list2.get(i4).ad(this.f241switch, this.f5877th.ddd(), this.f5877th.th(), this.f5877th.pf());
                        if (this.f240if != null && this.f5877th.nn(this.f240if.f3879de.qw())) {
                            this.f240if.f3879de.th(this.f5877th.m379if(), this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.f5877th.vvv())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.f5877th.i() + " to " + this.f5877th.vvv());
        }
    }

    public void rg(Object obj) {
        this.f5873ad.rg(this.f5874i, obj, this.f240if.f3879de, DataSource.RESOURCE_DISK_CACHE, this.when);
    }
}
