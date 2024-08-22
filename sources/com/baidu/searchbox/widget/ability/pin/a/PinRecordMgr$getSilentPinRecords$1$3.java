package com.baidu.searchbox.widget.ability.pin.a;

import com.baidu.searchbox.widget.ability.pin.a.model.SilentPinRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinRecordMgr.kt */
final class PinRecordMgr$getSilentPinRecords$1$3 extends Lambda implements Function0<String> {
    final /* synthetic */ List<SilentPinRecord> $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PinRecordMgr$getSilentPinRecords$1$3(List<SilentPinRecord> list) {
        super(0);
        this.$this_apply = list;
    }

    public final String invoke() {
        return "getSilentPinRecords: size=" + this.$this_apply.size() + ", items=" + this.$this_apply;
    }
}
