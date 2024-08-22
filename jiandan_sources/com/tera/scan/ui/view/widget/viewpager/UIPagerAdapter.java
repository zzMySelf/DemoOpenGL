package com.tera.scan.ui.view.widget.viewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class UIPagerAdapter<T> extends PagerAdapter {

    /* renamed from: ad  reason: collision with root package name */
    public List<UIPagerAdapter<T>.defpackage.qw> f7389ad = new ArrayList();

    /* renamed from: de  reason: collision with root package name */
    public boolean f7390de;
    public UIWrapPagerAdapter mWrapAdapter;
    public List<T> qw;

    public class qw {

        /* renamed from: ad  reason: collision with root package name */
        public View f7391ad;

        /* renamed from: de  reason: collision with root package name */
        public int f7392de;
        public T qw;

        public qw(UIPagerAdapter uIPagerAdapter, T t, View view, int i2) {
            this.qw = t;
            this.f7391ad = view;
            this.f7392de = i2;
        }
    }

    public UIPagerAdapter(@NonNull List<T> list) {
        this.qw = list;
    }

    public abstract void bindItemView(@NonNull View view, T t, int i2, boolean z);

    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        fe.mmm.qw.f.ad.de.qw qwVar = fe.mmm.qw.f.ad.de.qw.qw;
        qwVar.qw("UIPagerAdapter", "destroyItem() called with: position = [" + i2 + "]");
        qw qwVar2 = (qw) obj;
        viewGroup.removeView(qwVar2.f7391ad);
        this.f7389ad.remove(qwVar2);
    }

    public int getCount() {
        return this.qw.size();
    }

    public int getItemPosition(@NonNull Object obj) {
        qw qwVar = (qw) obj;
        Object ad2 = qwVar.qw;
        int indexOf = this.qw.indexOf(ad2);
        int i2 = indexOf == -1 ? -2 : indexOf;
        int de2 = qwVar.f7392de;
        fe.mmm.qw.f.ad.de.qw qwVar2 = fe.mmm.qw.f.ad.de.qw.qw;
        qwVar2.qw("UIPagerAdapter", "getItemPosition: oldPos=" + de2 + ",newPos=" + indexOf);
        if (i2 >= 0) {
            if (de2 != i2) {
                int unused = qwVar.f7392de = i2;
            }
            bindItemView(qwVar.f7391ad, ad2, i2, false);
        }
        return i2;
    }

    public List<T> getItems() {
        return this.qw;
    }

    public int getPageViewPosition(View view) {
        for (qw next : this.f7389ad) {
            if (next.f7391ad == view) {
                return next.f7392de;
            }
        }
        return -1;
    }

    public View getViewByPosition(int i2) {
        int i3 = 0;
        while (i3 < this.f7389ad.size()) {
            try {
                qw qwVar = this.f7389ad.get(i3);
                if (qwVar.f7392de == i2) {
                    return qwVar.f7391ad;
                }
                i3++;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public UIWrapPagerAdapter getWrapAdapter() {
        return this.mWrapAdapter;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        fe.mmm.qw.f.ad.de.qw qwVar = fe.mmm.qw.f.ad.de.qw.qw;
        qwVar.qw("UIPagerAdapter", "instantiateItem() called with: position = [" + i2 + "]");
        T t = this.qw.get(i2);
        View instantiateItemView = instantiateItemView(viewGroup, t, i2);
        bindItemView(instantiateItemView, t, i2, true);
        viewGroup.addView(instantiateItemView);
        qw qwVar2 = new qw(this, t, instantiateItemView, i2);
        this.f7389ad.add(qwVar2);
        return qwVar2;
    }

    @NonNull
    public abstract View instantiateItemView(@NonNull ViewGroup viewGroup, T t, int i2);

    public boolean isDataSetChanging() {
        return this.f7390de;
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((qw) obj).f7391ad == view;
    }

    @CallSuper
    public void notifyDataSetChanged() {
        this.f7390de = true;
        super.notifyDataSetChanged();
        UIWrapPagerAdapter uIWrapPagerAdapter = this.mWrapAdapter;
        if (uIWrapPagerAdapter != null) {
            uIWrapPagerAdapter.notifyDataSetChanged();
        }
        this.f7390de = false;
    }

    public void setItems(List<T> list) {
        this.qw = list;
        notifyDataSetChanged();
    }

    public void setWrapAdapter(UIWrapPagerAdapter uIWrapPagerAdapter) {
        this.mWrapAdapter = uIWrapPagerAdapter;
    }
}
