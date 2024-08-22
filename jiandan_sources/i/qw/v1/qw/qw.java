package i.qw.v1.qw;

import i.qw.x1.c;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final th f6215ad = new th((Object) null);
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final th f6216de = new th(Boolean.TRUE);
    @NotNull
    public static final c qw = new c("REHASH");

    public static final /* synthetic */ Void de() {
        rg();
        throw null;
    }

    public static final th fe(Object obj) {
        if (obj == null) {
            return f6215ad;
        }
        if (Intrinsics.areEqual(obj, (Object) Boolean.TRUE)) {
            return f6216de;
        }
        return new th(obj);
    }

    public static final Void rg() {
        throw new UnsupportedOperationException("not implemented");
    }
}
