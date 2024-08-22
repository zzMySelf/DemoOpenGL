package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.ui.a;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.dialog.PromptImageDialog;
import com.dxmpay.wallet.base.widget.textfilter.NumberEditTextPasteFilter;

public class c extends a implements a.b {
    public SafeKeyBoardEditText.CheckFunc h = new SafeKeyBoardEditText.CheckFunc() {
        public boolean check(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.trim().length() == 3 || str.trim().length() == 4) {
                return true;
            }
            return false;
        }
    };

    public c(Context context) {
        this.a = context;
    }

    public View a() {
        a(this.a, 0);
        return this.b;
    }

    public void a(String str) {
    }

    public SafeKeyBoardEditText b() {
        return this.e;
    }

    public void c() {
        a((CharSequence) ResUtils.getString(this.a, "ebpay_bank_cvv2_errortip"));
    }

    public CharSequence d() {
        return ResUtils.getString(this.a, "wallet_cashdesk_card_info_cvv2_title");
    }

    public void e() {
        PromptImageDialog promptImageDialog = new PromptImageDialog(this.a);
        promptImageDialog.setCanceledOnTouchOutside(false);
        promptImageDialog.setMessageTemp(ResUtils.string(this.a, "wallet_cashdesk_card_info_cvv2_hint_msg"));
        promptImageDialog.setMessage(ResUtils.string(this.a, "wallet_cashdesk_card_info_cvv2_hint_msg_2"));
        Context context = this.a;
        promptImageDialog.setTitleMessage(context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_cvv2_hint_title")));
        promptImageDialog.setButtonText(ResUtils.string(this.a, "dxm_ebpay_know"));
        promptImageDialog.setImage(ResUtils.drawable(this.a, "wallet_base_help_cvv"));
        promptImageDialog.show();
    }

    public SafeKeyBoardEditText.CheckFunc f() {
        return this.h;
    }

    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        safeKeyBoardEditText.setHint(ResUtils.string(this.a, "wallet_cashdesk_card_info_cvv2_input_hint"));
        safeKeyBoardEditText.setUseSafeKeyBoard(true);
        safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        safeKeyBoardEditText.addEditTextPasteFilter(new NumberEditTextPasteFilter());
    }
}
