package com.baidu.wallet.personal.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> extends BaseAdapter {
    public List<T> a = new ArrayList();
    public boolean b;
    public LayoutInflater c;
    public C0172a d;

    /* renamed from: com.baidu.wallet.personal.a.a$a  reason: collision with other inner class name */
    public interface C0172a {
        void a(boolean z);
    }

    public interface b<T> {
        void a(int i2, T t);

        void a(View view);

        void a(boolean z);

        void b(boolean z);

        void c(boolean z);
    }

    public a(Context context) {
        this.c = LayoutInflater.from(context);
    }

    private View a(ViewGroup viewGroup, int i2) {
        View inflate = this.b ? this.c.inflate(a(i2), viewGroup, false) : this.c.inflate(a(i2), (ViewGroup) null);
        inflate.setTag(a(i2, inflate));
        if (inflate != null) {
            a(inflate, i2);
        }
        return inflate;
    }

    public abstract int a(int i2);

    public abstract b<T> a(int i2, View view);

    public synchronized List<T> a() {
        return this.a;
    }

    public void a(View view, int i2) {
    }

    public synchronized void a(T t) {
        if (this.a != null) {
            this.a.add(t);
        }
    }

    public synchronized void b() {
        if (this.a != null) {
            this.a.clear();
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        List<T> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getItem(int i2) {
        List<T> list = this.a;
        if (list != null && i2 < list.size() && i2 >= 0) {
            return this.a.get(i2);
        }
        return null;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View a2 = a(viewGroup, i2);
        Object tag = a2.getTag();
        if (tag != null && (tag instanceof b)) {
            ((b) tag).a(i2, getItem(i2));
        }
        return a2;
    }

    public void notifyDataSetChanged() {
        C0172a aVar;
        boolean z;
        super.notifyDataSetChanged();
        if (this.d != null) {
            if (this.a.size() == 0) {
                aVar = this.d;
                z = true;
            } else if (this.a.size() > 0) {
                aVar = this.d;
                z = false;
            } else {
                return;
            }
            aVar.a(z);
        }
    }
}
