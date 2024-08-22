package com.baidu.android.lbspay.presenter;

import com.baidu.android.lbspay.activity.LBSTransActivity;

public class LBSTransPresenterFactory {
    public static final String TRANS_AUTH_PRESENTER = "LBSTransAuthPresenter";

    public static class a {
        public static LBSTransPresenterFactory a = new LBSTransPresenterFactory();
    }

    public static LBSTransPresenterFactory getInstance() {
        return a.a;
    }

    public LBSTransPresenter getTransPresenter(LBSTransActivity lBSTransActivity, String str) {
        if (((str.hashCode() == 595313813 && str.equals(TRANS_AUTH_PRESENTER)) ? (char) 0 : 65535) != 0) {
            return null;
        }
        return new LBSTransAuthPresenter(lBSTransActivity);
    }

    public LBSTransPresenterFactory() {
    }
}
