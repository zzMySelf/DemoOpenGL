package com.baidu.searchbox.music.ext.repo.song;

import com.baidu.searchbox.music.bean.CommentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J'\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/music/ext/repo/song/SongReqParam;", "", "songUri", "", "songName", "singerName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "comment", "Lcom/baidu/searchbox/music/bean/CommentInfo;", "getComment", "()Lcom/baidu/searchbox/music/bean/CommentInfo;", "setComment", "(Lcom/baidu/searchbox/music/bean/CommentInfo;)V", "needComment", "", "getNeedComment", "()Z", "setNeedComment", "(Z)V", "needUpdatePlayUrl", "getNeedUpdatePlayUrl", "setNeedUpdatePlayUrl", "getSingerName", "()Ljava/lang/String;", "songLoc", "getSongLoc", "setSongLoc", "(Ljava/lang/String;)V", "getSongName", "getSongUri", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SongApi.kt */
public final class SongReqParam {
    private CommentInfo comment;
    private boolean needComment;
    private boolean needUpdatePlayUrl;
    private final String singerName;
    private String songLoc;
    private final String songName;
    private final String songUri;

    public static /* synthetic */ SongReqParam copy$default(SongReqParam songReqParam, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = songReqParam.songUri;
        }
        if ((i2 & 2) != 0) {
            str2 = songReqParam.songName;
        }
        if ((i2 & 4) != 0) {
            str3 = songReqParam.singerName;
        }
        return songReqParam.copy(str, str2, str3);
    }

    public final String component1() {
        return this.songUri;
    }

    public final String component2() {
        return this.songName;
    }

    public final String component3() {
        return this.singerName;
    }

    public final SongReqParam copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "songUri");
        Intrinsics.checkNotNullParameter(str2, "songName");
        Intrinsics.checkNotNullParameter(str3, "singerName");
        return new SongReqParam(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SongReqParam)) {
            return false;
        }
        SongReqParam songReqParam = (SongReqParam) obj;
        return Intrinsics.areEqual((Object) this.songUri, (Object) songReqParam.songUri) && Intrinsics.areEqual((Object) this.songName, (Object) songReqParam.songName) && Intrinsics.areEqual((Object) this.singerName, (Object) songReqParam.singerName);
    }

    public int hashCode() {
        return (((this.songUri.hashCode() * 31) + this.songName.hashCode()) * 31) + this.singerName.hashCode();
    }

    public String toString() {
        return "SongReqParam(songUri=" + this.songUri + ", songName=" + this.songName + ", singerName=" + this.singerName + ')';
    }

    public SongReqParam(String songUri2, String songName2, String singerName2) {
        Intrinsics.checkNotNullParameter(songUri2, "songUri");
        Intrinsics.checkNotNullParameter(songName2, "songName");
        Intrinsics.checkNotNullParameter(singerName2, "singerName");
        this.songUri = songUri2;
        this.songName = songName2;
        this.singerName = singerName2;
    }

    public final String getSongUri() {
        return this.songUri;
    }

    public final String getSongName() {
        return this.songName;
    }

    public final String getSingerName() {
        return this.singerName;
    }

    public final boolean getNeedComment() {
        return this.needComment;
    }

    public final void setNeedComment(boolean z) {
        this.needComment = z;
    }

    public final CommentInfo getComment() {
        return this.comment;
    }

    public final void setComment(CommentInfo commentInfo) {
        this.comment = commentInfo;
    }

    public final boolean getNeedUpdatePlayUrl() {
        return this.needUpdatePlayUrl;
    }

    public final void setNeedUpdatePlayUrl(boolean z) {
        this.needUpdatePlayUrl = z;
    }

    public final String getSongLoc() {
        return this.songLoc;
    }

    public final void setSongLoc(String str) {
        this.songLoc = str;
    }
}
