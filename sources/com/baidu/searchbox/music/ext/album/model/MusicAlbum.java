package com.baidu.searchbox.music.ext.album.model;

import com.baidu.searchbox.music.ext.model.ISong;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010\u0000J\b\u00100\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00062"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "Ljava/io/Serializable;", "id", "", "(Ljava/lang/String;)V", "canPlayNum", "", "getCanPlayNum", "()I", "setCanPlayNum", "(I)V", "<set-?>", "coverUrl", "getCoverUrl", "()Ljava/lang/String;", "", "createTime", "getCreateTime", "()J", "description", "getDescription", "setDescription", "getId", "", "isCollectable", "()Z", "isCollected", "setCollected", "(Z)V", "isFavorite", "isModifiable", "isSongModifiable", "name", "getName", "songNum", "getSongNum", "type", "Lcom/baidu/searchbox/music/ext/album/model/AlbumType;", "getType", "()Lcom/baidu/searchbox/music/ext/album/model/AlbumType;", "setType", "(Lcom/baidu/searchbox/music/ext/album/model/AlbumType;)V", "equals", "other", "", "hashCode", "merge", "update", "toString", "Companion", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicAlbum.kt */
public final class MusicAlbum implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function1<JSONObject, MusicAlbum> PARSER_ALBUM = MusicAlbum$Companion$PARSER_ALBUM$1.INSTANCE;
    private int canPlayNum = -1;
    /* access modifiers changed from: private */
    public String coverUrl;
    /* access modifiers changed from: private */
    public long createTime;
    private String description = "";
    private final String id;
    /* access modifiers changed from: private */
    public boolean isCollectable;
    private boolean isCollected;
    /* access modifiers changed from: private */
    public boolean isFavorite;
    /* access modifiers changed from: private */
    public boolean isModifiable;
    /* access modifiers changed from: private */
    public boolean isSongModifiable;
    /* access modifiers changed from: private */
    public String name = "";
    /* access modifiers changed from: private */
    public long songNum;
    private AlbumType type = AlbumType.UNKNOWN;

    public MusicAlbum(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.id = id2;
    }

    public final String getId() {
        return this.id;
    }

    public final AlbumType getType() {
        return this.type;
    }

    public final void setType(AlbumType albumType) {
        Intrinsics.checkNotNullParameter(albumType, "<set-?>");
        this.type = albumType;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSongNum() {
        return this.songNum;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final boolean isModifiable() {
        return this.isModifiable;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final boolean isCollectable() {
        return this.isCollectable;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final boolean isSongModifiable() {
        return this.isSongModifiable;
    }

    public final boolean isCollected() {
        return this.isCollected;
    }

    public final void setCollected(boolean z) {
        this.isCollected = z;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final int getCanPlayNum() {
        return this.canPlayNum;
    }

    public final void setCanPlayNum(int i2) {
        this.canPlayNum = i2;
    }

    public final MusicAlbum merge(MusicAlbum update) {
        if (update != null && Intrinsics.areEqual((Object) this.id, (Object) update.id)) {
            boolean z = true;
            this.name = update.name.length() > 0 ? update.name : this.name;
            long j2 = update.songNum;
            if (j2 < 0) {
                j2 = this.songNum;
            }
            this.songNum = j2;
            CharSequence charSequence = update.coverUrl;
            this.coverUrl = !(charSequence == null || charSequence.length() == 0) ? update.coverUrl : this.coverUrl;
            this.isModifiable = update.isModifiable;
            this.isCollectable = update.isCollectable;
            this.isFavorite = update.isFavorite;
            long j3 = update.createTime;
            if (j3 < 0) {
                j3 = this.createTime;
            }
            this.createTime = j3;
            this.type = update.type != AlbumType.UNKNOWN ? update.type : this.type;
            if (update.description.length() <= 0) {
                z = false;
            }
            this.description = z ? update.description : this.description;
            int i2 = update.canPlayNum;
            if (i2 < 0) {
                i2 = this.canPlayNum;
            }
            this.canPlayNum = i2;
        }
        return this;
    }

    public String toString() {
        return "MusicAlbum{id='" + this.id + "', name='" + this.name + "', songNum=" + this.songNum + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            MusicAlbum musicAlbum = (MusicAlbum) other;
            if (this.type == ((MusicAlbum) other).type && Intrinsics.areEqual((Object) this.id, (Object) ((MusicAlbum) other).id)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.music.ext.album.model.MusicAlbum");
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.id.hashCode();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ \u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010R$\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum$Companion;", "", "()V", "PARSER_ALBUM", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "getPARSER_ALBUM$lib_music_ext_release", "()Lkotlin/jvm/functions/Function1;", "hotSongAlbum", "localFavorAlbum", "localRecentAlbum", "ofRelatedSong", "song", "Lcom/baidu/searchbox/music/ext/model/ISong;", "songUri", "", "songName", "songCover", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MusicAlbum.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<JSONObject, MusicAlbum> getPARSER_ALBUM$lib_music_ext_release() {
            return MusicAlbum.PARSER_ALBUM;
        }

        public final MusicAlbum localFavorAlbum() {
            MusicAlbum musicAlbum = new MusicAlbum("0");
            MusicAlbum $this$localFavorAlbum_u24lambda_u2d0 = musicAlbum;
            $this$localFavorAlbum_u24lambda_u2d0.setType(AlbumType.CUSTOM);
            $this$localFavorAlbum_u24lambda_u2d0.isFavorite = true;
            return musicAlbum;
        }

        public final MusicAlbum localRecentAlbum() {
            MusicAlbum $this$localRecentAlbum_u24lambda_u2d1 = new MusicAlbum("-1");
            $this$localRecentAlbum_u24lambda_u2d1.setType(AlbumType.RECENT);
            return $this$localRecentAlbum_u24lambda_u2d1;
        }

        public final MusicAlbum ofRelatedSong(ISong song) {
            Intrinsics.checkNotNullParameter(song, "song");
            ISong $this$ofRelatedSong_u24lambda_u2d2 = song;
            Companion companion = MusicAlbum.Companion;
            String uri = $this$ofRelatedSong_u24lambda_u2d2.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "uri");
            String name = $this$ofRelatedSong_u24lambda_u2d2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            return companion.ofRelatedSong(uri, name, $this$ofRelatedSong_u24lambda_u2d2.getAlbumInfo().getCover());
        }

        public final MusicAlbum ofRelatedSong(String songUri, String songName, String songCover) {
            Intrinsics.checkNotNullParameter(songUri, "songUri");
            Intrinsics.checkNotNullParameter(songName, "songName");
            MusicAlbum musicAlbum = new MusicAlbum(songUri);
            MusicAlbum $this$ofRelatedSong_u24lambda_u2d3 = musicAlbum;
            $this$ofRelatedSong_u24lambda_u2d3.setType(AlbumType.RELATED);
            $this$ofRelatedSong_u24lambda_u2d3.name = songName;
            $this$ofRelatedSong_u24lambda_u2d3.coverUrl = songCover;
            return musicAlbum;
        }

        public final MusicAlbum hotSongAlbum() {
            MusicAlbum $this$hotSongAlbum_u24lambda_u2d4 = new MusicAlbum("rege");
            $this$hotSongAlbum_u24lambda_u2d4.setType(AlbumType.LEADERBOARD);
            return $this$hotSongAlbum_u24lambda_u2d4;
        }
    }
}
