package com.baidu.wallet.base.widget.clickListener;

import android.view.View;

public abstract class ReDouAndNetErrClickListener implements View.OnClickListener {
    public abstract void doClick(View view);

    public void onClick(final View view) {
        new ReDoubleOnClickListener() {
            public void doClick(View view) {
                new ReNetErrorClickListener() {
                    public void doClick(View view) {
                        ReDouAndNetErrClickListener.this.doClick(view);
                    }
                }.onClick(view);
            }
        }.onClick(view);
    }
}
