package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.a.a;

/* compiled from: NpcSDKManagerImp */
class h implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f16383a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f16384b;

    h(i iVar, c cVar) {
        this.f16384b = iVar;
        this.f16383a = cVar;
    }

    public void a(boolean z, float f2) {
        b.a.a.a.c.d.a.b("aaaaa MainActivity isUpdate=" + z + ", size=" + f2);
        this.f16383a.a(z, f2);
    }

    public void onProgress(int i2) {
        c cVar = this.f16383a;
        if (cVar != null) {
            cVar.onProgress(i2);
        }
    }

    public void a(int i2, String str) {
        c cVar = this.f16383a;
        if (cVar != null) {
            cVar.a(i2, str);
        }
    }
}
