package fe.mmm.qw.n.fe;

import android.view.View;
import com.tera.scan.widget.selecttext.SelectTextPopAdapter;

/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ SelectTextPopAdapter f8079ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8080th;

    public /* synthetic */ qw(SelectTextPopAdapter selectTextPopAdapter, int i2) {
        this.f8079ad = selectTextPopAdapter;
        this.f8080th = i2;
    }

    public final void onClick(View view) {
        SelectTextPopAdapter.ad(this.f8079ad, this.f8080th, view);
    }
}
