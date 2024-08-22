package fe.rg.qw.o.fe;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

public final class when {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<Key, i<?>> f4904ad = new HashMap();
    public final Map<Key, i<?>> qw = new HashMap();

    public final Map<Key, i<?>> ad(boolean z) {
        return z ? this.f4904ad : this.qw;
    }

    public void de(Key key, i<?> iVar) {
        ad(iVar.when()).put(key, iVar);
    }

    public void fe(Key key, i<?> iVar) {
        Map<Key, i<?>> ad2 = ad(iVar.when());
        if (iVar.equals(ad2.get(key))) {
            ad2.remove(key);
        }
    }

    public i<?> qw(Key key, boolean z) {
        return ad(z).get(key);
    }
}
