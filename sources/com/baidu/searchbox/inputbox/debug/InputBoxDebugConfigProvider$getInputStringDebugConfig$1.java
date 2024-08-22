package com.baidu.searchbox.inputbox.debug;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.searchbox.debug.data.ViewFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/inputbox/debug/InputBoxDebugConfigProvider$getInputStringDebugConfig$1", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "fetchView", "Landroid/view/View;", "context", "Landroid/content/Context;", "lib-inputbox-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputBoxDebugConfigProvider.kt */
public final class InputBoxDebugConfigProvider$getInputStringDebugConfig$1 implements ViewFetcher {
    final /* synthetic */ String $key;
    final /* synthetic */ String $keyConfig;
    final /* synthetic */ String $titleTxt;

    InputBoxDebugConfigProvider$getInputStringDebugConfig$1(String $titleTxt2, String $key2, String $keyConfig2) {
        this.$titleTxt = $titleTxt2;
        this.$key = $key2;
        this.$keyConfig = $keyConfig2;
    }

    public View fetchView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView avaStrTV = new TextView(context);
        avaStrTV.setText(this.$titleTxt);
        avaStrTV.setTextColor(-16777216);
        linearLayout.addView(avaStrTV);
        EditText avaStrET = new EditText(context);
        LinearLayout.LayoutParams avaStrETLP = new LinearLayout.LayoutParams(-2, -2);
        avaStrETLP.weight = 1.0f;
        linearLayout.addView(avaStrET, avaStrETLP);
        avaStrET.setText(InputBoxDebugConfigKt.getStringConfig(this.$key, ""));
        CheckBox avaStrCB = new CheckBox(context);
        avaStrCB.setChecked(InputBoxDebugConfigKt.getBooleanConfig(this.$keyConfig, false));
        avaStrCB.setOnCheckedChangeListener(new InputBoxDebugConfigProvider$getInputStringDebugConfig$1$$ExternalSyntheticLambda0(this.$keyConfig, avaStrET, context, this.$key));
        linearLayout.addView(avaStrCB);
        avaStrET.addTextChangedListener(new InputBoxDebugConfigProvider$getInputStringDebugConfig$1$fetchView$2(avaStrCB));
        return linearLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchView$lambda-0  reason: not valid java name */
    public static final void m20404fetchView$lambda0(String $keyConfig2, EditText $avaStrET, Context $context, String $key2, CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter($keyConfig2, "$keyConfig");
        Intrinsics.checkNotNullParameter($avaStrET, "$avaStrET");
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($key2, "$key");
        InputBoxDebugConfigKt.setBooleanConfig($keyConfig2, isChecked);
        if (isChecked) {
            String s = $avaStrET.getText().toString();
            try {
                Toast.makeText($context, "设置成功", 0).show();
                InputBoxDebugConfigKt.setStringConfig($key2, s);
            } catch (Exception e2) {
                Toast.makeText($context, "设置失败", 0).show();
            }
        }
    }
}
