package i.qw.a2;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import org.jetbrains.annotations.NotNull;

public final class de {
    public static final /* synthetic */ AtomicLongFieldUpdater qw = AtomicLongFieldUpdater.newUpdater(de.class, "number");
    @NotNull
    public volatile /* synthetic */ long number = 1;

    public final long qw() {
        return qw.incrementAndGet(this);
    }
}
