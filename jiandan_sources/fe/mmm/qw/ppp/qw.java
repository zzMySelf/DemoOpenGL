package fe.mmm.qw.ppp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.google.common.net.MediaType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: ad  reason: collision with root package name */
    public static Context f8199ad;
    @NotNull
    public static final C0290qw qw = new C0290qw((DefaultConstructorMarker) null);

    /* renamed from: fe.mmm.qw.ppp.qw$qw  reason: collision with other inner class name */
    public static final class C0290qw {
        public C0290qw() {
        }

        public /* synthetic */ C0290qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Context qw() {
            return qw.f8199ad;
        }
    }

    public final void ad(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        f8199ad = application;
        application.getPackageName();
    }
}
