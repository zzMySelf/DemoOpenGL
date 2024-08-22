package co.touchlab.stately.collections;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "E", "it", "", "invoke", "(Ljava/util/Collection;)Ljava/lang/Object;", "co/touchlab/stately/collections/IsoArrayDeque$asAccess$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IsoArrayDeque.kt */
public final class IsoArrayDeque$first$$inlined$asAccess$1 extends Lambda implements Function1<Collection<E>, E> {
    public IsoArrayDeque$first$$inlined$asAccess$1() {
        super(1);
    }

    public final E invoke(Collection<E> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((ArrayDeque) it).first();
    }
}
