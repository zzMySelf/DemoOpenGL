package com.baidu.searchbox.video.feedflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u000e2\b\b\u0001\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/BottomUpSlideGuideView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "guideAnim", "Lorg/libpag/PAGView;", "guideText", "Landroid/widget/TextView;", "initGuideAnim", "", "initGuideText", "setFontAndPictureSize", "setGuideText", "text", "", "setGuideTextColor", "color", "setVisibility", "visibility", "updateFontSize", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomUpSlideGuideView.kt */
public final class BottomUpSlideGuideView extends LinearLayout {
    private PAGView guideAnim;
    private TextView guideText;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BottomUpSlideGuideView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BottomUpSlideGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomUpSlideGuideView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomUpSlideGuideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setGravity(17);
        initGuideAnim();
        initGuideText();
    }

    private final void initGuideAnim() {
        this.guideAnim = new PAGView(getContext());
        PAGView pAGView = null;
        int size = (int) FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_18dp, 0, 2, (Object) null);
        PAGView pAGView2 = this.guideAnim;
        if (pAGView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
            pAGView2 = null;
        }
        pAGView2.setLayoutParams(new LinearLayout.LayoutParams(size, size));
        PAGView pAGView3 = this.guideAnim;
        if (pAGView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
            pAGView3 = null;
        }
        pAGView3.setRepeatCount(-1);
        PAGView pAGView4 = this.guideAnim;
        if (pAGView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
        } else {
            pAGView = pAGView4;
        }
        addView(pAGView);
    }

    private final void initGuideText() {
        TextView textView;
        TextView textView2 = new TextView(getContext());
        this.guideText = textView2;
        LinearLayout.LayoutParams $this$initGuideText_u24lambda_u2d0 = new LinearLayout.LayoutParams(-2, -2);
        $this$initGuideText_u24lambda_u2d0.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_7dp);
        textView2.setLayoutParams($this$initGuideText_u24lambda_u2d0);
        TextView textView3 = this.guideText;
        TextView textView4 = null;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
            textView3 = null;
        }
        textView3.setText(getContext().getResources().getString(R.string.video_flow_attention_scroll_guide));
        TextView textView5 = this.guideText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
            textView5 = null;
        }
        textView5.setTextColor(ResourceUtils.getColor(getContext(), com.baidu.searchbox.feed.styles.R.color.FC6));
        TextView textView6 = this.guideText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
            textView = null;
        } else {
            textView = textView6;
        }
        FontSizeHelperKt.setVideoScaledSizeRes$default(textView, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
        TextView textView7 = this.guideText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
        } else {
            textView4 = textView7;
        }
        addView(textView4);
    }

    public final void setGuideText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.guideText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
            textView = null;
        }
        textView.setText(text);
    }

    public final void setFontAndPictureSize() {
        TextView textView;
        TextView textView2 = this.guideText;
        PAGView pAGView = null;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
            textView = null;
        } else {
            textView = textView2;
        }
        FontSizeHelperKt.setVideoScaledSizeRes$default(textView, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
        PAGView pAGView2 = this.guideAnim;
        if (pAGView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
        } else {
            pAGView = pAGView2;
        }
        FontSizeHelperKt.setVideoScaledSizeRes$default(pAGView, R.dimen.video_flow_dimens_18dp, R.dimen.video_flow_dimens_18dp, 0, 0, 12, (Object) null);
    }

    public final void setGuideTextColor(int color) {
        TextView textView = this.guideText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
            textView = null;
        }
        textView.setTextColor(color);
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        PAGView pAGView = null;
        if (visibility == 0) {
            PAGView pAGView2 = this.guideAnim;
            if (pAGView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
                pAGView2 = null;
            }
            pAGView2.stop();
            try {
                PAGView pAGView3 = this.guideAnim;
                if (pAGView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
                    pAGView3 = null;
                }
                pAGView3.setPath("assets://pag/video_flow_batch_guide_arrow.pag");
                PAGView pAGView4 = this.guideAnim;
                if (pAGView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
                    pAGView4 = null;
                }
                pAGView4.setRepeatCount(-1);
                PAGView pAGView5 = this.guideAnim;
                if (pAGView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
                } else {
                    pAGView = pAGView5;
                }
                pAGView.play();
            } catch (Exception e2) {
            }
        } else {
            PAGView pAGView6 = this.guideAnim;
            if (pAGView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
            } else {
                pAGView = pAGView6;
            }
            pAGView.stop();
        }
    }

    public final void updateFontSize() {
        TextView textView;
        PAGView pAGView = this.guideAnim;
        if (pAGView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideAnim");
            pAGView = null;
        }
        FontSizeHelperKt.setVideoScaledSizeRes$default(pAGView, R.dimen.video_flow_dimens_18dp, R.dimen.video_flow_dimens_18dp, 0, 0, 12, (Object) null);
        TextView textView2 = this.guideText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideText");
            textView = null;
        } else {
            textView = textView2;
        }
        FontSizeHelperKt.setVideoScaledSizeRes$default(textView, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
    }
}
