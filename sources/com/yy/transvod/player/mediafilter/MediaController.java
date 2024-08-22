package com.yy.transvod.player.mediafilter;

import android.content.Context;
import android.os.Handler;
import com.yy.transvod.player.core.TransVodMisc;
import com.yy.transvod.player.core.TransVodProxy;
import com.yy.transvod.player.core.TransVodStatistic;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MediaController implements IController {
    private static final String TAG = MediaController.class.getSimpleName();
    private List<MediaFilter> mAudioFilterList = new LinkedList();
    private AtomicBoolean mAudioSetuped = new AtomicBoolean(false);
    private AtomicInteger mCurrentState = new AtomicInteger(4);
    private Handler mHandler = null;
    private long mPlayStartTimeMs = 0;
    private final int mTransVodStatTrackId = 0;
    private List<MediaFilter> mVideoFilterList = new LinkedList();
    private AtomicBoolean mVideoSetuped = new AtomicBoolean(false);
    private TransVodMisc mVodMisc = new TransVodMisc();
    private WeakReference<TransVodProxy> mVodProxy = null;
    private TransVodStatistic mVodStatistic = null;

    public void init(Handler handler, TransVodProxy proxy, Context context) {
        if (handler == null) {
            throw new RuntimeException("handler MUST not be null.");
        } else if (proxy != null) {
            this.mHandler = handler;
            this.mVodProxy = new WeakReference<>(proxy);
            this.mVodStatistic = new TransVodStatistic((TransVodProxy) this.mVodProxy.get(), context);
            this.mVodMisc.init((TransVodProxy) this.mVodProxy.get());
        } else {
            throw new RuntimeException("proxy MUST not be null.");
        }
    }

    public void clear() {
        this.mVideoFilterList.clear();
        this.mAudioFilterList.clear();
    }

    public MediaController addFilter(int trackId, MediaFilter filter) {
        filter.setTrackId(trackId);
        filter.setController(this);
        if (trackId == 0) {
            this.mVideoFilterList.add(filter);
        } else if (trackId == 1) {
            this.mAudioFilterList.add(filter);
        }
        return this;
    }

    public final int getStatus() {
        return this.mCurrentState.get();
    }

    public boolean isVideoSetuped() {
        return this.mVideoSetuped.get();
    }

    public boolean isAuidoSetuped() {
        return this.mAudioSetuped.get();
    }

    public final Handler getHandler() {
        return this.mHandler;
    }

    public final TransVodStatistic getStatistic() {
        return this.mVodStatistic;
    }

    public final TransVodProxy getVodProxy() {
        return (TransVodProxy) this.mVodProxy.get();
    }

    public final TransVodMisc getVodMisc() {
        return this.mVodMisc;
    }

    public void setup() {
        synchronized (this) {
            this.mCurrentState.set(6);
            if (!this.mVideoSetuped.get()) {
                this.mVideoSetuped.set(true);
                for (MediaFilter upVar : this.mVideoFilterList) {
                    upVar.setup();
                }
            }
            if (!this.mAudioSetuped.get()) {
                this.mAudioSetuped.set(true);
                for (MediaFilter upVar2 : this.mAudioFilterList) {
                    upVar2.setup();
                }
            }
        }
    }

    public void stop() {
        synchronized (this) {
            this.mCurrentState.set(1);
            for (MediaFilter stop : this.mVideoFilterList) {
                stop.stop();
            }
            for (MediaFilter stop2 : this.mAudioFilterList) {
                stop2.stop();
            }
            this.mVideoSetuped.set(false);
            this.mAudioSetuped.set(false);
            TransVodStatistic transVodStatistic = this.mVodStatistic;
            if (transVodStatistic != null) {
                transVodStatistic.reset();
            }
            TransVodMisc transVodMisc = this.mVodMisc;
            if (transVodMisc != null) {
                transVodMisc.reset();
            }
        }
    }

    public void release() {
        for (MediaFilter release : this.mVideoFilterList) {
            release.release();
        }
        for (MediaFilter release2 : this.mAudioFilterList) {
            release2.release();
        }
    }

    public void connect() {
        Iterator<MediaFilter> iterator = this.mVideoFilterList.iterator();
        MediaFilter mediaFilter = null;
        MediaFilter curFilter = iterator.hasNext() ? iterator.next() : null;
        while (iterator.hasNext()) {
            MediaFilter nxtFilter = iterator.next();
            curFilter.connect(nxtFilter);
            curFilter = nxtFilter;
        }
        Iterator<MediaFilter> iterator2 = this.mAudioFilterList.iterator();
        if (iterator2.hasNext()) {
            mediaFilter = iterator2.next();
        }
        MediaFilter curFilter2 = mediaFilter;
        while (iterator2.hasNext()) {
            MediaFilter nxtFilter2 = iterator2.next();
            curFilter2.connect(nxtFilter2);
            curFilter2 = nxtFilter2;
        }
    }

    public void disconnect() {
        for (MediaFilter disconnect : this.mVideoFilterList) {
            disconnect.disconnect();
        }
        for (MediaFilter disconnect2 : this.mAudioFilterList) {
            disconnect2.disconnect();
        }
    }

    public void handlerror(int err) {
    }

    public void setPlayStartTime(long timeMs) {
        this.mPlayStartTimeMs = timeMs;
    }

    public long getPlayStartTime() {
        return this.mPlayStartTimeMs;
    }
}
