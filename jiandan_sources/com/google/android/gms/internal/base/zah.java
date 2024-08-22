package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

public final class zah extends Drawable.ConstantState {
    public int mChangingConfigurations;
    public int zaoa;

    public zah(zah zah) {
        if (zah != null) {
            this.mChangingConfigurations = zah.mChangingConfigurations;
            this.zaoa = zah.zaoa;
        }
    }

    public final int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public final Drawable newDrawable() {
        return new zae(this);
    }
}
