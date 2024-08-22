package fe.ggg.ad.qw.fe.ad;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de {
    @NotNull
    public static final <T> ArrayList<T> qw(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList<T> arrayList = new ArrayList<>();
        for (Object add : collection) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
