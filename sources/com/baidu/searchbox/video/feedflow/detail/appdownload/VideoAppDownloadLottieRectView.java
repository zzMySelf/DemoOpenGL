package com.baidu.searchbox.video.feedflow.detail.appdownload;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.feed.template.FeedAdProgressButton;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0006\u0010\u001e\u001a\u00020\u001cJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/appdownload/VideoAppDownloadLottieRectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "forceHidePag", "", "pagAnim", "Lorg/libpag/PAGView;", "getPagAnim", "()Lorg/libpag/PAGView;", "pagAnim$delegate", "Lkotlin/Lazy;", "progressButton", "Lcom/baidu/searchbox/feed/template/FeedAdProgressButton;", "getProgressButton", "()Lcom/baidu/searchbox/feed/template/FeedAdProgressButton;", "progressButton$delegate", "stateTextView", "Landroid/widget/TextView;", "getStateTextView", "()Landroid/widget/TextView;", "stateTextView$delegate", "hideLottie", "", "initSkin", "resetUi", "setProgress", "progress", "showPagAnim", "updateText", "text", "", "updateUIStatus", "downloadParam", "Lcom/baidu/searchbox/video/feedflow/detail/appdownload/DownloadParam;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoAppDownloadLottieRectView.kt */
public final class VideoAppDownloadLottieRectView extends FrameLayout {
    private boolean forceHidePag;
    private final Lazy pagAnim$delegate;
    private final Lazy progressButton$delegate;
    private final Lazy stateTextView$delegate;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoAppDownloadLottieRectView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoDownloadStatus.values().length];
            iArr[VideoDownloadStatus.STATUS_NONE.ordinal()] = 1;
            iArr[VideoDownloadStatus.STATUS_DOWNLOADING.ordinal()] = 2;
            iArr[VideoDownloadStatus.STATUS_PAUSED.ordinal()] = 3;
            iArr[VideoDownloadStatus.STATUS_SUCCESS.ordinal()] = 4;
            iArr[VideoDownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 5;
            iArr[VideoDownloadStatus.STATUS_FAILED_RETRY.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoAppDownloadLottieRectView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoAppDownloadLottieRectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoAppDownloadLottieRectView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoAppDownloadLottieRectView(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
        Intrinsics.checkNotNullParameter(context, "context");
        this.progressButton$delegate = LazyKt.lazy(new VideoAppDownloadLottieRectView$progressButton$2(this));
        this.stateTextView$delegate = LazyKt.lazy(new VideoAppDownloadLottieRectView$stateTextView$2(this));
        this.pagAnim$delegate = LazyKt.lazy(new VideoAppDownloadLottieRectView$pagAnim$2(this));
        LayoutInflater.from(context).inflate(R.layout.video_flow_download_lottie_rect_view, this, true);
        initSkin();
    }

    private final FeedAdProgressButton getProgressButton() {
        Object value = this.progressButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-progressButton>(...)");
        return (FeedAdProgressButton) value;
    }

    private final TextView getStateTextView() {
        Object value = this.stateTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-stateTextView>(...)");
        return (TextView) value;
    }

    private final PAGView getPagAnim() {
        Object value = this.pagAnim$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pagAnim>(...)");
        return (PAGView) value;
    }

    public final void updateUIStatus(DownloadParam downloadParam) {
        Intrinsics.checkNotNullParameter(downloadParam, "downloadParam");
        updateText(downloadParam.getText());
        switch (WhenMappings.$EnumSwitchMapping$0[downloadParam.getStatus().ordinal()]) {
            case 1:
                setProgress(0);
                showPagAnim();
                return;
            case 2:
                setProgress(downloadParam.getProgress());
                hideLottie();
                return;
            case 3:
                hideLottie();
                return;
            case 4:
                setProgress(100);
                hideLottie();
                return;
            case 5:
                setProgress(0);
                showPagAnim();
                return;
            case 6:
                setProgress(0);
                showPagAnim();
                return;
            default:
                return;
        }
    }

    private final void initSkin() {
        try {
            getPagAnim().setPath(VideoAppDownloadLottieRectViewKt.RECT_DOWNLOAD_PAG_PATH);
            showPagAnim();
            resetUi();
        } catch (Throwable th2) {
        }
    }

    public final void resetUi() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(getStateTextView(), R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
        getStateTextView().setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC84));
        FontSizeHelperKt.setVideoScaledSizeRes$default(getPagAnim(), R.dimen.video_flow_dimens_13dp, R.dimen.video_flow_dimens_16dp, 0, 0, 12, (Object) null);
        getProgressButton().setForeground(ContextCompat.getColor(getContext(), com.baidu.searchbox.feed.styles.R.color.FC135));
        getProgressButton().setRadius(R.dimen.video_flow_dimens_18dp);
    }

    private final void showPagAnim() {
        if (this.forceHidePag) {
            getPagAnim().setVisibility(8);
            return;
        }
        getPagAnim().setVisibility(0);
        post(new VideoAppDownloadLottieRectView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showPagAnim$lambda-0  reason: not valid java name */
    public static final void m10584showPagAnim$lambda0(VideoAppDownloadLottieRectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPagAnim().play();
    }

    private final void hideLottie() {
        getPagAnim().setVisibility(8);
        post(new VideoAppDownloadLottieRectView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: hideLottie$lambda-1  reason: not valid java name */
    public static final void m10583hideLottie$lambda1(VideoAppDownloadLottieRectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPagAnim().stop();
    }

    private final void updateText(String text) {
        getStateTextView().setText(text);
    }

    private final void setProgress(int progress) {
        getProgressButton().setProgressNoText(progress);
    }
}
