package fe.mmm.qw.xxx.p032if.qw;

import android.content.Context;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.xxx.if.qw.o  reason: invalid package */
public final class o {
    @NotNull
    public static final o qw = new o();

    @NotNull
    public final List<ISettingItem> ad() {
        return CollectionsKt__CollectionsKt.listOf(new when(), new pf(), new uk(), new Cif(), new Cswitch(), new i());
    }

    public final boolean de() {
        return false;
    }

    @NotNull
    public final String qw(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "京ICP备2020042663号-13A";
    }
}
