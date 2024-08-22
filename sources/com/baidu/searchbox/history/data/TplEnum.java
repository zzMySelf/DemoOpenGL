package com.baidu.searchbox.history.data;

import android.text.TextUtils;

public class TplEnum {
    public static final String TPL_BISERIAL_DIVIDE = "biserial_divide";
    public static final String TPL_BOTTOM_FLOAT_BAR_HOLDER = "bottom_float_bar_holder";
    public static final String TPL_COMMON_AD = "common_ad";
    public static final String TPL_COMMON_ATLAS = "common_atlas";
    public static final String TPL_COMMON_AUDIO = "common_audio";
    public static final String TPL_COMMON_COLLECTION = "common_collection";
    public static final String TPL_COMMON_IMAGE = "common_image";
    public static final String TPL_COMMON_LIVE = "common_live";
    public static final String TPL_COMMON_PRODUCT = "common_product";
    public static final String TPL_COMMON_QA_Q = "common_qa_q";
    public static final String TPL_COMMON_REPOST = "common_repost";
    public static final String TPL_COMMON_SWAN = "common_swan";
    public static final String TPL_COMMON_TEXT = "common_text";
    public static final String TPL_COMMON_VIDEO = "common_video";
    public static final String TPL_COMMON_WEB = "common_web";
    public static final String TPL_COMMON_WENKU = "common_wenku";
    public static final String TPL_DYNAMIC_ATLAS = "activity_atlas";
    public static final String TPL_DYNAMIC_IMAGE = "activity_image";
    public static final String TPL_DYNAMIC_REPOST = "activity_repost";
    public static final String TPL_DYNAMIC_TEXT = "activity_text";
    public static final String TPL_DYNAMIC_VIDEO = "activity_video";
    public static final String TPL_FEED_AD = "feed_ad";
    public static final String TPL_FEED_ATLAS = "feed_atlas";
    public static final String TPL_FEED_IMAGE = "feed_image";
    public static final String TPL_FEED_LIVE = "feed_live";
    public static final String TPL_FEED_MINIVIDEO = "feed_minivideo";
    public static final String TPL_FEED_TEXT = "feed_text";
    public static final String TPL_FEED_VIDEO = "feed_video";
    public static final String TPL_HISTORY_GOOD = "product";
    public static final String TPL_MGAME_DEFAULT = "mercury_default";
    public static final String TPL_NOVEL = "common_novel";
    public static final String TPL_QA_A_TEXT = "qa_answer_text";
    public static final String TPL_QA_Q_IMAGE = "qa_question_image";
    public static final String TPL_QA_Q_TEXT = "qa_question_text";
    public static final String TPL_SEARCH_MINIVIDEO = "search_minivideo";
    public static final String TPL_SEARCH_TEXT_NAME = "search_text_name";
    public static final String TPL_SEARCH_TEXT_URL = "search_text_url";
    public static final String TPL_SEARCH_VIDEO = "search_video";
    public static final String TPL_SPLASH_IMAGE = "splash_image";
    public static final String TPL_SWAN_ATLAS = "mars_atlas";
    public static final String TPL_SWAN_IMAGE = "mars_image";
    public static final String TPL_SWAN_LIVE = "mars_live";
    public static final String TPL_SWAN_SALE = "mars_sale";
    public static final String TPL_SWAN_TEXT = "mars_text";
    public static final String TPL_SWAN_VIDEO = "mars_video";
    public static final String TPL_WEB_FILM = "search_web_film";
    public static final String TPL_WEB_VIDEO = "search_web_video";

    public static boolean isTemplateVideo(String tplId) {
        if (TextUtils.isEmpty(tplId)) {
            return false;
        }
        if (tplId.equals("common_video") || tplId.equals("common_collection") || tplId.equals("feed_video") || tplId.equals("feed_minivideo") || tplId.equals("mars_video") || tplId.equals("search_video") || tplId.equals("search_minivideo")) {
            return true;
        }
        return false;
    }
}
