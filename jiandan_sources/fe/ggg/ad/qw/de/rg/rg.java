package fe.ggg.ad.qw.de.rg;

import androidx.lifecycle.LiveData;
import com.mars.united.core.os.database.UriObserver;
import java.io.Closeable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public final class rg {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final ConcurrentHashMap<WeakReference<LiveData<?>>, UriObserver> f7580ad = new ConcurrentHashMap<>();
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final ReferenceQueue<LiveData<?>> f7581de = new ReferenceQueue<>();
    @NotNull
    public static final ConcurrentHashMap<WeakReference<LiveData<?>>, Closeable> qw = new ConcurrentHashMap<>();
}
