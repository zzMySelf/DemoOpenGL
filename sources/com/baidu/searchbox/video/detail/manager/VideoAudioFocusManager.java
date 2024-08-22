package com.baidu.searchbox.video.detail.manager;

import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;
import com.baidu.searchbox.player.BDVideoPlayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014J\u0006\u0010\u001e\u001a\u00020\u0017J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/video/detail/manager/VideoAudioFocusManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "getAudioFocusChangeListener", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "setAudioFocusChangeListener", "(Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "hasFocus", "", "internalAudioFocusListener", "abandonAudioFocus", "", "changeAudioFocus", "focus", "handleVolumeKeyDown", "event", "Landroid/view/KeyEvent;", "isPlayingStatus", "release", "requestAudioFocus", "lib-support_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoAudioFocusManager.kt */
public final class VideoAudioFocusManager {
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    private final Lazy audioManager$delegate = LazyKt.lazy(new VideoAudioFocusManager$audioManager$2(this));
    private final Context context;
    private boolean hasFocus;
    private AudioManager.OnAudioFocusChangeListener internalAudioFocusListener = new VideoAudioFocusManager$$ExternalSyntheticLambda0(this);

    public VideoAudioFocusManager(Context context2) {
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener() {
        return this.audioFocusChangeListener;
    }

    public final void setAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.audioFocusChangeListener = onAudioFocusChangeListener;
    }

    private final AudioManager getAudioManager() {
        return (AudioManager) this.audioManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: internalAudioFocusListener$lambda-0  reason: not valid java name */
    public static final void m5332internalAudioFocusListener$lambda0(VideoAudioFocusManager this$0, int focusChange) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (focusChange != 1) {
            this$0.hasFocus = false;
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this$0.audioFocusChangeListener;
        if (onAudioFocusChangeListener != null) {
            onAudioFocusChangeListener.onAudioFocusChange(focusChange);
        }
    }

    public final void changeAudioFocus(boolean focus) {
        if (focus) {
            if (!BDVideoPlayer.isGlobalMute() && !this.hasFocus) {
                requestAudioFocus();
            }
        } else if (BDVideoPlayer.isGlobalMute() && this.hasFocus) {
            abandonAudioFocus();
        }
    }

    public final void release() {
        abandonAudioFocus();
        this.internalAudioFocusListener = null;
    }

    public final boolean handleVolumeKeyDown(KeyEvent event, boolean isPlayingStatus) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean handleResult = false;
        if (!isPlayingStatus) {
            return false;
        }
        try {
            if (event.getKeyCode() == 25) {
                AudioManager audioManager = getAudioManager();
                if (audioManager != null) {
                    audioManager.adjustStreamVolume(3, -1, 0);
                }
                handleResult = true;
            }
            if (event.getKeyCode() != 24) {
                return handleResult;
            }
            AudioManager audioManager2 = getAudioManager();
            if (audioManager2 != null) {
                audioManager2.adjustStreamVolume(3, 1, 0);
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private final void requestAudioFocus() {
        if (this.internalAudioFocusListener != null) {
            this.hasFocus = true;
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                audioManager.requestAudioFocus(this.internalAudioFocusListener, 3, 1);
            }
        }
    }

    private final void abandonAudioFocus() {
        this.hasFocus = false;
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.internalAudioFocusListener);
        }
    }
}
