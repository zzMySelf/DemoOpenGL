package com.baidu.searchbox.video.feedflow.detail.toptitle;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryModel;
import com.baidu.searchbox.video.feedflow.detail.summary.VideoFlowTargetModel;
import com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleViewStyle;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeState;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010#\u001a\u00020\u001fJ\b\u0010$\u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u0012H\u0016J \u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u001fH\u0002J\b\u00103\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u00064"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/toptitle/TopTitleComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "textHeight", "", "topTitleViewStyle", "Lcom/baidu/searchbox/video/feedflow/detail/toptitle/TopTitleViewStyle;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle$delegate", "Lkotlin/Lazy;", "calculateCurrentLineCount", "title", "", "currentLineTextCount", "checkDataAndShow", "", "createView", "Landroid/view/View;", "findTargetPositionEmoji", "content", "position", "(Ljava/lang/String;I)Ljava/lang/Integer;", "getAvailableTitleWidth", "", "getHorizontalMargin", "getVerticalMargin", "initView", "isEnglishLetter", "", "c", "", "isPunctuation", "isTopTitleVisible", "needShow", "needShowTitle", "isShowText", "onAttachToManager", "reduceCurrentLineCount", "titleLength", "curTextCount", "preTextCount", "setData", "summaryModel", "Lcom/baidu/searchbox/video/feedflow/detail/summary/SummaryModel;", "setTextviewVisible", "isShow", "updateTextHeight", "isTextNeedTwoLine", "updateTitleViewMaxLines", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopTitleComponent.kt */
public final class TopTitleComponent extends LiveDataComponent {
    private int textHeight = Integer.MAX_VALUE;
    private TopTitleViewStyle topTitleViewStyle = TopTitleViewStyle.VerticalStyle.INSTANCE;
    private final Lazy tvTitle$delegate = LazyKt.lazy(new TopTitleComponent$tvTitle$2(this));

    private final TextView getTvTitle() {
        return (TextView) this.tvTitle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextView initView() {
        TextView textView = new TextView(getContext());
        TextView $this$initView_u24lambda_u2d0 = textView;
        $this$initView_u24lambda_u2d0.setGravity(81);
        $this$initView_u24lambda_u2d0.setIncludeFontPadding(false);
        $this$initView_u24lambda_u2d0.setMaxLines(2);
        $this$initView_u24lambda_u2d0.setMinLines(1);
        $this$initView_u24lambda_u2d0.setEllipsize(TextUtils.TruncateAt.END);
        FontSizeHelperKt.setVideoScaledSizeRes$default($this$initView_u24lambda_u2d0, R.dimen.F_T_X060, 0, 0, 6, (Object) null);
        $this$initView_u24lambda_u2d0.setLineSpacing($this$initView_u24lambda_u2d0.getResources().getDimension(com.baidu.searchbox.video.feedflow.component.R.dimen.video_flow_dimens_5dp), 1.0f);
        $this$initView_u24lambda_u2d0.setTextColor(ContextCompat.getColor($this$initView_u24lambda_u2d0.getContext(), R.color.FC409));
        $this$initView_u24lambda_u2d0.setTypeface(Typeface.DEFAULT_BOLD);
        return textView;
    }

    public View createView() {
        return getTvTitle();
    }

    public void onAttachToManager() {
        FontSizeState fontSizeState;
        MutableLiveData<Unit> action;
        TopTitleState $this$onAttachToManager_u24lambda_u2d5;
        super.onAttachToManager();
        getManager().registerServices(ITopTextTitleService.class, new TopTextTitleComponentService(this));
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d5 = (TopTitleState) store.subscribe((Class<T>) TopTitleState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d5.getShow().observe(this, new TopTitleComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d5.getData().observe(this, new TopTitleComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d5.getHeight().observe(this, new TopTitleComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d5.getUpdateStyle().observe(this, new TopTitleComponent$$ExternalSyntheticLambda3(this, $this$onAttachToManager_u24lambda_u2d5));
        }
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && (fontSizeState = (FontSizeState) $this$subscribe$iv.subscribe(FontSizeState.class)) != null && (action = fontSizeState.getAction()) != null) {
            action.observe(this, new TopTitleComponent$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-1  reason: not valid java name */
    public static final void m5864onAttachToManager$lambda5$lambda1(TopTitleComponent this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkDataAndShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-2  reason: not valid java name */
    public static final void m5865onAttachToManager$lambda5$lambda2(TopTitleComponent this$0, SummaryModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (model == null) {
            this$0.textHeight = Integer.MAX_VALUE;
            this$0.getTvTitle().setText("");
            this$0.getTvTitle().setVisibility(4);
        } else {
            this$0.setData(model);
        }
        this$0.checkDataAndShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-3  reason: not valid java name */
    public static final void m5866onAttachToManager$lambda5$lambda3(TopTitleComponent this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkDataAndShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-4  reason: not valid java name */
    public static final void m5867onAttachToManager$lambda5$lambda4(TopTitleComponent this$0, TopTitleState $this_run, Boolean updateStyle) {
        TopTitleViewStyle topTitleViewStyle2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        Intrinsics.checkNotNullExpressionValue(updateStyle, "updateStyle");
        if (updateStyle.booleanValue()) {
            topTitleViewStyle2 = TopTitleViewStyle.HorizontalStyle.INSTANCE;
        } else {
            topTitleViewStyle2 = TopTitleViewStyle.VerticalStyle.INSTANCE;
        }
        this$0.topTitleViewStyle = topTitleViewStyle2;
        DIFactory.INSTANCE.post(new TopTitleComponent$onAttachToManager$1$4$1($this_run, this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6  reason: not valid java name */
    public static final void m5868onAttachToManager$lambda6(TopTitleComponent this$0, Unit it) {
        MutableLiveData<SummaryModel> data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FontSizeHelperKt.setVideoScaledSizeRes$default(this$0.getTvTitle(), R.dimen.F_T_X060, 0, 0, 6, (Object) null);
        Store $this$select$iv = this$0.getStore();
        SummaryModel summaryModel = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            TopTitleState topTitleState = (TopTitleState) (commonState != null ? commonState.select(TopTitleState.class) : null);
            if (!(topTitleState == null || (data = topTitleState.getData()) == null)) {
                summaryModel = data.getValue();
            }
        }
        SummaryModel model = summaryModel;
        if (model != null) {
            this$0.setData(model);
            this$0.checkDataAndShow();
        }
    }

    private final float getAvailableTitleWidth() {
        return ((float) DIFactory.INSTANCE.getDisplayWidth()) - (((float) getHorizontalMargin()) * ((float) 2));
    }

    private final boolean isPunctuation(char c2) {
        return Pattern.compile("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]").matcher(String.valueOf(c2)).find();
    }

    private final boolean isEnglishLetter(char c2) {
        if ('a' <= c2 && c2 < '{') {
            return true;
        }
        return 'A' <= c2 && c2 < '[';
    }

    /* access modifiers changed from: private */
    public final void checkDataAndShow() {
        AbsState state;
        TopTitleState topTitleState;
        MutableLiveData<SummaryModel> data;
        Store<AbsState> store;
        AbsState state2;
        TopTitleState topTitleState2;
        MutableLiveData<Integer> height;
        Integer value;
        AbsState state3;
        TopTitleState topTitleState3;
        MutableLiveData<Boolean> show;
        Boolean value2;
        Store<AbsState> store2 = getStore();
        if (store2 != null && (state = store2.getState()) != null && (topTitleState = (TopTitleState) state.select(TopTitleState.class)) != null && (data = topTitleState.getData()) != null && data.getValue() != null && (store = getStore()) != null && (state2 = store.getState()) != null && (topTitleState2 = (TopTitleState) state2.select(TopTitleState.class)) != null && (height = topTitleState2.getHeight()) != null && (value = height.getValue()) != null) {
            int height2 = value.intValue();
            Store<AbsState> store3 = getStore();
            if (store3 != null && (state3 = store3.getState()) != null && (topTitleState3 = (TopTitleState) state3.select(TopTitleState.class)) != null && (show = topTitleState3.getShow()) != null && (value2 = show.getValue()) != null) {
                needShowTitle(value2.booleanValue() && height2 >= this.textHeight);
                updateTitleViewMaxLines();
            }
        }
    }

    private final void updateTitleViewMaxLines() {
        getTvTitle().setMaxLines(2);
    }

    /* access modifiers changed from: private */
    public final void setData(SummaryModel summaryModel) {
        SpannableString titleSpanStr;
        int secondLineTextCount;
        String secondLineText;
        boolean z = false;
        if (summaryModel.isOffline() || !summaryModel.getNeedShow() || !needShow()) {
            setTextviewVisible(false);
            return;
        }
        TextView $this$setData_u24lambda_u2d8 = getTvTitle();
        $this$setData_u24lambda_u2d8.setMaxLines(2);
        FontSizeHelperKt.setVideoScaledSizeRes$default($this$setData_u24lambda_u2d8, R.dimen.F_T_X060, 0, 0, 6, (Object) null);
        $this$setData_u24lambda_u2d8.setTypeface(Typeface.DEFAULT_BOLD);
        $this$setData_u24lambda_u2d8.getPaint().setStrokeWidth(0.0f);
        $this$setData_u24lambda_u2d8.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        ViewGroup.LayoutParams layoutParams = $this$setData_u24lambda_u2d8.getLayoutParams();
        FrameLayout.LayoutParams $this$setData_u24lambda_u2d8_u24lambda_u2d7 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if ($this$setData_u24lambda_u2d8_u24lambda_u2d7 != null) {
            int horizontalMargin = DIFactory.INSTANCE.dp2px(12.0f);
            $this$setData_u24lambda_u2d8_u24lambda_u2d7.leftMargin = horizontalMargin;
            $this$setData_u24lambda_u2d8_u24lambda_u2d7.rightMargin = horizontalMargin;
            $this$setData_u24lambda_u2d8_u24lambda_u2d7.bottomMargin = $this$setData_u24lambda_u2d8.getContext().getResources().getDimensionPixelSize(com.baidu.searchbox.video.feedflow.component.R.dimen.video_flow_dimens_18dp);
        }
        String title = summaryModel.getTitle();
        if (title == null) {
            title = "";
        }
        String str = title;
        ArrayList<VideoFlowTargetModel> $this$forEach$iv = summaryModel.getLinkAttribute();
        if ($this$forEach$iv != null) {
            for (VideoFlowTargetModel model : $this$forEach$iv) {
                String key = model.getKey();
                if (key != null) {
                    str = StringsKt.replace$default(str, key, "", false, 4, (Object) null);
                }
            }
        }
        if (StringsKt.endsWith$default((CharSequence) str, 12290, false, 2, (Object) null) && !StringsKt.endsWith$default(str, "。。", false, 2, (Object) null)) {
            String substring = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            str = substring;
        }
        float[] measureWidthArray = new float[1];
        float titleWidth = getAvailableTitleWidth();
        boolean isExceedMaxLine = false;
        int firstLineTextCount = reduceCurrentLineCount(str.length(), getTvTitle().getPaint().breakText(str, 0, str.length(), true, titleWidth, measureWidthArray), 0);
        boolean isTextNeedTwoLine = firstLineTextCount != str.length();
        if (isTextNeedTwoLine) {
            int firstLineTextCount2 = calculateCurrentLineCount(str, firstLineTextCount);
            int firstLineTextCount3 = firstLineTextCount2;
            int secondLineTextCount2 = getTvTitle().getPaint().breakText(str, firstLineTextCount2, str.length(), true, titleWidth, measureWidthArray);
            if (secondLineTextCount2 + firstLineTextCount3 >= str.length() || getTvTitle().getMaxLines() != 3) {
                secondLineTextCount = secondLineTextCount2;
            } else {
                int secondLineTextCount3 = reduceCurrentLineCount(str.length(), secondLineTextCount2, firstLineTextCount3);
                isExceedMaxLine = true;
                String substring2 = str.substring(firstLineTextCount3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                secondLineTextCount = calculateCurrentLineCount(substring2, secondLineTextCount3);
            }
            if (firstLineTextCount3 > 0) {
                String firstLineText = str.substring(0, firstLineTextCount3);
                Intrinsics.checkNotNullExpressionValue(firstLineText, "this as java.lang.String…ing(startIndex, endIndex)");
                String thirdLineText = "";
                if (isExceedMaxLine) {
                    int endIndex = secondLineTextCount + firstLineTextCount3;
                    String substring3 = str.substring(firstLineTextCount3, endIndex);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    secondLineText = substring3;
                    String secondLineText2 = str.substring(endIndex);
                    Intrinsics.checkNotNullExpressionValue(secondLineText2, "this as java.lang.String).substring(startIndex)");
                    thirdLineText = secondLineText2;
                } else {
                    secondLineText = str.substring(firstLineTextCount3);
                    Intrinsics.checkNotNullExpressionValue(secondLineText, "this as java.lang.String).substring(startIndex)");
                }
                str = firstLineText + 10 + secondLineText;
                if (thirdLineText.length() > 0) {
                    z = true;
                }
                if (z) {
                    str = str + 10 + thirdLineText;
                    int i2 = firstLineTextCount3;
                } else {
                    int i3 = firstLineTextCount3;
                }
            } else {
                int i4 = firstLineTextCount3;
            }
        }
        updateTextHeight(isTextNeedTwoLine);
        if (!StringsKt.isBlank(str)) {
            titleSpanStr = EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), str, getTvTitle());
        } else {
            titleSpanStr = new SpannableString(str);
        }
        getTvTitle().setText(titleSpanStr);
    }

    private final int calculateCurrentLineCount(String title, int currentLineTextCount) {
        Integer positionEmoji;
        int currentLineTextCountShadow = currentLineTextCount;
        while (currentLineTextCountShadow > 0 && isPunctuation(title.charAt(currentLineTextCountShadow))) {
            currentLineTextCountShadow--;
        }
        while (currentLineTextCountShadow > 0 && isEnglishLetter(title.charAt(currentLineTextCountShadow)) && isEnglishLetter(title.charAt(currentLineTextCountShadow - 1))) {
            currentLineTextCountShadow--;
        }
        if (currentLineTextCountShadow > 0 && Character.isLowSurrogate(title.charAt(currentLineTextCountShadow)) && Character.isHighSurrogate(title.charAt(currentLineTextCountShadow - 1))) {
            currentLineTextCountShadow--;
        }
        if (currentLineTextCountShadow <= 0 || (positionEmoji = findTargetPositionEmoji(title, currentLineTextCountShadow - 1)) == null || positionEmoji.intValue() <= 0) {
            return currentLineTextCountShadow;
        }
        return positionEmoji.intValue();
    }

    private final int reduceCurrentLineCount(int titleLength, int curTextCount, int preTextCount) {
        int currentLineTextCount = curTextCount;
        int totalCountDiff = (titleLength - currentLineTextCount) - preTextCount;
        boolean z = false;
        if (1 <= totalCountDiff && totalCountDiff < 4) {
            z = true;
        }
        if (z) {
            return currentLineTextCount - (4 - totalCountDiff);
        }
        return currentLineTextCount;
    }

    private final Integer findTargetPositionEmoji(String content, int position) {
        if (StringsKt.isBlank(content)) {
            return null;
        }
        Matcher matcherEmotion = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(new SpannableString(content));
        while (matcherEmotion.find()) {
            String key = matcherEmotion.group();
            int start = matcherEmotion.start();
            if (start <= position && key.length() + start > position) {
                if (EmotionUtils.getInstance().getEmotionFileByName(EmotionType.EMOTION_CLASSIC_TYPE, key) != null) {
                    return Integer.valueOf(start);
                }
                Integer num = null;
                return null;
            }
        }
        return null;
    }

    private final void needShowTitle(boolean isShowText) {
        if (!isShowText) {
            setTextviewVisible(false);
        } else if (this.topTitleViewStyle instanceof TopTitleViewStyle.HorizontalStyle) {
            setTextviewVisible(false);
        } else {
            setTextviewVisible(true);
        }
    }

    private final void setTextviewVisible(boolean isShow) {
        if (isShow) {
            getTvTitle().setVisibility(0);
        } else {
            getTvTitle().setVisibility(4);
        }
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(new UploadTopTitleStatistic(isShow));
        }
    }

    public final boolean isTopTitleVisible() {
        return getTvTitle().getVisibility() == 0;
    }

    private final boolean needShow() {
        return DIFactory.INSTANCE.getDisplayWidth() >= 1080;
    }

    private final void updateTextHeight(boolean isTextNeedTwoLine) {
        int i2;
        if (!isTextNeedTwoLine) {
            i2 = getTvTitle().getLineHeight() + getVerticalMargin();
        } else if (isTextNeedTwoLine) {
            i2 = (getTvTitle().getLineHeight() * 2) + ((int) getTvTitle().getLineSpacingExtra()) + getVerticalMargin();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.textHeight = i2;
    }

    private final int getVerticalMargin() {
        ViewGroup.LayoutParams layoutParams = getTvTitle().getLayoutParams();
        ViewGroup.MarginLayoutParams params = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (params != null) {
            return params.topMargin + params.bottomMargin;
        }
        return DIFactory.INSTANCE.dp2px(36.0f);
    }

    private final int getHorizontalMargin() {
        ViewGroup.LayoutParams layoutParams = getTvTitle().getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        return marginLayoutParams != null ? marginLayoutParams.leftMargin : DIFactory.INSTANCE.dp2px(12.0f);
    }
}
