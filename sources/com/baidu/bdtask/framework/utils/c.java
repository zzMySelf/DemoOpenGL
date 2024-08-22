package com.baidu.bdtask.framework.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/bdtask/framework/utils/SafeLoadLibraryUtils;", "", "()V", "loadLibrary", "", "action", "Lkotlin/Function0;", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f10945a = new c();

    private c() {
    }

    @JvmStatic
    public static final void a(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        try {
            function0.invoke();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
