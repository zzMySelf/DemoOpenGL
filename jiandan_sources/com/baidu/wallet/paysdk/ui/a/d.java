package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.view.View;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.ui.a;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;

public class d extends a implements a.b {
    public final Context h;

    /* renamed from: i  reason: collision with root package name */
    public SafeKeyBoardEditText.CheckFunc f3627i;

    public d(Context context) {
        this.h = context;
        final com.baidu.wallet.paysdk.a aVar = new com.baidu.wallet.paysdk.a();
        this.f3627i = new SafeKeyBoardEditText.CheckFunc() {
            public boolean check(String str) {
                return aVar.a(str);
            }
        };
    }

    public View a() {
        a(this.h, 0);
        return this.b;
    }

    public void a(String str) {
    }

    public SafeKeyBoardEditText b() {
        return this.e;
    }

    public void c() {
        a((CharSequence) ResUtils.getString(this.h, "wallet_cashdesk_card_info_id_error_msg"));
    }

    public CharSequence d() {
        return ResUtils.getString(this.h, "wallet_cashdesk_card_info_id_title");
    }

    public void e() {
        final PromptDialog promptDialog = new PromptDialog(this.h);
        Context context = this.h;
        promptDialog.setMessage((CharSequence) context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_id_hint_msg")));
        promptDialog.setCanceledOnTouchOutside(false);
        Context context2 = this.h;
        promptDialog.setTitleText(context2.getString(ResUtils.string(context2, "wallet_cashdesk_card_info_id_hint_title")));
        promptDialog.hideNegativeButton();
        promptDialog.setPositiveBtn(ResUtils.string(this.h, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }

    public SafeKeyBoardEditText.CheckFunc f() {
        return this.f3627i;
    }

    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        safeKeyBoardEditText.setHint(ResUtils.string(this.h, "wallet_cashdesk_card_info_id_input_hint"));
        safeKeyBoardEditText.setUseSafeKeyBoard(true);
        safeKeyBoardEditText.setUseKeyX(true);
        safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        ((DivisionEditText) safeKeyBoardEditText).setViewType(20);
        safeKeyBoardEditText.setInputType(1);
        safeKeyBoardEditText.addEditTextPasteFilter(new IDCardEditTextPasteFilter());
    }
}
