package com.baidu.searchbox.favor.sync.util;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;

public class FavorAccountUtil {
    public static final String ANONY_UID = "anony";

    public static String getUid() {
        BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        String uid = "anony";
        BoxAccount account = accountManager.getBoxAccount();
        if (account != null && accountManager.isLogin()) {
            uid = account.getUid();
        }
        if (TextUtils.isEmpty(uid)) {
            return "anony";
        }
        return uid;
    }

    public static String getBDUSS() {
        BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        BoxAccount account = accountManager.getBoxAccount();
        if (account == null || !accountManager.isLogin()) {
            return "";
        }
        return account.getBduss();
    }
}
