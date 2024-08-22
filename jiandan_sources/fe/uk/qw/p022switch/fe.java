package fe.uk.qw.p022switch;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.dxmbumptech.glide.module.GlideModule;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* renamed from: fe.uk.qw.switch.fe  reason: invalid package */
public final class fe {
    public final Context qw;

    public fe(Context context) {
        this.qw = context;
    }

    public List<GlideModule> qw() {
        boolean isLoggable = Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.qw.getPackageManager().getApplicationInfo(this.qw.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                boolean isLoggable2 = Log.isLoggable("ManifestParser", 3);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                "Got app info metadata: " + applicationInfo.metaData;
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str)) && Log.isLoggable("ManifestParser", 3)) {
                    "Loaded Glide module: " + str;
                }
            }
            boolean isLoggable3 = Log.isLoggable("ManifestParser", 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
