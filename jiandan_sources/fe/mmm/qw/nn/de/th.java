package fe.mmm.qw.nn.de;

import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tera.scan.network.account.io.model.ServerBanInfo;
import com.tera.scan.network.network.exception.RemoteException;
import com.tera.scan.network.network.exception.RemoteExceptionInfo;
import fe.mmm.qw.nn.ad.qw.qw;
import fe.mmm.qw.nn.de.pf.de;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class th {
    public static void ad(int i2) {
        Function1<Integer, Unit> o2 = qw.qw.o();
        if (o2 != null) {
            o2.invoke(Integer.valueOf(i2));
        }
    }

    @CheckResult
    @NonNull
    public static RemoteException qw(int i2, @Nullable String str, @Nullable de deVar) {
        int i3;
        String str2 = deVar == null ? null : deVar.alertmsg;
        if (TextUtils.isEmpty(str)) {
            if (deVar == null) {
                str = null;
            } else {
                str = deVar.errmsg;
            }
        }
        if (deVar == null) {
            i3 = 0;
        } else {
            i3 = deVar.promptType;
        }
        Function1<Integer, Boolean> when = qw.qw.when();
        if (deVar != null && when != null && when.invoke(Integer.valueOf(deVar.errno)).booleanValue()) {
            return new RemoteException(i2, str, str2, (RemoteExceptionInfo) new ServerBanInfo(deVar.errno, deVar.errmsg));
        }
        if (i3 == 0) {
            return new RemoteException(i2, str, str2);
        }
        return new RemoteException(i2, str, str2, i3);
    }
}
