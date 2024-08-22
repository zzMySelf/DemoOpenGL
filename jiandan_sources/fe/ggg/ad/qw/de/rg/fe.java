package fe.ggg.ad.qw.de.rg;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.united.core.os.database.UriObserver;
import fe.ggg.ad.qw.ad.ad;
import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("LiveDataGC")
public final class fe {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final AtomicBoolean f7578ad = new AtomicBoolean(false);
    @NotNull
    public static final fe qw = new fe();

    public static final void yj() {
        while (true) {
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(ad.qw("ref check start"), (Object) null, 1, (Object) null);
            }
            qw.fe(rg.f7581de.remove());
        }
    }

    public final void ad(Closeable closeable) {
        try {
            if (!(closeable instanceof Cursor)) {
                closeable.close();
            } else if (((Cursor) closeable).isClosed()) {
                closeable.close();
            }
        } catch (Throwable th2) {
            ad.ad(th2, "LiveDataGC");
        }
    }

    @NotNull
    public final WeakReference<LiveData<?>> de(@NotNull LiveData<?> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        return new WeakReference<>(liveData, rg.f7581de);
    }

    public final void fe(Reference<? extends LiveData<?>> reference) {
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleRefSafe ref(");
            sb.append(reference);
            sb.append(") ref?.get()(");
            sb.append(reference == null ? null : (LiveData) reference.get());
            sb.append(')');
            LoggerKt.d$default(ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
        if (reference != null) {
            try {
                ConcurrentHashMap ad2 = rg.f7580ad;
                if (ad2 != null) {
                    UriObserver uriObserver = (UriObserver) TypeIntrinsics.asMutableMap(ad2).remove(reference);
                    if (uriObserver != null) {
                        uriObserver.qw();
                    }
                    ConcurrentHashMap qw2 = rg.qw;
                    if (qw2 != null) {
                        Closeable closeable = (Closeable) TypeIntrinsics.asMutableMap(qw2).remove(reference);
                        if (Logger.INSTANCE.getEnable()) {
                            LoggerKt.d$default(ad.qw("handleRefSafe close closeable=" + closeable + " ref(" + reference + ")=" + reference.get()), (Object) null, 1, (Object) null);
                        }
                        if (closeable != null) {
                            ad(closeable);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            } catch (Throwable th2) {
                ad.ad(th2, "LiveDataGC-handleRefSafe");
            }
        }
    }

    public final void qw(@NotNull WeakReference<LiveData<?>> weakReference, @NotNull UriObserver uriObserver, @Nullable Closeable closeable) {
        Intrinsics.checkNotNullParameter(weakReference, "ref");
        Intrinsics.checkNotNullParameter(uriObserver, "observer");
        rg();
        Closeable closeable2 = (Closeable) rg.qw.get(weakReference);
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw("addOrUpdate ref=" + weakReference + " cacheCursor=" + closeable2 + " closeData=" + closeable), (Object) null, 1, (Object) null);
        }
        if (closeable2 != null) {
            ad(closeable2);
        }
        if (closeable != null) {
            rg.qw.put(weakReference, closeable);
        }
        rg.f7580ad.put(weakReference, uriObserver);
    }

    public final void rg() {
        if (f7578ad.compareAndSet(false, true)) {
            th();
        }
    }

    public final void th() {
        new Thread(qw.f7579ad).start();
    }
}
