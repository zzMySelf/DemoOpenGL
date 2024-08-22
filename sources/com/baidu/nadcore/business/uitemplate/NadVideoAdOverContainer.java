package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.R;
import com.baidu.nadcore.business.event.NadDownloadClickEvent;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.business.utils.AdUtil;
import com.baidu.nadcore.cmd.SchemeRouter;
import com.baidu.nadcore.cmd.model.SchemeModel;
import com.baidu.nadcore.cmd.utils.SchemeUtility;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.eventbus.EventBusWrapper;
import com.baidu.nadcore.eventbus.ISubscriber;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdRewardVideoLpModel;
import com.baidu.nadcore.model.AppInfoModel;
import com.baidu.nadcore.stats.Als;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.nadcore.utils.UniversalCountDownTimer;
import com.baidu.nadcore.utils.ViewUtils;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.IEnhancementBtnView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.nadcore.widget.util.WidgetUtilKt;

public class NadVideoAdOverContainer extends RelativeLayout {
    protected static final boolean DEBUG = false;
    private static final String KEY_REWARD_WEB_PANEL = "rewardWebPanel";
    private static final int MAX_RECOMMEND_TAG_NUM = 3;
    private static final int MAX_TITLE_LINES = 2;
    private static final char[] REPLACE_TXT;
    private static final String REPLACE_TXT_STRING;
    private static final String TAG = "NadVideoAdOverContainer";
    /* access modifiers changed from: private */
    public LinearLayout mAdAuthorContainer;
    private RelativeLayout mAdInfoLayout;
    protected SimpleAdInfoView mAdInfoView;
    private AdImageView mAuthorAvatar;
    private TextView mAuthorAvatarTxt;
    /* access modifiers changed from: private */
    public TextView mAuthorName;
    private View mBottomLine;
    private final Object mDownloadEventObject = new Object();
    private TextView mFeedbackBtn;
    private boolean mHotAreaIsEnable = true;
    private LinearLayout mInteractionContainer;
    /* access modifiers changed from: private */
    public boolean mIsFinishEnhanceAnim;
    private PortraitVideoTailView mNewTailFrameView;
    private String mPage = "";
    private PlayerProgressHandler mPlayerProgressHandler;
    private LinearLayout mRecommendTagContainer;
    private boolean mShouldShowAdInfo;
    /* access modifiers changed from: private */
    public UniversalCountDownTimer mTimeoutTimer;
    /* access modifiers changed from: private */
    public TextView mTitle;
    private AdEnhanceBtnListener mTransitionBtnListener;
    private FrameLayout mTransitionButtonContainer;
    protected IEnhancementBtnView<View> mTransitionButtonView;
    /* access modifiers changed from: private */
    public View.OnClickListener mUiClickListener = null;

    public interface PlayerProgressHandler {
        long getAdShowTimestamp();

        int getCurrentLoop();

        int getPosition();

        int getPositionMs();
    }

    static {
        char[] cArr = {21704};
        REPLACE_TXT = cArr;
        REPLACE_TXT_STRING = new String(cArr);
    }

    public NadVideoAdOverContainer(Context context) {
        super(context);
        init(context);
    }

    public NadVideoAdOverContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NadVideoAdOverContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.mTitle = (TextView) findViewById(R.id.nad_video_title);
        this.mAdAuthorContainer = (LinearLayout) findViewById(R.id.nad_author_container);
        this.mAuthorName = (TextView) findViewById(R.id.nad_mini_author_name);
        this.mNewTailFrameView = (PortraitVideoTailView) findViewById(R.id.ad_mini_video_tail_frame_view_new);
        this.mAdInfoLayout = (RelativeLayout) findViewById(R.id.ad_mini_video_info_view);
        this.mInteractionContainer = (LinearLayout) findViewById(R.id.nad_right_vertical_container);
        this.mTransitionButtonContainer = (FrameLayout) findViewById(R.id.ad_transition_btn_view);
        this.mBottomLine = findViewById(R.id.nad_bottom_line);
        this.mRecommendTagContainer = (LinearLayout) findViewById(R.id.nad_mini_video_recommend_tag);
        this.mAdInfoView = (SimpleAdInfoView) findViewById(R.id.nad_app_info_container);
        this.mFeedbackBtn = (TextView) findViewById(R.id.nad_base_delete_id);
        this.mAuthorAvatar = (AdImageView) findViewById(R.id.ad_author_avatar);
        this.mAuthorAvatarTxt = (TextView) findViewById(R.id.ad_author_avatar_txt);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.nad_mini_video_detail_ad_item_over_info;
    }

    public void setData(AdBaseModel model) {
        this.mIsFinishEnhanceAnim = false;
        if (!isDataVaild(model)) {
            setVisibility(8);
            return;
        }
        AdBaseModel data = model;
        setTag(data);
        setVisibility(0);
        initConvertBtnData(data);
        optAdTitle(data);
        authorUiAdaptive();
        initListener(data);
        initRecommendTagView(data);
        registerDownloadEventBus(data);
    }

    private void initListener(AdBaseModel data) {
        this.mTitle.setOnClickListener(initPanelListener(data, ClogBuilder.Area.TITTLE.type));
        TextView textView = this.mAuthorAvatarTxt;
        if (textView != null) {
            textView.setOnClickListener(initPanelListener(data, ClogBuilder.Area.AVATAR.type));
        }
        AdImageView adImageView = this.mAuthorAvatar;
        if (adImageView != null) {
            adImageView.setOnClickListener(initPanelListener(data, ClogBuilder.Area.AVATAR.type));
        }
        this.mAuthorName.setOnClickListener(initPanelListener(data, ClogBuilder.Area.NAME.type));
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener initPanelListener(final AdBaseModel data, final String daArea) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                if (!NadVideoAdOverContainer.this.isShowingTailFrame()) {
                    String cmd = data.common.scheme;
                    if (data.enhanceModel != null && !data.enhanceModel.isReward) {
                        SchemeRouter.invoke(cmd, NadVideoAdOverContainer.this.getContext());
                    }
                    NadVideoAdOverContainer.this.sendActionAls(ClogBuilder.LogType.CLICK, daArea, data);
                    if (NadVideoAdOverContainer.this.mUiClickListener != null) {
                        NadVideoAdOverContainer.this.mUiClickListener.onClick(v);
                    }
                }
            }
        };
    }

    private void initAdInfoArea(final AdBaseModel data) {
        if (data != null) {
            AppInfoModel model = data.appInfo;
            if (!canShowAppInfoLayout(model)) {
                this.mShouldShowAdInfo = false;
                this.mAdInfoView.setVisibility(8);
                this.mNewTailFrameView.setAdInfo((AppInfoModel) null);
                return;
            }
            this.mShouldShowAdInfo = true;
            this.mAdInfoView.setVisibility(0);
            this.mAdInfoView.setAdInfo(model);
            this.mAdInfoView.setAfterListener(new SimpleAdInfoView.AdInfoAfterClickListener() {
                public void afterClick(String daArea) {
                    NadVideoAdOverContainer.this.sendActionAls(ClogBuilder.LogType.FREE_CLICK, daArea, data);
                }
            });
            this.mNewTailFrameView.setAdInfo(model);
        }
    }

    private boolean isDataVaild(AdBaseModel data) {
        return (data == null || data.common == null) ? false : true;
    }

    private void initConvertBtnData(AdBaseModel data) {
        findViewById(R.id.nad_video_btn_placeholder).setVisibility(data.hasOperator ? 0 : 8);
        initEnhanceData(data);
        this.mTransitionButtonContainer.setVisibility(0);
        initCountDownTimer();
    }

    private void initCountDownTimer() {
        UniversalCountDownTimer stausListener = new UniversalCountDownTimer(100000, 1000).setStausListener(new UniversalCountDownTimer.StatusListener() {
            public void onTick(long millsUtilFinished) {
                int progress = Math.round((float) ((100000 - millsUtilFinished) / 1000));
                if (NadVideoAdOverContainer.this.mIsFinishEnhanceAnim) {
                    NadVideoAdOverContainer.this.mTimeoutTimer.cancel();
                    UniversalCountDownTimer unused = NadVideoAdOverContainer.this.mTimeoutTimer = null;
                    return;
                }
                NadVideoAdOverContainer.this.updateProgress(progress);
            }
        });
        this.mTimeoutTimer = stausListener;
        stausListener.start();
    }

    public void release() {
        setVisibility(8);
        UniversalCountDownTimer universalCountDownTimer = this.mTimeoutTimer;
        if (universalCountDownTimer != null) {
            universalCountDownTimer.cancel();
            this.mTimeoutTimer = null;
        }
        IEnhancementBtnView<View> iEnhancementBtnView = this.mTransitionButtonView;
        if (iEnhancementBtnView != null) {
            iEnhancementBtnView.resetAnim();
        }
        unregisterDownloadEventBus();
    }

    private void initEnhanceData(AdBaseModel data) {
        IEnhancementBtnView<View> iEnhancementBtnView = this.mTransitionButtonView;
        if (iEnhancementBtnView != null) {
            iEnhancementBtnView.resetAnim();
            this.mTransitionButtonContainer.setVisibility(8);
            this.mTransitionButtonView = null;
        }
        if (data.enhanceModel == null) {
            this.mIsFinishEnhanceAnim = true;
            return;
        }
        if (data.enhanceModel.transition == null) {
            this.mIsFinishEnhanceAnim = true;
        }
        View btnPlaceholder = findViewById(R.id.nad_video_btn_placeholder);
        btnPlaceholder.setVisibility(0);
        this.mTransitionButtonContainer.setVisibility(0);
        if (this.mTransitionButtonContainer.getChildCount() > 0) {
            this.mTransitionButtonContainer.removeAllViews();
        }
        this.mTransitionButtonView = createEnhanceButtonView(getContext(), this.mTransitionButtonContainer, btnPlaceholder);
        AnonymousClass4 r2 = new AdEnhanceBtnListener(data, (View) this.mTransitionButtonView) {
            public void onEndAnim() {
                boolean unused = NadVideoAdOverContainer.this.mIsFinishEnhanceAnim = true;
            }

            public void onCancelAnim() {
                boolean unused = NadVideoAdOverContainer.this.mIsFinishEnhanceAnim = true;
            }
        };
        this.mTransitionBtnListener = r2;
        r2.setOnAdClickListener(this.mUiClickListener);
        this.mTransitionButtonView.setEnhanceBtnListener(this.mTransitionBtnListener);
        this.mTransitionButtonView.setData(data.enhanceModel);
        this.mTransitionButtonView.setBtnIconNightModeEnable(false);
    }

    public IEnhancementBtnView<View> createEnhanceButtonView(Context context, ViewGroup container, View btnPlaceholder) {
        return new AdEnhanceButtonView(context, container, btnPlaceholder);
    }

    private void initRecommendTagView(AdBaseModel data) {
    }

    private TextView createRecommendTagView(String text, int index) {
        int tagViewHeight = getResources().getDimensionPixelSize(R.dimen.nad_dimen_12dp);
        int tagLeftMargin = getResources().getDimensionPixelSize(R.dimen.nad_dimen_3dp);
        TextView tagView = new TextView(getContext());
        tagView.setText(text);
        tagView.setIncludeFontPadding(false);
        tagView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.nad_dimen_9dp));
        tagView.setTextColor(ContextCompat.getColor(getContext(), R.color.nad_mini_video_FFFF6600));
        tagView.setGravity(17);
        tagView.setMaxLines(1);
        LinearLayout.LayoutParams tagLayoutParams = new LinearLayout.LayoutParams(-2, tagViewHeight);
        if (index != 0) {
            tagLayoutParams.setMargins(tagLeftMargin, 0, 0, 0);
        }
        tagView.setLayoutParams(tagLayoutParams);
        return tagView;
    }

    private void authorUiAdaptive() {
        if (getTag() instanceof AdBaseModel) {
            AdBaseModel data = (AdBaseModel) getTag();
            if (data.common != null) {
                if (this.mAuthorAvatar.getParent() instanceof View) {
                    ((View) this.mAuthorAvatar.getParent()).setVisibility(0);
                }
                if (!TextUtils.isEmpty(data.common.brandUrl)) {
                    this.mAuthorAvatar.setVisibility(0);
                    this.mAuthorAvatarTxt.setVisibility(8);
                    this.mAuthorAvatar.displayImage(data.common.brandUrl);
                } else if (!TextUtils.isEmpty(data.common.brandName)) {
                    this.mAuthorAvatar.setVisibility(8);
                    this.mAuthorAvatarTxt.setVisibility(0);
                    this.mAuthorAvatarTxt.setText(data.common.brandName);
                } else {
                    this.mAuthorAvatar.setVisibility(8);
                    this.mAuthorAvatarTxt.setVisibility(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public String getNickNameStr(String str, TextPaint textPaint) {
        return ViewUtils.fitTextLabel(str, "", (float) ((int) (((float) ((int) (((float) DeviceUtils.ScreenInfo.getDisplayWidth(getContext())) - getResources().getDimension(R.dimen.nad_dimen_15dp)))) - getResources().getDimension(R.dimen.nad_dimen_11dp))), textPaint);
    }

    public void updateProgress(int progress) {
        IEnhancementBtnView<View> iEnhancementBtnView = this.mTransitionButtonView;
        if (iEnhancementBtnView != null) {
            iEnhancementBtnView.update(progress);
        }
    }

    public void setAlsLogPage(String page) {
        this.mPage = page;
    }

    /* access modifiers changed from: protected */
    public void sendActionAls(ClogBuilder.LogType actionType, String daArea, AdBaseModel data) {
        if (data != null && !TextUtils.isEmpty(data.common.extraParam)) {
            ClogBuilder builder = new ClogBuilder();
            builder.setType(actionType);
            builder.setArea(daArea);
            builder.setPage(this.mPage);
            PlayerProgressHandler playerProgressHandler = this.mPlayerProgressHandler;
            if (playerProgressHandler != null) {
                builder.setExt1(String.valueOf(playerProgressHandler.getPosition()));
                builder.setExt2(String.valueOf(this.mPlayerProgressHandler.getCurrentLoop()));
            }
            builder.setExtraParam(data.common.extraParam);
            Als.send(builder);
        }
    }

    private void optAdTitle(final AdBaseModel data) {
        final boolean finalShowAdTagWithTitle = showAdTagWithTitle(data);
        final String title = data.common.title == null ? "" : data.common.title;
        this.mTitle.post(new Runnable() {
            public void run() {
                ((LinearLayout.LayoutParams) NadVideoAdOverContainer.this.mAuthorName.getLayoutParams()).rightMargin = (int) NadVideoAdOverContainer.this.getResources().getDimension(R.dimen.nad_dimen_8dp);
                NadVideoAdOverContainer.this.mAdAuthorContainer.setBackgroundResource(0);
                NadVideoAdOverContainer.this.mAdAuthorContainer.setPadding(0, 0, 0, 0);
                TextView access$300 = NadVideoAdOverContainer.this.mAuthorName;
                NadVideoAdOverContainer nadVideoAdOverContainer = NadVideoAdOverContainer.this;
                access$300.setText(nadVideoAdOverContainer.getNickNameStr(nadVideoAdOverContainer.getBrandName(data.common.brandName), NadVideoAdOverContainer.this.mAuthorName.getPaint()));
                NadVideoAdOverContainer.this.mAdAuthorContainer.requestLayout();
                NadVideoAdOverContainer.this.mTitle.setText(finalShowAdTagWithTitle ? NadVideoAdOverContainer.this.getNewSpanTitleWithAdTag(title) : title);
            }
        });
    }

    private boolean showAdTagWithTitle(AdBaseModel data) {
        if (!(data instanceof AdRewardVideoLpModel)) {
            return true;
        }
        AdRewardVideoLpModel rewardVideoLpModel = (AdRewardVideoLpModel) data;
        if (rewardVideoLpModel.getTextAdTag() != null) {
            return TextUtils.isEmpty(rewardVideoLpModel.getTextAdTag().getText());
        }
        return true;
    }

    public String getBrandName(String brandName) {
        return String.format("@%s", new Object[]{brandName});
    }

    public void setOverLayInfoVisible(boolean visible) {
        setAdInfoVisible(visible);
    }

    public void updateEnhancementBtn() {
        IEnhancementBtnView<View> iEnhancementBtnView = this.mTransitionButtonView;
        if (iEnhancementBtnView != null) {
            iEnhancementBtnView.updateUI();
        }
    }

    public boolean isInteractionDataVaild(AdBaseModel data) {
        return (data == null || data.adInteractionData == null || data.adInteractionData.praiseData == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public SpannableStringBuilder getNewSpanTitleWithAdTag(String title) {
        if (getResources() == null) {
            return new SpannableStringBuilder(title);
        }
        Drawable tagDrawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_tag_icon);
        float sidePadding = getResources().getDimension(R.dimen.nad_dimen_100dp);
        return WidgetUtilKt.getSpanTitleWithAdTag(title, 2, this.mTitle, getContext(), tagDrawable, (int) sidePadding, getTagHeight(tagDrawable) / ((float) tagDrawable.getIntrinsicHeight()));
    }

    public float getTagHeight(Drawable tagDrawable) {
        return (float) tagDrawable.getIntrinsicHeight();
    }

    public void showNewTailFrame(boolean show) {
        Object tag = getTag();
        if (!(tag instanceof AdBaseModel)) {
            this.mNewTailFrameView.hideTailFrame();
            setAdOverInfoVisiblity(true);
            enableHotAreaClick(true);
        } else if (show) {
            this.mNewTailFrameView.showTailFrame((AdBaseModel) tag);
            setAdOverInfoVisiblity(false);
            enableHotAreaClick(false);
        } else {
            this.mNewTailFrameView.hideTailFrame();
            setAdOverInfoVisiblity(true);
            enableHotAreaClick(true);
        }
    }

    public void destroyAnimation() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages((Object) null);
        }
        IEnhancementBtnView<View> iEnhancementBtnView = this.mTransitionButtonView;
        if (iEnhancementBtnView != null) {
            iEnhancementBtnView.resetAnim();
        }
    }

    private void enableHotAreaClick(boolean enable) {
        this.mHotAreaIsEnable = enable;
        this.mTitle.setClickable(enable);
        this.mAuthorName.setClickable(enable);
        this.mAdInfoView.setClickable(enable);
        IEnhancementBtnView<View> iEnhancementBtnView = this.mTransitionButtonView;
        if (iEnhancementBtnView != null && iEnhancementBtnView.getRealView() != null) {
            this.mTransitionButtonView.getRealView().setClickable(enable);
        }
    }

    public boolean getHotAreaEnabled() {
        return this.mHotAreaIsEnable;
    }

    public boolean isShowingTailFrame() {
        return this.mNewTailFrameView.getVisibility() == 0;
    }

    public void setOnNewTailFrameReplayClickListener(View.OnClickListener listener) {
        this.mNewTailFrameView.setOnReplayClickListener(listener);
    }

    public void setOnUiClickListener(View.OnClickListener listener) {
        this.mUiClickListener = listener;
        PortraitVideoTailView portraitVideoTailView = this.mNewTailFrameView;
        if (portraitVideoTailView != null) {
            portraitVideoTailView.setOnAdClickListener(listener);
        }
        AdEnhanceBtnListener adEnhanceBtnListener = this.mTransitionBtnListener;
        if (adEnhanceBtnListener != null) {
            adEnhanceBtnListener.setOnAdClickListener(listener);
        }
    }

    public void setPlayerProgressHandler(PlayerProgressHandler playerProgressHandler) {
        this.mPlayerProgressHandler = playerProgressHandler;
    }

    public void setAdOverInfoVisiblity(boolean show) {
        if (show) {
            this.mAdInfoLayout.setVisibility(0);
        } else {
            this.mAdInfoLayout.setVisibility(4);
        }
    }

    public void setAdInfoVisible(boolean visible) {
        int i2 = 8;
        if (visible) {
            this.mBottomLine.setVisibility(0);
            if (this.mTransitionButtonView != null) {
                this.mTransitionButtonContainer.setVisibility(0);
            }
            this.mTitle.setVisibility(0);
            this.mAdAuthorContainer.setVisibility(0);
            this.mRecommendTagContainer.setVisibility(0);
            SimpleAdInfoView simpleAdInfoView = this.mAdInfoView;
            if (this.mShouldShowAdInfo) {
                i2 = 0;
            }
            simpleAdInfoView.setVisibility(i2);
            return;
        }
        this.mBottomLine.setVisibility(4);
        if (this.mTransitionButtonView != null) {
            this.mTransitionButtonContainer.setVisibility(4);
        }
        this.mTitle.setVisibility(4);
        this.mAdAuthorContainer.setVisibility(4);
        this.mRecommendTagContainer.setVisibility(4);
        SimpleAdInfoView simpleAdInfoView2 = this.mAdInfoView;
        if (this.mShouldShowAdInfo) {
            i2 = 4;
        }
        simpleAdInfoView2.setVisibility(i2);
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.OnTailJumpHandler onTailJumpHandler) {
        this.mNewTailFrameView.setOnTailJumpHandler(onTailJumpHandler);
    }

    public static boolean canShowAppInfoLayout(AppInfoModel appInfoModel) {
        if (appInfoModel == null) {
            return false;
        }
        if (!TextUtils.isEmpty(appInfoModel.version) || !TextUtils.isEmpty(appInfoModel.devName) || ((appInfoModel.privacy != null && !TextUtils.isEmpty(appInfoModel.privacy.desc)) || (appInfoModel.permission != null && !TextUtils.isEmpty(appInfoModel.permission.desc)))) {
            return true;
        }
        return false;
    }

    static class VerticalImageSpan extends ImageSpan {
        private int mSize;

        public VerticalImageSpan(Drawable drawable) {
            super(drawable);
        }

        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fontMetricsInt) {
            Rect rect = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
                int fontHeight = fmPaint.bottom - fmPaint.top;
                int drHeight = rect.bottom - rect.top;
                int top = (drHeight / 2) - (fontHeight / 4);
                int bottom = (drHeight / 2) + (fontHeight / 4);
                fontMetricsInt.ascent = -bottom;
                fontMetricsInt.top = -bottom;
                fontMetricsInt.bottom = top;
                fontMetricsInt.descent = top;
            }
            int i2 = rect.right;
            this.mSize = i2;
            return i2;
        }

        public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            canvas.translate(x, (float) ((((bottom - top) - drawable.getBounds().bottom) / 2) + top));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public void setFeedbackBtnVisibility(boolean visible) {
        this.mFeedbackBtn.setVisibility(visible ? 0 : 8);
    }

    private void registerDownloadEventBus(AdBaseModel adBaseModel) {
        EventBusWrapper.getDefault().register(this.mDownloadEventObject, 1, new ISubscriber<NadDownloadClickEvent>(NadDownloadClickEvent.class) {
            public void onEvent(NadDownloadClickEvent event) {
                if (NadVideoAdOverContainer.this.mTransitionButtonView != null && NadVideoAdOverContainer.this.mTransitionButtonView.getRealView() != null && (NadVideoAdOverContainer.this.mTransitionButtonView.getRealView() instanceof NadEnhanceButtonDownloadView)) {
                    NadEnhanceButtonDownloadView downloadView = (NadEnhanceButtonDownloadView) NadVideoAdOverContainer.this.mTransitionButtonView.getRealView();
                    if (event.data != null && downloadView.getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                        if (!AdUtil.hitMultiChargeCheckSwitch() || !(NadVideoAdOverContainer.this.mTransitionButtonView instanceof AdEnhanceButtonView)) {
                            downloadView.performClick();
                        } else {
                            ((AdEnhanceButtonView) NadVideoAdOverContainer.this.mTransitionButtonView).performDownloadPresenter();
                        }
                    }
                }
            }
        });
    }

    private void unregisterDownloadEventBus() {
        EventBusWrapper.getDefault().unregister(this.mDownloadEventObject);
    }

    private Boolean checkRewardPanelPop(String scheme) {
        if (!TextUtils.isEmpty(scheme) && SchemeUtility.isValidScheme(scheme)) {
            return Boolean.valueOf("rewardWebPanel".equals(new SchemeModel(scheme).getAction()));
        }
        return false;
    }

    public void setBottomLineHeight(int heightPx) {
        View view2 = this.mBottomLine;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = heightPx;
            this.mBottomLine.setLayoutParams(layoutParams);
        }
    }
}
