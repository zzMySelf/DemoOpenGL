package com.baidu.bdtask.component.buoy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class BuoyComponent$update$1$3 extends Lambda implements Function0<String> {
    final /* synthetic */ int $uiType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuoyComponent$update$1$3(int i2) {
        super(0);
        this.$uiType = i2;
    }

    public final String invoke() {
        return "uiType:" + this.$uiType + " is not a layer";
    }
}
