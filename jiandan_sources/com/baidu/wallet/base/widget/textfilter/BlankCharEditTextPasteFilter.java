package com.baidu.wallet.base.widget.textfilter;

import android.text.TextUtils;

public class BlankCharEditTextPasteFilter implements IEditTextPasteFilter {
    public static final String a = "BlankCharEditTextPasteFilter";

    public String intercept(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replaceAll("\\s", "");
        }
        return "";
    }
}
