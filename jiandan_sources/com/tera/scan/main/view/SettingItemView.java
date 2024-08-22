package com.tera.scan.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.view.layout.UIFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/main/view/SettingItemView;", "Lcom/tera/scan/ui/view/layout/UIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "arrowVisible", "", "show", "", "dividerVisible", "setRightText", "content", "", "setTips", "str", "setTitle", "tipsVisible", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SettingItemView extends UIFrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingItemView(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.view_setting_item, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SettingItemView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "getContext().obtainStyle…tyleable.SettingItemView)");
            String string = obtainStyledAttributes.getString(1);
            String string2 = obtainStyledAttributes.getString(0);
            setTitle(string);
            setTips(string2);
            obtainStyledAttributes.recycle();
        }
        setBackgroundResource(R.drawable.drawable_click_ripple);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void arrowVisible(boolean z) {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(imageView, "iv_arrow");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void dividerVisible(boolean z) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.divider);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "divider");
        _$_findCachedViewById.setVisibility(z ? 0 : 8);
    }

    public final void setRightText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_setting_item_right);
        Intrinsics.checkNotNullExpressionValue(textView, "tv_setting_item_right");
        textView.setVisibility(0);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(imageView, "iv_arrow");
        imageView.setVisibility(8);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_setting_item_tips);
        Intrinsics.checkNotNullExpressionValue(textView2, "tv_setting_item_tips");
        textView2.setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.tv_setting_item_right)).setText(str);
    }

    public final void setTips(@Nullable String str) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_setting_item_tips);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final void setTitle(@Nullable String str) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_setting_item_title);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final void tipsVisible(boolean z) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_setting_item_tips);
        Intrinsics.checkNotNullExpressionValue(textView, "tv_setting_item_tips");
        textView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SettingItemView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }
}
