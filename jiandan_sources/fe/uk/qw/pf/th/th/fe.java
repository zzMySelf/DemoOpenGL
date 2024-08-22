package fe.uk.qw.pf.th.th;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;
import java.util.List;

public class fe implements ResourceDecoder<Uri, Drawable> {
    public final Context qw;

    public fe(Context context) {
        this.qw = context.getApplicationContext();
    }

    @Nullable
    /* renamed from: de */
    public Resource<Drawable> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        Context fe2 = fe(uri, uri.getAuthority());
        return de.fe(qw.ad(this.qw, fe2, yj(fe2, uri)));
    }

    @NonNull
    public final Context fe(Uri uri, String str) {
        if (str.equals(this.qw.getPackageName())) {
            return this.qw;
        }
        try {
            return this.qw.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.qw.getPackageName())) {
                return this.qw;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    @DrawableRes
    public final int rg(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    @DrawableRes
    public final int th(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, SapiDeviceInfo.OS_TYPE);
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    /* renamed from: uk */
    public boolean qw(@NonNull Uri uri, @NonNull ad adVar) {
        return uri.getScheme().equals("android.resource");
    }

    @DrawableRes
    public final int yj(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return th(context, uri);
        }
        if (pathSegments.size() == 1) {
            return rg(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }
}
