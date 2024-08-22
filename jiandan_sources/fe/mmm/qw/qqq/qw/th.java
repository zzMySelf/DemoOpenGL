package fe.mmm.qw.qqq.qw;

import android.view.View;
import com.tera.scan.pdfedit.adapter.PdfListMergeAdapter;
import fe.mmm.qw.qqq.rg.qw;
import kotlin.jvm.functions.Function2;

/* compiled from: lambda */
public final /* synthetic */ class th implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function2 f8217ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8218th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ qw f8219yj;

    public /* synthetic */ th(Function2 function2, int i2, qw qwVar) {
        this.f8217ad = function2;
        this.f8218th = i2;
        this.f8219yj = qwVar;
    }

    public final void onClick(View view) {
        PdfListMergeAdapter.PdfItemViewHolder.qw(this.f8217ad, this.f8218th, this.f8219yj, view);
    }
}
