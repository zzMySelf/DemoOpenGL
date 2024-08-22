package fe.mmm.qw.j;

import android.text.TextUtils;
import com.tera.scan.doc.preview.office.ui.DocTinyFragment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateUtils;

public class fe {
    public static String qw(long j) {
        if (j < 1000) {
            j = 1000;
        }
        String str = "mm:ss";
        String str2 = null;
        if (j < 600000) {
            str = "m:ss";
        } else if (j >= DateUtils.MILLIS_PER_HOUR) {
            if (j < 36000000) {
                str = "H:mm:ss";
            } else if (j < 86400000) {
                str = DocTinyFragment.TIME_FORMAT;
            } else {
                long j2 = j / DateUtils.MILLIS_PER_HOUR;
                j %= DateUtils.MILLIS_PER_HOUR;
                str2 = String.valueOf(j2);
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String format = simpleDateFormat.format(new Date(j));
        if (TextUtils.isEmpty(str2)) {
            return format;
        }
        return str2 + ":" + format;
    }
}
