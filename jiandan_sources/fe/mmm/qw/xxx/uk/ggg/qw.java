package fe.mmm.qw.xxx.uk.ggg;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ImportDocFileViewModel f8666ad;
    public final /* synthetic */ MediatorLiveData qw;

    public /* synthetic */ qw(MediatorLiveData mediatorLiveData, ImportDocFileViewModel importDocFileViewModel) {
        this.qw = mediatorLiveData;
        this.f8666ad = importDocFileViewModel;
    }

    public final void onChanged(Object obj) {
        ImportDocFileViewModel.rg(this.qw, this.f8666ad, (List) obj);
    }
}
