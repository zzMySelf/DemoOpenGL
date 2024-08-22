package i.qw.u1;

import i.qw.u1.ad;
import i.qw.x1.c;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class o<E> extends AbstractChannel<E> {
    public o(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    @NotNull
    public Object aaa(E e) {
        ReceiveOrClosed<?> b;
        do {
            Object aaa = super.aaa(e);
            c cVar = qw.f6191ad;
            if (aaa == cVar) {
                return cVar;
            }
            if (aaa == qw.f6192de) {
                b = b(e);
                if (b == null) {
                    return qw.f6191ad;
                }
            } else if (aaa instanceof uk) {
                return aaa;
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Invalid offerInternal result ", aaa).toString());
            }
        } while (!(b instanceof uk));
        return b;
    }

    public final boolean ddd() {
        return false;
    }

    public final boolean r() {
        return true;
    }

    public final boolean s() {
        return true;
    }

    public final boolean vvv() {
        return false;
    }

    public void w(@NotNull Object obj, @NotNull uk<?> ukVar) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                when when = (when) obj;
                if (when instanceof ad.qw) {
                    Function1<E, Unit> function1 = this.f6177ad;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.de(function1, ((ad.qw) when).f6180uk, (UndeliveredElementException) null);
                    }
                } else {
                    when.u(ukVar);
                }
            } else if (obj != null) {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    UndeliveredElementException undeliveredElementException2 = null;
                    while (true) {
                        int i2 = size - 1;
                        when when2 = (when) arrayList.get(size);
                        if (when2 instanceof ad.qw) {
                            Function1<E, Unit> function12 = this.f6177ad;
                            undeliveredElementException2 = function12 == null ? null : OnUndeliveredElementKt.de(function12, ((ad.qw) when2).f6180uk, undeliveredElementException2);
                        } else {
                            when2.u(ukVar);
                        }
                        if (i2 < 0) {
                            break;
                        }
                        size = i2;
                    }
                    undeliveredElementException = undeliveredElementException2;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }
}
