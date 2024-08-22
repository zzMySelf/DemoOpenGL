package com.baidu.talos.core.modules.audio;

import android.media.AudioManager;
import com.baidu.talos.core.callback.Callback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/talos/core/modules/audio/TalosMediaPlayerManeger$onAudioFocusChangeListener$1", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "onAudioFocusChange", "", "focusChange", "", "lib-talos-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosMediaPlayerManeger.kt */
public final class TalosMediaPlayerManeger$onAudioFocusChangeListener$1 implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ TalosMediaPlayerManeger this$0;

    TalosMediaPlayerManeger$onAudioFocusChangeListener$1(TalosMediaPlayerManeger $receiver) {
        this.this$0 = $receiver;
    }

    public void onAudioFocusChange(int focusChange) {
        if (!this.this$0.mixWithOthers && this.this$0.getPlayer() != null) {
            boolean z = false;
            if (focusChange <= 0) {
                TalosMediaPlayerManeger talosMediaPlayerManeger = this.this$0;
                TalosMediaPlayer player = talosMediaPlayerManeger.getPlayer();
                if (player != null && player.isPlaying()) {
                    z = true;
                }
                talosMediaPlayerManeger.wasPlayingBeforeFocusChange = z;
                if (this.this$0.wasPlayingBeforeFocusChange) {
                    TalosMediaPlayerManeger talosMediaPlayerManeger2 = this.this$0;
                    talosMediaPlayerManeger2.pause(talosMediaPlayerManeger2.focusedPlayerKey, (Callback) null);
                    if (!this.this$0.mixWithOthers) {
                        this.this$0.abandonAudioFocus();
                    }
                }
            } else if (this.this$0.wasPlayingBeforeFocusChange) {
                TalosMediaPlayerManeger talosMediaPlayerManeger3 = this.this$0;
                talosMediaPlayerManeger3.play(talosMediaPlayerManeger3.focusedPlayerKey, (Callback) null);
                this.this$0.wasPlayingBeforeFocusChange = false;
            }
        }
    }
}
