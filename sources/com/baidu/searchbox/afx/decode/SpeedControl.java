package com.baidu.searchbox.afx.decode;

import android.util.Log;
import com.baidu.helios.channels.ChannelFactory;
import com.baidu.searchbox.afx.decode.VideoPlayer;

public class SpeedControl implements VideoPlayer.FrameCallback {
    private static final long ONE_MILLION = 1000000;
    private static final String TAG = "SpeedControl";
    private long mFixedFrameDurationUsec;
    private boolean mLoopReset;
    private long mPrevMonoUsec;
    private long mPrevPresentUsec;

    public void setFixedPlaybackRate(int fps) {
        this.mFixedFrameDurationUsec = 1000000 / ((long) fps);
    }

    public void preRender(long presentationTimeUsec) {
        long frameDelta;
        long j2 = presentationTimeUsec;
        if (this.mPrevMonoUsec == 0) {
            this.mPrevMonoUsec = System.nanoTime() / 1000;
            this.mPrevPresentUsec = j2;
            return;
        }
        if (this.mLoopReset) {
            this.mPrevPresentUsec = j2 - 40000;
            this.mLoopReset = false;
        }
        if (this.mFixedFrameDurationUsec != 0) {
            frameDelta = this.mFixedFrameDurationUsec;
        } else {
            frameDelta = j2 - this.mPrevPresentUsec;
        }
        if (frameDelta < 0) {
            Log.w(TAG, "Weird, video times went backward");
            frameDelta = 0;
        } else if (frameDelta == 0) {
            Log.w(TAG, "Warning: current frame and previous frame had same timestamp");
        } else if (frameDelta > 10000000) {
            frameDelta = ChannelFactory.CHANNEL_NAME_COMPONENT_COMMUNICATION_CONTENT_PROVIDER_PRIORITY;
        }
        long desiredUsec = this.mPrevMonoUsec + frameDelta;
        long nowUsec = System.nanoTime() / 1000;
        while (nowUsec < desiredUsec - 100) {
            long sleepTimeUsec = desiredUsec - nowUsec;
            if (sleepTimeUsec > 500000) {
                sleepTimeUsec = 500000;
            }
            try {
                Thread.sleep(sleepTimeUsec / 1000, ((int) (sleepTimeUsec % 1000)) * 1000);
            } catch (InterruptedException e2) {
            }
            nowUsec = System.nanoTime() / 1000;
            long j3 = presentationTimeUsec;
        }
        this.mPrevMonoUsec += frameDelta;
        this.mPrevPresentUsec += frameDelta;
    }

    public void loopReset() {
        this.mLoopReset = true;
    }

    public void reset() {
        this.mPrevPresentUsec = 0;
        this.mPrevMonoUsec = 0;
        this.mFixedFrameDurationUsec = 0;
        this.mLoopReset = false;
    }
}
