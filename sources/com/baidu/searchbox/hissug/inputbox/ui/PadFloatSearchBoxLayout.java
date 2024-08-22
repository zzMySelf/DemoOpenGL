package com.baidu.searchbox.hissug.inputbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.bg.res.R;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.searchboxbg.res.BoxBgManager;
import com.baidu.searchbox.searchboxbg.res.InputBoxDimenManager;
import com.baidu.searchbox.searchboxbg.res.utils.BoxFontSizeExtKt;
import com.baidu.voice.input.IInputMethodController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0007H\u0014J\b\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0007H\u0014J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0007H\u0014J\b\u0010!\u001a\u00020\u0007H\u0014J\b\u0010\"\u001a\u00020\u0007H\u0014J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0012\u0010(\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/hissug/inputbox/ui/PadFloatSearchBoxLayout;", "Lcom/baidu/searchbox/hissug/inputbox/ui/FloatSearchBoxLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "voiceContainer", "Landroid/widget/FrameLayout;", "getVoiceContainer", "()Landroid/widget/FrameLayout;", "voiceContainer$delegate", "Lkotlin/Lazy;", "value", "Lcom/baidu/voice/input/IInputMethodController;", "voiceController", "getVoiceController", "()Lcom/baidu/voice/input/IInputMethodController;", "setVoiceController", "(Lcom/baidu/voice/input/IInputMethodController;)V", "applyFontSize", "", "applyGraphSearchViewFontSize", "graphSearchView", "Landroid/widget/ImageView;", "getBoxLeftMargin", "getBoxRightMargin", "getHisBackBoxMarginLeft", "getSearchBoxBg", "Landroid/graphics/drawable/Drawable;", "getSearchBoxHeight", "getSearchBtnBgRes", "getSearchBtnTextColorRes", "initGraphSearchViewDrawable", "initVoice", "controller", "setClearViewVisibility", "visibility", "updateGraphSearchDrawable", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadFloatSearchBoxLayout.kt */
public final class PadFloatSearchBoxLayout extends FloatSearchBoxLayout {
    public Map<Integer, View> _$_findViewCache;
    private final Lazy voiceContainer$delegate;
    private IInputMethodController voiceController;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PadFloatSearchBoxLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PadFloatSearchBoxLayout(Context context, AttributeSet attributeSet) {
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
    public PadFloatSearchBoxLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.voiceContainer$delegate = LazyKt.lazy(new PadFloatSearchBoxLayout$voiceContainer$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PadFloatSearchBoxLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final IInputMethodController getVoiceController() {
        return this.voiceController;
    }

    public final void setVoiceController(IInputMethodController value) {
        if (this.voiceController == null) {
            initVoice(value);
        }
        this.voiceController = value;
    }

    private final FrameLayout getVoiceContainer() {
        return (FrameLayout) this.voiceContainer$delegate.getValue();
    }

    private final void initVoice(IInputMethodController controller) {
        View button;
        FrameLayout container;
        if (controller != null && (button = controller.getHisSugSearchBarVoiceView(getContext())) != null && (container = getVoiceContainer()) != null) {
            ViewParent parent = button.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(button);
            }
            container.removeAllViews();
            container.addView(button, -1, -1);
            FontSizeExtKt.updateSize$default(container, 0, 1, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public Drawable getSearchBoxBg() {
        return BoxBgManager.INSTANCE.getPadSearchBoxBg();
    }

    /* access modifiers changed from: protected */
    public int getSearchBoxHeight() {
        return InputBoxDimenManager.INSTANCE.getPadSearchBoxHeight();
    }

    /* access modifiers changed from: protected */
    public int getSearchBtnTextColorRes() {
        return BoxBgManager.INSTANCE.getPadSearchBtnTextColorRes();
    }

    /* access modifiers changed from: protected */
    public int getSearchBtnBgRes() {
        return BoxBgManager.INSTANCE.getPadSearchBtnBgRes();
    }

    /* access modifiers changed from: protected */
    public void initGraphSearchViewDrawable(ImageView graphSearchView) {
        Intrinsics.checkNotNullParameter(graphSearchView, "graphSearchView");
        updateGraphSearchDrawable(graphSearchView);
    }

    /* access modifiers changed from: protected */
    public void updateGraphSearchDrawable(ImageView graphSearchView) {
        if (graphSearchView != null) {
            ImageView $this$updateGraphSearchDrawable_u24lambda_u2d2 = graphSearchView;
            $this$updateGraphSearchDrawable_u24lambda_u2d2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ResWrapper.setImageDrawable($this$updateGraphSearchDrawable_u24lambda_u2d2, R.drawable.searchbox_image_search_pad_icon);
        }
    }

    /* access modifiers changed from: protected */
    public void applyGraphSearchViewFontSize(ImageView graphSearchView) {
        BoxFontSizeExtKt.setViewSizeRes(graphSearchView, R.dimen.pad_search_box_icon_size, R.dimen.pad_search_box_icon_size);
    }

    /* access modifiers changed from: protected */
    public int getBoxLeftMargin() {
        return ViewExKt.getDp(15);
    }

    /* access modifiers changed from: protected */
    public int getBoxRightMargin() {
        return ViewExKt.getDp(24);
    }

    /* access modifiers changed from: protected */
    public int getHisBackBoxMarginLeft() {
        return ViewExKt.getDp(24);
    }

    public void applyFontSize() {
        super.applyFontSize();
        FrameLayout voiceContainer = getVoiceContainer();
        if (voiceContainer != null) {
            FontSizeExtKt.updateSize$default(voiceContainer, 0, 1, (Object) null);
        }
    }

    public void setClearViewVisibility(int visibility) {
        super.setClearViewVisibility(visibility);
        if (visibility == 0) {
            FrameLayout voiceContainer = getVoiceContainer();
            if (voiceContainer != null) {
                voiceContainer.setVisibility(8);
                return;
            }
            return;
        }
        FrameLayout voiceContainer2 = getVoiceContainer();
        if (voiceContainer2 != null) {
            voiceContainer2.setVisibility(0);
        }
    }
}
