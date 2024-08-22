package com.baidu.searchbox.music.ext.album.model;

import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.model.SongParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/music/ext/model/ISong;", "kotlin.jvm.PlatformType", "json", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicAlbumParser.kt */
final class MusicAlbumParserKt$PARSER_SONG$1 extends Lambda implements Function1<JSONObject, ISong> {
    public static final MusicAlbumParserKt$PARSER_SONG$1 INSTANCE = new MusicAlbumParserKt$PARSER_SONG$1();

    MusicAlbumParserKt$PARSER_SONG$1() {
        super(1);
    }

    public final ISong invoke(JSONObject json) {
        return SongParser.parseJsonAsSong(json);
    }
}
