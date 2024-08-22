package com.baidu.sapi2.shell.result;

import android.app.Activity;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;

public class WebAuthResult extends SapiResult {
    public static final int ERROR_CODE_CONTEXT_ERROR = 13;
    public static final int ERROR_CODE_NEED_BACK_PHONE_NO_REG = 12;
    public static final String ERROR_MSG_CONTEXT_ERROR = "请先进行登录";
    public static final String ERROR_MSG_NEED_BACK_PHONE_NO_REG = "手机号未注册";
    public AccountType accountType = AccountType.UNKNOWN;
    public Activity activity;
    public boolean isAccountFreeze = false;

    public enum LoginType {
        PHONE_REG("phonereg"),
        LOGIN("login"),
        LOGIN_PROTECT("apilogin"),
        FORCE_BIND("AccountBind"),
        GUIDE_BIND("apibind"),
        SHARE_V1_CHOICE(ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE),
        SHARE_V2_CHOICE(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
        
        public String a;

        /* access modifiers changed from: public */
        LoginType(String str) {
            this.a = str;
        }

        public String getLoginType() {
            return this.a;
        }
    }

    public WebAuthResult() {
        this.msgMap.put(12, ERROR_MSG_NEED_BACK_PHONE_NO_REG);
    }

    public void finishActivity() {
    }

    public void finishActivity(boolean z) {
    }

    public String getLoginType() {
        return SapiUtils.getLoginType();
    }
}
