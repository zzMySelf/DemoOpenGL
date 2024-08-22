package com.baidu.bdtask.ctrl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "Lcom/baidu/bdtask/ctrl/TaskAction;", "taskSingleKey", "", "_statusCode", "", "_statusMsg", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "value", "statusCode", "getStatusCode", "()I", "setStatusCode", "(I)V", "statusMsg", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "getTaskSingleKey", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public abstract class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final String f10806a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f10807b;

    /* renamed from: c  reason: collision with root package name */
    private String f10808c;

    public c(String str, Integer num, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "taskSingleKey");
        this.f10806a = str;
        this.f10807b = num;
        this.f10808c = str2;
    }

    public String c() {
        return this.f10806a;
    }

    public int a() {
        Integer num = this.f10807b;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void a(int i2) {
        this.f10807b = Integer.valueOf(i2);
    }

    public String b() {
        String str = this.f10808c;
        return str != null ? str : "";
    }

    public void a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        this.f10808c = str;
    }
}
