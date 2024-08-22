package com.baidu.wallet.personal.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.apollon.NoProguard;
import java.util.ArrayList;
import java.util.List;

public class BCouponPagerAdapter extends PagerAdapter implements NoProguard {
    public Context a;
    public List<View> b = new ArrayList();
    public int c = 0;

    public BCouponPagerAdapter(Context context, List<View> list) {
        this.a = context;
        this.b = list;
    }

    public void destroyItem(View view, int i2, Object obj) {
        List<View> list = this.b;
        View view2 = list.get(i2 % list.size());
        if (view2.getParent() == null) {
            ((ViewPager) view).removeView(view2);
        }
    }

    public int getCount() {
        return this.b.size();
    }

    public int getItemPosition(Object obj) {
        int i2 = this.c;
        if (i2 <= 0) {
            return super.getItemPosition(obj);
        }
        this.c = i2 - 1;
        return -2;
    }

    public Object instantiateItem(View view, int i2) {
        List<View> list = this.b;
        View view2 = list.get(i2 % list.size());
        ViewParent parent = view2.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(view2);
        }
        ((ViewPager) view).addView(view2);
        return view2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void notifyDataSetChanged() {
        this.c = getCount();
        super.notifyDataSetChanged();
    }
}
