package com.baidu.searchbox.follow.followaddrlist.template;

import android.view.View;
import android.view.ViewGroup;

public interface ITemplate<T> {

    public interface OnChildListener {
        void followFailed(int i2);

        void followSuccess(boolean z);

        void onFooterClick(View view2);
    }

    void bindView(T t);

    View createView(ViewGroup viewGroup);

    void setOnChildClickListener(OnChildListener onChildListener);
}
