package fe.mmm.qw.k.pf.i;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import com.tera.scan.vip.ui.view.VipScrollViewPage;

/* compiled from: lambda */
public final /* synthetic */ class qw implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ View f7990ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ VipScrollViewPage f7991de;

    /* renamed from: fe  reason: collision with root package name */
    public final /* synthetic */ TextView f7992fe;
    public final /* synthetic */ View qw;

    /* renamed from: rg  reason: collision with root package name */
    public final /* synthetic */ TextView f7993rg;

    public /* synthetic */ qw(View view, View view2, VipScrollViewPage vipScrollViewPage, TextView textView, TextView textView2) {
        this.qw = view;
        this.f7990ad = view2;
        this.f7991de = vipScrollViewPage;
        this.f7992fe = textView;
        this.f7993rg = textView2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        VipScrollViewPage.m949onItemSelectChange$lambda10(this.qw, this.f7990ad, this.f7991de, this.f7992fe, this.f7993rg, valueAnimator);
    }
}
