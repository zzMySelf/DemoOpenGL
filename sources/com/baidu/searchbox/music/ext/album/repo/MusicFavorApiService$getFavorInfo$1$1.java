package com.baidu.searchbox.music.ext.album.repo;

import com.baidu.searchbox.music.ext.favor.SongFavorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/music/ext/favor/SongFavorInfo;", "data", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicFavorApiService.kt */
final class MusicFavorApiService$getFavorInfo$1$1 extends Lambda implements Function1<JSONObject, SongFavorInfo> {
    public static final MusicFavorApiService$getFavorInfo$1$1 INSTANCE = new MusicFavorApiService$getFavorInfo$1$1();

    MusicFavorApiService$getFavorInfo$1$1() {
        super(1);
    }

    public final SongFavorInfo invoke(JSONObject data) {
        return new SongFavorInfo(Intrinsics.areEqual((Object) "1", (Object) data != null ? data.optString("is_liked") : null), data != null ? data.optLong("collect_number") : -1);
    }
}
