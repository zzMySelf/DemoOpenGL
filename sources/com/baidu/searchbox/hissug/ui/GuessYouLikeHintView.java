package com.baidu.searchbox.hissug.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.hissug.R;
import com.baidu.searchbox.hissug.util.ViewPressStateUtilsKt;
import com.baidu.searchbox.hissug.util.common.HisPageSizeUtilsKt;
import com.baidu.searchbox.hissug.util.common.HisResourceUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\bJ\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/hissug/ui/GuessYouLikeHintView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/searchbox/hissug/ui/IView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintImage", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "updateFontSize", "", "updateText", "text", "updateUiTheme", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuessYouLikeHintView.kt */
public final class GuessYouLikeHintView extends LinearLayout implements IView {
    public Map<Integer, View> _$_findViewCache;
    private ImageView hintImage;
    private TextView hintText;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GuessYouLikeHintView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GuessYouLikeHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

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
    public GuessYouLikeHintView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(0);
        setGravity(17);
        ViewPressStateUtilsKt.addPressedState$default(this, true, 0.0f, 2, (Object) null);
        this.hintImage = new ImageView(getContext());
        TextView textView = new TextView(getContext());
        this.hintText = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = this.hintText;
        if (textView2 != null) {
            textView2.setGravity(17);
        }
        TextView textView3 = this.hintText;
        if (textView3 != null) {
            textView3.setText(getResources().getText(R.string.guess_you_like_hint_text));
        }
        updateUiTheme();
        updateFontSize();
        addView(this.hintImage);
        addView(this.hintText);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GuessYouLikeHintView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void updateUiTheme() {
        TextView textView = this.hintText;
        if (textView != null) {
            textView.setTextColor(HisResourceUtilsKt.getTextColor4(getContext()));
        }
        ImageView imageView = this.hintImage;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.search_sug_his_guess_you_like_hide_normal));
        }
    }

    public void updateFontSize() {
        ImageView imageView = this.hintImage;
        if (imageView != null) {
            imageView.setLayoutParams(new LinearLayout.LayoutParams(HisPageSizeUtilsKt.getTitleImageSize(), HisPageSizeUtilsKt.getTitleImageSize()));
        }
        TextView textView = this.hintText;
        if (textView != null) {
            textView.setPadding(getResources().getDimensionPixelSize(R.dimen.search_sug_his_guess_you_like_hide_status_hint_padding_lf), 0, 0, 0);
        }
        TextView textView2 = this.hintText;
        if (textView2 != null) {
            textView2.setTextSize(0, HisPageSizeUtilsKt.getHintTextSize());
        }
    }

    public final void updateText(int text) {
        TextView textView = this.hintText;
        if (textView != null) {
            textView.setText(text);
        }
    }
}
