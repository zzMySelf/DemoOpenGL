package com.baidu.searchbox.debug.data;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BR\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\b\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0010R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/debug/data/RadioDebugViewFetcher;", "T", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "title", "", "radios", "", "Lkotlin/Pair;", "initialValue", "valueChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Object;", "createRadioGroup", "Landroid/widget/RadioGroup;", "context", "Landroid/content/Context;", "fetchView", "Landroid/view/View;", "debug-data_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: RadioDebugItemInfo.kt */
final class RadioDebugViewFetcher<T> implements ViewFetcher {
    private final T initialValue;
    /* access modifiers changed from: private */
    public final List<Pair<String, T>> radios;
    private final String title;
    /* access modifiers changed from: private */
    public Function1<? super T, Unit> valueChanged;

    public RadioDebugViewFetcher(String title2, List<? extends Pair<String, ? extends T>> radios2, T initialValue2, Function1<? super T, Unit> valueChanged2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(radios2, "radios");
        Intrinsics.checkNotNullParameter(valueChanged2, "valueChanged");
        this.title = title2;
        this.radios = radios2;
        this.initialValue = initialValue2;
        this.valueChanged = valueChanged2;
    }

    public View fetchView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView titleText = new TextView(context);
        titleText.setText(this.title);
        titleText.setGravity(17);
        linearLayout.addView(titleText);
        linearLayout.addView(createRadioGroup(context));
        return linearLayout;
    }

    private final RadioGroup createRadioGroup(Context context) {
        RadioGroup radioGroup = new RadioGroup(context);
        LinearLayout.LayoutParams radioParams = new LinearLayout.LayoutParams(-1, -2);
        radioParams.rightMargin = 10;
        radioGroup.setOrientation(1);
        radioGroup.setLayoutParams(radioParams);
        radioGroup.setGravity(GravityCompat.START);
        for (Pair pair : this.radios) {
            RadioButton radio = new RadioButton(context);
            radio.setText((CharSequence) pair.getFirst());
            radio.setId(pair.hashCode());
            if (Intrinsics.areEqual(pair.getSecond(), (Object) this.initialValue)) {
                radio.setChecked(true);
            }
            radioGroup.addView(radio);
        }
        radioGroup.setOnCheckedChangeListener(new RadioDebugViewFetcher$createRadioGroup$2(this));
        return radioGroup;
    }
}
