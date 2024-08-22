package com.baidu.searchbox.hissug.data.utils;

import com.baidu.searchbox.util.BaiduIdentityManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/hissug/data/utils/NetRequestUtils;", "", "()V", "addPublicParams", "", "url", "lib_hissug_data_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetRequestUtils.kt */
public final class NetRequestUtils {
    public static final NetRequestUtils INSTANCE = new NetRequestUtils();

    private NetRequestUtils() {
    }

    public final String addPublicParams(String url) {
        return BaiduIdentityManager.getInstance().appendParam(url, 1, true, false);
    }
}
