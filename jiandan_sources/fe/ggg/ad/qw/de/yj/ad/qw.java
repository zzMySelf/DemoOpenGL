package fe.ggg.ad.qw.de.yj.ad;

import android.content.ContentResolver;
import android.database.Cursor;
import com.google.android.gms.actions.SearchIntents;
import com.mars.united.core.util.scheduler.BaseTask;
import fe.ggg.ad.qw.de.yj.qw.qw;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw<T, V extends fe.ggg.ad.qw.de.yj.qw.qw> extends BaseTask {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qw(@NotNull String str, @NotNull ContentResolver contentResolver, @NotNull de deVar, int i2, @NotNull IntRange intRange, @Nullable V v, @NotNull Function1<? super Cursor, ? extends T> function1, @NotNull Function1<? super Integer, ? extends V> function12, @NotNull fe.ggg.ad.qw.de.yj.de.qw<T, V> qwVar) {
        super("DatabaseLoadTask-" + str + '-' + deVar + '-' + i2 + '-' + intRange, 1);
        Intrinsics.checkNotNullParameter(str, "customTag");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(deVar, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(intRange, "loadRange");
        Intrinsics.checkNotNullParameter(function1, "parserData");
        Intrinsics.checkNotNullParameter(function12, "obtainVersion");
        Intrinsics.checkNotNullParameter(qwVar, "handler");
    }
}
