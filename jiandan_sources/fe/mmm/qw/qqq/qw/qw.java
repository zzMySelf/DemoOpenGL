package fe.mmm.qw.qqq.qw;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.tera.scan.pdfedit.adapter.PdfListMergeAdapter;

/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnTouchListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ItemTouchHelper f8213ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ PdfListMergeAdapter.PdfItemViewHolder f8214th;

    public /* synthetic */ qw(ItemTouchHelper itemTouchHelper, PdfListMergeAdapter.PdfItemViewHolder pdfItemViewHolder) {
        this.f8213ad = itemTouchHelper;
        this.f8214th = pdfItemViewHolder;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return PdfListMergeAdapter.PdfItemViewHolder.ad(this.f8213ad, this.f8214th, view, motionEvent);
    }
}
