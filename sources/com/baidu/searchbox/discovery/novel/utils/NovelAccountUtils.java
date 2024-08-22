package com.baidu.searchbox.discovery.novel.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;

public class NovelAccountUtils {
    private NovelAccountUtils() {
    }

    public static boolean isLogin(Context context) {
        BoxAccountManager boxAccountManager = getBoxAccountManager(context);
        if (boxAccountManager != null) {
            return boxAccountManager.isLogin(2);
        }
        return false;
    }

    public static boolean isGuestLogin(Context context) {
        BoxAccountManager boxAccountManager = getBoxAccountManager(context);
        if (boxAccountManager != null) {
            return boxAccountManager.isGuestLogin();
        }
        return false;
    }

    public static BoxAccountManager getBoxAccountManager(Context context) {
        return (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
    }

    public static BoxAccount getBoxAccount(Context context) {
        BoxAccountManager boxAccountManager = getBoxAccountManager(context);
        if (boxAccountManager != null) {
            return boxAccountManager.getBoxAccount();
        }
        return null;
    }

    public static String getUid(Context context) {
        try {
            BoxAccount boxAccount = getBoxAccount(context);
            if (boxAccount != null) {
                return boxAccount.uid;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getUid(Context context, String defaultValue) {
        String uid = getUid(context);
        if (!TextUtils.isEmpty(uid)) {
            return uid;
        }
        return defaultValue;
    }

    public static String getSession(Context context) {
        BoxAccountManager boxAccountManager = getBoxAccountManager(context);
        if (boxAccountManager != null) {
            return boxAccountManager.getSession("BoxAccount_bduss");
        }
        return null;
    }
}
