package fe.mmm.qw.qqq.o;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel;
import kotlin.Pair;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PdfSplitViewModel f8205ad;
    public final /* synthetic */ MediatorLiveData qw;

    public /* synthetic */ ad(MediatorLiveData mediatorLiveData, PdfSplitViewModel pdfSplitViewModel) {
        this.qw = mediatorLiveData;
        this.f8205ad = pdfSplitViewModel;
    }

    public final void onChanged(Object obj) {
        PdfSplitViewModel.rg(this.qw, this.f8205ad, (Pair) obj);
    }
}
