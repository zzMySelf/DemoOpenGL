package fe.uk.qw.pf.fe.mmm;

import androidx.annotation.Nullable;
import fe.uk.qw.pf.fe.mmm.pf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class th<K extends pf, V> {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<K, qw<K, V>> f5793ad = new HashMap();
    public final qw<K, V> qw = new qw<>();

    public static class qw<K, V> {

        /* renamed from: ad  reason: collision with root package name */
        public List<V> f5794ad;

        /* renamed from: de  reason: collision with root package name */
        public qw<K, V> f5795de;

        /* renamed from: fe  reason: collision with root package name */
        public qw<K, V> f5796fe;
        public final K qw;

        public qw() {
            this((Object) null);
        }

        @Nullable
        public V ad() {
            int de2 = de();
            if (de2 > 0) {
                return this.f5794ad.remove(de2 - 1);
            }
            return null;
        }

        public int de() {
            List<V> list = this.f5794ad;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void qw(V v) {
            if (this.f5794ad == null) {
                this.f5794ad = new ArrayList();
            }
            this.f5794ad.add(v);
        }

        public qw(K k) {
            this.f5796fe = this;
            this.f5795de = this;
            this.qw = k;
        }
    }

    public static <K, V> void rg(qw<K, V> qwVar) {
        qw<K, V> qwVar2 = qwVar.f5796fe;
        qwVar2.f5795de = qwVar.f5795de;
        qwVar.f5795de.f5796fe = qwVar2;
    }

    public static <K, V> void yj(qw<K, V> qwVar) {
        qwVar.f5795de.f5796fe = qwVar;
        qwVar.f5796fe.f5795de = qwVar;
    }

    public final void ad(qw<K, V> qwVar) {
        rg(qwVar);
        qw<K, V> qwVar2 = this.qw;
        qwVar.f5796fe = qwVar2;
        qwVar.f5795de = qwVar2.f5795de;
        yj(qwVar);
    }

    public final void de(qw<K, V> qwVar) {
        rg(qwVar);
        qw<K, V> qwVar2 = this.qw;
        qwVar.f5796fe = qwVar2.f5796fe;
        qwVar.f5795de = qwVar2;
        yj(qwVar);
    }

    public void fe(K k, V v) {
        qw qwVar = this.f5793ad.get(k);
        if (qwVar == null) {
            qwVar = new qw(k);
            de(qwVar);
            this.f5793ad.put(k, qwVar);
        } else {
            k.qw();
        }
        qwVar.qw(v);
    }

    @Nullable
    public V qw(K k) {
        qw qwVar = this.f5793ad.get(k);
        if (qwVar == null) {
            qwVar = new qw(k);
            this.f5793ad.put(k, qwVar);
        } else {
            k.qw();
        }
        ad(qwVar);
        return qwVar.ad();
    }

    @Nullable
    public V th() {
        for (qw<K, V> qwVar = this.qw.f5796fe; !qwVar.equals(this.qw); qwVar = qwVar.f5796fe) {
            V ad2 = qwVar.ad();
            if (ad2 != null) {
                return ad2;
            }
            rg(qwVar);
            this.f5793ad.remove(qwVar.qw);
            ((pf) qwVar.qw).qw();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (qw<K, V> qwVar = this.qw.f5795de; !qwVar.equals(this.qw); qwVar = qwVar.f5795de) {
            z = true;
            sb.append(ExtendedMessageFormat.START_FE);
            sb.append(qwVar.qw);
            sb.append(':');
            sb.append(qwVar.de());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
