package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.OnGetIdResultCallback;
import com.dxmpay.wallet.utils.StatHelper;
import com.google.common.net.MediaType;
import com.mars.kotlin.extension.LoggerKt;
import fe.fe.pf.ad;
import fe.mmm.qw.c.th;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class o extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8623yj;

    public static final class qw implements OnGetIdResultCallback<String> {
        public void onError(int i2, @Nullable Throwable th2, @Nullable Bundle bundle) {
            LoggerKt.d$default("requestOid onError", (Object) null, 1, (Object) null);
            fe.mmm.qw.de.ad.qw.qw.f330switch = StatHelper.SENSOR_ERR_2;
        }

        /* renamed from: qw */
        public void onResult(@NotNull String str, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "oaid");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            LoggerKt.d$default("requestOid:" + str + " bundle:" + bundle, (Object) null, 1, (Object) null);
            if (TextUtils.isEmpty(str)) {
                str = "-1";
            }
            fe.mmm.qw.de.ad.qw.qw.f330switch = str;
        }
    }

    public o(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.f8623yj = application;
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "OAIDStartupTask";
    }

    public int uk() {
        return 0;
    }

    public void xxx() {
        fe.mmm.qw.de.ad.qw.qw.f329if = ad.th(this.f8623yj).de();
        ad.th(this.f8623yj).ppp(new qw());
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
