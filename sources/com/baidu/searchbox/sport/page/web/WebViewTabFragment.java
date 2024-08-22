package com.baidu.searchbox.sport.page.web;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.ng.browser.init.BlinkInitHelper;
import com.baidu.searchbox.sport.model.TabInfo;
import com.baidu.searchbox.sport.page.base.BaseSportTabFragment;
import com.baidu.searchbox.sport.page.base.ITabComponent;
import com.baidu.searchbox.sport.widget.nestedscroll.NestedScrollWebView2;

public class WebViewTabFragment extends BaseSportTabFragment {
    private AbsSportWebComp webComp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabInfo tabInfo = getTabInfo();
        if (tabInfo != null && getContext() != null) {
            BlinkInitHelper.getInstance(getContext()).initBWebkit();
            SportWebComp sportWebComp = new SportWebComp(getToken(), new NestedScrollWebView2(getContext()), tabInfo);
            this.webComp = sportWebComp;
            sportWebComp.onCreate();
            if (savedInstanceState != null) {
                this.webComp.onRestoreInstanceState(savedInstanceState);
            }
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            absSportWebComp.onNightModeChange(isNightMode);
        }
    }

    public void onFontSizeChange(FontSizeInfo info) {
        super.onFontSizeChange(info);
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            absSportWebComp.onFontSizeChange(info);
        }
    }

    public ITabComponent getComponent() {
        return this.webComp;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            return absSportWebComp.getView();
        }
        return new View(getContext());
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null && outState != null) {
            absSportWebComp.onSaveInstanceState(outState);
        }
    }

    public void onStart() {
        super.onStart();
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            absSportWebComp.onStart();
        }
    }

    public void onResume() {
        super.onResume();
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            absSportWebComp.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            absSportWebComp.onPause();
        }
    }

    public void onStop() {
        super.onStop();
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            absSportWebComp.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AbsSportWebComp absSportWebComp = this.webComp;
        if (absSportWebComp != null) {
            absSportWebComp.onDestroy();
        }
    }
}
