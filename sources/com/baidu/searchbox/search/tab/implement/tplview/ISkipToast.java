package com.baidu.searchbox.search.tab.implement.tplview;

import com.baidu.searchbox.search.tab.implement.player.helper.ListPlayerHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/tplview/ISkipToast;", "", "getSkipToastBottomMarginRes", "", "hideSkipToast", "", "useAnimation", "", "skipToastSeekToPosition", "callback", "Lcom/baidu/searchbox/search/tab/implement/player/helper/ListPlayerHelper$PlayingCallback;", "supportSkipToast", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISkipToast.kt */
public interface ISkipToast {
    int getSkipToastBottomMarginRes();

    void hideSkipToast(boolean z);

    void skipToastSeekToPosition(ListPlayerHelper.PlayingCallback playingCallback);

    boolean supportSkipToast();
}
