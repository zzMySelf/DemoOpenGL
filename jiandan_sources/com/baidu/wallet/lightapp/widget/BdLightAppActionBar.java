package com.baidu.wallet.lightapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.wallet.base.widget.BdActionBar;

public class BdLightAppActionBar extends BdActionBar {
    public BdLightAppActionBar(Context context) {
        super(context);
    }

    public String getLayoutId() {
        return "wallet_langbrige_action_bar";
    }

    public void hideLeftZone() {
        this.mLeftImgZone2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mClose.getLayoutParams();
        layoutParams.width = DisplayUtils.dip2px(getContext(), 50.0f);
        this.mClose.setLayoutParams(layoutParams);
        this.mClose.setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, 0, 0);
    }

    public BdLightAppActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BdLightAppActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
