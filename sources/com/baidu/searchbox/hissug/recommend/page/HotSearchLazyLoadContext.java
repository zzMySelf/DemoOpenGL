package com.baidu.searchbox.hissug.recommend.page;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH'J\b\u0010\n\u001a\u00020\tH'J\b\u0010\u000b\u001a\u00020\fH'J\b\u0010\r\u001a\u00020\u000eH'R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/hissug/recommend/page/HotSearchLazyLoadContext;", "", "hotSearchLazyLoader", "Lcom/baidu/searchbox/hissug/recommend/page/HotSearchLazyLoader;", "getHotSearchLazyLoader", "()Lcom/baidu/searchbox/hissug/recommend/page/HotSearchLazyLoader;", "setHotSearchLazyLoader", "(Lcom/baidu/searchbox/hissug/recommend/page/HotSearchLazyLoader;)V", "getKeyboardHeight", "", "getUnfilledHeight", "isLazyEnabled", "", "setHasLoadLazyContent", "", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotSearchLazyLoadContext.kt */
public interface HotSearchLazyLoadContext {
    HotSearchLazyLoader getHotSearchLazyLoader();

    int getKeyboardHeight();

    int getUnfilledHeight();

    boolean isLazyEnabled();

    void setHasLoadLazyContent();

    void setHotSearchLazyLoader(HotSearchLazyLoader hotSearchLazyLoader);
}
