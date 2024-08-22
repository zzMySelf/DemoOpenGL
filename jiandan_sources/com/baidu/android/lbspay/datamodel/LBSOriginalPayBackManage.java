package com.baidu.android.lbspay.datamodel;

import com.baidu.android.lbspay.LBSOriginalPayBack;

public class LBSOriginalPayBackManage {
    public LBSOriginalPayBack mOriginalPayBack;

    public static class a {
        public static LBSOriginalPayBackManage a = new LBSOriginalPayBackManage();
    }

    public static LBSOriginalPayBackManage getInstance() {
        return a.a;
    }

    public void originalCallbackResult(String str, String str2, String str3) {
        LBSOriginalPayBack lBSOriginalPayBack = this.mOriginalPayBack;
        if (lBSOriginalPayBack != null) {
            lBSOriginalPayBack.onOriginalPayResult(str, str2, str3);
        }
    }

    public void setOriginalPayBack(LBSOriginalPayBack lBSOriginalPayBack) {
        this.mOriginalPayBack = lBSOriginalPayBack;
    }

    public LBSOriginalPayBackManage() {
    }
}
