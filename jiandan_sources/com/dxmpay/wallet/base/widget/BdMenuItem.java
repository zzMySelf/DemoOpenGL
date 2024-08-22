package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class BdMenuItem {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f4147ad = true;

    /* renamed from: de  reason: collision with root package name */
    public boolean f4148de = false;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4149fe = false;

    /* renamed from: i  reason: collision with root package name */
    public OnItemClickListener f4150i;

    /* renamed from: o  reason: collision with root package name */
    public Context f4151o;

    /* renamed from: pf  reason: collision with root package name */
    public BdMenu f4152pf;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public CharSequence f4153rg;

    /* renamed from: th  reason: collision with root package name */
    public Drawable f4154th;

    /* renamed from: uk  reason: collision with root package name */
    public String f4155uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f4156yj = 0;

    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        this.f4151o = context;
        this.qw = i2;
        this.f4153rg = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f4154th;
        if (drawable != null) {
            return drawable;
        }
        if (this.f4156yj == 0) {
            return null;
        }
        Drawable drawable2 = this.f4151o.getResources().getDrawable(this.f4156yj);
        this.f4156yj = 0;
        this.f4154th = drawable2;
        return drawable2;
    }

    public String getIconUrl() {
        return this.f4155uk;
    }

    public int getItemId() {
        return this.qw;
    }

    public BdMenu getMenu() {
        return this.f4152pf;
    }

    public OnItemClickListener getOnClickListener() {
        return this.f4150i;
    }

    public CharSequence getTitle() {
        return this.f4153rg;
    }

    public boolean isChecked() {
        return this.f4148de;
    }

    public boolean isEnabled() {
        return this.f4147ad;
    }

    public void setChecked(boolean z) {
        this.f4148de = z;
    }

    public void setEnabled(boolean z) {
        this.f4147ad = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f4156yj = 0;
        this.f4154th = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f4156yj = 0;
        this.f4155uk = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.f4152pf = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.f4150i = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.f4149fe = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f4153rg = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f4149fe;
    }

    public BdMenuItem setTitle(int i2) {
        this.f4153rg = this.f4151o.getResources().getText(i2, this.f4153rg);
        return this;
    }

    public BdMenuItem setIcon(int i2) {
        this.f4154th = null;
        this.f4156yj = i2;
        return this;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        this.f4151o = context;
        this.qw = i2;
        this.f4153rg = charSequence;
        this.f4156yj = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f4151o = context;
        this.qw = i2;
        this.f4153rg = charSequence;
        this.f4154th = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        this.f4151o = context;
        this.qw = i2;
        this.f4153rg = charSequence;
        this.f4155uk = str;
    }
}
