package com.baidu.wallet.base.widget.clickListener;

import android.view.View;

public abstract class ReDoubleOnClickListener implements View.OnClickListener {
    public static boolean a = true;
    public static final Runnable b = new Runnable() {
        public void run() {
            boolean unused = ReDoubleOnClickListener.a = true;
        }
    };

    public abstract void doClick(View view);

    public final void onClick(View view) {
        if (a) {
            a = false;
            view.post(b);
            doClick(view);
        }
    }
}
