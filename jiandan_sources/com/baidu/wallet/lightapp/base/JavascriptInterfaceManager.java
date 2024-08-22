package com.baidu.wallet.lightapp.base;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.core.Permission;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public final class JavascriptInterfaceManager {
    public static final Map<String, Permission> a;
    public static String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("dopay", Permission.NONE);
        a.put(LightappBusinessClient.METHOD_INIT_PAY, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_BD_LOGIN, Permission.NONE);
        a.put(LightappBusinessClient.CALL_NATIVE_VOICE, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_DETECT_LIVENESS, Permission.NONE);
        a.put(LightappJsNativeClient.METHOD_CALL_SHARE, Permission.NONE);
        a.put(LightappJsNativeClient.METHOD_CLOSE_WINDOW, Permission.NONE);
        a.put("setTitle", Permission.NONE);
        a.put(LightappBusinessClient.MTD_SET_FULLSCREEN, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_GET_USER_AGENT, Permission.NONE);
        a.put(LightappBusinessClient.MTD_DIGEST, Permission.NONE);
        a.put(LightappBusinessClient.MTD_ENCRYPT, Permission.NONE);
        a.put(LightappBusinessClient.MTD_DECRYPT, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_CALL_QRCODE_SCANNER, Permission.NONE);
        a.put("detectBankCard", Permission.NONE);
        a.put(LightappBusinessClient.METHOD_CALL_CAMERA, Permission.NONE);
        a.put(LightappJsNativeClient.VIEW_CALENDAR_EVENT, Permission.NONE);
        a.put(LightappJsNativeClient.ADJUST_SCREEN_BRIGHTNESS, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_GET_SUPPORT_LIVENESS, Permission.NONE);
        a.put(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, Permission.NONE);
        a.put(LightappJsNativeClient.METHOD_CALL_VIBRATE, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_LOAD_TIME_LINE, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_OFFLINE_INFO, Permission.NONE);
        a.put(LightappBusinessClient.MTD_SAVE_PIC, Permission.NONE);
        a.put(LightappBusinessClient.MTD_SET_SCREEN_VERTICAL, Permission.NONE);
        a.put(LightappBusinessClient.MTD_RPA_PERCEPTIONL, Permission.NONE);
        a.put(LightappBusinessClient.MTD_INSERT_PHONE_NUM_TO_ADDRESS_BOOK, Permission.NONE);
        a.put(LightappJsNativeClient.MW_OPEN_NEW_WEBVIEW, Permission.NONE);
        a.put(LightappJsNativeClient.MW_PRE_LOAD_URL, Permission.NONE);
        a.put(LightappJsNativeClient.MW_PRE_LOAD_EXCEPTION, Permission.NONE);
        a.put(LightappJsNativeClient.MW_HSITORY_GO, Permission.NONE);
        a.put(LightappJsNativeClient.MW_NATIVE_LOG, Permission.NONE);
        a.put(LightappJsNativeClient.MW_CLOSE_TOP_WEBVIEW, Permission.NONE);
        a.put(LightappBusinessClient.MTD_SEND_TO_SMS, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_PERMISSION_STATE, Permission.NONE);
        a.put(LightappJsNativeClient.MW_IS_PRELOADED, Permission.NONE);
        a.put(LightappJsNativeClient.MW_RM_FROM_PRELOAD_POOL, Permission.NONE);
        a.put(LightappJsNativeClient.MW_GET_LANGBRIDGE_HASH_STAMP, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_PERMISSIOM_DIALOG_MSG, Permission.NONE);
        a.put(LightappJsNativeClient.MW_GET_LANGBRIDGE_SETTINGS, Permission.NONE);
        a.put(LightappBusinessClient.MTD_SHOW_TITLE_FLOATVIEW, Permission.NONE);
        a.put(LightappBusinessClient.MTD_CUSTOM_RIGHT_BUTTON, Permission.NONE);
        a.put(LightappBusinessClient.MTD_PERMISSION_UNIVERSAL_SET, Permission.NONE);
        a.put("doRnAuth", Permission.READ_NORMAL);
        a.put("doBindCard", Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_BINDCARD_INDEPENDENT, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_BINDCARD_INITIATIVE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_H5GOBCK, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_H5REFRESH, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_UNREGISTER_H5_GO_BACK, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_H5ClOSE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_UNREGISTER_H5_CLOSE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_UNREGISTER_H5_REFRESH, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_SETMENU, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_LIST_MY_BANK_CARD, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_STATEVENT, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_CUSTOMER_SERVICE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_GET_SUPPORT_LIST, Permission.NONE);
        a.put(LightappBusinessClient.MTD_OPEN_IN_BROWSER, Permission.READ_NORMAL);
        a.put(LightappJsNativeClient.INSERT_CALENDAR_EVENT, Permission.READ_NORMAL);
        a.put(LightappJsNativeClient.SCREEN_CAPTURE_SETTINGS, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_UPLOAD_MSG, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_SETSUBMENU, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, Permission.READ_PRIVATE);
        a.put(LightappJsNativeClient.METHOD_CALL_FILE_FETCH, Permission.READ_PRIVATE);
        a.put("getPayMethod", Permission.READ_PRIVATE);
        a.put("changePayMethod", Permission.READ_PRIVATE);
        a.put("preOrderPay", Permission.READ_PRIVATE);
        a.put("selectPhonefromAdressBook", Permission.READ_PRIVATE);
        a.put(LightappBusinessClient.MTD_CALL_AUTOMATED_SUBMISSION, Permission.READ_PRIVATE);
        a.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, Permission.WRITE);
        a.put(LightappBusinessClient.MTD_END_AUDIO_RECORD, Permission.WRITE);
        a.put("setRnAuthResult", Permission.WRITE);
        a.put("postEvent", Permission.WRITE);
        a.put(LightappJsNativeClient.METHOD_GET_DEVIDE_INFO, Permission.READ_DEVICE);
        a.put(LightappBusinessClient.MTD_CALLPHONEINFO, Permission.READ_DEVICE);
        a.put(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, Permission.READ_DEVICE);
        a.put(LightappBusinessClient.MTD_GO_TO_APP_SETTING, Permission.NONE);
        a.put(LightappBusinessClient.MTD_OPEN_NEW_LIGHT_BRIDGE, Permission.NONE);
        a.put(LightappBusinessClient.MTD_SET_LIGHT_BRIDGE_STYLE, Permission.NONE);
        a.put(LightappBusinessClient.MTD_MESSAGE_FORWARDING, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_ACCEPT_MESSAGE_FROM_LANGBRIDGE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_UNREGISTER_MESSAGE_FROM_LANGBRIDGE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_GOTO_DXM_PAY_SERVICE, Permission.NONE);
    }

    public static boolean isIPAddress(String str) {
        if (!str.matches(regex)) {
            return false;
        }
        String[] split = str.split("\\.");
        int i2 = 0;
        while (i2 < 4) {
            try {
                int parseInt = Integer.parseInt(split[i2]);
                if (parseInt >= 0 && parseInt <= 255) {
                    i2++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    public static boolean verifyPermission(@NonNull URL url, @NonNull String str) {
        return verifyPermission(url, a.get(str));
    }

    public static boolean verifyPermission(@NonNull URL url, @NonNull Permission permission) {
        boolean z = false;
        if (SdkInitResponse.isLangBridgeCheckUrlProtocol()) {
            String protocol = url.getProtocol();
            if (TextUtils.isEmpty(protocol) || !protocol.equals("https")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(url.toString());
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_NOT_HTTPS_URL, arrayList);
                return false;
            }
            String host = url.getHost();
            if (TextUtils.isEmpty(host) || isIPAddress(host)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(url.toString());
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_HOST_IS_IP_ADDRESS, arrayList2);
                return false;
            }
        }
        if (permission == Permission.NONE) {
            return true;
        }
        String host2 = url.getHost();
        int i2 = 0;
        for (Map.Entry next : Domains.getInstance().getDomainsPermissionConfig().entrySet()) {
            if (host2.endsWith((String) next.getKey()) && ((String) next.getKey()).length() > i2) {
                int length = ((String) next.getKey()).length();
                i2 = length;
                z = ((EnumSet) next.getValue()).contains(permission);
            }
        }
        return z;
    }
}
