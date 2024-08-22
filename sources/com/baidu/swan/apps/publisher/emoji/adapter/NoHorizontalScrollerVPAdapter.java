package com.baidu.swan.apps.publisher.emoji.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class NoHorizontalScrollerVPAdapter extends PagerAdapter {
    private List<View> mData;

    public NoHorizontalScrollerVPAdapter(List<View> data) {
        this.mData = data;
    }

    public int getCount() {
        return this.mData.size();
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        if ((object instanceof View) && container != null) {
            container.removeView((View) object);
        }
    }

    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(this.mData.get(position));
        return this.mData.get(position);
    }

    public boolean isViewFromObject(View view2, Object object) {
        return view2 == object;
    }
}
