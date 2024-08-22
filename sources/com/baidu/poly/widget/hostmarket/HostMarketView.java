package com.baidu.poly.widget.hostmarket;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.poly.R;
import com.baidu.poly.wallet.calculate.CalculatePriceCallBack;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.poly.widget.c;

/* compiled from: SearchBox */
public class HostMarketView extends FrameLayout implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f17519a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17520b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17521c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public SwitchButton f17522d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f17523e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17524f = false;

    /* compiled from: SearchBox */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.a(z);
        }
    }

    /* compiled from: SearchBox */
    public interface b {
        void a(CalculatePriceCallBack.Data data);

        void a(boolean z, c cVar, CalculatePriceCallBack calculatePriceCallBack);
    }

    public HostMarketView(Context context) {
        super(context);
        a();
    }

    public void setListener(b bVar) {
        this.f17523e = bVar;
    }

    private void b() {
        if (this.f17519a == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f17520b.setText(this.f17519a.b());
        this.f17521c.setText(this.f17519a.l());
        if (!TextUtils.isEmpty(this.f17519a.a())) {
            try {
                this.f17521c.setTextColor(Color.parseColor(this.f17519a.a()));
            } catch (Exception e2) {
            }
        }
        if (this.f17524f) {
            this.f17522d.setVisibility(4);
            return;
        }
        this.f17522d.setVisibility(0);
        if (this.f17519a.h() == 1) {
            this.f17522d.setChecked(true);
        } else {
            this.f17522d.setChecked(false);
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.hostmarket_item, this, true);
        this.f17520b = (TextView) findViewById(R.id.title);
        this.f17521c = (TextView) findViewById(R.id.subtitle);
        SwitchButton switchButton = (SwitchButton) findViewById(R.id.switch_button);
        this.f17522d = switchButton;
        switchButton.setOnCheckedChangeListener(new a());
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f17523e != null) {
            this.f17519a.a(this.f17522d.isChecked() ? 1 : 0);
            this.f17523e.a(z, this.f17519a, new CalculatePriceCallBack() {
                public void onResult(CalculatePriceCallBack.Data data) {
                    HostMarketView.this.f17523e.a(data);
                    if (data != null) {
                        if (data.statusCode != 0) {
                            HostMarketView.this.f17522d.c();
                            Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(R.string.host_market_calculate_error), 0).show();
                        }
                        HostMarketView.this.f17519a.a(HostMarketView.this.f17522d.isChecked() ? 1 : 0);
                    }
                }
            });
        }
    }

    public void a(c cVar) {
        this.f17519a = cVar;
        if (cVar != null) {
            boolean z = true;
            if (cVar.h() != 1) {
                z = false;
            }
            this.f17524f = z;
        }
        b();
    }
}
