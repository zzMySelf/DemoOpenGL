package com.baidu.poly.widget.hostmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.poly.R;
import com.baidu.poly.widget.c;
import com.baidu.poly.widget.hostmarket.HostMarketView;

/* compiled from: SearchBox */
public class b extends FrameLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f17529a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17530b;

    public b(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.poly_view_random_marekt, this, true);
        this.f17530b = (TextView) findViewById(R.id.poly_random_market_title);
        this.f17529a = (TextView) findViewById(R.id.poly_random_market_subtitle);
    }

    public void setListener(HostMarketView.b bVar) {
    }

    public void a(c cVar) {
        if (cVar != null) {
            String b2 = cVar.b();
            String l = cVar.l();
            TextView textView = this.f17530b;
            if (textView != null) {
                textView.setText(b2);
            }
            TextView textView2 = this.f17529a;
            if (textView2 != null) {
                textView2.setText(l);
            }
        }
    }
}
