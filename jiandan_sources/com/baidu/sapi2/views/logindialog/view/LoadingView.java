package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;

public class LoadingView extends LinearLayout {
    public Context a;
    public TextView b;

    public LoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void b() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_loadingview, this);
        this.b = (TextView) findViewById(R.id.sapi_tv_loading_tip);
        setOrientation(1);
        setBackgroundColor(-1);
        setGravity(1);
    }

    public void a() {
        setBackgroundColor(Color.parseColor("#222222"));
        this.b.setTextColor(Color.parseColor("#80FFFFFF"));
    }

    public LoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        b();
    }
}
