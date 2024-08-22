package com.dxmpay.wallet.base.widget.textfilter;

import android.text.TextUtils;
import java.util.List;

public class NumberEditTextPasteFilter implements IEditTextPasteFilter {
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[0-9]+");
        if (regxParse == null || regxParse.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String next : regxParse) {
            if (!TextUtils.isEmpty(next)) {
                sb.append(next);
            }
        }
        return sb.toString();
    }
}
