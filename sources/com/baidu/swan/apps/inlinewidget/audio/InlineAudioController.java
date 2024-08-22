package com.baidu.swan.apps.inlinewidget.audio;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.api.module.system.SwanInlinePlayerManager;
import com.baidu.swan.apps.inlinewidget.BaseInlineWidgetController;
import com.baidu.swan.apps.inlinewidget.audio.command.GetCurrentPositionExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.GetDurationExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.IsPlayingExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.PauseExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.PrepareAsyncExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.ReleaseExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.SeekToExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.SetDataSourceExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.SetUseFreeFlowExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.SetVolumeExecutor;
import com.baidu.swan.apps.inlinewidget.audio.command.StartExecutor;
import com.baidu.swan.apps.inlinewidget.audio.widget.IInlineAudio;
import com.baidu.swan.apps.inlinewidget.video.widget.IInlineVideo;

public final class InlineAudioController extends BaseInlineWidgetController<IInlineAudio> {
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "InlineVideoController";
    private final IInlineVideo.IInlineVideoListener mPlayerListener;

    public InlineAudioController(IInlineAudio player) {
        super(player);
        AnonymousClass1 r0 = new IInlineVideo.IInlineVideoListener() {
            public void onPrepared() {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, "onPrepared", (Object) null);
                }
            }

            public void onPlayed(String playerId) {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, PluginInvokerConstants.METHOD_ZEUS_PLAYED, (Object) null);
                }
                SwanInlinePlayerManager.getInstance().putPlayerState(playerId, true);
                SwanInlinePlayerManager.getInstance().pauseOtherPlayers(playerId);
            }

            public void onPaused(String playerId) {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, "onPaused", (Object) null);
                }
                if (!TextUtils.isEmpty(playerId)) {
                    SwanInlinePlayerManager.getInstance().putPlayerState(playerId, false);
                }
            }

            public void onEnded() {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, "onEnded", (Object) null);
                }
            }

            public void onError(int what) {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, "onError", Integer.valueOf(what));
                }
            }

            public void onInfo(int what) {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, PluginInvokerConstants.METHOD_ZEUS_ONINFO, Integer.valueOf(what));
                }
            }

            public void onVideoSizeChanged() {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, "onVideoSizeChanged", (Object) null);
                }
            }

            public void onStateChange(int state) {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, "onStateChange", Integer.valueOf(state));
                }
            }

            public void onNetStatus(String statusJson) {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, "onNetStatus", statusJson);
                }
            }

            public void onRelease(String playerId) {
                if (InlineAudioController.DEBUG) {
                    Log.i(InlineAudioController.TAG, "onRelease: " + playerId);
                }
                SwanInlinePlayerManager.getInstance().removePlayerState(playerId);
            }

            public void onStartInitStart(String playerId) {
                ((IInlineAudio) InlineAudioController.this.mInlineWidget).onVideoCreateStart();
            }

            public void onStartInitEnd(String playerId) {
                ((IInlineAudio) InlineAudioController.this.mInlineWidget).onVideoCreateEnd();
            }

            public void onSeekComplete(String playerId) {
                if (InlineAudioController.this.mCallback != null) {
                    InlineAudioController.this.mCallback.onCallback(InlineAudioController.this, PluginInvokerConstants.METHOD_STATICS_SEEK_COMPLETE, (Object) null);
                }
            }
        };
        this.mPlayerListener = r0;
        player.setInlineVideoListener(r0);
        this.mCommandDispatcher.addCommandExecutor(new GetCurrentPositionExecutor());
        this.mCommandDispatcher.addCommandExecutor(new GetDurationExecutor());
        this.mCommandDispatcher.addCommandExecutor(new IsPlayingExecutor());
        this.mCommandDispatcher.addCommandExecutor(new PauseExecutor());
        this.mCommandDispatcher.addCommandExecutor(new PrepareAsyncExecutor());
        this.mCommandDispatcher.addCommandExecutor(new ReleaseExecutor());
        this.mCommandDispatcher.addCommandExecutor(new SeekToExecutor());
        this.mCommandDispatcher.addCommandExecutor(new SetDataSourceExecutor());
        this.mCommandDispatcher.addCommandExecutor(new SetUseFreeFlowExecutor());
        this.mCommandDispatcher.addCommandExecutor(new SetVolumeExecutor());
        this.mCommandDispatcher.addCommandExecutor(new StartExecutor());
    }
}
