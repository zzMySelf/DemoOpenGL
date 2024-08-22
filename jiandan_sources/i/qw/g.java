package i.qw;

import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g extends AbstractCoroutineContextElement implements ThreadContextElement<String> {
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static final qw f6124th = new qw((DefaultConstructorMarker) null);

    /* renamed from: ad  reason: collision with root package name */
    public final long f6125ad;

    public static final class qw implements CoroutineContext.Key<g> {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(long j) {
        super(f6124th);
        this.f6125ad = j;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f6125ad == ((g) obj).f6125ad;
    }

    public int hashCode() {
        return defpackage.qw.qw(this.f6125ad);
    }

    /* renamed from: mmm */
    public void m399switch(@NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Thread.currentThread().setName(str);
    }

    @NotNull
    /* renamed from: qqq */
    public String e(@NotNull CoroutineContext coroutineContext) {
        String xxx;
        h hVar = (h) coroutineContext.get(h.f6133th);
        String str = "coroutine";
        if (!(hVar == null || (xxx = hVar.xxx()) == null)) {
            str = xxx;
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) name, " @", 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            lastIndexOf$default = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + lastIndexOf$default + 10);
        if (name != null) {
            String substring = name.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(xxx());
            Unit unit = Unit.INSTANCE;
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
            currentThread.setName(sb2);
            return name;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.f6125ad + ')';
    }

    public final long xxx() {
        return this.f6125ad;
    }
}
