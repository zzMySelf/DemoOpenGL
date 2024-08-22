package i.qw;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class h extends AbstractCoroutineContextElement {
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static final qw f6133th = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f6134ad;

    public static final class qw implements CoroutineContext.Key<h> {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && Intrinsics.areEqual((Object) this.f6134ad, (Object) ((h) obj).f6134ad);
    }

    public int hashCode() {
        return this.f6134ad.hashCode();
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.f6134ad + ')';
    }

    @NotNull
    public final String xxx() {
        return this.f6134ad;
    }
}
