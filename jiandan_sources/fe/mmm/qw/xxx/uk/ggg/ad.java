package fe.mmm.qw.xxx.uk.ggg;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f8660ad;
    public final /* synthetic */ ImportDocFileViewModel qw;

    public /* synthetic */ ad(ImportDocFileViewModel importDocFileViewModel, MediatorLiveData mediatorLiveData) {
        this.qw = importDocFileViewModel;
        this.f8660ad = mediatorLiveData;
    }

    public final void onChanged(Object obj) {
        ImportDocFileViewModel.fe(this.qw, this.f8660ad, (List) obj);
    }
}
