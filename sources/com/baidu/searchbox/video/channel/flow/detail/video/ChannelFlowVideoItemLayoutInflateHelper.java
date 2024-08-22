package com.baidu.searchbox.video.channel.flow.detail.video;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J0\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/detail/video/ChannelFlowVideoItemLayoutInflateHelper;", "", "()V", "DEFAULT_COMBO_PRAISE_INDEX", "", "GESTURE_INDEX", "LANDSCAPE_ROOT_INDEX", "LONG_PRESS_SPEED_INDEX", "MASK_INDEX", "NET_ERROR_INDEX", "OFFLINE_INDEX", "PLAYER_INDEX", "PORTRAIT_ROOT_INDEX", "POSTER_INDEX", "addViewToContainer", "", "container", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "index", "addViewToRootContainer", "rootContainer", "id", "before", "Lkotlin/Function0;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowVideoItemLayoutInflateHelper.kt */
public final class ChannelFlowVideoItemLayoutInflateHelper {
    private static final int DEFAULT_COMBO_PRAISE_INDEX = 3;
    private static final int GESTURE_INDEX = 0;
    public static final ChannelFlowVideoItemLayoutInflateHelper INSTANCE = new ChannelFlowVideoItemLayoutInflateHelper();
    private static final int LANDSCAPE_ROOT_INDEX = 8;
    private static final int LONG_PRESS_SPEED_INDEX = 9;
    private static final int MASK_INDEX = 6;
    private static final int NET_ERROR_INDEX = 4;
    private static final int OFFLINE_INDEX = 5;
    private static final int PLAYER_INDEX = 2;
    private static final int PORTRAIT_ROOT_INDEX = 7;
    private static final int POSTER_INDEX = 1;

    private ChannelFlowVideoItemLayoutInflateHelper() {
    }

    public static /* synthetic */ void addViewToRootContainer$default(ChannelFlowVideoItemLayoutInflateHelper channelFlowVideoItemLayoutInflateHelper, ViewGroup viewGroup, View view2, int i2, Function0 function0, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        channelFlowVideoItemLayoutInflateHelper.addViewToRootContainer(viewGroup, view2, i2, function0);
    }

    public final void addViewToRootContainer(ViewGroup rootContainer, View view2, int id, Function0<Unit> before) {
        Intrinsics.checkNotNullParameter(rootContainer, "rootContainer");
        Intrinsics.checkNotNullParameter(view2, "view");
        if (before != null) {
            before.invoke();
        }
        if (id == R.id.video_flow_cmp_gesture) {
            addViewToContainer(rootContainer, view2, 0);
        } else if (id == R.id.video_flow_cmp_poster) {
            addViewToContainer(rootContainer, view2, 1);
        } else if (id == R.id.video_flow_cmp_player) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addViewToContainer(rootContainer, view2, 2);
        } else if (id == R.id.video_flow_cmp_default_combo_praise) {
            addViewToContainer(rootContainer, view2, 3);
        } else if (id == R.id.video_flow_cmp_net_error) {
            addViewToContainer(rootContainer, view2, 4);
        } else if (id == R.id.video_flow_cmp_offline) {
            addViewToContainer(rootContainer, view2, 5);
        } else if (id == R.id.video_flow_cmp_mask) {
            addViewToContainer(rootContainer, view2, 6);
        } else if (id == R.id.video_item_portrait_root) {
            addViewToContainer(rootContainer, view2, 7);
        } else if (id == R.id.video_item_landscape_root) {
            addViewToContainer(rootContainer, view2, 8);
        } else if (id == R.id.video_flow_cmp_long_press_speed) {
            addViewToContainer(rootContainer, view2, 9);
        } else {
            rootContainer.addView(view2);
        }
    }

    private final void addViewToContainer(ViewGroup container, View view2, int index) {
        container.addView(view2, index > container.getChildCount() ? container.getChildCount() : index);
    }
}
