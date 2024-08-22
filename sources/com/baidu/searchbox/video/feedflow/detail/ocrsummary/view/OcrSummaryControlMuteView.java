package com.baidu.searchbox.video.feedflow.detail.ocrsummary.view;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/view/OcrSummaryControlMuteView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "curImageResource", "", "changeIcon", "", "isMute", "", "isMuteStatus", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrSummaryPlayControlView.kt */
public final class OcrSummaryControlMuteView extends AppCompatImageView {
    private int curImageResource = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OcrSummaryControlMuteView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void changeIcon(boolean isMute) {
        int i2;
        if (isMute) {
            i2 = R.drawable.video_flow_player_mute_icon;
        } else {
            i2 = R.drawable.video_flow_player_unmute_icon;
        }
        this.curImageResource = i2;
        setImageResource(i2);
    }

    public final boolean isMuteStatus() {
        return this.curImageResource == R.drawable.video_flow_player_mute_icon;
    }
}
