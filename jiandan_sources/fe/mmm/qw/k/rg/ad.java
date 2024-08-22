package fe.mmm.qw.k.rg;

import com.baidu.netdisk.trade.privilege.config.IStore;
import fe.mmm.qw.yj.th;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad implements IStore {
    public void putInt(@NotNull String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "key");
        th.ppp().pf(str, i2);
    }

    public void putLong(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        th.ppp().m1012if(str, j);
    }

    public void putString(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        th.ppp().m1013switch(str, str2);
    }

    public void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        th.ppp().when(str);
    }
}
