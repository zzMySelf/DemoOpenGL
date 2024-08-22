package com.baidu.searchbox.antivr;

public class RuntimeResult {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18618a;

    /* renamed from: b  reason: collision with root package name */
    private String f18619b;

    /* renamed from: c  reason: collision with root package name */
    private String f18620c;

    /* renamed from: d  reason: collision with root package name */
    private String f18621d;

    /* access modifiers changed from: package-private */
    public void a() {
        this.f18618a = false;
        this.f18619b = null;
        this.f18620c = null;
        this.f18621d = null;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f18619b = str;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f18618a = z;
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.f18621d = str;
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        this.f18620c = str;
    }

    public String getHookName() {
        return this.f18621d;
    }

    public String getHostPkgName() {
        return this.f18619b;
    }

    public String getUidPkgs() {
        return this.f18620c;
    }

    public boolean isInVirtual() {
        return this.f18618a;
    }
}
