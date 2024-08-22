package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public final class zae extends Drawable implements Drawable.Callback {
    public int mAlpha;
    public int mFrom;
    public boolean zand;
    public int zanl;
    public long zanm;
    public int zann;
    public int zano;
    public int zanp;
    public boolean zanq;
    public zah zanr;
    public Drawable zans;
    public Drawable zant;
    public boolean zanu;
    public boolean zanv;
    public boolean zanw;
    public int zanx;

    public zae(Drawable drawable, Drawable drawable2) {
        this((zah) null);
        drawable = drawable == null ? zaf.zany : drawable;
        this.zans = drawable;
        drawable.setCallback(this);
        zah zah = this.zanr;
        zah.zaoa = drawable.getChangingConfigurations() | zah.zaoa;
        drawable2 = drawable2 == null ? zaf.zany : drawable2;
        this.zant = drawable2;
        drawable2.setCallback(this);
        zah zah2 = this.zanr;
        zah2.zaoa = drawable2.getChangingConfigurations() | zah2.zaoa;
    }

    private final boolean canConstantState() {
        if (!this.zanu) {
            this.zanv = (this.zans.getConstantState() == null || this.zant.getConstantState() == null) ? false : true;
            this.zanu = true;
        }
        return this.zanv;
    }

    public final void draw(Canvas canvas) {
        int i2 = this.zanl;
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            this.zanm = SystemClock.uptimeMillis();
            this.zanl = 2;
        } else if (i2 == 2 && this.zanm >= 0) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zanm)) / ((float) this.zanp);
            if (uptimeMillis < 1.0f) {
                z2 = false;
            }
            if (z2) {
                this.zanl = 0;
            }
            this.mAlpha = (int) ((((float) this.zann) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
            z = z2;
        } else {
            z = true;
        }
        int i3 = this.mAlpha;
        boolean z3 = this.zand;
        Drawable drawable = this.zans;
        Drawable drawable2 = this.zant;
        if (z) {
            if (!z3 || i3 == 0) {
                drawable.draw(canvas);
            }
            int i4 = this.zano;
            if (i3 == i4) {
                drawable2.setAlpha(i4);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.zano - i3);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.zano);
        }
        if (i3 > 0) {
            drawable2.setAlpha(i3);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zano);
        }
        invalidateSelf();
    }

    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zah zah = this.zanr;
        return changingConfigurations | zah.mChangingConfigurations | zah.zaoa;
    }

    public final Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zanr.mChangingConfigurations = getChangingConfigurations();
        return this.zanr;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zans.getIntrinsicHeight(), this.zant.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zans.getIntrinsicWidth(), this.zant.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (!this.zanw) {
            this.zanx = Drawable.resolveOpacity(this.zans.getOpacity(), this.zant.getOpacity());
            this.zanw = true;
        }
        return this.zanx;
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final Drawable mutate() {
        if (!this.zanq && super.mutate() == this) {
            if (canConstantState()) {
                this.zans.mutate();
                this.zant.mutate();
                this.zanq = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        this.zans.setBounds(rect);
        this.zant.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void setAlpha(int i2) {
        if (this.mAlpha == this.zano) {
            this.mAlpha = i2;
        }
        this.zano = i2;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zans.setColorFilter(colorFilter);
        this.zant.setColorFilter(colorFilter);
    }

    public final void startTransition(int i2) {
        this.mFrom = 0;
        this.zann = this.zano;
        this.mAlpha = 0;
        this.zanp = 250;
        this.zanl = 1;
        invalidateSelf();
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zacd() {
        return this.zant;
    }

    public zae(zah zah) {
        this.zanl = 0;
        this.zano = 255;
        this.mAlpha = 0;
        this.zand = true;
        this.zanr = new zah(zah);
    }
}
