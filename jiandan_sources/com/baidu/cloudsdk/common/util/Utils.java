package com.baidu.cloudsdk.common.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserModel;
import com.alipay.sdk.m.s.a;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class Utils {
    public static JSONObject decodeAsJSONObject(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            for (String split : str.split(a.n)) {
                String[] split2 = split.split("=");
                if (split2 != null && split2.length == 2) {
                    try {
                        jSONObject.put(split2[0], split2[1]);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject getFragmentParams(String str) {
        try {
            return decodeAsJSONObject(new URI(str).getFragment());
        } catch (URISyntaxException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject getQueryParams(String str) {
        try {
            return decodeAsJSONObject(new URI(str).getQuery());
        } catch (URISyntaxException unused) {
            return new JSONObject();
        }
    }

    public static String getQueryString(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            String string = bundle.getString(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(a.n);
                }
                try {
                    sb.append(URLEncoder.encode(str, (String) null));
                    sb.append("=");
                    sb.append(URLEncoder.encode(string, (String) null));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static String getRealPathFromUri(Activity activity, Uri uri) {
        Validator.notNull(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Validator.notNull(uri, "uri");
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("content")) {
            return uri.getPath();
        }
        Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        String string = managedQuery.getString(columnIndexOrThrow);
        managedQuery.close();
        return string;
    }

    public static boolean isActivityExist(Context context, Intent intent) {
        Validator.notNull(context, "context");
        Validator.notNull(intent, "intent");
        if (context.getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNetWorkAvaliable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return activeNetworkInfo.isConnected();
        }
        if (type == 0) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    public static boolean isUrl(Uri uri) {
        String scheme;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https");
    }

    public static String md5(String str) {
        Validator.notNull(str, "str");
        return md5(str.getBytes());
    }

    public static void setBrightness(Dialog dialog, int i2) {
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf((float) i2).floatValue() * 0.003921569f;
        dialog.getWindow().setAttributes(attributes);
    }

    public static <T> boolean isEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static String md5(byte[] bArr) {
        Validator.notNull(bArr, "data");
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return sb.toString();
    }

    public static boolean isEmpty(Bundle bundle) {
        return bundle == null || bundle.isEmpty();
    }
}
