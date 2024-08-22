package com.baidu.browser.components.commonmenu.impl;

import android.content.Context;
import com.baidu.searchbox.menu.font.SliderBar;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommonMenuPanelFont$$ExternalSyntheticLambda0 implements SliderBar.OnSliderBarChangeListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ CommonMenuPanelFont f$1;

    public /* synthetic */ CommonMenuPanelFont$$ExternalSyntheticLambda0(Context context, CommonMenuPanelFont commonMenuPanelFont) {
        this.f$0 = context;
        this.f$1 = commonMenuPanelFont;
    }

    public final void onIndexChanged(SliderBar sliderBar, int i2) {
        CommonMenuPanelFont.m12663initFontSizeSettingPopupWindow$lambda0(this.f$0, this.f$1, sliderBar, i2);
    }
}
