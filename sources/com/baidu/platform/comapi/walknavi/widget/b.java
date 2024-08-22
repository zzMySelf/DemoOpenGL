package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;

/* compiled from: WNaviDialog */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f16586a;

    b(c cVar) {
        this.f16586a = cVar;
    }

    public void onClick(View view2) {
        if (this.f16586a.f16594h != null) {
            this.f16586a.f16594h.a();
        }
        this.f16586a.dismiss();
    }
}
