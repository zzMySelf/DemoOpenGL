package com.baidu.wallet.utils;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.alipay.sdk.m.s.a;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class StringUtil {
    public static final Pattern AcceptUrlPat = Pattern.compile("^(https?://|file:///android_asset/).*");
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static Pattern b = Pattern.compile("(.*)<color=#?((?:\\d|[a-f]){3,8})>(\\d+)</color>(.*)", 2);
    public static WeakReference<Paint> c = new WeakReference<>((Object) null);

    public static String a(byte b2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a[(b2 >> 4) & 15]);
        sb.append(a[b2 & Ascii.SI]);
        return sb.toString();
    }

    public static String arrayToString(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (i2 < 0 || bArr.length < i2) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if (i4 > bArr.length) {
            i4 = bArr.length;
        }
        while (i2 < i4) {
            sb.append(a(bArr[i2]));
            i2++;
        }
        return sb.toString();
    }

    public static String getHexColorStr(int i2) {
        return Bank.HOT_BANK_LETTER + Integer.toHexString((i2 & 255) | (-16777216 & i2) | (16711680 & i2) | (65280 & i2));
    }

    public static float getStringWidth(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        Paint paint = (Paint) c.get();
        if (paint == null) {
            paint = new Paint();
            c = new WeakReference<>(paint);
        }
        paint.setTextSize(f);
        return paint.measureText(str);
    }

    public static CharSequence parseColorString(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = b.matcher(charSequence);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (matcher.matches()) {
            spannableStringBuilder.append(matcher.group(1));
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(a(matcher.group(2)));
            String group = matcher.group(3);
            spannableStringBuilder.append(group);
            spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - group.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(matcher.group(4));
        } else {
            spannableStringBuilder.append(charSequence);
        }
        return spannableStringBuilder;
    }

    public static String urlParam2JsonStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return com.baidu.android.common.others.lang.StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder(com.baidu.android.common.others.lang.StringUtil.ARRAY_START);
        for (String split : str.split(a.n)) {
            String[] split2 = split.split("=");
            if (!TextUtils.isEmpty(split2[0])) {
                sb.append(split2[0]);
                sb.append(":\"");
                if (2 == split2.length) {
                    sb.append(split2[1]);
                }
                sb.append("\",");
            }
        }
        sb.setCharAt(sb.length() - 1, ExtendedMessageFormat.END_FE);
        return sb.toString();
    }

    public static int a(String str) {
        int i2;
        int i3;
        int i4 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i5 = 255;
        String lowerCase = str.toLowerCase();
        try {
            String substring = lowerCase.substring(0, 2);
            String substring2 = lowerCase.substring(2, 4);
            String substring3 = lowerCase.substring(4, 6);
            String substring4 = lowerCase.substring(6, 8);
            i5 = Integer.valueOf(substring, 16).intValue();
            i3 = Integer.valueOf(substring2, 16).intValue();
            try {
                i2 = Integer.valueOf(substring3, 16).intValue();
                try {
                    i4 = Integer.valueOf(substring4, 16).intValue();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i2 = 0;
                return Color.argb(i5, i3, i2, i4);
            }
        } catch (Exception unused3) {
            i3 = 0;
            i2 = 0;
            return Color.argb(i5, i3, i2, i4);
        }
        return Color.argb(i5, i3, i2, i4);
    }
}
