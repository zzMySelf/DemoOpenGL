package fe.mmm.qw.rg.de.nn;

import androidx.lifecycle.Observer;
import com.mars.kotlin.service.Result;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class de implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ List f8283ad;
    public final /* synthetic */ TextRecognitionActivity qw;

    public /* synthetic */ de(TextRecognitionActivity textRecognitionActivity, List list) {
        this.qw = textRecognitionActivity;
        this.f8283ad = list;
    }

    public final void onChanged(Object obj) {
        yj.fe(this.qw, this.f8283ad, (Result) obj);
    }
}
