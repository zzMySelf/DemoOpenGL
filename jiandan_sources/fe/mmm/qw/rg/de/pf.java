package fe.mmm.qw.rg.de;

import androidx.lifecycle.Observer;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivity;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivityFlavor;

/* compiled from: lambda */
public final /* synthetic */ class pf implements Observer {
    public final /* synthetic */ TextRecognitionResultActivity qw;

    public /* synthetic */ pf(TextRecognitionResultActivity textRecognitionResultActivity) {
        this.qw = textRecognitionResultActivity;
    }

    public final void onChanged(Object obj) {
        TextRecognitionResultActivityFlavor.uk(this.qw, (Boolean) obj);
    }
}
