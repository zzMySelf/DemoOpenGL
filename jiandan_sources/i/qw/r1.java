package i.qw;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class r1 extends AbstractCoroutineContextElement {
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static final qw f6163th = new qw((DefaultConstructorMarker) null);
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public boolean f6164ad;

    public static final class qw implements CoroutineContext.Key<r1> {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r1() {
        super(f6163th);
    }
}
