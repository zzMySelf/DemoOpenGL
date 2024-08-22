package com.baidu.searchbox.search.rsseview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.search.basic.utils.ResultPageABTest;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.hissug.util.HissugRecommendAndGuessDataManager;
import com.baidu.searchbox.search.rsseview.SearchRsseModel;
import com.baidu.searchbox.searchui.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@StableApi
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b'\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0012\u0010&\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001dH\u0007J\b\u0010+\u001a\u00020\u001dH\u0007J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0016J\u0018\u0010.\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0016J\u0018\u0010/\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0016J\u0012\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u00102\u001a\u00020\u001dH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/search/rsseview/SearchRsseView;", "Landroid/widget/LinearLayout;", "Landroidx/lifecycle/Observer;", "Lcom/baidu/searchbox/search/rsseview/SearchRsseModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "data", "divider", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "setDivider", "(Landroid/view/View;)V", "isNewStyle", "", "()Z", "isNewStyle$delegate", "Lkotlin/Lazy;", "rootView", "topTips", "Landroid/widget/TextView;", "getTopTips", "()Landroid/widget/TextView;", "setTopTips", "(Landroid/widget/TextView;)V", "viewModel", "Lcom/baidu/searchbox/search/rsseview/ISearchRsseViewModel;", "bind", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "formatRoundColor", "roundBgColorSpan", "Lcom/baidu/searchbox/search/rsseview/RoundBgColorSpan;", "getBgColor", "", "getTextColor", "onChanged", "onFirstShow", "ext", "", "onFontSizeChanged", "onNightModeChanged", "onOriginalQueryClick", "query", "onReplaceQueryClick", "onSeTipsClick", "setTextFontSize", "textView", "setTextSpanStyle", "lib_search_ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchRsseView.kt */
public abstract class SearchRsseView extends LinearLayout implements Observer<SearchRsseModel> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private SearchRsseModel data;
    private View divider;
    private final Lazy isNewStyle$delegate;
    private LinearLayout rootView;
    private TextView topTips;
    /* access modifiers changed from: private */
    public ISearchRsseViewModel viewModel;

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
    public SearchRsseView(Context context) {
        super(context);
        ViewGroup.LayoutParams lp;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isNewStyle$delegate = LazyKt.lazy(SearchRsseView$isNewStyle$2.INSTANCE);
        LayoutInflater.from(context).inflate(R.layout.search_rsse_container, this, true);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.video_tab_rsse_root);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "video_tab_rsse_root");
        this.rootView = linearLayout;
        TextView textView = (TextView) _$_findCachedViewById(R.id.video_tab_tips_text);
        TextView $this$_init__u24lambda_u2d0 = textView;
        if (isNewStyle()) {
            $this$_init__u24lambda_u2d0.setGravity(16);
            int paddingVertical = context.getResources().getDimensionPixelSize(R.dimen.rsse_text_padding_vertical_new_style);
            $this$_init__u24lambda_u2d0.setPadding($this$_init__u24lambda_u2d0.getPaddingLeft(), paddingVertical, $this$_init__u24lambda_u2d0.getPaddingRight(), paddingVertical);
            setTextFontSize($this$_init__u24lambda_u2d0);
        }
        Intrinsics.checkNotNullExpressionValue(textView, "video_tab_tips_text.appl…)\n            }\n        }");
        this.topTips = textView;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.video_tab_tips_divider);
        View $this$_init__u24lambda_u2d2 = _$_findCachedViewById;
        if (isNewStyle() && (lp = $this$_init__u24lambda_u2d2.getLayoutParams()) != null) {
            Intrinsics.checkNotNullExpressionValue(lp, "layoutParams");
            lp.height = context.getResources().getDimensionPixelSize(R.dimen.rsse_divider_height_new_style);
            $this$_init__u24lambda_u2d2.setLayoutParams(lp);
        }
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "video_tab_tips_divider.a…}\n            }\n        }");
        this.divider = _$_findCachedViewById;
    }

    public final TextView getTopTips() {
        return this.topTips;
    }

    public final void setTopTips(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.topTips = textView;
    }

    public final View getDivider() {
        return this.divider;
    }

    public final void setDivider(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.divider = view2;
    }

    public final boolean isNewStyle() {
        return ((Boolean) this.isNewStyle$delegate.getValue()).booleanValue();
    }

    public final void onFontSizeChanged() {
        setTextFontSize(this.topTips);
        setTextSpanStyle();
    }

    private final void setTextFontSize(TextView textView) {
        FontSizeTextViewExtKt.setScaledSizeRes$default(textView, 3, R.dimen.rsse_text_size, 0, 4, (Object) null);
    }

    public final void onNightModeChanged() {
        setTextSpanStyle();
    }

    private final void setTextSpanStyle() {
        int stringId;
        int i2;
        int i3;
        SearchRsseModel $this$setTextSpanStyle_u24lambda_u2d9 = this.data;
        if ($this$setTextSpanStyle_u24lambda_u2d9 != null) {
            int i4 = 0;
            if (!$this$setTextSpanStyle_u24lambda_u2d9.getHasShow()) {
                onFirstShow($this$setTextSpanStyle_u24lambda_u2d9.getExtLog());
                $this$setTextSpanStyle_u24lambda_u2d9.setHasShow(true);
            }
            this.topTips.setTextColor(getTextColor());
            this.divider.setBackgroundColor(getBgColor());
            SpannableStringBuilder builder = new SpannableStringBuilder();
            String seType = $this$setTextSpanStyle_u24lambda_u2d9.getSeType();
            boolean z = false;
            if (Intrinsics.areEqual((Object) seType, (Object) HissugRecommendAndGuessDataManager.EVENT_BOX_RESULT)) {
                SpannableStringBuilder seBuilder = builder;
                SearchRsseModel.ReplaceBean $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3 = $this$setTextSpanStyle_u24lambda_u2d9.getReplace();
                if ($this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3 != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getResources().getString(R.string.search_video_se_tips);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.search_video_se_tips)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{$this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.getQ()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    String tipsStr = format;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    RoundBgColorSpan roundBgColorSpan = new RoundBgColorSpan(context, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.getQ());
                    formatRoundColor(roundBgColorSpan);
                    RoundBgColorSpan.setMargin$default(roundBgColorSpan, 0.0f, 0.0f, 2, (Object) null);
                    Collection highlightInfosJc = $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.getHighlightInfosJc();
                    if (highlightInfosJc == null || highlightInfosJc.isEmpty()) {
                        z = true;
                    }
                    if (!z) {
                        List<SearchRsseModel.ReplaceBean.HighlightInfosJcBean> highlightInfosJc2 = $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.getHighlightInfosJc();
                        Intrinsics.checkNotNull(highlightInfosJc2);
                        roundBgColorSpan.setHighlightInfos(highlightInfosJc2);
                    }
                    seBuilder.append(tipsStr);
                    seBuilder.setSpan(roundBgColorSpan, tipsStr.length() - $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.getQ().length(), tipsStr.length(), 33);
                    seBuilder.setSpan(new SearchRsseView$setTextSpanStyle$1$1$1$1(this, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3, $this$setTextSpanStyle_u24lambda_u2d9), tipsStr.length() - $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.getQ().length(), tipsStr.length() - 1, 33);
                }
            } else if (Intrinsics.areEqual((Object) seType, (Object) "full_replace")) {
                SpannableStringBuilder replaceBuilder = builder;
                if (ResultPageABTest.isResultPageNewStyle()) {
                    stringId = R.string.search_video_se_replace_new_style;
                } else {
                    stringId = R.string.search_video_se_replace;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = getResources().getString(stringId);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(stringId)");
                Object[] objArr = new Object[2];
                SearchRsseModel.ReplaceBean replace = $this$setTextSpanStyle_u24lambda_u2d9.getReplace();
                objArr[0] = replace != null ? replace.getQ() : null;
                SearchRsseModel.OriginBean origin = $this$setTextSpanStyle_u24lambda_u2d9.getOrigin();
                objArr[1] = origin != null ? origin.getQ() : null;
                String format2 = String.format(string2, Arrays.copyOf(objArr, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                String tipsStr2 = format2;
                replaceBuilder.append(tipsStr2);
                SearchRsseModel.ReplaceBean $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6 = $this$setTextSpanStyle_u24lambda_u2d9.getReplace();
                if ($this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6 != null) {
                    if (isNewStyle()) {
                        int currentIndex = 4;
                        Collection highlightInfosJc3 = $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getHighlightInfosJc();
                        if (!(highlightInfosJc3 == null || highlightInfosJc3.isEmpty())) {
                            List<SearchRsseModel.ReplaceBean.HighlightInfosJcBean> $this$forEach$iv = $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getHighlightInfosJc();
                            if ($this$forEach$iv != null) {
                                for (SearchRsseModel.ReplaceBean.HighlightInfosJcBean it : $this$forEach$iv) {
                                    int start = currentIndex;
                                    int end = currentIndex + it.getWord().length();
                                    if (AppConfig.isDebug()) {
                                        Log.d("SearchRsseView", it.getWord() + ": is highlight: $" + it.getType());
                                    }
                                    Context context2 = getContext();
                                    int i5 = i4;
                                    if (Intrinsics.areEqual((Object) it.getType(), (Object) "1")) {
                                        i3 = com.baidu.searchbox.search.style.res.R.color.SC44;
                                    } else {
                                        i3 = com.baidu.searchbox.search.style.res.R.color.SC360;
                                    }
                                    int color = ContextCompat.getColor(context2, i3);
                                    int start2 = start;
                                    int start3 = color;
                                    replaceBuilder.setSpan(new ForegroundColorSpan(color), start2, end, 17);
                                    currentIndex = end;
                                    i4 = i5;
                                }
                                int i6 = i4;
                            }
                        } else {
                            replaceBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), com.baidu.searchbox.search.style.res.R.color.SC360)), 3, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getQ().length() + 3, 17);
                        }
                    } else {
                        Context context3 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "context");
                        RoundBgColorSpan roundBgColorSpan2 = new RoundBgColorSpan(context3, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getQ());
                        formatRoundColor(roundBgColorSpan2);
                        Collection highlightInfosJc4 = $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getHighlightInfosJc();
                        if (!(highlightInfosJc4 == null || highlightInfosJc4.isEmpty())) {
                            List<SearchRsseModel.ReplaceBean.HighlightInfosJcBean> highlightInfosJc5 = $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getHighlightInfosJc();
                            Intrinsics.checkNotNull(highlightInfosJc5);
                            roundBgColorSpan2.setHighlightInfos(highlightInfosJc5);
                        }
                        replaceBuilder.setSpan(roundBgColorSpan2, 3, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getQ().length() + 3, 33);
                        replaceBuilder.setSpan(new SearchRsseView$setTextSpanStyle$1$2$1$2($this$setTextSpanStyle_u24lambda_u2d9, this, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6), 3, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.getQ().length() + 3, 33);
                    }
                }
                SearchRsseModel.OriginBean $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7 = $this$setTextSpanStyle_u24lambda_u2d9.getOrigin();
                if ($this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7 != null) {
                    if (isNewStyle()) {
                        int originStart = tipsStr2.length() - ($this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.getQ() + ' ').length();
                        int originEnd = tipsStr2.length();
                        Drawable icon = ContextCompat.getDrawable(getContext(), R.drawable.search_rsse_search_icon);
                        if (icon != null) {
                            int scaledSize = (int) FontSizeHelper.getScaledSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.rsse_search_icon_size));
                            icon.setBounds(0, 0, scaledSize, scaledSize);
                            int iconPadding = getContext().getResources().getDimensionPixelSize(R.dimen.rsse_text_search_icon_padding_new_style);
                            int i7 = iconPadding;
                            i2 = 33;
                            replaceBuilder.setSpan(new TopAlignedImageSpan(icon, iconPadding), originEnd - 1, originEnd, 33);
                        } else {
                            i2 = 33;
                        }
                        replaceBuilder.setSpan(new SearchRsseView$setTextSpanStyle$1$2$2$1(this, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7, $this$setTextSpanStyle_u24lambda_u2d9), originStart, originEnd, i2);
                    } else {
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "context");
                        RoundBgColorSpan originRoundBgColorSpan = new RoundBgColorSpan(context4, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.getQ());
                        formatRoundColor(originRoundBgColorSpan);
                        RoundBgColorSpan.setMargin$default(originRoundBgColorSpan, 0.0f, 0.0f, 2, (Object) null);
                        replaceBuilder.setSpan(originRoundBgColorSpan, tipsStr2.length() - $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.getQ().length(), tipsStr2.length(), 33);
                        replaceBuilder.setSpan(new SearchRsseView$setTextSpanStyle$1$2$2$2(this, $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7, $this$setTextSpanStyle_u24lambda_u2d9), tipsStr2.length() - $this$setTextSpanStyle_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.getQ().length(), tipsStr2.length(), 33);
                    }
                }
            }
            this.topTips.setText(builder);
            this.topTips.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void formatRoundColor(RoundBgColorSpan roundBgColorSpan) {
        Intrinsics.checkNotNullParameter(roundBgColorSpan, "roundBgColorSpan");
    }

    public int getTextColor() {
        return ContextCompat.getColor(getContext(), com.baidu.searchbox.search.style.res.R.color.SC2);
    }

    public int getBgColor() {
        if (isNewStyle()) {
            return ContextCompat.getColor(getContext(), R.color.rsse_bg_color_new_style);
        }
        return ContextCompat.getColor(getContext(), com.baidu.searchbox.search.style.res.R.color.SC31);
    }

    public void onFirstShow(String ext) {
        Intrinsics.checkNotNullParameter(ext, "ext");
        SearchRsseViewTCUtilsKt.uploadRsseLog(ext, SearchRsseViewTCUtilsKt.TOPTIPS_SHOW, (String) null);
    }

    public void onSeTipsClick(String ext, String query) {
        Intrinsics.checkNotNullParameter(ext, "ext");
        Intrinsics.checkNotNullParameter(query, "query");
        SearchRsseViewTCUtilsKt.uploadRsseLog(ext, SearchRsseViewTCUtilsKt.TOPTIPS_CORRECT_CLK, query);
    }

    public void onOriginalQueryClick(String ext, String query) {
        Intrinsics.checkNotNullParameter(ext, "ext");
        Intrinsics.checkNotNullParameter(query, "query");
        SearchRsseViewTCUtilsKt.uploadRsseLog(ext, SearchRsseViewTCUtilsKt.TOPTIPS_ORIGINAL_CLK, query);
    }

    public void onReplaceQueryClick(String ext, String query) {
        Intrinsics.checkNotNullParameter(ext, "ext");
        Intrinsics.checkNotNullParameter(query, "query");
        SearchRsseViewTCUtilsKt.uploadRsseLog(ext, SearchRsseViewTCUtilsKt.TOPTIPS_CORRECT_CLK, query);
    }

    public final void bind(LifecycleOwner lifecycleOwner, ISearchRsseViewModel viewModel2) {
        if (lifecycleOwner != null && viewModel2 != null) {
            this.viewModel = viewModel2;
            if (viewModel2 != null) {
                viewModel2.bindData(lifecycleOwner, this);
            }
        }
    }

    public void onChanged(SearchRsseModel data2) {
        ISearchRsseViewModel iSearchRsseViewModel = this.viewModel;
        if (iSearchRsseViewModel != null) {
            iSearchRsseViewModel.showRsseView(Boolean.valueOf(data2 != null));
        }
        if (data2 != null) {
            this.rootView.setVisibility(0);
            this.data = data2;
            onNightModeChanged();
        }
    }
}
