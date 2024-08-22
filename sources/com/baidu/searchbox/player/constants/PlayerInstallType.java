package com.baidu.searchbox.player.constants;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/constants/PlayerInstallType;", "", "()V", "INSTALL_TYPE_CYBER_MEDIA", "", "LIB_TYPE_CRASHPAD", "LIB_TYPE_FFMPEG_EXTEND", "LIB_TYPE_PCDN", "LIB_TYPE_RTC", "LIB_TYPE_VIDEO_SR", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerInstallType.kt */
public final class PlayerInstallType {
    public static final int INSTALL_TYPE_CYBER_MEDIA = 1;
    public static final PlayerInstallType INSTANCE = new PlayerInstallType();
    public static final int LIB_TYPE_CRASHPAD = 16;
    public static final int LIB_TYPE_FFMPEG_EXTEND = 4;
    public static final int LIB_TYPE_PCDN = 2;
    public static final int LIB_TYPE_RTC = 32;
    public static final int LIB_TYPE_VIDEO_SR = 8;

    private PlayerInstallType() {
    }
}
