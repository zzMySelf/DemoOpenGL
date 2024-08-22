package com.baidu.growthsystem.business.common.tone;

import android.media.MediaPlayer;
import com.baidu.searchbox.net.MediaPlayerTracker;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/growthsystem/business/common/tone/MediaPalyerHelper;", "", "()V", "isPause", "", "mPlayer", "Landroid/media/MediaPlayer;", "pause", "", "playSound", "filePath", "", "listener", "Landroid/media/MediaPlayer$OnCompletionListener;", "release", "resume", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaPalyerHelper.kt */
public final class MediaPalyerHelper {
    public static final MediaPalyerHelper INSTANCE = new MediaPalyerHelper();
    private static boolean isPause;
    private static MediaPlayer mPlayer;

    private MediaPalyerHelper() {
    }

    public final void playSound(String filePath, MediaPlayer.OnCompletionListener listener) {
        Unit unit;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2 = mPlayer;
        if (mediaPlayer2 == null) {
            mPlayer = new MediaPlayer();
        } else if (mediaPlayer2 != null) {
            mediaPlayer2.reset();
        }
        MediaPlayer mediaPlayer3 = mPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setAudioStreamType(3);
        }
        if (!(listener == null || (mediaPlayer = mPlayer) == null)) {
            mediaPlayer.setOnCompletionListener(listener);
        }
        MediaPlayer mediaPlayer4 = mPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setOnErrorListener(new MediaPalyerHelper$$ExternalSyntheticLambda0());
        }
        try {
            Result.Companion companion = Result.Companion;
            MediaPlayer mediaPlayer5 = mPlayer;
            if (mediaPlayer5 != null) {
                MediaPlayerTracker.setDataSource(mediaPlayer5, filePath);
            }
            MediaPlayer mediaPlayer6 = mPlayer;
            if (mediaPlayer6 != null) {
                mediaPlayer6.prepare();
            }
            MediaPlayer mediaPlayer7 = mPlayer;
            if (mediaPlayer7 != null) {
                mediaPlayer7.start();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m8971constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        isPause = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: playSound$lambda-0  reason: not valid java name */
    public static final boolean m13619playSound$lambda0(MediaPlayer mediaPlayer, int i2, int i3) {
        MediaPlayer mediaPlayer2 = mPlayer;
        if (mediaPlayer2 == null) {
            return false;
        }
        mediaPlayer2.reset();
        return false;
    }

    public final void pause() {
        Unit unit;
        MediaPlayer mediaPlayer = mPlayer;
        boolean z = false;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            z = true;
        }
        if (z) {
            try {
                Result.Companion companion = Result.Companion;
                MediaPlayer mediaPlayer2 = mPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.pause();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m8971constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            isPause = true;
        }
    }

    public final void resume() {
        Unit unit;
        if (isPause) {
            try {
                Result.Companion companion = Result.Companion;
                MediaPlayer mediaPlayer = mPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m8971constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            isPause = false;
        }
    }

    public final void release() {
        MediaPlayer mediaPlayer = mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mPlayer = null;
    }
}
