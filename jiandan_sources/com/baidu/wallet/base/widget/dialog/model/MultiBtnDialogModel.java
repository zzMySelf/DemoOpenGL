package com.baidu.wallet.base.widget.dialog.model;

import android.view.View;

public class MultiBtnDialogModel extends BaseModel {
    public View.OnClickListener defaultClickListener;
    public View.OnClickListener firstBtnClickListener;
    public String firstBtnText;
    public boolean firstBtnTextBold = false;
    public int firstBtnTextId;
    public CharSequence message;
    public int messageId;
    public View.OnClickListener secondBtnClickListener;
    public String secondBtnText;
    public boolean secondBtnTextBold = false;
    public int secondBtnTextId;
    public View.OnClickListener thirdBtnClickListener;
    public String thirdBtnText;
    public boolean thirdBtnTextBold = false;
    public int thirdBtnTextId;
    public int titleId;
    public String titleText;
}
