package i.qw.v1.qw;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

public final class rg<T> extends WeakReference<T> {
    @JvmField
    public final int qw;

    public rg(T t, @Nullable ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        this.qw = t != null ? t.hashCode() : 0;
    }
}
