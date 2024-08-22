package com.baidu.searchbox.music.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdmediacore.MediaRuntime;
import com.baidu.searchbox.bdmediacore.statistic.MediaHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.libsimcard.helper.ISimCardObserver;
import com.baidu.searchbox.libsimcard.helper.SimBindHelper;
import com.baidu.searchbox.libsimcard.helper.SimCardHelper;
import com.baidu.searchbox.libsimcard.model.SimCardData;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.adapter.PlayerDataChannelManager;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.music.callback.MusicPluginInstallCallback;
import com.baidu.searchbox.music.impl.R;
import com.baidu.searchbox.music.statistic.MusicUBCConstant;
import com.baidu.searchbox.music.utils.MusicCommonUtils;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import com.baidu.searchbox.plugin.api.InvokeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicPlayer {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_ERROR_CODE = "errorCode";
    private static final int MSG_REFRESH_SEEKBAR = 1;
    public static final String SP_PLAYER_MODE = "sp_music_player_mode";
    private static final String TAG = "MusicPlayer";
    private static MusicPlayer instance;
    /* access modifiers changed from: private */
    public boolean isPlayerInit = false;
    private boolean isSeekPlay = false;
    private boolean isSimCardRegisted = false;
    private MusicExternalHandler mExternalHandler;
    private int mInitSeekValue = 0;
    /* access modifiers changed from: private */
    public MusicCore mMusicPlayEngine = new DuMediaPlayer();
    private InvokeListener[] mPlayInfoInvokes = {new InvokeListener() {
        public String onExecute(String s) {
            if (MusicPlayer.DEBUG) {
                Log.d(MusicPlayer.TAG, "addPlayInfoListener: " + s);
            }
            MusicPlayer.this.getCurrentSong();
            if (MusicPlayer.this.pauseAfterInit) {
                MusicPlayer.this.pause();
                boolean unused = MusicPlayer.this.pauseAfterInit = false;
                UiThreadUtils.getMainHandler().postDelayed(new Runnable() {
                    public void run() {
                        MusicPlayer.this.getDuration();
                        MusicPlayer.this.getPosition();
                    }
                }, 200);
            }
            MusicPlayer.this.initSeek();
            return null;
        }
    }};
    /* access modifiers changed from: private */
    public int mPlayMode = PreferenceUtils.getInt("sp_music_player_mode", 1);
    /* access modifiers changed from: private */
    public MusicPlayState mPlayState = MusicPlayState.STOP;
    private volatile Vector<MusicPlayerCallback> mPlayerCallback = new Vector<>();
    /* access modifiers changed from: private */
    public Song mPreSong;
    private ProgressHandler mProgressHandler;
    private String mSeekId;
    private ISimCardObserver mSimcardObserver = new ISimCardObserver() {
        public void updateSimCardData(boolean isFreeFlowSimCard, SimCardData simCardData) {
            if (MusicPlayer.DEBUG) {
                Log.d(MusicPlayer.TAG, "——> updateSimCardData:  isFreeFlowSimCard " + isFreeFlowSimCard);
            }
            MusicPlayer.this.mMusicPlayEngine.changeToFreeCard(NetWorkUtils.isMobileNetworkConnected((Context) null) && (isFreeFlowSimCard || SimBindHelper.getInstance().getSimBindStatusFromDisk()), (InvokeCallback) null);
        }
    };
    /* access modifiers changed from: private */
    public Song mSong;
    private int mSongDownloadProgress;
    private int mSongDuration;
    /* access modifiers changed from: private */
    public ArrayList<Song> mSongList;
    private int mSongPosition;
    private int netWorkError;
    /* access modifiers changed from: private */
    public boolean pauseAfterInit = false;
    private PlayerDataChannelManager playerChannelManager;
    /* access modifiers changed from: private */
    public int position;
    /* access modifiers changed from: private */
    public int totalSongNum;

    private MusicPlayer() {
        init();
    }

    public static MusicPlayer getInstance() {
        if (instance == null) {
            synchronized (MusicPlayer.class) {
                if (instance == null) {
                    instance = new MusicPlayer();
                }
            }
        }
        return instance;
    }

    private void init() {
        this.mSongList = new ArrayList<>();
        this.mPlayState = MusicPlayState.READY;
        MusicExternalHandler musicExternalHandler = new MusicExternalHandler(AppRuntime.getAppContext());
        this.mExternalHandler = musicExternalHandler;
        musicExternalHandler.startListen();
        this.mProgressHandler = new ProgressHandler(Looper.getMainLooper());
        if (DEBUG) {
            Log.d(TAG, "init");
        }
    }

    private void initPlayer(final InvokeCallback callback) {
        if (this.isPlayerInit) {
            callback.onResult(0, (String) null);
            return;
        }
        if (!this.isSimCardRegisted) {
            this.isSimCardRegisted = true;
            SimCardHelper.getInstance().register(this.mSimcardObserver);
        }
        if (this.playerChannelManager == null) {
            this.playerChannelManager = new PlayerDataChannelManager();
        }
        this.mMusicPlayEngine.initMusic(new InvokeCallback() {
            public void onResult(int i2, String s) {
                if (i2 == 0) {
                    if (MusicPlayer.DEBUG) {
                        Log.d(MusicPlayer.TAG, "——> onResult: STATUS_CODE_SUCCESS");
                    }
                    MusicPlayer.this.addPlayInfoListener();
                    MusicPlayer.this.addPlayStateListener();
                    MusicPlayer.this.addSeekCompleteListener();
                    MusicPlayer.this.addMusicErrorListener();
                    MusicPlayer musicPlayer = MusicPlayer.this;
                    musicPlayer.setPlayMode(musicPlayer.mPlayMode);
                    ExecutorUtilsExt.postOnElastic(new Runnable() {
                        public void run() {
                            if (MusicPlayer.DEBUG) {
                                Log.d(MusicPlayer.TAG, "notifySimCardObservers after register");
                            }
                            SimCardHelper.getInstance().notifySimCardObservers();
                        }
                    }, "notifySimCardObservers", 2);
                    boolean unused = MusicPlayer.this.isPlayerInit = true;
                    MusicPlayer.this.onInvokeSucceed();
                    BdEventBus.Companion.getDefault().post(new MusicPluginInstallCallback(true));
                } else if (i2 == 14) {
                    BdEventBus.Companion.getDefault().post(new MusicPluginInstallCallback(false));
                    MusicPlayer.this.onInvokeFail();
                }
                callback.onResult(i2, s);
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void onInvokeFail() {
        if (DEBUG) {
            Log.d(TAG, "——> onInvokeFail: ");
        }
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            it.next().onInvokeFailed();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onInvokeSucceed() {
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            it.next().onInvokeSucceed();
        }
    }

    public void setPauseAfterInit(boolean pauseAfterInit2) {
        this.pauseAfterInit = pauseAfterInit2;
    }

    public void release() {
        if (isAvailable()) {
            this.mMusicPlayEngine.release((InvokeCallback) null);
        }
        this.isPlayerInit = false;
        this.mSongList = new ArrayList<>();
        synchronized (this) {
            this.mPlayerCallback = new Vector<>();
        }
        this.mPlayState = MusicPlayState.STOP;
        this.mExternalHandler.stopListen();
        stopRefreshProgress();
        SimCardHelper.getInstance().unregister(this.mSimcardObserver);
        if (DEBUG) {
            Log.d(TAG, "release");
        }
        PlayerDataChannelManager playerDataChannelManager = this.playerChannelManager;
        if (playerDataChannelManager != null) {
            playerDataChannelManager.release();
        }
        instance = null;
    }

    private synchronized void removeAlreadyDestroyedCallBack() {
        if (this.mPlayerCallback != null && this.mPlayerCallback.size() > 0) {
            for (int i2 = this.mPlayerCallback.size() - 1; i2 >= 0; i2--) {
                if (this.mPlayerCallback.get(i2) == null || this.mPlayerCallback.get(i2).isDestroyed()) {
                    this.mPlayerCallback.remove(i2);
                }
            }
        }
    }

    public synchronized void addPlayerCallback(MusicPlayerCallback callback) {
        removeAlreadyDestroyedCallBack();
        if (callback != null && !this.mPlayerCallback.contains(callback)) {
            this.mPlayerCallback.add(callback);
            if (DEBUG) {
                Log.d(TAG, "addPlayerCallback = " + callback);
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 1 */
    public synchronized void removePlayerCallback(MusicPlayerCallback callback) {
        if (callback != null) {
            if (this.mPlayerCallback != null && this.mPlayerCallback.contains(callback)) {
                this.mPlayerCallback.remove(callback);
            }
        }
    }

    public ArrayList<Song> getSongList() {
        return this.mSongList;
    }

    public Song getSong() {
        return this.mSong;
    }

    public void setSong(Song song) {
        this.mSong = song;
    }

    public int getCurrentIndex() {
        ArrayList<Song> arrayList = this.mSongList;
        if (arrayList == null || arrayList.size() <= 0 || this.mSong == null) {
            return 0;
        }
        for (int i2 = 0; i2 < this.mSongList.size(); i2++) {
            if (this.mSongList.get(i2) != null && this.mSong.equals(this.mSongList.get(i2))) {
                return i2;
            }
        }
        return 0;
    }

    public int getSongDuration() {
        return this.mSongDuration;
    }

    public int getSongPosition() {
        return this.mSongPosition;
    }

    public int getSongDownloadProgress() {
        return this.mSongDownloadProgress;
    }

    public int getPlayMode() {
        return this.mPlayMode;
    }

    public MusicPlayState getPlayState() {
        return this.mPlayState;
    }

    public void setSongList(int position2, ArrayList<Song> songs) {
        setSongList(position2, songs, 0);
    }

    public void setSongList(int position2, ArrayList<Song> songs, int currProcess) {
        initPlayer(new InitPlayerCallback(songs, position2, currProcess));
    }

    public synchronized void onStateChange() {
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(this.mPlayState);
        }
    }

    public void onGetDuration() {
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            it.next().onGetDuration(this.mSongDuration);
        }
    }

    public synchronized void onGetPosition() {
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            int i2 = this.mSongPosition;
            it.next().onGetPosition(i2, MusicCommonUtils.getProgress(this.mSongDuration, i2));
        }
    }

    public synchronized void onGetDownloadProgress() {
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            it.next().onGetDownloadProgress(this.mSongDownloadProgress);
        }
    }

    public synchronized void onGetCurrentSong() {
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            it.next().onGetCurrentSong(this.mSong);
        }
    }

    public void play() {
        if (isAvailable()) {
            if (!this.mExternalHandler.isInCall()) {
                this.mMusicPlayEngine.play((InvokeCallback) null);
                this.mPlayState = MusicPlayState.PLAY;
                if (DEBUG) {
                    Log.d(TAG, "play");
                }
            } else if (DEBUG) {
                Log.d(TAG, "play() in call return directly.");
            }
        }
    }

    public void pause() {
        if (isAvailable()) {
            this.mMusicPlayEngine.pause((InvokeCallback) null);
            this.mPlayState = MusicPlayState.PAUSE;
            if (DEBUG) {
                Log.d(TAG, "pause");
            }
        }
    }

    public void stop() {
        if (isAvailable()) {
            this.mMusicPlayEngine.stop((InvokeCallback) null);
            this.mPlayState = MusicPlayState.STOP;
            if (DEBUG) {
                Log.d(TAG, "stop");
            }
        }
    }

    public void seek(int position2) {
        if (isAvailable()) {
            this.mMusicPlayEngine.seek(position2, (InvokeCallback) null);
            if (DEBUG) {
                Log.d(TAG, "seek to " + position2);
            }
        }
    }

    public void setSpeed(float speed) {
        if (isAvailable()) {
            this.mMusicPlayEngine.setSpeed(speed, (InvokeCallback) null);
        }
    }

    public void setVolume(float leftVolume, float rightVolume) {
        this.mMusicPlayEngine.setVolume(leftVolume, rightVolume);
    }

    public void seekPlay(long position2) {
        this.isSeekPlay = true;
        seek((int) position2);
    }

    private void onSeekPlay() {
        if (this.isSeekPlay) {
            play();
            this.isSeekPlay = false;
        }
    }

    /* access modifiers changed from: private */
    public void addSeekCompleteListener() {
        this.mMusicPlayEngine.addSeekCompleteListener(new InvokeListener[]{new InvokeListener() {
            public String onExecute(String s) {
                MusicPlayer.this.onSeekComplete();
                return null;
            }
        }});
    }

    /* access modifiers changed from: private */
    public synchronized void onSeekComplete() {
        getPosition();
        Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
        while (it.hasNext()) {
            MusicPlayerCallback callback = it.next();
            if (callback != null) {
                callback.onSeekComplete();
            }
        }
        onSeekPlay();
    }

    /* access modifiers changed from: private */
    public void addMusicErrorListener() {
        this.mMusicPlayEngine.addMusicErrorListner(new InvokeListener[]{new InvokeListener() {
            public String onExecute(String errorInfo) {
                MusicPlayer.this.onError(errorInfo);
                return null;
            }
        }});
    }

    /* access modifiers changed from: private */
    public void onError(String errorInfo) {
        try {
            JSONObject jsonObject = new JSONObject(errorInfo);
            int errorCode = jsonObject.getInt("errorCode");
            MediaHelper.recordAudioReliability(MediaHelper.getMusicCoreError(String.valueOf(errorCode)), jsonObject.optJSONObject("errorDetail"));
            synchronized (this) {
                Iterator<MusicPlayerCallback> it = this.mPlayerCallback.iterator();
                while (it.hasNext()) {
                    MusicPlayerCallback callback = it.next();
                    if (callback != null) {
                        callback.onError(errorCode);
                    }
                }
            }
            if (MediaRuntime.getContext().getMode() != 2) {
                showErrorToast(errorCode);
            }
            if (DEBUG) {
                Log.d(TAG, "onError:errorCode: " + errorCode);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void showErrorToast(int errorCode) {
        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.music_play_error_toast_other).showToast();
    }

    /* access modifiers changed from: private */
    public void getDuration() {
        int duration;
        if (isAvailable() && (duration = this.mMusicPlayEngine.getDuration()) > 0) {
            this.mSongDuration = duration;
            onGetDuration();
        }
    }

    /* access modifiers changed from: private */
    public void getPosition() {
        int position2;
        if (isAvailable() && (position2 = this.mMusicPlayEngine.getPosition()) > 0) {
            this.mSongPosition = position2;
            onGetPosition();
        }
    }

    /* access modifiers changed from: private */
    public void getDownloadProgress() {
        int downloadProgress;
        if (isAvailable() && (downloadProgress = this.mMusicPlayEngine.getDownloadProgress()) >= 0 && downloadProgress <= 100) {
            this.mSongDownloadProgress = downloadProgress;
            onGetDownloadProgress();
        }
    }

    /* access modifiers changed from: private */
    public void getCurrentSong() {
        Song song;
        if (isAvailable()) {
            Song song2 = this.mMusicPlayEngine.getCurrentSong();
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "getCurrentSong =" + song2);
            }
            if (song2 != null) {
                checkSongInfo(song2);
                onGetCurrentSong();
                if (song2.mDuration > 0) {
                    this.mSongDuration = song2.mDuration;
                    onGetDuration();
                }
                boolean isNewSong = false;
                Song song3 = this.mPreSong;
                if (song3 == null || !song3.equals(song2)) {
                    this.mPreSong = song2;
                    isNewSong = true;
                }
                if (z) {
                    Log.d(TAG, "——> onPluginCallback: isNewSong " + isNewSong);
                }
                if (isNewSong && (song = this.mSong) != null && TextUtils.isEmpty(song.mSongId) && !TextUtils.isEmpty(this.mSong.mAudioSourcePinyin)) {
                    MusicUBCConstant.musicEvent("600", "show", this.mSong.mAudioSourcePinyin, (String) null, (String) null, (String) null);
                }
            }
        }
    }

    private void checkSongInfo(Song songFromPlugin) {
        ArrayList<Song> arrayList;
        if (songFromPlugin != null && (arrayList = this.mSongList) != null && arrayList.size() > 0) {
            if (DEBUG) {
                Log.d(TAG, "——> checkSongInfo: song " + songFromPlugin.toString());
            }
            long start = System.currentTimeMillis();
            for (int i2 = 0; i2 < this.mSongList.size(); i2++) {
                Song song = this.mSongList.get(i2);
                if (song.equals(songFromPlugin)) {
                    if (isBaiduMusic(songFromPlugin)) {
                        songFromPlugin.mAudioSource = song.mAudioSource;
                        songFromPlugin.mAudioIconUrl = song.mAudioIconUrl;
                        songFromPlugin.mAppDownlaodUrl = song.mAppDownlaodUrl;
                        songFromPlugin.mAppSize = song.mAppSize;
                        songFromPlugin.id = song.id;
                        this.mSong = songFromPlugin;
                    } else {
                        song.mDuration = songFromPlugin.mDuration;
                        this.mSong = song;
                    }
                    this.mSongList.set(i2, this.mSong);
                    if (DEBUG) {
                        Log.d(TAG, "——> checkSongInfo: take time " + (System.currentTimeMillis() - start));
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean isBaiduMusic(Song song) {
        return song != null && !TextUtils.isEmpty(song.mSongId);
    }

    /* access modifiers changed from: private */
    public void addPlayInfoListener() {
        this.mMusicPlayEngine.addPlayInfoListener((InvokeCallback) null, this.mPlayInfoInvokes);
    }

    /* access modifiers changed from: private */
    public void initSeek() {
        Song song;
        if (this.mInitSeekValue > 0 && (song = this.mSong) != null && TextUtils.equals(song.mAlbumId, this.mSeekId)) {
            if (DEBUG) {
                Log.d("MusicSeek", "use seek value : " + this.mInitSeekValue + " -- " + this.mSeekId);
            }
            seek(this.mInitSeekValue);
            this.mInitSeekValue = 0;
        }
    }

    /* access modifiers changed from: private */
    public void addPlayStateListener() {
        this.mMusicPlayEngine.addPlayStateListener((InvokeCallback) null, new InvokeListener[]{new InvokeListener() {
            public String onExecute(String s) {
                if (MusicPlayer.DEBUG) {
                    Log.d(MusicPlayer.TAG, "playState =" + s.toString());
                }
                try {
                    switch (new JSONObject(s).optInt("playstate")) {
                        case 0:
                            MusicPlayState unused = MusicPlayer.this.mPlayState = MusicPlayState.READY;
                            MusicPlayer.this.stopRefreshProgress();
                            break;
                        case 1:
                            MusicPlayState unused2 = MusicPlayer.this.mPlayState = MusicPlayState.PLAY;
                            MediaHelper.playSpeedEnd();
                            MusicPlayer.this.startRefreshProgress();
                            break;
                        case 2:
                            MusicPlayState unused3 = MusicPlayer.this.mPlayState = MusicPlayState.PAUSE;
                            MusicPlayer.this.stopRefreshProgress();
                            break;
                        case 3:
                            MusicPlayState unused4 = MusicPlayer.this.mPlayState = MusicPlayState.END;
                            MusicPlayer.this.stopRefreshProgress();
                            break;
                        case 4:
                            MusicPlayState unused5 = MusicPlayer.this.mPlayState = MusicPlayState.STOP;
                            MusicPlayer.this.stopRefreshProgress();
                            break;
                    }
                    MusicPlayer.this.onStateChange();
                    return null;
                } catch (JSONException e2) {
                    if (!MusicPlayer.DEBUG) {
                        return null;
                    }
                    e2.printStackTrace();
                    return null;
                }
            }
        }});
    }

    public void setPlayMode(int mode) {
        if (mode > 3) {
            mode = 1;
        }
        this.mMusicPlayEngine.setPlayMode(mode, (InvokeCallback) null);
        this.mPlayMode = mode;
        PreferenceUtils.setInt("sp_music_player_mode", mode);
    }

    public Song getDownloadSong() {
        Song song;
        if (!isAvailable() || (song = this.mSong) == null || !isBaiduMusic(song)) {
            return null;
        }
        return this.mMusicPlayEngine.getDownloadSong(this.mSong.mSongId);
    }

    public boolean isAvailable() {
        boolean isEngineValid = this.mMusicPlayEngine.isAvailable(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d(TAG, "--->>>PlayerAction-isAvailable: isPlayerInit=" + this.isPlayerInit + "isEngineValid=" + isEngineValid);
        }
        return this.isPlayerInit && isEngineValid;
    }

    public void setInitSeekValue(int historyPos) {
        this.mInitSeekValue = historyPos;
    }

    public void setSeekId(String mAlbumId) {
        this.mSeekId = mAlbumId;
    }

    class ProgressHandler extends Handler {
        public ProgressHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    try {
                        MusicPlayer.this.getDuration();
                        MusicPlayer.this.getPosition();
                        MusicPlayer.this.getDownloadProgress();
                        sendEmptyMessageDelayed(1, 200);
                        return;
                    } catch (Exception e2) {
                        if (MusicPlayer.DEBUG) {
                            e2.printStackTrace();
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void startRefreshProgress() {
        ProgressHandler progressHandler = this.mProgressHandler;
        if (progressHandler != null) {
            progressHandler.removeCallbacksAndMessages((Object) null);
            this.mProgressHandler.sendEmptyMessageDelayed(1, 200);
        }
    }

    public void stopRefreshProgress() {
        ProgressHandler progressHandler = this.mProgressHandler;
        if (progressHandler != null) {
            progressHandler.removeMessages(1);
        }
    }

    public boolean isChangeSrc() {
        Song song = this.mPreSong;
        return song == null || !song.equals(this.mSong);
    }

    public void setMusicPlayEngine(MusicCore musicPlayEngine) {
        if (this.mMusicPlayEngine != musicPlayEngine) {
            this.isPlayerInit = false;
            this.mMusicPlayEngine = musicPlayEngine;
        }
    }

    public MusicCore getMusicPlayEngine() {
        return this.mMusicPlayEngine;
    }

    class InitPlayerCallback implements InvokeCallback {
        private int initPosition;
        private int initProcess;
        private List<Song> initSongs;

        public InitPlayerCallback(List<Song> songs, int position, int currProcess) {
            this.initSongs = songs;
            this.initPosition = position;
            this.initProcess = currProcess;
        }

        public void onResult(int i2, String s) {
            List<Song> list;
            if (i2 == 0 && (list = this.initSongs) != null && list.size() > 0) {
                MediaHelper.playSpeechP3Start();
                Song unused = MusicPlayer.this.mPreSong = null;
                ArrayList unused2 = MusicPlayer.this.mSongList = new ArrayList();
                MusicPlayer.this.mSongList.addAll(this.initSongs);
                int unused3 = MusicPlayer.this.position = this.initPosition;
                if (MusicPlayer.this.mSongList.size() > MusicPlayer.this.position) {
                    MusicPlayer musicPlayer = MusicPlayer.this;
                    Song unused4 = musicPlayer.mSong = (Song) musicPlayer.mSongList.get(MusicPlayer.this.position);
                }
                if (MusicPlayer.DEBUG) {
                    Log.d(MusicPlayer.TAG, "setSongList = " + MusicPlayer.this.mSongList);
                }
                MusicPlayer.this.mMusicPlayEngine.setSongList(MusicPlayer.this.position, MusicPlayer.this.mSongList, (InvokeCallback) null, this.initProcess);
                MusicPlayer musicPlayer2 = MusicPlayer.this;
                int unused5 = musicPlayer2.totalSongNum = musicPlayer2.mSongList.size();
            }
        }
    }
}
