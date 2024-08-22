package com.baidu.pass.ecommerce.common.adapter;

import android.view.View;

public class ViewHolder<D> {
    private View convertView;

    public ViewHolder(View view2) {
        this.convertView = view2;
    }

    public void bindView(D d2) {
    }

    public <T extends View> T findViewById(int i2) {
        return this.convertView.findViewById(i2);
    }
}
