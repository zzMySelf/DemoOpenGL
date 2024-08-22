package com.baidu.searchbox.video.feedflow.detail.personalizedtips;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\u0012\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/personalizedtips/PersonalizedTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buttonLoading", "Lorg/libpag/PAGView;", "buttonTxt", "Landroid/widget/TextView;", "container", "listener", "Lcom/baidu/searchbox/video/feedflow/detail/personalizedtips/PersonalizedTipsView$IPersonalizedTipsListener;", "getListener", "()Lcom/baidu/searchbox/video/feedflow/detail/personalizedtips/PersonalizedTipsView$IPersonalizedTipsListener;", "setListener", "(Lcom/baidu/searchbox/video/feedflow/detail/personalizedtips/PersonalizedTipsView$IPersonalizedTipsListener;)V", "queryText", "tipsButton", "Landroid/widget/FrameLayout;", "tipsSuffix", "bindData", "", "query", "", "onFontSizeChange", "release", "toggleButtonState", "state", "", "IPersonalizedTipsListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalizedTipsView.kt */
public final class PersonalizedTipsView extends RelativeLayout {
    private PAGView buttonLoading = ((PAGView) findViewById(R.id.personalized_tips_button_loading));
    private TextView buttonTxt = ((TextView) findViewById(R.id.personalized_tips_button_txt));
    private RelativeLayout container = ((RelativeLayout) findViewById(R.id.personalized_tips_container));
    private IPersonalizedTipsListener listener;
    private TextView queryText = ((TextView) findViewById(R.id.personalized_tips_query));
    private FrameLayout tipsButton = ((FrameLayout) findViewById(R.id.personalized_tips_button));
    private TextView tipsSuffix = ((TextView) findViewById(R.id.personalized_tips_suffix));

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/personalizedtips/PersonalizedTipsView$IPersonalizedTipsListener;", "", "onClick", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalizedTipsView.kt */
    public interface IPersonalizedTipsListener {
        void onClick();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalizedTipsView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.video_flow_personalized_tips_view, this);
        setVisibility(8);
        PAGView $this$_init__u24lambda_u2d0 = this.buttonLoading;
        if ($this$_init__u24lambda_u2d0 != null) {
            $this$_init__u24lambda_u2d0.setPath("assets://pag/video_flow_personalized_tips_loading_lottie.pag");
            $this$_init__u24lambda_u2d0.setRepeatCount(-1);
        }
        onFontSizeChange();
    }

    public final IPersonalizedTipsListener getListener() {
        return this.listener;
    }

    public final void setListener(IPersonalizedTipsListener iPersonalizedTipsListener) {
        this.listener = iPersonalizedTipsListener;
    }

    public final void bindData(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        setVisibility(0);
        TextView textView = this.queryText;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.video_flow_personalized_tips_query_text);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…onalized_tips_query_text)");
            String format = String.format(string, Arrays.copyOf(new Object[]{query}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
        toggleButtonState(0);
        FrameLayout frameLayout = this.tipsButton;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new PersonalizedTipsView$$ExternalSyntheticLambda0(this));
        }
        setOnClickListener(new PersonalizedTipsView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-1  reason: not valid java name */
    public static final void m12151bindData$lambda1(PersonalizedTipsView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PAGView pAGView = this$0.buttonLoading;
        boolean z = false;
        if (pAGView != null && pAGView.getVisibility() == 0) {
            z = true;
        }
        if (!z) {
            IPersonalizedTipsListener iPersonalizedTipsListener = this$0.listener;
            if (iPersonalizedTipsListener != null) {
                iPersonalizedTipsListener.onClick();
            }
            this$0.toggleButtonState(1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-2  reason: not valid java name */
    public static final void m12152bindData$lambda2(PersonalizedTipsView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PAGView pAGView = this$0.buttonLoading;
        boolean z = false;
        if (pAGView != null && pAGView.getVisibility() == 0) {
            z = true;
        }
        if (!z) {
            IPersonalizedTipsListener iPersonalizedTipsListener = this$0.listener;
            if (iPersonalizedTipsListener != null) {
                iPersonalizedTipsListener.onClick();
            }
            this$0.toggleButtonState(1);
        }
    }

    static /* synthetic */ void toggleButtonState$default(PersonalizedTipsView personalizedTipsView, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        personalizedTipsView.toggleButtonState(i2);
    }

    private final void toggleButtonState(int state) {
        switch (state) {
            case 0:
                PAGView pAGView = this.buttonLoading;
                if (pAGView != null) {
                    pAGView.setVisibility(8);
                }
                PAGView pAGView2 = this.buttonLoading;
                if (pAGView2 != null) {
                    pAGView2.stop();
                }
                TextView textView = this.buttonTxt;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            case 1:
                TextView textView2 = this.buttonTxt;
                if (textView2 != null) {
                    textView2.setVisibility(4);
                }
                PAGView pAGView3 = this.buttonLoading;
                if (pAGView3 != null) {
                    pAGView3.setVisibility(0);
                }
                PAGView pAGView4 = this.buttonLoading;
                if (pAGView4 != null) {
                    pAGView4.play();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void onFontSizeChange() {
        TextView textView = this.queryText;
        if (textView != null) {
            FontSizeHelperKt.setVideoScaledSizeRes$default(textView, com.baidu.searchbox.feed.styles.R.dimen.F_T_X002, 0, 0, 6, (Object) null);
        }
        TextView textView2 = this.tipsSuffix;
        if (textView2 != null) {
            FontSizeHelperKt.setVideoScaledSizeRes$default(textView2, com.baidu.searchbox.feed.styles.R.dimen.F_T_X002, 0, 0, 6, (Object) null);
        }
        TextView textView3 = this.buttonTxt;
        if (textView3 != null) {
            FontSizeHelperKt.setVideoScaledSizeRes$default(textView3, com.baidu.searchbox.feed.styles.R.dimen.F_T_X041, 0, 0, 6, (Object) null);
        }
        View view2 = this.buttonLoading;
        if (view2 != null) {
            FontSizeHelperKt.setVideoScaledSizeRes$default(view2, com.baidu.searchbox.feed.styles.R.dimen.F_T_X041, com.baidu.searchbox.feed.styles.R.dimen.F_T_X041, 0, 0, 12, (Object) null);
        }
        float paddingTop = getContext().getResources().getDimension(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X084);
        float containerPaddingTop = getContext().getResources().getDimension(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X083);
        float containerPadding = getContext().getResources().getDimension(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X034);
        FrameLayout $this$onFontSizeChange_u24lambda_u2d3 = this.tipsButton;
        if ($this$onFontSizeChange_u24lambda_u2d3 != null) {
            FontSizeHelperKt.setVideoScaledPadding$default($this$onFontSizeChange_u24lambda_u2d3, containerPadding, paddingTop, containerPadding, paddingTop, 0, 0, 48, (Object) null);
        }
        RelativeLayout $this$onFontSizeChange_u24lambda_u2d4 = this.container;
        if ($this$onFontSizeChange_u24lambda_u2d4 != null) {
            FontSizeHelperKt.setVideoScaledPadding$default($this$onFontSizeChange_u24lambda_u2d4, containerPadding, containerPaddingTop, containerPadding, containerPaddingTop, 0, 0, 48, (Object) null);
        }
        FrameLayout frameLayout = this.tipsButton;
        GradientDrawable gradientDrawable = null;
        Drawable background = frameLayout != null ? frameLayout.getBackground() : null;
        GradientDrawable gradientDrawable2 = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setCornerRadius(FontSizeHelper.getScaledSize(0, DeviceUtils.ScreenInfo.dp2pxf(getContext(), 14.0f)));
        }
        RelativeLayout relativeLayout = this.container;
        Object background2 = relativeLayout != null ? relativeLayout.getBackground() : null;
        if (background2 instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background2;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(FontSizeHelper.getScaledSize(0, DeviceUtils.ScreenInfo.dp2pxf(getContext(), 10.0f)));
        }
    }

    public final void release() {
        PAGView pAGView = this.buttonLoading;
        if (pAGView != null) {
            pAGView.stop();
        }
    }
}
