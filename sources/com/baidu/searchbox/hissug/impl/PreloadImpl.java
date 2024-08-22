package com.baidu.searchbox.hissug.impl;

import com.baidu.search.preload.SearchPreloadDrawableUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.hissug.R;
import com.baidu.searchbox.hissug.pyramid.IPreLoad;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/hissug/impl/PreloadImpl;", "Lcom/baidu/searchbox/hissug/pyramid/IPreLoad;", "()V", "preloadResource", "", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreloadImpl.kt */
public final class PreloadImpl implements IPreLoad {
    public void preloadResource() {
        SearchPreloadDrawableUtils.INSTANCE.preloadDrawable(R.drawable.searchbox_clear_selector);
        SearchPreloadDrawableUtils.INSTANCE.preloadDrawable(R.drawable.searchbox_top_back_selector);
        SearchPreloadDrawableUtils.INSTANCE.preloadDrawable(com.baidu.searchbox.bg.res.R.drawable.searchbox_background_old_corner_round);
        try {
            Class.forName("com.baidu.searchbox.hissug.ui.EmptyBoxNoImageItemView");
        } catch (ClassNotFoundException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        SearchPreloadDrawableUtils.INSTANCE.preloadDrawable(R.drawable.search_sug_his_guess_you_like_show_normal);
        SearchPreloadDrawableUtils.INSTANCE.preloadDrawable(R.drawable.search_his_new_delte_icon);
    }
}
