package com.baidu.browser.commenttoolbar;

import android.text.TextUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"BOTTOM_BAR_HOT_DISCUSS_COMMENT", "", "BOTTOM_BAR_NEW_TYPE", "BOTTOM_BAR_NEW_TYPE_FLOAT", "BOTTOM_BAR_NEW_TYPE_HIDE", "BOTTOM_BAR_NEW_TYPE_NORMAL", "BOTTOM_BAR_NEW_TYPE_NO_COMMENT", "BOTTOM_BAR_NEW_TYPE_VOICE", "BOTTOM_BAR_OLD_TYPE", "COMMENT_TOOLBAR_KEY_BAR_STYLE", "COMMENT_TOOLBAR_KEY_COMMENT_CMD", "COMMENT_TOOLBAR_KEY_LOG_EXT", "COMMENT_TOPBAR_KEY_STYLE", "TOP_BAR_NEW_TYPE", "TOP_BAR_NEW_TYPE_NORMAL", "TOP_BAR_OLD_TYPE", "isCommentToolbarAdStyle", "", "style", "lib-browser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentToolbarConstant.kt */
public final class CommentToolbarConstantKt {
    public static final String BOTTOM_BAR_HOT_DISCUSS_COMMENT = "6";
    public static final String BOTTOM_BAR_NEW_TYPE = "bottomBarType";
    public static final String BOTTOM_BAR_NEW_TYPE_FLOAT = "4";
    public static final String BOTTOM_BAR_NEW_TYPE_HIDE = "5";
    public static final String BOTTOM_BAR_NEW_TYPE_NORMAL = "1";
    public static final String BOTTOM_BAR_NEW_TYPE_NO_COMMENT = "2";
    public static final String BOTTOM_BAR_NEW_TYPE_VOICE = "3";
    public static final String BOTTOM_BAR_OLD_TYPE = "0";
    public static final String COMMENT_TOOLBAR_KEY_BAR_STYLE = "toolBarStyle";
    public static final String COMMENT_TOOLBAR_KEY_COMMENT_CMD = "commentCmd";
    public static final String COMMENT_TOOLBAR_KEY_LOG_EXT = "commentLogExt";
    public static final String COMMENT_TOPBAR_KEY_STYLE = "topBarStyle";
    public static final String TOP_BAR_NEW_TYPE = "topBarType";
    public static final String TOP_BAR_NEW_TYPE_NORMAL = "1";
    public static final String TOP_BAR_OLD_TYPE = "0";

    public static final boolean isCommentToolbarAdStyle(String style) {
        return TextUtils.equals("1", style);
    }
}
