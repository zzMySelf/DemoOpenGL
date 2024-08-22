package fe.uk.qw.pf.de.when;

import android.net.Uri;
import com.baidubce.services.vod.VodClient;
import com.google.common.net.MediaType;

public final class ad {
    public static boolean ad(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && VodClient.PATH_MEDIA.equals(uri.getAuthority());
    }

    public static boolean de(Uri uri) {
        return ad(uri) && rg(uri);
    }

    public static boolean fe(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    public static boolean qw(Uri uri) {
        return ad(uri) && !rg(uri);
    }

    public static boolean rg(Uri uri) {
        return uri.getPathSegments().contains(MediaType.VIDEO_TYPE);
    }
}
