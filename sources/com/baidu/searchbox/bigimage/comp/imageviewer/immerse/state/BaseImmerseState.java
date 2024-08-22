package com.baidu.searchbox.bigimage.comp.imageviewer.immerse.state;

import android.util.Log;
import com.baidu.searchbox.bigimage.comp.imageviewer.immerse.ImmerseViewerComp;
import com.baidu.searchbox.nacomp.fsm.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/imageviewer/immerse/state/BaseImmerseState;", "Lcom/baidu/searchbox/nacomp/fsm/State;", "Lcom/baidu/searchbox/bigimage/comp/imageviewer/immerse/ImmerseViewerComp;", "()V", "enter", "", "owner", "exit", "onMessage", "", "msg", "", "toString", "", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseImmerseState.kt */
public abstract class BaseImmerseState implements State<ImmerseViewerComp> {
    public void enter(ImmerseViewerComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (BaseImmerseStateKt.DEBUG) {
            Log.d("ImmerseState", owner.getFsm$lib_search_bigimage_release().getPrevState() + " -> " + this);
        }
    }

    public void exit(ImmerseViewerComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    public boolean onMessage(ImmerseViewerComp owner, Object msg) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (!BaseImmerseStateKt.DEBUG) {
            return false;
        }
        Log.d("ImmerseState", owner + " in " + owner.getFsm$lib_search_bigimage_release().getCurrState() + " onMessage " + msg);
        return false;
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
