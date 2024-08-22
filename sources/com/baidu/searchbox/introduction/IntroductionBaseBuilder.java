package com.baidu.searchbox.introduction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.introduction.statistic.IIntroductionGMVStatistic;
import java.util.ArrayList;

public abstract class IntroductionBaseBuilder {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected IIntroductionGMVStatistic mIntroductionGMVStatistic;
    protected ArrayList mParamsList;
    protected ViewGroup mRootView;

    /* access modifiers changed from: package-private */
    public abstract View buildView();

    public abstract void release();

    public boolean showable() {
        return true;
    }

    public boolean isSplashIntrocuction() {
        return false;
    }

    public <T extends IntroductionBaseBuilder> T setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public <T extends IntroductionBaseBuilder> T setLayoutInflater(LayoutInflater inflater) {
        this.mInflater = inflater;
        return this;
    }

    public <T extends IntroductionBaseBuilder> T setRootView(ViewGroup rootView) {
        this.mRootView = rootView;
        return this;
    }

    public <T extends IntroductionBaseBuilder> T setParamsList(ArrayList<Object> paramsList) {
        this.mParamsList = paramsList;
        return this;
    }
}
