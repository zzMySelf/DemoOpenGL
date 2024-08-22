package com.baidu.android.pushservice.ach.e.l;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.android.pushservice.ach.e.d;
import com.baidu.protect.sdk.A596ff68b3f91aedb841288d3fe0592471b957756;

public abstract class a extends com.baidu.android.pushservice.ach.e.a {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f8070e;

    /* renamed from: f  reason: collision with root package name */
    public View f8071f;

    /* renamed from: com.baidu.android.pushservice.ach.e.l.a$a  reason: collision with other inner class name */
    public class C0118a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f8072a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f8073b;

        public C0118a(int i2, View view2) {
            this.f8072a = i2;
            this.f8073b = view2;
        }

        public void run() {
            A596ff68b3f91aedb841288d3fe0592471b957756.v(-16036, this, (Object[]) null);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view2) {
            A596ff68b3f91aedb841288d3fe0592471b957756.v(-16035, this, view2);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view2) {
            A596ff68b3f91aedb841288d3fe0592471b957756.v(-16062, this, view2);
        }
    }

    public static /* synthetic */ d a(a aVar) {
        return (d) A596ff68b3f91aedb841288d3fe0592471b957756.l(-16061, (Object) null, aVar);
    }

    public static /* synthetic */ d b(a aVar) {
        return (d) A596ff68b3f91aedb841288d3fe0592471b957756.l(-16064, (Object) null, aVar);
    }

    public static /* synthetic */ d c(a aVar) {
        return (d) A596ff68b3f91aedb841288d3fe0592471b957756.l(-16063, (Object) null, aVar);
    }

    public static /* synthetic */ d d(a aVar) {
        return (d) A596ff68b3f91aedb841288d3fe0592471b957756.l(-16058, (Object) null, aVar);
    }

    public void a(int i2) {
        A596ff68b3f91aedb841288d3fe0592471b957756.v(-16057, this, Integer.valueOf(i2));
    }

    public WindowManager.LayoutParams c() {
        return (WindowManager.LayoutParams) A596ff68b3f91aedb841288d3fe0592471b957756.l(-16060, this, (Object[]) null);
    }

    public void d() {
        A596ff68b3f91aedb841288d3fe0592471b957756.v(-16059, this, (Object[]) null);
    }
}
