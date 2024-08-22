package com.baidu.searchbox.ad.position.list;

import com.baidu.searchbox.nps.INpsPluginLoaderKt;
import com.baidu.searchbox.ui.SystemBarTintManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\bo\b\b\u0018\u00002\u00020\u0001B½\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\"J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010h\u001a\u00020\u0005HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010p\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010;J\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010~\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003JÈ\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001e\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b6\u0010(\"\u0004\b7\u0010*R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R\u001e\u0010 \u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010!\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R\u001e\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bG\u0010(\"\u0004\bH\u0010*R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010B\"\u0004\bL\u0010DR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010B\"\u0004\bN\u0010DR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010$\"\u0004\bP\u0010&R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bQ\u0010(\"\u0004\bR\u0010*R\u001a\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00101\"\u0004\bT\u0010UR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00101\"\u0004\bW\u0010UR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00101\"\u0004\bY\u0010UR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010B\"\u0004\b[\u0010DR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010$\"\u0004\b]\u0010&R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b^\u0010(\"\u0004\b_\u0010*R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010$\"\u0004\ba\u0010&R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bb\u0010(\"\u0004\bc\u0010*R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010B\"\u0004\be\u0010D¨\u0006\u0001"}, d2 = {"Lcom/baidu/searchbox/ad/position/list/VideoPlayInfo;", "", "progressTime", "", "hasFinished", "", "replayCount", "show", "showTs", "", "endTs", "follow", "followTs", "like", "likeTs", "share", "shareTs", "collect", "collectTs", "comment", "commentTs", "enterUserPage", "enterUserPageTs", "exitUserPageTs", "resourceType", "", "width", "height", "layout", "floorPolicy", "duration", "playCount", "firstEndPos", "firstFinishCount", "(IZIZLjava/lang/Long;Ljava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;)V", "getCollect", "()Z", "setCollect", "(Z)V", "getCollectTs", "()Ljava/lang/Long;", "setCollectTs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getComment", "setComment", "getCommentTs", "setCommentTs", "getDuration", "()I", "getEndTs", "setEndTs", "getEnterUserPage", "setEnterUserPage", "getEnterUserPageTs", "setEnterUserPageTs", "getExitUserPageTs", "setExitUserPageTs", "getFirstEndPos", "()Ljava/lang/Integer;", "setFirstEndPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFirstFinishCount", "setFirstFinishCount", "getFloorPolicy", "()Ljava/lang/String;", "setFloorPolicy", "(Ljava/lang/String;)V", "getFollow", "setFollow", "getFollowTs", "setFollowTs", "getHasFinished", "setHasFinished", "getHeight", "setHeight", "getLayout", "setLayout", "getLike", "setLike", "getLikeTs", "setLikeTs", "getPlayCount", "setPlayCount", "(I)V", "getProgressTime", "setProgressTime", "getReplayCount", "setReplayCount", "getResourceType", "setResourceType", "getShare", "setShare", "getShareTs", "setShareTs", "getShow", "setShow", "getShowTs", "setShowTs", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IZIZLjava/lang/Long;Ljava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;)Lcom/baidu/searchbox/ad/position/list/VideoPlayInfo;", "equals", "other", "hashCode", "toString", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdListState.kt */
public final class VideoPlayInfo {
    private boolean collect;
    private Long collectTs;
    private boolean comment;
    private Long commentTs;
    private final int duration;
    private Long endTs;
    private boolean enterUserPage;
    private Long enterUserPageTs;
    private Long exitUserPageTs;
    private Integer firstEndPos;
    private Integer firstFinishCount;
    private String floorPolicy;
    private boolean follow;
    private Long followTs;
    private boolean hasFinished;
    private String height;
    private String layout;
    private boolean like;
    private Long likeTs;
    private int playCount;
    private int progressTime;
    private int replayCount;
    private String resourceType;
    private boolean share;
    private Long shareTs;
    private boolean show;
    private Long showTs;
    private String width;

    public VideoPlayInfo() {
        this(0, false, 0, false, (Long) null, (Long) null, false, (Long) null, false, (Long) null, false, (Long) null, false, (Long) null, false, (Long) null, false, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (Integer) null, (Integer) null, 268435455, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VideoPlayInfo copy$default(VideoPlayInfo videoPlayInfo, int i2, boolean z, int i3, boolean z2, Long l, Long l2, boolean z3, Long l3, boolean z4, Long l4, boolean z5, Long l5, boolean z6, Long l6, boolean z7, Long l7, boolean z8, Long l8, Long l9, String str, String str2, String str3, String str4, String str5, int i4, int i5, Integer num, Integer num2, int i6, Object obj) {
        VideoPlayInfo videoPlayInfo2 = videoPlayInfo;
        int i7 = i6;
        return videoPlayInfo.copy((i7 & 1) != 0 ? videoPlayInfo2.progressTime : i2, (i7 & 2) != 0 ? videoPlayInfo2.hasFinished : z, (i7 & 4) != 0 ? videoPlayInfo2.replayCount : i3, (i7 & 8) != 0 ? videoPlayInfo2.show : z2, (i7 & 16) != 0 ? videoPlayInfo2.showTs : l, (i7 & 32) != 0 ? videoPlayInfo2.endTs : l2, (i7 & 64) != 0 ? videoPlayInfo2.follow : z3, (i7 & 128) != 0 ? videoPlayInfo2.followTs : l3, (i7 & 256) != 0 ? videoPlayInfo2.like : z4, (i7 & 512) != 0 ? videoPlayInfo2.likeTs : l4, (i7 & 1024) != 0 ? videoPlayInfo2.share : z5, (i7 & 2048) != 0 ? videoPlayInfo2.shareTs : l5, (i7 & 4096) != 0 ? videoPlayInfo2.collect : z6, (i7 & 8192) != 0 ? videoPlayInfo2.collectTs : l6, (i7 & 16384) != 0 ? videoPlayInfo2.comment : z7, (i7 & 32768) != 0 ? videoPlayInfo2.commentTs : l7, (i7 & 65536) != 0 ? videoPlayInfo2.enterUserPage : z8, (i7 & 131072) != 0 ? videoPlayInfo2.enterUserPageTs : l8, (i7 & 262144) != 0 ? videoPlayInfo2.exitUserPageTs : l9, (i7 & 524288) != 0 ? videoPlayInfo2.resourceType : str, (i7 & 1048576) != 0 ? videoPlayInfo2.width : str2, (i7 & 2097152) != 0 ? videoPlayInfo2.height : str3, (i7 & 4194304) != 0 ? videoPlayInfo2.layout : str4, (i7 & 8388608) != 0 ? videoPlayInfo2.floorPolicy : str5, (i7 & 16777216) != 0 ? videoPlayInfo2.duration : i4, (i7 & INpsPluginLoaderKt.CACHE_MODE_IOC) != 0 ? videoPlayInfo2.playCount : i5, (i7 & 67108864) != 0 ? videoPlayInfo2.firstEndPos : num, (i7 & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0 ? videoPlayInfo2.firstFinishCount : num2);
    }

    public final int component1() {
        return this.progressTime;
    }

    public final Long component10() {
        return this.likeTs;
    }

    public final boolean component11() {
        return this.share;
    }

    public final Long component12() {
        return this.shareTs;
    }

    public final boolean component13() {
        return this.collect;
    }

    public final Long component14() {
        return this.collectTs;
    }

    public final boolean component15() {
        return this.comment;
    }

    public final Long component16() {
        return this.commentTs;
    }

    public final boolean component17() {
        return this.enterUserPage;
    }

    public final Long component18() {
        return this.enterUserPageTs;
    }

    public final Long component19() {
        return this.exitUserPageTs;
    }

    public final boolean component2() {
        return this.hasFinished;
    }

    public final String component20() {
        return this.resourceType;
    }

    public final String component21() {
        return this.width;
    }

    public final String component22() {
        return this.height;
    }

    public final String component23() {
        return this.layout;
    }

    public final String component24() {
        return this.floorPolicy;
    }

    public final int component25() {
        return this.duration;
    }

    public final int component26() {
        return this.playCount;
    }

    public final Integer component27() {
        return this.firstEndPos;
    }

    public final Integer component28() {
        return this.firstFinishCount;
    }

    public final int component3() {
        return this.replayCount;
    }

    public final boolean component4() {
        return this.show;
    }

    public final Long component5() {
        return this.showTs;
    }

    public final Long component6() {
        return this.endTs;
    }

    public final boolean component7() {
        return this.follow;
    }

    public final Long component8() {
        return this.followTs;
    }

    public final boolean component9() {
        return this.like;
    }

    public final VideoPlayInfo copy(int i2, boolean z, int i3, boolean z2, Long l, Long l2, boolean z3, Long l3, boolean z4, Long l4, boolean z5, Long l5, boolean z6, Long l6, boolean z7, Long l7, boolean z8, Long l8, Long l9, String str, String str2, String str3, String str4, String str5, int i4, int i5, Integer num, Integer num2) {
        return new VideoPlayInfo(i2, z, i3, z2, l, l2, z3, l3, z4, l4, z5, l5, z6, l6, z7, l7, z8, l8, l9, str, str2, str3, str4, str5, i4, i5, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoPlayInfo)) {
            return false;
        }
        VideoPlayInfo videoPlayInfo = (VideoPlayInfo) obj;
        return this.progressTime == videoPlayInfo.progressTime && this.hasFinished == videoPlayInfo.hasFinished && this.replayCount == videoPlayInfo.replayCount && this.show == videoPlayInfo.show && Intrinsics.areEqual((Object) this.showTs, (Object) videoPlayInfo.showTs) && Intrinsics.areEqual((Object) this.endTs, (Object) videoPlayInfo.endTs) && this.follow == videoPlayInfo.follow && Intrinsics.areEqual((Object) this.followTs, (Object) videoPlayInfo.followTs) && this.like == videoPlayInfo.like && Intrinsics.areEqual((Object) this.likeTs, (Object) videoPlayInfo.likeTs) && this.share == videoPlayInfo.share && Intrinsics.areEqual((Object) this.shareTs, (Object) videoPlayInfo.shareTs) && this.collect == videoPlayInfo.collect && Intrinsics.areEqual((Object) this.collectTs, (Object) videoPlayInfo.collectTs) && this.comment == videoPlayInfo.comment && Intrinsics.areEqual((Object) this.commentTs, (Object) videoPlayInfo.commentTs) && this.enterUserPage == videoPlayInfo.enterUserPage && Intrinsics.areEqual((Object) this.enterUserPageTs, (Object) videoPlayInfo.enterUserPageTs) && Intrinsics.areEqual((Object) this.exitUserPageTs, (Object) videoPlayInfo.exitUserPageTs) && Intrinsics.areEqual((Object) this.resourceType, (Object) videoPlayInfo.resourceType) && Intrinsics.areEqual((Object) this.width, (Object) videoPlayInfo.width) && Intrinsics.areEqual((Object) this.height, (Object) videoPlayInfo.height) && Intrinsics.areEqual((Object) this.layout, (Object) videoPlayInfo.layout) && Intrinsics.areEqual((Object) this.floorPolicy, (Object) videoPlayInfo.floorPolicy) && this.duration == videoPlayInfo.duration && this.playCount == videoPlayInfo.playCount && Intrinsics.areEqual((Object) this.firstEndPos, (Object) videoPlayInfo.firstEndPos) && Intrinsics.areEqual((Object) this.firstFinishCount, (Object) videoPlayInfo.firstFinishCount);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.progressTime) * 31;
        boolean z = this.hasFinished;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.replayCount)) * 31;
        boolean z3 = this.show;
        if (z3) {
            z3 = true;
        }
        int i2 = (hashCode2 + (z3 ? 1 : 0)) * 31;
        Long l = this.showTs;
        int i3 = 0;
        int hashCode3 = (i2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.endTs;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        boolean z4 = this.follow;
        if (z4) {
            z4 = true;
        }
        int i4 = (hashCode4 + (z4 ? 1 : 0)) * 31;
        Long l3 = this.followTs;
        int hashCode5 = (i4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        boolean z5 = this.like;
        if (z5) {
            z5 = true;
        }
        int i5 = (hashCode5 + (z5 ? 1 : 0)) * 31;
        Long l4 = this.likeTs;
        int hashCode6 = (i5 + (l4 == null ? 0 : l4.hashCode())) * 31;
        boolean z6 = this.share;
        if (z6) {
            z6 = true;
        }
        int i6 = (hashCode6 + (z6 ? 1 : 0)) * 31;
        Long l5 = this.shareTs;
        int hashCode7 = (i6 + (l5 == null ? 0 : l5.hashCode())) * 31;
        boolean z7 = this.collect;
        if (z7) {
            z7 = true;
        }
        int i7 = (hashCode7 + (z7 ? 1 : 0)) * 31;
        Long l6 = this.collectTs;
        int hashCode8 = (i7 + (l6 == null ? 0 : l6.hashCode())) * 31;
        boolean z8 = this.comment;
        if (z8) {
            z8 = true;
        }
        int i8 = (hashCode8 + (z8 ? 1 : 0)) * 31;
        Long l7 = this.commentTs;
        int hashCode9 = (i8 + (l7 == null ? 0 : l7.hashCode())) * 31;
        boolean z9 = this.enterUserPage;
        if (!z9) {
            z2 = z9;
        }
        int i9 = (hashCode9 + (z2 ? 1 : 0)) * 31;
        Long l8 = this.enterUserPageTs;
        int hashCode10 = (i9 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.exitUserPageTs;
        int hashCode11 = (hashCode10 + (l9 == null ? 0 : l9.hashCode())) * 31;
        String str = this.resourceType;
        int hashCode12 = (hashCode11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.width;
        int hashCode13 = (hashCode12 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.height;
        int hashCode14 = (hashCode13 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.layout;
        int hashCode15 = (hashCode14 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.floorPolicy;
        int hashCode16 = (((((hashCode15 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.duration)) * 31) + Integer.hashCode(this.playCount)) * 31;
        Integer num = this.firstEndPos;
        int hashCode17 = (hashCode16 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.firstFinishCount;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        return hashCode17 + i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoPlayInfo(progressTime=").append(this.progressTime).append(", hasFinished=").append(this.hasFinished).append(", replayCount=").append(this.replayCount).append(", show=").append(this.show).append(", showTs=").append(this.showTs).append(", endTs=").append(this.endTs).append(", follow=").append(this.follow).append(", followTs=").append(this.followTs).append(", like=").append(this.like).append(", likeTs=").append(this.likeTs).append(", share=").append(this.share).append(", shareTs=");
        sb.append(this.shareTs).append(", collect=").append(this.collect).append(", collectTs=").append(this.collectTs).append(", comment=").append(this.comment).append(", commentTs=").append(this.commentTs).append(", enterUserPage=").append(this.enterUserPage).append(", enterUserPageTs=").append(this.enterUserPageTs).append(", exitUserPageTs=").append(this.exitUserPageTs).append(", resourceType=").append(this.resourceType).append(", width=").append(this.width).append(", height=").append(this.height).append(", layout=").append(this.layout);
        sb.append(", floorPolicy=").append(this.floorPolicy).append(", duration=").append(this.duration).append(", playCount=").append(this.playCount).append(", firstEndPos=").append(this.firstEndPos).append(", firstFinishCount=").append(this.firstFinishCount).append(')');
        return sb.toString();
    }

    public VideoPlayInfo(int progressTime2, boolean hasFinished2, int replayCount2, boolean show2, Long showTs2, Long endTs2, boolean follow2, Long followTs2, boolean like2, Long likeTs2, boolean share2, Long shareTs2, boolean collect2, Long collectTs2, boolean comment2, Long commentTs2, boolean enterUserPage2, Long enterUserPageTs2, Long exitUserPageTs2, String resourceType2, String width2, String height2, String layout2, String floorPolicy2, int duration2, int playCount2, Integer firstEndPos2, Integer firstFinishCount2) {
        this.progressTime = progressTime2;
        this.hasFinished = hasFinished2;
        this.replayCount = replayCount2;
        this.show = show2;
        this.showTs = showTs2;
        this.endTs = endTs2;
        this.follow = follow2;
        this.followTs = followTs2;
        this.like = like2;
        this.likeTs = likeTs2;
        this.share = share2;
        this.shareTs = shareTs2;
        this.collect = collect2;
        this.collectTs = collectTs2;
        this.comment = comment2;
        this.commentTs = commentTs2;
        this.enterUserPage = enterUserPage2;
        this.enterUserPageTs = enterUserPageTs2;
        this.exitUserPageTs = exitUserPageTs2;
        this.resourceType = resourceType2;
        this.width = width2;
        this.height = height2;
        this.layout = layout2;
        this.floorPolicy = floorPolicy2;
        this.duration = duration2;
        this.playCount = playCount2;
        this.firstEndPos = firstEndPos2;
        this.firstFinishCount = firstFinishCount2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VideoPlayInfo(int r30, boolean r31, int r32, boolean r33, java.lang.Long r34, java.lang.Long r35, boolean r36, java.lang.Long r37, boolean r38, java.lang.Long r39, boolean r40, java.lang.Long r41, boolean r42, java.lang.Long r43, boolean r44, java.lang.Long r45, boolean r46, java.lang.Long r47, java.lang.Long r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, int r54, int r55, java.lang.Integer r56, java.lang.Integer r57, int r58, kotlin.jvm.internal.DefaultConstructorMarker r59) {
        /*
            r29 = this;
            r0 = r58
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r30
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r31
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r32
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r33
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r34
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = 0
            goto L_0x0032
        L_0x0030:
            r8 = r35
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r36
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r37
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            r11 = 0
            goto L_0x004a
        L_0x0048:
            r11 = r38
        L_0x004a:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r39
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r40
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r41
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r42
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r43
        L_0x0072:
            r7 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x0078
            r7 = 0
            goto L_0x007a
        L_0x0078:
            r7 = r44
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r45
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r46
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r47
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r48
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r49
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r50
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r51
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r52
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r53
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = -1
            goto L_0x00e9
        L_0x00e7:
            r25 = r54
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r55
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r56
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r28
            if (r0 == 0) goto L_0x0107
            r0 = 0
            goto L_0x0109
        L_0x0107:
            r0 = r57
        L_0x0109:
            r30 = r1
            r31 = r3
            r32 = r4
            r33 = r5
            r34 = r6
            r35 = r8
            r36 = r9
            r37 = r10
            r38 = r11
            r39 = r12
            r40 = r13
            r41 = r14
            r42 = r15
            r43 = r2
            r44 = r7
            r45 = r16
            r46 = r17
            r47 = r18
            r48 = r19
            r49 = r20
            r50 = r21
            r51 = r22
            r52 = r23
            r53 = r24
            r54 = r25
            r55 = r26
            r56 = r27
            r57 = r0
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ad.position.list.VideoPlayInfo.<init>(int, boolean, int, boolean, java.lang.Long, java.lang.Long, boolean, java.lang.Long, boolean, java.lang.Long, boolean, java.lang.Long, boolean, java.lang.Long, boolean, java.lang.Long, boolean, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getProgressTime() {
        return this.progressTime;
    }

    public final void setProgressTime(int i2) {
        this.progressTime = i2;
    }

    public final boolean getHasFinished() {
        return this.hasFinished;
    }

    public final void setHasFinished(boolean z) {
        this.hasFinished = z;
    }

    public final int getReplayCount() {
        return this.replayCount;
    }

    public final void setReplayCount(int i2) {
        this.replayCount = i2;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setShow(boolean z) {
        this.show = z;
    }

    public final Long getShowTs() {
        return this.showTs;
    }

    public final void setShowTs(Long l) {
        this.showTs = l;
    }

    public final Long getEndTs() {
        return this.endTs;
    }

    public final void setEndTs(Long l) {
        this.endTs = l;
    }

    public final boolean getFollow() {
        return this.follow;
    }

    public final void setFollow(boolean z) {
        this.follow = z;
    }

    public final Long getFollowTs() {
        return this.followTs;
    }

    public final void setFollowTs(Long l) {
        this.followTs = l;
    }

    public final boolean getLike() {
        return this.like;
    }

    public final void setLike(boolean z) {
        this.like = z;
    }

    public final Long getLikeTs() {
        return this.likeTs;
    }

    public final void setLikeTs(Long l) {
        this.likeTs = l;
    }

    public final boolean getShare() {
        return this.share;
    }

    public final void setShare(boolean z) {
        this.share = z;
    }

    public final Long getShareTs() {
        return this.shareTs;
    }

    public final void setShareTs(Long l) {
        this.shareTs = l;
    }

    public final boolean getCollect() {
        return this.collect;
    }

    public final void setCollect(boolean z) {
        this.collect = z;
    }

    public final Long getCollectTs() {
        return this.collectTs;
    }

    public final void setCollectTs(Long l) {
        this.collectTs = l;
    }

    public final boolean getComment() {
        return this.comment;
    }

    public final void setComment(boolean z) {
        this.comment = z;
    }

    public final Long getCommentTs() {
        return this.commentTs;
    }

    public final void setCommentTs(Long l) {
        this.commentTs = l;
    }

    public final boolean getEnterUserPage() {
        return this.enterUserPage;
    }

    public final void setEnterUserPage(boolean z) {
        this.enterUserPage = z;
    }

    public final Long getEnterUserPageTs() {
        return this.enterUserPageTs;
    }

    public final void setEnterUserPageTs(Long l) {
        this.enterUserPageTs = l;
    }

    public final Long getExitUserPageTs() {
        return this.exitUserPageTs;
    }

    public final void setExitUserPageTs(Long l) {
        this.exitUserPageTs = l;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final void setResourceType(String str) {
        this.resourceType = str;
    }

    public final String getWidth() {
        return this.width;
    }

    public final void setWidth(String str) {
        this.width = str;
    }

    public final String getHeight() {
        return this.height;
    }

    public final void setHeight(String str) {
        this.height = str;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final void setLayout(String str) {
        this.layout = str;
    }

    public final String getFloorPolicy() {
        return this.floorPolicy;
    }

    public final void setFloorPolicy(String str) {
        this.floorPolicy = str;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final void setPlayCount(int i2) {
        this.playCount = i2;
    }

    public final Integer getFirstEndPos() {
        return this.firstEndPos;
    }

    public final void setFirstEndPos(Integer num) {
        this.firstEndPos = num;
    }

    public final Integer getFirstFinishCount() {
        return this.firstFinishCount;
    }

    public final void setFirstFinishCount(Integer num) {
        this.firstFinishCount = num;
    }
}
