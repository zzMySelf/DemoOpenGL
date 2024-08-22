package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

public final class zabc extends zabp {
    public WeakReference<zaaw> zahp;

    public zabc(zaaw zaaw) {
        this.zahp = new WeakReference<>(zaaw);
    }

    public final void zas() {
        zaaw zaaw = (zaaw) this.zahp.get();
        if (zaaw != null) {
            zaaw.resume();
        }
    }
}
