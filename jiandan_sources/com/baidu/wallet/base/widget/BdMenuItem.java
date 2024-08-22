package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class BdMenuItem {
    public static final int a = 0;
    public final int b;
    public boolean c = true;
    public boolean d = false;
    public boolean e = false;
    public CharSequence f;
    public Drawable g;
    public int h = 0;

    /* renamed from: i  reason: collision with root package name */
    public String f1140i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        this.k = context;
        this.b = i2;
        this.f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable;
        }
        if (this.h == 0) {
            return null;
        }
        Drawable drawable2 = this.k.getResources().getDrawable(this.h);
        this.h = 0;
        this.g = drawable2;
        return drawable2;
    }

    public String getIconUrl() {
        return this.f1140i;
    }

    public int getItemId() {
        return this.b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f;
    }

    public boolean isChecked() {
        return this.d;
    }

    public boolean isEnabled() {
        return this.c;
    }

    public void setChecked(boolean z) {
        this.d = z;
    }

    public void setEnabled(boolean z) {
        this.c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.h = 0;
        this.g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.h = 0;
        this.f1140i = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.l = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.e;
    }

    public BdMenuItem setTitle(int i2) {
        this.f = this.k.getResources().getText(i2, this.f);
        return this;
    }

    public BdMenuItem setIcon(int i2) {
        this.g = null;
        this.h = i2;
        return this;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        this.k = context;
        this.b = i2;
        this.f = charSequence;
        this.h = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.k = context;
        this.b = i2;
        this.f = charSequence;
        this.g = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        this.k = context;
        this.b = i2;
        this.f = charSequence;
        this.f1140i = str;
    }
}
