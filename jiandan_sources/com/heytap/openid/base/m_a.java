package com.heytap.openid.base;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.List;

@Keep
public class m_a implements Runnable {
    @Keep
    public final /* synthetic */ Context m_a;
    @Keep
    public final /* synthetic */ List m_b;
    @Keep
    public final /* synthetic */ m_b m_c;

    public m_a(m_b m_b2, Context context, List list) {
        this.m_c = m_b2;
        this.m_a = context;
        this.m_b = list;
    }

    @Keep
    public native void run();
}
