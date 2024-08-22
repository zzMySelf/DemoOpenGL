package fe.ggg.ad.qw.de.rg;

import android.database.Cursor;
import com.mars.kotlin.extension.Tag;
import com.mars.united.core.util.scheduler.BaseMultiTask;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("CursorLiveData_CursorTask")
public final class de extends BaseMultiTask.qw<Cursor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public de(@NotNull String str, @NotNull Function0<? extends Cursor> function0, @NotNull String str2) {
        super(Intrinsics.stringPlus("CursorTask_", str2), 1);
        Intrinsics.checkNotNullParameter(str, "customDebugTag");
        Intrinsics.checkNotNullParameter(function0, "getCursor");
        Intrinsics.checkNotNullParameter(str2, "nameSuffix");
    }
}
