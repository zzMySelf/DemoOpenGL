package com.baidu.searchbox.hissug.impl;

import com.baidu.browser.utils.SearchPreferenceUtils;
import com.baidu.searchbox.hissug.pyramid.IHissugGraph;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/hissug/impl/HissugGraphImpl;", "Lcom/baidu/searchbox/hissug/pyramid/IHissugGraph;", "()V", "isHissugGraph", "", "setIsHissugGraph", "", "switch", "lib_hissug_impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HissugGraphImpl.kt */
public final class HissugGraphImpl implements IHissugGraph {
    public void setIsHissugGraph(boolean z) {
        SearchPreferenceUtils.getInstance().putBoolean("sp_key_search_hissug_graph_switch", z);
    }

    public boolean isHissugGraph() {
        return SearchPreferenceUtils.getInstance().getBoolean("sp_key_search_hissug_graph_switch", false);
    }
}
