package com.baidu.searchbox.video.feedflow.detail.videosummarynew;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.videosummary.LeftBtnModel;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryLeftViewType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/videosummarynew/VideoSummaryLeftView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callBackListener", "Lcom/baidu/searchbox/video/feedflow/detail/videosummarynew/IVideoSummaryLeftViewListener;", "getCallBackListener", "()Lcom/baidu/searchbox/video/feedflow/detail/videosummarynew/IVideoSummaryLeftViewListener;", "setCallBackListener", "(Lcom/baidu/searchbox/video/feedflow/detail/videosummarynew/IVideoSummaryLeftViewListener;)V", "icon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "title", "Landroid/widget/TextView;", "type", "Lcom/baidu/searchbox/video/feedflow/detail/videosummary/VideoSummaryLeftViewType;", "bindData", "", "model", "Lcom/baidu/searchbox/video/feedflow/detail/videosummary/LeftBtnModel;", "resetToUnFold", "setFontAndPictureSize", "setMindMapType", "startFoldAnim", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSummaryLeftView.kt */
public final class VideoSummaryLeftView extends FrameLayout {
    private IVideoSummaryLeftViewListener callBackListener;
    private final SimpleDraweeView icon;
    private final TextView title;
    private VideoSummaryLeftViewType type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoSummaryLeftView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoSummaryLeftViewType.values().length];
            iArr[VideoSummaryLeftViewType.MIND_TYPE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoSummaryLeftView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoSummaryLeftView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoSummaryLeftView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoSummaryLeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = VideoSummaryLeftViewType.NULL;
        LayoutInflater.from(context).inflate(R.layout.video_summary_left_view, this, true);
        View findViewById = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.iv_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_btn)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById2;
        this.icon = simpleDraweeView;
        GenericDraweeHierarchy $this$_init__u24lambda_u2d0 = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        if ($this$_init__u24lambda_u2d0 != null) {
            $this$_init__u24lambda_u2d0.setPlaceholderImage(R.drawable.video_flow_mind_map_icon);
            $this$_init__u24lambda_u2d0.setUseGlobalColorFilter(false);
        }
        setOnClickListener(new VideoSummaryLeftView$$ExternalSyntheticLambda1(this));
        setFontAndPictureSize();
    }

    public final IVideoSummaryLeftViewListener getCallBackListener() {
        return this.callBackListener;
    }

    public final void setCallBackListener(IVideoSummaryLeftViewListener iVideoSummaryLeftViewListener) {
        this.callBackListener = iVideoSummaryLeftViewListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m5923_init_$lambda1(VideoSummaryLeftView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IVideoSummaryLeftViewListener iVideoSummaryLeftViewListener = this$0.callBackListener;
        if (iVideoSummaryLeftViewListener != null) {
            iVideoSummaryLeftViewListener.onContainerClick(this$0.type);
        }
    }

    public final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.icon, R.dimen.video_flow_dimens_12dp, R.dimen.video_flow_dimens_12dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.title, R.dimen.video_flow_dimens_13dp, 0, 0, 6, (Object) null);
    }

    public final void bindData(LeftBtnModel model) {
        if (model == null) {
            setVisibility(8);
            return;
        }
        this.type = model.getType();
        if (model.isTitleFold()) {
            this.title.setVisibility(8);
        } else {
            resetToUnFold();
            this.title.setVisibility(0);
        }
        if (WhenMappings.$EnumSwitchMapping$0[model.getType().ordinal()] == 1) {
            setMindMapType();
        } else {
            setVisibility(8);
        }
    }

    private final void setMindMapType() {
        this.title.setText(getContext().getResources().getString(R.string.video_flow_video_summary_mind_map));
        setVisibility(0);
    }

    public final void startFoldAnim() {
        ValueAnimator widthAnimator = ValueAnimator.ofInt(new int[]{this.title.getMeasuredWidth(), 0});
        widthAnimator.setDuration(240);
        widthAnimator.addUpdateListener(new VideoSummaryLeftView$$ExternalSyntheticLambda0(this));
        widthAnimator.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: startFoldAnim$lambda-2  reason: not valid java name */
    public static final void m5924startFoldAnim$lambda2(VideoSummaryLeftView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup.LayoutParams floatNextPageTipLp = this$0.title.getLayoutParams();
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            floatNextPageTipLp.width = ((Integer) animatedValue).intValue();
            this$0.title.setLayoutParams(floatNextPageTipLp);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void resetToUnFold() {
        ViewGroup.LayoutParams layoutParams = this.title.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.width = -2;
        }
        this.title.requestLayout();
    }
}
