package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sofire.b.d;
import com.baidu.sofire.d.b;
import com.baidu.sofire.l.e;
import com.baidu.sofire.l.w;

public class MyProvider extends ContentProvider {
    public static boolean a = false;

    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        public void run() {
            d.a(MyProvider.this.getContext().getApplicationContext(), this.a);
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        String callingPackage;
        try {
            if ((Build.VERSION.SDK_INT >= 19 && (callingPackage = getCallingPackage()) != null && !callingPackage.equals(getContext().getApplicationContext().getPackageName())) || TextUtils.isEmpty(str)) {
                return null;
            }
            if ("setAgreePolicy".equals(str)) {
                w.a(getContext().getApplicationContext()).a((Runnable) new a(bundle.getBoolean("_agree_policy", true)));
                bundle2 = new Bundle();
                bundle2.putBoolean("handle_flag", true);
            } else if ("CallPreferences".equals(str)) {
                bundle2 = com.baidu.sofire.j.a.a(getContext().getApplicationContext()).a(bundle);
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean("handle_flag", true);
            } else if (str.startsWith("sub_process_")) {
                Bundle a2 = b.a(str, bundle);
                if (a2 == null) {
                    a2 = new Bundle();
                }
                bundle2.putBoolean("handle_flag", true);
            } else if ("getRemoteZid".equals(str)) {
                String a3 = e.a(getContext().getApplicationContext());
                Bundle bundle3 = new Bundle();
                if (!TextUtils.isEmpty(a3)) {
                    bundle3.putString("_zid", a3);
                }
                bundle3.putBoolean("handle_flag", true);
                bundle2 = bundle3;
            } else if ("callbackGzfi".equals(str)) {
                d.a(getContext().getApplicationContext(), bundle);
                bundle2 = null;
            } else {
                bundle2 = d.a(getContext().getApplicationContext(), str, bundle);
            }
            if (bundle2 != null) {
                bundle2.putString("server_version", "3.6.7.0");
            }
            return bundle2;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        a = true;
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
