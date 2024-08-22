package fe.mmm.qw.f.de.de.fe.rg;

import android.view.View;
import com.tera.scan.ui.view.widget.viewpager.tab.UIFixedTabLayout;

/* compiled from: lambda */
public final /* synthetic */ class de implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ UIFixedTabLayout f7788ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f7789th;

    public /* synthetic */ de(UIFixedTabLayout uIFixedTabLayout, int i2) {
        this.f7788ad = uIFixedTabLayout;
        this.f7789th = i2;
    }

    public final void onClick(View view) {
        UIFixedTabLayout.m928addTab$lambda3(this.f7788ad, this.f7789th, view);
    }
}
