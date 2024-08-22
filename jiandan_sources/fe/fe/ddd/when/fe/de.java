package fe.fe.ddd.when.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import java.io.File;

public class de {
    @NonNull
    public Supplier<File> qw;

    public static class ad {
        @NonNull

        /* renamed from: ad  reason: collision with root package name */
        public Context f1675ad;
        @Nullable
        public Supplier<File> qw;

        public ad(@NonNull Context context) {
            this.f1675ad = context;
        }

        @NonNull
        public de de() {
            return new de(this, (qw) null);
        }
    }

    public class qw implements Supplier<File> {
        public final /* synthetic */ ad qw;

        public qw(de deVar, ad adVar) {
            this.qw = adVar;
        }

        /* renamed from: qw */
        public File get() {
            Context applicationContext = this.qw.f1675ad.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = this.qw.f1675ad;
            }
            return new File(applicationContext.getFilesDir(), "log_store");
        }
    }

    public /* synthetic */ de(ad adVar, qw qwVar) {
        this(adVar);
    }

    public static void ad() {
    }

    @NonNull
    public Supplier<File> qw() {
        return this.qw;
    }

    public de(@NonNull ad adVar) {
        Supplier<File> supplier;
        if (adVar.qw == null) {
            supplier = new qw(this, adVar);
        } else {
            supplier = adVar.qw;
        }
        this.qw = supplier;
    }
}
