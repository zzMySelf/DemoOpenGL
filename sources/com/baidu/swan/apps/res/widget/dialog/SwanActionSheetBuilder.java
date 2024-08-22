package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;

public class SwanActionSheetBuilder extends SwanAppAlertDialog.Builder {
    private Context mContext;

    public SwanActionSheetBuilder(Context context) {
        super(context);
        this.mContext = context;
    }

    public SwanAppAlertDialog create() {
        this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams btnPanelLayoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
        btnPanelLayoutParams.addRule(12);
        this.mDialogElement.mBtnPanelLayout.setLayoutParams(btnPanelLayoutParams);
        RelativeLayout.LayoutParams dividerLayoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.aiapps_action_sheet_bottom_divider));
        dividerLayoutParams.addRule(2, this.mDialogElement.mBtnPanelLayout.getId());
        this.mDialogElement.mDivider2.setLayoutParams(dividerLayoutParams);
        setDialogDividerColorResource(R.color.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams lvLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        lvLayoutParams.addRule(2, this.mDialogElement.mDivider2.getId());
        this.mDialogElement.mCustomPanel.setLayoutParams(lvLayoutParams);
        return super.create();
    }
}
