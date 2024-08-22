package com.baidu.searchbox.music.ext.album.repo;

import com.baidu.searchbox.music.ext.album.model.AlbumSongList;
import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import com.baidu.searchbox.music.ext.album.repo.albumsong.AlbumSongApi;
import com.baidu.searchbox.music.ext.model.ISong;
import java.util.List;
import kotlin.Metadata;
import rx.Single;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/baidu/searchbox/music/ext/album/repo/MusicAlbumRepo$songApi$1", "Lcom/baidu/searchbox/music/ext/album/repo/albumsong/AlbumSongApi;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicAlbumRepo.kt */
public final class MusicAlbumRepo$songApi$1 implements AlbumSongApi {
    MusicAlbumRepo$songApi$1() {
    }

    public Single<MusicAlbum> addAllSongs(MusicAlbum src, MusicAlbum dst, List<? extends ISong> excludes) {
        return AlbumSongApi.DefaultImpls.addAllSongs(this, src, dst, excludes);
    }

    public Single<MusicAlbum> addSong(MusicAlbum album, ISong song) {
        return AlbumSongApi.DefaultImpls.addSong(this, album, song);
    }

    public Single<MusicAlbum> addSongs(MusicAlbum src, MusicAlbum dst, List<? extends ISong> songs) {
        return AlbumSongApi.DefaultImpls.addSongs(this, src, dst, songs);
    }

    public Single<MusicAlbum> clearSongs(MusicAlbum album, List<? extends ISong> excludes) {
        return AlbumSongApi.DefaultImpls.clearSongs(this, album, excludes);
    }

    public Single<AlbumSongList> getSongList(MusicAlbum album, int pageSize, boolean requireCount, String lastId) {
        return AlbumSongApi.DefaultImpls.getSongList(this, album, pageSize, requireCount, lastId);
    }

    public Single<MusicAlbum> removeSongs(MusicAlbum album, List<? extends ISong> songs) {
        return AlbumSongApi.DefaultImpls.removeSongs(this, album, songs);
    }

    public boolean supportPaging() {
        return AlbumSongApi.DefaultImpls.supportPaging(this);
    }
}
