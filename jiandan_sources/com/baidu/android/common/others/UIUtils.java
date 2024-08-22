package com.baidu.android.common.others;

import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.wallet.paysdk.datamodel.Bank;

@Deprecated
public class UIUtils {
    public static final int NO_ALPHA_STANDARD = 7;
    public static final int WITH_ALPHA_STANDARD = 9;

    public static int getTextViewHeight(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (!TextUtils.isEmpty(textView.getText())) {
            return (int) (Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent)) + 2.0d);
        }
        return 0;
    }

    public static int getTextViewWidth(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        if (!TextUtils.isEmpty(textView.getText())) {
            return (int) paint.measureText(textView.getText().toString());
        }
        return 0;
    }

    public static boolean isColorValid(Object obj) {
        if (!(obj instanceof String)) {
            return obj instanceof Integer;
        }
        String valueOf = String.valueOf(obj);
        if (!TextUtils.isEmpty(valueOf) && valueOf.startsWith(Bank.HOT_BANK_LETTER) && (valueOf.length() == 7 || valueOf.length() == 9)) {
            return true;
        }
        return false;
    }
}
