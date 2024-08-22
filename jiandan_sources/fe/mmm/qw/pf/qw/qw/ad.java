package fe.mmm.qw.pf.qw.qw;

import android.view.View;
import com.tera.scan.file.selector.adpter.LocalImageSelectAdapter;

/* compiled from: lambda */
public final /* synthetic */ class ad implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ LocalImageSelectAdapter f8188ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ View f8189th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ int f8190yj;

    public /* synthetic */ ad(LocalImageSelectAdapter localImageSelectAdapter, View view, int i2) {
        this.f8188ad = localImageSelectAdapter;
        this.f8189th = view;
        this.f8190yj = i2;
    }

    public final void onClick(View view) {
        LocalImageSelectAdapter.m754bindView$lambda2(this.f8188ad, this.f8189th, this.f8190yj, view);
    }
}
