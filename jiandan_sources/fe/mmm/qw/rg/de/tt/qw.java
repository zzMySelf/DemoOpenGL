package fe.mmm.qw.rg.de.tt;

import androidx.lifecycle.Observer;
import com.tera.scan.business.textrecognition.viewmodel.TextRecognitionResultViewModel;
import kotlin.jvm.internal.Ref;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ TextRecognitionResultViewModel f8293ad;
    public final /* synthetic */ Ref.IntRef qw;

    public /* synthetic */ qw(Ref.IntRef intRef, TextRecognitionResultViewModel textRecognitionResultViewModel) {
        this.qw = intRef;
        this.f8293ad = textRecognitionResultViewModel;
    }

    public final void onChanged(Object obj) {
        TextRecognitionResultViewModel.qw(this.qw, this.f8293ad, (Boolean) obj);
    }
}
