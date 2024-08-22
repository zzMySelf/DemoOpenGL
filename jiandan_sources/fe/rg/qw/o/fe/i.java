package fe.rg.qw.o.fe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.List;

public class i<R> implements DecodeJob.ad<R>, FactoryPools.Poolable {
    public static final qw f = new qw();
    public static final Handler g = new Handler(Looper.getMainLooper(), new ad());
    public GlideException aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final List<ResourceCallback> f4791ad;
    public Resource<?> ddd;
    public volatile boolean e;
    public List<ResourceCallback> eee;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public final o f4792i;

    /* renamed from: if  reason: not valid java name */
    public final GlideExecutor f182if;
    public boolean mmm;
    public DataSource nn;

    /* renamed from: o  reason: collision with root package name */
    public final GlideExecutor f4793o;

    /* renamed from: pf  reason: collision with root package name */
    public final GlideExecutor f4794pf;
    public boolean ppp;
    public boolean qqq;
    public Cswitch<?> rrr;

    /* renamed from: switch  reason: not valid java name */
    public final GlideExecutor f183switch;

    /* renamed from: th  reason: collision with root package name */
    public final fe.rg.qw.ggg.o.ad f4795th;
    public DecodeJob<R> tt;

    /* renamed from: uk  reason: collision with root package name */
    public final qw f4796uk;
    public boolean vvv;
    public Key when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final Pools.Pool<i<?>> f4797yj;

    public static class ad implements Handler.Callback {
        public boolean handleMessage(Message message) {
            i iVar = (i) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                iVar.pf();
            } else if (i2 == 2) {
                iVar.o();
            } else if (i2 == 3) {
                iVar.i();
            } else {
                throw new IllegalStateException("Unrecognized message: " + message.what);
            }
            return true;
        }
    }

    @VisibleForTesting
    public static class qw {
        public <R> Cswitch<R> qw(Resource<R> resource, boolean z) {
            return new Cswitch<>(resource, z, true);
        }
    }

    public i(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, o oVar, Pools.Pool<i<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, oVar, pool, f);
    }

    public void ad(ResourceCallback resourceCallback) {
        fe.rg.qw.ggg.i.qw();
        this.f4795th.de();
        if (this.mmm) {
            resourceCallback.rg(this.rrr, this.nn);
        } else if (this.qqq) {
            resourceCallback.qw(this.aaa);
        } else {
            this.f4791ad.add(resourceCallback);
        }
    }

    public final void de(ResourceCallback resourceCallback) {
        if (this.eee == null) {
            this.eee = new ArrayList(2);
        }
        if (!this.eee.contains(resourceCallback)) {
            this.eee.add(resourceCallback);
        }
    }

    @NonNull
    public fe.rg.qw.ggg.o.ad fe() {
        return this.f4795th;
    }

    public void ggg(ResourceCallback resourceCallback) {
        fe.rg.qw.ggg.i.qw();
        this.f4795th.de();
        if (this.mmm || this.qqq) {
            de(resourceCallback);
            return;
        }
        this.f4791ad.remove(resourceCallback);
        if (this.f4791ad.isEmpty()) {
            yj();
        }
    }

    public void i() {
        this.f4795th.de();
        if (this.e) {
            this.f4792i.de(this, this.when);
            ppp(false);
            return;
        }
        throw new IllegalStateException("Not cancelled");
    }

    @VisibleForTesting
    /* renamed from: if  reason: not valid java name */
    public i<R> m305if(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.when = key;
        this.ppp = z;
        this.ggg = z2;
        this.vvv = z3;
        this.xxx = z4;
        return this;
    }

    public void o() {
        this.f4795th.de();
        if (this.e) {
            ppp(false);
        } else if (this.f4791ad.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (!this.qqq) {
            this.qqq = true;
            this.f4792i.ad(this, this.when, (Cswitch<?>) null);
            for (ResourceCallback next : this.f4791ad) {
                if (!m306switch(next)) {
                    next.qw(this.aaa);
                }
            }
            ppp(false);
        } else {
            throw new IllegalStateException("Already failed once");
        }
    }

    public void pf() {
        this.f4795th.de();
        if (this.e) {
            this.ddd.recycle();
            ppp(false);
        } else if (this.f4791ad.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else if (!this.mmm) {
            Cswitch<?> qw2 = this.f4796uk.qw(this.ddd, this.ppp);
            this.rrr = qw2;
            this.mmm = true;
            qw2.de();
            this.f4792i.ad(this, this.when, this.rrr);
            int size = this.f4791ad.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResourceCallback resourceCallback = this.f4791ad.get(i2);
                if (!m306switch(resourceCallback)) {
                    this.rrr.de();
                    resourceCallback.rg(this.rrr, this.nn);
                }
            }
            this.rrr.th();
            ppp(false);
        } else {
            throw new IllegalStateException("Already have resource");
        }
    }

    public final void ppp(boolean z) {
        fe.rg.qw.ggg.i.qw();
        this.f4791ad.clear();
        this.when = null;
        this.rrr = null;
        this.ddd = null;
        List<ResourceCallback> list = this.eee;
        if (list != null) {
            list.clear();
        }
        this.qqq = false;
        this.e = false;
        this.mmm = false;
        this.tt.rrr(z);
        this.tt = null;
        this.aaa = null;
        this.nn = null;
        this.f4797yj.release(this);
    }

    public void qw(GlideException glideException) {
        this.aaa = glideException;
        g.obtainMessage(2, this).sendToTarget();
    }

    public void rg(Resource<R> resource, DataSource dataSource) {
        this.ddd = resource;
        this.nn = dataSource;
        g.obtainMessage(1, this).sendToTarget();
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m306switch(ResourceCallback resourceCallback) {
        List<ResourceCallback> list = this.eee;
        return list != null && list.contains(resourceCallback);
    }

    public void th(DecodeJob<?> decodeJob) {
        uk().execute(decodeJob);
    }

    public final GlideExecutor uk() {
        if (this.ggg) {
            return this.f182if;
        }
        return this.vvv ? this.f183switch : this.f4794pf;
    }

    public void vvv(DecodeJob<R> decodeJob) {
        GlideExecutor glideExecutor;
        this.tt = decodeJob;
        if (decodeJob.e()) {
            glideExecutor = this.f4793o;
        } else {
            glideExecutor = uk();
        }
        glideExecutor.execute(decodeJob);
    }

    public boolean when() {
        return this.xxx;
    }

    public void yj() {
        if (!this.qqq && !this.mmm && !this.e) {
            this.e = true;
            this.tt.qw();
            this.f4792i.de(this, this.when);
        }
    }

    @VisibleForTesting
    public i(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, o oVar, Pools.Pool<i<?>> pool, qw qwVar) {
        this.f4791ad = new ArrayList(2);
        this.f4795th = fe.rg.qw.ggg.o.ad.qw();
        this.f4793o = glideExecutor;
        this.f4794pf = glideExecutor2;
        this.f182if = glideExecutor3;
        this.f183switch = glideExecutor4;
        this.f4792i = oVar;
        this.f4797yj = pool;
        this.f4796uk = qwVar;
    }
}
