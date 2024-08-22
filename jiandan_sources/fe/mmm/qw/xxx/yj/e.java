package fe.mmm.qw.xxx.yj;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.home.FileSelectModeFragment;
import fe.mmm.qw.th.qw.th.o;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "FileSelectModeFragmentFlavor")
public final class e {
    public static final void qw(@NotNull FileSelectModeFragment fileSelectModeFragment, boolean z) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "<this>");
        if (z) {
            Context context = fileSelectModeFragment.getContext();
            if (context != null) {
                o.uk(context.getResources().getString(R.string.delete_file_success_toast));
            }
            FragmentActivity activity = fileSelectModeFragment.getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                fileSelectModeFragment.getViewModel$app_main_aiscanConfigRelease().exitFileSelectMode(mainActivity);
            }
        }
    }
}
