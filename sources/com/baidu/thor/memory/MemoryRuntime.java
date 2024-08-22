package com.baidu.thor.memory;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/baidu/thor/memory/MemoryRuntime;", "", "()V", "iMemoryService", "Lcom/baidu/thor/memory/IMemoryService;", "getIMemoryService", "()Lcom/baidu/thor/memory/IMemoryService;", "setIMemoryService", "(Lcom/baidu/thor/memory/IMemoryService;)V", "memoryServiceClass", "", "getMemoryServiceClass", "()Ljava/lang/String;", "setMemoryServiceClass", "(Ljava/lang/String;)V", "getHostPerformance", "Lorg/json/JSONObject;", "perfType", "excTime", "", "description", "page", "business", "lib-memory-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MemoryRuntime.kt */
public final class MemoryRuntime {
    public static final MemoryRuntime INSTANCE = new MemoryRuntime();
    private static IMemoryService iMemoryService;
    private static String memoryServiceClass = "com.baidu.thor.memory.upload.MemoryService";

    private MemoryRuntime() {
    }

    public final IMemoryService getIMemoryService() {
        return iMemoryService;
    }

    public final void setIMemoryService(IMemoryService iMemoryService2) {
        iMemoryService = iMemoryService2;
    }

    public final String getMemoryServiceClass() {
        return memoryServiceClass;
    }

    public final void setMemoryServiceClass(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        memoryServiceClass = str;
    }

    public final JSONObject getHostPerformance(String perfType, long excTime, String description, String page, String business) {
        Intrinsics.checkNotNullParameter(perfType, "perfType");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(business, "business");
        JSONObject hostPerformance = HostPerformanceRuntime.getHostPerformance(perfType, excTime, description, page, business);
        Intrinsics.checkNotNullExpressionValue(hostPerformance, "getHostPerformance(perfT…cription, page, business)");
        return hostPerformance;
    }
}
