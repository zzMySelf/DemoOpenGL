package com.baidu.map.poitalos.view.multistate;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/map/poitalos/view/multistate/ThreeStateNoCollapseExProcessor;", "Lcom/baidu/map/poitalos/view/multistate/StateProcessor;", "raw", "", "(I)V", "getAllState", "", "getDownNextState", "state", "getNearestState", "getNearestStateProtector", "direct", "getUpNextState", "poi_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StateProcessor.kt */
public final class ThreeStateNoCollapseExProcessor extends StateProcessor {
    public ThreeStateNoCollapseExProcessor(int raw) {
        super(raw);
    }

    public int getUpNextState(int state) {
        int next = state - 1;
        if (next == 4) {
            next--;
        }
        return RangesKt.coerceAtLeast(3, next);
    }

    public int getDownNextState(int state) {
        int next = state + 1;
        if (next == 4) {
            next++;
        }
        return RangesKt.coerceAtMost(6, next);
    }

    public int getNearestState(int state) {
        if (state == 4) {
            return 3;
        }
        return state;
    }

    public int getNearestStateProtector(int state, int direct) {
        if (state == 4 && direct < 0) {
            return 3;
        }
        if (state != 4 || direct <= 0) {
            return state;
        }
        return 5;
    }

    public List<Integer> getAllState() {
        return CollectionsKt.listOf(1, 2, 3, 5, 6);
    }
}
