package fe.mmm.qw.pf.qw.qw;

import android.view.View;
import com.tera.scan.file.selector.adpter.LocalImageSelectAdapter;

/* compiled from: lambda */
public final /* synthetic */ class de implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ LocalImageSelectAdapter f8191ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ View f8192th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ int f8193yj;

    public /* synthetic */ de(LocalImageSelectAdapter localImageSelectAdapter, View view, int i2) {
        this.f8191ad = localImageSelectAdapter;
        this.f8192th = view;
        this.f8193yj = i2;
    }

    public final void onClick(View view) {
        LocalImageSelectAdapter.m752bindView$lambda0(this.f8191ad, this.f8192th, this.f8193yj, view);
    }
}
