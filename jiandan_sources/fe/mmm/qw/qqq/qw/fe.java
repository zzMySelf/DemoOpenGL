package fe.mmm.qw.qqq.qw;

import android.view.View;
import com.tera.scan.pdfedit.adapter.PdfMergeAddAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: lambda */
public final /* synthetic */ class fe implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function1 f8211ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8212th;

    public /* synthetic */ fe(Function1 function1, int i2) {
        this.f8211ad = function1;
        this.f8212th = i2;
    }

    public final void onClick(View view) {
        PdfMergeAddAdapter.ImportFileViewHolder.qw(this.f8211ad, this.f8212th, view);
    }
}
