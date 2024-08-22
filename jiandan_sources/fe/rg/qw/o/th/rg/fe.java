package fe.rg.qw.o.th.rg;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.o.ad;
import java.util.List;

public class fe implements ResourceDecoder<Uri, Drawable> {
    public final Context qw;

    public fe(Context context) {
        this.qw = context.getApplicationContext();
    }

    @Nullable
    /* renamed from: de */
    public Resource<Drawable> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        int th2 = th(uri);
        String authority = uri.getAuthority();
        return de.fe(qw.ad(this.qw, authority.equals(this.qw.getPackageName()) ? this.qw : fe(uri, authority), th2));
    }

    @NonNull
    public final Context fe(Uri uri, String str) {
        try {
            return this.qw.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    /* renamed from: rg */
    public boolean qw(@NonNull Uri uri, @NonNull ad adVar) {
        return uri.getScheme().equals("android.resource");
    }

    @DrawableRes
    public final int th(Uri uri) {
        Integer num;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            String str = pathSegments.get(1);
            num = Integer.valueOf(this.qw.getResources().getIdentifier(str, pathSegments.get(0), authority));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    num = Integer.valueOf(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            num = null;
        }
        if (num == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        } else if (num.intValue() != 0) {
            return num.intValue();
        } else {
            throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
        }
    }
}
