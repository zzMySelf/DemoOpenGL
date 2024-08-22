package com.baidu.searchbox.video.template.live;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.Jsonable;
import com.baidu.searchbox.feed.template.FeedTabVideoView;
import com.baidu.searchbox.feed.template.FeedTemplateImpl;
import com.baidu.searchbox.feed.util.FeedVideoTabAutoPlayUtil;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.ui.VideoTabLiveTitlePrefixSpan;
import com.baidu.searchbox.player.utils.BdVideoImageUtils;
import com.baidu.searchbox.player.utils.VideoChannelTitleMoveDownUtils;
import com.baidu.searchbox.video.detail.export.IVideoNPSService;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.template.live.player.ChannelLiveGestureLayer;
import com.baidu.searchbox.video.template.live.player.ChannelLivePlayer;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0014J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0014J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\nH\u0014J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J(\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J\b\u0010(\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\nH\u0014J\b\u0010+\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/video/template/live/VideoTabLiveView;", "Lcom/baidu/searchbox/feed/template/FeedTabVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mTitlePrefixGifImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mTitlePrefixSpan", "Lcom/baidu/searchbox/player/ui/VideoTabLiveTitlePrefixSpan;", "createPlayer", "", "getPreFixTitle", "Landroid/text/SpannableString;", "prefix", "Lcom/baidu/searchbox/feed/model/FeedItemData$PrefixRichTitle;", "title", "", "getTplCoverUrl", "initView", "onClick", "v", "Landroid/view/View;", "preDownloadLiveNPS", "setPlayerHolderTopUiVisible", "visible", "", "shouldHidePreFixTag", "showVideoTitle", "itemData", "Lcom/baidu/searchbox/feed/model/FeedItemDataTabVideo;", "start", "startPlay", "reusedPlayer", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "update", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "options", "", "", "updateContainerSize", "updateGifLocation", "updateTabVideoView", "updateVideoPlayNum", "Companion", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabLiveView.kt */
public final class VideoTabLiveView extends FeedTabVideoView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int SCREEN_WIDTH = DeviceUtil.ScreenInfo.getDisplayWidth(FeedRuntime.getAppContext());
    private SimpleDraweeView mTitlePrefixGifImage;
    private VideoTabLiveTitlePrefixSpan mTitlePrefixSpan;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoTabLiveView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/template/live/VideoTabLiveView$Companion;", "", "()V", "SCREEN_WIDTH", "", "getSCREEN_WIDTH", "()I", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoTabLiveView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getSCREEN_WIDTH() {
            return VideoTabLiveView.SCREEN_WIDTH;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.mVideoPlayIcon.setImageResource(R.drawable.feed_video_live);
        this.mBottomShader.setVisibility(8);
        this.mTitlePrefixGifImage = (SimpleDraweeView) findViewById(com.baidu.searchbox.feed.template.R.id.feed_template_base_title_gif_tag);
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        super.update(feedModel, options);
        updateContainerSize();
        updateVideoPlayNum();
        preDownloadLiveNPS();
    }

    /* access modifiers changed from: protected */
    public void updateTabVideoView() {
        super.updateTabVideoView();
        this.mVideoPlayIcon.setImageResource(R.drawable.feed_video_live);
        VideoTabLiveTitlePrefixSpan videoTabLiveTitlePrefixSpan = this.mTitlePrefixSpan;
        if (videoTabLiveTitlePrefixSpan != null) {
            videoTabLiveTitlePrefixSpan.updateNightUi();
        }
    }

    private final void updateContainerSize() {
        int i2;
        FeedBaseModel model = this.mFeedModel;
        if (model != null) {
            FeedItemData feedItemData = model.data;
            FeedItemDataTabVideo data = feedItemData instanceof FeedItemDataTabVideo ? (FeedItemDataTabVideo) feedItemData : null;
            if (data != null) {
                this.mVideoImageWidth = SCREEN_WIDTH;
                ViewGroup.LayoutParams imageLP = this.mVideoImage.getLayoutParams();
                imageLP.width = this.mVideoImageWidth;
                if (Intrinsics.areEqual((Object) data.liveScreenStyle, (Object) "0")) {
                    i2 = MathKt.roundToInt((((float) this.mVideoImageWidth) * 7.0f) / 6.0f);
                } else {
                    i2 = MathKt.roundToInt((((float) this.mVideoImageWidth) * 9.0f) / 16.0f);
                }
                this.mVideoImageHeight = i2;
                imageLP.height = this.mVideoImageHeight;
                this.mVideoImage.setLayoutParams(imageLP);
                ViewGroup.LayoutParams holderLP = this.mVideoHolder.getLayoutParams();
                holderLP.height = this.mVideoImageHeight;
                this.mVideoHolder.setLayoutParams(holderLP);
            }
        }
    }

    private final void updateVideoPlayNum() {
        this.mVideoLength.setVisibility(8);
        this.mVideoPlayDivider.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.mVideoPlayNum.getLayoutParams();
        RelativeLayout.LayoutParams $this$updateVideoPlayNum_u24lambda_u2d2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if ($this$updateVideoPlayNum_u24lambda_u2d2 != null) {
            $this$updateVideoPlayNum_u24lambda_u2d2.addRule(8, com.baidu.searchbox.feed.template.R.id.tab_video_img);
            $this$updateVideoPlayNum_u24lambda_u2d2.addRule(7, com.baidu.searchbox.feed.template.R.id.tab_video_img);
            $this$updateVideoPlayNum_u24lambda_u2d2.rightMargin = DeviceUtil.ScreenInfo.dp2px(getContext(), 15.0f);
            $this$updateVideoPlayNum_u24lambda_u2d2.bottomMargin = DeviceUtil.ScreenInfo.dp2px(getContext(), 10.0f);
        }
    }

    private final void preDownloadLiveNPS() {
        FeedItemDataTabVideo.VideoInfoEntity $this$preDownloadLiveNPS_u24lambda_u2d3;
        FeedBaseModel feedBaseModel = this.mFeedModel;
        FeedItemDataTabVideo feedItemDataTabVideo = null;
        Jsonable jsonable = feedBaseModel != null ? feedBaseModel.data : null;
        if (jsonable instanceof FeedItemDataTabVideo) {
            feedItemDataTabVideo = (FeedItemDataTabVideo) jsonable;
        }
        if (feedItemDataTabVideo != null && ($this$preDownloadLiveNPS_u24lambda_u2d3 = feedItemDataTabVideo.mVideoInfo) != null && NetUtils.isNetWifi() && Intrinsics.areEqual((Object) $this$preDownloadLiveNPS_u24lambda_u2d3.mFormat, (Object) "yy")) {
            IVideoNPSService.Impl.INSTANCE.get().preDownloadLiveNPS($this$preDownloadLiveNPS_u24lambda_u2d3.mPage);
        }
    }

    /* access modifiers changed from: protected */
    public void showVideoTitle(FeedItemDataTabVideo itemData) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        TextView titleView = FeedVideoTabAutoPlayUtil.getNeedShowTitleView(this.mTitle, this.mBottomTitle);
        if (titleView != null) {
            CharSequence charSequence2 = itemData.title;
            if (charSequence2 == null || charSequence2.length() == 0) {
                titleView.setVisibility(8);
                return;
            }
            FeedItemData.PrefixRichTitle prefix = itemData.mPrefixRichTitle;
            if (shouldHidePreFixTag(prefix)) {
                charSequence = itemData.title;
            } else {
                Intrinsics.checkNotNullExpressionValue(prefix, "prefix");
                String str = itemData.title;
                Intrinsics.checkNotNullExpressionValue(str, "itemData.title");
                charSequence = getPreFixTitle(prefix, str);
            }
            titleView.setText(charSequence);
        }
    }

    private final boolean shouldHidePreFixTag(FeedItemData.PrefixRichTitle prefix) {
        if (prefix == null || !prefix.isDataValid()) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) prefix.content, (Object) getContext().getResources().getString(R.string.tab_video_author_image_living_tag)) || !VideoChannelTitleMoveDownUtils.isTitleMoveDown()) {
            return false;
        }
        return true;
    }

    private final SpannableString getPreFixTitle(FeedItemData.PrefixRichTitle prefix, String title) {
        if (this.mTitlePrefixSpan == null) {
            if (VideoChannelTitleMoveDownUtils.isTitleMoveDown()) {
                Context context = this.mContext;
                Intrinsics.checkNotNullExpressionValue(context, "mContext");
                String str = prefix.content;
                Intrinsics.checkNotNullExpressionValue(str, "prefix.content");
                VideoTabLiveTitlePrefixSpan $this$getPreFixTitle_u24lambda_u2d4 = new VideoTabLiveTitlePrefixSpan(context, str, 10.0f);
                $this$getPreFixTitle_u24lambda_u2d4.updateIconNight();
                this.mTitlePrefixSpan = $this$getPreFixTitle_u24lambda_u2d4;
                Intrinsics.checkNotNull($this$getPreFixTitle_u24lambda_u2d4);
                $this$getPreFixTitle_u24lambda_u2d4.setModifyStartY(true);
            } else {
                Context context2 = this.mContext;
                Intrinsics.checkNotNullExpressionValue(context2, "mContext");
                String str2 = prefix.content;
                Intrinsics.checkNotNullExpressionValue(str2, "prefix.content");
                VideoTabLiveTitlePrefixSpan $this$getPreFixTitle_u24lambda_u2d5 = new VideoTabLiveTitlePrefixSpan(context2, str2);
                $this$getPreFixTitle_u24lambda_u2d5.updateIconNight();
                this.mTitlePrefixSpan = $this$getPreFixTitle_u24lambda_u2d5;
                updateGifLocation();
            }
        }
        SpannableString $this$getPreFixTitle_u24lambda_u2d6 = new SpannableString("prefix" + title);
        $this$getPreFixTitle_u24lambda_u2d6.setSpan(this.mTitlePrefixSpan, 0, 6, 17);
        return $this$getPreFixTitle_u24lambda_u2d6;
    }

    private final void updateGifLocation() {
        SimpleDraweeView simpleDraweeView = this.mTitlePrefixGifImage;
        DraweeController draweeController = null;
        ViewGroup.LayoutParams layoutParams = simpleDraweeView != null ? simpleDraweeView.getLayoutParams() : null;
        if (layoutParams != null) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutParams;
            int i2 = params.leftMargin;
            VideoTabLiveTitlePrefixSpan videoTabLiveTitlePrefixSpan = this.mTitlePrefixSpan;
            Float valueOf = videoTabLiveTitlePrefixSpan != null ? Float.valueOf(videoTabLiveTitlePrefixSpan.getPreIconX()) : null;
            Intrinsics.checkNotNull(valueOf);
            params.leftMargin = i2 + (((int) valueOf.floatValue()) - (params.width / 2));
            Paint.FontMetricsInt metricsInt = this.mTitle.getPaint().getFontMetricsInt();
            params.topMargin += (((this.mTitle.getPaddingTop() - metricsInt.top) + metricsInt.descent) - ((metricsInt.descent - metricsInt.ascent) / 2)) - (params.height / 2);
            Uri uri = new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.drawable.feed_video_live_title_gif_tag)).build();
            PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
            SimpleDraweeView simpleDraweeView2 = this.mTitlePrefixGifImage;
            if (simpleDraweeView2 != null) {
                draweeController = simpleDraweeView2.getController();
            }
            AbstractDraweeController draweeController2 = ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) newDraweeControllerBuilder.setOldController(draweeController)).setUri(uri).setAutoPlayAnimations(true)).build();
            SimpleDraweeView simpleDraweeView3 = this.mTitlePrefixGifImage;
            if (simpleDraweeView3 != null) {
                simpleDraweeView3.setController(draweeController2);
            }
            SimpleDraweeView simpleDraweeView4 = this.mTitlePrefixGifImage;
            if (simpleDraweeView4 != null) {
                simpleDraweeView4.setVisibility(0);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    /* access modifiers changed from: protected */
    public void setPlayerHolderTopUiVisible(boolean visible) {
        super.setPlayerHolderTopUiVisible(visible);
        this.mBottomShader.setVisibility(8);
        this.mVideoPlayDivider.setVisibility(8);
        if (visible) {
            SimpleDraweeView simpleDraweeView = this.mTitlePrefixGifImage;
            if (simpleDraweeView != null) {
                simpleDraweeView.setAlpha(1.0f);
                return;
            }
            return;
        }
        SimpleDraweeView simpleDraweeView2 = this.mTitlePrefixGifImage;
        if (simpleDraweeView2 != null) {
            simpleDraweeView2.setAlpha(0.0f);
        }
    }

    public void onClick(View v) {
        View clickView;
        FeedTemplate.OnChildViewClickListener onChildViewClickListener;
        if (Intrinsics.areEqual((Object) v, (Object) this.mVideoPlayIcon)) {
            clickView = this;
        } else {
            clickView = this.mIVideoOptBottomView.getView();
            Intrinsics.checkNotNullExpressionValue(clickView, "{\n            mIVideoOptBottomView.view\n        }");
        }
        clickView.setTag(this.mFeedTemplateImplBase.mFeedModel);
        FeedTemplateImpl feedTemplateImpl = this.mFeedTemplateImplBase;
        if (feedTemplateImpl != null && (onChildViewClickListener = feedTemplateImpl.mClickListener) != null) {
            onChildViewClickListener.onClick(clickView);
        }
    }

    public void startPlay(BaseVideoPlayer reusedPlayer) {
        startPlay();
    }

    /* access modifiers changed from: protected */
    public void createPlayer() {
        View contentView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ChannelLivePlayer $this$createPlayer_u24lambda_u2d9 = new ChannelLivePlayer(context, (BaseKernelLayer) null, (String) null, 6, (DefaultConstructorMarker) null);
        $this$createPlayer_u24lambda_u2d9.setAutoPlay();
        $this$createPlayer_u24lambda_u2d9.disableOrientationEventHelper();
        $this$createPlayer_u24lambda_u2d9.setEnableGestureHandleTouchEvent(false);
        ChannelLiveGestureLayer gestureLayer = $this$createPlayer_u24lambda_u2d9.getGestureLayer();
        if (!(gestureLayer == null || (contentView = gestureLayer.getContentView()) == null)) {
            contentView.setOnClickListener(this);
        }
        FeedBaseModel model = this.mFeedModel;
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "mFeedModel");
            FeedItemData feedItemData = model.data;
            FeedItemDataTabVideo data = feedItemData instanceof FeedItemDataTabVideo ? (FeedItemDataTabVideo) feedItemData : null;
            if (data != null) {
                if (Intrinsics.areEqual((Object) data.liveScreenStyle, (Object) "0")) {
                    $this$createPlayer_u24lambda_u2d9.setVideoScalingMode(2);
                    String coverUrl = getTplCoverUrl();
                    if (TextUtils.isEmpty(coverUrl)) {
                        setTag((Object) null);
                        $this$createPlayer_u24lambda_u2d9.setVideoBackground((Drawable) null);
                    } else {
                        setTag(coverUrl);
                        BdVideoImageUtils.fetchBlurBitmap(coverUrl, 25, false, 0, 0, new WeakReference(new VideoTabLiveView$createPlayer$1$1$1$callback$1(coverUrl, this, $this$createPlayer_u24lambda_u2d9)));
                    }
                } else {
                    $this$createPlayer_u24lambda_u2d9.setVideoScalingMode(0);
                }
            }
        }
        this.mPlayer = $this$createPlayer_u24lambda_u2d9;
    }

    /* access modifiers changed from: protected */
    public void start() {
        BdVideoSeries it;
        String coverUrl = getTplCoverUrl();
        CharSequence charSequence = coverUrl;
        if (!(charSequence == null || charSequence.length() == 0) && (it = this.mPlayer.getVideoSeries()) != null) {
            it.setPoster(coverUrl);
        }
        this.mPlayer.start();
    }

    private final String getTplCoverUrl() {
        List images;
        FeedBaseModel model = this.mFeedModel;
        if (model != null) {
            FeedItemData feedItemData = model.data;
            FeedItemDataTabVideo data = feedItemData instanceof FeedItemDataTabVideo ? (FeedItemDataTabVideo) feedItemData : null;
            if (!(data == null || (images = data.images) == null)) {
                Intrinsics.checkNotNullExpressionValue(images, "images");
                if (images.size() > 0) {
                    return ((FeedItemDataNews.Image) images.get(0)).image;
                }
            }
        }
        return null;
    }
}
