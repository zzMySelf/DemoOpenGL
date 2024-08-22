package com.baidu.wallet.core.beans;

public abstract class BeanConstants {
    public static final String API_GET_FP = "/odp/wireless/sdk/init";
    public static final String API_HCE_QUERY_TRANSLIST = "/o2o/0/hce/0/trans_query/0";
    public static final String API_PAY_RESULT_CALLBACK_FOR_PHONECHARGE = "/ebbp/nologin/query/payresult/promotin";
    public static final String API_SEND_BFB_SMS = "/_u/wireless/send_sms/";
    public static final String API_WALLET_INTERFACE = "/odp/wireless/sdk/outerpage";
    public static final int AUTHLEVEL_CLIENT = 1;
    public static final int AUTHLEVEL_PUBLIC = 0;
    public static final int AUTHLEVEL_USER = 2;
    public static final String BANK_CREDIT = "credit";
    public static final String BANK_DEBIT = "debit";
    public static final String BANK_TYPE = "bank_type";
    public static final int BEAN_ID_FOR_BACKUP_INIT = 1042;
    public static final int BEAN_ID_FOR_NEW_INIT = 786;
    public static final int BEAN_ID_GET_FP = 530;
    public static String CHANNEL_ID = "tieba";
    public static final String CHANNEL_ID_BDMAP = "bdmap";
    public static final String CHANNEL_ID_BROWSER = "browser";
    public static final String CHANNEL_ID_HI = "hi";
    public static final String CHANNEL_ID_IQIYI = "iqiyi";
    public static final String CHANNEL_ID_KUANG = "baiduapp";
    public static final String CHANNEL_ID_LVYOU = "bdtravel";
    public static final String CHANNEL_ID_NAVI = "navi";
    public static final String CHANNEL_ID_NUOMI = "nuomi";
    public static final String CHANNEL_ID_NUOMI_LIAN = "bainuolian";
    public static final String CHANNEL_ID_SHOU_ZHU_YOU_XI = "shouzhuyouxi";
    public static final String CHANNEL_ID_SIMPLIFY = "simplify";
    public static final String CHANNEL_ID_TIE_BA = "tieba";
    public static final String CHANNEL_ID_WAIMAI = "waimai";
    public static final String CHANNEL_ID_WALLET_APP = "walletapp";
    public static final String CHANNEL_ID_WALLET_APP_PRO = "walletapppro";
    public static final String CHANNEL_ID_WEISHI = "weishi";
    public static final String CHANNEL_ID_YIPINGTAI = "yipingtai";
    public static final String CHANNEL_ID_YUN = "bdcloud";
    public static final String COOKIE_OPENBDUSS = "OPENBDUSS";
    public static final boolean DEBUG = false;
    public static final String DOMAIN_CONFIG_KEY = "wallet_sdk_domain_config_key";
    public static final String DOMAIN_CONFIG_KEY_FOR_APP = "wallet_sdk_domain_config_for_app";
    public static final String DOMAIN_CONFIG_NAME_ONLINE = "wallet_sdk_domain_config_name_online";
    public static final String DOMAIN_CONFIG_NAME_QA = "wallet_sdk_domain_config_name_qa";
    public static boolean ENABLE_SAFE_KEYBOARD = false;
    public static final String ENCODE_GBK = "gbk";
    public static final String ENCODE_UTF_8 = "UTF-8";
    public static final String EV_BEAN_EXECUT_ERR_CONTENT = "ev_bean_execut_err_content";
    public static final String EV_LOGIN_SUCCESS = "ev_login_seccuss";
    public static final boolean FLAG_SECURE_SWITCH = true;
    public static final int HAS_MOBILE_PASSWORD_FALSE = 0;
    public static final int HAS_MOBILE_PASSWORD_TRUE = 1;
    public static final String HTTP_REQUEST_TYPE_PAY_BEAN = "pay bean http request";
    public static final String HTTP_REQUEST_TYPE_UPLOAD_BEAN = "upload bean http request";
    public static final boolean IS_SEARCHBOX_PLUGIN = false;
    public static final String KEY_CREATE_TIME_STAMP = "createTime";
    public static final String KEY_HAS_NEW_BALANCE = "hasNewBalance";
    public static final String KEY_LOGIN_TYPE = "login_type";
    public static final String KEY_PASSPORT_LOGIN = "login";
    public static final String KEY_PASSPORT_REG = "reg";
    public static final String KEY_TOEKN_VALUE = "token_value";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_TOKEN_TYPE = "token_type";
    public static final int METHOD_HTTP_GET = 0;
    public static final int METHOD_HTTP_POST = 1;
    public static final boolean MONKEY = false;
    public static final String PREFERENCES_HOME_TAB = "_home_tab_preference";
    public static final String PREFERENCES_NAME = "com.baidu.wallet.preferences_name";
    public static final String PREFS_KEY_USE_NEW_HOME = "use_new_home";
    public static final String REQUEST_ID_TRANSFER = "request_id_transfer";
    public static final String RTC_DOMAIN_CONFIG_KEY = "wallet_sdk_rtc_domain_config_key";
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    public static String SDK_VERSION = "";
    public static final String UPLOAD_IMAGE = "/aif/image/scan";
    public static String VERSION_NO = "11.1.500.104";
    public static final String WEB_VIEW_CACHE_TAG = "WebViewCacheManager";
    public static boolean needActAnimation = true;

    public static final class a {
        public static final String A = "life_show_head_desc";
        public static final String B = "life_show_head_style";
        public static final String C = "life_hidden_change";
        public static final String D = "home_skin_change";
        public static final String E = "download_lottie_completed";
        public static final String F = "download_image_completed";
        public static final String a = "action_login";
        public static final String b = "action_logout";
        public static final String c = "update_tab_icon";
        public static final String d = "life_data_refresh";
        public static final String e = "life_notice_change";
        public static final String f = "life_have_notice_change";
        public static final String g = "life_credit_change";
        public static final String h = "life_auto_redirect";

        /* renamed from: i  reason: collision with root package name */
        public static final String f3547i = "life_auto_animation";
        public static final String j = "life_request";
        public static final String k = "life_coupon_change";
        public static final String l = "life_common_coupon_change";
        public static final String m = "start_amount_animator";
        public static final String n = "dialog_all_dismiss";

        /* renamed from: o  reason: collision with root package name */
        public static final String f3548o = "credit_notice_change";
        public static final String p = "finance_home_animator_done";
        public static final String q = "finance_home_animator_up";
        public static final String r = "finance_home_regular_popupwindow_dissmiss";
        public static final String s = "finance_home_regular_sub_title_click";
        public static final String t = "push_icon_count_update";
        public static final String u = "mine_tab_eye_status";
        public static final String v = "tab_show_new_text";
        public static final String w = "tab_hide_new_text";
        public static final String x = "skin_change";
        public static final String y = "user_info_change";
        public static final String z = "life_show_brand_card";
    }

    public static final class b {
        public static final String a = "sdk_home_tab_life600.cfg";
        public static final String b = "home_tab_mine_600.cfg";
        public static final String c = "window_config_350.cfg";
        public static final String d = "home_tab_life427.cfg";
        public static final String e = "home_tab_mine_440.cfg";
        public static final String f = "window_config_350.cfg";
        public static final String g = "home_tab_loan230.cfg";
        public static final String h = "sdk_home_tab_life600.cfg";

        /* renamed from: i  reason: collision with root package name */
        public static final String f3549i = "home_tab_mine_600.cfg";
        public static final String j = "window_config_350.cfg";
        public static final String k = "mine_tab_eye_status";
    }
}
