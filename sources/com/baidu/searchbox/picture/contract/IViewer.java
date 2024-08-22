package com.baidu.searchbox.picture.contract;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

public interface IViewer {
    Activity getHostContext();

    ViewGroup getRootView();

    ViewPager getViewPager();
}
