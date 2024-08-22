package com.dxmpay.wallet.base.widget.textfilter;

import android.text.TextUtils;

public class BlankCharEditTextPasteFilter implements IEditTextPasteFilter {
    public String intercept(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replaceAll("\\s", "");
        }
        return "";
    }
}
