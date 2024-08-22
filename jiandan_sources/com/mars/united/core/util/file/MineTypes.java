package com.mars.united.core.util.file;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/mars/united/core/util/file/MineTypes;", "", "mineType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMineType", "()Ljava/lang/String;", "MINE_JPEG", "MINE_PNG", "MINE_GIF", "MINE_NEF", "MINE_CR2", "MINE_DNG", "MINE_MP4", "MINE_MOV", "MINE_FLV", "MINE_UNKNOWN", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum MineTypes {
    MINE_JPEG("image/jpeg"),
    MINE_PNG("image/png"),
    MINE_GIF("image/gif"),
    MINE_NEF("image/x-nikon-nef"),
    MINE_CR2("image/x-canon-cr2"),
    MINE_DNG("image/x-adobe-dng"),
    MINE_MP4("video/mp4"),
    MINE_MOV("video/mov"),
    MINE_FLV("video/flv"),
    MINE_UNKNOWN("unknown");
    
    @NotNull
    public final String mineType;

    /* access modifiers changed from: public */
    MineTypes(String str) {
        this.mineType = str;
    }

    @NotNull
    public final String getMineType() {
        return this.mineType;
    }
}
