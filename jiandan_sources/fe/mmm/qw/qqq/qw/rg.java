package fe.mmm.qw.qqq.qw;

import android.view.View;
import com.tera.scan.pdfedit.adapter.PdfListSplitAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: lambda */
public final /* synthetic */ class rg implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function1 f8215ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8216th;

    public /* synthetic */ rg(Function1 function1, int i2) {
        this.f8215ad = function1;
        this.f8216th = i2;
    }

    public final void onClick(View view) {
        PdfListSplitAdapter.PdfItemViewHolder.qw(this.f8215ad, this.f8216th, view);
    }
}
