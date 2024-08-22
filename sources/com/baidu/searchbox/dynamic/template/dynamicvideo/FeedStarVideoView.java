package com.baidu.searchbox.dynamic.template.dynamicvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.dynamic.template.R;
import com.baidu.searchbox.dynamic.template.model.DynamicVideoInfo;
import com.baidu.searchbox.dynamic.template.video.DynamicVideoPostViewImpl;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.hot.IDynamicAutoPlay;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBaseModelHelper;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.tab.utils.FeedDividerUtils;
import com.baidu.searchbox.feed.tab.view.FeedThickDividerPolicy;
import com.baidu.searchbox.feed.tab.view.FeedThinDividerPolicy;
import com.baidu.searchbox.feed.template.FeedItemStarTitleBar;
import com.baidu.searchbox.feed.template.NewsFeedBaseView;
import com.baidu.searchbox.feed.template.recgoods.FeedTalosLiteSlotStatInterceptor;
import com.baidu.searchbox.feed.template.titlebar.StarTitleBar;
import com.baidu.searchbox.feed.template.titlebar.StarTitleBarKt;
import com.baidu.searchbox.feed.template.tplinterface.OnNetWorkChangeListener;
import com.baidu.searchbox.feed.template.util.FontSizeExpUtil;
import com.baidu.searchbox.feed.template.util.RasterWidthUtil;
import com.baidu.searchbox.feed.template.utils.FeedOrderSenseUtil;
import com.baidu.searchbox.feed.template.view.FeedStarImpl;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.util.processor.FeedTextProcessor;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.talos.lite.ITalosLiteContainer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tH\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0014J\u0012\u0010.\u001a\u00020/2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020'H\u0002J\b\u00102\u001a\u00020'H\u0002J\b\u00103\u001a\u00020'H\u0002J\u0010\u00104\u001a\u00020'2\u0006\u0010(\u001a\u00020\tH\u0016J\b\u00105\u001a\u00020/H\u0014J\b\u00106\u001a\u00020/H\u0016J\u0010\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020/H\u0016J\b\u0010:\u001a\u00020/H\u0016J\b\u0010;\u001a\u00020/H\u0016J\b\u0010<\u001a\u00020/H\u0016J\b\u0010=\u001a\u00020/H\u0016J\b\u0010>\u001a\u00020/H\u0016J\b\u0010?\u001a\u00020/H\u0016J\b\u0010@\u001a\u00020/H\u0016J\u0012\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u0010B\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020/H\u0016J\u0010\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\tH\u0016J(\u0010H\u001a\u00020/2\b\u0010I\u001a\u0004\u0018\u00010D2\u0014\u0010J\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020M\u0018\u00010KH\u0016J\b\u0010N\u001a\u00020/H\u0002J\b\u0010O\u001a\u00020/H\u0016J\u0012\u0010P\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010DH\u0014J\u0012\u0010Q\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010DH\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$¨\u0006R"}, d2 = {"Lcom/baidu/searchbox/dynamic/template/dynamicvideo/FeedStarVideoView;", "Lcom/baidu/searchbox/feed/template/NewsFeedBaseView;", "Lcom/baidu/searchbox/feed/base/hot/IDynamicAutoPlay;", "Lcom/baidu/searchbox/feed/template/tplinterface/OnNetWorkChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "feedItemStarTitleBar", "Lcom/baidu/searchbox/feed/template/titlebar/StarTitleBar;", "feedStarImpl", "Lcom/baidu/searchbox/feed/template/view/FeedStarImpl;", "feedStarVideoModel", "Lcom/baidu/searchbox/dynamic/template/dynamicvideo/FeedItemDataStarVideo;", "netWorkRunnable", "com/baidu/searchbox/dynamic/template/dynamicvideo/FeedStarVideoView$netWorkRunnable$1", "Lcom/baidu/searchbox/dynamic/template/dynamicvideo/FeedStarVideoView$netWorkRunnable$1;", "titleContainer", "Landroid/widget/FrameLayout;", "videoContainer", "Landroid/widget/RelativeLayout;", "getVideoContainer", "()Landroid/widget/RelativeLayout;", "videoContainer$delegate", "Lkotlin/Lazy;", "videoPostViewImpl", "Lcom/baidu/searchbox/dynamic/template/video/DynamicVideoPostViewImpl;", "getVideoPostViewImpl", "()Lcom/baidu/searchbox/dynamic/template/video/DynamicVideoPostViewImpl;", "videoPostViewImpl$delegate", "videoRootView", "Landroid/view/View;", "getVideoRootView", "()Landroid/view/View;", "videoRootView$delegate", "couldStartPlay", "", "contentHeight", "getFeedDividerPolicy", "Lcom/baidu/searchbox/feed/base/FeedTemplate$FeedDividerPolicy;", "initInflate", "inflater", "Landroid/view/LayoutInflater;", "initLayout", "", "isContentOutOfWindow", "isLiveVideo", "isWifi", "liveNotAutoPlay", "needStopPlay", "onDetachedFromWindow", "onEnterPage", "onFontSizeChanged", "fontSizeInPx", "onLeavePage", "onNetWorkChange", "onViewCreate", "onViewDestroy", "onViewPause", "onViewResume", "onViewStart", "onViewStop", "processAspectRadio", "model", "setDynamicBackgroundPressed", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "startPlay", "stopPlay", "stopType", "update", "feedModel", "options", "", "", "", "updatePlayIcon", "updateRefreshTime", "updateSubViewData", "updateSubViewUi", "lib-feed-dynamic-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedStarVideoView.kt */
public final class FeedStarVideoView extends NewsFeedBaseView implements IDynamicAutoPlay, OnNetWorkChangeListener {
    private StarTitleBar feedItemStarTitleBar;
    private final FeedStarImpl feedStarImpl;
    /* access modifiers changed from: private */
    public FeedItemDataStarVideo feedStarVideoModel;
    private final FeedStarVideoView$netWorkRunnable$1 netWorkRunnable;
    private FrameLayout titleContainer;
    private final Lazy videoContainer$delegate;
    private final Lazy videoPostViewImpl$delegate;
    private final Lazy videoRootView$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedStarVideoView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedStarVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedStarVideoView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedStarVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.feedStarImpl = new FeedStarImpl(this);
        this.videoContainer$delegate = LazyKt.lazy(new FeedStarVideoView$videoContainer$2(this));
        this.videoRootView$delegate = LazyKt.lazy(new FeedStarVideoView$videoRootView$2(this));
        this.videoPostViewImpl$delegate = LazyKt.lazy(new FeedStarVideoView$videoPostViewImpl$2(this));
        this.netWorkRunnable = new FeedStarVideoView$netWorkRunnable$1(this);
    }

    private final RelativeLayout getVideoContainer() {
        Object value = this.videoContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoContainer>(...)");
        return (RelativeLayout) value;
    }

    /* access modifiers changed from: private */
    public final View getVideoRootView() {
        Object value = this.videoRootView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoRootView>(...)");
        return (View) value;
    }

    /* access modifiers changed from: private */
    public final DynamicVideoPostViewImpl getVideoPostViewImpl() {
        return (DynamicVideoPostViewImpl) this.videoPostViewImpl$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public View initInflate(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View $this$initInflate_u24lambda_u2d2 = inflater.inflate(R.layout.dynamic_feed_star_video_view, this);
        FrameLayout frameLayout = (FrameLayout) $this$initInflate_u24lambda_u2d2.findViewById(R.id.feed_star_title_bar_id);
        if (frameLayout != null) {
            Intrinsics.checkNotNullExpressionValue(frameLayout, "findViewById<FrameLayout…d.feed_star_title_bar_id)");
            FrameLayout $this$initInflate_u24lambda_u2d2_u24lambda_u2d1 = frameLayout;
            FeedItemStarTitleBar $this$initInflate_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = new FeedItemStarTitleBar($this$initInflate_u24lambda_u2d2_u24lambda_u2d1.getContext());
            this.feedItemStarTitleBar = $this$initInflate_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0;
            $this$initInflate_u24lambda_u2d2_u24lambda_u2d1.addView($this$initInflate_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0);
        } else {
            frameLayout = null;
        }
        this.titleContainer = frameLayout;
        Intrinsics.checkNotNullExpressionValue($this$initInflate_u24lambda_u2d2, "inflater.inflate(R.layou…)\n            }\n        }");
        return $this$initInflate_u24lambda_u2d2;
    }

    /* access modifiers changed from: protected */
    public void initLayout(Context context) {
        this.mTitle.setLineSpacing(ViewExtensionsKt.getDimension(this, com.baidu.searchbox.feed.styles.R.dimen.F_M_T_X03), 1.0f);
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        ITalosLiteContainer container;
        StarTitleBar it1 = null;
        FeedItemData feedItemData = feedModel != null ? feedModel.data : null;
        FeedItemDataStarVideo feedItemDataStarVideo = feedItemData instanceof FeedItemDataStarVideo ? (FeedItemDataStarVideo) feedItemData : null;
        if (feedItemDataStarVideo != null) {
            this.feedStarVideoModel = feedItemDataStarVideo;
            FeedTextProcessor.setDynamicTplTextMaxLines(this.mTitle, feedModel);
            FrameLayout it = this.titleContainer;
            if (it != null) {
                StarTitleBar it12 = this.feedItemStarTitleBar;
                if (it12 != null) {
                    it1 = StarTitleBarKt.assembleTitleBar(it, feedModel, it12);
                }
                this.feedItemStarTitleBar = it1;
            }
            StarTitleBar starTitleBar = this.feedItemStarTitleBar;
            if (starTitleBar != null) {
                starTitleBar.setTplClickListener(this);
            }
            super.update(feedModel, options);
            this.mNewsTemplateImpl.updateLabelBarVisibility(feedModel);
            this.feedStarImpl.update(feedModel);
            getVideoPostViewImpl().setBusiness(feedModel.runtimeStatus.channelId);
            getVideoPostViewImpl().update(feedModel);
            processAspectRadio(this.feedStarVideoModel);
            updatePlayIcon();
            if (this.mFeedTemplateImplBase != null && this.mFeedTemplateImplBase.aboveBottomBarTalosView != null && (container = this.mFeedTemplateImplBase.aboveBottomBarTalosView.getContainer()) != null) {
                container.addActionIntercept("ubc", new FeedTalosLiteSlotStatInterceptor(feedModel));
            }
        }
    }

    private final void updatePlayIcon() {
        int i2;
        ImageView playIcon = getVideoPostViewImpl().getPlayIcon();
        Context context = getContext();
        if (isLiveVideo()) {
            i2 = R.drawable.dynamic_video_play_icon_live;
        } else {
            i2 = com.baidu.searchbox.feed.template.R.drawable.feed_video_play;
        }
        playIcon.setImageDrawable(ContextCompat.getDrawable(context, i2));
    }

    private final void processAspectRadio(FeedItemDataStarVideo model) {
        if (model != null) {
            DynamicVideoInfo dynamicVideoInfo = model.getDynamicVideoInfo();
            String str = dynamicVideoInfo != null ? dynamicVideoInfo.type : null;
            if (Intrinsics.areEqual((Object) str, (Object) "minivideo")) {
                RelativeLayout $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d6 = getVideoContainer();
                ViewGroup.LayoutParams layoutParams = $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d6.getLayoutParams();
                ViewGroup.LayoutParams $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d6_u24lambda_u2d5 = layoutParams;
                Context context = $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d6.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                float rasterWidth = RasterWidthUtil.getRasterWidth(context, 8, FeedOrderSenseUtil.isSenseOfOrderOneMode(this.mFeedBaseModel));
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d6_u24lambda_u2d5.height = (int) ((((float) 4) * rasterWidth) / ((float) 3));
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d6_u24lambda_u2d5.width = (int) rasterWidth;
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d6.setLayoutParams(layoutParams);
            } else if (Intrinsics.areEqual((Object) str, (Object) DynamicVideoInfo.LIVE_VERTICAL_TYPE)) {
                RelativeLayout $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d8 = getVideoContainer();
                ViewGroup.LayoutParams layoutParams2 = $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d8.getLayoutParams();
                ViewGroup.LayoutParams $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d8_u24lambda_u2d7 = layoutParams2;
                Context context2 = $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d8.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                float rasterWidth2 = RasterWidthUtil.getRasterWidth(context2, 8, FeedOrderSenseUtil.isSenseOfOrderOneMode(this.mFeedBaseModel));
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d8_u24lambda_u2d7.height = (int) ((((float) 5) * rasterWidth2) / ((float) 4));
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d8_u24lambda_u2d7.width = (int) rasterWidth2;
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d8.setLayoutParams(layoutParams2);
            } else {
                RelativeLayout $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d10 = getVideoContainer();
                ViewGroup.LayoutParams layoutParams3 = $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d10.getLayoutParams();
                ViewGroup.LayoutParams $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9 = layoutParams3;
                Context context3 = $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d10.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                float rasterWidth3 = RasterWidthUtil.getRasterWidth(context3, 12, FeedOrderSenseUtil.isSenseOfOrderOneMode(this.mFeedBaseModel));
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.height = (int) ((((float) 9) * rasterWidth3) / ((float) 16));
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.width = (int) rasterWidth3;
                $this$processAspectRadio_u24lambda_u2d11_u24lambda_u2d10.setLayoutParams(layoutParams3);
            }
        }
    }

    public void onNetWorkChange() {
        if (isLiveVideo()) {
            removeCallbacks(this.netWorkRunnable);
            postDelayed(this.netWorkRunnable, 500);
        }
    }

    /* access modifiers changed from: protected */
    public void updateSubViewData(FeedBaseModel model) {
    }

    /* access modifiers changed from: protected */
    public void updateSubViewUi(FeedBaseModel model) {
        StarTitleBar starTitleBar = this.feedItemStarTitleBar;
        if (starTitleBar != null) {
            starTitleBar.update(model);
        }
    }

    public void updateRefreshTime() {
        super.updateRefreshTime();
        StarTitleBar starTitleBar = this.feedItemStarTitleBar;
        if (starTitleBar != null) {
            starTitleBar.updateCreateTime();
        }
    }

    public void onFontSizeChanged(int fontSizeInPx) {
        super.onFontSizeChanged(FontSizeExpUtil.getStarTitleFontSize(getFeedModel()));
        FeedTextProcessor.processText(this.mFeedTemplateImplBase.mContext, this.mTitle, this.mFeedBaseModel, false);
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        if (FeedDividerUtils.needHideThickDivider(getFeedModel())) {
            return FeedThinDividerPolicy.getDefault();
        }
        return FeedThickDividerPolicy.getDefault();
    }

    /* access modifiers changed from: protected */
    public void setDynamicBackgroundPressed(FeedBaseModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        FeedBaseModelHelper helper = model.getHelper();
        Intrinsics.checkNotNullExpressionValue(helper, "model.helper");
        if (helper.isNeedDynamicFold()) {
            FeedUtil.setBackground(this, ContextCompat.getDrawable(getContext(), com.baidu.searchbox.feed.core.R.drawable.feed_item_dynamic_bg));
        }
    }

    public boolean couldStartPlay(int contentHeight) {
        int halfVideoTop = getVideoContainer().getTop() + getTop() + (getVideoContainer().getMeasuredHeight() / 2);
        return halfVideoTop >= 0 && halfVideoTop <= contentHeight;
    }

    public void startPlay() {
        if (!liveNotAutoPlay()) {
            getVideoPostViewImpl().startPlay();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r0.getDynamicVideoInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean liveNotAutoPlay() {
        /*
            r3 = this;
            boolean r0 = r3.isLiveVideo()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.baidu.searchbox.dynamic.template.dynamicvideo.FeedItemDataStarVideo r0 = r3.feedStarVideoModel
            if (r0 == 0) goto L_0x0018
            com.baidu.searchbox.dynamic.template.model.DynamicVideoInfo r0 = r0.getDynamicVideoInfo()
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.autoPlay
            if (r0 != r1) goto L_0x0018
            r0 = r1
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            if (r0 == 0) goto L_0x0023
            boolean r0 = r3.isWifi()
            if (r0 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamic.template.dynamicvideo.FeedStarVideoView.liveNotAutoPlay():boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getDynamicVideoInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isLiveVideo() {
        /*
            r2 = this;
            com.baidu.searchbox.dynamic.template.dynamicvideo.FeedItemDataStarVideo r0 = r2.feedStarVideoModel
            if (r0 == 0) goto L_0x000d
            com.baidu.searchbox.dynamic.template.model.DynamicVideoInfo r0 = r0.getDynamicVideoInfo()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.type
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            java.lang.String r1 = "liveVertical"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = "liveHorizontal"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r1 = 0
            goto L_0x0024
        L_0x0023:
            r1 = 1
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamic.template.dynamicvideo.FeedStarVideoView.isLiveVideo():boolean");
    }

    private final boolean isWifi() {
        return NetWorkUtils.isWifiConnected(FeedRuntime.getAppContext());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.netWorkRunnable);
    }

    public boolean needStopPlay(int contentHeight) {
        int halfVideoTop = getVideoContainer().getTop() + getTop() + (getVideoContainer().getMeasuredHeight() / 2);
        boolean z = false;
        if (halfVideoTop >= 0 && halfVideoTop <= contentHeight) {
            z = true;
        }
        return true ^ z;
    }

    public boolean isContentOutOfWindow() {
        return getVideoContainer().getTop() < 0;
    }

    public void stopPlay(int stopType) {
        getVideoPostViewImpl().stopPlay(stopType);
    }

    public void onViewCreate() {
        super.onViewCreate();
    }

    public void onViewStart() {
        super.onViewStart();
        getVideoPostViewImpl().onStart();
        this.feedStarImpl.onViewStart();
    }

    public void onViewResume() {
        super.onViewResume();
        getVideoPostViewImpl().onResume();
        this.feedStarImpl.onViewResume();
    }

    public void onViewPause() {
        super.onViewPause();
        getVideoPostViewImpl().onPause();
        this.feedStarImpl.onViewPause();
    }

    public void onViewStop() {
        super.onViewStop();
        getVideoPostViewImpl().onStop();
        this.feedStarImpl.onViewStop();
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        getVideoPostViewImpl().onDestroy();
        this.feedStarImpl.onViewDestroy();
    }

    public void onEnterPage() {
        super.onEnterPage();
        this.feedStarImpl.onEnterPage();
    }

    public void onLeavePage() {
        super.onLeavePage();
        this.feedStarImpl.onLeavePage();
    }
}
