package com.baidu.searchbox.video.template.live.player;

import android.widget.TextView;
import com.baidu.searchbox.player.layer.ErrorLayer;
import com.baidu.searchbox.video.template.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/template/live/player/ChannelLiveErrorLayer;", "Lcom/baidu/searchbox/player/layer/ErrorLayer;", "()V", "showKernelError", "", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelLiveErrorLayer.kt */
public final class ChannelLiveErrorLayer extends ErrorLayer {
    /* access modifiers changed from: protected */
    public void showKernelError() {
        super.showKernelError();
        TextView textView = this.mKernelErrorTv;
        if (textView != null) {
            textView.setText(this.mContext.getString(R.string.video_tab_live_player_error_text));
        }
    }
}
