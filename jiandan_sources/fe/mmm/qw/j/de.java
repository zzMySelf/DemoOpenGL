package fe.mmm.qw.j;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

public class de {
    public Uri ad(Context context, String str) {
        return qw(context, new File(str));
    }

    public Uri qw(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".nestdiskFileprovider", file);
    }
}
