package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.wallet.api.ILoginBackListener;
import java.util.Map;

public abstract class e {

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public abstract String a(String str);

    public abstract Map<String, String> a(Context context, String str);

    public abstract void a(long j);

    public abstract void a(Context context, ILoginBackListener iLoginBackListener, String str);

    public abstract void a(a aVar);

    public abstract void a(boolean z);

    public abstract void a(boolean z, ILoginBackListener iLoginBackListener, int i2);

    public abstract void b();

    public abstract void b(boolean z);

    public abstract boolean c();

    public abstract boolean d();

    public abstract String e();

    public abstract void f();
}
