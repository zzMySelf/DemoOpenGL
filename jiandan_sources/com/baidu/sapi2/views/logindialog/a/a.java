package com.baidu.sapi2.views.logindialog.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class a extends PagerAdapter {
    public List<View> a;

    public a(List<View> list) {
        this.a = list;
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView(this.a.get(i2));
    }

    public int getCount() {
        return this.a.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        viewGroup.addView(this.a.get(i2));
        return this.a.get(i2);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
