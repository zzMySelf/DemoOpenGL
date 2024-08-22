package com.baidu.searchbox.mall.comp.his.states;

import android.util.Log;
import com.baidu.searchbox.mall.comp.his.SearchHisComp;
import com.baidu.searchbox.mall.debug.DebugsKt;
import com.baidu.searchbox.nacomp.fsm.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/mall/comp/his/states/BaseHisState;", "Lcom/baidu/searchbox/nacomp/fsm/State;", "Lcom/baidu/searchbox/mall/comp/his/SearchHisComp;", "()V", "enter", "", "owner", "exit", "onMessage", "", "msg", "", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseHisState.kt */
public class BaseHisState implements State<SearchHisComp> {
    public void enter(SearchHisComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (DebugsKt.getDEBUG()) {
            Log.d("BaseHisState", owner.getFsm$lib_search_mall_release().getPrevState() + " -> " + owner.getFsm$lib_search_mall_release().getCurrState());
        }
    }

    public void exit(SearchHisComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    public boolean onMessage(SearchHisComp owner, Object msg) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        return false;
    }
}
