package com.baidu.searchbox.feed.h5.abtest;

import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.feed.h5.H5Runtime;

public class HybridAbtestManager {
    private static final String BASIC_NEWUI_TEST = "basic_newUI_Test";
    private static final String HIGHLIGHT_WORD_AB_KEY = "feed_highlight_words";
    private static final String JS_INJECT_AB_KEY = "news_add_document_start_javascript";
    private static final String SHIELD_SEARCH_BOX_AB_KEY = "feed_easybrowser_search_type_without_searchc_ban";
    private static final String TOP_SEARCH_BOX_AB_KEY = "easybrowser_search_type";
    private static boolean sHasGetHighLightWordSwitch = false;
    private static boolean sHasGetJsInjectSwitch = false;
    private static boolean sHasGetShieldSearchBoxSwitch = false;
    private static boolean sHasGetTopSearchBoxSwitch = false;
    private static int sHighLightWordSwitch = 0;
    private static Boolean sIsTtsIconNewStyle = null;
    private static boolean sJsInjectSwitch = false;
    private static boolean sShieldSearchBoxSwitch = false;
    private static String sTopSearchBoxSwitch = "";

    public static boolean jsInjectSwitch() {
        if (H5Runtime.isDebug()) {
            return true;
        }
        if (!sHasGetJsInjectSwitch) {
            sJsInjectSwitch = AbTestManager.getInstance().getSwitch(JS_INJECT_AB_KEY, false);
            sHasGetJsInjectSwitch = true;
        }
        return sJsInjectSwitch;
    }

    public static String topSearchBoxSwitch() {
        if (!sHasGetTopSearchBoxSwitch) {
            sTopSearchBoxSwitch = AbTestManager.getInstance().getSwitch(TOP_SEARCH_BOX_AB_KEY, "");
            sHasGetTopSearchBoxSwitch = true;
        }
        return sTopSearchBoxSwitch;
    }

    public static boolean shieldSearchBoxSwitch() {
        if (!sHasGetShieldSearchBoxSwitch) {
            sShieldSearchBoxSwitch = AbTestManager.getInstance().getSwitch(SHIELD_SEARCH_BOX_AB_KEY, false);
            sHasGetShieldSearchBoxSwitch = true;
        }
        return sShieldSearchBoxSwitch;
    }

    public static int highLightWordSwitch() {
        if (!sHasGetHighLightWordSwitch) {
            sHighLightWordSwitch = AbTestManager.getInstance().getSwitch(HIGHLIGHT_WORD_AB_KEY, 0);
            sHasGetHighLightWordSwitch = true;
        }
        return sHighLightWordSwitch;
    }

    public static boolean isTtsIconNewStyle() {
        if (sIsTtsIconNewStyle == null) {
            boolean z = false;
            if (AbTestManager.getInstance().getSwitch(BASIC_NEWUI_TEST, 0) == 1) {
                z = true;
            }
            sIsTtsIconNewStyle = Boolean.valueOf(z);
        }
        return sIsTtsIconNewStyle.booleanValue();
    }
}
