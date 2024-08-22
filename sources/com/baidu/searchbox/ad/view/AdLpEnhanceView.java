package com.baidu.searchbox.ad.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.model.AdDownloadBean;
import com.baidu.nadcore.download.presenter.IAdDownloadView;
import com.baidu.searchbox.ad.AdParamsCache;
import com.baidu.searchbox.ad.download.IDownloadView;
import com.baidu.searchbox.ad.download.data.AdDownloadExtra;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.R;
import com.baidu.searchbox.feed.ad.model.AppInfoModel;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.facebook.drawee.view.SimpleDraweeView;

public class AdLpEnhanceView extends RelativeLayout implements View.OnClickListener, IAdDownloadView<AdLpEnhanceView>, IDownloadView<AdLpEnhanceView> {
    private static final long CARD_ANIMATE_TIME = 500;
    private static final long CARD_HOLDING_TIME = 5000;
    private static final long CARD_POP_TIME = 1000;
    private static final long CARD_WAITING_TIME = 3000;
    public static final String PROCESS_WITHOUT_ANIMATOR = "process_without_animator";
    public static final String PROCESS_WITH_ANIMATOR = "process_with_animator";
    public static final String VIEW_TYPE_BIG = "big_card";
    public static final String VIEW_TYPE_SMALL = "small_card";
    private AdDownloadBean mAdDownloadBean;
    private String mAdId;
    /* access modifiers changed from: private */
    public TextView mAppDesView;
    private SimpleDraweeView mAppIconView;
    private AppInfoModel mAppInfoModel;
    private TextView mAppTitleView;
    private ImageView mCloseBtn;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public View mDownloadBtn;
    private IDownloadView<View> mDownloadView;
    /* access modifiers changed from: private */
    public RelativeLayout mInnerContainer;
    private boolean mMaxpage;
    private FrameLayout mOuterContainer;
    private RelativeLayout mParentContainer;
    private SimpleAdInfoView mSimpleAdInfoView;
    /* access modifiers changed from: private */
    public String mStatus;

    public AdLpEnhanceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AdLpEnhanceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdLpEnhanceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAdId = "";
        this.mMaxpage = false;
        this.mContext = context;
    }

    public void setInfo(String adId, boolean maxPage, AppInfoModel appInfoModel) {
        this.mAdId = adId;
        this.mMaxpage = maxPage;
        this.mAppInfoModel = appInfoModel;
    }

    public void bind(ViewGroup viewGroup) {
    }

    public void update(String text, AdDownloadBean adDownloadBean) {
        if (adDownloadBean.status == AdDownloadStatus.DOWNLOADING) {
            if (TextUtils.equals("big_card", getStatus())) {
                text = String.format(this.mContext.getResources().getString(R.string.button_downloading), new Object[]{((int) (adDownloadBean.progress * 100.0f)) + "%"});
            } else {
                text = ((int) (adDownloadBean.progress * 100.0f)) + "%";
            }
        }
        this.mDownloadView.setText(text);
        this.mDownloadView.setProgress((int) (adDownloadBean.progress * 100.0f));
        this.mDownloadView.getRealView().postInvalidate();
    }

    public void updateView(String processtype, final RelativeLayout container, final IDownloadView<View> downloadView, AdDownloadBean adDownloadBean) {
        String area;
        init(adDownloadBean, container);
        this.mDownloadView = downloadView;
        downloadView.setMax(100);
        this.mAdDownloadBean = adDownloadBean;
        if (TextUtils.equals(PROCESS_WITH_ANIMATOR, processtype)) {
            this.mStatus = VIEW_TYPE_SMALL;
            area = Als.Area.LP_ENHANCE_SMALL.value;
            container.setTag(downloadView);
            container.postDelayed(new Runnable() {
                public void run() {
                    Object tag = container.getTag();
                    IDownloadView iDownloadView = downloadView;
                    if (tag == iDownloadView) {
                        AdLpEnhanceView.this.initDownloadBtnStyle((View) iDownloadView);
                        AdLpEnhanceView.this.showCardAnimation();
                    }
                }
            }, 3000);
        } else {
            container.setTag((Object) null);
            this.mStatus = "big_card";
            area = Als.Area.LP_ENHANCE_BIG.value;
            initDownloadBtnStyle((View) downloadView);
        }
        reportAls(Als.LogType.FREE_SHOW.type, area);
    }

    private void init(AdDownloadBean adDownloadBean, RelativeLayout parentContainer) {
        this.mParentContainer = parentContainer;
        LayoutInflater.from(this.mContext).inflate(R.layout.ad_lp_enhance_layout, this);
        this.mAppIconView = (SimpleDraweeView) findViewById(R.id.ad_lp_enhance_icon);
        this.mAppTitleView = (TextView) findViewById(R.id.ad_lp_enhance_title);
        this.mAppDesView = (TextView) findViewById(R.id.ad_lp_enhance_description);
        this.mSimpleAdInfoView = (SimpleAdInfoView) findViewById(R.id.ad_app_info_layout);
        this.mCloseBtn = (ImageView) findViewById(R.id.ad_lp_enhance_close_btn);
        this.mOuterContainer = (FrameLayout) findViewById(R.id.ad_lp_enhance_outerContainer);
        this.mInnerContainer = (RelativeLayout) findViewById(R.id.ad_lp_enhance_innerContainer);
        this.mAppIconView.setImageURI(adDownloadBean.mt.appIconUrl);
        this.mAppTitleView.setText(adDownloadBean.mt.appName);
        this.mAppDesView.setText(AdParamsCache.Companion.getInstance().getParam(this.mAdId, "title"));
        this.mOuterContainer.setBackgroundDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.ad_lp_enhance_view_bg));
        this.mAppDesView.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.ad_lp_enhance_desc_color));
        this.mAppTitleView.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.ad_lp_enhance_title_color));
        this.mCloseBtn.setOnClickListener(this);
        this.mSimpleAdInfoView.setAdInfo(this.mAppInfoModel);
    }

    /* access modifiers changed from: private */
    public void initDownloadBtnStyle(View realDownloadView) {
        if (TextUtils.equals("big_card", this.mStatus)) {
            FrameLayout.LayoutParams btnLp = new FrameLayout.LayoutParams(-1, -2);
            btnLp.gravity = 81;
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.dimens_17dp);
            btnLp.rightMargin = dimensionPixelOffset;
            btnLp.leftMargin = dimensionPixelOffset;
            btnLp.bottomMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 30.0f);
            btnLp.height = this.mContext.getResources().getDimensionPixelOffset(R.dimen.dimens_38dp);
            realDownloadView.setLayoutParams(btnLp);
            realDownloadView.setVisibility(0);
        } else {
            changeCommonView2SmallStyle();
            FrameLayout.LayoutParams btnLp2 = new FrameLayout.LayoutParams(-1, -2);
            btnLp2.gravity = 85;
            btnLp2.width = DeviceUtil.ScreenInfo.dp2px(this.mContext, 72.0f);
            btnLp2.height = DeviceUtil.ScreenInfo.dp2px(this.mContext, 28.0f);
            btnLp2.rightMargin = (int) this.mContext.getResources().getDimension(R.dimen.dimens_17dp);
            btnLp2.bottomMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 30.0f);
            realDownloadView.setLayoutParams(btnLp2);
            realDownloadView.setVisibility(0);
        }
        this.mDownloadBtn = realDownloadView;
        this.mOuterContainer.addView(realDownloadView);
        ViewParent vp = getParent();
        if (vp instanceof ViewGroup) {
            ((ViewGroup) vp).removeView(this);
        }
        this.mParentContainer.addView(this);
        if (!this.mMaxpage) {
            this.mParentContainer.setVisibility(0);
        }
    }

    private void changeCommonView2SmallStyle() {
        this.mStatus = VIEW_TYPE_SMALL;
        this.mInnerContainer.getLayoutParams().height = DeviceUtil.ScreenInfo.dp2px(this.mContext, 97.0f);
        RelativeLayout.LayoutParams descLp = (RelativeLayout.LayoutParams) this.mAppDesView.getLayoutParams();
        descLp.width = -1;
        descLp.height = DeviceUtil.ScreenInfo.dp2px(this.mContext, 22.0f);
        descLp.addRule(5, R.id.ad_lp_enhance_title);
        descLp.addRule(3, R.id.ad_lp_enhance_title);
        descLp.topMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 4.0f);
        descLp.rightMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 95.0f);
        this.mAppDesView.setMaxLines(1);
        this.mAppDesView.setLayoutParams(descLp);
    }

    public ViewGroup getContainer() {
        return this.mOuterContainer;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void showCardAnimation() {
        if (this.mDownloadBtn != null) {
            int[] location = new int[2];
            this.mParentContainer.getLocationOnScreen(location);
            ObjectAnimator transYAnimator = ObjectAnimator.ofFloat(this.mParentContainer, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{(float) location[1], 0.0f});
            ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(this.mParentContainer, "alpha", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{transYAnimator, alphaAnimator});
            animatorSet.setDuration(1000);
            animatorSet.start();
            animatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animation) {
                }

                public void onAnimationEnd(Animator animation) {
                    AdLpEnhanceView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (TextUtils.equals(AdLpEnhanceView.VIEW_TYPE_SMALL, AdLpEnhanceView.this.mStatus)) {
                                AdLpEnhanceView.this.transferAnimatation(AdLpEnhanceView.this.mDownloadBtn, 160, 292, 38, 13);
                            } else {
                                AdLpEnhanceView.this.transferAnimatation(AdLpEnhanceView.this.mDownloadBtn, 97, 72, 28, 95);
                            }
                        }
                    }, 5000);
                }

                public void onAnimationCancel(Animator animation) {
                }

                public void onAnimationRepeat(Animator animation) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void transferAnimatation(View realDownloadView, int targetContainerHeight, int targetBtnWidth, int targetBtnHeight, int targetDescRightMargin) {
        String str = TextUtils.equals("big_card", this.mStatus) ? VIEW_TYPE_SMALL : "big_card";
        this.mStatus = str;
        String area = (TextUtils.equals("big_card", str) ? Als.Area.LP_ENHANCE_BIG : Als.Area.LP_ENHANCE_SMALL).value;
        int maxLine = TextUtils.equals("big_card", this.mStatus) ? 2 : 1;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[]{1, 100}).setDuration(500);
        valueAnimator.start();
        reportAls(Als.LogType.FREE_SHOW.type, area);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(realDownloadView, targetContainerHeight, targetBtnWidth, targetBtnHeight, targetDescRightMargin, maxLine) {
            private IntEvaluator mIntEvaluator = new IntEvaluator();
            int oldBtnHeight;
            int oldBtnWidth;
            int oldDescHeight;
            int oldDescRightMargin;
            int oldHeight;
            final /* synthetic */ int val$maxLine;
            final /* synthetic */ View val$realDownloadView;
            final /* synthetic */ int val$targetBtnHeight;
            final /* synthetic */ int val$targetBtnWidth;
            final /* synthetic */ int val$targetContainerHeight;
            final /* synthetic */ int val$targetDescRightMargin;

            {
                this.val$realDownloadView = r2;
                this.val$targetContainerHeight = r3;
                this.val$targetBtnWidth = r4;
                this.val$targetBtnHeight = r5;
                this.val$targetDescRightMargin = r6;
                this.val$maxLine = r7;
                this.oldHeight = AdLpEnhanceView.this.mInnerContainer.getHeight();
                this.oldBtnWidth = r2.getWidth();
                this.oldBtnHeight = r2.getHeight();
                this.oldDescRightMargin = ((RelativeLayout.LayoutParams) AdLpEnhanceView.this.mAppDesView.getLayoutParams()).rightMargin;
                this.oldDescHeight = AdLpEnhanceView.this.mAppDesView.getHeight();
            }

            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                AdLpEnhanceView.this.mInnerContainer.getLayoutParams().height = this.mIntEvaluator.evaluate(fraction, Integer.valueOf(this.oldHeight), Integer.valueOf(DeviceUtil.ScreenInfo.dp2px(AdLpEnhanceView.this.mContext, (float) this.val$targetContainerHeight))).intValue();
                FrameLayout.LayoutParams btnLp = (FrameLayout.LayoutParams) this.val$realDownloadView.getLayoutParams();
                btnLp.gravity = 85;
                btnLp.width = this.mIntEvaluator.evaluate(fraction, Integer.valueOf(this.oldBtnWidth), Integer.valueOf(DeviceUtil.ScreenInfo.dp2px(AdLpEnhanceView.this.mContext, (float) this.val$targetBtnWidth))).intValue();
                btnLp.height = this.mIntEvaluator.evaluate(fraction, Integer.valueOf(this.oldBtnHeight), Integer.valueOf(DeviceUtil.ScreenInfo.dp2px(AdLpEnhanceView.this.mContext, (float) this.val$targetBtnHeight))).intValue();
                btnLp.bottomMargin = DeviceUtil.ScreenInfo.dp2px(AdLpEnhanceView.this.mContext, 30.0f);
                this.val$realDownloadView.setLayoutParams(btnLp);
                RelativeLayout.LayoutParams descLp = (RelativeLayout.LayoutParams) AdLpEnhanceView.this.mAppDesView.getLayoutParams();
                descLp.rightMargin = this.mIntEvaluator.evaluate(fraction, Integer.valueOf(this.oldDescRightMargin), Integer.valueOf(DeviceUtil.ScreenInfo.dp2px(AdLpEnhanceView.this.mContext, (float) this.val$targetDescRightMargin))).intValue();
                descLp.height = this.mIntEvaluator.evaluate(fraction, Integer.valueOf(this.oldDescHeight), Integer.valueOf(DeviceUtil.ScreenInfo.dp2px(AdLpEnhanceView.this.mContext, (float) (this.oldDescHeight * 2)))).intValue();
                descLp.addRule(3, R.id.ad_lp_enhance_title);
                descLp.topMargin = DeviceUtil.ScreenInfo.dp2px(AdLpEnhanceView.this.mContext, 4.0f);
                AdLpEnhanceView.this.mAppDesView.setMaxLines(this.val$maxLine);
                AdLpEnhanceView.this.mAppDesView.setLayoutParams(descLp);
            }
        });
    }

    public void onClick(View v) {
        if (this.mParentContainer != null) {
            int id = v.getId();
            String area = null;
            String type = Als.LogType.NAVIDEO_POP_CLOSE.type;
            if (id == R.id.ad_lp_enhance_close_btn) {
                this.mParentContainer.removeAllViews();
                area = Als.Area.LP_ENHANCE_CLOSE.value;
            }
            reportAls(type, area);
        }
    }

    public void reportAls(String type, String daArea) {
        Als.Builder builder = new Als.Builder();
        builder.setPage(Als.Page.LP_ENHANCE_VIEW);
        builder.setType(type);
        builder.setArea(daArea);
        builder.setExtraParam(this.mAdDownloadBean.mt.alsExt);
        if (this.mAdDownloadBean.status != null) {
            builder.setExt1(this.mAdDownloadBean.status.name());
        }
        Als.postADRealTimeLog(builder);
    }

    public void onNightModeChanged(boolean isNightMode) {
        FrameLayout frameLayout = this.mOuterContainer;
        if (frameLayout != null && this.mAppTitleView != null && this.mAppDesView != null) {
            frameLayout.setBackgroundDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.ad_lp_enhance_view_bg));
            this.mAppDesView.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.ad_lp_enhance_desc_color));
            this.mAppTitleView.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.ad_lp_enhance_title_color));
        }
    }

    public AdLpEnhanceView getRealView() {
        return this;
    }

    public void setViewTag(Object tag) {
        setTag(tag);
    }

    public Object getViewTag() {
        return getTag();
    }

    public void setProgress(int progress) {
        String tmp;
        if (progress >= this.mDownloadView.getMax()) {
            tmp = this.mContext.getResources().getString(R.string.button_install);
        } else if (TextUtils.equals("big_card", getStatus())) {
            tmp = String.format(this.mContext.getResources().getString(R.string.button_downloading), new Object[]{progress + "%"});
        } else {
            tmp = progress + "%";
        }
        this.mDownloadView.setText(tmp);
        this.mDownloadView.setProgress(progress);
        this.mDownloadView.getRealView().postInvalidate();
    }

    public void setMax(int max) {
    }

    public void onAppStateChange(AdDownloadExtra.STATUS state) {
    }

    public void setText(String text) {
        this.mDownloadView.setText(text);
        this.mDownloadView.getRealView().postInvalidate();
    }

    public int getMax() {
        return 100;
    }
}
