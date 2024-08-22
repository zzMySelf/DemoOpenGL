package fe.mmm.qw.k.pf.i;

import android.view.View;
import com.tera.scan.vip.ui.view.PrivilegeBannerView;
import kotlin.jvm.functions.Function0;

/* compiled from: lambda */
public final /* synthetic */ class fe implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function0 f7989ad;

    public /* synthetic */ fe(Function0 function0) {
        this.f7989ad = function0;
    }

    public final void onClick(View view) {
        PrivilegeBannerView.m946setOnCloseListener$lambda2(this.f7989ad, view);
    }
}
