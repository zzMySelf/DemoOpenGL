package com.baidu.sofire.ac;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.b.a;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.w;
import java.io.File;
import org.json.JSONObject;

public class U implements Runnable {
    public final a mCheckUpdateProcess;

    public U(Context context, int i2, boolean z) {
        this.mCheckUpdateProcess = new a(context, i2, z);
    }

    public void handleWork(Context context, Intent intent) {
        a aVar = this.mCheckUpdateProcess;
        aVar.a = context;
        aVar.c = com.baidu.sofire.c.a.a(context);
        aVar.e = com.baidu.sofire.j.a.a(context);
        aVar.d = new File(new File(c.f(context), "sofire_tmp"), ".tmp");
        aVar.b = com.baidu.sofire.b.c.a(context);
        aVar.f = intent.getIntExtra("from", 0);
        w.a(context).b(this);
    }

    public synchronized void run() {
        this.mCheckUpdateProcess.b();
    }

    public U(Context context, int i2, boolean z, JSONObject jSONObject) {
        this.mCheckUpdateProcess = new a(context, i2, z, jSONObject);
    }

    public U() {
        this.mCheckUpdateProcess = new a();
    }
}
