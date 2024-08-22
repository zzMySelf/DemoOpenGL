package com.baidu.sapi2.views.logindialog.callback;

import android.text.SpannableStringBuilder;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.view.LoadingView;

public abstract class QuickLoginDialogCallback implements IQuickLoginDialogCallback {
    public void onDismiss() {
    }

    public void onPreShowAgreement(TextView textView, SpannableStringBuilder spannableStringBuilder) {
    }

    public void onPreShowAgreementWithOperator(TextView textView, String str, SpannableStringBuilder spannableStringBuilder) {
    }

    public void onPreShowDialog(ColorType colorType, LinearLayout linearLayout, TextView textView) {
    }

    public void onPreShowLoading(ColorType colorType, LoadingView loadingView) {
    }

    public void onPreShowLogin(ColorType colorType, QuickLoginType quickLoginType, TextView textView) {
    }
}
