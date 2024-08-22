package co.touchlab.stately.collections;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/util/Collection;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IsoMutableCollection.kt */
final class IsoMutableCollection$isEmpty$1 extends Lambda implements Function1<Collection<T>, Boolean> {
    public static final IsoMutableCollection$isEmpty$1 INSTANCE = new IsoMutableCollection$isEmpty$1();

    IsoMutableCollection$isEmpty$1() {
        super(1);
    }

    public final Boolean invoke(Collection<T> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.isEmpty());
    }
}
