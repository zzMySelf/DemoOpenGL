package fe.mmm.qw.qqq.de;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull
    public static final File ad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(qw(context).getAbsolutePath() + File.separator + ".tempImage");
        file.mkdirs();
        return file;
    }

    @NotNull
    public static final File qw(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb = new StringBuilder();
        String str = null;
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        sb.append(str);
        sb.append(File.separator);
        sb.append("createPdf");
        File file = new File(sb.toString());
        file.mkdirs();
        return file;
    }
}
