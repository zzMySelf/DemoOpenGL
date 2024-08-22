package fe.uk.qw.pf.fe;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Encoder;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.engine.DataFetcherGenerator;
import com.dxmbumptech.glide.load.model.ModelLoader;
import fe.uk.qw.vvv.rg;
import java.util.Collections;
import java.util.List;

public class nn implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: ad  reason: collision with root package name */
    public final rg<?> f5804ad;

    /* renamed from: i  reason: collision with root package name */
    public Object f5805i;

    /* renamed from: o  reason: collision with root package name */
    public volatile ModelLoader.qw<?> f5806o;

    /* renamed from: pf  reason: collision with root package name */
    public de f5807pf;

    /* renamed from: th  reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f5808th;

    /* renamed from: uk  reason: collision with root package name */
    public ad f5809uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f5810yj;

    public class qw implements DataFetcher.DataCallback<Object> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ModelLoader.qw f5811ad;

        public qw(ModelLoader.qw qwVar) {
            this.f5811ad = qwVar;
        }

        public void de(@NonNull Exception exc) {
            if (nn.this.yj(this.f5811ad)) {
                nn.this.i(this.f5811ad, exc);
            }
        }

        public void rg(@Nullable Object obj) {
            if (nn.this.yj(this.f5811ad)) {
                nn.this.uk(this.f5811ad, obj);
            }
        }
    }

    public nn(rg<?> rgVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f5804ad = rgVar;
        this.f5808th = fetcherReadyCallback;
    }

    public void ad() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        ModelLoader.qw<?> qwVar = this.f5806o;
        if (qwVar != null) {
            qwVar.f3879de.cancel();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void de(Object obj) {
        long ad2 = rg.ad();
        try {
            Encoder<X> ggg = this.f5804ad.ggg(obj);
            fe feVar = new fe(ggg, obj, this.f5804ad.pf());
            this.f5807pf = new de(this.f5806o.qw, this.f5804ad.ppp());
            this.f5804ad.fe().qw(this.f5807pf, feVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                "Finished encoding source to cache, key: " + this.f5807pf + ", data: " + obj + ", encoder: " + ggg + ", duration: " + rg.qw(ad2);
            }
            this.f5806o.f3879de.ad();
            this.f5809uk = new ad(Collections.singletonList(this.f5806o.qw), this.f5804ad, this);
        } catch (Throwable th2) {
            this.f5806o.f3879de.ad();
            throw th2;
        }
    }

    public final boolean fe() {
        return this.f5810yj < this.f5804ad.yj().size();
    }

    public void i(ModelLoader.qw<?> qwVar, @NonNull Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f5808th;
        de deVar = this.f5807pf;
        DataFetcher<Data> dataFetcher = qwVar.f3879de;
        fetcherReadyCallback.th(deVar, exc, dataFetcher, dataFetcher.fe());
    }

    public final void o(ModelLoader.qw<?> qwVar) {
        this.f5806o.f3879de.th(this.f5804ad.m379if(), new qw(qwVar));
    }

    public boolean qw() {
        Object obj = this.f5805i;
        if (obj != null) {
            this.f5805i = null;
            de(obj);
        }
        ad adVar = this.f5809uk;
        if (adVar != null && adVar.qw()) {
            return true;
        }
        this.f5809uk = null;
        this.f5806o = null;
        boolean z = false;
        while (!z && fe()) {
            List<ModelLoader.qw<?>> yj2 = this.f5804ad.yj();
            int i2 = this.f5810yj;
            this.f5810yj = i2 + 1;
            this.f5806o = yj2.get(i2);
            if (this.f5806o != null && (this.f5804ad.rg().de(this.f5806o.f3879de.fe()) || this.f5804ad.nn(this.f5806o.f3879de.qw()))) {
                o(this.f5806o);
                z = true;
            }
        }
        return z;
    }

    public void rg(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f5808th.rg(key, obj, dataFetcher, this.f5806o.f3879de.fe(), key);
    }

    public void th(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f5808th.th(key, exc, dataFetcher, this.f5806o.f3879de.fe());
    }

    public void uk(ModelLoader.qw<?> qwVar, Object obj) {
        yj rg2 = this.f5804ad.rg();
        if (obj == null || !rg2.de(qwVar.f3879de.fe())) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f5808th;
            Key key = qwVar.qw;
            DataFetcher<Data> dataFetcher = qwVar.f3879de;
            fetcherReadyCallback.rg(key, obj, dataFetcher, dataFetcher.fe(), this.f5807pf);
            return;
        }
        this.f5805i = obj;
        this.f5808th.ad();
    }

    public boolean yj(ModelLoader.qw<?> qwVar) {
        ModelLoader.qw<?> qwVar2 = this.f5806o;
        return qwVar2 != null && qwVar2 == qwVar;
    }
}
