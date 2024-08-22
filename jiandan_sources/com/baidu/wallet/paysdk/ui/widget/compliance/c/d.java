package com.baidu.wallet.paysdk.ui.widget.compliance.c;

import com.baidu.wallet.paysdk.ui.widget.compliance.view.WheelView;

public interface d {
    void onWheelLoopFinished(WheelView wheelView);

    void onWheelScrollStateChanged(WheelView wheelView, int i2);

    void onWheelScrolled(WheelView wheelView, int i2);

    void onWheelSelected(WheelView wheelView, int i2);
}
