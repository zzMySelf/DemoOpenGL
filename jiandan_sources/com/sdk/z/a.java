package com.sdk.z;

import android.content.Context;
import com.sdk.f.f;
import com.sdk.mobile.config.MobileConfig;
import java.util.List;

public class a<T> extends com.sdk.w.a<T> {
    static {
        boolean z = f.a;
    }

    public a(Context context, com.sdk.e.a<T> aVar) {
        super(context, aVar, new MobileConfig());
    }

    public a(Context context, List<String> list, com.sdk.e.a<T> aVar) {
        super(context, aVar, new MobileConfig());
    }
}
