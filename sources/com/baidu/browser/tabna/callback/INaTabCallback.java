package com.baidu.browser.tabna.callback;

import com.baidu.browser.tabna.SearchTabItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;

public interface INaTabCallback extends IBaseTabCallback {
    String getNaTabTitle(String str);

    void onNaCardRenderFail(String str, int i2, String str2);

    void onNaFirstImageScreenPaint(String str, Long l);

    void onNaFirstScreenPaintFinished(String str);

    void onNaFirstScreenPaintFinished(String str, Long l);

    boolean onNaItemAdvanceFilter();

    boolean onNaItemClick(int i2, int i3, String str);

    boolean onNaItemDispatchScheme(String str, CallbackHandler callbackHandler);

    boolean onNaItemDispatchUrl(String str);

    boolean onNaItemRefreshSearchTip(String str, int i2);

    boolean onNaItemRefreshUrl(String str);

    void onNaPageRenderFail();

    boolean onNaTabHandleGroupCard(String str);

    void onNaTabLoadUrl(String str);

    void onNaTabPageShow(SearchTabItem searchTabItem, boolean z);

    void onNaTabStop();

    void onNaTopTagClick(String str);

    void onNaVideoPlayerFirstPlay(String str);

    void putNaTabPosition(int i2);

    void updateGroupCardWithScrollYChanged(int i2, String str);
}
