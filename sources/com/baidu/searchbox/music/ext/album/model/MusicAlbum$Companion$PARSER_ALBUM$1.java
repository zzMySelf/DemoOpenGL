package com.baidu.searchbox.music.ext.album.model;

import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "json", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicAlbum.kt */
final class MusicAlbum$Companion$PARSER_ALBUM$1 extends Lambda implements Function1<JSONObject, MusicAlbum> {
    public static final MusicAlbum$Companion$PARSER_ALBUM$1 INSTANCE = new MusicAlbum$Companion$PARSER_ALBUM$1();

    MusicAlbum$Companion$PARSER_ALBUM$1() {
        super(1);
    }

    public final MusicAlbum invoke(JSONObject json) {
        JSONObject jSONObject = json;
        MusicAlbum musicAlbum = null;
        if (jSONObject != null) {
            JSONObject it = json;
            String albumName = it.optString("songlist_name");
            String albumId = JSONExtKt.optStringIgnoreNulls(it, "songlist_id", "");
            boolean z = false;
            if (albumId.length() > 0) {
                CharSequence charSequence = albumName;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    musicAlbum = new MusicAlbum(albumId);
                    MusicAlbum $this$invoke_u24lambda_u2d1_u24lambda_u2d0 = musicAlbum;
                    Intrinsics.checkNotNullExpressionValue(albumName, "albumName");
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.name = albumName;
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.songNum = it.optLong("song_num", -1);
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.coverUrl = JSONExtKt.optStringIgnoreNulls(it, "image", "");
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.isModifiable = it.optInt("modifiable", 0) == 1;
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.isFavorite = it.optInt("favorite", 0) == 1;
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.isCollectable = it.optInt("collectable", 1) == 1;
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.createTime = it.optLong("create_time", -1) * 1000;
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.isSongModifiable = it.optInt("songModifiable", 0) == 1;
                    if (it.optInt("is_collected", -1) == 1) {
                        z = true;
                    }
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.setCollected(z);
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.setType(AlbumType.Companion.fromIntText(JSONExtKt.optStringIgnoreNulls(it, "type", "")));
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.setDescription(JSONExtKt.optStringIgnoreNulls(it, "description", ""));
                    $this$invoke_u24lambda_u2d1_u24lambda_u2d0.setCanPlayNum(jSONObject.optInt("canPlayNum", -1));
                }
            }
        }
        return musicAlbum;
    }
}
