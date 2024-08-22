package fe.de.qw.qw;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzb;

public final class yj {

    /* renamed from: ad  reason: collision with root package name */
    public String f1309ad;
    public int qw;

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f1310ad = "";
        public int qw;

        public /* synthetic */ qw(k kVar) {
        }

        @NonNull
        public qw ad(@NonNull String str) {
            this.f1310ad = str;
            return this;
        }

        @NonNull
        public qw de(int i2) {
            this.qw = i2;
            return this;
        }

        @NonNull
        public yj qw() {
            yj yjVar = new yj();
            yjVar.qw = this.qw;
            yjVar.f1309ad = this.f1310ad;
            return yjVar;
        }
    }

    @NonNull
    public static qw de() {
        return new qw((k) null);
    }

    public int ad() {
        return this.qw;
    }

    @NonNull
    public String qw() {
        return this.f1309ad;
    }

    @NonNull
    public String toString() {
        String zzl = zzb.zzl(this.qw);
        String str = this.f1309ad;
        return "Response Code: " + zzl + ", Debug Message: " + str;
    }
}
