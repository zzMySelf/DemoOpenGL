package com.baidu.searchbox.impl;

import android.content.Context;
import com.baidu.searchbox.account.userinfo.AccountUserInfoManager;
import com.baidu.searchbox.menu.login.ioc.IMenuLoginIOC;

public class MenuLoginImpl implements IMenuLoginIOC {
    public void gotoUserHome(Context context, String uid) {
        AccountUserInfoManager.launchUserInfoPage(context, uid, AccountUserInfoManager.UserInfoSrc.KEY_MENU_HEADER);
    }
}
