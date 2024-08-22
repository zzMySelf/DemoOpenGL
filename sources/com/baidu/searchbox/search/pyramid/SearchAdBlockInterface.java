package com.baidu.searchbox.search.pyramid;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;

public interface SearchAdBlockInterface {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("search", "search_adblock_interface");

    boolean isEnableAds(Context context);

    boolean isOpenAutoAds(Context context);
}
