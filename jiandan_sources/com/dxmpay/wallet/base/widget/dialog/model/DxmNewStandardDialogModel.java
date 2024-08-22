package com.dxmpay.wallet.base.widget.dialog.model;

import android.view.View;

public class DxmNewStandardDialogModel extends BaseModel {
    public View.OnClickListener closeBtnClickListener;
    public View.OnClickListener defaultClickListener;
    public String firstBtnBackgroundResource = null;
    public View.OnClickListener firstBtnClickListener;
    public String firstBtnText;
    public boolean hideSecondBtn = false;
    public String message;
    public View.OnClickListener secondBtnClickListener;
    public String secondBtnText;
    public String titleText;

    public interface OnClickCallback {
        void closeBtnClicked();

        void onFirstBtnClicked();

        void onSecondBtnClicked();
    }
}
