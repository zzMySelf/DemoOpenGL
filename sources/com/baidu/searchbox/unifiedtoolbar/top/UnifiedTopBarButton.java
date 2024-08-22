package com.baidu.searchbox.unifiedtoolbar.top;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.unifiedtoolbar.R;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.searchbox.ui.fontsize.view.FontSizeImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001sB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u000bH\u0016J\u0010\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020\u0011H\u0016J\b\u0010X\u001a\u00020TH\u0014JB\u0010Y\u001a\u00020T2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020-2\u0006\u0010W\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010[\u001a\u0002082\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010]H\u0002J\b\u0010^\u001a\u00020TH\u0016J\b\u0010_\u001a\u00020TH\u0014J\b\u0010`\u001a\u00020TH\u0014J\b\u0010a\u001a\u00020TH\u0016J\u0010\u0010b\u001a\u00020T2\u0006\u0010c\u001a\u000208H\u0016J\u0010\u0010d\u001a\u0002082\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020T2\u0006\u0010h\u001a\u000208H\u0016J\u0010\u0010i\u001a\u00020T2\u0006\u0010U\u001a\u00020\u000bH\u0014J\u0012\u0010j\u001a\u00020T2\b\b\u0002\u0010Z\u001a\u00020BH\u0017J.\u0010k\u001a\u00020T2\u0006\u0010l\u001a\u00020B2\u0006\u0010m\u001a\u00020B2\u0014\u0010n\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010AH\u0016J\u0012\u0010o\u001a\u00020T2\b\b\u0002\u0010Z\u001a\u00020BH\u0016J6\u0010p\u001a\u00020T2\u0006\u0010l\u001a\u00020B2\u0006\u0010q\u001a\u00020B2\u0006\u0010m\u001a\u00020B2\u0014\u0010n\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010AH\u0016J4\u0010r\u001a\u00020T2\u0006\u0010l\u001a\u00020B2\u0006\u0010m\u001a\u00020B2\u0006\u0010q\u001a\u00020B2\u0014\u0010n\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010AR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001b\u0010'\u001a\u00020(8FX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\"\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\n\u001a\u0004\u0018\u00010-@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\u001a\u0010>\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R(\u0010@\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\u001c\u0010P\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010J\"\u0004\bR\u0010L¨\u0006t"}, d2 = {"Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButton;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/ui/fontsize/listener/IFontSizeViewListener;", "Lcom/baidu/searchbox/skin/callback/NightModeChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "<set-?>", "Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonMode;", "buttonMode", "getButtonMode", "()Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonMode;", "setButtonMode", "(Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonMode;)V", "Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonStyle;", "buttonStyle", "getButtonStyle", "()Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonStyle;", "setButtonStyle", "(Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonStyle;)V", "customImageResId", "", "getCustomImageResId", "()I", "setCustomImageResId", "(I)V", "floatStyleBgView", "Landroid/view/View;", "getFloatStyleBgView", "()Landroid/view/View;", "setFloatStyleBgView", "(Landroid/view/View;)V", "value", "fontSizeScaleType", "getFontSizeScaleType", "setFontSizeScaleType", "iconImageView", "Lcom/baidu/searchbox/ui/fontsize/view/FontSizeImageView;", "getIconImageView", "()Lcom/baidu/searchbox/ui/fontsize/view/FontSizeImageView;", "iconImageView$delegate", "Lkotlin/Lazy;", "Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonType;", "iconType", "getIconType", "()Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonType;", "imageResIdArray", "", "getImageResIdArray", "()[I", "setImageResIdArray", "([I)V", "isAutoResizeImage", "", "()Z", "setAutoResizeImage", "(Z)V", "isResponseNightModeChange", "setResponseNightModeChange", "isTranslucentWhenPress", "setTranslucentWhenPress", "ubcExt", "", "", "", "getUbcExt", "()Ljava/util/Map;", "setUbcExt", "(Ljava/util/Map;)V", "ubcFrom", "getUbcFrom", "()Ljava/lang/String;", "setUbcFrom", "(Ljava/lang/String;)V", "ubcPage", "getUbcPage", "setUbcPage", "ubcSource", "getUbcSource", "setUbcSource", "changeMode", "", "mode", "changeStyle", "style", "fitFloatButtonStyle", "initTopBarButton", "type", "isAutoResponseFontSize", "actionBlock", "Lkotlin/Function0;", "initViews", "onAttachedToWindow", "onDetachedFromWindow", "onFontSizeChange", "onNightModeChanged", "isNightMode", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEnabled", "enabled", "setImageResByMode", "ubcBackButtonClick", "ubcBackButtonShow", "from", "page", "ext", "ubcButtonClick", "ubcButtonShow", "source", "updateStatInfo", "Companion", "lib-unified-toolbar_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnifiedTopBarButton.kt */
public class UnifiedTopBarButton extends FrameLayout implements IFontSizeViewListener, NightModeChangeListener {
    private static final float ALPHA_DISABLED = 0.4f;
    private static final float ALPHA_NORMAL = 1.0f;
    private static final float ALPHA_PRESSED = 0.4f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    protected static final int FLOAT_BACKGROUND_SIZE_DP = 30;
    public static final int MENU_LEFT_OFFSET_FLOAT_DP = -1;
    /* access modifiers changed from: private */
    public static final int TOP_BACK_DEFAULT_MARGIN_LEFT_DP;
    /* access modifiers changed from: private */
    public static final int TOP_BACK_DEFAULT_MARGIN_LEFT_PX;
    /* access modifiers changed from: private */
    public static final float TOP_BACK_DEFAULT_MARGIN_LEFT_PX_NOT_SCALE;
    public static final String UBC_EXT_KEY_SECOND_PAGE = "secondpage";
    public static final String UBC_TOP_BACK_CLICK_DEFAULT_TYPE = "btn_clk";
    public static final String UBC_TOP_BACK_ID = "6035";
    public static final String UBC_TOP_BACK_SOURCE = "topbar_back";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private UnifiedTopBarButtonMode buttonMode;
    private UnifiedTopBarButtonStyle buttonStyle;
    private int customImageResId;
    private View floatStyleBgView;
    private int fontSizeScaleType;
    private final Lazy iconImageView$delegate;
    /* access modifiers changed from: private */
    public UnifiedTopBarButtonType iconType;
    private int[] imageResIdArray;
    private boolean isAutoResizeImage;
    private boolean isResponseNightModeChange;
    private boolean isTranslucentWhenPress;
    private Map<String, ? extends Object> ubcExt;
    private String ubcFrom;
    private String ubcPage;
    private String ubcSource;

    @JvmStatic
    public static final UnifiedTopBarButton createCustomTopBarButton(Context context, int i2) {
        return Companion.createCustomTopBarButton(context, i2);
    }

    @JvmStatic
    public static final UnifiedTopBarButton createCustomTopBarButton(Context context, int i2, boolean z) {
        return Companion.createCustomTopBarButton(context, i2, z);
    }

    @JvmStatic
    public static final UnifiedTopBarButton createCustomTopBarButton(Context context, int i2, boolean z, Function0<Unit> function0) {
        return Companion.createCustomTopBarButton(context, i2, z, function0);
    }

    @JvmStatic
    public static final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType) {
        return Companion.createTopBarButton(context, unifiedTopBarButtonType);
    }

    @JvmStatic
    public static final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle) {
        return Companion.createTopBarButton(context, unifiedTopBarButtonType, unifiedTopBarButtonStyle);
    }

    @JvmStatic
    public static final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle, UnifiedTopBarButtonMode unifiedTopBarButtonMode) {
        return Companion.createTopBarButton(context, unifiedTopBarButtonType, unifiedTopBarButtonStyle, unifiedTopBarButtonMode);
    }

    @JvmStatic
    public static final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle, UnifiedTopBarButtonMode unifiedTopBarButtonMode, boolean z) {
        return Companion.createTopBarButton(context, unifiedTopBarButtonType, unifiedTopBarButtonStyle, unifiedTopBarButtonMode, z);
    }

    @JvmStatic
    public static final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle, UnifiedTopBarButtonMode unifiedTopBarButtonMode, boolean z, Function0<Unit> function0) {
        return Companion.createTopBarButton(context, unifiedTopBarButtonType, unifiedTopBarButtonStyle, unifiedTopBarButtonMode, z, function0);
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

    public final void ubcBackButtonClick() {
        ubcBackButtonClick$default(this, (String) null, 1, (Object) null);
    }

    public boolean isResponseFontSize() {
        return IFontSizeViewListener.DefaultImpls.isResponseFontSize(this);
    }

    public void setIsResponseFontSize(boolean isResponseFontSize) {
        IFontSizeViewListener.DefaultImpls.setIsResponseFontSize(this, isResponseFontSize);
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0007JH\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButton$Companion;", "", "()V", "ALPHA_DISABLED", "", "ALPHA_NORMAL", "ALPHA_PRESSED", "FLOAT_BACKGROUND_SIZE_DP", "", "MENU_LEFT_OFFSET_FLOAT_DP", "TOP_BACK_DEFAULT_MARGIN_LEFT_DP", "getTOP_BACK_DEFAULT_MARGIN_LEFT_DP", "()I", "TOP_BACK_DEFAULT_MARGIN_LEFT_PX", "getTOP_BACK_DEFAULT_MARGIN_LEFT_PX", "TOP_BACK_DEFAULT_MARGIN_LEFT_PX_NOT_SCALE", "getTOP_BACK_DEFAULT_MARGIN_LEFT_PX_NOT_SCALE", "()F", "UBC_EXT_KEY_SECOND_PAGE", "", "UBC_TOP_BACK_CLICK_DEFAULT_TYPE", "UBC_TOP_BACK_ID", "UBC_TOP_BACK_SOURCE", "createCustomTopBarButton", "Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButton;", "context", "Landroid/content/Context;", "imageResId", "isAutoResponseFontSize", "", "actionBlock", "Lkotlin/Function0;", "", "createTopBarButton", "type", "Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonType;", "style", "Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonStyle;", "mode", "Lcom/baidu/searchbox/unifiedtoolbar/top/UnifiedTopBarButtonMode;", "lib-unified-toolbar_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnifiedTopBarButton.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UnifiedTopBarButton createCustomTopBarButton(Context context, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createCustomTopBarButton$default(this, context, i2, false, (Function0) null, 12, (Object) null);
        }

        @JvmStatic
        public final UnifiedTopBarButton createCustomTopBarButton(Context context, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createCustomTopBarButton$default(this, context, i2, z, (Function0) null, 8, (Object) null);
        }

        @JvmStatic
        public final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonType, "type");
            return createTopBarButton$default(this, context, unifiedTopBarButtonType, (UnifiedTopBarButtonStyle) null, (UnifiedTopBarButtonMode) null, false, (Function0) null, 60, (Object) null);
        }

        @JvmStatic
        public final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonType, "type");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonStyle, "style");
            return createTopBarButton$default(this, context, unifiedTopBarButtonType, unifiedTopBarButtonStyle, (UnifiedTopBarButtonMode) null, false, (Function0) null, 56, (Object) null);
        }

        @JvmStatic
        public final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle, UnifiedTopBarButtonMode unifiedTopBarButtonMode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonType, "type");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonStyle, "style");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonMode, "mode");
            return createTopBarButton$default(this, context, unifiedTopBarButtonType, unifiedTopBarButtonStyle, unifiedTopBarButtonMode, false, (Function0) null, 48, (Object) null);
        }

        @JvmStatic
        public final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle, UnifiedTopBarButtonMode unifiedTopBarButtonMode, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonType, "type");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonStyle, "style");
            Intrinsics.checkNotNullParameter(unifiedTopBarButtonMode, "mode");
            return createTopBarButton$default(this, context, unifiedTopBarButtonType, unifiedTopBarButtonStyle, unifiedTopBarButtonMode, z, (Function0) null, 32, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ UnifiedTopBarButton createTopBarButton$default(Companion companion, Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle, UnifiedTopBarButtonMode unifiedTopBarButtonMode, boolean z, Function0 function0, int i2, Object obj) {
            UnifiedTopBarButtonStyle unifiedTopBarButtonStyle2;
            UnifiedTopBarButtonMode unifiedTopBarButtonMode2;
            if ((i2 & 4) != 0) {
                unifiedTopBarButtonStyle2 = UnifiedTopBarButtonStyle.NORMAL;
            } else {
                unifiedTopBarButtonStyle2 = unifiedTopBarButtonStyle;
            }
            if ((i2 & 8) != 0) {
                unifiedTopBarButtonMode2 = UnifiedTopBarButtonMode.AUTO;
            } else {
                unifiedTopBarButtonMode2 = unifiedTopBarButtonMode;
            }
            return companion.createTopBarButton(context, unifiedTopBarButtonType, unifiedTopBarButtonStyle2, unifiedTopBarButtonMode2, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? null : function0);
        }

        @JvmStatic
        public final UnifiedTopBarButton createTopBarButton(Context context, UnifiedTopBarButtonType type, UnifiedTopBarButtonStyle style, UnifiedTopBarButtonMode mode, boolean isAutoResponseFontSize, Function0<Unit> actionBlock) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(mode, "mode");
            UnifiedTopBarButton $this$createTopBarButton_u24lambda_u2d0 = new UnifiedTopBarButton(context);
            $this$createTopBarButton_u24lambda_u2d0.initTopBarButton(context, type, style, mode, isAutoResponseFontSize, actionBlock);
            return $this$createTopBarButton_u24lambda_u2d0;
        }

        public static /* synthetic */ UnifiedTopBarButton createCustomTopBarButton$default(Companion companion, Context context, int i2, boolean z, Function0 function0, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z = true;
            }
            if ((i3 & 8) != 0) {
                function0 = null;
            }
            return companion.createCustomTopBarButton(context, i2, z, function0);
        }

        @JvmStatic
        public final UnifiedTopBarButton createCustomTopBarButton(Context context, int imageResId, boolean isAutoResponseFontSize, Function0<Unit> actionBlock) {
            Intrinsics.checkNotNullParameter(context, "context");
            UnifiedTopBarButton unifiedTopBarButton = new UnifiedTopBarButton(context);
            UnifiedTopBarButton $this$createCustomTopBarButton_u24lambda_u2d2 = unifiedTopBarButton;
            $this$createCustomTopBarButton_u24lambda_u2d2.iconType = UnifiedTopBarButtonType.OTHER;
            $this$createCustomTopBarButton_u24lambda_u2d2.setAutoResizeImage(isAutoResponseFontSize);
            $this$createCustomTopBarButton_u24lambda_u2d2.initViews();
            $this$createCustomTopBarButton_u24lambda_u2d2.setCustomImageResId(imageResId);
            $this$createCustomTopBarButton_u24lambda_u2d2.getIconImageView().setImageResource(imageResId);
            $this$createCustomTopBarButton_u24lambda_u2d2.setOnClickListener(new UnifiedTopBarButton$Companion$$ExternalSyntheticLambda0(actionBlock));
            return unifiedTopBarButton;
        }

        /* access modifiers changed from: private */
        /* renamed from: createCustomTopBarButton$lambda-2$lambda-1  reason: not valid java name */
        public static final void m4590createCustomTopBarButton$lambda2$lambda1(Function0 $actionBlock, View it) {
            if ($actionBlock != null) {
                $actionBlock.invoke();
            }
        }

        public final int getTOP_BACK_DEFAULT_MARGIN_LEFT_DP() {
            return UnifiedTopBarButton.TOP_BACK_DEFAULT_MARGIN_LEFT_DP;
        }

        public final float getTOP_BACK_DEFAULT_MARGIN_LEFT_PX_NOT_SCALE() {
            return UnifiedTopBarButton.TOP_BACK_DEFAULT_MARGIN_LEFT_PX_NOT_SCALE;
        }

        public final int getTOP_BACK_DEFAULT_MARGIN_LEFT_PX() {
            return UnifiedTopBarButton.TOP_BACK_DEFAULT_MARGIN_LEFT_PX;
        }
    }

    static {
        int dimensionPixelSize = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.unified_top_back_common_left_margin);
        TOP_BACK_DEFAULT_MARGIN_LEFT_DP = dimensionPixelSize;
        float dp2pxFloat = UnifiedTopBarExtensionsKt.dp2pxFloat(Integer.valueOf(dimensionPixelSize));
        TOP_BACK_DEFAULT_MARGIN_LEFT_PX_NOT_SCALE = dp2pxFloat;
        TOP_BACK_DEFAULT_MARGIN_LEFT_PX = (int) FontSizeHelper.getScaledSize(0, dp2pxFloat);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedTopBarButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconImageView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnifiedTopBarButton$iconImageView$2(this));
        this.isAutoResizeImage = true;
        this.isResponseNightModeChange = true;
        this.isTranslucentWhenPress = true;
        this.buttonStyle = UnifiedTopBarButtonStyle.NORMAL;
        this.buttonMode = UnifiedTopBarButtonMode.AUTO;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedTopBarButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Context context2 = context;
        AttributeSet attributeSet = attrs;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.iconImageView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnifiedTopBarButton$iconImageView$2(this));
        this.isAutoResizeImage = true;
        this.isResponseNightModeChange = true;
        this.isTranslucentWhenPress = true;
        this.buttonStyle = UnifiedTopBarButtonStyle.NORMAL;
        this.buttonMode = UnifiedTopBarButtonMode.AUTO;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.UnifiedTopBarButton);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…able.UnifiedTopBarButton)");
            TypedArray typedArray = obtainStyledAttributes;
            UnifiedTopBarButtonType buttonType = UnifiedTopBarButtonUtilsKt.createButtonTypeByInt(typedArray.getInt(R.styleable.UnifiedTopBarButton_topBarButtonType, 0));
            UnifiedTopBarButtonStyle buttonStyle2 = UnifiedTopBarButtonUtilsKt.createButtonStyleByInt(typedArray.getInt(R.styleable.UnifiedTopBarButton_topBarButtonStyle, 0));
            UnifiedTopBarButtonMode buttonMode2 = UnifiedTopBarButtonUtilsKt.createButtonModeByInt(typedArray.getInt(R.styleable.UnifiedTopBarButton_topBarButtonMode, 0));
            this.isAutoResizeImage = typedArray.getBoolean(R.styleable.UnifiedTopBarButton_isAutoResizeImage, true);
            this.isResponseNightModeChange = typedArray.getBoolean(R.styleable.UnifiedTopBarButton_isResponseNightModeChange, true);
            this.isTranslucentWhenPress = typedArray.getBoolean(R.styleable.UnifiedTopBarButton_isTranslucentWhenPress, true);
            typedArray.recycle();
            initTopBarButton$default(this, context, buttonType, buttonStyle2, buttonMode2, this.isAutoResizeImage, (Function0) null, 32, (Object) null);
        }
    }

    public final FontSizeImageView getIconImageView() {
        return (FontSizeImageView) this.iconImageView$delegate.getValue();
    }

    public final boolean isAutoResizeImage() {
        return this.isAutoResizeImage;
    }

    public final void setAutoResizeImage(boolean z) {
        this.isAutoResizeImage = z;
    }

    public final boolean isResponseNightModeChange() {
        return this.isResponseNightModeChange;
    }

    public final void setResponseNightModeChange(boolean z) {
        this.isResponseNightModeChange = z;
    }

    public final boolean isTranslucentWhenPress() {
        return this.isTranslucentWhenPress;
    }

    public final void setTranslucentWhenPress(boolean z) {
        this.isTranslucentWhenPress = z;
    }

    public final UnifiedTopBarButtonType getIconType() {
        return this.iconType;
    }

    public int[] getImageResIdArray() {
        return this.imageResIdArray;
    }

    public void setImageResIdArray(int[] iArr) {
        this.imageResIdArray = iArr;
    }

    public final View getFloatStyleBgView() {
        return this.floatStyleBgView;
    }

    public final void setFloatStyleBgView(View view2) {
        this.floatStyleBgView = view2;
    }

    public final int getCustomImageResId() {
        return this.customImageResId;
    }

    public final void setCustomImageResId(int i2) {
        this.customImageResId = i2;
    }

    public final UnifiedTopBarButtonStyle getButtonStyle() {
        return this.buttonStyle;
    }

    /* access modifiers changed from: protected */
    public final void setButtonStyle(UnifiedTopBarButtonStyle unifiedTopBarButtonStyle) {
        Intrinsics.checkNotNullParameter(unifiedTopBarButtonStyle, "<set-?>");
        this.buttonStyle = unifiedTopBarButtonStyle;
    }

    public final UnifiedTopBarButtonMode getButtonMode() {
        return this.buttonMode;
    }

    /* access modifiers changed from: protected */
    public final void setButtonMode(UnifiedTopBarButtonMode unifiedTopBarButtonMode) {
        Intrinsics.checkNotNullParameter(unifiedTopBarButtonMode, "<set-?>");
        this.buttonMode = unifiedTopBarButtonMode;
    }

    public final int getFontSizeScaleType() {
        return this.fontSizeScaleType;
    }

    public final void setFontSizeScaleType(int value) {
        this.fontSizeScaleType = value;
        getIconImageView().setFontSizeType(value);
        onFontSizeChange();
    }

    /* access modifiers changed from: protected */
    public final String getUbcFrom() {
        return this.ubcFrom;
    }

    /* access modifiers changed from: protected */
    public final void setUbcFrom(String str) {
        this.ubcFrom = str;
    }

    /* access modifiers changed from: protected */
    public final String getUbcSource() {
        return this.ubcSource;
    }

    /* access modifiers changed from: protected */
    public final void setUbcSource(String str) {
        this.ubcSource = str;
    }

    /* access modifiers changed from: protected */
    public final String getUbcPage() {
        return this.ubcPage;
    }

    /* access modifiers changed from: protected */
    public final void setUbcPage(String str) {
        this.ubcPage = str;
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> getUbcExt() {
        return this.ubcExt;
    }

    /* access modifiers changed from: protected */
    public final void setUbcExt(Map<String, ? extends Object> map) {
        this.ubcExt = map;
    }

    public void initViews() {
        setMinimumWidth(UnifiedTopBarExtensionsKt.dp2px((Number) 38));
        setMinimumHeight(UnifiedTopBarExtensionsKt.dp2px((Number) 38));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        setForegroundGravity(17);
        FrameLayout.LayoutParams $this$initViews_u24lambda_u2d0 = new FrameLayout.LayoutParams(-2, -2);
        $this$initViews_u24lambda_u2d0.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(getIconImageView(), $this$initViews_u24lambda_u2d0);
        setClipToPadding(false);
        setClipChildren(false);
    }

    public void changeMode(UnifiedTopBarButtonMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        setImageResByMode(mode);
    }

    public void changeStyle(UnifiedTopBarButtonStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        int[][] iArr = (int[][]) UnifiedTopBarButtonUtilsKt.getIconImageResMap().get(this.iconType);
        setImageResIdArray(iArr != null ? (int[]) ArraysKt.getOrNull((T[]) (Object[]) iArr, style.getIndex$lib_unified_toolbar_release()) : null);
        setImageResByMode(this.buttonMode);
        if (style == UnifiedTopBarButtonStyle.FLOAT) {
            fitFloatButtonStyle();
            return;
        }
        View view2 = this.floatStyleBgView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.4f);
        }
    }

    public void ubcBackButtonShow(String from, String page, Map<String, ? extends Object> ext) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(page, "page");
        ubcButtonShow(from, "topbar_back", page, ext);
        IUnifiedTopBarIoc impl = UnifiedTopBarIocHolder.INSTANCE.getImpl();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        impl.setUnifiedBackUBCInfo(context, MapsKt.mapOf(TuplesKt.to("from", from), TuplesKt.to("page", page), TuplesKt.to("source", "topbar_back"), TuplesKt.to("ext", ext)));
    }

    public void ubcButtonShow(String from, String source, String page, Map<String, ? extends Object> ext) {
        T t;
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(page, "page");
        updateStatInfo(from, page, source, ext);
        Ref.ObjectRef extStr = new Ref.ObjectRef();
        Map it = this.ubcExt;
        if (it != null) {
            try {
                Result.Companion companion = Result.Companion;
                UnifiedTopBarButton unifiedTopBarButton = this;
                t = Result.m8971constructorimpl(new JSONObject(it).toString());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                t = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m8977isFailureimpl(t)) {
                t = null;
            }
            extStr.element = t;
        }
        UnifiedTopBarButtonUtilsKt.topBarCommonStatistic("6035", from, source, page, (String) null, "show", (String) extStr.element);
    }

    public final void updateStatInfo(String from, String page, String source, Map<String, ? extends Object> ext) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(source, "source");
        this.ubcFrom = from;
        this.ubcExt = ext;
        this.ubcPage = page;
        this.ubcSource = source;
    }

    public static /* synthetic */ void ubcBackButtonClick$default(UnifiedTopBarButton unifiedTopBarButton, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = "btn_clk";
            }
            unifiedTopBarButton.ubcBackButtonClick(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ubcBackButtonClick");
    }

    public void ubcBackButtonClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ubcButtonClick(type);
    }

    public static /* synthetic */ void ubcButtonClick$default(UnifiedTopBarButton unifiedTopBarButton, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = "btn_clk";
            }
            unifiedTopBarButton.ubcButtonClick(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ubcButtonClick");
    }

    public void ubcButtonClick(String type) {
        T t;
        Intrinsics.checkNotNullParameter(type, "type");
        String from = this.ubcFrom;
        String page = "";
        if (from == null) {
            from = page;
        }
        String str = this.ubcPage;
        if (str != null) {
            page = str;
        }
        boolean z = true;
        if (!(page.length() == 0)) {
            if (from.length() != 0) {
                z = false;
            }
            if (!z) {
                Ref.ObjectRef extStr = new Ref.ObjectRef();
                Map it = this.ubcExt;
                if (it != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        UnifiedTopBarButton unifiedTopBarButton = this;
                        t = Result.m8971constructorimpl(new JSONObject(it).toString());
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        t = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (Result.m8977isFailureimpl(t)) {
                        t = null;
                    }
                    extStr.element = t;
                }
                UnifiedTopBarButtonUtilsKt.topBarCommonStatistic("6035", from, "topbar_back", page, type, "click", (String) extStr.element);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isEnabled() && this.isTranslucentWhenPress) {
            switch (event.getAction()) {
                case 0:
                    setAlpha(0.4f);
                    break;
                case 1:
                case 3:
                    setAlpha(1.0f);
                    break;
            }
        }
        return super.onTouchEvent(event);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r2 = kotlin.collections.ArraysKt.getOrNull(r2, (int) r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNightModeChanged(boolean r4) {
        /*
            r3 = this;
            boolean r0 = r3.isResponseNightModeChange
            if (r0 == 0) goto L_0x0032
            int[] r0 = r3.getImageResIdArray()
            if (r0 != 0) goto L_0x0018
            int r0 = r3.customImageResId
            if (r0 == 0) goto L_0x0018
            com.baidu.searchbox.ui.fontsize.view.FontSizeImageView r0 = r3.getIconImageView()
            int r1 = r3.customImageResId
            r0.setImageResource(r1)
            goto L_0x0032
        L_0x0018:
            r0 = r4
            com.baidu.searchbox.ui.fontsize.view.FontSizeImageView r1 = r3.getIconImageView()
            int[] r2 = r3.getImageResIdArray()
            if (r2 == 0) goto L_0x002e
            java.lang.Integer r2 = kotlin.collections.ArraysKt.getOrNull((int[]) r2, (int) r0)
            if (r2 == 0) goto L_0x002e
            int r2 = r2.intValue()
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            r1.setImageResource(r2)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton.onNightModeChanged(boolean):void");
    }

    public void onFontSizeChange() {
        IFontSizeViewListener.DefaultImpls.onFontSizeChange(this);
        getIconImageView().onFontSizeChange();
        int sizeType = this.fontSizeScaleType;
        if (!this.isAutoResizeImage) {
            sizeType = -1;
        }
        View view2 = this.floatStyleBgView;
        if (view2 != null) {
            FontSizeViewExtKt.setScaledSize$default(view2, sizeType, UnifiedTopBarExtensionsKt.dp2pxFloat((Number) 30), UnifiedTopBarExtensionsKt.dp2pxFloat((Number) 30), 0, 8, (Object) null);
        }
        FontSizeViewExtKt.setScaledWidth$default(this, sizeType, UnifiedTopBarExtensionsKt.dp2pxFloat((Number) 38), 0, 4, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new UnifiedTopBarButton$$ExternalSyntheticLambda1(this));
        NightModeHelper.subscribeNightModeChangeEvent(this, new UnifiedTopBarButton$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-5  reason: not valid java name */
    public static final void m4588onAttachedToWindow$lambda5(UnifiedTopBarButton this$0, FontSizeChangeMessage it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.onFontSizeChange();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-6  reason: not valid java name */
    public static final void m4589onAttachedToWindow$lambda6(UnifiedTopBarButton this$0, boolean isNightMode) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onNightModeChanged(isNightMode);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BdEventBus.Companion.getDefault().unregister(this);
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    /* access modifiers changed from: protected */
    public void setImageResByMode(UnifiedTopBarButtonMode mode) {
        Integer orNull;
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (getImageResIdArray() != null) {
            int index = 1;
            int i2 = 0;
            if (!(mode == UnifiedTopBarButtonMode.NIGHT || (mode == UnifiedTopBarButtonMode.AUTO && NightModeHelper.isNightMode()))) {
                index = 0;
            }
            FontSizeImageView iconImageView = getIconImageView();
            int[] imageResIdArray2 = getImageResIdArray();
            if (!(imageResIdArray2 == null || (orNull = ArraysKt.getOrNull(imageResIdArray2, index)) == null)) {
                i2 = orNull.intValue();
            }
            iconImageView.setImageResource(i2);
            this.buttonMode = mode;
        }
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [android.view.ViewGroup$LayoutParams] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fitFloatButtonStyle() {
        /*
            r12 = this;
            android.view.View r0 = r12.floatStyleBgView
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x006b
            android.graphics.drawable.ShapeDrawable r0 = new android.graphics.drawable.ShapeDrawable
            android.graphics.drawable.shapes.OvalShape r3 = new android.graphics.drawable.shapes.OvalShape
            r3.<init>()
            android.graphics.drawable.shapes.Shape r3 = (android.graphics.drawable.shapes.Shape) r3
            r0.<init>(r3)
            r3 = r0
            r4 = 0
            android.graphics.Paint r5 = r3.getPaint()
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r5.setColor(r6)
            r5 = 102(0x66, float:1.43E-43)
            r3.setAlpha(r5)
            android.view.View r3 = new android.view.View
            android.content.Context r4 = r12.getContext()
            r3.<init>(r4)
            r4 = r0
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r3.setBackground(r4)
            r12.addView(r3, r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            boolean r5 = r4 instanceof android.widget.FrameLayout.LayoutParams
            if (r5 == 0) goto L_0x0041
            android.widget.FrameLayout$LayoutParams r4 = (android.widget.FrameLayout.LayoutParams) r4
            goto L_0x0042
        L_0x0041:
            r4 = r1
        L_0x0042:
            if (r4 != 0) goto L_0x0045
            goto L_0x0049
        L_0x0045:
            r5 = 17
            r4.gravity = r5
        L_0x0049:
            int r6 = r12.fontSizeScaleType
            r4 = 30
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Number r5 = (java.lang.Number) r5
            float r7 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExtensionsKt.dp2pxFloat(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            float r8 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExtensionsKt.dp2pxFloat(r4)
            r9 = 0
            r10 = 8
            r11 = 0
            r5 = r3
            com.baidu.searchbox.config.ext.FontSizeViewExtKt.setScaledSize$default(r5, r6, r7, r8, r9, r10, r11)
            r12.floatStyleBgView = r3
        L_0x006b:
            android.view.View r0 = r12.floatStyleBgView
            if (r0 != 0) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            r0.setVisibility(r2)
        L_0x0073:
            com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonType r0 = r12.iconType
            com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonType r2 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButtonType.MENU
            if (r0 != r2) goto L_0x0098
            com.baidu.searchbox.ui.fontsize.view.FontSizeImageView r0 = r12.getIconImageView()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r2 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r2 == 0) goto L_0x0088
            r1 = r0
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
        L_0x0088:
            if (r1 != 0) goto L_0x008b
            goto L_0x0098
        L_0x008b:
            r0 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExtensionsKt.dp2px(r0)
            r1.leftMargin = r0
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton.fitFloatButtonStyle():void");
    }

    static /* synthetic */ void initTopBarButton$default(UnifiedTopBarButton unifiedTopBarButton, Context context, UnifiedTopBarButtonType unifiedTopBarButtonType, UnifiedTopBarButtonStyle unifiedTopBarButtonStyle, UnifiedTopBarButtonMode unifiedTopBarButtonMode, boolean z, Function0 function0, int i2, Object obj) {
        if (obj == null) {
            unifiedTopBarButton.initTopBarButton(context, unifiedTopBarButtonType, unifiedTopBarButtonStyle, unifiedTopBarButtonMode, z, (i2 & 32) != 0 ? null : function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initTopBarButton");
    }

    /* access modifiers changed from: private */
    public final void initTopBarButton(Context context, UnifiedTopBarButtonType type, UnifiedTopBarButtonStyle style, UnifiedTopBarButtonMode mode, boolean isAutoResponseFontSize, Function0<Unit> actionBlock) {
        this.iconType = type;
        this.buttonStyle = style;
        int[][] iArr = UnifiedTopBarButtonUtilsKt.getIconImageResMap().get(type);
        setImageResIdArray(iArr != null ? (int[]) ArraysKt.getOrNull((T[]) (Object[]) iArr, style.getIndex$lib_unified_toolbar_release()) : null);
        this.isResponseNightModeChange = mode == UnifiedTopBarButtonMode.AUTO;
        this.isAutoResizeImage = isAutoResponseFontSize;
        initViews();
        setImageResByMode(mode);
        setOnClickListener(new UnifiedTopBarButton$$ExternalSyntheticLambda0(type, actionBlock, context, this));
        if (style == UnifiedTopBarButtonStyle.FLOAT) {
            fitFloatButtonStyle();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initTopBarButton$lambda-8  reason: not valid java name */
    public static final void m4587initTopBarButton$lambda8(UnifiedTopBarButtonType $type, Function0 $actionBlock, Context $context, UnifiedTopBarButton this$0, View it) {
        Intrinsics.checkNotNullParameter($type, "$type");
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ($type == UnifiedTopBarButtonType.BACK) {
            if ($actionBlock != null) {
                $actionBlock.invoke();
            } else {
                Activity activity = $context instanceof Activity ? (Activity) $context : null;
                if (activity != null) {
                    activity.finish();
                }
            }
            ubcBackButtonClick$default(this$0, (String) null, 1, (Object) null);
        } else if ($actionBlock != null) {
            $actionBlock.invoke();
        }
    }
}
