package com.baidu.searchbox.search.pyramid;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.HashMap;

public interface SearchInterfaceManager {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("search", "lib_search_interface");

    long fetchRecentlySearchTime();

    String getCurrentPreProcessUrl(Context context);

    String getLastReferer();

    String getLastUrl();

    String getPageType(String str);

    String getPu(boolean z);

    String getPu(boolean z, String str, HashMap<String, String> hashMap);

    void recordSearchTimeStamp(long j2, String str);
}
