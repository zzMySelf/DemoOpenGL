package i.qw.u1;

import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
public final class th<T> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final ad f6196ad = new ad((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final de f6197de = new de();
    @Nullable
    public final Object qw;

    public static final class ad {
        public ad() {
        }

        public /* synthetic */ ad(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <E> Object ad() {
            de qw = th.f6197de;
            th.de(qw);
            return qw;
        }

        @NotNull
        public final <E> Object de(E e) {
            th.de(e);
            return e;
        }

        @NotNull
        public final <E> Object qw(@Nullable Throwable th2) {
            qw qwVar = new qw(th2);
            th.de(qwVar);
            return qwVar;
        }
    }

    public static class de {
        @NotNull
        public String toString() {
            return "Failed";
        }
    }

    public static final class qw extends de {
        @Nullable
        @JvmField
        public final Throwable qw;

        public qw(@Nullable Throwable th2) {
            this.qw = th2;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof qw) && Intrinsics.areEqual((Object) this.qw, (Object) ((qw) obj).qw);
        }

        public int hashCode() {
            Throwable th2 = this.qw;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Closed(" + this.qw + ')';
        }
    }

    @PublishedApi
    public /* synthetic */ th(Object obj) {
        this.qw = obj;
    }

    public static final /* synthetic */ th ad(Object obj) {
        return new th(obj);
    }

    @NotNull
    @PublishedApi
    public static <T> Object de(@Nullable Object obj) {
        return obj;
    }

    public static boolean fe(Object obj, Object obj2) {
        return (obj2 instanceof th) && Intrinsics.areEqual(obj, ((th) obj2).m403if());
    }

    public static final boolean i(Object obj) {
        return obj instanceof qw;
    }

    public static final boolean o(Object obj) {
        return !(obj instanceof de);
    }

    @NotNull
    public static String pf(Object obj) {
        if (obj instanceof qw) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    @Nullable
    public static final Throwable rg(Object obj) {
        qw qwVar = obj instanceof qw ? (qw) obj : null;
        if (qwVar == null) {
            return null;
        }
        return qwVar.qw;
    }

    @Nullable
    public static final T th(Object obj) {
        if (!(obj instanceof de)) {
            return obj;
        }
        return null;
    }

    public static int uk(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final T yj(Object obj) {
        Throwable th2;
        if (!(obj instanceof de)) {
            return obj;
        }
        if (!(obj instanceof qw) || (th2 = ((qw) obj).qw) == null) {
            throw new IllegalStateException(Intrinsics.stringPlus("Trying to call 'getOrThrow' on a failed channel result: ", obj).toString());
        }
        throw th2;
    }

    public boolean equals(Object obj) {
        return fe(m403if(), obj);
    }

    public int hashCode() {
        return uk(m403if());
    }

    /* renamed from: if  reason: not valid java name */
    public final /* synthetic */ Object m403if() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return pf(m403if());
    }
}
