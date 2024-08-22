package com.baidu.apsaras.scheduler.internal.utils;

import com.baidu.search.tcstatistic.TcStatisticConstantKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/apsaras/scheduler/internal/utils/Removed;", "", "ref", "Lcom/baidu/apsaras/scheduler/internal/utils/LockFreeLinkedListNode;", "Lcom/baidu/apsaras/scheduler/internal/utils/Node;", "(Lcom/baidu/apsaras/scheduler/internal/utils/LockFreeLinkedListNode;)V", "toString", "", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LockFreeLinkedList.kt */
final class Removed {
    public final LockFreeLinkedListNode ref;

    public Removed(LockFreeLinkedListNode ref2) {
        Intrinsics.checkNotNullParameter(ref2, TcStatisticConstantKt.KEY_REF);
        this.ref = ref2;
    }

    public String toString() {
        return "Removed[" + this.ref + AbstractJsonLexerKt.END_LIST;
    }
}
