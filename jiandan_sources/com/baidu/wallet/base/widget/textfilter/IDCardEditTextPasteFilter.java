package com.baidu.wallet.base.widget.textfilter;

import java.util.List;

public class IDCardEditTextPasteFilter implements IEditTextPasteFilter {
    public static final String a = "IDCardEditTextPasteFilter";

    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[0-9xX]+");
        StringBuilder sb = new StringBuilder();
        if (regxParse != null && regxParse.size() > 0) {
            for (String append : regxParse) {
                sb.append(append);
            }
        }
        return sb.toString();
    }
}
