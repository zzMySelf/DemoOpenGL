package com.dxmpay.wallet.base.widget.textfilter;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.android.common.others.IStringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditTextPasteFilterUtils {
    public static final String EDITTEXT_PASTE_INTERCEPTOR_KEY = "textPasteInteceptor";
    public static final String EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR = "\\|";
    public static final String REGX_DIGIT = "[1-9]\\d*[\\.]{0,1}\\d*|0\\.\\d*|\\.\\d*";
    public static final String REGX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static final String REGX_ID = "[0-9xX]+";
    public static final String REGX_NUMBER = "[0-9]+";
    public static final String regxEmailOrPhone = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*|[0-9]+";

    public static String applyEditTextPasteFilters(Context context, List<IEditTextPasteFilter> list) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        String str = "";
        if (clipboardManager == null) {
            return str;
        }
        CharSequence text = clipboardManager.getText();
        if (!TextUtils.isEmpty(text)) {
            str = text.toString();
        }
        if (!TextUtils.isEmpty(str)) {
            for (IEditTextPasteFilter intercept : list) {
                str = intercept.intercept(str);
            }
        }
        return str;
    }

    public static List<IEditTextPasteFilter> parseEditTextPasteFilter(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        return parseEditTextPasteFilter(attributeSet.getAttributeValue((String) null, "textPasteInteceptor"));
    }

    public static List<String> regxParse(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static List<IEditTextPasteFilter> parseEditTextPasteFilter(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.trim().split("\\|");
            String name = EditTextPasteFilterUtils.class.getPackage().getName();
            for (String trim : split) {
                try {
                    Object newInstance = Class.forName(name + IStringUtil.CURRENT_PATH + trim.trim()).newInstance();
                    if (newInstance != null && (newInstance instanceof IEditTextPasteFilter)) {
                        arrayList.add((IEditTextPasteFilter) newInstance);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }
}
