package com.baidu.searchbox.music.ioc;

import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.music.MusicInvokeCallback;
import com.baidu.searchbox.music.MusicManager;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.ServiceInvokeParams;
import com.baidu.searchbox.music.StatParams;
import com.baidu.searchbox.music.bean.PlayerDurationStatInfo;
import com.baidu.searchbox.music.bean.PlayerExtInfo;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.music.comp.player.controller.assist.timer.SimplePlayCallback;
import com.baidu.searchbox.music.dynamicurl.SearchMusicPlayUrlPrefetcherKt;
import com.baidu.searchbox.music.ext.album.playback.PlaybackParams;
import com.baidu.searchbox.music.ext.album.playback.PlaybackProgress;
import com.baidu.searchbox.music.ext.album.playback.PlaybackRepo;
import com.baidu.searchbox.music.ext.album.playback.PlaylistCallback;
import com.baidu.searchbox.music.ext.album.playback.PlaylistProvider;
import com.baidu.searchbox.music.ext.errext.EmptyPlayListException;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.model.SongExtraKt;
import com.baidu.searchbox.music.ext.model.SongFactory;
import com.baidu.searchbox.music.ext.runtime.IMusicExtPlayback;
import com.baidu.searchbox.music.player.MusicStateCallback;
import com.baidu.searchbox.music.utils.AudioPlayHistoryUtils;
import com.baidu.searchbox.music.utils.AudioPlayUpdateUrlUtils;
import com.baidu.searchbox.nacomp.util.CollectionUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

public class MusicExtPlaybackImpl implements IMusicExtPlayback {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "MusicExtPlaybackImpl";
    /* access modifiers changed from: private */
    public PlaybackRepoBridge playbackBridge;
    private final CompositeSubscription subscription = new CompositeSubscription();

    public Single<List<ISong>> updatePlayUrl(final List<ISong> list) {
        List<Song> unwraps = SongFactory.unwrapAll(list);
        if (CollectionUtils.isEmpty(unwraps)) {
            return Single.just(Collections.emptyList());
        }
        final List<Song> expiredList = getExpiredList(unwraps);
        if (DEBUG) {
            Log.d(TAG, "updatePlayUrl expiredList size=" + expiredList.size());
        }
        if (expiredList.isEmpty()) {
            return Single.just(list);
        }
        return Single.create(new Single.OnSubscribe<List<ISong>>() {
            public void call(final SingleSubscriber<? super List<ISong>> subscriber) {
                AudioPlayUpdateUrlUtils.getPlayListOnlineAddressUrl(expiredList, new AudioPlayHistoryUtils.AudioHistoryCallback() {
                    public void onSuccess() {
                        subscriber.onSuccess(list);
                    }

                    public void onFailed() {
                        subscriber.onError(new IOException("更新播放地址失败"));
                    }
                });
            }
        });
    }

    private List<Song> getExpiredList(List<Song> songList) {
        List<Song> expiredList = new ArrayList<>();
        for (Song song : songList) {
            if (!SearchMusicPlayUrlPrefetcherKt.isUrlValid(song)) {
                expiredList.add(song);
            }
        }
        return expiredList;
    }

    public boolean isMusicPlaying() {
        return MusicManager.Companion.get().getPlayStatus() == MusicPlayState.PLAY;
    }

    public String getSongId() {
        Song curSong = MusicManager.Companion.get().getPlaylistController().getPlayingSong();
        return curSong == null ? "" : curSong.id;
    }

    public void playOrPause(int from, PlayerDurationStatInfo statInfo) {
        setMiniPlayer();
        MusicManager.Companion.get().playOrPause(new StatParams(statInfo, from));
    }

    public void playSong(int index, PlayerDurationStatInfo statInfo) {
        setMiniPlayer();
        MusicManager.Companion.get().playAt(index, new StatParams(statInfo, 0));
    }

    private Func1<List<ISong>, Observable<List<ISong>>> funcUpdatePlayUrl() {
        return new Func1<List<ISong>, Observable<List<ISong>>>() {
            public Observable<List<ISong>> call(List<ISong> result) {
                return MusicExtPlaybackImpl.this.updatePlayUrl(result).toObservable();
            }
        };
    }

    private Func1<List<ISong>, List<ISong>> excludeUnplayableSongs() {
        return new Func1<List<ISong>, List<ISong>>() {
            public List<ISong> call(List<ISong> result) {
                List<ISong> filtered = new ArrayList<>();
                for (ISong song : result) {
                    if (SongExtraKt.isSupportNAPlay(song)) {
                        filtered.add(song);
                    }
                }
                return filtered;
            }
        };
    }

    public void setPlaylistAndPlay(PlaylistProvider provider, PlaybackParams playParams, final PlaylistCallback callback) {
        setMiniPlayer();
        MusicManager.Companion.get().getPlaylistController().setPlaylistSource(provider.getSource());
        final ActionSetPagedSongToPlaylist onNext = new ActionSetPagedSongToPlaylist(provider, callback, playParams);
        this.subscription.clear();
        this.subscription.add(provider.getSongs().concatMap(funcUpdatePlayUrl()).map(excludeUnplayableSongs()).subscribe(onNext, new Action1<Throwable>() {
            public void call(Throwable throwable) {
                if (MusicExtPlaybackImpl.DEBUG) {
                    Log.d(MusicExtPlaybackImpl.TAG, "fetch songs error: " + throwable);
                }
                PlaylistCallback playlistCallback = callback;
                if (playlistCallback != null) {
                    playlistCallback.onSongsApplyFailed(throwable);
                }
            }
        }, new Action0() {
            public void call() {
                if (MusicExtPlaybackImpl.DEBUG) {
                    Log.d(MusicExtPlaybackImpl.TAG, "fetch songs completed");
                }
                if (callback == null) {
                    return;
                }
                if (CollectionUtils.isEmpty(onNext.getAllSongs())) {
                    callback.onSongsApplyFailed(new EmptyPlayListException("可播放歌曲为空"));
                } else {
                    callback.onSongsAllApplied();
                }
            }
        }));
    }

    public void subscribePlayState(final PlaybackRepo repo) {
        repo.setMediaCorePlayState(MusicManager.Companion.get().getPlayStatus());
        Song playingSong = MusicManager.Companion.get().getPlaylistController().getPlayingSong();
        ISong wrapped = null;
        if (playingSong != null) {
            wrapped = SongFactory.wrapCompat(playingSong);
        }
        repo.setPlayingSong(wrapped);
        if (this.playbackBridge == null) {
            this.playbackBridge = new PlaybackRepoBridge(repo);
        }
        BdEventBus.Companion.getDefault().register(repo, MusicStateCallback.class, 1, new Action<MusicStateCallback>() {
            public void call(MusicStateCallback event) {
                if (MusicExtPlaybackImpl.DEBUG && event != null) {
                    Log.d(MusicExtPlaybackImpl.TAG, "MusicStateChange state = " + event.mState + ", source = " + event.mSource + ", mode = " + event.mMode);
                }
                if (event != null && event.mState != null) {
                    repo.setMediaCorePlayState(event.mState);
                    MusicManager.Companion.get().addPlayCallback(MusicExtPlaybackImpl.this.playbackBridge);
                }
            }
        });
        MusicManager.Companion.get().addPlayCallback(this.playbackBridge);
    }

    public void unsubscribePlayState(PlaybackRepo repo) {
        BdEventBus.Companion.getDefault().unregister(repo);
        if (this.playbackBridge != null) {
            MusicManager.Companion.get().removePlayCallback(this.playbackBridge);
        }
    }

    private void setMiniPlayer() {
        if (!TTSRuntime.getInstance().isPlayingMusic()) {
            TTSRuntime.getInstance().changePlayerToMode(2);
        }
    }

    private static class ActionSetPagedSongToPlaylist implements Action1<List<ISong>> {
        private final List<ISong> allSongs = new ArrayList();
        private final PlaylistCallback callback;
        private final AtomicInteger pageCounter = new AtomicInteger(0);
        private final PlaybackParams playParams;
        private final PlaylistProvider provider;

        public ActionSetPagedSongToPlaylist(PlaylistProvider provider2, PlaylistCallback callback2, PlaybackParams playParams2) {
            this.provider = provider2;
            this.callback = callback2;
            this.playParams = playParams2;
        }

        public void call(List<ISong> songs) {
            if (MusicExtPlaybackImpl.DEBUG) {
                Log.d(MusicExtPlaybackImpl.TAG, "fetched songs: " + songs);
            }
            int pageIndex = this.pageCounter.getAndIncrement();
            for (ISong song : songs) {
                if (!this.allSongs.contains(song)) {
                    this.allSongs.add(song);
                }
            }
            MusicExtPlaybackImpl.applySongsToPlaylist(this.allSongs, this.provider, pageIndex == 0, this.playParams);
            if (this.callback != null && !CollectionUtils.isEmpty(songs)) {
                this.callback.onSongsPagingApplied(songs);
            }
        }

        public List<ISong> getAllSongs() {
            return this.allSongs;
        }
    }

    /* access modifiers changed from: private */
    public static void applySongsToPlaylist(List<ISong> songs, PlaylistProvider provider, boolean isFirst, PlaybackParams playParams) {
        int i2;
        if (!CollectionUtils.isEmpty(songs)) {
            int source = provider.getSource();
            if (isFirst || MusicManager.Companion.get().getPlaylistController().getPlaylistSource() == source) {
                ISong start = provider.getStartSong();
                boolean keepPlay = false;
                int index = Math.max(0, songs.indexOf(start));
                PlayerExtInfo extInfo = (playParams == null || playParams.getStatInfo() == null) ? null : new PlayerExtInfo(playParams.getStatInfo());
                if (extInfo != null) {
                    if (playParams.getAutoStartPlay()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    extInfo.setAutoPlay(i2);
                }
                if (playParams != null && playParams.getKeepPlaying()) {
                    keepPlay = true;
                }
                boolean startPlay = isFirst;
                if (keepPlay && start != null && start.equals(PlaybackRepo.INSTANCE.getPlayingSong())) {
                    startPlay = false;
                }
                ServiceInvokeParams params = new ServiceInvokeParams(MusicManager.Companion.get().getInvokeSource(), SongFactory.unwrapAll(songs));
                params.setStartIndex(index);
                params.setSongsSource(source);
                params.setStartPlay(startPlay);
                if (extInfo != null) {
                    params.setAutoPlay(extInfo.getAutoPlay());
                    params.setPlayTimestamp(extInfo.getPlayTimestamp());
                    params.setStatInfo(extInfo.getStatInfo());
                }
                MusicManager.Companion.get().startMusicService(AppRuntime.getAppContext(), params, (MusicInvokeCallback) null);
            }
        }
    }

    private static class PlaybackRepoBridge extends SimplePlayCallback {
        /* access modifiers changed from: private */
        public final PlaybackRepo repo;

        public PlaybackRepoBridge(PlaybackRepo repo2) {
            this.repo = repo2;
        }

        public void onPlayProgressChange(final int percent, final long progress) {
            super.onPlayProgressChange(percent, progress);
            if (progress < 0) {
                return;
            }
            if (UiThreadUtils.isOnUiThread()) {
                this.repo.setProgress(new PlaybackProgress((int) progress, percent));
            } else {
                UiThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        PlaybackRepoBridge.this.repo.setProgress(new PlaybackProgress((int) progress, percent));
                    }
                });
            }
        }

        public void onPlayError(int code) {
            super.onPlayError(code);
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    PlaybackRepoBridge.this.repo.setMediaCorePlayState(MusicPlayState.STOP);
                }
            });
        }
    }
}
