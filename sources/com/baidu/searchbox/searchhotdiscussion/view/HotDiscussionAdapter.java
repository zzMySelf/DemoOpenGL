package com.baidu.searchbox.searchhotdiscussion.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ui.viewpager.PagerAdapterImpl;
import java.util.List;

public class HotDiscussionAdapter extends PagerAdapterImpl {
    private List<View> mListViews;

    public HotDiscussionAdapter(List<View> listViews) {
        this.mListViews = listViews;
    }

    /* access modifiers changed from: protected */
    public View onInstantiateItem(ViewGroup viewGroup, int i2) {
        View view2 = this.mListViews.get(i2);
        view2.setTag(Integer.valueOf(i2));
        if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        return view2;
    }

    /* access modifiers changed from: protected */
    public void onConfigItem(View view2, int i2) {
    }

    public int getCount() {
        return this.mListViews.size();
    }
}
