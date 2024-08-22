package com.baidu.searchbox.introduction;

import android.view.LayoutInflater;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

public class IntroductionPagerAdapter extends PagerAdapter {
    public static final int INTRO_PAGE_COUNT = 4;
    private ArrayList<View> mArray;
    private WorkspaceStateListener mListener;

    public IntroductionPagerAdapter(LayoutInflater inflator, WorkspaceStateListener listener) {
        init(inflator, listener);
    }

    private void init(LayoutInflater inflator, WorkspaceStateListener listener) {
        this.mListener = listener;
        this.mArray = new ArrayList<>();
    }

    public int getCount() {
        return 4;
    }

    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(this.mArray.get(arg1));
    }

    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(this.mArray.get(arg1));
        return this.mArray.get(arg1);
    }
}
