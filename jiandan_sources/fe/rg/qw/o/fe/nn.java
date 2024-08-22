package fe.rg.qw.o.fe;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import fe.rg.qw.ggg.fe;
import java.util.Collections;
import java.util.List;

public class nn implements DataFetcherGenerator, DataFetcher.DataCallback<Object>, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: ad  reason: collision with root package name */
    public final rg<?> f4831ad;

    /* renamed from: i  reason: collision with root package name */
    public Object f4832i;

    /* renamed from: o  reason: collision with root package name */
    public volatile ModelLoader.qw<?> f4833o;

    /* renamed from: pf  reason: collision with root package name */
    public de f4834pf;

    /* renamed from: th  reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f4835th;

    /* renamed from: uk  reason: collision with root package name */
    public ad f4836uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f4837yj;

    public nn(rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f4831ad = rgVar;
        this.f4835th = fetcherReadyCallback;
    }

    public void ad() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        ModelLoader.qw<?> qwVar = this.f4833o;
        if (qwVar != null) {
            qwVar.f3709de.cancel();
        }
    }

    public void de(@NonNull Exception exc) {
        this.f4835th.th(this.f4834pf, exc, this.f4833o.f3709de, this.f4833o.f3709de.fe());
    }

    /* JADX INFO: finally extract failed */
    public final void fe(Object obj) {
        long ad2 = fe.ad();
        try {
            Encoder<X> ppp = this.f4831ad.ppp(obj);
            fe feVar = new fe(ppp, obj, this.f4831ad.o());
            this.f4834pf = new de(this.f4833o.qw, this.f4831ad.when());
            this.f4831ad.fe().qw(this.f4834pf, feVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                "Finished encoding source to cache, key: " + this.f4834pf + ", data: " + obj + ", encoder: " + ppp + ", duration: " + fe.qw(ad2);
            }
            this.f4833o.f3709de.ad();
            this.f4836uk = new ad(Collections.singletonList(this.f4833o.qw), this.f4831ad, this);
        } catch (Throwable th2) {
            this.f4833o.f3709de.ad();
            throw th2;
        }
    }

    public boolean qw() {
        Object obj = this.f4832i;
        if (obj != null) {
            this.f4832i = null;
            fe(obj);
        }
        ad adVar = this.f4836uk;
        if (adVar != null && adVar.qw()) {
            return true;
        }
        this.f4836uk = null;
        this.f4833o = null;
        boolean z = false;
        while (!z && yj()) {
            List<ModelLoader.qw<?>> yj2 = this.f4831ad.yj();
            int i2 = this.f4837yj;
            this.f4837yj = i2 + 1;
            this.f4833o = yj2.get(i2);
            if (this.f4833o != null && (this.f4831ad.rg().de(this.f4833o.f3709de.fe()) || this.f4831ad.ddd(this.f4833o.f3709de.qw()))) {
                this.f4833o.f3709de.th(this.f4831ad.pf(), this);
                z = true;
            }
        }
        return z;
    }

    public void rg(Object obj) {
        yj rg2 = this.f4831ad.rg();
        if (obj == null || !rg2.de(this.f4833o.f3709de.fe())) {
            this.f4835th.uk(this.f4833o.qw, obj, this.f4833o.f3709de, this.f4833o.f3709de.fe(), this.f4834pf);
            return;
        }
        this.f4832i = obj;
        this.f4835th.ad();
    }

    public void th(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f4835th.th(key, exc, dataFetcher, this.f4833o.f3709de.fe());
    }

    public void uk(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f4835th.uk(key, obj, dataFetcher, this.f4833o.f3709de.fe(), key);
    }

    public final boolean yj() {
        return this.f4837yj < this.f4831ad.yj().size();
    }
}
