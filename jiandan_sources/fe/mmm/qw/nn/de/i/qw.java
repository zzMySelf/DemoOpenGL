package fe.mmm.qw.nn.de.i;

import com.mars.kotlin.extension.fp.Either;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public static final Either.Left<Pair<String, Integer>> qw = new Either.Left<>(TuplesKt.to("network_error_key", 1));

    @NotNull
    public static final Either.Left<Pair<String, Integer>> ad() {
        return qw;
    }

    @NotNull
    public static final Either.Left<Pair<String, Integer>> de(int i2, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("server_error_key_");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return new Either.Left<>(TuplesKt.to(sb.toString(), Integer.valueOf(i2)));
    }

    @NotNull
    public static final Pair<String, Integer> qw(@NotNull Either.Left<Pair<String, Integer>> left) {
        Intrinsics.checkNotNullParameter(left, "<this>");
        return left.getValue();
    }
}
