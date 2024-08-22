package fe.mmm.qw.j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class when {
    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String ad(long j, String str) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return new SimpleDateFormat(str).format(instance.getTime());
    }

    public static String qw(long j) {
        return new SimpleDateFormat("yyMMdd", Locale.SIMPLIFIED_CHINESE).format(new Date(j));
    }
}
