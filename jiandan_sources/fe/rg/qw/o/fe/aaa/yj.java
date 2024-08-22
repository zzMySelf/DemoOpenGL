package fe.rg.qw.o.fe.aaa;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.pool.FactoryPools;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.rg;
import fe.rg.qw.ggg.uk;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public final Pools.Pool<ad> f4771ad = FactoryPools.rg(10, new qw(this));
    public final rg<Key, String> qw = new rg<>(1000);

    public static final class ad implements FactoryPools.Poolable {

        /* renamed from: ad  reason: collision with root package name */
        public final MessageDigest f4772ad;

        /* renamed from: th  reason: collision with root package name */
        public final fe.rg.qw.ggg.o.ad f4773th = fe.rg.qw.ggg.o.ad.qw();

        public ad(MessageDigest messageDigest) {
            this.f4772ad = messageDigest;
        }

        @NonNull
        public fe.rg.qw.ggg.o.ad fe() {
            return this.f4773th;
        }
    }

    public class qw implements FactoryPools.Factory<ad> {
        public qw(yj yjVar) {
        }

        /* renamed from: ad */
        public ad qw() {
            try {
                return new ad(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String ad(Key key) {
        String yj2;
        synchronized (this.qw) {
            yj2 = this.qw.yj(key);
        }
        if (yj2 == null) {
            yj2 = qw(key);
        }
        synchronized (this.qw) {
            this.qw.pf(key, yj2);
        }
        return yj2;
    }

    public final String qw(Key key) {
        ad acquire = this.f4771ad.acquire();
        uk.fe(acquire);
        ad adVar = acquire;
        try {
            key.qw(adVar.f4772ad);
            return i.ddd(adVar.f4772ad.digest());
        } finally {
            this.f4771ad.release(adVar);
        }
    }
}
