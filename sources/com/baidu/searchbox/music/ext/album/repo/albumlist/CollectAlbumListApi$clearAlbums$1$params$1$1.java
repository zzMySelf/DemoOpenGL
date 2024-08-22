package com.baidu.searchbox.music.ext.album.repo.albumlist;

import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectAlbumListApi.kt */
final class CollectAlbumListApi$clearAlbums$1$params$1$1 extends Lambda implements Function1<MusicAlbum, CharSequence> {
    public static final CollectAlbumListApi$clearAlbums$1$params$1$1 INSTANCE = new CollectAlbumListApi$clearAlbums$1$params$1$1();

    CollectAlbumListApi$clearAlbums$1$params$1$1() {
        super(1);
    }

    public final CharSequence invoke(MusicAlbum it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }
}
