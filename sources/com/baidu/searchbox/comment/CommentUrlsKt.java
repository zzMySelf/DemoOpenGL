package com.baidu.searchbox.comment;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\t\u0010\u0004\u001a\u00020\u0001H\b\u001a\t\u0010\u0005\u001a\u00020\u0001H\b\u001a\t\u0010\u0006\u001a\u00020\u0001H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"COMMENT_NOTIFY_REMIND_URL", "", "HOT_WORDS_EASTER_EGG_URL", "SEND_EASTER_EGG_ICON_URL", "getCommentNotifyRemindIconUrl", "getHotsWordsEasterEggUrl", "getSendEasterEggIconUrl", "lib-comment-interface_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentUrls.kt */
public final class CommentUrlsKt {
    public static final String COMMENT_NOTIFY_REMIND_URL = "https://b.bdstatic.com/searchbox/image/gcp/20240520/2573569051.png";
    public static final String HOT_WORDS_EASTER_EGG_URL = "https://b.bdstatic.com/searchbox/image/gcp/20230921/1251387692.png";
    public static final String SEND_EASTER_EGG_ICON_URL = "https://b.bdstatic.com/searchbox/image/gcp/20230921/2510095142.png";

    public static final String getHotsWordsEasterEggUrl() {
        return HOT_WORDS_EASTER_EGG_URL;
    }

    public static final String getSendEasterEggIconUrl() {
        return SEND_EASTER_EGG_ICON_URL;
    }

    public static final String getCommentNotifyRemindIconUrl() {
        return COMMENT_NOTIFY_REMIND_URL;
    }
}
