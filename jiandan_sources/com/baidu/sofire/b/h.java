package com.baidu.sofire.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.sofire.ac.Callback;

public class h implements Runnable {
    public final /* synthetic */ Callback a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Class[] e;
    public final /* synthetic */ Object[] f;

    public h(Callback callback, Context context, int i2, String str, Class[] clsArr, Object[] objArr) {
        this.a = callback;
        this.b = context;
        this.c = i2;
        this.d = str;
        this.e = clsArr;
        this.f = objArr;
    }

    public void run() {
        Callback callback = this.a;
        if (callback != null) {
            callback.onBegin(new Object[0]);
        }
        Pair<Integer, Object> a2 = d.a(this.b, this.c, 0, this.d, (Class<?>[]) this.e, this.f);
        if (this.a == null) {
            return;
        }
        if (((Integer) a2.first).intValue() != 0) {
            this.a.onError(a2.first);
            return;
        }
        this.a.onEnd(a2.second);
    }
}
