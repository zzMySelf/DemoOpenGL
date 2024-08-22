package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class DiscolorScrollView extends ScrollView {
    public a a;

    public interface a {
        void onScrollChanged(DiscolorScrollView discolorScrollView, int i2, int i3, int i4, int i5);
    }

    public DiscolorScrollView(Context context) {
        super(context);
    }

    public DiscolorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.a;
        if (aVar != null) {
            aVar.onScrollChanged(this, i2, i3, i4, i5);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.a = aVar;
    }
}
