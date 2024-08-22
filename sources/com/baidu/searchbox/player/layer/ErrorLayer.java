package com.baidu.searchbox.player.layer;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.ubc.IErrorLayerUbcDispatcher;
import com.baidu.searchbox.player.utils.BdNetUtils;
import com.baidu.searchbox.video.videoplayer.event.LayerShowEvent;
import com.baidu.searchbox.videoplayer.framework.R;

public class ErrorLayer extends BasePlayerLayer implements View.OnClickListener {
    private boolean isNeedNetErrorView = true;
    private boolean isShowNetErrorToast;
    protected FrameLayout mContainer;
    protected TextView mKernelErrorTv;
    protected LinearLayout mKernelErrorView;
    private Button mNetErrorRetryBtn;
    private TextView mNetErrorTv;
    protected LinearLayout mNetErrorView;

    public ErrorLayer() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setVisibility(4);
    }

    public View getContentView() {
        return this.mContainer;
    }

    public void onPlayerEventNotify(VideoEvent event) {
        if ("player_event_on_error".equals(event.getAction()) && !getBindPlayer().isFloatingMode()) {
            onPlayerError(event);
        }
    }

    public void onControlEventNotify(VideoEvent event) {
        if ("control_event_resume".equals(event.getAction()) || "control_event_show_tip".equals(event.getAction()) || "control_event_start".equals(event.getAction())) {
            getBindPlayer().getPlayerCallbackManager().onLayerDismiss(this);
            hideKernelError();
            hideNetError();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getAction()
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 0
            switch(r1) {
                case -552621273: goto L_0x0036;
                case -552580917: goto L_0x002c;
                case 162783179: goto L_0x0022;
                case 1147160494: goto L_0x0018;
                case 1409909918: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0040
        L_0x000e:
            java.lang.String r1 = "layer_event_switch_floating"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 2
            goto L_0x0041
        L_0x0018:
            java.lang.String r1 = "layer_event_update_font_size"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 4
            goto L_0x0041
        L_0x0022:
            java.lang.String r1 = "layer_event_show_error_layer"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 3
            goto L_0x0041
        L_0x002c:
            java.lang.String r1 = "layer_event_switch_half"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r2
            goto L_0x0041
        L_0x0036:
            java.lang.String r1 = "layer_event_switch_full"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r3
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            switch(r0) {
                case 0: goto L_0x009e;
                case 1: goto L_0x008f;
                case 2: goto L_0x0088;
                case 3: goto L_0x0070;
                case 4: goto L_0x0045;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x00ac
        L_0x0045:
            android.widget.LinearLayout r0 = r4.mNetErrorView
            if (r0 == 0) goto L_0x005a
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x005a
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r4.getBindPlayer()
            boolean r0 = r0.isFullMode()
            r4.switchNetError(r0)
        L_0x005a:
            android.widget.LinearLayout r0 = r4.mKernelErrorView
            if (r0 == 0) goto L_0x00ac
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00ac
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r4.getBindPlayer()
            boolean r0 = r0.isFullMode()
            r4.switchKernelError(r0)
            goto L_0x00ac
        L_0x0070:
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r4.getBindPlayer()
            boolean r0 = r0.isError()
            if (r0 == 0) goto L_0x00ac
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r4.getBindPlayer()
            boolean r0 = r0.isFloatingMode()
            if (r0 != 0) goto L_0x00ac
            r4.showErrorContainer()
            goto L_0x00ac
        L_0x0088:
            r4.hideKernelError()
            r4.hideNetError()
            goto L_0x00ac
        L_0x008f:
            android.widget.LinearLayout r0 = r4.mNetErrorView
            if (r0 == 0) goto L_0x0096
            r4.switchNetError(r3)
        L_0x0096:
            android.widget.LinearLayout r0 = r4.mKernelErrorView
            if (r0 == 0) goto L_0x00ac
            r4.switchKernelError(r3)
            goto L_0x00ac
        L_0x009e:
            android.widget.LinearLayout r0 = r4.mNetErrorView
            if (r0 == 0) goto L_0x00a5
            r4.switchNetError(r2)
        L_0x00a5:
            android.widget.LinearLayout r0 = r4.mKernelErrorView
            if (r0 == 0) goto L_0x00ac
            r4.switchKernelError(r2)
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.ErrorLayer.onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        super.onPlayerStatusChanged(status, old);
        if (status == PlayerStatus.PLAYING || status == PlayerStatus.PREPARING) {
            getBindPlayer().getPlayerCallbackManager().onLayerDismiss(this);
            hideNetError();
            hideKernelError();
        }
    }

    /* access modifiers changed from: protected */
    public void setContainerVisible(boolean isVisible) {
        this.mContainer.setVisibility(isVisible ? 0 : 4);
    }

    /* access modifiers changed from: protected */
    public void showErrorContainer() {
        setContainerVisible(true);
        getBindPlayer().getPlayerCallbackManager().onLayerShow(this);
        if (!BdNetUtils.isNetUp()) {
            showNetError();
            hideKernelError();
        } else {
            showKernelError();
            hideNetError();
        }
        BdEventBus.Companion.getDefault().post(new LayerShowEvent(LayerShowEvent.ERROR_LAYER));
    }

    /* access modifiers changed from: protected */
    public void onPlayerError(VideoEvent event) {
        showErrorContainer();
    }

    /* access modifiers changed from: protected */
    public void showNetError() {
        if (this.isNeedNetErrorView) {
            if (this.mNetErrorView == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.mContext, R.layout.bdvideoplayer_layout_net_error, (ViewGroup) null);
                this.mNetErrorView = linearLayout;
                this.mNetErrorTv = (TextView) linearLayout.findViewById(com.baidu.searchbox.videoplayer.ui.R.id.tv_error);
                Button button = (Button) this.mNetErrorView.findViewById(com.baidu.searchbox.videoplayer.business.R.id.bt_retry);
                this.mNetErrorRetryBtn = button;
                button.setOnClickListener(this);
                this.mContainer.addView(this.mNetErrorView, new FrameLayout.LayoutParams(-1, -1));
            }
            switchNetError(getBindPlayer().isFullMode());
            sendEvent(LayerEvent.obtainEvent("layer_event_net_error_show"));
            this.mNetErrorView.setVisibility(0);
            getBindPlayer().getPlayerCallbackManager().onPanelVisibilityChanged(true);
        }
    }

    private void hideNetError() {
        LinearLayout linearLayout = this.mNetErrorView;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void showKernelError() {
        if (this.mKernelErrorView == null) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(this.mContext, R.layout.bdvideoplayer_layout_kernel_error, (ViewGroup) null);
            this.mKernelErrorView = linearLayout;
            TextView textView = (TextView) linearLayout.findViewById(com.baidu.searchbox.videoplayer.business.R.id.play_error_layout_retry);
            this.mKernelErrorTv = textView;
            textView.setOnClickListener(this);
            this.mContainer.addView(this.mKernelErrorView, new FrameLayout.LayoutParams(-1, -1));
        }
        this.mKernelErrorTv.setText(R.string.bdvideoplayer_tip_kernel_error);
        switchKernelError(getBindPlayer().isFullMode());
        this.mKernelErrorView.setVisibility(0);
    }

    private void hideKernelError() {
        LinearLayout linearLayout = this.mKernelErrorView;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private IErrorLayerUbcDispatcher getStatDispatcher() {
        return getBindPlayer().getStatDispatcher();
    }

    public int[] getSubscribeEvent() {
        return new int[]{4, 5, 2, 3};
    }

    public void onClick(View v) {
        if (v.getId() == com.baidu.searchbox.videoplayer.business.R.id.bt_retry || v.getId() == com.baidu.searchbox.videoplayer.business.R.id.play_error_layout_retry) {
            if (!BdNetUtils.isNetUp()) {
                View holder = getBindPlayer().getAttachedContainer();
                if (holder != null) {
                    if (getBindPlayer().getStrategy().isShowNetErrorToast()) {
                        UniversalToast.makeText(holder.getContext(), R.string.bdvideoplayer_tip_net_error).showToast();
                    }
                } else {
                    return;
                }
            } else {
                hideKernelError();
                hideNetError();
                setContainerVisible(false);
                resumePlayer();
                sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_CLICK_RETRY));
            }
            if (getStatDispatcher() != null) {
                getStatDispatcher().reload();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resumePlayer() {
        getBindPlayer().resumeFromError();
    }

    private void switchNetError(boolean isFullScreen) {
        LinearLayout.LayoutParams retryParams = (LinearLayout.LayoutParams) this.mNetErrorRetryBtn.getLayoutParams();
        if (isFullScreen) {
            FontSizeTextViewExtKt.setScaledSizeRes(this.mNetErrorTv, 0, R.dimen.bdvideoplayer_dimens_14dp);
            this.mNetErrorRetryBtn.setTextSize(1, FontSizeHelper.getScaledSize(0, 14.0f));
            int leftRightPadding = this.mContext.getResources().getDimensionPixelOffset(R.dimen.bdvideoplayer_dimens_20dp);
            int topBottomPadding = this.mContext.getResources().getDimensionPixelOffset(R.dimen.bdvideoplayer_dimens_8dp);
            this.mNetErrorRetryBtn.setPadding(leftRightPadding, topBottomPadding, leftRightPadding, topBottomPadding);
            retryParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.bdvideoplayer_dimens_31dp);
        } else {
            FontSizeTextViewExtKt.setScaledSizeRes(this.mNetErrorTv, 0, R.dimen.bdvideoplayer_dimens_12dp);
            this.mNetErrorRetryBtn.setTextSize(1, FontSizeHelper.getScaledSize(0, 12.0f));
            int leftRightPadding2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.bdvideoplayer_dimens_8dp);
            int topBottomPadding2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.bdvideoplayer_dimens_6dp);
            this.mNetErrorRetryBtn.setPadding(leftRightPadding2, topBottomPadding2, leftRightPadding2, topBottomPadding2);
            retryParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.bdvideoplayer_dimens_24dp);
        }
        this.mNetErrorRetryBtn.setLayoutParams(retryParams);
    }

    private void switchKernelError(boolean isFullScreen) {
        Drawable[] kernelCompoundDrawables = this.mKernelErrorTv.getCompoundDrawables();
        if (isFullScreen) {
            FontSizeTextViewExtKt.setScaledSizeRes(this.mKernelErrorTv, 0, R.dimen.bdvideoplayer_dimens_14dp);
            kernelCompoundDrawables[1].setBounds(0, 0, (int) FontSizeHelper.getScaledSizeRes(0, com.baidu.searchbox.videoplayer.business.R.dimen.dimens_47dp), (int) FontSizeHelper.getScaledSizeRes(0, com.baidu.searchbox.videoplayer.business.R.dimen.dimens_47dp));
        } else {
            FontSizeTextViewExtKt.setScaledSizeRes(this.mKernelErrorTv, 0, R.dimen.bdvideoplayer_dimens_12dp);
            kernelCompoundDrawables[1].setBounds(0, 0, (int) FontSizeHelper.getScaledSizeRes(0, com.baidu.searchbox.videoplayer.business.R.dimen.dimens_42dp), (int) FontSizeHelper.getScaledSizeRes(0, com.baidu.searchbox.videoplayer.business.R.dimen.dimens_42dp));
        }
        this.mKernelErrorTv.setCompoundDrawables(kernelCompoundDrawables[0], kernelCompoundDrawables[1], kernelCompoundDrawables[2], kernelCompoundDrawables[3]);
    }

    public boolean isShow() {
        LinearLayout linearLayout = this.mNetErrorView;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void setIsNeedNetErrorView(boolean isNeedNetError) {
        this.isNeedNetErrorView = isNeedNetError;
    }
}
