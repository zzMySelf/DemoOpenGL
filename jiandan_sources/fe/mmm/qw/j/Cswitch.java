package fe.mmm.qw.j;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

/* renamed from: fe.mmm.qw.j.switch  reason: invalid class name */
public class Cswitch {
    public static SpannableStringBuilder ad(CharSequence charSequence, int i2, boolean z, boolean z2, String... strArr) {
        if (charSequence == null) {
            return null;
        }
        String charSequence2 = charSequence.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (z) {
            charSequence2 = charSequence2.toString().toLowerCase();
        }
        for (String str : strArr) {
            if (z) {
                str = str.toLowerCase();
            }
            int indexOf = charSequence2.indexOf(str);
            if (indexOf >= 0) {
                int length = str.length() + indexOf;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), indexOf, length, 33);
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, length, 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder de(String str, int i2, boolean z, boolean z2, String... strArr) {
        if (str == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (z) {
            str = str.toLowerCase();
        }
        for (String str2 : strArr) {
            if (z) {
                str2 = str2.toLowerCase();
            }
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                int length = str2.length() + indexOf;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), indexOf, length, 33);
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, length, 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder fe(String str, int i2, boolean z, String... strArr) {
        return de(str, i2, z, false, strArr);
    }

    public static int qw(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (!rg(charAt) && Character.isLetter(charAt)) {
                i2 += 2;
            } else {
                i2++;
            }
        }
        return i2;
    }

    public static boolean rg(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }
}
