package com.baidu.browser.prefetch;

import android.text.TextUtils;
import com.baidu.browser.explore.network.NaResponseInformation;

public class PrefetchNAData {
    public String cacheKey;
    public String data = "";
    public boolean hasIntercepted = false;
    public String isid = "";
    public String mod = "";
    public String module = "";
    public String preRenderQid = null;
    public boolean preRenderToPrefetch = false;
    public NaResponseInformation prefetchResponseInformation = null;
    public String prefetchUrl = null;
    public String querysign = "";
    public String realword = "";
    public Long time = 0L;

    public boolean isExpired() {
        return System.currentTimeMillis() > this.time.longValue() + 180000;
    }

    public boolean isWordEquals(PrefetchData prefetchData) {
        return prefetchData != null && TextUtils.equals(this.realword, prefetchData.mWord);
    }
}
