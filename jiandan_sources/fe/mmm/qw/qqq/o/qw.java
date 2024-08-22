package fe.mmm.qw.qqq.o;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel;
import kotlin.Pair;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PdfSplitViewModel f8207ad;
    public final /* synthetic */ MediatorLiveData qw;

    public /* synthetic */ qw(MediatorLiveData mediatorLiveData, PdfSplitViewModel pdfSplitViewModel) {
        this.qw = mediatorLiveData;
        this.f8207ad = pdfSplitViewModel;
    }

    public final void onChanged(Object obj) {
        PdfSplitViewModel.i(this.qw, this.f8207ad, (Pair) obj);
    }
}
