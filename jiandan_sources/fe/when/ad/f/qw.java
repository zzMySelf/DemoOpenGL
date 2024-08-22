package fe.when.ad.f;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class qw {
    public final Pattern qw;

    public qw(String[] strArr) {
        this.qw = Pattern.compile(qw(strArr));
    }

    public String[] ad(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = this.qw.matcher(str);
        int i2 = 0;
        while (matcher.find()) {
            String substring = str.substring(i2, matcher.start());
            if (substring.length() > 0) {
                arrayList.add(substring);
            }
            arrayList.add(matcher.group());
            i2 = matcher.end();
        }
        String substring2 = str.substring(i2, str.length());
        if (substring2.length() > 0) {
            arrayList.add(substring2);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String qw(String[] strArr) {
        StringBuilder sb = new StringBuilder(100);
        for (String append : strArr) {
            sb.append("(");
            sb.append(append);
            sb.append(")|");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
