package com.vivo.push.b;

import com.vivo.push.a;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: TagCommand */
public final class z extends c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f6327a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.f6327a = arrayList;
    }

    /* access modifiers changed from: protected */
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("tags", (Serializable) this.f6327a);
    }

    /* access modifiers changed from: protected */
    public final void d(a aVar) {
        super.d(aVar);
        this.f6327a = aVar.c("tags");
    }

    public final String toString() {
        return "TagCommand";
    }
}
