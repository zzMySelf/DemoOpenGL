package com.baidu.searchbox.hissug.data.utils.debug;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.baidu.searchbox.debug.data.ViewFetcher;
import com.baidu.searchbox.search.debug.SearchDebugConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/hissug/data/utils/debug/HissugDebugConfigProvider$getMultiRadioDebugConfig$1", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "fetchView", "Landroid/view/View;", "context", "Landroid/content/Context;", "lib_hissug_data_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HissugDebugConfigProvider.kt */
public final class HissugDebugConfigProvider$getMultiRadioDebugConfig$1 implements ViewFetcher {
    final /* synthetic */ String $key;
    final /* synthetic */ HashMap<String, Integer> $map;
    final /* synthetic */ String $titleTxt;

    HissugDebugConfigProvider$getMultiRadioDebugConfig$1(String $titleTxt2, String $key2, HashMap<String, Integer> $map2) {
        this.$titleTxt = $titleTxt2;
        this.$key = $key2;
        this.$map = $map2;
    }

    public View fetchView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(16);
        TextView title = new TextView(context);
        title.setText(this.$titleTxt);
        title.setGravity(17);
        title.setTextColor(-16777216);
        linearLayout.addView(title, -2, -1);
        RadioGroup radioGroup = new RadioGroup(context);
        LinearLayout.LayoutParams radioParams = new LinearLayout.LayoutParams(-1, -2);
        radioParams.rightMargin = 10;
        radioGroup.setOrientation(0);
        radioGroup.setLayoutParams(radioParams);
        radioGroup.setGravity(GravityCompat.END);
        int config = SearchDebugConfig.getIntConfig(this.$key, Integer.MIN_VALUE);
        for (Map.Entry entry : this.$map.entrySet()) {
            int entryValue = ((Number) entry.getValue()).intValue();
            RadioButton btn = new RadioButton(context);
            btn.setText((String) entry.getKey());
            btn.setTextColor(-16777216);
            radioGroup.addView(btn);
            if (config == entryValue) {
                btn.setChecked(true);
            }
            btn.setOnCheckedChangeListener(new HissugDebugConfigProvider$getMultiRadioDebugConfig$1$$ExternalSyntheticLambda0(this.$key, entryValue));
        }
        linearLayout.addView(radioGroup);
        return linearLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchView$lambda-0  reason: not valid java name */
    public static final void m19886fetchView$lambda0(String $key2, int $entryValue, CompoundButton buttonView, boolean isChecked) {
        Intrinsics.checkNotNullParameter($key2, "$key");
        if (isChecked) {
            SearchDebugConfig.setIntConfig($key2, $entryValue);
        }
    }
}
