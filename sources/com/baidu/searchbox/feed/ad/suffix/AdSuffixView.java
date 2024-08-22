package com.baidu.searchbox.feed.ad.suffix;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ad.IAdHistoryRuntime;
import com.baidu.searchbox.ad.download.IDownloadPresenter;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.download.data.AdDownloadBean;
import com.baidu.searchbox.ad.feed.R;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.model.VideoAdItemModel;
import com.baidu.searchbox.feed.net.ADRequester;
import com.baidu.searchbox.feed.template.appdownload.BaseAdAppDownloadNewPresenter;
import com.baidu.searchbox.player.ad.AdLayer;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;

public abstract class AdSuffixView extends AdBasePasterView implements View.OnClickListener {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final int DEFAULT_DURATION = 15;
    public static final int MAX_TOUCH_OFFSET = 50;
    private static final String TAG = "AdVideoSuffixImageView";
    protected float[] mClickXY = {-1.0f, -1.0f};
    protected TypeEvaluator<GradientDrawable> mDetailButtonEvaluator = new TypeEvaluator<GradientDrawable>() {
        public GradientDrawable evaluate(float fraction, GradientDrawable startValue, GradientDrawable endValue) {
            GradientDrawable gradientDrawable = startValue;
            int startInt = AdSuffixView.this.mDetailButtonStartArgb;
            float startA = ((float) ((startInt >> 24) & 255)) / 255.0f;
            float startR = ((float) ((startInt >> 16) & 255)) / 255.0f;
            int endInt = AdSuffixView.this.getResources().getColor(R.color.video_suffix_download_bg);
            float endA = ((float) ((endInt >> 24) & 255)) / 255.0f;
            float f2 = startR;
            float startR2 = (float) Math.pow((double) startR, 2.2d);
            float startG = (float) Math.pow((double) (((float) ((startInt >> 8) & 255)) / 255.0f), 2.2d);
            float startB = (float) Math.pow((double) (((float) (startInt & 255)) / 255.0f), 2.2d);
            float endR = (float) Math.pow((double) (((float) ((endInt >> 16) & 255)) / 255.0f), 2.2d);
            float endG = (float) Math.pow((double) (((float) ((endInt >> 8) & 255)) / 255.0f), 2.2d);
            float endB = (float) Math.pow((double) (((float) (endInt & 255)) / 255.0f), 2.2d);
            int i2 = startInt;
            float f3 = startA;
            float f4 = startG;
            float f5 = startB;
            float r = endB;
            int i3 = endInt;
            float f6 = endA;
            AdSuffixView.this.mDetailButtonStartArgb = (Math.round((((endA - startA) * fraction) + startA) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (((endR - startR2) * fraction) + startR2), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(((float) Math.pow((double) (((endG - startG) * fraction) + startG), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow((double) (((endB - startB) * fraction) + startB), 0.45454545454545453d)) * 255.0f);
            startValue.mutate();
            gradientDrawable.setColor(AdSuffixView.this.mDetailButtonStartArgb);
            return gradientDrawable;
        }
    };
    protected int mDetailButtonStartArgb = 1711276032;
    protected SuffixCircularDownloadButon mDownloadButton;
    protected SuffixCircularDownloadPresenter mDownloadPresenter;
    protected View mNewVideoAdDetail;
    protected SimpleDraweeView mNewVideoDetailImg;
    protected SuffixDetailTextView mNewVideoDetailTxt;
    protected View mNewViewADDetailArea;
    protected TextView mVideoADCloseTxt;
    protected View mVideoADDetail;
    protected TextView mVideoDetailTxt;

    public AdSuffixView(Context context, AdLayer adLayer, boolean isHalf) {
        super(context, adLayer, isHalf);
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        if (this.mAdItemModel != null) {
            if (!TextUtils.isEmpty(this.mAdItemModel.closeText)) {
                this.mVideoADCloseTxt.setText(this.mAdItemModel.closeText);
            } else {
                this.mVideoADCloseTxt.setText(com.baidu.searchbox.videoplayer.business.R.string.video_suffix_ad_close);
            }
            if (this.mAdItemModel.button == null || TextUtils.isEmpty(this.mAdItemModel.button.text)) {
                String defaultText = getResources().getString(com.baidu.searchbox.videoplayer.business.R.string.video_suffix_ad_detail);
                this.mVideoDetailTxt.setText(defaultText);
                this.mNewVideoDetailTxt.setDetailText(defaultText);
            } else {
                this.mVideoDetailTxt.setText(this.mAdItemModel.button.text);
                this.mNewVideoDetailTxt.setDetailText(this.mAdItemModel.button.text);
            }
            this.mDurationTime = this.mAdItemModel.duration > 0 ? this.mAdItemModel.duration : 15;
            this.mVideoADTimer.setText(String.format("%ds", new Object[]{Integer.valueOf(this.mDurationTime)}));
            initDownloadPresenter();
            if (this.mAdItemModel.mAdSwitch == null) {
                return;
            }
            if (this.mAdItemModel.mAdSwitch.isNewButton()) {
                this.mVideoADDetail.setVisibility(8);
                this.mNewVideoAdDetail.setVisibility(0);
                this.mNewVideoDetailTxt.setVisibility(4);
                loadNewDetailIcon(this.mAdItemModel.isUseAdDownload());
                startNewDetailButtonAnim();
                return;
            }
            this.mVideoADDetail.setVisibility(0);
            this.mNewVideoAdDetail.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void initDownloadPresenter() {
        if (this.mAdItemModel.canDownload()) {
            AdDownloadBean downloadBean = AdDownloadBean.create(this.mAdItemModel.adDownload, this.mAdItemModel.daPage.value, this.mAdItemModel.ext);
            SuffixCircularDownloadPresenter suffixCircularDownloadPresenter = this.mDownloadPresenter;
            if (suffixCircularDownloadPresenter != null) {
                suffixCircularDownloadPresenter.unregisterAppStatusListener();
                this.mDownloadPresenter.unregisterDownloadListener();
            }
            SuffixCircularDownloadPresenter suffixCircularDownloadPresenter2 = new SuffixCircularDownloadPresenter(this.mDownloadButton, new AlsSender(this), new DownloadListener(this), downloadBean);
            this.mDownloadPresenter = suffixCircularDownloadPresenter2;
            suffixCircularDownloadPresenter2.setShowStartDownloadToast(true);
        }
    }

    private void loadNewDetailIcon(boolean isDownload) {
        if (isDownload) {
            ((GenericDraweeHierarchy) this.mNewVideoDetailImg.getHierarchy()).setPlaceholderImage(R.drawable.suffix_download_begin);
        } else {
            ((GenericDraweeHierarchy) this.mNewVideoDetailImg.getHierarchy()).setPlaceholderImage(R.drawable.video_ad_icon_detail_new);
        }
        if (this.mAdItemModel.button != null) {
            this.mNewVideoDetailImg.setImageURI(this.mAdItemModel.button.icon);
        }
    }

    private void startNewDetailButtonAnim() {
        final ViewTreeObserver vot = this.mNewVideoDetailTxt.getViewTreeObserver();
        vot.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver = vot;
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    vot.removeOnGlobalLayoutListener(this);
                }
                int detailFullWidth = AdSuffixView.this.mNewVideoDetailTxt.getWidth();
                final int detailIconWidth = DeviceUtil.ScreenInfo.dp2px(AdSuffixView.this.getContext(), 24.0f);
                final ViewGroup.LayoutParams detailParams = AdSuffixView.this.mNewVideoDetailTxt.getLayoutParams();
                if (detailParams != null) {
                    detailParams.width = detailIconWidth;
                    AdSuffixView.this.mNewVideoDetailTxt.setLayoutParams(detailParams);
                }
                ViewGroup.LayoutParams layoutParams = AdSuffixView.this.mNewVideoAdDetail.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = detailFullWidth;
                    AdSuffixView.this.mNewVideoAdDetail.setLayoutParams(layoutParams);
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, ((float) detailFullWidth) / ((float) detailIconWidth)});
                ofFloat.setTarget(AdSuffixView.this.mNewVideoDetailTxt);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float scale = ((Float) animation.getAnimatedValue()).floatValue();
                        ViewGroup.LayoutParams layoutParams = detailParams;
                        if (layoutParams != null) {
                            layoutParams.width = (int) (((float) detailIconWidth) * scale);
                            AdSuffixView.this.mNewVideoDetailTxt.setLayoutParams(detailParams);
                            if (!AdSuffixView.this.mNewVideoDetailTxt.isShown()) {
                                AdSuffixView.this.mNewVideoDetailTxt.setVisibility(0);
                            }
                        }
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() {
                    public void onAnimationStart(Animator animation) {
                    }

                    public void onAnimationEnd(Animator animation) {
                        if (AdSuffixView.this.mAdItemModel.canDownload()) {
                            AdSuffixView.this.mNewViewADDetailArea.setVisibility(8);
                            AdSuffixView.this.mDownloadButton.setVisibility(0);
                        }
                    }

                    public void onAnimationCancel(Animator animation) {
                    }

                    public void onAnimationRepeat(Animator animation) {
                    }
                });
                ofFloat.setDuration((long) 700);
                ofFloat.start();
                Drawable drawable = AdSuffixView.this.getResources().getDrawable(R.drawable.bg_ad_suffox_detail_button_start);
                Animator textBgAnim = ObjectAnimator.ofObject(AdSuffixView.this.mNewVideoDetailTxt, "background", AdSuffixView.this.mDetailButtonEvaluator, new Object[]{drawable});
                textBgAnim.setDuration((long) 700);
                textBgAnim.start();
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendActionAls(String actionType, Als.Page pageType, String daArea, VideoAdItemModel data) {
        if (data != null && data.ext != null) {
            Als.Builder builder = new Als.Builder();
            builder.setType(actionType);
            builder.setPage(pageType);
            builder.setArea(daArea);
            builder.setExtraParam(data.ext);
            builder.setExt1(DeviceUtil.ScreenInfo.isScreenPortrait() ? "0" : "1");
            builder.setExt2(String.valueOf(this.mHasPlayTime));
            Als.postADRealTimeLog(builder);
        } else if (DEBUG) {
            throw new NullPointerException("model is null!");
        }
    }

    protected class SuffixOnTouchListener implements View.OnTouchListener {
        private float x1 = 0.0f;
        private float x2 = 0.0f;
        private float y1 = 0.0f;
        private float y2 = 0.0f;

        protected SuffixOnTouchListener() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (onExpandInterceptedEvent(event)) {
                return false;
            }
            if (event.getAction() == 0) {
                this.x1 = event.getRawX();
                this.y1 = event.getRawY();
            }
            if (!(AdSuffixView.this.mAdItemModel == null || AdSuffixView.this.mAdItemModel.mAdSwitch == null || AdSuffixView.this.mAdItemModel.mAdSwitch.clicNoRespRatio <= 0)) {
                float noRespRatio = AdSuffixView.this.mAdItemModel.mAdSwitch.getClickNoRespRatio();
                int screenWidth = DeviceUtil.ScreenInfo.getDisplayWidth(AdSuffixView.this.getContext());
                int width = Math.min(screenWidth, DeviceUtil.ScreenInfo.getDisplayHeight(AdSuffixView.this.getContext()));
                float f2 = this.x1;
                if (f2 < ((float) width) * noRespRatio || f2 > ((float) screenWidth) - (((float) width) * noRespRatio)) {
                    return false;
                }
            }
            if (event.getAction() == 1) {
                this.x2 = event.getRawX();
                this.y2 = event.getRawY();
                if (Math.abs(this.x1 - this.x2) < 50.0f && Math.abs(this.y1 - this.y2) < 50.0f) {
                    AdSuffixView.this.mClickXY[0] = this.x1;
                    AdSuffixView.this.mClickXY[1] = this.y1;
                    AdSuffixView.this.onClick(v);
                }
            }
            return true;
        }

        private boolean onExpandInterceptedEvent(MotionEvent event) {
            if (AdSuffixView.this.getTouchDelegate() == null || !AdSuffixView.this.getTouchDelegate().onTouchEvent(event)) {
                return false;
            }
            return true;
        }
    }

    private static class AlsSender implements IDownloadPresenter.IAlsSender {
        private WeakReference<AdSuffixView> mReference;

        AlsSender(AdSuffixView holder) {
            this.mReference = new WeakReference<>(holder);
        }

        public void sendALS(String actionType, String daArea, AdDownload download) {
            AdSuffixView suffixView = (AdSuffixView) this.mReference.get();
            if (suffixView != null) {
                if (download == null) {
                    if (AdSuffixView.DEBUG) {
                        throw new NullPointerException("model is null!");
                    }
                } else if (suffixView.mAdItemModel != null && download == suffixView.mAdItemModel.adDownload) {
                    suffixView.sendActionAls(actionType, suffixView.mAdItemModel.daPage, daArea, suffixView.mAdItemModel);
                }
            }
        }
    }

    private static class DownloadListener extends BaseAdAppDownloadNewPresenter.SimpleAdDownloadListener {
        private WeakReference<AdSuffixView> mReference;

        public DownloadListener(AdSuffixView holder) {
            this.mReference = new WeakReference<>(holder);
        }

        public void onClicked(AdDownload download) {
            AdSuffixView suffixView = (AdSuffixView) this.mReference.get();
            if (suffixView != null && suffixView.mAdItemModel != null) {
                if (download == suffixView.mAdItemModel.adDownload) {
                    IAdHistoryRuntime.Impl.get().addAdHistory((Object) suffixView.mAdItemModel);
                    ADRequester.adThirdPartyMonitor(suffixView.mAdItemModel.extData, Als.ADActionType.CLICK);
                } else if (AdSuffixView.DEBUG) {
                    throw new IllegalArgumentException("download model is not the same!");
                }
            }
        }
    }
}
