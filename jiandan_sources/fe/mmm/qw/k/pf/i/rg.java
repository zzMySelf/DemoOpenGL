package fe.mmm.qw.k.pf.i;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import com.tera.scan.vip.ui.view.VipScrollViewPage;

/* compiled from: lambda */
public final /* synthetic */ class rg implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ TextView f7994ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ TextView f7995de;

    /* renamed from: fe  reason: collision with root package name */
    public final /* synthetic */ View f7996fe;
    public final /* synthetic */ View qw;

    /* renamed from: rg  reason: collision with root package name */
    public final /* synthetic */ VipScrollViewPage f7997rg;

    public /* synthetic */ rg(View view, TextView textView, TextView textView2, View view2, VipScrollViewPage vipScrollViewPage) {
        this.qw = view;
        this.f7994ad = textView;
        this.f7995de = textView2;
        this.f7996fe = view2;
        this.f7997rg = vipScrollViewPage;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        VipScrollViewPage.m950onItemSelectChange$lambda14(this.qw, this.f7994ad, this.f7995de, this.f7996fe, this.f7997rg, valueAnimator);
    }
}
