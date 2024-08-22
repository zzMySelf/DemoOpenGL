package fe.th.ad.de;

import com.duxiaoman.imageloader.statistic.ImageSdkSAListener;
import fe.th.ad.ad;

public class qw {
    public static final ImageSdkSAListener qw = ad.ad().qw();

    public static void ad(String str, String str2) {
        ImageSdkSAListener imageSdkSAListener = qw;
        if (imageSdkSAListener != null) {
            imageSdkSAListener.onGlideFailEvent(str, str2);
        }
    }

    public static void qw(String str, String str2) {
        ImageSdkSAListener imageSdkSAListener = qw;
        if (imageSdkSAListener != null) {
            imageSdkSAListener.onFrescoFailEvent(str, str2);
        }
    }
}
