package fe.mmm.qw.f.de.de.de;

import android.view.View;
import com.tera.scan.ui.view.widget.tooltip.UITooltip;
import com.tera.scan.ui.view.widget.tooltip.UITooltip$show$1;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ UITooltip f7775ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ View f7776th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ boolean f7777uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ UITooltip.Gravity f7778yj;

    public /* synthetic */ qw(UITooltip uITooltip, View view, UITooltip.Gravity gravity, boolean z) {
        this.f7775ad = uITooltip;
        this.f7776th = view;
        this.f7778yj = gravity;
        this.f7777uk = z;
    }

    public final void run() {
        UITooltip$show$1.m926invoke$lambda0(this.f7775ad, this.f7776th, this.f7778yj, this.f7777uk);
    }
}
