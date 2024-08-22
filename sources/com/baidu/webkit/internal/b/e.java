package com.baidu.webkit.internal.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.webkit.sdk.Log;
import java.net.URISyntaxException;

/* compiled from: NotWebProtocolUrlHandler */
public final class e extends g {
    public final boolean a(Context context, String str) {
        if (str == null || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://")) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                String str2 = parseUri.getPackage();
                if (str2 == null) {
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:".concat(String.valueOf(str2))));
                intent.addCategory("android.intent.category.BROWSABLE");
                return a(context, intent);
            }
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent((ComponentName) null);
            parseUri.setSelector((Intent) null);
            try {
                if (context instanceof Activity) {
                    ((Activity) context).startActivityIfNeeded(parseUri, -1);
                    return true;
                }
            } catch (ActivityNotFoundException e2) {
                Log.printStackTrace(e2);
            } catch (Exception e3) {
                Log.printStackTrace(e3);
            }
            return true;
        } catch (URISyntaxException e4) {
            Log.d(Log.LOG_TAG, "Bad URI " + str + ": " + e4.getMessage());
            return false;
        }
    }
}
