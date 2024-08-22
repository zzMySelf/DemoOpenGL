package com.baidu.iknow.advisory.hn.player;

import android.media.MediaPlayer;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.searchbox.net.MediaPlayerTracker;
import java.io.IOException;

public class MediaPlayerManager implements LifecycleObserver {
    private static MediaPlayer mPlayer;

    public interface MediaPlayerCallback {
        void onCompletion(Object obj);

        void onError();
    }

    public static void playAudio(String filePath, String msgId, final MediaPlayerCallback callback) {
        try {
            if (mPlayer != null) {
                mPlayer = null;
            }
            MediaPlayer mediaPlayer = new MediaPlayer();
            mPlayer = mediaPlayer;
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    MediaPlayerCallback.this.onCompletion("playAudio Succeed");
                    boolean unused = MediaPlayerManager.doStopAudio();
                }
            });
            MediaPlayerTracker.setDataSource(mPlayer, filePath);
            mPlayer.setAudioStreamType(3);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e2) {
            callback.onError();
        }
    }

    /* access modifiers changed from: private */
    public static boolean doStopAudio() {
        MediaPlayer mediaPlayer = mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        mediaPlayer.stop();
        mPlayer.release();
        mPlayer = null;
        return true;
    }

    public static boolean stopAudio() {
        return doStopAudio();
    }
}
