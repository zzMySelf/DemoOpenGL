package fe.mmm.qw.rg.de.nn;

import androidx.lifecycle.Observer;
import com.mars.kotlin.service.Result;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ TextRecognitionActivity f8284ad;
    public final /* synthetic */ List qw;

    public /* synthetic */ qw(List list, TextRecognitionActivity textRecognitionActivity) {
        this.qw = list;
        this.f8284ad = textRecognitionActivity;
    }

    public final void onChanged(Object obj) {
        th.fe(this.qw, this.f8284ad, (Result) obj);
    }
}
