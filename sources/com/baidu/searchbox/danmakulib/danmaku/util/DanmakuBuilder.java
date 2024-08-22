package com.baidu.searchbox.danmakulib.danmaku.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.danmakulib.R;
import com.baidu.searchbox.danmakulib.constants.DanmakuPriority;
import com.baidu.searchbox.danmakulib.constants.ForceLayoutType;
import com.baidu.searchbox.danmakulib.danmaku.model.BaseCacheStuffer;
import com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext;
import com.baidu.searchbox.danmakulib.danmaku.model.SpannedCacheStuffer;
import com.baidu.searchbox.danmakulib.interfaces.ICustomViewHolder;
import com.baidu.searchbox.danmakulib.model.BarrageModel;
import com.baidu.searchbox.danmakulib.model.Notification;
import com.baidu.searchbox.danmakulib.update.DanmakuPlatformConfigListener;
import com.baidu.searchbox.danmakulib.update.PreferUtils;
import com.baidu.searchbox.danmakulib.util.BdDmkLog;
import com.baidu.searchbox.danmakulib.util.ImageUtil;
import com.baidu.searchbox.danmakulib.widget.CustomViewDanmakuController;
import com.baidu.searchbox.danmakulib.widget.SpecialDanmakuController;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.SpanStringUtils;
import java.lang.ref.SoftReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DanmakuBuilder {
    public static final String CMT_WAY_AI_CHARACTER = "7";
    private static final int COMMAND_LAST_PIC_HIGH_DP = 14;
    public static final String COMMAND_SHOW_TIMES = "command_show_times";
    private static final int COMMAND_SHOW_TIMES_DEF = 5;
    public static final String COMMAND_START_SHOW_TIME = "command_start_show_time";
    public static final String COMMAND_VIDEO_NIDS = "command_video_nids";
    private static final int DANMAKU_EMOJI_TAIL_SIZE = 9;
    private static final int DANMAKU_FORM_COMMAND = 0;
    private static final int DANMAKU_FORM_SPECIAL = 1;
    private static final int DANMAKU_MORE_TAIL_SIZE = 3;
    public static final int DANMAKU_STYLE_0 = 0;
    public static final int DANMAKU_STYLE_1 = 1;
    public static final int DANMAKU_STYLE_2 = 2;
    public static final int DANMAKU_STYLE_3 = 3;
    public static final int DANMAKU_STYLE_4_0 = 4;
    public static final int DANMAKU_STYLE_4_1 = 5;
    public static final int DANMAKU_STYLE_5 = 6;
    public static final int DANMAKU_STYLE_6 = 7;
    public static final int DANMAKU_STYLE_AI_CHARACTER = 30;
    public static final int DANMAKU_STYLE_AI_CHARACTER_PRAISE = 31;
    public static final int DANMAKU_STYLE_HOT_COMMENT = 11;
    public static final int DANMAKU_STYLE_HOT_COMMENT_SELF = 12;
    public static final int DANMAKU_STYLE_NOTIFICATION = 13;
    public static final int DANMAKU_STYLE_NOTIFICATION_UNCLICK = 14;
    public static final int DANMAKU_STYLE_SEARCH = 15;
    public static final int DANMAKU_STYLE_SEARCH_GUIDE_STYLE_1 = 21;
    public static final int DANMAKU_STYLE_SEARCH_GUIDE_STYLE_2 = 22;
    public static final int DANMAKU_STYLE_SEARCH_PRAISE = 18;
    public static final int DANMAKU_STYLE_SEARCH_SELF = 16;
    public static final int DANMAKU_STYLE_SEARCH_SELF_PRAISE = 20;
    public static final int DANMAKU_STYLE_SEARCH_SELF_UNPRAISE = 19;
    public static final int DANMAKU_STYLE_SEARCH_UNPRAISE = 17;
    public static final int DANMAKU_TEXT_SIZE = 15;
    private static final int DANMAKU_TEXT_STROKE_COLOR = 1291845632;
    private static final int DANMAKU_TEXT_STROKE_WIDTH_PX = 2;
    private static final int MAX_DANMAKU_CONTENT_SIZE = 20;
    public static final int ONE_DAY_TIME_MILLIS = 86400000;
    private static final int PRAISED_TEXT_COLOR = -35723;
    private static final int PRAISE_CNT_SIZE_DP = 14;
    private static final int PRAISE_ICON_LEFT_PADDING_DP = 7;
    private static final int PRAISE_ICON_MIDDLE_PADDING_DP = 3;
    private static final int PRAISE_ICON_RIGHT_PADDING_DP = 1;
    private static final int SEARCH_PRAISED_TEXT_COLOR = -55949;
    public static final String SPARATOR = ",";
    public static final String SPECIAL_SHOW_TIMES = "special_show_times";
    public static final int SPECIAL_SHOW_TIMES_DEF = 5;
    public static final String SPECIAL_START_SHOW_TIME = "special_start_show_time";
    public static final String SPECIAL_VIDEO_NIDS = "special_video_nids";
    private static final int STYLE0_DRAWTEXT_TOP_OFFSET_DP = -2;
    private static final int UNPRAISED_TEXT_COLOR = -1;
    private String cmtWay;
    private ICustomViewHolder customViewHolder;
    @ForceLayoutType
    private int forceLayoutType;
    private boolean isFakeSuccess;
    private boolean isRepeat;
    private boolean isSelfPraise;
    private boolean isSelfSend;
    private boolean isShowPraiseView = true;
    private boolean isUseCustomClick = false;
    private String mCampaignText;
    private CharSequence mContent;
    private DanmakuContext mDanmakuContext;
    private String mDanmakuId;
    private boolean mIsMockedDanmaku;
    private String mNid;
    private Notification mNotification;
    private int mPraiseCounts;
    private BarrageModel.SkinInfo mSkinInfo;
    private int mStyle = 0;
    private int mTextSize = 15;
    private long mTimeMs;
    private String mTopicId;
    @DanmakuPriority
    public int priorityLevel = 0;
    private BarrageModel.Special special;

    public DanmakuBuilder setFakeSuccess(boolean fakeSuccess) {
        this.isFakeSuccess = fakeSuccess;
        return this;
    }

    public DanmakuBuilder setDanmakuContext(DanmakuContext danmakuContext) {
        this.mDanmakuContext = danmakuContext;
        return this;
    }

    public DanmakuBuilder setText(CharSequence content) {
        if (TextUtils.isEmpty(content)) {
            this.mContent = "";
        } else if (content.length() <= 20) {
            this.mContent = content;
        } else if (content.toString().replaceAll("\\[([一-龥\\w])+\\]", " ").length() <= 20) {
            this.mContent = content;
        } else {
            CharSequence tail = content.subSequence(11, 20);
            Matcher matcherEmotion = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(tail);
            if (matcherEmotion.find()) {
                this.mContent = TextUtils.concat(new CharSequence[]{content.subSequence(0, 11), tail.subSequence(0, matcherEmotion.group().length() + matcherEmotion.start())});
                if (content.length() > 20) {
                    this.mContent += "…";
                }
            } else {
                this.mContent = content.subSequence(0, 17) + "…";
            }
        }
        return this;
    }

    public DanmakuBuilder setTextSize(int textSize) {
        this.mTextSize = textSize;
        return this;
    }

    public DanmakuBuilder setTime(long timeMs) {
        this.mTimeMs = timeMs;
        return this;
    }

    public DanmakuBuilder setStyle(int style) {
        this.mStyle = style;
        return this;
    }

    public DanmakuBuilder setPraiseCounts(int counts) {
        this.mPraiseCounts = counts;
        return this;
    }

    public DanmakuBuilder setDanmakuId(String id) {
        this.mDanmakuId = id;
        return this;
    }

    public DanmakuBuilder setTopicId(String topicId) {
        this.mTopicId = topicId;
        return this;
    }

    public String getNid() {
        return this.mNid;
    }

    public DanmakuBuilder setNid(String nid) {
        this.mNid = nid;
        return this;
    }

    public DanmakuBuilder setMockedDanmakuFlag(boolean isMocked) {
        this.mIsMockedDanmaku = isMocked;
        return this;
    }

    public DanmakuBuilder setAndroidContext(Context context) {
        return this;
    }

    public DanmakuBuilder setIsSelfPraise(boolean isSelfPraise2) {
        this.isSelfPraise = isSelfPraise2;
        return this;
    }

    public DanmakuBuilder setIsSelfSend(boolean isSelfSend2) {
        this.isSelfSend = isSelfSend2;
        return this;
    }

    public DanmakuBuilder setIsRepeat(boolean isRepeat2) {
        this.isRepeat = isRepeat2;
        return this;
    }

    public DanmakuBuilder setSkinInfo(BarrageModel.SkinInfo skinInfo) {
        this.mSkinInfo = skinInfo;
        return this;
    }

    public DanmakuBuilder setIsUseCustomClick(boolean isUseCustomClick2) {
        this.isUseCustomClick = isUseCustomClick2;
        return this;
    }

    public DanmakuBuilder setIsShowPraiseView(boolean isShowPraiseView2) {
        this.isShowPraiseView = isShowPraiseView2;
        return this;
    }

    public DanmakuBuilder setNotification(Notification notification) {
        this.mNotification = notification;
        return this;
    }

    public DanmakuBuilder setCampaignText(String text) {
        this.mCampaignText = text;
        return this;
    }

    public DanmakuBuilder setSpecial(BarrageModel.Special special2) {
        this.special = special2;
        return this;
    }

    public DanmakuBuilder setCmtWay(String cmtWay2) {
        this.cmtWay = cmtWay2;
        return this;
    }

    public DanmakuBuilder setForceLayoutType(@ForceLayoutType int forceLayoutType2) {
        this.forceLayoutType = forceLayoutType2;
        return this;
    }

    public DanmakuBuilder setPriorityLevel(@DanmakuPriority int priority) {
        this.priorityLevel = priority;
        return this;
    }

    public DanmakuBuilder setCustomViewHolder(ICustomViewHolder holder) {
        this.customViewHolder = holder;
        return this;
    }

    public BaseDanmaku create() {
        if (this.mDanmakuContext == null || AppRuntime.getAppContext() == null) {
            return null;
        }
        if (!(this.mDanmakuContext.getCacheStuffer() instanceof SpannedCacheStuffer)) {
            this.mDanmakuContext.setCacheStuffer(new SpannedCacheStuffer(), (BaseCacheStuffer.Proxy) null);
        }
        return createDanmaku();
    }

    private BaseDanmaku createDanmaku() {
        BaseDanmaku item = this.mDanmakuContext.mDanmakuFactory.createDanmaku(1, this.mDanmakuContext);
        if (item == null || item.getDurationObj() == null) {
            return null;
        }
        if (this.mNotification == null) {
            BarrageModel.Special special2 = this.special;
            if (special2 != null && !TextUtils.isEmpty(special2.effectUrl)) {
                if (!SpecialDanmakuController.isCanShowSpecialDanmaku(AppRuntime.getAppContext(), this.mNid)) {
                    return null;
                }
                item.special = this.special;
            }
        } else if (!needShowCommand()) {
            return null;
        } else {
            item.notification = this.mNotification;
        }
        item.mCampaignContent = getCampaignText();
        item.skinInfo = this.mSkinInfo;
        item.isUseCustomClick = this.isUseCustomClick;
        item.isShowPraiseView = this.isShowPraiseView;
        item.mPraiseCounts = this.mPraiseCounts;
        item.isSelfPraise = this.isSelfPraise;
        item.isSelfSend = this.isSelfSend;
        item.mDanmakuId = this.mDanmakuId;
        item.mTopicId = this.mTopicId;
        item.mIsMockedDanmaku = this.mIsMockedDanmaku;
        item.mTextSize = getTextSize();
        configDanmakuTextColor(this.mStyle, item);
        configDanmakuTextShadowColor(this.mStyle, item);
        item.mPaddingLeft = 0;
        item.mPaddingRight = 0;
        item.mPaddingTop = 0;
        item.mPaddingBottom = 0;
        item.mUnderlineColor = 0;
        item.isRepeat = this.isRepeat;
        item.cmtWay = this.cmtWay;
        item.forceLayoutType = this.forceLayoutType;
        item.priorityLevel = this.priorityLevel;
        item.customViewHolder = this.customViewHolder;
        if (item != null) {
            item.mOriginalText = this.mContent;
            try {
                configDanmakuSpannableText(this.mStyle, AppRuntime.getAppContext(), item);
            } catch (Exception e2) {
                BdDmkLog.e("DanmakuBuilder", "configDanmakuSpannableText error: " + e2.getMessage());
            }
            item.setTime(this.mTimeMs);
            item.mPriority = 0;
            item.mDanmakuStyle = this.mStyle;
            item.nid = this.mNid;
        }
        item.isFakeSuccess = this.isFakeSuccess;
        if (this.customViewHolder == null || CustomViewDanmakuController.isCanShowCustomViewDanmaku(AppRuntime.getAppContext(), item)) {
            return item;
        }
        return null;
    }

    private float getTextSize() {
        return DanmakuUtils.getScaledSize((float) DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), (float) this.mTextSize));
    }

    private CharSequence getCampaignText() {
        Notification notification = this.mNotification;
        if (notification == null || notification.getRedirect() == null || this.mNotification.getRedirect().getContent() == null) {
            return "";
        }
        SpannableStringBuilder content = new SpannableStringBuilder(this.mNotification.getRedirect().getContent()).append(" ");
        Bitmap tail = ImageUtil.getBitmapFromCache(this.mNotification.getRedirect().getIcon());
        if (tail != null && !tail.isRecycled()) {
            int tailHeight = Math.round(DanmakuUtils.getScaledSize(14.0f * AppRuntime.getAppContext().getResources().getDisplayMetrics().density));
            content.setSpan(new SpanStringUtils.CenterImageSpan(AppRuntime.getAppContext(), Bitmap.createScaledBitmap(tail, tailHeight, tailHeight, true)), content.length() - 1, content.length(), 33);
        }
        return content;
    }

    private boolean needShowCommand() {
        int cmdMax = DanmakuUtils.stringToIntSafety(PreferUtils.getStringPreference(AppRuntime.getAppContext(), DanmakuPlatformConfigListener.COMMAND_MAX_COUNT, String.valueOf(5)), 5);
        int cmdShowTimes = PreferUtils.getIntPreference(AppRuntime.getAppContext(), COMMAND_SHOW_TIMES, 0);
        String nids = PreferUtils.getStringPreference(AppRuntime.getAppContext(), COMMAND_VIDEO_NIDS, "");
        long currentTime = System.currentTimeMillis();
        if (currentTime - DanmakuUtils.stringToLongSafety(PreferUtils.getStringPreference(AppRuntime.getAppContext(), COMMAND_START_SHOW_TIME, String.valueOf(currentTime)), 0) >= 86400000 || nids.contains(this.mNid)) {
            PreferUtils.setIntPreference(AppRuntime.getAppContext(), COMMAND_SHOW_TIMES, 0);
            return true;
        } else if (cmdShowTimes < cmdMax) {
            return true;
        } else {
            return false;
        }
    }

    private static void configDanmakuTextColor(int style, BaseDanmaku danmaku) {
        if (danmaku != null) {
            if (style == 4 || style == 5 || style == 6) {
                danmaku.mTextColor = PRAISED_TEXT_COLOR;
            } else if (danmaku.notification == null || danmaku.notification.getText() == null) {
                danmaku.mTextColor = -1;
            } else if (danmaku.notification.getText().getTextColor() != null) {
                danmaku.mTextColor = DanmakuUtils.toggleColor(danmaku.notification.getText().getTextColor(), -1);
            }
        }
    }

    private static void configDanmakuTextShadowColor(int style, BaseDanmaku danmaku) {
        if (danmaku != null) {
            if (danmaku.skinInfo != null) {
                danmaku.mTextShadowColor = 0;
            } else if (danmaku.notification == null || danmaku.notification.getText() == null) {
                danmaku.mTextShadowColor = 1291845632;
            } else if (danmaku.notification.getText().getStrokeColor() != null) {
                danmaku.mTextShadowColor = DanmakuUtils.toggleColor(danmaku.notification.getText().getStrokeColor(), 1291845632);
            }
        }
    }

    public static void configDanmakuSpannableText(int style, Context ctx, BaseDanmaku danmaku) {
        SpannableStringBuilder formattedText;
        String praiseCntsStr;
        int praiseCntsTextColor;
        Drawable iconDrawable;
        SpannableStringBuilder ssb;
        String praiseCntsStr2;
        int praiseCntsTextColor2;
        Drawable iconDrawable2;
        int i2 = style;
        Context context = ctx;
        BaseDanmaku baseDanmaku = danmaku;
        if (context != null && baseDanmaku != null && !TextUtils.isEmpty(baseDanmaku.mOriginalText)) {
            boolean z = true;
            boolean isCommandBarrage = baseDanmaku.notification != null;
            CharSequence originalText = baseDanmaku.mOriginalText;
            CharSequence formattedText2 = originalText;
            switch (i2) {
                case 0:
                    baseDanmaku.mLeftOffsetPx = 0;
                    baseDanmaku.mTopOffsetPx = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), -2.0f);
                    formattedText = originalText;
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    String praiseCntsStr3 = baseDanmaku.mPraiseCounts + "";
                    if (i2 != 1) {
                        z = false;
                    }
                    boolean onlyIcon = z;
                    if (onlyIcon) {
                        baseDanmaku.mPraiseCounts = 0;
                        praiseCntsStr = " ";
                    } else {
                        praiseCntsStr = praiseCntsStr3;
                    }
                    SpannableStringBuilder ssb2 = new SpannableStringBuilder(originalText);
                    ssb2.append(praiseCntsStr);
                    if (i2 == 4 || i2 == 5 || i2 == 6) {
                        iconDrawable = ctx.getResources().getDrawable(R.drawable.bd_danmaku_praised);
                        praiseCntsTextColor = PRAISED_TEXT_COLOR;
                    } else {
                        iconDrawable = ctx.getResources().getDrawable(R.drawable.bd_danmaku_unpraised);
                        praiseCntsTextColor = -1;
                    }
                    SpannableStringBuilder ssb3 = ssb2;
                    TextWithCompoundDrawableSpan textDrawableSpan = new TextWithCompoundDrawableSpan(ctx, iconDrawable, 7, onlyIcon ? 0 : 3, 1, 14, praiseCntsTextColor, 1291845632, 2);
                    baseDanmaku.mPraiseStyleSpanStart = ssb3.length() - praiseCntsStr.length();
                    baseDanmaku.mPraiseStyleSpanEnd = ssb3.length();
                    SpannableStringBuilder ssb4 = ssb3;
                    ssb4.setSpan(textDrawableSpan, baseDanmaku.mPraiseStyleSpanStart, baseDanmaku.mPraiseStyleSpanEnd, 33);
                    formattedText = ssb4;
                    break;
                case 11:
                case 12:
                case 13:
                case 14:
                    TextView contentTextView = new TextView(context);
                    contentTextView.setTextSize(0, baseDanmaku.mTextSize);
                    formattedText = EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, ctx.getApplicationContext(), originalText, contentTextView);
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 30:
                case 31:
                    SpannableStringBuilder ssb5 = new SpannableStringBuilder(originalText);
                    BdDmkLog.d(">>>>>>", "1 configDanmakuSpannableText danmaku:" + danmaku.hashCode() + " content:" + baseDanmaku.mOriginalText + " " + baseDanmaku.mPraiseCounts);
                    if (!isCommandBarrage) {
                        if (baseDanmaku.mPraiseCounts != 0) {
                            praiseCntsStr2 = baseDanmaku.mPraiseCounts + "";
                        } else {
                            praiseCntsStr2 = " ";
                        }
                        ssb5.append(praiseCntsStr2);
                        int i3 = style;
                        if (i3 == 18 || i3 == 20 || i3 == 31) {
                            iconDrawable2 = FontSizeHelper.getScaledDrawableForTargetFontSize(0, ContextCompat.getDrawable(context, DanmakuContext.getPraisedDrawableRes()), DanmakuUtils.getFontSizeGear());
                            praiseCntsTextColor2 = SEARCH_PRAISED_TEXT_COLOR;
                        } else {
                            iconDrawable2 = FontSizeHelper.getScaledDrawableForTargetFontSize(0, ContextCompat.getDrawable(context, DanmakuContext.getUnpraisedDrawableRes()), DanmakuUtils.getFontSizeGear());
                            praiseCntsTextColor2 = -1;
                        }
                        SpannableStringBuilder ssb6 = ssb5;
                        TextWithCompoundDrawableSpan textDrawableSpan2 = new TextWithCompoundDrawableSpan(ctx, iconDrawable2, 7, 3, 1, Math.round(DanmakuUtils.getScaledSize(14.0f)), praiseCntsTextColor2, 1291845632, 2);
                        baseDanmaku.mPraiseStyleSpanStart = ssb6.length() - praiseCntsStr2.length();
                        baseDanmaku.mPraiseStyleSpanEnd = ssb6.length();
                        if (baseDanmaku.isShowPraiseView) {
                            ssb = ssb6;
                            ssb.setSpan(textDrawableSpan2, baseDanmaku.mPraiseStyleSpanStart, baseDanmaku.mPraiseStyleSpanEnd, 33);
                        } else {
                            ssb = ssb6;
                        }
                    } else {
                        int i4 = style;
                        ssb = ssb5;
                    }
                    TextView searchTextView = new TextView(context);
                    searchTextView.setTextSize(0, baseDanmaku.mTextSize);
                    formattedText = EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, ctx.getApplicationContext(), ssb, searchTextView);
                    break;
                case 21:
                    SpannableStringBuilder ssb7 = new SpannableStringBuilder(originalText);
                    ssb7.append(" ");
                    SpannableStringBuilder ssb8 = ssb7;
                    TextWithCompoundDrawableSpan fireDrawableSpan = new TextWithCompoundDrawableSpan(ctx, ContextCompat.getDrawable(context, R.drawable.bd_danmaku_fireworks), 7, 3, 1, 14, -1, 1291845632, 2);
                    baseDanmaku.mPraiseStyleSpanStart = ssb8.length() - " ".length();
                    baseDanmaku.mPraiseStyleSpanEnd = ssb8.length();
                    SpannableStringBuilder ssb9 = ssb8;
                    ssb9.setSpan(fireDrawableSpan, baseDanmaku.mPraiseStyleSpanStart, baseDanmaku.mPraiseStyleSpanEnd, 33);
                    int i5 = style;
                    formattedText = ssb9;
                    break;
                case 22:
                    SpannableStringBuilder ssb10 = new SpannableStringBuilder(originalText);
                    ssb10.append(" ");
                    SpannableStringBuilder ssb11 = ssb10;
                    TextWithCompoundDrawableSpan heartDrawableSpan = new TextWithCompoundDrawableSpan(ctx, ContextCompat.getDrawable(context, R.drawable.bd_danmaku_heart), 7, 3, 1, 14, -1, 1291845632, 2);
                    baseDanmaku.mPraiseStyleSpanStart = ssb11.length() - " ".length();
                    baseDanmaku.mPraiseStyleSpanEnd = ssb11.length();
                    SpannableStringBuilder ssb12 = ssb11;
                    ssb12.setSpan(heartDrawableSpan, baseDanmaku.mPraiseStyleSpanStart, baseDanmaku.mPraiseStyleSpanEnd, 33);
                    int i6 = style;
                    formattedText = ssb12;
                    break;
                default:
                    formattedText = formattedText2;
                    break;
            }
            baseDanmaku.mText = formattedText;
        }
    }

    private static void resetDataForStyleChange(BaseDanmaku danmaku) {
        if (danmaku != null) {
            if (danmaku.mObj instanceof SoftReference) {
                ((SoftReference) danmaku.mObj).clear();
            }
            danmaku.mTopOffsetPx = 0;
            danmaku.mLeftOffsetPx = 0;
            danmaku.mPaddingBottom = 0;
            danmaku.mPaddingTop = 0;
            danmaku.mPaddingRight = 0;
            danmaku.mPaddingLeft = 0;
            danmaku.mPaintHeight = -1.0f;
            danmaku.mPaintWidth = -1.0f;
            danmaku.mRequestFlags |= 1;
            danmaku.mRequestFlags |= 2;
        }
    }

    public static void changeDanmakuStyle(BaseDanmaku danmaku, int newStyle, Context ctx) {
        BdDmkLog.d(">>>>>>", "changeDanmakuStyle  danmaku:" + danmaku.hashCode() + "  danmaku.mDanmakuStyle:" + danmaku.mDanmakuStyle + " newStyle:" + newStyle + " content:" + danmaku.mOriginalText);
        if (danmaku != null) {
            danmaku.mDanmakuStyle = newStyle;
        }
        resetDataForStyleChange(danmaku);
        configDanmakuTextColor(newStyle, danmaku);
        configDanmakuTextShadowColor(newStyle, danmaku);
        try {
            configDanmakuSpannableText(newStyle, ctx, danmaku);
        } catch (Exception e2) {
            BdDmkLog.e("changeDanmakuStyle", "configDanmakuSpannableText error:" + e2.getMessage());
        }
    }

    public static void updatePraisedDanmakuStyle(BaseDanmaku danmaku, Context ctx) {
        switch (danmaku.mDanmakuStyle) {
            case 0:
            case 2:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 4, ctx);
                    return;
                }
                return;
            case 1:
            case 3:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 6, ctx);
                    return;
                }
                return;
            case 17:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 18, ctx);
                    return;
                }
                return;
            case 18:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 17, ctx);
                    return;
                }
                return;
            case 19:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 20, ctx);
                    return;
                }
                return;
            case 20:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 19, ctx);
                    return;
                }
                return;
            case 30:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 31, ctx);
                    return;
                }
                return;
            case 31:
                if (ctx != null) {
                    changeDanmakuStyle(danmaku, 30, ctx);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static int makeDanmakuStyle(boolean sentByItself, boolean showPraise, boolean praisedByItself, int praiseCounts, int type, boolean isGuide, boolean click) {
        if (type == 6) {
            return sentByItself ? 12 : 11;
        }
        if (type == 7) {
            return click ? 13 : 14;
        }
        return makeDanmakuStyle(sentByItself, showPraise, praisedByItself, praiseCounts);
    }

    public static int makeDanmakuStyle(boolean sentByItself, boolean showPraise, boolean praisedByItself, int praiseCounts) {
        if (sentByItself && !showPraise) {
            return 7;
        }
        if (praisedByItself) {
            return sentByItself ? 6 : 5;
        }
        if (sentByItself) {
            if (praiseCounts == 0) {
                return 1;
            }
            return 3;
        } else if (!showPraise) {
            return 0;
        } else {
            return 2;
        }
    }

    public static int makeDanmakuStyleWithPraise(boolean sentByItself, boolean praisedByItself, String cmtWay2) {
        if ("7".equals(cmtWay2)) {
            if (praisedByItself) {
                return 31;
            }
            return 30;
        } else if (sentByItself) {
            if (praisedByItself) {
                return 20;
            }
            return 19;
        } else if (praisedByItself) {
            return 18;
        } else {
            return 17;
        }
    }

    public static class TextWithCompoundDrawableSpan extends ReplacementSpan {
        private static final int IMAGE_OFFSET_Y_DP = -1;
        private Context mCtx;
        private Drawable mDrawable;
        private int mFontColor;
        private int mFontSizeDp;
        private int mFontStrokeColor;
        private int mFontStrokeWidthPx;
        private int mPaddingLeftDp;
        private int mPaddingMiddleDp;
        private int mPaddingRightDp;
        private boolean mStrokeFontEnabled;

        public TextWithCompoundDrawableSpan(Context ctx, Drawable drawable, int paddingLeftDp, int paddingMiddleDp, int paddingRightDp, int fontSizeDp, int fontColor, int strokeColor, int strokeWidthPx) {
            this.mFontSizeDp = fontSizeDp;
            this.mPaddingLeftDp = paddingLeftDp;
            this.mPaddingMiddleDp = paddingMiddleDp;
            this.mPaddingRightDp = paddingRightDp;
            this.mCtx = ctx;
            this.mDrawable = drawable;
            this.mFontColor = fontColor;
            this.mFontStrokeColor = strokeColor;
            this.mFontStrokeWidthPx = strokeWidthPx;
            int width = drawable.getIntrinsicWidth();
            int height = this.mDrawable.getIntrinsicHeight();
            this.mDrawable.setBounds(0, 0, width > 0 ? width : 0, height > 0 ? height : 0);
            this.mStrokeFontEnabled = true;
        }

        public TextWithCompoundDrawableSpan(Context ctx, Drawable drawable, int paddingLeftDp, int paddingMiddleDp, int paddingRightDp, int fontSizeDp, int fontColor) {
            this(ctx, drawable, paddingLeftDp, paddingMiddleDp, paddingRightDp, fontSizeDp, fontColor, -1, -1);
            this.mStrokeFontEnabled = false;
        }

        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
            return ((int) getTextPaint(paint).measureText(text, start, end)) + this.mDrawable.getBounds().right + DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingLeftDp) + DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingMiddleDp) + DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingRightDp);
        }

        public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
            Canvas canvas2 = canvas;
            int i2 = y;
            TextPaint textPaint = getTextPaint(paint);
            Paint.FontMetricsInt fm = textPaint.getFontMetricsInt();
            int transY = (((((fm.descent + i2) + i2) + fm.ascent) / 2) - (this.mDrawable.getBounds().bottom / 2)) + DeviceUtils.ScreenInfo.dp2px(this.mCtx, -1.0f);
            canvas.save();
            canvas.translate(x + ((float) DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingLeftDp)), (float) transY);
            this.mDrawable.draw(canvas);
            canvas.restore();
            if (this.mStrokeFontEnabled) {
                configStrokePaintStyle(textPaint);
                canvas.drawText(text, start, end, x + ((float) DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingLeftDp)) + ((float) this.mDrawable.getBounds().right) + ((float) DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingMiddleDp)), (float) i2, textPaint);
            }
            configNormalPaintStyle(textPaint);
            canvas.drawText(text, start, end, x + ((float) DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingLeftDp)) + ((float) this.mDrawable.getBounds().right) + ((float) DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mPaddingMiddleDp)), (float) i2, textPaint);
        }

        private TextPaint getTextPaint(Paint paint) {
            return new TextPaint(paint);
        }

        private void configNormalPaintStyle(Paint paint) {
            if (paint != null) {
                paint.setTextSize((float) DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mFontSizeDp));
                paint.setStrokeWidth(0.0f);
                paint.setColor(this.mFontColor);
                paint.setStyle(Paint.Style.FILL);
            }
        }

        private void configStrokePaintStyle(Paint paint) {
            if (paint != null) {
                paint.setTextSize((float) DeviceUtils.ScreenInfo.dp2px(this.mCtx, (float) this.mFontSizeDp));
                paint.setStrokeWidth((float) this.mFontStrokeWidthPx);
                paint.setColor(this.mFontStrokeColor);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
            }
        }
    }
}
