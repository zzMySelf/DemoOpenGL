package com.baidu.searchbox.live.interfaces.player;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u0002H\u0012¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/ExtAction;", "", "action", "", "(Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "desc", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "eventBundle", "Landroid/util/SparseArray;", "logLevel", "", "priority", "targetType", "type", "get", "T", "k", "def", "(ILjava/lang/Object;)Ljava/lang/Object;", "put", "", "v", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExtAction.kt */
public final class ExtAction {
    private final String action;
    private final StringBuilder desc;
    private SparseArray<Object> eventBundle;
    private int logLevel;
    private int priority;
    private int targetType;
    private int type;

    public ExtAction() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public ExtAction(String action2) {
        this.action = action2;
        this.eventBundle = new SparseArray<>(3);
        this.type = -1;
        this.targetType = -1;
        this.priority = 0;
        this.logLevel = 0;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ExtAction(java.lang.String r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0008
            r1 = 0
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
        L_0x0008:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.interfaces.player.ExtAction.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAction() {
        return this.action;
    }

    public final <T> T get(int k, T def) {
        SparseArray<Object> sparseArray = this.eventBundle;
        T t = null;
        T t2 = sparseArray != null ? sparseArray.get(k) : null;
        if (t2 instanceof Object) {
            t = t2;
        }
        return t != null ? t : def;
    }

    public final void put(int k, Object v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        SparseArray<Object> sparseArray = this.eventBundle;
        if (sparseArray != null) {
            sparseArray.put(k, v);
        }
    }
}
