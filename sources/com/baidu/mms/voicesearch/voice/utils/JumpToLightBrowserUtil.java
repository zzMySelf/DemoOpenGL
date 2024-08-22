package com.baidu.mms.voicesearch.voice.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mms.voicesearch.api.VoiceSearchManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.model.voice.MicAuthorityModel;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.MicPermissionDialog;
import com.baidu.voicesearch.component.common.SharedPreferenceUtil;
import java.net.URLEncoder;
import org.json.JSONObject;

public class JumpToLightBrowserUtil {
    private static final String TAG = "JumpToLightBrowserUtil";

    public static void jumpToLightBrowserActivityWithUrlSuffix(String micAuthorityGuideUrlSuffix) {
        if (micAuthorityGuideUrlSuffix != null || micAuthorityGuideUrlSuffix.length() != 0) {
            jumpToLightBrowserActivityWithUrl(MicAuthorityModel.MIC_GUIDE_URL_PREFIX + micAuthorityGuideUrlSuffix);
        }
    }

    public static void jumpToLightBrowserActivityWithUrl(String micAuthorityGuideUrl) {
        try {
            VoiceSearchManager.getInstance().getVoiceSearchCallback().executeDirectSearch(VoiceSearchManager.getApplicationContext(), new JSONObject("{\"mode\":0,\"intent\":\"intent:#Intent;S.bdsb_light_start_url=" + URLEncoder.encode(micAuthorityGuideUrl, "UTF-8") + ";end\",\"class\":\"com.baidu.searchbox.lightbrowser.LightBrowserActivity\",\"min_v\":\"16786958\",\"tcbox\":{\"vmgdb\":\"0020100208e\"}}"), (Bundle) null);
        } catch (Exception e2) {
        }
    }

    public static void jumpToSpeechSettingActivityWithUrl(String url) {
        try {
            VoiceSearchManager.getInstance().getVoiceSearchCallback().executeDirectSearch(VoiceSearchManager.getApplicationContext(), new JSONObject("{\"mode\":0,\"intent\":\"intent:#Intent;S.bdsb_light_start_url=" + URLEncoder.encode(url, "UTF-8") + ";end\",\"class\":\"com.baidu.searchbox.speech.SpeechSettingActivity\",\"min_v\":\"16786958\",\"tcbox\":{\"vmgdb\":\"0020100208e\"}}"), (Bundle) null);
        } catch (Exception e2) {
        }
    }

    public static boolean jumpToIManagerOrPermissionManagerOnVivo(Context context) {
        if (context == null) {
            return false;
        }
        String iManagerPackageName = SharedPreferenceUtil.getDataFromSharedPreference(context, MicPermissionDialog.KEY_IMANAGER_PACKAGE_NAME, "");
        String iManagerActivityName = SharedPreferenceUtil.getDataFromSharedPreference(context, MicPermissionDialog.KEY_IMANAGER_ACTIVITY_NAME, "");
        String permissionPackageName = SharedPreferenceUtil.getDataFromSharedPreference(context, MicPermissionDialog.KEY_PERMISSION_PACKAGE_NAME, "");
        String permissionActivityName = SharedPreferenceUtil.getDataFromSharedPreference(context, MicPermissionDialog.KEY_PERMISSION_ACTIVITY_NAME, "");
        if (!TextUtils.isEmpty(iManagerActivityName) && !TextUtils.isEmpty(iManagerPackageName) && checkApplication(context, iManagerPackageName) && checkActivity(context, iManagerPackageName, iManagerActivityName)) {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(iManagerPackageName));
            return true;
        } else if (TextUtils.isEmpty(permissionPackageName) || TextUtils.isEmpty(permissionPackageName) || !checkActivity(context, permissionPackageName, permissionActivityName)) {
            return false;
        } else {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.putExtra("packageName", "com.baidu.speechbundle");
            intent.setComponent(new ComponentName(permissionPackageName, permissionActivityName));
            context.startActivity(intent);
            return true;
        }
    }

    private static boolean checkApplication(Context context, String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageName, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    private static boolean checkActivity(Context context, String packageName, String classname) {
        Intent intent = new Intent();
        intent.setClassName(packageName, classname);
        if (context.getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }
}
