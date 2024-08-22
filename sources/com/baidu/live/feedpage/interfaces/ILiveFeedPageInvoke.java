package com.baidu.live.feedpage.interfaces;

import android.content.Context;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.searchbox.live.interfaces.service.bd.IBaiduNewHomeInterface;
import com.baidu.searchbox.live.interfaces.service.bd.IBottomBarInterface;

public interface ILiveFeedPageInvoke {
    IBottomBarInterface buildBottomBarInstance();

    IBaiduNewHomeInterface buildNewHomeInstance();

    void cancelToast(Context context);

    String getCuid();

    String getIID();

    String getUIMode();

    String getUK();

    void invokeScheme(Context context, String str);

    boolean isLogin();

    void login(Context context, AccountManagerService.LoginResultListener loginResultListener);

    void showToast(Context context, String str);
}
