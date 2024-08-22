package fe.ggg.ad.qw.de.rg;

import android.database.Cursor;
import android.os.Handler;
import com.mars.united.core.util.scheduler.BaseMultiTask;
import com.mars.united.core.util.scheduler.ThreadPriority;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class yj<T> extends BaseMultiTask {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yj(@NotNull String str, @NotNull String str2, boolean z, @NotNull Function1<? super Cursor, ? extends T> function1, @NotNull Handler handler, @NotNull Function0<? extends Cursor> function0, @NotNull ThreadPriority threadPriority) {
        super("LoadTaskGroup", CollectionsKt__CollectionsJVMKt.listOf(new de(str, function0, str2)), threadPriority, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "customDebugTag");
        Intrinsics.checkNotNullParameter(str2, "nameSuffix");
        Intrinsics.checkNotNullParameter(function1, "parser");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(function0, "getCursor");
        Intrinsics.checkNotNullParameter(threadPriority, "threadPriority");
    }
}
