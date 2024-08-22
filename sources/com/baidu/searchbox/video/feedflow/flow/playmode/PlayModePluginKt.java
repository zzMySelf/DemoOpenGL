package com.baidu.searchbox.video.feedflow.flow.playmode;

import android.content.Context;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.common.SwitchUpdatePerformer;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfigKt;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0006\u001a\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u001a\u0010\u0010\b\u001a\u00020\t*\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u001a\u0010\u0010\n\u001a\u00020\t*\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u001a\u0010\u0010\u000b\u001a\u00020\t*\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u001a \u0010\f\u001a\u00020\r*\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"AI_PLAY_MODE_VIDEO_DURATION", "", "TAG", "", "getCurPlayMode", "Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "isCurPlayModeAi", "", "isCurPlayModeContinue", "isCurPlayModeLoop", "showPlayModeToast", "", "context", "Landroid/content/Context;", "playMode", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayModePlugin.kt */
public final class PlayModePluginKt {
    private static final int AI_PLAY_MODE_VIDEO_DURATION = 15;
    private static final String TAG = "PlayModePlugin";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlayModePlugin.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayMode.values().length];
            iArr[PlayMode.CONTINUE_PLAY.ordinal()] = 1;
            iArr[PlayMode.LOOP_PLAY.ordinal()] = 2;
            iArr[PlayMode.AI_PLAY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void showPlayModeToast(Store<?> $this$showPlayModeToast, Context context, PlayMode playMode) {
        String toastStr;
        Store<?> store = $this$showPlayModeToast;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(playMode, IntentData.KEY_COLLECTION_MODE);
        if (store != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[playMode.ordinal()]) {
                case 1:
                    toastStr = context2.getString(R.string.video_flow_autoplay_open);
                    break;
                case 2:
                    toastStr = context2.getString(R.string.video_flow_autoplay_close);
                    break;
                case 3:
                    toastStr = context2.getString(R.string.video_flow_ai_play_open);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullExpressionValue(toastStr, "when (playMode) {\n      …_flow_ai_play_open)\n    }");
            StoreExtKt.post(store, new ToastAction.Show(0, toastStr, 0, ToastAction.App.INSTANCE, (ToastLocation) null, (ToastTemplate) null, 0, 0, (CharSequence) null, (ToastRightAreaStyle) null, (Action) null, IMConstants.IM_MSG_TYPE_FAST_SHIELD, (DefaultConstructorMarker) null));
        }
    }

    public static final PlayMode getCurPlayMode(Store<?> $this$getCurPlayMode) {
        CommonState commonState = null;
        Object state = $this$getCurPlayMode != null ? $this$getCurPlayMode.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return getCurPlayMode(commonState);
    }

    public static final boolean isCurPlayModeLoop(Store<?> $this$isCurPlayModeLoop) {
        CommonState commonState = null;
        Object state = $this$isCurPlayModeLoop != null ? $this$isCurPlayModeLoop.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return getCurPlayMode(commonState) == PlayMode.LOOP_PLAY;
    }

    public static final boolean isCurPlayModeAi(Store<?> $this$isCurPlayModeAi) {
        CommonState commonState = null;
        Object state = $this$isCurPlayModeAi != null ? $this$isCurPlayModeAi.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return getCurPlayMode(commonState) == PlayMode.AI_PLAY;
    }

    public static final boolean isCurPlayModeContinue(Store<?> $this$isCurPlayModeContinue) {
        CommonState commonState = null;
        Object state = $this$isCurPlayModeContinue != null ? $this$isCurPlayModeContinue.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return getCurPlayMode(commonState) == PlayMode.CONTINUE_PLAY;
    }

    public static final PlayMode getCurPlayMode(CommonState $this$getCurPlayMode) {
        boolean isCurAiPlayMode;
        SwitchUpdatePerformer switchUpdatePerformer = FlowSwitchStateKt.flowSwitchState($this$getCurPlayMode).getSwitchUpdatePerformer();
        if (switchUpdatePerformer != null) {
            isCurAiPlayMode = switchUpdatePerformer.isCurAiPlayMode();
        } else {
            isCurAiPlayMode = DIFactory.INSTANCE.getConfig().isCurAiPlayMode();
        }
        if (isCurAiPlayMode) {
            return PlayMode.AI_PLAY;
        }
        return AutoplayConfigKt.findAutoplaySwitch($this$getCurPlayMode) ? PlayMode.CONTINUE_PLAY : PlayMode.LOOP_PLAY;
    }
}
