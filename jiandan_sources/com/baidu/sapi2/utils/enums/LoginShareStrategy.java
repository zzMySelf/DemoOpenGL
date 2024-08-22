package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum LoginShareStrategy {
    DISABLED("disabled"),
    CHOICE("choice");
    
    public String mStrValue;

    /* access modifiers changed from: public */
    LoginShareStrategy(String str) {
        this.mStrValue = str;
    }

    public static LoginShareStrategy getDefault() {
        return CHOICE;
    }

    public static LoginShareStrategy mapStrToValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (LoginShareStrategy loginShareStrategy : values()) {
            if (str.equals(loginShareStrategy.getStrValue())) {
                return loginShareStrategy;
            }
        }
        return getDefault();
    }

    public String getStrValue() {
        return this.mStrValue;
    }
}
