package fe.mmm.qw.j;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class uk {
    @NotNull
    public static final qw qw = new qw((DefaultConstructorMarker) null);

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int ad(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getApplicationContext().getSystemService("window");
            if (systemService != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }

        public final int qw(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getApplicationContext().getSystemService("window");
            if (systemService != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
    }
}
