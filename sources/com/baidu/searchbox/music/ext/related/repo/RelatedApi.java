package com.baidu.searchbox.music.ext.related.repo;

import com.baidu.searchbox.music.ext.album.playback.playlist.db.PlaylistColumns;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.related.model.RelatedModel;
import com.baidu.searchbox.music.ext.repo.MusicApiService;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.Single;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/music/ext/related/repo/RelatedApi;", "Lcom/baidu/searchbox/music/ext/repo/MusicApiService;", "()V", "parserMusicRelated", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lcom/baidu/searchbox/music/ext/related/model/RelatedModel;", "requestRelatedModel", "Lrx/Single;", "song", "Lcom/baidu/searchbox/music/ext/model/ISong;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedApi.kt */
public final class RelatedApi extends MusicApiService {
    private final Function1<JSONObject, RelatedModel> parserMusicRelated = RelatedApi$parserMusicRelated$1.INSTANCE;

    public final Single<RelatedModel> requestRelatedModel(ISong song) {
        Intrinsics.checkNotNullParameter(song, "song");
        Single<RelatedModel> create = Single.create(new RelatedApi$$ExternalSyntheticLambda0(this, song));
        Intrinsics.checkNotNullExpressionValue(create, "create<RelatedModel> { s…erMusicRelated)\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: requestRelatedModel$lambda-2  reason: not valid java name */
    public static final void m1164requestRelatedModel$lambda2(RelatedApi this$0, ISong $song, SingleSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($song, "$song");
        Map params = new LinkedHashMap();
        Map $this$requestRelatedModel_u24lambda_u2d2_u24lambda_u2d1 = params;
        $this$requestRelatedModel_u24lambda_u2d2_u24lambda_u2d1.put("action", "recommend_song_tab");
        String name = $song.getName();
        Intrinsics.checkNotNullExpressionValue(name, "song.name");
        $this$requestRelatedModel_u24lambda_u2d2_u24lambda_u2d1.put("song_name", name);
        String uri = $song.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "song.uri");
        $this$requestRelatedModel_u24lambda_u2d2_u24lambda_u2d1.put(PlaylistColumns.SONG_URI, uri);
        String it = $song.getAlbumInfo().getCover();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            $this$requestRelatedModel_u24lambda_u2d2_u24lambda_u2d1.put(MusicExtStats.VALUE_PLAYER_TAB_IMAGE_CLICK, it);
        }
        String access$getAPI_URL$p = RelatedApiKt.API_URL;
        Intrinsics.checkNotNullExpressionValue(subscriber, "subscriber");
        this$0.sendGetRequest(access$getAPI_URL$p, params, subscriber, this$0.parserMusicRelated);
    }
}
