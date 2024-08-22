package com.tera.scan.business.textrecognition.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.aiscan.R;
import com.tera.scan.ui.view.layout.UIFrameLayout;
import com.tera.scan.ui.view.widget.UITextView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/business/textrecognition/dialog/OcrResultMenuItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setFreeTimesAndVisible", "", "times", "visible", "", "setMenuIcon", "icon", "setMenuText", "resId", "setRightTopVipStatusVisible", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OcrResultMenuItemView extends ConstraintLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OcrResultMenuItemView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OcrResultMenuItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OcrResultMenuItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.view_ocr_result_menu, this);
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

    public final void setFreeTimesAndVisible(int i2, boolean z) {
        if (z) {
            UITextView uITextView = (UITextView) _$_findCachedViewById(R.id.tv_free_times);
            if (uITextView != null) {
                uITextView.setText(getContext().getString(R.string.free_times, new Object[]{String.valueOf(i2)}));
            }
            UITextView uITextView2 = (UITextView) _$_findCachedViewById(R.id.tv_free_times);
            if (uITextView2 != null) {
                uITextView2.setVisibility(0);
                return;
            }
            return;
        }
        UITextView uITextView3 = (UITextView) _$_findCachedViewById(R.id.tv_free_times);
        if (uITextView3 != null) {
            uITextView3.setVisibility(8);
        }
    }

    public final void setMenuIcon(@DrawableRes int i2) {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_menu_icon);
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public final void setMenuText(@StringRes int i2) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_menu_text);
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public final void setRightTopVipStatusVisible(boolean z) {
        if (z) {
            UIFrameLayout uIFrameLayout = (UIFrameLayout) _$_findCachedViewById(R.id.fl_translate_vip_status);
            if (uIFrameLayout != null) {
                uIFrameLayout.setVisibility(0);
                return;
            }
            return;
        }
        UIFrameLayout uIFrameLayout2 = (UIFrameLayout) _$_findCachedViewById(R.id.fl_translate_vip_status);
        if (uIFrameLayout2 != null) {
            uIFrameLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OcrResultMenuItemView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
