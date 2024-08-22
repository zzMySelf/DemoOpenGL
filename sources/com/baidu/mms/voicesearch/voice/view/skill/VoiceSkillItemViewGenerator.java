package com.baidu.mms.voicesearch.voice.view.skill;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.common.operation.CommonOperationModel;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceSkinController;
import com.baidu.mms.voicesearch.voice.bean.dao.VoiceSkillContentModel;
import com.baidu.mms.voicesearch.voice.common.Tools;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.searchbox.home.tabs.BaseTabItemView;
import com.baidu.speechbundle.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J[\u0010\u0003\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eJ[\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eJS\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e¨\u0006\u0015"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/skill/VoiceSkillItemViewGenerator;", "", "()V", "initApplicationSubView", "Lkotlin/Pair;", "Landroid/widget/RelativeLayout;", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "content", "Lcom/baidu/mms/voicesearch/voice/bean/dao/VoiceSkillContentModel;", "isFirst", "", "onClickCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "initSkillSubView", "Landroid/widget/LinearLayout;", "initWhisperView", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceSkillItemViewGenerator.kt */
public final class VoiceSkillItemViewGenerator {
    public final Pair<LinearLayout, LinearLayout.LayoutParams> initSkillSubView(Context context, VoiceSkillContentModel content, boolean isFirst, Function1<? super VoiceSkillContentModel, Unit> onClickCallBack) {
        String descriptionTextColor;
        String tryButtonColor;
        Context context2 = context;
        VoiceSkillContentModel voiceSkillContentModel = content;
        if (context2 == null) {
            Function1<? super VoiceSkillContentModel, Unit> function1 = onClickCallBack;
            return null;
        } else if (voiceSkillContentModel == null) {
            Function1<? super VoiceSkillContentModel, Unit> function12 = onClickCallBack;
            return null;
        } else {
            LinearLayout subView = new LinearLayout(context2);
            LinearLayout.LayoutParams subviewLp = new LinearLayout.LayoutParams(-1, -2);
            subView.setOrientation(0);
            if (isFirst) {
                subviewLp.topMargin = (int) Tools.dip2px(25.0f);
            } else {
                subviewLp.topMargin = (int) Tools.dip2px(22.0f);
            }
            subviewLp.leftMargin = (int) Tools.dip2px(14.0f);
            TextView descriptionView = new TextView(context2);
            descriptionView.setTextSize(Tools.px2sp(context2, Tools.dip2px(14.0f)));
            String tryTextColor = "#B3FFFFFF";
            if (SkinManager.getInstance().isNightMode()) {
                descriptionTextColor = tryTextColor;
            } else {
                descriptionTextColor = CommonOperationModel.BOTTOM_BAR_TEXT_DEFAULT_DAY_COLOR;
            }
            descriptionView.setTextColor(Color.parseColor(descriptionTextColor));
            descriptionView.post(new VoiceSkillItemViewGenerator$$ExternalSyntheticLambda0(voiceSkillContentModel, descriptionView));
            LinearLayout.LayoutParams descriptionViewLp = new LinearLayout.LayoutParams((int) Tools.dip2px(189.0f), -2);
            descriptionView.setMaxLines(1);
            descriptionViewLp.gravity = 16;
            subView.addView(descriptionView, descriptionViewLp);
            TextView tryButton = new TextView(context2);
            tryButton.setTextSize(Tools.px2sp(context2, Tools.dip2px(11.0f)));
            tryButton.setText(context2.getString(R.string.voice_skill_pop_window_try));
            if (!SkinManager.getInstance().isNightMode()) {
                tryTextColor = "#4E6EF2";
            }
            tryButton.setTextColor(Color.parseColor(tryTextColor));
            tryButton.setGravity(17);
            float tryButtonRadius = Tools.dip2px(13.0f);
            if (SkinManager.getInstance().isNightMode()) {
                tryButtonColor = "#1AFFFFFF";
            } else {
                tryButtonColor = "#1A4E6EF2";
            }
            tryButton.setBackground(VoiceSkinController.Companion.getInstance().createShape(-1, tryButtonRadius, tryButtonRadius, tryButtonRadius, tryButtonRadius, -1, (String) null, tryButtonColor));
            tryButton.setOnClickListener(new VoiceSkillItemViewGenerator$initSkillSubView$2(onClickCallBack, voiceSkillContentModel));
            LinearLayout.LayoutParams tryButtonLp = new LinearLayout.LayoutParams((int) Tools.dip2px(48.0f), (int) Tools.dip2px(24.0f));
            tryButtonLp.gravity = 16;
            tryButtonLp.leftMargin = (int) Tools.dip2px(10.0f);
            subView.addView(tryButton, tryButtonLp);
            return new Pair<>(subView, subviewLp);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initSkillSubView$lambda-0  reason: not valid java name */
    public static final void m14038initSkillSubView$lambda0(VoiceSkillContentModel $content, TextView $descriptionView) {
        String realStr;
        String str;
        Intrinsics.checkNotNullParameter($descriptionView, "$descriptionView");
        String realStr2 = $content.getMainText();
        float quoteWidth = Tools.calTextWidth("“”", $descriptionView.getPaint());
        float dotWidth = Tools.calTextWidth("...", $descriptionView.getPaint());
        if (!TextUtils.isEmpty(realStr2)) {
            float descriptionWidth = Tools.calTextWidth(realStr2, $descriptionView.getPaint()) + dotWidth;
            boolean hasDeleteWord = false;
            while (descriptionWidth > Tools.dip2px(189.0f)) {
                hasDeleteWord = true;
                if (realStr2 != null) {
                    str = realStr2.substring(0, Math.min(12, realStr2.length() - 1));
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
                } else {
                    str = null;
                }
                realStr2 = str;
                descriptionWidth = Tools.calTextWidth(realStr2, $descriptionView.getPaint()) + quoteWidth + dotWidth;
            }
            if (hasDeleteWord) {
                realStr = Typography.leftDoubleQuote + realStr2 + "...”";
            } else {
                realStr = Typography.leftDoubleQuote + realStr2 + Typography.rightDoubleQuote;
            }
            $descriptionView.setText(realStr);
        }
    }

    public final Pair<RelativeLayout, LinearLayout.LayoutParams> initApplicationSubView(Context context, VoiceSkillContentModel content, boolean isFirst, Function1<? super VoiceSkillContentModel, Unit> onClickCallBack) {
        String mainTitleTextColor;
        String dividerColor;
        Context context2 = context;
        VoiceSkillContentModel voiceSkillContentModel = content;
        if (context2 == null) {
            Function1<? super VoiceSkillContentModel, Unit> function1 = onClickCallBack;
            return null;
        } else if (voiceSkillContentModel == null) {
            Function1<? super VoiceSkillContentModel, Unit> function12 = onClickCallBack;
            return null;
        } else {
            RelativeLayout subView = new RelativeLayout(context2);
            LinearLayout.LayoutParams subviewLp = new LinearLayout.LayoutParams(-1, (int) Tools.dip2px(64.0f));
            SimpleDraweeView img = new SimpleDraweeView(context2);
            RelativeLayout.LayoutParams imgLp = new RelativeLayout.LayoutParams((int) Tools.dip2px(40.0f), (int) Tools.dip2px(40.0f));
            img.setImageURI(content.getIconUrl());
            imgLp.leftMargin = (int) Tools.dip2px(14.0f);
            imgLp.addRule(15);
            subView.addView(img, imgLp);
            TextView mainTitleView = new TextView(context2);
            mainTitleView.setIncludeFontPadding(false);
            mainTitleView.setTextSize(Tools.px2sp(context2, Tools.dip2px(14.0f)));
            mainTitleView.setText(content.getMainText());
            if (SkinManager.getInstance().isNightMode()) {
                mainTitleTextColor = "#B3FFFFFF";
            } else {
                mainTitleTextColor = CommonOperationModel.BOTTOM_BAR_TEXT_DEFAULT_DAY_COLOR;
            }
            mainTitleView.setTextColor(Color.parseColor(mainTitleTextColor));
            RelativeLayout.LayoutParams mainTitleViewLp = new RelativeLayout.LayoutParams(-2, -2);
            mainTitleView.setMaxLines(1);
            mainTitleView.setEllipsize(TextUtils.TruncateAt.END);
            mainTitleViewLp.topMargin = (int) Tools.dip2px(15.0f);
            mainTitleViewLp.leftMargin = (int) Tools.dip2px(62.0f);
            subView.addView(mainTitleView, mainTitleViewLp);
            TextView subTitleView = new TextView(context2);
            subTitleView.setIncludeFontPadding(false);
            subTitleView.setTextSize(Tools.px2sp(context2, Tools.dip2px(12.0f)));
            subTitleView.setText(content.getSubText());
            subTitleView.setTextColor(Color.parseColor(BaseTabItemView.GRAY_BADGE_COLOR));
            RelativeLayout.LayoutParams subTitleViewLp = new RelativeLayout.LayoutParams(-2, -2);
            subTitleView.setMaxLines(1);
            subTitleView.setEllipsize(TextUtils.TruncateAt.END);
            subTitleViewLp.topMargin = (int) Tools.dip2px(37.0f);
            subTitleViewLp.leftMargin = (int) Tools.dip2px(62.0f);
            subTitleViewLp.rightMargin = (int) Tools.dip2px(14.0f);
            subView.addView(subTitleView, subTitleViewLp);
            if (!isFirst) {
                View divider = new View(context2);
                if (SkinManager.getInstance().isNightMode()) {
                    dividerColor = "#26FFFFFF";
                } else {
                    dividerColor = "#E0E0E0";
                }
                divider.setBackgroundColor(Color.parseColor(dividerColor));
                RelativeLayout.LayoutParams dividerLp = new RelativeLayout.LayoutParams(-1, 1);
                dividerLp.addRule(10);
                dividerLp.leftMargin = (int) Tools.dip2px(14.0f);
                dividerLp.rightMargin = (int) Tools.dip2px(14.0f);
                subView.addView(divider, dividerLp);
            } else {
                subviewLp.topMargin = (int) Tools.dip2px(11.0f);
            }
            subView.setOnClickListener(new VoiceSkillItemViewGenerator$$ExternalSyntheticLambda1(onClickCallBack, voiceSkillContentModel));
            return new Pair<>(subView, subviewLp);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initApplicationSubView$lambda-1  reason: not valid java name */
    public static final void m14037initApplicationSubView$lambda1(Function1 $onClickCallBack, VoiceSkillContentModel $content, View it) {
        if ($onClickCallBack != null) {
            $onClickCallBack.invoke($content);
        }
    }

    public final Pair<RelativeLayout, LinearLayout.LayoutParams> initWhisperView(Context context, VoiceSkillContentModel content, Function1<? super VoiceSkillContentModel, Unit> onClickCallBack) {
        String textColor;
        String tryButtonColor;
        Context context2 = context;
        VoiceSkillContentModel voiceSkillContentModel = content;
        if (context2 == null) {
            Function1<? super VoiceSkillContentModel, Unit> function1 = onClickCallBack;
            return null;
        } else if (voiceSkillContentModel == null) {
            Function1<? super VoiceSkillContentModel, Unit> function12 = onClickCallBack;
            return null;
        } else {
            RelativeLayout subView = new RelativeLayout(context2);
            LinearLayout.LayoutParams subviewLp = new LinearLayout.LayoutParams(-1, -1);
            SimpleDraweeView micIcon = new SimpleDraweeView(context2);
            micIcon.setImageURI(content.getIconUrl());
            RelativeLayout.LayoutParams micIconLp = new RelativeLayout.LayoutParams((int) Tools.dip2px(70.0f), (int) Tools.dip2px(70.0f));
            micIconLp.topMargin = (int) Tools.dip2px(29.0f);
            micIconLp.addRule(14);
            subView.addView(micIcon, micIconLp);
            TextView textView = new TextView(context2);
            textView.setTextSize(Tools.px2sp(context2, Tools.dip2px(14.0f)));
            textView.setGravity(1);
            textView.setText(content.getMainText());
            String tryTextColor = "#B3FFFFFF";
            if (SkinManager.getInstance().isNightMode()) {
                textColor = tryTextColor;
            } else {
                textColor = CommonOperationModel.BOTTOM_BAR_TEXT_DEFAULT_DAY_COLOR;
            }
            textView.setTextColor(Color.parseColor(textColor));
            RelativeLayout.LayoutParams textLp = new RelativeLayout.LayoutParams(-1, -2);
            textLp.topMargin = (int) Tools.dip2px(127.0f);
            subView.addView(textView, textLp);
            TextView tryButton = new TextView(context2);
            tryButton.setTextSize(Tools.px2sp(context2, Tools.dip2px(12.0f)));
            tryButton.setText(context2.getString(R.string.voice_skill_pop_window_try));
            if (!SkinManager.getInstance().isNightMode()) {
                tryTextColor = "#4E6EF2";
            }
            tryButton.setTextColor(Color.parseColor(tryTextColor));
            tryButton.setGravity(17);
            float tryButtonRadius = Tools.dip2px(14.0f);
            if (SkinManager.getInstance().isNightMode()) {
                tryButtonColor = "#1AFFFFFF";
            } else {
                tryButtonColor = "#1A4E6EF2";
            }
            tryButton.setBackground(VoiceSkinController.Companion.getInstance().createShape(-1, tryButtonRadius, tryButtonRadius, tryButtonRadius, tryButtonRadius, -1, (String) null, tryButtonColor));
            tryButton.setOnClickListener(new VoiceSkillItemViewGenerator$initWhisperView$1(onClickCallBack, voiceSkillContentModel));
            RelativeLayout.LayoutParams tryButtonLp = new RelativeLayout.LayoutParams((int) Tools.dip2px(61.0f), (int) Tools.dip2px(29.0f));
            tryButtonLp.addRule(14);
            tryButtonLp.topMargin = (int) Tools.dip2px(156.0f);
            subView.addView(tryButton, tryButtonLp);
            return new Pair<>(subView, subviewLp);
        }
    }
}
