package i.qw.x1;

import i.qw.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
/* renamed from: i.qw.x1.switch  reason: invalid class name */
public final class Cswitch<E> {
    public static /* synthetic */ Object ad(Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        qw(obj);
        return obj;
    }

    @NotNull
    public static final Object de(Object obj, E e) {
        if (k.qw() && !(!(e instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            qw(e);
            return e;
        } else if (!(obj instanceof ArrayList)) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            qw(arrayList);
            return arrayList;
        } else if (obj != null) {
            ((ArrayList) obj).add(e);
            qw(obj);
            return obj;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        }
    }

    @NotNull
    public static <E> Object qw(@Nullable Object obj) {
        return obj;
    }
}
