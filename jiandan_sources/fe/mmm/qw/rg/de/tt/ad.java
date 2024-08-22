package fe.mmm.qw.rg.de.tt;

import androidx.lifecycle.Observer;
import com.tera.scan.business.textrecognition.viewmodel.TextRecognitionResultViewModel;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ TextRecognitionResultViewModel qw;

    public /* synthetic */ ad(TextRecognitionResultViewModel textRecognitionResultViewModel) {
        this.qw = textRecognitionResultViewModel;
    }

    public final void onChanged(Object obj) {
        TextRecognitionResultViewModel.ad(this.qw, (Boolean) obj);
    }
}
