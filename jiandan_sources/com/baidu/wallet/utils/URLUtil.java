package com.baidu.wallet.utils;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.wallet.core.NoProguard;

public final class URLUtil implements NoProguard {
    public static String clearQuery(@NonNull String str) {
        return Uri.parse(str).buildUpon().clearQuery().toString();
    }

    public static String getHost(@NonNull String str) {
        return Uri.parse(str).getHost();
    }

    public static String wholeUrl(@NonNull String str) {
        return str.length() > 500 ? str.substring(0, 500) : str;
    }
}
