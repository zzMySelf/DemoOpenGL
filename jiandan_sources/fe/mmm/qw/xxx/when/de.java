package fe.mmm.qw.xxx.when;

import android.content.Context;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de {
    @NotNull
    public static final de qw = new de();

    @NotNull
    public final String qw(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = null;
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        File file = new File(str, ShareDirectionType.IMPORT);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return absolutePath;
    }
}
