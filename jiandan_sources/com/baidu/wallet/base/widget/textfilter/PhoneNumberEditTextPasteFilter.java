package com.baidu.wallet.base.widget.textfilter;

import android.text.TextUtils;

public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {
    public static final String a = "PhoneNumberEditTextPasteFilter";
    public static final String b = "86";

    public String intercept(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.startsWith(b) ? str.substring(2) : str;
    }
}
