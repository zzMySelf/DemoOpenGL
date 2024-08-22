package fe.fe.ddd.when.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.fe.ddd.when.fe.de;
import fe.fe.ddd.when.fe.uk;

public class yj {
    @NonNull

    /* renamed from: ad  reason: collision with root package name */
    public Context f1686ad;
    @NonNull
    public de qw;

    public static class ad {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public de f1687ad;
        @NonNull

        /* renamed from: de  reason: collision with root package name */
        public Context f1688de;
        @Nullable
        public uk qw;

        public ad(@NonNull Context context) {
            this.f1688de = context;
        }

        @NonNull
        public yj fe() {
            return new yj(this);
        }
    }

    public static void ad() {
        uk.qw();
        de.ad();
    }

    @NonNull
    public static ad de(@NonNull Context context) {
        return new ad(context);
    }

    @NonNull
    public de qw() {
        return this.qw;
    }

    public yj(@NonNull ad adVar) {
        this.f1686ad = adVar.f1688de;
        this.qw = adVar.f1687ad == null ? new de.ad(this.f1686ad).de() : adVar.f1687ad;
        if (adVar.qw == null) {
            new uk.ad().ad();
        } else {
            uk unused = adVar.qw;
        }
    }
}
