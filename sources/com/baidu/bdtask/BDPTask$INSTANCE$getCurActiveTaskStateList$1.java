package com.baidu.bdtask;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/bdtask/TaskStateList;", "invoke"}, k = 3, mv = {1, 1, 9})
final class BDPTask$INSTANCE$getCurActiveTaskStateList$1 extends Lambda implements Function0<TaskStateList> {
    public static final BDPTask$INSTANCE$getCurActiveTaskStateList$1 INSTANCE = new BDPTask$INSTANCE$getCurActiveTaskStateList$1();

    BDPTask$INSTANCE$getCurActiveTaskStateList$1() {
        super(0);
    }

    public final TaskStateList invoke() {
        BDPTask access$getInstance$p = BDPTask.INSTANCE.getInstance();
        if (access$getInstance$p != null) {
            return access$getInstance$p.getCurActiveTaskStateList();
        }
        return null;
    }
}
