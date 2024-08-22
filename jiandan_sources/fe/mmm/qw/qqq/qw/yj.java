package fe.mmm.qw.qqq.qw;

import android.view.View;
import com.tera.scan.pdfedit.adapter.PdfWatermarkSelectAdapter;
import com.tera.scan.pdfedit.data.AddPdfItemData;
import kotlin.jvm.functions.Function1;

/* compiled from: lambda */
public final /* synthetic */ class yj implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function1 f8220ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ AddPdfItemData f8221th;

    public /* synthetic */ yj(Function1 function1, AddPdfItemData addPdfItemData) {
        this.f8220ad = function1;
        this.f8221th = addPdfItemData;
    }

    public final void onClick(View view) {
        PdfWatermarkSelectAdapter.ImportFileViewHolder.qw(this.f8220ad, this.f8221th, view);
    }
}
