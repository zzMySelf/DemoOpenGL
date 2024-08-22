package fe.rg.qw.ppp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class qw {
    public static final ConcurrentMap<String, Key> qw = new ConcurrentHashMap();

    @NonNull
    public static String ad(@Nullable PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @NonNull
    public static Key de(@NonNull Context context) {
        String packageName = context.getPackageName();
        Key key = (Key) qw.get(packageName);
        if (key != null) {
            return key;
        }
        Key fe2 = fe(context);
        Key putIfAbsent = qw.putIfAbsent(packageName, fe2);
        return putIfAbsent == null ? fe2 : putIfAbsent;
    }

    @NonNull
    public static Key fe(@NonNull Context context) {
        return new de(ad(qw(context)));
    }

    @Nullable
    public static PackageInfo qw(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            "Cannot resolve info for" + context.getPackageName();
            return null;
        }
    }
}
