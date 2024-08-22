package com.baidu.searchbox.feed.util.processor;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBaseModelHelper;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataStar;
import com.baidu.searchbox.feed.model.FeedQuoteDtModel;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.template.statistic.FeedChannelConstants;
import com.baidu.searchbox.feed.template.statistic.FeedTemplateStatTable;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.util.processor.FeedFoldTextProcessor;
import com.baidu.searchbox.ui.UnifyTextView;
import java.util.ArrayList;

public class FeedTextProcessor {
    public static final int FEED_STAR_TITLE_MAX_LINES = 3;
    public static final int HOT_STAR_TITLE_MAX_LINES = 7;
    public static final float MAX_TEXT_SPACING = 36.0f;
    private static final int TEXT_MARGIN_DISTANCE = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X001);

    public static void processText(Context context, TextView textView, FeedBaseModel model, boolean isStable) {
        if (model != null && textView != null && context != null) {
            processTextNoCache(context, textView, model, isStable, model.getHelper());
        }
    }

    private static void processTextByCache(Context context, TextView textView, FeedBaseModel model, FeedBaseModelHelper helper) {
        if (helper.isTitlePrefixValid() && helper.getFeedTitle() != null && !helper.getFeedTitle().isEmpty()) {
            textView.setMovementMethod((MovementMethod) null);
            textView.setTextColor(context.getResources().getColor(FeedNormalTextProcessor.getFeedTitleColor(context, model)));
        } else if (!helper.isRichTextTitle() && !helper.isTruncationText() && !helper.isTopicText() && !helper.isShortUrlText() && !helper.isAtText() && !helper.isEmotionTextTag()) {
            textView.setMovementMethod((MovementMethod) null);
            textView.setTextColor(context.getResources().getColor(FeedNormalTextProcessor.getFeedTitleColor(context, model)));
        }
        if (textView instanceof UnifyTextView) {
            ((UnifyTextView) textView).setTextWithUnifiedPadding(helper.processText, TextView.BufferType.NORMAL);
        } else {
            textView.setText(helper.processText, TextView.BufferType.NORMAL);
        }
    }

    private static void processTextNoCache(Context context, TextView textView, FeedBaseModel model, boolean isStable, FeedBaseModelHelper helper) {
        if (helper.isTitlePrefixValid() && helper.getFeedTitle() != null && !helper.getFeedTitle().isEmpty()) {
            textView.setMovementMethod((MovementMethod) null);
            FeedNormalTextProcessor.createPrefixNormalText(context, textView, model);
        } else if (helper.isRichTextTitle()) {
            processRichText(context, textView, model, isStable);
        } else if (helper.isTruncationText() || helper.isTopicText() || helper.isShortUrlText() || helper.isAtText() || helper.isEmotionTextTag()) {
            preSetText(textView, model);
            if (textView.getMeasuredWidth() > 0) {
                internalProcess(context, textView, model);
                return;
            }
            int offset = TEXT_MARGIN_DISTANCE * 2;
            if (FeedUtil.isTabletBasic()) {
                offset = FeedTemplateUtil.getPadEdgeBlankWidth(context) * 2;
            }
            textView.measure(View.MeasureSpec.makeMeasureSpec(FeedTemplateUtil.getCalculateWidth(context) - offset, 1073741824), 0);
            internalProcess(context, textView, model);
        } else {
            textView.setMovementMethod((MovementMethod) null);
            FeedNormalTextProcessor.createNormalText(context, textView, model);
        }
    }

    public static void processEvolutionTitleWithDurationZone(Context context, FeedBaseModel model, TextView textView, int rightOffsetX) {
        if (textView != null && context != null && model != null) {
            FeedBaseModelHelper helper = model.getHelper();
            processEvolutionTitleWithDurationZoneNoCache(context, textView, model, rightOffsetX);
        }
    }

    private static void processEvolutionTitleWithDurationZoneByCache(TextView textView, FeedBaseModel model) {
        FeedBaseModelHelper helper = model.getHelper();
        if (helper.isTitlePrefixValid() && helper.getFeedTitle() != null && !helper.getFeedTitle().isEmpty()) {
            textView.setMovementMethod((MovementMethod) null);
        }
        if (textView instanceof UnifyTextView) {
            ((UnifyTextView) textView).setTextWithUnifiedPadding(helper.evolutionWithZoneText, TextView.BufferType.NORMAL);
        } else {
            textView.setText(helper.evolutionWithZoneText, TextView.BufferType.NORMAL);
        }
    }

    private static void processEvolutionTitleWithDurationZoneNoCache(Context context, TextView textView, FeedBaseModel model, int rightOffsetX) {
        SpannableString spanText = new SpannableString(model.getHelper().getFeedTitle());
        FeedBaseModelHelper helper = model.getHelper();
        if (helper.isTitlePrefixValid() && helper.getFeedTitle() != null && !helper.getFeedTitle().isEmpty()) {
            textView.setMovementMethod((MovementMethod) null);
            spanText = FeedNormalTextProcessor.getPrefixNormalText(context, textView, model, 0);
        }
        SpannableStringBuilder finalStr = new SpannableStringBuilder(spanText);
        if (rightOffsetX > 0) {
            finalStr = FeedEllipsisTextProcessor.createEvolutionEllipsisText(textView, finalStr, rightOffsetX);
        }
        if (textView instanceof UnifyTextView) {
            ((UnifyTextView) textView).setTextWithUnifiedPadding(finalStr, TextView.BufferType.NORMAL);
        } else {
            textView.setText(finalStr, TextView.BufferType.NORMAL);
        }
    }

    private static void preSetText(TextView textView, FeedBaseModel model) {
        if (TextUtils.isEmpty(textView.getText())) {
            String title = acquireRichText(model, model.getHelper());
            if (textView instanceof UnifyTextView) {
                ((UnifyTextView) textView).setTextWithUnifiedPadding(title, TextView.BufferType.NORMAL);
            } else {
                textView.setText(title, TextView.BufferType.NORMAL);
            }
        }
    }

    private static String acquireRichText(FeedBaseModel model, FeedBaseModelHelper helper) {
        String title;
        if (!helper.isNeedDynamicFold() || model.data.isFolded || ((FeedItemDataStar) model.data).isFirstCard) {
            title = helper.getFeedTitle();
        } else {
            title = helper.getDynamicFoldTitle();
        }
        if (helper.isShortUrlText()) {
            return FeedShortUrlTextProcessor.replaceTitle(model.data.titleLink.shortUrlTag.shortUrlList, title);
        }
        return title;
    }

    public static void processTextExt(final Context context, final TextView textView, final FeedBaseModel model, final FeedQuoteDtModel quoteDtModel, boolean isStable) {
        if (model != null && quoteDtModel != null && textView != null && context != null) {
            if (FeedEllipsisTextProcessor.isTruncationTextExt(quoteDtModel) || FeedTopicTextProcessor.isTopicTextExt(quoteDtModel) || FeedShortUrlTextProcessor.isShortUrlTextExt(quoteDtModel) || FeedAtTextProcessor.isAtTextExt(quoteDtModel) || FeedEmotionTextProcessor.isEmotionTextTagExt(quoteDtModel)) {
                textView.post(new Runnable() {
                    public void run() {
                        if (textView.getMeasuredWidth() > 0) {
                            FeedTextProcessor.internalProcessExt(context, textView, model, quoteDtModel);
                        } else {
                            textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                                public boolean onPreDraw() {
                                    textView.getViewTreeObserver().removeOnPreDrawListener(this);
                                    FeedTextProcessor.internalProcessExt(context, textView, model, quoteDtModel);
                                    return false;
                                }
                            });
                        }
                    }
                });
                return;
            }
            textView.setMovementMethod((MovementMethod) null);
            FeedNormalTextProcessor.createNormalTextExt(context, textView, model, quoteDtModel);
        }
    }

    /* access modifiers changed from: private */
    public static void internalProcess(final Context context, final TextView textView, final FeedBaseModel model) {
        FeedBaseModelHelper helper = model.getHelper();
        SpannableStringBuilder spannableBuilder = new SpannableStringBuilder(acquireRichText(model, helper));
        if (helper.isEmotionTextTag()) {
            FeedEmotionTextProcessor.createEmotionText(textView, model, spannableBuilder);
        }
        if (helper.isSearchHotChannel()) {
            FeedHotQueryTextProcessor.processQueryRedItem(model, spannableBuilder);
        }
        if (helper.isTopicText()) {
            FeedTopicTextProcessor.createTopicText(context, textView, model, spannableBuilder);
        }
        if (helper.isAtText()) {
            FeedAtTextProcessor.createAtText(context, textView, model, spannableBuilder);
        }
        if (helper.isShortUrlText()) {
            FeedShortUrlTextProcessor.createShortUrlText(context, textView, model, spannableBuilder);
        }
        if (helper.isNeedDynamicFold()) {
            if (!model.data.isFolded) {
                FeedEllipsisTextProcessor.createEllipsisText(textView, model, spannableBuilder, model.data.titleLink.fullTextTag.title);
            } else {
                textView.setMaxLines(Integer.MAX_VALUE);
            }
        } else if (helper.isTruncationText()) {
            FeedEllipsisTextProcessor.createEllipsisText(textView, model, spannableBuilder, model.data.titleLink.fullTextTag.title);
        }
        if (helper.isNeedFoldText()) {
            if (!model.data.isFolded) {
                FeedEllipsisTextProcessor.createFoldOrFullEllipsisText(context, textView, model, spannableBuilder, FeedFoldTextProcessor.FOLD_FLAG);
                FeedFoldTextProcessor.createFoldText(context, textView, model, spannableBuilder, new FeedFoldTextProcessor.OnFoldClickListener() {
                    public void onClick(View view2) {
                        FeedBaseModel.this.data.isFolded = true;
                        FeedTemplateStatTable.getInstance().get(FeedBaseModel.this.runtimeStatus.channelId).richTextExpandClick(FeedBaseModel.this);
                        FeedTextProcessor.internalProcess(context, textView, FeedBaseModel.this);
                    }
                });
            } else {
                FeedEllipsisTextProcessor.createFoldOrFullEllipsisText(context, textView, model, spannableBuilder, FeedFoldTextProcessor.FULL_FLAG);
            }
        }
        if ((helper.isTopicText() || helper.isShortUrlText() || helper.isEmotionTextTag() || helper.isAtText()) && !helper.isTruncationText() && !helper.isNeedFoldText()) {
            FeedEllipsisTextProcessor.createDefaultEllipsisText(textView, model, spannableBuilder);
        }
        textView.setTextColor(context.getResources().getColor(FeedNormalTextProcessor.getFeedTitleColor(context, model)));
        if (textView instanceof UnifyTextView) {
            ((UnifyTextView) textView).setTextWithUnifiedPadding(spannableBuilder, TextView.BufferType.NORMAL);
        } else {
            textView.setText(spannableBuilder, TextView.BufferType.NORMAL);
        }
    }

    /* access modifiers changed from: private */
    public static void internalProcessExt(Context context, TextView textView, FeedBaseModel model, FeedQuoteDtModel quoteDtModel) {
        String title = quoteDtModel.title;
        if (FeedShortUrlTextProcessor.isShortUrlTextExt(quoteDtModel)) {
            title = FeedShortUrlTextProcessor.replaceTitle(quoteDtModel.titleLinkExt.shortUrlTag.shortUrlList, title);
        }
        SpannableStringBuilder spannableBuilder = new SpannableStringBuilder(title);
        if (FeedEmotionTextProcessor.isEmotionTextTagExt(quoteDtModel)) {
            FeedEmotionTextProcessor.createEmotionTextExt(textView, model, quoteDtModel, spannableBuilder);
        }
        if (FeedTopicTextProcessor.isTopicTextExt(quoteDtModel)) {
            FeedTopicTextProcessor.createTopicTextExt(context, textView, model, quoteDtModel, spannableBuilder);
        }
        if (FeedAtTextProcessor.isAtTextExt(quoteDtModel)) {
            FeedAtTextProcessor.createAtTextExt(context, textView, model, quoteDtModel, spannableBuilder);
        }
        if (FeedShortUrlTextProcessor.isShortUrlTextExt(quoteDtModel)) {
            FeedShortUrlTextProcessor.createShortUrlTextExt(context, textView, model, quoteDtModel, spannableBuilder);
        }
        if (FeedEllipsisTextProcessor.isTruncationTextExt(quoteDtModel)) {
            FeedEllipsisTextProcessor.createEllipsisTextExt(textView, model, quoteDtModel, spannableBuilder);
        }
        if ((FeedTopicTextProcessor.isTopicTextExt(quoteDtModel) || FeedShortUrlTextProcessor.isShortUrlTextExt(quoteDtModel) || FeedEmotionTextProcessor.isEmotionTextTagExt(quoteDtModel) || FeedAtTextProcessor.isAtTextExt(quoteDtModel)) && !FeedEllipsisTextProcessor.isTruncationTextExt(quoteDtModel)) {
            FeedEllipsisTextProcessor.createDefaultEllipsisText(textView, model, spannableBuilder);
        }
        textView.setTextColor(context.getResources().getColor(com.baidu.searchbox.feed.core.R.color.feed_quote_right_text));
        if (textView instanceof UnifyTextView) {
            ((UnifyTextView) textView).setTextWithUnifiedPadding(spannableBuilder, TextView.BufferType.NORMAL);
        } else {
            textView.setText(spannableBuilder, TextView.BufferType.NORMAL);
        }
    }

    public static void processRichText(Context context, TextView textView, FeedBaseModel model, boolean isStable) {
        if (model != null && model.data != null) {
            FeedRichTextProcessor.createRichText(context, textView, model, model.data.richTitles, isStable);
        }
    }

    public static void processRichText(Context context, TextView textView, FeedBaseModel model, ArrayList<FeedItemData.RichTitle> riches, boolean isStable) {
        FeedRichTextProcessor.createRichText(context, textView, model, riches, isStable);
    }

    public static SpannableStringBuilder getTextWithEllipsisTag(String content, int textViewWidth, TextView textView, String ellipsisTag, int ellipsisTagColor) {
        return FeedEllipsisTextProcessor.buildEllipsisTagSpannable(new SpannableStringBuilder(content), textViewWidth, textView, ellipsisTag, ellipsisTagColor);
    }

    public static void setDynamicTplTextMaxLines(TextView textView, FeedBaseModel model) {
        if (model != null && model.runtimeStatus != null && model.data != null && textView != null && !FeedChannelConstants.isSearchHotChannel(model.runtimeStatus.channelId)) {
            if (model.data.titleMaxLines > 0 && model.data.titleMaxLines < 7) {
                textView.setMaxLines(model.data.titleMaxLines);
            } else if (FeedChannelConstants.isFeedChannel(model.runtimeStatus.channelId)) {
                textView.setMaxLines(3);
            } else if (!(model.data instanceof FeedItemDataStar) || !((FeedItemDataStar) model.data).isFirstCard) {
                textView.setMaxLines(7);
            } else {
                textView.setMaxLines(Integer.MAX_VALUE);
            }
        }
    }

    public static void setDynamicImmersiveTextSpacing(TextView textView, float textSize, FeedBaseModel model, boolean isEnforce) {
        if (textView != null) {
            if (isDynamicImmersive(model) || isEnforce) {
                textView.setLineSpacing(Math.min((textSize > 0.0f ? textSize : textView.getTextSize()) * 0.7f, 36.0f), 1.0f);
            }
        }
    }

    public static void setDynamicTemplateTitleLineSpace(TextView titleView, FeedBaseModel model) {
        int lineSpace;
        if (titleView != null && model != null && (model.data instanceof FeedItemDataStar) && (lineSpace = ((FeedItemDataStar) model.data).titleLineSpace) > 0) {
            titleView.setLineSpacing((float) DeviceUtils.ScreenInfo.dp2px(titleView.getContext(), (float) lineSpace), 1.0f);
        }
    }

    private static boolean isDynamicImmersive(FeedBaseModel model) {
        if (model == null || !(model.data instanceof FeedItemDataStar)) {
            return false;
        }
        return TextUtils.equals(((FeedItemDataStar) model.data).templateStyle, "1");
    }
}
