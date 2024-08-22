package com.baidu.searchbox.inputbox.debug;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InputBoxDebugConfigProvider$getInputDebugConfig$1$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ CheckBox f$4;
    public final /* synthetic */ Context f$5;
    public final /* synthetic */ String f$6;

    public /* synthetic */ InputBoxDebugConfigProvider$getInputDebugConfig$1$$ExternalSyntheticLambda0(String str, EditText editText, int i2, int i3, CheckBox checkBox, Context context, String str2) {
        this.f$0 = str;
        this.f$1 = editText;
        this.f$2 = i2;
        this.f$3 = i3;
        this.f$4 = checkBox;
        this.f$5 = context;
        this.f$6 = str2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        InputBoxDebugConfigProvider$getInputDebugConfig$1.m20403fetchView$lambda0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, compoundButton, z);
    }
}
