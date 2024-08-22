package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.feed.availability.image.FeedDraweeCallerContext;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.log.OnLineLogs;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.tab.view.FeedThinDividerPolicy;
import com.baidu.searchbox.feed.template.cny.CNYResManager;
import com.baidu.searchbox.feed.template.util.FontSizeExpUtil;
import com.baidu.searchbox.feed.template.utils.FeedOrderSenseUtil;
import com.baidu.searchbox.feed.template.utils.FeedTemplateImgCornersUtil;
import com.baidu.searchbox.feed.widget.operationfloat.taskfloat.listener.VideoAfxListener;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import java.util.Map;

public class FeedCNYStyleTwoView extends NewsFeedBaseView {
    private static final float VIDEO_RATIO = 1.7777778f;
    private FrameLayout mContentLayout;
    private AlphaVideo mContentVideo;
    private RelativeLayout.LayoutParams mEffectLp;
    private AlphaVideo mEffectVideo;
    private RelativeLayout.LayoutParams mFakeUnlikeLp;
    private ImageView mFakeUnlikeView;
    private FeedDraweeView mImage;
    private boolean mIsFirst;

    public FeedCNYStyleTwoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FeedCNYStyleTwoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedCNYStyleTwoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIsFirst = true;
    }

    /* access modifiers changed from: protected */
    public View initInflate(LayoutInflater inflater) {
        return inflater.inflate(R.layout.feed_tpl_cny_view, this);
    }

    /* access modifiers changed from: protected */
    public void initLayout(Context context) {
        this.mContentLayout = (FrameLayout) findViewById(R.id.feed_cny_content_area);
        this.mContentVideo = (AlphaVideo) findViewById(R.id.feed_caishen_afx);
        FeedDraweeView feedDraweeView = (FeedDraweeView) findViewById(R.id.feed_template_big_image_id);
        this.mImage = feedDraweeView;
        FeedTemplateImgCornersUtil.processSingleImgSmallCorners(feedDraweeView);
        int contentWidth = FeedTemplateUtil.getCalculateWidth(context) - (getEdgeBlankWidth() * 2);
        RelativeLayout.LayoutParams contentLp = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
        contentLp.width = contentWidth;
        contentLp.height = (int) (((float) contentWidth) / 1.7777778f);
        this.mContentLayout.setLayoutParams(contentLp);
        float f2 = 0.5f;
        this.mContentVideo.setDarkFilter(NightModeHelper.isNightMode() ? 0.5f : 0.0f);
        this.mContentVideo.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mContentVideo.setClipToOutline(true);
            this.mContentVideo.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view2, Outline outline) {
                    Rect rect = new Rect(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight());
                    if (outline != null) {
                        outline.setRoundRect(rect, (float) DeviceUtils.ScreenInfo.dp2px(FeedCNYStyleTwoView.this.getContext(), 8.0f));
                    }
                }
            });
        }
        AlphaVideo alphaVideo = new AlphaVideo(getContext());
        this.mEffectVideo = alphaVideo;
        if (!NightModeHelper.isNightMode()) {
            f2 = 0.0f;
        }
        alphaVideo.setDarkFilter(f2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.mEffectLp = layoutParams;
        addView(this.mEffectVideo, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.mFakeUnlikeView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mFakeUnlikeView.setId(R.id.feed_template_base_delete_id);
        this.mFakeUnlikeLp = new RelativeLayout.LayoutParams(-2, -2);
        this.mFakeUnlikeView.setOnClickListener(this);
        addView(this.mFakeUnlikeView, this.mFakeUnlikeLp);
        this.mContentVideo.setOnVideoErrorListener(new VideoAfxListener() {
            public boolean onError(ErrorInfo errorInfo) {
                UiThreadUtils.runOnUiThread(new FeedCNYStyleTwoView$2$$ExternalSyntheticLambda0(this));
                return true;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$onError$0$com-baidu-searchbox-feed-template-FeedCNYStyleTwoView$2  reason: not valid java name */
            public /* synthetic */ void m19439lambda$onError$0$combaidusearchboxfeedtemplateFeedCNYStyleTwoView$2() {
                OnLineLogs.getCNYLogger().d("CNY Second contentVideo onError");
                FeedCNYStyleTwoView.this.onVideoError();
            }
        });
        this.mEffectVideo.setOnVideoErrorListener(new VideoAfxListener() {
            public boolean onError(ErrorInfo errorInfo) {
                UiThreadUtils.runOnUiThread(new FeedCNYStyleTwoView$3$$ExternalSyntheticLambda0(this));
                return super.onError(errorInfo);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$onError$0$com-baidu-searchbox-feed-template-FeedCNYStyleTwoView$3  reason: not valid java name */
            public /* synthetic */ void m19440lambda$onError$0$combaidusearchboxfeedtemplateFeedCNYStyleTwoView$3() {
                OnLineLogs.getCNYLogger().d("CNY Second effectVideo onError");
                FeedCNYStyleTwoView.this.onVideoError();
            }
        });
    }

    /* access modifiers changed from: private */
    public void onVideoError() {
        AlphaVideo alphaVideo = this.mContentVideo;
        if (alphaVideo != null && this.mEffectVideo != null && this.mImage != null) {
            alphaVideo.setVisibility(8);
            this.mEffectVideo.setVisibility(8);
            this.mImage.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void updateSubViewData(FeedBaseModel model) {
        if (this.mIsFirst && CNYResManager.Companion.getInstance().existFeedTwoStyleRes()) {
            this.mContentVideo.setSourcePath(CNYResManager.Companion.getInstance().getVideoPathByName(CNYResManager.Companion.getAFX_STYLE_TWO_CONTENT()));
            this.mEffectVideo.setSourcePath(CNYResManager.Companion.getInstance().getVideoPathByName(CNYResManager.Companion.getAFX_STYLE_TWO_EFFECT()));
            this.mContentVideo.setLooping(false);
            this.mEffectVideo.setLooping(false);
            this.mContentVideo.setKeepLastFrame(true);
            this.mEffectVideo.setKeepLastFrame(true);
        }
    }

    /* access modifiers changed from: protected */
    public void updateSubViewUi(FeedBaseModel model) {
        if (model != null && (model.data instanceof FeedItemDataNews)) {
            FeedItemDataNews itemData = (FeedItemDataNews) model.data;
            if (itemData.images != null && itemData.images.size() > 0) {
                String url = itemData.images.get(0).image;
                if (TextUtils.isEmpty(url)) {
                    this.mImage.setImageURI(Uri.parse("res://" + getContext().getPackageName() + "/" + R.drawable.feed_cny_bg));
                    return;
                }
                this.mImage.setPlaceHolderWithSelfFlag().loadImage(url, model, FeedDraweeCallerContext.getTemplateCallerContext(model));
            }
        }
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        applyTitleFontSize(FontSizeExpUtil.getCoreTplViewTitleFontSize(feedModel));
        super.update(feedModel, options);
        FeedOrderSenseUtil.setDislikePicture(this.mFakeUnlikeView, 2, feedModel);
        if (this.mFeedTemplateImplBase.mFeedLabelView.getUnlikeButton() != null) {
            this.mFeedTemplateImplBase.mFeedLabelView.getUnlikeButton().setVisibility(8);
        }
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        super.onFeedNightModeChanged(isNightMode);
        AlphaVideo alphaVideo = this.mEffectVideo;
        float f2 = 0.5f;
        if (alphaVideo != null) {
            alphaVideo.setDarkFilter(NightModeHelper.isNightMode() ? 0.5f : 0.0f);
        }
        AlphaVideo alphaVideo2 = this.mContentVideo;
        if (alphaVideo2 != null) {
            if (!NightModeHelper.isNightMode()) {
                f2 = 0.0f;
            }
            alphaVideo2.setDarkFilter(f2);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new FeedCNYStyleTwoView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onAttachedToWindow$0$com-baidu-searchbox-feed-template-FeedCNYStyleTwoView  reason: not valid java name */
    public /* synthetic */ void m19438lambda$onAttachedToWindow$0$combaidusearchboxfeedtemplateFeedCNYStyleTwoView() {
        if (this.mIsFirst) {
            adjustEffectVideoLayout();
            this.mIsFirst = false;
        }
        AlphaVideo alphaVideo = this.mContentVideo;
        if (alphaVideo != null) {
            alphaVideo.play();
        }
        AlphaVideo alphaVideo2 = this.mEffectVideo;
        if (alphaVideo2 != null) {
            alphaVideo2.play();
        }
    }

    /* access modifiers changed from: private */
    public void adjustEffectVideoLayout() {
        int labelHeight;
        if (this.mFeedTemplateImplBase == null || this.mFeedTemplateImplBase.mFeedLabelView == null) {
            labelHeight = DeviceUtils.ScreenInfo.dp2px(getContext(), 11.0f);
        } else {
            labelHeight = this.mFeedTemplateImplBase.mFeedLabelView.getHeight();
        }
        this.mEffectLp.height = this.mTitle.getHeight() + this.mContentLayout.getHeight() + labelHeight + DeviceUtils.ScreenInfo.dp2px(getContext(), 39.0f);
        this.mEffectLp.addRule(12, -1);
        this.mEffectVideo.setLayoutParams(this.mEffectLp);
        this.mFakeUnlikeLp.addRule(11, -1);
        if (!(this.mFeedTemplateImplBase == null || this.mFeedTemplateImplBase.mFeedLabelView == null)) {
            this.mFakeUnlikeLp.addRule(8, this.mFeedTemplateImplBase.mFeedLabelView.getId());
        }
        this.mFakeUnlikeLp.rightMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 11.0f);
        this.mFakeUnlikeView.setLayoutParams(this.mFakeUnlikeLp);
        if (getParent() instanceof View) {
            ExpandTouchAreaHelper.expandTouchArea((View) getParent(), this.mFakeUnlikeView, FeedLabelView.UNLIKE_TOUCH_EXPAND_LEFT, FeedLabelView.UNLIKE_TOUCH_EXPAND_TOP, FeedLabelView.UNLIKE_TOUCH_EXPAND_RIGHT, FeedLabelView.UNLIKE_TOUCH_EXPAND_BOTTOM);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    public void onLeavePage() {
        super.onLeavePage();
        stop();
    }

    public void onEnterPage() {
        super.onEnterPage();
        AlphaVideo alphaVideo = this.mContentVideo;
        if (alphaVideo != null) {
            alphaVideo.play();
        }
        AlphaVideo alphaVideo2 = this.mEffectVideo;
        if (alphaVideo2 != null) {
            alphaVideo2.play();
        }
    }

    public void onViewDestroy() {
        AlphaVideo alphaVideo = this.mContentVideo;
        if (alphaVideo != null) {
            alphaVideo.destroy();
        }
        AlphaVideo alphaVideo2 = this.mEffectVideo;
        if (alphaVideo2 != null) {
            alphaVideo2.destroy();
        }
        super.onViewDestroy();
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return FeedThinDividerPolicy.getDefault();
    }

    public void onFontSizeChanged(int fontSizeInPx) {
        super.onFontSizeChanged(fontSizeInPx);
        post(new FeedCNYStyleTwoView$$ExternalSyntheticLambda0(this));
    }

    private void stop() {
        AlphaVideo alphaVideo = this.mContentVideo;
        if (alphaVideo != null && alphaVideo.isPlaying()) {
            this.mContentVideo.stop();
        }
        if (this.mContentVideo != null && this.mEffectVideo.isPlaying()) {
            this.mEffectVideo.stop();
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.feed_template_base_delete_id && this.mFeedTemplateImplBase.mClickListener != null) {
            v.setTag(this.mFeedTemplateImplBase.mFeedModel);
            this.mFeedTemplateImplBase.mClickListener.onClick(v);
        }
    }
}
