package com.bun.miitmdid.provider.nubia;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.bun.miitmdid.f0;

@Keep
public class NubiaIdentityImpl {
    @Keep
    public static final String TAG = "NubiaIdentityImpl";
    @Keep
    public static Uri uri = Uri.parse("content://cn.nubia.identity/identity");

    public static Object generalMethod(Context context, String str, @Nullable String str2, String str3, Class<?> cls) {
        Bundle bundle;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                if (acquireContentProviderClient != null) {
                    bundle = acquireContentProviderClient.call(str, str2, (Bundle) null);
                    if (i2 >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    f0.d(TAG, "generalMethod: contentResolver is null");
                    return null;
                }
            } else {
                bundle = context.getContentResolver().call(uri, str, str2, (Bundle) null);
            }
            if (bundle == null) {
                f0.d(TAG, "generalMethod: bundle is null");
                return null;
            } else if (bundle.getInt("code", -1) == 0) {
                f0.c(TAG, "generalMethod: success");
                if (cls == Boolean.class) {
                    return Boolean.valueOf(bundle.getBoolean(str3, false));
                }
                if (cls == String.class) {
                    return bundle.getString(str3, "");
                }
                return null;
            } else {
                String string = bundle.getString("message");
                f0.d(TAG, "generalMethod: failed:" + string);
                return null;
            }
        } catch (Exception e) {
            f0.d(TAG, "generalMethod: Exception: " + e.getMessage());
            return null;
        }
    }

    @Keep
    public static native String getAAID(Context context, String str);

    @Keep
    public static native String getOAID(Context context);

    @Keep
    public static native String getVAID(Context context, String str);

    @Keep
    public static native boolean isSupported(Context context);
}
