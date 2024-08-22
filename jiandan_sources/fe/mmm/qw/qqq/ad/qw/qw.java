package fe.mmm.qw.qqq.ad.qw;

import android.content.Context;
import com.tera.scan.pdfedit.PdfEditService;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    public static final void qw(@NotNull Context context, @NotNull String str, @NotNull ArrayList<String> arrayList, boolean z, boolean z2, @NotNull IPdfEditCallback iPdfEditCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "pdfPath");
        Intrinsics.checkNotNullParameter(arrayList, "filePaths");
        Intrinsics.checkNotNullParameter(iPdfEditCallback, "callback");
        new PdfEditService().qw(context, str, arrayList, z, z2, iPdfEditCallback);
    }
}
