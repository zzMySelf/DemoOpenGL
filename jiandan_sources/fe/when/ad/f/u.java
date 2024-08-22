package fe.when.ad.f;

import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class u extends w1 {
    public u(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer("D:");
        stringBuffer.append(a(calendar.get(1), 4));
        stringBuffer.append(a(calendar.get(2) + 1, 2));
        stringBuffer.append(a(calendar.get(5), 2));
        stringBuffer.append(a(calendar.get(11), 2));
        stringBuffer.append(a(calendar.get(12), 2));
        stringBuffer.append(a(calendar.get(13), 2));
        int i2 = (calendar.get(15) + calendar.get(16)) / 3600000;
        if (i2 == 0) {
            stringBuffer.append('Z');
        } else if (i2 < 0) {
            stringBuffer.append('-');
            i2 = -i2;
        } else {
            stringBuffer.append('+');
        }
        if (i2 != 0) {
            stringBuffer.append(a(i2, 2));
            stringBuffer.append(ExtendedMessageFormat.QUOTE);
            stringBuffer.append(a(Math.abs((calendar.get(15) + calendar.get(16)) / CometHttpRequestInterceptor.a) - (i2 * 60), 2));
            stringBuffer.append(ExtendedMessageFormat.QUOTE);
        }
        this.f9835uk = stringBuffer.toString();
    }

    public final String a(int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        while (stringBuffer.length() < i3) {
            stringBuffer.insert(0, "0");
        }
        stringBuffer.setLength(i3);
        return stringBuffer.toString();
    }

    public u() {
        this(new GregorianCalendar());
    }
}
