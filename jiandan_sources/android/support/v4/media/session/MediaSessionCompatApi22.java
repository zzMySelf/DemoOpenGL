package android.support.v4.media.session;

import android.media.session.MediaSession;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
public class MediaSessionCompatApi22 {
    public static void setRatingType(Object obj, int i2) {
        ((MediaSession) obj).setRatingType(i2);
    }
}
