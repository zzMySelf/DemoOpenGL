package fe.de.qw.qw;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.List;

public final class ppp {
    public final zzu qw;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final String f1276ad;
        public final String qw;

        public static class qw {

            /* renamed from: ad  reason: collision with root package name */
            public String f1277ad;
            public String qw;

            public /* synthetic */ qw(t tVar) {
            }

            @NonNull
            public qw ad(@NonNull String str) {
                this.qw = str;
                return this;
            }

            @NonNull
            public qw de(@NonNull String str) {
                this.f1277ad = str;
                return this;
            }

            @NonNull
            public ad qw() {
                if (this.qw == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                } else if (this.f1277ad != null) {
                    return new ad(this, (u) null);
                } else {
                    throw new IllegalArgumentException("Product type must be provided.");
                }
            }
        }

        public /* synthetic */ ad(qw qwVar, u uVar) {
            this.qw = qwVar.qw;
            this.f1276ad = qwVar.f1277ad;
        }

        @NonNull
        public static qw qw() {
            return new qw((t) null);
        }

        @NonNull
        public final String ad() {
            return this.qw;
        }

        @NonNull
        public final String de() {
            return this.f1276ad;
        }
    }

    public static class qw {
        public zzu qw;

        public /* synthetic */ qw(s sVar) {
        }

        @NonNull
        public qw ad(@NonNull List<ad> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            boolean z = false;
            boolean z2 = false;
            for (ad next : list) {
                z |= next.de().equals("inapp");
                z2 |= next.de().equals("subs");
            }
            if (!z || !z2) {
                this.qw = zzu.zzk(list);
                return this;
            }
            throw new IllegalArgumentException("All products should be of the same product type.");
        }

        @NonNull
        public ppp qw() {
            return new ppp(this, (v) null);
        }
    }

    public /* synthetic */ ppp(qw qwVar, v vVar) {
        this.qw = qwVar.qw;
    }

    @NonNull
    public static qw qw() {
        return new qw((s) null);
    }

    public final zzu ad() {
        return this.qw;
    }

    @NonNull
    public final String de() {
        return ((ad) this.qw.get(0)).de();
    }
}
