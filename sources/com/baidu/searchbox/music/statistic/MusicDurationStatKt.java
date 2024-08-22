package com.baidu.searchbox.music.statistic;

import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"DEBUG", "", "TAG", "", "UBC_EXT_KEY_CONTENT", "UBC_EXT_KEY_PROD_TYPE", "UBC_EXT_KEY_REPEAT", "UBC_EXT_KEY_SE_LID", "UBC_EXT_KEY_SE_SOURCE", "UBC_EXT_KEY_SINGER", "UBC_EXT_KEY_SONG_ID", "UBC_EXT_VALUE_PROD_TYPE_BACKSTAGE", "UBC_EXT_VALUE_PROD_TYPE_BAIDU", "UBC_EXT_VALUE_SE_SOURCE_MUSIC", "UBC_FLOW_KEY_MUSIC_FLOAT_BACK_6334", "UBC_FLOW_KEY_MUSIC_FLOAT_FRONT_6334", "UBC_FLOW_KEY_MUSIC_FULL_BACK_6334", "UBC_FLOW_KEY_MUSIC_FULL_FRONT_6334", "UBC_FLOW_KEY_MUSIC_MINI_BACK_6334", "UBC_FLOW_KEY_MUSIC_MINI_FRONT_6334", "UBC_FLOW_KEY_MUSIC_NONE_6334", "UBC_ID_SEARCH_MUSIC_DURATION", "UBC_VALUE_FROM_SEARCH", "UBC_VALUE_PAGE_MUSIC", "UBC_VALUE_TYPE_FLOATING", "UBC_VALUE_TYPE_FULL", "UBC_VALUE_TYPE_MINI_BAR", "UBC_VALUE_TYPE_NONE", "lib-music-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicDurationStat.kt */
public final class MusicDurationStatKt {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "MusicDurationStat";
    private static final String UBC_EXT_KEY_CONTENT = "content";
    private static final String UBC_EXT_KEY_PROD_TYPE = "prod_type";
    private static final String UBC_EXT_KEY_REPEAT = "repeat";
    private static final String UBC_EXT_KEY_SE_LID = "se_lid";
    private static final String UBC_EXT_KEY_SE_SOURCE = "se_source";
    private static final String UBC_EXT_KEY_SINGER = "singer";
    private static final String UBC_EXT_KEY_SONG_ID = "url";
    private static final String UBC_EXT_VALUE_PROD_TYPE_BACKSTAGE = "backstage";
    private static final String UBC_EXT_VALUE_PROD_TYPE_BAIDU = "baidu";
    private static final String UBC_EXT_VALUE_SE_SOURCE_MUSIC = "music";
    public static final String UBC_FLOW_KEY_MUSIC_FLOAT_BACK_6334 = "MUSIC_FLOAT_BACK_6334";
    public static final String UBC_FLOW_KEY_MUSIC_FLOAT_FRONT_6334 = "MUSIC_FLOAT_FRONT_6334";
    public static final String UBC_FLOW_KEY_MUSIC_FULL_BACK_6334 = "MUSIC_FULL_BACK_6334";
    public static final String UBC_FLOW_KEY_MUSIC_FULL_FRONT_6334 = "MUSIC_FULL_FRONT_6334";
    public static final String UBC_FLOW_KEY_MUSIC_MINI_BACK_6334 = "MUSIC_MINI_BACK_6334";
    public static final String UBC_FLOW_KEY_MUSIC_MINI_FRONT_6334 = "MUSIC_MINI_FRONT_6334";
    public static final String UBC_FLOW_KEY_MUSIC_NONE_6334 = "";
    private static final String UBC_ID_SEARCH_MUSIC_DURATION = "6334";
    private static final String UBC_VALUE_FROM_SEARCH = "search";
    private static final String UBC_VALUE_PAGE_MUSIC = "music";
    private static final String UBC_VALUE_TYPE_FLOATING = "floating";
    private static final String UBC_VALUE_TYPE_FULL = "full";
    private static final String UBC_VALUE_TYPE_MINI_BAR = "minibar";
    private static final String UBC_VALUE_TYPE_NONE = "";
}
