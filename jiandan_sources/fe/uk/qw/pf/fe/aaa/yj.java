package fe.uk.qw.pf.fe.aaa;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.util.pool.FactoryPools;
import fe.uk.qw.vvv.i;
import fe.uk.qw.vvv.o;
import fe.uk.qw.vvv.th;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public final Pools.Pool<ad> f5738ad = FactoryPools.fe(10, new qw(this));
    public final th<Key, String> qw = new th<>(1000);

    public static final class ad implements FactoryPools.Poolable {

        /* renamed from: ad  reason: collision with root package name */
        public final MessageDigest f5739ad;

        /* renamed from: th  reason: collision with root package name */
        public final fe.uk.qw.vvv.pf.ad f5740th = fe.uk.qw.vvv.pf.ad.qw();

        public ad(MessageDigest messageDigest) {
            this.f5739ad = messageDigest;
        }

        @NonNull
        public fe.uk.qw.vvv.pf.ad fe() {
            return this.f5740th;
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
        ad acquire = this.f5738ad.acquire();
        i.fe(acquire);
        ad adVar = acquire;
        try {
            key.qw(adVar.f5739ad);
            return o.aaa(adVar.f5739ad.digest());
        } finally {
            this.f5738ad.release(adVar);
        }
    }
}
