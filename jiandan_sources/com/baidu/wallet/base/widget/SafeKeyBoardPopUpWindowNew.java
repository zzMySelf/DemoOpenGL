package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import java.util.Objects;

public class SafeKeyBoardPopUpWindowNew extends SafeKeyBoardPopupWindow {
    public ImageButton a;
    public Button btConfirm = ((Button) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_confirm")));

    public SafeKeyBoardPopUpWindowNew(Context context) {
        super(context);
        ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_hide"));
        this.a = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EventBus instance = EventBus.getInstance();
                Objects.requireNonNull(instance);
                EventBus.getInstance().post(new EventBus.Event("hide_keyboard_listener", (Object) null));
            }
        });
    }

    public int getLayoutId() {
        return ResUtils.layout(this.mContext, this.miniMode ? "wallet_base_safekeyboard_popupwindow_new_mini" : "wallet_base_safekeyboard_popupwindow_new");
    }

    public void initKeyNum(boolean z) {
        super.initKeyNum(z);
        SafeKeyBoardEditText safeKeyBoardEditText = this.mySafeEditText;
        if (safeKeyBoardEditText != null) {
            String obj = safeKeyBoardEditText.getEditableText().toString();
            SafeKeyBoardEditText safeKeyBoardEditText2 = this.mySafeEditText;
            if (!(safeKeyBoardEditText2 == null || safeKeyBoardEditText2.getCheckFunc() == null)) {
                this.btConfirm.setEnabled(this.mySafeEditText.getCheckFunc().check(obj));
            }
        }
        this.mySafeEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    SafeKeyBoardPopUpWindowNew.this.btConfirm.setEnabled(false);
                    return;
                }
                String obj = editable.toString();
                SafeKeyBoardEditText safeKeyBoardEditText = SafeKeyBoardPopUpWindowNew.this.mySafeEditText;
                if (safeKeyBoardEditText != null && safeKeyBoardEditText.getCheckFunc() != null) {
                    SafeKeyBoardPopUpWindowNew.this.btConfirm.setEnabled(SafeKeyBoardPopUpWindowNew.this.mySafeEditText.getCheckFunc().check(obj));
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    String charSequence2 = charSequence.toString();
                    SafeKeyBoardEditText safeKeyBoardEditText = SafeKeyBoardPopUpWindowNew.this.mySafeEditText;
                    if (safeKeyBoardEditText != null && safeKeyBoardEditText.getCheckFunc() != null) {
                        SafeKeyBoardPopUpWindowNew.this.btConfirm.setEnabled(SafeKeyBoardPopUpWindowNew.this.mySafeEditText.getCheckFunc().check(charSequence2));
                    }
                }
            }
        });
        this.btConfirm.setOnClickListener(this.mySafeEditText.getOnConfirmListener());
        this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_safekeyboard_numkey_selector"));
    }

    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        super.setSafeEditTet(safeKeyBoardEditText);
        if (this.mySafeEditText != null) {
            String obj = safeKeyBoardEditText.getEditableText().toString();
            if (safeKeyBoardEditText.getCheckFunc() != null) {
                this.btConfirm.setEnabled(safeKeyBoardEditText.getCheckFunc().check(obj));
            }
        }
    }
}
