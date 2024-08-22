package com.baidu.searchbox.music.ext.album.playback.playlist.db;

import com.baidu.searchbox.music.ext.model.ISong;
import java.io.Closeable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001e\u0010\u0012\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0013\u001a\u00020\u0010H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H&J\u0016\u0010\u0018\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/playback/playlist/db/PlaylistDao;", "Ljava/io/Closeable;", "appendSongs", "", "songList", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "clearSongs", "", "clearSongsBySite", "sites", "", "", "deleteSongs", "start", "count", "", "getSongList", "insertSongs", "position", "reorderSong", "song", "from", "to", "setSongList", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaylistDao.kt */
public interface PlaylistDao extends Closeable {
    boolean appendSongs(List<? extends ISong> list);

    void clearSongs();

    void clearSongsBySite(Set<String> set);

    boolean deleteSongs(ISong iSong, int i2);

    List<ISong> getSongList();

    boolean insertSongs(List<? extends ISong> list, int i2);

    boolean reorderSong(ISong iSong, int i2, int i3);

    void setSongList(List<? extends ISong> list);
}
