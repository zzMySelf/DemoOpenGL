package com.baidu.webkit.internal.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/* compiled from: UrlHandler */
public abstract class g {
    public abstract boolean a(Context context, String str);

    protected static boolean a(Context context, Intent intent) {
        intent.addFlags(268435456);
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivity(intent);
                return true;
            }
        } catch (ActivityNotFoundException e2) {
            Toast.makeText(context, context.getResources().getIdentifier("sailor_msg_activity_not_found", "string", context.getPackageName()), 0).show();
        } catch (SecurityException e3) {
            Toast.makeText(context, context.getResources().getIdentifier("sailor_msg_activity_not_found", "string", context.getPackageName()), 0).show();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }
}
