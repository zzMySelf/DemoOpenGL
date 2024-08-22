package com.baidu.searchbox.music.ext.statistic;

import com.baidu.searchbox.music.bean.PlayerDurationStatInfo;
import com.baidu.searchbox.music.ext.services.MusicServices;
import com.baidu.searchbox.nacomp.util.UniqueId;

public class MusicExtStats {
    public static final String DATA_SOURCE_ALBUM_SERVER = "albumServer";
    public static final String DEFAULT_CHANNEL_SOURCE = "other";
    public static final String EXT_KEY_EXT_JSON = "extJson";
    public static final String EXT_KEY_PAGE_FROM = "pageFrom";
    public static final String EXT_KEY_PATH_TAGS = "musicFrom";
    public static final String OTHER_CHANNEL_SOURCE = "other";
    public static final String PAGE = "aladdin";
    public static final String PAGE_ALBUM_LIST = "songlist_aggregate";
    public static final String PAGE_COLLECT_ALBUM_DETAIL = "collect_songdetail";
    public static final String PAGE_CUSTOM_ALBUM_DETAIL = "create_songdetail";
    public static final String PAGE_FAVOR_ALBUM_DETAIL = "like_songdetail";
    public static final String PAGE_FULL = "full";
    public static final String PAGE_LEADERBOARD_DETAIL = "leaderboard_songdetail";
    public static final String PAGE_LYRIC = "lyrics";
    public static final String PAGE_LYRIC_COPY = "lyrics_select";
    public static final String PAGE_MUSIC_COMMENT = "all_comment";
    public static final String PAGE_MY_MUSIC = "my_music";
    public static final String PAGE_PLAYER_TAB = "homepage";
    public static final String PAGE_PLAY_PANEL = "music_player_list";
    public static final String PAGE_RECENT = "play_aggregate";
    public static final String PAGE_RECENT_ALBUM_DETAIL = "play_songdetail";
    public static final String PAGE_RECOMMEND = "recommend";
    public static final String PAGE_RELATED_ALBUM_DETAIL = "recommend_songdetail";
    public static final String PAGE_SINGER_DETAIL = "singer_detail";
    public static final String SOURCE = "full";
    public static final String SOURCE_COLLECT_LIST = "collectlist";
    public static final String SOURCE_CUSTOM_LIST = "customlist";
    public static final String SOURCE_PLAY_PANEL_FAVOR = "likelist";
    public static final String SOURCE_PLAY_PANEL_HIS = "historylist";
    public static final String SOURCE_PLAY_PANEL_PLAYING = "playlist";
    public static final String SOURCE_SONG_ADD = "add_song_page";
    public static final String SOURCE_SONG_INFO = "songinfo";
    public static final String SOURCE_TAB_SWITCH = "tabswitch";
    public static final String STAT_SERVICE = "MusicExtStatService";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_JUMP_BTN_CLK = "jump_btn_clk";
    public static final String TYPE_SHOW = "show";
    public static final String TYPE_SLIDE = "slide";
    public static final String UBC_843_SOURCE = "music";
    public static final String UBC_MUSIC_EXT_EVENT_ID = "1119";
    public static final String VALUE_ALBUM_DETAIL_ALBUM_NAME_EDIT = "songlist_name_click";
    public static final String VALUE_ALBUM_DETAIL_BACK_CLICK = "return_click";
    public static final String VALUE_ALBUM_DETAIL_COLLECT_CANCEL_CLICK = "album_cancel_collect_click";
    public static final String VALUE_ALBUM_DETAIL_COLLECT_CLICK = "album_collect_click";
    public static final String VALUE_ALBUM_DETAIL_EDIT = "songlist_adm";
    public static final String VALUE_ALBUM_DETAIL_MULTI_COLLECT_CLICK = "addtolist_click_adm";
    public static final String VALUE_ALBUM_DETAIL_MULTI_DEL_CLICK = "del_click_adm";
    public static final String VALUE_ALBUM_DETAIL_PLAY_ALL_CLICK = "play_all_click";
    public static final String VALUE_ALBUM_DETAIL_SEL_ALL_CLICK = "select_all_click";
    public static final String VALUE_ALBUM_DETAIL_SINGLE_COLLECT_CLICK = "addtolist_click";
    public static final String VALUE_ALBUM_DETAIL_SONG_CLICK = "songclick";
    public static final String VALUE_ALBUM_DETAIL_SONG_DEL_CLICK = "del_click";
    public static final String VALUE_ALBUM_DETAIL_SONG_LONG_PRESS = "song_longclick";
    public static final String VALUE_ALBUM_HIS_SONG_LIST_TAB = "songlist_tab";
    public static final String VALUE_ALBUM_HIS_SONG_TAB = "song_tab";
    public static final String VALUE_ALBUM_LIST_CLICK_BACK = "return_click";
    public static final String VALUE_ALBUM_LIST_CLICK_SELECT = "songlistclick_select";
    public static final String VALUE_ALBUM_LIST_CLICK_TO_DETAIL = "songlistclick_todetail";
    public static final String VALUE_ALBUM_LIST_LONG_CLICK = "songlist_longclick";
    public static final String VALUE_ALBUM_LIST_MANAGE_CLICK = "play_aggregate_adm";
    public static final String VALUE_ALBUM_LIST_MANAGE_DEL = "del_click_adm";
    public static final String VALUE_ALBUM_LIST_MENU_DEL = "del_click";
    public static final String VALUE_ALBUM_LIST_MENU_RENAME = "edit_click";
    public static final String VALUE_ALBUM_LIST_PLAY = "songlistclick_play";
    public static final String VALUE_ALBUM_LIST_SELECT_ALL = "select_all_click";
    public static final String VALUE_ALBUM_LIST_SLIDE_BACK = "return_slide";
    public static final String VALUE_ALBUM_LIST_TAB_CHANGE = "tabclick";
    public static final String VALUE_CLICK_TO_LYRIC_TAB = "clicktolyrics";
    public static final String VALUE_CLICK_TO_PLAYER_TAB = "clicktohomepage";
    public static final String VALUE_CLICK_TO_RECOMMEND_TAB = "clicktorecommend";
    public static final String VALUE_CLOSE_ALL = "music_close_all";
    public static final String VALUE_CLOSE_DIRECT = "music_close_direct";
    public static final String VALUE_CLOSE_MINIMIZE = "music_close_minimize";
    public static final String VALUE_COLLECT_PANEL_CREATE = "music_player_list_create";
    public static final String VALUE_COLLECT_PANEL_FAVOR = "music_player_list_like";
    public static final String VALUE_COMMENT_ENTRY_FAIL = "music_player_comment_click_0";
    public static final String VALUE_COMMENT_ENTRY_SUCCESS = "music_player_comment_click_1";
    public static final String VALUE_LYRICS_ENCODED = "lyrics_encoded";
    public static final String VALUE_LYRIC_CLICK = "lyrics_click";
    public static final String VALUE_LYRIC_FONT_CLICK = "textsize_click";
    public static final String VALUE_LYRIC_LONG_CLICK = "lyrics_longclick";
    public static final String VALUE_LYRIC_PAUSE_CLICK = "pause_click";
    public static final String VALUE_LYRIC_PLAY_CLICK = "play_click";
    public static final String VALUE_LYRIC_SHARE_CLICK = "copy_click";
    public static final String VALUE_MINIMIZE_CLICK = "minimize_click";
    public static final String VALUE_MINIMIZE_SLIDE = "minimize_slide";
    public static final String VALUE_MUSIC_LIKE_TOAST_ADD = "music_like_toast_add";
    public static final String VALUE_MUSIC_LYRIC_SINGER_CLICK = "lyrics_singer_detail_click";
    public static final String VALUE_MUSIC_LYRIC_SINGER_LIST_CLICK = "lyrics_multi_singer_detail_click";
    public static final String VALUE_MUSIC_SINGER_CLICK = "singer_detail_click";
    public static final String VALUE_MUSIC_SINGER_LIST_CLICK = "multi_singer_detail_click";
    public static final String VALUE_MY_MUSIC_CREATE_SONG_LIST_CLICK_1 = "create_songlist_click_1";
    public static final String VALUE_MY_MUSIC_CREATE_SONG_LIST_CLICK_2 = "create_songlist_click_2";
    public static final String VALUE_MY_MUSIC_LIKE_CLICK = "like_click";
    public static final String VALUE_MY_MUSIC_MORE_CLICK = "more_click";
    public static final String VALUE_MY_MUSIC_PAGE_SHOW = "pageshow";
    public static final String VALUE_MY_MUSIC_SONG_CLICK = "songclick";
    public static final String VALUE_MY_MUSIC_SONG_LIST_CLICK_INFO = "songlistclick_info";
    public static final String VALUE_MY_MUSIC_SONG_LIST_CLICK_PLAY = "songlistclick_play";
    public static final String VALUE_MY_MUSIC_SONG_LIST_SLIDE = "songlist_slide";
    public static final String VALUE_NEXT = "next";
    public static final String VALUE_PLAYER_CLICK_COLLECT = "music_player_addlist";
    public static final String VALUE_PLAYER_TAB_IMAGE_CLICK = "song_image";
    public static final String VALUE_PLAYER_TAB_PROGRESS_CLICK = "song_progress";
    public static final String VALUE_PLAYER_VIDEO_CLICK = "video_click";
    public static final String VALUE_PLAYER_VIDEO_PAUSE_CLICK = "video_click_pause";
    public static final String VALUE_PLAYER_VIDEO_PLAY_CLICK = "video_click_continue";
    public static final String VALUE_PLAYER_VIDEO_REC_FOLD = "minimize_click";
    public static final String VALUE_PLAYER_VIDEO_REC_ITEM = "video_list_click";
    public static final String VALUE_PLAYER_VIDEO_REC_MORE = "video_list_more_click";
    public static final String VALUE_PLAYER_VIDEO_REC_UNFOLD = "unfold_click";
    public static final String VALUE_PLAYER_VIDEO_SHOW = "video";
    public static final String VALUE_PLAYER_VIDEO_URL_CLICK = "video_url_click";
    public static final String VALUE_PLAY_PANEL_CLEAR = "delete_all";
    public static final String VALUE_PLAY_PANEL_CLICK_SHOW = "pageshow_click";
    public static final String VALUE_PLAY_PANEL_CLOSE_BTN = "close_button";
    public static final String VALUE_PLAY_PANEL_CLOSE_OTHER = "close_outdoor";
    public static final String VALUE_PLAY_PANEL_DELETE = "delete";
    public static final String VALUE_PLAY_PANEL_DONE = "done";
    public static final String VALUE_PLAY_PANEL_LIST_EMPTY_SHOW = "empty";
    public static final String VALUE_PLAY_PANEL_LIST_SHOW = "pageshow";
    public static final String VALUE_PLAY_PANEL_LOGIN = "go_login";
    public static final String VALUE_PLAY_PANEL_PLAY_ALL = "play_all";
    public static final String VALUE_PLAY_PANEL_PLAY_MODE_CLICK = "play_mode";
    public static final String VALUE_PLAY_PANEL_SONGS_COLLECT = "add_to_songlist";
    public static final String VALUE_PLAY_PANEL_SONG_CANCEL_COLLECT = "cancel_collect_song";
    public static final String VALUE_PLAY_PANEL_SONG_COLLECT = "collect_song";
    public static final String VALUE_PLAY_PANEL_SONG_DELETE = "delete_song";
    public static final String VALUE_PLAY_PANEL_SONG_PLAY = "play_song";
    public static final String VALUE_PLAY_PANEL_SWITCH_SHOW = "pageshow_tabswitch";
    public static final String VALUE_PRE = "pre";
    public static final String VALUE_RECOMMEND_REFRESH_CLICK = "refresh_click";
    public static final String VALUE_RECOMMEND_SINGER_DETAIL = "singerdetail";
    public static final String VALUE_SHOW = "pageshow";
    public static final String VALUE_SLIDE_LAST = "slide_last";
    public static final String VALUE_SLIDE_NEXT = "slide_next";
    public static final String VALUE_SLIDE_TO_LYRIC_TAB = "slidetolyrics";
    public static final String VALUE_SLIDE_TO_PLAYER_TAB = "slidetohomepage";
    public static final String VALUE_SLIDE_TO_RECOMMEND_TAB = "slidetorecommend";
    public static final String VALUE_SONGS_ADD_CLICK = "add_songs";
    public static final String VALUE_SONGS_ADD_FROM_COLLECT = "add_from_collectlist";
    public static final String VALUE_SONGS_ADD_FROM_CUSTOM = "add_from_customlist";
    public static final String VALUE_SONGS_ADD_FROM_FAVORITE = "add_from_likelist";
    public static final String VALUE_SONGS_ADD_FROM_RECENT = "add_from_play_aggregate";
    public static final String VALUE_SONGS_ADD_FROM_RECOMMEND = "add_from_recommend";
    public static final String VALUE_SONGS_LYRIC_SHOW = "lyrics_show_time";
    public static final String VALUE_SONGS_RECOMMEND_SHOW = "show_recommend";

    public static void registerStatService(UniqueId token) {
        if (token != null) {
            MusicServices.register(token, STAT_SERVICE, new MusicExtStatService());
        }
    }

    public static void unregisterStatService(UniqueId token) {
        if (token != null) {
            MusicServices.unregister(token, STAT_SERVICE);
        }
    }

    public static MusicExtStatService of(UniqueId token) {
        if (token == null) {
            return null;
        }
        return (MusicExtStatService) MusicServices.get(token, STAT_SERVICE);
    }

    public static PlayerDurationStatInfo getDurationInfo(UniqueId token, String page) {
        MusicExtStatService stat = of(token);
        String source = "";
        String pathTags = "";
        String extJson = "";
        if (stat != null) {
            source = stat.getChannelSource();
            pathTags = stat.getPathTags();
            extJson = stat.getExtJson();
        }
        return new PlayerDurationStatInfo(source, page, pathTags, extJson);
    }
}
