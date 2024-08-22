package com.baidu.searchbox.feed.util.processor;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewStub;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.base.hot.IDynamicAutoPlay;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataStar;
import com.baidu.searchbox.feed.model.FeedItemForwardUgcDtModel;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.FeedForwardUgcDtView;
import com.baidu.searchbox.feed.template.FeedStarOneImgView;
import com.baidu.searchbox.feed.template.R;
import com.baidu.searchbox.feed.template.interfaces.IDynamicTemplateLifeCycle;
import com.baidu.searchbox.feed.template.statistic.FeedChannelConstants;
import com.baidu.searchbox.feed.template.utils.FeedHotTemplateUtils;
import com.baidu.searchbox.feed.template.utils.FeedTemplateImgCornersUtil;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u00012\u00020\u0002:\u0001@B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0006\u0010*\u001a\u00020\u000bJ\b\u0010+\u001a\u00020\u001eH\u0002J\n\u0010,\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u001f\u001a\u00020\u0006J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020\u0006H\u0002J\u0010\u00101\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u00020(H\u0016J\b\u00103\u001a\u00020(H\u0016J\b\u00104\u001a\u00020(H\u0016J\b\u00105\u001a\u00020(H\u0016J\b\u00106\u001a\u00020(H\u0016J\u000e\u00107\u001a\u00020(2\u0006\u00108\u001a\u00020\u0017J\b\u00109\u001a\u00020(H\u0016J\b\u0010:\u001a\u00020(H\u0002J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u001eH\u0016J\b\u0010=\u001a\u00020(H\u0002J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/baidu/searchbox/feed/util/processor/BigImgGifAutoPlayProcessor;", "Lcom/baidu/searchbox/feed/base/hot/IDynamicAutoPlay;", "Lcom/baidu/searchbox/feed/template/interfaces/IDynamicTemplateLifeCycle;", "rootView", "Landroid/view/View;", "isRepost", "", "(Landroid/view/View;Z)V", "bigImgView", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "business", "", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", "curBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "getCurBaseModel", "()Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "setCurBaseModel", "(Lcom/baidu/searchbox/feed/model/FeedBaseModel;)V", "gifClickListener", "Landroid/view/View$OnClickListener;", "gifDrawable", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "gifImage", "gifPlayHandler", "Landroid/os/Handler;", "gifStatus", "", "hasGif", "itemData", "Lcom/baidu/searchbox/feed/model/FeedItemDataStar;", "needPlayAfterDownload", "checkImgUrl", "url", "couldStartPlay", "contentHeight", "downloadGifResource", "", "playAfterDownload", "getGifHdUrl", "getGifInContentTop", "getGifUrl", "initGifImageIfNeeded", "initHandler", "isContentOutOfWindow", "isGifResourceReady", "needStopPlay", "onDestroy", "onPause", "onResume", "onStart", "onStop", "setGifClickListener", "listener", "startPlay", "startPlayGif", "stopPlay", "stopType", "stopPlayGif", "update", "baseModel", "GifControllerListener", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImgGifAutoPlayProcessor.kt */
public final class BigImgGifAutoPlayProcessor implements IDynamicAutoPlay, IDynamicTemplateLifeCycle {
    private FeedDraweeView bigImgView;
    private String business;
    private FeedBaseModel curBaseModel;
    private View.OnClickListener gifClickListener;
    /* access modifiers changed from: private */
    public AnimatedDrawable2 gifDrawable;
    /* access modifiers changed from: private */
    public FeedDraweeView gifImage;
    /* access modifiers changed from: private */
    public Handler gifPlayHandler;
    /* access modifiers changed from: private */
    public int gifStatus;
    private boolean hasGif;
    private final boolean isRepost;
    private FeedItemDataStar itemData;
    /* access modifiers changed from: private */
    public boolean needPlayAfterDownload;
    private final View rootView;

    public BigImgGifAutoPlayProcessor(View rootView2, boolean isRepost2) {
        Intrinsics.checkNotNullParameter(rootView2, "rootView");
        this.rootView = rootView2;
        this.isRepost = isRepost2;
        initHandler();
        View findViewById = rootView2.findViewById(R.id.feed_template_big_image_id);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…ed_template_big_image_id)");
        this.bigImgView = (FeedDraweeView) findViewById;
    }

    public final FeedBaseModel getCurBaseModel() {
        return this.curBaseModel;
    }

    public final void setCurBaseModel(FeedBaseModel feedBaseModel) {
        this.curBaseModel = feedBaseModel;
    }

    public final String getBusiness() {
        return this.business;
    }

    public final void setBusiness(String str) {
        this.business = str;
    }

    private final void initHandler() {
        this.gifPlayHandler = new BigImgGifAutoPlayProcessor$initHandler$1(this, Looper.getMainLooper());
    }

    public final void update(FeedBaseModel baseModel) {
        Intrinsics.checkNotNullParameter(baseModel, "baseModel");
        if (baseModel.runtimeStatus != null && (baseModel.data instanceof FeedItemDataStar)) {
            String str = baseModel.runtimeStatus.channelId;
            this.business = str;
            if (!FeedChannelConstants.isFeedChannel(str)) {
                this.curBaseModel = baseModel;
                FeedItemData feedItemData = baseModel.data;
                if (feedItemData != null) {
                    this.itemData = (FeedItemDataStar) feedItemData;
                    this.hasGif = false;
                    this.gifDrawable = null;
                    this.gifStatus = 0;
                    FeedDraweeView it = this.gifImage;
                    if (it != null) {
                        it.setVisibility(8);
                    }
                    FeedItemDataStar it2 = this.itemData;
                    if (it2 == null) {
                        return;
                    }
                    if (TextUtils.equals("gif", it2.type) || ((it2 instanceof FeedItemForwardUgcDtModel) && TextUtils.equals(((FeedItemForwardUgcDtModel) it2).quoteModel.resourceType, "gif"))) {
                        this.hasGif = true;
                        if (NetWorkUtils.isWifiNetworkConnected()) {
                            downloadGifResource(false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedItemDataStar");
            }
        }
    }

    public boolean couldStartPlay(int contentHeight) {
        if (!this.hasGif || !NetWorkUtils.isWifiNetworkConnected()) {
            return false;
        }
        int gifContentTop = getGifInContentTop();
        boolean isShowTopArea = contentHeight - gifContentTop >= this.bigImgView.getHeight() / 2;
        boolean isShowBottomArea = true;
        if (gifContentTop < 0) {
            isShowBottomArea = this.bigImgView.getHeight() + gifContentTop > this.bigImgView.getHeight() / 2;
        }
        if (!isShowTopArea || !isShowBottomArea) {
            return false;
        }
        return true;
    }

    public void startPlay() {
        if (isGifResourceReady()) {
            startPlayGif();
        } else {
            downloadGifResource(true);
        }
    }

    public boolean needStopPlay(int contentHeight) {
        if (!this.hasGif) {
            return true;
        }
        int gifInContentTop = getGifInContentTop();
        if (((float) gifInContentTop) < ((float) (-this.bigImgView.getHeight())) * 0.5f || ((float) gifInContentTop) + (((float) this.bigImgView.getHeight()) * 0.5f) > ((float) contentHeight)) {
            return true;
        }
        return false;
    }

    public void stopPlay(int stopType) {
        if (this.hasGif) {
            stopPlayGif();
            Handler handler = this.gifPlayHandler;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public boolean isContentOutOfWindow() {
        return getGifInContentTop() < 0;
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
        stopPlay(5);
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    /* access modifiers changed from: private */
    public final void startPlayGif() {
        initGifImageIfNeeded();
        AnimatedDrawable2 it = this.gifDrawable;
        if (it == null) {
            FeedDraweeView feedDraweeView = this.gifImage;
            if (feedDraweeView != null) {
                feedDraweeView.setVisibility(0);
            }
            if (this.curBaseModel != null && this.itemData != null) {
                String gifUrl = getGifUrl();
                String gifHdUrl = getGifHdUrl();
                if (!TextUtils.isEmpty(gifUrl) && !TextUtils.isEmpty(gifHdUrl)) {
                    String str = this.business;
                    SimpleDraweeView simpleDraweeView = this.gifImage;
                    ControllerListener gifControllerListener = new GifControllerListener();
                    FeedBaseModel feedBaseModel = this.curBaseModel;
                    FeedItemDataStar feedItemDataStar = this.itemData;
                    FeedHotTemplateUtils.fetchImageWithMonitor(str, gifUrl, gifHdUrl, simpleDraweeView, gifControllerListener, feedBaseModel, feedItemDataStar != null ? Boolean.valueOf(feedItemDataStar.isFirstCard) : null);
                }
            }
        } else if (!it.isRunning()) {
            FeedDraweeView feedDraweeView2 = this.gifImage;
            if (feedDraweeView2 != null) {
                feedDraweeView2.setImageDrawable(this.gifDrawable);
            }
            it.start();
            FeedDraweeView feedDraweeView3 = this.gifImage;
            if (feedDraweeView3 != null) {
                feedDraweeView3.setVisibility(0);
            }
        }
    }

    private final void stopPlayGif() {
        FeedDraweeView it = this.gifImage;
        if (it != null) {
            it.setVisibility(8);
        }
        AnimatedDrawable2 it2 = this.gifDrawable;
        if (it2 != null) {
            it2.stop();
            it2.jumpToFrame(0);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/util/processor/BigImgGifAutoPlayProcessor$GifControllerListener;", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "(Lcom/baidu/searchbox/feed/util/processor/BigImgGifAutoPlayProcessor;)V", "shouldPlayAfterLoad", "", "onFinalImageSet", "", "id", "", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BigImgGifAutoPlayProcessor.kt */
    public final class GifControllerListener extends BaseControllerListener<ImageInfo> {
        private boolean shouldPlayAfterLoad = true;

        public GifControllerListener() {
        }

        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
            Intrinsics.checkNotNullParameter(id, "id");
            super.onFinalImageSet(id, imageInfo, animatable);
            if (animatable instanceof AnimatedDrawable2) {
                BigImgGifAutoPlayProcessor.this.gifStatus = 3;
                BigImgGifAutoPlayProcessor.this.gifDrawable = (AnimatedDrawable2) animatable;
                ((AnimatedDrawable2) animatable).setAnimationBackend(new BigImgGifAutoPlayProcessor$GifControllerListener$onFinalImageSet$1(((AnimatedDrawable2) animatable).getAnimationBackend()));
                if (this.shouldPlayAfterLoad) {
                    BigImgGifAutoPlayProcessor.this.initGifImageIfNeeded();
                    FeedDraweeView access$getGifImage$p = BigImgGifAutoPlayProcessor.this.gifImage;
                    Intrinsics.checkNotNull(access$getGifImage$p);
                    access$getGifImage$p.setVisibility(0);
                    AnimatedDrawable2 access$getGifDrawable$p = BigImgGifAutoPlayProcessor.this.gifDrawable;
                    Intrinsics.checkNotNull(access$getGifDrawable$p);
                    access$getGifDrawable$p.start();
                    Handler it = BigImgGifAutoPlayProcessor.this.gifPlayHandler;
                    if (it != null) {
                        BigImgGifAutoPlayProcessor bigImgGifAutoPlayProcessor = BigImgGifAutoPlayProcessor.this;
                        if (FeedRuntime.GLOBAL_DEBUG) {
                            String access$getTAG$p = BigImgGifAutoPlayProcessorKt.TAG;
                            StringBuilder append = new StringBuilder().append("send delay message: post_delay, delayed ");
                            AnimatedDrawable2 access$getGifDrawable$p2 = bigImgGifAutoPlayProcessor.gifDrawable;
                            Intrinsics.checkNotNull(access$getGifDrawable$p2);
                            Log.d(access$getTAG$p, append.append(access$getGifDrawable$p2.getLoopDurationMs()).toString());
                        }
                        AnimatedDrawable2 access$getGifDrawable$p3 = bigImgGifAutoPlayProcessor.gifDrawable;
                        Intrinsics.checkNotNull(access$getGifDrawable$p3);
                        it.sendEmptyMessageDelayed(1, access$getGifDrawable$p3.getLoopDurationMs());
                    }
                    this.shouldPlayAfterLoad = false;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void initGifImageIfNeeded() {
        if (this.gifImage == null) {
            View findViewById = this.rootView.findViewById(R.id.feed_hot_star_big_image_gif_stub);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…_star_big_image_gif_stub)");
            ((ViewStub) findViewById).inflate();
            FeedDraweeView feedDraweeView = (FeedDraweeView) this.rootView.findViewById(R.id.feed_hot_star_big_image_gif_view);
            this.gifImage = feedDraweeView;
            FeedTemplateImgCornersUtil.processSingleImgSmallCorners(feedDraweeView);
        }
    }

    private final void downloadGifResource(boolean playAfterDownload) {
        this.needPlayAfterDownload = playAfterDownload;
        if (this.gifStatus == 0) {
            String url = getGifHdUrl();
            if (!TextUtils.isEmpty(url)) {
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                Uri uri = Uri.parse(url);
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build();
                this.gifStatus = 1;
                imagePipeline.fetchDecodedImage(request, (Object) null).subscribe(new BigImgGifAutoPlayProcessor$downloadGifResource$1(this, url, uri), CallerThreadExecutor.getInstance());
            }
        }
    }

    private final int getGifInContentTop() {
        int contentTop = 0;
        ViewParent templateView = this.bigImgView.getParent();
        int i2 = 0;
        View view2 = null;
        if (!this.isRepost) {
            while (templateView != null && !(templateView instanceof FeedStarOneImgView)) {
                View view3 = templateView instanceof View ? (View) templateView : null;
                contentTop += view3 != null ? view3.getTop() : 0;
                templateView = templateView.getParent();
            }
        } else {
            while (templateView != null && !(templateView instanceof FeedForwardUgcDtView)) {
                View view4 = templateView instanceof View ? (View) templateView : null;
                contentTop += view4 != null ? view4.getTop() : 0;
                templateView = templateView.getParent();
            }
        }
        if (templateView instanceof View) {
            view2 = (View) templateView;
        }
        if (view2 != null) {
            i2 = view2.getTop();
        }
        return this.bigImgView.getTop() + contentTop + i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.hdImagesList;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getGifHdUrl() {
        /*
            r4 = this;
            com.baidu.searchbox.feed.model.FeedItemDataStar r0 = r4.itemData
            if (r0 == 0) goto L_0x000e
            org.json.JSONArray r0 = r0.hdImagesList
            if (r0 == 0) goto L_0x000e
            r1 = 0
            java.lang.Object r0 = r0.opt(r1)
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            java.lang.String r1 = ""
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x0019
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x002e
        L_0x0019:
            boolean r2 = r0 instanceof org.json.JSONObject
            if (r2 == 0) goto L_0x002e
            r2 = r0
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            java.lang.String r3 = "url"
            java.lang.String r2 = r2.optString(r3)
            java.lang.String r3 = "obj.optString(\"url\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1 = r2
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.util.processor.BigImgGifAutoPlayProcessor.getGifHdUrl():java.lang.String");
    }

    private final String getGifUrl() {
        List list;
        FeedItemDataNews.Image image;
        FeedItemDataStar feedItemDataStar = this.itemData;
        if (feedItemDataStar == null || (list = feedItemDataStar.images) == null || (image = (FeedItemDataNews.Image) list.get(0)) == null) {
            return null;
        }
        return image.image;
    }

    private final boolean isGifResourceReady() {
        if (this.gifDrawable != null) {
            return true;
        }
        if (this.gifStatus == 2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean checkImgUrl(String url) {
        if (TextUtils.equals(url, getGifHdUrl())) {
            return true;
        }
        return false;
    }

    public final void setGifClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.gifClickListener = listener;
    }

    public final boolean hasGif() {
        return this.hasGif;
    }
}
