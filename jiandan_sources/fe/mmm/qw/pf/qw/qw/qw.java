package fe.mmm.qw.pf.qw.qw;

import android.view.View;
import com.tera.scan.file.selector.adpter.LocalImageSelectAdapter;

/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnLongClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ LocalImageSelectAdapter f8194ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8195th;

    public /* synthetic */ qw(LocalImageSelectAdapter localImageSelectAdapter, int i2) {
        this.f8194ad = localImageSelectAdapter;
        this.f8195th = i2;
    }

    public final boolean onLongClick(View view) {
        return LocalImageSelectAdapter.m753bindView$lambda1(this.f8194ad, this.f8195th, view);
    }
}
