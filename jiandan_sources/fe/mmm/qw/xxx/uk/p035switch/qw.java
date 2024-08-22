package fe.mmm.qw.xxx.uk.p035switch;

import android.view.View;
import com.tera.scan.main.importfile.adapter.ImportDocListAdapter;
import kotlin.jvm.functions.Function1;

/* renamed from: fe.mmm.qw.xxx.uk.switch.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function1 f8670ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8671th;

    public /* synthetic */ qw(Function1 function1, int i2) {
        this.f8670ad = function1;
        this.f8671th = i2;
    }

    public final void onClick(View view) {
        ImportDocListAdapter.ImportFileViewHolder.qw(this.f8670ad, this.f8671th, view);
    }
}
