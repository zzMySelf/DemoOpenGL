package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.nadcore.slidingtag.INadSlidingComponent;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.base.FeedTemplateManager;
import com.baidu.searchbox.feed.base.IFeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.controller.FeedPolicy;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.flow.util.FontAdjustment;
import com.baidu.searchbox.feed.model.FeedAider;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataStar;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.model.FeedTtsModel;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.statistic.RenderCostMonitor;
import com.baidu.searchbox.feed.template.common.ExtraData;
import com.baidu.searchbox.feed.template.common.view.DrawableTextView;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.template.statistic.FeedChannelConstants;
import com.baidu.searchbox.feed.template.statistic.FeedTemplateStatTable;
import com.baidu.searchbox.feed.template.statistic.IFeedTemplateStatistics;
import com.baidu.searchbox.feed.template.utils.FeedOrderSenseUtil;
import com.baidu.searchbox.feed.template.view.poi.FeedHotPoiView;
import com.baidu.searchbox.feed.tts.TTSSwitchUtil;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.ral.RalState;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.util.RalTTSLocalSwitcher;
import com.baidu.searchbox.feed.widget.TTSPlayIcon;
import com.baidu.searchbox.player.helper.ViewOpUtils;
import com.baidu.searchbox.resources.util.CtxResEasyUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import java.util.ArrayList;
import java.util.Map;

public class FeedLabelView extends ViewGroup {
    private static final int AD_SOURCE_MAX_WIDTH = getDimensionPixelSizeById(R.dimen.feed_ad_label_source_max_width);
    private static final int AD_TAG_IMAGE_HEIGHT = getDimensionPixelSizeById(R.dimen.dimens_16dp);
    private static final int AD_TAG_IMAGE_MARGIN_RIGHT = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X007);
    private static final int AD_TAG_IMAGE_WIDTH = getDimensionPixelSizeById(R.dimen.dimens_70dp);
    private static final int AUTHOR_ICON_MARGIN_RIGHT = getDimensionPixelSizeById(R.dimen.feed_label_author_icon_margin_right);
    private static final int AUTHOR_ICON_SIZE = getDimensionPixelSizeById(R.dimen.feed_template_new_p3);
    private static final int BUBBLE_SHOW_LONG_TIME = 3000;
    private static final int COMMENT_MAX_WIDTH = getDimensionPixelSizeById(R.dimen.feed_label_comment_max_width);
    private static final int CORNER_RADIUS = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 2.0f);
    private static final String DISLIKE_BUBBLE_TOAST = "feed_dislike_guide";
    private static final int ENTER_HEIGHT = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_H_X07);
    private static final int ENTER_MARGIN_RIGHT = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 0.0f);
    private static final int ENTER_TEXT_SIZE = getDimensionPixelSizeById(R.dimen.feed_enter_txt_size);
    private static final int ENTER_UNLIKE_H_MARGIN = getDimensionPixelSizeById(R.dimen.feed_margin_between_unlike_and_enter);
    private static final int ENTER_WIDTH = getDimensionPixelSizeById(R.dimen.feed_enter_width);
    private static final int FONT_WEIGHT = 600;
    private static final int LABEL_TEXT_MARGIN = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X007);
    private static final int NORMAL_TEXT_COLOR = getColorById(com.baidu.searchbox.feed.styles.R.color.FC2);
    private static final int NORMAL_TEXT_SIZE = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_T_X033);
    private static final int OPERATE_MARGIN_RIGHT = getDimensionPixelSizeById(R.dimen.feed_template_new_p3);
    private static final int POI_MARGIN_RIGHT = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X052);
    private static final int RADIO_ICON_TEXT_MARGIN = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X056);
    private static final int RADIO_PLAY_ICON_MARGIN_LEFT = getDimensionPixelSizeById(R.dimen.feed_margin_between_icon_and_enter);
    private static final int RADIO_PLAY_ICON_MARGIN_RIGHT = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 0.0f);
    private static final int RADIO_PLAY_ICON_TEXT_SIZE = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_T_X041);
    private static final int RECOMMEND_MAX_WIDTH = getDimensionPixelSizeById(R.dimen.feed_label_recommend_max_width);
    private static final int SAFE_SPACE = 0;
    private static final int SOURCE_MAX_WIDTH = getDimensionPixelSizeById(R.dimen.feed_label_source_max_width);
    private static final String TAG = "FeedLabelView";
    private static final int TAG_BORDER_WIDTH = 1;
    private static final int TAG_HEIGHT = getDimensionPixelSizeById(R.dimen.feed_tag_height);
    private static final int TAG_MAX_WIDTH;
    private static final int TAG_PADDING;
    private static final int TAG_TEXT_COLOR = getColorById(R.color.feed_type_txt_color_cu);
    private static final int TAG_TEXT_SIZE = getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_T_X033);
    private static final int TAG_TEXT_SIZE_DEFAULT = 10;
    private static final int TIME_MAX_WIDTH = getDimensionPixelSizeById(R.dimen.feed_time_max_width_n);
    private static final int TTS_SIZE = getDimensionPixelSizeById(R.dimen.feed_label_tts_wh);
    private static final int UNLIKE_MARGIN_RIGHT = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 0.0f);
    public static final int UNLIKE_TOUCH_EXPAND_BOTTOM = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 15.0f);
    public static final int UNLIKE_TOUCH_EXPAND_LEFT = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 15.0f);
    public static final int UNLIKE_TOUCH_EXPAND_RIGHT = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 15.0f);
    public static final int UNLIKE_TOUCH_EXPAND_TOP = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 15.0f);
    private boolean isApplyVideoDetailCommend;
    private INadSlidingComponent mAdSlidingTag;
    private String mAdSource;
    private FeedDraweeView mAdTagImageView;
    private TextView mAdTagText;
    private FeedDraweeView mAuthorIcon;
    private FeedBarView mBarView;
    /* access modifiers changed from: private */
    public BubbleManager mBubbleManager;
    private String mCommendContent;
    private String mComment;
    private String mCommonText;
    private TextView mEnterView;
    private View.OnClickListener mEnterViewClickListener;
    private ExtraData mExtraData;
    /* access modifiers changed from: private */
    public FeedBaseModel mFeedModel;
    private boolean mHideReasonText;
    private int mIndex;
    private boolean mIsEnterViewShow;
    private boolean mIsRalVoiceBtnShow;
    private boolean mIsTagHasBorder;
    private int mMaxHeight;
    private int mMaxWidth;
    private TextPaint mNormalPaint;
    private RelativeLayout mOperateContainer;
    private FeedHotPoiView mPoiView;
    private TTSPlayIcon mRadioPlayIcon;
    private View.OnClickListener mRalButtonClickListener;
    private String mReason;
    private TextPaint mReasonPaint;
    private RectF mRectF;
    private boolean mShowCommentNum;
    private String mSource;
    /* access modifiers changed from: private */
    public FeedSquareDraweeView mSquareIcon;
    private TextView mSquareIconDesc;
    private String mSubTag;
    private ImageView mTTs;
    private String mTag;
    private Paint mTagBorderPaint;
    private TextPaint mTagPaint;
    private ArrayList<String> mTexts;
    private String mTime;
    private DrawableTextView mTopDrawableText;
    private ImageView mUnLike;
    private FeedLabelSourceTag sourceTag;

    static {
        int dp2px = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 3.0f);
        TAG_PADDING = dp2px;
        TAG_MAX_WIDTH = getDimensionPixelSizeById(R.dimen.feed_label_tag_max_width) - (dp2px * 2);
    }

    public FeedLabelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FeedLabelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedLabelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mTexts = new ArrayList<>(4);
        this.mIsTagHasBorder = true;
        this.mIndex = 0;
        this.mMaxWidth = 0;
        this.mMaxHeight = 0;
        this.mRectF = new RectF();
        this.mHideReasonText = false;
        this.mIsEnterViewShow = false;
        this.mIsRalVoiceBtnShow = false;
        this.mShowCommentNum = true;
        this.isApplyVideoDetailCommend = false;
        init();
    }

    private void init() {
        ImageView imageView = new ImageView(getContext());
        this.mUnLike = imageView;
        imageView.setScaleType(FeedAbtestManager.isFluencyOptOpen() ? ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.CENTER_INSIDE);
        this.mUnLike.setId(R.id.feed_template_base_delete_id);
        this.mUnLike.setContentDescription(getResources().getString(R.string.feed_unlike));
        this.mTTs = new ImageView(getContext());
        int i2 = TTS_SIZE;
        this.mTTs.setLayoutParams(new ViewGroup.LayoutParams(i2, i2));
        this.mTTs.setVisibility(8);
        setWillNotDraw(false);
        TextPaint textPaint = new TextPaint();
        this.mNormalPaint = textPaint;
        textPaint.setAntiAlias(true);
        setTextSize(this.mNormalPaint, NORMAL_TEXT_SIZE, getFontType(this.mFeedModel));
        this.mNormalPaint.setColor(NORMAL_TEXT_COLOR);
        TextPaint textPaint2 = new TextPaint();
        this.mTagPaint = textPaint2;
        textPaint2.setAntiAlias(true);
        setTextSize(this.mTagPaint, TAG_TEXT_SIZE, getFontType(this.mFeedModel));
        TextPaint textPaint3 = this.mTagPaint;
        int i3 = TAG_TEXT_COLOR;
        textPaint3.setColor(i3);
        Paint paint = new Paint();
        this.mTagBorderPaint = paint;
        paint.setAntiAlias(true);
        this.mTagBorderPaint.setColor(i3);
        this.mTagBorderPaint.setStrokeWidth(1.0f);
        this.mTagBorderPaint.setStyle(Paint.Style.STROKE);
        addView(this.mUnLike);
        addView(this.mTTs);
    }

    public void initOperateContainer() {
        if (this.mOperateContainer == null) {
            this.mOperateContainer = new RelativeLayout(getContext());
            this.mOperateContainer.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            this.mOperateContainer.setId(R.id.feed_ad_operate_view);
            addView(this.mOperateContainer);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof View) {
            ExpandTouchAreaHelper.expandTouchArea((View) getParent(), this.mUnLike, UNLIKE_TOUCH_EXPAND_LEFT, UNLIKE_TOUCH_EXPAND_TOP, UNLIKE_TOUCH_EXPAND_RIGHT, UNLIKE_TOUCH_EXPAND_BOTTOM);
        }
        FeedLabelSourceTag feedLabelSourceTag = this.sourceTag;
        if (feedLabelSourceTag != null) {
            feedLabelSourceTag.onAttachedToWindow();
        }
        setAdSlidingTag(this.mFeedModel);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FeedLabelSourceTag feedLabelSourceTag = this.sourceTag;
        if (feedLabelSourceTag != null) {
            feedLabelSourceTag.onDetachedFromWindow();
        }
        INadSlidingComponent iNadSlidingComponent = this.mAdSlidingTag;
        if (iNadSlidingComponent != null) {
            iNadSlidingComponent.destroy();
            ViewOpUtils.removeView(this.mAdSlidingTag.getSlidingView());
            this.mAdSlidingTag = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        long startTime = RenderCostMonitor.getTime();
        this.mMaxWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        measureChildrenAndGetMaxHeight(widthMeasureSpec, heightMeasureSpec);
        int max = Math.max(measureDrawElementsAndGetMaxHeight(), this.mMaxHeight);
        this.mMaxHeight = max;
        setMeasuredDimension(this.mMaxWidth, max);
        RenderCostMonitor.getInstance().updateStatistic(getClass().getSimpleName(), "onMeasure", RenderCostMonitor.getElapsedTime(Long.valueOf(startTime), RenderCostMonitor.getTime()), getFeedId());
    }

    private void measureChildrenAndGetMaxHeight(int widthMeasureSpec, int heightMeasureSpec) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View child = getChildAt(i2);
            if (!(child == null || child.getVisibility() == 8)) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
                if (child.getMeasuredHeight() > this.mMaxHeight) {
                    this.mMaxHeight = child.getMeasuredHeight();
                }
            }
        }
    }

    private int measureDrawElementsAndGetMaxHeight() {
        TextPaint textPaint;
        int maxHeight = 0;
        TextPaint textPaint2 = this.mTagPaint;
        if (textPaint2 != null) {
            Paint.FontMetrics fm = textPaint2.getFontMetrics();
            float height = fm.bottom - fm.top;
            if (height > ((float) 0)) {
                maxHeight = (int) height;
            }
        }
        TextPaint textPaint3 = this.mNormalPaint;
        if (textPaint3 != null) {
            Paint.FontMetrics fm2 = textPaint3.getFontMetrics();
            float height2 = fm2.bottom - fm2.top;
            if (height2 > ((float) maxHeight)) {
                maxHeight = (int) height2;
            }
        }
        if (this.isApplyVideoDetailCommend && !TextUtils.isEmpty(this.mCommendContent) && (textPaint = this.mReasonPaint) != null) {
            Paint.FontMetrics fm3 = textPaint.getFontMetrics();
            float height3 = fm3.bottom - fm3.top;
            if (height3 > ((float) maxHeight)) {
                maxHeight = (int) height3;
            }
        }
        FeedLabelSourceTag feedLabelSourceTag = this.sourceTag;
        if (feedLabelSourceTag != null && feedLabelSourceTag.isValid()) {
            float height4 = this.sourceTag.getTagHeight();
            if (height4 > ((float) maxHeight)) {
                maxHeight = (int) height4;
            }
        }
        INadSlidingComponent iNadSlidingComponent = this.mAdSlidingTag;
        if (iNadSlidingComponent == null || iNadSlidingComponent.getSlidingView().getVisibility() != 0) {
            return maxHeight;
        }
        float height5 = (float) this.mAdSlidingTag.getSlidingView().getMeasuredHeight();
        if (height5 > ((float) maxHeight)) {
            return (int) height5;
        }
        return maxHeight;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        FeedHotPoiView feedHotPoiView;
        DrawableTextView drawableTextView;
        long startTime = RenderCostMonitor.getTime();
        int left = 0;
        FeedSquareDraweeView feedSquareDraweeView = this.mSquareIcon;
        if (feedSquareDraweeView != null && feedSquareDraweeView.getVisibility() == 0) {
            int iconHeight = this.mSquareIcon.getMeasuredHeight();
            int iconWidth = this.mSquareIcon.getMeasuredWidth();
            int iconTop = ((b2 - t) - iconHeight) / 2;
            int iconLeft = (r - l) - getMeasuredWidth();
            this.mSquareIcon.layout(iconLeft, iconTop, iconLeft + iconWidth, iconTop + iconHeight);
            int left2 = 0 + iconWidth;
            TextView textView = this.mSquareIconDesc;
            if (textView != null && textView.getVisibility() == 0) {
                int descHeight = this.mSquareIconDesc.getMeasuredHeight();
                int descWidth = this.mSquareIconDesc.getMeasuredWidth();
                int descTop = ((b2 - t) - descHeight) / 2;
                this.mSquareIconDesc.layout(left2, descTop, left2 + descWidth, descTop + descHeight);
                left2 += descWidth;
            }
            left = left2 + this.mSquareIcon.getSquareDraweeRightMargin();
        }
        FeedDraweeView feedDraweeView = this.mAuthorIcon;
        if (feedDraweeView != null && feedDraweeView.getVisibility() == 0) {
            int iconHeight2 = this.mAuthorIcon.getMeasuredHeight();
            int iconWidth2 = this.mAuthorIcon.getMeasuredWidth();
            int iconTop2 = ((b2 - t) - iconHeight2) / 2;
            this.mAuthorIcon.layout(left, iconTop2, left + iconWidth2, iconTop2 + iconHeight2);
            left += AUTHOR_ICON_MARGIN_RIGHT + iconWidth2;
        }
        FeedDraweeView feedDraweeView2 = this.mAdTagImageView;
        if (feedDraweeView2 != null && feedDraweeView2.getVisibility() == 0) {
            int tagImageHeight = this.mAdTagImageView.getMeasuredHeight();
            int tagImageWidth = this.mAdTagImageView.getMeasuredWidth();
            int tagImageTop = ((b2 - t) - tagImageHeight) / 2;
            this.mAdTagImageView.layout(left, tagImageTop, left + tagImageWidth, tagImageTop + tagImageHeight);
            left += AD_TAG_IMAGE_MARGIN_RIGHT + tagImageWidth;
        }
        if (left == 0 && (drawableTextView = this.mTopDrawableText) != null && drawableTextView.getVisibility() == 0) {
            int topDTextHeight = this.mTopDrawableText.getMeasuredHeight();
            int topDTextWidth = this.mTopDrawableText.getMeasuredWidth();
            int topDTextLeft = (r - l) - getMeasuredWidth();
            int topDTextTop = ((b2 - t) - topDTextHeight) / 2;
            this.mTopDrawableText.layout(topDTextLeft, topDTextTop, topDTextLeft + topDTextWidth, topDTextTop + topDTextHeight);
            left += AUTHOR_ICON_MARGIN_RIGHT + topDTextWidth;
        }
        if (left == 0 && (feedHotPoiView = this.mPoiView) != null && feedHotPoiView.getVisibility() == 0) {
            int poiHeight = this.mPoiView.getMeasuredHeight();
            int poiWidth = this.mPoiView.getMeasuredWidth();
            int poiLeft = (r - l) - getMeasuredWidth();
            int poiTop = ((b2 - t) - poiHeight) / 2;
            this.mPoiView.layout(poiLeft, poiTop, poiLeft + poiWidth, poiTop + poiHeight);
            left += AUTHOR_ICON_MARGIN_RIGHT + poiWidth;
        }
        if (left == 0 && hitFeedBarStyle(this.mFeedModel)) {
            int width = this.mBarView.getMeasuredWidth();
            int height = this.mBarView.getMeasuredHeight();
            int barTop = ((b2 - t) - height) / 2;
            this.mBarView.layout(left, barTop, left + width, barTop + height);
            left += width;
        }
        int left3 = left + getSelfValidWidth();
        if (this.mTTs.getVisibility() != 8) {
            int ttsHeight = this.mTTs.getMeasuredHeight();
            int ttsTop = ((b2 - t) - ttsHeight) / 2;
            ImageView imageView = this.mTTs;
            imageView.layout(left3, ttsTop, imageView.getMeasuredWidth() + left3, ttsTop + ttsHeight);
        }
        int right = r - l;
        TTSPlayIcon tTSPlayIcon = this.mRadioPlayIcon;
        if (!(tTSPlayIcon == null || tTSPlayIcon.getVisibility() == 8)) {
            int playIconHeight = this.mRadioPlayIcon.getMeasuredHeight();
            int playIconWidth = this.mRadioPlayIcon.getMeasuredWidth();
            int playIconTop = ((b2 - t) - playIconHeight) / 2;
            int i2 = RADIO_PLAY_ICON_MARGIN_RIGHT;
            int playIconLeft = (right - i2) - playIconWidth;
            this.mRadioPlayIcon.layout(playIconLeft, playIconTop, playIconLeft + playIconWidth, playIconTop + playIconHeight);
            right -= (RADIO_PLAY_ICON_MARGIN_LEFT + playIconWidth) + i2;
        }
        TextView textView2 = this.mEnterView;
        if (!(textView2 == null || textView2.getVisibility() == 8)) {
            int enterHeight = this.mEnterView.getMeasuredHeight();
            int enterWidth = this.mEnterView.getMeasuredWidth();
            int enterTop = ((b2 - t) - enterHeight) / 2;
            int i3 = ENTER_MARGIN_RIGHT;
            int enterLeft = (right - i3) - enterWidth;
            this.mEnterView.layout(enterLeft, enterTop, enterLeft + enterWidth, enterTop + enterHeight);
            right -= (ENTER_UNLIKE_H_MARGIN + enterWidth) + i3;
        }
        if (this.mUnLike.getVisibility() != 8) {
            int unLikeHeight = this.mUnLike.getMeasuredHeight();
            int unLikeWidth = this.mUnLike.getMeasuredWidth();
            int unlikeTop = ((b2 - t) - unLikeHeight) / 2;
            int unlikeLeft = (right - UNLIKE_MARGIN_RIGHT) - unLikeWidth;
            this.mUnLike.layout(unlikeLeft, unlikeTop, unlikeLeft + unLikeWidth, unlikeTop + unLikeHeight);
        }
        TextView textView3 = this.mAdTagText;
        if (textView3 != null && textView3.getVisibility() == 0) {
            int adTagHeight = this.mAdTagText.getMeasuredHeight();
            int adTagWidth = this.mAdTagText.getMeasuredWidth();
            int adTagTop = ((b2 - t) - adTagHeight) / 2;
            if (FeedAdUtil.isDynamicDetailBannerAd(this.mFeedModel) && this.mFeedModel.feedback == null && this.mUnLike.getVisibility() == 8) {
                int adTagLeft = right - adTagWidth;
                this.mAdTagText.layout(adTagLeft, adTagTop, adTagLeft + adTagWidth, adTagTop + adTagHeight);
                right -= adTagWidth;
            } else {
                int adTagRightMargin = LABEL_TEXT_MARGIN;
                if (FeedAdUtil.hitBarBtnMoveUp(this.mFeedModel) && this.mUnLike.getVisibility() == 8) {
                    adTagRightMargin = 0;
                }
                if (FeedOrderSenseUtil.isSenseOfOrderOneMode(this.mFeedModel)) {
                    adTagRightMargin -= getDimensionPixelSizeById(com.baidu.searchbox.feed.ad.R.dimen.dimens_2dp);
                }
                int adTagLeft2 = ((right - adTagRightMargin) - adTagWidth) - this.mUnLike.getMeasuredWidth();
                this.mAdTagText.layout(adTagLeft2, adTagTop, adTagLeft2 + adTagWidth, adTagTop + adTagHeight);
                right -= adTagRightMargin + adTagWidth;
            }
        }
        RelativeLayout relativeLayout = this.mOperateContainer;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            int opHeight = this.mOperateContainer.getMeasuredHeight();
            int opWidth = this.mOperateContainer.getMeasuredWidth();
            int opTop = ((b2 - t) - opHeight) / 2;
            int i4 = OPERATE_MARGIN_RIGHT;
            int opLeft = (right - i4) - opWidth;
            this.mOperateContainer.layout(opLeft, opTop, opLeft + opWidth, opTop + opHeight);
            right -= i4 + opWidth;
        }
        INadSlidingComponent iNadSlidingComponent = this.mAdSlidingTag;
        if (iNadSlidingComponent != null) {
            int maxItemWidth = iNadSlidingComponent.getMaxItemWidth();
            int i5 = LABEL_TEXT_MARGIN;
            if (right - left3 > maxItemWidth + (i5 * 2)) {
                int slidingWidth = this.mAdSlidingTag.getSlidingView().getMeasuredWidth();
                int slidingHeight = this.mAdSlidingTag.getSlidingView().getMeasuredHeight();
                int slidingTop = ((b2 - t) - slidingHeight) / 2;
                this.mAdSlidingTag.getSlidingView().layout(left3, slidingTop, left3 + slidingWidth, slidingTop + slidingHeight);
                int left4 = left3 + i5 + slidingWidth;
                this.mAdSlidingTag.setVisibility(0);
            } else {
                this.mAdSlidingTag.setVisibility(8);
            }
        }
        RenderCostMonitor.getInstance().updateStatistic(getClass().getSimpleName(), "onLayout", RenderCostMonitor.getElapsedTime(Long.valueOf(startTime), RenderCostMonitor.getTime()), getFeedId());
    }

    private int getSelfValidWidth() {
        float f2;
        float f3;
        int width = 0;
        detectShowItems();
        if (this.mIndex > 0) {
            for (int i2 = 0; i2 < this.mIndex; i2++) {
                if (this.mTexts.get(i2) == this.mTag) {
                    f3 = (float) width;
                    f2 = getTextLength(this.mTexts.get(i2), this.mTagPaint) + ((float) (TAG_PADDING * 2)) + ((float) LABEL_TEXT_MARGIN);
                } else if (this.sourceTag == null || this.mTexts.get(i2) != this.sourceTag.text) {
                    f3 = (float) width;
                    f2 = getTextLength(this.mTexts.get(i2), this.mNormalPaint) + ((float) LABEL_TEXT_MARGIN);
                } else {
                    f3 = (float) width;
                    f2 = this.sourceTag.calculateWidth();
                }
                width = (int) (f3 + f2);
            }
        }
        return width;
    }

    private void detectShowItems() {
        int width;
        int width2 = 0;
        TTSPlayIcon tTSPlayIcon = this.mRadioPlayIcon;
        if (!(tTSPlayIcon == null || tTSPlayIcon.getVisibility() == 8)) {
            width2 = 0 + RADIO_PLAY_ICON_MARGIN_LEFT + this.mRadioPlayIcon.getMeasuredWidth() + RADIO_PLAY_ICON_MARGIN_RIGHT;
        }
        TextView textView = this.mEnterView;
        if (!(textView == null || textView.getVisibility() == 8)) {
            width2 += ENTER_UNLIKE_H_MARGIN + this.mEnterView.getMeasuredWidth() + ENTER_MARGIN_RIGHT;
        }
        if (this.mUnLike.getVisibility() != 8) {
            width2 += this.mUnLike.getMeasuredWidth() + UNLIKE_MARGIN_RIGHT;
        }
        RelativeLayout relativeLayout = this.mOperateContainer;
        if (!(relativeLayout == null || relativeLayout.getVisibility() == 8)) {
            this.mOperateContainer.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            width2 += this.mOperateContainer.getMeasuredWidth() + OPERATE_MARGIN_RIGHT;
        }
        int width3 = width2 + 0;
        if (this.mTTs.getVisibility() != 8) {
            width3 += this.mTTs.getMeasuredWidth();
        }
        FeedSquareDraweeView feedSquareDraweeView = this.mSquareIcon;
        if (feedSquareDraweeView != null && feedSquareDraweeView.getVisibility() == 0) {
            width3 += this.mSquareIcon.getMeasuredWidth() + this.mSquareIcon.getSquareDraweeRightMargin();
            TextView textView2 = this.mSquareIconDesc;
            if (textView2 != null && textView2.getVisibility() == 0) {
                width3 += this.mSquareIconDesc.getMeasuredWidth();
            }
        }
        FeedDraweeView feedDraweeView = this.mAuthorIcon;
        if (feedDraweeView != null && feedDraweeView.getVisibility() == 0) {
            width3 += this.mAuthorIcon.getMeasuredWidth() + AUTHOR_ICON_MARGIN_RIGHT;
        }
        FeedDraweeView feedDraweeView2 = this.mAdTagImageView;
        if (feedDraweeView2 != null && feedDraweeView2.getVisibility() == 0) {
            width3 += this.mAdTagImageView.getMeasuredWidth() + AD_TAG_IMAGE_MARGIN_RIGHT;
        }
        TextView textView3 = this.mAdTagText;
        if (textView3 != null && textView3.getVisibility() == 0) {
            if (FeedAdUtil.isDynamicDetailBannerAd(this.mFeedModel) && this.mFeedModel.feedback == null && this.mUnLike.getVisibility() == 8) {
                width3 += this.mAdTagText.getMeasuredWidth();
            } else {
                width3 += this.mAdTagText.getMeasuredWidth() + LABEL_TEXT_MARGIN;
            }
        }
        if (width > this.mMaxWidth) {
            this.mIndex = 0;
            return;
        }
        int i2 = 0;
        while (i2 < this.mTexts.size()) {
            if (this.mTexts.get(i2) == this.mTag) {
                width = ((int) (((float) width) + getTextLength(this.mTexts.get(i2), this.mTagPaint) + ((float) LABEL_TEXT_MARGIN))) + (TAG_PADDING * 2);
            } else if (this.sourceTag != null && this.mTexts.get(i2) == this.sourceTag.text) {
                width = (int) (((float) width) + this.sourceTag.calculateWidth());
            } else if (TextUtils.isEmpty(this.mSubTag) || this.mTexts.get(i2) != this.mAdSource) {
                width = (int) (((float) width) + getTextLength(this.mTexts.get(i2), this.mNormalPaint) + ((float) LABEL_TEXT_MARGIN));
            } else {
                int avaiableWidth = this.mMaxWidth - width;
                float textLength = getTextLength(this.mTexts.get(i2), this.mNormalPaint);
                int i3 = LABEL_TEXT_MARGIN;
                float actualSourceWidth = textLength + ((float) i3);
                if (((float) avaiableWidth) > actualSourceWidth) {
                    width = (int) (((float) width) + actualSourceWidth);
                } else {
                    String fitTextLabel = FeedAdUtil.fitTextLabel(this.mSource, this.mSubTag, (float) (avaiableWidth - i3), this.mNormalPaint);
                    this.mAdSource = fitTextLabel;
                    this.mTexts.set(i2, fitTextLabel);
                    width += avaiableWidth;
                }
            }
            if (width > this.mMaxWidth) {
                break;
            }
            i2++;
        }
        this.mIndex = i2;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        long startTime = RenderCostMonitor.getTime();
        super.dispatchDraw(canvas);
        RenderCostMonitor.getInstance().updateStatistic(getClass().getSimpleName(), "dispatchDraw", RenderCostMonitor.getElapsedTime(Long.valueOf(startTime), RenderCostMonitor.getTime()), getFeedId());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        drawSelf(canvas);
        canvas.restore();
    }

    private void drawSelf(Canvas canvas) {
        int left;
        if (this.mTopDrawableText == null) {
            int left2 = 0;
            FeedSquareDraweeView feedSquareDraweeView = this.mSquareIcon;
            if (feedSquareDraweeView != null && feedSquareDraweeView.getVisibility() == 0) {
                int left3 = 0 + this.mSquareIcon.getMeasuredWidth();
                TextView textView = this.mSquareIconDesc;
                left2 = (textView == null || textView.getVisibility() != 0) ? left3 + this.mSquareIcon.getSquareDraweeRightMargin() : left3 + this.mSquareIconDesc.getMeasuredWidth() + this.mSquareIcon.getSquareDraweeRightMargin();
            }
            FeedDraweeView feedDraweeView = this.mAuthorIcon;
            if (feedDraweeView != null && feedDraweeView.getVisibility() == 0) {
                left2 += this.mAuthorIcon.getMeasuredWidth() + AUTHOR_ICON_MARGIN_RIGHT;
            }
            FeedDraweeView feedDraweeView2 = this.mAdTagImageView;
            if (feedDraweeView2 != null && feedDraweeView2.getVisibility() == 0) {
                left2 += this.mAdTagImageView.getMeasuredWidth() + AD_TAG_IMAGE_MARGIN_RIGHT;
            }
            if (isPoiViewVisible()) {
                left2 += this.mPoiView.getMeasuredWidth() + POI_MARGIN_RIGHT;
            }
            if (hitFeedBarStyle(this.mFeedModel)) {
                left2 += this.mBarView.getMeasuredWidth();
            }
            int index = Math.min(this.mIndex, this.mTexts.size());
            for (int i2 = 0; i2 < index; i2++) {
                int height = getMeasuredHeight();
                if (this.mTexts.get(i2) == this.mTag) {
                    int i3 = TAG_HEIGHT;
                    float offsetY = ((float) (height - i3)) / 2.0f;
                    if (this.mIsTagHasBorder) {
                        this.mRectF.left = (float) left;
                        this.mRectF.top = offsetY;
                        this.mRectF.right = ((float) ((TAG_PADDING * 2) + left)) + getTextLength(this.mTag, this.mTagPaint);
                        RectF rectF = this.mRectF;
                        rectF.bottom = rectF.top + ((float) i3);
                        RectF rectF2 = this.mRectF;
                        int i4 = CORNER_RADIUS;
                        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, this.mTagBorderPaint);
                    }
                    int i5 = 0;
                    canvas.drawText(this.mTag, (float) ((this.mIsTagHasBorder ? TAG_PADDING : 0) + left), ((((float) i3) / 2.0f) + offsetY) - ((this.mTagPaint.getFontMetrics().top + this.mTagPaint.getFontMetrics().bottom) / 2.0f), this.mTagPaint);
                    float f2 = (float) left;
                    float textLength = getTextLength(this.mTag, this.mTagPaint);
                    if (this.mIsTagHasBorder) {
                        i5 = TAG_PADDING * 2;
                    }
                    left = (int) (f2 + textLength + ((float) i5) + ((float) LABEL_TEXT_MARGIN));
                } else if (this.isApplyVideoDetailCommend && !TextUtils.isEmpty(this.mCommendContent) && this.mCommendContent.equals(this.mTexts.get(i2))) {
                    canvas.drawText(this.mTexts.get(i2), (float) left, getTextBaseLineY(this.mReasonPaint, height, this.mTexts.get(i2)), this.mReasonPaint);
                    left = (int) (((float) left) + getTextLength(this.mTexts.get(i2), this.mReasonPaint) + ((float) LABEL_TEXT_MARGIN));
                } else if (this.sourceTag == null || this.mTexts.get(i2) != this.sourceTag.text) {
                    canvas.drawText(this.mTexts.get(i2), (float) left, getTextBaseLineY(this.mNormalPaint, height, this.mTexts.get(i2)), this.mNormalPaint);
                    left = (int) (((float) left) + getTextLength(this.mTexts.get(i2), this.mNormalPaint) + ((float) LABEL_TEXT_MARGIN));
                } else {
                    left = (int) (((float) left) + this.sourceTag.onDraw(canvas, left, height));
                }
            }
        }
    }

    private boolean isPoiViewVisible() {
        FeedHotPoiView feedHotPoiView = this.mPoiView;
        return feedHotPoiView != null && feedHotPoiView.getVisibility() == 0;
    }

    private float getTextBaseLineY(TextPaint paint, int maxHeight, String text) {
        if (TextUtils.isEmpty(text) || (!text.contains("y") && !text.contains("g"))) {
            return ((((float) maxHeight) - getTextHeight(paint)) / 2.0f) - paint.getFontMetrics().top;
        }
        return ((((float) maxHeight) - getTextHeight(paint)) / 2.0f) - paint.getFontMetrics().ascent;
    }

    private float getTextHeight(TextPaint paint) {
        return paint.getFontMetrics().bottom - paint.getFontMetrics().top;
    }

    public void update(FeedBaseModel model, Map<String, Object> options) {
        if (model != null) {
            this.mFeedModel = model;
            this.mExtraData = (ExtraData) options;
            updatePaints(model.data);
            textLengthProcess();
            setNeedShowTopTextView(model);
            setNeedShowPoiView(model);
            setNeedShowUnlikeIcon(model);
            setNeedShowAuthorIcon(model);
            setNeedShowEnterView();
            showSquareIconIfNeed(model);
            setAdTagImageVisibility(false);
            setNeedFeedBarView(model, options);
            initAdTagView(model);
            setAdSlidingTag(model);
            if (isHeightWrapContent(this.mFeedModel)) {
                this.mMaxHeight = 0;
            } else {
                this.mMaxHeight = TAG_TEXT_SIZE;
            }
            requestLayout();
            invalidate();
        }
    }

    private void buildSourceTag() {
        FeedLabelSourceTag build = FeedLabelSourceTag.build(this.mFeedModel);
        this.sourceTag = build;
        if (build.isValid()) {
            this.sourceTag.buildTextPaint();
        }
    }

    private boolean isHeightWrapContent(FeedBaseModel model) {
        if (model == null || model.data == null) {
            return false;
        }
        boolean hitLayoutStyle = hitLayoutStyle(model);
        if (!TextUtils.equals(model.layout, FeedTplNameCenter.TITLE_ONLY_TOP) || !FeedFilter.checkTopTemplate(model) || !hitLayoutStyle || model.data.isShowDislike) {
            return false;
        }
        return true;
    }

    private void updatePaints(FeedItemData itemData) {
        this.mNormalPaint.setColor(ContextCompat.getColor(getContext(), com.baidu.searchbox.feed.styles.R.color.FC2));
        setTextSize(this.mNormalPaint, getFontTextSize((float) NORMAL_TEXT_SIZE), getFontType(this.mFeedModel));
        this.mTagPaint.setColor(toggleColorSafe(NightModeHelper.getNightModeSwitcherState() ? itemData.tagNightColor : itemData.tagColor, com.baidu.android.common.ui.style.R.color.GC8));
        setTextSize(this.mTagPaint, getFontTextSize(getTextSize(itemData.tagTextSize, 10)), getFontType(this.mFeedModel));
        this.mTagBorderPaint.setColor(TAG_TEXT_COLOR);
        boolean z = !"0".equals(itemData.tagHasBorder.trim());
        this.mIsTagHasBorder = z;
        if (z) {
            this.mTagBorderPaint.setColor(toggleColorSafe(NightModeHelper.getNightModeSwitcherState() ? itemData.tagNightBorderColor : itemData.tagBorderColor, R.color.feed_type_txt_bg_color_cu));
        }
    }

    private void textLengthProcess() {
        this.mTexts.clear();
        FeedBaseModel feedBaseModel = this.mFeedModel;
        String str = null;
        FeedItemData itemData = feedBaseModel == null ? null : feedBaseModel.data;
        String str2 = itemData == null ? null : itemData.tag;
        this.mTag = str2;
        if (!TextUtils.isEmpty(str2) && isNeedShowTag()) {
            String cutTextIfNeed = cutTextIfNeed(this.mTag, (float) TAG_MAX_WIDTH, this.mTagPaint);
            this.mTag = cutTextIfNeed;
            this.mTexts.add(cutTextIfNeed);
        }
        String str3 = itemData == null ? null : itemData.mCommendReason;
        this.mCommendContent = str3;
        if (this.isApplyVideoDetailCommend && !TextUtils.isEmpty(str3)) {
            String cutTextIfNeed2 = cutTextIfNeed(this.mCommendContent, (float) RECOMMEND_MAX_WIDTH, this.mReasonPaint);
            this.mCommendContent = cutTextIfNeed2;
            this.mTexts.add(cutTextIfNeed2);
        }
        FeedLabelSourceTag build = FeedLabelSourceTag.build(this.mFeedModel);
        this.sourceTag = build;
        if (build.isValid() && !hitLayoutStyle(this.mFeedModel)) {
            this.sourceTag.setTextSize(getFontTextSize(this.sourceTag.getDefaultTextSize()));
            TextPaint paint = this.sourceTag.buildTextPaint();
            FeedLabelSourceTag feedLabelSourceTag = this.sourceTag;
            feedLabelSourceTag.text = cutTextIfNeed(feedLabelSourceTag.text, (float) FeedLabelSourceTag.MAX_WIDTH, paint);
            this.mTexts.add(this.sourceTag.text);
        }
        this.mSubTag = itemData == null ? null : itemData.subTag;
        String str4 = itemData == null ? null : itemData.source;
        this.mSource = str4;
        if (!TextUtils.isEmpty(str4)) {
            String cutTextIfNeed3 = cutTextIfNeed(this.mSource, (float) SOURCE_MAX_WIDTH, this.mNormalPaint);
            this.mSource = cutTextIfNeed3;
            this.mTexts.add(cutTextIfNeed3);
        }
        String str5 = itemData == null ? null : itemData.reason;
        this.mReason = str5;
        if (!this.mHideReasonText && !TextUtils.isEmpty(str5)) {
            String cutTextIfNeed4 = cutTextIfNeed(this.mReason, (float) RECOMMEND_MAX_WIDTH, this.mNormalPaint);
            this.mReason = cutTextIfNeed4;
            this.mTexts.add(cutTextIfNeed4);
        }
        String str6 = itemData == null ? null : itemData.commentNum;
        this.mComment = str6;
        if (!TextUtils.isEmpty(str6) && !hitLayoutStyle(this.mFeedModel) && this.mShowCommentNum) {
            String cutTextIfNeed5 = cutTextIfNeed(this.mComment, (float) COMMENT_MAX_WIDTH, this.mNormalPaint);
            this.mComment = cutTextIfNeed5;
            this.mTexts.add(cutTextIfNeed5);
        }
        if (itemData != null && !TextUtils.isEmpty(itemData.publishTime)) {
            String formatTimeInRange = FeedUtil.formatTimeInRange(itemData.publishTime, itemData.publishTimeRange);
            this.mTime = formatTimeInRange;
            if (!TextUtils.isEmpty(formatTimeInRange)) {
                String cutTextIfNeed6 = cutTextIfNeed(this.mTime, (float) TIME_MAX_WIDTH, this.mNormalPaint);
                this.mTime = cutTextIfNeed6;
                this.mTexts.add(cutTextIfNeed6);
            }
        }
        if (itemData != null) {
            str = itemData.commonText;
        }
        this.mCommonText = str;
        if (!TextUtils.isEmpty(str)) {
            if (isPoiViewVisible()) {
                this.mTexts.clear();
            }
            String cutTextIfNeed7 = cutTextIfNeed(this.mCommonText, (float) TIME_MAX_WIDTH, this.mNormalPaint);
            this.mCommonText = cutTextIfNeed7;
            this.mTexts.add(cutTextIfNeed7);
        }
        if (hitFeedBarStyle(this.mFeedModel)) {
            this.mTexts.clear();
        }
    }

    public void isApplyVideoDetailCommend(boolean isApply) {
        this.isApplyVideoDetailCommend = isApply;
        TextPaint textPaint = new TextPaint();
        this.mReasonPaint = textPaint;
        textPaint.setAntiAlias(true);
        setTextSize(this.mReasonPaint, NORMAL_TEXT_SIZE, getFontType(this.mFeedModel));
        this.mReasonPaint.setColor(getColorById(com.baidu.android.common.ui.style.R.color.GC8));
    }

    private String cutTextIfNeed(String str, float width, TextPaint paint) {
        return TextUtils.ellipsize(str, paint, width, TextUtils.TruncateAt.END).toString();
    }

    private float getTextLength(String str, TextPaint paint) {
        return paint.measureText(str);
    }

    /* access modifiers changed from: protected */
    public String getFeedId() {
        FeedBaseModel feedBaseModel = this.mFeedModel;
        if (feedBaseModel != null) {
            return feedBaseModel.id;
        }
        return "-1";
    }

    public void setEnterViewOnClickListener(View.OnClickListener l) {
        if (l != null) {
            this.mEnterViewClickListener = l;
        }
    }

    public void setUnlikeButtonOnClickListener(View.OnClickListener l) {
        this.mUnLike.setOnClickListener(l);
    }

    public void setRalButtonOnClickListener(View.OnClickListener l) {
        if (l != null) {
            this.mRalButtonClickListener = l;
        }
    }

    public ImageView getUnlikeButton() {
        return this.mUnLike;
    }

    public TextView getRalVoiceButton() {
        return this.mRadioPlayIcon;
    }

    public boolean getEnterViewShow() {
        return this.mIsEnterViewShow;
    }

    public boolean getRalVoiceBtnShow() {
        return this.mIsRalVoiceBtnShow;
    }

    private boolean isNeedShowEnterView(boolean ttsStatus, ExtraData extraData) {
        if (!isSupportEnterView() || extraData == null) {
            return false;
        }
        if ((!ttsStatus || !TextUtils.equals(extraData.feedUsedFor, ExtraData.USED_FOR_MAIN_FEED) || !TextUtils.equals(extraData.abTestMode, ExtraData.AB_TEST_DEFAULT)) && ((!TextUtils.equals(extraData.feedUsedFor, ExtraData.USED_FOR_HOME_TAB3_TTS_1) || !TextUtils.equals(extraData.abTestMode, ExtraData.AB_TEST_TTS_1)) && (!TextUtils.equals(extraData.feedUsedFor, ExtraData.USED_FOR_HOME_TAB3_TTS_2) || !TextUtils.equals(extraData.abTestMode, ExtraData.AB_TEST_TTS_2)))) {
            return false;
        }
        return true;
    }

    private boolean isSupportEnterView() {
        switch (this.mFeedModel.getHelper().serverViewSourceState()) {
            case -1:
                return localJudgeSupportEnterView();
            case 0:
                return false;
            case 1:
                return true;
            default:
                return localJudgeSupportEnterView();
        }
    }

    private boolean localJudgeSupportEnterView() {
        IFeedTemplate template = FeedTemplateManager.SERVICE.getFeedTemplate((CharSequence) this.mFeedModel.layout);
        if (template instanceof SimpleFeedTemplate) {
            return ((SimpleFeedTemplate) template).shouldShowOriginalEnter();
        }
        return true;
    }

    public void setRadioState(RalState ralState) {
        if (ralState == RalState.RAL_STATE_IDLE || !this.mFeedModel.getTtsModel().canTTS()) {
            TTSPlayIcon tTSPlayIcon = this.mRadioPlayIcon;
            if (tTSPlayIcon != null) {
                tTSPlayIcon.setVisibility(8);
            }
            this.mIsRalVoiceBtnShow = false;
            FeedBarView feedBarView = this.mBarView;
            if (feedBarView != null) {
                feedBarView.setTtsOpenMode(false);
                return;
            }
            return;
        }
        if (this.mRadioPlayIcon == null) {
            initRadioPlayIcon();
        }
        this.mRadioPlayIcon.setVisibility(0);
        this.mIsRalVoiceBtnShow = true;
        FeedBarView feedBarView2 = this.mBarView;
        if (feedBarView2 != null) {
            feedBarView2.setTtsOpenMode(true);
        }
        setTextSize((TextView) this.mRadioPlayIcon, (float) RADIO_PLAY_ICON_TEXT_SIZE, getFontType(this.mFeedModel));
        this.mRadioPlayIcon.setGravity(17);
        int resId = -1;
        if (ralState == RalState.RAL_STATE_PLAY) {
            resId = R.drawable.feed_template_big_ral_play_icon;
            this.mRadioPlayIcon.setText(com.baidu.searchbox.bdmedia.interfaces.R.string.tts_feed_radio_pause_text);
            if (FeedPolicy.isFollowAndTtsBtnNewStyle(this.mFeedModel)) {
                this.mRadioPlayIcon.setBackground(getBackgroundDrawable(R.drawable.feed_radio_play_btn_bg_selector_new));
            } else {
                this.mRadioPlayIcon.setBackground(getBackgroundDrawable(R.drawable.feed_radio_play_btn_bg_selector));
            }
            this.mRadioPlayIcon.setTextColor(getColorById(com.baidu.searchbox.feed.styles.R.color.FC133));
        } else if (ralState == RalState.RAL_STATE_PAUSE) {
            resId = R.drawable.feed_template_big_ral_pause_icon;
            this.mRadioPlayIcon.setText(com.baidu.searchbox.bdmedia.interfaces.R.string.tts_feed_radio_play_text);
            if (FeedPolicy.isFollowAndTtsBtnNewStyle(this.mFeedModel)) {
                this.mRadioPlayIcon.setBackground(getBackgroundDrawable(R.drawable.feed_radio_play_btn_bg_selector_new));
            } else {
                this.mRadioPlayIcon.setBackground(getBackgroundDrawable(R.drawable.feed_radio_pause_btn_bg_selector));
            }
            this.mRadioPlayIcon.setTextColor(getColorById(com.baidu.searchbox.feed.styles.R.color.FC110));
        }
        Drawable drawable = FontAdjustment.getScaledFrameworkDrawable(getResources().getDrawable(resId));
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mRadioPlayIcon.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public static void handleTtsAnimate(FeedLabelView feedLabelView, FeedBaseModel model, boolean otherStopCondition) {
        if (feedLabelView != null) {
            IFeedTTSModel ttsModel = model.getTtsModel();
            if (!ttsModel.canTTS()) {
                feedLabelView.stopTTS();
            } else if (ttsModel.getTtsState() == 0) {
                feedLabelView.stopTTS();
            } else if (otherStopCondition || ttsModel.getTtsState() == 2) {
                feedLabelView.stopTTS();
            } else {
                feedLabelView.playTTS();
            }
        }
    }

    public void playTTS() {
        ExtraData extraData = this.mExtraData;
        if (extraData == null || !extraData.abTestMode.equals(ExtraData.AB_TEST_READ_LISTEN_MODE)) {
            this.mTTs.setVisibility(0);
            this.mTTs.setBackgroundResource(R.drawable.feed_tts_play);
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mTTs.getBackground();
            if (animationDrawable != null) {
                animationDrawable.start();
                return;
            }
            return;
        }
        RalState ralState = RalState.RAL_STATE_IDLE;
        if (isTtsMode()) {
            ralState = RalState.RAL_STATE_PLAY;
        }
        setRadioState(ralState);
    }

    public void stopTTS() {
        ExtraData extraData = this.mExtraData;
        if (extraData == null || !extraData.abTestMode.equals(ExtraData.AB_TEST_READ_LISTEN_MODE)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mTTs.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.mTTs.setVisibility(8);
            return;
        }
        RalState ralState = RalState.RAL_STATE_IDLE;
        if (isTtsMode()) {
            ralState = RalState.RAL_STATE_PAUSE;
        }
        setRadioState(ralState);
    }

    private boolean isTtsMode() {
        boolean channelSwitch = false;
        FeedBaseModel feedBaseModel = this.mFeedModel;
        if (feedBaseModel != null) {
            if (FeedChannelConstants.isDynamicImmersiveChannel(feedBaseModel.runtimeStatus.channelId) && !TTSSwitchUtil.sDynamicImmersiveTtsSwitch) {
                return false;
            }
            channelSwitch = TTSSwitchUtil.getTTSSwitch(this.mFeedModel.runtimeStatus.channelId);
        }
        if (RalTTSLocalSwitcher.getInstance().getLocalSwitcher() || channelSwitch) {
            return true;
        }
        return false;
    }

    public void updateRefreshTime() {
        FeedBaseModel feedBaseModel = this.mFeedModel;
        if (feedBaseModel != null && feedBaseModel.data != null && !TextUtils.isEmpty(this.mFeedModel.data.publishTime) && this.mTexts.contains(this.mTime)) {
            textLengthProcess();
            requestLayout();
            invalidate();
        }
    }

    private void setNeedShowUnlikeIcon(FeedBaseModel model) {
        setNeedShowUnlikeIcon(!FeedChannelConstants.isSearchHotChannel(model.runtimeStatus.channelId) && model.data != null && model.data.isShowDislike && !hitDynamicBarStyle(model) && !FeedAdUtil.isShowNewFeedBarForUgc(model));
        FeedOrderSenseUtil.setDislikePicture(this.mUnLike, 2, model);
    }

    public void setNeedShowUnlikeIcon(boolean needShow) {
        int i2 = 8;
        if (!FeedAdUtil.isDynamicDetailBannerAd(this.mFeedModel) || this.mFeedModel.feedback != null) {
            int i3 = 0;
            if (isHeightWrapContent(this.mFeedModel) || hitDynamicBarStyle(this.mFeedModel) || FeedAdUtil.hitBarBtnMoveUp(this.mFeedModel)) {
                ImageView imageView = this.mUnLike;
                if (needShow) {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
            } else {
                ImageView imageView2 = this.mUnLike;
                if (!needShow) {
                    i3 = 4;
                }
                imageView2.setVisibility(i3);
            }
            this.mUnLike.setClickable(needShow);
            return;
        }
        this.mUnLike.setVisibility(8);
    }

    private void showDislikeGuide() {
        FeedBaseModel feedBaseModel;
        if (this.mUnLike.getVisibility() == 0 && (feedBaseModel = this.mFeedModel) != null && feedBaseModel.data != null && this.mFeedModel.runtimeStatus != null && FeedChannelConstants.isFeedChannel(this.mFeedModel.runtimeStatus.channelId) && TextUtils.equals(this.mFeedModel.data.showDislikeGuide, "1") && !FeedPreferenceUtils.getBoolean(DISLIKE_BUBBLE_TOAST, false)) {
            BubbleManager bubbleManager = this.mBubbleManager;
            if ((bubbleManager == null || bubbleManager.isDismissed()) && this.mUnLike != null) {
                BubbleManager build = BubbleManager.getBuilder().setAnchor(this.mUnLike).setText(getResources().getString(R.string.feed_dislike_dislike_guide_toast)).enableAnimation(true).isAutoDetectShowPosition(true).setAutoDismissInterval(3000).setPaddingBetweenAnchor((float) DeviceUtil.ScreenInfo.px2dp(getContext(), getResources().getDimension(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X015))).setOnBubbleEventListener(new BubbleManager.OnBubbleEventListener() {
                    public void onBubbleDismiss() {
                        BubbleManager unused = FeedLabelView.this.mBubbleManager = null;
                    }

                    public void onBubbleShow() {
                        FeedPreferenceUtils.putBoolean(FeedLabelView.DISLIKE_BUBBLE_TOAST, true);
                        FeedStatisticCenter.dislikeShowStatistics("toast_show", "list", FeedLabelView.this.mFeedModel.id);
                    }

                    public void onBubbleClick() {
                        FeedLabelView.this.mBubbleManager.dismissBubble();
                    }
                }).build();
                this.mBubbleManager = build;
                build.showBubble();
            }
        }
    }

    private void setNeedShowEnterView() {
        ExtraData extraData = this.mExtraData;
        setNeedShowEnterView(extraData != null && isNeedShowEnterView(extraData.isGlobalTTSMode, this.mExtraData) && !hitFeedBarStyle(this.mFeedModel));
    }

    private void setNeedShowEnterView(boolean needShow) {
        if (this.mIsEnterViewShow != needShow) {
            this.mIsEnterViewShow = needShow;
            if (this.mEnterView == null) {
                initEnterView();
            }
            this.mEnterView.setVisibility(needShow ? 0 : 8);
            this.mEnterView.setTextColor(FeedRuntime.getAppContext().getResources().getColorStateList(R.color.feed_enter_text_color));
            FeedUtil.setBackground(this.mEnterView, getResources().getDrawable(R.drawable.feed_enter_rect_bg));
        }
    }

    private void showSquareIconIfNeed(FeedBaseModel model) {
        if (!hitFeedBarStyle(model)) {
            this.mSquareIcon = FeedSquareDraweeView.from(getContext(), model, this.mSquareIcon, this);
            initSquareIconDescIfNeed();
            return;
        }
        FeedSquareDraweeView feedSquareDraweeView = this.mSquareIcon;
        if (feedSquareDraweeView != null) {
            feedSquareDraweeView.setVisibility(8);
        }
        TextView textView = this.mSquareIconDesc;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void initSquareIconDescIfNeed() {
        FeedSquareDraweeView feedSquareDraweeView = this.mSquareIcon;
        if (feedSquareDraweeView != null) {
            if (feedSquareDraweeView.getVisibility() == 8) {
                TextView textView = this.mSquareIconDesc;
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.mSquareIconDesc == null) {
                TextView textView2 = new TextView(getContext());
                this.mSquareIconDesc = textView2;
                textView2.setId(R.id.feed_aider_desc_tag);
                this.mSquareIconDesc.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mSquareIconDesc.setGravity(17);
                this.mSquareIconDesc.setLines(1);
                this.mSquareIconDesc.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (FeedLabelView.this.mFeedModel != null && FeedLabelView.this.mSquareIcon != null) {
                            FeedLabelView.this.mSquareIcon.clickIcon(FeedLabelView.this.mFeedModel);
                        }
                    }
                });
                addView(this.mSquareIconDesc);
            }
            FeedBaseModel feedBaseModel = this.mFeedModel;
            if (feedBaseModel == null || feedBaseModel.data == null || this.mFeedModel.data.aider == null) {
                this.mSquareIconDesc.setVisibility(8);
                return;
            }
            FeedAider aider = this.mFeedModel.data.aider;
            if (!TextUtils.isEmpty(aider.iconDesc)) {
                this.mSquareIconDesc.setText(aider.iconDesc);
                setTextSize(this.mSquareIconDesc, (float) NORMAL_TEXT_SIZE, getFontType(this.mFeedModel));
                this.mSquareIconDesc.setVisibility(0);
            } else {
                this.mSquareIconDesc.setVisibility(8);
            }
            String color = FeedRuntime.getNightMode() ? aider.iconDescColorNight : aider.iconDescColor;
            if (!TextUtils.isEmpty(color)) {
                this.mSquareIconDesc.setTextColor(Color.parseColor(color));
            }
        }
    }

    public void setNeedShowAuthorIcon(FeedBaseModel model) {
        FeedItemData itemData = model.data;
        if (itemData == null || TextUtils.isEmpty(itemData.authorIconUrl) || hitFeedBarStyle(model)) {
            FeedDraweeView feedDraweeView = this.mAuthorIcon;
            if (feedDraweeView != null && feedDraweeView.getVisibility() != 8) {
                this.mAuthorIcon.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mAuthorIcon == null) {
            FeedDraweeView feedDraweeView2 = new FeedDraweeView(getContext());
            this.mAuthorIcon = feedDraweeView2;
            feedDraweeView2.setId(R.id.feed_item_ai_app_icon);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setRoundAsCircle(true);
            ((GenericDraweeHierarchy) this.mAuthorIcon.getHierarchy()).setRoundingParams(roundingParams);
            this.mAuthorIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int i2 = AUTHOR_ICON_SIZE;
            this.mAuthorIcon.setLayoutParams(new ViewGroup.LayoutParams(i2, i2));
            addView(this.mAuthorIcon);
        }
        this.mAuthorIcon.setTemplateFlag(6);
        this.mAuthorIcon.setPlaceHolderWithSelfFlag().loadImage(itemData.authorIconUrl, model);
        this.mAuthorIcon.setVisibility(0);
    }

    public void setNeedShowTopTextView(FeedBaseModel model) {
        FeedRuntimeStatus status = model == null ? null : model.runtimeStatus;
        FeedItemData itemData = model == null ? null : model.data;
        if (status != null && !FeedChannelConstants.isFeedChannel(status.channelId) && (itemData instanceof FeedItemDataStar) && ((FeedItemDataStar) itemData).isTop && !hitFeedBarStyle(model)) {
            if (this.mTopDrawableText == null) {
                DrawableTextView drawableTextView = new DrawableTextView(getContext());
                this.mTopDrawableText = drawableTextView;
                drawableTextView.setVisibility(0);
                setTextSize((TextView) this.mTopDrawableText, FeedRuntime.getAppContext().getResources().getDimension(com.baidu.searchbox.feed.styles.R.dimen.F_T_X116), getFontType(this.mFeedModel));
                this.mTopDrawableText.setText(R.string.feed_hot_is_top_text);
                this.mTopDrawableText.setCompoundDrawablePadding((int) FeedRuntime.getAppContext().getResources().getDimension(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X115));
                addView(this.mTopDrawableText, new ViewGroup.LayoutParams(-2, -2));
            }
            this.mTopDrawableText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.feed_hot_is_top_icon), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mTopDrawableText.setTextColor(ContextCompat.getColor(FeedRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC8));
            return;
        }
        DrawableTextView drawableTextView2 = this.mTopDrawableText;
        if (drawableTextView2 != null) {
            drawableTextView2.setVisibility(8);
        }
    }

    public void setNeedShowPoiView(FeedBaseModel model) {
        FeedItemData itemData = null;
        FeedRuntimeStatus status = model == null ? null : model.runtimeStatus;
        if (model != null) {
            itemData = model.data;
        }
        if (status != null && !FeedChannelConstants.isFeedChannel(status.channelId) && (itemData instanceof FeedItemDataStar) && !((FeedItemDataStar) itemData).isTop && ((FeedItemDataStar) itemData).poiData != null && ((FeedItemDataStar) itemData).poiData.check() && !hitFeedBarStyle(model)) {
            if (this.mPoiView == null) {
                this.mPoiView = new FeedHotPoiView(getContext());
                addView(this.mPoiView, new ViewGroup.LayoutParams(-2, -2));
            }
            this.mPoiView.setVisibility(0);
            this.mPoiView.update(model, ((FeedItemDataStar) itemData).poiData, false);
            return;
        }
        FeedHotPoiView feedHotPoiView = this.mPoiView;
        if (feedHotPoiView != null) {
            feedHotPoiView.setVisibility(8);
        }
    }

    public void setHideReasonText(boolean isHide) {
        this.mHideReasonText = isHide;
    }

    public void setShowCommentNum(boolean toShown) {
        this.mShowCommentNum = toShown;
    }

    private int toggleColorSafe(String deliverColor, int defaultColorId) {
        if (TextUtils.isEmpty(deliverColor)) {
            return ContextCompat.getColor(getContext(), defaultColorId);
        }
        try {
            return Color.parseColor(deliverColor);
        } catch (IllegalArgumentException e2) {
            return ContextCompat.getColor(getContext(), defaultColorId);
        }
    }

    private static int getDimensionPixelSizeById(int id) {
        return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(id);
    }

    private static int getColorById(int id) {
        return ContextCompat.getColor(FeedRuntime.getAppContext(), id);
    }

    private static Drawable getBackgroundDrawable(int id) {
        return FontAdjustment.getScaledFrameworkDrawable(id);
    }

    public void setNormalTextSize(int textSize) {
        setTextSize(this.mNormalPaint, textSize, getFontType(this.mFeedModel));
    }

    private boolean isNeedShowTag() {
        if (!(this.mFeedModel.data instanceof FeedItemDataStar)) {
            return true;
        }
        FeedItemDataStar dataStar = (FeedItemDataStar) this.mFeedModel.data;
        if ((dataStar.topAuthorInfo.followInfo == null || dataStar.topAuthorInfo.followInfo.button == null || dataStar.topAuthorInfo.pendantInfo == null || !"1".equals(dataStar.topAuthorInfo.followInfo.button.state) || !"1".equals(dataStar.topAuthorInfo.pendantInfo.originFollowState)) && dataStar.feedBar != null) {
            return false;
        }
        return true;
    }

    private void initRadioPlayIcon() {
        TTSPlayIcon tTSPlayIcon = new TTSPlayIcon(getContext());
        this.mRadioPlayIcon = tTSPlayIcon;
        tTSPlayIcon.setId(R.id.feed_id_radio_icon_tag);
        this.mRadioPlayIcon.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (FeedPolicy.isFollowAndTtsBtnNewStyle(this.mFeedModel)) {
            this.mRadioPlayIcon.setIncludeFontPadding(false);
            int paddingLR = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X053);
            int paddingTB = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X053);
            this.mRadioPlayIcon.setPadding(paddingLR, paddingTB, paddingLR, paddingTB);
            this.mRadioPlayIcon.setBackground(getBackgroundDrawable(R.drawable.feed_radio_play_btn_bg_selector_new));
        } else {
            this.mRadioPlayIcon.setIncludeFontPadding(true);
            int paddingLR2 = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X052);
            int paddingTB2 = (int) (((float) paddingLR2) - CtxResEasyUtils.dp2px(1.8f));
            this.mRadioPlayIcon.setPadding(paddingLR2, paddingTB2, paddingLR2, paddingTB2);
            this.mRadioPlayIcon.setBackground(getBackgroundDrawable(R.drawable.feed_radio_play_btn_bg_selector));
        }
        setTextSize((TextView) this.mRadioPlayIcon, (float) RADIO_PLAY_ICON_TEXT_SIZE, getFontType(this.mFeedModel));
        this.mRadioPlayIcon.setTextColor(getColorById(com.baidu.searchbox.feed.styles.R.color.FC110));
        this.mRadioPlayIcon.setText(com.baidu.searchbox.bdmedia.interfaces.R.string.tts_feed_radio_play_text);
        this.mRadioPlayIcon.initDrawable(FeedRuntime.getAppContext().getResources().getDrawable(R.drawable.feed_template_big_ral_pause_icon), 0, 0, 0);
        this.mRadioPlayIcon.setCompoundDrawablePadding(RADIO_ICON_TEXT_MARGIN);
        this.mRadioPlayIcon.setOnClickListener(this.mRalButtonClickListener);
        this.mRadioPlayIcon.getViewTreeObserver().addOnPreDrawListener(new FeedLabelView$$ExternalSyntheticLambda0(this));
        if (getParent() instanceof View) {
            int expandTop = getResources().getDimensionPixelSize(R.dimen.feed_template_label_ral_v_padding_top);
            int expandBottom = getResources().getDimensionPixelSize(R.dimen.feed_template_label_ral_v_padding_bottom);
            int expandLeft = getResources().getDimensionPixelSize(R.dimen.feed_template_label_ral_h_padding_left);
            int expandRight = getResources().getDimensionPixelSize(R.dimen.feed_template_label_ral_h_padding_right);
            ExpandTouchAreaHelper.expandTouchArea((View) getParent(), this.mRadioPlayIcon, expandLeft, expandTop, expandRight, expandBottom);
        }
        addView(this.mRadioPlayIcon);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initRadioPlayIcon$0$com-baidu-searchbox-feed-template-FeedLabelView  reason: not valid java name */
    public /* synthetic */ boolean m19449lambda$initRadioPlayIcon$0$combaidusearchboxfeedtemplateFeedLabelView() {
        FeedBaseModel feedBaseModel = this.mFeedModel;
        if (feedBaseModel != null && (feedBaseModel.getTtsModel() instanceof FeedTtsModel)) {
            FeedTtsModel ttsModel = (FeedTtsModel) this.mFeedModel.getTtsModel();
            if (!ttsModel.ttsBtnLogShown) {
                ttsModel.ttsBtnLogShown = true;
                IFeedTemplateStatistics feedTempStat = FeedTemplateStatTable.getInstance().get(this.mFeedModel.runtimeStatus.channelId);
                if (feedTempStat != null) {
                    feedTempStat.onTtsPlayBtnShow(this.mFeedModel);
                }
            }
        }
        return true;
    }

    private void initEnterView() {
        TextView textView = new TextView(getContext());
        this.mEnterView = textView;
        textView.setId(R.id.feed_id_enter);
        this.mEnterView.setLayoutParams(new ViewGroup.LayoutParams(ENTER_WIDTH, ENTER_HEIGHT));
        this.mEnterView.setGravity(17);
        setTextSize(this.mEnterView, (float) ENTER_TEXT_SIZE, getFontType(this.mFeedModel));
        this.mEnterView.setText(com.baidu.searchbox.bdmedia.interfaces.R.string.tts_feed_enter_text);
        this.mEnterView.setVisibility(8);
        this.mEnterView.setOnClickListener(this.mEnterViewClickListener);
        addView(this.mEnterView);
    }

    public void setNormalPaintColor(int colorRes) {
        TextPaint textPaint = this.mNormalPaint;
        if (textPaint != null) {
            textPaint.setColor(getColorById(colorRes));
        }
    }

    public void setAdTagImageVisibility(boolean needShow) {
        FeedDraweeView feedDraweeView = this.mAdTagImageView;
        if (feedDraweeView != null) {
            feedDraweeView.setVisibility(needShow ? 0 : 8);
        }
    }

    public void setAdImageTagShow(String tagImageUrl, double iconRatio) {
        int iconWidth;
        if (TextUtils.isEmpty(tagImageUrl)) {
            setAdTagImageVisibility(false);
            return;
        }
        FeedDraweeView feedDraweeView = new FeedDraweeView(getContext());
        this.mAdTagImageView = feedDraweeView;
        feedDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        int adTagImageHeight = AD_TAG_IMAGE_HEIGHT;
        if (iconRatio > 0.0d) {
            iconWidth = (int) (((double) adTagImageHeight) * iconRatio);
        } else {
            iconWidth = AD_TAG_IMAGE_WIDTH;
        }
        this.mAdTagImageView.setLayoutParams(new ViewGroup.LayoutParams(iconWidth, adTagImageHeight));
        addView(this.mAdTagImageView);
        setAdTagImageVisibility(true);
        this.mAdTagImageView.setImageURI(tagImageUrl);
    }

    private boolean hitLayoutStyle(FeedBaseModel model) {
        return model != null && TextUtils.equals(FeedTplNameCenter.TITLE_ONLY_TOP, model.layout) && (model.data instanceof FeedItemDataNews);
    }

    private float getFontTextSize(float defTextSize) {
        FeedItemData itemData;
        FeedBaseModel feedBaseModel = this.mFeedModel;
        if (feedBaseModel == null || (itemData = feedBaseModel.data) == null) {
            return defTextSize;
        }
        float fontSize = getTextSize(itemData.assistFontSize, 0);
        return fontSize > 0.0f ? fontSize : defTextSize;
    }

    private float getTextSize(String str, int def) {
        float textSize;
        try {
            textSize = (float) Integer.parseInt(str);
            if (hitLayoutStyle(this.mFeedModel)) {
                textSize = (textSize < 7.0f || textSize > 12.0f) ? (float) def : textSize;
            }
        } catch (NumberFormatException e2) {
            textSize = (float) def;
        }
        return (float) DeviceUtil.ScreenInfo.dp2px(getContext(), textSize);
    }

    /* access modifiers changed from: protected */
    public void showDislikeBubble() {
        showDislikeGuide();
    }

    /* access modifiers changed from: protected */
    public void dismissBubble() {
        BubbleManager bubbleManager = this.mBubbleManager;
        if (bubbleManager != null && !bubbleManager.isDismissed()) {
            this.mBubbleManager.dismissBubble();
        }
    }

    /* access modifiers changed from: protected */
    public void scrollIdleState() {
        if (isFullDisplayed()) {
            showDislikeGuide();
        }
    }

    /* access modifiers changed from: protected */
    public void handleBubbleShow(int newState) {
        if (newState == 0) {
            showDislikeBubble();
        } else {
            dismissBubble();
        }
    }

    private boolean isFullDisplayed() {
        Rect rect = new Rect();
        return getGlobalVisibleRect(rect) && rect.bottom - rect.top >= getHeight();
    }

    private boolean hitFeedBarStyle(FeedBaseModel model) {
        return (model == null || model.data == null || model.data.feedBar == null || !model.data.hitDynamicLayoutStyle()) ? false : true;
    }

    private boolean hitDynamicBarStyle(FeedBaseModel model) {
        return hitFeedBarStyle(model) && (model.data instanceof FeedItemDataStar) && ((FeedItemDataStar) model.data).renderStrategy != null && ((FeedItemDataStar) model.data).renderStrategy.isDynamicFeedBar();
    }

    private void setNeedFeedBarView(FeedBaseModel model, Map<String, Object> options) {
        FeedBarView feedBarView = this.mBarView;
        if (feedBarView != null) {
            feedBarView.setVisibility(8);
        }
        if (hitFeedBarStyle(this.mFeedModel)) {
            if (this.mBarView == null) {
                this.mBarView = new FeedBarView(getContext());
                Object expendClickValue = options.get("expendClick");
                boolean expendClick = false;
                if (expendClickValue instanceof Boolean) {
                    expendClick = ((Boolean) expendClickValue).booleanValue();
                }
                if (expendClick) {
                    this.mBarView.setFeedBarHeight(getDimensionPixelSizeById(com.baidu.searchbox.generalcommunity.R.dimen.dp_24) + getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X107) + getDimensionPixelSizeById(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X110));
                } else {
                    this.mBarView.setFeedBarHeight(getDimensionPixelSizeById(com.baidu.searchbox.generalcommunity.R.dimen.dp_24));
                }
                addView(this.mBarView, new ViewGroup.LayoutParams(-2, -2));
            }
            if (!hitDynamicBarStyle(this.mFeedModel)) {
                this.mBarView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            } else {
                this.mBarView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.mBarView.setVisibility(0);
            this.mBarView.update(model);
        }
    }

    private static void setTextSize(TextPaint textPaint, int sizePx, int type) {
        textPaint.setTextSize(FontSizeHelper.getScaledSize(type, (float) sizePx));
    }

    private static void setTextSize(TextPaint textPaint, float sizePx, int type) {
        textPaint.setTextSize(FontSizeHelper.getScaledSize(type, sizePx));
    }

    private static void setTextSize(TextView textView, float sizePx, int type) {
        textView.setTextSize(0, FontSizeHelper.getScaledSize(type, sizePx));
    }

    private void initAdTagView(FeedBaseModel model) {
        if (model == null || model.data == null || TextUtils.isEmpty(model.data.subTag) || (FeedAdUtil.isShowNewFeedBarForUgc(model) && !FeedAdUtil.hitBarBtnMoveUp(model))) {
            TextView textView = this.mAdTagText;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mAdTagText == null) {
            TextView textView2 = new TextView(getContext());
            this.mAdTagText = textView2;
            addView(textView2);
        }
        this.mAdTagText.setText(model.data.subTag);
        this.mAdTagText.setTextColor(getColorById(com.baidu.searchbox.feed.styles.R.color.FC225));
        this.mAdTagText.setId(R.id.ad_tag);
        this.mAdTagText.setGravity(17);
        setTextSize(this.mAdTagText, (float) TAG_TEXT_SIZE, getFontType(this.mFeedModel));
        this.mAdTagText.setVisibility(0);
    }

    private void setAdSlidingTag(FeedBaseModel model) {
        if (model == null || model.data == null || model.data.ad.slidingTagModel == null || !FeedAdUtil.forceShowSlidingOnLabelView() || FeedAdUtil.isDynamicDetailBannerAd(this.mFeedModel)) {
            INadSlidingComponent iNadSlidingComponent = this.mAdSlidingTag;
            if (iNadSlidingComponent != null) {
                iNadSlidingComponent.setVisibility(8);
                this.mAdSlidingTag.destroy();
                ViewOpUtils.removeView(this.mAdSlidingTag.getSlidingView());
                this.mAdSlidingTag = null;
                return;
            }
            return;
        }
        if (this.mAdSlidingTag == null) {
            INadSlidingComponent invoke = INadSlidingComponent.Companion.invoke(model.data.ad.slidingTagModel, getContext());
            this.mAdSlidingTag = invoke;
            addView(invoke.getSlidingView());
        }
        this.mAdSlidingTag.setFontSize(0, (float) FontAdjustment.getScaledFrameworkSize(NORMAL_TEXT_SIZE));
        this.mAdSlidingTag.setMaxWidth(RECOMMEND_MAX_WIDTH);
        this.mAdSlidingTag.startDelay(model.data.ad.slidingTagModel);
        this.mAdSlidingTag.onNightModeChanged(NightModeHelper.getNightModeSwitcherState(), Integer.valueOf(getColorById(com.baidu.searchbox.feed.styles.R.color.FC2)));
    }

    private int getFontType(FeedBaseModel model) {
        if (model == null || model.data == null || !FeedAbtestManager.isCustomFontOpen() || !TextUtils.equals(model.layout, FeedTplNameCenter.TITLE_ONLY_TOP) || !FeedFilter.checkTopTemplate(model) || FeedConfig.Font.get().customFrameworkFontSize == -1) {
            return 0;
        }
        return FeedConfig.Font.get().customFrameworkFontSize;
    }

    public FeedBarView getFeedBarView() {
        return this.mBarView;
    }
}
