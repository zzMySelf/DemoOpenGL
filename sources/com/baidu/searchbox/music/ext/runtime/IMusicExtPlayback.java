package com.baidu.searchbox.music.ext.runtime;

import com.baidu.searchbox.music.bean.PlayerDurationStatInfo;
import com.baidu.searchbox.music.ext.album.playback.PlaybackParams;
import com.baidu.searchbox.music.ext.album.playback.PlaybackRepo;
import com.baidu.searchbox.music.ext.album.playback.PlaylistCallback;
import com.baidu.searchbox.music.ext.album.playback.PlaylistProvider;
import com.baidu.searchbox.music.ext.model.ISong;
import java.util.List;
import rx.Single;

public interface IMusicExtPlayback {
    String getSongId();

    boolean isMusicPlaying();

    void playOrPause(int i2, PlayerDurationStatInfo playerDurationStatInfo);

    void playSong(int i2, PlayerDurationStatInfo playerDurationStatInfo);

    void setPlaylistAndPlay(PlaylistProvider playlistProvider, PlaybackParams playbackParams, PlaylistCallback playlistCallback);

    void subscribePlayState(PlaybackRepo playbackRepo);

    void unsubscribePlayState(PlaybackRepo playbackRepo);

    Single<List<ISong>> updatePlayUrl(List<ISong> list);
}
