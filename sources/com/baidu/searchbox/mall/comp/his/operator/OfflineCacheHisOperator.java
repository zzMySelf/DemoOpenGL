package com.baidu.searchbox.mall.comp.his.operator;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/mall/comp/his/operator/OfflineCacheHisOperator;", "Lcom/baidu/searchbox/mall/comp/his/operator/LocalHisBaseOperator;", "()V", "getCachePath", "", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocalHisOperator.kt */
final class OfflineCacheHisOperator extends LocalHisBaseOperator {
    public String getCachePath() {
        return "mall_his_cache_local_file";
    }
}
