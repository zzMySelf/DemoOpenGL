package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zan;
import com.google.android.gms.internal.base.zao;
import java.util.concurrent.ExecutorService;

public final class zabf {
    public static final ExecutorService zahy = zan.zact().zaa(2, new NumberedThreadFactory("GAC_Executor"), zao.zasg);

    public static ExecutorService zaaz() {
        return zahy;
    }
}
