package com.baidu.searchbox.lightbrowser.utils;

import com.baidu.searchbox.lightbrowser.base.R;

public final class BrowserMenuUtility {
    public static final String DEFAULT_IMAGE_MIMETYPE = "image/*";
    public static final int ID_MENU_ADBLOCK = 13;
    public static final int ID_MENU_ADD_BOOKMARK = 4;
    public static final int ID_MENU_BARCODE = 12;
    public static final int ID_MENU_BG_WIN_OPEN = 14;
    public static final int ID_MENU_COPY = 3;
    public static final int ID_MENU_FAVOR_WEBPAGE = 16;
    public static final int ID_MENU_FONT_SIZE = 15;
    public static final int ID_MENU_NEW_WIN_OPEN = 2;
    public static final int ID_MENU_OPEN = 1;
    public static final int ID_MENU_OPEN_IMAGE = 7;
    public static final int ID_MENU_SAVE_IMAGE = 6;
    public static final int ID_MENU_SAVE_IMAGE_NET = 10;
    public static final int ID_MENU_SAVE_OFFLINE_WEBPAGE = 17;
    public static final int ID_MENU_SEARCH_IMAGE = 11;
    public static final int ID_MENU_SELECT_TITLE = 9;
    public static final int ID_MENU_SELECT_TITLE_LINK = 18;
    public static final int ID_MENU_SET_WALLPAPER = 8;
    public static final int ID_MENU_SHARE = 5;
    public static final int ID_MENU_WRONG_WORD_REPORT = 19;
    public static final String KEY_SAVE_IMG_ON_LIGHT_WEB = "light";
    public static final String KEY_SAVE_IMG_ON_MAIN_WEB = "main";
    public static int[] mAnchorImagePopMenuIcons = {R.drawable.menu_save, com.baidu.android.common.ui.style.R.drawable.menu_open_image, R.drawable.menu_copy};
    public static int[] mAnchorImagePopMenuIconsNew = {R.drawable.menu_open, com.baidu.android.common.ui.style.R.drawable.menu_image_search, R.drawable.menu_new_win_open, R.drawable.menu_copy, R.drawable.menu_image_adblock};
    public static int[] mAnchorImagePopMenuIds = {6, 7, 3};
    public static int[] mAnchorImagePopMenuIdsNew = {1, 11, 2, 3, 13};
    public static int[] mAnchorImagePopMenuTexts = {R.string.browser_menu_save_image, R.string.browser_menu_load_image, R.string.browser_menu_copy};
    public static int[] mAnchorImagePopMenuTextsNew = {R.string.browser_menu_open, R.string.browser_menu_search_image, R.string.browser_menu_newwindow_open, R.string.browser_menu_copy, R.string.browser_menu_adblock};
    public static int[] mImagePopMenuIcons = {R.drawable.menu_barcode, com.baidu.android.common.ui.style.R.drawable.menu_open_image, com.baidu.android.common.ui.style.R.drawable.menu_image_search, R.drawable.menu_image_adblock, R.drawable.menu_save, com.baidu.android.common.ui.style.R.drawable.menu_save_net, com.baidu.android.common.ui.style.R.drawable.menu_share, R.drawable.memu_set_wallpaper};
    public static int[] mImagePopMenuIds = {12, 7, 11, 13, 6, 10, 5, 8};
    public static int[] mImagePopMenuTexts = {R.string.browser_menu_barcode, R.string.browser_menu_load_image, R.string.browser_menu_search_image, R.string.browser_menu_adblock, R.string.browser_menu_save_image, R.string.browser_menu_save_image_net, R.string.browser_menu_share_image, R.string.browser_menu_set_wallpaper};
    public static int[] mLightTitlePopMenuIds = {9, 19, 15, 16};
    public static int[] mLightTitlePopMenuTexts = {R.string.browser_menu_select_copy, R.string.browser_menu_wrong_word_report, R.string.browser_menu_font_size, R.string.browser_menu_favor};
    public static int[] mSelectedPopMenuIcons = {R.drawable.menu_select_text};
    public static int[] mSelectedPopMenuIds = {9};
    public static int[] mSelectedPopMenuTexts = {R.string.browser_menu_select_text};
    public static int[] mTitlePopMenuIcons = {R.drawable.menu_open, com.baidu.android.common.ui.style.R.drawable.menu_image_search, R.drawable.menu_new_win_open, R.drawable.menu_copy};
    public static int[] mTitlePopMenuIds = {9, 15, 16, 17};
    public static int[] mTitlePopMenuTexts = {R.string.browser_menu_select_copy, R.string.browser_menu_font_size, R.string.browser_menu_favor, R.string.browser_menu_save_offline_webpage};
    public static int[] mWindowPopMenuIcons = {R.drawable.menu_open, R.drawable.menu_new_win_open, R.drawable.menu_copy, R.drawable.menu_copy};
    public static int[] mWindowPopMenuIds = {1, 2, 3, 18};
    public static int[] mWindowPopMenuTexts = {R.string.browser_menu_open, R.string.browser_menu_newwindow_open, R.string.browser_menu_copy, R.string.browser_menu_select_copy};

    private BrowserMenuUtility() {
    }
}
