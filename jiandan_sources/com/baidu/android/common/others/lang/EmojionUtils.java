package com.baidu.android.common.others.lang;

import android.text.TextUtils;
import java.util.regex.Pattern;

public final class EmojionUtils {
    public static boolean containsEmoji(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66).matcher(str).find();
    }

    public static String removeEmoji(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.trim().replaceAll("([-])", "");
    }
}
