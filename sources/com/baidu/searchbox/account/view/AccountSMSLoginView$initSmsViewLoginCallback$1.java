package com.baidu.searchbox.account.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import com.baidu.android.app.account.BoxLoginBridge;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.devices.KeyboardUtils;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ISmsLoginViewListener;
import com.baidu.searchbox.account.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/account/view/AccountSMSLoginView$initSmsViewLoginCallback$1", "Lcom/baidu/sapi2/callback/SmsViewLoginCallback;", "onCheckCodeViewHide", "", "onCheckCodeViewShow", "onFailure", "webAuthResult", "Lcom/baidu/sapi2/shell/result/WebAuthResult;", "onNeedBack", "onSuccess", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountSMSLoginView.kt */
public final class AccountSMSLoginView$initSmsViewLoginCallback$1 extends SmsViewLoginCallback {
    final /* synthetic */ AccountSMSLoginView this$0;

    AccountSMSLoginView$initSmsViewLoginCallback$1(AccountSMSLoginView $receiver) {
        this.this$0 = $receiver;
    }

    public void onCheckCodeViewShow() {
        ISmsLoginViewListener smsLoginViewListener = this.this$0.getSmsLoginViewListener();
        if (smsLoginViewListener != null) {
            smsLoginViewListener.onCheckCodeViewShow();
        }
    }

    public void onCheckCodeViewHide() {
        ISmsLoginViewListener smsLoginViewListener = this.this$0.getSmsLoginViewListener();
        if (smsLoginViewListener != null) {
            smsLoginViewListener.onCheckCodeViewHide();
        }
    }

    public void onNeedBack(WebAuthResult webAuthResult) {
        Window window;
        View decorView;
        Context context = this.this$0.getContext();
        Context context2 = this.this$0.getContext();
        Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
        KeyboardUtils.forceHiddenSoftInput(context, (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : decorView.getWindowToken());
        boolean z = true;
        if (webAuthResult != null && webAuthResult.getResultCode() == 100073) {
            onFailure(webAuthResult);
            return;
        }
        String message = this.this$0.getContext().getResources().getString(R.string.account_login_dialog_needback_other);
        Intrinsics.checkNotNullExpressionValue(message, "context.resources.getStr…in_dialog_needback_other)");
        String btnText = this.this$0.getContext().getResources().getString(R.string.account_login_dialog_needback_positive_btn_login);
        Intrinsics.checkNotNullExpressionValue(btnText, "context.resources.getStr…dback_positive_btn_login)");
        if (webAuthResult == null || webAuthResult.getResultCode() != 12) {
            z = false;
        }
        if (z) {
            String string = this.this$0.getContext().getResources().getString(R.string.account_login_dialog_needback_phone);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…in_dialog_needback_phone)");
            message = string;
            String string2 = this.this$0.getContext().getResources().getString(R.string.account_login_dialog_needback_positive_btn_register);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…ck_positive_btn_register)");
            btnText = string2;
        }
        new BoxAlertDialog.Builder(this.this$0.getContext()).setTitle((CharSequence) this.this$0.getContext().getResources().getString(R.string.account_login_dialog_needback_title)).setMessage(message).setPositiveButton((CharSequence) btnText, (DialogInterface.OnClickListener) new AccountSMSLoginView$initSmsViewLoginCallback$1$$ExternalSyntheticLambda0(this.this$0)).setNegativeButton((CharSequence) this.this$0.getContext().getResources().getString(R.string.bdbox_scheme_version_not_match_cancel), (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: onNeedBack$lambda-0  reason: not valid java name */
    public static final void m14699onNeedBack$lambda0(AccountSMSLoginView this$02, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        ISmsLoginViewListener smsLoginViewListener = this$02.getSmsLoginViewListener();
        if (smsLoginViewListener != null) {
            smsLoginViewListener.onRegister();
        }
        BoxLoginBridge.DialogLoginListener loginDialogListener = this$02.getLoginDialogListener();
        if (loginDialogListener != null) {
            loginDialogListener.switchLoginWithPhone(0, false, this$02.getLoginPhoneNumber());
        }
    }

    public void onSuccess(WebAuthResult webAuthResult) {
        BoxLoginBridge.DialogLoginListener loginDialogListener = this.this$0.getLoginDialogListener();
        if (loginDialogListener != null) {
            loginDialogListener.onSuccess(webAuthResult);
        }
    }

    public void onFailure(WebAuthResult webAuthResult) {
        if (webAuthResult != null) {
            WebAuthResult webAuthResult2 = webAuthResult;
            HashMap<Integer, String> hashMap = BoxAccountManager.webAuthErrors;
            Intrinsics.checkNotNullExpressionValue(hashMap, "webAuthErrors");
            hashMap.put(Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg());
        }
        BoxLoginBridge.DialogLoginListener loginDialogListener = this.this$0.getLoginDialogListener();
        if (loginDialogListener != null) {
            loginDialogListener.onFailure(webAuthResult);
        }
    }
}
