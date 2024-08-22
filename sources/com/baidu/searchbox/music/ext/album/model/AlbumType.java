package com.baidu.searchbox.music.ext.album.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/model/AlbumType;", "", "includeInRecent", "", "(Ljava/lang/String;IZ)V", "getIncludeInRecent", "()Z", "toIntText", "", "RECENT", "COLLECT", "CUSTOM", "SINGER", "RELATED", "LEADERBOARD", "UNKNOWN", "Companion", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumType.kt */
public enum AlbumType {
    RECENT(true),
    COLLECT(true),
    CUSTOM(true),
    SINGER(false),
    RELATED(false),
    LEADERBOARD(true),
    UNKNOWN(false);
    
    public static final Companion Companion = null;
    private final boolean includeInRecent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlbumType.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[AlbumType.values().length];
            iArr[AlbumType.RECENT.ordinal()] = 1;
            iArr[AlbumType.CUSTOM.ordinal()] = 2;
            iArr[AlbumType.COLLECT.ordinal()] = 3;
            iArr[AlbumType.SINGER.ordinal()] = 4;
            iArr[AlbumType.RELATED.ordinal()] = 5;
            iArr[AlbumType.LEADERBOARD.ordinal()] = 6;
            iArr[AlbumType.UNKNOWN.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AlbumType(boolean includeInRecent2) {
        this.includeInRecent = includeInRecent2;
    }

    public final boolean getIncludeInRecent() {
        return this.includeInRecent;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final String toIntText() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            default:
                return "";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/model/AlbumType$Companion;", "", "()V", "fromIntText", "Lcom/baidu/searchbox/music/ext/album/model/AlbumType;", "type", "", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlbumType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AlbumType fromIntText(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            switch (type.hashCode()) {
                case 49:
                    if (type.equals("1")) {
                        return AlbumType.RECENT;
                    }
                    break;
                case 50:
                    if (type.equals("2")) {
                        return AlbumType.CUSTOM;
                    }
                    break;
                case 51:
                    if (type.equals("3")) {
                        return AlbumType.COLLECT;
                    }
                    break;
                case 52:
                    if (type.equals("4")) {
                        return AlbumType.SINGER;
                    }
                    break;
                case 53:
                    if (type.equals("5")) {
                        return AlbumType.RELATED;
                    }
                    break;
                case 54:
                    if (type.equals("6")) {
                        return AlbumType.LEADERBOARD;
                    }
                    break;
            }
            return AlbumType.UNKNOWN;
        }
    }
}
