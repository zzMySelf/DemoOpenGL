package fe.ggg.ad.qw.de;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable
    public static final Fragment qw(@NotNull FragmentActivity fragmentActivity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        return fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
    }
}
