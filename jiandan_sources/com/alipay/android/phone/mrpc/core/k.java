package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowDateActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k {
    public static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    public static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    public static class a {
        public int a;
        public int b;
        public int c;

        public a(int i2, int i3, int i4) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
        }
    }

    public static long a(String str) {
        int i2;
        int i3;
        int i4;
        a aVar;
        int i5;
        int i6;
        int i7;
        Matcher matcher = a.matcher(str);
        if (matcher.find()) {
            i2 = b(matcher.group(1));
            i4 = c(matcher.group(2));
            i3 = d(matcher.group(3));
            aVar = e(matcher.group(4));
        } else {
            Matcher matcher2 = b.matcher(str);
            if (matcher2.find()) {
                i4 = c(matcher2.group(1));
                int b2 = b(matcher2.group(2));
                a e = e(matcher2.group(3));
                i3 = d(matcher2.group(4));
                i2 = b2;
                aVar = e;
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (i3 >= 2038) {
            i7 = 1;
            i6 = 0;
            i5 = 2038;
        } else {
            i7 = i2;
            i6 = i4;
            i5 = i3;
        }
        Time time = new Time("UTC");
        time.set(aVar.c, aVar.b, aVar.a, i7, i6, i5);
        return time.toMillis(false);
    }

    public static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    public static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int d(String str) {
        if (str.length() != 2) {
            return str.length() == 3 ? ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900 : str.length() == 4 ? ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0') : DxmShowDateActivity.START_YEAR;
        }
        int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
        return charAt >= 70 ? charAt + 1900 : charAt + 2000;
    }

    public static a e(String str) {
        int i2;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i2 = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i2 = 1;
        }
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1 + 1;
        return new a(charAt, ((str.charAt(i3) - '0') * 10) + (str.charAt(i4) - '0'), ((str.charAt(i5) - '0') * 10) + (str.charAt(i5 + 1) - '0'));
    }
}
