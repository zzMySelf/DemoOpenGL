package com.baidu.searchbox.music.ext.album.model;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MusicAlbumList {
    List<MusicAlbum> albumList;
    boolean hasMore;

    public MusicAlbumList() {
    }

    public MusicAlbumList(List<MusicAlbum> list, boolean hasMore2) {
        this.albumList = list;
        this.hasMore = hasMore2;
    }

    public List<MusicAlbum> getAlbumList() {
        return this.albumList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public String toString() {
        return "MusicAlbumList{albumList=" + this.albumList + ", hasMore=" + this.hasMore + AbstractJsonLexerKt.END_OBJ;
    }
}
