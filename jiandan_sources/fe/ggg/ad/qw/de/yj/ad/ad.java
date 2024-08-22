package fe.ggg.ad.qw.de.yj.ad;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ContentResolver f7588ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final List<Uri> f7589de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final Function0<Unit> f7590fe;
    @NotNull
    public final Handler qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile boolean f7591rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final qw f7592th;

    public static final class qw extends ContentObserver {
        public final /* synthetic */ ad qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(ad adVar, Handler handler) {
            super(handler);
            this.qw = adVar;
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            if (!this.qw.f7591rg) {
                this.qw.f7590fe.invoke();
            }
        }
    }

    public ad(@NotNull Handler handler, @NotNull ContentResolver contentResolver, @NotNull List<? extends Uri> list, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(list, "uri");
        Intrinsics.checkNotNullParameter(function0, "notifyChanged");
        this.qw = handler;
        this.f7588ad = contentResolver;
        this.f7589de = list;
        this.f7590fe = function0;
        this.f7592th = new qw(this, handler);
    }

    public final void de() {
        this.f7591rg = false;
        for (Uri registerContentObserver : this.f7589de) {
            this.f7588ad.registerContentObserver(registerContentObserver, true, this.f7592th);
        }
    }

    public final void fe() {
        this.f7591rg = true;
        this.f7588ad.unregisterContentObserver(this.f7592th);
    }
}
