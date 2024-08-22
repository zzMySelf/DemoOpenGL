package com.baidu.searchbox.video.payment.player;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.element.ControlLayerElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ElementLayer;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0017J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/payment/player/VideoPaymentLimitFreeTipsElement;", "Lcom/baidu/searchbox/player/element/ControlLayerElement;", "()V", "container", "Landroid/view/View;", "freeTipsText", "Landroid/widget/TextView;", "beginCountDownTimer", "", "getContentView", "handleLayerMessage", "msg", "Landroid/os/Message;", "initElement", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "togglePanelVisible", "isVisible", "", "isBubbleShow", "updateViewPosition", "isPanelVisible", "Companion", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPaymentLimitFreeTipsElement.kt */
public final class VideoPaymentLimitFreeTipsElement extends ControlLayerElement {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MSG_HIDE_TIP = 1100;
    private static final long TIP_SHOW_DURATION = 5000;
    private View container;
    private TextView freeTipsText;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/payment/player/VideoPaymentLimitFreeTipsElement$Companion;", "", "()V", "MSG_HIDE_TIP", "", "TIP_SHOW_DURATION", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoPaymentLimitFreeTipsElement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public View getContentView() {
        View view2 = this.container;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("container");
        return null;
    }

    public void initElement() {
        View view2 = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.video_payment_limit_free_tips_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…mit_free_tips_view, null)");
        this.container = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        } else {
            view2 = inflate;
        }
        View $this$initElement_u24lambda_u2d0 = view2;
        this.freeTipsText = (TextView) $this$initElement_u24lambda_u2d0.findViewById(R.id.video_payment_free_tips);
        $this$initElement_u24lambda_u2d0.setVisibility(8);
    }

    public void onEventNotify(VideoEvent event) {
        String tips;
        Intrinsics.checkNotNullParameter(event, "event");
        super.onEventNotify(event);
        String action = event.getAction();
        View view2 = null;
        switch (action.hashCode()) {
            case -819959289:
                if (action.equals(LayerEvent.ACTION_SHOW_LIMIT_FREE_TIPS) && (tips = event.getStringExtra(23, (String) null)) != null) {
                    String freeTips = tips;
                    View view3 = this.container;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                    } else {
                        view2 = view3;
                    }
                    view2.setVisibility(0);
                    TextView textView = this.freeTipsText;
                    if (textView != null) {
                        textView.setText(freeTips);
                    }
                    beginCountDownTimer();
                    return;
                }
                return;
            case 154871702:
                if (!action.equals("player_event_on_complete")) {
                    return;
                }
                break;
            case 723345051:
                if (!action.equals("control_event_start")) {
                    return;
                }
                break;
            default:
                return;
        }
        View view4 = this.container;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        } else {
            view2 = view4;
        }
        view2.setVisibility(4);
    }

    private final void beginCountDownTimer() {
        Handler handlerInnerLayer;
        ElementLayer elementLayer = this.mParent;
        if (elementLayer != null && (handlerInnerLayer = elementLayer.getHandlerInnerLayer()) != null) {
            handlerInnerLayer.sendEmptyMessageDelayed(1100, 5000);
        }
    }

    public void handleLayerMessage(Message msg) {
        Handler handlerInnerLayer;
        if (msg != null && msg.what == 1100) {
            View view2 = this.container;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                view2 = null;
            }
            view2.setVisibility(8);
            ElementLayer elementLayer = this.mParent;
            if (elementLayer != null && (handlerInnerLayer = elementLayer.getHandlerInnerLayer()) != null) {
                handlerInnerLayer.removeMessages(1100);
            }
        }
    }

    public void togglePanelVisible(boolean isVisible, boolean isBubbleShow) {
        updateViewPosition(isVisible);
    }

    private final void updateViewPosition(boolean isPanelVisible) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.rightMargin = IVideoScreenInfoUtils.Impl.get().dp2px(17.0f);
        if (isPanelVisible) {
            params.bottomMargin = IVideoScreenInfoUtils.Impl.get().dp2px(35.0f);
        } else {
            params.bottomMargin = IVideoScreenInfoUtils.Impl.get().dp2px(11.0f);
        }
        params.gravity = 8388693;
        View view2 = this.container;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            view2 = null;
        }
        view2.setLayoutParams(params);
    }
}
