package com.baidu.browser.components.toolbar.impl;

import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"AD_COMMENT", "", "BOTTOM_RESULT_PAD", "COMMENT", "CUSTOM", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "GROUP_TOPIC", "MULTIWINDOW_EXPOSED", "NEW_BOTTOM_FLOAT", "NEW_BOTTOM_HIDE", "NEW_BOTTOM_NORMAL", "NEW_BOTTOM_NO_COMMENT", "NEW_BOTTOM_VOICE", "NEW_HOT_DISCUSS_COMMENT", "NORMAL", "PRE_BUILD", "TAG", "", "TEENAGER", "THEME_TOPIC", "TWO_LINE_TOPIC", "lib-browser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBoxToolbarManager.kt */
public final class SearchBoxToolbarManagerKt {
    public static final int AD_COMMENT = 6;
    public static final int BOTTOM_RESULT_PAD = 19;
    public static final int COMMENT = 2;
    public static final int CUSTOM = 8;
    private static boolean DEBUG = AppConfig.isDebug();
    public static final int GROUP_TOPIC = 9;
    public static final int MULTIWINDOW_EXPOSED = 7;
    public static final int NEW_BOTTOM_FLOAT = 13;
    public static final int NEW_BOTTOM_HIDE = 14;
    public static final int NEW_BOTTOM_NORMAL = 10;
    public static final int NEW_BOTTOM_NO_COMMENT = 11;
    public static final int NEW_BOTTOM_VOICE = 12;
    public static final int NEW_HOT_DISCUSS_COMMENT = 15;
    public static final int NORMAL = 1;
    public static final int PRE_BUILD = 0;
    public static final String TAG = "SearchBoxToolbar";
    public static final int TEENAGER = 5;
    public static final int THEME_TOPIC = 4;
    public static final int TWO_LINE_TOPIC = 3;

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    public static final void setDEBUG(boolean z) {
        DEBUG = z;
    }
}
