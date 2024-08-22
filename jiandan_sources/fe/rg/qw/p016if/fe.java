package fe.rg.qw.p016if;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.module.GlideModule;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* renamed from: fe.rg.qw.if.fe  reason: invalid package */
public final class fe {
    public final Context qw;

    public fe(Context context) {
        this.qw = context;
    }

    public static GlideModule ad(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof GlideModule) {
                    return (GlideModule) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (InstantiationException e) {
                de(cls, e);
                throw null;
            } catch (IllegalAccessException e2) {
                de(cls, e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                de(cls, e3);
                throw null;
            } catch (InvocationTargetException e4) {
                de(cls, e4);
                throw null;
            }
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    public static void de(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
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
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(ad(str));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        "Loaded Glide module: " + str;
                    }
                }
            }
            boolean isLoggable3 = Log.isLoggable("ManifestParser", 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
