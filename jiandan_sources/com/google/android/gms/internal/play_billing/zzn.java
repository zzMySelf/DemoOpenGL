package com.google.android.gms.internal.play_billing;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.FormattableUtils;

public final class zzn {
    public static String zza(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj == null) {
                str2 = StringUtil.NULL_STRING;
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e) {
                    String str3 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), e);
                    str2 = "<" + str3 + " threw " + e.getClass().getName() + ">";
                }
            }
            objArr[i3] = str2;
            i3++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i2 >= length2 || (indexOf = str.indexOf(FormattableUtils.SIMPLEST_FORMAT, i4)) == -1) {
                sb.append(str, i4, str.length());
            } else {
                sb.append(str, i4, indexOf);
                sb.append(objArr[i2]);
                i4 = indexOf + 2;
                i2++;
            }
        }
        sb.append(str, i4, str.length());
        if (i2 < length2) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i5 = i2 + 1; i5 < objArr.length; i5++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(objArr[i5]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
