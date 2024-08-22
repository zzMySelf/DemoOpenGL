package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;

public class MaxListView extends ListView {
    public int a;
    public Context b;

    public MaxListView(Context context) {
        super(context);
        this.b = context;
        a();
    }

    private void a() {
        this.a = DisplayUtils.dip2px(this.b, 400.0f);
    }

    public int getListViewHeight() {
        return this.a;
    }

    public void onMeasure(int i2, int i3) {
        int i4 = this.a;
        if (i4 > -1) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public void setListViewHeight(int i2) {
        this.a = i2;
    }

    public MaxListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = context;
        a();
    }

    public MaxListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        a();
    }
}
