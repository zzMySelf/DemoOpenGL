package fe.mmm.qw.uk;

import android.net.Uri;
import android.os.SystemClock;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.db.ISlowWriteMonitorable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final int f8558ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final AtomicInteger f8559de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final ISlowWriteMonitorable f8560fe;
    @Nullable
    public Uri qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile long f8561rg;

    /* renamed from: th  reason: collision with root package name */
    public volatile long f8562th;

    public ad(@Nullable Uri uri, int i2, @NotNull AtomicInteger atomicInteger, @NotNull ISlowWriteMonitorable iSlowWriteMonitorable) {
        Intrinsics.checkNotNullParameter(atomicInteger, "slowWriteCounter");
        Intrinsics.checkNotNullParameter(iSlowWriteMonitorable, "monitor");
        this.qw = uri;
        this.f8558ad = i2;
        this.f8559de = atomicInteger;
        this.f8560fe = iSlowWriteMonitorable;
        SystemClock.elapsedRealtime();
    }

    public final void ad() {
        if (this.f8559de.get() < this.f8560fe.ad() && this.f8561rg > 0 && de() > this.f8560fe.qw()) {
            this.f8559de.incrementAndGet();
            try {
                this.f8560fe.de(this);
                ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                ExpectKt.failure(th2);
            }
        }
    }

    public final long de() {
        fe();
        return this.f8562th - this.f8561rg;
    }

    public final void fe() {
        if (this.f8562th <= 0) {
            this.f8562th = SystemClock.elapsedRealtime();
        }
    }

    public final void qw() {
        this.f8561rg = SystemClock.elapsedRealtime();
    }

    public final long rg() {
        return this.f8562th;
    }

    @Nullable
    public final Uri th() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        Either either;
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        try {
            Uri uri = this.qw;
            if (uri == null || (str = uri.getQueryParameter("KEY_URI_CALL_FROM_SCENE")) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "uri?.getQueryParameter(SCENE_KEY) ?: \"\"");
            Uri uri2 = this.qw;
            if (uri2 == null || (str2 = uri2.getPath()) == null) {
                str2 = "";
            }
            Intrinsics.checkNotNullExpressionValue(str2, "uri?.path ?: \"\"");
            either = ExpectKt.success(str + str2);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        sb.append((String) ExpectKt.successOrDefault(either, ""));
        sb.append(this.f8558ad);
        return sb.toString();
    }

    public final void uk(@Nullable Uri uri) {
        this.qw = uri;
    }

    public final boolean yj() {
        return this.f8561rg > 0 && this.f8562th == 0;
    }
}
