package com.baidu.wallet.personal.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    public int a;
    public int b;
    public Bitmap c;
    public Resources d;
    public ArrayList<Integer> e = new ArrayList<>();
    public ArrayList<Integer> f = new ArrayList<>();

    public a(Resources resources, Bitmap bitmap) {
        this.a = bitmap.getWidth();
        this.b = bitmap.getHeight();
        this.c = bitmap;
        this.d = resources;
    }

    public a a(int i2) {
        int i3 = (this.b - i2) / 2;
        this.f.add(Integer.valueOf(i3));
        this.f.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public a a(int i2, int i3) {
        this.e.add(Integer.valueOf(i2));
        this.e.add(Integer.valueOf(i2 + i3));
        return this;
    }

    public byte[] a() {
        if (this.e.size() == 0) {
            this.e.add(0);
            this.e.add(Integer.valueOf(this.a));
        }
        if (this.f.size() == 0) {
            this.f.add(0);
            this.f.add(Integer.valueOf(this.b));
        }
        ByteBuffer order = ByteBuffer.allocate((this.e.size() + 8 + this.f.size() + 9) * 4).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) this.e.size());
        order.put((byte) this.f.size());
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        Iterator<Integer> it = this.e.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Iterator<Integer> it2 = this.f.iterator();
        while (it2.hasNext()) {
            order.putInt(it2.next().intValue());
        }
        for (int i2 = 0; i2 < 9; i2++) {
            order.putInt(1);
        }
        return order.array();
    }

    public NinePatch b() {
        byte[] a2 = a();
        if (this.c != null) {
            return new NinePatch(this.c, a2, (String) null);
        }
        return null;
    }

    public a b(int i2, int i3) {
        this.f.add(Integer.valueOf(i2));
        this.f.add(Integer.valueOf(i2 + i3));
        return this;
    }

    public NinePatchDrawable c() {
        NinePatch b2 = b();
        if (b2 != null) {
            return new NinePatchDrawable(this.d, b2);
        }
        return null;
    }
}
