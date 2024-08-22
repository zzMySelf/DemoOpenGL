package com.dxmpay.wallet.utils;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityUtils {
    public static final String SCREEN_READER_INTENT_ACTION = "android.accessibilityservice.AccessibilityService";
    public static final String SCREEN_READER_INTENT_CATEGORY = "android.accessibilityservice.category.FEEDBACK_SPOKEN";
    public static final String TAG = "AccessibilityUtils";

    public static class ad extends AccessibilityDelegateCompat {
        public final /* synthetic */ String qw;

        public ad(String str) {
            this.qw = str;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setRoleDescription(this.qw);
        }
    }

    public static class de extends AccessibilityDelegateCompat {
        public final /* synthetic */ String qw;

        public de(String str) {
            this.qw = str;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setText(this.qw);
        }
    }

    public static class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View f4366ad;

        public qw(View view) {
            this.f4366ad = view;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f4366ad.sendAccessibilityEvent(128);
            }
        }
    }

    public static void changeRoleDescription(View view, String str) {
        ViewCompat.setAccessibilityDelegate(view, new ad(str));
    }

    public static boolean isAccessibilityEnabled(Context context) {
        if (context == null) {
            return false;
        }
        try {
            boolean isEnabled = ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
            boolean isScreenReaderActive = isScreenReaderActive(context);
            if (isEnabled || isScreenReaderActive) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static boolean isAccessibilitySettingsOn(Context context, String str) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isScreenReaderActive(Context context) {
        Intent intent = new Intent(SCREEN_READER_INTENT_ACTION);
        intent.addCategory(SCREEN_READER_INTENT_CATEGORY);
        boolean z = false;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 15) {
                ContentResolver contentResolver = context.getContentResolver();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    Cursor query = contentResolver.query(Uri.parse("content://" + resolveInfo.serviceInfo.packageName + ".providers.StatusProvider"), (String[]) null, (String) null, (String[]) null, (String) null);
                    if (query != null && query.moveToFirst()) {
                        int i3 = query.getInt(0);
                        query.close();
                        if (i3 == 1) {
                            return true;
                        }
                    }
                }
            } else if (i2 >= 26) {
                for (ResolveInfo next : queryIntentServices) {
                    z |= isAccessibilitySettingsOn(context, next.serviceInfo.packageName + "/" + next.serviceInfo.name);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE)) {
                    arrayList.add(runningServiceInfo.service.getPackageName());
                }
                for (ResolveInfo resolveInfo2 : queryIntentServices) {
                    if (arrayList.contains(resolveInfo2.serviceInfo.packageName)) {
                        z |= true;
                    }
                }
            }
        }
        return z;
    }

    public static void requestAccessibilityFocuse(View view) {
        view.postDelayed(new qw(view), 100);
    }

    public static void setAccessibilityFocusable(View view, boolean z) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (z) {
            ViewCompat.setImportantForAccessibility(view, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view, 2);
        }
    }

    public static void setContentDescription(View view, CharSequence charSequence) {
        if (view != null) {
            view.setContentDescription(charSequence);
        }
    }

    public static void setEditTextDescription(View view, String str) {
        ViewCompat.setAccessibilityDelegate(view, new de(str));
    }

    public static void setGroupDescription(View view, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            view.setScreenReaderFocusable(true);
        } else {
            view.setFocusable(true);
        }
        view.setContentDescription(str);
    }
}
