package com.tera.scan.ui.view.widget.empty;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.aiscan.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.view.helper.UIBaseHelper;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.f.de.de.qw.qw;
import fe.qw.qw.de;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u0007J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u0007J\u001a\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0007H\u0007J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u0007J\u001a\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0007H\u0007J\u0016\u0010(\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010)\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u0007J\u001a\u0010*\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0007H\u0007J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%J6\u0010,\u001a\u00020\u00182\b\b\u0003\u0010-\u001a\u00020\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\n\b\u0002\u00101\u001a\u0004\u0018\u00010/H\u0007J\u0014\u00102\u001a\u00020\u00182\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/tera/scan/ui/view/widget/empty/UIEmptyView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "empty", "Landroid/view/View;", "emptyButton", "Lcom/tera/scan/ui/view/widget/UIButton;", "emptyIcon", "Landroid/widget/ImageView;", "emptyText", "Landroid/widget/TextView;", "emptyTextButton", "loading", "loadingIcon", "loadingLottie", "Lcom/airbnb/lottie/LottieAnimationView;", "loadingText", "hide", "", "setBtnBackgroundColor", "color", "setBtnSize", "width", "height", "setBtnTextColor", "setBtnTextSize", "size", "", "unit", "setButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setDescTextColor", "setDescTextSize", "setEmptyIconSize", "setTextBtnTextColor", "setTextBtnTextSize", "setTextButtonClickListener", "showEmpty", "resId", "desc", "", "btn", "textBtn", "showLoading", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIEmptyView extends RelativeLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    public View empty;
    @Nullable
    public UIButton emptyButton;
    @Nullable
    public ImageView emptyIcon;
    @Nullable
    public TextView emptyText;
    @Nullable
    public TextView emptyTextButton;
    @Nullable
    public View loading;
    @Nullable
    public ImageView loadingIcon;
    @Nullable
    public LottieAnimationView loadingLottie;
    @Nullable
    public TextView loadingText;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIEmptyView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIEmptyView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIEmptyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ui_empty_view, this, false);
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        if (inflate != null) {
            this.loading = inflate.findViewById(R.id.ui_id_loading);
            this.loadingIcon = (ImageView) inflate.findViewById(R.id.ui_id_loading_icon);
            this.loadingLottie = (LottieAnimationView) inflate.findViewById(R.id.ui_id_loading_lottie);
            this.loadingText = (TextView) inflate.findViewById(R.id.ui_id_loading_text);
            this.empty = inflate.findViewById(R.id.ui_id_empty);
            this.emptyIcon = (ImageView) inflate.findViewById(R.id.ui_id_empty_icon);
            this.emptyText = (TextView) inflate.findViewById(R.id.ui_id_empty_text);
            this.emptyButton = (UIButton) inflate.findViewById(R.id.ui_id_empty_button);
            this.emptyTextButton = (TextView) inflate.findViewById(R.id.ui_id_empty_text_button);
            LottieAnimationView lottieAnimationView = this.loadingLottie;
            if (lottieAnimationView != null) {
                lottieAnimationView.addLottieOnCompositionLoadedListener(new qw(this));
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UIEmptyView, i2, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ptyView, defStyleAttr, 0)");
            int qw = fe.mmm.qw.f.ad.qw.qw(121.0f, context);
            setEmptyIconSize(obtainStyledAttributes.getDimensionPixelOffset(8, qw), obtainStyledAttributes.getDimensionPixelOffset(7, qw));
            setDescTextColor(fe.mmm.qw.f.ad.fe.qw.qw.qw(context, obtainStyledAttributes.getResourceId(5, R.color.ui_color_gc2)));
            setDescTextSize$default(this, obtainStyledAttributes.getDimension(6, 14.0f), 0, 2, (Object) null);
            setBtnBackgroundColor(fe.mmm.qw.f.ad.fe.qw.qw.qw(context, obtainStyledAttributes.getResourceId(0, R.color.ui_color_gc36)));
            setBtnSize(obtainStyledAttributes.getDimensionPixelOffset(4, fe.mmm.qw.f.ad.qw.qw(57.0f, context)), obtainStyledAttributes.getDimensionPixelOffset(1, fe.mmm.qw.f.ad.qw.qw(28.0f, context)));
            setBtnTextColor(fe.mmm.qw.f.ad.fe.qw.qw.qw(context, obtainStyledAttributes.getResourceId(2, R.color.ui_color_gc4)));
            setBtnTextSize$default(this, obtainStyledAttributes.getDimension(3, 13.0f), 0, 2, (Object) null);
            setTextBtnTextColor(fe.mmm.qw.f.ad.fe.qw.qw.qw(context, obtainStyledAttributes.getResourceId(9, R.color.ui_color_gc32)));
            setTextBtnTextSize$default(this, obtainStyledAttributes.getDimension(10, 16.0f), 0, 2, (Object) null);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m923lambda1$lambda0(UIEmptyView uIEmptyView, de deVar) {
        Intrinsics.checkNotNullParameter(uIEmptyView, "this$0");
        ImageView imageView = uIEmptyView.loadingIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public static /* synthetic */ void setBtnTextSize$default(UIEmptyView uIEmptyView, float f, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        uIEmptyView.setBtnTextSize(f, i2);
    }

    public static /* synthetic */ void setDescTextSize$default(UIEmptyView uIEmptyView, float f, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        uIEmptyView.setDescTextSize(f, i2);
    }

    public static /* synthetic */ void setTextBtnTextSize$default(UIEmptyView uIEmptyView, float f, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        uIEmptyView.setTextBtnTextSize(f, i2);
    }

    public static /* synthetic */ void showEmpty$default(UIEmptyView uIEmptyView, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = R.drawable.ui_empty_common;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        if ((i3 & 8) != 0) {
            str3 = null;
        }
        uIEmptyView.showEmpty(i2, str, str2, str3);
    }

    public static /* synthetic */ void showLoading$default(UIEmptyView uIEmptyView, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        uIEmptyView.showLoading(str);
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

    public final void hide() {
        LottieAnimationView lottieAnimationView = this.loadingLottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        View view = this.empty;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.loading;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(8);
    }

    public final void setBtnBackgroundColor(@ColorInt int i2) {
        UIBaseHelper<UIButton> helper;
        UIButton uIButton = this.emptyButton;
        if (uIButton != null && (helper = uIButton.getHelper()) != null) {
            helper.b(i2);
        }
    }

    public final void setBtnSize(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        UIButton uIButton = this.emptyButton;
        if (uIButton != null && (layoutParams = uIButton.getLayoutParams()) != null) {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
    }

    public final void setBtnTextColor(@ColorInt int i2) {
        UIButton uIButton = this.emptyButton;
        if (uIButton != null) {
            uIButton.setTextColor(i2);
        }
    }

    @JvmOverloads
    public final void setBtnTextSize(float f) {
        setBtnTextSize$default(this, f, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final void setBtnTextSize(float f, int i2) {
        UIButton uIButton = this.emptyButton;
        if (uIButton != null) {
            uIButton.setTextSize(i2, f);
        }
    }

    public final void setButtonClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        UIButton uIButton = this.emptyButton;
        if (uIButton != null) {
            uIButton.setOnClickListener(onClickListener);
        }
    }

    public final void setDescTextColor(@ColorInt int i2) {
        TextView textView = this.emptyText;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    @JvmOverloads
    public final void setDescTextSize(float f) {
        setDescTextSize$default(this, f, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final void setDescTextSize(float f, int i2) {
        TextView textView = this.emptyText;
        if (textView != null) {
            textView.setTextSize(i2, f);
        }
    }

    public final void setEmptyIconSize(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView = this.emptyIcon;
        if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
    }

    public final void setTextBtnTextColor(@ColorInt int i2) {
        TextView textView = this.emptyTextButton;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    @JvmOverloads
    public final void setTextBtnTextSize(float f) {
        setTextBtnTextSize$default(this, f, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final void setTextBtnTextSize(float f, int i2) {
        TextView textView = this.emptyTextButton;
        if (textView != null) {
            textView.setTextSize(i2, f);
        }
    }

    public final void setTextButtonClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        TextView textView = this.emptyTextButton;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    @JvmOverloads
    public final void showEmpty() {
        showEmpty$default(this, 0, (String) null, (String) null, (String) null, 15, (Object) null);
    }

    @JvmOverloads
    public final void showEmpty(@DrawableRes int i2) {
        showEmpty$default(this, i2, (String) null, (String) null, (String) null, 14, (Object) null);
    }

    @JvmOverloads
    public final void showEmpty(@DrawableRes int i2, @Nullable String str) {
        showEmpty$default(this, i2, str, (String) null, (String) null, 12, (Object) null);
    }

    @JvmOverloads
    public final void showEmpty(@DrawableRes int i2, @Nullable String str, @Nullable String str2) {
        showEmpty$default(this, i2, str, str2, (String) null, 8, (Object) null);
    }

    @JvmOverloads
    public final void showEmpty(@DrawableRes int i2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        ImageView imageView = this.emptyIcon;
        if (imageView != null) {
            fe.mmm.qw.f.ad.fe.qw qwVar = fe.mmm.qw.f.ad.fe.qw.qw;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(qwVar.ad(context, i2));
        }
        TextView textView = this.emptyText;
        if (textView != null) {
            if (str == null) {
                str = getContext().getString(R.string.ui_no_network_retry);
            }
            textView.setText(str);
        }
        UIButton uIButton = this.emptyButton;
        if (uIButton != null) {
            uIButton.setVisibility(str2 == null ? 8 : 0);
        }
        UIButton uIButton2 = this.emptyButton;
        if (uIButton2 != null) {
            uIButton2.setText(str2);
        }
        TextView textView2 = this.emptyTextButton;
        if (textView2 != null) {
            textView2.setVisibility(str3 == null ? 8 : 0);
        }
        TextView textView3 = this.emptyTextButton;
        if (textView3 != null) {
            textView3.setText(str3);
        }
        LottieAnimationView lottieAnimationView = this.loadingLottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        View view = this.empty;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.loading;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    @JvmOverloads
    public final void showLoading() {
        showLoading$default(this, (String) null, 1, (Object) null);
    }

    @JvmOverloads
    public final void showLoading(@Nullable String str) {
        TextView textView = this.loadingText;
        if (textView != null) {
            if (str == null) {
                str = getContext().getString(R.string.ui_loading);
            }
            textView.setText(str);
        }
        LottieAnimationView lottieAnimationView = this.loadingLottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.playAnimation();
        }
        View view = this.empty;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.loading;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        setVisibility(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UIEmptyView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
