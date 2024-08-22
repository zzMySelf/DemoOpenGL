package com.baidu.searchbox.unifiedtoolbar.elements;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.common.unifiedtoolbar.R;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElement;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarElementOption;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\bJ\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/unifiedtoolbar/elements/GoodsSummaryLeftElement;", "Lcom/baidu/searchbox/unifiedtoolbar/base/BottomBarElement;", "context", "Landroid/content/Context;", "elementOption", "Lcom/baidu/searchbox/unifiedtoolbar/option/BottomBarElementOption;", "(Landroid/content/Context;Lcom/baidu/searchbox/unifiedtoolbar/option/BottomBarElementOption;)V", "remainingColorResourceId", "", "Ljava/lang/Integer;", "remainingContentView", "Landroid/widget/TextView;", "remainingLabelView", "remainingLayout", "Landroid/view/ViewGroup;", "totalContentView", "totalLabelView", "getStatisticTypeClickValue", "", "getStatisticTypeShowValue", "onFontSizeChange", "", "onNightModeChanged", "isNightMode", "", "setRemainingTextColorReal", "setResource", "updateSubtitleColor", "colorResourceId", "updateTotalAndRemainingText", "totalText", "remainingText", "lib-unified-toolbar_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsSummaryLeftElement.kt */
public final class GoodsSummaryLeftElement extends BottomBarElement {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Integer remainingColorResourceId;
    private TextView remainingContentView;
    private TextView remainingLabelView;
    private ViewGroup remainingLayout;
    private TextView totalContentView;
    private TextView totalLabelView;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsSummaryLeftElement(Context context, BottomBarElementOption elementOption) {
        super(context, elementOption);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(elementOption, "elementOption");
        LayoutInflater.from(context).inflate(R.layout.goods_summary_left_layout, this, true);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(0, -1);
        llp.weight = 1.0f;
        setLayoutParams(llp);
        View findViewById = findViewById(R.id.total_label);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.total_label)");
        this.totalLabelView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.total_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.total_content)");
        this.totalContentView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.remaining_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.remaining_layout)");
        this.remainingLayout = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.remaining_label);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.remaining_label)");
        this.remainingLabelView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.remaining_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.remaining_content)");
        this.remainingContentView = (TextView) findViewById5;
        setResource();
    }

    private final void setResource() {
        this.totalLabelView.setTextColor(ResourcesCompat.getColor(getResources(), com.baidu.android.common.ui.style.R.color.GC1, (Resources.Theme) null));
        this.totalContentView.setTextColor(ResourcesCompat.getColor(getResources(), com.baidu.android.common.ui.style.R.color.GC62, (Resources.Theme) null));
        setRemainingTextColorReal();
    }

    private final void setRemainingTextColorReal() {
        if (this.remainingColorResourceId != null) {
            TextView textView = this.remainingLabelView;
            Resources resources = getResources();
            Integer num = this.remainingColorResourceId;
            if (num != null) {
                textView.setTextColor(ResourcesCompat.getColor(resources, num.intValue(), (Resources.Theme) null));
                TextView textView2 = this.remainingContentView;
                Resources resources2 = getResources();
                Integer num2 = this.remainingColorResourceId;
                if (num2 != null) {
                    textView2.setTextColor(ResourcesCompat.getColor(resources2, num2.intValue(), (Resources.Theme) null));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        this.remainingLabelView.setTextColor(ResourcesCompat.getColor(getResources(), com.baidu.android.common.ui.style.R.color.GC105, (Resources.Theme) null));
        this.remainingContentView.setTextColor(ResourcesCompat.getColor(getResources(), com.baidu.android.common.ui.style.R.color.GC105, (Resources.Theme) null));
    }

    public String getStatisticTypeShowValue() {
        return "";
    }

    public String getStatisticTypeClickValue() {
        return "";
    }

    public void onNightModeChanged(boolean isNightMode) {
        setResource();
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        if (this.remainingLayout.getVisibility() == 0) {
            FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalLabelView, 0, R.dimen.trade_price_total_text__normal_size, 0, 4, (Object) null);
            FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalContentView, 0, R.dimen.trade_price_total_text__normal_size, 0, 4, (Object) null);
            FontSizeTextViewExtKt.setScaledSizeRes$default(this.remainingLabelView, 0, R.dimen.trade_price_tip_text_size, 0, 4, (Object) null);
            FontSizeTextViewExtKt.setScaledSizeRes$default(this.remainingContentView, 0, R.dimen.trade_price_tip_text_size, 0, 4, (Object) null);
            return;
        }
        FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalLabelView, 0, R.dimen.trade_price_total_text_big_size, 0, 4, (Object) null);
        FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalContentView, 0, R.dimen.trade_price_total_text_big_size, 0, 4, (Object) null);
    }

    public final void updateTotalAndRemainingText(String totalText, String remainingText) {
        String str = totalText;
        String str2 = remainingText;
        Intrinsics.checkNotNullParameter(str, "totalText");
        Intrinsics.checkNotNullParameter(str2, "remainingText");
        this.totalContentView.setText(str);
        this.remainingContentView.setText(str2);
        if (TextUtils.isEmpty(StringsKt.trim((CharSequence) str2).toString())) {
            this.remainingLayout.setVisibility(8);
            if (isResponseFontSize()) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalLabelView, 0, R.dimen.trade_price_total_text_big_size, 0, 4, (Object) null);
                FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalContentView, 0, R.dimen.trade_price_total_text_big_size, 0, 4, (Object) null);
                return;
            }
            this.totalLabelView.setTextSize(0, getResources().getDimension(R.dimen.trade_price_total_text_big_size));
            this.totalContentView.setTextSize(0, getResources().getDimension(R.dimen.trade_price_total_text_big_size));
            return;
        }
        this.remainingLayout.setVisibility(0);
        if (isResponseFontSize()) {
            FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalLabelView, 0, R.dimen.trade_price_total_text__normal_size, 0, 4, (Object) null);
            FontSizeTextViewExtKt.setScaledSizeRes$default(this.totalContentView, 0, R.dimen.trade_price_total_text__normal_size, 0, 4, (Object) null);
            return;
        }
        this.totalLabelView.setTextSize(0, getResources().getDimension(R.dimen.trade_price_total_text__normal_size));
        this.totalContentView.setTextSize(0, getResources().getDimension(R.dimen.trade_price_total_text__normal_size));
    }

    public final void updateSubtitleColor(int colorResourceId) {
        this.remainingColorResourceId = Integer.valueOf(colorResourceId);
        setRemainingTextColorReal();
    }
}
