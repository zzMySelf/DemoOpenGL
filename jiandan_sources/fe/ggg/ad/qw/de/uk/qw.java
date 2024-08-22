package fe.ggg.ad.qw.de.uk;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.mars.kotlin.extension.Logger;
import com.mars.united.core.debug.DevelopException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull
    public final FragmentActivity qw;

    public qw(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.qw = fragmentActivity;
    }

    public final void qw() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.qw.getPackageName(), (String) null));
        try {
            this.qw.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
                throw new DevelopException((Throwable) e);
            }
        }
    }
}
