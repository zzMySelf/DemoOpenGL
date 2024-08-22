package fe.th.de.rrr.uk;

import fe.th.de.rrr.fe;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static final String[] f5468ad;

    /* renamed from: de  reason: collision with root package name */
    public static final DateFormat[] f5469de;
    public static final ThreadLocal<DateFormat> qw = new qw();

    public class qw extends ThreadLocal<DateFormat> {
        /* renamed from: qw */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(fe.when);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f5468ad = strArr;
        f5469de = new DateFormat[strArr.length];
    }

    public static Date ad(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = qw.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f5468ad) {
            int length = f5468ad.length;
            for (int i2 = 0; i2 < length; i2++) {
                DateFormat dateFormat = f5469de[i2];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f5468ad[i2], Locale.US);
                    dateFormat.setTimeZone(fe.when);
                    f5469de[i2] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    public static String qw(Date date) {
        return qw.get().format(date);
    }
}
