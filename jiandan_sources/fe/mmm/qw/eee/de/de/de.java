package fe.mmm.qw.eee.de.de;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.tera.scan.permission.request.PermissionDialogAfterRefuseDialogInternal;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    public final void ad(@NotNull Context context, @NotNull FragmentManager fragmentManager, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        new PermissionDialogAfterRefuseDialogInternal().de(context, fragmentManager, function0);
    }

    public final void qw(@NotNull Context context, @NotNull FragmentManager fragmentManager, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        new PermissionDialogAfterRefuseDialogInternal().ad(context, fragmentManager, function0);
    }
}
