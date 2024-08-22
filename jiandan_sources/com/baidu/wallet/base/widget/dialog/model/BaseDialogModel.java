package com.baidu.wallet.base.widget.dialog.model;

import android.view.View;

public class BaseDialogModel extends BaseModel {
    public View.OnClickListener defaultListener;
    public int dialogBackgound = 0;
    public boolean hideButtons = false;
    public boolean hideNegativeBtn = false;
    public boolean hidePositiveBtn = false;
    public boolean hideTitle = false;
    public View.OnClickListener negativeBtnClickListener;
    public CharSequence negativeBtnText;
    public boolean negativeBtnTextBold = true;
    public int negativeBtnTextColor = 0;
    public int negativeBtnTextId;
    public int negativeBtnTextSize = 0;
    public View.OnClickListener positiveBtnClickListener;
    public CharSequence positiveBtnText;
    public boolean positiveBtnTextBold = true;
    public int positiveBtnTextColor = 0;
    public int positiveBtnTextId;
    public int positiveBtnTextSize = 0;
    public CharSequence title;
    public int titleId;
}
