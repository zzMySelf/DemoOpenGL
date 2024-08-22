package fe.mmm.qw.qqq.i;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import androidx.appcompat.widget.ActivityChooserModel;
import com.github.barteksc.pdfviewer.PDFThumb;
import com.shockwave.pdfium.util.Size;
import fe.mmm.qw.o.qw.de.qw.uk;
import fe.mmm.qw.ppp.qw;
import fe.p013if.ad.qw.th;
import fe.p013if.ad.qw.yj;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de extends uk {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public de(@NotNull String str, @NotNull Activity activity, @Nullable String str2) {
        super(str, activity, str2);
        Intrinsics.checkNotNullParameter(str, "localPath");
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @NotNull
    public Size uk() {
        Context qw = qw.qw.qw();
        ActivityManager activityManager = null;
        Object systemService = qw != null ? qw.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY) : null;
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        }
        boolean z = false;
        int memoryClass = activityManager != null ? activityManager.getMemoryClass() : 0;
        if (memoryClass <= 256) {
            z = true;
        }
        fe.mmm.qw.i.qw.ad("PdfThumbProxy", "currentDeviceMaxMemory：" + memoryClass + " lowMemory：" + z);
        if (z) {
            fe.mmm.qw.i.qw.ad("PdfThumbProxy", "use low memory setting");
            return new Size(1800, 1800);
        }
        fe.mmm.qw.i.qw.ad("PdfThumbProxy", "use high memory setting");
        return new Size(2560, 2560);
    }

    @NotNull
    public PDFThumb yj(@Nullable Looper looper, @Nullable th thVar) {
        return new yj(looper, thVar);
    }
}
