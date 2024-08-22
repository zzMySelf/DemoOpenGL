package com.baidu.searchbox.video.payment.player;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.callback.IUniversalPlayerCallback;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ErrorLayer;
import com.baidu.searchbox.video.detail.business.R;

public class VideoPaymentErrorLayer extends ErrorLayer {
    private TextView mUrlExpireErrorErrorTv;
    private LinearLayout mUrlExpireErrorView;

    public void onControlEventNotify(VideoEvent event) {
        if ("control_event_resume".equals(event.getAction()) || "control_event_show_tip".equals(event.getAction())) {
            hideUrlExpireError();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r5) {
        /*
            r4 = this;
            super.onLayerEventNotify(r5)
            java.lang.String r0 = r5.getAction()
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 0
            switch(r1) {
                case -552621273: goto L_0x0027;
                case -552580917: goto L_0x001c;
                case 2127287015: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0032
        L_0x0011:
            java.lang.String r1 = "layer_event_show_url_expire_error"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 2
            goto L_0x0033
        L_0x001c:
            java.lang.String r1 = "layer_event_switch_half"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r2
            goto L_0x0033
        L_0x0027:
            java.lang.String r1 = "layer_event_switch_full"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r3
            goto L_0x0033
        L_0x0032:
            r0 = -1
        L_0x0033:
            switch(r0) {
                case 0: goto L_0x0043;
                case 1: goto L_0x003b;
                case 2: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x004a
        L_0x0037:
            r4.showUrlExpireError()
            goto L_0x004a
        L_0x003b:
            android.widget.LinearLayout r0 = r4.mUrlExpireErrorView
            if (r0 == 0) goto L_0x004a
            r4.switchUrlExpireError(r3)
            goto L_0x004a
        L_0x0043:
            android.widget.LinearLayout r0 = r4.mUrlExpireErrorView
            if (r0 == 0) goto L_0x004a
            r4.switchUrlExpireError(r2)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.payment.player.VideoPaymentErrorLayer.onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        super.onPlayerStatusChanged(status, old);
        if (status == PlayerStatus.PLAYING || status == PlayerStatus.PREPARING) {
            hideUrlExpireError();
        }
    }

    /* access modifiers changed from: protected */
    public void showUrlExpireError() {
        if (this.mUrlExpireErrorView == null) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(this.mContext, R.layout.video_url_expire_error_layout, (ViewGroup) null);
            this.mUrlExpireErrorView = linearLayout;
            TextView textView = (TextView) linearLayout.findViewById(R.id.play_error_layout);
            this.mUrlExpireErrorErrorTv = textView;
            textView.setOnClickListener(this);
            this.mContainer.addView(this.mUrlExpireErrorView, new FrameLayout.LayoutParams(-1, -1));
        }
        this.mContainer.setVisibility(0);
        this.mUrlExpireErrorView.setVisibility(0);
        switchUrlExpireError(getBindPlayer().isFullMode());
    }

    /* access modifiers changed from: protected */
    public void hideUrlExpireError() {
        LinearLayout linearLayout = this.mUrlExpireErrorView;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
    }

    private void switchUrlExpireError(boolean isFullScreen) {
        Drawable[] kernelCompoundDrawables = this.mUrlExpireErrorErrorTv.getCompoundDrawables();
        if (isFullScreen) {
            this.mUrlExpireErrorErrorTv.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_14dp));
            kernelCompoundDrawables[1].setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(com.baidu.searchbox.videoplayer.business.R.dimen.dimens_47dp), this.mContext.getResources().getDimensionPixelOffset(com.baidu.searchbox.videoplayer.business.R.dimen.dimens_47dp));
        } else {
            this.mUrlExpireErrorErrorTv.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_12dp));
            kernelCompoundDrawables[1].setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_42dp), this.mContext.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_42dp));
        }
        this.mUrlExpireErrorErrorTv.setCompoundDrawables(kernelCompoundDrawables[0], kernelCompoundDrawables[1], kernelCompoundDrawables[2], kernelCompoundDrawables[3]);
    }

    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.play_error_layout && (getBindPlayer() instanceof VideoPaymentPlayer)) {
            IUniversalPlayerCallback baseVideoPlayerCallback = ((VideoPaymentPlayer) getBindPlayer()).getPlayerCallbackManager().getUniversalPlayerCallback();
            if (baseVideoPlayerCallback instanceof AbsVideoPaymentPlayerCallback) {
                ((AbsVideoPaymentPlayerCallback) baseVideoPlayerCallback).onVideoUrlExpire();
                this.mContainer.setVisibility(4);
                hideUrlExpireError();
                sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_CLICK_RETRY));
            }
        }
    }
}
