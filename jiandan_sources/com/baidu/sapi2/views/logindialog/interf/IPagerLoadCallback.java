package com.baidu.sapi2.views.logindialog.interf;

import com.baidu.sapi2.NoProguard;

public interface IPagerLoadCallback extends NoProguard {
    void onChange2LoginPage();

    void onChange2SmsPage(String str, int i2);

    void onPageLoading();

    void onPageShow(int i2);
}
