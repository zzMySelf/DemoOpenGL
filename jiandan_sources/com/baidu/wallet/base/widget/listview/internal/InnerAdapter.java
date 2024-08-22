package com.baidu.wallet.base.widget.listview.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.ViewMappingUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class InnerAdapter<T> extends BaseAdapter {
    public List<Class<?>> a = new ArrayList();
    public Context b;
    public BaseListAdapter<T> c;

    public InnerAdapter(Context context, BaseListAdapter<T> baseListAdapter) {
        this.b = context;
        this.c = baseListAdapter;
    }

    private void a(int i2, T t, BaseListAdapter.BaseViewHolder baseViewHolder, BaseListAdapter<T> baseListAdapter) {
        baseViewHolder.setView(t, i2, this.b, baseListAdapter);
    }

    public int getBindItemViewResId(int i2) {
        if (BindLayoutMapping.getLayoutId(getViewBundles().get(this.c.useItemTrueType() ? this.c.getItemTrueType(i2) : this.c.getItemViewType(i2))).equals("NOT_USE_XML")) {
            return -1;
        }
        return ResUtils.layout(this.b, BindLayoutMapping.getLayoutId(getViewBundles().get(this.c.useItemTrueType() ? this.c.getItemTrueType(i2) : this.c.getItemViewType(i2))));
    }

    public int getCount() {
        return 0;
    }

    public T getItem(int i2) {
        return null;
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        BaseListAdapter.BaseViewHolder baseViewHolder;
        if (view == null) {
            BaseListAdapter.BaseViewHolder onCreateViewHolder = onCreateViewHolder(i2, getViewBundles());
            baseViewHolder = onCreateViewHolder;
            view = a(i2, onCreateViewHolder);
        } else {
            baseViewHolder = (BaseListAdapter.BaseViewHolder) view.getTag();
        }
        if (view == null || view.getTag() == null) {
            throw new NullPointerException(" creatview fails");
        }
        a(i2, this.c.getItem(i2), baseViewHolder, this.c);
        return view;
    }

    public List<Class<?>> getViewBundles() {
        return a(this.a);
    }

    public int getViewTypeCount() {
        return 0;
    }

    public void handleViewHolder(BaseListAdapter.BaseViewHolder baseViewHolder, T... tArr) {
    }

    public BaseListAdapter.BaseViewHolder onCreateViewHolder(int i2, List<Class<?>> list) {
        return (BaseListAdapter.BaseViewHolder) a(list.get(this.c.useItemTrueType() ? this.c.getItemTrueType(i2) : this.c.getItemViewType(i2)));
    }

    private View a(int i2, BaseListAdapter.BaseViewHolder baseViewHolder) {
        View view;
        if (getBindItemViewResId(i2) == -1) {
            view = baseViewHolder.createView(this.b);
        } else {
            view = View.inflate(this.b, getBindItemViewResId(i2), (ViewGroup) null);
            ViewMappingUtil.mapView(baseViewHolder, view);
        }
        handleViewHolder(baseViewHolder, new Object[0]);
        view.setTag(baseViewHolder);
        return view;
    }

    public static <T> T a(Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Class<?>> a(List<Class<?>> list) {
        if (list.size() <= 0) {
            this.c.onBindViewHolder(list);
        }
        return list;
    }
}
