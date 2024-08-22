package com.baidu.searchbox.menu.login;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import com.baidu.searchbox.account.component.IAccountComponentCallback;
import java.util.List;

public interface LoginMenuPresenter {
    public static final String KEY_NICKNAME = "nick_name";
    public static final String KEY_PORTRAIT_URL = "potrait_url";

    Bundle getLoginInfo(List<String> list);

    void getQuickLoginView(Context context, int i2, AccountComponentConfig accountComponentConfig, IAccountComponentCallback iAccountComponentCallback);

    boolean isLogin();
}
