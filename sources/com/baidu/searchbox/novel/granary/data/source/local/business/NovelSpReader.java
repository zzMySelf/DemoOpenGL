package com.baidu.searchbox.novel.granary.data.source.local.business;

import com.baidu.searchbox.novel.granary.data.source.local.core.NovelSpManager;

public class NovelSpReader {
    private static final String SP_NAME = "NOVEL_SP_READER";

    public interface Key {
        public static final String KEY_BOTTOM_EDU_TEXT_DATA = "key_bottom_edu_text_data";
        public static final String KEY_CAN_SHOW_CHAPTER_END_AD = "key_can_show_chapter_end_ad";
        public static final String KEY_CAN_SHOW_LEGAL_BANNER_AD = "key_can_show_legal_banner_ad";
        public static final String KEY_DEBUG_FE_CONNECT_URL = "key_debug_fe_connect_url";
        public static final String KEY_DEBUG_SERVER_CONNECT_URL = "key_debug_server_connect_url";
        public static final String KEY_ENCODE_TTS_REWARD_NEW_USER_PROTECTED = "key_encode_tts_reward_new_user_protected";
        public static final String KEY_ENCODE_TTS_REWARD_PLAY_EXPIRE_TIME = "key_encode_tts_reward_play_expire_time";
        public static final String KEY_ENCODE_TTS_USE_COUNT = "key_encode_tts_reward_new_user_count";
        public static final String KEY_FBREADER_BACK_COLOR_VERSION = "key_fbreader_back_color_version";
        public static final String KEY_FBREADER_LIGHT_LEVEL_VERSION = "key_fbreader_light_level_version";
        public static final String KEY_FBREADER_PAGE_TURN_TYPE_VERSION = "key_fbreader_page_turn_type_version";
        public static final String KEY_FBREADER_SPACE_INTERVAL_VERSION = "key_fbreader_space_interval_version";
        public static final String KEY_GIFT_REWARD_ENTER_ACTION = "key_reward_enter_action";
        public static final String KEY_GIFT_REWARD_THANKS_CONTENT = "key_gift_reward_thanks_content";
        public static final String KEY_HUANGFAN_FILTER_TEXT = "key_huangfan_filter_text";
        public static final String KEY_HUANGFAN_FITER_LAST_MODIFIED = "key_huangfan_fiter_last_modified";
        public static final String KEY_LEGAL_CONTENT_JILI_TEXT_DATA = "key_legal_content_jili_text_data";
        public static final String KEY_LEGAL_TOP_NOTICE_LAST_REQUEST_TIME = "key_legal_top_notice_last_request_time";
        public static final String KEY_LEGAL_TOP_NOTICE_LAST_SHOW_TIME = "key_legal_top_notice_last_show_time_";
        public static final String KEY_LEGAL_TOP_NOTICE_REQUEST_INTERVAL = "key_legal_top_notice_request_interval";
        public static final String KEY_LEGAL_TOP_NOTICE_SHOW_INTERVAL = "key_legal_top_notice_show_interval_";
        public static final String KEY_LEGAL_TTS_REWARD_PLAY_EXPIRE_TIME = "key_legal_tts_reward_play_expire_time";
        public static final String KEY_LITE_READER_BACKGROUND_COLOR_VERSION = "key_lite_reader_background_color_version";
        public static final String KEY_LITE_READER_FLIP_STYLE_VERSION = "key_lite_reader_flip_style_version";
        public static final String KEY_LITE_READER_FONT_LEVEL_VERSION = "key_lite_reader_font_level_version";
        public static final String KEY_NEED_ANCHOR_SHELF = "key_need_anchor_shelf";
        public static final String KEY_NOVEL_BOOK_SHELF_ECONOMIC_DIALOG_LAST_TIME = "key_novel_book_shelf_dialog_last_time";
        public static final String KEY_NOVEL_BOOK_SHELF_ECONOMIC_DIALOG_TIMES = "key_novel_book_shelf_dialog_times";
        public static final String KEY_NOVEL_BOOK_SHELF_ECONOMIC_DIALOG_X = "key_novel_book_shelf_economic_x";
        public static final String KEY_NOVEL_BOOK_SHELF_ECONOMIC_DIALOG_Y = "key_novel_book_shelf_economic_y";
        public static final String KEY_NOVEL_HIJACK_ADD_SHELF_ALERT = "key_novel_hijack_add_shelf_alert";
        public static final String KEY_NOVEL_HIJACK_SWITCH_EXPIRE = "key_novel_hijack_switch_expire";
        public static final String KEY_NOVEL_HIJACK_SWITCH_IS_OPEN = "key_novel_hijack_switch_is_open";
        public static final String KEY_NOVEL_HIJACK_SWITCH_IS_SHOW = "key_novel_hijack_switch_is_show";
        public static final String KEY_NOVEL_HIJACK_SWITCH_VERSION = "key_novel_hijack_switch_version";
        public static final String KEY_NOVEL_VIP_AFTER_FREE_VIP_HAD_SHOW = "key_novel_fb_reader_vip_after_free_vip_had_show";
        public static final String KEY_RIGHT_TOP_OPERATE_STATUS = "key_right_top_operate_status";
        public static final String KEY_TTS_MULTI_ROLES_FREE_TOTAL_LEFT_TIME = "key_tts_multi_free_total_left_time";
        public static final String KEY_TTS_MULTI_ROLES_REWARD_TOTAL_LEFT_TIME = "key_tts_multi_reward_total_left_time";
    }

    public interface Value {
    }

    public static NovelSpManager getSp() {
        return NovelSpManager.getI(SP_NAME);
    }
}
