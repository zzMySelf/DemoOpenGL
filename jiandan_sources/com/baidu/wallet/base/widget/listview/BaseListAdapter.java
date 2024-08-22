package com.baidu.wallet.base.widget.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.wallet.base.widget.listview.internal.InnerAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseListAdapter<T> extends BaseAdapter {
    public Context a;
    public List<T> b = new ArrayList();
    public InnerAdapter<T> c;
    public ViewGroup mParent;

    public static abstract class BaseViewHolder<T> {
        public View createView(Context context) {
            return null;
        }

        public abstract void setView(T t, int i2, Context context, BaseListAdapter<T> baseListAdapter);
    }

    public BaseListAdapter(Context context) {
        this.a = context;
        this.c = new InnerAdapter<>(context, this);
    }

    public void addList(List<T> list) {
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public void clearList() {
        this.b.clear();
        notifyDataSetChanged();
    }

    public Context getContext() {
        return this.a;
    }

    public int getCount() {
        return this.b.size();
    }

    public T getItem(int i2) {
        return this.b.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getItemTrueType(int i2) {
        return 0;
    }

    public int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    public List<T> getList() {
        return this.b;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        this.mParent = viewGroup;
        return this.c.getView(i2, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.c.getViewBundles().size();
    }

    public void initList(List<T> list) {
        if (this.b.size() > 0) {
            this.b.clear();
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public abstract void onBindViewHolder(List<Class<?>> list);

    public boolean useItemTrueType() {
        return false;
    }
}
