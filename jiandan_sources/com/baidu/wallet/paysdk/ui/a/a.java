package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.paysdk.contract.a;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;

public class a extends com.baidu.wallet.paysdk.ui.a implements a.b {
    public SafeKeyBoardEditText.CheckFunc h = new SafeKeyBoardEditText.CheckFunc() {
        public boolean check(String str) {
            if (!TextUtils.isEmpty(str) && str.trim().replace(" ", "").length() >= 9) {
                return true;
            }
            return false;
        }
    };

    public a(Context context) {
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
        a((CharSequence) ResUtils.getString(this.a, "wallet_cashdesk_card_info_error_msg"));
    }

    public CharSequence d() {
        return ResUtils.getString(this.a, "wallet_cashdesk_card_info_title");
    }

    public void e() {
        final PromptDialog promptDialog = new PromptDialog(this.a);
        Context context = this.a;
        promptDialog.setMessage((CharSequence) context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_hint_msg")));
        Context context2 = this.a;
        promptDialog.setTitleText(context2.getString(ResUtils.string(context2, "wallet_cashdesk_card_info_hint_title")));
        promptDialog.hideNegativeButton();
        promptDialog.setPositiveBtn(ResUtils.string(this.a, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }

    public SafeKeyBoardEditText.CheckFunc f() {
        return this.h;
    }

    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        safeKeyBoardEditText.setHint(ResUtils.string(this.a, "wallet_cashdesk_card_info_input_hint"));
        safeKeyBoardEditText.setUseSafeKeyBoard(true);
        safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
        ((DivisionEditText) safeKeyBoardEditText).setViewType(25);
        safeKeyBoardEditText.addEditTextPasteFilter(new IDCardEditTextPasteFilter());
    }
}
